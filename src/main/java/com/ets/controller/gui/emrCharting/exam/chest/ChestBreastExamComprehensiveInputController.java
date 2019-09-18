package com.ets.controller.gui.emrCharting.exam.chest;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamChestInputController Class
 *Description: BreastExamComprehensive.fxml Controller class
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

public class ChestBreastExamComprehensiveInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox skinLesionsCheck;

	@FXML
	private CheckBox leftWithoutMasses;

	@FXML
	private CheckBox leftFixed;

	@FXML
	private CheckBox leftSolitary;

	@FXML
	private CheckBox leftMobile;

	@FXML
	private CheckBox leftMultipleMasses;

	@FXML
	private CheckBox leftHard;

	@FXML
	private CheckBox leftCystic;

	@FXML
	private CheckBox leftMedially;

	@FXML
	private CheckBox axillaryNormal;

	@FXML
	private CheckBox noAbnormalitiesleft;

	@FXML
	private CheckBox nippleLeft;

	@FXML
	private CheckBox superiorLeft;

	@FXML
	private CheckBox dimplingLeft;

	@FXML
	private CheckBox medialleft;

	@FXML
	private CheckBox inferiorleft;

	@FXML
	private CheckBox chargesleft;

	@FXML
	private CheckBox lateralleft;

	@FXML
	private CheckBox skinLesionsCheck2;

	@FXML
	private CheckBox leftSuperior;

	@FXML
	private CheckBox leftInferior;

	@FXML
	private CheckBox leftLaterally;

	@FXML
	private RadioButton axillaryNotNoted;

	@FXML
	private RadioButton axillaryNotedLeft;

	@FXML
	private RadioButton axillaryNotedRight;

	@FXML
	private CheckBox findingBilaterally;

	@FXML
	private CheckBox findingaxillary;

	@FXML
	private CheckBox noAbnormalitiesRight;

	@FXML
	private CheckBox nippleRight1;

	@FXML
	private CheckBox superiorRight1;

	@FXML
	private CheckBox dimplingRight1;

	@FXML
	private CheckBox medialRight1;

	@FXML
	private CheckBox inferiorRight1;

	@FXML
	private CheckBox chargesRight1;

	@FXML
	private CheckBox lateralRight1;

	@FXML
	private CheckBox rightWithoutMasses1;

	@FXML
	private CheckBox rightFixed1;

	@FXML
	private CheckBox rightCystic1;

	@FXML
	private CheckBox rightSuperior1;

	@FXML
	private CheckBox rightMobile1;

	@FXML
	private CheckBox rightMedially1;

	@FXML
	private CheckBox rightInferior1;

	@FXML
	private CheckBox rightLaterally1;

	@FXML
	private CheckBox rightSolitary1;

	@FXML
	private CheckBox rightMultipleMasses1;

	@FXML
	private CheckBox rightHard1;

	private ExamChestInputController examChestInputController;

	public void setExamChestInputController(ExamChestInputController examChestInputController) {
		this.examChestInputController = examChestInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examChestInputController.str);
			examComp.append("\n\nBREASTS:  ");
			examChestInputController.str = examComp.toString();

			if (skinLesionsCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examChestInputController.str);
				str1.append("Breast inspection reveals no abnormalities bilaterally.");
				examChestInputController.str = str1.toString();

			} else {

				if (noAbnormalitiesleft.isSelected() || nippleLeft.isSelected() || superiorLeft.isSelected()
						|| dimplingLeft.isSelected() || medialleft.isSelected() || inferiorleft.isSelected()
						|| chargesleft.isSelected() || lateralleft.isSelected()) {

					StringBuilder str12 = new StringBuilder(examChestInputController.str);
					str12.append(" Inspection shows left: ");
					examChestInputController.str = str12.toString();

					if (noAbnormalitiesleft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("no abnormalities,");
						examChestInputController.str = str1.toString();

					}
					if (nippleLeft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("nipple retraction,");
						examChestInputController.str = str1.toString();

					}
					if (superiorLeft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("superior,");
						examChestInputController.str = str1.toString();

					}
					if (dimplingLeft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("dimpling,");
						examChestInputController.str = str1.toString();

					}
					if (medialleft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append( "medial,");
						examChestInputController.str = str1.toString();

					}
					if (inferiorleft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append(" inferior, ");
						examChestInputController.str = str1.toString();

					}
					if (chargesleft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("peau d'orange changes,");
						examChestInputController.str = str1.toString();

					}
					if (lateralleft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("lateral,");
						examChestInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examChestInputController.str);
					str11.append(".");
					examChestInputController.str = str11.toString();

				}

			}

			if (noAbnormalitiesRight.isSelected() || nippleRight1.isSelected() || superiorRight1.isSelected()
					|| dimplingRight1.isSelected() || medialRight1.isSelected() || inferiorRight1.isSelected()
					|| chargesRight1.isSelected() || lateralRight1.isSelected()) {

				StringBuilder str12 = new StringBuilder(examChestInputController.str);
				str12.append(" Inspection reveals no abnormalities bilaterally. right: ");
				examChestInputController.str = str12.toString();

				if (noAbnormalitiesRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("no abnormalities, ");
					examChestInputController.str = str1.toString();

				}
				if (nippleRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("nipple retraction, ");
					examChestInputController.str = str1.toString();

				}
				if (superiorRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("superior, ");
					examChestInputController.str = str1.toString();

				}
				if (dimplingRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("dimpling, ");
					examChestInputController.str = str1.toString();

				}
				if (medialRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("medial, ");
					examChestInputController.str = str1.toString();

				}
				if (inferiorRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("inferior, ");
					examChestInputController.str = str1.toString();

				}
				if (chargesRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append(" peau d'orange changes, ");
					examChestInputController.str = str1.toString();

				}
				if (lateralRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append(" lateral,");
					examChestInputController.str = str1.toString();

				}

				StringBuilder str11 = new StringBuilder(examChestInputController.str);
				str11.append(".");
				examChestInputController.str = str11.toString();

			}

			if (skinLesionsCheck2.isSelected()) {

				StringBuilder str11 = new StringBuilder(examChestInputController.str);
				str11.append(" Palpation of breasts show no masses bilaterally, and no axillary adenopathy. ");
				examChestInputController.str = str11.toString();

			} else {

				if (leftWithoutMasses.isSelected() || leftFixed.isSelected() || leftCystic.isSelected()
						|| leftSuperior.isSelected() || leftLaterally.isSelected() || leftMobile.isSelected()
						|| leftMedially.isSelected() || leftInferior.isSelected() || leftMultipleMasses.isSelected()
						|| leftSolitary.isSelected() || leftHard.isSelected()) {

					StringBuilder str11 = new StringBuilder(examChestInputController.str);
					str11.append(" Breasts show left: ");
					examChestInputController.str = str11.toString();

					if (leftWithoutMasses.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("without masses,");
						examChestInputController.str = str1.toString();

					}
					if (leftFixed.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("Fixed, ");
						examChestInputController.str = str1.toString();

					}
					if (leftCystic.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("cystic,");
						examChestInputController.str = str1.toString();

					}
					if (leftSuperior.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("superior,");
						examChestInputController.str = str1.toString();

					}
					if (leftLaterally.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("laterally, ");
						examChestInputController.str = str1.toString();

					}
					if (leftMobile.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("mobile, ");
						examChestInputController.str = str1.toString();

					}
					if (leftMedially.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("medially, ");
						examChestInputController.str = str1.toString();

					}
					if (leftInferior.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("inferior, ");
						examChestInputController.str = str1.toString();

					}
					if (leftMultipleMasses.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("multiple masses noted, ");
						examChestInputController.str = str1.toString();

					}
					if (leftSolitary.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("solitary mass noted, ");
						examChestInputController.str = str1.toString();

					}
					if (leftHard.isSelected()) {

						StringBuilder str1 = new StringBuilder(examChestInputController.str);
						str1.append("herd ");
						examChestInputController.str = str1.toString();

					}

					StringBuilder str12 = new StringBuilder(examChestInputController.str);
					str12.append(".");
					examChestInputController.str = str12.toString();

				}

			}

			if (rightWithoutMasses1.isSelected() || rightFixed1.isSelected() || rightCystic1.isSelected()
					|| rightSuperior1.isSelected() || rightLaterally1.isSelected() || rightMobile1.isSelected()
					|| rightMedially1.isSelected() || rightInferior1.isSelected() || rightMultipleMasses1.isSelected()
					|| rightSolitary1.isSelected() || rightHard1.isSelected()) {

				StringBuilder str11 = new StringBuilder(examChestInputController.str);
				str11.append("Breast shows right: ");
				examChestInputController.str = str11.toString();

				if (rightWithoutMasses1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append(" without masses, ");
					examChestInputController.str = str1.toString();

				}
				if (rightFixed1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("fixed, ");
					examChestInputController.str = str1.toString();

				}
				if (rightCystic1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("cystic, ");
					examChestInputController.str = str1.toString();

				}
				if (rightSuperior1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("superior, ");
					examChestInputController.str = str1.toString();

				}
				if (rightLaterally1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("laterally,");
					examChestInputController.str = str1.toString();

				}
				if (rightMobile1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("mobile, ");
					examChestInputController.str = str1.toString();

				}
				if (rightMedially1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("medially, ");
					examChestInputController.str = str1.toString();

				}
				if (rightInferior1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("inferior,");
					examChestInputController.str = str1.toString();

				}
				if (rightMultipleMasses1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append(" multiple masses noted, ");
					examChestInputController.str = str1.toString();

				}
				if (rightSolitary1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append(" solitary mass noted, ");
					examChestInputController.str = str1.toString();

				}
				if (rightHard1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("hard");
					examChestInputController.str = str1.toString();

				}

				StringBuilder str12 = new StringBuilder(examChestInputController.str);
				str12.append(".");
				examChestInputController.str = str12.toString();

			}

			if (axillaryNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examChestInputController.str);
				str1.append("depressed bridge of nose, ");
				examChestInputController.str = str1.toString();

			} else {

				if (axillaryNotNoted.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("Axillary adenopathy not noted. ");
					examChestInputController.str = str1.toString();

				}
				if (axillaryNotedLeft.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("Axillary adenopathy noted left.");
					examChestInputController.str = str1.toString();

				}
				if (axillaryNotedRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("Axillary adenopathy noted right. ");
					examChestInputController.str = str1.toString();

				}

			}

			if (findingBilaterally.isSelected() || findingaxillary.isSelected()) {

				StringBuilder str11 = new StringBuilder(examChestInputController.str);
				str11.append("Examination of the breasts is normal for the following: ");
				examChestInputController.str = str11.toString();

				if (findingBilaterally.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("masses bilaterally,");
					examChestInputController.str = str1.toString();

				}
				if (findingaxillary.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("axillary adenopathy.");
					examChestInputController.str = str1.toString();

				}

			}

			++examChestInputController.formCount;
			examChestInputController.setChestUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examChestInputController.formCount;
				examChestInputController.setChestUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
