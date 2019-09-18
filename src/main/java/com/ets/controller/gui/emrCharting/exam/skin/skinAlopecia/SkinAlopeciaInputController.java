package com.ets.controller.gui.emrCharting.exam.skin.skinAlopecia;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkinAlopeciaInputController Class
 *Description: skinAlopecia.fxml GUI Controller class
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

public class SkinAlopeciaInputController implements Initializable {
	
    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

   
    @FXML
    private CheckBox brokenCheck;

	@FXML
	private CheckBox NovisibleCheck;

	@FXML
	private CheckBox illuminatesCheck;

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

			if (brokenCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" broken shafts of hair,");
				examSkinInputController.str = str1.toString();

			}
			if (illuminatesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" illuminates with a woods lamp ,");
				examSkinInputController.str = str1.toString();

			}
			if (NovisibleCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" no visible hair ,");
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
