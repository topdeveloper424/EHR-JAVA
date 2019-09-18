package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientName Class
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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "patient_name")

public class PatientName {
	
	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

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
						private StringProperty nickName = new SimpleStringProperty(this, "nickName");

						@Column(name = "nick_name")
						public String getNickName() {
							return nickName.get();
						}

						public void setNickName(String nickName) {
							this.nickName.set(nickName);
						}

						public StringProperty nickNameProperty() {
							return nickName;
						}
						
						// Column 7
						private StringProperty nickNamePrefix = new SimpleStringProperty(this, "nickNamePrefix");

						@Column(name = "nickname_prefix")
						public String getNickNamePrefix() {
							return nickNamePrefix.get();
						}

						public void setNickNamePrefix(String nickNamePrefix) {
							this.nickNamePrefix.set(nickNamePrefix);
						}

						public StringProperty nickNamePrefixProperty() {
							return nickNamePrefix;
						}
						
						// Column 7
						private StringProperty aliasFirstName = new SimpleStringProperty(this, "aliasFirstName");

						@Column(name = "alias_first_name")
						public String getAliasFirstName() {
							return aliasFirstName.get();
						}

						public void setAliasFirstName(String aliasFirstName) {
							this.aliasFirstName.set(aliasFirstName);
						}

						public StringProperty aliasFirstNameProperty() {
							return aliasFirstName;
						}
						
						// Column 7
						private StringProperty aliasLastName = new SimpleStringProperty(this, "aliasLastName");

						@Column(name = "aliasLastName")
						public String getAliasLastName() {
							return aliasFirstName.get();
						}

						public void setAliasLastName(String aliasLastName) {
							this.aliasLastName.set(aliasLastName);
						}

						public StringProperty aliasLastNameProperty() {
							return aliasLastName;
						}

	public PatientName() {
		
	}

}
