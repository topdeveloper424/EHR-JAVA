package com.ets.controller.gui.emrCharting.hpi.timing;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-0103-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPITimingInputController Class
 *Description: Timing.fxml GUI Controller class
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
import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.paint.Color;

public class HPITimingInputController implements Initializable {
	
	  @FXML
	    private CheckBox constantCheck;

	    @FXML
	    private CheckBox intermittentCheck;

	    @FXML
	    private CheckBox comesAndGoCheck;

	    @FXML
	    private CheckBox EveryFewMinutesCheck;

	    @FXML
	    private CheckBox PeriodicCheck;

	    @FXML
	    private CheckBox WaxingAndWaningCheck;

	    @FXML
	    private CheckBox AfterEatingCheck;

	    @FXML
	    private CheckBox BeforeEating;

	    @FXML
	    private CheckBox nighttimeCheck;

	    @FXML
	    private CheckBox MiddayCheck;

	    @FXML
	    private CheckBox uponAwakeningCheck;

	    @FXML
	    private CheckBox MorningCheck;

	    @FXML
	    private CheckBox afternoonCheck;

	    @FXML
	    private CheckBox eveningCheck;

	    @FXML
	    private CheckBox WhenGettingUpCheck;

	    @FXML
	    private CheckBox WhenGoingToBedCheck;

	    @FXML
	    private CheckBox WhenSleepingCheck;

	    @FXML
	    private CheckBox OtherTimingCheck;
	    @FXML
	    private Button doneButton;
	    
	    @FXML
	    private Button skipBtn;
	    
	    
	    
	private Button button;
	private GenericEMRChartingController genericEMRChartingController;
    
    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneButton.setOnAction((event) -> {
			try{
				genericEMRChartingController.setHpiTextArea("\nTIMING : ");
			if(constantCheck.isSelected()){
				genericEMRChartingController.setHpiTextArea("constant");
				
			}
			if(intermittentCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("intermittent");
			}
			
            if(comesAndGoCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("comes and go");
			}
           if(EveryFewMinutesCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Every Few Minutes");
			}
           if(PeriodicCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Periodic");
			}
           if(WaxingAndWaningCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Waxing And Waning");
			}
           if(AfterEatingCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("After Eating");
			}
           if(BeforeEating.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Before Eating");
			}
           if(nighttimeCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Nighttime");
			}
           if(MiddayCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Midday");
			}
           if(uponAwakeningCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Upon Awakening");
			}
           if(MorningCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Morning");
			}
           if(afternoonCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Afternoon");
			}
           if(eveningCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("Evening");
			}
          
           if(WhenGoingToBedCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("When Going To Bed Check");
			}
           if(WhenGettingUpCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("When Getting Up Check");
			}
           if(WhenSleepingCheck.isSelected()){
				
				genericEMRChartingController.setHpiTextArea("When Sleeping Check");
			}
           
           genericEMRChartingController.saveAllTextArea(); 
       
           button.setTextFill(Color.GREEN);
			new FXFormCommonUtilities().closeForm(doneButton);
			}
           catch (Exception ex) {
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
