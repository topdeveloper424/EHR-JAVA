package com.ets.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
@Entity
@Table(name="clinician_days_block_time")
public class ClinicianDaysBlockTime {

	
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

	@ManyToOne
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

	
	
	private StringProperty weekday = new SimpleStringProperty(this, "weekday");

	@Column(name = "weekday")
	public String getWeekday() {
		return weekday.get();
	}

	public void setWeekday(String weekday) {
		this.weekday.set(weekday);
	}

	public StringProperty weekdayProperty() {
		return weekday;
	}
	
	// Column 2
	private StringProperty startTime = new SimpleStringProperty(this, "startTime");

	@Column(name = "start_time")
	public String getStartTime() {
		return startTime.get();
	}

	public void setStartTime(String startTime) {
		this.startTime.set(startTime);
	}

	public StringProperty startTimeProperty() {
		return startTime;
	}
		
		// Column 2
	private StringProperty endTime = new SimpleStringProperty(this, "endTime");

	@Column(name = "end_time")
	public String getEndTime() {
		return endTime.get();
	}

	public void setEndTime(String endTime) {
		this.endTime.set(endTime);
	}

	public StringProperty endTimeProperty() {
		return endTime;
	}
		

}

