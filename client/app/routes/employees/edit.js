import Route from '@ember/routing/route';
import Ember from 'ember';

const { set } = Ember;

export default class EmployeesEditRoute extends Route {
    model(params){
        this.set('action',params.action);
        return this.store.findRecord('employee', params.employeeId);  
    }

       setupController(controller, model){
           this._super(controller, model);
           set(controller,'employee', model);
           controller.set('company', this.paramsFor('employees').id);
       }
  
}
