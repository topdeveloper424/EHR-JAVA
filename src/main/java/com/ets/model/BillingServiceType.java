package com.ets.model;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingServiceType Class
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

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name="billing_service_type")

public class BillingServiceType {
	
	/***************
	 * Column property ( 1 )
	 *****************************************/

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
	
	/***************
	 * Column property (  )
	 *****************************************/
	
private  StringProperty service = new SimpleStringProperty(this, "service");
	
	@Column(name = "service")
	public  String getService(){
		return service.get();
	}
	
	public  void setService(String service){
		this.service.set(service);
		
	}
	
	public StringProperty serviceProperty(){
		return service;
	}

	/***************
	 * Column property ( 3 )
	 *****************************************/
	
private  StringProperty descrip = new SimpleStringProperty(this, "descrip");
	
	@Column(name = "descrip")
	public  String getDescrip(){
		return descrip.get();
	}
	
	public  void setDescrip(String descrip){
		this.descrip.set(descrip);
		
	}
	
	public StringProperty descripProperty(){
		return descrip;
	}
	
	/***************
	 * Column property ( 4 )
	 *****************************************/
	
	private  StringProperty billing_type = new SimpleStringProperty(this, "billing_type");
	
	@Column(name = "billing_type")
	public  String getBilling_type(){
		return billing_type.get();
	}
	
	public  void setBilling_type(String billing_type){
		this.billing_type.set(billing_type);
		
	}
	
	public StringProperty billing_typeProperty(){
		return billing_type;
	}
	
	/***************
	 * Column property ( 5 )
	 *****************************************/
	
private  SimpleBooleanProperty inactive=new SimpleBooleanProperty(this ,"inactive");
	
	@Column(name = "inactive")
	public  boolean getInactive() {
		return inactive.get();
	}

	public  void setInactive(boolean inactive) {
		this.inactive.set(inactive);
		//this.inactive = inactive ;
	}
	
	public BooleanProperty inactiveProperty() {
		return inactive;
	}
	
	private List<VisitCategory> visitCategory;

	@OneToMany(fetch = FetchType.LAZY , mappedBy="billingServiceType" , cascade=CascadeType.ALL)
	public List<VisitCategory> getVisitCategory() {
		return visitCategory;
	}

	public void setVisitCategory(List<VisitCategory> visitCategory) {
		this.visitCategory = visitCategory;
	}
	
	private List<MedActBilling> medActBillings;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="billingServiceType" , cascade=CascadeType.ALL)
	public List<MedActBilling> getMedActBillings() {
		return medActBillings;
	}

	public void setMedActBillings(List<MedActBilling> medActBillings) {
		this.medActBillings = medActBillings;
	}
	
	

}
