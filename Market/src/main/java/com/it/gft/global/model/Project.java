package com.it.gft.global.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GFT_PROJECTS")
public class Project implements Serializable{

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int project_id;

    private String projectName;

    private int timeLine;

    private Date initDate;

    private int numberOfReleases;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "projects")
    private Set<Employee> employees;

    public String getProjectName() {
	return projectName;
    }

    public int getTimeLine() {
	return timeLine;
    }

    public Date getInitDate() {
	return initDate;
    }

    public int getNumberOfReleases() {
	return numberOfReleases;
    }

    public void setProjectName(String projectName) {
	this.projectName = projectName;
    }

    public void setTimeLine(int timeLine) {
	this.timeLine = timeLine;
    }

    public void setInitDate(Date initDate) {
	this.initDate = initDate;
    }

    public void setNumberOfReleases(int numberOfReleases) {
	this.numberOfReleases = numberOfReleases;
    }

    public Set<Employee> getEmployees() {
	if (employees == null)
	    employees = new HashSet<Employee>();

	return employees;
    }

    @Transient
    public Long getId() {
	return Long.valueOf(this.project_id);
    }

    @Transient
    public String getAuditDetail() {
	StringBuilder sb = new StringBuilder();
	sb.append(" project_id : ").append(project_id).append("   projectName : ").append(projectName).append("  timeLine : ").append(timeLine);

	return sb.toString();
    }
}
