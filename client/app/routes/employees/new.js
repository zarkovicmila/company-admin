import Route from '@ember/routing/route';
import Ember from 'ember';
const { set } = Ember;

export default class EmployeesNewRoute extends Route {
       
    model(){
        return this.store.createRecord('employee');
       }

       setupController(controller, model){
           this._super(controller, model);
           set(controller,'employee', model);
           controller.set('company', this.paramsFor('employees').id);
       }
}
