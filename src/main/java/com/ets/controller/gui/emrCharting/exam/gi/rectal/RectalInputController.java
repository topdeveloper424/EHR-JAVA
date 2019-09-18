package com.ets.controller.gui.emrCharting.exam.gi.rectal;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RectalInputController Class
 *Description: rectal.fxml Controller class
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
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.gi.ExamGIinputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class RectalInputController implements Initializable {

	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox normalCkeckBox;

	    @FXML
	    private CheckBox normalToneCheckBox;

	    @FXML
	    private CheckBox decreasedCheckBox;

	    @FXML
	    private CheckBox noMassesCheckBox;

	    @FXML
	    private CheckBox massCheckBox;

	    @FXML
	    private CheckBox noHemorroidsCheckBox;

	    @FXML
	    private CheckBox nonTenderCheckBox;

	    @FXML
	    private CheckBox hemeNegativeStoolCheckBox;

	    @FXML
	    private CheckBox exhibitedCheckBox;

	    @FXML
	    private CheckBox noHemorroidsPresentCheckBox;

	    @FXML
	    private CheckBox tendernessCheckBox;

	    @FXML
	    private CheckBox hemePossitiveStoolCheckBox;

	    @FXML
	    private CheckBox impactedCheckBox;

	    @FXML
	    private CheckBox negativeOccultCheckBox;

	    @FXML
	    private CheckBox frankBloodCheckBox;

	    @FXML
	    private CheckBox melanoticCheckBox;

	    @FXML
	    private CheckBox possitiveOccultCheckBox;

	    @FXML
	    private CheckBox grossBloodCheckBox;

	    @FXML
	    private CheckBox includeCheckBox;
	    
   


	private ExamGIinputController examGIinputController;
	
	public void setExamGIinputController(ExamGIinputController examGIinputController) {
		this.examGIinputController = examGIinputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder rectal = new StringBuilder(examGIinputController.str);
			rectal.append("\n\nGI & ABDOMEN: ");
			examGIinputController.str = rectal.toString();
			
			 if (normalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Examination of anus and rectum reveals normal tone with no masses present. ");
				examGIinputController.str = str1.toString();
				
			}if(normalToneCheckBox.isSelected() || noHemorroidsCheckBox.isSelected() || hemeNegativeStoolCheckBox.isSelected() || noMassesCheckBox.isSelected() || 
					noHemorroidsPresentCheckBox.isSelected() || hemePossitiveStoolCheckBox.isSelected() || decreasedCheckBox.isSelected() || nonTenderCheckBox.isSelected() ||
					exhibitedCheckBox.isSelected() || massCheckBox.isSelected() || tendernessCheckBox.isSelected() || impactedCheckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Rectal exam reveals ");
				examGIinputController.str = str1.toString();
				
			} if (normalToneCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("normal tone, ");
				examGIinputController.str = str1.toString();
				
			} if (noHemorroidsCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("no hemorrhoids noted, ");
				examGIinputController.str = str1.toString();
				
			} if (hemeNegativeStoolCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("heme negative stool, ");
				examGIinputController.str = str1.toString();
				
			} if (noMassesCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("no masses,");
				examGIinputController.str = str1.toString();
				
			} if (noHemorroidsPresentCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("hemorrhoids present, ");
				examGIinputController.str = str1.toString();
				
			} if (hemePossitiveStoolCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("heme positive stool, ");
				examGIinputController.str = str1.toString();
				
			} if (decreasedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("decreased tone, ");
				examGIinputController.str = str1.toString();
				
			} if (nonTenderCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("non tender near appendix, ");
				examGIinputController.str = str1.toString();
				
			} if (exhibitedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("exhibited frank blood, ");
				examGIinputController.str = str1.toString();
				
			} if (massCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("mass palpable, ");
				examGIinputController.str = str1.toString();
				
			} if (tendernessCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("tenderness near appendix, ");
				examGIinputController.str = str1.toString();
				
			} if (impactedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("impacted stool. ");
				examGIinputController.str = str1.toString();
				
			} if (negativeOccultCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Negative for occult blood. ");
				examGIinputController.str = str1.toString();
				
			} if (melanoticCheckBox.isSelected()) {
			
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Melanotic stool. ");
				examGIinputController.str = str1.toString();
				
			} if (possitiveOccultCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Positive for occult blood. ");
				examGIinputController.str = str1.toString();
				
			} if (frankBloodCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Frank blood present.");
				examGIinputController.str = str1.toString();
				
			} if (grossBloodCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Gross blood present. ");
				examGIinputController.str = str1.toString();
				
			}if (includeCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Patient declined rectal examination. ");
				examGIinputController.str = str1.toString();
				
			} 
			

			
			++examGIinputController.formCount;	
			examGIinputController.setGIUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examGIinputController.formCount;	
				examGIinputController.setGIUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
}



