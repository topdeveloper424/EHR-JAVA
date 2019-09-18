package com.ets.controller.gui.emrCharting.exam.resp;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 31-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespChestPercussionInputController Class
 *Description: respChestPercussion.fxml GUI Controller class
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



public class RespChestPercussionInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox PercussionNormalCheck;

    @FXML
    private CheckBox PercussionLeftLowerCheck;

    @FXML
    private CheckBox PercussionLeftMidFieldCheck;

    @FXML
    private CheckBox PercussionLeftUpperCheck;

    @FXML
    private CheckBox PercussionRightMidFieldCheck;

    @FXML
    private CheckBox PercussionRightLowerrCheck;

    @FXML
    private CheckBox PercussionRightUpperCheck;

    @FXML
    private CheckBox PercussionAllnormalCheck;
    
    
    private ExamRespInputController examRespInputController;

    public void setExamRespInputController(ExamRespInputController examRespInputController) {
		this.examRespInputController = examRespInputController;
	}
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examRespInputController.str);
			examComp.append("\n\n ");
			examRespInputController.str = examComp.toString();

		

			if (PercussionAllnormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append("Chest percussion is normal.");
				examRespInputController.str = str1.toString();

			} else {

				if (PercussionLeftLowerCheck.isSelected() || PercussionLeftMidFieldCheck.isSelected()
						|| PercussionLeftUpperCheck.isSelected() || PercussionNormalCheck.isSelected()
						|| PercussionRightLowerrCheck.isSelected() || PercussionRightMidFieldCheck.isSelected()
						|| PercussionRightUpperCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examRespInputController.str);
					str12.append(" Percussion of the chest shows ");
					examRespInputController.str = str12.toString();

					if (PercussionLeftLowerCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness left upper lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionLeftMidFieldCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness left midfield lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionLeftUpperCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness left upper lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("normal percussion,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionRightLowerrCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" dullness right lower lung,");
						examRespInputController.str = str1.toString();

					}
					if (PercussionRightMidFieldCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" dullness right midfield lung , ");
						examRespInputController.str = str1.toString();

					}
					if (PercussionRightUpperCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("dullness right upper lung ");
						examRespInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examRespInputController.str);
					str11.append(".");
					examRespInputController.str = str11.toString();

				}

			}

			++examRespInputController.formCount;
			examRespInputController.setRespUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examRespInputController.formCount;
				examRespInputController.setRespUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
