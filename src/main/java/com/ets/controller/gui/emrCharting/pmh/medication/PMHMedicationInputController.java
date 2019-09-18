package com.ets.controller.gui.emrCharting.pmh.medication;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.instruction.patientInst.PatientInstructionFreeTextController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class PMHMedicationInputController implements Initializable {

    @FXML
    private CheckBox NocurrentMedication;

    @FXML
    private CheckBox selectAnyMedication;

    @FXML
    private CheckBox AspirinAdultOTC;

    @FXML
    private CheckBox AspirinOTC;

    @FXML
    private CheckBox Acetaminophen;

    @FXML
    private CheckBox IbuprofenCheck;

    @FXML
    private CheckBox AnalgesicsMigraine;

    @FXML
    private CheckBox allergyURIAntihistamines;

    @FXML
    private CheckBox allergyURINasal;

    @FXML
    private CheckBox MuscleRelaxantsCheck;

    @FXML
    private CheckBox AnalgesicsNSAIDS;

    @FXML
    private CheckBox asthma;

    @FXML
    private CheckBox Diabetes;

    @FXML
    private CheckBox GIHUAntacids;

    @FXML
    private CheckBox HTNACEARB;

    @FXML
    private CheckBox HTNNItrates;

    @FXML
    private CheckBox lipids;

    @FXML
    private CheckBox ocps;

    @FXML
    private CheckBox asleepAnxiety;

    @FXML
    private CheckBox steroids;

    @FXML
    private CheckBox vitamins;

    @FXML
    private CheckBox highMedicationsBloodPressure;

    @FXML
    private CheckBox lipidLoweringMedications;

    @FXML
    private CheckBox sleepingPills;

    @FXML
    private Button SkipButton;

    @FXML
    private Button freeTextBtn;

    
    
    private Button button;
    
	
   	public GenericEMRChartingController genericEMRChartingController;

   	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
   			Button button) {
   		this.genericEMRChartingController = genericEMRChartingController;
   		this.button = button;
   	}
   	
   	 FXMLFormPath formPath = new FXMLFormPath();
   	


   	public static String strForFreeText = "";
   	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		


		freeTextBtn.setOnAction((event) ->{
              
			
					if (NocurrentMedication.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("No Current Medication,");
						strForFreeText = str1.toString();
						NocurrentMedication.setSelected(false);

					}

                 if (selectAnyMedication.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Select Any Medication");
						strForFreeText = str1.toString();
						selectAnyMedication.setSelected(false);

					}  if (AspirinAdultOTC.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Aspirin Adult OTC, ");
						strForFreeText = str1.toString();
						AspirinAdultOTC.setSelected(false);

					} if (AspirinOTC.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Aspirin OTC ,81mg, ");
						strForFreeText = str1.toString();
						AspirinOTC.setSelected(false);

					} if (Acetaminophen.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Acetaminophen, ");
						strForFreeText = str1.toString();
						Acetaminophen.setSelected(false);

					}if (IbuprofenCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Ibuprofen OTC, ");
						strForFreeText = str1.toString();
						IbuprofenCheck.setSelected(false);

					}if (allergyURIAntihistamines.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Allergy/URI-Antihistamines, ");
						strForFreeText = str1.toString();
						allergyURIAntihistamines.setSelected(false);

					}if (allergyURINasal.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Allergy/URI-Nasal Spray/Steroi, ");
						strForFreeText = str1.toString();
						allergyURINasal.setSelected(false);

					}if (AnalgesicsMigraine.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Analgesics-Migraine");
						strForFreeText = str1.toString();
						AnalgesicsMigraine.setSelected(false);

					}
                  if (MuscleRelaxantsCheck.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Analgesics-Muscle Relaxants");
						strForFreeText = str1.toString();
						MuscleRelaxantsCheck.setSelected(false);

					}
                  if (AnalgesicsNSAIDS.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Analgesics-NSAIDS, ");
						strForFreeText = str1.toString();
						AnalgesicsNSAIDS.setSelected(false);

					} if (asthma.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Asthma, ");
						strForFreeText = str1.toString();
						asthma.setSelected(false);

					}if (Diabetes.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Diabetes, ");
						strForFreeText = str1.toString();
						Diabetes.setSelected(false);

					}if (GIHUAntacids.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("GI-Hu Antacids");
						strForFreeText = str1.toString();
						GIHUAntacids.setSelected(false);

					}if (HTNACEARB.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("HTN-ACE,ARB,BB,CCB, ");
						strForFreeText = str1.toString();
						HTNACEARB.setSelected(false);

					}if (HTNNItrates.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("HTN-Nitrates_Diuretics, ");
						strForFreeText = str1.toString();
						HTNNItrates.setSelected(false);

					}
                  if (lipids.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Lipids, ");
						strForFreeText = str1.toString();
						lipids.setSelected(false);

					} if (ocps.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("OCPs, ");
						strForFreeText = str1.toString();
						ocps.setSelected(false);

					}if (asleepAnxiety.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Aleep/Anxiety, ");
						strForFreeText = str1.toString();
						asleepAnxiety.setSelected(false);

					}if (steroids.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Steroids, ");
						strForFreeText = str1.toString();
						steroids.setSelected(false);

					}
                    if (vitamins.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Vitamins, ");
						strForFreeText = str1.toString();
						vitamins.setSelected(false);

					}   if (highMedicationsBloodPressure.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("High Medications Blood Pressure, ");
						strForFreeText = str1.toString();
						highMedicationsBloodPressure.setSelected(false);

					} if (lipidLoweringMedications.isSelected()) {
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Lipid-Lowering Medications, ");
						strForFreeText = str1.toString();
						lipidLoweringMedications.setSelected(false);

					}if (sleepingPills.isSelected()) { 
		                
						StringBuilder str1 = new StringBuilder(strForFreeText);
						str1.append("Sleeping Pills, ");
						strForFreeText = str1.toString();
						sleepingPills.setSelected(false);

					} 
					
					

					String formName = formPath.context.getMessage("PMHMedicationFreeText", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.PMHMedicationFreeText", null, Locale.US);
					
					
					MedicationFreeTextInputController medicationFreeTextInputController = 
					(MedicationFreeTextInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					formPath.closeApplicationContext();
					medicationFreeTextInputController.setPmhMedicationInputController(this);
					genericEMRChartingController.paint(button);
					new FXFormCommonUtilities().closeForm(freeTextBtn);
		});
		
		
			
		SkipButton.setOnAction((event) -> {
			try {
				//cancel centralized form
				
				new FXFormCommonUtilities().closeForm( SkipButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		
		
		
	}

}
