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
import javafx.scene.control.ToggleGroup;;

public class AudioHearingInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;
	    
	  @FXML
	    private CheckBox asNormalChexk;

	    @FXML
	    private CheckBox asMildCheck;

	    @FXML
	    private CheckBox asModerateCheck;

	    @FXML
	    private CheckBox asModCheck;

	    @FXML
	    private CheckBox asSevereCheck;

	    @FXML
	    private CheckBox asProfoundCheck;

	    @FXML
	    private CheckBox adNormalChexk;

	    @FXML
	    private CheckBox adMildCheck;

	    @FXML
	    private CheckBox adModerateCheck;

	    @FXML
	    private CheckBox adModCheck;

	    @FXML
	    private CheckBox adSevereCheck;

	    @FXML
	    private CheckBox adProfoundCheck;
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\nAudio/Hearing results: ");
			resultInputController.str = procedureStr.toString();

			

			if (asNormalChexk.isSelected() || asMildCheck.isSelected()
					|| asModerateCheck.isSelected() || asModCheck.isSelected()
					|| asSevereCheck.isSelected() || asProfoundCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("\n");
				resultInputController.str = str.toString();
				
				if (asNormalChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("normal hearing (0-25 dB), ");
					resultInputController.str = str1.toString();
					
				}if (asMildCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("mild loss (26-40 dB), ");
					resultInputController.str = str1.toString();

				}if (asModerateCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" moderate loss (41-55 dB), ");
					resultInputController.str = str1.toString();

				}if (asModCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("mod.severe loss (56-70 dB),  ");
					resultInputController.str = str1.toString();
					
				}if (asSevereCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("severe loss (71-90 dB), ");
					resultInputController.str = str1.toString();

				}if (asProfoundCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("profound loss (91+ dB), ");
					resultInputController.str = str1.toString();

				} 
				
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("in AS- Left Ear.");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			if (adNormalChexk.isSelected() || adMildCheck.isSelected()
					|| adModCheck.isSelected() || adModerateCheck.isSelected()
					|| adProfoundCheck.isSelected() || adSevereCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("\n");
				resultInputController.str = str.toString();
				
				if (adMildCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("mild loss (26-40 dB), ");
					resultInputController.str = str1.toString();
					
				}if (adModCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("moderately severe loss (56-70 dB), ");
					resultInputController.str = str1.toString();

				}if (adModerateCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("moderate loss (41-55 dB), ");
					resultInputController.str = str1.toString();

				}if (adNormalChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" normal hearing (0-25 dB), ");
					resultInputController.str = str1.toString();
					
				}if (adProfoundCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("profound loss (91+ dB), ");
					resultInputController.str = str1.toString();

				}if (adSevereCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("severe loss (71-90 dB), ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("in AD (right ear).");
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
