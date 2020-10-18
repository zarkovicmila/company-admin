import Controller from '@ember/controller';
import { action } from '@ember/object';
import { inject as service } from '@ember/service';


export default class EmployeesNewController extends Controller {

    @service('employee') employeeService;
    
    savedEmployee = null;

    @action
    addEmployee(){   
    this.employee.validate()
    .then(({ validations }) => {
      if (validations.get('isValid')) {
        let newEmployee = this.createEmployee();
        this.employeeService.saveEmployee(newEmployee);
    
        this.clearProperties();
        this.set('savedEmployee', newEmployee.name + ' ' + newEmployee.surname);
      }
    })
    .catch( err => {
      alert('Error.');
    });       
  }
  
    @action
    goToCompanyPage(){
      this.set('savedEmployee',null);
      this.transitionToRoute('employees', this.company);
    }

    clearProperties(){
        this.employee.name = '';
        this.employee.surname = '';
        this.employee.email = '';
        this.employee.address = '';
        this.employee.salary = '';
    } 

    createEmployee(){
        let employee = {      
            name: this.get('employee.name'),
            surname: this.get('employee.surname'),
            address: this.get('employee.address'),
            email: this.get('employee.email'),
            salary: this.get('employee.salary'),
            company_id: this.company
          }         

        return employee;
   }
}
