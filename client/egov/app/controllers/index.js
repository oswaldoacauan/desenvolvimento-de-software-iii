import Ember from 'ember';
/* global google */

const solicitacaoClean = {
  nome: null,
  email: null,
  descricao: null,
  endereco: null,
  tipo: null,
  status: "Pendente",
  lat: null,
  lng: null
};

export default Ember.Controller.extend({
  map: null,
  latitude: -29.795395,
  longitude: -51.154339,
  zoom: 15,
  isCreatingSolicitacao: false,

  newSolicitacao: Ember.Object.create(solicitacaoClean),
  geocoder: new google.maps.Geocoder,
  currentUser: null,

  updateEndereco: function() {
    const latlng = {
      lat: this.get('newSolicitacao.lat'),
      lng: this.get('newSolicitacao.lng'),
    };

    this.get('geocoder').geocode({'location': latlng}, (results, status) => {
      if (status === 'OK') {
        if (results[1]) {
          this.set('newSolicitacao.endereco', results[0].formatted_address);
        }
      }
    });
  },

  actions: {
    setMap(map) {
      this.set('map', map);
    },
    handleDrag(lat, lng) {
      this.set('newSolicitacao.lat', lat);
      this.set('newSolicitacao.lng', lng);
      this.updateEndereco();
    },
    toggleCreateSolicitacao() {
      this.set('newSolicitacao.lat', this.get('map').center.lat());
      this.set('newSolicitacao.lng', this.get('map').center.lng());
      this.updateEndereco();
      this.toggleProperty('isCreatingSolicitacao');
    },
    createSolicitacao() {
      const solicitacao = {
        "usuario": 0,
        "tipo": parseInt(this.get('newSolicitacao.tipo')),
        "lat": this.get('newSolicitacao.lat'),
        "lng": this.get('newSolicitacao.lng'),
        "descricao": this.get('newSolicitacao.descricao'),
        "endereco": this.get('newSolicitacao.endereco'),
        "status": this.get('newSolicitacao.status'),
      };

      const currentUser = this.get('currentUser');
      let newUser = false;
      if (!currentUser) {
        newUser = {
          "nome": this.get('newSolicitacao.nome'),
          "email": this.get('newSolicitacao.email'),
          "senha": "string",
          "cpf": "string",
          "rg": "string",
          "endereco": "string",
          "nascimento": "2017-06-21T14:04:41.396Z"
        };
      }

      this.send('postSolicitacao', solicitacao, newUser);

      this.set('newSolicitacao.lng', null);
      this.set('newSolicitacao.lat', null);
      this.set('newSolicitacao.tipo', null);
      this.set('newSolicitacao.endereco', null);
      this.set('newSolicitacao.descricao', null);
      this.toggleProperty('isCreatingSolicitacao');
    },
  }
});
