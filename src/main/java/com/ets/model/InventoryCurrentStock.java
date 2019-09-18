package com.ets.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "inventory_current_stock")
public class InventoryCurrentStock {

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
	
	private SimpleObjectProperty<InventoryDescription> inventory = new SimpleObjectProperty<InventoryDescription>(this, "inventory");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "inventory_id")
	public InventoryDescription getInventory() {
		return inventory.get();
	}

	public void setInventory(InventoryDescription inventory) {
		this.inventory.set(inventory);
	}

	public SimpleObjectProperty<InventoryDescription> inventoryProperty() {
		return inventory;
	}
	
	/*private ObjectProperty<Date> dateOfPurchase = new SimpleObjectProperty<Date>();

	@Column(name = "date_of_purchase")
	@Temporal(TemporalType.DATE)
	public Date getDateOfPurchase() {
		return dateOfPurchase.get();
	}

	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase.set(dateOfPurchase);
	}

	public ObjectProperty<Date> dateOfPurchaseProperty() {
		return this.dateOfPurchase;
	}*/
	
	/*private StringProperty pricePerUnit = new SimpleStringProperty(this, "pricePerUnit");

	@Column(name = "price_per_unit")
	public String getPricePerUnit() {
		return pricePerUnit.get();
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit.set(pricePerUnit);
	}

	public StringProperty pricePerUnitProperty() {
		return pricePerUnit;
	}*/
	
	private StringProperty quantityInStock = new SimpleStringProperty(this, "quantityInStock");

	@Column(name = "quantity_in_stock")
	public String getQuantityInStock() {
		return quantityInStock.get();
	}

	public void setQuantityInStock(String quantityInStock) {
		this.quantityInStock.set(quantityInStock);
	}

	public StringProperty quantityInStockProperty() {
		return quantityInStock;
	}
	
	/*private StringProperty unitDescrp = new SimpleStringProperty(this, "unitDescrp");

	@Column(name = "unit_descrp")
	public String getUnitDescrp() {
		return unitDescrp.get();
	}

	public void setUnitDescrp(String unitDescrp) {
		this.unitDescrp.set(unitDescrp);
	}

	public StringProperty unitDescrpProperty() {
		return unitDescrp;
	}*/
	
	public InventoryCurrentStock() {
		// TODO Auto-generated constructor stub
	}

}
