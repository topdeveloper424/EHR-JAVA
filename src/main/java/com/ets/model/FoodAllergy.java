package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "food_substance")
public class FoodAllergy {
	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

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
	private StringProperty substanceName = new SimpleStringProperty(this, "substanceName");

	@Column(name = "substance_name")
	public String getSubstanceName() {
		return substanceName.get();
	}

	public void setSubstanceName(String substanceName) {
		this.substanceName.set(substanceName);
	}

	public StringProperty substanceNameProperty() {
		return substanceName;
	}
	
	private StringProperty uniCode = new SimpleStringProperty(this, "uniCode");

	@Column(name = "uni_code")
	public String getUniCode() {
		return uniCode.get();
	}

	public void setUniCode(String uniCode) {
		this.uniCode.set(uniCode);
	}

	public StringProperty uniCodeProperty() {
		return uniCode;
	}

	public FoodAllergy() {
		super();
		
	}
}
