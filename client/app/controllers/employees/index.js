import Controller from '@ember/controller';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';


export default class EmployeesIndexController extends Controller {
 
    @service('employee') employeeService;

    employeeToDelete = null;
    alert = false;
    averageSalary = null;

    @action
    deleteEmployee(id){
        this.store.findRecord('employee', id, { reload: true }).then((employee) => { 
            this.set('employeeToDelete', null);
            employee.destroyRecord();
          
        }).catch(err=>{
              alert('Error.');
          });
    }

    @action
    findAverageSalary(id){
        this.employeeService.getAverageSalary(id)
        .then( e =>{
            this.set('averageSalary', parseInt(e.target.response))
            this.set('alert', true);
        })
        .catch(err => {
            alert('Error.');
        });
    }

    @action
    setEmployeeToDelete(id){
        this.set('employeeToDelete', id);
    }

    @action
    cancleDeleltingEmployee(){
        this.set('employeeToDelete', null);
    }

    @action
    dismissAlert(){
        this.set('alert', false);
    }

}