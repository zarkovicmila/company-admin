package fon.companyservice.service;

import fon.companyservice.domain.Company;
import fon.companyservice.domain.Employee;
import fon.companyservice.repository.CompanyRepository;
import fon.companyservice.repository.EmployeeRepository;
import fon.companyservice.web.mapper.CompanyMapper;
import fon.companyservice.web.model.CompanyDto;
import fon.companyservice.web.model.exception.CompanyNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CompanyServiceImpl implements CompanyService {

    private final CompanyRepository companyRepository;
    private final EmployeeRepository employeeRepository;
    private final CompanyMapper companyMapper;

    @Override
    public CompanyDto findCompanyById(Integer id) {
        return companyMapper.companyToCompanyDto(companyRepository.findById(id).orElseThrow(CompanyNotFoundException::new));
    }

    @Override
    public List<CompanyDto> listCompanies() {
        List<Company> companyList = companyRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
        List<CompanyDto> companyDtoList = companyList.stream().map(companyMapper::toCompanyDto).collect(Collectors.toList());
        return companyDtoList;
    }

    @Override
    public BigDecimal getAverageSalary(Integer id) {
        return employeeRepository.getAverageSalaryForCompany(id);
    }
}
