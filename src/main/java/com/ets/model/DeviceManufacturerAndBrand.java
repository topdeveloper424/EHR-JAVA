package com.ets.model;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SharpDeviceManufacAndBrand Class
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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "sharp_mfd_or_brand")

public class DeviceManufacturerAndBrand {
	

	private  IntegerProperty id = new SimpleIntegerProperty(this, "id");
	
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


	private  StringProperty mfd = new SimpleStringProperty(this, "mfd");

	@Column(name = "mfd")
	public  String getMfd(){
		return mfd.get();
	}
	
	public  void setMfd(String mfd){
		this.mfd.set(mfd);
	}
	
	public StringProperty mfdProperty(){
		return mfd;
	}
	
	

	private  StringProperty brand = new SimpleStringProperty(this, "brand");

	@Column(name = "brand")
	public  String getBrand(){
		return brand.get();
	}
	
	public  void setBrand(String brand){
		this.brand.set(brand);
	}
	
	public StringProperty brandProperty(){
		return brand;
	}
	

	private  SimpleBooleanProperty inactive = new SimpleBooleanProperty(
			this, "inactive");

	@Column(name = "inactive")
	public  boolean getInactive() {
		return inactive.get();
	}

	public  void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}

	public DeviceManufacturerAndBrand() {
		
	}
	
}
