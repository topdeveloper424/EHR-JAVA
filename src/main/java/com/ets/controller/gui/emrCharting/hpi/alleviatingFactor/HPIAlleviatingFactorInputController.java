package com.ets.controller.gui.emrCharting.hpi.alleviatingFactor;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPIAlleviatingFactorInputController Class
 *Description: AlleviatingFactor.fxml GUI Controller class
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

public class HPIAlleviatingFactorInputController implements Initializable{
	    @FXML
	    private CheckBox DrinkingSomethingCheck;

	    @FXML
	    private CheckBox EatingCheck;

	    @FXML
	    private CheckBox GettingUpInMorningCheck;

	    @FXML
	    private CheckBox StayingStillCheck;

	    @FXML
	    private CheckBox LyingDownCheck;

	    @FXML
	    private CheckBox MovingAroundCheck;

	    @FXML
	    private CheckBox SleepingCheck;

	    @FXML
	    private CheckBox SwallowingCheck;

	    @FXML
	    private CheckBox OtherAlleviatingFactorCheck;

	    @FXML
	    private CheckBox NotMovingCheck;

	    @FXML
	    private CheckBox StandingUpCheck;

	    @FXML
	    private CheckBox SittingDownCheck;

	    @FXML
	    private CheckBox WalkingCheck;
	    
	    @FXML
	    private Button skipBtn;
	    
	    @FXML
	    private Button doneButton;
	
	private Button button;
	 private GenericEMRChartingController genericEMRChartingController;
	    
	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
		}

	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneButton.setOnAction((event) -> {
			try {
				genericEMRChartingController.setHpiTextArea("\n\nBETTER : ");
				if(DrinkingSomethingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Drinkng something");
					
				}
				if(EatingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Eating");
					
				}
				if(GettingUpInMorningCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Getting Up In Morning");
					
				}
				if(SleepingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Sleeping");
					
				}
				if(LyingDownCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Lying Down");
					
				}
				if(MovingAroundCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Moving Around");
					
				}
				if(NotMovingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Not Moving");
					
				}
				if(SittingDownCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Sitting Down");
					
				}
				if(StandingUpCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Standing Up");
					
				}
				if(StayingStillCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Staying Still");
					
				}
				if(SwallowingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Swallowing");
					
				}
				if(WalkingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Walking");
					
				}
				button.setTextFill(Color.GREEN);
				new FXFormCommonUtilities().closeForm(doneButton);
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
