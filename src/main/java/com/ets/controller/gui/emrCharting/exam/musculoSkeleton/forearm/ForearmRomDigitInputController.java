package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ForearmRomDigitInputController Class
 *Description: ForearmRomDigits.fxml Controller class
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

public class ForearmRomDigitInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField MCPflexionText;

    @FXML
    private TextField MCPextensionText;

    @FXML
    private TextField PIPFlexionText;

    @FXML
    private TextField PIPExtensionText;

    @FXML
    private TextField DIPFlexionText;

    @FXML
    private TextField DIPExtensionText;
    
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
			
			
			
			if (MCPflexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nDigit: MCP Flexion "+MCPflexionText.getText()+" degrees (NL-90 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
				
			
			
			
			if (MCPextensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nDigit: MCP Extension "+MCPextensionText.getText()+" degrees (NL-5 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			
			if (PIPFlexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nDigit: PIP Flexion "+PIPFlexionText.getText()+" degrees (NL-110 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			if (PIPExtensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nDigit: PIP Extension "+PIPExtensionText.getText()+" degrees (NL-5 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
			
			

			if (DIPFlexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nDigit: DIP Flexion "+DIPFlexionText.getText()+" degrees (NL-60 degrees)");
				examMusculotoneForearmInputController.str = str1.toString();

			}
			
						

			if (DIPExtensionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("\nDigit: DIP Extension "+DIPExtensionText.getText()+" degrees (NL-5 degrees).");
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
