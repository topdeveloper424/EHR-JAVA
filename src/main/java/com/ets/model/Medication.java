package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


@Entity
@Table(name = "medication")
public class Medication {
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
	private  StringProperty medicationName = new SimpleStringProperty(this, "medicationName");
	private SimpleObjectProperty<MedicationClass> medicationClass = new SimpleObjectProperty<MedicationClass>(this, "medicationClass");
	
	private  StringProperty dispense = new SimpleStringProperty(this, "dispense");
	private  StringProperty medStrength = new SimpleStringProperty(this, "medStrength");
	private  StringProperty form = new SimpleStringProperty(this, "form");
	private  StringProperty howMuch = new SimpleStringProperty(this, "howMuch");
	
	private  StringProperty howMuchTo = new SimpleStringProperty(this, "howMuchTo");
	private  StringProperty howMuchform = new SimpleStringProperty(this, "howMuchform");
	private  StringProperty route = new SimpleStringProperty(this, "route");
	private  StringProperty frequency = new SimpleStringProperty(this, "frequency");
	private  StringProperty howLong = new SimpleStringProperty(this, "howLong");
	private  StringProperty howLongMonthOrYear = new SimpleStringProperty(this, "howLongMonthOrYear");
	private  StringProperty special = new SimpleStringProperty(this, "special");
	private  StringProperty additionalSig = new SimpleStringProperty(this, "additionalSig");
	@Column(name = "medication_name")

	public  String getMedicationName() {
		return medicationName.get();
	}

	public  void setMedicationName(String medicationName) {
		this.medicationName.set(medicationName);
	}

	public StringProperty medicationNameProperty() {
		return medicationName;
	}
	
	@JoinColumn(name = "medication_class")
	

	@ManyToOne(fetch = FetchType.EAGER)
	public MedicationClass getMedicationClass() {
		return medicationClass.get();
	}

	public void setMedicationClass(MedicationClass medicationClass) {
		this.medicationClass.set(medicationClass);
	}

	public SimpleObjectProperty<MedicationClass> medicationClassProperty() {
		return medicationClass;
	}
	@Column(name = "dispense")

	
	public  String getDispense() {
		return dispense.get();
	}

	public  void setDispense(String dispense) {
		this.dispense.set(dispense);
	}

	public StringProperty dispenseProperty() {
		return dispense;
	}
	
	@Column(name = "form")
	
	public  String getForm() {
		return form.get();
	}

	public  void setForm(String form) {
		this.form.set(form);
	}

	public StringProperty formProperty() {
		return form;
	}
	
	
	@Column(name = "how_much")
	
	public  String getHowMuch() {
		return howMuch.get();
	}

	public  void setHowMuch(String howMuch) {
		this.howMuch.set(howMuch);
	}

	public StringProperty howMuchProperty() {
		return howMuch;
	}
	@Column(name = "how_much_to")

	
	public  String getHowMuchTo() {
		return howMuchTo.get();
	}

	public  void setHowMuchTo(String howMuchTo) {
		this.howMuchTo.set(howMuchTo);
	}

	public StringProperty howMuchToProperty() {
		return howMuchTo;
	}
	@Column(name = "how_much_form")
	
	
	public  String getHowMuchform() {
		return howMuchform.get();
	}

	public  void setHowMuchform(String howMuchform) {
		this.howMuchform.set(howMuchform);
	}

	public StringProperty howMuchformProperty() {
		return howMuchform;
	}
	@Column(name = "route")
	
	
	public  String getRoute() {
		return route.get();
	}

	public  void setRoute(String route) {
		this.route.set(route);
	}

	public StringProperty routeProperty() {
		return route;
	}
	@Column(name = "frequency")

	
	public  String getFrequency() {
		return frequency.get();
	}

	public  void setFrequency(String frequency) {
		this.frequency.set(frequency);
	}
	public StringProperty frequencyProperty() {
		return frequency;
	}
	@Column(name = "how_long")
	
	
	public  String getHowLong() {
		return frequency.get();
	}

	public  void setHowLong(String howLong) {
		this.howLong.set(howLong);
	}

	public StringProperty howLongProperty() {
		return howLong;
	}
	@Column(name = "how_long_month_or_year")

	
	public  String getHowLongMonthOrYear() {
		return howLongMonthOrYear.get();
	}

	public  void setHowLongMonthOrYear(String howLongMonthOrYear) {
		this.howLongMonthOrYear.set(howLongMonthOrYear);
	}

	public StringProperty howLongMonthOrYearProperty() {
		return howLongMonthOrYear;
	}
	@Column(name = "special")
	
	public  String getSpecial() {
		return special.get();
	}

	public  void setSpecial(String special) {
		this.special.set(special);
	}

	public StringProperty specialProperty() {
		return special;
	}
	
	
	@Column(name = "additional_sig")

	public  String getAdditionalSig() {
		return additionalSig.get();
	}

	public  void setAdditionalSig(String additionalSig) {
		this.additionalSig.set(additionalSig);
	}

	public StringProperty additionalSigProperty() {
		return additionalSig;
	}
	
	@Column(name = "med_strength")

	public  String getMedStrength() {
		return medStrength.get();
	}

	public  void setMedStrength(String medStrength) {
		this.medStrength.set(medStrength);
	}

	public StringProperty medStrengthProperty() {
		return medStrength;
	}
	
}
