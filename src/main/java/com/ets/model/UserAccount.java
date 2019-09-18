package com.ets.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 09-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of UserAccount Class
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
@Table(name = "user_account")

public class UserAccount {
	
	private static final Map<String, UserAccount> USERS = new HashMap<String, UserAccount>();
	
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

	/*
	private StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public String getCode() {
		return code.get();
	}

	public void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
	}
	*/

	// Column 2
	private StringProperty firstName = new SimpleStringProperty(this, "firstName");

	@Column(name = "first_name")
	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return firstName;
	}

	// Column 3
	private StringProperty middleName = new SimpleStringProperty(this, "middleName");

	@Column(name = "middle_name")
	public String getMiddleName() {
		return middleName.get();
	}

	public void setMiddleName(String middleName) {
		this.middleName.set(middleName);
	}

	public StringProperty middleNameProperty() {
		return middleName;
	}

	// Column 4
	private StringProperty lastName = new SimpleStringProperty(this, "lastName");

	@Column(name = "last_name")
	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return lastName;
	}
	
	// Column 5
		private StringProperty suffix = new SimpleStringProperty(this, "suffix");

		@Column(name = "suffix")
		public String getSuffix() {
			return suffix.get();
		}

		public void setSuffix(String suffix) {
			this.suffix.set(suffix);
		}

		public StringProperty suffixProperty() {
			return suffix;
		}

	// Column 6
	private StringProperty userName = new SimpleStringProperty(this, "userName");

	@Column(name = "user_name")
	public String getUserName() {
		return userName.get();
	}

	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	public StringProperty userNameProperty() {
		return userName;
	}


	// Column 7
	private StringProperty password = new SimpleStringProperty(this, "password");

	@Column(name = "password")
	public String getPassword() {
		return password.get();
	}

	public void setPassword(String password) {
		this.password.set(password);
	}

	public StringProperty passwordProperty() {
		return password;
	}

	// Column 8
	private StringProperty salt = new SimpleStringProperty(this, "salt");

	@Column(name = "salt")
	public String getSalt() {
		return salt.get();
	}

	public void setSalt(String salt) {
		this.salt.set(salt);
	}

	public StringProperty saltProperty() {
		return salt;
	}

	// Column 9
	private ObjectProperty<Date> passwordLastChanged = new SimpleObjectProperty<Date>();

	@Column(name = "password_last_changed")
	public Date getPasswordLastChanged() {
		return passwordLastChanged.get();
	}

	public void setPasswordLastChanged(Date passwordLastChanged) {
		this.passwordLastChanged.set(passwordLastChanged);
	}

	private ObjectProperty<Date> passwordLastChangedProperty() {
		return this.passwordLastChanged;
	}

	// Column 10
	
	private SimpleBooleanProperty passwordExpire = new SimpleBooleanProperty(this, "passwordExpire");

	@Column(name = "password_expire")
	public boolean getPasswordExpire() {
		return passwordExpire.get();
	}

	public void setPasswordExpire(boolean passwordExpire ) {
		this.passwordExpire.set(passwordExpire);
	}

	public BooleanProperty passwordExpireProperty() {
		return passwordExpire;
	}

	// Column 11
	private ObjectProperty<Date> passwordExpiresOn = new SimpleObjectProperty<Date>();

	@Column(name = "password_expires_on")
	public Date getPasswordExpiresOn() {
		return passwordExpiresOn.get();
	}

	public void setPasswordExpiresOn(Date passwordExpiresOn ) {
		this.passwordExpiresOn.set( passwordExpiresOn );
	}

	private ObjectProperty<Date> passwordExpiresOnProperty() {
		return this.passwordExpiresOn;
	}


	// Column 12
	private StringProperty jobTitle = new SimpleStringProperty(this, "jobTitle");

	@Column(name = "job_title")
	public String getJobTitle() {
		return jobTitle.get();
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle.set(jobTitle);
	}

	public StringProperty jobTitleProperty() {
		return jobTitle;
	}

	// Column 13
	private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	public Address getAddress() {
		return address.get();
	}

	public void setAddress(Address address) {
		this.address.set(address);
	}

	public SimpleObjectProperty<Address> addressProperty() {
		return address;
	}
	
	

	// Column 14
	private SimpleBooleanProperty suspended = new SimpleBooleanProperty(this, "suspended");

	@Column(name = "suspended")
	public boolean getSuspended() {
		return suspended.get();
	}

	public void setSuspended(boolean suspended) {
		this.suspended.set(suspended);
	}

	public BooleanProperty suspendedProperty() {
		return suspended;
	}

	// Column 15
	private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}

	// Column 16
	private StringProperty createdBy = new SimpleStringProperty(this, "createdBy");

	@Column(name = "created_by")
	public String getCreatedBy() {
		return createdBy.get();
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy.set(createdBy);
	}

	public StringProperty createdByProperty() {
		return createdBy;
	}

	// Column 17
	private ObjectProperty<Date> createdAtDate = new SimpleObjectProperty<Date>();

	@Column(name = "created_at_date")
	@Temporal(TemporalType.DATE)
	public Date getCreatedAtDate() {
		return createdAtDate.get();
	}

	public void setCreatedAtDate(Date createdAtDate) {
		this.createdAtDate.set(createdAtDate);
	}

	private ObjectProperty<Date> createdAtDateProperty() {
		return createdAtDate;
	}
	
	// Column 18
		private ObjectProperty<Date> createdAtTime = new SimpleObjectProperty<Date>();

		@Column(name = "created_at_time")
		@Temporal(TemporalType.TIME)
		public Date getCreatedAtTime() {
			return createdAtTime.get();
		}

		public void setCreatedAtTime(Date createdAtTime) {
			this.createdAtTime.set(createdAtTime);
		}

		private ObjectProperty<Date> createdAtTimeProperty() {
			return createdAtTime;
		}

	// Column 19
	private StringProperty updatedBy = new SimpleStringProperty(this, "updatedBy");

	@Column(name = "updated_by")
	public String getUpdatedBy() {
		return updatedBy.get();
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy.set(updatedBy);
	}

	public StringProperty updatedByProperty() {
		return updatedBy;
	}

	// Column 20
	private ObjectProperty<Date> updatedAtDate = new SimpleObjectProperty<Date>();

	@Column(name = "updated_at_date")
	public Date getUpdatedAtDate() {
		return updatedAtDate.get();
	}

	public void setUpdatedAtDate(Date updatedAtDate) {
		this.updatedAtDate.set(updatedAtDate);
	}

	private ObjectProperty<Date> updatedAtDateProperty() {
		return updatedAtDate;
	}

	// Column 21
	private ObjectProperty<Date> updatedAtTime = new SimpleObjectProperty<Date>();

	@Column(name = "updated_at_time")
	public Date getUpdatedAtTime() {
		return updatedAtTime.get();
	}

	public void setUpdatedAtTime(Date updatedAtTime) {
		this.updatedAtTime.set(updatedAtTime);
	}

	private ObjectProperty<Date> updatedAtTimeProperty() {
		return updatedAtTime;
	}

	// Column 22
	private StringProperty roleName = new SimpleStringProperty(this, "roleName");

	@Column(name = "role_name")
	public String getRoleName() {
		return roleName.get();
	}

	public void setRoleName(String roleName) {
		this.roleName.set(roleName);
	}

	public StringProperty roleNameProperty() {
		return roleName;
	}

	// Column 23
	private SimpleBooleanProperty loginStatus = new SimpleBooleanProperty(this, "loginStatus");

	@Column(name = "login_status")
	public boolean getLoginStatus() {
		return loginStatus.get();
	}

	public void setLoginStatus(boolean loginStatus) {
		this.loginStatus.set(loginStatus);
	}

	public BooleanProperty loginStatusProperty() {
		return loginStatus;
	}

	// Column 24
	private SimpleBooleanProperty admin = new SimpleBooleanProperty(this, "admin");

	@Column(name = "admin")
	public boolean getAdmin() {
		return admin.get();
	}

	public void setAdmin(boolean admin) {
		this.admin.set(admin);
	}

	public BooleanProperty adminProperty() {
		return admin;
	}

	private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinic_id")
	public Clinic getClinic() {
		return clinic.get();
	}

	public void setClinic(Clinic clinic) {
		this.clinic.set(clinic);
	}

	public SimpleObjectProperty<Clinic> clinicProperty() {
		return clinic;
	}
	
	private List<LoginHistory> loginHistories;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="userAccount" , cascade=CascadeType.ALL)
	public List<LoginHistory> getLoginHistories() {
		return loginHistories;
	}

	public void setLoginHistories(List<LoginHistory> loginHistories) {
		this.loginHistories = loginHistories;
	}
	
	private List<LoginSchedule> loginSchedules;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="userAccount" , cascade=CascadeType.ALL)
	public List<LoginSchedule> getLoginSchedules() {
		return loginSchedules;
	}

	public void setLoginSchedules(List<LoginSchedule> loginSchedules) {
		this.loginSchedules = loginSchedules;
	}

	public UserAccount() {

	}

	public UserAccount(Integer id, String firstName, String middleName, String lastName, String suffix, String userName,
			String password, String salt, Date passwordLastChanged, Boolean passwordExpire, Date passwordExpiresOn,
			String jobTitle, Address address, Boolean suspended, Boolean inactive, String createdBy, Date createdAtDate,
			Date createdAtTime, String updatedBy, Date updatedAtDate, Date updatedAtTime, String roleName,
			Boolean loginStatus, Boolean admin) {

		this.id = new SimpleIntegerProperty(id);
		;
		this.firstName = new SimpleStringProperty(firstName);
		;
		this.middleName = new SimpleStringProperty(middleName);
		;
		this.lastName = new SimpleStringProperty(lastName);
		;
		this.suffix = new SimpleStringProperty(suffix);
		;
		this.userName = new SimpleStringProperty(userName);
		;
		this.password = new SimpleStringProperty(password);
		;
		this.salt = new SimpleStringProperty(salt);
		this.passwordLastChanged = new SimpleObjectProperty<Date>(passwordLastChanged);
		;
		this.passwordExpire = new SimpleBooleanProperty(passwordExpire);
		;
		this.passwordExpiresOn = new SimpleObjectProperty<Date>(passwordExpiresOn);
		;
		this.jobTitle = new SimpleStringProperty(jobTitle);
		;
		this.address = new SimpleObjectProperty<Address>(address);
		;
		this.suspended = new SimpleBooleanProperty(suspended);
		;
		this.inactive = new SimpleBooleanProperty(inactive);
		;
		this.createdBy = new SimpleStringProperty(createdBy);
		;
		this.createdAtDate = new SimpleObjectProperty<Date>(createdAtDate);
		;
		this.createdAtTime = new SimpleObjectProperty<Date>(createdAtTime);
		;
		this.updatedBy = new SimpleStringProperty(updatedBy);
		;
		this.updatedAtDate = new SimpleObjectProperty<Date>(updatedAtDate);
		;
		this.updatedAtTime = new SimpleObjectProperty<Date>(updatedAtTime);
		;
		this.roleName = new SimpleStringProperty(roleName);
		;
		this.loginStatus = new SimpleBooleanProperty(loginStatus);
		;
		this.admin = new SimpleBooleanProperty(admin);
		;
	}

}