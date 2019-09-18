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
@Table(name = "inventory_purchase")
public class InventoryPurchase {
	
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
	
	private StringProperty pricePerUnit = new SimpleStringProperty(this, "pricePerUnit");

	@Column(name = "price_per_unit")
	public String getPricePerUnit() {
		return pricePerUnit.get();
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit.set(pricePerUnit);
	}

	public StringProperty pricePerUnitProperty() {
		return pricePerUnit;
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
	
	private StringProperty lastPuschaseQuantity = new SimpleStringProperty(this, "lastPuschaseQuantity");

	@Column(name = "last_puschase_quantity")
	public String getLastPuschaseQuantity() {
		return lastPuschaseQuantity.get();
	}

	public void setLastPuschaseQuantity(String lastPuschaseQuantity) {
		this.lastPuschaseQuantity.set(lastPuschaseQuantity);
	}

	public StringProperty lastPuschaseQuantityProperty() {
		return lastPuschaseQuantity;
	}
	
	private ObjectProperty<Date> lastPurchaseDate = new SimpleObjectProperty<Date>();

	@Column(name = "last_purchase_date")
	@Temporal(TemporalType.DATE)
	public Date getLastPurchaseDate() {
		return lastPurchaseDate.get();
	}

	public void setLastPurchaseDate(Date lastPurchaseDate) {
		this.lastPurchaseDate.set(lastPurchaseDate);
	}

	public ObjectProperty<Date> lastPurchaseDateProperty() {
		return this.lastPurchaseDate;
	}

	public InventoryPurchase() {
		
	}

}
