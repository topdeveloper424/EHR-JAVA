package com.ets.controller.gui.emrCharting.hpi.problems;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 11-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPIProblemsInputController Class
 *Description: Problems.fxml GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.emrHpi.EmrHpiEntityController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.model.EmrHpi;
import com.ets.service.emrHpi.EmrHpiServiceImpl;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;

public class HPIProblemsInputController implements Initializable {
	  @FXML
	    private CheckBox followUpCheckBox;

	    @FXML
	    private CheckBox uncertainProblemCheckBox;

	    @FXML
	    private CheckBox animalBiteCheckBox;

	    @FXML
	    private CheckBox beeOrInsectCheckBox;

	    @FXML
	    private CheckBox burnCheckBox;

	    @FXML
	    private CheckBox concussionCheckBox;

	    @FXML
	    private CheckBox contusaionCheckBox;

	    @FXML
	    private CheckBox headInjuryCheckBox;

	    @FXML
	    private CheckBox eyeProblemCheckBox;

	    @FXML
	    private CheckBox injuryCheckBox;

	    @FXML
	    private CheckBox foreignBodyCheckBox;

	    @FXML
	    private CheckBox fractureCheckBox;

	    @FXML
	    private CheckBox dermatitis;

	    @FXML
	    private CheckBox abdominalPainCheckBox;

	    @FXML
	    private CheckBox coldCheckBox;

	    @FXML
	    private CheckBox chestPainCheckBox;

	    @FXML
	    private CheckBox AnxityCheckBox;

	    @FXML
	    private CheckBox upperExtrimityInjuryCheckBox;

	    @FXML
	    private CheckBox sprainOrStrainCheckBox;

	    @FXML
	    private CheckBox NeckOrUpperBackProblemCheckBox;

	    @FXML
	    private CheckBox multipleBodyPartInjuryCheckBox;

	    @FXML
	    private CheckBox lowerExtremityInjuryCheckBox;

	    @FXML
	    private CheckBox lowBackProblemCheckBox;

	    @FXML
	    private CheckBox lacerationCheckBox;

	    @FXML
	    private CheckBox earacheCheckBox;

	    @FXML
	    private CheckBox gastrointestinalCheckBox;

	    @FXML
	    private CheckBox diabetesCheckBox;

	    @FXML
	    private CheckBox fluCheckBox;

	    @FXML
	    private CheckBox headacheCheckBox;

	    @FXML
	    private CheckBox hypertensionCheckBox;

	    @FXML
	    private CheckBox sinusProblemCheckBox;

	    @FXML
	    private CheckBox soreThroatCheckBox;

	    @FXML
	    private CheckBox upperRespiratoryCheckBox;

	    @FXML
	    private CheckBox urinaryTractCheckBox;

	    @FXML
	    private CheckBox otherProblemCheckBox;

	    @FXML
	    private CheckBox workInjuryCheckBox;

	    @FXML
	    private CheckBox personalInjuryCheckBox;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;
	    private Button button;
        private GenericEMRChartingController genericEMRChartingController;
	    
	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
		}
	    
	    

		@Override
	public void initialize(URL location, ResourceBundle resources) {
					
	    	doneBtn.setOnAction((event) -> {
				try {
					
					//List<EmrHpi> emrHpiList = new ArrayList<EmrHpi>();
					
					genericEMRChartingController.setHpiTextArea("\nPROBLEM: ");
					if(followUpCheckBox.isSelected()){
						
						//EmrHpi emrHpi1=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Follow Up");	
						/*emrHpi1.setSummary("follow Up");
						emrHpi1.setCharacteristics("Presenting problem");
						emrHpi1.setDate(new Date());
						emrHpi1.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi1);*/
						
					}
					if(uncertainProblemCheckBox.isSelected()){
						
						//EmrHpi emrHpi2=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Uncertain Problem");	
						/*emrHpi2.setSummary("uncertain Problem");
						emrHpi2.setCharacteristics("Presenting problem");
						emrHpi2.setDate(new Date());
						emrHpi2.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi2);*/
						
						
						
					}
					if(animalBiteCheckBox.isSelected()){
						
						//EmrHpi emrHpi3=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Animal Bite");	
						/*emrHpi3.setSummary("Animal Bite");
						emrHpi3.setCharacteristics("Presenting problem");
						emrHpi3.setDate(new Date());
						emrHpi3.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi3);*/
						
						
					}
					if(beeOrInsectCheckBox.isSelected()){
						
						//EmrHpi emrHpi4=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Bee Or Insect");	
						
						/*emrHpi4.setSummary("Bee Or Insect");
						emrHpi4.setCharacteristics("Presenting problem");
						emrHpi4.setDate(new Date());
						emrHpi4.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi4);*/
						
						
					}
					if(burnCheckBox.isSelected()){
						
						//EmrHpi emrHpi5=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Burn");	
						/*emrHpi5.setSummary("Burn");
						emrHpi5.setCharacteristics("Presenting problem");
						emrHpi5.setDate(new Date());
						emrHpi5.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi5);*/
						
					}
					if(concussionCheckBox.isSelected()){
						
						//EmrHpi emrHpi6=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("concussion");	
						
						/*emrHpi6.setSummary("concussion");
						emrHpi6.setCharacteristics("Presenting problem");
						emrHpi6.setDate(new Date());
						emrHpi6.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi6);*/
						
						
					}
					if(contusaionCheckBox.isSelected()){
						
						//EmrHpi emrHpi7=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("contusaion");	
					
						/*emrHpi7.setSummary("contusaion");
						emrHpi7.setCharacteristics("Presenting problem");
						emrHpi7.setDate(new Date());
						emrHpi7.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi7);*/
						
						
					}
					if(headInjuryCheckBox.isSelected()){
						
						//EmrHpi emrHpi8=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Head Injury");	
						/*emrHpi8.setSummary("Head Injury");
						emrHpi8.setCharacteristics("Presenting problem");
						emrHpi8.setDate(new Date());
						emrHpi8.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi8);*/
						
					
						
					}
					if(eyeProblemCheckBox.isSelected()){
						
						//EmrHpi emrHpi9=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Eye Problem");	
						/*emrHpi9.setSummary("Eye Problem");
						emrHpi9.setCharacteristics("Presenting problem");
						emrHpi9.setDate(new Date());
						emrHpi9.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi9);*/
						
						
					}
					if(injuryCheckBox.isSelected()){
						
						//EmrHpi emrHpi10=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Injury");	
						/*emrHpi10.setSummary("Injury");
						emrHpi10.setCharacteristics("Presenting problem");
						emrHpi10.setDate(new Date());
						emrHpi10.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi10);*/
						
						
					}
					if(foreignBodyCheckBox.isSelected()){
						
						//EmrHpi emrHpi11=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Foreign Body");	
						/*emrHpi11.setSummary("Foreign Body");
						emrHpi11.setCharacteristics("Presenting problem");
						emrHpi11.setDate(new Date());
						emrHpi11.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi11);*/
						
						
					}if(fractureCheckBox.isSelected()){
						
						//EmrHpi emrHpi12=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Fracture");	
						/*emrHpi12.setSummary("Fracture");
						emrHpi12.setCharacteristics("Presenting problem");
						emrHpi12.setDate(new Date());
						emrHpi12.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi12);*/
						
						
					}
					if(dermatitis.isSelected()){
						
						//EmrHpi emrHpi13=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Dermatitis");	
						/*emrHpi13.setSummary("Dermatitis");
						emrHpi13.setCharacteristics("Presenting problem");
						emrHpi13.setDate(new Date());
						emrHpi13.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi13);*/
						
						
					}
					if(abdominalPainCheckBox.isSelected()){
						
						//EmrHpi emrHpi14=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Abdominal Pain");	
						/*emrHpi14.setSummary("Abdominal Pain");
						emrHpi14.setCharacteristics("Presenting problem");
						emrHpi14.setDate(new Date());
						emrHpi14.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi14);*/
						
					}
					if(coldCheckBox.isSelected()){
						
						//EmrHpi emrHpi15=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Cold");	
						/*emrHpi15.setSummary("Head Injury");
						emrHpi15.setCharacteristics("Presenting problem");
						emrHpi15.setDate(new Date());
						emrHpi15.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi15);*/
						
					}
					if(chestPainCheckBox.isSelected()){
						
						//EmrHpi emrHpi16=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Chest Pain");	
						/*emrHpi16.setSummary("Chest Pain");
						emrHpi16.setCharacteristics("Presenting problem");
						emrHpi16.setDate(new Date());
						emrHpi16.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi16);*/
						
					}
					if(AnxityCheckBox.isSelected()){
						
						//EmrHpi emrHpi17=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Anxity");	
						/*emrHpi17.setSummary("Anxity");
						emrHpi17.setCharacteristics("Presenting problem");
						emrHpi17.setDate(new Date());
						emrHpi17.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi17);*/
						
					}
					
					if(upperExtrimityInjuryCheckBox.isSelected()){
						
						//EmrHpi emrHpi18=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Upper Extrimity Injury");	
						/*emrHpi18.setSummary("Upper Extrimity Injury");
						emrHpi18.setCharacteristics("Presenting problem");
						emrHpi18.setDate(new Date());
						emrHpi18.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi18);*/
						
					}
					if(sprainOrStrainCheckBox.isSelected()){
						
						EmrHpi emrHpi19=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Sprain Or Strain");	
						/*emrHpi19.setSummary("Sprain Or Strain");
						emrHpi19.setCharacteristics("Presenting problem");
						emrHpi19.setDate(new Date());
						emrHpi19.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi19);*/
						
					}
					if(NeckOrUpperBackProblemCheckBox.isSelected()){
						
						//EmrHpi emrHpi20=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Neck Or UpperBack Problem");	
						/*emrHpi20.setSummary("Neck Or UpperBack Problem");
						emrHpi20.setCharacteristics("Presenting problem");
						emrHpi20.setDate(new Date());
						emrHpi20.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi20);*/
						
					}
					if(multipleBodyPartInjuryCheckBox.isSelected()){
						
						//EmrHpi emrHpi21=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Multiple BodyPart Injury");	
						/*emrHpi21.setSummary("Multiple BodyPart Injury");
						emrHpi21.setCharacteristics("Presenting problem");
						emrHpi21.setDate(new Date());
						emrHpi21.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi21);*/
						
					}
					if(lowerExtremityInjuryCheckBox.isSelected()){
						
						//EmrHpi emrHpi22=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Lower Extremity Injury");	
						/*emrHpi22.setSummary("Lower Extremity Injury");
						emrHpi22.setCharacteristics("Presenting problem");
						emrHpi22.setDate(new Date());
						emrHpi22.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi22);*/
						
					}
					if(lowBackProblemCheckBox.isSelected()){
						
						//EmrHpi emrHpi23=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("LowBack Problem");	
						/*emrHpi23.setSummary("LowBack Problem");
						emrHpi23.setCharacteristics("Presenting problem");
						emrHpi23.setDate(new Date());
						emrHpi23.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi23);*/
						
					}
					if(lacerationCheckBox.isSelected()){
						
						//EmrHpi emrHpi24=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Laceration");	
						/*emrHpi24.setSummary("Laceration");
						emrHpi24.setCharacteristics("Presenting problem");
						emrHpi24.setDate(new Date());
						emrHpi24.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi24);*/
						
					}
					if(earacheCheckBox.isSelected()){
						
						//EmrHpi emrHpi25=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("earache");	
						/*emrHpi25.setSummary("earache");
						emrHpi25.setCharacteristics("Presenting problem");
						emrHpi25.setDate(new Date());
						emrHpi25.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi25);*/
						
					}
					if(gastrointestinalCheckBox.isSelected()){
						
						//EmrHpi emrHpi26=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("gastrointestinal");	
						/*emrHpi26.setSummary("gastrointestinal");
						emrHpi26.setCharacteristics("Presenting problem");
						emrHpi26.setDate(new Date());
						emrHpi26.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi26);*/
						
					}
					if(diabetesCheckBox.isSelected()){
						
						//EmrHpi emrHpi27=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("diabetes");	
						/*emrHpi27.setSummary("diabetes");
						emrHpi27.setCharacteristics("Presenting problem");
						emrHpi27.setDate(new Date());
						emrHpi27.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi27);*/
						
					}
					if(fluCheckBox.isSelected()){
						
						//EmrHpi emrHpi28=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("flu");	
						/*emrHpi28.setSummary("flu");
						emrHpi28.setCharacteristics("Presenting problem");
						emrHpi28.setDate(new Date());
						emrHpi28.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi28);*/
						
					}
					if(headacheCheckBox.isSelected()){
						
						//EmrHpi emrHpi29=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("headache");	
						/*emrHpi29.setSummary("headache");
						emrHpi29.setCharacteristics("Presenting problem");
						emrHpi29.setDate(new Date());
						emrHpi29.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi29);*/
						
					}
					if(hypertensionCheckBox.isSelected()){
						
						//EmrHpi emrHpi30=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("hypertension");	
						/*emrHpi30.setSummary("hypertension");
						emrHpi30.setCharacteristics("Presenting problem");
						emrHpi30.setDate(new Date());
						emrHpi30.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi30);*/
						
					}
					if(sinusProblemCheckBox.isSelected()){
						
						//EmrHpi emrHpi31=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Sinus Problem");	
						/*emrHpi31.setSummary("Sinus Problem");
						emrHpi31.setCharacteristics("Presenting problem");
						emrHpi31.setDate(new Date());
						emrHpi31.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi31);*/
						
					}
					if(soreThroatCheckBox.isSelected()){
						
						//EmrHpi emrHpi32=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("Sore Throat");	
						/*emrHpi32.setSummary("Sore Throat");
						emrHpi32.setCharacteristics("Presenting problem");
						emrHpi32.setDate(new Date());
						emrHpi32.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi32);*/
						
					}
					if(upperRespiratoryCheckBox.isSelected()){
						
						//EmrHpi emrHpi33=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("upper Respiratory");	
						/*emrHpi33.setSummary("upper Respiratory");
						emrHpi33.setCharacteristics("Presenting problem");
						emrHpi33.setDate(new Date());
						emrHpi33.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi33);*/
						
					}
					if(urinaryTractCheckBox.isSelected()){
						
						//EmrHpi emrHpi34=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("urinary Tract");	
						/*emrHpi34.setSummary("urinary Tract");
						emrHpi34.setCharacteristics("Presenting problem");
						emrHpi34.setDate(new Date());
						emrHpi34.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi34);*/
						
					}
					
					if(otherProblemCheckBox.isSelected()){
						
						//EmrHpi emrHpi35=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("otherProblem");	
						/*emrHpi35.setSummary("otherProblem");
						emrHpi35.setCharacteristics("Presenting problem");
						emrHpi35.setDate(new Date());
						emrHpi35.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi35);*/
						
					}
					if(workInjuryCheckBox.isSelected()){
						
						//EmrHpi emrHpi36=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("work Injury");	
						/*emrHpi36.setSummary("work Injury");
						emrHpi36.setCharacteristics("Presenting problem");
						emrHpi36.setDate(new Date());
						emrHpi36.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi36);*/
						
					}
					if(personalInjuryCheckBox.isSelected()){
						
						//EmrHpi emrHpi37=new EmrHpi();
						genericEMRChartingController.setHpiTextArea("personal Injury");	
						/*emrHpi37.setSummary("personal Injury");
						emrHpi37.setCharacteristics("Presenting problem");
						emrHpi37.setDate(new Date());
						emrHpi37.setPatient(Global.patient);
						
						emrHpiList.add(emrHpi37);*/
						
					}
					
					
					//new  EmrHpiEntityController().saveOrUpdate(emrHpiList);
					
					
					genericEMRChartingController.saveAllTextArea();
					button.setTextFill(Color.GREEN);
					new FXFormCommonUtilities().closeForm(doneBtn);
					
				}catch(Exception e){
					e.printStackTrace();
				}
	    	
	    });
	    	
	    	skipBtn.setOnAction((event) -> {
				try {
					
					new FXFormCommonUtilities().closeForm( skipBtn);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
	    
	}

	
}
