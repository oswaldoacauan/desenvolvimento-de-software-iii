import Ember from 'ember';

export default Ember.Route.extend({
  ajax: Ember.inject.service(),
  model() {
    return this.get('ajax').request('/solicitacao');
  },
  beforeModel() {
    return this.get('ajax').request('/tiposolicitacao').then(r => this.set('tipos', r));
  },
  setupController(controller, model) {
    this._super(controller, model);

    controller.set('tipos', this.get('tipos'));

    navigator.geolocation.getCurrentPosition((location) => {
      controller.set('latitude', location.coords.latitude);
      controller.set('longitude', location.coords.longitude);
    });
  },
  actions: {
    postSolicitacao(solicitacao, usuario) {
      let createUser = Ember.RSVP.Promise.resolve(this.controller.get('currentUser.id'));

      if (usuario !== false) {
        createUser = this.get('ajax').post('/usuario', {data: usuario});
      }

      return createUser.then(userId => {
        if (usuario !== false) {
          this.controller.set('currentUser', this.get('ajax').request(`/usuario/${userId}`));
        }

        solicitacao.usuario = userId;
        solicitacao.status = "Pendente";

        return this.get('ajax').post('/solicitacao', { data: solicitacao });
      })
      .then(() => this.get('ajax').request('/solicitacao'))
      .then(model => this.controller.set('model', model));
    }
  }
});
