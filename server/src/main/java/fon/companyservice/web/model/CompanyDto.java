package fon.companyservice.web.model;

import fon.companyservice.web.model.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CompanyDto {

    private Integer id;
    private String name;
    private List<EmployeeDto> employees;
}
