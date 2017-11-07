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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "GFT_BRANCH")
public class Branch implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int branch_id;

    private String city;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Employee> employees;

    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Staffing staff;

    @JsonManagedReference
    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Ambassor ambassor;

    @JoinColumn(name = "branch_id", referencedColumnName = "branch_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Director director;

    public Ambassor getAmbassor() {
	return ambassor;
    }

    public void setAmbassor(Ambassor ambassor) {
	this.ambassor = ambassor;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public Set<Employee> getEmployees() {
	if (employees == null)
	    employees = new HashSet<Employee>();

	return employees;
    }

    public Staffing getStaff() {
	return staff;
    }

    public void setStaff(Staffing staff) {
	this.staff = staff;
    }

    public Director getDirector() {
	return director;
    }

    public void setDirector(Director director) {
	this.director = director;
    }

}
