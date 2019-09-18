package com.ets.model;

import java.util.Date;

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

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 10-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ClinicClosed Class
 *Description: ClinicClosed model class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

@Entity
@Table(name = "clinic_closed")

public class ClinicClosed {

	// Column 1

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


	// Column 2
		private ObjectProperty<Date> scheduledDate = new SimpleObjectProperty<Date>();

		@Column(name = "scheduled_date")
		@Temporal(TemporalType.DATE)
		public Date getScheduledDate() {
			return scheduledDate.get();
		}

		public void setScheduledDate(Date scheduledDate) {
			this.scheduledDate.set(scheduledDate);
		}

		public ObjectProperty<Date> scheduledDateDateProperty() {
			return this.scheduledDate;
		}

		private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

		@OneToOne(fetch = FetchType.EAGER)
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

	public ClinicClosed() {

	}

}
