package com.ets.controller.gui.emrCharting.exam.skin.skinBurn;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkinBurnInputController Class
 *Description: skinBurn.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.exam.skin.ExamSkinInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class SkinBurnInputController implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	  

	    @FXML
	    private CheckBox erythemaCheck;

	    @FXML
	    private CheckBox multipleCheck;

	    @FXML
	    private CheckBox FirstdegCheck;

	    @FXML
	    private CheckBox thirdDegCheck;

	    @FXML
	    private CheckBox swollenCheck;

	    @FXML
	    private CheckBox goodskinCheck;

	    @FXML
	    private CheckBox blistersCheck;

	    @FXML
	    private CheckBox whiteCheck;

	    @FXML
	    private CheckBox secondDegCheck;

	    @FXML
	    private CheckBox burstCheck;

	    @FXML
	    private CheckBox circumferentialCheck;

	    @FXML
	    private CheckBox infectedBurnCheck;
	    
	    
	    private ExamSkinInputController examSkinInputController;
		
		public void setExamSkinInputController(ExamSkinInputController examSkinInputController) {
			this.examSkinInputController = examSkinInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(examSkinInputController.str);
			skelComp.append("\nSKIN: The affected area reveals: ");
			examSkinInputController.str = skelComp.toString();

			if (erythemaCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" erythema of 1st degree burn,");
				examSkinInputController.str = str1.toString();

			}
			if (blistersCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" blisters on erythematous base,");
				examSkinInputController.str = str1.toString();

			}if (multipleCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" multiple burn blisters,");
				examSkinInputController.str = str1.toString();

			}if (whiteCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" white and painless skin,");
				examSkinInputController.str = str1.toString();

			}
			if (FirstdegCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" 1st degree burn changes,");
				examSkinInputController.str = str1.toString();

			}
			if (secondDegCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" 2nd degree burn changes,");
				examSkinInputController.str = str1.toString();

			}if (thirdDegCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" 3rd degree burn changes,");
				examSkinInputController.str = str1.toString();

			}if (burstCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" burst blisters,");
				examSkinInputController.str = str1.toString();

			}if (swollenCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" swollen tender indurated,");
				examSkinInputController.str = str1.toString();

			}if (circumferentialCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" circumferential burn,");
				examSkinInputController.str = str1.toString();

			}if (goodskinCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" good skin healing,");
				examSkinInputController.str = str1.toString();

			}if (infectedBurnCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" infected burn area,");
				examSkinInputController.str = str1.toString();

			}
		++examSkinInputController.formCount;	
		examSkinInputController.setSkinUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examSkinInputController.formCount;	
				examSkinInputController.setSkinUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
