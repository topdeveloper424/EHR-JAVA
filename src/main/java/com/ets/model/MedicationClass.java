package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "medication_class")

public class MedicationClass {
	
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

	
	private  StringProperty medicalClass = new SimpleStringProperty(this, "medicalClass");

	@Column(name = "medical_class")
	public  String getMedicalClass() {
		return medicalClass.get();
	}

	public  void setMedicalClass(String medicalClass) {
		this.medicalClass.set(medicalClass);
	}

	public StringProperty medicalClassProperty() {
		return medicalClass;
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
	

	public MedicationClass() {
		
	}

}
