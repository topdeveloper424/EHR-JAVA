package com.ets.model;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderSchedule Class
 *Description: Entity class
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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "provider_schedule")

public class ProviderSchedule {
	
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
	private SimpleObjectProperty<Provider> provider = new SimpleObjectProperty<Provider>(this, "provider");

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "provider_id")
	public Provider getProvider() {
		return provider.get();
	}

	public void setProvider(Provider provider) {
		this.provider.set(provider);
	}

	public SimpleObjectProperty<Provider> providerProperty() {
		return provider;
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
	
	/*// Column 2
		private ObjectProperty<Date> startTime = new SimpleObjectProperty<Date>();

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

	public ProviderSchedule() {
		
	}

	public ProviderSchedule(String weekday) {
		
		this.weekday = new SimpleStringProperty(weekday);
	}
		

}
