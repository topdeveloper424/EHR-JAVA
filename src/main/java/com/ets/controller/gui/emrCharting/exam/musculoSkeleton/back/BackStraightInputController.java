package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.back;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 21-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BackStraightInputController Class
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

public class BackStraightInputController implements Initializable{
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

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
					str1.append("");
					examMusculotoneBackController.str = str1.toString();

				}
				if (slrPossitiveRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
					str1.append("");
					examMusculotoneBackController.str = str1.toString();

				}
			}

			if (crossOverText.getText().length() > 0) {

				StringBuilder str1 = new StringBuilder(examMusculotoneBackController.str);
				str1.append(" "+crossOverText.getText()+ " ");
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
