package com.ets.controller.gui.emrCharting.exam.constitutional.comprehensive;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.constutional.ExamConstutionalInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ConstComprehensiveInputController Class
 *Description: EditDistrict GUI Controller class
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
public class ConstComprehensiveInputController implements Initializable {
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox patientAppearsnormalCkeckBox;

	    @FXML
	    private CheckBox DistressnormalCkeckBox1;

	    @FXML
	    private CheckBox vitalSignsnormalCkeckBox11;

	    @FXML
	    private CheckBox AcuteDistressCheck;

	    @FXML
	    private CheckBox bloodPressureLowCheck;

	    @FXML
	    private CheckBox heartRateLowCheck;

	    @FXML
	    private CheckBox respiratoryLowCheck;

	    @FXML
	    private CheckBox temperatureLowCheck;

	    @FXML
	    private CheckBox heartRateElevatedCheck;

	    @FXML
	    private CheckBox bloodPressureElevatedCheck;

	    @FXML
	    private CheckBox respiratoryRateElevatedCheck;

	    @FXML
	    private CheckBox temperatureElevatedCheck;

	    @FXML
	    private CheckBox otherCheck;

	    @FXML
	    private CheckBox bloodPressureHighCheck;

	    @FXML
	    private CheckBox severeDistressCheck;

	    @FXML
	    private CheckBox mildDistressCheck;

	    @FXML
	    private CheckBox moderateDistressCheck;

	    @FXML
	    private CheckBox mordiblyObeseCheck;

	    @FXML
	    private CheckBox overweightCheck;

	    @FXML
	    private CheckBox obeseCheck;

	    @FXML
	    private CheckBox cachecticCheck;

	    @FXML
	    private CheckBox thinCheck;

	    @FXML
	    private CheckBox flushedCheck;

	    @FXML
	    private CheckBox washedCheck;

	    @FXML
	    private CheckBox wellnourishedCheck;
	    FXMLFormPath formPath = new FXMLFormPath();
	    
	    
	private ExamConstutionalInputController examConstutionalInputController;
	
	
	public void setExamConstutionalInputController(ExamConstutionalInputController examConstutionalInputController) {
		this.examConstutionalInputController = examConstutionalInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examConstutionalInputController.str);
			examComp.append("\n\n ");
			examConstutionalInputController.str = examComp.toString();
			
			
			++examConstutionalInputController.formCount;	
			examConstutionalInputController.setConstUI();
			
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examConstutionalInputController.formCount;	
				examConstutionalInputController.setConstUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	

}
}
