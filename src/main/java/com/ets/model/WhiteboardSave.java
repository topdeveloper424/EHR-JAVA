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
@Table(name = "white_board_save")
public class WhiteboardSave {
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

	
	
	private StringProperty status = new SimpleStringProperty(this, "status");

	@Column(name = "status1")

	public String getStatus() {
		return status.get();
	}

	public void setStatus(String status) {
		this.status.set(status);
	}

	public StringProperty statusProperty() {
		return status;
	}
	

	private StringProperty procedure = new SimpleStringProperty(this, "procedure");

	@Column(name = "procedure1")

	public String getProcedure() {
		return procedure.get();
	}

	public void setProcedure(String procedure) {
		this.procedure.set(procedure);
	}

	public StringProperty procedureProperty() {
		return procedure;
	}
	


	private  SimpleBooleanProperty waitingRoom = new SimpleBooleanProperty(this, "waitingRoom");

	@Column(name = "waitingRoom")
	public  boolean getWaitingRoom() {
		return waitingRoom.get();
	}

	public  void setWaitingRoom(boolean waitingRoom) {
		this.waitingRoom.set(waitingRoom);
	}

	public BooleanProperty waitingRoomProperty() {
		return waitingRoom;
	}
	
	private  SimpleBooleanProperty lab = new SimpleBooleanProperty(this, "lab");

	@Column(name = "lab")
	public  boolean getLab() {
		return lab.get();
	}

	public  void setLab(boolean lab) {
		this.lab.set(lab);
	}

	public BooleanProperty labProperty() {
		return lab;
	}
	private  SimpleBooleanProperty xRay = new SimpleBooleanProperty(this, "xRay");

	@Column(name = "xRay")
	public  boolean getXRay() {
		return xRay.get();
	}

	public  void setXRay(boolean xRay) {
		this.xRay.set(xRay);
	}

	public BooleanProperty xRayProperty() {
		return xRay;
	}
	private  SimpleBooleanProperty checkOut = new SimpleBooleanProperty(this, "checkOut");

	@Column(name = "checkout")
	public  boolean getCheckOut() {
		return checkOut.get();
	}

	public  void setCheckOut(boolean checkOut) {
		this.checkOut.set(checkOut);
	}

	public BooleanProperty checkOutProperty() {
		return checkOut;
	}
	
	
	private  SimpleBooleanProperty examRoom1 = new SimpleBooleanProperty(this, "examRoom1");

	@Column(name = "exam_room1")
	public  boolean getExamRoom1() {
		return examRoom1.get();
	}

	public  void setExamRoom1(boolean examRoom1) {
		this.examRoom1.set(examRoom1);
	}

	public BooleanProperty examRoom1Property() {
		return examRoom1;
	}
	private  SimpleBooleanProperty examRoom2 = new SimpleBooleanProperty(this, "examRoom2");

	@Column(name = "exam_room2")
	public  boolean getExamRoom2() {
		return examRoom2.get();
	}

	public  void setExamRoom2(boolean examRoom2) {
		this.examRoom2.set(examRoom2);
	}

	public BooleanProperty examRoom2Property() {
		return examRoom2;
	}
	
	
	private  SimpleBooleanProperty examRoom7 = new SimpleBooleanProperty(this, "examRoom7");

	@Column(name = "exam_room7")
	public  boolean getExamRoom7() {
		return examRoom7.get();
	}

	public  void setExamRoom7(boolean examRoom7) {
		this.examRoom7.set(examRoom7);
	}

	public BooleanProperty examRoom7() {
		return examRoom7;
	}
	
	
	private  SimpleBooleanProperty eyeRoom = new SimpleBooleanProperty(this, "eyeRoom");

	@Column(name = "eye_room")
	public  boolean getEyeRoom() {
		return eyeRoom.get();
	}

	public  void setEyeRoom(boolean eyeRoom) {
		this.eyeRoom.set(eyeRoom);
	}

	public BooleanProperty eyeRoom() {
		return eyeRoom;
	}
	
	
	private  SimpleBooleanProperty hcg = new SimpleBooleanProperty(this, "hcg");

	@Column(name = "hcg")
	public  boolean getHcg() {
		return hcg.get();
	}

	public  void setHcg(boolean hcg) {
		this.hcg.set(hcg);
	}

	public BooleanProperty hcg() {
		return hcg;
	}
	
	
	private  SimpleBooleanProperty physicalRoom = new SimpleBooleanProperty(this, "physicalRoom");

	@Column(name = "physical_room")
	public  boolean getPhysicalRoom() {
		return physicalRoom.get();
	}

	public  void setPhysicalRoom(boolean physicalRoom) {
		this.physicalRoom.set(physicalRoom);
	}

	public BooleanProperty physicalRoom() {
		return physicalRoom;
	}
	
	private  SimpleBooleanProperty lacerationRoom = new SimpleBooleanProperty(this, "lacerationRoom");

	@Column(name = "laceration_room")
	public  boolean getlacerationRoom() {
		return lacerationRoom.get();
	}

	public  void setLacerationRoom(boolean lacerationRoom) {
		this.lacerationRoom.set(lacerationRoom);
	}

	public BooleanProperty lacerationRoom() {
		return lacerationRoom;
	}

	
	private SimpleObjectProperty<PatientVisit> patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "patientvisit_id")
	public PatientVisit getPatientVisit() {
		return patientVisit.get();
	}

	public void setPatientVisit(PatientVisit patientVisit) {
		this.patientVisit.set(patientVisit);
	}

	public SimpleObjectProperty<PatientVisit> patientVisitProperty() {
		return patientVisit;
	}

	
	public WhiteboardSave() {
		super();
		
	}
	
	
}
