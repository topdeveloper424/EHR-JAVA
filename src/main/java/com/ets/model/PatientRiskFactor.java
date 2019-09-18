package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientRiskFactor Class
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;



import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "patient_risk_factor")

public class PatientRiskFactor {
	
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
			private StringProperty countryOfOrigin = new SimpleStringProperty(this, "countryOfOrigin");

			@Column(name = "country_of_origin")
			public String getCountryOfOrigin() {
				return countryOfOrigin.get();
			}

			public void setCountryOfOrigin(String countryOfOrigin) {
				this.countryOfOrigin.set(countryOfOrigin);
			}

			public StringProperty countryOfOriginProperty() {
				return countryOfOrigin;
			}
			
			private ObjectProperty<Date> usaEntryDate = new SimpleObjectProperty<Date>();

			@Column(name = "usa_entry_date")
			@Temporal(TemporalType.DATE)
			public Date getUsaEntryDate() {
				return usaEntryDate.get();
			}

			public void setUsaEntryDate(Date usaEntryDate) {
				this.usaEntryDate.set(usaEntryDate);
			}

			public ObjectProperty<Date> usaEntryDateProperty() {
				return this.usaEntryDate;
			}
			
			// Column 4
			private SimpleObjectProperty<PatientSmokingStatus> smokingStatus = new SimpleObjectProperty<PatientSmokingStatus>(this, "smokingStatus");

			@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
			@JoinColumn(name = "smoking_status_id")
			public PatientSmokingStatus getSmokingStatus() {
				return smokingStatus.get();
			}

			public void setSmokingStatus(PatientSmokingStatus smokingStatus) {
				this.smokingStatus.set(smokingStatus);
			}

			public SimpleObjectProperty<PatientSmokingStatus> smokingStatusProperty() {
				return smokingStatus;
			}
			

			private  SimpleBooleanProperty bcgVaxHistory = new SimpleBooleanProperty(this, "bcgVaxHistory");

			@Column(name = "bcg_vax_history")
			public  boolean getBcgVaxHistory() {
				return bcgVaxHistory.get();
			}

			public  void setBcgVaxHistory(boolean bcgVaxHistory) {
				this.bcgVaxHistory.set(bcgVaxHistory);
			}

			public BooleanProperty bcgVaxHistoryProperty() {
				return bcgVaxHistory;
			}

			

			private  SimpleBooleanProperty drugAllergy = new SimpleBooleanProperty(this, "drugAllergy");

			@Column(name = "drug_allergy")
			public  boolean getDrugAllergy() {
				return drugAllergy.get();
			}

			public  void setDrugAllergy(boolean drugAllergy) {
				this.drugAllergy.set(drugAllergy);
			}

			public BooleanProperty drugAllergyProperty() {
				return drugAllergy;
			}


			private  SimpleBooleanProperty currentProblem = new SimpleBooleanProperty(this, "currentProblem");

			@Column(name = "current_problem")
			public  boolean getCurrentProblem() {
				return currentProblem.get();
			}

			public  void setCurrentProblem(boolean currentProblem) {
				this.currentProblem.set(currentProblem);
			}

			public BooleanProperty currentProblemProperty() {
				return currentProblem;
			}

			

			private  SimpleBooleanProperty medication = new SimpleBooleanProperty(this, "medication");

			@Column(name = "medication")
			public  boolean getMedication() {
				return medication.get();
			}

			public  void setMedication(boolean medication) {
				this.medication.set(medication);
			}

			public BooleanProperty medicationProperty() {
				return medication;
			}

			

			private  SimpleBooleanProperty allergy = new SimpleBooleanProperty(this, "allergy");

			@Column(name = "allergy")
			public  boolean getAllergy() {
				return allergy.get();
			}

			public  void setAllergy(boolean allergy) {
				this.allergy.set(allergy);
			}

			public BooleanProperty allergyProperty() {
				return allergy;
			}

			

			private  SimpleBooleanProperty cardiacEvent = new SimpleBooleanProperty(this, "cardiacEvent");

			@Column(name = "cardiac_event")
			public  boolean getCardiacEvent() {
				return cardiacEvent.get();
			}

			public  void setCardiacEvent(boolean cardiacEvent) {
				this.cardiacEvent.set(cardiacEvent);
			}

			public BooleanProperty cardiacEventProperty() {
				return cardiacEvent;
			}


	public PatientRiskFactor() {
		
	}

}
