package com.ets.model;

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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "spirometer_test_param_gen")
public class SpirometerTestParamGen {

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

	private StringProperty methCalcPredictVal = new SimpleStringProperty(this, "methCalcPredictVal");

	@Column(name = "meth_calc_predict_val")
	public String getMethCalcPredictVal() {
		return methCalcPredictVal.get();
	}

	public void setMethCalcPredictVal(String methCalcPredictVal) {
		this.methCalcPredictVal.set(methCalcPredictVal);
	}

	public StringProperty methCalcPredictValProperty() {
		return methCalcPredictVal;
	}

	private StringProperty raceCorrectAsian = new SimpleStringProperty(this, "raceCorrectAsian");

	@Column(name = "race_correct_asian")
	public String getRaceCorrectAsian() {
		return raceCorrectAsian.get();
	}

	public void setRaceCorrectAsian(String raceCorrectAsian) {
		this.raceCorrectAsian.set(raceCorrectAsian);
	}

	public StringProperty raceCorrectAsianProperty() {
		return raceCorrectAsian;
	}

	private StringProperty raceCorrectBlack = new SimpleStringProperty(this, "raceCorrectBlack");

	@Column(name = "race_correct_black")
	public String getRaceCorrectBlack() {
		return raceCorrectBlack.get();
	}

	public void setRaceCorrectBlack(String raceCorrectBlack) {
		this.raceCorrectBlack.set(raceCorrectBlack);
	}

	public StringProperty raceCorrectBlackProperty() {
		return raceCorrectBlack;
	}

	private StringProperty raceCorrectHispanic = new SimpleStringProperty(this, "raceCorrectHispanic");

	@Column(name = "race_correct_hispanic")
	public String getRaceCorrectHispanic() {
		return raceCorrectHispanic.get();
	}

	public void setRaceCorrectHispanic(String raceCorrectHispanic) {
		this.raceCorrectHispanic.set(raceCorrectHispanic);
	}

	public StringProperty locProperty() {
		return raceCorrectHispanic;
	}

}
