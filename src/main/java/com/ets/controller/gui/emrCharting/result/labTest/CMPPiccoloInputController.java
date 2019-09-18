package com.ets.controller.gui.emrCharting.result.labTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class CMPPiccoloInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField naText;

    @FXML
    private TextField kText;

    @FXML
    private TextField tc02Text;

    @FXML
    private TextField clText;

    @FXML
    private TextField gluText;

    @FXML
    private TextField caText;

    @FXML
    private TextField bunText;

    @FXML
    private TextField creText;

    @FXML
    private TextField alpText;

    @FXML
    private TextField altText;

    @FXML
    private TextField astText;

    @FXML
    private TextField tbilText;

    @FXML
    private TextField albText;

    @FXML
    private TextField tpText;
    
    private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder resultStr = new StringBuilder(resultInputController.str);
			resultStr.append("\n\nCMP (Comprehensive Metabolic) Lab Results: \n----------------------------------------------------------");
			resultInputController.str = resultStr.toString();

			
			
			if (naText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nNA+ : " +naText.getText() +"    Normal Range: 128 - 145 MMOL/L.");
				resultInputController.str = str1.toString();

			}
			
			if (kText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nK+: " +kText.getText() +"   Normal Range: 3.6 - 5.1 MMOL/L.");
				resultInputController.str = str1.toString();

			}
			
				
				 
				 
			if (tc02Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTC02: " +tc02Text.getText() +"     Normal Range: 18 - 33 MMOL/L.");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (clText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n CL-: " +clText.getText() +"    Normal Range: 98 - 108 MMOL/L.");
				resultInputController.str = str1.toString();

			}
			
			
			if (gluText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nGLU: " +gluText.getText() +"    Normal Range: 73 - 118 MG/DL.");
				resultInputController.str = str1.toString();

			}
			
			if (caText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nCA: " +caText.getText() +"      Normal Range: 98 - 108 MMOL/L.");
				resultInputController.str = str1.toString();

			}
			
			if (bunText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nBUN: " +bunText.getText() +"        Normal Range: 7 - 22 MG/DL.");
				resultInputController.str = str1.toString();

			}
			
			
			 
			
			if (creText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nCRE: " +creText.getText() +"     Normal Range: 0.6 - 1.2 MG/DL.");
				resultInputController.str = str1.toString();

			}
			
			
			if (alpText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nALP: " +alpText.getText() +"     Normal Range: 42 - 141 U/L.");
				resultInputController.str = str1.toString();

			}
			
			if (altText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nALT: " +altText.getText() +"     Normal Range: 10 - 47 U/L.");
				resultInputController.str = str1.toString();

			}
			
			if (astText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nAST: " +astText.getText() +"    Normal Range: 11 - 38 U/L.");
				resultInputController.str = str1.toString();

			}
			
			
			if (tbilText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTBIL : " +tbilText.getText() +"     Normal Range: 0.2 - 1.6 MG/DL.");
				resultInputController.str = str1.toString();

			}
			
			if (albText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nALB: " +albText.getText() +"     Normal Range: 3.3 - 5.5 G/DL.");
				resultInputController.str = str1.toString();

			}
			
			if (tpText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nTP: " +tpText.getText() +"      Normal Range: 16.4 - 8.1 G/DL.");
				resultInputController.str = str1.toString();

			}


			

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++resultInputController.formCount;
				resultInputController.setResUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
