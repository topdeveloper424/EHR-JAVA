package com.ets.controller.gui.emrCharting.exam.skin.skinSclapHair;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkinSclapHairInputController Class
 *Description: skinScalpAndHair.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.exam.skin.ExamSkinInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;

public class SkinSclapHairInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox palpationNormalCheck;

    @FXML
    private CheckBox NopalableMassesCheck;

    @FXML
    private CheckBox rightCheck;

    @FXML
    private CheckBox bilaterallyCheck;

    @FXML
    private CheckBox leftChck;

    @FXML
    private CheckBox examinationNormalCheck;

    @FXML
    private RadioButton noAbnormalitiesRadio;

    @FXML
    private CheckBox scalpCheck;

    @FXML
    private CheckBox faceCheck;

    @FXML
    private CheckBox pubicCheck;

    @FXML
    private CheckBox eyebrowsCheck;

    @FXML
    private CheckBox hairDistributionNormalCheck;

    @FXML
    private CheckBox hairConsistencyNormalCheck;

    @FXML
    private CheckBox sebaseousCheck;

    @FXML
    private CheckBox indurationCheck;

    @FXML
    private CheckBox fluctuanceCheck;

    @FXML
    private RadioButton generalAlopeciaRadio;

    @FXML
    private RadioButton focalAlpoceaRadio;

    @FXML
    private CheckBox lowerExtrimityCheck;

    @FXML
    private CheckBox handCheck;

    @FXML
    private CheckBox footCheck;

    @FXML
    private CheckBox chestCheck;

    @FXML
    private CheckBox upperExtrimityCheck;

    @FXML
    private CheckBox armCheck;

    @FXML
    private CheckBox legCheck;

    @FXML
    private RadioButton isNormalRadio;

    @FXML
    private RadioButton showtotalCheck;

    @FXML
    private RadioButton showpatchChck;

	@FXML
	private RadioButton hairConsistencyIsNormalCheck;

	@FXML
	private RadioButton hairConsistencyIsAbnormallyCheck;

	private ExamSkinInputController examSkinInputController;

	public void setExamSkinInputController(ExamSkinInputController examSkinInputController) {
		this.examSkinInputController = examSkinInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			StringBuilder skelComp = new StringBuilder(examSkinInputController.str);
			skelComp.append("\n\n ");
			examSkinInputController.str = skelComp.toString();

			if (palpationNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" Palpation of the scalp reveals no palpable masses or irregularities. ");
				examSkinInputController.str = str1.toString();

			}
			else{
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" Palpation of the scalp reveals ");
				examSkinInputController.str = str1.toString();


				if (NopalableMassesCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" no palpable masses, ");
					examSkinInputController.str = str11.toString();

				}
				if (indurationCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" induration, ");
					examSkinInputController.str = str11.toString();

				}
				if (sebaseousCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" sebaceous cyst, ");
					examSkinInputController.str = str11.toString();

				}
				if (fluctuanceCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" fluctuance, ");
					examSkinInputController.str = str11.toString();

				}
				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(".");
				examSkinInputController.str = str11.toString();

				
			}if (examinationNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" Examination of the hair reveals no abnormalities. ");
				examSkinInputController.str = str11.toString();

			}else{
				

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" Examination of the hair reveals");
				examSkinInputController.str = str1.toString();

				
				
				if (examinationNormalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" no abnormalities, ");
					examSkinInputController.str = str11.toString();

				}
				if (focalAlpoceaRadio.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" focal alopecia, ");
					examSkinInputController.str = str11.toString();

				}if (generalAlopeciaRadio.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" general alopecia, ");
					examSkinInputController.str = str11.toString();

				}
				
			}
			if (bilaterallyCheck.isSelected()||rightCheck.isSelected()||leftChck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" located ");
				examSkinInputController.str = str11.toString();

			}
			 
			if (bilaterallyCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" bilaterally,");
				examSkinInputController.str = str11.toString();

			}
			if (rightCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" right,");
				examSkinInputController.str = str11.toString();

			}
			if (leftChck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" left,");
				examSkinInputController.str = str11.toString();

			}
			if (scalpCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" scalp ,");
				examSkinInputController.str = str11.toString();

			}
			
			if (faceCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" face,");
				examSkinInputController.str = str11.toString();

			}
			if (pubicCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" public area,");
				examSkinInputController.str = str11.toString();

			}
			if (armCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" arm,");
				examSkinInputController.str = str11.toString();

			}
			if (lowerExtrimityCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" lower extrimity area,");
				examSkinInputController.str = str11.toString();

			}
			if (handCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" hand,");
				examSkinInputController.str = str11.toString();

			}
			if (footCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" foot,");
				examSkinInputController.str = str11.toString();

			}
			if (legCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" leg,");
				examSkinInputController.str = str11.toString();

			}
			if (eyebrowsCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" eyebrows,");
				examSkinInputController.str = str11.toString();

			}
			if (chestCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" chest,");
				examSkinInputController.str = str11.toString();

			}
			if (upperExtrimityCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" upper extrimity area,");
				examSkinInputController.str = str11.toString();

			}
			if (upperExtrimityCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" Hair distribution is normal.");
				examSkinInputController.str = str11.toString();

			}else{
				
				if (showtotalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" Hair distribution shows total alopecia.");
					examSkinInputController.str = str11.toString();

				}
				if (showpatchChck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" Hair distribution shows patchy alopecia.");
					examSkinInputController.str = str11.toString();

				}
				if (isNormalRadio.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" Hair distribution is normal.");
					examSkinInputController.str = str11.toString();

				}
				
			}
			
			if (hairConsistencyNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" Hair consistency is normal.");
				examSkinInputController.str = str11.toString();

			}else{
				

				if (hairConsistencyIsNormalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append("Hair consistency is normal.");
					examSkinInputController.str = str11.toString();

				}
				if (hairConsistencyIsAbnormallyCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examSkinInputController.str);
					str11.append(" Hair consistency is abnormally course.");
					examSkinInputController.str = str11.toString();

				}
			}
			
			
		++examSkinInputController.formCount;	
		examSkinInputController.setSkinUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examSkinInputController.formCount;	
				examSkinInputController.setSkinUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
