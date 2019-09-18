package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.back;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 21-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BackSpecialTestInputController Class
 *Description: backSpecialTest.fxml Controller class
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

public class BackSpecialTestInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox sittingPossitiveRightCheck;

	@FXML
	private CheckBox sittingNegativeRightCheck;

	@FXML
	private CheckBox sittingPossitiveLefttCheck;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox sittingNegativeLeftCheck;

	@FXML
	private CheckBox slrNormalCheck;

	@FXML
	private RadioButton slrNegativeRadio;

	@FXML
	private RadioButton slrPossitiveRadio;
	
	 @FXML
	    private ToggleGroup slr;

	@FXML
	private TextField crossOverText;

	@FXML
	private TextField rightText;

	@FXML
	private TextField leftText;

	@FXML
	private CheckBox sittingNormalCheck;

	@FXML
	private CheckBox supinePossitiveRightCheck;

	@FXML
	private CheckBox supineNegativeRightCheck;

	@FXML
	private CheckBox supinePossitiveLefttCheck;

	@FXML
	private CheckBox supineNegativeLeftCheck;

	@FXML
	private CheckBox slrNormalCheck11;

	private ExamMusculotoneBackController examMusculotoneBackController;

	public void setExamMusculotoneBackController(ExamMusculotoneBackController examMusculotoneBackController) {
		this.examMusculotoneBackController = examMusculotoneBackController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneBackController.str);
			examComp.append("\n\n: ");
			examMusculotoneBackController.str = examComp.toString();

			if (slrNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("");
				examMusculotoneBackController.str = str1.toString();

			} else {

				if (slrNegativeRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("Cross over straight leg raise is negative.");
					examMusculotoneBackController.str = str1.toString();

				}
				if (slrPossitiveRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("Cross over straight leg raise is possitive.");
					examMusculotoneBackController.str = str1.toString();

				}
			}

			if (crossOverText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append("Crossover straight leg raise is negative at " +crossOverText.getText()+" degrees.");
				examMusculotoneBackController.str = str1.toString();

			}

			if (sittingNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
				str11.append("");
				examMusculotoneBackController.str = str11.toString();

			} else {

				if (sittingNegativeLeftCheck.isSelected() || sittingNegativeRightCheck.isSelected()
						|| sittingPossitiveLefttCheck.isSelected() || sittingPossitiveRightCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append("Straight leg raise sitting is ");
					examMusculotoneBackController.str = str11.toString();

					if (sittingNegativeLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("negative left, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (sittingNegativeRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("negative right, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (sittingPossitiveLefttCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("positive left , ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (sittingPossitiveRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("positive right, ");
						examMusculotoneBackController.str = str1.toString();

					}


				}

			}

			if (slrNormalCheck11.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
				str11.append("External ears appear normal. ");
				examMusculotoneBackController.str = str11.toString();

			} else {

				if (supineNegativeRightCheck.isSelected() || supinePossitiveLefttCheck.isSelected()
						|| supinePossitiveRightCheck.isSelected() || supineNegativeLeftCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneBackController.str);
					str11.append("Straight leg raise supine is ");
					examMusculotoneBackController.str = str11.toString();

					if (supineNegativeRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("negative right, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (supinePossitiveLefttCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("positive left , ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (supinePossitiveRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("positive right, ");
						examMusculotoneBackController.str = str1.toString();

					}
					if (supineNegativeLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
						str1.append("negative left, ");
						examMusculotoneBackController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("at ");
					examMusculotoneBackController.str = str1.toString();

				}

			}

			if (rightText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append(rightText.getText()+" degrees right,");
				examMusculotoneBackController.str = str1.toString();

			}

			if (leftText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append(leftText.getText()+" degrees left, ");
				examMusculotoneBackController.str = str1.toString();

			}

			++examMusculotoneBackController.formCount;
			examMusculotoneBackController.setBackUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneBackController.formCount;
				examMusculotoneBackController.setBackUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
