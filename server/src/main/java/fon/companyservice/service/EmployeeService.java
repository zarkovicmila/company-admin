package fon.companyservice.service;


import fon.companyservice.web.model.EmployeeDto;

import java.util.List;


public interface EmployeeService {

    EmployeeDto findEmployeeById(Integer id);
    EmployeeDto saveEmployee(EmployeeDto employeeDto);
    EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto);
    void deleteEmployee(Integer id);
    List<EmployeeDto> findEmployeesByCompany(Integer companyId);
}
