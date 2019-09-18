package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ForearmSpecialTestRightInputController Class
 *Description: ForearmSpecialTestLeft.fxml Controller class
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
import javafx.scene.control.ToggleGroup;

public class ForearmSpecialTestRightInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private Label FlexionKneeText;

    @FXML
    private RadioButton Finkelsteinpositive;

    @FXML
    private ToggleGroup fink;

    @FXML
    private RadioButton FinkelsteinNegative;

    @FXML
    private RadioButton Grindpositive1;

    @FXML
    private ToggleGroup grind;

    @FXML
    private RadioButton GrindNegative1;

    @FXML
    private RadioButton Mcpositive11;

    @FXML
    private ToggleGroup mcm;

    @FXML
    private RadioButton McNegative11;

    @FXML
    private RadioButton Phalenspositive;

    @FXML
    private ToggleGroup pha;

    @FXML
    private RadioButton PhalenNegative;

    @FXML
    private RadioButton Watsonpositive;

    @FXML
    private ToggleGroup wat;

    @FXML
    private RadioButton WatsonNegative;

    @FXML
    private RadioButton Tinelpositive;

    @FXML
    private ToggleGroup tine;

    @FXML
    private RadioButton TinelNegative;
    
    private ExamMusculotoneForearmInputController examMusculotoneForearmInputController;

	public void setExamMusculotoneForearmInputController(
			ExamMusculotoneForearmInputController examMusculotoneForearmInputController) {
		this.examMusculotoneForearmInputController = examMusculotoneForearmInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneForearmInputController.str);
			examComp.append("\n\nSPECIAL TESTS:\nRight wrist and hand - the following special tests were performed: ");
			examMusculotoneForearmInputController.str = examComp.toString();

			if (FinkelsteinNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Finkelstein's test negative.");
				examMusculotoneForearmInputController.str = str1.toString();

			}
				 
					  

			if (Finkelsteinpositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Finkelstein's test possitive.");
				examMusculotoneForearmInputController.str = str1.toString();

			}

			
			
			
			
			if (GrindNegative1.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Grind test negative. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			if (Grindpositive1.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Grind test possitive. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (McNegative11.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("McMurray's test negative. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			if (Mcpositive11.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("McMurray's test possitive. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}

			 
			
			
			
			
			
			
			if (PhalenNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Phalen's test negative. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}if (Phalenspositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Phalen's test possitive. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			
			
			
			if (Watsonpositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Watson's test possitive. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}if (WatsonNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Watson's test negative.");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			
			
			
			if (TinelNegative.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Tinel's sign test negative. ");
				examMusculotoneForearmInputController.str = str1.toString();

			}if (Tinelpositive.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Tinel's sign test possitive. ");
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
