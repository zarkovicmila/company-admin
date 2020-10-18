package fon.companyservice.service;

import fon.companyservice.domain.Employee;
import fon.companyservice.repository.EmployeeRepository;
import fon.companyservice.web.mapper.EmployeeMapper;
import fon.companyservice.web.model.EmployeeDto;
import fon.companyservice.web.model.exception.EmployeeNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    @Override
    public EmployeeDto findEmployeeById(Integer id) {
        return employeeMapper.employeeToEmployeeDto(employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new));
    }

    @Transactional
    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        return employeeMapper.employeeToEmployeeDto(employeeRepository.save(employeeMapper.employeeDtoToEmployee(employeeDto)));
    }

    @Transactional
    @Override
    public EmployeeDto updateEmployee(Integer id, EmployeeDto employeeDto) {
        Employee employee = employeeRepository.findById(id).orElseThrow(EmployeeNotFoundException::new);
        employee.setAddress(employeeDto.getAddress());
        employee.setEmail(employeeDto.getEmail());
        employee.setName(employeeDto.getName());
        employee.setSurname(employeeDto.getSurname());
        employee.setSalary(employeeDto.getSalary());

        return employeeMapper.employeeToEmployeeDto(employeeRepository.save(employee));
    }

    @Transactional
    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findEmployeesByCompany(Integer companyId) {
        List<Employee> employeeList = employeeRepository.findAllByCompanyIdOrderBySurname(companyId);
        List<EmployeeDto> employeeDtoList = employeeList.stream().map(employeeMapper::employeeToEmployeeDto).collect(Collectors.toList());
        return employeeDtoList;
    }
}
