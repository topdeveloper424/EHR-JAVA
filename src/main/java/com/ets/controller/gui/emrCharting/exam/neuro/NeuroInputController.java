package com.ets.controller.gui.emrCharting.exam.neuro;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.gu.comprehensiveMultiSystem.GUComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.comprehensiveMultiSystem.NeuroComprehensiveMultiSystem;
import com.ets.controller.gui.emrCharting.exam.neuro.cordinationBalance.NeuroCordinationBalanceInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.cranialNerves.NeuroCranialNervesInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.cranialNervesAlternate.NeuroCranialNervesAlternaInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.cranialNervesEval.CranialNervesEvalInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.fundKnowledge.NeuroFundKnowledgeInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.higherFunction.NeuroHigherFunctionInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.knowledgeAttention.NeuroKnowledgeAttentionInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.langSpeech.NeuroLanguageSpeechInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.reflexes.NeuroReflexesInpurController;
import com.ets.controller.gui.emrCharting.exam.neuro.sensReflexCoord.ReflexesSensCoordInputController;
import com.ets.controller.gui.emrCharting.exam.neuro.sensation.NeuroSensationInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeuroInputController Class
 *Description: neuroExam GUI Controller class
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
public class NeuroInputController implements Initializable {

	@FXML
	private CheckBox normalComprehensive;

	@FXML
	private CheckBox examComprehensive;

	@FXML
	private CheckBox higherFunction;

	@FXML
	private CheckBox attentionLang;

	@FXML
	private CheckBox langSpeech;

	@FXML
	private CheckBox fundOfKnowledge;

	@FXML
	private CheckBox cranialNerves;

	@FXML
	private CheckBox coordinationNormal;

	@FXML
	private CheckBox coordinationBalance;

	@FXML
	private CheckBox reflexes;

	@FXML
	private CheckBox sensation;

	@FXML
	private CheckBox migraine;

	@FXML
	private CheckBox cranialNervesEval;

	@FXML
	private CheckBox cranialNervesAlterna;

	@FXML
	private CheckBox reflexSensCoord;

	@FXML
	private Button skipBtn;

	@FXML
	private Button doneBtn;

	private Button button;

	private CheckBox checkBox;

	public static Integer formCount = 0;
	private Integer secondFormCount = 0;
	private Integer flag = 0;
	private Integer flag1 = 0;

	FXMLFormPath formPath = new FXMLFormPath();

	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button, CheckBox checkBox) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
		this.checkBox = checkBox;
	}

	public String str = "\n\n";

	void formCountIncrement() {
		++secondFormCount;
	}

	public void setNeuroUI() {

		if (normalComprehensive.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("NEUROLOGIC:  Neurological exam showed normal reflexes and sensation.  "
					+ "Face was examined for asymmetry caused by Cranial nerve weakness. "
					+ " Patient observed for equal movement of all four extremities. "
					+ " Any sensory deficits were elicited.  No abnormal findings.");
			str = str1.toString();
			normalComprehensive.setSelected(false);
			setNeuroUI();
		}

		else if (examComprehensive.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroComprehensiveMultiSystem", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroComprehensiveMultiSystem", null, Locale.US);

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

			NeuroComprehensiveMultiSystem neuroComprehensiveMultiSystem = (NeuroComprehensiveMultiSystem) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroComprehensiveMultiSystem.setNeuroInputController(this);

			examComprehensive.setSelected(false);

		} else if (higherFunction.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroHigherFunction", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroHigherFunction", null, Locale.US);

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

			NeuroHigherFunctionInputController neuroHigherFunctionInputController = (NeuroHigherFunctionInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroHigherFunctionInputController.setNeuroInputController(this);

			higherFunction.setSelected(false);

		} 
		 else if (cranialNervesEval.isSelected()) {
				formCountIncrement();
				String formName = formPath.context.getMessage("ExamNeuroCranialNervesEval", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ExamNeuroCranialNervesEval", null, Locale.US);

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

				CranialNervesEvalInputController cranialNervesEvalInputController = (CranialNervesEvalInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				cranialNervesEvalInputController.setNeuroInputController(this);

				cranialNervesEval.setSelected(false);

			} 
		else if (cranialNervesAlterna.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroCompExamCarnialAlternate", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroCompExamCarnialAlternate", null, Locale.US);

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

			NeuroCranialNervesAlternaInputController neuroCranialNervesAlternaInputController = (NeuroCranialNervesAlternaInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroCranialNervesAlternaInputController.setNeuroInputController(this);

			cranialNervesAlterna.setSelected(false);

		} else if (reflexSensCoord.isSelected()) {
			
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamSensRelexCoord", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamSensRelexCoord", null, Locale.US);

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

			ReflexesSensCoordInputController reflexesSensCoordInputController = (ReflexesSensCoordInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			reflexesSensCoordInputController.setNeuroInputController(this);

			reflexSensCoord.setSelected(false);

		} else if (attentionLang.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroKnowledgeAttention", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroKnowledgeAttention", null, Locale.US);

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

			NeuroKnowledgeAttentionInputController neuroKnowledgeAttentionInputController = (NeuroKnowledgeAttentionInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroKnowledgeAttentionInputController.setNeuroInputController(this);

			attentionLang.setSelected(false);

		} else if (langSpeech.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroLangSpeech", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroLangSpeech", null, Locale.US);

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

			NeuroLanguageSpeechInputController neuroLanguageSpeechInputController = (NeuroLanguageSpeechInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroLanguageSpeechInputController.setNeuroInputController(this);

			langSpeech.setSelected(false);

		} else if (fundOfKnowledge.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroFundKnowledge", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroFundKnowledge", null, Locale.US);

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

			NeuroFundKnowledgeInputController neuroFundKnowledgeInputController = (NeuroFundKnowledgeInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroFundKnowledgeInputController.setNeuroInputController(this);

			fundOfKnowledge.setSelected(false);

		} else if (cranialNerves.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroCranialNerves", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroCranialNerves", null, Locale.US);

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

			NeuroCranialNervesInputController neuroCranialNervesInputController = (NeuroCranialNervesInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroCranialNervesInputController.setNeuroInputController(this);

			cranialNerves.setSelected(false);

		}
		else if (coordinationNormal.isSelected()) {
			
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Coordination and balance: Romberg negative, tandem gait normal. Finger to nose: normal left and right. Heel / knee / shin normal bilaterally. Dysdiadochokinesis not noted.");
			str = str1.toString();
			coordinationNormal.setSelected(false);
			
			setNeuroUI();

		}else if (coordinationBalance.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroCordinationBalance", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroCordinationBalance", null, Locale.US);

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

			NeuroCordinationBalanceInputController neuroCordinationBalanceInputController = (NeuroCordinationBalanceInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroCordinationBalanceInputController.setNeuroInputController(this);

			coordinationBalance.setSelected(false);

		}else if (reflexes.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroReflexes", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroReflexes", null, Locale.US);

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

			NeuroReflexesInpurController neuroReflexesInpurController = (NeuroReflexesInpurController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroReflexesInpurController.setNeuroInputController(this);

			reflexes.setSelected(false);

		}else if (sensation.isSelected()) {
			formCountIncrement();
			String formName = formPath.context.getMessage("ExamNeuroSensation", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ExamNeuroSensation", null, Locale.US);

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

			NeuroSensationInputController neuroSensationInputController = (NeuroSensationInputController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);
			neuroSensationInputController.setNeuroInputController(this);

			sensation.setSelected(false);

		}else if (migraine.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("NEUROLOGIC: Neurological exam showed normal reflexes and sensation.  Cranial nerves were tested and intact.  Patient exhibited photophobia.");
			str = str1.toString();
			migraine.setSelected(false);
			setNeuroUI();
		}
		else if (secondFormCount == formCount) {

			genericEMRChartingController.paint(button);
			genericEMRChartingController.hideCheckBox(checkBox);
			new FXFormCommonUtilities().closeForm(doneBtn);
			formCount = 0;
			genericEMRChartingController.setExamOrganTextArea(str);
			genericEMRChartingController.saveAllTextArea();

		}

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		doneBtn.setOnAction((event) -> {

			setNeuroUI();

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
