package com.ets.model;

import java.util.Date;

import javax.persistence.CascadeType;
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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name="emr_charting_text_area")
public class EmrChartingTextAreaSave {
	private IntegerProperty id = new SimpleIntegerProperty(this, "id");

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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
	
	
	private StringProperty textArea = new SimpleStringProperty(this, "textArea");

	@Column(name = "text_Area")
	public String getTextArea() {
		return textArea.get();
	}

	public void setTextArea(String textArea) {
		this.textArea.set(textArea);
	}
	

	public StringProperty textAreaProperty() {
		return textArea;
	}
	
	
	
	private StringProperty rosTextArea = new SimpleStringProperty(this, "rosTextArea");

	@Column(name = "ros_text_Area")
	public String getRosTextArea() {
		return rosTextArea.get();
	}

	public void setRosTextArea(String rosTextArea) {
		this.rosTextArea.set(rosTextArea);
	}
	

	public StringProperty rosTextAreaProperty() {
		return rosTextArea;
	}
	
	
	private StringProperty examTextArea = new SimpleStringProperty(this, "examTextArea");

	@Column(name = "exam_text_Area")
	public String getExamTextArea() {
		return examTextArea.get();
	}

	public void setExamTextArea(String examTextArea) {
		this.examTextArea.set(examTextArea);
	}
	

	public StringProperty examTextAreaProperty() {
		return examTextArea;
	}
	
	private StringProperty resultTextArea = new SimpleStringProperty(this, "resultTextArea");
	@Column(name = "result_text_area")
	public String getResultTextArea() {
		return resultTextArea.get();
	}

	public void setResultTextArea(String resultTextArea) {
		this.resultTextArea.set(resultTextArea);
	}
	

	public StringProperty resultTextAreaProperty() {
		return resultTextArea;
	}
	
	
	private StringProperty procedureTextArea = new SimpleStringProperty(this, "procedureTextArea");
	@Column(name = "procedure_text_area")
	public String getProcedureTextArea() {
		return procedureTextArea.get();
	}

	public void setProcedureTextArea(String procedureTextArea) {
		this.procedureTextArea.set(procedureTextArea);
	}
	

	public StringProperty procedureTextAreaProperty() {
		return procedureTextArea;
	}
	private StringProperty pmhTextArea = new SimpleStringProperty(this, "pmhTextArea");

	@Column(name = "pmh_text_area")
	public String getPmhTextArea() {
		return pmhTextArea.get();
	}

	public void setPmhTextArea(String pmhTextArea) {
		this.pmhTextArea.set(pmhTextArea);
	}
	

	public StringProperty pmhTextAreaProperty() {
		return pmhTextArea;
	}
	
	
	
	 private SimpleObjectProperty<PatientVisit>  patientVisit = new SimpleObjectProperty<PatientVisit>(this, "patientVisit");

	 @OneToOne(targetEntity=PatientVisit.class,fetch=FetchType.EAGER , cascade=CascadeType.ALL, orphanRemoval=true)
	 @JoinColumn(name="patient_visit_id")
	 public PatientVisit getPatientVisit() {
			return patientVisit.get();
		}

		public void setPatientVisit(PatientVisit patientVisit) {
			this.patientVisit.set(patientVisit);
		}

		public SimpleObjectProperty<PatientVisit> patientVisitProperty() {
			return patientVisit;
		}

		
		private StringProperty clinicianIn = new SimpleStringProperty(this, "clinicianIn");

		@Column(name = "clinicianIn")
		public String getClinicianIn() {
			return clinicianIn.get();
		}

		public void setClinicianIn(String clinicianIn) {
			this.clinicianIn.set(clinicianIn);
		}
		

		public StringProperty clinicianInProperty() {
			return clinicianIn;
		}
		
		
		private StringProperty clinicianOut = new SimpleStringProperty(this, "clinicianOut");

		@Column(name = "clinicianOut")
		public String getClinicianOut() {
			return clinicianOut.get();
		}

		public void setClinicianOut(String clinicianOut) {
			this.clinicianOut.set(clinicianOut);
		}
		

		public StringProperty clinicianOutProperty() {
			return clinicianOut;
		}
		private StringProperty providerIn = new SimpleStringProperty(this, "providerIn");

		@Column(name = "providerIn")
		public String getProviderIn() {
			return providerIn.get();
		}

		public void setProviderIn(String providerIn) {
			this.providerIn.set(providerIn);
		}
		

		public StringProperty providerInProperty() {
			return providerIn;
		}
		
		private StringProperty providerOut = new SimpleStringProperty(this, "providerOut");

		@Column(name = "providerOut")
		public String getProviderOut() {
			return providerOut.get();
		}

		public void setProviderOut(String providerOut) {
			this.providerOut.set(providerOut);
		}
		

		public StringProperty providerOutProperty() {
			return providerOut;
		}
		private StringProperty patientType = new SimpleStringProperty(this, "patientType");

		@Column(name = "patientType")
		public String getPatientType() {
			return patientType.get();
		}

		public void setPatientType(String patientType) {
			this.patientType.set(patientType);
		}
		

		public StringProperty patientTypeProperty() {
			return patientType;
		}
		private StringProperty levelOfVisit = new SimpleStringProperty(this, "levelOfVisit");

		@Column(name = "levelOfVisit")
		public String getLevelOfVisit() {
			return levelOfVisit.get();
		}

		public void setLevelOfVisit(String levelOfVisit) {
			this.levelOfVisit.set(levelOfVisit);
		}
		

		public StringProperty levelOfVisitProperty() {
			return levelOfVisit;
		}
		private StringProperty twoPatientIdentifiedVarify = new SimpleStringProperty(this, "twoPatientIdentifiedVarify");

		
	
		@Column(name = "twoPatientIdentifiedVarify")
		public String getTwoPatientIdentifiedVarify() {
			return twoPatientIdentifiedVarify.get();
		}

		public void setTwoPatientIdentifiedVarify(String twoPatientIdentifiedVarify) {
			this.twoPatientIdentifiedVarify.set(twoPatientIdentifiedVarify);
		}
		

		public StringProperty twoPatientIdentifiedVarifyProperty() {
			return twoPatientIdentifiedVarify;
		}
		
		/*private StringProperty dateOfInjury = new SimpleStringProperty(this, "dateOfInjury");

		@Column(name = "dateOfInjury")
		public String getDateOfInjury() {
			return dateOfInjury.get();
		}

		public void setDateOfInjury(String dateOfInjury) {
			this.dateOfInjury.set(dateOfInjury);
		}
		

		public StringProperty dateOfInjuryProperty() {
			return dateOfInjury;
		}
		*/
		private ObjectProperty<Date> dateOfInjury = new SimpleObjectProperty<Date>();

		@Column(name = "dateOfInjury")
		@Temporal(TemporalType.DATE)
		public Date getDateOfInjury() {
			return dateOfInjury.get();
		}

		public void setDateOfInjury(Date dateOfInjury) {
			this.dateOfInjury.set(dateOfInjury);
		}

		public ObjectProperty<Date> dateOfInjuryProperty() {
			return this.dateOfInjury;
		}
		
		private StringProperty workStatusChoice = new SimpleStringProperty(this, "workStatusChoice");

		@Column(name = "work_status_choice")
		public String getWorkStatusChoice() {
			return workStatusChoice.get();
		}

		public void setWorkStatusChoice(String workStatusChoice) {
			this.workStatusChoice.set(workStatusChoice);
		}
		

		public StringProperty workStatusChoiceProperty() {
			return workStatusChoice;
		}

		
		
		private ObjectProperty<Date> workStatusAsOf = new SimpleObjectProperty<Date>();

		@Column(name = "workStatusAsOf")
		@Temporal(TemporalType.DATE)
		public Date getWorkStatusAsOf() {
			return workStatusAsOf.get();
		}

		public void setWorkStatusAsOf(Date workStatusAsOf) {
			this.workStatusAsOf.set(workStatusAsOf);
		}

		public ObjectProperty<Date> workStatusAsOfProperty() {
			return this.workStatusAsOf;
		}
		
		private StringProperty instructionTextArea = new SimpleStringProperty(this, "instructionTextArea");

		@Column(name = "instruction_text_area")
		public String getInstructionTextArea() {
			return instructionTextArea.get();
		}

		public void setInstructionTextArea(String instructionTextArea) {
			this.instructionTextArea.set(instructionTextArea);
		}
		

		public StringProperty instructionTextAreaProperty() {
			return instructionTextArea;
		}
		private StringProperty workStatusTextArea = new SimpleStringProperty(this, "workStatusTextArea");

		@Column(name = "workStatus_text_area")
		public String getWorkStatusTextArea() {
			return workStatusTextArea.get();
		}

		public void setWorkStatusTextArea(String workStatusTextArea) {
			this.workStatusTextArea.set(workStatusTextArea);
		}
		

		public StringProperty workStatusTextAreaProperty() {
			return workStatusTextArea;
		}
		
		

		
		//*****************
		private ObjectProperty<Date> instructionNextVisitDate = new SimpleObjectProperty<Date>();

		@Column(name = "instruction_nextvisit_date")
		@Temporal(TemporalType.DATE)
		public Date getInstructionNextVisitDate() {
			return instructionNextVisitDate.get();
		}

		public void setInstructionNextVisitDate(Date instructionNextVisitDate) {
			this.instructionNextVisitDate.set(instructionNextVisitDate);
		}

		public ObjectProperty<Date> instructionNextVisitDateProperty() {
			return this.instructionNextVisitDate;
		}
		
		
		private StringProperty instructionNextVisitTime = new SimpleStringProperty(this, "instructionNextVisitTime");

		@Column(name = "instruction_nextvisit_time")
		public String getInstructionNextVisitTime() {
			return instructionNextVisitTime.get();
		}

		public void setInstructionNextVisitTime(String instructionNextVisitTime) {
			this.instructionNextVisitTime.set(instructionNextVisitTime);
		}
		

		public StringProperty instructionNextVisitTimeProperty() {
			return instructionNextVisitTime;
		}
		
		private StringProperty instructionPatientCondition = new SimpleStringProperty(this, "instructionPatientCondition");

		@Column(name = "instruction_patient_condition")
		public String getInstructionPatientCondition() {
			return instructionPatientCondition.get();
		}

		public void setInstructionPatientCondition(String instructionPatientCondition) {
			this.instructionPatientCondition.set(instructionPatientCondition);
		}
		

		public StringProperty instructionPatientConditionProperty() {
			return instructionNextVisitTime;
		}
		
		private StringProperty instructionAmbulatoryStatus = new SimpleStringProperty(this, "instructionAmbulatoryStatus");

		@Column(name = "instruction_ambulatory_status")
		public String getInstructionAmbulatoryStatus() {
			return instructionAmbulatoryStatus.get();
		}

		public void setInstructionAmbulatoryStatus(String instructionAmbulatoryStatus) {
			this.instructionAmbulatoryStatus.set(instructionAmbulatoryStatus);
		}
		

		public StringProperty instructionAmbulatoryStatusProperty() {
			return instructionAmbulatoryStatus;
		}
		
		
		private StringProperty instructionDischargeDestination = new SimpleStringProperty(this, "instructionDischargeDestination");

		@Column(name = "instruction_discharge_destination")
		public String getInstructionDischargeDestination() {
			return instructionDischargeDestination.get();
		}

		public void setInstructionDischargeDestination(String instructionDischargeDestination) {
			this.instructionDischargeDestination.set(instructionDischargeDestination);
		}
		

		public StringProperty instructionDischargeDestinationProperty() {
			return instructionDischargeDestination;
		}
		
		

		private StringProperty patientVisitComplaint = new SimpleStringProperty(this, "patientVisitComplaint");

		@Column(name = "patientVisitComplaint")
		public String getPatientVisitComplaint() {
			return patientVisitComplaint.get();
		}

		public void setPatientVisitComplaint(String patientVisitComplaint) {
			this.patientVisitComplaint.set(patientVisitComplaint);
		}
		

		public StringProperty patientVisitComplaintProperty() {
			return patientVisitComplaint;
		}
		private StringProperty orderTextArea = new SimpleStringProperty(this, "orderTextArea");

		@Column(name = "orderTextArea")
		public String getOrderTextArea() {
			return orderTextArea.get();
		}

		public void setOrderTextArea(String orderTextArea) {
			this.orderTextArea.set(orderTextArea);
		}
		

		public StringProperty orderTextAreaProperty() {
			return orderTextArea;
		}
		
		private StringProperty assessmentTextArea = new SimpleStringProperty(this, "assessmentTextArea");

		@Column(name = "assessment_text_area")
		public String getAssessmentTextArea() {
			return assessmentTextArea.get();
		}

		public void setAssessmentTextArea(String assessmentTextArea) {
			this.assessmentTextArea.set(assessmentTextArea);
		}
		

		public StringProperty assessmentTextAreaProperty() {
			return assessmentTextArea;
		}
		
	public EmrChartingTextAreaSave() {
		
	}

}
