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
@Table(name = "audiometry_test_param_gen")
public class AudioMeterTestParamGen {

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
	
	private StringProperty signifyNoResponse = new SimpleStringProperty(this, "signifyNoResponse");

	@Column(name = "signify_no_response")

	public String getSignifyNoResponse() {
		return signifyNoResponse.get();
	}

	public void setSignifyNoResponse(String signifyNoResponse) {
		this.signifyNoResponse.set(signifyNoResponse);
	}

	public StringProperty signifyNoResponseProperty() {
		return signifyNoResponse;
	}
	
	private StringProperty signifyNoTestConducted = new SimpleStringProperty(this, "signifyNoTestConducted");

	@Column(name = "signify_no_test_conducted")

	public String getSignifyNoTestConducted() {
		return signifyNoTestConducted.get();
	}

	public void setSignifyNoTestConducted(String signifyNoTestConducted) {
		this.signifyNoTestConducted.set(signifyNoTestConducted);
	}

	public StringProperty signifyNoTestConductedProperty() {
		return signifyNoTestConducted;
	}
	
	private StringProperty stdThresholdShift = new SimpleStringProperty(this, "stdThresholdShift");

	@Column(name = "std_threshold_shift")

	public String getStdThresholdShift() {
		return stdThresholdShift.get();
	}

	public void setStdThresholdShift(String stdThresholdShift) {
		this.stdThresholdShift.set(stdThresholdShift);
	}

	public StringProperty stdThresholdShiftProperty() {
		return stdThresholdShift;
	}
	
	private StringProperty OSHARecShift = new SimpleStringProperty(this, "OSHARecShift");

	@Column(name = "OSHA_rec_shift")

	public String getOSHARecShift() {
		return OSHARecShift.get();
	}

	public void setOSHARecShift(String OSHARecShift) {
		this.OSHARecShift.set(OSHARecShift);
	}

	public StringProperty OSHARecShiftProperty() {
		return OSHARecShift;
	}
	
	private StringProperty speechAsymmetryFreq = new SimpleStringProperty(this, "speechAsymmetryFreq");

	@Column(name = "speech_asymmetry_freq")

	public String getSpeechAsymmetryFreq() {
		return speechAsymmetryFreq.get();
	}

	public void setSpeechAsymmetryFreq(String speechAsymmetryFreq) {
		this.speechAsymmetryFreq.set(speechAsymmetryFreq);
	}

	public StringProperty speechAsymmetryFreqProperty() {
		return speechAsymmetryFreq;
	}
	
	private StringProperty highFreqAsymmetry = new SimpleStringProperty(this, "highFreqAsymmetry");

	@Column(name = "high_freq_asymmetry")

	public String getHighFreqAsymmetry() {
		return highFreqAsymmetry.get();
	}

	public void setHighFreqAsymmetry(String highFreqAsymmetry) {
		this.highFreqAsymmetry.set(highFreqAsymmetry);
	}

	public StringProperty highFreqAsymmetryProperty() {
		return highFreqAsymmetry;
	}
	
	private StringProperty speechFreq = new SimpleStringProperty(this, "speechFreq");

	@Column(name = "speech_freq")

	public String getSpeechFreq() {
		return speechFreq.get();
	}

	public void setSpeechFreq(String speechFreq) {
		this.speechFreq.set(speechFreq);
	}

	public StringProperty speechFreqProperty() {
		return speechFreq;
	}
	
	private StringProperty highFreq = new SimpleStringProperty(this, "highFreq");

	@Column(name = "high_freq")

	public String getHighFreq() {
		return highFreq.get();
	}

	public void setHighFreq(String highFreq) {
		this.highFreq.set(highFreq);
	}

	public StringProperty highFreqProperty() {
		return highFreq;
	}
	
	private StringProperty medRefCriteria = new SimpleStringProperty(this, "medRefCriteria");

	@Column(name = "med_ref_criteria")

	public String getMedRefCriteria() {
		return medRefCriteria.get();
	}

	public void setMedRefCriteria(String medRefCriteria) {
		this.medRefCriteria.set(medRefCriteria);
	}

	public StringProperty medRefCriteriaProperty() {
		return medRefCriteria;
	}

	
	
	
}
