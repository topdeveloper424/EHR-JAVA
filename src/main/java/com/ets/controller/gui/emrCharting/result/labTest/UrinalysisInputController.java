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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class UrinalysisInputController implements Initializable {
	
	 @FXML
	    private RadioButton LeukocytesNegativeRadio;

	    @FXML
	    private ToggleGroup Leukocytes;

	    @FXML
	    private RadioButton Leukocytes15Radio;

	    @FXML
	    private RadioButton Leukocytes70Radio;

	    @FXML
	    private RadioButton Leukocytes125Radio;

	    @FXML
	    private RadioButton Leukocytes500Radio;

	    @FXML
	    private RadioButton NitriteNegativeRadio;

	    @FXML
	    private ToggleGroup Nitrite;

	    @FXML
	    private RadioButton NitritePossitiveRadio;

	    @FXML
	    private RadioButton Urobilinogen02Radio;

	    @FXML
	    private ToggleGroup Urobilinogen;

	    @FXML
	    private RadioButton Urobilinogen1Radio;

	    @FXML
	    private RadioButton Urobilinogen2radio;

	    @FXML
	    private RadioButton Urobilinogen4radio;

	    @FXML
	    private RadioButton Urobilinogen8Radio;

	    @FXML
	    private RadioButton Urobilinogen12Radio;

	    @FXML
	    private RadioButton ProteinNegativeRadio;

	    @FXML
	    private ToggleGroup Protein;

	    @FXML
	    private RadioButton Protein15Radio;

	    @FXML
	    private RadioButton Protein30radio;

	    @FXML
	    private RadioButton Protein100Radio;

	    @FXML
	    private RadioButton Protein300Radio;

	    @FXML
	    private RadioButton Protein2000Radio;

	    @FXML
	    private RadioButton ph5Radio;

	    @FXML
	    private ToggleGroup ph;

	    @FXML
	    private RadioButton ph6Radio;

	    @FXML
	    private RadioButton ph65Radio;

	    @FXML
	    private RadioButton ph7Radio;

	    @FXML
	    private RadioButton ph75Radio;

	    @FXML
	    private RadioButton ph8Radio;

	    @FXML
	    private RadioButton ph9Radio;

	    @FXML
	    private RadioButton BloodNegativeRadio;

	    @FXML
	    private ToggleGroup Blood;

	    @FXML
	    private RadioButton BloodPlusRadio;

	    @FXML
	    private RadioButton BloodPlusPlusRadio;

	    @FXML
	    private RadioButton BloodPlus2Radio;

	    @FXML
	    private RadioButton BloodPlus3Radio;

	    @FXML
	    private RadioButton Blood5radio;

	    @FXML
	    private RadioButton Blood50Radio;

	    @FXML
	    private RadioButton Gravity1000Radio;

	    @FXML
	    private ToggleGroup Gravity;

	    @FXML
	    private RadioButton Gravity1005Radio;

	    @FXML
	    private RadioButton Gravity1010Radio;

	    @FXML
	    private RadioButton Gravity1015Radio;

	    @FXML
	    private RadioButton Gravity1020Radio;

	    @FXML
	    private RadioButton Gravity1025Radio;

	    @FXML
	    private RadioButton Gravity1030Radio;

	    @FXML
	    private RadioButton KetonesnegativeRadio;

	    @FXML
	    private ToggleGroup Ketones;

	    @FXML
	    private RadioButton Ketones5Radio;

	    @FXML
	    private RadioButton Ketones15Radio;

	    @FXML
	    private RadioButton Ketones40Radio;

	    @FXML
	    private RadioButton Ketones80Radio;

	    @FXML
	    private RadioButton Ketones160Radio;

	    @FXML
	    private RadioButton BilirubinNegativeRadio;

	    @FXML
	    private ToggleGroup Bilirubin;

	    @FXML
	    private RadioButton Bilirubin1Radio;

	    @FXML
	    private RadioButton GlucoseNegativeRadio;

	    @FXML
	    private ToggleGroup Glucose;

	    @FXML
	    private RadioButton Glucose100Radio;

	    @FXML
	    private RadioButton Glucose250Radio;

	    @FXML
	    private RadioButton Glucose500Radio;

	    @FXML
	    private RadioButton Glucose1000Radio;

	    @FXML
	    private RadioButton Glucose2000Radio;

	    @FXML
	    private TextArea freeTextRadio;

	    @FXML
	    private RadioButton Bilirubin2Radio;

	    @FXML
	    private RadioButton Bilirubin4Radio;
	    
	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;
	    
	    
	    private ResultInputController resultInputController;

		public void setResultInputController(ResultInputController resultInputController) {
			this.resultInputController = resultInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\nUrine dipstick results:  ");
			resultInputController.str = procedureStr.toString();

			
			if (LeukocytesNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Leukocytes (white blood cells in the urine) negative (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Leukocytes15Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Leukocytes (white blood cells in the urine) 15+ (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Leukocytes70Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Leukocytes (white blood cells in the urine) 70+ (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Leukocytes125Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Leukocytes (white blood cells in the urine) 125+ (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Leukocytes500Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Leukocytes (white blood cells in the urine) 500+++ (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			if (NitriteNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Nitrite Negative (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (NitritePossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Nitrite Possitive (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (Urobilinogen02Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Urobilinogen 0.2 (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Urobilinogen12Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Urobilinogen 12 (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Urobilinogen1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Urobilinogen 1 (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Urobilinogen2radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Urobilinogen 2 (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Urobilinogen4radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Urobilinogen 4 (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Urobilinogen8Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Urobilinogen 8 (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
				
			if (Protein100Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Protein 100+++  (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Protein15Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Protein 15  (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Protein2000Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Protein 2000+++  (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Protein300Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Protein 300+++  (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Protein30radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Protein 30+  (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (ProteinNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Protein Negative  (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (ph5Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pH 5.0.");
				resultInputController.str = str1.toString();

			}if (ph65Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pH 6.5.");
				resultInputController.str = str1.toString();
				
			}if (ph6Radio.isSelected()) {
				 
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pH 6.0.");
				resultInputController.str = str1.toString();

			}if (ph75Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pH 7.5.");
				resultInputController.str = str1.toString();
				
			}if (ph7Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pH 7.0.");
				resultInputController.str = str1.toString();
				
			}if (ph8Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pH 8.0.");
				resultInputController.str = str1.toString();
				
			}if (ph9Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("pH 9.0.");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			if (Blood50Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Blood 50 Ery (normal = negative). ");
				resultInputController.str = str1.toString();

			}if (Blood5radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Blood 5-10 (normal = negative). ");
				resultInputController.str = str1.toString();
				
			}if (BloodNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Blood Negative  (normal = negative). ");
				resultInputController.str = str1.toString();

			}if (BloodPlus2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Blood 5-10 (normal = negative). ");
				resultInputController.str = str1.toString();
				
			}if (BloodPlus3Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Blood  +++ (normal = negative). ");
				resultInputController.str = str1.toString();
				
			}if (BloodPlusPlusRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Blood ++ (normal = negative). ");
				resultInputController.str = str1.toString();
				
			}if (BloodPlusRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Blood + (normal = negative). ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			
			if (Gravity1000Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Specific Gravity 1.000. ");
				resultInputController.str = str1.toString();

			}if (Gravity1005Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Specific Gravity 1.005. ");
				resultInputController.str = str1.toString();
				
			}if (Gravity1010Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Specific Gravity 1.010. ");
				resultInputController.str = str1.toString();
				
			}if (Gravity1015Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Specific Gravity 1.005. ");
				resultInputController.str = str1.toString();
				
			}if (Gravity1020Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Specific Gravity 1.020. ");
				resultInputController.str = str1.toString();

			}if (Gravity1025Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Specific Gravity 1.025. ");
				resultInputController.str = str1.toString();
				
			}if (Gravity1030Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Specific Gravity 1.030. ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if (Ketones15Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Ketones 15 (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Ketones160Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Ketones 160 (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Ketones40Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Ketones 40 (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Ketones5Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Ketones 5 (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Ketones80Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Ketones 80 (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (KetonesnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Ketones Negative (negative = normal). ");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			if (Bilirubin1Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Bilirubin 1+ (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (Bilirubin2Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Bilirubin  2 ++  (negative = normal). ");
				resultInputController.str = str1.toString();
				
			}if (Bilirubin4Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Bilirubin 4+++ (negative = normal). ");
				resultInputController.str = str1.toString();

			}if (BilirubinNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Bilirubin negative (negative = normal). ");
				resultInputController.str = str1.toString();

			}
			
			
			
			
			
			if (Glucose1000Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Glucose 1000 (negative = normal) ");
				resultInputController.str = str1.toString();

			}if (Glucose100Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Glucose 100 (negative = normal) ");
				resultInputController.str = str1.toString();
				
			}if (Glucose2000Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Glucose >2000 (negative = normal) ");
				resultInputController.str = str1.toString();

			}if (Glucose250Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Glucose 250 (negative = normal) ");
				resultInputController.str = str1.toString();
				
			}if (Glucose500Radio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Glucose 500 (negative = normal) ");
				resultInputController.str = str1.toString();
				
			}if (GlucoseNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("Glucose Negative (negative = normal) ");
				resultInputController.str = str1.toString();
				
			}
			
			
			
			
			if (freeTextRadio.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append("\n" +freeTextRadio.getText() +".");
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