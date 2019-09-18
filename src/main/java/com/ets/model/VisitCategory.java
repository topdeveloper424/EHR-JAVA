package com.ets.model;

import java.util.List;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 05-09-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitCategory Class
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
@Table(name="visit_category")

public class VisitCategory {
	
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
	
	private  StringProperty entryType = new SimpleStringProperty(this, "entryType");
	
	@Column(name = "entry_type")
	public  String getEntryType(){
		return entryType.get();
	}
	
	public  void setEntryType(String entryType){
		this.entryType.set(entryType);
		
	}
	
	public StringProperty entryTypeProperty(){
		return entryType;
	}
	
	/***************
	 * Column property ( 5 )
	 *****************************************/
	
	private  StringProperty visitType = new SimpleStringProperty(this, "visitType");
	
	@Column(name = "visit_type")
	public  String getVisitType(){
		return visitType.get();
	}
	
	public  void setVisitType(String visitType){
		this.visitType.set(visitType);
		
	}
	
	public StringProperty visitTypeProperty(){
		return visitType;
	}
	
	/***************
	 * Column property ( 6 )
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
	 * Column property ( 7 )
	 *****************************************/
	
	private  StringProperty resultType = new SimpleStringProperty(this, "resultType");
	
	@Column(name = "result_type")
	public  String getResultType(){
		return resultType.get();
	}
	
	public  void setResultType(String resultType){
		this.resultType.set(resultType);
		
	}
	
	public StringProperty resultTypeProperty(){
		return resultType;
	}
	
	/***************
	 * Column property ( 8 )
	 *****************************************/
	
	private  StringProperty minutesReqd = new SimpleStringProperty(this, "minutesReqd");
	
	@Column(name = "minutes_reqd")
	public  String getMinutesReqd(){
		return minutesReqd.get();
	}
	
	public  void setMinutesReqd(String minutesReqd){
		this.minutesReqd.set(minutesReqd);
		
	}
	
	public StringProperty minutesReqdProperty(){
		return minutesReqd;
	}
	
	
	/***************
	 * Column property ( 9 )
	 *****************************************/
	
	private  StringProperty encounterType = new SimpleStringProperty(this, "encounterType");
	
	@Column(name = "encounter_type")
	public  String getEncounterType(){
		return encounterType.get();
	}
	
	public  void setEncounterType(String encounterType){
		this.encounterType.set(encounterType);
		
	}
	
	public StringProperty encounterTypeProperty(){
		return encounterType;
	}
	
	
	/***************
	 * Column property ( 5 )
	 *****************************************/
	
	
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
	
	/***************
	 * Column property ( 10 )
	 *****************************************/
	
private  SimpleBooleanProperty  noChargeVisit =new SimpleBooleanProperty(this ,"noChargeVisit");
	
	@Column(name = "no_charge_visit")
	public  boolean getNoChargeVisit() {
		return noChargeVisit.get();
	}

	public  void setNoChargeVisit(boolean noChargeVisit) {
		this.noChargeVisit.set(noChargeVisit);
		//this.inactive = inactive ;
	}
	
	public BooleanProperty noChargeVisitProperty() {
		return noChargeVisit;
	}
	
	
	/***************
	 * Column property ( 11 )
	 *****************************************/
	
	private SimpleObjectProperty<BillingServiceType> billingServiceType = new SimpleObjectProperty<BillingServiceType>(
			this, "billingServiceType");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_service_type_id")
	public BillingServiceType getBillingServiceType() {
		return billingServiceType.get();
	}

	public void setBillingServiceType(BillingServiceType billingServiceType) {
		this.billingServiceType.set(billingServiceType);
	}

	public SimpleObjectProperty<BillingServiceType> billingServiceTypeProperty() {
		return billingServiceType;
	}
	
	
	
    
	
	/***************
	 * Column property ( 12 )
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
	
	private List<PatientAppointment> patientAppointments;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="visitCatId" , cascade=CascadeType.ALL)
	public List<PatientAppointment> getPatientAppointments() {
		return patientAppointments;
	}

	public void setPatientAppointments(List<PatientAppointment> patientAppointments) {
		this.patientAppointments = patientAppointments;
	}
	
	private List<PatientVisit> patientVisits;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="visitCategory" , cascade=CascadeType.ALL)
	public List<PatientVisit> getPatientVisits() {
		return patientVisits;
	}

	public void setPatientVisits(List<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}
	    private List<CompanyProtocol> companyProtocol ;
		@OneToMany(fetch = FetchType.LAZY , mappedBy="visitCategory" , cascade=CascadeType.ALL)
		public List<CompanyProtocol> getCompanyProtocol() {
			return companyProtocol;
		}

		public void setCompanyProtocol(List<CompanyProtocol> companyProtocol) {
			this.companyProtocol = companyProtocol;
		}
	public VisitCategory() {
		// TODO Auto-generated constructor stub
	}

}
