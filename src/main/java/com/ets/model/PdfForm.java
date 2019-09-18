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
@Table(name = "pdf_form")

public class PdfForm {
	
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

	
	private  StringProperty name = new SimpleStringProperty(this, "name");

	@Column(name = "name")
	public  String getName() {
		return name.get();
	}

	public  void setName(String name) {
		this.name.set(name);
	}

	public StringProperty nameProperty() {
		return name;
	}
	
	private  StringProperty path = new SimpleStringProperty(this, "path");

	@Column(name = "path")
	public  String getPath() {
		return path.get();
	}

	public  void setPath(String path) {
		this.path.set(path);
	}

	public StringProperty pathProperty() {
		return path;
	}
	
	private  StringProperty lastedUpdatedBy = new SimpleStringProperty(this, "lastedUpdatedBy");

	@Column(name = "lasted_updated_by")
	public  String getLastedUpdatedBy() {
		return lastedUpdatedBy.get();
	}

	public  void setLastedUpdatedBy(String lastedUpdatedBy) {
		this.lastedUpdatedBy.set(lastedUpdatedBy);
	}

	public StringProperty lastedUpdatedByProperty() {
		return lastedUpdatedBy;
	}
	
	private  StringProperty inactivatedByUser = new SimpleStringProperty(this, "inactivatedByUser");

	@Column(name = "inactivated_by_user")
	public  String getInactivatedByUser() {
		return inactivatedByUser.get();
	}

	public  void setInactivatedByUser(String inactivatedByUser) {
		this.inactivatedByUser.set(inactivatedByUser);
	}

	public StringProperty inactivatedByUserProperty() {
		return inactivatedByUser;
	}
	
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

	public PdfForm() {
		
	}

}
