package com.ets.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 09-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Access Class
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


@Entity
@Table(name = "access")

public class Access {
	// Column 1
	private IntegerProperty id = new SimpleIntegerProperty();
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


	// Column 2
	private SimpleObjectProperty<Role> role = new SimpleObjectProperty<Role>(this, "role");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "role_id")
	public Role getRole() {
		return role.get();
	}

	public void setRole(Role role) {
		this.role.set(role);
	}

	public SimpleObjectProperty<Role> roleProperty() {
			return role;
	}


	// Column 3
	private  StringProperty level = new SimpleStringProperty(this,"level");

	@Column(name = "level")
	public  String getLevel(){
		return level.get();
	}

	public void setLevel(String level){
		this.level.set(level);
	}

	public StringProperty levelProperty(){
		return level;
	}


	// Column 4
	private IntegerProperty tableGroupId = new SimpleIntegerProperty();
	
	@JoinColumn(name = "table_group_id")
	public Integer getTableGroupId() {
		return tableGroupId.get();
	}

	public void setTableGroupId(Integer tableGroupId) {
		this.tableGroupId.set(tableGroupId);
	}

	public IntegerProperty tableGroupIdProperty() {
		return this.tableGroupId;
	}
	
	// Column 4
	
	private SimpleObjectProperty<UserAccount> userAccount = new SimpleObjectProperty<UserAccount>(this, "userAccount");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_acount_id")
	public UserAccount getUserAccount() {
		return userAccount.get();
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount.set(userAccount);
	}

	public SimpleObjectProperty<UserAccount> userAcountProperty() {
		return userAccount;
	}


	public Access() {

	}
}