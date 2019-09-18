package com.ets.controller.gui.emrCharting.result.radiology;

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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class MriReportInputController implements Initializable {
	
	 @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea findingsTextarea;

    @FXML
    private RadioButton leftradio;

    @FXML
    private ToggleGroup lr;

    @FXML
    private RadioButton rightRadio;

    @FXML
    private RadioButton BodyLNRadio;

    @FXML
    private ToggleGroup Body;

    @FXML
    private RadioButton Bodycervicalradio;

    @FXML
    private RadioButton BodyThoracicRadio;

    @FXML
    private RadioButton BodyChestradio;

    @FXML
    private RadioButton BodyPelvisradio;

    @FXML
    private RadioButton BodyShoulderRadio;

    @FXML
    private RadioButton BodyArmradio;

    @FXML
    private RadioButton BodyElbowRadio;

    @FXML
    private RadioButton BodyWristradio;

    @FXML
    private RadioButton BodyHandRadio;

    @FXML
    private RadioButton BodyLegRadio;

    @FXML
    private RadioButton BodyKneeRadio;

    @FXML
    private RadioButton ReadingNormalRadio;

    @FXML
    private ToggleGroup Reading;

    @FXML
    private RadioButton ReadingAbnormalRadio;
    
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

			

			if (leftradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("MRI of left");
				resultInputController.str = str1.toString();

			}if (rightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("MRI of right");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			if (BodyArmradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("arm states.");
				resultInputController.str = str1.toString();

			}if (Bodycervicalradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("cervical spine states.");
				resultInputController.str = str1.toString();
				
			}if (BodyChestradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("chest states.");
				resultInputController.str = str1.toString();

			}if (BodyElbowRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("elbow states.");
				resultInputController.str = str1.toString();
				
			}if (BodyHandRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("hand states.");
				resultInputController.str = str1.toString();

			}if (BodyKneeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("knee states.");
				resultInputController.str = str1.toString();
				
			}if (BodyLegRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("leg states.");
				resultInputController.str = str1.toString();

			}if (BodyLNRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("L-S spine states.");
				resultInputController.str = str1.toString();
				
			}if (BodyPelvisradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pelvis and hip states.");
				resultInputController.str = str1.toString();

			}if (BodyShoulderRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("shoulder states.");
				resultInputController.str = str1.toString();
				
			}if (BodyThoracicRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("thoracic spine states.");
				resultInputController.str = str1.toString();

			}if (BodyWristradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("wrist states.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (ReadingNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("states normal study.");
				resultInputController.str = str1.toString();

			}if (ReadingAbnormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("states abnormal study.");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (findingsTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Findings: " +findingsTextarea.getText() +".");
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
