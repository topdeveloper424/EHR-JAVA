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

public class PTEvaluationInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;
	
	  @FXML
	    private RadioButton flexActive25Radio;

	    @FXML
	    private ToggleGroup Leukocytes;

	    @FXML
	    private RadioButton flexActive50Radio;

	    @FXML
	    private RadioButton flexActive100Radio;

	    @FXML
	    private RadioButton flexActive75Radio;

	    @FXML
	    private RadioButton flexPassive25Radio;

	    @FXML
	    private ToggleGroup Nitrite;

	    @FXML
	    private RadioButton flexPassive50Radio;

	    @FXML
	    private RadioButton flexPassive75Radio;

	    @FXML
	    private RadioButton flexPassive100radio;

	    @FXML
	    private RadioButton flexStrength15Radio;

	    @FXML
	    private ToggleGroup Protein;

	    @FXML
	    private RadioButton flexStrength35Radio;

	    @FXML
	    private RadioButton flexStrength45radio;

	    @FXML
	    private RadioButton flexStrength25Radio;

	    @FXML
	    private RadioButton flexStrength55Radio;

	    @FXML
	    private RadioButton extensionActive25Radio;

	    @FXML
	    private ToggleGroup ph;

	    @FXML
	    private RadioButton extensionActive50Radio;

	    @FXML
	    private RadioButton extensionActive75Radio;

	    @FXML
	    private RadioButton extensionActive100Radio;

	    @FXML
	    private RadioButton extensionPasive25Radio;

	    @FXML
	    private ToggleGroup Blood;

	    @FXML
	    private RadioButton extensionPasive50Radio;

	    @FXML
	    private RadioButton extensionPasive75radio;

	    @FXML
	    private RadioButton extensionPasive100Radio;

	    @FXML
	    private RadioButton extensionStrength15Radio;

	    @FXML
	    private ToggleGroup Gravity;

	    @FXML
	    private RadioButton extensionStrength25Radio;

	    @FXML
	    private RadioButton extensionStrength35Radio;

	    @FXML
	    private RadioButton extensionStrength45Radio;

	    @FXML
	    private RadioButton extensionStrength55Radio;
	
	
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

			
			if (flexActive100Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Active = 100 %");
				resultInputController.str = str1.toString();
				
			}if (flexActive25Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Active = 25 %");
				resultInputController.str = str1.toString();

			}if (flexActive50Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Active = 50 %");
				resultInputController.str = str1.toString();

			}if (flexActive75Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Active = 75 %");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (flexPassive100radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Passive = 100 %. ");
				resultInputController.str = str1.toString();
				
			}if (flexPassive25Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Passive = 25 %. ");
				resultInputController.str = str1.toString();

			}if (flexPassive50Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Passive = 50 %. ");
				resultInputController.str = str1.toString();

			}if (flexPassive75Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Passive = 75 %. ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if (flexStrength15Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Strength = 1/5.");
				resultInputController.str = str1.toString();
				
			}if (flexStrength25Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Strength = 2/5.");
				resultInputController.str = str1.toString();

			}if (flexStrength35Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Strength = 3/5.");
				resultInputController.str = str1.toString();

			}if (flexStrength45radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Strength = 4/5.");
				resultInputController.str = str1.toString();
				
			}if (flexStrength55Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Flex L1/2/3 Strength = 5/5.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			if (extensionActive100Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Active = 100 %.");
				resultInputController.str = str1.toString();
				
			}if (extensionActive25Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Active = 25 %.");
				resultInputController.str = str1.toString();

			}if (extensionActive50Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Active = 50 %.");
				resultInputController.str = str1.toString();

			}if (extensionActive75Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Active = 75 %.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if (extensionPasive100Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Passive = 100 %.");
				resultInputController.str = str1.toString();
				
			}if (extensionPasive25Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Passive = 25 %.");
				resultInputController.str = str1.toString();

			}if (extensionPasive50Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Passive = 50 %.");
				resultInputController.str = str1.toString();

			}if (extensionPasive75radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Passive = 75 %.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if (extensionStrength15Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Strength = 1/5.");
				resultInputController.str = str1.toString();
				
			}if (extensionStrength25Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Strength = 2/5.");
				resultInputController.str = str1.toString();
				
			}if (extensionStrength35Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Strength = 3/5.");
				resultInputController.str = str1.toString();

			}if (extensionStrength45Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Strength = 4/5.");
				resultInputController.str = str1.toString();

			}if (extensionStrength55Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Hip Extension L5/S1-2 Strength = 5/5.");
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
