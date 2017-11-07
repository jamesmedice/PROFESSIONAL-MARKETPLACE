package com.it.gft.global.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "GFT_AMBASSOR")
public class Ambassor implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ambassor_id;

    private String functionArea;

    @JsonBackReference
    @JoinColumn(name = "ambassor_id", referencedColumnName = "ambassor_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Branch branch;

    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Employee employee;

    public String getFunctionArea() {
	return functionArea;
    }

    public Branch getBranch() {
	return branch;
    }

    public Employee getEmployee() {
	return employee;
    }

    public void setEmployee(Employee employee) {
	this.employee = employee;
    }

    public void setFunctionArea(String functionArea) {
	this.functionArea = functionArea;
    }

    public void setBranch(Branch branch) {
	this.branch = branch;
    }

}
