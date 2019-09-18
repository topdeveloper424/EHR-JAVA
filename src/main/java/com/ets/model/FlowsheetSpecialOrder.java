package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;

@Entity
@Table(name = "flowsheet_special_order")
public class FlowsheetSpecialOrder {
	
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
	
	
	private SimpleObjectProperty<MedicalActivity> medicalActivity = new SimpleObjectProperty<MedicalActivity>(this, "medicalActivity");

	@ManyToOne
	@JoinColumn(name = "medical_activity_id")
	public MedicalActivity getMedicalActivity() {
		return medicalActivity.get();
	}

	public void setMedicalActivity(MedicalActivity medicalActivity) {
		this.medicalActivity.set(medicalActivity);
	}

	public SimpleObjectProperty<MedicalActivity> medicalActivityProperty() {
		return medicalActivity;
	}
	
	private SimpleObjectProperty<PatientVisit> patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");

	@ManyToOne
	@JoinColumn(name = "patient_visit_id")
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
