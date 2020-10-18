package fon.companyservice.web.controller;

import fon.companyservice.service.CompanyService;
import fon.companyservice.web.model.CompanyDto;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/companies")
public class CompanyController {

    private final CompanyService companyService;


    @GetMapping
    public ResponseEntity<List<CompanyDto>> listCompanies(){
        return new ResponseEntity<>(companyService.listCompanies(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompanyDto> findCompany(@PathVariable("id") Integer id){
        return new ResponseEntity<>(companyService.findCompanyById(id), HttpStatus.OK);
    }

    @GetMapping("/{id}/average-salary")
    public ResponseEntity findAverageSalary(@PathVariable("id") Integer id){
        return new ResponseEntity<>(companyService.getAverageSalary(id), HttpStatus.OK);
    }

}
