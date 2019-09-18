package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.knee;

/*

 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 13-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of KneeRomRightInputController Class
 *Description: kneeSpecialTestRight.fxml Controller class
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class KneeSpecialTestRightInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private RadioButton AnteriornegativeRadio;

	@FXML
	private ToggleGroup Anterior;

	@FXML
	private RadioButton AnteriorpossitiveRadio;

	@FXML
	private RadioButton ApleyNegativeRadio;

	@FXML
	private ToggleGroup Apley;

	@FXML
	private RadioButton ApleypossitiveRadio;

	@FXML
	private RadioButton ApprehensionnegativeRadio;

	@FXML
	private ToggleGroup Apprehensio;

	@FXML
	private RadioButton ApprehensionpossitiveRadio;

	@FXML
	private RadioButton CrossnegativeRadio;

	@FXML
	private ToggleGroup Cross;

	@FXML
	private RadioButton CrosspossitiveRadio;

	@FXML
	private RadioButton DropnegativeRadio;

	@FXML
	private ToggleGroup Drop;

	@FXML
	private RadioButton DroppossitiveRadio;

	@FXML
	private RadioButton EmptynegativeRadio;

	@FXML
	private ToggleGroup Empty;

	@FXML
	private RadioButton EmptypossitiveRadio;

	@FXML
	private RadioButton HawkinsnegativeRadio;

	@FXML
	private ToggleGroup Hawkins;

	@FXML
	private RadioButton HawkinspossitiveRadio;

	@FXML
	private RadioButton NeernegativeRadio;

	@FXML
	private ToggleGroup Neers;

	@FXML
	private RadioButton NeerpossitiveRadio;

	@FXML
	private RadioButton BriennegativeRadio;

	@FXML
	private ToggleGroup brien;

	@FXML
	private RadioButton BrienpossitiveRadio;

	@FXML
	private RadioButton RelocationnegativeRadio;

	@FXML
	private ToggleGroup Relocation;

	@FXML
	private RadioButton RelocationpossitiveRadio;

	@FXML
	private RadioButton SpeedsnegativeRadio;

	@FXML
	private ToggleGroup Speeds;

	@FXML
	private RadioButton SpeedspossitiveRadio;

	private ExamMusculotoneKneeInputController examMusculotoneKneeInputController;

	public void setExamMusculotoneKneeInputController(
			ExamMusculotoneKneeInputController examMusculotoneKneeInputController) {
		this.examMusculotoneKneeInputController = examMusculotoneKneeInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneKneeInputController.str);
			examComp.append("\n\nSPECIAL TESTS:\nRight Knee- the following special tests were performed: ");
			examMusculotoneKneeInputController.str = examComp.toString();

			if (AnteriornegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Apley's compression test negative. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (AnteriorpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Apley's compression test positive. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			if (ApleyNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Apley's distraction test negative.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (ApleypossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Apley's distraction test positive. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (ApprehensionnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nApprehension negative. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (ApprehensionpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nApprehension positive. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (CrossnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Anterior Drawer Sign negative. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (CrosspossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Anterior Drawer Sign positive.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			if (DropnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nPosterior Drawer Sign negative.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (DroppossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nPosterior Drawer Sign positive.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			if (EmptynegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nDuck walk negative. , ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (EmptypossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nDuck walk positive. , ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			if (HawkinsnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nFlick test negative ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (HawkinspossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nFlick test positive");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			if (NeerpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nLachman's positive.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (NeernegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nLachman's negative.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			if (BriennegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nMcMurray negative.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (BrienpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nMcMurray positive.");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			if (RelocationnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nValgus stress negative. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (RelocationpossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\nValgus stress positive. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			
			
			
			if (SpeedsnegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Varus stress negative. ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			if (SpeedspossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneKneeInputController.str);
				str1.append("\n Varus stress positive.  ");
				examMusculotoneKneeInputController.str = str1.toString();

			}
			
			
			

			++examMusculotoneKneeInputController.formCount;
			examMusculotoneKneeInputController.setKneeUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneKneeInputController.formCount;
				examMusculotoneKneeInputController.setKneeUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
