package com.ets.model;

import java.util.List;

import javax.persistence.CascadeType;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Patient Class
 *Description: Entity class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "patient")
public class Patient {
	
	/***************
	 * Column property ( 1 )
	 *****************************************/

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
	
	// Column 2
				private StringProperty socialSecurityNo = new SimpleStringProperty(this, "socialSecurityNo");

				@Column(name = "social_security_no")
				public String getSocialSecurityNo() {
					return socialSecurityNo.get();
				}

				public void setSocialSecurityNo(String socialSecurityNo) {
					this.socialSecurityNo.set(socialSecurityNo);
				}

				public StringProperty socialSecurityNoProperty() {
					return socialSecurityNo;
				}
				
				// Column 13
				private SimpleObjectProperty<Company> company = new SimpleObjectProperty<Company>(this, "company");

				@ManyToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "company_id")
				public Company getCompany() {
					return company.get();
				}

				public void setCompany(Company company) {
					this.company.set(company);
				}
				
				public SimpleObjectProperty<Company> companyProperty() {
					return company;
				}
				
				// Column 13
				private SimpleObjectProperty<Address> address = new SimpleObjectProperty<Address>(this, "address");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "address_id")
				public Address getAddress() {
					return address.get();
				}

				public void setAddress(Address address) {
					this.address.set(address);
				}

				public SimpleObjectProperty<Address> addressProperty() {
					return address;
				}
				
				
				private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

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
				
				
				// Column 2
				private StringProperty photoName = new SimpleStringProperty(this, "photoName");

				@Column(name = "photo_name")
				public String getPhotoName() {
					return photoName.get();
				}

				public void setPhotoName(String photoName) {
					this.photoName.set(photoName);
				}

				public StringProperty photoNameProperty() {
					return photoName;
				}
				
				// Column 13
				private SimpleObjectProperty<PatientAuthRep> patientAuthRep = new SimpleObjectProperty<PatientAuthRep>(this, "patientAuthRep");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "patient_auth_rep_id")
				public PatientAuthRep getPatientAuthRep() {
					return patientAuthRep.get();
				}

				public void setPatientAuthRep(PatientAuthRep patientAuthRep) {
					this.patientAuthRep.set(patientAuthRep);
				}

				public SimpleObjectProperty<PatientAuthRep> patientAuthRepProperty() {
					return patientAuthRep;
				}
				
				// Column 13
				private SimpleObjectProperty<PatientAddlContactInfo> addlContactInfoId = new SimpleObjectProperty<PatientAddlContactInfo>(this, "addlContactInfoId");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "addl_contact_info_id")
				public PatientAddlContactInfo getAddlContactInfoId() {
					return addlContactInfoId.get();
				}

				public void setAddlContactInfoId(PatientAddlContactInfo addlContactInfoId) {
					this.addlContactInfoId.set(addlContactInfoId);
				}

				public SimpleObjectProperty<PatientAddlContactInfo> addlContactInfoIdProperty() {
					return addlContactInfoId;
				}
				
				// Column 13
				private SimpleObjectProperty<PatientInsuranceCarrier> patientInsuranceCarrier= new SimpleObjectProperty<PatientInsuranceCarrier>(this, "patientInsuranceCarrier");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "patient_insurance_carrier_id")
				public PatientInsuranceCarrier getPatientInsuranceCarrier() {
					return patientInsuranceCarrier.get();
				}

				public void setPatientInsuranceCarrier(PatientInsuranceCarrier patientInsuranceCarrier) {
					this.patientInsuranceCarrier.set(patientInsuranceCarrier);
				}

				public SimpleObjectProperty<PatientInsuranceCarrier> patientInsuranceCarrierProperty() {
					return patientInsuranceCarrier;
				}
				
				// Column 13
				private SimpleObjectProperty<PatientDrivingLicense> patientDrivingLicense= new SimpleObjectProperty<PatientDrivingLicense>(this, "patientDrivingLicense");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "patient_driving_license_id")
				public PatientDrivingLicense getPatientDrivingLicense() {
					return patientDrivingLicense.get();
				}

				public void setPatientDrivingLicense(PatientDrivingLicense patientInsuranceCarrier) {
					this.patientDrivingLicense.set(patientInsuranceCarrier);
				}

				public SimpleObjectProperty<PatientDrivingLicense> patientDrivingLicenseProperty() {
					return patientDrivingLicense;
				}
				
				// Column 13
				private SimpleObjectProperty<PatientName> patientName= new SimpleObjectProperty<PatientName>(this, "patientName");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "patient_name")
				public PatientName getPatientName() {
					return patientName.get();
				}

				public void setPatientName(PatientName patientName) {
					this.patientName.set(patientName);
				}

				public SimpleObjectProperty<PatientName> patientNameProperty() {
					return patientName;
				}
				
				// Column 13
				private SimpleObjectProperty<PatientStatistic> patientStatistic= new SimpleObjectProperty<PatientStatistic>(this, "patientStatistic");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "patient_statistic")
				public PatientStatistic getPatientStatistic() {
					return patientStatistic.get();
				}

				public void setPatientStatistic(PatientStatistic patientStatistic) {
					this.patientStatistic.set(patientStatistic);
				}

				public SimpleObjectProperty<PatientStatistic> patientStatisticProperty() {
					return patientStatistic;
				}
				
				private SimpleObjectProperty<PatientSmokingStatus> patientSmokingStatus= new SimpleObjectProperty<PatientSmokingStatus>(this, "patientSmokingStatus");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "patient_smokingStatus")
				public PatientSmokingStatus getPatientSmokingStatus() {
					return patientSmokingStatus.get();
				}

				public void setPatientSmokingStatus(PatientSmokingStatus patientSmokingStatus) {
					this.patientSmokingStatus.set(patientSmokingStatus);
				}

				public SimpleObjectProperty<PatientSmokingStatus> patientSmokingStatusProperty() {
					return patientSmokingStatus;
				}
				
				private SimpleObjectProperty<PatientRiskFactor> patientRiskFactor= new SimpleObjectProperty<PatientRiskFactor>(this, "patientRiskFactor");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "patient_risk_factor")
				public PatientRiskFactor getPatientRiskFactor() {
					return patientRiskFactor.get();
				}

				public void setPatientRiskFactor(PatientRiskFactor patientRiskFactor) {
					this.patientRiskFactor.set(patientRiskFactor);
				}

				public SimpleObjectProperty<PatientRiskFactor> patientRiskFactorProperty() {
					return patientRiskFactor;
				}
				
				// Column 2
				private StringProperty medicalRecordNo = new SimpleStringProperty(this, "medicalRecordNo");

				@Column(name = "medical_record_no")
				public String getmedicalRecordNo() {
					return medicalRecordNo.get();
				}

				public void setMedicalRecordNo(String medicalRecordNo) {
					this.medicalRecordNo.set(medicalRecordNo);
				}

				public StringProperty medicalRecordNoProperty() {
					return medicalRecordNo;
				}
				
				// Column 13
				private SimpleObjectProperty<Provider> pcp= new SimpleObjectProperty<Provider>(this, "pcp");

				@ManyToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "pcp_id")
				public Provider getPcp() {
					return pcp.get();
				}

				public void setPcp(Provider pcp) {
					this.pcp.set(pcp);
				}

				public SimpleObjectProperty<Provider> pcpProperty() {
					return pcp;
				}
				
				// Column 13
				private SimpleObjectProperty<Provider> preferredProvider= new SimpleObjectProperty<Provider>(this, "pcp");

				@ManyToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "preferred_provider_id")
				public Provider getPreferredProvider() {
					return preferredProvider.get();
				}

				public void setPreferredProvider(Provider preferredProvider) {
					this.preferredProvider.set(preferredProvider);
				}

				public SimpleObjectProperty<Provider> preferredProviderProperty() {
					return preferredProvider;
				}
				
				private List<PatientAppointment> patientAppointments;

				@OneToMany(fetch = FetchType.LAZY , mappedBy="patient" , cascade=CascadeType.ALL)
				public List<PatientAppointment> getPatientAppointments() {
					return patientAppointments;
				}

				public void setPatientAppointments(List<PatientAppointment> patientAppointments) {
					this.patientAppointments = patientAppointments;
				}
				
				private List<DrugScreenTestResult> drugScreenTestResults;
				
				@OneToMany(fetch = FetchType.LAZY , mappedBy="patient" , cascade=CascadeType.ALL)
				public List<DrugScreenTestResult> getDrugScreenTestResults() {
					return drugScreenTestResults;
				}

				public void setDrugScreenTestResults(List<DrugScreenTestResult> drugScreenTestResults) {
					this.drugScreenTestResults = drugScreenTestResults;
				}
				
				private List<PatientVisit> patientVisits;
				
				@OneToMany(fetch = FetchType.LAZY , mappedBy="patient" , cascade=CascadeType.ALL)
				public List<PatientVisit> getPatientVisits() {
					return patientVisits;
				}

				public void setPatientVisits(List<PatientVisit> patientVisits) {
					this.patientVisits = patientVisits;
				}
				
				private List<Assesment> assesment;
				
				@OneToMany(fetch = FetchType.LAZY , mappedBy="patient" , cascade=CascadeType.ALL)
				public List<Assesment> getAssesment() {
					return assesment;
				}

				public void setAssesment(List<Assesment> assesment) {
					this.assesment = assesment;
				}
				
				private List<EmrHpi> emrHpi;
				
				@OneToMany(fetch = FetchType.LAZY , mappedBy="patient" , cascade=CascadeType.ALL)
				public List<EmrHpi> getEmrHpi() {
					return emrHpi;
				}

				public void setEmrHpi(List<EmrHpi> emrHpi) {
					this.emrHpi = emrHpi;
				}
				private StringProperty imagePath = new SimpleStringProperty(this, "imagePath");

				@Column(name = "imagePath")

				public String getImagePath() {
					return imagePath.get();
				}

				public void setImagePath(String imagePath) {
					this.imagePath.set(imagePath);
				}

				public StringProperty imagePathProperty() {
					return imagePath;
				}
				public Patient() {
		
				}
				
				
				
				private List<RepresentRelation> repRelation;
				@OneToMany(fetch = FetchType.LAZY, mappedBy="patient", cascade=CascadeType.ALL)
				public List<RepresentRelation> getRepRelation() {
					return repRelation;
				}

				public void setRepRelation(List<RepresentRelation> repRelation) {
					this.repRelation = repRelation;
				}

				

}
