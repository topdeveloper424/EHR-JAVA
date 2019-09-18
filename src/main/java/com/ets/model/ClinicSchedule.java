package com.ets.model;

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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "clinic_schedule")

public class ClinicSchedule {
	
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

	/*private SimpleBooleanProperty openStatus = new SimpleBooleanProperty(this, "openStatus");

	@Column(name = "open_status")
	public boolean getOpenStatus() {
		return openStatus.get();
	}

	public void setOpenStatus(boolean openStatus) {
		this.openStatus.set(openStatus);
	}

	public BooleanProperty openStatusProperty() {
		return openStatus;
	}*/
	
	
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
	
	private StringProperty timeslotSize = new SimpleStringProperty(this, "timeslotSize");

	@Column(name = "timeslot_size")
	public String getTimeslotSize() {
		return timeslotSize.get();
	}

	public void setTimeslotSize(String timeslotSize) {
		this.timeslotSize.set(timeslotSize);
	}

	public StringProperty timeslotSizeProperty() {
		return timeslotSize;
	}
	
	// Column 14
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
	
		
		// Column 10
				/*private SimpleObjectProperty<ClinicClosed> clinicClosed = new SimpleObjectProperty<ClinicClosed>(this, "clinicClosed");

				@OneToOne(fetch = FetchType.EAGER)
				@JoinColumn(name = "clinic_closed_id")
				public ClinicClosed getClinicClosed() {
					return clinicClosed.get();
				}

				public void setClinicClosed(ClinicClosed clinicClosed) {
					this.clinicClosed.set(clinicClosed);
				}

				public SimpleObjectProperty<ClinicClosed> clinicClosedProperty() {
					return clinicClosed;
				}*/
	
	public ClinicSchedule() {
		
	}

		public ClinicSchedule(String weekday) {
			
			this.weekday = new SimpleStringProperty(weekday);
		}
	
	

}
