package com.ets.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "vision_tester")

public class VisionTester {
	
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

	private SimpleObjectProperty<Clinic> clinic = new SimpleObjectProperty<Clinic>(this, "clinic");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "clinic_id")
	public Clinic getClinic() {
		return clinic.get();
	}

	public void setClinic(Clinic clinic) {
		this.clinic.set(clinic);
	}

	public SimpleObjectProperty<Clinic> clinicProperty() {
		return clinic;
	}
	private StringProperty locOrDescrp = new SimpleStringProperty(this, "locOrDescrp");

	@Column(name = "loc_or_descrp")
	public String getLocOrDescrp() {
		return locOrDescrp.get();
	}

	public void setLocOrDescrp(String locOrDescrp) {
		this.locOrDescrp.set(locOrDescrp);
	}

	public StringProperty locOrDescrpProperty() {
		return locOrDescrp;
	}
	
	private SimpleObjectProperty<EquipmentModel> equipmentModel = new SimpleObjectProperty<EquipmentModel>(this, "equipmentModel");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "equipment_model_id")
	public EquipmentModel getEquipmentModel() {
		return equipmentModel.get();
	}

	public void setEquipmentModel(EquipmentModel equipmentModel) {
		this.equipmentModel.set(equipmentModel);
	}

	public SimpleObjectProperty<EquipmentModel> equipmentModelProperty() {
		return equipmentModel;
	}
	private StringProperty serialNo = new SimpleStringProperty(this, "serialNo");

	@Column(name = "serial_no")
	public String getSerialNo() {
		return serialNo.get();
	}

	public void setSerialNo(String serialNo) {
		this.serialNo.set(serialNo);
	}

	public StringProperty serialNoProperty() {
		return serialNo;
	}
	
	private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactive() {
		return inactive;
	}
	
	public VisionTester(){
		
	}
   
}
