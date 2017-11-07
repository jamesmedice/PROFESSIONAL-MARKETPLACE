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

import com.it.gft.global.log.model.IAuditLog;

@Entity
@Table(name = "GFT_CLIENTS")
public class Market implements Serializable, IAuditLog {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int client_id;

    private String client_name;

    private String coreBusiness;

    private String cmmi5;

    @JoinColumn(name = "client_id", referencedColumnName = "client_id")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Project> projects;

    public String getClient_name() {
	return client_name;
    }

    public String getCoreBusiness() {
	return coreBusiness;
    }

    public String getCmmi5() {
	return cmmi5;
    }

    public void setClient_name(String client_name) {
	this.client_name = client_name;
    }

    public void setCoreBusiness(String coreBusiness) {
	this.coreBusiness = coreBusiness;
    }

    public void setCmmi5(String cmmi5) {
	this.cmmi5 = cmmi5;
    }

    public Set<Project> getProjects() {
	if (projects == null)
	    projects = new HashSet<Project>();

	return projects;
    }

    public Long getId() {
	return Long.valueOf(this.client_id);
    }

    public void setId(Integer client_id) {
	this.client_id = client_id;
    }

    public String getAuditDetail() {
	return "Client [client_name=" + client_name + ", coreBusiness=" + coreBusiness + ", cmmi5=" + cmmi5 + ", projects=" + projects + "]";
    }

}
