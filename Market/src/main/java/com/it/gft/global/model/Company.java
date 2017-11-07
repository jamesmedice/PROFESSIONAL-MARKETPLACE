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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "GFT_COMPANY")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Company implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int company_id;

    private String name;

    private int iva;

    private String businessArea;

    private String coreBusiness;

    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Market> clients;

    @JoinColumn(name = "company_id", referencedColumnName = "company_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Branch> branchs;

    public Company() {
	super();
    }

    public Company(String name, int iva, String businessArea, String coreBusiness) {
	this.name = name;
	this.iva = iva;
	this.businessArea = businessArea;
	this.coreBusiness = coreBusiness;
    }

    public String getName() {
	return name;
    }

    public int getIva() {
	return iva;
    }

    public String getBusinessArea() {
	return businessArea;
    }

    public void setName(String name) {
	this.name = name;
    }

    public void setIva(int iva) {
	this.iva = iva;
    }

    public void setBusinessArea(String businessArea) {
	this.businessArea = businessArea;
    }

    public String getCoreBusiness() {
	return coreBusiness;
    }

    public void setCoreBusiness(String coreBusiness) {
	this.coreBusiness = coreBusiness;
    }

    public Set<Branch> getBranchs() {
	if (branchs == null)
	    branchs = new HashSet<Branch>();

	return branchs;
    }

    public Set<Market> getClients() {
	if (clients == null)
	    clients = new HashSet<Market>();

	return clients;
    }

    @Transient
    public Long getId() {
	return Long.valueOf(this.company_id);
    }

    public void setId(Integer company_id) {
	this.company_id = company_id;
    }

    @Transient
    public String getAuditDetail() {
	StringBuilder sb = new StringBuilder();
	sb.append(" Id : ").append(company_id).append("   iva : ").append(iva).append("  BusinessArea : ").append(businessArea);

	return sb.toString();
    }

    @Override
    public String toString() {
	return "Company [company_id=" + company_id + ", name=" + name + ", iva=" + iva + ", businessArea=" + businessArea + ", coreBusiness=" + coreBusiness + ", clients="
		+ clients + ", branchs=" + branchs + "]";
    }

}
