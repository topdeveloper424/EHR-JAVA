package com.ets.model;


/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientInsuranceCarrier Class
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


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "patient_insurance_carrier")


public class PatientInsuranceCarrier {

	/***************
	 * Column property ( 1 )
	 *****************************************/

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
	private StringProperty planType = new SimpleStringProperty(this, "planType");

	@Column(name = "plan_type")
	public String getPlanType() {
		return planType.get();
	}

	public void setPlanType(String planType) {
		this.planType.set(planType);
	}

	public StringProperty planTypeProperty() {
		return planType;
	}

	// Column 12
	private ObjectProperty<Date> dateExpiry = new SimpleObjectProperty<Date>();

	@Column(name = "date_expiry")
	@Temporal(TemporalType.DATE)
	public Date getDateExpiry() {

		return dateExpiry.get();

	}

	public void setDateExpiry(Date dateExpiry) {

		this.dateExpiry.set(dateExpiry);

	}

	public ObjectProperty<Date> dateExpiryProperty() {

		return this.dateExpiry;

	}

	// Column 12
	private ObjectProperty<Date> dateEffective = new SimpleObjectProperty<Date>();

	@Column(name = "date_effective")
	@Temporal(TemporalType.DATE)
	public Date getDateEffective() {

		return dateEffective.get();

	}

	public void setDateEffective(Date dateEffective) {

		this.dateEffective.set(dateEffective);

	}

	public ObjectProperty<Date> dateEffectiveProperty() {

		return this.dateEffective;

	}

	// Column 2
	private StringProperty planName = new SimpleStringProperty(this, "planName");

	@Column(name = "plan_name")
	public String getPlanName() {
		return planName.get();
	}

	public void setPlanName(String planName) {
		this.planName.set(planName);
	}

	public StringProperty planNameProperty() {
		return planName;
	}

	// Column 2
	private StringProperty employerName = new SimpleStringProperty(this, "employerName");

	@Column(name = "employer_name")
	public String getEmployerName() {
		return employerName.get();
	}

	public void setEmployerName(String employerName) {
		this.employerName.set(employerName);
	}

	public StringProperty employerNameProperty() {
		return employerName;
	}

	private StringProperty policyOrGroup = new SimpleStringProperty(this, "policyOrGroup");

	@Column(name = "policy_or_group")
	public String getPolicyOrGroup() {
		return policyOrGroup.get();
	}

	public void setPolicyOrGroup(String policyOrGroup) {
		this.policyOrGroup.set(policyOrGroup);
	}

	public StringProperty policyOrGroupProperty() {
		return policyOrGroup;
	}

	private StringProperty copayAmt = new SimpleStringProperty(this, "copayAmt");

	@Column(name = "copay_amt")
	public String getCopayAmt() {
		return copayAmt.get();
	}

	public void setCopayAmt(String copayAmt) {
		this.copayAmt.set(copayAmt);
	}

	public StringProperty copayAmtProperty() {
		return copayAmt;
	}

	private StringProperty coverPercent = new SimpleStringProperty(this, "coverPercent");

	@Column(name = "cover_percent")
	public String getCoverPercent() {
		return coverPercent.get();
	}

	public void setCoverPercent(String coverPercent) {
		this.coverPercent.set(coverPercent);
	}

	public StringProperty coverPercentProperty() {
		return coverPercent;
	}

	private StringProperty deductAmt = new SimpleStringProperty(this, "deductAmt");

	@Column(name = "deduct_amt")
	public String getDeductAmt() {
		return deductAmt.get();
	}

	public void setDeductAmt(String deductAmt) {
		this.deductAmt.set(deductAmt);
	}

	public StringProperty deductAmtProperty() {
		return deductAmt;
	}
	
	private StringProperty deductMet = new SimpleStringProperty(this, "deductMet");

	@Column(name = "deduct_met")
	public String getDeductMet() {
		return deductMet.get();
	}

	public void setDeductMet(String deductMet) {
		this.deductMet.set(deductMet);
	}

	public StringProperty deductMetProperty() {
		return deductMet;
	}

	// Column 13
	private SimpleObjectProperty<Carrier> carrier = new SimpleObjectProperty<Carrier>(this, "address");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "carrier_id")
	public Carrier getCarrier() {
		return carrier.get();
	}

	public void setCarrier(Carrier carrier) {
		this.carrier.set(carrier);
	}

	public SimpleObjectProperty<Carrier> carrierProperty() {
		return carrier;
	}

	public PatientInsuranceCarrier() {

	}

}
