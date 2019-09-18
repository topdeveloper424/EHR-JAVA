package com.ets.model;

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

import org.hibernate.annotations.Cascade;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 23-12-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Company Protocol Class
 *Description: Model Class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:Neha Sahadev
 *Owner:
 *Date:21/11/2017
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

@Entity
@Table(name = "company_protocol")
public class CompanyProtocol {
	
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
	
	
	private StringProperty protocolType = new SimpleStringProperty(this, "protocolType");

	@Column(name = "protocol_type")
	public String getProtocolType() {
		return protocolType.get();
	}

	public void setProtocolType(String protocolType) {
		this.protocolType.set(protocolType);
	}

	public StringProperty protocolTypeProperty() {
		return protocolType;
	}
	
	private StringProperty description = new SimpleStringProperty(this, "description");

	@Column(name = "description")
	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description.set(description);
	}

	public StringProperty descriptionProperty() {
		return description;
	}
	
	private StringProperty userFormName = new SimpleStringProperty(this, "userFormName");

	@Column(name = "user_form_name")
	public String getUserFormName() {
		return userFormName.get();
	}

	public void setUserFormName(String userFormName) {
		this.userFormName.set(userFormName);
	}

	public StringProperty userFormNameProperty() {
		return userFormName;
	}
	
	private StringProperty overrideminute = new SimpleStringProperty(this, "overrideminute");

	@Column(name = "override_minute")
	public String getOverrideminute() {
		return overrideminute.get();
	}

	public void setOverrideminute(String overrideminute) {
		this.overrideminute.set(overrideminute);
	}

	public StringProperty overrideminuteProperty() {
		return overrideminute;
	}
	
	private StringProperty aboveAmount = new SimpleStringProperty(this, "aboveAmount");

	@Column(name = "above_amount")
	public String getAboveAmount() {
		return aboveAmount.get();
	}

	public void setAboveAmount(String aboveAmount) {
		this.aboveAmount.set(aboveAmount);
	}

	public StringProperty aboveAmountProperty() {
		return aboveAmount;
	}
	
	
	
	private StringProperty phoneNumber = new SimpleStringProperty(this, "phoneNumber");

	@Column(name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber.get();
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber.set(phoneNumber);
	}

	public StringProperty phoneNumberProperty() {
		return phoneNumber;
	}
	
	
	private StringProperty nameOrDepartment = new SimpleStringProperty(this, "nameOrDepartment");

	@Column(name = "name_or_department")
	public String getNameOrDepartment() {
		return nameOrDepartment.get();
	}

	public void setNameOrDepartment(String nameOrDepartment) {
		this.nameOrDepartment.set(nameOrDepartment);
	}

	public StringProperty nameOrDepartmentProperty() {
		return nameOrDepartment;
	}
	
	
	private StringProperty ptOt = new SimpleStringProperty(this, "ptOt");

	@Column(name = "pt_ot")
	public String getPtOt() {
		return ptOt.get();
	}

	public void setPtOt(String ptOt) {
		this.ptOt.set(ptOt);
	}

	public StringProperty ptOtProperty() {
		return ptOt;
	}
	
	
	private StringProperty referrals = new SimpleStringProperty(this, "referrals");

	@Column(name = "referrals")
	public String getReferrals() {
		return referrals.get();
	}

	public void setReferrals(String referrals) {
		this.referrals.set(referrals);
	}

	public StringProperty referralsProperty() {
		return referrals;
	}
	
	
	private StringProperty reportResult = new SimpleStringProperty(this, "reportResult");

	@Column(name = "report_result")
	public String getReportResult() {
		return reportResult.get();
	}

	public void setReportResult(String reportResult) {
		this.reportResult.set(reportResult);
	}

	public StringProperty reportResultProperty() {
		return reportResult;
	}
	
	
	private StringProperty mailAddress = new SimpleStringProperty(this, "mailAddress");

	@Column(name = "mail_address")
	public String getMailAddress() {
		return mailAddress.get();
	}

	public void setMailAddress(String mailAddress) {
		this.mailAddress.set(mailAddress);
	}

	public StringProperty mailAddressProperty() {
		return mailAddress;
	}
	
	
	private StringProperty city = new SimpleStringProperty(this, "city");

	@Column(name = "city")
	public String getCity() {
		return city.get();
	}

	public void setCity(String city) {
		this.city.set(city);
	}

	public StringProperty cityProperty() {
		return city;
	}
	
	private StringProperty state = new SimpleStringProperty(this, "state");

	@Column(name = "state")
	public String getState() {
		return state.get();
	}

	public void setState(String state) {
		this.state.set(state);
	}

	public StringProperty stateProperty() {
		return state;
	}
	
	private StringProperty zip = new SimpleStringProperty(this, "zip");

	@Column(name = "zip")
	public String getZip() {
		return zip.get();
	}

	public void setZip(String zip) {
		this.zip.set(zip);
	}

	public StringProperty zipProperty() {
		return zip;
	}
	
	
	private StringProperty phone = new SimpleStringProperty(this, "phone");

	@Column(name = "phone")
	public String getPhone() {
		return phone.get();
	}

	public void setPhone(String phone) {
		this.phone.set(phone);
	}

	public StringProperty phoneProperty() {
		return phone;
	}
	
	
	private StringProperty faxResult = new SimpleStringProperty(this, "faxResult");

	@Column(name = "fax_result")
	public String getFaxResult() {
		return faxResult.get();
	}

	public void setFaxResult(String faxResult) {
		this.faxResult.set(faxResult);
	}

	public StringProperty faxResultProperty() {
		return faxResult;
	}
	
	
	private StringProperty emailResult = new SimpleStringProperty(this, "emailResult");

	@Column(name = "email_result")
	public String getEmailResult() {
		return emailResult.get();
	}

	public void setEmailResult(String emailResult) {
		this.emailResult.set(emailResult);
	}

	public StringProperty emailResultProperty() {
		return emailResult;
	}
	
	
	
	private StringProperty instruction = new SimpleStringProperty(this, "instruction");

	@Column(name = "instruction")
	public String getInstruction() {
		return instruction.get();
	}

	public void setInstruction(String instruction) {
		this.instruction.set(instruction);
	}

	public StringProperty instructionProperty() {
		return instruction;
	}
	
	
	private SimpleObjectProperty<VisitCategory> visitCategory = new SimpleObjectProperty<VisitCategory>(this, "visitCategory");

	@ManyToOne
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
	
	
	private SimpleObjectProperty<JobClass> jobClass = new SimpleObjectProperty<JobClass>(this, "jobClass");

	@ManyToOne
	@JoinColumn(name = "job_class_id")
	public JobClass getJobClass() {
		return jobClass.get();
	}

	public void setJobClass(JobClass jobClass) {
		this.jobClass.set(jobClass);
	}

	public SimpleObjectProperty<JobClass> jobClassProperty() {
		return jobClass;
	}
	
	private SimpleObjectProperty<DepartmentUnit> departmentUnit = new SimpleObjectProperty<DepartmentUnit>(this, "departmentUnit");

	@ManyToOne
	@JoinColumn(name = "department_unit_id")
	public DepartmentUnit getDepartmentUnit() {
		return departmentUnit.get();
	}

	public void setDepartmentUnit(DepartmentUnit departmentUnit) {
		this.departmentUnit.set(departmentUnit);
	}

	public SimpleObjectProperty<DepartmentUnit> departmentUnitProperty() {
		return departmentUnit;
	}
	
	private SimpleObjectProperty<Company> company = new SimpleObjectProperty<Company>(this, "company");

	@ManyToOne
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
	
    private List<PatientVisit> patientVisit ;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="companyProtocol" , cascade=CascadeType.ALL)
	
	public List<PatientVisit> getPatientVisit() {
		return patientVisit;
	}

	public void setPatientVisit(List<PatientVisit> patientVisit) {
		this.patientVisit = patientVisit;
	}
	
	
	private List<CompanyOptionalProtocolActivity> optionalProtocolActivity ;
    
	@OneToMany(fetch = FetchType.LAZY , mappedBy="companyProtocol" , cascade=CascadeType.ALL,orphanRemoval=true)
	public List<CompanyOptionalProtocolActivity> getOptionalProtocolActivity() {
		return optionalProtocolActivity;
	}

	public void setOptionalProtocolActivity(List<CompanyOptionalProtocolActivity> optionalProtocolActivity) {
		this.optionalProtocolActivity = optionalProtocolActivity;
	}
	
	private List<CompanyStandardProtocolActivity> standardProtocolActivity;

	@OneToMany(fetch = FetchType.LAZY , mappedBy="companyProtocol" , cascade=CascadeType.ALL,orphanRemoval=true)
	public List<CompanyStandardProtocolActivity> getStandardProtocolActivity() {
		return standardProtocolActivity;
	}

	public void setStandardProtocolActivity(List<CompanyStandardProtocolActivity> standardProtocolActivity) {
		this.standardProtocolActivity = standardProtocolActivity;
	}

}
