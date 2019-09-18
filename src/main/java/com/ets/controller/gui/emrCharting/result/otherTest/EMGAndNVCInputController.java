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

public class EMGAndNVCInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;
	
	  @FXML
	    private CheckBox leftUpperlChexk;

	    @FXML
	    private CheckBox rightUpperCheck;

	    @FXML
	    private CheckBox bilateralUpperCheck;

	    @FXML
	    private CheckBox leftLowerCheck;

	    @FXML
	    private CheckBox rightLowerCheck;

	    @FXML
	    private CheckBox bilateralLowerCheck;

	    @FXML
	    private RadioButton emgNcvRadio;

	    @FXML
	    private ToggleGroup em;

	    @FXML
	    private RadioButton emgRadio;

	    @FXML
	    private RadioButton ncvRadio;

	    @FXML
	    private RadioButton normalradio;

	    @FXML
	    private ToggleGroup nor;

	    @FXML
	    private RadioButton abnormalRadio;

	    @FXML
	    private TextArea findText;
	
	
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

			
			
				
			
		 if (emgNcvRadio.isSelected()||emgRadio.isSelected()||ncvRadio.isSelected()){
			
			StringBuilder str11 = new StringBuilder(resultInputController.str);
			str11.append("The following report was reviewed by provider:");
			resultInputController.str = str11.toString();
			if (emgNcvRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("EMG/NCV report.");
				resultInputController.str = str1.toString();
				
			}if (emgRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("EMG report.");
				resultInputController.str = str1.toString();

			}if (ncvRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(" NCV report.");
				resultInputController.str = str1.toString();

			}
				}
			
	
				if (leftUpperlChexk.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Of left upper extremity,");
					resultInputController.str = str1.toString();
					
				}if (bilateralUpperCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" bilateral upper extremity,");
					resultInputController.str = str1.toString();

				}if (rightLowerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" right lower extremity,");
					resultInputController.str = str1.toString();

				}if (rightUpperCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" right upper extremity,");
					resultInputController.str = str1.toString();
					
				}if (leftLowerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("left lower extremity,");
					resultInputController.str = str1.toString();

				}if (bilateralLowerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("bilateral lower extremity,");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
		
			
			
			
			if (normalradio.isSelected()) {

				StringBuilder str12 = new StringBuilder(resultInputController.str);
				str12.append("States normal study.");
				resultInputController.str = str12.toString();

			}if (abnormalRadio.isSelected()) {

				StringBuilder str13 = new StringBuilder(resultInputController.str);
				str13.append("States abnormal study.");
				resultInputController.str = str13.toString();

			}
			
			
			
			if (findText.getText().length() > 0) {

				StringBuilder str14 = new StringBuilder(resultInputController.str);
				str14.append(findText.getText() +".");
				resultInputController.str = str14.toString();

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

