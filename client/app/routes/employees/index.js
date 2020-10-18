import Route from '@ember/routing/route';
import Ember from 'ember';
const { set } = Ember;

export default class EmployeesIndexRoute extends Route {
    model(){
        let company_id = this.paramsFor('employees').id;
        return this.store.query('employee',{companyId: company_id});  
     }
   
       setupController(controller, model){
           this._super(controller, model);
           set(controller,'employees', model);
           controller.set('company', this.paramsFor('employees').id);
       }
}
