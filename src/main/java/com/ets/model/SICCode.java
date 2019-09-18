package com.ets.model;



import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 25-03-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SICCode Class
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
@Table(name = "sic_code")

public class SICCode {
	
	/***************
	 * Column property ( 1 )
	 *****************************************/

	private  IntegerProperty id = new SimpleIntegerProperty(this, "id");

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

	/***************
	 * Column property ( 2 )
	 *****************************************/

	private  StringProperty code = new SimpleStringProperty(this, "code");

	@Column(name = "code")
	public  String getCode() {
		return code.get();
	}

	public  void setCode(String code) {
		this.code.set(code);
	}

	public StringProperty codeProperty() {
		return code;
	}

	/***************
	 * Column property ( 3 )
	 *****************************************/

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
	
	/***************
	 * Column property ( 4 )
	 *****************************************/

	private  StringProperty workInjuryRate = new SimpleStringProperty(this,
			"workInjuryRate");

	@Column(name = "work_injury_rate")
	public  String getWorkInjuryRate() {
		return workInjuryRate.get();
	}

	public  void setWorkInjuryRate(String workInjuryRate) {
		this.workInjuryRate.set(workInjuryRate);
	}

	public StringProperty workInjuryRateProperty() {
		return workInjuryRate;
	}
	
	/***************
	 * Column property ( 5 )
	 *****************************************/

	private  StringProperty lostTimeInjuryRate = new SimpleStringProperty(this,
			"lostTimeInjuryRate");

	@Column(name = "lost_time_injury_rate")
	public  String getLostTimeInjuryRate() {
		return lostTimeInjuryRate.get();
	}

	public  void setLostTimeInjuryRate(String lostTimeInjuryRate) {
		this.lostTimeInjuryRate.set(lostTimeInjuryRate);
	}

	public StringProperty lostTimeInjuryRateProperty() {
		return lostTimeInjuryRate;
	}
	
	/***************
	 * Column property ( 6 )
	 *****************************************/

	private  StringProperty lostWorkDays = new SimpleStringProperty(this,
			"lostWorkDays");

	@Column(name = "lost_work_days")
	public  String getLostWorkDays() {
		return lostWorkDays.get();
	}

	public  void setLostWorkDays(String lostWorkDays) {
		this.lostWorkDays.set(lostWorkDays);
	}

	public StringProperty lostWorkDaysProperty() {
		return lostWorkDays;
	}
	
	
	/***************
	 * Column property ( 7 )
	 *****************************************/

	private  StringProperty avgWageReplCost = new SimpleStringProperty(this,
			"avgWageReplCost");

	@Column(name = "avg_wage_repl_cost")
	public  String getAvgWageReplCost() {
		return avgWageReplCost.get();
	}

	public  void setAvgWageReplCost(String avgWageReplCost) {
		this.avgWageReplCost.set(avgWageReplCost);
	}

	public StringProperty avgWageReplCostProperty() {
		return avgWageReplCost;
	}
	
	/***************
	 * Column property ( 8 )
	 *****************************************/
	
	private  StringProperty avgCompPremiumPerEmp = new SimpleStringProperty(this,
			"avgCompPremiumPerEmp");

	@Column(name = "avg_comp_premium_per_emp")
	public  String getAvgCompPremiumPerEmp() {
		return avgCompPremiumPerEmp.get();
	}

	public  void setAvgCompPremiumPerEmp(String avgCompPremiumPerEmp) {
		this.avgCompPremiumPerEmp.set(avgCompPremiumPerEmp);
	}

	public StringProperty avgCompPremiumPerEmpProperty() {
		return avgCompPremiumPerEmp;
	}
	
	/***************
	 * Column property ( 9 )
	 *****************************************/

	private  StringProperty variablePremium = new SimpleStringProperty(this,
			"variablePremium");

	@Column(name = "variable_premium")
	public  String getVariablePremium() {
		return variablePremium.get();
	}

	public  void setVariablePremium(String variablePremium) {
		this.variablePremium.set(variablePremium);
	}

	public StringProperty variablePremiumProperty() {
		return variablePremium;
	}
	
	/***************
	 * Column property ( 10 )
	 *****************************************/

	private  SimpleBooleanProperty inactive = new SimpleBooleanProperty(
			this, "inactive");

	@Column(name = "inactive")
	public  boolean getInactive() {
		return inactive.get();
	}

	public  void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}
	
	/*private List<Company> companies;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy="sicCode" , cascade=CascadeType.ALL)
	public List<Company> getCompanies() {
		return companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}*/

	public SICCode() {
		
	}
	
	

}
