package com.ets.controller.gui.emrCharting.exam.resp;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 3-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespExamCompMultiSysInputController Class
 *Description: respExamCompMultiSys.fxml GUI Controller class
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

public class RespExamCompMultiSysInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox PalpationDecreasedVocalRightCheck;

	@FXML
	private CheckBox PalpationNormalVocalCheck;

	@FXML
	private CheckBox PalpationDecreasedVocalLeftCheck;

	@FXML
	private CheckBox PalpationIncreasedVocalRightCheck;

	@FXML
	private CheckBox PercussionNormalCheck;

	@FXML
	private CheckBox PercussionLeftLowerCheck;

	@FXML
	private CheckBox PercussionLeftMidFieldCheck;

	@FXML
	private CheckBox PercussionLeftUpperCheck;

	@FXML
	private CheckBox PercussionRightMidFieldCheck;

	@FXML
	private CheckBox PercussionRightLowerrCheck;

	@FXML
	private CheckBox PercussionRightUpperCheck;

	@FXML
	private RadioButton decreasedRadio;

	@FXML
	private RadioButton asymmetricRadio;

	@FXML
	private CheckBox PercussionAllnormalCheck;

	@FXML
	private TextArea handText;

	@FXML
	private CheckBox PalpationAllNormalCheck;

	@FXML
	private CheckBox PalpationIncreasedVocalLeftCheck;

	@FXML
	private CheckBox AuscultationNormalCheck;

	@FXML
	private CheckBox WheezesNormalCheck;

	@FXML
	private CheckBox WheezesNoPresenceCheck;

	@FXML
	private CheckBox WheezesDiffuseCheck;

	@FXML
	private CheckBox WheezesScatteredCheck;

	@FXML
	private CheckBox WheezesLocalizedCheck;

	@FXML
	private CheckBox provocativeNormal;

	@FXML
	private CheckBox RetractionsNotNotedCheck;

	@FXML
	private CheckBox RetractionsSupraclavicularCheck;

	@FXML
	private CheckBox RetractionsIntercostalsCheck;

	@FXML
	private RadioButton airNormalRadio;

	@FXML
	private ToggleGroup air;

	@FXML
	private RadioButton airDecreasedRadio;

	@FXML
	private RadioButton ratioNormalRadio;

	@FXML
	private ToggleGroup ratio;

	@FXML
	private RadioButton ratioabnormalRadio;

	private ExamRespInputController examRespInputController;

	public void setExamRespInputController(ExamRespInputController examRespInputController) {
		this.examRespInputController = examRespInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examRespInputController.str);
			examComp.append("\n\nRESPIRATORY:  ");
			examRespInputController.str = examComp.toString();

			if (provocativeNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" Examinations of the chest show respiratory excursions normal, and no retractions.");
				examRespInputController.str = str1.toString();

			} else {

				if (decreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("Examinations of the chest show respiratory excursions to be decreased.");
					examRespInputController.str = str1.toString();

				}
				if (asymmetricRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("Examinations of the chest show respiratory excursions to be increased.");
					examRespInputController.str = str1.toString();

				}

			}

			if (RetractionsIntercostalsCheck.isSelected() || RetractionsNotNotedCheck.isSelected()
					|| RetractionsSupraclavicularCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examRespInputController.str);
				str11.append(" Retractions ");
				examRespInputController.str = str11.toString();

				if (RetractionsIntercostalsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("intercostals,");
					examRespInputController.str = str1.toString();

				}
				if (RetractionsNotNotedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("not noted, ");
					examRespInputController.str = str1.toString();

				}
				if (RetractionsSupraclavicularCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("supraclavicular.");
					examRespInputController.str = str1.toString();

				}

			}

			if (PercussionAllnormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append("Chest percussion is normal.");
				examRespInputController.str = str1.toString();

			} else {

				if (PercussionLeftLowerCheck.isSelected() || PercussionLeftMidFieldCheck.isSelected()
						|| PercussionLeftUpperCheck.isSelected() || PercussionNormalCheck.isSelected()
						|| PercussionRightLowerrCheck.isSelected() || PercussionRightMidFieldCheck.isSelected()
						|| PercussionRightUpperCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examRespInputController.str);
					str12.append(" Percussion of the chest shows ");
					examRespInputController.str = str12.toString();

					if (PercussionLeftLowerCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness left upper lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionLeftMidFieldCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness left midfield lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionLeftUpperCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness left upper lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("normal percussion,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionRightLowerrCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" dullness right lower lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionRightMidFieldCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" dullness right midfield lung , ");
						examRespInputController.str = str1.toString();

					}
					if (PercussionRightUpperCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness right upper lung ");
						examRespInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examRespInputController.str);
					str11.append(".");
					examRespInputController.str = str11.toString();

				}

			}

			if (PalpationAllNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" Palpation reveals normal vocal fremitus.");
				examRespInputController.str = str1.toString();

			} else {

				if (PalpationDecreasedVocalLeftCheck.isSelected() || PalpationDecreasedVocalRightCheck.isSelected()
						|| PalpationIncreasedVocalLeftCheck.isSelected()
						|| PalpationIncreasedVocalRightCheck.isSelected() || PalpationNormalVocalCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examRespInputController.str);
					str12.append(" Palpation reveals:");
					examRespInputController.str = str12.toString();

					if (PalpationDecreasedVocalLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("decreased vocal fremitus left,");
						examRespInputController.str = str1.toString();

					}
					if (PalpationDecreasedVocalRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("decreased vocal fremitus right,");
						examRespInputController.str = str1.toString();

					}
					if (PalpationIncreasedVocalLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("increased vocal fremitus left,");
						examRespInputController.str = str1.toString();

					}
					if (PalpationIncreasedVocalRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("increased vocal fremitus right, ");
						examRespInputController.str = str1.toString();

					}
					if (PalpationNormalVocalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("normal vocal fremitus");
						examRespInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examRespInputController.str);
					str11.append(".");
					examRespInputController.str = str11.toString();

				}

			}

			if (AuscultationNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" no crackles/rales/rhonchi. ");
				examRespInputController.str = str1.toString();

			} else {

				if (handText.getText().length() > 0) {

					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append(handText.getText());
					examRespInputController.str = str1.toString();

				}

			}

			if (WheezesNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" ");
				examRespInputController.str = str1.toString();

			} else {

				if (WheezesDiffuseCheck.isSelected() || WheezesLocalizedCheck.isSelected()
						|| WheezesNoPresenceCheck.isSelected() || WheezesScatteredCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examRespInputController.str);
					str12.append(" and no presence of  ");
					examRespInputController.str = str12.toString();

					if (WheezesDiffuseCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("diffuse,");
						examRespInputController.str = str1.toString();

					}
					if (WheezesLocalizedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("localized,");
						examRespInputController.str = str1.toString();

					}
					if (WheezesNoPresenceCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("no presence of, ");
						examRespInputController.str = str1.toString();

					}
					if (WheezesScatteredCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" scattered , ");
						examRespInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examRespInputController.str);
					str11.append(" wheezes.");
					examRespInputController.str = str11.toString();

				}

			}

			if (airNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append("Air movement is normal. ");
				examRespInputController.str = str1.toString();

			}
			if (airDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append("Air movement is decreased. ");
				examRespInputController.str = str1.toString();

			}

			if (ratioNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" and I/E ratio is normal.");
				examRespInputController.str = str1.toString();

			}
			if (ratioabnormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" and I/E ratio is abnormal.");
				examRespInputController.str = str1.toString();

			}

			++examRespInputController.formCount;
			examRespInputController.setRespUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examRespInputController.formCount;
				examRespInputController.setRespUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
