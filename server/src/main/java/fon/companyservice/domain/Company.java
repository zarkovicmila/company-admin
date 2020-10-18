package fon.companyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OrderBy("surname ASC")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    private List<Employee> employees;
}
