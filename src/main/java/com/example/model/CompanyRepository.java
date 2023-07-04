package com.example.model;



import com.example.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {
    // Özel sorgular ve işlemler burada tanımlanabilir
}
