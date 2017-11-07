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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 
 * @author TOSS
 *
 */
@Entity
@Table(name = "GFT_PROFILES")
public class Profile implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int profile_id;

    private int level;

    private String level_description;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profile")
    private Set<Employee> employees;
    
    public Long getId() {
 	return Long.valueOf(this.profile_id);
     }

     public void setId(Integer profile_id) {
 	this.profile_id = profile_id;
     }

    public int getLevel() {
	return level;
    }

    public String getLevel_description() {
	return level_description;
    }

    public Set<Employee> getEmployees() {
	if (employees == null)
	    employees = new HashSet<Employee>();

	return employees;
    }

    public void setLevel(int level) {
	this.level = level;
    }

    public void setLevel_description(String level_description) {
	this.level_description = level_description;
    }

}
