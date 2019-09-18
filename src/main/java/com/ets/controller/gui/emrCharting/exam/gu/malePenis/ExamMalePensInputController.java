package com.ets.controller.gui.emrCharting.exam.gu.malePenis;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamMalePensInputController Class
 *Description: MalePenisForm.fxml Controller class
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

import com.ets.controller.gui.emrCharting.exam.gu.GUInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamMalePensInputController implements Initializable {
	

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox normalCkeckBox;

    @FXML
    private CheckBox normal2CheckBox;

    @FXML
    private CheckBox balantisCheckBox;

    @FXML
    private CheckBox uncircumcisedCheckBox;

    @FXML
    private CheckBox circumcisedCheckBox;

    @FXML
    private CheckBox venerealCheckBox;

    @FXML
    private CheckBox ulcerationsCheckBox;

    @FXML
    private CheckBox phimosisCheckBox;

    @FXML
    private CheckBox dischargedCheckBox;

	private GUInputController guInputController;


	public void setGuInputController(GUInputController guInputController) {
		this.guInputController = guInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
						
			if (normalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Penis is normal. ");
				guInputController.str = str1.toString();
				
			}if(normal2CheckBox.isSelected() || circumcisedCheckBox.isSelected() || uncircumcisedCheckBox.isSelected() || 
					ulcerationsCheckBox.isSelected() || venerealCheckBox.isSelected() || phimosisCheckBox.isSelected() ||
					balantisCheckBox.isSelected() || dischargedCheckBox.isSelected()){
				
				StringBuilder examBasic = new StringBuilder(guInputController.str);
				examBasic.append("\nPenis: ");
				guInputController.str = examBasic.toString();
				
				
			}if (normal2CheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("normal, ");
				guInputController.str = str1.toString();
				
			}if (circumcisedCheckBox.isSelected()) {
				 
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("circumcised, ");
				guInputController.str = str1.toString();
				
			}if (uncircumcisedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("uncircumcised, ");
				guInputController.str = str1.toString();
			
			} if (ulcerationsCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("ulcerations noted, ");
				guInputController.str = str1.toString();
				
			} if (venerealCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("venereal warts noted, ");
				guInputController.str = str1.toString();
				
			}if (phimosisCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("phimosis noted, ");
				guInputController.str = str1.toString();
				
			}if (balantisCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("balantis noted, ");
				guInputController.str = str1.toString();
				
			}if (dischargedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("discharge noted. ");
				guInputController.str = str1.toString();
				
			}
			
			++guInputController.formCount;	
			guInputController.setGIUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		
		
		skipBtn.setOnAction((event) -> {
			try {
				++guInputController.formCount;	
				guInputController.setGIUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
