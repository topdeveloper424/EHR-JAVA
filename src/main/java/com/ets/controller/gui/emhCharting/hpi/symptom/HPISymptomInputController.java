package com.ets.controller.gui.emhCharting.hpi.symptom;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

public class HPISymptomInputController  implements Initializable{
	
	 @FXML
	    private CheckBox AnxietyCheck;

	    @FXML
	    private CheckBox BleedingCheck;

	    @FXML
	    private CheckBox BloodInStoolCheck;

	    @FXML
	    private CheckBox BloodInUrineCheck;

	    @FXML
	    private CheckBox BlurredVisionCheck;

	    @FXML
	    private CheckBox CongestionCheck;

	    @FXML
	    private CheckBox ChillsCheck;

	    @FXML
	    private CheckBox ConstipationCheck;

	    @FXML
	    private CheckBox DifficultySleepingCheck;

	    @FXML
	    private CheckBox CoughCheck;

	    @FXML
	    private CheckBox DifficultySwalloingCheck;

	    @FXML
	    private CheckBox DepressionCheck;

	    @FXML
	    private CheckBox DiarrheaCheck;

	    @FXML
	    private CheckBox FeverCheck;

	    @FXML
	    private CheckBox ItchingCheck;

	    @FXML
	    private CheckBox HeadacheCheck;

	    @FXML
	    private CheckBox IrritationCheck;

	    @FXML
	    private CheckBox IndigestionCheck;

	    @FXML
	    private CheckBox HeartBurnCheck;

	    @FXML
	    private CheckBox FrequentUrinationCheck;

	    @FXML
	    private CheckBox FaintingCheck;

	    @FXML
	    private CheckBox EaracheCheck;

	    @FXML
	    private CheckBox DrainageCheck;

	    @FXML
	    private CheckBox DizzinessCheck;

	    @FXML
	    private CheckBox DisorientationCheck;

	    @FXML
	    private CheckBox DischargeCheck;

	    @FXML
	    private CheckBox NumbnessCheck;

	    @FXML
	    private CheckBox ProblemsUrinatingCheck;

	    @FXML
	    private CheckBox NauseaCheck;

	    @FXML
	    private CheckBox PainCheck;

	    @FXML
	    private CheckBox ShortnessofBreathCheck;

	    @FXML
	    private CheckBox SorethroatCheck;

	    @FXML
	    private CheckBox SpasmCheck;

	    @FXML
	    private CheckBox StiffnessCheck;

	    @FXML
	    private CheckBox SwellingCheck;

	    @FXML
	    private CheckBox TightnessCheck;

	    @FXML
	    private CheckBox TightnessinChestCheck;

	    @FXML
	    private CheckBox TinglingCheck;

	    @FXML
	    private CheckBox VomitingCheck;

	    @FXML
	    private CheckBox OtherSymptomCheck;

	    @FXML
	    private Button AnyWizardButton;

	    @FXML
	    private Button FreeTextButton;

	    @FXML
	    private Button RunRepeatButton;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button DoneButton;

	    @FXML
	    private CheckBox UseLeadInCheck;

	    @FXML
	    private TextField UseLeadInText;

	    private Button button;
        private GenericEMRChartingController genericEMRChartingController;
	    
	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
			this.genericEMRChartingController = genericEMRChartingController;
			this.button = button;
		}
	 
		public void initialize(URL location, ResourceBundle resources) {
			DoneButton.setOnAction((event) -> {
				try {
					genericEMRChartingController.setHpiTextArea("\nSYMPTOM: ");
					if(AnxietyCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Anxiety");	
						
					}
					
					if(BleedingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Bleeding");
					}
					if(BloodInStoolCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Blood In Stool");
					}
					if(BloodInUrineCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Blood In Urine");
					}
					if(BlurredVisionCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Blurred Vision");
					}
					if(CongestionCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Congestion");
					}
					if(ChillsCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Chills");
					}
					if(ConstipationCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Constipation");
					}
					if(DifficultySleepingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Difficulty In Sleeping");
					}
					if(CoughCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Cough");
					}
					if(DifficultySwalloingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Difficulty Swalloing");
					}
					if(DepressionCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Depression");
					}
					if(DiarrheaCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Diarrhea");
					}
					if(FeverCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Fever");
					}
					if(ItchingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Itching");
					}
					
					if(HeadacheCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Headache");
					}
					
					if(IrritationCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Irritation");
					}
					
					
					if(IndigestionCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Indigestion");
					}
					
					if(HeartBurnCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("HeartBurn");
					}
					
					if(FrequentUrinationCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Frequent Urination");
					}
					
					if(FaintingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Fainting");
					}
					
					if(EaracheCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Earache");
					}
					
					if(DrainageCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Drainage");
					}
					
					if(DizzinessCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Dizziness");
					}
					
					if(DisorientationCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Disorientation");
					}
					
					if(DischargeCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Discharge");
					}
					
					if(NumbnessCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Numbness");
					}
					if(ProblemsUrinatingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Problems Urinating");
					}
					
					if(NauseaCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Nausea");
					}
					if(PainCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Pain");
					}
					if(ShortnessofBreathCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Shortness of Breath");
					}
					if(SorethroatCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("(Sore throat");
					}
					if(SpasmCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Spasm");
					}
					if(StiffnessCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Stiffness");
					}
					
					if(SwellingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Swelling");
					}
					if(TightnessCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Tightness");
					}
					if(TightnessinChestCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Tightness in Chest");
					}
					if(TinglingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Tingling");
					}
					if(VomitingCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Vomiting");
					}
					if(OtherSymptomCheck.isSelected()){
						genericEMRChartingController.setHpiTextArea("Other Symptom");
					}
					
					button.setTextFill(Color.GREEN);
					new FXFormCommonUtilities().closeForm(DoneButton);
					
				}catch(Exception e){
					e.printStackTrace();
				}
	    	
	    });
			
			skipBtn.setOnAction((event) -> {
				try {
					
					new FXFormCommonUtilities().closeForm( skipBtn);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
	    
}

}
