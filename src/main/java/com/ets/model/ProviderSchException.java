package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderSchException Class
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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "provider_sch_exception")

public class ProviderSchException {

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

	private SimpleObjectProperty<Provider> provider = new SimpleObjectProperty<Provider>(this, "provider");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "provider_id")
	public Provider getProvider() {
		return provider.get();
	}

	public void setProvider(Provider provider) {
		this.provider.set(provider);
	}

	public SimpleObjectProperty<Provider> providerProperty() {
		return provider;
	}

	/*private StringProperty weekday = new SimpleStringProperty(this, "weekday");

	@Column(name = "weekday")
	public String getWeekday() {
		return weekday.get();
	}

	public void setWeekday(String weekday) {
		this.weekday.set(weekday);
	}

	public StringProperty weekdayProperty() {
		return weekday;
	}*/

	// Column 2
	private ObjectProperty<Date> excepDate = new SimpleObjectProperty<Date>();

	@Column(name = "excep_date")
	@Temporal(TemporalType.DATE)
	public Date getExcepDate() {
		return excepDate.get();
	}

	public void setExcepDate(Date excepDate) {
		this.excepDate.set(excepDate);
	}

	public ObjectProperty<Date> excepDateDateProperty() {
		return this.excepDate;
	}

	public ProviderSchException() {

	}

}
