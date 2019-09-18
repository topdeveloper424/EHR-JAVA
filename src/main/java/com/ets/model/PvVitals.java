package com.ets.model;

import java.util.Date;

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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Table(name="pv_vitals")
@Entity
public class PvVitals {
	
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
	
	private ObjectProperty<Date> vitalsDate = new SimpleObjectProperty<Date>();

	@Column(name = "vitals_date")
	@Temporal(TemporalType.DATE)
	public Date getVitalsDate() {
		return vitalsDate.get();
	}

	public void setVitalsDate(Date vitalsDate) {
		this.vitalsDate.set(vitalsDate);
	}

	public ObjectProperty<Date> vitalsDateProperty() {
		return this.vitalsDate;
	}
	
	private StringProperty vitalsTime = new SimpleStringProperty(this, "vitalsTime");

	@Column(name = "vitals_time")
	public String getVitalsTime() {
		return vitalsTime.get();
	}

	public void setVitalsTime(String vitalsTime) {
		this.vitalsTime.set(vitalsTime);
	}

	public StringProperty vitalsTimeProperty() {
		return vitalsTime;
	}
	
	private ObjectProperty<Date> vitalsBirthDate = new SimpleObjectProperty<Date>();

	@Column(name = "vitals_birth_date")
	@Temporal(TemporalType.DATE)
	public Date getVitalsBirthDate() {
		return vitalsBirthDate.get();
	}

	public void setVitalsBirthDate(Date vitalsBirthDate) {
		this.vitalsBirthDate.set(vitalsBirthDate);
	}

	public ObjectProperty<Date> vitalsBirthDateProperty() {
		return this.vitalsBirthDate;
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
	
	private SimpleObjectProperty<Clinician> examiner= new SimpleObjectProperty<Clinician>(this, "examiner");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "examiner")
	public Clinician getExaminer() {
		return examiner.get();
	}

	public void setExaminer(Clinician examiner) {
		this.examiner.set(examiner);
	}

	public SimpleObjectProperty<Clinician> examinerProperty() {
		return examiner;
	}
	
	private StringProperty race = new SimpleStringProperty(this, "race");

	@Column(name = "race")
	public String getRace() {
		return race.get();
	}

	public void setRace(String race) {
		this.race.set(race);
	}

	public StringProperty raceProperty() {
		return race;
	}
	
	private SimpleObjectProperty<VitalReader> vitalSignDevice= new SimpleObjectProperty<VitalReader>(this, "vitalSignDevice");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "vital_sign_device")
	public VitalReader getVitalReader() {
		return vitalSignDevice.get();
	}

	public void setVitalReader(VitalReader vitalSignDevice) {
		this.vitalSignDevice.set(vitalSignDevice);
	}

	public SimpleObjectProperty<VitalReader> vitalSignDeviceProperty() {
		return vitalSignDevice;
	}
	
	
	private StringProperty gender = new SimpleStringProperty(this, "gender");

	@Column(name = "gender")
	public String getGender() {
		return gender.get();
	}

	public void setGender(String gender) {
		this.gender.set(gender);
	}

	public StringProperty genderProperty() {
		return gender;
	}
	
	private StringProperty vHeightIn = new SimpleStringProperty(this, "vHeightIn");

	@Column(name = "vs_height_in")
	public String getVHeightIn() {
		return vHeightIn.get();
	}

	public void setVHeightIn(String vHeightIn) {
		this.vHeightIn.set(vHeightIn);
	}

	public StringProperty vHeightInProperty() {
		return vHeightIn;
	}
	
	private StringProperty vsHeightCm = new SimpleStringProperty(this, "vsHeightCm");

	@Column(name = "vs_height_cm")
	public String getVsHeightCm() {
		return vsHeightCm.get();
	}

	public void setVsHeightCm(String vsHeightCm) {
		this.vsHeightCm.set(vsHeightCm);
	}

	public StringProperty vsHeightCmProperty() {
		return vsHeightCm;
	}
	
	private StringProperty vsWeightLb = new SimpleStringProperty(this, "vsWeightLb");

	@Column(name = "vs_weight_lb")
	public String getVsWeightLb() {
		return vsWeightLb.get();
	}

	public void setVsWeightLb(String vsWeightLb) {
		this.vsWeightLb.set(vsWeightLb);
	}

	public StringProperty vsWeightLbProperty() {
		return vsWeightLb;
	}
	
	private StringProperty vsWeightOz = new SimpleStringProperty(this, "vsWeightOz");

	@Column(name = "vs_weight_oz")
	public String getVsWeightOz() {
		return vsWeightOz.get();
	}

	public void setVsWeightOz(String vsWeightOz) {
		this.vsWeightOz.set(vsWeightOz);
	}

	public StringProperty vsWeightOzProperty() {
		return vsWeightOz;
	}
	
	private StringProperty vsWeightKg = new SimpleStringProperty(this, "vsWeightKg");

	@Column(name = "vs_weight_kg")
	public String getVsWeightKg() {
		return vsWeightKg.get();
	}

	public void setVsWeightKg(String vsWeightKg) {
		this.vsWeightKg.set(vsWeightKg);
	}

	public StringProperty vsWeightKgProperty() {
		return vsWeightKg;
	}
	
	private StringProperty vsBmi = new SimpleStringProperty(this, "vsBmi");

	@Column(name = "vs_bmi")
	public String getVsBmi() {
		return vsBmi.get();
	}

	public void setVsBmi(String vsBmi) {
		this.vsBmi.set(vsBmi);
	}

	public StringProperty vsBmiProperty() {
		return vsBmi;
	}
	
	private StringProperty vsTempFaren = new SimpleStringProperty(this, "vsTempFaren");

	@Column(name = "vs_temp_faren")
	public String getVsTempFaren() {
		return vsTempFaren.get();
	}

	public void setVsTempFaren(String vsTempFaren) {
		this.vsTempFaren.set(vsTempFaren);
	}

	public StringProperty vsTempFarenProperty() {
		return vsTempFaren;
	}
	
	private StringProperty vsTempCel = new SimpleStringProperty(this, "vsTempCel");

	@Column(name = "vs_temp_cel")
	public String getVsTempCel() {
		return vsTempCel.get();
	}

	public void setVsTempCel(String vsTempCel) {
		this.vsTempCel.set(vsTempCel);
	}

	public StringProperty vsTempCelProperty() {
		return vsTempCel;
	}
	
	private StringProperty vsBpN = new SimpleStringProperty(this, "vsBpN");

	@Column(name = "vs_bp_n")
	public String getVsBpN() {
		return vsBpN.get();
	}

	public void setVsBpN(String vsBpN) {
		this.vsBpN.set(vsBpN);
	}

	public StringProperty vsBpNProperty() {
		return vsBpN;
	}
	
	private StringProperty vsBpD = new SimpleStringProperty(this, "vsBpD");

	@Column(name = "vs_bp_d")
	public String getVsBpD() {
		return vsBpD.get();
	}

	public void setVsBpD(String vsBpD) {
		this.vsBpD.set(vsBpD);
	}

	public StringProperty vsBpDProperty() {
		return vsBpD;
	}
	
	private StringProperty vsBpTakenFrom = new SimpleStringProperty(this, "vsBpTakenFrom");

	@Column(name = "vs_bp_taken_from")
	public String getVsBpTakenFrom() {
		return vsBpTakenFrom.get();
	}

	public void setVsBpTakenFrom(String vsBpTakenFrom) {
		this.vsBpTakenFrom.set(vsBpTakenFrom);
	}

	public StringProperty vsBpTakenFromProperty() {
		return vsBpTakenFrom;
	}
	
	private StringProperty vsBpPos = new SimpleStringProperty(this, "vsBpPos");

	@Column(name = "vs_bp_pos")
	public String getVsBpPos() {
		return vsBpPos.get();
	}

	public void setVsBpPos(String vsBpPos) {
		this.vsBpPos.set(vsBpPos);
	}

	public StringProperty vsBpPosProperty() {
		return vsBpPos;
	}
	
	private StringProperty vsPulse = new SimpleStringProperty(this, "vsPulse");

	@Column(name = "vs_pulse")
	public String getVsPulse() {
		return vsPulse.get();
	}

	public void setVsPulse(String vsPulse) {
		this.vsPulse.set(vsPulse);
	}

	public StringProperty vsPulseProperty() {
		return vsPulse;
	}
	
	private StringProperty vsRespiration = new SimpleStringProperty(this, "vsRespiration");

	@Column(name = "vs_respiration")
	public String getVsRespiration() {
		return vsRespiration.get();
	}

	public void setVsRespiration(String vsRespiration) {
		this.vsRespiration.set(vsRespiration);
	}

	public StringProperty vsRespirationProperty() {
		return vsRespiration;
	}
	
	private StringProperty vsPulseOxymetryPercent = new SimpleStringProperty(this, "vsPulseOxymetryPercent");

	@Column(name = "vs_pulse_oxymetry_percent")
	public String getVsPulseOxymetryPercent() {
		return vsPulseOxymetryPercent.get();
	}

	public void setvsPulseOxymetryPercent(String vsPulseOxymetryPercent) {
		this.vsPulseOxymetryPercent.set(vsPulseOxymetryPercent);
	}

	public StringProperty vsPulseOxymetryPercentProperty() {
		return vsPulseOxymetryPercent;
	}
	
	private StringProperty vsLPerMin = new SimpleStringProperty(this, "vsLPerMin");

	@Column(name = "vs_l_per_min")
	public String getVsLPerMin() {
		return vsLPerMin.get();
	}

	public void setVsLPerMin(String vsLPerMin) {
		this.vsLPerMin.set(vsLPerMin);
	}

	public StringProperty vsLPerMinProperty() {
		return vsLPerMin;
	}
	
	private  SimpleBooleanProperty vsRoomAir = new SimpleBooleanProperty(
			this, "vsRoomAir");

	@Column(name = "vs_room_air")
	public  boolean getVsRoomAir() {
		return vsRoomAir.get();
	}

	public void setVsRoomAir(boolean vsRoomAir) {
		this.vsRoomAir.set(vsRoomAir);
	}

	public BooleanProperty vsRoomAirProperty() {
		return vsRoomAir;
	}

	public PvVitals() {
		
	}

}
