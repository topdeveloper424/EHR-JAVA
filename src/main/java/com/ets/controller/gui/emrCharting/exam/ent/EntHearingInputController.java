package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntHearingInputController Class
 *Description: entHearing.fxml Controller class
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
import javafx.scene.layout.AnchorPane;

public class EntHearingInputController implements Initializable{
	

    @FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private CheckBox hearLeftNormalCkeckBox;

    @FXML
    private CheckBox hearLeftWhisperedCkeckBox;

    @FXML
    private CheckBox hearLeftMldlyCkeckBox;

    @FXML
    private CheckBox hearLeftModeratelyCkeckBox;

    @FXML
    private CheckBox hearLeftSeverallyCkeckBox;

    @FXML
    private CheckBox hearRightNormalCkeckBox;

    @FXML
    private CheckBox hearRighttWhisperedCkeckBox;

    @FXML
    private CheckBox hearRightMldlyCkeckBox;

    @FXML
    private CheckBox hearRighttAbsentCkeckBox;

    @FXML
    private CheckBox hearRightSeverallyCkeckBox;

    @FXML
    private CheckBox hearRightAllNormalCkeckBox;

    @FXML
    private CheckBox hearLeftAbsentCkeckBox;

    @FXML
    private CheckBox hearLeftNotTestedCkeckBox;

    @FXML
    private CheckBox hearRightNotTestedCkeckBox;

    @FXML
    private CheckBox hearRightModeratelyCkeckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox hearLeftAllNormalCkeckBox;

	    
	    private ExamEntInputController examEntInputController;
		
		public void setExamEntInputController(ExamEntInputController examEntInputController) {
			this.examEntInputController = examEntInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEntInputController.str);
			examComp.append("\n\n: ");
			examEntInputController.str = examComp.toString();
			
						
			
if (hearLeftAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Hearing in the left ear is normal; ");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (hearLeftAbsentCkeckBox.isSelected() || hearLeftMldlyCkeckBox.isSelected() || hearLeftModeratelyCkeckBox.isSelected() || hearLeftNormalCkeckBox.isSelected() 
						|| hearLeftNotTestedCkeckBox.isSelected() || hearLeftSeverallyCkeckBox.isSelected() || hearLeftWhisperedCkeckBox.isSelected() ) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("");
					examEntInputController.str = str11.toString();
					
					
					if (hearLeftAbsentCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftMldlyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftModeratelyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftNotTestedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftSeverallyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftWhisperedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}
					
					
				}
				
				
				
			}
			
			
			
			
			
			
			
			
			if (hearRightAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("Hearing in the right ear is normal; ");
				examEntInputController.str = str11.toString();
				
			}else{
				
				if (hearRightMldlyCkeckBox.isSelected() || hearRightModeratelyCkeckBox.isSelected() || hearRightNormalCkeckBox.isSelected() || hearRightNotTestedCkeckBox.isSelected() 
						|| hearRightSeverallyCkeckBox.isSelected() || hearRighttAbsentCkeckBox.isSelected() || hearRighttWhisperedCkeckBox.isSelected() ) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("");
					examEntInputController.str = str11.toString();
					
					
					if (hearRightMldlyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightModeratelyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightNotTestedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightSeverallyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRighttAbsentCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRighttWhisperedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}
					
					
				}
				
				
				
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
