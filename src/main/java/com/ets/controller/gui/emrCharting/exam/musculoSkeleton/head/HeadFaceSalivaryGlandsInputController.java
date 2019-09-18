package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.head;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HeadFaceSalivaryGlandsInputController Class
 *Description: headFacesalivaryGlands GUI Controller class
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
public class HeadFaceSalivaryGlandsInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox salivaryMoistlCheck;

	@FXML
	private CheckBox salivaryDryCheck;

	@FXML
	private CheckBox salivaryStomatitisCheck;

	@FXML
	private CheckBox salivaryLessionCheck;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox swellingLeftCheckBox;

	@FXML
	private CheckBox swellingRightCheckBox;

	@FXML
	private CheckBox swellingBilaterallyCheckBox;

	@FXML
	private CheckBox swellingMassCheckBox;

	@FXML
	private CheckBox salivaryTenderCheck;

	@FXML
	private CheckBox salivaryHardCheck;

	@FXML
	private CheckBox salivaryNormalCheck;

	private ExamMusculotoneHeadInputController examMusculotoneHeadInputController;

	public void setExamMusculotoneHeadInputController(
			ExamMusculotoneHeadInputController examMusculotoneHeadInputController) {
		this.examMusculotoneHeadInputController = examMusculotoneHeadInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneHeadInputController.str);
			examComp.append("\n\n");
			examMusculotoneHeadInputController.str = examComp.toString();

			if (salivaryNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("Salivary glands are normal, ");
				examMusculotoneHeadInputController.str = str1.toString();

			} else {

				if (salivaryDryCheck.isSelected() || salivaryHardCheck.isSelected() || salivaryLessionCheck.isSelected()
						|| salivaryMoistlCheck.isSelected() || salivaryStomatitisCheck.isSelected()
						|| salivaryTenderCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
					str11.append("Salivary glands ");
					examMusculotoneHeadInputController.str = str11.toString();

					if (salivaryDryCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("dry, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryHardCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("hard, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryLessionCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("lession, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryMoistlCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("moist, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryStomatitisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("stomatitis, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryTenderCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("tender, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(". ");
					examMusculotoneHeadInputController.str = str1.toString();

				}

			

				if (swellingBilaterallyCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("bilaterally, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (swellingLeftCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("left, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (swellingRightCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("right, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				
			}
			++examMusculotoneHeadInputController.formCount;
			examMusculotoneHeadInputController.setHeadUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneHeadInputController.formCount;
				examMusculotoneHeadInputController.setHeadUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
