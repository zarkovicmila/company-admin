package fon.companyservice.web.controller;

import fon.companyservice.service.EmployeeService;
import fon.companyservice.web.mapper.EmployeeMapper;
import fon.companyservice.web.model.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/v1/employees")
@RestController
public class EmployeeController {

    private final EmployeeService employeeService;


    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployee(@PathVariable("id") Integer employeeId){
        return new ResponseEntity<>(employeeService.findEmployeeById(employeeId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getEmployeesFromCompany(@RequestParam(value = "companyId", required = true) Integer companyId){
        return new ResponseEntity<>(employeeService.findEmployeesByCompany(companyId),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.saveEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Integer employeeId, @RequestBody EmployeeDto employeeDto){
        return new ResponseEntity<>(employeeService.updateEmployee(employeeId, employeeDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEmployee(@PathVariable("id") Integer employeeId){
        employeeService.deleteEmployee(employeeId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}
