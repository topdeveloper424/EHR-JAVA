package com.ets.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="emr_hpi")

public class EmrHpi {

	/*private IntegerProperty id = new SimpleIntegerProperty(this, "id");
	
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
	}*/
	
	private Integer id;
	 
	 
	 private Date date;
	 
	 
	 private String summary;
	 
	 private String characteristics;
	 
	 
	 private String descrip;
	 

	 @Id
	 @GeneratedValue(strategy=GenerationType.AUTO)
	    @Column(name="id")
	 public Integer getId() {
	  return id;
	 }

	 public void setId(Integer id) {
	  this.id = id;
	 }

	 @Column(name="date")
	 public Date getDate() {
	  return date;
	 }

	 public void setDate(Date date) {
	  this.date = date;
	 }

	 @Column(name="summary")
	 public String getSummary() {
	  return summary;
	 }

	 public void setSummary(String summary) {
	  this.summary = summary;
	 }


	 @Column(name="characteristics")
	 public String getCharacteristics() {
	  return characteristics;
	 }

	 public void setCharacteristics(String characteristics) {
	  this.characteristics = characteristics;
	 }

	 @Column(name="description")
	 public String getDescrip() {
	  return descrip;
	 }

	 public void setDescrip(String descrip) {
	  this.descrip = descrip;
	 }

	/* private SimpleObjectProperty<Patient> patient = new SimpleObjectProperty<Patient>(this, "patient");

	 @ManyToOne(fetch = FetchType.EAGER)
	 @JoinColumn(name = "patient_id")
	 public Patient getPatient() {
	  return patient.get();
	 }

	 public void setPatient(Patient patient) {
	  this.patient.set(patient);
	 }

	 public SimpleObjectProperty<Patient> patientProperty() {
	  return patient;
	 }*/
	 private Patient patient;
	    @ManyToOne
	    @JoinColumn(name="patient_id")
	 public Patient getPatient() {
	  return patient;
	 }

	 public void setPatient(Patient patient) {
	  this.patient = patient;
	 }
	 
	 private PatientVisit patientVisit;

	 @ManyToOne
	 @JoinColumn(name="patient_visit_id")
	public PatientVisit getPatientVisit() {
		return patientVisit;
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit = patientVisit;
	}

	public EmrHpi() {
		// TODO Auto-generated constructor stub
	}

}
