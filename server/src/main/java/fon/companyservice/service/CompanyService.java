package fon.companyservice.service;

import fon.companyservice.web.model.CompanyDto;

import java.math.BigDecimal;
import java.util.List;

public interface CompanyService {

    CompanyDto findCompanyById(Integer id);
    List<CompanyDto> listCompanies();
    BigDecimal getAverageSalary(Integer id);
}
