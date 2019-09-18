package com.ets.controller.gui.emrCharting.exam.neck;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckExamCompInputController Class
 *Description: neckExamComp.fxml GUI Controller class
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
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class NeckExamCompInputController implements Initializable {

	@FXML
	private CheckBox NormalLesionCheck;

	@FXML
	private CheckBox NormalEcchyosisCheck;

	@FXML
	private CheckBox NormalErythemaCheck;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox VisuaAllNormalCheckBox;
	@FXML
	private CheckBox thyroidNormalCheck1;
	@FXML
	private CheckBox VisuaLesionsCheckBox;

	@FXML
	private CheckBox VisuaDiscolorationCheckBox;

	@FXML
	private CheckBox PalpationWarmthCheckBox;

	@FXML
	private CheckBox VisuaErythemaCheckBox;

	@FXML
	private CheckBox VisuaSwellingCheckBox;

	@FXML
	private CheckBox ThyroidDiffuselyCheckBox;

	@FXML
	private CheckBox PalpationLADCheck;

	@FXML
	private CheckBox PalpationTTPCheck;

	@FXML
	private CheckBox PalpationSpasmsCheck;

	@FXML
	private CheckBox PalpationEdemaCheck;

	@FXML
	private CheckBox VisuaEcchyosisCheckBox;

	@FXML
	private CheckBox VisuaAbnormalCheck;

	@FXML
	private TextArea AbnormalText;
	

	@FXML
	private TextArea AbnormalPalpationText;

	@FXML
	private RadioButton negativeRadio;

	@FXML
	private ToggleGroup Ascultation;

	@FXML
	private RadioButton possitiveRadio;

	@FXML
	private CheckBox JugularNotNotedCheck;

	@FXML
	private CheckBox JugularNotedCheck;

	@FXML
	private CheckBox ThyroidMultipleCheckBox;

	@FXML
	private CheckBox ThyroidMassRightCheckBox;

	@FXML
	private CheckBox ThyroidmassLeftCheckBox;

	@FXML
	private CheckBox ThyroidTenderCheckBox;
	@FXML
	private CheckBox  ThyroidNonTenderCheckBox1;

	@FXML
	private TextArea abnormalThyroidText;

	@FXML
	private CheckBox NormalSwellingCheck;

	@FXML
	private CheckBox NormalAtrophyCheck;

	@FXML
	private CheckBox NormalMassesCheck;

	@FXML
	private CheckBox NormalIrregularities;

	@FXML
	private CheckBox PalpationNormalCheck;

	private ExamNeckInputController examNeckInputController;

	public void setExamNeckInputController(ExamNeckInputController examNeckInputController) {
		this.examNeckInputController = examNeckInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examNeckInputController.str);
			examComp.append("\n\nNECK: ");
			examNeckInputController.str = examComp.toString();

			if (VisuaAllNormalCheckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(
						"Visual examination of the neck is normal. no lesions, no discoloration, no ecchymosis, no erythema, "
								+ "no swelling, normal alignment, no atrophy, and no deformity.");
				examNeckInputController.str = str1.toString();

			} else {

				if (VisuaAbnormalCheck.isSelected() || VisuaDiscolorationCheckBox.isSelected()
						|| VisuaEcchyosisCheckBox.isSelected() || VisuaErythemaCheckBox.isSelected()
						|| VisuaLesionsCheckBox.isSelected() || VisuaSwellingCheckBox.isSelected()) {

					StringBuilder str12 = new StringBuilder(examNeckInputController.str);
					str12.append("Visual inspection revealed the following abnormalities: ");
					examNeckInputController.str = str12.toString();

					if (VisuaAbnormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append(" abnormal alignment, ");
						examNeckInputController.str = str1.toString();

					}
					if (VisuaDiscolorationCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("discoloration, ");
						examNeckInputController.str = str1.toString();

					}
					if (VisuaEcchyosisCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("ecchymosis, ");
						examNeckInputController.str = str1.toString();

					}
					if (VisuaErythemaCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("erythema,");
						examNeckInputController.str = str1.toString();

					}
					if (VisuaLesionsCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("lesions,");
						examNeckInputController.str = str1.toString();

					}
					if (VisuaSwellingCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("swelling");
						examNeckInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examNeckInputController.str);
					str11.append(".");
					examNeckInputController.str = str11.toString();

				}

			}

			if (AbnormalText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(AbnormalText.getText());
				examNeckInputController.str = str1.toString();

			}

			if (PalpationNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append("Palpation of neck is normal: no LAD, no tenderness, no warmth, no edema, and no spasms.");
				examNeckInputController.str = str1.toString();

			} else {

				if (PalpationEdemaCheck.isSelected() || PalpationLADCheck.isSelected()
						|| PalpationSpasmsCheck.isSelected() || PalpationTTPCheck.isSelected()
						|| PalpationWarmthCheckBox.isSelected()) {

					StringBuilder str12 = new StringBuilder(examNeckInputController.str);
					str12.append("Palpation revealed the following abnormalities: ");
					examNeckInputController.str = str12.toString();

					if (PalpationEdemaCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("edema, ");
						examNeckInputController.str = str1.toString();

					}
					if (PalpationLADCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("LAD, ");
						examNeckInputController.str = str1.toString();

					}
					if (PalpationSpasmsCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("Spasm, ");
						examNeckInputController.str = str1.toString();

					}
					if (PalpationTTPCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("TTP, ");
						examNeckInputController.str = str1.toString();

					}
					if (PalpationWarmthCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examNeckInputController.str);
						str1.append("Warmth,");
						examNeckInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examNeckInputController.str);
					str11.append(".");
					examNeckInputController.str = str11.toString();

				}

			}

			if (AbnormalPalpationText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(AbnormalPalpationText.getText());
				examNeckInputController.str = str1.toString();

			}

			if (negativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append("Ascultation of neck is negative for carotid bruits. ");
				examNeckInputController.str = str1.toString();

			}
			if (possitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append("Ascultation of neck is positive for carotid bruits.");
				examNeckInputController.str = str1.toString();

			}

			if (JugularNotNotedCheck.isSelected() || JugularNotedCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examNeckInputController.str);
				str11.append("Jugular venous distension: ");
				examNeckInputController.str = str11.toString();

				if (JugularNotNotedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append(" not noted, ");
					examNeckInputController.str = str1.toString();

				}
				if (JugularNotedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("noted.");
					examNeckInputController.str = str1.toString();

				}

				
			}
			
			if (thyroidNormalCheck1.isSelected()) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append("No thyromegaly present.");
				examNeckInputController.str = str1.toString();

			}else{
			
			
			

			if (ThyroidDiffuselyCheckBox.isSelected() || ThyroidmassLeftCheckBox.isSelected()
					|| ThyroidMassRightCheckBox.isSelected() || ThyroidMultipleCheckBox.isSelected()
					|| ThyroidTenderCheckBox.isSelected()) {

				StringBuilder str11 = new StringBuilder(examNeckInputController.str);
				str11.append(" Thyroid ");
				examNeckInputController.str = str11.toString();

				if (ThyroidDiffuselyCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("diffusely enlarged,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidmassLeftCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("mass left,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidMassRightCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("mass right,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidMultipleCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("multiple nodules,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidTenderCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("tender, ");
					examNeckInputController.str = str1.toString();

				}if (ThyroidNonTenderCheckBox1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("non tender");
					examNeckInputController.str = str1.toString();

				}
				
				StringBuilder str12 = new StringBuilder(examNeckInputController.str);
				str12.append(".");
				examNeckInputController.str = str12.toString();

			}
			}
			if (abnormalThyroidText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append(abnormalThyroidText.getText());
				examNeckInputController.str = str1.toString();

			}

			if (NormalAtrophyCheck.isSelected() || NormalEcchyosisCheck.isSelected() || NormalErythemaCheck.isSelected()
					|| NormalIrregularities.isSelected() || NormalLesionCheck.isSelected()
					|| NormalMassesCheck.isSelected() || NormalSwellingCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examNeckInputController.str);
				str11.append(" Examination of the neck is normal for the following: ");
				examNeckInputController.str = str11.toString();

				if (NormalAtrophyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append(" atrophy,");
					examNeckInputController.str = str1.toString();

				}
				if (NormalEcchyosisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append(" eccymosis,");
					examNeckInputController.str = str1.toString();

				}
				if (NormalErythemaCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("erythema,");
					examNeckInputController.str = str1.toString();

				}
				if (NormalIrregularities.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("irregularities,");
					examNeckInputController.str = str1.toString();

				}
				if (NormalLesionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("lesions,");
					examNeckInputController.str = str1.toString();

				}
				if (NormalMassesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("masses,");
					examNeckInputController.str = str1.toString();

				}
				if (NormalSwellingCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append(" swelling,");
					examNeckInputController.str = str1.toString();

				}

			/*	StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append("depressed bridge of nose, ");
				examNeckInputController.str = str1.toString();*/

			}

			++examNeckInputController.formCount;
			examNeckInputController.setNeckUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examNeckInputController.formCount;
				examNeckInputController.setNeckUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
