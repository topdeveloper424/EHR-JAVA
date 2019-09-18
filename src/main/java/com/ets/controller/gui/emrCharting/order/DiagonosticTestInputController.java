package com.ets.controller.gui.emrCharting.order;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DiagonosticTestInputController Class
 *Description: diagonistics.fxm GUI Controller class
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
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DiagonosticTestInputController implements Initializable {
	
	 @FXML
	    private CheckBox AccucheckCheckBox;

	    @FXML
	    private CheckBox cmpCheckBox;

	    @FXML
	    private CheckBox hemoglobinCheckBox;

	    @FXML
	    private CheckBox chemistryCheckBox;

	    @FXML
	    private CheckBox upperExtrimitiesCheckBox;

	    @FXML
	    private CheckBox hematologyCheckBox;

	    @FXML
	    private CheckBox microbiologyCheckBox;

	    @FXML
	    private CheckBox occMedCheckBox;

	    @FXML
	    private CheckBox anemiaCheckBox;

	    @FXML
	    private CheckBox giCheckBox;

	    @FXML
	    private CheckBox influenzaCheckBox;

	    @FXML
	    private CheckBox strepCheckBox;

	    @FXML
	    private CheckBox ucCheckBox;

	    @FXML
	    private CheckBox wcCheckBox;

	    @FXML
	    private CheckBox instantCheckBox;

	    @FXML
	    private CheckBox chestCheckBox;

	    @FXML
	    private CheckBox headCheckBox;

	    @FXML
	    private CheckBox lowerExtrimitiesCheckBox;

	    @FXML
	    private CheckBox spineCheckBox;

	    @FXML
	    private CheckBox ctScanCheckBox;

	    @FXML
	    private CheckBox mriCheckBox;

	    @FXML
	    private CheckBox ultrasonographyCheckBox;

	    @FXML
	    private CheckBox audiometryCheckBox;

	    @FXML
	    private CheckBox ekgCheckBox;

	    @FXML
	    private CheckBox emgCheckBox;

	    @FXML
	    private CheckBox jamarCheckBox;

	    @FXML
	    private CheckBox bloodPressureCheckBox;

	    @FXML
	    private CheckBox peckFlowCheckBox;

	    @FXML
	    private CheckBox pulseOximetryCheckBox;

	    @FXML
	    private CheckBox pulmunaryFunctionCheckBox;

	    @FXML
	    private CheckBox tympanometryCheckBox;

	    @FXML
	    private CheckBox visionTestCheckBox;

	    @FXML
	    private CheckBox vitalSignCheckBox;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;
	   
	    
	  //  private Button button;
	    
	    private GenericEMRChartingController genericEMRChartingController;

		public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController) {
			this.genericEMRChartingController = genericEMRChartingController;
			
		}
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	    
	    public static String str = "\n\nOrdered ";
	    
	    public void setDiagonosisTestUI(){
	    	
	    	/*if(upperExtrimitiesCheckBox.isSelected()){
	    		
	    		String fmName=formPath.context.getMessage("OrderSmartFormXHouse", null, Locale.US);
				String fmTitle=formPath.context.getMessage("Title.OrderSmartFormXHouse", null, Locale.US);
				formPath.closeApplicationContext();
				XrayInHouseInputController xrayInHouseInputController =
				 (XrayInHouseInputController) new FXFormCommonUtilities().displayForm(fmName, fmTitle);
				//pmhAlcoholInputController.setPmhSocialHistoryInputController(this, DoneButton);
				xrayInHouseInputController.setDiagonosticTestInputController(this);
				upperExtrimitiesCheckBox.setSelected(false);
	    		
	    	}else {
	    		genericEMRChartingController.viewResultMedicalActivityChargeTable(XrayInHouseInputController.medicalActivityId);
	    		genericEMRChartingController.setOrderTextArea(str);
	    		new FXFormCommonUtilities().closeForm(doneBtn);
			}*/
	    }
	    
	    public void closeUI(Button button){
	    	new FXFormCommonUtilities().closeForm(button);
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			setDiagonosisTestUI();
			
			
		});
		
		
	}

}
