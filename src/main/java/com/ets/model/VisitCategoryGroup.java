package com.ets.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "visit_category_group")

public class VisitCategoryGroup {
	
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

	private  StringProperty descrip = new SimpleStringProperty(this,
			"descrip");

	@Column(name = "descrip")
	public  String getDescrip() {
		return descrip.get();
	}

	public  void setDescrip(String descrip) {
		this.descrip.set(descrip);
	}

	public StringProperty descripProperty() {
		return descrip;
	}

	public VisitCategoryGroup() {
		
	}
	
	

}
