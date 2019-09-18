package com.ets.controller.gui.emrCharting.assesment.assesmentDiagonosis;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AssesmentDiagonosisInputController Class
 *Description: emrCharting.fxml Controller class
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
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.assesment.AssessmentEntityController;
import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.assesment.icd10.ICD10SearchController;
import com.ets.controller.gui.icd10.ICD10ViewController;
import com.ets.model.Assesment;
import com.ets.model.Icd10Codes;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AssesmentDiagonosisInputController implements Initializable {

	@FXML
	private ChoiceBox<String> bodyPartChoiceBox;

	@FXML
	private RadioButton ChronicityNaRadio;

	@FXML
	private ToggleGroup Chronicity;

	@FXML
	private RadioButton ChronicityChronicRadio;

	@FXML
	private RadioButton ChronicityAcuteRadio;

	@FXML
	private RadioButton ChronicitySelfRadio;

	@FXML
	private RadioButton currentNaRadio;

	@FXML
	private ToggleGroup currentDegree;

	@FXML
	private RadioButton currentControledRadio;

	@FXML
	private RadioButton currentUncontrolledRadio;

	@FXML
	private RadioButton currentQuestionableaRadio;

	@FXML
	private RadioButton firstRowNaRadio;

	@FXML
	private ToggleGroup firstRow;

	@FXML
	private RadioButton firstRowLeftRadio;

	@FXML
	private RadioButton firstRowRightRadio;

	@FXML
	private RadioButton firstRowBilateralRadio;

	@FXML
	private RadioButton secondRowNaRadio;

	@FXML
	private ToggleGroup secondRow;

	@FXML
	private RadioButton thirdRowNaRadio;

	@FXML
	private ToggleGroup thirdRow;

	@FXML
	private ToggleGroup fourthRow;

	@FXML
	private RadioButton fifthRowNaRadio;

	@FXML
	private ToggleGroup fifthRow;

	@FXML
	private RadioButton secondRowDorsalRadio;

	@FXML
	private RadioButton thirdRowMedicalRadio;

	@FXML
	private RadioButton fourthRowAnteriorRadio;

	@FXML
	private RadioButton fifthRowProximalRadio;

	@FXML
	private RadioButton secondRowPlanterRadio;

	@FXML
	private RadioButton thirdRowLateralRadio;

	@FXML
	private RadioButton fourthRowPosteriorRadio;

	@FXML
	private RadioButton fifthRowDistalRadio;

	@FXML
	private RadioButton InteractableNaRadio;

	@FXML
	private ToggleGroup Interactable;

	@FXML
	private RadioButton InteractableYesRadio;

	@FXML
	private RadioButton InteractableNoRadio;

	@FXML
	private CheckBox minorCheckBox;

	@FXML
	private CheckBox unComplecatedCheckBox;

	@FXML
	private CheckBox complecatedCheckBox;

	@FXML
	private CheckBox systematicCheckBox;

	@FXML
	private CheckBox midExacerbationCheckBox;

	@FXML
	private CheckBox severeExacerbationv;

	@FXML
	private CheckBox lifeThreateringCheckBox;

	@FXML
	private CheckBox resolvedCheckBox;

	@FXML
	private CheckBox stableCheckBox;

	@FXML
	private CheckBox improvedCheckBox;

	@FXML
	private CheckBox worseningCheckBox;

	@FXML
	private CheckBox additionalWorkCheckBox;

	@FXML
	private CheckBox noAdditionalWorkCheckBox;

	@FXML
	private RadioButton assesmentNaRadio;

	@FXML
	private ToggleGroup AssesmentTiming;

	@FXML
	private RadioButton assesmentInitialRadio;

	@FXML
	private RadioButton assesmentSubsequentRadio;

	@FXML
	private RadioButton assesmentSequelaRadio;

	@FXML
	private TextField assesmentText;

	@FXML
	private TextField icd10Text;

	@FXML
	private Button icd10Btn;

	@FXML
	private TextField snomedctText;

	@FXML
	private Button snomedctBtn;

	@FXML
	private TextArea causeOfInjuryText;

	@FXML
	private TextArea timeOfInjuryText;

	@FXML
	private TextArea physicialLocationInjuryText;

	@FXML
	private RadioButton specialSecurityRadio;

	@FXML
	private ToggleGroup AssesmentTiming1;

	@FXML
	private RadioButton eapAccessRadio;

	@FXML
	private RadioButton personalHealthRadio;

	@FXML
	private RadioButton minimalRadio;

	@FXML
	private ToggleGroup AssesmentTiming11;

	@FXML
	private RadioButton lowRadio;

	@FXML
	private RadioButton moderateRadio;

	@FXML
	private RadioButton highRadio;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	public void setIcd10Text() {

		assesmentText.setText(ICD10SearchController.icd10Description);
		icd10Text.setText(ICD10SearchController.icd10Code);
	}

	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController) {
		this.genericEMRChartingController = genericEMRChartingController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	private String str = null;

	public void setIcd10(Icd10Codes icd10Codes) {

		icd10Text.setText(icd10Codes.getCode());
		assesmentText.setText(icd10Codes.getDescrip());

		Assesment assesment = new Assesment();
		assesment.setIcd10(icd10Codes);

		assesment.setPatient(Global.patient);
		assesment.setPatientVisit(Global.patientVisitObj);
		new AssessmentEntityController().saveOrUpdate(assesment);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		setIcd10Text();

		List<String> bodyPartList = new ArrayList<String>();

		bodyPartList.add("Abdomen");
		bodyPartList.add("Abdomen-LLQ");
		bodyPartList.add("Abdomen-RUQ");
		bodyPartList.add("Abdomen-LUQ");
		bodyPartList.add("Abdomen-Midline");
		bodyPartList.add("Abdomen-RLQ");
		bodyPartList.add("Ankle");
		bodyPartList.add("Back");
		bodyPartList.add("Lower Leg");
		bodyPartList.add("Breast");
		bodyPartList.add("Buttock");
		bodyPartList.add("Calf");
		bodyPartList.add("Cervical Spine");
		bodyPartList.add("Chest");
		bodyPartList.add("Coccyx");
		bodyPartList.add("Ear");
		bodyPartList.add("Elbow");
		bodyPartList.add("Eye");
		bodyPartList.add("Eyelid");
		bodyPartList.add("Face");
		bodyPartList.add("Fingers");
		bodyPartList.add("Finger-Fifth");
		bodyPartList.add("Finger-Fourth");
		bodyPartList.add("Finger-Second");
		bodyPartList.add("Finger-Third");
		bodyPartList.add("Foot");
		bodyPartList.add("Forearm");
		bodyPartList.add("Gluteal fold");
		bodyPartList.add("Groin");
		bodyPartList.add("Hand");
		bodyPartList.add("Head");
		bodyPartList.add("Heel");
		bodyPartList.add("Hip");
		bodyPartList.add("Ischail");
		bodyPartList.add("Knee");
		bodyPartList.add("Lower Leg");
		bodyPartList.add("Lumbar Spine");
		bodyPartList.add("Metatarsal Head");
		bodyPartList.add("Neck");
		bodyPartList.add("Nose");
		bodyPartList.add("Other");
		bodyPartList.add("Penis");
		bodyPartList.add("Perinum");
		bodyPartList.add("Pre-Tibial");
		bodyPartList.add("Sacral");
		bodyPartList.add("Scapula");
		bodyPartList.add("Scrotum");
		bodyPartList.add("Shoulder");
		bodyPartList.add("Thoracis Spine");
		bodyPartList.add("Thorax");
		bodyPartList.add("Thumb");
		bodyPartList.add("Toe Fifth");
		bodyPartList.add("Toe Fourth");
		bodyPartList.add("Toe Great");
		bodyPartList.add("Toe Second");
		bodyPartList.add("Toe Third");
		bodyPartList.add("Toe");
		bodyPartList.add("Trochanter");
		bodyPartList.add("Upper Arm");
		bodyPartList.add("Upper Leg");
		bodyPartList.add("Vaginal");
		bodyPartList.add("Wrist");

		ObservableList bodyPartObservList = FXCollections.observableList(bodyPartList);

		// workStatusChoiceBox.getItems().clear();
		bodyPartChoiceBox.setItems(bodyPartObservList);

		doneBtn.setOnAction((event) -> {
			try {

				str = assesmentText.getText();
				// genericEMRChartingController.setAssesmentTextArea(assesmentText.getText());
				/*
				 * if(){ genericEMRChartingController.setAssesmentTextArea(); }
				 */

				if (ChronicityChronicRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" chronic, ");
					str = str1.toString();

				}
				if (ChronicityAcuteRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" acute, ");
					str = str1.toString();

				}
				if (ChronicitySelfRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" Self Limited, ");
					str = str1.toString();

				}
				
				
				if (firstRowLeftRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("left, ");
					str = str1.toString();

				}if (firstRowRightRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Right, ");
					str = str1.toString();

				}if (firstRowBilateralRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Bilateral, ");
					str = str1.toString();

				}
				
				if (secondRowDorsalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Dorsal, ");
					str = str1.toString();

				}
				if (secondRowPlanterRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Planter, ");
					str = str1.toString();

				}if (thirdRowMedicalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Medial, ");
					str = str1.toString();

				}
				if (thirdRowLateralRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Lateral, ");
					str = str1.toString();

				}
				if (fourthRowAnteriorRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Anterior, ");
					str = str1.toString();

				}
				if (fourthRowPosteriorRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Posterior, ");
					str = str1.toString();

				} 
				if (fifthRowDistalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Distal, ");
					str = str1.toString();

				} if (fifthRowProximalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Proximal, ");
					str = str1.toString();

				} 
				
	
				

				if (currentControledRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" currently appearing controlled.");
					str = str1.toString();

				}
				if (currentUncontrolledRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" currently uncontrolled.");
					str = str1.toString();

				}
				
				if (currentQuestionableaRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("under questionable degree of control.");
					str = str1.toString();

				}
				//*****
				if (minorCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Condition minor. ");
					str = str1.toString();
					
					

				} 
				if (unComplecatedCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Condition uncomplicated. ");
					str = str1.toString();

				} 
				
				if (complecatedCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Condition complicated. ");
					str = str1.toString();

				} 
				if (systematicCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" exhibiting systemic symptoms. ");
					str = str1.toString();

				} 
				if (midExacerbationCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Condition showing mild exacerbation.");
					str = str1.toString();

				} 
				if (severeExacerbationv.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append("Condition showing severe exacerbation. ");
					str = str1.toString();

				} 
				if (lifeThreateringCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" Condition life threatening. ");
					str = str1.toString();

				} 
				
				//********
				if (resolvedCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" Condition resolved, ");
					str = str1.toString();

				} if (stableCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(" Condition stable, ");
					str = str1.toString();

				} if (improvedCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(str);
					str1.append(". Condition Improved, ");
					str = str1.toString();

				} 
				 if (worseningCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append("Condition Worsening, ");
						str = str1.toString();

					} 
				 if (additionalWorkCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append("Additional work-up required. ");
						str = str1.toString();

					} 
				
				 
				 if (noAdditionalWorkCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append(" No additional work-up required. ");
						str = str1.toString();

					} 
				 
					
					if (InteractableNoRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append("Intractable pain - absent, ");
						str = str1.toString();

					} 
					if (InteractableYesRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append("Intractable pain - present, ");
						str = str1.toString();

					} 
					
				
				 
				 if (causeOfInjuryText.getText().length() > 0) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append("Cause of Injury is  " +causeOfInjuryText.getText()+".");
						str = str1.toString();

					}
				 if (timeOfInjuryText.getText().length() > 0) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append(" Activity at time of injury was  " +timeOfInjuryText.getText()+".");
						str = str1.toString();

					}
				 
				 if (physicialLocationInjuryText.getText().length() > 0) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append(" Physical location where injury occurred was " +physicialLocationInjuryText.getText()+".");
						str = str1.toString();

					}
				 
				 if (assesmentSequelaRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append(" Assessment Type: Sequela. ");
						str = str1.toString();

					} 
				 if (assesmentSubsequentRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append(" Assessment Type: Subsequent. ");
						str = str1.toString();

					} 
				 if (assesmentInitialRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(str);
						str1.append(" Assessment Type: Initial. ");
						str = str1.toString();

					} 
				genericEMRChartingController.setAssesmentTextArea(str);
				genericEMRChartingController.saveAllTextArea();
				genericEMRChartingController.viewAssesmenttable();
				new FXFormCommonUtilities().closeForm(doneBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd10Btn.setOnAction((event) -> {

			try {

				String formName = formPath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD10", null, Locale.US);
				formPath.closeApplicationContext();
				ICD10ViewController icd10ViewController = (ICD10ViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				icd10ViewController.setAssesmentDiagonosisInputController(this);
				// providerViewController.setPatientInputController(this,
				// PrimaryCareButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		skipBtn.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
