package com.ets.controller.gui.emrCharting.ros.allIm;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AllImInputController Class
 *Description: Allim.fxm GUI Controller class
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

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class AllImInputController implements Initializable {
	
	  @FXML
	    private RadioButton deniesRadio;

	    @FXML
	    private RadioButton hayFeverRadio;

	    @FXML
	    private ToggleGroup blurred;

	    @FXML
	    private RadioButton hivesRadio;

	    @FXML
	    private ToggleGroup cataracts;

	    @FXML
	    private RadioButton itchyRadio;

	    @FXML
	    private RadioButton rhinitisRadio;

	    @FXML
	    private ToggleGroup excessive;

	    @FXML
	    private RadioButton drugsRadio;

	    @FXML
	    private ToggleGroup eye;

	    @FXML
	    private RadioButton foodsRadio;

	    @FXML
	    private ToggleGroup flashing;

	    @FXML
	    private RadioButton swellingsRadio;

	    @FXML
	    private ToggleGroup glaucoma;

	    @FXML
	    private RadioButton hayFeverPlusRadio;

	    @FXML
	    private RadioButton hayFeverMinusRadio;

	    @FXML
	    private RadioButton hayFeverQuesRadio;

	    @FXML
	    private RadioButton drugsQuesRadio;

	    @FXML
	    private RadioButton drugsMinusRadio;

	    @FXML
	    private RadioButton drugsPlusRadio;

	    @FXML
	    private RadioButton swellingsPlusRadio;

	    @FXML
	    private RadioButton swellingsMinusRadio;

	    @FXML
	    private RadioButton swellingsQuesRadio;

	    @FXML
	    private RadioButton hivesPlusRadio;

	    @FXML
	    private RadioButton hivesMinusRadio;

	    @FXML
	    private RadioButton hivesQuesRadio;

	    @FXML
	    private RadioButton itchyQuesRadio;

	    @FXML
	    private ToggleGroup dimness;

	    @FXML
	    private RadioButton itchyMinusRadio;

	    @FXML
	    private RadioButton itchyPlusRadio;

	    @FXML
	    private RadioButton rhinitisPlusRadio;

	    @FXML
	    private RadioButton rhinitisMinusRadio;

	    @FXML
	    private RadioButton rhinitisQuesRadio;

	    @FXML
	    private RadioButton foodsPlusRadio;

	    @FXML
	    private RadioButton foodsMinusRadio;

	    @FXML
	    private RadioButton foodsQuesRadio;

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
				genericEMRChartingController.setRosTextArea("\n\nALLERGIC / IMMUNOLOGIC:");
				
				if(deniesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("Denies rhinitis, hay fever, itchy eyes, urticaria, angioedema, or sensitivity to foods or drugs. ");
					
				}
				
				if(hayFeverRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Hay fever.,");
					
				}if(hayFeverPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" claims  hay fever ");
					
				}if(hayFeverMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" denies  hay fever ");
					
				}if(hayFeverQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" unsure about claims  hay fever");
					
				}if(hivesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Hives (urticaria) ,");
					
				}if(hivesPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" claims Hives (urticaria).,");
					
				}if(hivesMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("denies Hives (urticaria).");
					
				}if(hivesQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" unsure about Hives (urticaria).,");
					
				}if(itchyRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Itchy eyes.");
					
				}if(itchyPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("claims itchy eyes.");
					
				}if(itchyMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" denies itchy eyes");
					
				}if(itchyQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea("unsure about itchy eyes");
					
				}if(rhinitisRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Rhinitis,");
					
				}if(rhinitisPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" claims  rhinitis ");
					
				}if(rhinitisMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" denies Rhinitis ");
					
				}if(rhinitisQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" unsure about  rhinitis");
					
				}if(drugsRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to drugs, documented elsewhere. ");
					
				}if(drugsPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to drugs, documented elsewhere. ");
					
				}if(drugsMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to drugs, documented elsewhere.");
					
				}if(drugsQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to drugs, documented elsewhere.");
					
				}if(foodsRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to foods, doumented elsewhere.");
					
				}if(foodsPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to foods, doumented elsewhere.");
					
				}if(foodsMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to foods, doumented elsewhere.");
					
				}if(foodsQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Sensitivity to foods, doumented elsewhere.");
					
				}if(swellingsRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Swelling under skin (angioedema).");
					
				}if(swellingsPlusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" Claims swelling under skin (angioedema)");
					
				}if(swellingsMinusRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" denies swelling under skin (angioedema)");
					
				}if(swellingsQuesRadio.isSelected()){
					
					genericEMRChartingController.setRosTextArea(" unsure about swelling under skin (angioedema)");
					
				}
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
