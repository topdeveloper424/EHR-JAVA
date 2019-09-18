package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class VisualAcuityResultsInputController implements Initializable {
	
	   @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField farLeftText;

	    @FXML
	    private TextField farRightText;

	    @FXML
	    private TextField farBothText;

	    @FXML
	    private TextField nearLeftText;

	    @FXML
	    private TextField nearRightText;

	    @FXML
	    private TextField nearBothText;

	    @FXML
	    private TextField correctedFarLeftText;

	    @FXML
	    private TextField correctedFarRightText;

	    @FXML
	    private TextField correctedFarBothText;

	    @FXML
	    private TextField correctedNearLeftText;

	    @FXML
	    private TextField correctedNearRightText;

	    @FXML
	    private TextField correctedNearBothText;
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			StringBuilder str12 = new StringBuilder(resultInputController.str);
			str12.append("Uncorrected Far: \n ");
			resultInputController.str = str12.toString();
			if (farBothText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" OU  20/ "+farBothText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (farLeftText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OS  20/"+farLeftText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (farRightText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OD  20/ "+farRightText.getText() +".");
				resultInputController.str = str1.toString();

			}




		      StringBuilder str55 = new StringBuilder(resultInputController.str);
		      str55.append(" \n Uncorrected Near:");
		      resultInputController.str = str55.toString();
			if (nearBothText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OU 20/"+nearBothText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			if (nearLeftText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OS 20/"+nearLeftText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (nearRightText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n OD  20/"+nearRightText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			  StringBuilder str33 = new StringBuilder(resultInputController.str);
		      str33.append("\n Corrected Far:");
		      resultInputController.str = str33.toString();
			
			if (correctedFarBothText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OU  20/ "+correctedFarBothText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (correctedFarLeftText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n OS  20/ "+correctedFarLeftText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			if (correctedFarRightText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OD  20/"+correctedFarRightText.getText() +".");
				resultInputController.str = str1.toString();

			}
			StringBuilder str7 = new StringBuilder(resultInputController.str);
			str7.append("\n Corrected Near:"+correctedFarRightText.getText() +".");
			resultInputController.str = str7.toString();

			
			
			if (correctedNearBothText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n OU  20/  "+correctedNearBothText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			if (correctedNearLeftText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OS  20/"+correctedNearLeftText.getText() +".");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (correctedNearRightText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n  OD  20/"+correctedNearRightText.getText() +".");
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
