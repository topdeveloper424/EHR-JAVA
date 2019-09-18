package com.ets.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Cascade;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Table(name="patient_visit")
@Entity
public class PatientVisit {
	
	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	private StringProperty visitType = new SimpleStringProperty(this, "visitType");

	@Column(name = "visit_type")
	public String getVisitType() {
		return visitType.get();
	}

	public void setVisitType(String visitType) {
		this.visitType.set(visitType);
	}

	public StringProperty visitTypeProperty() {
		return visitType;
	}
	
	private StringProperty type = new SimpleStringProperty(this, "type");

	@Column(name = "pat_type")
	public String getType() {
		return type.get();
	}

	public void setType(String type) {
		this.type.set(type);
	}

	public StringProperty typeProperty() {
		return type;
	}
	
	private StringProperty arrivalTime = new SimpleStringProperty(this, "arrivalTime");

	@Column(name = "arrival_time")
	public String getArrivalTime() {
		return arrivalTime.get();
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime.set(arrivalTime);
	}

	public StringProperty arrivalTimeProperty() {
		return arrivalTime;
	}
	
	private StringProperty startTime = new SimpleStringProperty(this, "startTime");

	@Column(name = "start_time")
	public String getStartTime() {
		return startTime.get();
	}

	public void setStartTime(String startTime) {
		this.startTime.set(startTime);
	}

	public StringProperty startTimeProperty() {
		return startTime;
	}
	
	private ObjectProperty<Date> visitDate = new SimpleObjectProperty<Date>();

	@Column(name = "visit_date")
	@Temporal(TemporalType.DATE)
	public Date getVisitDate() {
		return visitDate.get();
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate.set(visitDate);
	}

	public ObjectProperty<Date> visitDateProperty() {
		return this.visitDate;
	}
	
	private StringProperty completionTime = new SimpleStringProperty(this, "completionTime");

	@Column(name = "completion_time")
	public String getCompletionTime() {
		return completionTime.get();
	}

	public void setCompletionTime(String completionTime) {
		this.completionTime.set(completionTime);
	}

	public StringProperty completionTimeProperty() {
		return completionTime;
	}
	
	
	private SimpleObjectProperty<VisitCategory> visitCategory = new SimpleObjectProperty<VisitCategory>(this,
			"visitCategory");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "visit_category_id")
	public VisitCategory getVisitCategory() {
		return visitCategory.get();
	}

	public void setVisitCategory(VisitCategory visitCategory) {
		this.visitCategory.set(visitCategory);
	}

	public SimpleObjectProperty<VisitCategory> visitCategoryProperty() {
		return visitCategory;
	}
	
	/*private SimpleObjectProperty<Icd10Codes> icd10Codes = new SimpleObjectProperty<Icd10Codes>(this,
			"icd10Codes");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "icd10_codes_id")
	public Icd10Codes getIcd10Codes() {
		return icd10Codes.get();
	}

	public void setIcd10Codes(Icd10Codes icd10Codes) {
		this.icd10Codes.set(icd10Codes);
	}

	public SimpleObjectProperty<Icd10Codes> icd10CodesProperty() {
		return icd10Codes;
	}*/
	
	private StringProperty providerTimeIn = new SimpleStringProperty(this, "providerTimeIn");

	@Column(name = "providerTimeIn")
	public String getProviderTimeIn() {
		return providerTimeIn.get();
	}

	public void setProviderTimeIn(String providerTimeIn) {
		this.providerTimeIn.set(providerTimeIn);
	}

	public StringProperty providerTimeInProperty() {
		return providerTimeIn;
	}
	
	private StringProperty providerTimeOut = new SimpleStringProperty(this, "providerTimeOut");

	@Column(name = "provider_time_out")
	public String getProviderTimeOut() {
		return providerTimeOut.get();
	}

	public void setProviderTimeOut(String providerTimeOut) {
		this.providerTimeOut.set(providerTimeOut);
	}

	public StringProperty providerTimeOutProperty() {
		return providerTimeOut;
	}
	
	private StringProperty purpose = new SimpleStringProperty(this, "purpose");

	@Column(name = "purpose")
	public String getPurpose() {
		return purpose.get();
	}

	public void setPurpose(String purpose) {
		this.purpose.set(purpose);
	}

	public StringProperty purposeProperty() {
		return purpose;
	}
	
	private StringProperty visitLocation = new SimpleStringProperty(this, "visitLocation");

	@Column(name = "visit_location")
	public String getVisitLocation() {
		return visitLocation.get();
	}

	public void setVisitLocation(String visitLocation) {
		this.visitLocation.set(visitLocation);
	}

	public StringProperty visitLocationProperty() {
		return visitLocation;
	}
	
	private StringProperty meansOfArrival = new SimpleStringProperty(this, "meansOfArrival");

	
	
	
    private List<Icd10Codes> icd10Codes;
    @ManyToMany(cascade =CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinTable(name = "patient_visit_icd", joinColumns = {@JoinColumn(name="patVisitId", unique=false)}, inverseJoinColumns = {@JoinColumn(name="icdId", unique=false)})
    public List<Icd10Codes> getIcd10Codes() {
		return icd10Codes;
	}

	public void setIcd10Codes(List<Icd10Codes> icd10Codes) {
		this.icd10Codes = icd10Codes;
	}

//@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,orphanRemoval=true) 
    //@JoinTable(name = "patient_visit_icd", joinColumns = {@JoinColumn(name="patVisitId", unique=false)}, inverseJoinColumns = {@JoinColumn(name="icdId", unique=false)})
  
  
  // @JoinTable(name = "patient_visit_icd", joinColumns = {@JoinColumn(name="patVisitId", unique=false)}, inverseJoinColumns = {@JoinColumn(name="icdId", unique=false)})
	
   


	@Column(name = "means_of_arrival")
	public String getMeansOfArrival() {
		return meansOfArrival.get();
	}

	public void setMeansOfArrival(String meansOfArrival) {
		this.meansOfArrival.set(meansOfArrival);
	}

	public StringProperty meansOfArrivalProperty() {
		return meansOfArrival;
	}

	private SimpleObjectProperty<Provider> provider = new SimpleObjectProperty<Provider>(this, "provider");

	@ManyToOne(fetch = FetchType.EAGER)
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
	
		
	private SimpleObjectProperty<ReferalProvider> referredBy = new SimpleObjectProperty<ReferalProvider>(this, "referredBy");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "referredBy")

	public ReferalProvider getReferredBy() {
		return referredBy.get();
	}

	public void setReferredBy(ReferalProvider referredBy) {
		this.referredBy.set(referredBy);
	}

	public SimpleObjectProperty<ReferalProvider> referredByProperty() {
		return referredBy;
	}
	
	private SimpleObjectProperty<Provider> billingPsysician = new SimpleObjectProperty<Provider>(this, "billingPsysician");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "billing_physician_id")

	public Provider getBillingPsysician() {
		return billingPsysician.get();
	}

	public void setBillingPsysician(Provider billingPsysician) {
		this.billingPsysician.set(billingPsysician);
	}

	public SimpleObjectProperty<Provider> billingPsysicianProperty() {
		return billingPsysician;
	}
	
	private SimpleObjectProperty<Clinician> clinician= new SimpleObjectProperty<Clinician>(this, "clinician");

	@ManyToOne(fetch = FetchType.EAGER)
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
	
		
	
	/*private SimpleObjectProperty<Clinic> clinic= new SimpleObjectProperty<Clinic>(this, "clinic");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinic_id")
	public Clinic getClinic() {
		return clinic.get();
	}

	public void setClinic(Clinic clinic) {
		this.clinic.set(clinic);
	}

	public SimpleObjectProperty<Clinic> clinicProperty() {
		return clinic;
	}
	

	
	
	public void setClinic(SimpleObjectProperty<Clinic> clinic) {
		this.clinic = clinic;
	}*/

	
	
	/*	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;

		public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}
*/
	
	
	
	
	
	private StringProperty summary = new SimpleStringProperty(this, "summary");

	@Column(name = "summary")
	public String getSummary() {
		return summary.get();
	}

	public void setSummary(String summary) {
		this.summary.set(summary);
	}

	public StringProperty summaryProperty() {
		return summary;
	}
	
	private StringProperty visitStatus = new SimpleStringProperty(this, "visitStatus");

	@Column(name = "visit_status")
	public String getVisitStatus() {
		return visitStatus.get();
	}

	public void setVisitStatus(String visitStatus) {
		this.visitStatus.set(visitStatus);
	}

	public StringProperty visitStatusProperty() {
		return visitStatus;
	}
	
	private StringProperty alertNotes = new SimpleStringProperty(this, "alertNotes");

	@Column(name = "alert_notes")
	public String getAlertNotes() {
		return alertNotes.get();
	}

	public void setAlertNotes(String alertNotes) {
		this.alertNotes.set(alertNotes);
	}

	public StringProperty alertNotesProperty() {
		return alertNotes;
	}
	
	private StringProperty protocolInstruction = new SimpleStringProperty(this, "protocolInstruction");

	@Column(name = "protocolInstruction")
	public String getProtocolInstruction() {
		return protocolInstruction.get();
	}

	public void setProtocolInstruction(String protocolInstruction) {
		this.protocolInstruction.set(protocolInstruction);
	}

	public StringProperty protocolInstructionProperty() {
		return protocolInstruction;
	}
	
	private StringProperty overridePayer = new SimpleStringProperty(this, "overridePayer");

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
	
	private SimpleObjectProperty<BillingAccount> billingAccount = new SimpleObjectProperty<BillingAccount>(this,
			"billingAccount");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "billing_ac_id")
	public BillingAccount getBillingAccount() {
		return billingAccount.get();
	}

	public void setBillingAccount(BillingAccount billingAccount) {
		this.billingAccount.set(billingAccount);
	}

	public SimpleObjectProperty<BillingAccount> billingAccountProperty() {
		return billingAccount;
	}
	
	private SimpleObjectProperty<Patient> patient = new SimpleObjectProperty<Patient>(this,
			"patient");

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
	
	/*private List<MedicalActivityCharge> medicalActivityCharge ;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="patientVisit" , cascade=CascadeType.ALL)
	public List<MedicalActivityCharge> getMedicalActivityCharge() {
		return medicalActivityCharge;
	}

	public void setMedicalActivityCharge(List<MedicalActivityCharge> medicalActivityCharge) {
		this.medicalActivityCharge = medicalActivityCharge;
	}*/

	@Column(name = "status")
	private StringProperty status = new SimpleStringProperty(this, "status");
	public String getStatus() {
		return status.get();
	}

	public void setStatus(String status) {
		this.status.set(status);
	}

	public StringProperty statusProperty() {
		return status;
	}
	private StringProperty visitStatusWhite = new SimpleStringProperty(this, "visitStatusWhite");

	@Column(name = "visitStatusWhite")

	public String getVisitStatusWhite() {
		return visitStatusWhite.get();
	}

	public void setVisitStatusWhite(String visitStatusWhite) {
		this.visitStatusWhite.set(visitStatusWhite);
	}

	public StringProperty visitStatusWhiteProperty() {
		return visitStatusWhite;
	}

	private StringProperty procedure = new SimpleStringProperty(this, "procedure");

	@Column(name = "procedure1")

	public String getProcedure() {
		return procedure.get();
	}

	public void setProcedure(String procedure) {
		this.procedure.set(procedure);
	}

	public StringProperty procedureProperty() {
		return procedure;
	}
	


	private  SimpleBooleanProperty waitingRoom = new SimpleBooleanProperty(this, "waitingRoom");

	@Column(name = "waitingroom")
	public  boolean getWaitingRoom() {
		return waitingRoom.get();
	}

	public  void setWaitingRoom(boolean waitingRoom) {
		this.waitingRoom.set(waitingRoom);
	}

	public BooleanProperty waitingRoomProperty() {
		return waitingRoom;
	}
	
	private  SimpleBooleanProperty lab = new SimpleBooleanProperty(this, "lab");

	@Column(name = "lab")
	public  boolean getLab() {
		return lab.get();
	}

	public  void setLab(boolean lab) {
		this.lab.set(lab);
	}

	public BooleanProperty labProperty() {
		return lab;
	}
	private  SimpleBooleanProperty xRay = new SimpleBooleanProperty(this, "xRay");

	@Column(name = "xRay")
	public  boolean getXRay() {
		return xRay.get();
	}

	public  void setXRay(boolean xRay) {
		this.xRay.set(xRay);
	}

	public BooleanProperty xRayProperty() {
		return xRay;
	}
	private  SimpleBooleanProperty checkOut = new SimpleBooleanProperty(this, "checkOut");

	@Column(name = "checkout")
	public  boolean getCheckOut() {
		return checkOut.get();
	}

	public  void setCheckOut(boolean checkOut) {
		this.checkOut.set(checkOut);
	}

	public BooleanProperty checkOutProperty() {
		return checkOut;
	}
	
	
	private  SimpleBooleanProperty examRoom1 = new SimpleBooleanProperty(this, "examRoom1");

	@Column(name = "exam_room1")
	public  boolean getExamRoom1() {
		return examRoom1.get();
	}

	public  void setExamRoom1(boolean examRoom1) {
		this.examRoom1.set(examRoom1);
	}

	public BooleanProperty examRoom1Property() {
		return examRoom1;
	}
	private  SimpleBooleanProperty examRoom2 = new SimpleBooleanProperty(this, "examRoom2");

	@Column(name = "exam_room2")
	public  boolean getExamRoom2() {
		return examRoom2.get();
	}

	public  void setExamRoom2(boolean examRoom2) {
		this.examRoom2.set(examRoom2);
	}

	public BooleanProperty examRoom2Property() {
		return examRoom2;
	}
	
	
	private  SimpleBooleanProperty examRoom7 = new SimpleBooleanProperty(this, "examRoom7");

	@Column(name = "exam_room7")
	public  boolean getExamRoom7() {
		return examRoom7.get();
	}

	public  void setExamRoom7(boolean examRoom7) {
		this.examRoom7.set(examRoom7);
	}

	public BooleanProperty examRoom7() {
		return examRoom7;
	}
	
	
	private  SimpleBooleanProperty eyeRoom = new SimpleBooleanProperty(this, "eyeRoom");

	@Column(name = "eye_room")
	public  boolean getEyeRoom() {
		return eyeRoom.get();
	}

	public  void setEyeRoom(boolean eyeRoom) {
		this.eyeRoom.set(eyeRoom);
	}

	public BooleanProperty eyeRoom() {
		return eyeRoom;
	}
	
	
	private  SimpleBooleanProperty hcg = new SimpleBooleanProperty(this, "hcg");

	@Column(name = "hcg")
	public  boolean getHcg() {
		return hcg.get();
	}

	public  void setHcg(boolean hcg) {
		this.hcg.set(hcg);
	}

	public BooleanProperty hcg() {
		return hcg;
	}
	
	
	private  SimpleBooleanProperty physicalRoom = new SimpleBooleanProperty(this, "physicalRoom");

	@Column(name = "physical_room")
	public  boolean getPhysicalRoom() {
		return physicalRoom.get();
	}

	public  void setPhysicalRoom(boolean physicalRoom) {
		this.physicalRoom.set(physicalRoom);
	}

	public BooleanProperty physicalRoom() {
		return physicalRoom;
	}
	
	private  SimpleBooleanProperty lacerationRoom = new SimpleBooleanProperty(this, "lacerationRoom");

	@Column(name = "laceration_room")
	public  boolean getlacerationRoom() {
		return lacerationRoom.get();
	}

	public  void setLacerationRoom(boolean lacerationRoom) {
		this.lacerationRoom.set(lacerationRoom);
	}

	public BooleanProperty lacerationRoom() {
		return lacerationRoom;
	}

	
	private SimpleObjectProperty<EmrChartingTextAreaSave> emrChartingTestArea = new SimpleObjectProperty<EmrChartingTextAreaSave>(this, "emrChartingTextAreaSave");

	@OneToOne(mappedBy="patientVisit")
	@JoinColumn(name = "emrChartingTestArea")

	public EmrChartingTextAreaSave getEmrChartingTextAreaSave() {
		return emrChartingTestArea.get();
	}

	public void setEmrChartingTextAreaSave(EmrChartingTextAreaSave emrChartingTestArea) {
		this.emrChartingTestArea.set(emrChartingTestArea);
	}

	public SimpleObjectProperty<EmrChartingTextAreaSave> emrChartingTestAreaProperty() {
		return emrChartingTestArea;
	}
	
	
	private SimpleObjectProperty<CompanyProtocol> companyProtocol = new SimpleObjectProperty<CompanyProtocol>(this, "companyProtocol");

	
	@ManyToOne(cascade=CascadeType.ALL)
	//@Cascade(org.hibernate.annotations.CascadeType.ALL)
	@JoinColumn(name = "company_protocol_id")
	public CompanyProtocol getCompanyProtocol() {
		return companyProtocol.get();
	}

	public void setCompanyProtocol(CompanyProtocol companyProtocol) {
		this.companyProtocol.set(companyProtocol);
	}

	public SimpleObjectProperty<CompanyProtocol> companyProtocolProperty() {
		return companyProtocol;
	}
	
	
	private List<FlowsheetSpecialOrder> flowsheetSpecialOrder;
	@OneToMany(fetch = FetchType.LAZY , mappedBy="patientVisit" , cascade=CascadeType.ALL)
	
	public List<FlowsheetSpecialOrder> getFlowsheetSpecialOrder() {
		return flowsheetSpecialOrder;
	}

	public void setFlowsheetSpecialOrder(List<FlowsheetSpecialOrder> flowsheetSpecialOrder) {
		this.flowsheetSpecialOrder = flowsheetSpecialOrder;
	}
	
	
	
	public PatientVisit() {
		
	}

}
