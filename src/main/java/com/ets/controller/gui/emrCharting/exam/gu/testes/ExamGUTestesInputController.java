package com.ets.controller.gui.emrCharting.exam.gu.testes;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamGUTestesInputController Class
 *Description: testes.fxml Controller class
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

public class ExamGUTestesInputController implements Initializable{
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox prostatenormalCkeckBox;

	    @FXML
	    private CheckBox LeftNormalCheck;

	    @FXML
	    private CheckBox LefttendernessCheck;

	    @FXML
	    private CheckBox LeftMassesCheck;

	    @FXML
	    private CheckBox LeftenlargedCheck;

	    @FXML
	    private CheckBox LeftAtrophicCheck;

	    @FXML
	    private CheckBox RightTestisMassesCheck;

	    @FXML
	    private CheckBox rightTestisTenderCheck;

	    @FXML
	    private CheckBox RightAbsentCheck;

	    @FXML
	    private CheckBox RightNormalCheck;

	    @FXML
	    private CheckBox RightAtrophicCheck;

	    @FXML
	    private CheckBox RightMassesCheck;

	    @FXML
	    private CheckBox LeftHydroceleCheck;

	    @FXML
	    private CheckBox rightEpididymisCheck;

	    @FXML
	    private CheckBox RightHydroceleCheck;

	    @FXML
	    private CheckBox RighttendernessCheck;

	    @FXML
	    private CheckBox RightenlargedCheck;

	    @FXML
	    private CheckBox LeftEpididymisCheck;

	    @FXML
	    private CheckBox leftAbsentCheck;
	
	private GUInputController guInputController;

	public void setGuInputController(GUInputController guInputController) {
		this.guInputController = guInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examBasic = new StringBuilder(guInputController.str);
			examBasic.append("\n\nGU Male: ");
			guInputController.str = examBasic.toString();
			
			
			if (prostatenormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Exam of scrotum shows testes normal. ");
				guInputController.str = str1.toString();
				
			}if(LeftNormalCheck.isSelected() || LeftMassesCheck.isSelected() || LeftenlargedCheck.isSelected() || LeftAtrophicCheck.isSelected() || 
					LeftHydroceleCheck.isSelected() || RightTestisMassesCheck.isSelected() || LefttendernessCheck.isSelected() || rightTestisTenderCheck.isSelected() ||
					RightAbsentCheck.isSelected() || rightEpididymisCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Exam of scrotum shows left testis ");
				guInputController.str = str1.toString();
				
				
			}if (LeftNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("normal, ");
				guInputController.str = str1.toString();
				
			}if (LefttendernessCheck.isSelected()) {
				 
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("tenderness,");
				guInputController.str = str1.toString();
				    
			} if (LeftMassesCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("masses, ");
				guInputController.str = str1.toString();
				  
			}if (LeftenlargedCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("enlarged, ");
				guInputController.str = str1.toString();
				
			} if (LeftAtrophicCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("atrophic, ");
				guInputController.str = str1.toString();
				
			}if (rightTestisTenderCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("right testis tenderness,");
				guInputController.str = str1.toString();
				
			}if (RightTestisMassesCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("right testis masses, ");
				guInputController.str = str1.toString();
				
			}if (RightAbsentCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("absent, ");
				guInputController.str = str1.toString();
				
			}if (LeftHydroceleCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("hydrocele, ");
				guInputController.str = str1.toString();
				
			}if (rightEpididymisCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("epididymis, ");
				guInputController.str = str1.toString();
				
			}if(RightNormalCheck.isSelected() || RighttendernessCheck.isSelected() || RightMassesCheck.isSelected() || RightenlargedCheck.isSelected() ||
					RightAtrophicCheck.isSelected() || leftAbsentCheck.isSelected() || RightHydroceleCheck.isSelected() || LeftEpididymisCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("right testis ");
				guInputController.str = str1.toString();
				
				
			}if (RightNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("normal, ");
				guInputController.str = str1.toString();
				
			}if (RighttendernessCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("tenderness, ");
				guInputController.str = str1.toString();
				 
			}if (RightMassesCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("masses, ");
				guInputController.str = str1.toString();
				
			}if (RightenlargedCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("enlarged, ");
				guInputController.str = str1.toString();
				
			}if (RightAtrophicCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("atrophic, ");
				guInputController.str = str1.toString();
				
			}if (leftAbsentCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("absent, ");
				guInputController.str = str1.toString();
				
			}if (RightHydroceleCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("hydrocele, ");
				guInputController.str = str1.toString();
				
			}if (LeftEpididymisCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("epididymis, ");
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
