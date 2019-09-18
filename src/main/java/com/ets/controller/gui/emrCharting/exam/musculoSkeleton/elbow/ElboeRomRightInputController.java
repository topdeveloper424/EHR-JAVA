package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.elbow;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ElboeRomRightInputController Class
 *Description: ElbowROMRight GUI Controller class
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
public class ElboeRomRightInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField flexionText;

    @FXML
    private TextField extensionText;

    @FXML
    private TextField supinationText;

    @FXML
    private Label FlexionKneeText;

    @FXML
    private TextField pronationText;
    
    private ExamMusculotoneElbowInputController examMusculotoneElbowInputController;

	public void setExamMusculotoneElbowInputController(
			ExamMusculotoneElbowInputController examMusculotoneElbowInputController) {
		this.examMusculotoneElbowInputController = examMusculotoneElbowInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneElbowInputController.str);
			examComp.append("\n\nRANGE OF MOTION: ");
			examMusculotoneElbowInputController.str = examComp.toString();
			
			
			
			if (flexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Right Elbow: Flexion "+flexionText.getText()+" degrees (NL-160 degrees)");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			
			
			if (extensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Right Elbow: Extension "+extensionText.getText()+"degrees (NL-5 degrees)");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			
			if (supinationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Right Elbow: Supination "+supinationText.getText()+" degrees (NL-90 degrees)");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			if (pronationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneElbowInputController.str);
				str1.append("Right Elbow: Pronation "+pronationText.getText()+" degrees (NL-90 degrees).");
				examMusculotoneElbowInputController.str = str1.toString();

			}
			
			
			
			

			++examMusculotoneElbowInputController.formCount;
			examMusculotoneElbowInputController.setElbowUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneElbowInputController.formCount;
				examMusculotoneElbowInputController.setElbowUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
