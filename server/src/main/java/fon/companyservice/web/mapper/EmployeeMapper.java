package fon.companyservice.web.mapper;

import fon.companyservice.domain.Employee;
import fon.companyservice.web.model.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface EmployeeMapper {

    @Mappings({
            @Mapping(target = "company.id", source = "company_id"),
            @Mapping(target = "company.name", source = "company_name")
    })
    Employee employeeDtoToEmployee(EmployeeDto employeeDto);

    @Mappings({
            @Mapping(target = "company_id", source = "company.id"),
            @Mapping(target = "company_name", source = "company.name")
    })
    EmployeeDto employeeToEmployeeDto(Employee employee);

}
