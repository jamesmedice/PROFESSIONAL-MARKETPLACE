package com.it.gft.global.dao.impl;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.util.Assert;

import com.it.gft.global.app.AppConfig;
import com.it.gft.global.app.EntityProvider;
import com.it.gft.global.model.Company;
import com.it.gft.global.service.CompanyService;

@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
@ContextConfiguration(classes = { AppConfig.class })
public class CompanyDAOImplTest extends EntityProvider {

    private static final Integer ID_COMPANY_1 = 1;

    @Autowired
    @Qualifier(value = "companyService")
    private CompanyService companyService;

    @Before
    public void init() {

    }

    @Test
    public void saveAllTreeCompany() {
	companyService.saveCompany(getCompany());
    }

    @Test
    public void findAllCompaniesTest() {
	List<Company> items = companyService.findAllCompanies();
	Assert.notEmpty(items);
    }

    @Test
    public void findCompanyByIdTest() {
	Company item = companyService.findById(ID_COMPANY_1);
	Assert.notNull(item);
    }

}
