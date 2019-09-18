package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "recur_pattern")

public class RecurPattern {
	
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
	
	private  SimpleBooleanProperty dailyRecur = new SimpleBooleanProperty(
			this, "dailyRecur");

	@Column(name = "daily_recur")
	public  boolean getDailyRecur() {
		return dailyRecur.get();
	}

	public  void setDailyRecur(boolean dailyRecur) {
		this.dailyRecur.set(dailyRecur);
	}

	public BooleanProperty dailyRecurProperty() {
		return dailyRecur;
	}




	private SimpleBooleanProperty weeklyRecur = new SimpleBooleanProperty(this, "weeklyRecur");

	@Column(name = "weekly_recur")
	public boolean getWeeklyRecur() {
		return weeklyRecur.get();
	}

	public void setWeeklyRecur(boolean weeklyRecur) {
		this.weeklyRecur.set(weeklyRecur);
	}

	public BooleanProperty weeklyRecurProperty() {
		return weeklyRecur;
	}
	
	private SimpleBooleanProperty monthlyRecur = new SimpleBooleanProperty(this, "monthlyRecur");

	@Column(name = "monthly_recur")
	public boolean getMonthlyRecur() {
		return monthlyRecur.get();
	}

	public void setMonthlyRecur(boolean monthlyRecur) {
		this.monthlyRecur.set(monthlyRecur);
	}

	public BooleanProperty monthlyRecurProperty() {
		return monthlyRecur;
	}
	
	private SimpleBooleanProperty everyWeekDay = new SimpleBooleanProperty(this, "everyWeekDay");

	@Column(name = "every_week_way")
	public boolean getEveryWeekDay() {
		return everyWeekDay.get();
	}

	public void setEveryWeekDay(boolean everyWeekDay) {
		this.everyWeekDay.set(everyWeekDay);
	}

	public BooleanProperty everyWeekDayProperty() {
		return everyWeekDay;
	}
	
	private  StringProperty afterEvery = new SimpleStringProperty(this, "afterEvery");

	@Column(name = "after_every")
	public  String getAfterEvery() {
		return afterEvery.get();
	}
	public  void setAfterEvery(String afterEvery) {
		this.afterEvery.set(afterEvery);
	}
	public StringProperty afterEveryProperty() {
		return afterEvery;
	}
	
	private SimpleBooleanProperty sunday = new SimpleBooleanProperty(this, "sunday");

	@Column(name = "sunday")
	public boolean getSunday() {
		return sunday.get();
	}
	
	public void setSunday(boolean sunday) {
		this.sunday.set(sunday);
	}

	public BooleanProperty sundayProperty() {
		return sunday;
	}
	
	
	private SimpleBooleanProperty monday = new SimpleBooleanProperty(this, "monday");

	@Column(name = "monday")
	public boolean getMonday() {
		return monday.get();
	}
	
	public void setMonday(boolean monday) {
		this.monday.set(monday);
	}

	public BooleanProperty mondayProperty() {
		return monday;
	}
	private SimpleBooleanProperty tuesday = new SimpleBooleanProperty(this, "tuesday");

	@Column(name = "tuesday")
	public boolean getTuesday() {
		return tuesday.get();
	}
	
	public void setTuesday(boolean tuesday) {
		this.tuesday.set(tuesday);
	}

	public BooleanProperty tuesdayProperty() {
		return tuesday;
	}
	private SimpleBooleanProperty wednesday = new SimpleBooleanProperty(this, "wednesday");

	@Column(name = "wednesday")
	public boolean getWednesday() {
		return wednesday.get();
	}
	
	public void setWednesday(boolean wednesday) {
		this.wednesday.set(wednesday);
	}

	public BooleanProperty wednesdayProperty() {
		return wednesday;
	}
	private SimpleBooleanProperty thursday = new SimpleBooleanProperty(this, "thursday");

	@Column(name = "thursday")
	public boolean getThursday() {
		return thursday.get();
	}
	
	public void setThursday(boolean thursday) {
		this.thursday.set(thursday);
	}

	public BooleanProperty thursdayProperty() {
		return thursday;
	}
	private SimpleBooleanProperty friday = new SimpleBooleanProperty(this, "friday");

	@Column(name = "friday")
	public boolean getFriday() {
		return friday.get();
	}
	
	public void setFriday(boolean friday) {
		this.friday.set(friday);
	}

	public BooleanProperty fridayProperty() {
		return friday;
	}
	
	private SimpleBooleanProperty saturday = new SimpleBooleanProperty(this, "saturday");

	@Column(name = "saturday")
	public boolean getSaturday() {
		return saturday.get();
	}
	
	public void setSaturday(boolean saturday) {
		this.saturday.set(saturday);
	}

	public BooleanProperty saturdayProperty() {
		return saturday;
	}
	
	private SimpleBooleanProperty noOfDay = new SimpleBooleanProperty(this, "noOfDay");

	@Column(name = "noOfDay")
	public boolean getNoOfDay() {
		return noOfDay.get();
	}
	
	public void setNoOfDay(boolean noOfDay) {
		this.noOfDay.set(noOfDay);
	}

	public BooleanProperty noOfDayProperty() {
		return noOfDay;
	}
	
	
	
	private  StringProperty weekday = new SimpleStringProperty(this, "weekday");
	@Column(name = "weekday")
	public  String getWeekday() {
		return weekday.get();
	}

	public  void setWeekday(String weekday) {
		this.weekday.set(weekday);
}

	public StringProperty weekdayProperty() {
	return weekday;
	}
	

	private  StringProperty dayOfMonth = new SimpleStringProperty(this, "dayOfMonth");

	@Column(name = "day_of_month")
	public  String getDayOfMonth() {
		return dayOfMonth.get();
	}

	public  void setDayOfMonth(String dayOfMonth) {
		this.dayOfMonth.set(dayOfMonth);
	}

	public StringProperty dayOfMonthProperty() {
		return dayOfMonth;
	
	}
	private IntegerProperty recurAfterEveryMonth = new SimpleIntegerProperty(this, "recurAfterEveryMonth");
	@Column(name = "recur_after_every_month")
	public Integer getRecurAfterEveryMonth() {
		return recurAfterEveryMonth.get();
	}

	
	public void setRecurAfterEveryMonth(Integer recurAfterEveryMonth) {
		this.recurAfterEveryMonth.set(recurAfterEveryMonth);
	}


	public IntegerProperty recurAfterEveryMonthProperty() {
		return this.recurAfterEveryMonth;
	}
	private  StringProperty weekOfMonth = new SimpleStringProperty(this, "weekOfMonth");

	@Column(name = "week_of_Month")
	public  String getWeekOfMonth() {
		return weekOfMonth.get();
	}
	public  void setWeekOfMonth(String weekOfMonth) {
		this.weekOfMonth.set(weekOfMonth);
	}
	public StringProperty weekOfMonthProperty() {
		return weekOfMonth;
	}
	private  StringProperty weekDayOfMonth = new SimpleStringProperty(this, "weekDayOfMonth");

	@Column(name = "week_day_of_Month")
	public  String getWeekDayOfMonth() {
		return weekDayOfMonth.get();
	}
	public  void setWeekDayOfMonth(String weekDayOfMonth) {
		this.weekDayOfMonth.set(weekDayOfMonth);
	}
	public StringProperty weekDayOfMonthProperty() {
		return weekDayOfMonth;
	}
	
	private SimpleBooleanProperty recurDayAfterEveryMonth = new SimpleBooleanProperty(this, "recurDayAfterEveryMonth");

	@Column(name = "recurDayAfterEveryMonth")
	public boolean getRecurDayAfterEveryMonth() {
		return recurDayAfterEveryMonth.get();
	}
	
	public void setRecurDayAfterEveryMonth(boolean recurDayAfterEveryMonth) {
		this.recurDayAfterEveryMonth.set(recurDayAfterEveryMonth);
	}

	public BooleanProperty recurDayAfterEveryMonthProperty() {
		return recurDayAfterEveryMonth;
	}
	private SimpleBooleanProperty recurWeekDayEveryMonth = new SimpleBooleanProperty(this, "recurWeekDayEveryMonth");

	@Column(name = "recurWeekDayEveryMonth")
	public boolean getRecurWeekDayEveryMonth() {
		return recurWeekDayEveryMonth.get();
	}
	
	public void setRecurWeekDayEveryMonth(boolean recurWeekDayEveryMonth) {
		this.recurWeekDayEveryMonth.set(recurWeekDayEveryMonth);
	}

	public BooleanProperty recurWeekDayEveryMonthProperty() {
		return recurWeekDayEveryMonth;
	}
	public RecurPattern() {
		
	}

}
