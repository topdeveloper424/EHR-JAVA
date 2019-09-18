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
@Table(name = "vital_sign")
public class VitalSign {

	
	

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
	private SimpleObjectProperty<PatientVisit> patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientVisit_id")
	public PatientVisit getPatientVisit() {
		return patientVisit.get();
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit.set(patientVisit);
	}

	public SimpleObjectProperty<PatientVisit> patientVisitProperty() {
		return patientVisit;
	}
	
	private StringProperty timeOfreading = new SimpleStringProperty(this, "timeOfreading");

	@Column(name = "timeOfreading")
	public String getTimeOfreading() {
		return timeOfreading.get();
	}

	public void setTimeOfreading(String timeOfreading) {
		this.timeOfreading.set(timeOfreading);
	}

	public StringProperty timeOfreadingProperty() {
		return timeOfreading;
	}
	private StringProperty age = new SimpleStringProperty(this, "age");

	@Column(name = "age")
	public String getAge() {
		return age.get();
	}

	public void setAge(String age) {
		this.age.set(age);
	}

	public StringProperty ageProperty() {
		return age;
	}

	private StringProperty heightInInches = new SimpleStringProperty(this, "heightInInches");

	@Column(name = "heightInInches")
	public String getHeightInInches() {
		return heightInInches.get();
	}

	public void setHeightInInches(String heightInInches) {
		this.heightInInches.set(heightInInches);
	}

	public StringProperty heightInInchesProperty() {
		return heightInInches;
	}

	private StringProperty heightInCm = new SimpleStringProperty(this, "heightInCm");

	@Column(name = "heightInCm")
	public String getHeightInCm() {
		return heightInCm.get();
	}

	public void setHeightInCm(String heightInCm) {
		this.heightInCm.set(heightInCm);
	}

	public StringProperty heightInCmProperty() {
		return heightInCm;
	}
	
	private StringProperty bmi = new SimpleStringProperty(this, "bmi");

	@Column(name = "bmi")
	public String getBmi() {
		return bmi.get();
	}

	public void setBmi(String bmi) {
		this.bmi.set(bmi);
	}

	public StringProperty bmiProperty() {
		return bmi;
	}
	
	private StringProperty weightLb = new SimpleStringProperty(this, "weightLb");

	@Column(name = "weightLb")
	public String getWeightLb() {
		return weightLb.get();
	}

	public void setWeightLb(String weightLb) {
		this.weightLb.set(weightLb);
	}

	public StringProperty weightLbProperty() {
		return weightLb;
	}
	private StringProperty weightOz = new SimpleStringProperty(this, "weightOz");

	@Column(name = "weightOz")
	public String getWeightOz() {
		return weightOz.get();
	}

	public void setWeightOz(String weightOz) {
		this.weightOz.set(weightOz);
	}

	public StringProperty weightOzProperty() {
		return weightOz;
	}
	
	private StringProperty weightKg = new SimpleStringProperty(this, "weightKg");

	@Column(name = "weightKg")
	public String getWeightKg() {
		return weightKg.get();
	}

	public void setWeightKg(String weightKg) {
		this.weightOz.set(weightKg);
	}

	public StringProperty weightKgProperty() {
		return weightKg;
	}
	
	private StringProperty bodyFat = new SimpleStringProperty(this, "bodyFat");

	@Column(name = "bodyFat")
	public String getBodyFat() {
		return bodyFat.get();
	}

	public void setBodyFat(String bodyFat) {
		this.bodyFat.set(bodyFat);
	}

	public StringProperty bodyFatProperty() {
		return bodyFat;
	}
	private StringProperty abdominalInches = new SimpleStringProperty(this, "abdominalInches");

	@Column(name = "abdominalInches")
	public String getAbdominalInches() {
		return abdominalInches.get();
	}

	public void setAbdominalInches(String abdominalInches) {
		this.abdominalInches.set(abdominalInches);
	}

	public StringProperty abdominalInchesProperty() {
		return abdominalInches;
	}
	private StringProperty abdominalCm = new SimpleStringProperty(this, "abdominalCm");

	@Column(name = "abdominalCm")
	public String getAbdominalCm() {
		return abdominalCm.get();
	}

	public void setAbdominalCm(String abdominalCm) {
		this.abdominalCm.set(abdominalCm);
	}

	public StringProperty abdominalCmProperty() {
		return abdominalCm;
	}
	
	private StringProperty farenhiet = new SimpleStringProperty(this, "farenhiet");

	@Column(name = "farenhiet")
	public String getFarenhiet() {
		return farenhiet.get();
	}

	public void setFarenhiet(String farenhiet) {
		this.farenhiet.set(farenhiet);
	}

	public StringProperty farenhietProperty() {
		return farenhiet;
	}
	private StringProperty celcius = new SimpleStringProperty(this, "celcius");

	@Column(name = "celcius")
	public String getCelcius() {
		return celcius.get();
	}

	public void setCelcius(String celcius) {
		this.celcius.set(celcius);
	}

	public StringProperty celciusProperty() {
		return celcius;
	}
	private StringProperty breathPerMinute = new SimpleStringProperty(this, "breathPerMinute");

	@Column(name = "breathPerMinute")
	public String getBreathPerMinute() {
		return breathPerMinute.get();
	}

	public void setBreathPerMinute(String breathPerMinute) {
		this.breathPerMinute.set(breathPerMinute);
	}

	public StringProperty breathPerMinuteProperty() {
		return breathPerMinute;
	}
	
	
	private StringProperty systolic = new SimpleStringProperty(this, "systolic");

	@Column(name = "systolic")
	public String getSystolic() {
		return systolic.get();
	}

	public void setSystolic(String systolic) {
		this.systolic.set(systolic);
	}

	public StringProperty systolicProperty() {
		return systolic;
	}
	
	private StringProperty dystolic = new SimpleStringProperty(this, "dystolic");

	@Column(name = "dystolic")
	public String getDystolic() {
		return dystolic.get();
	}

	public void setDystolic(String dystolic) {
		this.dystolic.set(dystolic);
	}

	public StringProperty dystolicProperty() {
		return dystolic;
	}private StringProperty pulsePerRate = new SimpleStringProperty(this, "pulsePerRate");

	@Column(name = "pulsePerRate")
	public String getPulsePerRate() {
		return pulsePerRate.get();
	}

	public void setPulsePerRate(String pulsePerRate) {
		this.pulsePerRate.set(pulsePerRate);
	}

	public StringProperty pulsePerRateProperty() {
		return pulsePerRate;
	}
	
	private StringProperty whichArmUsed = new SimpleStringProperty(this, "whichArmUsed");

	@Column(name = "whichArmUsed")
	public String getWhichArmUsed() {
		return whichArmUsed.get();
	}

	public void setWhichArmUsed(String whichArmUsed) {
		this.whichArmUsed.set(whichArmUsed);
	}

	public StringProperty whichArmUsedProperty() {
		return whichArmUsed;
	}
	
	private StringProperty patientPositionAtTimeReading = new SimpleStringProperty(this, "patientPositionAtTimeReading");

	@Column(name = "patientPositionAtTimeReading")
	public String getPatientPositionAtTimeReading() {
		return patientPositionAtTimeReading.get();
	}

	public void setPatientPositionAtTimeReading(String patientPositionAtTimeReading) {
		this.patientPositionAtTimeReading.set(patientPositionAtTimeReading);
	}

	public StringProperty patientPositionAtTimeReadingProperty() {
		return patientPositionAtTimeReading;
	}
	
	private StringProperty pulseoximetry = new SimpleStringProperty(this, "pulseoximetry");

	@Column(name = "pulseoximetry")
	public String getPulseoximetry() {
		return pulseoximetry.get();
	}

	public void setPulseoximetry(String pulseoximetry) {
		this.pulseoximetry.set(pulseoximetry);
	}

	public StringProperty pulseoximetryProperty() {
		return pulseoximetry;
	}

	private StringProperty roomAir = new SimpleStringProperty(this, "roomAir");

	@Column(name = "roomAir")
	public String getRoomAir() {
		return roomAir.get();
	}

	public void setRoomAir(String roomAir) {
		this.roomAir.set(roomAir);
	}

	public StringProperty roomAirProperty() {
		return roomAir;
	}private StringProperty orText = new SimpleStringProperty(this, "orText");

	@Column(name = "orText")
	public String getOrText() {
		return orText.get();
	}

	public void setOrText(String orText) {
		this.roomAir.set(orText);
	}

	public StringProperty orTextProperty() {
		return orText;
	}
	
	private StringProperty painLevel = new SimpleStringProperty(this, "painLevel");

	@Column(name = "painLevel")
	public String getPainLevel() {
		return painLevel.get();
	}

	public void setPainLevel(String painLevel) {
		this.painLevel.set(painLevel);
	}

	public StringProperty painLevelProperty() {
		return painLevel;
	}
	
}

