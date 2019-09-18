package com.ets.controller.gui.emrCharting.exam.cv;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CvArteriesCarotidsInputController Class
 *Description: cvArteriesCarotids GUI Controller class
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
public class CvArteriesCarotidsInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox carotidsAllNormalCheckBox;

	@FXML
	private CheckBox carotidsNormalBilaterallyCheckBox;

	@FXML
	private CheckBox carotidsLeftNormalCheckBox;

	@FXML
	private CheckBox carotidsLeftDecreasedCheckBox;

	@FXML
	private CheckBox carotidsRightNormalCheckBox;

	@FXML
	private CheckBox carotidsRightDecreasedCheckBox;

	@FXML
	private RadioButton noBruitsRadio;

	@FXML
	private ToggleGroup bruits;

	@FXML
	private RadioButton bilateralBruitsRadio;

	@FXML
	private RadioButton leftBruitsRadio;

	@FXML
	private RadioButton rightBruitsRadio;

	private ExamCvInputController examCvInputController;

	public void setExamCvInputController(ExamCvInputController examCvInputController) {
		this.examCvInputController = examCvInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examCvInputController.str);
			examComp.append("\n\n:CV ");
			examCvInputController.str = examComp.toString();

			if (carotidsAllNormalCheckBox.isSelected()) {

				StringBuilder str12 = new StringBuilder(examCvInputController.str);
				str12.append("Carotids are normal bilaterally. ");
				examCvInputController.str = str12.toString();

			} else {

				if (carotidsLeftDecreasedCheckBox.isSelected() || carotidsLeftNormalCheckBox.isSelected()
						|| carotidsNormalBilaterallyCheckBox.isSelected() || carotidsRightDecreasedCheckBox.isSelected()
						|| carotidsRightNormalCheckBox.isSelected()) {

					StringBuilder str12 = new StringBuilder(examCvInputController.str);
					str12.append("Carotids are ");
					examCvInputController.str = str12.toString();

					if (carotidsLeftDecreasedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("left decreased, ");
						examCvInputController.str = str1.toString();

					}
					if (carotidsLeftNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("left normal, ");
						examCvInputController.str = str1.toString();

					}
					if (carotidsNormalBilaterallyCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("normal bilaterally, ");
						examCvInputController.str = str1.toString();

					}
					if (carotidsRightDecreasedCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("right decreased, ");
						examCvInputController.str = str1.toString();

					}
					if (carotidsRightNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("right normal, ");
						examCvInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append(".");
					examCvInputController.str = str11.toString();

				}

			}

			if (noBruitsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with no bruits noted. ");
				examCvInputController.str = str1.toString();

			}
			if (bilateralBruitsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with bilateral bruits noted.");
				examCvInputController.str = str1.toString();

			}
			if (rightBruitsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with bilateral right bruits noted.");
				examCvInputController.str = str1.toString();

			}
			if (leftBruitsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with bilateral left bruits noted.");
				examCvInputController.str = str1.toString();

			}
			

			++examCvInputController.formCount;
			examCvInputController.setCvUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examCvInputController.formCount;
				examCvInputController.setCvUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
