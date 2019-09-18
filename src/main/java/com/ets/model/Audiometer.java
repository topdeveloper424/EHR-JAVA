package com.ets.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "audiometer")
public class Audiometer {
	
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
	@JoinColumn(name = "equipmentModel_id")
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
	
	 private ObjectProperty<Date> acousticCalibDt = new SimpleObjectProperty<Date>();

	@Column(name = "acoustic_calib_dt")
	@Temporal(TemporalType.DATE)
	public Date getAcousticCalibDt() {
		return acousticCalibDt.get();
	}

	public void setAcousticCalibDt(Date acousticCalibDt) {
		this.acousticCalibDt.set(acousticCalibDt);
	}

	public ObjectProperty<Date> acousticCalibDtProperty() {
		return this.acousticCalibDt;
	}
	
	private ObjectProperty<Date> calibExpiryDt = new SimpleObjectProperty<Date>();

	@Column(name = "calib_expiry_dt")
	@Temporal(TemporalType.DATE)
	public Date getCalibExpiryDt() {
		return calibExpiryDt.get();
	}

	public void setCalibExpiryDt(Date calibExpiryDt) {
		this.calibExpiryDt.set(calibExpiryDt);
	}

	public ObjectProperty<Date> calibExpiryDtProperty() {
		return this.calibExpiryDt;
	}
	
	private ObjectProperty<Date> soundCheckDt = new SimpleObjectProperty<Date>();

	@Column(name = "sound_check_dt")
	@Temporal(TemporalType.DATE)
	public Date getSoundCheckDt() {
		return soundCheckDt.get();
	}

	public void setSoundCheckDt(Date soundCheckDt) {
		this.soundCheckDt.set(soundCheckDt);
	}

	public ObjectProperty<Date> soundCheckDtProperty() {
		return this.soundCheckDt;
	}
	
	private StringProperty checkedBy = new SimpleStringProperty(this, "checkedBy");

	@Column(name = "checked_by")

	public String getCheckedBy() {
		return checkedBy.get();
	}

	public void setCheckedBy(String checkedBy) {
		this.checkedBy.set(checkedBy);
	}

	public StringProperty checkedByProperty() {
		return checkedBy;
	}
	
	private StringProperty soundReading = new SimpleStringProperty(this, "soundReading");

	@Column(name = "sound_reading")

	public String getSoundReading() {
		return soundReading.get();
	}

	public void setSoundReading(String soundReading) {
		this.soundReading.set(soundReading);
	}

	public StringProperty soundReadingProperty() {
		return soundReading;
	}
	
	private  SimpleBooleanProperty inactive = new SimpleBooleanProperty(
			this, "inactive");

	@Column(name = "inactive")
	public  boolean getInactive() {
		return inactive.get();
	}

	public void setInactive(boolean inactive) {
		this.inactive.set(inactive);
	}

	public BooleanProperty inactiveProperty() {
		return inactive;
	}

	public Audiometer() {
		
	}

}
