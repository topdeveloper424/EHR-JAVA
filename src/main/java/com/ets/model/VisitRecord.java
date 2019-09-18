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
@Table(name = "visit_record")
public class VisitRecord {
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

	private ObjectProperty<Date> visitDate = new SimpleObjectProperty<Date>();

	@Column(name = "visit_date")
	@Temporal(TemporalType.DATE)
	public Date getVisitDate() {
		return visitDate.get();
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate.set(visitDate);
	}

	public ObjectProperty<Date> VisitDateProperty() {
		return this.visitDate;
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

	private SimpleObjectProperty<VisitCategory> visitCategory = new SimpleObjectProperty<VisitCategory>(this,
			"visitCategory");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	private StringProperty providerInTime = new SimpleStringProperty(this, "providerInTime");

	@Column(name = "provider_in_time")
	public String getProviderInTime() {
		return providerInTime.get();
	}

	public void setProviderInTime(String providerInTime) {
		this.providerInTime.set(providerInTime);
	}

	public StringProperty providerInTimeProperty() {
		return providerInTime;
	}

	private StringProperty providerOutTime = new SimpleStringProperty(this, "providerOutTime");

	@Column(name = "provider_out_time")
	public String getProviderOutTime() {
		return providerOutTime.get();
	}

	public void setProviderOutTime(String providerOutTime) {
		this.providerOutTime.set(providerOutTime);
	}

	public StringProperty providerOutTimeProperty() {
		return providerOutTime;
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

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	private SimpleObjectProperty<MedActBilling> billPhysician = new SimpleObjectProperty<MedActBilling>(this,
			"billPhysician");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "bill_physician_id")
	public MedActBilling getBillPhysician() {
		return billPhysician.get();
	}

	public void setBillPhysician(MedActBilling billPhysician) {
		this.billPhysician.set(billPhysician);
	}

	public SimpleObjectProperty<MedActBilling> billPhysicianProperty() {
		return billPhysician;
	}

	private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

	private SimpleObjectProperty<Provider> referredBy = new SimpleObjectProperty<Provider>(this, "referredBy");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "referred_by")
	public Provider getReferredBy() {
		return referredBy.get();
	}

	public void setReferredBy(Provider referredBy) {
		this.referredBy.set(referredBy);
	}

	public SimpleObjectProperty<Provider> referredByProperty() {
		return referredBy;
	}

	private StringProperty summaryText = new SimpleStringProperty(this, "summaryText");

	@Column(name = "summary_text")
	public String getSummaryText() {
		return summaryText.get();
	}

	public void setSummaryText(String summaryText) {
		this.summaryText.set(summaryText);
	}

	public StringProperty summaryTextProperty() {
		return summaryText;
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

	private StringProperty alertNote = new SimpleStringProperty(this, "alertNote");

	@Column(name = "alert_note")
	public String getAlertNote() {
		return alertNote.get();
	}

	public void setAlertNote(String alertNote) {
		this.alertNote.set(alertNote);
	}

	public StringProperty alertNoteProperty() {
		return alertNote;
	}
}
