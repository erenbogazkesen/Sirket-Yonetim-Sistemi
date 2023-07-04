package com.example.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    // Şirket kaydetme işlemi
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Tüm şirketleri getirme işlemi
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Şirket silme işlemi
    public boolean deleteCompany(Long companyId) {
        try {
            companyRepository.deleteById(companyId);
            return true; // Şirket başarıyla silindiğinde true döndürülür
        } catch (Exception e) {
            return false; // Şirket silinemediğinde veya hata oluştuğunda false döndürülür
        }
    }

    // Diğer iş mantığı metotları
    // ...

    public Company getCompanyById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }

    public Company addCompany(Company company) {
        return companyRepository.save(company);
    }

    public boolean updateCompany(Long id, Company updatedCompany) {
        Company existingCompany = companyRepository.findById(id).orElse(null);

        if (existingCompany != null) {
            existingCompany.setName(updatedCompany.getName());
            existingCompany.setAddress(updatedCompany.getAddress());
            // Diğer alanları güncelleme

            companyRepository.save(existingCompany);
            return true; // Şirket başarıyla güncellendiğinde true döndürülür
        }

        return false; // Şirket bulunamadığında veya güncellenemediğinde false döndürülür
    }
}
