package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "assessment")
public class Assesment {
	
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

	
	/*private  StringProperty code = new SimpleStringProperty(this, "code");

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
	
	
	private StringProperty descrp = new SimpleStringProperty(this, "descrp");

	@Column(name = "descrp")
	public String getDescrp() {
		return descrp.get();
	}

	public void setDescrp(String descrp) {
		this.descrp.set(descrp);
	}

	public StringProperty descrpProperty() {
		return descrp;
	}*/
	
	private SimpleObjectProperty<Patient> patient = new SimpleObjectProperty<Patient>(this, "patient");

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
	}
	
	private SimpleObjectProperty<Icd10Codes> icd10 = new SimpleObjectProperty<Icd10Codes>(this, "icd10");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "icd10_id")
	public Icd10Codes getIcd10() {
		return icd10.get();
	}

	public void setIcd10(Icd10Codes icd10) {
		this.icd10.set(icd10);
	}

	public SimpleObjectProperty<Icd10Codes> icd10Property() {
		return icd10;
	}
	
	

	private SimpleObjectProperty<PatientVisit> patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientVisit_id")
	public PatientVisit getPatientVisit() {
		return patientVisit.get();
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit.set(patientVisit);
	}

	public SimpleObjectProperty<PatientVisit> patientVisitProperty() {
		return patientVisit;
	}
	

}
