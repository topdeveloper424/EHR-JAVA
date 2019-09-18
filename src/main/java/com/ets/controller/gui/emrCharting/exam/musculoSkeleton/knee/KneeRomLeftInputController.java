package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.knee;

/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 13-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of KneeRomLeftInputController Class
 *Description: kneeROMLeft.fxml Controller class
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

public class KneeRomLeftInputController implements Initializable{
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField flexionText;

    @FXML
    private TextField extensionText;

    @FXML
    private TextField hyperextensionText;
    
    private ExamMusculotoneKneeInputController examMusculotoneKneeInputController;

	public void setExamMusculotoneKneeInputController(
			ExamMusculotoneKneeInputController examMusculotoneKneeInputController) {
		this.examMusculotoneKneeInputController = examMusculotoneKneeInputController;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneKneeInputController.str);
			examComp.append("\n\nRANGE OF MOTION:");
			examMusculotoneKneeInputController.str = examComp.toString();
			
			
			
			if (flexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nLeft Knee: Flexion"+flexionText.getText()+" degrees (NL-130 degrees)");
				examMusculotoneKneeInputController.str = str1.toString();

			}
		
			if (extensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nLeft Knee: Extension"+extensionText.getText()+"degrees (NL-10 degrees)");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			if (hyperextensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nLeft Knee: Hyperextension"+hyperextensionText.getText()+" degrees (NL-15 degrees). ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			

			++examMusculotoneKneeInputController.formCount;
			examMusculotoneKneeInputController.setKneeUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneKneeInputController.formCount;
				examMusculotoneKneeInputController.setKneeUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
