package com.ets.model;

import java.util.Date;

import javax.persistence.CascadeType;
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
@Table(name="medical_activity_charge")
public class MedicalActivityCharge {
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

	@ManyToOne(fetch = FetchType.EAGER)
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
	private ObjectProperty<Date> activityDate   = new SimpleObjectProperty<Date>();

	@Column(name = "activity_date")
	@Temporal(TemporalType.DATE)
	public Date getActivityDate() {
		return activityDate.get();
	}

	public void setActivityDate(Date activityDate) {
		this.activityDate.set(activityDate);
	}

	public ObjectProperty<Date> activityDateProperty() {
		return this.activityDate;
	}
	private StringProperty billingStatus = new SimpleStringProperty(this, "billingStatus");

	@Column(name = "billing_status")
	public String getBillingStatus() {
		return billingStatus.get();
	}

	public void setBillingStatus(String billingStatus) {
		this.billingStatus.set(billingStatus);
	}

	public StringProperty billingStatusProperty() {
		return billingStatus;
	}
	
	private StringProperty billingModifier  = new SimpleStringProperty(this, "billingModifier");

	@Column(name = "billing_modifier")
	public String getBillingModifier() {
		return billingModifier.get();
	}

	public void setBillingModifier(String billingModifier) {
		this.billingModifier.set(billingModifier);
	}

	public StringProperty billingModifierProperty() {
		return billingModifier;
	}
	
	private StringProperty billingQty   = new SimpleStringProperty(this, "billingQty");

	@Column(name = "billing_qty")
	public String getBillingQty() {
		return billingQty.get();
	}

	public void setBillingQty(String billingQty) {
		this.billingQty.set(billingQty);
	}

	public StringProperty billingQtyProperty() {
		return billingQty;
	}
	
	private StringProperty billingComment  = new SimpleStringProperty(this, "billingComment");

	@Column(name = "billing_comment")
	public String getBillingComment() {
		return billingComment.get();
	}

	public void setBillingComment(String billingComment) {
		this.billingComment.set(billingComment);
	}

	public StringProperty billingCommentProperty() {
		return billingComment;
	}
	
	private StringProperty resultCode   = new SimpleStringProperty(this, "resultCode");

	@Column(name = "result_code")
	public String getResultCode() {
		return resultCode.get();
	}

	public void setResultCode(String resultCode) {
		this.resultCode.set(resultCode);
	}

	public StringProperty resultCodeProperty() {
		return resultCode;
	}
	
	
	private SimpleBooleanProperty checkBillingStatus = new SimpleBooleanProperty(this, "checkBillingStatus");

	@Column(name = "check_billing_status")
	public boolean getCheckBillingStatus() {
		return checkBillingStatus.get();
	}

	public void setCheckBillingStatus(boolean checkBillingStatus) {
		this.checkBillingStatus.set(checkBillingStatus);
	}

	public BooleanProperty checkBillingStatusProperty() {
		return checkBillingStatus;
	}
	
	
	
	private StringProperty drugQuant = new SimpleStringProperty(this, "drugQuant");

	@Column(name = "drug_quant")
	public String getDrugQuant() {
		return drugQuant.get();
	}

	public void setDrugQuant(String drugQuant) {
		this.drugQuant.set(drugQuant);
	}

	public StringProperty drugQuantProperty() {
		return drugQuant;
	}
	
	
	private StringProperty uom = new SimpleStringProperty(this, "uom");

	@Column(name = "uom")
	public String getUom() {
		return uom.get();
	}

	public void setUom(String uom) {
		this.uom.set(uom);
	}

	public StringProperty uomProperty() {
		return uom;
	}
	
	
	
	private StringProperty locationGiven = new SimpleStringProperty(this, "locationGiven");

	@Column(name = "locationGiven")
	public String getLocationGiven() {
		return locationGiven.get();
	}

	public void setLocationGiven(String locationGiven) {
		this.locationGiven.set(locationGiven);
	}

	public StringProperty locationGivenProperty() {
		return locationGiven;
	}
	
	
	
	//@JoinColumn(name = "drug_Screen_result")
	private DrugScreenResult drugScreenResult; 
	@OneToOne(cascade=CascadeType.ALL,orphanRemoval =true, mappedBy = "medActCharge", fetch = FetchType.LAZY)
	
	public DrugScreenResult getDrugScreenResult() {
		return drugScreenResult;
	}

	public void setDrugScreenResult(DrugScreenResult drugScreenResult) {
		this.drugScreenResult = drugScreenResult;
	}
	
	/*@Column(name = "check_billing_status")
	public Boolean getCheckBillingStatus() {
		return checkBillingStatus.get();
	}

	public void setCheckBillingStatus(Boolean checkBillingStatus) {
		this.checkBillingStatus.set(checkBillingStatus);
	}

	public BooleanProperty checkBillingStatusProperty() {
		return checkBillingStatus;
	}
	*/
	
	/*public Boolean getCheckBillingStatus() {
		return checkBillingStatus;
	}

	public void setCheckBillingStatus(BooleanProperty checkBillingStatus) {
		this.checkBillingStatus = checkBillingStatus;
	}
	*/
	
	
	private ObjectProperty<Date> nextDueDate = new SimpleObjectProperty<Date>();

	@Column(name = "next_due_date")
	@Temporal(TemporalType.DATE)
	public Date getNextDueDate() {
		return nextDueDate.get();
	}

	public void setNextDueDate(Date nextDueDate) {
		this.nextDueDate.set(nextDueDate);
	}

	public ObjectProperty<Date> nextDueDateProperty() {
		return this.nextDueDate;
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
	
	private StringProperty ndcCode    = new SimpleStringProperty(this, "ndcCode");

	@Column(name = "ndc_code")
	public String getNdcCode() {
		return ndcCode.get();
	}

	public void setNdcCode(String ndcCode) {
		this.ndcCode.set(ndcCode);
	}

	public StringProperty ndcCodeProperty() {
		return ndcCode;
	}
	private StringProperty labSampleId    = new SimpleStringProperty(this, "labSampleId");

	@Column(name = "lab_sample_id")
	public String getLabSampleId() {
		return labSampleId.get();
	}

	public void setLabSampleId(String labSampleId) {
		this.labSampleId.set(labSampleId);
	}

	public StringProperty labSampleIdProperty() {
		return labSampleId;
	}
	private StringProperty labOrderNo = new SimpleStringProperty(this, "labOrderNo");

	@Column(name = "lab_order_no")
	public String getLabOrderNo() {
		return labOrderNo.get();
	}

	public void setLabOrderNo(String labOrderNo) {
		this.labOrderNo.set(labOrderNo);
	}

	public StringProperty labOrderNoProperty() {
		return labOrderNo;
	}
	
		
	private SimpleBooleanProperty noCost = new SimpleBooleanProperty(this, "noCost");

	@Column(name = "no_cost")
	public boolean getNoCost() {
		return noCost.get();
	}

	public void setNoCost(boolean noCost) {
		this.noCost.set(noCost);
	}

	public BooleanProperty noCostProperty() {
		return noCost;
	}
	
	private StringProperty activityCost  = new SimpleStringProperty(this, "activityCost");

	@Column(name = "activityCost")
	public String getActivityCost() {
		return activityCost.get();
	}

	public void setActivityCost(String activityCost) {
		this.activityCost.set(activityCost);
	}

	public StringProperty activityCostProperty() {
		return activityCost;
	}
	
	private StringProperty overridePayer  = new SimpleStringProperty(this, "overridePayer");

	@Column(name = "override_payer")
	public String getOverridePayer() {
		return overridePayer.get();
	}

	public void setOverridePayer(String overridePayer) {
		this.overridePayer.set(overridePayer);
	}

	public StringProperty overridePayerProperty() {
		return overridePayer;
	}
	
	
	private StringProperty overrideFee  = new SimpleStringProperty(this, "overrideFee");

	@Column(name = "override_fee")
	public String getOverrideFee() {
		return overrideFee.get();
	}

	public void setOverrideFee(String overridePayer) {
		this.overrideFee.set(overridePayer);
	}

	public StringProperty overrideFeeProperty() {
		return overrideFee;
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

	public SimpleObjectProperty<PatientVisit>patientVisitProperty() {
		return patientVisit;
	}
	
	
	public MedicalActivityCharge(){
		
	}
}
