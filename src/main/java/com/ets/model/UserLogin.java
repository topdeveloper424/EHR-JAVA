package com.ets.model;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserLogin Class
 *Description: Entity class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "user_login")

public class UserLogin {
	private static final Map<String, UserLogin> USERS = new HashMap<String, UserLogin>();
	private Integer id;
	private String name;
	private String password;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public UserLogin() {
		
	}
	public UserLogin(String name) {
		
		this.name = name;
	}
	public static UserLogin of(String name) {
		UserLogin login = USERS.get(name);
		
        if (login == null) {
        	login = new UserLogin(name);
            USERS.put(name, login);
        }
        return login;
		
	}
	
	
/*private  IntegerProperty id = new SimpleIntegerProperty();
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	public Integer getId() {
		return id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public IntegerProperty idProperty() {
		return this.id;
	}
	
	private  StringProperty name = new SimpleStringProperty(this, "name");

	@Column(name = "name")
	public  String getName() {
		return name.get();
	}

	public  void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}
	
	private  StringProperty password = new SimpleStringProperty(this, "password");
	
	@Column(name = "password")
	public  String getPassword() {
		return password.get();
	}

	public  void setPassword(String password) {
		this.password.set(password);
	}

	public StringProperty passwordProperty() {
		return password;
	}

	public UserLogin() {
		
	}*/
	
	

}
