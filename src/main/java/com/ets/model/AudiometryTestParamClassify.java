package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="audiometry_test_param_classify")
public class AudiometryTestParamClassify {
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
	private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

	@OneToOne(fetch = FetchType.EAGER)
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
	private StringProperty hearingLossClass  = new SimpleStringProperty(this, "hearingLossClass");

	@Column(name = "hearing_loss_class")
	public String getHearingLossClass() {
		return hearingLossClass.get();
	}

	public void setHearingLossClass(String hearingLossClass) {
		this.hearingLossClass.set(hearingLossClass);
	}

	public StringProperty hearingLossClassProperty() {
		return hearingLossClass;
	}
	private StringProperty fromFreq = new SimpleStringProperty(this, "fromFreq");

	@Column(name = "from_freq")
	public String getFromFreq() {
		return fromFreq.get();
	}

	public void setFromFreq(String fromFreq) {
		this.fromFreq.set(fromFreq);
	}

	public StringProperty fromFreqProperty() {
		return fromFreq;
	}
	private StringProperty thruFreq = new SimpleStringProperty(this, "thruFreq");

	@Column(name = "thru_freq")
	public String getThruFreq() {
		return thruFreq.get();
	}

	public void setThruFreq(String thruFreq) {
		this.thruFreq.set(thruFreq);
	}

	public StringProperty thruFreqProperty() {
		return thruFreq;
	}
	
	private StringProperty result= new SimpleStringProperty(this, "result");

	@Column(name = "result")
	public String getResult() {
		return result.get();
	}

	public void setResult(String result) {
		this.result.set(result);
	}

	public StringProperty resultProperty() {
		return result;
	}
	
	private StringProperty binauralImpairmentFormula = new SimpleStringProperty(this, "binauralImpairmentFormula");

	@Column(name = "binaural_impairment_formula")
	public String getBinauralImpairmentFormula() {
		return binauralImpairmentFormula.get();
	}

	public void setBinauralImpairmentFormula(String binauralImpairmentFormula) {
		this.binauralImpairmentFormula.set(binauralImpairmentFormula);
	}

	public StringProperty binauralImpairmentFormulaProperty() {
		return binauralImpairmentFormula;
	}

	public AudiometryTestParamClassify(){
		
	}
}
