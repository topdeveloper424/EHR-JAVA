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
@Table(name = "user_defined_form")
public class UserDefinedForm {
	
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
	

	private StringProperty formName = new SimpleStringProperty(this, "formName");

	@Column(name = "form_name")
	public String getFormName() {
		return formName.get();
	}

	public  void setFormName(String formName) {
		this.formName.set(formName);
	}

	public StringProperty formNameProperty() {
		return formName;
	}
	
	
	private StringProperty formType = new SimpleStringProperty(this, "formType");

	@Column(name = "form_type")
	public String getFormType() {
		return formType.get();
	}

	public  void setFormType(String formType) {
		this.formType.set(formType);
	}

	public StringProperty formTypeProperty() {
		return formType;
	}
	
	
	private StringProperty formPath = new SimpleStringProperty(this, "formPath");

	@Column(name = "form_path")
	public String getFormPath() {
		return formPath.get();
	}

	public  void setFormPath(String formPath) {
		this.formPath.set(formPath);
	}

	public StringProperty formPathProperty() {
		return formPath;
	}

}
