package com.ets.controller.gui.emrCharting.order;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.order.consult.ConsultErTransferInputController;
import com.ets.controller.gui.medicationCode.MedicationCodeInputController;
import com.ets.controller.gui.medicationCode.MedicationCodeViewController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class MedicationInputController implements Initializable{
	@FXML
    private CheckBox UrgentCareOralCheck;

    @FXML
    private CheckBox UrgentCareInjectablesCheckBox;

    @FXML
    private CheckBox InHouseDispenseCheckBox;

    @FXML
    private CheckBox InOfficeAdministeredCheckBox;

    @FXML
    private CheckBox AntibioticsAdultRxCheckBox;

    @FXML
    private CheckBox OralTopicalRxCheckBox;

    @FXML
    private CheckBox PainWithInflamationCheckBox;

    @FXML
    private CheckBox PainWithSpasmCheckBox;

    @FXML
    private CheckBox PainNeuropathicCheckBox;

    @FXML
    private CheckBox DrJonesCheckBox;

    @FXML
    private CheckBox DrSmithCheckBox;

    @FXML
    private CheckBox Acetaminophen500CheckBox;

    @FXML
    private CheckBox AspirinOTCCheckBox;

    @FXML
    private CheckBox IbuprofenOTCCheck;

    @FXML
    private CheckBox IbuprofenCheckBox;

    @FXML
    private CheckBox MagicMouthwashCheckBox;

    @FXML
    private CheckBox Prelone15CheckBox;

    @FXML
    private CheckBox AllergyURICoughCheckBox;

    @FXML
    private CheckBox AnalgesicsMuscleCheckBox;

    @FXML
    private CheckBox AnalgesicsNSAIDSCheckBox;

    @FXML
    private CheckBox DiabetesCheckBox;

    @FXML
    private CheckBox ENDOOCPCheckBox;

    @FXML
    private CheckBox GIAntidiarrheCheckBox;

    @FXML
    private CheckBox GIAntinausesCheckBox;

    @FXML
    private CheckBox htnAceArbCheckBox;

    @FXML
    private CheckBox lipidsCheckBox;

    @FXML
    private CheckBox SleepAnxietyCheckBox;

    @FXML
    private CheckBox AspirinAdultOTCCheckBox;

    @FXML
    private CheckBox AsthmaCheck;

    @FXML
    private CheckBox AnalgesicsOpioidsCheck;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;
    private Button button;
    
 		public GenericEMRChartingController genericEMRChartingController;
 	    
 	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
 			this.genericEMRChartingController = genericEMRChartingController;
 			this.button = button;
 		}
 	    
 	    
 	    
 	    FXMLFormPath formPath = new FXMLFormPath();

 		public static Integer formCount = 0;

 		private Integer secondFormCount = 0;

 		public static String str = "\n\n";


 		void formCountIncrement() {
 			++secondFormCount;
 		}

 		
 		public void setMedicationForPatientUI(){
 			
 			if(UrgentCareOralCheck.isSelected()){
				String str = "UrgentCareOralCheck";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				UrgentCareOralCheck.setSelected(false);
				
			}else if(UrgentCareInjectablesCheckBox.isSelected()){
				String str = "UrgentCareInjectablesCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				UrgentCareInjectablesCheckBox.setSelected(false);
				
			}else if(InHouseDispenseCheckBox.isSelected()){
				String str = "InHouseDispenseCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				InHouseDispenseCheckBox.setSelected(false);
				
			}else if(InOfficeAdministeredCheckBox.isSelected()){
				String str = "InOfficeAdministeredCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				InOfficeAdministeredCheckBox.setSelected(false);
				
			}else if(AntibioticsAdultRxCheckBox.isSelected()){
				String str = "AntibioticsAdultRxCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AntibioticsAdultRxCheckBox.setSelected(false);
				
			}else if(OralTopicalRxCheckBox.isSelected()){
				String str = "OralTopicalRxCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				OralTopicalRxCheckBox.setSelected(false);
				
			}else if(PainWithInflamationCheckBox.isSelected()){
				String str = "PainWithInflamationCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				PainWithInflamationCheckBox.setSelected(false);
				
			}else if(PainWithSpasmCheckBox.isSelected()){
				String str = "PainWithSpasmCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				PainWithSpasmCheckBox.setSelected(false);
				
			}else if(PainNeuropathicCheckBox.isSelected()){
				String str = "PainNeuropathicCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				PainNeuropathicCheckBox.setSelected(false);
				
			}else if(DrJonesCheckBox.isSelected()){
				String str = "DrJonesCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				DrJonesCheckBox.setSelected(false);
				
			}else if(DrSmithCheckBox.isSelected()){
				String str = "DrSmithCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				DrSmithCheckBox.setSelected(false);
				
			}else if(Acetaminophen500CheckBox.isSelected()){
				String str = "Acetaminophen500CheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				Acetaminophen500CheckBox.setSelected(false);
				
			}else if(AspirinOTCCheckBox.isSelected()){
				String str = "AspirinOTCCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AspirinOTCCheckBox.setSelected(false);
				
			}else if(IbuprofenOTCCheck.isSelected()){
				String str = "IbuprofenOTCCheck";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				IbuprofenOTCCheck.setSelected(false);
				
			}else if(IbuprofenCheckBox.isSelected()){
				String str = "IbuprofenCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				IbuprofenCheckBox.setSelected(false);
				
			}else if(MagicMouthwashCheckBox.isSelected()){
				String str = "MagicMouthwashCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				MagicMouthwashCheckBox.setSelected(false);
				
			}else if(Prelone15CheckBox.isSelected()){
				String str = "Prelone15CheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				Prelone15CheckBox.setSelected(false);
				
			}else if(AsthmaCheck.isSelected()){
				String str = "AsthmaCheck";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AsthmaCheck.setSelected(false);
				
			}else if(AllergyURICoughCheckBox.isSelected()){
				String str = "AllergyURICoughCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AllergyURICoughCheckBox.setSelected(false);
				
			}else if(AnalgesicsMuscleCheckBox.isSelected()){
				String str = "AnalgesicsMuscleCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AnalgesicsMuscleCheckBox.setSelected(false);
				
			}else if(AnalgesicsNSAIDSCheckBox.isSelected()){
				String str = "AnalgesicsNSAIDSCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AnalgesicsNSAIDSCheckBox.setSelected(false);
				
			}else if(AnalgesicsOpioidsCheck.isSelected()){
				String str = "AnalgesicsOpioidsCheck";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AnalgesicsOpioidsCheck.setSelected(false);
				
			}else if(DiabetesCheckBox.isSelected()){
				String str = "DiabetesCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				DiabetesCheckBox.setSelected(false);
				
			}else if(ENDOOCPCheckBox.isSelected()){
				String str = "ENDOOCPCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				ENDOOCPCheckBox.setSelected(false);
				
			}else if(GIAntidiarrheCheckBox.isSelected()){
				String str = "GIAntidiarrheCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				GIAntidiarrheCheckBox.setSelected(false);
				
			}else if(GIAntinausesCheckBox.isSelected()){
				String str = "GIAntinausesCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				GIAntinausesCheckBox.setSelected(false);
				
			}else if(htnAceArbCheckBox.isSelected()){
				String str = "htnAceArbCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				htnAceArbCheckBox.setSelected(false);
				
			}else if(lipidsCheckBox.isSelected()){
				String str = "lipidsCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				lipidsCheckBox.setSelected(false);
				
			}else if(SleepAnxietyCheckBox.isSelected()){
				String str = "SleepAnxietyCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				SleepAnxietyCheckBox.setSelected(false);
				
			}else if(AspirinAdultOTCCheckBox.isSelected()){
				String str = "AspirinAdultOTCCheckBox";
				formCountIncrement();
				String formName = formPath.context.getMessage("ViewMedicationCode", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ViewMedicationCode", null, Locale.US);

				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;

				if (Global.patient != null) {

					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();

				}
				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
				formPath.closeApplicationContext();

				MedicationCodeViewController medicationCodeViewController = (MedicationCodeViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeViewController.setMedicationInputController(this,str);
				AspirinAdultOTCCheckBox.setSelected(false);
				
			}
			
              else if (secondFormCount == formCount) {
				
				genericEMRChartingController.paint(button);
				
				formCount = 0;
				genericEMRChartingController.setOrderTextArea(str);
				genericEMRChartingController.saveAllTextArea();
				str = "";
				new FXFormCommonUtilities().closeForm(doneBtn);


			}
 			
 		}
 		
 		
 		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			setMedicationForPatientUI();
			
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
