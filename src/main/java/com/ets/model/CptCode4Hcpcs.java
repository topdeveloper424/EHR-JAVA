package com.ets.model;

import java.util.Date;
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
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 29-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CptCode Class
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
@Table(name = "cpt_code")

public class CptCode4Hcpcs {
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
	private StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public String getCode() {
		return code.get();
	}

	public void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
	}

	// Collumn 3

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

	// Collumn 4

	private StringProperty codeType = new SimpleStringProperty(this, "codeType");

	@Column(name = "code_type")
	public String getCodeType() {
		return codeType.get();
	}

	public void setCodeType(String codeType) {
		this.codeType.set(codeType);
	}

	public StringProperty codeTypeProperty() {
		return codeType;
	}

	// Collumn 5

	private StringProperty wrkCompCrgCurrent = new SimpleStringProperty(this, "wrkCompCrgCurrent");

	@Column(name = "wrk_comp_crg_current")
	public String getWrkCompCrgCurrent() {
		return wrkCompCrgCurrent.get();
	}

	public void setWrkCompCrgCurrent(String wrkCompCrgCurrent) {
		this.wrkCompCrgCurrent.set(wrkCompCrgCurrent);
	}

	public StringProperty wrkCompCrgCurrentProperty() {
		return wrkCompCrgCurrent;
	}

	// Collumn 6

	private ObjectProperty<Date> wrkCompCrgEffective = new SimpleObjectProperty<Date>();

	@Column(name = "wrk_comp_crg_effective")
	@Temporal(TemporalType.DATE)
	public Date getWrkCompCrgEffective() {
		return wrkCompCrgEffective.get();
	}

	public void setWrkCompCrgEffective(Date wrkCompCrgEffective) {
		this.wrkCompCrgEffective.set(wrkCompCrgEffective);
	}

	private ObjectProperty<Date> wrkCompCrgEffectiveProperty() {
		return this.wrkCompCrgEffective;
	}

	// Collumn 7

	private StringProperty wrkCompFutureCrg = new SimpleStringProperty(this, "wrkCompFutureCrg");

	@Column(name = "wrk_comp_future_crg")
	public String getWrkCompFutureCrg() {
		return wrkCompFutureCrg.get();
	}

	public void setWrkCompFutureCrg(String wrkCompFutureCrg) {
		this.wrkCompFutureCrg.set(wrkCompFutureCrg);
	}

	public StringProperty wrkCompFutureCrgProperty() {
		return wrkCompFutureCrg;
	}
	// Collumn 8

	private ObjectProperty<Date> wrkCompFutureEffective = new SimpleObjectProperty<Date>();

	@Column(name = "wrk_comp_future_effective")
	@Temporal(TemporalType.DATE)
	public Date getWrkCompFutureEffective() {
		return wrkCompFutureEffective.get();
	}

	public void setWrkCompFutureEffective(Date wrkCompFutureEffective) {
		this.wrkCompFutureEffective.set(wrkCompFutureEffective);
	}

	private ObjectProperty<Date> wrkCompFutureEffectiveProperty() {
		return this.wrkCompFutureEffective;
	}

	// Collumn 9

	private StringProperty pvtPracticeCrgCurrent = new SimpleStringProperty(this, "pvtPracticeCrgCurrent");

	@Column(name = "pvt_practice_crg_current")
	public String getPvtPracticeCrgCurrent() {
		return pvtPracticeCrgCurrent.get();
	}

	public void setPvtPracticeCrgCurrent(String pvtPracticeCrgCurrent) {
		this.pvtPracticeCrgCurrent.set(pvtPracticeCrgCurrent);
	}

	public StringProperty pvtPracticeCrgCurrentProperty() {
		return pvtPracticeCrgCurrent;
	}

	// Collumn 10

	private ObjectProperty<Date> pvtPracticeEffective = new SimpleObjectProperty<Date>();

	@Column(name = "pvt_practice_effective")
	@Temporal(TemporalType.DATE)
	public Date getPvtPracticeEffective() {
		return pvtPracticeEffective.get();
	}

	public void setPvtPracticeEffective(Date pvtPracticeEffective) {
		this.pvtPracticeEffective.set(pvtPracticeEffective);
	}

	public ObjectProperty<Date> pvtPracticeEffectiveProperty() {
		return pvtPracticeEffective;
	}

	// Collumn 11

	private StringProperty pvtPracticeFutureCrg = new SimpleStringProperty(this, "pvtPracticeFutureCrg");

	@Column(name = "pvt_practice_future_crg")
	public String getPvtPracticeFutureCrg() {
		return pvtPracticeFutureCrg.get();
	}

	public void setPvtPracticeFutureCrg(String pvtPracticeFutureCrg) {
		this.pvtPracticeFutureCrg.set(pvtPracticeFutureCrg);
	}

	public StringProperty pvtPracticeFutureCrgProperty() {
		return pvtPracticeFutureCrg;
	}

	// Collumn 12

	private ObjectProperty<Date> pvtPracticeFutureEfective = new SimpleObjectProperty<Date>();

	@Column(name = "pvt_practice_future_efective")
	@Temporal(TemporalType.DATE)
	public Date getPvtPracticeFutureEfective() {
		return pvtPracticeFutureEfective.get();
	}

	public void setPvtPracticeFutureEfective(Date pvtPracticeFutureEfective) {
		this.pvtPracticeFutureEfective.set(pvtPracticeFutureEfective);
	}

	public ObjectProperty<Date> pvtPracticeFutureEfectiveProperty() {
		return pvtPracticeFutureEfective;
	}

	// Collumn 13

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
	
	private List<MedicalActivity> medicalActivities;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="cptCode4Hcpcs" , cascade=CascadeType.ALL)
	public List<MedicalActivity> getMedicalActivities() {
		return medicalActivities;
	}

	public void setMedicalActivities(List<MedicalActivity> medicalActivities) {
		this.medicalActivities = medicalActivities;
	}

	public CptCode4Hcpcs() {

	}

}
