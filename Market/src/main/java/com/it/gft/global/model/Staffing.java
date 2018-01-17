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
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GFT_STAFFING")
public class Staffing implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int staff_id;

    private String corporateArea;

    @JsonIgnore
    @JoinColumn(name = "staff_id", referencedColumnName = "staff_id", nullable = true)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Employee> employees;

    public String getCorporateArea() {
	return corporateArea;
    }

    public Set<Employee> getEmployees() {
	if (employees == null)
	    employees = new HashSet<Employee>();

	return employees;
    }

    public void setCorporateArea(String corporateArea) {
	this.corporateArea = corporateArea;
    }
}
