package com.it.gft.global.model;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class EntityProvider {


    public static void showProperties(Object mapper) {
	if (mapper instanceof Object)
	    for (Field field : mapper.getClass().getDeclaredFields()) {
		Type type = field.getGenericType();
		System.out.println("field name: " + field.getName());
		if (type instanceof TypeVariable<?>) {

		    System.out.println("-field type: " + field.getType());

		} else if (type instanceof ParameterizedType) {
		    ParameterizedType ptype = (ParameterizedType) type;
		    ptype.getRawType();
		    showProperties(type);
		} else {
		    System.out.println("-field type: " + field.getType());
		}
	    }
    }

   
    
    public static Company getCompany() {
	Company company = new Company();
	company.setIva(439753108);
	company.setName("GFT ITALY C.O");
	company.setCoreBusiness("IT BANKING OUTSOURCING");
	company.setBusinessArea("IT");
	company.getBranchs().add(getBranch("FIRENZE", company));
	company.getBranchs().add(getBranch("MILANO", company));
	company.getBranchs().add(getBranch("PADOVA", company));
	company.getBranchs().add(getBranch("PIACENZA", company));
	company.getBranchs().add(getBranch("TORINO", company));
	company.getBranchs().add(getBranch("VENEZIA", company));
	company.getClients().add(getClient("INTESA SANPAOLO"));
	company.getClients().add(getClient("CHEBANCA", "CMMI4"));
	company.getClients().add(getClient("BANCA POPOLARE DI NOVARA"));
	company.getClients().add(getClient("BANCA POPOLARE DI MILANO", "CMMI5"));
	company.getClients().add(getClient("UBI BANCA"));
	return company;
    }

    public static Market getClient(String name) {
	return getClient(name, null);
    }

    public static Market getClient(String name, String cmmi) {
	Market client = new Market();
	client.setClient_name(name);
	client.setCmmi5(cmmi != null ? cmmi : "DEFAULT_CMMI_1");
	client.setCoreBusiness("IT");
	client.getProjects().add(getProject("Mortgage"));
	client.getProjects().add(getProject("Home Banking", 10));
	client.getProjects().add(getProject("Invisible Card", 40));
	client.getProjects().add(getProject("WWWFISH", 31));
	return client;
    }

    public static Project getProject(String name) {
	return getProject(name, 0);
    }

    public static Project getProject(String name, int numberReleases) {
	Project proj = new Project();
	proj.setInitDate(new Date());
	proj.setNumberOfReleases(numberReleases > 0 ? numberReleases : 25);
	proj.setProjectName(name);
	proj.getEmployees().add(getEmployee("Tiago Medice", BigDecimal.valueOf(4000)));
	proj.getEmployees().add(getEmployee("Lucas Medice", BigDecimal.valueOf(3.8000)));
	proj.getEmployees().add(getEmployee("Mateus Medice", BigDecimal.valueOf(3900)));
	return proj;
    }

    public static Branch getBranch(String city, Company company) {
	Branch branch = new Branch();
	branch.setCity(city);
	branch.setStaff(getStaff());
	branch.setAmbassor(getAmbassor());
	branch.setDirector(getDirector());
	branch.getDirector().setStaff(branch.getStaff());
	branch.getEmployees().add(getEmployee("Stefano Fantechi"));
	branch.getEmployees().add(getEmployee("Mauro Sabatino", BigDecimal.valueOf(1000)));
	branch.getEmployees().add(getEmployee("Mattia Zanela", BigDecimal.valueOf(3000)));
	return branch;
    }

    public static Director getDirector() {
	return getDirector(null);
    }

    public static Director getDirector(String area) {
	Director dir = new Director();
	dir.setBusiness_area(area != null ? area : "DEFAULT_BUSINESS_AREA");
	return dir;
    }

    public static Ambassor getAmbassor() {
	return getAmbassor(null);
    }

    public static Ambassor getAmbassor(String area) {
	Ambassor ambss = new Ambassor();
	ambss.setFunctionArea(area != null ? area : "UNIVERISTY");
	ambss.setEmployee(getEmployee("Giacomo Medici", BigDecimal.valueOf(1399)));
	return ambss;
    }

    public static Staffing getStaff() {
	return getStaff(null);
    }

    public static Staffing getStaff(String corporateArea) {
	Staffing staff = new Staffing();
	staff.setCorporateArea(corporateArea != null ? corporateArea : "DEFAULT_AREA_ORGANIZATION");
	staff.getEmployees().add(getEmployee("Cristina Calandra", BigDecimal.valueOf(2000)));
	staff.getEmployees().add(getEmployee("Claudia Nuber", BigDecimal.valueOf(1200)));
	return staff;
    }

    public static Employee getEmployee(String name, BigDecimal salary) {
	Employee employee = new Employee();
	employee.setInitDate(new Date());
	employee.setProfile_name(name);
	employee.setAvailable_travel(true);
	employee.setSalary(salary != null ? salary : BigDecimal.valueOf(1500));
	employee.setCurrency(Currency.EURO);
	employee.setProfile(getProfile(3));
	employee.getSkills().add(getProfessionalSkills());
	employee.getSkills().add(getProfessionalSkillsBeta());
	return employee;
    }

    public static ProfessionalSkills getProfessionalSkills() {
	ProfessionalSkills skills = new ProfessionalSkills();
	skills.setSkill_category("WEB DESIGN");
	skills.setSkill_type("AUTO");
	skills.setSkill_description("DEVELOPMENT");
	return skills;
    }

    public static ProfessionalSkills getProfessionalSkillsBeta() {
	ProfessionalSkills skills = new ProfessionalSkills();
	skills.setSkill_category("WEB DEVELOPment");
	skills.setSkill_type("AUTO");
	skills.setSkill_description("OUTSOURCING");
	return skills;
    }

    public static Profile getProfile(int i) {
	return getProfile(i, null);
    }

    public static Profile getProfile(int level, String level_desc) {
	Profile profile = new Profile();
	profile.setLevel(level);
	profile.setLevel_description(level_desc != null ? level_desc : "DEFAULT_LEVEL_1");
	return profile;
    }

    public static Employee getEmployee(String name) {
	return getEmployee(name, null);
    }

}
