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

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 09-08-2016 
 * Initial Version: 0.01 
 * Module Name: 
 * Parameter
 * Definition: Type object of LoginSchedule Class 
 * Description: Entity class
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: 
 * Owner: 
 * Date: 
 * Version: 
 * Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 */

@Entity
@Table(name = "login_schedule")


public class LoginSchedule {
	// Column 1
	private IntegerProperty id = new SimpleIntegerProperty();

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
	private SimpleObjectProperty<UserAccount> userAccount = new SimpleObjectProperty<UserAccount>(this, "userAccount");

	@ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name = "user_acount_id")
	public UserAccount getUserAccount() {
		return userAccount.get();
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount.set(userAccount);
	}

	public SimpleObjectProperty<UserAccount> userAcountProperty() {
		return userAccount;
	}

	// Column 3
	private IntegerProperty weekDayId = new SimpleIntegerProperty();

	@Column(name = "weekday_id")
	public Integer getWeekDayId() {
		return weekDayId.get();
	}

	public void setWeekDayId(Integer weekDayId) {
		this.weekDayId.set(weekDayId);
	}

	public IntegerProperty weekDayIdProperty() {
		return this.weekDayId;
	}

	// Column 4
	private ObjectProperty<Date> shiftStartTime = new SimpleObjectProperty<Date>();

	@Column(name = "shift_start_time")
	@Temporal(TemporalType.TIME)
	public Date getShiftStartTime() {
		return shiftStartTime.get();
	}

	public void setShiftStartTime(Date shiftStartTime) {
		this.shiftStartTime.set(shiftStartTime);
	}

	private ObjectProperty<Date> shiftStartTimeProperty() {
		return shiftStartTime;
	}

	// Column 5
	private ObjectProperty<Date> shiftEndTime = new SimpleObjectProperty<Date>();

	@Column(name = "shift_end_time")
	@Temporal(TemporalType.TIME)
	public Date getShiftEndTime() {
		return shiftEndTime.get();
	}

	public void setShiftEndTime(Date shiftEndTime) {
		this.shiftEndTime.set(shiftEndTime);
	}

	private ObjectProperty<Date> shiftEndTimeProperty() {
		return shiftEndTime;
	}

	// Column 5
	private SimpleBooleanProperty scheduledHoliday = new SimpleBooleanProperty(this, "scheduledHoliday");

	@Column(name = "scheduled_holiday")
	public boolean getScheduledHoliday() {
		return scheduledHoliday.get();
	}

	public void setScheduledHoliday(boolean scheduledHoliday) {
		this.scheduledHoliday.set(scheduledHoliday);
	}

	public BooleanProperty scheduledHolidayProperty() {
		return scheduledHoliday;
	}

	public LoginSchedule() {

	}

}