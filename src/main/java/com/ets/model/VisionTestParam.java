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

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
@Table(name = "vision_test_param")
public class VisionTestParam {
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
	
	private SimpleObjectProperty<MedicalActivity> medicalActivity = new SimpleObjectProperty<MedicalActivity>(this, "medicalActivity");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "asso_med_act_id")
	public MedicalActivity getMedicalActivity() {
		return medicalActivity.get();
	}

	public void setMedicalActivity(MedicalActivity medicalActivity) {
		this.medicalActivity.set(medicalActivity);
	}

	public SimpleObjectProperty<MedicalActivity> medicalActivityProperty() {
		return medicalActivity;
	}
	private SimpleObjectProperty<VisitCategory> visitCategory = new SimpleObjectProperty<VisitCategory>(this, "visitCategory");

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "asso_visit_cat_id")
	public VisitCategory getVisitCategory() {
		return visitCategory.get();
	}

	public void setVisitCategory(VisitCategory visitCategory) {
		this.visitCategory.set(visitCategory);
	}

	public SimpleObjectProperty<VisitCategory> visitCategory() {
		return visitCategory;
	}
	
	private StringProperty visualAcuityTestDist = new SimpleStringProperty(this, "visualAcuityTestDist");

	@Column(name = "visual_acuity_test_dist")
	public String getVisualAcuityTestDist() {
		return visualAcuityTestDist.get();
	}

	public void setVisualAcuityTestDist(String visualAcuityTestDist) {
		this.visualAcuityTestDist.set(visualAcuityTestDist);
	}

	public StringProperty visualAcuityTestDistProperty() {
		return visualAcuityTestDist;
	}

	private StringProperty colorBlindnessTestMode = new SimpleStringProperty(this, "colorBlindnessTestMode");

	@Column(name = "color_blindness_test_mode")
	public String getColorBlindnessTestMode() {
		return colorBlindnessTestMode.get();
	}

	public void setColorBlindnessTestMode(String colorBlindnessTestMode) {
		this.colorBlindnessTestMode.set(colorBlindnessTestMode);
	}

	public StringProperty colorBlindnessTestMode() {
		return colorBlindnessTestMode;
	}

    public VisionTestParam(){
    	
    }
	
}
