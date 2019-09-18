package com.ets.model;

/*
 *Original Author: Shazarin Farha on Behalf of ETS for Client Company
 *File Creation Date: 09-05-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Medical Activity Class
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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "medical_activity")

public class MedicalActivity {

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

	/***************
	 * Column property ( 2 )
	 *****************************************/

	private StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public String getCode() {
		return code.get();
	}

	public void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
	}

	/***************
	 * Column property ( 3 )
	 *****************************************/

	private StringProperty descrip = new SimpleStringProperty(this, "descrip");

	@Column(name = "descrip")
	public String getDescrip() {
		return descrip.get();
	}

	public void setDescrip(String descrip) {
		this.descrip.set(descrip);
	}

	public StringProperty descripProperty() {
		return descrip;
	}

	/***************
	 * Column property (4 )
	 *****************************************/

	private StringProperty activityType = new SimpleStringProperty(this, "activityType");

	@Column(name = "activity_type")
	public String getActivityType() {
		return activityType.get();
	}

	public void setActivityType(String activityType) {
		this.activityType.set(activityType);
	}

	public StringProperty activityTypeProperty() {
		return activityType;
	}

	// Collumn 5
	private IntegerProperty stepsRequired = new SimpleIntegerProperty(this, "stepsRequired");
	
	@Column(name = "steps_required")
	public Integer getStepsRequired() {
		return stepsRequired.get();
	}

	public void setStepsRequired(Integer stepsRequired) {
		this.stepsRequired.set(stepsRequired);
	}

	public IntegerProperty stepsRequiredProperty() {
		return this.stepsRequired;
	}

	// Collumn 6

	private StringProperty security = new SimpleStringProperty(this, "security");

	@Column(name = "security")
	public String getSecurity() {
		return security.get();
	}

	public void setSecurity(String security) {
		this.security.set(security);
	}

	public StringProperty securityProperty() {
		return security;
	}

	// Collumn 7

	private SimpleObjectProperty<CptCode4Hcpcs> cptCode4Hcpcs = new SimpleObjectProperty<CptCode4Hcpcs>(this,
			"cptCode4Hcpcs");

	@ManyToOne
	@JoinColumn(name = "cpt_code4_hcpcs_id" )
	public CptCode4Hcpcs getCptCode4Hcpcs() {
		return cptCode4Hcpcs.get();
	}

	public void setCptCode4Hcpcs(CptCode4Hcpcs cptCode4Hcpcs) {
		this.cptCode4Hcpcs.set(cptCode4Hcpcs);
	}

	public SimpleObjectProperty<CptCode4Hcpcs> cptCode4HcpcsProperty() {
		return cptCode4Hcpcs;
	}

	// Collumn 8

	private SimpleObjectProperty<MedActBilling> billingServiceType = new SimpleObjectProperty<MedActBilling>(
			this, "billingServiceType");

	@ManyToOne
	@JoinColumn(name = "billing_service_type_id")
	public MedActBilling getBillingServiceType() {
		return billingServiceType.get();
	}

	public void setBillingServiceType(MedActBilling billingServiceType) {
		this.billingServiceType.set(billingServiceType);
	}

	public SimpleObjectProperty<MedActBilling> billingServiceTypeProperty() {
		return billingServiceType;
	}

	// Collumn 9

	private SimpleObjectProperty<MedActSurvelRule> medActSurvelRule = new SimpleObjectProperty<MedActSurvelRule>(this,
			"medActSurvelRule");

	@OneToOne
	@JoinColumn(name = "med_act_survel_rule_id")
	public MedActSurvelRule getMedActSurvelRule() {
		return medActSurvelRule.get();
	}

	public void setMedActSurvelRule(MedActSurvelRule medActSurvelRule) {
		this.medActSurvelRule.set(medActSurvelRule);
	}

	public SimpleObjectProperty<MedActSurvelRule> medActSurvelRuleProperty() {
		return medActSurvelRule;
	}

	/*
	 * // Collumn 10

	private SimpleObjectProperty<MedActResultCode> medActResultCode = new SimpleObjectProperty<MedActResultCode>(this,
			"medActResultCode");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "med_act_result_code_id")
	public MedActResultCode getMedActResultCode() {
		return medActResultCode.get();
	}

	public void setMedActResultCode(MedActResultCode medActResultCode) {
		this.medActResultCode.set(medActResultCode);
	}

	public SimpleObjectProperty<MedActResultCode> medActResultCodeProperty() {
		return medActResultCode;
	}*/

	// Collumn 10
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
	
	private List<MedicalCondition> medicalActivitie1;
	private List<MedicalCondition> medicalActivitie2;
	private List<MedicalCondition> medicalActivitie3;
	private List<MedicalCondition> medicalActivitie4;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="vaccine" , cascade=CascadeType.ALL)
	public List<MedicalCondition> getMedicalActivitie1() {
		return medicalActivitie1;
	}

	public void setMedicalActivitie1(List<MedicalCondition> medicalActivitie1) {
		this.medicalActivitie1 = medicalActivitie1;
	}
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="secondVaccine" , cascade=CascadeType.ALL)
	public List<MedicalCondition> getMedicalActivitie2() {
		return medicalActivitie2;
	}

	public void setMedicalActivitie2(List<MedicalCondition> medicalActivitie2) {
		this.medicalActivitie2 = medicalActivitie2;
	}
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="immuneTest" , cascade=CascadeType.ALL)
	public List<MedicalCondition> getMedicalActivitie3() {
		return medicalActivitie3;
	}

	public void setMedicalActivitie3(List<MedicalCondition> medicalActivitie3) {
		this.medicalActivitie3 = medicalActivitie3;
	}
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="diagTest" , cascade=CascadeType.ALL)
	public List<MedicalCondition> getMedicalActivitie4() {
		return medicalActivitie4;
	}

	public void setMedicalActivitie4(List<MedicalCondition> medicalActivitie4) {
		this.medicalActivitie4 = medicalActivitie4;
	}

	private List<MedicalActivityCharge> medicalActivityCharges;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="medicalActivity" , cascade=CascadeType.ALL)
	public List<MedicalActivityCharge> getMedicalActivityCharges() {
		return medicalActivityCharges;
	}

	public void setMedicalActivityCharges(List<MedicalActivityCharge> medicalActivityCharges) {
		this.medicalActivityCharges = medicalActivityCharges;
	}

    private List<CompanyOptionalProtocolActivity> optionalProtocolActivity ;
    
	@OneToMany(fetch = FetchType.LAZY , mappedBy="medicalActivity" , cascade=CascadeType.ALL)
	public List<CompanyOptionalProtocolActivity> getOptionalProtocolActivity() {
		return optionalProtocolActivity;
	}

	public void setOptionalProtocolActivity(List<CompanyOptionalProtocolActivity> optionalProtocolActivity) {
		this.optionalProtocolActivity = optionalProtocolActivity;
	}
	
	private List<CompanyStandardProtocolActivity> standardProtocolActivity;

	@OneToMany(fetch = FetchType.LAZY , mappedBy="medicalActivity" , cascade=CascadeType.ALL)
	public List<CompanyStandardProtocolActivity> getStandardProtocolActivity() {
		return standardProtocolActivity;
	}

	public void setStandardProtocolActivity(List<CompanyStandardProtocolActivity> standardProtocolActivity) {
		this.standardProtocolActivity = standardProtocolActivity;
	}

	public MedicalActivity() {

	}

}
