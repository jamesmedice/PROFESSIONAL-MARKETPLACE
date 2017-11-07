package com.it.gft.global.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.it.gft.global.dao.CompanyDAO;
import com.it.gft.global.model.Company;
import com.it.gft.global.service.CompanyService;

/**
 * 
 * @author TOSS
 *
 */
@Service("companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {

    @Autowired(required = true)
    private CompanyDAO companyDAO;

    @Override
    public void saveCompany(Company company) {
	companyDAO.save(company);
    }

    @Override
    public List<Company> findAllCompanies(Boolean orderBy, String name) {
	return companyDAO.findAll(orderBy, name);
    }

    @Override
    public List<Company> findAllCompanies() {
	return companyDAO.findAll(false, null);
    }

    @Override
    public void deleteCompanyById(Integer id) {
	companyDAO.deleteById(id);
    }

    @Override
    public Company findById(Integer id) {
	return companyDAO.findById(id);
    }

    @Override
    public void updateCompany(Company company) {
	companyDAO.update(company);
    }

    @Override
    public void deleteCompany(Company company) {
	companyDAO.delete(company);
    }

}
