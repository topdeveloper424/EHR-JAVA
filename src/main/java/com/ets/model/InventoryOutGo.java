package com.ets.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "inventory_out_go")
public class InventoryOutGo {
	
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
	
	private SimpleObjectProperty<InventoryDescription> inventory = new SimpleObjectProperty<InventoryDescription>(this, "inventory");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inventory_id")
	public InventoryDescription getInventory() {
		return inventory.get();
	}

	public void setInventory(InventoryDescription inventory) {
		this.inventory.set(inventory);
	}

	public SimpleObjectProperty<InventoryDescription> inventoryProperty() {
		return inventory;
	}

	private StringProperty quantityOut = new SimpleStringProperty(this, "quantityOut");

	@Column(name = "quantity_out")
	public String getQuantityOut() {
		return quantityOut.get();
	}

	public void setQuantityOut(String quantityOut) {
		this.quantityOut.set(quantityOut);
	}

	public StringProperty quantityOutProperty() {
		return quantityOut;
	}
	
	private ObjectProperty<Date> outGoDate = new SimpleObjectProperty<Date>();

	@Column(name = "out_go_date")
	@Temporal(TemporalType.DATE)
	public Date getOutGoDate() {
		return outGoDate.get();
	}

	public void setOutGoDate(Date outGoDate) {
		this.outGoDate.set(outGoDate);
	}

	public ObjectProperty<Date> outGoDateProperty() {
		return this.outGoDate;
	}
	
	private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

	@ManyToOne(fetch = FetchType.EAGER)
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
	
	private SimpleObjectProperty<Patient> patient = new SimpleObjectProperty<Patient>(this, "patient");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patient_id")
	public Patient getPatient() {
		return patient.get();
	}

	public void setPatient(Patient patient) {
		this.patient.set(patient);
	}

	public SimpleObjectProperty<Patient> patientProperty() {
		return patient;
	}
	
	private SimpleObjectProperty<UserAccount> userAccount = new SimpleObjectProperty<UserAccount>(this, "userAccount");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "user_account_id")
	public UserAccount getUserAccount() {
		return userAccount.get();
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount.set(userAccount);
	}

	public SimpleObjectProperty<UserAccount> userAccountProperty() {
		return userAccount;
	}

	public InventoryOutGo() {
		// TODO Auto-generated constructor stub
	}

}
