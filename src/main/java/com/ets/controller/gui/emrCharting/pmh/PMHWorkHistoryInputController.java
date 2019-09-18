package com.ets.controller.gui.emrCharting.pmh;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RosGuInputController Class
 *Description: WorkHistory.fxm GUI Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.SocialHistoryFreeTextController;
import com.ets.controller.gui.emrCharting.pmh.workHistory.CurrentEmploymentInputController;
import com.ets.controller.gui.emrCharting.pmh.workHistory.PastEmploymentInputController;
import com.ets.controller.gui.emrCharting.pmh.workHistory.RetiredInputController;
import com.ets.controller.gui.emrCharting.pmh.workHistory.TimeAtWorkInputController;
import com.ets.controller.gui.emrCharting.pmh.workHistory.WorkHistoryFreeTextController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class PMHWorkHistoryInputController implements Initializable{
	
	@FXML
    private CheckBox UnemployedCheck;

    @FXML
    private CheckBox CurrentEmploymentCheck;

    @FXML
    private CheckBox TimeAtWorkCheck;

    @FXML
    private CheckBox pastEmploymentCheck;

    @FXML
    private CheckBox RetiredCheck;

    @FXML
    private Button SkipButton;

    @FXML
    private Button DoneButton;
    
   
    
    @FXML
    private Button  freeTextButton;
    
    
    private Button button;
    
	public GenericEMRChartingController genericEMRChartingController;
    
    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}
    
    FXMLFormPath formPath = new FXMLFormPath();
	
	public static Integer formCount = 0;
	public static String strForFreeText = "";
	private Integer secondFormCount = 0;

	public static String str="\n\n";

	void formCountIncrement() {
		++secondFormCount;
	}
	
	
	public void setWorkHistoryUI(){
		
		
		if (UnemployedCheck.isSelected()) {
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Patient is currently unemployed.");
			str = str1.toString();
			UnemployedCheck.setSelected(false);
			
			setWorkHistoryUI();

		} else if (CurrentEmploymentCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHWorkHistoryCurrentEmployment", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHWorkHistoryCurrentEmployment", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			CurrentEmploymentInputController currentEmploymentInputController = (CurrentEmploymentInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			currentEmploymentInputController.setpMHWorkHistoryInputController(this);

			CurrentEmploymentCheck.setSelected(false);

		} 
		 else if (TimeAtWorkCheck.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("PMHWorkHistoryTimeAtWork", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.PMHWorkHistoryTimeAtWork", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				TimeAtWorkInputController timeAtWorkInputController = (TimeAtWorkInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				timeAtWorkInputController.setpMHWorkHistoryInputController(this);

				TimeAtWorkCheck.setSelected(false);

			} 
		else if (pastEmploymentCheck.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHWorkHistoryPastEmployment", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHWorkHistoryPastEmployment", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			PastEmploymentInputController pastEmploymentInputController = (PastEmploymentInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			pastEmploymentInputController.setpMHWorkHistoryInputController(this);

			pastEmploymentCheck.setSelected(false);

		} else if (RetiredCheck.isSelected()) {
			
			formCountIncrement();
			String formName = formPath.context.getMessage("PMHWorkHistoryRetired", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.PMHWorkHistoryRetired", null, Locale.US);

			String formTitle2 = null;
			String formTitle3 = null;
			String formTitle4 = null;

			if (Global.patient != null) {

				formTitle2 = Global.patient.getPatientName().getFirstName();
				formTitle3 = Global.patient.getPatientName().getMiddleName();
				formTitle4 = Global.patient.getPatientName().getLastName();

			}
			String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
			formPath.closeApplicationContext();

			RetiredInputController retiredInputController = (RetiredInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			retiredInputController.setpMHWorkHistoryInputController(this);

			RetiredCheck.setSelected(false);

		} else if (secondFormCount == formCount) {
			
			genericEMRChartingController.paint(button);
			
			formCount = 0;
			genericEMRChartingController.setPmhTextArea(str);
			genericEMRChartingController.saveAllTextArea();
			new FXFormCommonUtilities().closeForm(DoneButton);


		}
		
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		DoneButton.setOnAction((event) -> {
			try {
				
				setWorkHistoryUI();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	    freeTextButton.setOnAction((event) -> {
			
			

				if (UnemployedCheck.isSelected()) {
	                
					StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Unemployed,");
					strForFreeText = str1.toString();
					UnemployedCheck.setSelected(false);

				}

				 if (CurrentEmploymentCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Current Employment,");
					strForFreeText = str1.toString();
					CurrentEmploymentCheck.setSelected(false);
				}

				 if (TimeAtWorkCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("Time at Work,");
					strForFreeText = str1.toString();
					TimeAtWorkCheck.setSelected(false);
				}

				 if (pastEmploymentCheck.isSelected()) {
					 
					     StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Past Employment,");
						strForFreeText = str1.toString();
						pastEmploymentCheck.setSelected(false);
				}

				 if (RetiredCheck.isSelected()) {
					 
					  StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Retired,");
						strForFreeText = str1.toString();
						RetiredCheck.setSelected(false);
				}

				
				
				String formName = formPath.context.getMessage("PMHWorkHistoryFreeText", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PMHWorkHistoryFreeText", null, Locale.US);
				
				
				WorkHistoryFreeTextController workHistoryFreeTextController = 
				(WorkHistoryFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				formPath.closeApplicationContext();
				workHistoryFreeTextController.setpMHWorkHistoryInputController(this);
							
				new FXFormCommonUtilities().closeForm(freeTextButton);
				
			});
		
		SkipButton.setOnAction((event) -> {
			try {
				
				new FXFormCommonUtilities().closeForm(SkipButton);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
}
