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

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "vital_reader")
public class VitalReader {

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

	private StringProperty loc = new SimpleStringProperty(this, "loc");

	@Column(name = "loc")
	public String getLoc() {
		return loc.get();
	}

	public void setLoc(String loc) {
		this.loc.set(loc);
	}

	public StringProperty locProperty() {
		return loc;
	}

	private SimpleObjectProperty<EquipmentModel> equipmentModel = new SimpleObjectProperty<EquipmentModel>(this,
			"equipmentModel");

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

	private ObjectProperty<Date> transDt = new SimpleObjectProperty<Date>();

	@Column(name = "trans_dt")
	@Temporal(TemporalType.DATE)
	public Date getTransDt() {
		return transDt.get();
	}

	public void setTransDt(Date transDt) {
		this.transDt.set(transDt);
	}

	public ObjectProperty<Date> transDtProperty() {
		return this.transDt;
	}

	private StringProperty transTime = new SimpleStringProperty(this, "transTime");

	@Column(name = "trans_time")
	public String getTransTime() {
		return transTime.get();
	}

	public void setTransTime(String transTime) {
		this.transTime.set(transTime);
	}

	public StringProperty transTimeProperty() {
		return transTime;
	}

	private StringProperty calibBy = new SimpleStringProperty(this, "calibBy");

	@Column(name = "calib_by")
	public String getCalibBy() {
		return calibBy.get();
	}

	public void setCalibBy(String calibBy) {
		this.calibBy.set(calibBy);
	}

	public StringProperty calibByProperty() {
		return calibBy;
	}

	private SimpleBooleanProperty inactive = new SimpleBooleanProperty(this, "inactive");

	@Column(name = "inactive")
	public boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}

	public VitalReader() {

	}

}
