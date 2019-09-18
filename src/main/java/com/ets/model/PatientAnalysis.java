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
import javax.persistence.Table;

import org.hibernate.type.DateType;
import org.springframework.beans.propertyeditors.InputSourceEditor;

@Entity
@Table (name = "patient_analysis")
public class PatientAnalysis {
	
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private int Id;
	
	@Column(name = "details_first")
	private String detail ;
	
	@Column(name = "details_second")
	private String details;
	

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getInformation() {
		return information;
	}

	public void setInformation(String information) {
		this.information = information;
	}

	public String getInformations() {
		return informations;
	}

	public void setInformations(String informations) {
		this.informations = informations;
	}

	@Column(name = "details_third")
	private String information;
	
	@Column(name = "details_fourth")
	private String informations;
	
	
	@Column(name = "count")
	private String count;
	
	@Column(name = "average")
	private String avg;
	
	
	@Column(name = "billing")
	private String bill;
	
	@Column(name = "total1")
	private String total1;
	
	
	@Column(name = "total2")
	private String total2;
	
	
	
	public String getCount() {
		return count;
	}

	public void setCount(String count) {
		this.count = count;
	}

	public String getAvg() {
		return avg;
	}

	public void setAvg(String avg) {
		this.avg = avg;
	}

	public String getBill() {
		return bill;
	}

	public void setBill(String bill) {
		this.bill = bill;
	}

	public String getTotal1() {
		return total1;
	}

	public void setTotal1(String total1) {
		this.total1 = total1;
	}

	public String getTotal2() {
		return total2;
	}

	public void setTotal2(String total2) {
		this.total2 = total2;
	}

	@Column (name = "From_date")
	private Date fromDate;
	
	@Column (name = "Thru_date")
	private Date thruDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "company_id")
	private Company com;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinic_id")
	private Clinic clinic;
	
	
	public Clinic getClinic() {
		return clinic;
	}

	public void setClinic(Clinic clinic) {
		this.clinic = clinic;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "visitCategory_id")
	private VisitCategory visitCat;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inci_id")
	private IncidentOrEvent inci;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientvisit_id")
	private PatientVisit visitype;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "service_id")
	private BillingServiceType serviceType;


	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getThruDate() {
		return thruDate;
	}

	public void setThruDate(Date thruDate) {
		this.thruDate = thruDate;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public Company getCom() {
		return com;
	}

	public void setCom(Company com) {
		this.com = com;
	}

	public VisitCategory getVisitCat() {
		return visitCat;
	}

	public void setVisitCat(VisitCategory visitCat) {
		this.visitCat = visitCat;
	}

	public IncidentOrEvent getInci() {
		return inci;
	}

	public void setInci(IncidentOrEvent inci) {
		this.inci = inci;
	}

	public PatientVisit getVisitype() {
		return visitype;
	}

	public void setVisitype(PatientVisit visitype) {
		this.visitype = visitype;
	}

	public BillingServiceType getServiceType() {
		return serviceType;
	}

	public void setServiceType(BillingServiceType serviceType) {
		this.serviceType = serviceType;
	}
}
