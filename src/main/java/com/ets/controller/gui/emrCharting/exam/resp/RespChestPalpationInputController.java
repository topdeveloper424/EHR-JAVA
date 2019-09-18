package com.ets.controller.gui.emrCharting.exam.resp;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 30-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespChestPalpationInputController Class
 *Description: respChestPalpation.fxml GUI Controller class
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

public class RespChestPalpationInputController implements Initializable {
	

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox PalpationDecreasedVocalRightCheck;

    @FXML
    private CheckBox PalpationNormalVocalCheck;

    @FXML
    private CheckBox PalpationDecreasedVocalLeftCheck;

    @FXML
    private CheckBox PalpationIncreasedVocalRightCheck;

    @FXML
    private CheckBox PalpationAllNormalCheck;

    @FXML
    private CheckBox PalpationIncreasedVocalLeftCheck;
    
    
    private ExamRespInputController examRespInputController;

    public void setExamRespInputController(ExamRespInputController examRespInputController) {
		this.examRespInputController = examRespInputController;
	}
    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examRespInputController.str);
			examComp.append("\n\n: ");
			examRespInputController.str = examComp.toString();

			


			if (PalpationAllNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" Palpation reveals normal vocal fremitus.");
				examRespInputController.str = str1.toString();

			} else {

				if (PalpationDecreasedVocalLeftCheck.isSelected() || PalpationDecreasedVocalRightCheck.isSelected()
						|| PalpationIncreasedVocalLeftCheck.isSelected()
						|| PalpationIncreasedVocalRightCheck.isSelected() || PalpationNormalVocalCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examRespInputController.str);
					str12.append(" Palpation reveals:");
					examRespInputController.str = str12.toString();

					if (PalpationDecreasedVocalLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("decreased vocal fremitus left,");
						examRespInputController.str = str1.toString();

					}
					if (PalpationDecreasedVocalRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("decreased vocal fremitus right,");
						examRespInputController.str = str1.toString();

					}
					if (PalpationIncreasedVocalLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("increased vocal fremitus left,");
						examRespInputController.str = str1.toString();

					}
					if (PalpationIncreasedVocalRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("increased vocal fremitus right, ");
						examRespInputController.str = str1.toString();

					}
					if (PalpationNormalVocalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("normal vocal fremitus");
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
