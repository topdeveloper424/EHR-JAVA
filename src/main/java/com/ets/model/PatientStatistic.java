package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientStatistic Class
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
@Table(name = "patient_statistic")

public class PatientStatistic {
	
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
		private ObjectProperty<Date> dob = new SimpleObjectProperty<Date>();

		@Column(name = "dob")
		@Temporal(TemporalType.DATE)
		public Date getDob() {
			return dob.get();
		}

		public void setDob(Date dob) {
			this.dob.set(dob);
		}

		public ObjectProperty<Date> dobProperty() {
			return this.dob;
		}
		
		
		private StringProperty gender = new SimpleStringProperty(this, "gender");

		@Column(name = "gender")
		public String getGender() {
			return gender.get();
		}

		public void setGender(String gender) {
			this.gender.set(gender);
		}

		public StringProperty genderProperty() {
			return gender;
		}
		
		private StringProperty rece = new SimpleStringProperty(this, "rece");

		@Column(name = "rece")
		public String getRace() {
			return rece.get();
		}

		public void setRace(String rece) {
			this.rece.set(rece);
		}

		public StringProperty receProperty() {
			return rece;
		}
		
		private  SimpleBooleanProperty deceased = new SimpleBooleanProperty(this, "deceased");

		@Column(name = "deceased")
		public  boolean getDeceased() {
			return deceased.get();
		}

		public  void setDeceased(boolean deceased) {
			this.deceased.set(deceased);
		}

		public BooleanProperty deceasedProperty() {
			return deceased;
		}
		
		/*private StringProperty deceased = new SimpleStringProperty(this, "deceased");

		@Column(name = "deceased")
		public String getDeceased() {
			return deceased.get();
		}

		public void setDeceased(String deceased) {
			this.deceased.set(deceased);
		}

		public StringProperty deceasedProperty() {
			return deceased;
		}*/
		
		private StringProperty marital = new SimpleStringProperty(this, "marital");

		@Column(name = "marital")
		public String getMarital() {
			return marital.get();
		}

		public void setMarital(String marital) {
			this.marital.set(marital);
		}

		public StringProperty maritalProperty() {
			return marital;
		}

		
		private StringProperty education = new SimpleStringProperty(this, "education");

		@Column(name = "education")
		public String getEducation() {
			return education.get();
		}

		public void setEducation(String education) {
			this.education.set(education);
		}

		public StringProperty educationProperty() {
			return education;
		}

		
		private StringProperty prefLang = new SimpleStringProperty(this, "prefLang");

		@Column(name = "pref_lang")
		public String getPrefLang() {
			return prefLang.get();
		}

		public void setPrefLang(String prefLang) {
			this.prefLang.set(prefLang);
		}

		public StringProperty prefLangProperty() {
			return prefLang;
		}

		
		private StringProperty secondLang = new SimpleStringProperty(this, "secondLang");

		@Column(name = "second_lang")
		public String getSecondLang() {
			return secondLang.get();
		}

		public void setSecondLang(String secondLang) {
			this.secondLang.set(secondLang);
		}

		public StringProperty secondLangProperty() {
			return secondLang;
		}
		
		private SimpleBooleanProperty speakEnglish = new SimpleBooleanProperty(this, "speakEnglish");

		@Column(name = "speak_english")
		public boolean getSpeakEnglish() {
			return speakEnglish.get();
		}

		public void setSpeakEnglish(boolean speakEnglish) {
			this.speakEnglish.set(speakEnglish);
		}

		public BooleanProperty speakEnglishProperty() {
			return speakEnglish;
		}




	public PatientStatistic() {
		
	}

}
