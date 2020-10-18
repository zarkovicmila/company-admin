package fon.companyservice.web.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private Integer id;

    private String name;

    private String surname;

    private String email;

    private String address;

    private BigDecimal salary;

    private Integer company_id;

    private String company_name;
}
