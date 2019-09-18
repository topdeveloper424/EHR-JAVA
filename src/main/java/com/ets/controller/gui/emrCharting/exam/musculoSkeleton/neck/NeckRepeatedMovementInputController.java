package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck;

/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckRepeatedMovementInputController Class
 *Description: neckRepeatedMovement.fxml Controller class
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class NeckRepeatedMovementInputController implements Initializable{
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private RadioButton negativeRadio;

	    @FXML
	    private RadioButton possitiveRadio;
	    
	    private ExamMusculotoneNeckInputController examMusculotoneNeckInputController;

		public void setExamMusculotoneNeckInputController(
				ExamMusculotoneNeckInputController examMusculotoneNeckInputController) {
			this.examMusculotoneNeckInputController = examMusculotoneNeckInputController;
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneNeckInputController.str);
			examComp.append("\n\n ");
			examMusculotoneNeckInputController.str = examComp.toString();

			

			
			if (negativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
				str1.append("Repeated movement negative.");
				examMusculotoneNeckInputController.str = str1.toString();

			}
			
			if (possitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
				str1.append("Repeated movement possitive.");
				examMusculotoneNeckInputController.str = str1.toString();

			}
			

			++examMusculotoneNeckInputController.formCount;
			examMusculotoneNeckInputController.setNeckUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneNeckInputController.formCount;
				examMusculotoneNeckInputController.setNeckUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
