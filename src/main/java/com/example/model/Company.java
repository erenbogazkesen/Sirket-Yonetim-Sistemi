package com.example.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    // Diğer alanlar

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // Getter ve Setter metodları

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Diğer getter ve setter metodları

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setAddress(String address) {
        this.address = address;
    }



// Getter ve Setter metotları

    public String getAddress() {
        return address;
    }


}
