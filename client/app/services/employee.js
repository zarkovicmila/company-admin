import Service from '@ember/service';
import ENV from '../config/environment';

export default class EmployeeService extends Service {
    

    updateEmployee(employee){      
        let xhr = new XMLHttpRequest();
        
        xhr.open('PUT', ENV.restAPI+'employees/'+employee.id);
        xhr.setRequestHeader('Content-type', 'application/json');
        xhr.onload = function(){
         if(this.status == 200 || this.status == 201){
             console.log('Success');
            }
        }
         xhr.send(JSON.stringify(employee));
    }


    saveEmployee(newEmployee){
        let xhr = new XMLHttpRequest();

        xhr.open('POST', ENV.restAPI+'employees');
        xhr.setRequestHeader('Content-type', 'application/json');      
        xhr.onload = function(){
        if(this.status == 200 || this.status == 201){
            console.log('Success');
        }
      }
        xhr.send(JSON.stringify(newEmployee));
    }

    getAverageSalary(companyId){
        return new Promise( (resolve, reject) => {
        let xhr = new XMLHttpRequest();
        xhr.open('GET', ENV.restAPI+'companies/'+companyId+'/average-salary');
        xhr.setRequestHeader('Content-type', 'application/json');
        xhr.onload = resolve;
        xhr.onerror = reject;
        xhr.send();
        });
    }
    
}
