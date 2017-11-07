package com.it.gft.global.service;

import java.util.List;

import com.it.gft.global.model.Company;

public interface CompanyService {

    void saveCompany(Company employee);

    List<Company> findAllCompanies(Boolean orderBy, String name);

    List<Company> findAllCompanies();

    void deleteCompanyById(Integer id);

    void deleteCompany(Company company);

    Company findById(Integer id);

    void updateCompany(Company company);
}
