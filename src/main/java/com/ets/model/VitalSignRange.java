package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "vital_sign_range")

public class VitalSignRange {

	private  IntegerProperty id = new SimpleIntegerProperty(this, "id");

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

	
	private  StringProperty name = new SimpleStringProperty(this, "name");

	@Column(name = "name")
	public  String getName() {
		return name.get();
	}

	public  void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}
	
	
	private  StringProperty vitalType = new SimpleStringProperty(this, "vitalType");

	@Column(name = "vital_type")
	public  String getVitalType() {
		return vitalType.get();
	}

	public  void setVitalType(String vitalType) {
		this.vitalType.set(vitalType);
	}

	public StringProperty vitalTypeProperty() {
		return vitalType;
	}
	
	
	
	private  StringProperty gender = new SimpleStringProperty(this, "gender");

	@Column(name = "gender")
	public  String getGender() {
		return gender.get();
	}

	public  void setGender(String gender) {
		this.gender.set(gender);
	}

	public StringProperty genderProperty() {
		return gender;
	}
	
	
	private  StringProperty fromAge = new SimpleStringProperty(this, "fromAge");

	@Column(name = "from_age")
	public  String getFromAge() {
		return fromAge.get();
	}

	public  void setFromAge(String fromAge) {
		this.fromAge.set(fromAge);
	}

	public StringProperty fromAgeProperty() {
		return fromAge;
	}
	
	
	private  StringProperty toAge = new SimpleStringProperty(this, "toAge");

	@Column(name = "to_age")
	public  String getToAge() {
		return toAge.get();
	}

	public  void setToAge(String toAge) {
		this.toAge.set(toAge);
	}

	public StringProperty toAgeProperty() {
		return toAge;
	}
	
	
	private  StringProperty ageUnit = new SimpleStringProperty(this, "ageUnit");

	@Column(name = "age_unit")
	public  String getAgeUnit() {
		return ageUnit.get();
	}

	public  void setAgeUnit(String ageUnit) {
		this.ageUnit.set(ageUnit);
	}

	public StringProperty ageUnitProperty() {
		return ageUnit;
	}
	private  StringProperty measurementSys = new SimpleStringProperty(this, "measurementSys");

	@Column(name = "measurement_sys")
	public  String getMeasurementSys() {
		return measurementSys.get();
	}

	public  void setMeasurementSys(String measurementSys) {
		this.measurementSys.set(measurementSys);
	}

	public StringProperty measurementSysProperty() {
		return measurementSys;
	}
	
	
	
	private  StringProperty weightFromLbs = new SimpleStringProperty(this, "weightFromLbs");

	@Column(name = "weight_from_lbs")
	public  String getWeightFromLbs() {
		return weightFromLbs.get();
	}

	public  void setWeightFromLbs(String weightFromLbs) {
		this.weightFromLbs.set(weightFromLbs);
	}

	public StringProperty weightFromLbsProperty() {
		return weightFromLbs;
	}
	
	
	private  StringProperty weightFromOz = new SimpleStringProperty(this, "weightFromOz");

	@Column(name = "weight_from_oz")
	public  String getWeightFromOz() {
		return weightFromOz.get();
	}

	public  void setWeightFromOz(String weightFromOz) {
		this.weightFromOz.set(weightFromOz);
	}

	public StringProperty weightFromOzProperty() {
		return weightFromOz;
	}
	
	
	private  StringProperty weightToLbs = new SimpleStringProperty(this, "weightToLbs");

	@Column(name = "weight_to_lbs")
	public  String getWeightToLbs() {
		return weightToLbs.get();
	}

	public  void setWeightToLbs(String weightToLbs) {
		this.weightToLbs.set(weightToLbs);
	}

	public StringProperty weightToLbsProperty() {
		return weightToLbs;
	}
	
	
	
	private  StringProperty weightToOz = new SimpleStringProperty(this, "weightToOz");

	@Column(name = "weight_to_oz")
	public  String getWeightToOz() {
		return weightToOz.get();
	}

	public  void setWeightToOz(String weightToOz) {
		this.weightToOz.set(weightToOz);
	}

	public StringProperty weightToOzProperty() {
		return weightToOz;
	}
	
	
	private  StringProperty heightFromInch = new SimpleStringProperty(this, "heightFromInch");

	@Column(name = "height_from_inch")
	public  String getHeightFromInch() {
		return heightFromInch.get();
	}

	public  void setHeightFromInch(String heightFromInch) {
		this.heightFromInch.set(heightFromInch);
	}

	public StringProperty heightFromInchProperty() {
		return heightFromInch;
	}
	
	
	private  StringProperty heightToInch = new SimpleStringProperty(this, "heightToInch");

	@Column(name = "height_to_inch")
	public  String getHeightToInch() {
		return heightToInch.get();
	}

	public  void setHeightToInch(String heightToInch) {
		this.heightToInch.set(heightToInch);
	}

	public StringProperty heightToInchProperty() {
		return heightToInch;
	}
	
	public VitalSignRange() {
		
	}

}
