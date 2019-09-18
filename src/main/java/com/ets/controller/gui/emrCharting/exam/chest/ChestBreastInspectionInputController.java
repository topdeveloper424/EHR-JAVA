package com.ets.controller.gui.emrCharting.exam.chest;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ChestBreastInspectionInputController Class
 *Description: BreastInspection.fxml Controller class
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

public class ChestBreastInspectionInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox skinLesionsCheck;

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
	private CheckBox noAbnormalitiesRight;

	@FXML
	private CheckBox nippleRight;

	@FXML
	private CheckBox superiorRight;

	@FXML
	private CheckBox dimplingRight;

	@FXML
	private CheckBox medialRight;

	@FXML
	private CheckBox inferiorRight;

	@FXML
	private CheckBox chargesRight;

	@FXML
	private CheckBox lateralRight;

	private ExamChestInputController examChestInputController;

	public void setExamChestInputController(ExamChestInputController examChestInputController) {
		this.examChestInputController = examChestInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examChestInputController.str);
			examComp.append("\n\n");
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

			

			if (noAbnormalitiesRight.isSelected() || nippleRight.isSelected() || superiorRight.isSelected()
					|| dimplingRight.isSelected() || medialRight.isSelected() || inferiorRight.isSelected()
					|| chargesRight.isSelected() || lateralRight.isSelected()) {

				StringBuilder str12 = new StringBuilder(examChestInputController.str);
				str12.append(" Inspection reveals no abnormalities bilaterally. right: ");
				examChestInputController.str = str12.toString();

				if (noAbnormalitiesRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("no abnormalities, ");
					examChestInputController.str = str1.toString();

				}
				if (nippleRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("nipple retraction, ");
					examChestInputController.str = str1.toString();

				}
				if (superiorRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("superior, ");
					examChestInputController.str = str1.toString();

				}
				if (dimplingRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("dimpling, ");
					examChestInputController.str = str1.toString();

				}
				if (medialRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("medial, ");
					examChestInputController.str = str1.toString();

				}
				if (inferiorRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append("inferior, ");
					examChestInputController.str = str1.toString();

				}
				if (chargesRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append(" peau d'orange changes, ");
					examChestInputController.str = str1.toString();

				}
				if (lateralRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examChestInputController.str);
					str1.append(" lateral,");
					examChestInputController.str = str1.toString();

				}

				StringBuilder str11 = new StringBuilder(examChestInputController.str);
				str11.append(".");
				examChestInputController.str = str11.toString();

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
