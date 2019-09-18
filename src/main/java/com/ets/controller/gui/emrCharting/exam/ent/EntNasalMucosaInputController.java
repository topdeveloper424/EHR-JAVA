package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntNasalMucosaInputController Class
 *Description: entNasalMucosa.fxml Controller class
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
import javafx.scene.layout.AnchorPane;

public class EntNasalMucosaInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox nasalAllNormalCkeckBox;

	@FXML
	private CheckBox nasalNormalCkeckBox;

	@FXML
	private CheckBox nasalHyperemicCkeckBox;

	@FXML
	private CheckBox nasalLeftCkeckBox;

	@FXML
	private CheckBox nasalRightCkeckBox;

	@FXML
	private CheckBox turbinatesBoggyCheck;

	@FXML
	private CheckBox turbinatesNormalCheck;

	@FXML
	private CheckBox turbinatesSwollenlCheck;

	@FXML
	private CheckBox turbinatesInflamedCheck;

	@FXML
	private CheckBox turbinatesEnlargedCheck;

	@FXML
	private CheckBox nasalRhinorrheaCkeckBox;

	@FXML
	private CheckBox nasalEpistaxisCkeckBox;

	@FXML
	private CheckBox nasalPolypCkeckBox;

	@FXML
	private CheckBox sptumNormalCkeckBox;

	@FXML
	private CheckBox sptumPerforatedCkeckBox;

	@FXML
	private CheckBox sptumMarkedDeviationCkeckBox;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox sptumhematomaCkeckBox;

	private ExamEntInputController examEntInputController;

	public void setExamEntInputController(ExamEntInputController examEntInputController) {
		this.examEntInputController = examEntInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examEntInputController.str);
			examComp.append("\n\n: ");
			examEntInputController.str = examComp.toString();

			if (nasalAllNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Nasal mucosa, septum and turbinates normal. ");
				examEntInputController.str = str1.toString();

			} else {

				if (nasalNormalCkeckBox.isSelected() || nasalLeftCkeckBox.isSelected()
						|| nasalEpistaxisCkeckBox.isSelected() || nasalHyperemicCkeckBox.isSelected()
						|| nasalPolypCkeckBox.isSelected() || nasalRhinorrheaCkeckBox.isSelected()
						|| nasalRightCkeckBox.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Nasal mucosa ");
					examEntInputController.str = str11.toString();

					if (nasalNormalCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("normal, ");
						examEntInputController.str = str1.toString();

					}
					if (nasalLeftCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("left, ");
						examEntInputController.str = str1.toString();

					}
					if (nasalEpistaxisCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("focus of epistaxis, ");
						examEntInputController.str = str1.toString();

					}
					if (nasalHyperemicCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("hyperemic, ");
						examEntInputController.str = str1.toString();

					}
					if (nasalPolypCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("polyp noted, ");
						examEntInputController.str = str1.toString();

					}
					if (nasalRhinorrheaCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("rhinorrhea noted, ");
						examEntInputController.str = str1.toString();

					}
					if (nasalRightCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("right, ");
						examEntInputController.str = str1.toString();

					}

					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();

				}

			}

			if (sptumNormalCkeckBox.isSelected() || sptumhematomaCkeckBox.isSelected()
					|| sptumMarkedDeviationCkeckBox.isSelected() || sptumPerforatedCkeckBox.isSelected()) {

				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("Septum: ");
				examEntInputController.str = str11.toString();

				if (sptumNormalCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("normal, ");
					examEntInputController.str = str1.toString();

				}
				if (sptumhematomaCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("hematoma noted, ");
					examEntInputController.str = str1.toString();

				}
				if (sptumMarkedDeviationCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("marked deviation noted, ");
					examEntInputController.str = str1.toString();

				}
				if (sptumPerforatedCkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("perforated,  ");
					examEntInputController.str = str1.toString();

				}

				StringBuilder str12 = new StringBuilder(examEntInputController.str);
				str12.append(".");
				examEntInputController.str = str12.toString();

			}

			if (turbinatesNormalCheck.isSelected() || turbinatesBoggyCheck.isSelected()
					|| turbinatesEnlargedCheck.isSelected() || turbinatesInflamedCheck.isSelected()
					|| turbinatesSwollenlCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("Turbinates ");
				examEntInputController.str = str11.toString();

				if (turbinatesNormalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("normal, ");
					examEntInputController.str = str1.toString();

				}
				if (turbinatesBoggyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("boggy, ");
					examEntInputController.str = str1.toString();

				}
				if (turbinatesEnlargedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("enlarged, ");
					examEntInputController.str = str1.toString();

				}
				if (turbinatesInflamedCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("inflamed, ");
					examEntInputController.str = str1.toString();

				}
				if (turbinatesSwollenlCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("swollen, ");
					examEntInputController.str = str1.toString();

				}

				StringBuilder str12 = new StringBuilder(examEntInputController.str);
				str12.append(".");
				examEntInputController.str = str12.toString();

			}

			++examEntInputController.formCount;
			examEntInputController.setEntUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examEntInputController.formCount;
				examEntInputController.setEntUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
