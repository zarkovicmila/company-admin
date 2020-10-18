import EmberRouter from '@ember/routing/router';
import config from 'ember-company-admin/config/environment';

export default class Router extends EmberRouter {
  location = config.locationType;
  rootURL = config.rootURL;
}

Router.map(function() {
  this.route('companies', function() {});
  this.route('employees', { path: '/companies/:id'}, function() {
    this.route('edit', { path: 'employees/:employeeId' } );
    this.route('new', { path: 'employees'});
  });
});
