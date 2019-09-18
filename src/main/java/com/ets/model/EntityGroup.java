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


/**
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 09-08-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntityGroup Class
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
@Table(name = "entity_group")

public class EntityGroup {
	// Column 1
	private IntegerProperty id = new SimpleIntegerProperty();
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


	// Column 2
	private  StringProperty name = new SimpleStringProperty(this,"name");

	@Column(name = "name")
	public  String getName(){
		return name.get();
	}

	public void setName(String name){
		this.name.set(name);
	}

	public StringProperty nameProperty(){
		return name;
	}


	// Column 3
	private  StringProperty tableName = new SimpleStringProperty(this,"tableName");

	@Column(name = "table_name")
	public  String getTableName(){
		return tableName.get();
	}

	public void setTableName(String tableName){
		this.tableName.set(tableName);
	}

	public StringProperty tableNameProperty(){
		return tableName;
	}


	// Column 4
	private IntegerProperty tableGroupId = new SimpleIntegerProperty();

	@Column(name = "table_group_id")
	public Integer getTableGroupId() {
		return tableGroupId.get();
	}

	public void setTableGroupId(Integer tableGroupId) {
		this.tableGroupId.set(tableGroupId);
	}

	public IntegerProperty tableGroupIdProperty() {
		return this.tableGroupId;
	}


	public EntityGroup() {

	}

}