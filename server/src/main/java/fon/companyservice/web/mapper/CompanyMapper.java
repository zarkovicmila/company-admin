package fon.companyservice.web.mapper;

import fon.companyservice.domain.Company;
import fon.companyservice.web.model.CompanyDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = EmployeeMapper.class)
public interface CompanyMapper {

    Company companyDtoToCompany(CompanyDto companyDto);

    CompanyDto companyToCompanyDto(Company company);

    @Mapping(target = "employees", ignore = true)
    CompanyDto toCompanyDto(Company company);
}
