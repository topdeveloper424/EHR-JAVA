package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntHearingInputController Class
 *Description: entLipGumTeeth.fxml Controller class
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

public class EntLipGumInputController implements Initializable{
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox lipNormalCheck;

    @FXML
    private RadioButton lipNormalRadio;

    @FXML
    private ToggleGroup lip;

    @FXML
    private RadioButton gumAppearRadio;

    @FXML
    private ToggleGroup gum;

    @FXML
    private RadioButton detitionGoodRadio;

    @FXML
    private ToggleGroup dentition;

    @FXML
    private RadioButton detitionFairRadio;

    @FXML
    private RadioButton gumMildRadio;

    @FXML
    private RadioButton lipChelitisRadio;

    @FXML
    private RadioButton lipHerpiticRadio;

    @FXML
    private RadioButton gumSevereRadio;

    @FXML
    private RadioButton detitionPoorRadio;

    @FXML
    private RadioButton detitionEvalWORadio;

    @FXML
    private RadioButton gumMassrRadio;

    @FXML
    private RadioButton lipAngularRadio;

    @FXML
    private RadioButton detitionEvalWCRadio;
    
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
			
			
			
if (lipNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Lips and gums are normal.");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (lipNormalRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Lips show normal ");
					examEntInputController.str = str1.toString();
					
				}if (lipChelitisRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Lips show cheilitis.");
					examEntInputController.str = str1.toString();
					
				}if (lipHerpiticRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Lips show Herpetic stomatitis. ");
					examEntInputController.str = str1.toString();
					
				}
				
				
				
			}
			
			
			
			
			
			
			
			if (gumAppearRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append(" Gums appear normal.");
				examEntInputController.str = str1.toString();
				
			}if (gumMassrRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Gums mass noted.");
				examEntInputController.str = str1.toString();
				
			}if (gumMildRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Gums show mild gingivitis.");
				examEntInputController.str = str1.toString();
				
			}if (gumSevereRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Gums show severe gingvitis.");
				examEntInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			
			
			
				
				if (detitionGoodRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition is in good repair. ");
					examEntInputController.str = str1.toString();
					
				}if (detitionEvalWORadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Dentition evaluation shows carie(s) w/o abscess.");
					examEntInputController.str = str1.toString();
					
				}if (detitionFairRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition is in fair repair. ");
					examEntInputController.str = str1.toString();
					
				}if (detitionPoorRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition is in poor repair. ");
					examEntInputController.str = str1.toString();
					
				}if (detitionEvalWCRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition evaluation shows carie(s) w/c abscess.");
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
