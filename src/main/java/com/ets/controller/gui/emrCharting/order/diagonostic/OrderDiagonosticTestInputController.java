package com.ets.controller.gui.emrCharting.order.diagonostic;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.order.consult.ConsultBoneScanInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrderDiagonosticTestInputController implements Initializable {
	
	 @FXML
	    private CheckBox AccucheckCheckBox;

	    @FXML
	    private CheckBox cmpCheckBox;

	    @FXML
	    private CheckBox hemoglobinCheckBox;

	    @FXML
	    private CheckBox chemistryCheckBox;

	    @FXML
	    private CheckBox upperExtrimitiesCheckBox;

	    @FXML
	    private CheckBox hematologyCheckBox;

	    @FXML
	    private CheckBox microbiologyCheckBox;

	    @FXML
	    private CheckBox occMedCheckBox;

	    @FXML
	    private CheckBox anemiaCheckBox;

	    @FXML
	    private CheckBox giCheckBox;

	    @FXML
	    private CheckBox influenzaCheckBox;

	    @FXML
	    private CheckBox strepCheckBox;

	    @FXML
	    private CheckBox ucCheckBox;

	    @FXML
	    private CheckBox wcCheckBox;

	    @FXML
	    private CheckBox instantCheckBox;

	    @FXML
	    private CheckBox chestCheckBox;

	    @FXML
	    private CheckBox headCheckBox;

	    @FXML
	    private CheckBox lowerExtrimitiesCheckBox;

	    @FXML
	    private CheckBox spineCheckBox;

	    @FXML
	    private CheckBox ctScanCheckBox;

	    @FXML
	    private CheckBox mriCheckBox;

	    @FXML
	    private CheckBox ultrasonographyCheckBox;

	    @FXML
	    private CheckBox audiometryCheckBox;

	    @FXML
	    private CheckBox ekgCheckBox;

	    @FXML
	    private CheckBox emgCheckBox;

	    @FXML
	    private CheckBox jamarCheckBox;

	    @FXML
	    private CheckBox bloodPressureCheckBox;

	    @FXML
	    private CheckBox peckFlowCheckBox;

	    @FXML
	    private CheckBox pulseOximetryCheckBox;

	    @FXML
	    private CheckBox pulmunaryFunctionCheckBox;

	    @FXML
	    private CheckBox tympanometryCheckBox;

	    @FXML
	    private CheckBox visionTestCheckBox;

	    @FXML
	    private CheckBox vitalSignCheckBox;

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
	    
	    public void setDiagonosisTestUI(){
	    	
	    	if (AccucheckCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Accucheck/Instant Blood Glucose ordered. ");
				str = str1.toString();
				AccucheckCheckBox.setSelected(false);

				setDiagonosisTestUI();

			}
			
			else if (cmpCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("The following labs were ordered, specimens ran in house: CMP (Piccolo In House Lab Test). ");
				str = str1.toString();
				cmpCheckBox.setSelected(false);

				setDiagonosisTestUI();

			}else if (hemoglobinCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Hemoglobin test was ordered. ");
				str = str1.toString();
				hemoglobinCheckBox.setSelected(false);

				setDiagonosisTestUI();

			}  
			
			else if (chemistryCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultLabOrderChemistry", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticLabOrderChemistryInputController labOrderChemistryInputController = (DiagonosticLabOrderChemistryInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				labOrderChemistryInputController.setOrderDiagonosticTestInputController(this);

				chemistryCheckBox.setSelected(false);

			}
	    	
			else if (hematologyCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultLabOrderHematology", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticLabOrderHematologyInputController labOrderHematologyInputController = (DiagonosticLabOrderHematologyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				labOrderHematologyInputController.setOrderDiagonosticTestInputController(this);

				hematologyCheckBox.setSelected(false);

			}
	    	
	    	
			else if (microbiologyCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultlabOrderMicroBiology", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticLabOrderMicroBiologyInputController labOrderMicroBiologyInputController = (DiagonosticLabOrderMicroBiologyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				labOrderMicroBiologyInputController.setOrderDiagonosticTestInputController(this);

				microbiologyCheckBox.setSelected(false);

			}
	    	
	    	
			else if (occMedCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultlabOrderOccMed", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticLabOrderOccMedInputController labOrderOccMedInputController = (DiagonosticLabOrderOccMedInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				labOrderOccMedInputController.setOrderDiagonosticTestInputController(this);

				occMedCheckBox.setSelected(false);

			}
	    	
	    	
			else if (anemiaCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultLabPanelAnemia", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticLabPanelAnemiaInputController labPanelAnemiaInputController = (DiagonosticLabPanelAnemiaInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				labPanelAnemiaInputController.setOrderDiagonosticTestInputController(this);

				anemiaCheckBox.setSelected(false);

			}
	    	
			else if (giCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultlabPanalGI", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticLabPanalGIInputController labPanalGIInputController = (DiagonosticLabPanalGIInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				labPanalGIInputController.setOrderDiagonosticTestInputController(this);

				giCheckBox.setSelected(false);

			}
	    	
			else if (influenzaCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Rapid influenza A+B test was ordered. ");
				str = str1.toString();
				influenzaCheckBox.setSelected(false);

				setDiagonosisTestUI();

			}else if (strepCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Rapid Strep A Test (OIA) was ordered. ");
				str = str1.toString();
				strepCheckBox.setSelected(false);

				setDiagonosisTestUI();

			}else if (ucCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultSTDLabsUC", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticSTDLabsUCInputController stdLabsUCInputController = (DiagonosticSTDLabsUCInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				stdLabsUCInputController.setOrderDiagonosticTestInputController(this);

				ucCheckBox.setSelected(false);

			}else if (wcCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultSTDLabsWC", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticSTDLabsWCInputController stdLabsWCInputController = (DiagonosticSTDLabsWCInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				stdLabsWCInputController.setOrderDiagonosticTestInputController(this);

				wcCheckBox.setSelected(false);

			}else if (instantCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultUrinalysisUrineTestOrder", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticUrinalysisUrineTestOrderInputController urinalysisUrineTestOrderInputController = (DiagonosticUrinalysisUrineTestOrderInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				urinalysisUrineTestOrderInputController.setOrderDiagonosticTestInputController(this);

				instantCheckBox.setSelected(false);

			}else if (chestCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultXrayInHouse", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticXrayInHouseInputController xrayInHouseInputController = (DiagonosticXrayInHouseInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				xrayInHouseInputController.setOrderDiagonosticTestInputController(this);

				chestCheckBox.setSelected(false);

			}else if (headCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultXrayInHouseHeadNeck", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticXrayInHouseHeadNeckInputController headNeckInputController = (DiagonosticXrayInHouseHeadNeckInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				headNeckInputController.setOrderDiagonosticTestInputController(this);

				headCheckBox.setSelected(false);

			}else if (lowerExtrimitiesCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultXrayInHouseLowerExtremities", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticXrayInHouseLowerExtremitiesInputController lowerExtremitiesInputController = (DiagonosticXrayInHouseLowerExtremitiesInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				lowerExtremitiesInputController.setOrderDiagonosticTestInputController(this);

				lowerExtrimitiesCheckBox.setSelected(false);

			}else if (spineCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultXrayInHouseSpinePelvis", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticXrayInHouseSpinePelvisInputController spinePelvisInputController = (DiagonosticXrayInHouseSpinePelvisInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				spinePelvisInputController.setOrderDiagonosticTestInputController(this);

				spineCheckBox.setSelected(false);

			}else if (upperExtrimitiesCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultXrayInHouseUpperExtrimities", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticXrayInHouseUpperExtrimitiesInputController upperExtrimitiesInputController = (DiagonosticXrayInHouseUpperExtrimitiesInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				upperExtrimitiesInputController.setOrderDiagonosticTestInputController(this);

				upperExtrimitiesCheckBox.setSelected(false);

			}else if (ctScanCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultCtScanGeneral", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticCtScanGeneralInputController ctScanGeneralInputController = (DiagonosticCtScanGeneralInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ctScanGeneralInputController.setOrderDiagonosticTestInputController(this);

				ctScanCheckBox.setSelected(false);

			}else if (mriCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultMRIGeneral", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticMRIGeneralInputController mriGeneralInputController = (DiagonosticMRIGeneralInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				mriGeneralInputController.setOrderDiagonosticTestInputController(this);

				mriCheckBox.setSelected(false);

			}else if (ultrasonographyCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultUltrasonography", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticUltrasonographyInputController ultrasonographyInputController = (DiagonosticUltrasonographyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				ultrasonographyInputController.setOrderDiagonosticTestInputController(this);

				ultrasonographyCheckBox.setSelected(false);

			}else if (audiometryCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("Audiometry ordered. ");
				str = str1.toString();
				audiometryCheckBox.setSelected(false);

				setDiagonosisTestUI();
				

			}else if (ekgCheckBox.isSelected()) {
				StringBuilder str1 = new StringBuilder(str);
				str1.append("EKG ordered. ");
				str = str1.toString();
				ekgCheckBox.setSelected(false);

				setDiagonosisTestUI();

			}else if (emgCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultEMGorNCV", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticEMGorNCVInputController emGorNCVInputController = (DiagonosticEMGorNCVInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				emGorNCVInputController.setOrderDiagonosticTestInputController(this);

				emgCheckBox.setSelected(false);

			}else if (jamarCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultJAMARHandOnly", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticJAMARHandOnlyInputController jamarHandOnlyInputController = (DiagonosticJAMARHandOnlyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				jamarHandOnlyInputController.setOrderDiagonosticTestInputController(this);

				jamarCheckBox.setSelected(false);

			}else if (bloodPressureCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultOrthostaticBloodPressure", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticOrthostaticBloodPressureInputController bloodPressureInputController = (DiagonosticOrthostaticBloodPressureInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				bloodPressureInputController.setOrderDiagonosticTestInputController(this);

				bloodPressureCheckBox.setSelected(false);

			}else if (peckFlowCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultPeakFlow", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticPeakFlowInputController peakFlowInputController = (DiagonosticPeakFlowInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				peakFlowInputController.setOrderDiagonosticTestInputController(this);

				peckFlowCheckBox.setSelected(false);

			}else if (pulseOximetryCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultPulseOximetry", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticPulseOximetryInputController pulseOximetryInputController = (DiagonosticPulseOximetryInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				pulseOximetryInputController.setOrderDiagonosticTestInputController(this);

				pulseOximetryCheckBox.setSelected(false);

			}else if (pulmunaryFunctionCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultPulmonaryFunctionTest", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticPulmonaryFunctionTestInputController pulmonaryFunctionTestInputController = (DiagonosticPulmonaryFunctionTestInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				pulmonaryFunctionTestInputController.setOrderDiagonosticTestInputController(this);

				pulmunaryFunctionCheckBox.setSelected(false);

			}else if (tympanometryCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultTympanomentry", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticTympanomentryInputController tympanomentryInputController = (DiagonosticTympanomentryInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				tympanomentryInputController.setOrderDiagonosticTestInputController(this);

				tympanometryCheckBox.setSelected(false);

			}else if (visionTestCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultVisionTesting", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticVisionTestingInputController visionTestingInputController = (DiagonosticVisionTestingInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				visionTestingInputController.setOrderDiagonosticTestInputController(this);

				visionTestCheckBox.setSelected(false);

			}else if (vitalSignCheckBox.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("OrderDiagonosticTestResultvitalSignMonitor", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

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

				DiagonosticVitalSignMonitorInputController vitalSignMonitorInputController = (DiagonosticVitalSignMonitorInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				vitalSignMonitorInputController.setOrderDiagonosticTestInputController(this);

				vitalSignCheckBox.setSelected(false);

			}else if (secondFormCount == formCount) {
				
				genericEMRChartingController.paint(button);
				
				formCount = 0;
				genericEMRChartingController.setOrderTextArea(str);
				genericEMRChartingController.saveAllTextArea();
				new FXFormCommonUtilities().closeForm(doneBtn);


			}
	    
	    	
	    	
	    }
	    
	    
	    public void closeUI(Button button){
	    	new FXFormCommonUtilities().closeForm(button);
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			setDiagonosisTestUI();
			
			
		});
		
		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});
		
		
	}

}
