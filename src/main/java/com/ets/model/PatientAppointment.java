package com.ets.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="patient_appointment")
public class PatientAppointment {

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

	private StringProperty type = new SimpleStringProperty(this, "type");

	@Column(name = "type")
	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.set(type);
	}

	public StringProperty typeProperty() {
		return type;
	}




	private ObjectProperty<Date> apptDate = new SimpleObjectProperty<Date>();

	@Column(name = "appt_date")
	@Temporal(TemporalType.DATE)
	public Date getApptDate() {
		return apptDate.get();
	}

	public void setApptDate(Date apptDate) {
		this.apptDate.set(apptDate);
	}

	public ObjectProperty<Date> apptDateProperty() {
		return this.apptDate;
	}
	
	
	/*private ObjectProperty<Date> apptTime = new SimpleObjectProperty<Date>();

	@Column(name = "appt_Time ")
	@Temporal(TemporalType.TIME)
	public Date getApptTime() {
		return apptTime.get();
	}

	public void setApptTime(Date apptTime) {
		this.apptTime.set(apptTime);
	}

	public ObjectProperty<Date> apptTimeProperty() {
		return this.apptTime;
	}*/

	private StringProperty apptTime = new SimpleStringProperty(this, "apptTime");

	@Column(name = "appt_Time")
	public String getApptTime() {
		return apptTime.get();
	}

	public void setApptTime(String apptTime) {
		this.apptTime.set(apptTime);
	}

	public StringProperty apptTimeProperty() {
		return apptTime;
	}

	private StringProperty status = new SimpleStringProperty(this, "status");

	@Column(name = "status")
	public String getStatus() {
		return status.get();
	}

	public void setStatus(String status) {
		this.status.set(status);
	}

	public StringProperty statusProperty() {
		return status;
	}

	private SimpleObjectProperty<VisitCategory> visitCatId = new SimpleObjectProperty<VisitCategory>(this,
			"visitCatId");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "visit_cat_id")
	public VisitCategory getVisitCatId() {
		return visitCatId.get();
	}

	public void setVisitCatId(VisitCategory visitCatId) {
		this.visitCatId.set(visitCatId);
	}

	public SimpleObjectProperty<VisitCategory> visitCatIdProperty() {
		return visitCatId;
	}

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

	private StringProperty purpose = new SimpleStringProperty(this, "purpose ");

	@Column(name = "purpose_id")
	public String getPurpose() {
		return purpose.get();
	}

	public void setPurpose(String purpose) {
		this.purpose.set(purpose);
	}

	public StringProperty purposeProperty() {
		return purpose;
	}

	private SimpleObjectProperty<Provider> provider = new SimpleObjectProperty<Provider>(this, "provider");

	@ManyToOne
	@JoinColumn(name = "provider_id")
	public Provider getProvider() {
		return provider.get();
	}

	public void setProvider(Provider provider) {
		this.provider.set(provider);
	}

	public SimpleObjectProperty<Provider> providerProperty() {
		return provider;
	}

	private SimpleObjectProperty<Clinician> clinician = new SimpleObjectProperty<Clinician>(this, "clinician");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinician_id")
	public Clinician getClinician() {
		return clinician.get();
	}

	public void setClinician(Clinician clinician) {
		this.clinician.set(clinician);
	}

	public SimpleObjectProperty<Clinician> clinicianProperty() {
		return clinician;
	}

	private SimpleObjectProperty<ReferalProvider> referredBy = new SimpleObjectProperty<ReferalProvider>(this, "referredBy");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "referred_by_id")
	public ReferalProvider getReferredBy() {
		return referredBy.get();
	}

	public void setReferredBy(ReferalProvider referredBy) {
		this.referredBy.set(referredBy);
	}

	public SimpleObjectProperty<ReferalProvider> referredByProperty() {
		return referredBy;
	}

	private StringProperty schMinutesReq = new SimpleStringProperty(this, "schMinutesReq");

	@Column(name = "sch_minutes_req")
	public String getSchMinutesReq() {
		return schMinutesReq.get();
	}

	public void setSchMinutesReq(String schMinutesReq) {
		this.schMinutesReq.set(schMinutesReq);
	}

	public StringProperty schMinutesReqProperty() {
		return schMinutesReq;
	}

	private StringProperty cancelReason = new SimpleStringProperty(this, "cancelReason");

	@Column(name = "cancel_reason")
	public String getCancelReason() {
		return cancelReason.get();
	}

	public void setCancelReason(String cancelReason) {
		this.cancelReason.set(cancelReason);
	}

	public StringProperty cancelReasonProperty() {
		return cancelReason;
	}

	private StringProperty apptNotes = new SimpleStringProperty(this, "apptNotes");

	@Column(name = "appt_notes")
	public String getApptNotes() {
		return apptNotes.get();
	}

	public void setApptNotes(String apptNotes) {
		this.apptNotes.set(apptNotes);
	}

	public StringProperty apptNotesProperty() {
		return apptNotes;
	}
	
	
	private boolean visitingStatus;
	@Column(name = "visiting_status",columnDefinition="boolean default false")
	public boolean isVisitingStatus() {
		return visitingStatus;
	}

	public void setVisitingStatus(boolean visitingStatus) {
		this.visitingStatus = visitingStatus;
	}
	
	
		
}
