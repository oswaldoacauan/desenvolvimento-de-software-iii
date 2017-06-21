import { moduleForComponent, test } from 'ember-qunit';
import hbs from 'htmlbars-inline-precompile';

moduleForComponent('g-map-acessor', 'Integration | Component | g map acessor', {
  integration: true
});

test('it renders', function(assert) {

  // Set any properties with this.set('myProperty', 'value');
  // Handle any actions with this.on('myAction', function(val) { ... });

  this.render(hbs`{{g-map-acessor}}`);

  assert.equal(this.$().text().trim(), '');

  // Template block usage:
  this.render(hbs`
    {{#g-map-acessor}}
      template block text
    {{/g-map-acessor}}
  `);

  assert.equal(this.$().text().trim(), 'template block text');
});
