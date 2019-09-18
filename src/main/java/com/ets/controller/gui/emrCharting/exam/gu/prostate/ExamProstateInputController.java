package com.ets.controller.gui.emrCharting.exam.gu.prostate;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamProstateInputController Class
 *Description: prostate.fxml Controller class
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

public class ExamProstateInputController implements Initializable{
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox prostatenormalCkeckBox;

    @FXML
    private CheckBox smoothCheck;

    @FXML
    private CheckBox nodularCheck;

    @FXML
    private CheckBox hardCheck;

    @FXML
    private CheckBox boggyCheck;

    @FXML
    private CheckBox asymmetricCheck;

    @FXML
    private CheckBox nonTenderCheck;

    @FXML
    private CheckBox enlargedCheck;

    @FXML
    private CheckBox tenderCheck;

    @FXML
    private CheckBox massessWithoutMassCheck;

    @FXML
    private CheckBox massesWithmassCheck;

    @FXML
    private CheckBox prostateincludeCheck;

	private GUInputController guInputController;


	public void setGuInputController(GUInputController guInputController) {
		this.guInputController = guInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event)->
		{
			StringBuilder hernia = new StringBuilder(guInputController.str);
			hernia.append("\n\n ");
			guInputController.str = hernia.toString();
			
		if (prostatenormalCkeckBox.isSelected()) {
			
			StringBuilder prosNormal = new StringBuilder(guInputController.str);
			prosNormal.append("Prostate exam reveals prostate normal and without masses. ");
			guInputController.str = prosNormal.toString();
			
		}if(smoothCheck.isSelected() || hardCheck.isSelected() || asymmetricCheck.isSelected() || nonTenderCheck.isSelected() 
				|| nodularCheck.isSelected()|| boggyCheck.isSelected()|| enlargedCheck.isSelected()
				||tenderCheck.isSelected()){
			
			StringBuilder prosExamCommonText = new StringBuilder(guInputController.str);
			prosExamCommonText.append("Examination reveals ");
			guInputController.str = prosExamCommonText.toString();
			
		}if(smoothCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("smooth, ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(hardCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append(" hard,  ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(asymmetricCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("asymmetric, ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(nonTenderCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("nontender, ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(nodularCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("nodular,  ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(boggyCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("boggy,  ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(enlargedCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("enlarged,  ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(tenderCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("tender prostate, ");
			guInputController.str = prosExamOtherText.toString();
			
		}


      if(massessWithoutMassCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("Without masses. ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(massesWithmassCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("with mass palpable. ");
			guInputController.str = prosExamOtherText.toString();
			
		}
      if(prostateincludeCheck.isSelected()) {
			
			StringBuilder prosExamOtherText = new StringBuilder(guInputController.str);
			prosExamOtherText.append("Patient declined prostate exam. ");
			guInputController.str = prosExamOtherText.toString();
			
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
