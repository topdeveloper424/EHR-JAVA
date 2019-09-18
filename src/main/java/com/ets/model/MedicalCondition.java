package com.ets.model;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
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

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 17-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalCondition Class
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
 *
 **/

@Entity
@Table(name="medical_condition")

public class MedicalCondition {
	
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
	 * Column property ( 2 )
	 *****************************************/

	private  StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public  String getCode() {
		return code.get();
	}

	public  void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
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
	
	private  StringProperty type = new SimpleStringProperty(this, "type");
	
	@Column(name = "type")
	public  String getType(){
		return type.get();
	}
	
	public  void setType(String type){
		this.type.set(type);
		
	}
	
	public StringProperty typeProperty(){
		return type;
	}
	
private  StringProperty security = new SimpleStringProperty(this, "security");
	
	@Column(name = "security")
	public  String getSecurity(){
		return security.get();
	}
	
	public  void setSecurity(String security){
		this.security.set(security);
		
	}
	
	public StringProperty securityProperty(){
		return security;
	}
	
	private SimpleObjectProperty<MedicalActivity> vaccine = new SimpleObjectProperty<MedicalActivity>(this, "vaccine");

	@ManyToOne
	@JoinColumn(name = "vaccine_id")
	public MedicalActivity getVaccine() {
		return vaccine.get();
	}

	public void setVaccine(MedicalActivity vaccine) {
		this.vaccine.set(vaccine);
	}

	public SimpleObjectProperty<MedicalActivity> vaccineProperty() {
		return vaccine;
	}
	
	
	private SimpleObjectProperty<MedicalActivity> secondVaccine = new SimpleObjectProperty<MedicalActivity>(this, "secondVaccine");

	@ManyToOne
	@JoinColumn(name = "second_vaccine_id")
	public MedicalActivity getSecondVaccine() {
		return secondVaccine.get();
	}

	public void setSecondVaccine(MedicalActivity secondVaccine) {
		this.secondVaccine.set(secondVaccine);
	}

	public SimpleObjectProperty<MedicalActivity> secondVaccineProperty() {
		return secondVaccine;
	}
	
	private SimpleObjectProperty<MedicalActivity> immuneTest = new SimpleObjectProperty<MedicalActivity>(this, "immuneTest");

	@ManyToOne
	@JoinColumn(name = "immune_test_id")
	public MedicalActivity getImmuneTest() {
		return immuneTest.get();
	}

	public void setImmuneTest(MedicalActivity immuneTest) {
		this.immuneTest.set(immuneTest);
	}

	public SimpleObjectProperty<MedicalActivity> immuneTestProperty() {
		return immuneTest;
	}
	
	private SimpleObjectProperty<MedicalActivity> diagTest = new SimpleObjectProperty<MedicalActivity>(this, "diagTest");

	@ManyToOne
	@JoinColumn(name = "diag_test_id")
	public MedicalActivity getDiagTest() {
		return diagTest.get();
	}

	public void setDiagTest(MedicalActivity diagTest) {
		this.diagTest.set(diagTest);
	}

	public SimpleObjectProperty<MedicalActivity> diagTestProperty() {
		return diagTest;
	}
	
private  SimpleBooleanProperty infectious=new SimpleBooleanProperty(this ,"infectious");
	
	@Column(name = "infectious")
	public  boolean getInfectious() {
		return infectious.get();
	}

	public  void setInfectious(boolean infectious) {
		this.infectious.set(infectious);
		
	}
	
	public BooleanProperty infectiousProperty() {
		return infectious;
	}
	
private  SimpleBooleanProperty oshaRecordable=new SimpleBooleanProperty(this ,"oshaRecordable");
	
	@Column(name = "osha_recordable")
	public  boolean getOshaRecordable() {
		return oshaRecordable.get();
	}

	public  void setOshaRecordable(boolean oshaRecordable) {
		this.oshaRecordable.set(oshaRecordable);
		
	}
	
	public BooleanProperty oshaRecordableProperty() {
		return oshaRecordable;
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

	public MedicalCondition() {
		
	}

}
