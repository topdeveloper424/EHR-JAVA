package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AudiometryResultsInputController implements Initializable {

	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private TextField left500Text;

	    @FXML
	    private TextField left1000Text;

	    @FXML
	    private TextField left2000Text;

	    @FXML
	    private TextField left3000Text;

	    @FXML
	    private TextField left4000Text;

	    @FXML
	    private TextField left6000Text;

	    @FXML
	    private TextField left8000Text;

	    @FXML
	    private TextField right500Text;

	    @FXML
	    private TextField right1000Text;

	    @FXML
	    private TextField right2000Text;

	    @FXML
	    private TextField right3000Text;

	    @FXML
	    private TextField right4000Text;

	    @FXML
	    private TextField right6000Text;

	    @FXML
	    private TextField right8000Text;
	    
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder resultStr = new StringBuilder(resultInputController.str);
			resultStr.append("\n\nAudiometry Results: ");
			resultInputController.str = resultStr.toString();

		

			
			
			
			if (left1000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +left1000Text.getText() +" dB     Left Ear- 1000 Hz.");
				resultInputController.str = str1.toString();

			}
			
				
			if (left2000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +left2000Text.getText() +" dB     Left Ear- 2000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			if (left3000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +left3000Text.getText() +" dB     Left Ear- 3000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (left4000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +left4000Text.getText() +" dB     Left Ear- 4000 Hz.");
				resultInputController.str = str1.toString();

			}
			 
			 
			 
			
			if (left500Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +left500Text.getText() +" dB     Left Ear- 500Hz.");
				resultInputController.str = str1.toString();

			}
			
			if (left6000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +left6000Text.getText() +" dB     Left Ear- 6000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			if (left8000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +left8000Text.getText() +" dB     Left Ear- 8000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (right1000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(right1000Text.getText() +" dB     Right Ear- 1000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			
			if (right2000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +right2000Text.getText() +" dB     Right Ear- 2000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			if (right3000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +right3000Text.getText() +" dB     Right Ear- 3000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			
			if (right4000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +right4000Text.getText() +" dB     Right Ear- 4000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			
			
			if (right500Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +right500Text.getText() +" dB     Right Ear- 500 Hz.");
				resultInputController.str = str1.toString();

			}
			
			if (right6000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +right6000Text.getText() +" dB     Right Ear- 6000 Hz.");
				resultInputController.str = str1.toString();

			}
			
			if (right8000Text.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +right8000Text.getText() +" dB     Right Ear- 8000 Hz.");
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
