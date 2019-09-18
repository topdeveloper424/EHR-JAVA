package com.ets.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 09-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Role Class
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
@Table(name = "role")

public class Role {
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
	private  StringProperty name = new SimpleStringProperty(this,"name");

	@Column(name = "name")
	public  String getName(){
		return name.get();
	}

	public void setName(String name){
		this.name.set(name);
	}

	public StringProperty nameProperty(){
		return name;
	}


	// Column 3
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


	// Column 4
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
	
	// Column 5
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


	// Column 6
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

	// Column 7
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
	
	// Column 8
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


	public Role() {

	}

	
	
}