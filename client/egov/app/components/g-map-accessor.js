import Ember from 'ember';
const GMapAccessor = Ember.Component.extend({
  mapWasSet: Ember.observer('mapContext.map', function() {
    Ember.run.once(this, function() {
     this.get('setMap')(this.get('mapContext.map'));
    });
  })
});
GMapAccessor.reopenClass({
  positionalParams: ['mapContext']
});
export default GMapAccessor;
