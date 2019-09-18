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
@Table(name = "equipment_model")

public class EquipmentModel {
	
	
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
	
	private  StringProperty modelNo = new SimpleStringProperty(this,
			"modelNo");

	@Column(name = "model_no")
	public  String getModelNo() {
		return modelNo.get();
	}

	public  void setModelNo(String modelNo) {
		this.modelNo.set(modelNo);
	}

	public StringProperty modelNoProperty() {
		return modelNo;
	}

	
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
	
	private  SimpleBooleanProperty canTransferdata = new SimpleBooleanProperty(
			this, "canTransferdata");

	@Column(name = "can_transfer_data")
	public  boolean getCanTransferdata() {
		return canTransferdata.get();
	}

	public  void setCanTransferdata(boolean canTransferdata) {
		this.canTransferdata.set(canTransferdata);
	}

	public BooleanProperty canTransferdataProperty() {
		return canTransferdata;
	}
	
	
	
	private  SimpleBooleanProperty canImportData = new SimpleBooleanProperty(
			this, "canImportData");

	@Column(name = "can_import_data")
	public  boolean getCanImportData() {
		return canImportData.get();
	}

	public  void setCanImportData(boolean canImportData) {
		this.canImportData.set(canImportData);
	}

	public BooleanProperty canImportDataProperty() {
		return canImportData;
	}
	
	
	
	private  SimpleBooleanProperty supportUsbConn = new SimpleBooleanProperty(
			this, "supportUsbConn");

	@Column(name = "support_usb_conn")
	public  boolean getSupportUsbConn() {
		return supportUsbConn.get();
	}

	public  void setSupportUsbConn(boolean supportUsbConn) {
		this.supportUsbConn.set(supportUsbConn);
	}

	public BooleanProperty supportUsbConnProperty() {
		return supportUsbConn;
	}
	
	
	private  StringProperty baudRate = new SimpleStringProperty(this,
			"baudRate");

	@Column(name = "baud_rate")
	public  String getBaudRate() {
		return baudRate.get();
	}

	public  void setBaudRate(String baudRate) {
		this.baudRate.set(baudRate);
	}

	public StringProperty baudRateProperty() {
		return baudRate;
	}
	
	
	private  StringProperty parity = new SimpleStringProperty(this,
			"parity");

	@Column(name = "parity")
	public  String getparity() {
		return parity.get();
	}

	public  void setParity(String parity) {
		this.parity.set(parity);
	}

	public StringProperty parityProperty() {
		return parity;
	}
	
	
	private  StringProperty dataBit = new SimpleStringProperty(this,
			"dataBit");

	@Column(name = "data_bit")
	public  String getDataBit() {
		return dataBit.get();
	}

	public  void setDataBit(String dataBit) {
		this.dataBit.set(dataBit);
	}

	public StringProperty dataBitProperty() {
		return dataBit;
	}
	
	
	private  StringProperty stopBit = new SimpleStringProperty(this,
			"stopBit");

	@Column(name = "stop_bit")
	public  String getStopBit() {
		return stopBit.get();
	}

	public  void setStopBit(String stopBit) {
		this.stopBit.set(stopBit);
	}

	public StringProperty stopBitProperty() {
		return stopBit;
	}

	public EquipmentModel() {
		
	}

}
