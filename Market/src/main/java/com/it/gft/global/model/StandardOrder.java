package com.it.gft.global.model;

import java.io.Serializable;

/**
 * 
 * @author TOSS
 *
 */
public class StandardOrder implements Serializable {

    private static final long serialVersionUID = 1251288170488336427L;

    private Boolean order;

    private String name;

    public Boolean getOrder() {
	return order;
    }

    public String getName() {
	return name;
    }

    public void setOrder(Boolean order) {
	this.order = order;
    }

    public void setName(String name) {
	this.name = name;
    }

}
