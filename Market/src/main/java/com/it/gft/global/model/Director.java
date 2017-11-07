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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "GFT_DIRECTOR")
public class Director implements Serializable {

    private static final long serialVersionUID = 20251502L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int director_id;

    private String business_area;

    @JsonIgnore
    @JoinColumn(name = "director_id", referencedColumnName = "director_id")
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Staffing staff;

    public String getBusiness_area() {
	return business_area;
    }

    public Staffing getStaff() {
	return staff;
    }

    public void setBusiness_area(String business_area) {
	this.business_area = business_area;
    }

    public void setStaff(Staffing staff) {
	this.staff = staff;
    }

}
