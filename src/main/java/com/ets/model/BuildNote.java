package com.ets.model;

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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


	@Entity
	@Table(name = "buildNote")

	public class BuildNote {

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
		
		private StringProperty buildNoteSubjective = new SimpleStringProperty(this, "buildNoteSubjective");

		@Column(name = "buildNoteSubjective")
		public String getBuildNoteSubjective() {
			return buildNoteSubjective.get();
		}

		public void setBuildNoteSubjective(String buildNoteSubjective) {
			this.buildNoteSubjective.set(buildNoteSubjective);
		}

		public StringProperty buildNoteSubjectiveProperty() {
			return buildNoteSubjective;
		}
		
		

		private StringProperty buildNoteObjective = new SimpleStringProperty(this, "buildNoteObjective");

		@Column(name = "buildNoteObjective")
		public String getBuildNoteObjective() {
			return buildNoteObjective.get();
		}

		public void setBuildNoteObjective(String buildNoteObjective) {
			this.buildNoteObjective.set(buildNoteObjective);
		}

		public StringProperty buildNoteObjectiveProperty() {
			return buildNoteObjective;
		}
		
		private StringProperty assessment = new SimpleStringProperty(this, "assessment");

		@Column(name = "assessment")
		public String getAssessment() {
			return assessment.get();
		}

		public void setAssessment(String assessment) {
			this.assessment.set(assessment);
		}

		public StringProperty assessmentProperty() {
			return assessment;
		}
		
		private StringProperty plan = new SimpleStringProperty(this, "plan");

		@Column(name = "plan")
		public String getPlan() {
			return plan.get();
		}

		public void setPlan(String plan) {
			this.plan.set(plan);
		}

		public StringProperty planProperty() {
			return plan;
		}
		
		private SimpleObjectProperty<PatientVisit> patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");

		@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
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
		private SimpleObjectProperty<Patient> patient = new SimpleObjectProperty<Patient>(this, "patient");

		@OneToOne(fetch = FetchType.EAGER , cascade = CascadeType.ALL)
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
}
