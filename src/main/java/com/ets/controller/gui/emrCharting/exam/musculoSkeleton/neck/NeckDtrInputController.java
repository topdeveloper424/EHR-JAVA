package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.neck;

/*

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of NeckDtrInputController Class
 *Description: neckDTR.fxml Controller class
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

public class NeckDtrInputController implements Initializable{
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private CheckBox bicepsTricepsRightCheck;

    @FXML
    private CheckBox bicepsTricepsLeftCheck;

    @FXML
    private CheckBox biceps2RightCheckBox;

    @FXML
    private CheckBox triceps2RightCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox tricepsDecreasedRightCheckBox;

    @FXML
    private CheckBox tricepsDecreasedLeftCheckBox;

    @FXML
    private CheckBox triceps2LeftCheckBox;

    @FXML
    private CheckBox biceps2LeftCheckBox;

    @FXML
    private CheckBox bicepsDecreasedRightCheck;

    @FXML
    private CheckBox bicepsDecreasedLeftCheck;

    @FXML
    private CheckBox NormalCheck;
    
    private ExamMusculotoneNeckInputController examMusculotoneNeckInputController;

   	public void setExamMusculotoneNeckInputController(
   			ExamMusculotoneNeckInputController examMusculotoneNeckInputController) {
   		this.examMusculotoneNeckInputController = examMusculotoneNeckInputController;
   	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneNeckInputController.str);
			examComp.append("\n\n");
			examMusculotoneNeckInputController.str = examComp.toString();

			
			

			if (NormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneNeckInputController.str);
				str11.append("");
				examMusculotoneNeckInputController.str = str11.toString();

			} else {

				if (bicepsTricepsRightCheck.isSelected() || bicepsDecreasedRightCheck.isSelected()
						|| tricepsDecreasedRightCheckBox.isSelected() || biceps2LeftCheckBox.isSelected()
						|| triceps2LeftCheckBox.isSelected() || biceps2RightCheckBox.isSelected()
						|| triceps2RightCheckBox.isSelected() || bicepsTricepsLeftCheck.isSelected()
						|| bicepsDecreasedLeftCheck.isSelected() || tricepsDecreasedLeftCheckBox.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneNeckInputController.str);
					str11.append("DTR were ");
					examMusculotoneNeckInputController.str = str11.toString();

					if (bicepsTricepsRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("2+/2+ (biceps/triceps) right, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (bicepsDecreasedRightCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("biceps decreased right, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (tricepsDecreasedRightCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("triceps decreased right, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (biceps2LeftCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("biceps 2+ left, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (triceps2LeftCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("triceps 2+ left, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (biceps2RightCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("biceps 2+ right, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}if (triceps2RightCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("triceps 2+ right, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (bicepsTricepsLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("2+/2+ (biceps/triceps) left, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (bicepsDecreasedLeftCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("biceps decreased left, ");
						examMusculotoneNeckInputController.str = str1.toString();

					}
					if (tricepsDecreasedLeftCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneNeckInputController.str);
						str1.append("triceps decreased left");
						examMusculotoneNeckInputController.str = str1.toString();

					}

				}

			}
			
			
			
			
			
			
			
			
			
			
			
			

			


			

			++examMusculotoneNeckInputController.formCount;
			examMusculotoneNeckInputController.setNeckUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneNeckInputController.formCount;
				examMusculotoneNeckInputController.setNeckUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
