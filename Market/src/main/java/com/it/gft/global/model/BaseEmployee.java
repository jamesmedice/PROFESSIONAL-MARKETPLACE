package com.it.gft.global.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public abstract class BaseEmployee implements Serializable {

    private static final long serialVersionUID = 20251502L;

    private String profile_name;

    private BigDecimal salary;

    private Date initDate;

    private int level;

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
}
