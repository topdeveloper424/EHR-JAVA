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
@Table(name = "inventory_description")
public class InventoryDescription {
	
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
	
	private  StringProperty type = new SimpleStringProperty(this, "type");
	
	@Column(name = "type")
	public  String getType(){
		return type.get();
	}
	
	public void setType(String type){
		this.type.set(type);
	}
	
	public StringProperty typeProperty(){
		return type;
	}
	
	private  StringProperty name = new SimpleStringProperty(this, "name");
	
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
	
	private StringProperty descrip = new SimpleStringProperty(this, "descrip");

	@Column(name = "descrip")
	public String getDescrip() {
		return descrip.get();
	}

	public void setDescrip(String descrip) {
		this.descrip.set(descrip);
	}

	public StringProperty descripProperty() {
		return descrip;
	}
	
	private StringProperty epcCode = new SimpleStringProperty(this, "epcCode");

	@Column(name = "epc_code")
	public String getEpcCode() {
		return epcCode.get();
	}

	public void setEpcCode(String epcCode) {
		this.epcCode.set(epcCode);
	}

	public StringProperty epcCodeProperty() {
		return epcCode;
	}
	
	/*private StringProperty quentityInStock = new SimpleStringProperty(this, "quentityInStock");

	@Column(name = "quentity_in_stock")
	public String getQuentityInStock() {
		return quentityInStock.get();
	}

	public void setQuentityInStock(String quentityInStock) {
		this.quentityInStock.set(quentityInStock);
	}

	public StringProperty quentityInStockProperty() {
		return quentityInStock;
	}*/
	
	private StringProperty unitDescrp = new SimpleStringProperty(this, "unitDescrp");

	@Column(name = "unit_descrp")
	public String getUnitDescrp() {
		return unitDescrp.get();
	}

	public void setUnitDescrp(String unitDescrp) {
		this.unitDescrp.set(unitDescrp);
	}

	public StringProperty unitDescrpProperty() {
		return unitDescrp;
	}


	public InventoryDescription() {
		
	}

}
