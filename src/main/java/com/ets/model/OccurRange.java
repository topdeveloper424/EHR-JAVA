package com.ets.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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

@Entity
@Table(name = "occur_range")

public class OccurRange {
	
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
	
	private  StringProperty blockedEndTime = new SimpleStringProperty(this, "blockedEndTime");

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
	
//	private IntegerProperty endAfter = new SimpleIntegerProperty(this, "endAfter");
//	@Column(name = "end_after")
//	
//	public Integer getEndAfter() {
//		return endAfter.get();
//	}
//
//	public void setEndAfter(Integer endAfter) {
//		this.endAfter.set(endAfter);
//	}
//
//	public IntegerProperty endAfterProperty() {
//		return endAfter;
//	}
//	
	private  StringProperty endAfter = new SimpleStringProperty(this, "endAfter");

	@Column(name = "end_after")
	public  String getEndAfter() {
		return endAfter.get();
	}
	public  void setEndAfter(String endAfter) {
		this.endAfter.set(endAfter);
	}
	public StringProperty endAfterProperty() {
		return endAfter;
	}
	
	
	private SimpleBooleanProperty noEndDate = new SimpleBooleanProperty(this, "noEndDate");

	@Column(name = "no_end_date")
	public boolean getNoEndDate() {
		return noEndDate.get();
	}
	
	public void setNoEndDate(boolean noEndDate) {
		this.noEndDate.set(noEndDate);
	}

	public BooleanProperty noEndDateProperty() {
		return noEndDate;
	}
	
	// Column 2
	
			private ObjectProperty<Date> startDate = new SimpleObjectProperty<Date>();

			@Column(name = "start_date")
			@Temporal(TemporalType.DATE)
			public Date getStartDate() {
				return startDate.get();
			}

			public void setStartDate(Date startDate) {
				this.startDate.set(startDate);
			}

			public ObjectProperty<Date> startDateProperty() {
				return this.startDate;
			}
			
				// Column 2
			
					private ObjectProperty<Date> endByDate = new SimpleObjectProperty<Date>();

					@Column(name = "end_by_date")
					@Temporal(TemporalType.DATE)
					public Date getEndByDate() {
						return endByDate.get();
					}

					public void setEndByDate(Date endByDate) {
						this.endByDate.set(endByDate);
					}

					public ObjectProperty<Date> endByDateProperty() {
						return this.endByDate;
					}


	public OccurRange() {
		
	}

}
