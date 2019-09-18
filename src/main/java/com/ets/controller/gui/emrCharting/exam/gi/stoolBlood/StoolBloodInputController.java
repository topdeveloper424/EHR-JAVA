package com.ets.controller.gui.emrCharting.exam.gi.stoolBlood;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StoolBloodInputController Class
 *Description: stoolBlood.fxml Controller class
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

import com.ets.controller.gui.emrCharting.exam.gi.ExamGIinputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class StoolBloodInputController implements Initializable {
	
		@FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox normalCkeckBox;

	    @FXML
	    private CheckBox exhibitedCheckBox;

	    @FXML
	    private CheckBox negativeOccultCheckBox;

	    @FXML
	    private CheckBox melanoticCheckBox;

	    @FXML
	    private CheckBox possitiveOccultCheckBox;

	    @FXML
	    private CheckBox includeCheckBox;


	private ExamGIinputController examGIinputController;
	
	public void setExamGIinputController(ExamGIinputController examGIinputController) {
		this.examGIinputController = examGIinputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examBasic = new StringBuilder(examGIinputController.str);
			examBasic.append("\n\nGI & ABDOMEN: ");
			examGIinputController.str = examBasic.toString();
			
			
			if (normalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Stool sample was negative for occult blood. ");
				examGIinputController.str = str1.toString();
				
			}if(negativeOccultCheckBox.isSelected() || possitiveOccultCheckBox.isSelected() ||
					exhibitedCheckBox.isSelected() || melanoticCheckBox.isSelected()  ){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Stool sample was tested for occult blood : ");
				examGIinputController.str = str1.toString();
				
			}if (negativeOccultCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("negative for occult blood, ");
				examGIinputController.str = str1.toString();
				
			}if (possitiveOccultCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("positive for occult blood, ");
				examGIinputController.str = str1.toString();
				
			}if (exhibitedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("exhibited frank blood, ");
				examGIinputController.str = str1.toString();
				  
			} if (melanoticCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("melanotic. ");
				examGIinputController.str = str1.toString();
				
			} if (includeCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Stool sample was not tested for occult blood. ");
				examGIinputController.str = str1.toString();
				
			}
			
			
			++examGIinputController.formCount;	
			examGIinputController.setGIUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examGIinputController.formCount;	
				examGIinputController.setGIUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
}




