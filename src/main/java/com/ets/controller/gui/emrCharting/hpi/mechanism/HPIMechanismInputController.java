package com.ets.controller.gui.emrCharting.hpi.mechanism;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 11-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPIMechanismInputController Class
 *Description: Mechanism.fxml GUI Controller class
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

public class HPIMechanismInputController implements Initializable {
	
	 @FXML
	    private CheckBox PatientIsUncertainText;

	    @FXML
	    private CheckBox AutoAccidentCheck;

	    @FXML
	    private CheckBox BicycleAccidentCheck;

	    @FXML
	    private CheckBox ChemicalBurnCheck;

	    @FXML
	    private CheckBox ChemicalSpilCheck;

	    @FXML
	    private CheckBox ChemicalSplashCheck;

	    @FXML
	    private CheckBox ElectricalBurnCheck;

	    @FXML
	    private CheckBox ElectricalShockCheck;

	    @FXML
	    private CheckBox HurtByEquipmentCheck;

	    @FXML
	    private CheckBox FireCheck;

	    @FXML
	    private CheckBox HurtByToolCheck;

	    @FXML
	    private CheckBox ForeignBodyinEyeCheck;

	    @FXML
	    private CheckBox SunBurnCheck;

	    @FXML
	    private CheckBox PullingAnObjectCheck;

	    @FXML
	    private CheckBox StruckByAnObjectCheck;

	    @FXML
	    private CheckBox BendingCheck;

	    @FXML
	    private CheckBox StruckAnObjectCheck;

	    @FXML
	    private CheckBox TwistingCheck;

	    @FXML
	    private CheckBox StoopingCheck;

	    @FXML
	    private CheckBox PushingAnObjectCheck;

	    @FXML
	    private CheckBox MovingAnObjectCheck;

	    @FXML
	    private CheckBox LiftingAnObjectCheck;

	    @FXML
	    private CheckBox FellCheck;

	    @FXML
	    private CheckBox TrippedCheck;

	    @FXML
	    private CheckBox SlippedCheck;

	    @FXML
	    private CheckBox InhaledFumesCheck;

	    @FXML
	    private CheckBox StructByVehicleCheck;

	    @FXML
	    private CheckBox ThrownFromAvehicleCheck;

	    @FXML
	    private CheckBox StruckByLightning;

	    @FXML
	    private CheckBox ThrownByAnVehicleCheck;

	    @FXML
	    private CheckBox ThrownFromHorseCheck;

	    @FXML
	    private CheckBox OtherContextCheck;
	    
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
				genericEMRChartingController.setHpiTextArea("\nCONTEXT / MECHANISM : ");
				if(PatientIsUncertainText.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient is uncertain of how this problem started");
				}
				if(AutoAccidentCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Auto Accident");
				}
				if(BicycleAccidentCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Bicycle Accident");
				}
				if(ChemicalBurnCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Chemical Burn");
				}
				if(ChemicalSpilCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("chemical spil");
				}
				if(ChemicalSplashCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("chemical splash");
				}
				if(ElectricalBurnCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("electrical burn");
				}
				if(ElectricalShockCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("electrical shock");
				}
				if(FireCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("fire");
				}
				if(ForeignBodyinEyeCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Foreign Body");
				}
				if(SunBurnCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("SunBurn");
				}
				if(HurtByEquipmentCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Hurt by Equipment");
				}
				if(HurtByToolCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Hurt by Tool");
				}
				if(InhaledFumesCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Inhaled Fumes");
				}
				if(SlippedCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Slipped");
				}
				if(TrippedCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Tripped");
				}
				if(FellCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Fell");
				}
				if(LiftingAnObjectCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Lifting an Object");
				}
				if(MovingAnObjectCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Moving an Object");
				}
				if(PushingAnObjectCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Pushing an Object");
				}
				if(PullingAnObjectCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Pulling an Object");
				}
				if(BendingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Bending");
				}
				if(StoopingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Stooping");
				}
				if(TwistingCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Twisting");
				}
				if(StruckAnObjectCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Struck an Object");
				}
				if(StruckByAnObjectCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Struck by an Object");
				}
				if(StruckByLightning.isSelected()){
					genericEMRChartingController.setHpiTextArea("Struck by Lightning");
				}
				if(StructByVehicleCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Struct by Vehicle");
				}
				if(ThrownByAnVehicleCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Thrown by Vehicle");
				}
				if(ThrownFromAvehicleCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Thrown from a vehicle");
				}
				if(ThrownFromHorseCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Thrown from Horse");
				}
				/*if(OtherContextCheck.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient claims onset pain of 2/10. Current pain is 2/10 ");
				}*/
								
				genericEMRChartingController.saveAllTextArea(); 
				button.setTextFill(Color.GREEN);
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
