package com.ets.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-09-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of JobClass Class
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


@Entity
@Table(name = "job_class")


public class JobClass {

	// Collumn 1
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

	// Collumn 2

	private StringProperty descrp = new SimpleStringProperty(this, "descrp");

	@Column(name = "descrp")
	public String getDescrp() {
		return descrp.get();
	}

	public void setDescrp(String descrp) {
		this.descrp.set(descrp);
	}

	public StringProperty descrpProperty() {
		return descrp;
	}

	// Collumn 3

	private StringProperty classOfJob = new SimpleStringProperty(this, "classOfJob");

	@Column(name = "class_of_job")
	public String getClassOfJob() {
		return classOfJob.get();
	}

	public void setClassOfJob(String classOfJob) {
		this.classOfJob.set(classOfJob);
	}

	public StringProperty classOfJobProperty() {
		return classOfJob;
	}

	// Collumn 4

	private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}
	 private List<CompanyProtocol> companyProtocol ;
	@OneToMany(fetch = FetchType.LAZY , mappedBy="jobClass" , cascade=CascadeType.ALL)
	public List<CompanyProtocol> getCompanyProtocol() {
		return companyProtocol;
	}

	public void setCompanyProtocol(List<CompanyProtocol> companyProtocol) {
		this.companyProtocol = companyProtocol;
	}
	public JobClass() {

	}

}
