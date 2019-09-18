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
 *Parameter Definition: Type object of HeadFaceFacialStrengthInputController Class
 *Description: headFaceFacialStrength GUI Controller class
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
public class HeadFaceFacialStrengthInputController implements Initializable{
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private CheckBox abnormalities2Check;

    @FXML
    private CheckBox abnormalities2FrontalCheck;

    @FXML
    private CheckBox abnormalities2SIawCheck;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox abnormalities2MaxilaryCheck;

    @FXML
    private CheckBox HeadFaceNormalStrengthCheck;

    @FXML
    private CheckBox HeadFaceWeeknessCheck;

    @FXML
    private CheckBox HeadFaceSaggingCheck;

    @FXML
    private CheckBox HeadFaceExtensivelCheck;

    @FXML
    private CheckBox HeadFaceParalysisCheck;

    @FXML
    private CheckBox HeadFaceSansationlCheck;

    @FXML
    private CheckBox HeadFaceLossToneCheck;

    @FXML
    private CheckBox HeadFaceNormalCheck;

    @FXML
    private CheckBox abnormalities1LeftCheck;

    @FXML
    private CheckBox abnormalities1RightCheck;

    @FXML
    private CheckBox abnormalities1BilateralCheck;
    
    private ExamMusculotoneHeadInputController examMusculotoneHeadInputController;

    public void setExamMusculotoneHeadInputController(
			ExamMusculotoneHeadInputController examMusculotoneHeadInputController) {
		this.examMusculotoneHeadInputController = examMusculotoneHeadInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneHeadInputController.str);
			examComp.append("\n\n ");
			examMusculotoneHeadInputController.str = examComp.toString();

			
				
			if (HeadFaceNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append(" Face has normal strength and tone. ");
				examMusculotoneHeadInputController.str = str11.toString();

			} else {

				if (HeadFaceExtensivelCheck.isSelected() || HeadFaceLossToneCheck.isSelected()
						|| HeadFaceNormalStrengthCheck.isSelected() || HeadFaceParalysisCheck.isSelected()
						|| HeadFaceSaggingCheck.isSelected() || HeadFaceSansationlCheck.isSelected()
						|| HeadFaceWeeknessCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
					str11.append(" Face has  ");
					examMusculotoneHeadInputController.str = str11.toString();

					if (HeadFaceExtensivelCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("extensive wrinkling, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceLossToneCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("loss of tone, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceNormalStrengthCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append(" normal tone., ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceParalysisCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("paralysis , ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceSaggingCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append(" sagging, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceSansationlCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("sensation, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceWeeknessCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("weakness, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(".");
					examMusculotoneHeadInputController.str = str1.toString();

				}

			}
			
			
			
			
			
				
				
				if(abnormalities1BilateralCheck.isSelected() || abnormalities1LeftCheck.isSelected()
						 || abnormalities1RightCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
					str11.append("in the ");
					examMusculotoneHeadInputController.str = str11.toString();
					
					
					
					if (abnormalities1BilateralCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("bilateral, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (abnormalities1LeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("left, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					
					if (abnormalities1RightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("right, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					
					
					
				}
				
				
				
				
				
			
					if (abnormalities2Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("cheek, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					
					if (abnormalities2FrontalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("frontal areas, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (abnormalities2MaxilaryCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("maxilary area,");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (abnormalities2SIawCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("jaw,");
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
