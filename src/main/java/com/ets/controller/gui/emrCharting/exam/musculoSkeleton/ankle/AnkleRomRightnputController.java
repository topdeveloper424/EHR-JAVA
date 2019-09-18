package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.ankle;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 14-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AnkleRomRightnputController Class
 *Description: ankleFootSpecialTestRight.fxml Controller class
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AnkleRomRightnputController implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField dorsiflexionText;

	    @FXML
	    private TextField planterText;

	    @FXML
	    private TextField inversionText;

	    @FXML
	    private TextField eversionText;
	    
	    
	    private ExamMusculotoneAnkleInputController examMusculotoneAnkleInputController;

		public void setExamMusculotoneAnkleInputController(
				ExamMusculotoneAnkleInputController examMusculotoneAnkleInputController) {
			this.examMusculotoneAnkleInputController = examMusculotoneAnkleInputController;
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneAnkleInputController.str);
			examComp.append("\n\n:RANGE OF MOTION: ");
			examMusculotoneAnkleInputController.str = examComp.toString();
			
			
			
			if (dorsiflexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("\nRight Ankle: Dorsiflexion "+dorsiflexionText.getText()+" degrees (NL-20 degrees)");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			if (planterText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("\nRight Ankle: Plantar Flexion "+planterText.getText()+" degrees (NL-45 degrees)");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			if (inversionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("\nRight Ankle: Inversion "+inversionText.getText()+" degrees (NL-30 degrees)");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			
			if (eversionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("\nRight Ankle: Eversion "+eversionText.getText()+" degrees (NL-20 degrees).");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			
			

			++examMusculotoneAnkleInputController.formCount;
			examMusculotoneAnkleInputController.setAnkleUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneAnkleInputController.formCount;
				examMusculotoneAnkleInputController.setAnkleUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
