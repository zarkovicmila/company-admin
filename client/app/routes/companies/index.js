import Route from '@ember/routing/route';
import Ember from 'ember';
const { set } = Ember;


export default class CompaniesIndexRoute extends Route {
     model(){
       return this.store.findAll('company').catch(err=>{
           alert('Error.');
       });
    }

    setupController(controller, model){
        set(controller,'companies', model);
    }
}
