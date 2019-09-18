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

public class JAMARGripTestInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField right1stText;

	    @FXML
	    private TextField right2ndText;

	    @FXML
	    private TextField right3rdText;

	    @FXML
	    private TextField left1stText;

	    @FXML
	    private TextField left2ndText;

	    @FXML
	    private TextField left3rdText;

	    @FXML
	    private RadioButton handRightRadio;

	    @FXML
	    private ToggleGroup hand;

	    @FXML
	    private RadioButton handLeftRadio;

	    @FXML
	    private RadioButton handAmbidextrousRadio;

	    @FXML
	    private RadioButton AffectedRightRadio;

	    @FXML
	    private ToggleGroup Affected;

	    @FXML
	    private RadioButton AffectedLeftRadio;

	    @FXML
	    private RadioButton AffectedBothRadio;
	
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			if (handRightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("JAMAR Results: Dominant Hand: Right.");
				resultInputController.str = str1.toString();

			}if (handAmbidextrousRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("JAMAR Results: Dominant Hand: Ambidextrous.");
				resultInputController.str = str1.toString();

			}if (handLeftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("JAMAR Results: Dominant Hand: Left.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (AffectedBothRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Affected Extremity(Ies): Both.");
				resultInputController.str = str1.toString();

			}if (AffectedLeftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Affected Extremity(Ies): Left.");
				resultInputController.str = str1.toString();

			}if (AffectedRightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Affected Extremity(Ies): Right.");
				resultInputController.str = str1.toString();

			}
			

			
			if (right1stText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nRight Extremity- " +right1stText.getText() +" psi (1st attempt).");
				resultInputController.str = str1.toString();

			}
			
			if (right2ndText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nRight Extremity- " +right2ndText.getText() +" psi (2nd attempt).");
				resultInputController.str = str1.toString();

			}
			
			if (right3rdText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nRight Extremity- " +right3rdText.getText() +" psi (3rd attempt).");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			if (left1stText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nLeft   Extremity- " +left1stText.getText() +" psi (1st attempt).");
				resultInputController.str = str1.toString();

			}
			
			
			if (left2ndText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nLeft   Extremity- " +left2ndText.getText() +" psi (2nd attempt).");
				resultInputController.str = str1.toString();

			}
			
			if (left3rdText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\nLeft   Extremity- " +left3rdText.getText() +" psi (3rd attempt).");
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
