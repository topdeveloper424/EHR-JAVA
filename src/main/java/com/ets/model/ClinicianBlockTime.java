package com.ets.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "clinician_block_time")

public class ClinicianBlockTime {
	
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
	private SimpleObjectProperty<Clinician> clinician = new SimpleObjectProperty<Clinician>(this, "clinician");

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "clinician_id")
	public Clinician getClinician() {
		return clinician.get();
	}

	public void setClinician(Clinician clinician) {
		this.clinician.set(clinician);
	}

	public SimpleObjectProperty<Clinician> clinicianProperty() {
		return clinician;
	}



	private ObjectProperty<Date> blockTimeDate = new SimpleObjectProperty<Date>();

	@Column(name = "blockTimeDate")
	@Temporal(TemporalType.DATE)
	public Date getBlockTimeDate() {
		return blockTimeDate.get();
	}

	public void setBlockTimeDate(Date blockTimeDate) {
		this.blockTimeDate.set(blockTimeDate);
	}

	public ObjectProperty<Date> blockTimeDateProperty() {
		return this.blockTimeDate;
	}
	
	private StringProperty blockTime = new SimpleStringProperty(this, "blockTime");

	@Column(name = "block_time")
	public String getBlockTime() {
		return blockTime.get();
	}

	public void setBlockTime(String blockTime) {
		this.blockTime.set(blockTime);
	}

	public StringProperty blockTimeProperty() {
		return blockTime;
	}
	
		

		


	public ClinicianBlockTime() {
		// TODO Auto-generated constructor stub
	}}