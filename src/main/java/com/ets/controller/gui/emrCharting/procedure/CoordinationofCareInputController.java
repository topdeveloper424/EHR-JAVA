package com.ets.controller.gui.emrCharting.procedure;

/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 01-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CoordinationofCareInputController Class
 *Description: coordination.fxml Controller class
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
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class CoordinationofCareInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox RoutineReferralCheck;

	@FXML
	private CheckBox MedicallyNecessaryCheck;

	@FXML
	private CheckBox erCheck;

	@FXML
	private CheckBox dotCheck;

	@FXML
	private CheckBox EmployerCheck;

	@FXML
	private CheckBox AmbulanceCheck;

	@FXML
	private CheckBox familyFriendCheck;

	@FXML
	private CheckBox erPhysicianCheck;

	@FXML
	private CheckBox OrthopedistCheck;

	@FXML
	private TextArea physicianNameTextArea;

	@FXML
	private TextArea specialityTextarea;

	@FXML
	private TextArea physicianPhoneTextarea;

	@FXML
	private TextArea instructionTextarea;

	private MedicalProcedureInputController medicalProcedureInputController;

	public void setMedicalProcedureInputController(MedicalProcedureInputController medicalProcedureInputController) {
		this.medicalProcedureInputController = medicalProcedureInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder skelComp = new StringBuilder(medicalProcedureInputController.str);
			skelComp.append("\n\n");
			medicalProcedureInputController.str = skelComp.toString();

			if (erCheck.isSelected() || MedicallyNecessaryCheck.isSelected() || RoutineReferralCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient's care was transferred to ");
				medicalProcedureInputController.str = str.toString();

				if (erCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("ER, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (MedicallyNecessaryCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Specialist-Medically Necessary, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (RoutineReferralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("Specialist- Routine Referral, ");
					medicalProcedureInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("\n");
				medicalProcedureInputController.str = str1.toString();

			}

			if (AmbulanceCheck.isSelected() || familyFriendCheck.isSelected() || EmployerCheck.isSelected()
					|| dotCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Patient was transferred via: ");
				medicalProcedureInputController.str = str.toString();

				if (AmbulanceCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("ambulance, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (familyFriendCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("driven by family/friend, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (EmployerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("driven by employer");
					medicalProcedureInputController.str = str1.toString();

				}
				if (dotCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append(" ");
					medicalProcedureInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("\n\n");
				medicalProcedureInputController.str = str1.toString();

			}

			if (physicianNameTextArea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append("Name Of Physician Who Coordinated Care: " + physicianNameTextArea.getText());
				medicalProcedureInputController.str = str1.toString();

			}

			StringBuilder str12 = new StringBuilder(medicalProcedureInputController.str);
			str12.append("\n\n");
			medicalProcedureInputController.str = str12.toString();

			if (erPhysicianCheck.isSelected() || OrthopedistCheck.isSelected() || dotCheck.isSelected()) {

				StringBuilder str = new StringBuilder(medicalProcedureInputController.str);
				str.append("Type of Specialty: ");
				medicalProcedureInputController.str = str.toString();

				if (erPhysicianCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("ER Physician, ");
					medicalProcedureInputController.str = str1.toString();

				}
				if (OrthopedistCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
					str1.append("orthopedist, ");
					medicalProcedureInputController.str = str1.toString();

				}
				

			}

			if (specialityTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Other Speciality- " + specialityTextarea.getText() + "\n\n");
				medicalProcedureInputController.str = str1.toString();

			}

			if (physicianPhoneTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Physician Phone Number: " + physicianPhoneTextarea.getText() + "\n\n");
				medicalProcedureInputController.str = str1.toString();

			}

			if (instructionTextarea.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(medicalProcedureInputController.str);
				str1.append(" Instructions From Physician: " + instructionTextarea.getText() + "\n\n");
				medicalProcedureInputController.str = str1.toString();

			}

			++medicalProcedureInputController.formCount;
			medicalProcedureInputController.setMedUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++medicalProcedureInputController.formCount;
				medicalProcedureInputController.setMedUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
