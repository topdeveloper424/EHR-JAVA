package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="drug_screen_drug_name")
public class DrugScreenDrugName {
	
	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

	@Id
	
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
	
	private StringProperty dsType = new SimpleStringProperty(this, "dsType");

	@Column(name = "ds_type")
	public String getDsType() {
		return dsType.get();
	}

	public void setDsType(String dsType) {
		this.dsType.set(dsType);
	}

	public StringProperty dsTypeProperty() {
		return dsType;
	}
	
	private StringProperty drugName = new SimpleStringProperty(this, "drugName");

	@Column(name = "drug_name")
	public String getDrugName() {
		return drugName.get();
	}

	public void setDrugName(String drugName) {
		this.drugName.set(drugName);
	}

	public StringProperty drugNameProperty() {
		return drugName;
	}
	
	private StringProperty prelimResult = new SimpleStringProperty(this, "prelimResult");

	@Column(name = "prelim_result")
	public String getPrelimResult() {
		return prelimResult.get();
	}

	public void setPrelimResult(String prelimResult) {
		this.prelimResult.set(prelimResult);
	}

	public StringProperty prelimResultProperty() {
		return prelimResult;
	}


	public DrugScreenDrugName() {
		
	}

	
	public DrugScreenDrugName(String prelimResult) {
		
		this.prelimResult = new SimpleStringProperty(prelimResult);
	}
	
	

}
