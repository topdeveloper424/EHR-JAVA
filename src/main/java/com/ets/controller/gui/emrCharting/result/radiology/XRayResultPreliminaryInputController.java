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

public class XRayResultPreliminaryInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextArea freeFormTextarea;

    @FXML
    private RadioButton noacuteradio;

    @FXML
    private ToggleGroup preli;

    @FXML
    private RadioButton abnormalRadio;

    @FXML
    private RadioButton questationableRadio;

    @FXML
    private RadioButton otherradio;

    @FXML
    private CheckBox fractureCheck;

    @FXML
    private CheckBox fractureTibialCheck;

    @FXML
    private CheckBox fracturePatellaCheck;

    @FXML
    private CheckBox effusionCheck;

    @FXML
    private CheckBox effusionKneeJointCheck;

    @FXML
    private CheckBox degenerativeCheck;

    @FXML
    private CheckBox dislocationCheck;
    
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
			
			
			if (noacuteradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("X-ray Results: Preliminary reading of x-ray shows no acute, detectable abnormalities. ");
				resultInputController.str = str1.toString();

			}if (abnormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("X-ray Results: Preliminary reading of x-ray shows abnormal.");
				resultInputController.str = str1.toString();
				
			}if (questationableRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("X-ray Results: Preliminary reading of x-ray shows questionable abnormality.");
				resultInputController.str = str1.toString();

			}if (otherradio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("X-ray Results: Preliminary reading of x-ray shows other. ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			if (fractureCheck.isSelected() || fracturePatellaCheck.isSelected()
					|| effusionKneeJointCheck.isSelected() || dislocationCheck.isSelected()
					|| fractureTibialCheck.isSelected() || effusionCheck.isSelected()
					|| degenerativeCheck.isSelected()) {

				StringBuilder str = new StringBuilder(resultInputController.str);
				str.append("Possible ");
				resultInputController.str = str.toString();
				
				if (fractureCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("fracture, ");
					resultInputController.str = str1.toString();
					
				}if (fracturePatellaCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("fracture of the patella, ");
					resultInputController.str = str1.toString();
					
				}if (effusionKneeJointCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("effusion of the knee joint, ");
					resultInputController.str = str1.toString();

				}if (dislocationCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("dislocation, ");
					resultInputController.str = str1.toString();
					
				}if (fractureTibialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("fracture at the tibial plateau, ");
					resultInputController.str = str1.toString();

				}if (effusionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("effusion, ");
					resultInputController.str = str1.toString();

				}if (degenerativeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("degenerative changes, ");
					resultInputController.str = str1.toString();
					
				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			if (freeFormTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(freeFormTextarea.getText() +".");
				resultInputController.str = str1.toString();

			}

			StringBuilder str1 = new StringBuilder(resultInputController.str);
			str1.append("Patient was advised about possibility of occult fracture nonetheless and counseled about follow-up care.");
			resultInputController.str = str1.toString();
			

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