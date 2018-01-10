package com.it.gft.global.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "OAUTH_DETAILS")
public class OauthDetails implements Serializable {

    @Id
    @Column(name = "username")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String username;

    @Column(name = "password")
    private String password;

    public String getUsername() {
	return username;
    }

    public String getPassword() {
	return password;
    }

    public void setUsername(String username) {
	this.username = username;
    }

    public void setPassword(String password) {
	this.password = password;
    }

}
