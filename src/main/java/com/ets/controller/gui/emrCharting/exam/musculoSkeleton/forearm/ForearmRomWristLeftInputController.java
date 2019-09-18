package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ForearmRomWristLeftInputController Class
 *Description: ForearmROMWristLeft.fxml Controller class
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ForearmRomWristLeftInputController implements Initializable{
	
	 	@FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField flexionText;

	    @FXML
	    private TextField extensionText;

	    @FXML
	    private TextField radialText;

	    @FXML
	    private Label FlexionKneeText;

	    @FXML
	    private TextField ulnarText;
	    
	    private ExamMusculotoneForearmInputController examMusculotoneForearmInputController;

	   	public void setExamMusculotoneForearmInputController(
	   			ExamMusculotoneForearmInputController examMusculotoneForearmInputController) {
	   		this.examMusculotoneForearmInputController = examMusculotoneForearmInputController;
	   	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneForearmInputController.str);
			examComp.append("\n\nRANGE OF MOTION: ");
			examMusculotoneForearmInputController.str = examComp.toString();
			
			
			
			if (flexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nLeft Wrist: Flexion "+flexionText.getText()+" degrees (NL-90 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			
			if (extensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nLeft Wrist: Extension "+extensionText.getText()+" degrees (NL-70 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			
			if (radialText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nLeft Wrist: Radial Deviation "+radialText.getText()+" degrees (NL-20 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			if (ulnarText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nLeft Wrist: Ulnar Deviation "+ulnarText.getText()+" degrees (NL-55 degrees).");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			
			

			++examMusculotoneForearmInputController.formCount;
			examMusculotoneForearmInputController.setForearmUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneForearmInputController.formCount;
				examMusculotoneForearmInputController.setForearmUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
