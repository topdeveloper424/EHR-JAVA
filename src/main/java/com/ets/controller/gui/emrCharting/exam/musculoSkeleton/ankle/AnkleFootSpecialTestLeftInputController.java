package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.ankle;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 14-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AnkleFootSpecialTestLeftInputController Class
 *Description: ankleROMLeft.fxml Controller class
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AnkleFootSpecialTestLeftInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton DrawerNegativeRadio;

    @FXML
    private ToggleGroup Drawer;

    @FXML
    private RadioButton DrawerPossitiveRadio;

    @FXML
    private RadioButton HeelNegativeRadio;

    @FXML
    private RadioButton HeelPosssitiveRadio;
    
    
    private ExamMusculotoneAnkleInputController examMusculotoneAnkleInputController;

	public void setExamMusculotoneAnkleInputController(
			ExamMusculotoneAnkleInputController examMusculotoneAnkleInputController) {
		this.examMusculotoneAnkleInputController = examMusculotoneAnkleInputController;
	}
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneAnkleInputController.str);
			examComp.append("\n\nSPECIAL TESTS:\n Left ankle and foot - the following special tests were performed: ");
			examMusculotoneAnkleInputController.str = examComp.toString();
			
			
			
			if (DrawerNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Drawer signs test negative. ");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			if (DrawerPossitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append(" Drawer signs test negative. ");
				examMusculotoneAnkleInputController.str = str1.toString();

			}

			
			
			
			if (HeelNegativeRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Heel pounding test negative.");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			
			if (HeelPosssitiveRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Heel pounding test possitive.");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			
			
			

			++examMusculotoneAnkleInputController.formCount;
			examMusculotoneAnkleInputController.setAnkleUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneAnkleInputController.formCount;
				examMusculotoneAnkleInputController.setAnkleUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
