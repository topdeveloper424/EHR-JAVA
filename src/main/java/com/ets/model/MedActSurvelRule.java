package com.ets.model;

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


/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 29-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedActSurvelRule Class
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
@Table(name = "med_act_survel_rule")


public class MedActSurvelRule {

	// Collumn 1
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

	// Collumn 2
	private StringProperty repeat = new SimpleStringProperty(this, "repeat");

	@Column(name = "repeat1")
	public String getRepeat() {
		return repeat.get();
	}

	public void setRepeat(String repeat) {
		this.repeat.set(repeat);
	}

	public StringProperty repeatProperty() {
		return repeat;
	}

	// Collumn 3
	private StringProperty regularInterval = new SimpleStringProperty(this, "regularInterval");

	@Column(name = "regular_interval")
	public String getRegularInterval() {
		return regularInterval.get();
	}

	public void setRegularInterval(String regularInterval) {
		this.regularInterval.set(regularInterval);
	}

	public StringProperty regularIntervalProperty() {
		return regularInterval;
	}

	// Collumn 4
	private StringProperty frequency = new SimpleStringProperty(this, "frequency");

	@Column(name = "frequency")
	public String getFrequency() {
		return frequency.get();
	}

	public void setFrequency(String frequency) {
		this.frequency.set(frequency);
	}

	public StringProperty frequencyProperty() {
		return frequency;
	}

	// Collumn 5
	private StringProperty uponAge = new SimpleStringProperty(this, "uponAge");

	@Column(name = "uponAge")
	public String getUponAge() {
		return uponAge.get();
	}

	public void setUponAge(String uponAge) {
		this.uponAge.set(uponAge);
	}

	public StringProperty uponAgeProperty() {
		return uponAge;
	}

	// Collumn 6
	private StringProperty stopAtAge = new SimpleStringProperty(this, "stopAtAge");

	@Column(name = "stopAtAge")
	public String getStopAtAge() {
		return stopAtAge.get();
	}

	public void setStopAtAge(String stopAtAge) {
		this.stopAtAge.set(stopAtAge);
	}

	public StringProperty stopAtAgeProperty() {
		return stopAtAge;
	}

	// Collumn 7
	private StringProperty onlyForSex = new SimpleStringProperty(this, "onlyForSex");

	@Column(name = "only_for_sex")
	public String getOnlyForSex() {
		return onlyForSex.get();
	}

	public void setOnlyForSex(String onlyForSex) {
		this.onlyForSex.set(onlyForSex);
	}

	public StringProperty onlyForSexProperty() {
		return onlyForSex;
	}

	// Collumn 8
	private StringProperty onlyForEthnic = new SimpleStringProperty(this, "onlyForEthnic");

	@Column(name = "only_for_ethnic")
	public String getOnlyForEthnic() {
		return onlyForEthnic.get();
	}

	public void setOnlyForEthnic(String onlyForEthnic) {
		this.onlyForEthnic.set(onlyForEthnic);
	}

	public StringProperty onlyForEthnicProperty() {
		return onlyForEthnic;
	}

	public MedActSurvelRule() {
		// TODO Auto-generated constructor stub
	}

}
