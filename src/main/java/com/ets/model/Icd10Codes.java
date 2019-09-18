package com.ets.model;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "icd10")


public class Icd10Codes {
	
	/***************
	 * Column property ( 1 )
	 *****************************************/

	private  IntegerProperty id = new SimpleIntegerProperty(this, "id");

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
	
	/***************
	 * Column property ( 2 )
	 *****************************************/

	private  StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public  String getCode() {
		return code.get();
	}

	public  void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
	}

	/***************
	 * Column property ( 3 )
	 *****************************************/

	private  StringProperty descrip = new SimpleStringProperty(this,
			"descrip");

	@Column(name = "descrip")
	public  String getDescrip() {
		return descrip.get();
	}

	public  void setDescrip(String descrip) {
		this.descrip.set(descrip);
	}

	public StringProperty descripProperty() {
		return descrip;
	}
	
	/***************
	 * Column property ( 4 )
	 *****************************************/

	private  StringProperty bodySystem = new SimpleStringProperty(this,"bodySystem");

	@Column(name = "body_system")
	public  String getBodySystem() {
		return bodySystem.get();
	}

	public  void setBodySystem(String bodySystem) {
		this.bodySystem.set(bodySystem);
	}

	public StringProperty bodySystemProperty() {
		return bodySystem;
	}
	
	/**********
	 * Column property ( 4 )
	 *****************************************/

	private  StringProperty classification = new SimpleStringProperty(this,"classification");

	@Column(name = "classification")
	public  String getClassification() {
		return classification.get();
	}

	public  void setClassification(String classification) {
		this.classification.set(classification);
	}

	public StringProperty classificationProperty() {
		return classification;
	}
	
	/***************
	 * Column property ( 5 )
	 *****************************************/

	/*private SimpleObjectProperty<MedicalCondition> medicalCondition = new SimpleObjectProperty<MedicalCondition>(this, "medicalCondition");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "medical_condition_id")
	public MedicalCondition getMedicalCondition() {
		return medicalCondition.get();
	}

	public void setMedicalCondition(MedicalCondition medicalCondition) {
		this.medicalCondition.set(medicalCondition);
	}

	public SimpleObjectProperty<MedicalCondition> medicalConditionProperty() {
		return medicalCondition;
	}*/
	
	/***************
	 * Column property ( 6 )
	 *****************************************/
	
private  SimpleBooleanProperty inactive=new SimpleBooleanProperty(this ,"inactive");
	
	@Column(name = "inactive")
	public  boolean getInactive() {
		return inactive.get();
	}

	public  void setInactive(boolean inactive) {
		this.inactive.set(inactive);
		
	}
	
	public BooleanProperty inactiveProperty() {
		return inactive;
	}
	
	private List<Assesment> assesment;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="icd10" , cascade=CascadeType.ALL)
	public List<Assesment> getAssesment() {
		return assesment;
	}

	public void setAssesment(List<Assesment> assesment) {
		this.assesment = assesment;
	}

	
	
	 private List<PatientVisit> patientVisits;
	 @ManyToMany(fetch = FetchType.EAGER,mappedBy="icd10Codes")
	
	 public List<PatientVisit> getPatientVisits() {
		return patientVisits;
	}

	public void setPatientVisits(List<PatientVisit> patientVisits) {
		this.patientVisits = patientVisits;
	}

	//@ManyToOne(cascade ={CascadeType.ALL})
	  
	   
	  // @JoinTable(name = "patient_visit_icd", joinColumns = {@JoinColumn(name="patVisitId", unique=false)}, inverseJoinColumns = {@JoinColumn(name="icdId", unique=false)})
		
	public Icd10Codes() {
		
	}

}
