package com.ets.controller.gui.emrCharting.exam.gi.hernia;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of GiHerniaInputController Class
 *Description: hernias.fxml Controller class
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

public class GiHerniaInputController implements Initializable{

	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox normalCkeckBox;

	    @FXML
	    private CheckBox noneCheckBox;

	    @FXML
	    private CheckBox leftCheckBox;

	    @FXML
	    private CheckBox rightCheckBox;

	    @FXML
	    private CheckBox umbilicalCheckBox;

	    @FXML
	    private CheckBox ventralCheckBox;


	private ExamGIinputController examGIinputController;
	
	public void setExamGIinputController(ExamGIinputController examGIinputController) {
		this.examGIinputController = examGIinputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			StringBuilder hernia = new StringBuilder(examGIinputController.str);
			hernia.append("\n\nGI & ABDOMEN: ");
			examGIinputController.str = hernia.toString();
			
			if (normalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("No hernias noted. ");
				examGIinputController.str = str1.toString();
				
			}if(noneCheckBox.isSelected() || ventralCheckBox.isSelected() || leftCheckBox.isSelected() || rightCheckBox.isSelected() || umbilicalCheckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Hernias: ");
				examGIinputController.str = str1.toString();
				
			}if (noneCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("none noted. ");
				examGIinputController.str = str1.toString();
				
			} if (ventralCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("ventral, ");
				examGIinputController.str = str1.toString();
				
			} if (leftCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("left inguinal, ");
				examGIinputController.str = str1.toString();
				
			} if (rightCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append(" right inguinal, ");
				examGIinputController.str = str1.toString();
				
			} if (umbilicalCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("umbilical, ");
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



