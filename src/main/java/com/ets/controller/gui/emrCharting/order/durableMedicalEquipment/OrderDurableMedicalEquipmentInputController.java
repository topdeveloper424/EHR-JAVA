package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DurableMedicalEquipmentInputController Class
 *Description: durableMedicalEquipment.fxm GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.order.consult.ConsultAcupunctureReferalInputController;
import com.ets.controller.gui.emrCharting.order.consult.ConsultErTransferInputController;
import com.ets.controller.gui.emrCharting.order.consult.ConsultPcpUcInputController;
import com.ets.controller.gui.emrCharting.order.durableMedicalEquipment.smartForm.SmartFormInputController;
import com.ets.controller.gui.emrCharting.pmh.socialHistory.PMHAlcoholInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrderDurableMedicalEquipmentInputController implements Initializable {
	
	@FXML
    private CheckBox licCheckBox;

    @FXML
    private CheckBox wcCheckBox;

    @FXML
    private CheckBox backTorsoCheckBox;

    @FXML
    private CheckBox cervicalSpineCheckBox;

    @FXML
    private CheckBox elbowCheckBox;

    @FXML
    private CheckBox footCheckBox;

    @FXML
    private CheckBox handCheckBox;

    @FXML
    private CheckBox kneeCheckBox;

    @FXML
    private CheckBox lSpineCheckBox;

    @FXML
    private CheckBox lowerLegCheckBox;

    @FXML
    private CheckBox shoulderCheckBox;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;
    
    private Button button;
    
    FXMLFormPath formPath = new FXMLFormPath();
    
    private GenericEMRChartingController genericEMRChartingController;
    
    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}
    
   

	public static Integer formCount = 0;

	private Integer secondFormCount = 0;

	public static String str = "\n\n";


	void formCountIncrement() {
		++secondFormCount;
	}
    
    public void setDurableMedicalEquipmentModelUI(){
    	
    	if(licCheckBox.isSelected()){
			
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentDMEDispenseUC", null, Locale.US);

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

			DurableMedicalDMEDispenseUCInputController durableMedicalDMEDispenseUCInputController = (DurableMedicalDMEDispenseUCInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalDMEDispenseUCInputController.setOrderDurableMedicalEquipmentInputController(this);

			licCheckBox.setSelected(false);
			
		}
    	else if (wcCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentDMEDispenceWC", null, Locale.US);

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

			DurableMedicalDMEDispenceWCInputController durableMedicalDMEDispenceWCInputController = (DurableMedicalDMEDispenceWCInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalDMEDispenceWCInputController.setOrderDurableMedicalEquipmentInputController(this);

			wcCheckBox.setSelected(false);

		}
		else if (backTorsoCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentDmeDispenseBackTorso", null, Locale.US);

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

			DurableMedicalDmeDispenseBackTorsoInputController durableMedicalDmeDispenseBackTorsoInputController = (DurableMedicalDmeDispenseBackTorsoInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalDmeDispenseBackTorsoInputController.setOrderDurableMedicalEquipmentInputController(this);

			backTorsoCheckBox.setSelected(false);

		}
    	
		else if (cervicalSpineCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthoDMECervicalSpine", null, Locale.US);

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

			DurableMedicalOrthoDMECervicalSpineInputController durableMedicalOrthoDMECervicalSpineInputController = (DurableMedicalOrthoDMECervicalSpineInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthoDMECervicalSpineInputController.setOrderDurableMedicalEquipmentInputController(this);

			cervicalSpineCheckBox.setSelected(false);

		}
		else if (elbowCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthoDMEelbow", null, Locale.US);

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

			DurableMedicalOrthoDMEelbowInputController durableMedicalOrthoDMEelbowInputController = (DurableMedicalOrthoDMEelbowInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthoDMEelbowInputController.setOrderDurableMedicalEquipmentInputController(this);

			elbowCheckBox.setSelected(false);

		}
    	
		else if (footCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthoMDEFootAnkle", null, Locale.US);

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

			DurableMedicalOrthoMDEFootAnkleInputController durableMedicalOrthoMDEFootAnkleInputController = (DurableMedicalOrthoMDEFootAnkleInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthoMDEFootAnkleInputController.setOrderDurableMedicalEquipmentInputController(this);

			footCheckBox.setSelected(false);

		}
		
    	
		else if (handCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthoDMEHandWrist", null, Locale.US);

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

			DurableMedicalOrthoDMEHandWristInputController durableMedicalOrthoDMEHandWristInputController = (DurableMedicalOrthoDMEHandWristInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthoDMEHandWristInputController.setOrderDurableMedicalEquipmentInputController(this);

			handCheckBox.setSelected(false);

		}
		else if (kneeCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthoDMEKnee", null, Locale.US);

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

			DurableMedicalOrthoDMEKneeInputController durableMedicalOrthoDMEKneeInputController = (DurableMedicalOrthoDMEKneeInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthoDMEKneeInputController.setOrderDurableMedicalEquipmentInputController(this);

			kneeCheckBox.setSelected(false);

		}
    	
		else if (lSpineCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthDMELspine", null, Locale.US);

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

			DurableMedicalOrthDMELspineInputController durableMedicalOrthDMELspineInputController = (DurableMedicalOrthDMELspineInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthDMELspineInputController.setOrderDurableMedicalEquipmentInputController(this);

			lSpineCheckBox.setSelected(false);

		}
		else if (lowerLegCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthoDMELowerLeg", null, Locale.US);

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

			DurableMedicalOrthoDMELowerLegInputController durableMedicalOrthoDMELowerLegInputController = (DurableMedicalOrthoDMELowerLegInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthoDMELowerLegInputController.setOrderDurableMedicalEquipmentInputController(this);

			lowerLegCheckBox.setSelected(false);

		}
    	
		else if (shoulderCheckBox.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("OrderDurableMedicalEquipmentOrthoDMRShoulder", null, Locale.US);

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

			DurableMedicalOrthoDMRShoulderInputController durableMedicalOrthoDMRShoulderInputController = (DurableMedicalOrthoDMRShoulderInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			durableMedicalOrthoDMRShoulderInputController.setOrderDurableMedicalEquipmentInputController(this);

			shoulderCheckBox.setSelected(false);

		}
    	
		else if (secondFormCount == formCount) {

			genericEMRChartingController.paint(button);

			formCount = 0;
			genericEMRChartingController.setOrderTextArea(str);
			genericEMRChartingController.saveAllTextArea();
			new FXFormCommonUtilities().closeForm(doneBtn);

		}
    	
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {
			try {
				
				setDurableMedicalEquipmentModelUI();
				
			} catch (Exception ex) {
				ex.printStackTrace();
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
