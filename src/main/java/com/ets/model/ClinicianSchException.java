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
import javax.persistence.ManyToOne;
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
@Table(name = "clinician_sch_exception")

public class ClinicianSchException {
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

	@ManyToOne(fetch = FetchType.EAGER)
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

	/*private StringProperty weekday = new SimpleStringProperty(this, "weekday");

	@Column(name = "weekday")
	public String getWeekday() {
		return weekday.get();
	}

	public void setWeekday(String weekday) {
		this.weekday.set(weekday);
	}

	public StringProperty weekdayProperty() {
		return weekday;
	}*/

	// Column 2
	private ObjectProperty<Date> excepDate = new SimpleObjectProperty<Date>();

	@Column(name = "excep_date")
	@Temporal(TemporalType.DATE)
	public Date getExcepDate() {
		return excepDate.get();
	}

	public void setExcepDate(Date excepDate) {
		this.excepDate.set(excepDate);
	}

	public ObjectProperty<Date> excepDateDateProperty() {
		return this.excepDate;
	}
	public ClinicianSchException() {
		// TODO Auto-generated constructor stub
	}

}
