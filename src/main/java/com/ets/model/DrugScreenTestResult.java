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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="drug_screen_test_result")
public class DrugScreenTestResult {
	
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
	
	
	private StringProperty drugTestName = new SimpleStringProperty(this, "drugTestName");

	@Column(name = "drug_test_name")
	public String getDrugTestName() {
		return drugTestName.get();
	}

	public void setDrugTestName(String drugTestName) {
		this.drugTestName.set(drugTestName);
	}

	public StringProperty drugTestNameProperty() {
		return drugTestName;
	}
	
	private StringProperty finalResult = new SimpleStringProperty(this, "finalResult");

	@Column(name = "final_result")
	public String getFinalResult() {
		return finalResult.get();
	}

	public void setFinalResult(String finalResult) {
		this.finalResult.set(finalResult);
	}

	public StringProperty finalResultProperty() {
		return finalResult;
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
	
	private SimpleObjectProperty<PatientVisit> patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");

	@ManyToOne
	@JoinColumn(name = "patientvisit_id")
	public PatientVisit getPatientVisit() {
		return patientVisit.get();
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit.set(patientVisit);
	}
	
	public SimpleObjectProperty<PatientVisit> patientVisitProperty() {
		
		return patientVisit;
		
	}
	
	private StringProperty prelimResult = new SimpleStringProperty(this, "prelimResult");

	@Column(name = "prelim_result")
	public String getPrelimResult() {
		return prelimResult.get();
	}

	public void setPrelimResult(String prelimResult) {
		this.prelimResult.set(prelimResult);
	}

	public StringProperty prelimResultProperty() {
		return prelimResult;
	}
	
	private StringProperty medicalActivityCode = new SimpleStringProperty(this, "medicalActivityCode");

	@Column(name = "medical_activity_code")
	public String getMedicalActivityCode() {
		return medicalActivityCode.get();
	}

	public void setMedicalActivityCode(String medicalActivityCode) {
		this.medicalActivityCode.set(medicalActivityCode);
	}

	public StringProperty medicalActivityCodeProperty() {
		return medicalActivityCode;
	}
	
	
	private StringProperty splitSpecimenResult = new SimpleStringProperty(this, "splitSpecimenResult");

	@Column(name = "split_specimen_result")
	public String getSplitSpecimenResult() {
		return splitSpecimenResult.get();
	}

	public void setSplitSpecimenResult(String splitSpecimenResult) {
		this.splitSpecimenResult.set(splitSpecimenResult);
	}

	public StringProperty splitSpecimenResultProperty() {
		return splitSpecimenResult;
	}
	
	
	private StringProperty resultSummary = new SimpleStringProperty(this, "resultSummary");

	@Column(name = "result_summary")
	public String getResultSummary() {
		return resultSummary.get();
	}

	public void setResultSummary(String resultSummary) {
		this.resultSummary.set(resultSummary);
	}

	public StringProperty ResultSummaryProperty() {
		return resultSummary;
	}
	
	private StringProperty testName = new SimpleStringProperty(this, "testName");

	@Column(name = "test_name")
	public String getTestName() {
		return testName.get();
	}

	public void setTestName(String testName) {
		this.testName.set(testName);
	}

	public StringProperty testNameProperty() {
		return testName;
	}
	
	private StringProperty textResult = new SimpleStringProperty(this, "textResult");

	@Column(name = "text_result")
	public String getTextResult() {
		return textResult.get();
	}

	public void setTextResult(String textResult) {
		this.textResult.set(textResult);
	}

	public StringProperty textResultProperty() {
		return textResult;
	}
	
	private StringProperty labResult = new SimpleStringProperty(this, "labResult");

	@Column(name = "lab_result")
	public String getLabResult() {
		return labResult.get();
	}

	public void setLabResult(String labResult) {
		this.labResult.set(labResult);
	}

	public StringProperty labResultProperty() {
		return labResult;
	}
	
	
	private StringProperty numaricResult = new SimpleStringProperty(this, "numaricResult");

	@Column(name = "numaric_result")
	public String getNumaricResult() {
		return numaricResult.get();
	}

	public void setNumaricResult(String numaricResult) {
		this.numaricResult.set(numaricResult);
	}

	public StringProperty numaricResultProperty() {
		return numaricResult;
	}
	
	
	private StringProperty units = new SimpleStringProperty(this, "units");

	@Column(name = "units")
	public String getUnits() {
		return units.get();
	}

	public void setUnits(String units) {
		this.units.set(units);
	}

	public StringProperty unitsProperty() {
		return units;
	}
	
	private StringProperty refRange = new SimpleStringProperty(this, "refRange");

	@Column(name = "ref_range")
	public String getRefRange() {
		return refRange.get();
	}

	public void setRefRange(String refRange) {
		this.refRange.set(refRange);
	}

	public StringProperty refRangeProperty() {
		return refRange;
	}
	
	
	private StringProperty describeReason = new SimpleStringProperty(this, "describeReason");

	@Column(name = "describe_reason")
	public String getDescribeReason() {
		return describeReason.get();
	}

	public void setDescribeReason(String describeReason) {
		this.describeReason.set(describeReason);
	}

	/*@OneToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@Column(name = "medical_activity_charge")
	private MedicalActivityCharge medActCharge;
	
	public MedicalActivityCharge getMedActCharge() {
		return medActCharge;
	}

	public void setMedActCharge(MedicalActivityCharge medActCharge) {
		this.medActCharge = medActCharge;
	}
*/
	public StringProperty describeReasonProperty() {
		return describeReason;
	}
	/**private IntegerProperty id = new SimpleIntegerProperty(this, "id");

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
	
	//private IntegerProperty revision = new SimpleIntegerProperty(this, "revision");
	private Integer revision;
	@Column(name = "revision")
	public Integer getRevision() {
		return revision;
	}

	public void setRevision(Integer revision) {
		this.revision = revision;
	}

	/**/  /*  public Integer getRevision() {
		return revision.get();
	}

	public void setRevision(Integer revision) {
		this.revision.set(revision);
	}

	public IntegerProperty revisionProperty() {
		return this.revision;
	}*/
	/*public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}
*/

/*	private StringProperty prelimResult = new SimpleStringProperty(this, "prelimResult");

	@Column(name = "prelim_result")
	public String getPrelimResult() {
		return prelimResult.get();
	}

	public void setPrelimResult(String prelimResult) {
		this.prelimResult.set(prelimResult);
	}

	public StringProperty prelimResultProperty() {
		return prelimResult;
	}*/
	private DrugScreenResult drugScreenId;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn//(name ="drugScreenId")
	public DrugScreenResult getDrugScreenId() {
		return drugScreenId;
	}

	public void setDrugScreenId(DrugScreenResult drugScreenId) {
		this.drugScreenId = drugScreenId;
	}


	private ObjectProperty<Date> modifiedDate = new SimpleObjectProperty<Date>();
	@Column(name = "modified_date")
	@Temporal(TemporalType.DATE)
	public Date getModifiedDate() {
		return modifiedDate.get();
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate.set(modifiedDate);;
	}
	
	public ObjectProperty<Date> modifiedDateProperty()
	{
		return this.modifiedDate;
	}
	
	
	
	public DrugScreenTestResult() {
		
	}

	

	public DrugScreenTestResult(String drugTestName, String prelimResult) {
		
		this.drugTestName = new SimpleStringProperty(drugTestName);
		this.prelimResult = new SimpleStringProperty(prelimResult);
		
	}

	

	public DrugScreenTestResult(String drugTestName, String finalResult, String prelimResult) {
		
		
		this.drugTestName = new SimpleStringProperty(drugTestName);
		this.finalResult = new SimpleStringProperty(finalResult);
		this.prelimResult = new SimpleStringProperty(prelimResult);
	}
	
	
	
	
	

}
