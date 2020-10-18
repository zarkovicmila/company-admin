package fon.companyservice.repository;

import fon.companyservice.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByCompanyIdOrderBySurname(Integer companyId);

    @Query("SELECT SUM(e.salary)/COUNT(e.id) FROM Employee e GROUP BY e.company.id HAVING e.company.id=?1")
    BigDecimal getAverageSalaryForCompany(Integer companyId);
}
