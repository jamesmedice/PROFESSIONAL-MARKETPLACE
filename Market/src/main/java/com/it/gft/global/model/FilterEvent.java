package com.it.gft.global.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
public class FilterEvent implements Serializable {

    private static final long serialVersionUID = -4632082388365582828L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "eventdoc")
    private String eventdoc;

    public int getId() {
	return id;
    }

    public String getEventdoc() {
	return eventdoc;
    }

    public void setEventdoc(String eventdoc) {
	this.eventdoc = eventdoc;
    }

}
