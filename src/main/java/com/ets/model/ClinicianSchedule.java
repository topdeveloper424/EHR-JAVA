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
@Table(name = "clinician_schedule")

public class ClinicianSchedule {
	
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

	@ManyToOne(fetch = FetchType.EAGER )
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
	

	
	private StringProperty openTime = new SimpleStringProperty(this, "openTime");


	@Column(name = "open_time")
	public String getOpenTime() {
		return openTime.get();
	}

	public void setOpenTime(String openTime) {
		this.openTime.set(openTime);
	}

	public StringProperty openTimeProperty() {
		return openTime;
	}
	
	private StringProperty closeTime = new SimpleStringProperty(this, "closeTime");

	@Column(name = "close_time")
	public String getCloseTime() {
		return closeTime.get();
	}

	public void setCloseTime(String closeTime) {
		this.closeTime.set(closeTime);
	}

	public StringProperty closeTimeProperty() {
		return closeTime;
	}

	

	// Column 2
		/*private ObjectProperty<Date> startTime = new SimpleObjectProperty<Date>();

		@Column(name = "start_time")
		@Temporal(TemporalType.DATE)
		public Date getStartTime() {
			return startTime.get();
		}

		public void setStartTime(Date startTime) {
			this.startTime.set(startTime);
		}

		public ObjectProperty<Date> startTimeProperty() {
			return this.startTime;
		}
		
		// Column 2
				private ObjectProperty<Date> finishTime = new SimpleObjectProperty<Date>();

				@Column(name = "finish_time")
				@Temporal(TemporalType.DATE)
				public Date getFinishTime() {
					return finishTime.get();
				}

				public void setFinishTime(Date finishTime) {
					this.finishTime.set(finishTime);
				}

				public ObjectProperty<Date> finishTimeProperty() {
					return this.finishTime;
				}
*/
	public ClinicianSchedule() {
		
	}

	public ClinicianSchedule(String weekday) {
		
		this.weekday = new SimpleStringProperty(weekday);
	}
	
	
}
