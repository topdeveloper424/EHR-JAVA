package com.ets.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 29-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedActResultCode Class
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
@Table(name = "med_act_billing")

public class MedActBilling {

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
	private SimpleBooleanProperty noChargeItem = new SimpleBooleanProperty(this, "noChargeItem");

	@Column(name = "no_charge_item")
	public boolean getNoChargeItem() {
		return noChargeItem.get();
	}

	public void setNoChargeItem(boolean noChargeItem) {
		this.noChargeItem.set(noChargeItem);
	}

	public BooleanProperty noChargeItemProperty() {
		return noChargeItem;
	}


	// Collumn 3
	private StringProperty employerChargeCurrent = new SimpleStringProperty(this, "employerChargeCurrent");

	@Column(name = "employer_charge_current")
	public String getEmployerChargeCurrent() {
		return employerChargeCurrent.get();
	}

	public void setEmployerChargeCurrent(String employerChargeCurrent) {
		this.employerChargeCurrent.set(employerChargeCurrent);
	}

	public StringProperty employerChargeCurrentProperty() {
		return employerChargeCurrent;
	}

	// Collumn 4
	private ObjectProperty<Date> employerChargeEffective = new SimpleObjectProperty<Date>();

	@Column(name = "employer_charge_effective")
	@Temporal(TemporalType.DATE)
	public Date getEmployerChargeEffective() {
		return employerChargeEffective.get();
	}

	public void setEmployerChargeEffective(Date employerChargeEffective) {
		this.employerChargeEffective.set(employerChargeEffective);
	}

	private ObjectProperty<Date> employerChargeEffectiveProperty() {
		return this.employerChargeEffective;
	}

	// Collumn 5
	private StringProperty employerChargeFuture = new SimpleStringProperty(this, "employerChargeFuture");

	@Column(name = "employer_charge_future")
	public String getEmployerChargeFuture() {
		return employerChargeFuture.get();
	}

	public void setEmployerChargeFuture(String employerChargeFuture) {
		this.employerChargeFuture.set(employerChargeFuture);
	}

	public StringProperty employerChargeFutureProperty() {
		return employerChargeFuture;
	}

	// Collumn 6
	private ObjectProperty<Date> employerChargeFutureEffective = new SimpleObjectProperty<Date>();

	@Column(name = "employer_charge_future_effective")
	@Temporal(TemporalType.DATE)
	public Date getEmployerChargeFutureEffective() {
		return employerChargeFutureEffective.get();
	}

	public void setEmployerChargeFutureEffective(Date employerChargeFutureEffective) {
		this.employerChargeFutureEffective.set(employerChargeFutureEffective);
	}

	private ObjectProperty<Date> employerChargeFutureEffectiveProperty() {
		return this.employerChargeFutureEffective;
	}

	// Column 7
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
	
	
	private List<MedicalActivity> medicalActivities;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="billingServiceType" , cascade=CascadeType.ALL)	
	public List<MedicalActivity> getMedicalActivities() {
		return medicalActivities;
	}

	public void setMedicalActivities(List<MedicalActivity> medicalActivities) {
		this.medicalActivities = medicalActivities;
	}

	public MedActBilling() {
		// TODO Auto-generated constructor stub
	}

}
