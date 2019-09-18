package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntSinusesInputController Class
 *Description: entNasalMucosa.fxml Controller class
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
import javafx.scene.layout.AnchorPane;

public class EntSinusesInputController implements Initializable{
	
	  @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox maxillaryNormalCheck;

	    @FXML
	    private RadioButton maxillaryNonTenderRadio;

	    @FXML
	    private ToggleGroup lip;

	    @FXML
	    private RadioButton frontalNonTenderRadio;

	    @FXML
	    private ToggleGroup gum;

	    @FXML
	    private RadioButton ethmoidNonTenderRadio;

	    @FXML
	    private ToggleGroup dentition;

	    @FXML
	    private RadioButton ethmoidTenderRadio;

	    @FXML
	    private RadioButton frontalLeftTenderRadio;

	    @FXML
	    private RadioButton maxillaryLeftTenderRadio;

	    @FXML
	    private RadioButton maxillaryRightTenderRadio;

	    @FXML
	    private RadioButton frontalRightTenderRadio;

	    @FXML
	    private RadioButton frontalBilaterallyTenderRadio;

	    @FXML
	    private RadioButton maxillaryBilaterallyTenderRadio;
	    
	    private ExamEntInputController examEntInputController;
		
		public void setExamEntInputController(ExamEntInputController examEntInputController) {
			this.examEntInputController = examEntInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEntInputController.str);
			examComp.append("\n\n:Sinuses: ");
			examEntInputController.str = examComp.toString();
			
			if(maxillaryNormalCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("No sinus tenderness present.");
				examEntInputController.str = str1.toString();
				
			}else{
				
				
					
					
					if (maxillaryBilaterallyTenderRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("maxillary tender bilaterally ;");
						examEntInputController.str = str1.toString();
						
					}if (maxillaryLeftTenderRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("maxillary tender left ;");
						examEntInputController.str = str1.toString();
						
					}if (maxillaryNonTenderRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("maxillary non tender ;");
						examEntInputController.str = str1.toString();
						
					}if (maxillaryRightTenderRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("maxillary tender right ;");
						examEntInputController.str = str1.toString();
						
					}
					
					
				}
				
			
			
			
			
	
				
				if (frontalNonTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("frontal non tender.");
					examEntInputController.str = str1.toString();
					
				}if (frontalLeftTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("frontal tender left.");
					examEntInputController.str = str1.toString();
					
				}if (frontalBilaterallyTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("frontal tender bilaterally.");
					examEntInputController.str = str1.toString();
					
				}if (frontalRightTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("frontal tender right.");
					examEntInputController.str = str1.toString();
					
				}
				
				
			
			
			
			
			
				
				
				if (ethmoidNonTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Ethmoid tender.");
					examEntInputController.str = str1.toString();
					
				}if (ethmoidTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Ethmoid non tender.");
					examEntInputController.str = str1.toString();
					
				}
				
				
			
			
			
			++examEntInputController.formCount;	
			examEntInputController.setEntUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examEntInputController.formCount;	
				examEntInputController.setEntUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
