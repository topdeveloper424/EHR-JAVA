package com.ets.controller.gui.emrCharting.hpi.aggaravatingFactor;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPIAggaravatingFactorInputController Class
 *Description: AggaravatingFactor.fxml GUI Controller class
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

public class HPIAggaravatingFactorInputController implements Initializable {
	 @FXML
	    private CheckBox bendingCheckBox;

	    @FXML
	    private CheckBox drinkingCheckBox;

	    @FXML
	    private CheckBox eatingCheckBox;

	    @FXML
	    private CheckBox swallowingCheckBox;

	    @FXML
	    private CheckBox gettingupCheckBox;

	    @FXML
	    private CheckBox liftingCheckBox;

	    @FXML
	    private CheckBox lyingDownCheckBox;

	    @FXML
	    private CheckBox movingAroundCheckBox;

	    @FXML
	    private CheckBox sleepingCheckBox;

	    @FXML
	    private CheckBox pushingCheckBox;

	    @FXML
	    private CheckBox stoppingCheckBox;

	    @FXML
	    private CheckBox pullingCheckBox;

	    @FXML
	    private CheckBox reachingOutCheckBox;

	    @FXML
	    private CheckBox rearchingUpCheckBox;

	    @FXML
	    private CheckBox otherCheckBox;

	    @FXML
	    private CheckBox walkingCheckBox;

	    @FXML
	    private CheckBox sittingDownCheckBox;

	    @FXML
	    private CheckBox sittingForCheckBox;
	    
        private Button button;
        
        @FXML
        private Button skipBtn;
        
        @FXML
        private Button DoneBtn;

	    
	    private GenericEMRChartingController genericEMRChartingController;
	    
	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		DoneBtn.setOnAction((event) -> {
			try {
				
				genericEMRChartingController.setHpiTextArea("\n\nWORSE : ");
		if(bendingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Bending");
		}
		if(drinkingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Drinking");
		}
		
		if(eatingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Eating");
		}
		
		if(swallowingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("swallowing");
		}
		
		
		if(gettingupCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Getting up in morning");
		}
		
		if(liftingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("liftting");
		}
		
		if(lyingDownCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Lying Down");
		}
		
		
		if(movingAroundCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Moving Around");
		}
		

		if(pullingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Pulling");
		}
		

		if(pushingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("pushing");
		}
		

		if(reachingOutCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Reaching Out");
		}
		

		if(rearchingUpCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Rearching Up");
		}
		

		if(sleepingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("sleeping");
		}
		

		if(sittingDownCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Sitting Down");
		}
		
		

		if(sittingForCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Sitting for Long Period");
		}

		if(stoppingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("stopping");
		}

		if(walkingCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("Walking");
		}

		if(otherCheckBox.isSelected()){
			genericEMRChartingController.setHpiTextArea("");
		}
		button.setTextFill(Color.GREEN);
		new FXFormCommonUtilities().closeForm(DoneBtn);
		
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
