package com.ets.controller.gui.emrCharting.exam.resp;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 31-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespLungAuscultationInputController Class
 *Description: respLungAuscultation.fxml GUI Controller class
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

public class RespLungAuscultationInputController implements Initializable{
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox RalesRightUpperCheck;

	    @FXML
	    private CheckBox RalesLeftBaseCheck;

	    @FXML
	    private CheckBox RalesNoPresenceCheck;

	    @FXML
	    private CheckBox RalesLeftUpperCheck;

	    @FXML
	    private CheckBox RalesLeftMidFieldCheck;

	    @FXML
	    private CheckBox RalesRightMidfieldCheck;

	    @FXML
	    private CheckBox RalesRightBaseCheck;

	    @FXML
	    private CheckBox RalesAllNormalCheck;

	    @FXML
	    private CheckBox WheezesNoPresenceCheck;

	    @FXML
	    private CheckBox WheezesDiffuseCheck;

	    @FXML
	    private CheckBox WheezesScatteredCheck;

	    @FXML
	    private CheckBox WheezesLocalizedCheck;

	    @FXML
	    private RadioButton airNormalRadio;

	    @FXML
	    private ToggleGroup air;

	    @FXML
	    private RadioButton airDecreasedRadio;

	    @FXML
	    private RadioButton ratioNormalRadio;

	    @FXML
	    private ToggleGroup ratio;

	    @FXML
	    private RadioButton ratioabnormalRadio;

	    @FXML
	    private CheckBox RhonchiNoPresenceCheck;

	    @FXML
	    private CheckBox RhonchiDiffuseCheck;

	    @FXML
	    private CheckBox RhonchiScatteredCheck;

	    @FXML
	    private CheckBox RhonchiLocalizedCheck;
	    
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

			if (RalesAllNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append("Auscultation reveals normal lung sounds, with air movement and I/E ratio normal.");
				examRespInputController.str = str1.toString();
				
			}else{
				
				if (RalesLeftBaseCheck.isSelected() || RalesLeftMidFieldCheck.isSelected()
						|| RalesLeftUpperCheck.isSelected() || RalesNoPresenceCheck.isSelected()
						|| RalesRightBaseCheck.isSelected() || RalesRightMidfieldCheck.isSelected()
						|| RalesRightUpperCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examRespInputController.str);
					str11.append("Auscultation reveals");
					examRespInputController.str = str11.toString();

					if (RalesLeftBaseCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("left base,");
						examRespInputController.str = str1.toString();

					}
					if (RalesLeftMidFieldCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("left midfield,");
						examRespInputController.str = str1.toString();

					}
					if (RalesLeftUpperCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" left upper,");
						examRespInputController.str = str1.toString();

					}if (RalesNoPresenceCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("no presence of, ");
						examRespInputController.str = str1.toString();

					}if (RalesRightBaseCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" right base,");
						examRespInputController.str = str1.toString();

					}
					if (RalesRightMidfieldCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" right midfield, ");
						examRespInputController.str = str1.toString();

					}
					if (RalesRightUpperCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" right upper , ");
						examRespInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append("rales. ");
					examRespInputController.str = str1.toString();

				}
				
			
	

				if (RhonchiDiffuseCheck.isSelected() || RhonchiLocalizedCheck.isSelected()
						|| RhonchiNoPresenceCheck.isSelected() || RhonchiScatteredCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examRespInputController.str);
					str12.append("");
					examRespInputController.str = str12.toString();

					if (RhonchiDiffuseCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("diffusse, ");
						examRespInputController.str = str1.toString();

					}
					if (RhonchiLocalizedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("localized, ");
						examRespInputController.str = str1.toString();

					}
					if (RhonchiNoPresenceCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("no presence of, ");
						examRespInputController.str = str1.toString();

					}
					if (RhonchiScatteredCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("scattered,");
						examRespInputController.str = str1.toString();

					}
					StringBuilder str1 = new StringBuilder(examRespInputController.str);
					str1.append(" rhonchi. ");
					examRespInputController.str = str1.toString();
					

			}
				
				
				
				if (WheezesDiffuseCheck.isSelected() || WheezesLocalizedCheck.isSelected()
						|| WheezesNoPresenceCheck.isSelected() || WheezesScatteredCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examRespInputController.str);
					str12.append("");
					examRespInputController.str = str12.toString();

					if (WheezesDiffuseCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("diffuse,");
						examRespInputController.str = str1.toString();

					}
					if (WheezesLocalizedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("localized,");
						examRespInputController.str = str1.toString();

					}
					if (WheezesNoPresenceCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append("no presence of, ");
						examRespInputController.str = str1.toString();

					}
					if (WheezesScatteredCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examRespInputController.str);
						str1.append(" scattered , ");
						examRespInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examRespInputController.str);
					str11.append(" wheezes.");
					examRespInputController.str = str11.toString();

				}

			

			if (airNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append("Air movement is normal. ");
				examRespInputController.str = str1.toString();

			}
			if (airDecreasedRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append("Air movement is decreased. ");
				examRespInputController.str = str1.toString();

			}

			if (ratioNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" and I/E ratio is normal.");
				examRespInputController.str = str1.toString();

			}
			if (ratioabnormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examRespInputController.str);
				str1.append(" and I/E ratio is abnormal.");
				examRespInputController.str = str1.toString();

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
