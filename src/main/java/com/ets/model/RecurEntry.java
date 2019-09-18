package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "recur_entry")

public class RecurEntry {
	
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
	
	private  StringProperty descrp = new SimpleStringProperty(this,
			"descrp");

	@Column(name = "descrp")
	public  String getDescrp() {
		return descrp.get();
	}

	public  void setDescrp(String descrp) {
		this.descrp.set(descrp);
	}

	public StringProperty descrpProperty() {
		return descrp;
	}
	
	private  StringProperty blockedStartTime = new SimpleStringProperty(this, "blockedStartTime");

	@Column(name = "blocked_start_time")
	public  String getBlockedStartTime() {
		return blockedStartTime.get();
	}

	public  void setBlockedStartTime(String blockedStartTime) {
		this.blockedStartTime.set(blockedStartTime);
	}

	public StringProperty blockedStartTimeProperty() {
		return blockedStartTime;
	}
	
	private  StringProperty blockedEndTime = new SimpleStringProperty(this,
			"blockedEndTime");

	@Column(name = "blocked_end_time")
	public  String getBlockedEndTime() {
		return blockedEndTime.get();
	}

	public  void setBlockedEndTime(String blockedEndTime) {
		this.blockedEndTime.set(blockedEndTime);
	}

	public StringProperty blockedEndTimeProperty() {
		return blockedEndTime;
	}

	public RecurEntry() {
		
	}

}
