package com.ets.controller.gui.emrCharting.exam.neck;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckThyroidInputController Class
 *Description: neckThyroid.fxml GUI Controller class
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

public class NeckThyroidInputController implements Initializable {
	
	  @FXML
	    private CheckBox ThyroidDiffuselyCheck;

	    @FXML
	    private CheckBox ThyroidMasRightCheck;

	    @FXML
	    private CheckBox ThyroidMultipleCheck;

	    @FXML
	    private CheckBox ThyroidMassLeftCheck;

	    @FXML
	    private CheckBox ThyroidNonTenderCheck;

	    @FXML
	    private CheckBox ThyroidTenderCheck;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	 
	    
	    @FXML
	    private CheckBox thyroidNormalCheck1;
	    private ExamNeckInputController examNeckInputController;

	    public void setExamNeckInputController(ExamNeckInputController examNeckInputController) {
			this.examNeckInputController = examNeckInputController;
		}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examNeckInputController.str);
			examComp.append("\n\n: ");
			examNeckInputController.str = examComp.toString();

			
			if (thyroidNormalCheck1.isSelected()) {

				StringBuilder str1 = new StringBuilder(examNeckInputController.str);
				str1.append("No thyromegaly present.");
				examNeckInputController.str = str1.toString();

			}else{
			
			
			

			if (ThyroidDiffuselyCheck.isSelected() || ThyroidMassLeftCheck.isSelected()
					|| ThyroidMasRightCheck.isSelected() || ThyroidMultipleCheck.isSelected()
					|| ThyroidTenderCheck.isSelected()||ThyroidNonTenderCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examNeckInputController.str);
				str11.append(" Thyroid ");
				examNeckInputController.str = str11.toString();

				if (ThyroidDiffuselyCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("diffusely enlarged,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidMassLeftCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("mass left,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidMasRightCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("mass right,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidMultipleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("multiple nodules,");
					examNeckInputController.str = str1.toString();

				}
				if (ThyroidTenderCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("tender, ");
					examNeckInputController.str = str1.toString();

				}if (ThyroidNonTenderCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examNeckInputController.str);
					str1.append("non tender");
					examNeckInputController.str = str1.toString();

				}
				
				StringBuilder str12 = new StringBuilder(examNeckInputController.str);
				str12.append(".");
				examNeckInputController.str = str12.toString();

			}	

		
			
			}

			

			++examNeckInputController.formCount;
			examNeckInputController.setNeckUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examNeckInputController.formCount;
				examNeckInputController.setNeckUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
