package com.example.model;


import com.example.model.Employee;
//import com.example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Çalışan kaydetme işlemi
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Tüm çalışanları getirme işlemi
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Çalışan silme işlemi
    public void deleteEmployee(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

    // Diğer iş mantığı metotları
    // ...
}
