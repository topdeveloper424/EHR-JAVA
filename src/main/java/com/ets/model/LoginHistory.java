package com.ets.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 09-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Logins Class
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
@Table(name = "login_history")

public class LoginHistory {
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


	// Column 3
	private ObjectProperty<Date> entryTime = new SimpleObjectProperty<Date>();

	@Column(name = "entry_time")
	@Temporal(TemporalType.TIME)
	public Date getEntryTime() {
		return entryTime.get();
	}

	public void setEntryTime(Date entryTime ) {
		this.entryTime.set(entryTime);
	}

	public ObjectProperty<Date> entryTimeProperty() {
		return this.entryTime;
	}
	
	// Column 4
		private ObjectProperty<Date> entryDate = new SimpleObjectProperty<Date>();

		@Column(name = "entry_date")
		@Temporal(TemporalType.DATE)
		public Date getEntryDate() {
			return entryDate.get();
		}

		public void setEntryDate(Date entryDate ) {
			this.entryDate.set(entryDate);
		}

		public ObjectProperty<Date> entryDateProperty() {
			return this.entryDate;
		}


	// Column 5
	private SimpleBooleanProperty status = new SimpleBooleanProperty(this, "status");

	@Column(name = "status")
	public boolean getStatus() {
		return status.get();
	}

	public void setStatus(boolean status) {
		this.status.set(status);
	}

	public BooleanProperty statusProperty() {
		return status;
	}
	
	

	public LoginHistory() {

	}
}