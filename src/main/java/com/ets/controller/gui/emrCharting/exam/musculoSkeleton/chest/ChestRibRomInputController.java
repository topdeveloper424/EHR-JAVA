package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.chest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ChestRibRomInputController Class
 *Description: ChestRibROM GUI Controller class
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
public class ChestRibRomInputController implements Initializable{
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField flexionText;

    @FXML
    private TextField rightLateralText;

    @FXML
    private TextField LeftLateralText;
    
    private ExamMusculotoneChestInputController examMusculotoneChestInputController;
	
	public void setExamMusculotoneChestInputController(
			ExamMusculotoneChestInputController examMusculotoneChestInputController) {
		this.examMusculotoneChestInputController = examMusculotoneChestInputController;
	}



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneChestInputController.str);
			examComp.append("\n\nRANGE OF MOTION: ");
			examMusculotoneChestInputController.str = examComp.toString();
			
			
			
			if (flexionText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
				str1.append("\nT-Spine: Flexion "+flexionText.getText()+" degrees (NL- 35 degrees)");
				examMusculotoneChestInputController.str = str1.toString();

			}
			
			
			
					
			
			
			if (rightLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
				str1.append("\nT-Spine: Right Lateral Flexion "+rightLateralText.getText()+" degrees (NL-30 degrees)");
				examMusculotoneChestInputController.str = str1.toString();

			}
			
			
			
			if (LeftLateralText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
				str1.append("\nT-Spine: Left Lateral Flexion "+LeftLateralText.getText()+" degrees (NL-30 degrees).");
				examMusculotoneChestInputController.str = str1.toString();

			}
			
			
			
			
			
			

			++examMusculotoneChestInputController.formCount;
			examMusculotoneChestInputController.setChestUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneChestInputController.formCount;
				examMusculotoneChestInputController.setChestUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
