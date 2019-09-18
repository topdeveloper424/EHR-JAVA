package com.ets.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "drug_screen_result")

public class DrugScreenResult {
	
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

	
	private ObjectProperty<Date> collectionDate   = new SimpleObjectProperty<Date>();

	@Column(name = "collection_date")
	@Temporal(TemporalType.DATE)
	public Date getCollectionDate() {
		return collectionDate.get();
	}

	public void setCollectionDate(Date collectionDate) {
		this.collectionDate.set(collectionDate);
	}

	public ObjectProperty<Date> collectionDateProperty() {
		return this.collectionDate;
	}
	
	private StringProperty ccfNo  = new SimpleStringProperty(this, "ccfNo");

	@Column(name = "ccf_no")
	public String getCcfNo() {
		return ccfNo.get();
	}

	public void setCcfNo(String ccfNo) {
		this.ccfNo.set(ccfNo);
	}

	public StringProperty ccfNoProperty() {
		return ccfNo;
	}
	
	private SimpleObjectProperty<Laboratory> laboratory = new SimpleObjectProperty<Laboratory>(this, "laboratory");

	@ManyToOne
	@JoinColumn(name = "laboratory_id")
	public Laboratory getLaboratory() {
		return laboratory.get();
	}

	public void setLaboratory(Laboratory laboratory) {
		this.laboratory.set(laboratory);
	}

	public SimpleObjectProperty<Laboratory> laboratoryProperty() {
		return laboratory;
	}
		
	private ObjectProperty<Date> dateSent    = new SimpleObjectProperty<Date>();

	@Column(name = "date_sent")
	@Temporal(TemporalType.DATE)
	public Date getDateSent() {
		return dateSent.get();
	}

	public void setDateSent(Date dateSent) {
		this.dateSent.set(dateSent);
	}

	public ObjectProperty<Date> dateSentProperty() {
		return this.dateSent;
	}

	private StringProperty testReason  = new SimpleStringProperty(this, "testReason");

	@Column(name = "test_reason")
	public String getTestReason() {
		return testReason.get();
	}

	public void setTestReason(String testReason) {
		this.testReason.set(testReason);
	}

	public StringProperty testReasonProperty() {
		return testReason;
	}
	
	private StringProperty collectionProtocol   = new SimpleStringProperty(this, "collectionProtocol");

	@Column(name = "collection_protocol")
	public String getCollectionProtocol() {
		return collectionProtocol.get();
	}

	public void setCollectionProtocol(String collectionProtocol) {
		this.collectionProtocol.set(collectionProtocol);
	}

	public StringProperty collectionProtocolProperty() {
		return collectionProtocol;
	}
	
		private ObjectProperty<Date> dateReceived  = new SimpleObjectProperty<Date>();

	@Column(name = "date_received")
	@Temporal(TemporalType.DATE)
	public Date getDateReceived() {
		return dateReceived.get();
	}

	public void setDateReceived(Date dateReceived) {
		this.dateReceived.set(dateReceived);
	}

	public ObjectProperty<Date> dateReceivedProperty() {
		return this.dateReceived;
	}
	
	private StringProperty orderResultStatus    = new SimpleStringProperty(this, "orderResultStatus");

	@Column(name = "order_result_status")
	public String getOrderResultStatus() {
		return orderResultStatus.get();
	}

	public void setOrderResultStatus(String orderResultStatus) {
		this.orderResultStatus.set(orderResultStatus);
	}

	public StringProperty orderResultStatusProperty() {
		return orderResultStatus;
	}
	
	private ObjectProperty<Date> mroReqDate   = new SimpleObjectProperty<Date>();

	@Column(name = "mro_req_date")
	@Temporal(TemporalType.DATE)
	public Date getMroReqDate() {
		return mroReqDate.get();
	}

	public void setMroReqDate(Date mroReqDate) {
		this.mroReqDate.set(mroReqDate);
	}

	public ObjectProperty<Date> mroReqDateProperty() {
		return this.mroReqDate;
	}
	
	private ObjectProperty<Date> employeeNotifiedDate   = new SimpleObjectProperty<Date>();

	@Column(name = "employee_notified_date")
	@Temporal(TemporalType.DATE)
	public Date getEmployeeNotifiedDate() {
		return employeeNotifiedDate.get();
	}

	public void setEmployeeNotifiedDate(Date employeeNotifiedDate) {
		this.employeeNotifiedDate.set(employeeNotifiedDate);
	}

	public ObjectProperty<Date> employeeNotifiedDateProperty() {
		return this.employeeNotifiedDate;
	}
	
	private ObjectProperty<Date> splitSpecimenDate   = new SimpleObjectProperty<Date>();

	@Column(name = "split_specimen_date")
	@Temporal(TemporalType.DATE)
	public Date getSplitSpecimenDate() {
		return splitSpecimenDate.get();
	}

	public void setSplitSpecimenDate(Date splitSpecimenDate) {
		this.splitSpecimenDate.set(splitSpecimenDate);
	}

	public ObjectProperty<Date> splitSpecimenDateProperty() {
		return this.splitSpecimenDate;
	}
	
	private ObjectProperty<Date> splitResultDate   = new SimpleObjectProperty<Date>();

	@Column(name = "split_result_date")
	@Temporal(TemporalType.DATE)
	public Date getSplitResultDate() {
		return splitResultDate.get();
	}

	public void setSplitResultDate(Date splitResultDate) {
		this.splitResultDate.set(splitResultDate);
	}

	public ObjectProperty<Date> splitResultDateProperty() {
		return this.mroReqDate;
	}
	
	
	private ObjectProperty<Date> mroReviewDate   = new SimpleObjectProperty<Date>();

	@Column(name = "mro_review_date")
	@Temporal(TemporalType.DATE)
	public Date getMroReviewDate() {
		return mroReviewDate.get();
	}

	public void setMroReviewDate(Date mroReviewDate) {
		this.mroReviewDate.set(mroReviewDate);
	}

	public ObjectProperty<Date> mroReviewDateProperty() {
		return this.mroReviewDate;
	}
	
	
	private ObjectProperty<Date> finalDeterminationDate   = new SimpleObjectProperty<Date>();

	@Column(name = "final_determination_date")
	@Temporal(TemporalType.DATE)
	public Date getFinalDeterminationDate() {
		return finalDeterminationDate.get();
	}

	public void setFinalDeterminationDate(Date finalDeterminationDate) {
		this.finalDeterminationDate.set(finalDeterminationDate);
	}

	public ObjectProperty<Date> finalDeterminationDateProperty() {
		return this.finalDeterminationDate;
	}
	
	
	private StringProperty reportedTo    = new SimpleStringProperty(this, "reportedTo");

	@Column(name = "reported_to")
	public String getReportedTo() {
		return reportedTo.get();
	}

	public void setReportedTo(String reportedTo) {
		this.reportedTo.set(reportedTo);
	}

	public StringProperty reportedToProperty() {
		return reportedTo;
	}
	
	
	private StringProperty finalDetarmination    = new SimpleStringProperty(this, "finalDetarmination");

	@Column(name = "final_detarmination")
	public String getFinalDetarmination() {
		return finalDetarmination.get();
	}

	public void setFinalDetarmination(String finalDetarmination) {
		this.finalDetarmination.set(finalDetarmination);
	}

	public StringProperty finalDetarminationProperty() {
		return finalDetarmination;
	}
	
	private StringProperty comments    = new SimpleStringProperty(this, "comments");

	@Column(name = "comments")
	public String getComments() {
		return comments.get();
	}

	public void setComments(String comments) {
		this.comments.set(comments);
	}

	public StringProperty commentsProperty() {
		return comments;
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
	
	/*private StringProperty drugTestCode    = new SimpleStringProperty(this, "drugTestCode");

	@Column(name = "drug_test_code")
	public String getDrugTestCode() {
		return drugTestCode.get();
	}

	public void setDrugTestCode(String drugTestCode) {
		this.drugTestCode.set(drugTestCode);
	}

	public StringProperty drugTestCodeProperty() {
		return drugTestCode;
	}
	
	private StringProperty drugTestDescrp    = new SimpleStringProperty(this, "drugTestDescrp");

	@Column(name = "drug_test_descrp")
	public String getDrugTestDescrp() {
		return drugTestDescrp.get();
	}

	public void setDrugTestDescrp(String drugTestDescrp) {
		this.drugTestDescrp.set(drugTestDescrp);
	}

	public StringProperty drugTestDescrpProperty() {
		return drugTestDescrp;
	}
	

	private StringProperty modificationReason    = new SimpleStringProperty(this, "modificationReason");

	@Column(name = "modification_reason")
	public String getModificationReason() {
		return modificationReason.get();
	}

	public void setModificationReason(String drugTestDescrp) {
		this.modificationReason.set(drugTestDescrp);
	}

	public StringProperty modificationReasonProperty() {
		return modificationReason;
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
	}*/

	
		
	
		/*private StringProperty mroReviewedOn     = new SimpleStringProperty(this, "mroReviewedOn");

	@Column(name = "mro_reviewed_on")
	public String getMroReviewedOn() {
		return mroReviewedOn.get();
	}

	public void setMroReviewedOn(String mroReviewedOn) {
		this.mroReviewedOn.set(mroReviewedOn);
	}

	public StringProperty mroReviewedOnProperty() {
		return mroReviewedOn;
	}
	
		private StringProperty employeeNotifiedOn      = new SimpleStringProperty(this, "employeeNotifiedOn");

	@Column(name = "employee_notified_on")
	public String getEmployeeNotifiedOn() {
		return employeeNotifiedOn.get();
	}

	public void setEmployeeNotifiedOn(String employeeNotifiedOn) {
		this.employeeNotifiedOn.set(employeeNotifiedOn);
	}

	public StringProperty employeeNotifiedOnProperty() {
		return employeeNotifiedOn;
	}
		private StringProperty finalDetermin = new SimpleStringProperty(this, "finalDetermin");

	@Column(name = "final_determin")
	public String getFinalDetermin() {
		return finalDetermin.get();
	}

	public void setfinalDetermin(String finalDetermin) {
		this.finalDetermin.set(finalDetermin);
	}

	public StringProperty finalDeterminProperty() {
		return finalDetermin;
	}
		private StringProperty splitSpecimenReq  = new SimpleStringProperty(this, "splitSpecimenReq");

	@Column(name = "split_specimen_req")
	public String getSplitSpecimenReq() {
		return splitSpecimenReq.get();
	}

	public void setSplitSpecimenReq(String splitSpecimenReq) {
		this.splitSpecimenReq.set(splitSpecimenReq);
	}

	public StringProperty splitSpecimenReqProperty() {
		return splitSpecimenReq;
	}
	private ObjectProperty<Date> finalDeterminDate    = new SimpleObjectProperty<Date>();

	@Column(name = "final_determin_date")
	@Temporal(TemporalType.DATE)
	public Date getFinalDeterminDate() {
		return finalDeterminDate.get();
	}

	public void setFinalDeterminDate(Date finalDeterminDate) {
		this.finalDeterminDate.set(finalDeterminDate);
	}

	public ObjectProperty<Date> finalDeterminDateProperty() {
		return this.finalDeterminDate;
	}
	
	private StringProperty splitResultReceived   = new SimpleStringProperty(this, "splitResultReceived");

	@Column(name = "split_result_received")
	public String getSplitResultReceived() {
		return splitResultReceived.get();
	}

	public void setSplitResultReceived(String splitResultReceived) {
		this.splitResultReceived.set(splitResultReceived);
	}

	public StringProperty splitResultReceivedProperty() {
		return splitResultReceived;
	}

	private StringProperty reportedToEmployerBy    = new SimpleStringProperty(this, "reportedToEmployerBy");

	@Column(name = "reported_to_employer_by")
	public String getReportedToEmployerBy() {
		return reportedToEmployerBy.get();
	}

	public void setReportedToEmployerBy(String reportedToEmployerBy) {
		this.reportedToEmployerBy.set(reportedToEmployerBy);
	}

	public StringProperty reportedToEmployerByProperty() {
		return reportedToEmployerBy;
	}
   
	private StringProperty comments     = new SimpleStringProperty(this, "comments");

	@Column(name = "comments")
	public String getComments() {
		return comments.get();
	}

	public void setComments(String comments) {
		this.comments.set(comments);
	}

	public StringProperty commentsProperty() {
		return comments;
	}*/
	//private SimpleObjectProperty<MedicalActivityCharge> medActCharge = new SimpleObjectProperty<MedicalActivityCharge>(this, "medActCharge");
	
    private MedicalActivityCharge medActCharge;
    @OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
/*	public SimpleObjectProperty<MedicalActivityCharge> getMedActCharge() {
		return medActCharge;
	}

	public void setMedActCharge(SimpleObjectProperty<MedicalActivityCharge> medActCharge) {
		this.medActCharge = medActCharge;
	}*/
	public MedicalActivityCharge getMedActCharge() {
		return medActCharge;
	}

	public void setMedActCharge(MedicalActivityCharge medActCharge) {
		this.medActCharge = medActCharge;
	}

	private List<DrugScreenTestResult> drugScreenTest;
	@OneToMany(fetch = FetchType.LAZY, mappedBy= "drugScreenId",orphanRemoval =true,cascade=CascadeType.ALL)
	public List<DrugScreenTestResult> getDrugScreenTest() {
		return drugScreenTest;
	}

	public void setDrugScreenTest(List<DrugScreenTestResult> drugScreenTest) {
		this.drugScreenTest = drugScreenTest;
	}


	public DrugScreenResult(){
		
	}

	

	

	

		
	
	
	
}