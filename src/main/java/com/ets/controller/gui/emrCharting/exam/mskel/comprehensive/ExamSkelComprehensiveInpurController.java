package com.ets.controller.gui.emrCharting.exam.mskel.comprehensive;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamSkelComprehensiveInpurController Class
 *Description: Examcomprehensive GUI Controller class
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

import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;

public class ExamSkelComprehensiveInpurController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox gaintNormal;

	@FXML
	private CheckBox gaintNormal2Chekc;

	@FXML
	private CheckBox gaintSpastic;

	@FXML
	private CheckBox gaintLurching;

	@FXML
	private CheckBox gaintBizzare;

	@FXML
	private CheckBox stationNormal;

	@FXML
	private CheckBox stationUndetermine;

	@FXML
	private CheckBox coordinationDecreasedHeel;

	@FXML
	private CheckBox coordinationNormal;

	@FXML
	private CheckBox cooedinationDecreasedOnFinger;

	@FXML
	private CheckBox dysdiadochokinesisInclude;

	@FXML
	private CheckBox NailsNormalNails;

	@FXML
	private CheckBox nailshemorrhaegs;

	@FXML
	private CheckBox nailsAvulsion;

	@FXML
	private CheckBox nailsPitting;

	@FXML
	private CheckBox nailsOnchomycosis;

	@FXML
	private CheckBox toenailsNormal;

	@FXML
	private CheckBox toenailsSubungual;

	@FXML
	private CheckBox NailsNormal;

	@FXML
	private CheckBox gaintClownish;

	@FXML
	private CheckBox gaintHemiplegic;

	@FXML
	private CheckBox gaintSteppage;

	@FXML
	private CheckBox gaintPoorWeight;

	@FXML
	private CheckBox gaintFestinating;

	@FXML
	private CheckBox gaintLimping;

	@FXML
	private CheckBox stationBoardbase;

	@FXML
	private CheckBox nailsTraumatic;

	@FXML
	private CheckBox gaintPoorHeelStrike;

	@FXML
	private CheckBox gaintUnableToWalk;

	@FXML
	private RadioButton dysdiadochokinesisNotTested;

	@FXML
	private RadioButton dysdiadochokinesisNotNoted;

	@FXML
	private RadioButton dysdiadochokinesisNoted;

	@FXML
	private CheckBox nailsParonychia;

	@FXML
	private CheckBox subungualCheck;

	@FXML
	private CheckBox toenailsonchyomycosis;

	@FXML
	private CheckBox toenailsAvulsuion;

	@FXML
	private CheckBox toenailsPitting;

	@FXML
	private CheckBox toenailsTraumatic;

	@FXML
	private CheckBox toenailshemorrhages;

	@FXML
	private CheckBox toenailsIgnownWithInfection;

	private MSkelInputController msSkelInputController;

	public void setMsSkelInputController(MSkelInputController msSkelInputController) {
		this.msSkelInputController = msSkelInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			/*
			 * StringBuilder skelComp = new
			 * StringBuilder(msSkelInputController.str); skelComp.append(
			 * "\n\nGI & ABDOMEN: "); msSkelInputController.str =
			 * skelComp.toString();
			 */

			StringBuilder skelComp = new StringBuilder(msSkelInputController.str);
			skelComp.append("\n\n ");
			msSkelInputController.str = skelComp.toString();

			if (gaintNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(
						"MUSCULOSKELETAL: Patient was noted to be walking normally. Station and coordination normal. ");
				msSkelInputController.str = str1.toString();

			} else {

				if (gaintNormal2Chekc.isSelected() || gaintSteppage.isSelected() || gaintSpastic.isSelected()
						|| gaintClownish.isSelected() || gaintPoorWeight.isSelected()
						|| gaintPoorHeelStrike.isSelected() || gaintHemiplegic.isSelected() || gaintBizzare.isSelected()
						|| gaintLimping.isSelected() || gaintLurching.isSelected() || gaintFestinating.isSelected()
						|| gaintUnableToWalk.isSelected()) {

					StringBuilder str11 = new StringBuilder(msSkelInputController.str);
					str11.append("MUSCULOSKELETAL: Patient's gait was noted to be ");
					msSkelInputController.str = str11.toString();

					if (gaintNormal2Chekc.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("normal, ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintSteppage.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("steppage, ");
						msSkelInputController.str = str1.toString();

					}

					if (gaintSpastic.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("spastic, ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintClownish.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("clownish, ");
						msSkelInputController.str = str1.toString();

					}

					if (gaintPoorWeight.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("with poor weight bearing. ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintPoorHeelStrike.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("with poor heel strike, ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintHemiplegic.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("hemiplegic, ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintBizzare.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("bizarre,  ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintLimping.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("limping, ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintLurching.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("lurching and staggering, ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintFestinating.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("festinating, ");
						msSkelInputController.str = str1.toString();

					}
					if (gaintUnableToWalk.isSelected()) {

						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("unable to walk w/o assistance. ");
						msSkelInputController.str = str1.toString();

					}

				}

			}

			if (stationNormal.isSelected() || stationBoardbase.isSelected() || stationUndetermine.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Station is ");
				msSkelInputController.str = str1.toString();

			}
			if (stationNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("normal, ");
				msSkelInputController.str = str1.toString();

			}
			if (stationBoardbase.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("broad based, ");
				msSkelInputController.str = str1.toString();

			}
			if (stationUndetermine.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("undetermined. ");
				msSkelInputController.str = str1.toString();

			}

			if (coordinationNormal.isSelected() || coordinationDecreasedHeel.isSelected()
					|| cooedinationDecreasedOnFinger.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Coordination is ");
				msSkelInputController.str = str1.toString();

			}
			if (coordinationNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("normal. ");
				msSkelInputController.str = str1.toString();

			}
			if (coordinationDecreasedHeel.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("decreased heel, knee, shin. ");
				msSkelInputController.str = str1.toString();

			}
			if (cooedinationDecreasedOnFinger.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("decreased on finger to nose. ");
				msSkelInputController.str = str1.toString();

			}

			if (dysdiadochokinesisInclude.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Dysdiadochokinesis not noted. ");
				msSkelInputController.str = str1.toString();

			}
			if (dysdiadochokinesisNotTested.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Dysdiadochokinesis not tested. ");
				msSkelInputController.str = str1.toString();

			}
			if (dysdiadochokinesisNotNoted.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Dysdiadochokinesis noted. ");
				msSkelInputController.str = str1.toString();

			}
			if (dysdiadochokinesisNoted.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Dysdiadochokinesis not noted. ");
				msSkelInputController.str = str1.toString();

			}

			if (NailsNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(
						"MUSCULOSKELETAL: Patient's gait was noted to be clownish. Examination showed digits and nails normal. ");
				msSkelInputController.str = str1.toString();

			} else {

				if (NailsNormalNails.isSelected() || nailsOnchomycosis.isSelected() || nailshemorrhaegs.isSelected()
						|| nailsParonychia.isSelected() || nailsPitting.isSelected() || nailsAvulsion.isSelected()
						|| nailsTraumatic.isSelected() || subungualCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append(" Examination of the fingernails showed; ");
					msSkelInputController.str = str1.toString();

				}
				if (NailsNormalNails.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("normal nails, ");
					msSkelInputController.str = str1.toString();

				}
				if (nailsOnchomycosis.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("onychomycosis, ");
					msSkelInputController.str = str1.toString();

				}
				if (subungualCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append(" subungual hematoma, ");
					msSkelInputController.str = str1.toString();

				}
				if (nailshemorrhaegs.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("hemorrhages, ");
					msSkelInputController.str = str1.toString();

				}
				if (nailsParonychia.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("paronychia redness swelling. ");
					msSkelInputController.str = str1.toString();

				}
				if (nailsPitting.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("pitting, ");
					msSkelInputController.str = str1.toString();

				}
				if (nailsAvulsion.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("avulsion ");
					msSkelInputController.str = str1.toString();

				}
				if (nailsTraumatic.isSelected()) {

					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("traumatic deformity, ");
					msSkelInputController.str = str1.toString();

				}

			}

			if (toenailsNormal.isSelected() || toenailsonchyomycosis.isSelected() || toenailsAvulsuion.isSelected()
					|| toenailsSubungual.isSelected() || toenailsPitting.isSelected() || toenailsTraumatic.isSelected()
					|| toenailshemorrhages.isSelected() || toenailsIgnownWithInfection.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Examination of the toenails showed; ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailsNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("normal, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailsonchyomycosis.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("onychomycosis, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailsAvulsuion.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("avulsion, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailsSubungual.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("subungual hematoma, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailsPitting.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("pitting, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailsTraumatic.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("traumatic deformity, ");
				msSkelInputController.str = str1.toString();

			}

			if (toenailshemorrhages.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("hemorrhages, ");
				msSkelInputController.str = str1.toString();

			}
			if (toenailsIgnownWithInfection.isSelected()) {

				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("ingrown with infection. ");
				msSkelInputController.str = str1.toString();

			}
			++msSkelInputController.formCount;
			msSkelInputController.setSkelUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++msSkelInputController.formCount;
				msSkelInputController.setSkelUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
