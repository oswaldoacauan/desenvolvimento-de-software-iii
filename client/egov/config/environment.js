/* jshint node: true */

module.exports = function(environment) {
  var ENV = {
    modulePrefix: 'egov',
    environment: environment,
    baseURL: '/',
    locationType: 'auto',
    EmberENV: {
      FEATURES: {
        // Here you can enable experimental features on an ember canary build
        // e.g. 'with-controller': true
      }
    },
    sassOptions: {
      includePaths: ['bower_components/material-design-lite/src']
    },
    API: {
      host: 'http://127.0.0.1:9000',
      namespace: '/egov',
    },
    APP: {
      // Here you can pass flags/options to your application instance
      // when it is created
    }
  };

  if (environment === 'development') {
    // ENV.APP.LOG_RESOLVER = true;
    // ENV.APP.LOG_ACTIVE_GENERATION = true;
    // ENV.APP.LOG_TRANSITIONS = true;
    // ENV.APP.LOG_TRANSITIONS_INTERNAL = true;
    // ENV.APP.LOG_VIEW_LOOKUPS = true;
  }

  if (environment === 'test') {
    // Testem prefers this...
    ENV.baseURL = '/';
    ENV.locationType = 'none';

    // keep test console output quieter
    ENV.APP.LOG_ACTIVE_GENERATION = false;
    ENV.APP.LOG_VIEW_LOOKUPS = false;

    ENV.APP.rootElement = '#ember-testing';
  }

  if (environment === 'production') {

  }

  ENV['g-map'] = {
    libraries: ['places'],
    key: 'AIzaSyDtuKaNcWeGRQRjFXF49Qrj5c_-fqn3IP0',
    language: 'pt-br',
    protocol: 'https'
  };

  return ENV;
};
