package com.ets.controller.gui.emrCharting.exam.skin.examComprehensive;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamComprehensiveMultiInputController Class
 *Description: ExamSkincomprehensiveMultisystem.fxml GUI Controller class
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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class ExamComprehensiveMultiInputController implements Initializable {
	 
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox rashCheck;

	    @FXML
	    private CheckBox whealsCheck;

	    @FXML
	    private CheckBox pustulesCheck;

	    @FXML
	    private CheckBox abrasionCheck;

	    @FXML
	    private CheckBox lesionsCheck;

	    @FXML
	    private CheckBox plaquesCheck;

	    @FXML
	    private CheckBox bullaeCheck;

	    @FXML
	    private CheckBox maculeCheck;

	    @FXML
	    private CheckBox nodulesCheck;

	    @FXML
	    private CheckBox papulesCkeckBox;

	    @FXML
	    private CheckBox lacerationCkeckBox;

	    @FXML
	    private CheckBox encchymosisCkeckBox;

	    @FXML
	    private CheckBox NormallesionsCheck;

	    @FXML
	    private CheckBox normalWoundCheck;

	    @FXML
	    private CheckBox normalRashesCheck;

	    @FXML
	    private CheckBox abnormalitiesCheck;

	    @FXML
	    private CheckBox normalUlcersCheck;

	    @FXML
	    private CheckBox skinLesionsCheck;

	    @FXML
	    private RadioButton skinLesionsNoVisibleRadio;

	    @FXML
	    private ToggleGroup active1;

	    @FXML
	    private RadioButton skinLesionsPalableRadio;

	    @FXML
	    private ToggleGroup active11;

	    @FXML
	    private RadioButton solitaryRadio;

	    @FXML
	    private ToggleGroup active111;

	    @FXML
	    private RadioButton multipleRadio;

	    @FXML
	    private ToggleGroup active1111;

	    @FXML
	    private RadioButton visibleRadio;

	    @FXML
	    private ToggleGroup active11111;

	    @FXML
	    private CheckBox dischargeCkeckBox1;

	    @FXML
	    private CheckBox swellingCkeckBox11;

	    @FXML
	    private CheckBox woundDehiscenceCkeckBox;

	    @FXML
	    private CheckBox vesiclesCheck;

	    @FXML
	    private CheckBox edemaCheck;

	    @FXML
	    private CheckBox honeyCheck;

	    @FXML
	    private CheckBox indurationCkeckBox;

	    @FXML
	    private CheckBox fluctuanceCheck;

	    @FXML
	    private CheckBox buttocksCheck;

	    @FXML
	    private CheckBox neckCheck;

	    @FXML
	    private CheckBox abdomenCheck;

	    @FXML
	    private CheckBox handsCheck;

	    @FXML
	    private CheckBox headDistributionCheck;

	    @FXML
	    private CheckBox faceCheck;

	    @FXML
	    private CheckBox chestCheck;

	    @FXML
	    private CheckBox lowerExtremitesCheck;

	    @FXML
	    private CheckBox scalpCheck;

	    @FXML
	    private CheckBox backCheck;

	    @FXML
	    private CheckBox upperExtremitiesCheck;

	    @FXML
	    private CheckBox feetCheck;

	    @FXML
	    private CheckBox ColorNormalCheck;

	    @FXML
	    private CheckBox ColorNormalCheck2;

	    @FXML
	    private CheckBox purpleCheck;

	    @FXML
	    private CheckBox hypopigmentedCheck;

	    @FXML
	    private CheckBox erythematousCheck;
	    
	private ExamSkinInputController examSkinInputController;
	
	public void setExamSkinInputController(ExamSkinInputController examSkinInputController) {
		this.examSkinInputController = examSkinInputController;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{

			StringBuilder skelComp = new StringBuilder(examSkinInputController.str);
			skelComp.append("\n\nSKIN: ");
			examSkinInputController.str = skelComp.toString();

			if (skinLesionsCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" Skin exam reveals no visible or palpable lesions, rashes or abnormalities. ");
				examSkinInputController.str = str1.toString();

			}else{
				if (skinLesionsNoVisibleRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examSkinInputController.str);
					str1.append(" Inspection and palpation of skin reveals no visible or palpable ");
					examSkinInputController.str = str1.toString();

				}
				
				if (skinLesionsPalableRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examSkinInputController.str);
					str1.append("Inspection and palpation of skin reveals palpable ");
					examSkinInputController.str = str1.toString();

				}
				if (solitaryRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examSkinInputController.str);
					str1.append("Inspection and palpation of skin reveals solitary ");
					examSkinInputController.str = str1.toString();

				}
				if (solitaryRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examSkinInputController.str);
					str1.append("Inspection and palpation of skin reveals multiple ");
					examSkinInputController.str = str1.toString();

				}
				if (visibleRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examSkinInputController.str);
					str1.append("Inspection and palpation of skin reveals visible ");
					examSkinInputController.str = str1.toString();

				}
				
			}
			
			if (rashCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" rash, ");
				examSkinInputController.str = str1.toString();

			}
			if (lesionsCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" lesions, ");
				examSkinInputController.str = str1.toString();

			}
			if (nodulesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" nodules, ");
				examSkinInputController.str = str1.toString();

			}
			if (whealsCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" wheals,");
				examSkinInputController.str = str1.toString();

			}
			if (plaquesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" plaques, ");
				examSkinInputController.str = str1.toString();

			}
			if (papulesCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" papules, ");
				examSkinInputController.str = str1.toString();

			}
			if (pustulesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" pustules, ");
				examSkinInputController.str = str1.toString();

			}
			if (bullaeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" bullae, ");
				examSkinInputController.str = str1.toString();

			}
			if (lacerationCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" laceration, ");
				examSkinInputController.str = str1.toString();

			}
			if (abrasionCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" abrasion, ");
				examSkinInputController.str = str1.toString();

			}
			if (maculeCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" macule, ");
				examSkinInputController.str = str1.toString();

			}
			if (encchymosisCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" encchymosis, ");
				examSkinInputController.str = str1.toString();

			}
			if (dischargeCkeckBox1.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" discharge, ");
				examSkinInputController.str = str1.toString();

			}
			if (woundDehiscenceCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" wound dehiscence, ");
				examSkinInputController.str = str1.toString();

			}
			if (edemaCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" edema,");
				examSkinInputController.str = str1.toString();

			}
			if (swellingCkeckBox11.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" swelling,");
				examSkinInputController.str = str1.toString();

			}
			if (vesiclesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" vesicles,");
				examSkinInputController.str = str1.toString();

			}
			if (honeyCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" honey  crusted lesions,");
				examSkinInputController.str = str1.toString();

			}
			if (indurationCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" induration,");
				examSkinInputController.str = str1.toString();

			}if (fluctuanceCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" fluctuance,");
				examSkinInputController.str = str1.toString();

			}
			if (headDistributionCheck.isSelected()||neckCheck.isSelected()
					||abdomenCheck.isSelected()||handsCheck.isSelected()
					||faceCheck.isSelected()||chestCheck.isSelected()
					||buttocksCheck.isSelected()||feetCheck.isSelected()
					||lowerExtremitesCheck.isSelected()||scalpCheck.isSelected()
					||backCheck.isSelected()||upperExtremitiesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(",located over the ");
				examSkinInputController.str = str1.toString();

			}
			if (headDistributionCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("head,trunk or extrimities,");
				examSkinInputController.str = str1.toString();

			}
			 
			if (neckCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("neck,");
				examSkinInputController.str = str1.toString();

			}
			if (abdomenCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("abdomen,");
				examSkinInputController.str = str1.toString();

			}
			if (handsCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hand,");
				examSkinInputController.str = str1.toString();

			}if (faceCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("face,");
				examSkinInputController.str = str1.toString();

			}if (chestCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("chest,");
				examSkinInputController.str = str1.toString();

			}
			if (buttocksCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("buttocks,");
				examSkinInputController.str = str1.toString();

			}if (feetCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("feet,");
				examSkinInputController.str = str1.toString();

			}
			if (lowerExtremitesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("lower extremities,");
				examSkinInputController.str = str1.toString();

			}if (scalpCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("scalp");
				examSkinInputController.str = str1.toString();

			}if (backCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("back");
				examSkinInputController.str = str1.toString();

			}if (upperExtremitiesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("upper extremities");
				examSkinInputController.str = str1.toString();

			}
			//######
			if (ColorNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" Skin color normal.");
				examSkinInputController.str = str1.toString();

			}else{
				StringBuilder str11 = new StringBuilder(examSkinInputController.str);
				str11.append(" Skin color ");
				examSkinInputController.str = str11.toString();

			
			if (ColorNormalCheck2.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("normal color");
				examSkinInputController.str = str1.toString();

			}
			if (purpleCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("purple");
				examSkinInputController.str = str1.toString();

			}
			if (hypopigmentedCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hypopigmented");
				examSkinInputController.str = str1.toString();

			}if (erythematousCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("erythematous");
				examSkinInputController.str = str1.toString();

			}
			StringBuilder str1 = new StringBuilder(examSkinInputController.str);
			str1.append(".");
			examSkinInputController.str = str1.toString();

			}
			
			if (NormallesionsCheck.isSelected()||normalWoundCheck.isSelected()
					||normalUlcersCheck.isSelected()||normalRashesCheck.isSelected()
					||abnormalitiesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" Examination of the skin is normal for the following: ");
				examSkinInputController.str = str1.toString();

			}
			
			if (NormallesionsCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("lesions,");
				examSkinInputController.str = str1.toString();

			}
			if (normalWoundCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("wounds,");
				examSkinInputController.str = str1.toString();

			}
			
			if (normalUlcersCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("ulcer,");
				examSkinInputController.str = str1.toString();

			}

			if (normalRashesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("rashes,");
				examSkinInputController.str = str1.toString();

			}if (abnormalitiesCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("abnormalities,");
				examSkinInputController.str = str1.toString();

			}
			
			StringBuilder str1 = new StringBuilder(examSkinInputController.str);
			str1.append(".");
			examSkinInputController.str = str1.toString();
			//genericEMRChartingController.saveAllTextArea();
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
