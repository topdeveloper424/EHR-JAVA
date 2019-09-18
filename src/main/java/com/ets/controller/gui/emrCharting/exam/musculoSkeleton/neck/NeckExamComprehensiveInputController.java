package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck;

/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckExamComprehensiveInputController Class
 *Description: neckExamComprehensie.fxml Controller class
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class NeckExamComprehensiveInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox lowerCheck;

	@FXML
	private CheckBox upperCheck;

	@FXML
	private CheckBox trapiziousCheck;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox paracervicalCheck;

	@FXML
	private CheckBox InspectionEcchymosisCheck;

	@FXML
	private CheckBox InspectionErythemaCheck;

	@FXML
	private CheckBox InspectionSurgicalCheck;

	@FXML
	private CheckBox InspectionWarmthCheck;

	@FXML
	private CheckBox InspectionScarsCheck;

	@FXML
	private CheckBox InspectionIugularCheck;

	@FXML
	private CheckBox spasmCheck;

	@FXML
	private CheckBox InspectionNormalCheck;

	@FXML
	private CheckBox NoTensernesstCheck;

	@FXML
	private CheckBox TendernessCheck;

	@FXML
	private CheckBox PointTensernessCheck;

	@FXML
	private CheckBox TensernessNormalCheck;

	@FXML
	private RadioButton bilateralRadio;

	@FXML
	private ToggleGroup Muscle;

	@FXML
	private RadioButton leftRadio;

	@FXML
	private RadioButton rightRadio;

	@FXML
	private RadioButton suppleRadio;

	@FXML
	private ToggleGroup neck;

	@FXML
	private RadioButton stuffRadio;

	@FXML
	private RadioButton showsRadio;

	@FXML
	private CheckBox neckNormalCheck;

	private ExamMusculotoneNeckInputController examMusculotoneNeckInputController;

	public void setExamMusculotoneNeckInputController(
			ExamMusculotoneNeckInputController examMusculotoneNeckInputController) {
		this.examMusculotoneNeckInputController = examMusculotoneNeckInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneNeckInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneNeckInputController.str = examComp.toString();

			if (InspectionNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneNeckInputController.str);
				str11.append("Examination of the neck reveals no injuries or skin abnormalities.");
				examMusculotoneNeckInputController.str = str11.toString();

			} else {

				if (InspectionEcchymosisCheck.isSelected() || InspectionErythemaCheck.isSelected()
						|| InspectionIugularCheck.isSelected() || InspectionScarsCheck.isSelected()
						|| InspectionSurgicalCheck.isSelected() || InspectionWarmthCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneNeckInputController.str);
					str11.append("Examination of the neck reveals ");
					examMusculotoneNeckInputController.str = str11.toString();

					if (InspectionEcchymosisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("ecchymosis, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (InspectionErythemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("erythema, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (InspectionIugularCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("jugular venous distension, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (InspectionScarsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("scars, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (InspectionSurgicalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("surgical scarring, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (InspectionWarmthCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("warmth, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append(".");
					examMusculotoneNeckInputController.str = str1.toString();

				}

			}

			if (TensernessNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneNeckInputController.str);
				str11.append("There is no tenderness or spasm of the paracervical or trapezius muscles.");
				examMusculotoneNeckInputController.str = str11.toString();

			} else {

				if (NoTensernesstCheck.isSelected() || PointTensernessCheck.isSelected() || TendernessCheck.isSelected()
						|| spasmCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneNeckInputController.str);
					str11.append("There is ");
					examMusculotoneNeckInputController.str = str11.toString();

					if (NoTensernesstCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("no tenderness or spasm, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (PointTensernessCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("point tenderness, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (TendernessCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("tenderness, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (spasmCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("spasm, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}

				}

			}

			if (bilateralRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
				str1.append("over the bilateral.");
				examMusculotoneNeckInputController.str = str1.toString();

			}
			if (rightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
				str1.append("over the right.");
				examMusculotoneNeckInputController.str = str1.toString();

			}

			if (leftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
				str1.append("over the left.");
				examMusculotoneNeckInputController.str = str1.toString();

			}

			if (upperCheck.isSelected() || paracervicalCheck.isSelected() || lowerCheck.isSelected()
					|| trapiziousCheck.isSelected()) {

				
				if (upperCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append("upper, ");
					examMusculotoneNeckInputController.str = str1.toString();

				}
				if (paracervicalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append("paracervical, ");
					examMusculotoneNeckInputController.str = str1.toString();

				}
				if (lowerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append("lower, ");
					examMusculotoneNeckInputController.str = str1.toString();

				}
				if (trapiziousCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append("trapezius  ");
					examMusculotoneNeckInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
				str1.append("muscles.");
				examMusculotoneNeckInputController.str = str1.toString();

			}

			if (neckNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneNeckInputController.str);
				str11.append("Neck is supple. ");
				examMusculotoneNeckInputController.str = str11.toString();

			} else {

				if (suppleRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append("Neck is supple. ");
					examMusculotoneNeckInputController.str = str1.toString();

				}
				if (showsRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append("Neck shows limited range of motion.");
					examMusculotoneNeckInputController.str = str1.toString();

				}
				if (stuffRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
					str1.append("Neck is stuff. ");
					examMusculotoneNeckInputController.str = str1.toString();

				}

			}

			++examMusculotoneNeckInputController.formCount;
			examMusculotoneNeckInputController.setNeckUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneNeckInputController.formCount;
				examMusculotoneNeckInputController.setNeckUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
