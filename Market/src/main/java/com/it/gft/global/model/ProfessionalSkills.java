package com.it.gft.global.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GFT_PROFESSIONAL_SKILLS")
public class ProfessionalSkills implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int skill_id;

    private String skill_category;

    private String skill_type;

    private String skill_description;
 
    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy="skills")
    private Set<Employee> employees;

    public String getSkill_category() {
	return skill_category;
    }

    public String getSkill_type() {
	return skill_type;
    }

    public String getSkill_description() {
	return skill_description;
    }

    public Set<Employee> getEmployees() {
	if (employees == null)
	    employees = new HashSet<>();

	return employees;
    }

    public void setSkill_category(String skill_category) {
	this.skill_category = skill_category;
    }

    public void setSkill_type(String skill_type) {
	this.skill_type = skill_type;
    }

    public void setSkill_description(String skill_description) {
	this.skill_description = skill_description;
    }

}
