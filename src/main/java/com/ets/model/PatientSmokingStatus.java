package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientSmokingStatus Class
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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@Entity
@Table(name = "patient_smoking_status")

public class PatientSmokingStatus {

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
				private StringProperty smokingStatus = new SimpleStringProperty(this, "smokingStatus");

				@Column(name = "smoking_status")
				public String getSmokingStatus() {
					return smokingStatus.get();
				}

				public void setSmokingStatus(String smokingStatus) {
					this.smokingStatus.set(smokingStatus);
				}

				public StringProperty smokingStatusProperty() {
					return smokingStatus;
				}
				
				// Column 3
				private StringProperty packsPerDay = new SimpleStringProperty(this, "packsPerDay");

				@Column(name = "packs_per_day")
				public String getPacksPerDay() {
					return packsPerDay.get();
				}

				public void setPacksPerDay(String packsPerDay) {
					this.packsPerDay.set(packsPerDay);
				}

				public StringProperty packsPerDayProperty() {
					return packsPerDay;
				}
				
				// Column 3
				private StringProperty noOfYears = new SimpleStringProperty(this, "noOfYears");

				@Column(name = "no_of_years")
				public String getNoOfYears() {
					return noOfYears.get();
				}

				public void setNoOfYears(String noOfYears) {
					this.noOfYears.set(noOfYears);
				}

				public StringProperty noOfYearsProperty() {
					return noOfYears;
				}
				
				// Column 12
				private ObjectProperty<Date> lastSmokedDate = new SimpleObjectProperty<Date>();

				@Column(name = "last_smoked_date")
				@Temporal(TemporalType.DATE)
				public Date getLastSmokedDate() {
					
					return lastSmokedDate.get();
					
				}

				public void setLastSmokedDate(Date lastSmokedDate) {
					
					this.lastSmokedDate.set(lastSmokedDate);
					
				}

				public ObjectProperty<Date> lastSmokedDateProperty() {
					
					return this.lastSmokedDate;
					
				}
				
				/***************
				 * Column property ( 4 )
				 *****************************************/

				private  SimpleBooleanProperty cessationProgramOffered = new SimpleBooleanProperty(
						this, "cessationProgramOffered");

				@Column(name = "cessation_program_offered")
				public  boolean getCessationProgramOffered() {
					return cessationProgramOffered.get();
				}

				public  void setCessationProgramOffered(boolean cessationProgramOffered) {
					this.cessationProgramOffered.set(cessationProgramOffered);
				}

				public BooleanProperty cessationProgramOfferedProperty() {
					return cessationProgramOffered;
				}
				
				// Column 12
				private ObjectProperty<Date> cessationProgramOfferedDate = new SimpleObjectProperty<Date>();

				@Column(name = "cessation_program_offered_date")
				@Temporal(TemporalType.DATE)
				public Date getCessationProgramOfferedDate() {
					
					return cessationProgramOfferedDate.get();
					
				}

				public void setCessationProgramOfferedDate(Date cessationProgramOfferedDate) {
					
					this.cessationProgramOfferedDate.set(cessationProgramOfferedDate);
					
				}

				public ObjectProperty<Date> cessationProgramOfferedDateProperty() {
					
					return this.cessationProgramOfferedDate;
					
				}
				
				/***************
				 * Column property ( 4 )
				 *****************************************/

				private  SimpleBooleanProperty cessationProgramAccepted = new SimpleBooleanProperty(
						this, "cessationProgramAccepted");

				@Column(name = "cessation_program_accepted")
				public  boolean getCessationProgramAccepted() {
					return cessationProgramAccepted.get();
				}

				public  void setCessationProgramAccepted(boolean cessationProgramAccepted) {
					this.cessationProgramAccepted.set(cessationProgramAccepted);
				}

				public BooleanProperty cessationProgramAcceptedProperty() {
					return cessationProgramAccepted;
				}
	
	public PatientSmokingStatus() {
		
	}

}
