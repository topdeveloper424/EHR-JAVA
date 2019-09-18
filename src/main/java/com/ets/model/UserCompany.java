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
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

@Entity
@Table(name = "user_company")

public class UserCompany {
	
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
		private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

		@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

		// Column 4
		private SimpleBooleanProperty accessLevel = new SimpleBooleanProperty(this, "accessLevel");

		@Column(name = "access_level")
		public boolean getAccessLevel() {
			return accessLevel.get();
		}

		public void setAccessLevel(boolean accessLevel) {
			this.accessLevel.set(accessLevel);
		}

		public BooleanProperty accessLevelProperty() {
			return accessLevel;
		}

	public UserCompany() {
		// TODO Auto-generated constructor stub
	}

}
