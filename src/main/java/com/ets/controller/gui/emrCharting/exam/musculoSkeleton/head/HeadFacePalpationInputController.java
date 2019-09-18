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
 *Parameter Definition: Type object of HeadFacePalpationInputController Class
 *Description: headFacePalpation GUI Controller class
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
public class HeadFacePalpationInputController implements Initializable{
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private CheckBox revealedNormalCkeckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox tenderness2CheekCheck;

	    @FXML
	    private CheckBox tenderness2SkullCheck;

	    @FXML
	    private CheckBox tenderness2Frontalheck;

	    @FXML
	    private CheckBox tenderness2MaxilaryCheck;

	    @FXML
	    private CheckBox tenderness2IawCheck;

	    @FXML
	    private CheckBox tenderness2TemporomandibulaCheck;

	    @FXML
	    private CheckBox tenderness2ExudatesCheck;

	    @FXML
	    private CheckBox tenderness2ForeignCheck;

	    @FXML
	    private RadioButton revealedNotendernessRadio;

	    @FXML
	    private RadioButton revealedTendernessRadio;
	    
	    @FXML
	    private ToggleGroup face;

	    @FXML
	    private CheckBox tendernessPartialCheck;

	    @FXML
	    private CheckBox tendernessLeftCheck;

	    @FXML
	    private CheckBox tendernessRightCheck;

	    @FXML
	    private CheckBox tendernessPosteriorCheck;

	    @FXML
	    private CheckBox tendernessAnteriorCheck;
	    
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

			if (revealedNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append(" There was no sinus tenderness in the face. ");
				examMusculotoneHeadInputController.str = str1.toString();

			} else {

				if (revealedNotendernessRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" Face examination revealed no tenderness. ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (revealedTendernessRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("Face examination revealed tenderness.");
					examMusculotoneHeadInputController.str = str1.toString();

				}

			}

			if (tendernessLeftCheck.isSelected() || tendernessRightCheck.isSelected()
					|| tendernessAnteriorCheck.isSelected() || tendernessPosteriorCheck.isSelected()
					|| tendernessPartialCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append("Tenderness was noted in the ");
				examMusculotoneHeadInputController.str = str11.toString();

				if (tendernessLeftCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("left,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessRightCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("right,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessAnteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("anterior,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessPosteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("posterior, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessPartialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" parietal, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append(" region of the face/skull. ");
				examMusculotoneHeadInputController.str = str1.toString();

			}


				if (tenderness2CheekCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("cheek, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				
				if (tenderness2Frontalheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("frontal areas, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tenderness2IawCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("jaw,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				
				if (tenderness2MaxilaryCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("Maxilary areas, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tenderness2SkullCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("skull, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tenderness2TemporomandibulaCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" temporomandibular joint. ");
					examMusculotoneHeadInputController.str = str1.toString();

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
