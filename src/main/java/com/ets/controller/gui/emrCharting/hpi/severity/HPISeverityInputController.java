package com.ets.controller.gui.emrCharting.hpi.severity;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPISeverityInputController Class
 *Description: Severity.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;

public class HPISeverityInputController implements Initializable {
	
	  @FXML
	    private CheckBox pain1CheckBox;

	    @FXML
	    private CheckBox pain2CheckBox;

	    @FXML
	    private CheckBox pain3CheckBox;

	    @FXML
	    private CheckBox pain4CheckBox;

	    @FXML
	    private CheckBox pain5CheckBox;

	    @FXML
	    private CheckBox pain6CheckBox;

	    @FXML
	    private CheckBox pain7CheckBox;

	    @FXML
	    private CheckBox degree1CheckBox;

	    @FXML
	    private CheckBox pain9CheckBox;

	    @FXML
	    private CheckBox pain8CheckBox;

	    @FXML
	    private CheckBox pain10CheckBox;

	    @FXML
	    private CheckBox majorCheckBox;

	    @FXML
	    private CheckBox moderateCheckBox;

	    @FXML
	    private CheckBox minorCheckBox;

	    @FXML
	    private CheckBox degree2CheckBox;

	    @FXML
	    private CheckBox degree3CheckBox;

	    @FXML
	    private CheckBox significantCheckBox;

	    @FXML
	    private CheckBox severeCheckBox;

	    @FXML
	    private CheckBox nuisanceCheckBox;

	    @FXML
	    private CheckBox tolarableCheckBox;

	    @FXML
	    private CheckBox intolarableCheckBox;

	    @FXML
	    private CheckBox excruciatingCheckBox;

	    @FXML
	    private CheckBox simpleCheckBox;

	    @FXML
	    private CheckBox compoundCheckBox;

	    @FXML
	    private CheckBox painOnsetCheckBox;

	    @FXML
	    private CheckBox otherSeverityCheckBox;

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
				genericEMRChartingController.setHpiTextArea("\n\nSEVERITY : ");
				if(pain1CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 1 on a scale of 1 to 10");
				}
				if(pain2CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 2 on a scale of 1 to 10");
				}
				if(pain3CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 3 on a scale of 1 to 10");
				}
				if(pain4CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 4 on a scale of 1 to 10");
				}
				if(pain5CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 5 on a scale of 1 to 10");
				}
				if(pain6CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 6 on a scale of 1 to 10");
				}
				if(pain7CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 7 on a scale of 1 to 10");
				}
				if(pain8CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 8 on a scale of 1 to 10");
				}
				if(pain9CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 9 on a scale of 1 to 10");
				}
				if(pain10CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient rates the pain 10 on a scale of 1 to 10");
				}
				if(degree1CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("1st Degree");
				}
				if(degree2CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("2nd Degree");
				}
				if(degree3CheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("3rd Degree");
				}
				if(minorCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("minor(1 to 10)");
				}
				if(moderateCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("moderate(2 to 4)");
				}
				if(majorCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("major(7 to 8)");
				}
				if(significantCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("significant(5 to 6)");
				}
				if(severeCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("severe(9 to 10)");
				}
				if(nuisanceCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("nuisance");
				}
				if(tolarableCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("tolarable");
				}
				if(intolarableCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("intolarable");
				}
				if(excruciatingCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("excruciating");
				}
				if(simpleCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("simple");
				}
				if(compoundCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("compound");
				}
				if(painOnsetCheckBox.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient claims onset pain of 2/10. Current pain is 2/10 ");
				}
								
				
				
				button.setTextFill(Color.GREEN);
				genericEMRChartingController.saveAllTextArea(); 
				new FXFormCommonUtilities().closeForm( doneBtn);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
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
