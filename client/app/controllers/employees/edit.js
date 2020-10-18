import Controller from '@ember/controller';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';


export default class EmployeesEditController extends Controller {
    
    @service('employee') employeeService;
  
    queryParams = ['action'];
    action = null;


    @action
    updateEmployee(id){    
     this.employee.validate()
        .then(({ validations }) => {
          if (validations.get('isValid')) {
            
            let updateEmployee = this.createEmployee(id);
            this.employeeService.updateEmployee(updateEmployee);
            this.transitionToRoute('employees', updateEmployee.company_id);
          }
      })
      .catch( err => {
        alert('Error.');
      });        
  }
           
   createEmployee(id){
    let employee = {
            id:id,
            name: this.get('employee.name'),
            surname: this.get('employee.surname'),
            address: this.get('employee.address'),
            email: this.get('employee.email'),
            salary: this.get('employee.salary'),
            company_id: this.get('employee.company_id')
          }      
      
    return employee;
   }

 }

