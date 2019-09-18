package com.ets.controller.gui.emrCharting.exam.resp;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 30-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespAssesmentEffortInputController Class
 *Description: respAssesmentEffort.fxml GUI Controller class
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

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class RespAssesmentEffortInputController implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton decreasedRadio;

	    @FXML
	    private RadioButton asymmetricRadio;

	    @FXML
	    private CheckBox provocativeNormal;

	    @FXML
	    private CheckBox RetractionsNotNotedCheck;

	    @FXML
	    private CheckBox RetractionsSupraclavicularCheck;

	    @FXML
	    private CheckBox RetractionsIntercostalsCheck;

	    @FXML
	    private RadioButton normalRadio;

	    @FXML
	    private ToggleGroup air;
	    
	    
	    private ExamRespInputController examRespInputController;

	    public void setExamRespInputController(ExamRespInputController examRespInputController) {
			this.examRespInputController = examRespInputController;
		}
	    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examRespInputController.str);
			examComp.append("\n\n: ");
			examRespInputController.str = examComp.toString();


			if (provocativeNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" Examinations of the chest show respiratory excursions normal, and no retractions.");
				examRespInputController.str = str1.toString();

			} else {

				if (decreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("Examinations of the chest show respiratory excursions to be decreased.");
					examRespInputController.str = str1.toString();

				}
				if (asymmetricRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("Examinations of the chest show respiratory excursions to be increased.");
					examRespInputController.str = str1.toString();

				}
				
				if(normalRadio.isSelected()){
					
					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("Examinations of the chest show respiratory excursions to be normal.");
					examRespInputController.str = str1.toString();
					
				}

			}

			if (RetractionsIntercostalsCheck.isSelected() || RetractionsNotNotedCheck.isSelected()
					|| RetractionsSupraclavicularCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examRespInputController.str);
				str11.append(" Retractions ");
				examRespInputController.str = str11.toString();

				if (RetractionsIntercostalsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("intercostals,");
					examRespInputController.str = str1.toString();

				}
				if (RetractionsNotNotedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("not noted, ");
					examRespInputController.str = str1.toString();

				}
				if (RetractionsSupraclavicularCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("supraclavicular.");
					examRespInputController.str = str1.toString();

				}

			}

			

			++examRespInputController.formCount;
			examRespInputController.setRespUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examRespInputController.formCount;
				examRespInputController.setRespUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
