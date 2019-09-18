package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.back;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 21-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BackRibThoracicInputController Class
 *Description: backRibROMThoracic.fxml Controller class
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
import javafx.scene.control.TextField;

public class BackRibThoracicInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField flexionText;

    @FXML
    private TextField rightLateralText;

    @FXML
    private TextField LeftLateralText;
    
    private ExamMusculotoneBackController examMusculotoneBackController;

	public void setExamMusculotoneBackController(ExamMusculotoneBackController examMusculotoneBackController) {
		this.examMusculotoneBackController = examMusculotoneBackController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneBackController.str);
			examComp.append("\n\n: ");
			examMusculotoneBackController.str = examComp.toString();
			
			
			
			if (flexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("\nL/S-Spine: Flexion " +flexionText.getText()+" degrees (NL- 90 degrees)");
				examMusculotoneBackController.str = str1.toString();

			}
			
			
			
			
			
			if (rightLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("\nL/S Spine: Right Lateral Flexion  " +rightLateralText.getText()+ "degrees (NL- 20 degrees)");
				examMusculotoneBackController.str = str1.toString();

			}
			
			
			
			if (LeftLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("\nL/S-Spine: Left Lateral Flexion  " +LeftLateralText.getText()+ "degrees (NL- 20 degrees).");
				examMusculotoneBackController.str = str1.toString();

			}
			
			
			
			
			
			

			++examMusculotoneBackController.formCount;
			examMusculotoneBackController.setBackUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneBackController.formCount;
				examMusculotoneBackController.setBackUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
