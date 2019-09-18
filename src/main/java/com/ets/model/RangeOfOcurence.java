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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;


@Entity
@Table(name = "range_of_ocurence")

public class RangeOfOcurence {

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
	

	private Date startDate;

	@Column(name = "start_date")
	@Temporal(TemporalType.DATE)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	private Date noEndDate;

	@Column(name = "no_end_date")
	@Temporal(TemporalType.DATE)
	public Date getNoEndDate() {
		return noEndDate;
	}

	public void setNoEndDate(Date noEndDate) {
		this.noEndDate = noEndDate;
	}

	private Date endAfterDate;

	@Column(name = "end_after_date")
	@Temporal(TemporalType.DATE)
	public Date getEndAfterDate() {
		return endAfterDate;
	}

	public void setEndAfterDate(Date endAfterDate) {
		this.endAfterDate = endAfterDate;
	}

	private Date endByDate;

	@Column(name = "end_by_date")
	@Temporal(TemporalType.DATE)
	public Date getEndByDate() {
		return endByDate;
	}

	public void setEndByDate(Date endByDate) {
		this.endByDate = endByDate;
	}

	public RangeOfOcurence() {

	}

}
