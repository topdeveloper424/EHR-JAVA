package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "company_standard_protocol_activity")
public class CompanyStandardProtocolActivity {

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

	@ManyToOne
	@JoinColumn(name = "medical_mctivity_id")
	public MedicalActivity getMedicalActivity() {
		return medicalActivity.get();
	}

	public void setMedicalActivity(MedicalActivity medicalActivity) {
		this.medicalActivity.set(medicalActivity);
	}

	public SimpleObjectProperty<MedicalActivity> medicalActivityProperty() {
		return medicalActivity;
	}
	
	private  StringProperty overridePayerType = new SimpleStringProperty(this, "overridePayerType");

	@Column(name = "override_payer_type")
	public  String getOverridePayerType() {
		return overridePayerType.get();
	}

	public  void setOverridePayerType(String overridePayerType) {
		this.overridePayerType.set(overridePayerType);
	}

	public StringProperty overridePayerTypeProperty() {
		return overridePayerType;
	}
	
	private  StringProperty overrideCharge = new SimpleStringProperty(this, "overrideCharge");

	@Column(name = "override_charge")
	public  String getOverrideCharge() {
		return overrideCharge.get();
	}

	public  void setOverrideCharge(String overrideCharge) {
		this.overrideCharge.set(overrideCharge);
	}

	public StringProperty overrideChargeProperty() {
		return overrideCharge;
	}
	
	private  SimpleBooleanProperty noCharge = new SimpleBooleanProperty(
			this, "noCharge");

	@Column(name = "no_charge")
	public  boolean getNoCharge() {
		return noCharge.get();
	}

	public  void setNoCharge(boolean noCharge) {
		this.noCharge.set(noCharge);
	}

	public BooleanProperty noChargeProperty() {
		return noCharge;
	}
	
	
	private  StringProperty uponAge = new SimpleStringProperty(this, "uponAge");

	@Column(name = "upon_age")
	public  String getUponAge() {
		return uponAge.get();
	}

	public  void setUponAge(String uponAge) {
		this.uponAge.set(uponAge);
	}

	public StringProperty uponAgeProperty() {
		return uponAge;
	}
	
	
	private  StringProperty forSex = new SimpleStringProperty(this, "forSex");

	@Column(name = "for_sex")
	public  String getForSex() {
		return forSex.get();
	}

	public  void setForSex(String forSex) {
		this.forSex.set(forSex);
	}

	public StringProperty forSexProperty() {
		return forSex;
	}
	
	
	private  StringProperty stopAge = new SimpleStringProperty(this, "stopAge");

	@Column(name = "stop_age")
	public  String getStopAge() {
		return stopAge.get();
	}

	public  void setStopAge(String stopAge) {
		this.stopAge.set(stopAge);
	}

	public StringProperty stopAgeProperty() {
		return stopAge;
	}
	
	
	private  StringProperty ethnic = new SimpleStringProperty(this, "ethnic");

	@Column(name = "ethnic")
	public  String getEthnic() {
		return ethnic.get();
	}

	public  void setEthnic(String ethnic) {
		this.ethnic.set(ethnic);
	}

	public StringProperty ethnicProperty() {
		return ethnic;
	}
	
	private SimpleObjectProperty<CompanyProtocol> companyProtocol = new SimpleObjectProperty<CompanyProtocol>(this, "companyProtocol");

	@ManyToOne
	@JoinColumn(name = "Company_protocol_id")
	public CompanyProtocol getCompanyProtocol() {
		return companyProtocol.get();
	}

	public void setCompanyProtocol(CompanyProtocol companyProtocol) {
		this.companyProtocol.set(companyProtocol);
	}

	public SimpleObjectProperty<CompanyProtocol> companyProtocolProperty() {
		return companyProtocol;
	}
	
	private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}
	
	
	
}
