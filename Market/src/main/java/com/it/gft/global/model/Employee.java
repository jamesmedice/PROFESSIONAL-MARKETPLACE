package com.it.gft.global.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GFT_EMPLOYEE")
public class Employee extends BaseEmployee implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    private Currency currency;

    private boolean available_travel = true;

    @JoinColumn(name = "profile_id", referencedColumnName = "profile_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Profile profile;

    @JoinColumn(name = "skill_id", referencedColumnName = "skill_id")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<ProfessionalSkills> skills;

    @JsonIgnore
    @JoinColumn(name = "project_id", referencedColumnName = "project_id")
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Project> projects;

    private String profile_name;

    private BigDecimal salary;

    private Date initDate;

    private int level;

    @Transient
    public Long getId() {
	return Long.valueOf(this.employee_id);
    }

    public String getProfile_name() {
	return profile_name;
    }

    public BigDecimal getSalary() {
	return salary;
    }

    public Date getInitDate() {
	return initDate;
    }

    public void setProfile_name(String profile_name) {
	this.profile_name = profile_name;
    }

    public void setSalary(BigDecimal salary) {
	this.salary = salary;
    }

    public void setInitDate(Date initDate) {
	this.initDate = initDate;
    }

    public int getLevel() {
	return level;
    }

    public void setLevel(int level) {
	this.level = level;
    }

    public Currency getCurrency() {
	return currency;
    }

    public void setCurrency(Currency currency) {
	this.currency = currency;
    }

    public Profile getProfile() {
	return profile;
    }

    public void setProfile(Profile profile) {
	this.profile = profile;
    }

    public Set<Project> getProjects() {
	if (projects == null)
	    projects = new HashSet<Project>();

	return projects;
    }

    public Set<ProfessionalSkills> getSkills() {
	if (skills == null)
	    skills = new HashSet<ProfessionalSkills>();

	return skills;
    }

    public boolean isAvailable_travel() {
	return available_travel;
    }

    public void setAvailable_travel(boolean available_travel) {
	this.available_travel = available_travel;
    }

}
