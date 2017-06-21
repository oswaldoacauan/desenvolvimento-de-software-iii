import AjaxService from 'ember-ajax/services/ajax';
import config from '../config/environment';

export default AjaxService.extend({
  contentType: 'application/json; charset=utf-8',
  host: config.API.host,
  namespace: config.API.namespace,
});
