package com.ets.controller.gui.audiomericTest;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;



import com.ets.controller.entity.audiometryTestParamClassify.*;
import com.ets.controller.entity.audiometryTestParamGen.AudiometryTestParamGenEntityController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import com.ets.model.AudioMeterTestParamGen;
import com.ets.model.Clinic;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class AudiometricTestingParameterInputController implements Initializable {
	@FXML
    private TextField signifyToResponseText;

    @FXML
    private TextField signifyNoTestConductText;

    @FXML
    private TextField ThresholdShiftText;

    @FXML
    private TextField OSHAText;

    @FXML
    private TextField AssemetryAtaSpeechFreqText;

    @FXML
    private TextField assemetryAtHighFreqText;

    @FXML
    private RadioButton Radio2k;

    @FXML
    private RadioButton Radio3k;

    @FXML
    private RadioButton Radio6k;

    @FXML
    private RadioButton Radio8K;

    @FXML
    private RadioButton AAORadio;

    @FXML
    private RadioButton CAOHCRadio;

    @FXML
    private TextField BestText;

    @FXML
    private TextField fromBestText;

    @FXML
    private TextField ThruBestText;

    @FXML
    private TextField ResultBestText;

    @FXML
    private TextField text2;

    @FXML
    private TextField from2Text;

    @FXML
    private TextField thru2Text;

    @FXML
    private TextField Result2Text;

    @FXML
    private TextField text3;

    @FXML
    private TextField from3Text;

    @FXML
    private TextField thru3Text;

    @FXML
    private TextField Result3Text;

    @FXML
    private TextField text4;

    @FXML
    private TextField from4Text;

    @FXML
    private TextField thru4Tesxt;

    @FXML
    private TextField Result4Text;

    @FXML
    private TextField text5;

    @FXML
    private TextField from5Text;

    @FXML
    private TextField thru5Text;

    @FXML
    private TextField Result5Text;

    @FXML
    private TextField worstText;

    @FXML
    private TextField fromWorstText;

    @FXML
    private TextField ResultWorstText;

    @FXML
    private RadioButton AAOORadio;

    @FXML
    private RadioButton NewJerseyRadio;

    @FXML
    private RadioButton illionisRadio;

    @FXML
    private Button madicalActivityBtn;

    @FXML
    private Button visitCategoryBtn;

    @FXML
    private Button audioMeterWquipmentButton;

    @FXML
    private Button Okbutton;

    @FXML
    private Button cancelButton;
    
    private Clinic clinic;
    
    
    
    public void setAudioMetricTestParam(){
    	
    	signifyToResponseText.setText("99");
    	ThresholdShiftText.setText("10");
    	AssemetryAtaSpeechFreqText.setText("15");
    	signifyNoTestConductText.setText("999");
    	OSHAText.setText("25");
    	assemetryAtHighFreqText.setText("25");
    	
		BestText.setText("Normal Hearing");
		text2.setText("Mild Hearing Loss");
		text3.setText("Moderate Loss");
		text4.setText("Mod Severe Loss");
		text5.setText("Severe Loss");
		worstText.setText("Profound Loss");
		fromBestText.setText("0");
		from2Text.setText("26");
		from3Text.setText("41");
		from4Text.setText("56");
		from5Text.setText("71");
		fromWorstText.setText("91");
		ThruBestText.setText("25Â�");
		thru2Text.setText("40");
		thru3Text.setText("55");
		thru4Tesxt.setText("70");
		thru5Text.setText("90");
		ResultBestText.setText("N");
		Result2Text.setText("A");
		Result3Text.setText("A");
		Result4Text.setText("A");
		Result5Text.setText("A");
		ResultWorstText.setText("A");
		
    }


	FXMLFormPath formPath = new FXMLFormPath();
	
	
	
/*	public void callOkBtn() {
		
		
		AudioMeterTestParamGen audioMeterTest = new AudioMeterTestParamGen();
		audioMeterTest.setSignifyNoResponse();
		
		
		
		
		
	}*/

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		setAudioMetricTestParam();
		
		audioMeterWquipmentButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ViewAudioMeter", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewAudioMeter", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		madicalActivityBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		
		visitCategoryBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		/*Okbutton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(Okbutton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		
		

		Okbutton.setOnAction((event)-> {
			try {
			AudioMeterTestParamGen audioMeterTest = new AudioMeterTestParamGen();
			audioMeterTest.setSignifyNoTestConducted(signifyNoTestConductText.getText());
			audioMeterTest.setStdThresholdShift(ThresholdShiftText.getText());
			audioMeterTest.setOSHARecShift(OSHAText.getText());
			audioMeterTest.setSpeechAsymmetryFreq(AssemetryAtaSpeechFreqText.getText());
			audioMeterTest.setHighFreqAsymmetry(assemetryAtHighFreqText.getText());
			/*audioMeterTest.setSpeechFreq();
			audioMeterTest.setHighFreq();
			audioMeterTest.setMedRefCriteria();*/
			audioMeterTest.setSignifyNoResponse(signifyToResponseText.getText());
			audioMeterTest.setClinic(clinic);
			
			new AudiometryTestParamGenEntityController().add(audioMeterTest);
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		         });
		
		
		
		
		
		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
