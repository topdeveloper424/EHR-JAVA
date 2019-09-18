package com.ets.controller.gui.emrCharting.exam.gu.comprehensiveMultiSystem;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of GUComprehensiveInputController Class
 *Description: GUcomphensiveMultiSystem.fxml Controller class
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

import com.ets.controller.gui.emrCharting.exam.gu.GUInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class GUComprehensiveInputController implements Initializable {
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox scrotumNormalCkeckBox;

	    @FXML
	    private CheckBox scrotumnormal2Check;

	    @FXML
	    private CheckBox scrotumHydroceleCheck;

	    @FXML
	    private CheckBox scrotumepdidymisCheck;

	    @FXML
	    private CheckBox scrotumabsentCheck;

	    @FXML
	    private CheckBox RightTestisNormalCkeckBox;

	    @FXML
	    private CheckBox RightTestisEnlargedlCkeckBox;

	    @FXML
	    private CheckBox RightTestisTendernessCkeckBox;

	    @FXML
	    private CheckBox RightTestisMassesCkeckBox;

	    @FXML
	    private CheckBox RightTestisHydroceleCkeckBox;

	    @FXML
	    private CheckBox RightTestisAtrophiclCkeckBox;

	    @FXML
	    private CheckBox RightTestisAbsentCheckkBox;

	    @FXML
	    private CheckBox penisCircumsizedCheck;

	    @FXML
	    private CheckBox penisuncircumsizedCheck;

	    @FXML
	    private CheckBox penisUlcerationsCheck;

	    @FXML
	    private CheckBox PenisVeneralCheck;

	    @FXML
	    private CheckBox penisNormal2Check;

	    @FXML
	    private CheckBox penisBalantisCheck;

	    @FXML
	    private CheckBox penisDischargeCheck;

	    @FXML
	    private CheckBox penisPhiosisCheck;

	    @FXML
	    private CheckBox prostateIncludeCheck;

	    @FXML
	    private CheckBox postateExamSmoothCheck;

	    @FXML
	    private CheckBox postateExamEnlargedNonTenderCheck;

	    @FXML
	    private CheckBox rodularNonCheck;

	    @FXML
	    private CheckBox postateExamHardEnlargedCheck;

	    @FXML
	    private CheckBox postateExamEnlargedTenderCheck;

	    @FXML
	    private CheckBox postateWithoutMassesCheck;

	    @FXML
	    private CheckBox postateMassesCheck;

	    @FXML
	    private CheckBox postateExamNormalCheck;

	    @FXML
	    private CheckBox scrotumLeftTestisCheck;

	    @FXML
	    private CheckBox scrotumenlargedCheck;

	    @FXML
	    private CheckBox scrotumtendernessCheck;

	    @FXML
	    private CheckBox scrotumatrophicCheck;

	    @FXML
	    private CheckBox scrotummassesCheck;

	    @FXML
	    private CheckBox scrotumleftTestisCheck;

	    @FXML
	    private CheckBox RightTestisEpdidymisCkeckBox;

	    @FXML
	    private CheckBox penisNormalCheck;

	    @FXML
	    private CheckBox boggyTenderEnlargedCheck;

	private GUInputController guInputController;

	public void setGuInputController(GUInputController guInputController) {
		this.guInputController = guInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examBasic = new StringBuilder(guInputController.str);
			examBasic.append("\n\nGU Male: ");
			guInputController.str = examBasic.toString();
			
			
			if (scrotumNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append(" Exam of scrotum shows testes normal. ");
				guInputController.str = str1.toString();
				
			}if(scrotumnormal2Check.isSelected() || scrotumepdidymisCheck.isSelected() || scrotumabsentCheck.isSelected() || scrotumHydroceleCheck.isSelected()  || 
					scrotumLeftTestisCheck.isSelected() || scrotumtendernessCheck.isSelected() || scrotummassesCheck.isSelected() ||
					scrotumenlargedCheck.isSelected() || scrotumatrophicCheck.isSelected() || scrotumleftTestisCheck.isSelected() || RightTestisAbsentCheckkBox.isSelected() || RightTestisAtrophiclCkeckBox.isSelected() || RightTestisEnlargedlCkeckBox.isSelected() || 
					RightTestisEpdidymisCkeckBox.isSelected() || RightTestisHydroceleCkeckBox.isSelected() || RightTestisMassesCkeckBox.isSelected() ||
					RightTestisNormalCkeckBox.isSelected() || RightTestisTendernessCkeckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Exam of scrotum shows ");
				guInputController.str = str1.toString();
				
			}if (scrotumnormal2Check.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("left testis normal, ");
				guInputController.str = str1.toString();
				
			}if (scrotumepdidymisCheck.isSelected()) {
				 
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("epididymis, ");
				guInputController.str = str1.toString();
				
			}if (scrotumabsentCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("absent, ");
				guInputController.str = str1.toString();
				  
			} if (scrotumHydroceleCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("hydrocele, ");
				guInputController.str = str1.toString();
				
			} if (scrotumLeftTestisCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("left testis masses, ");
				guInputController.str = str1.toString();
				
			}if (scrotumtendernessCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("tenderness, ");
				guInputController.str = str1.toString();
				
			}if (scrotummassesCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("masses, ");
				guInputController.str = str1.toString();
				
			}if (scrotumenlargedCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("enlarged, ");
				guInputController.str = str1.toString();
				
			}if (scrotumatrophicCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("atrophic");
				guInputController.str = str1.toString();
				
			}if (scrotumleftTestisCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("left testis tenderness, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisNormalCkeckBox.isSelected()) {
				 
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("right testis normal, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisTendernessCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("tenderness, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisMassesCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("masses, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisEnlargedlCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("enlarged, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisAtrophiclCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("atrophic, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisAbsentCheckkBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("absent, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisHydroceleCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("hydrocele, ");
				guInputController.str = str1.toString();
				
			}if (RightTestisEpdidymisCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("epididymis. ");
				guInputController.str = str1.toString();
				
			}if (penisNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Penis is normal. ");
				guInputController.str = str1.toString();
				
			}if(penisBalantisCheck.isSelected() || penisCircumsizedCheck.isSelected() || penisDischargeCheck.isSelected() || penisNormal2Check.isSelected() || penisPhiosisCheck.isSelected() || 
					penisUlcerationsCheck.isSelected() || penisuncircumsizedCheck.isSelected() || PenisVeneralCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Penis: ");
				guInputController.str = str1.toString();
				
				
			}if (penisNormal2Check.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("normal, ");
				guInputController.str = str1.toString();
				
			}if (penisCircumsizedCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("circumsized, ");
				guInputController.str = str1.toString();
				
			}if (penisuncircumsizedCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("uncircumsized, ");
				guInputController.str = str1.toString();
			    
			}if (penisUlcerationsCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("ulcerations noted, ");
				guInputController.str = str1.toString();
				
			}if (PenisVeneralCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("venereal warts noted, ");
				guInputController.str = str1.toString();
				
			}if (penisPhiosisCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("phimosis noted, ");
				guInputController.str = str1.toString();
				
			}if (penisBalantisCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("balantis noted, ");
				guInputController.str = str1.toString();
				
			}if (penisDischargeCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("discharge noted. ");
				guInputController.str = str1.toString();
				
			}if (prostateIncludeCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Patient declined prostate exam.");
				guInputController.str = str1.toString();
				
			}if (postateExamNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("");
				guInputController.str = str1.toString();
				
			}if(postateExamSmoothCheck.isSelected() || postateExamEnlargedNonTenderCheck.isSelected() || rodularNonCheck.isSelected() || 
					postateExamEnlargedTenderCheck.isSelected() || postateExamHardEnlargedCheck.isSelected() || boggyTenderEnlargedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("Prostate exam reveals ");
				guInputController.str = str1.toString();
				
			}if (postateExamSmoothCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("smooth nontender prostate, ");
				guInputController.str = str1.toString();
				
			}if (postateExamEnlargedNonTenderCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append(" enlarged non tender prostate, ");
				guInputController.str = str1.toString();
				
			}if (rodularNonCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("nodular non tender prostate, ");
				guInputController.str = str1.toString();
				
			}if (postateExamEnlargedTenderCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("enlarged tender prostate, ");
				guInputController.str = str1.toString();
				
			}if (postateExamHardEnlargedCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("hard enlarged nodular prostate, ");
				guInputController.str = str1.toString();
				
			}if (boggyTenderEnlargedCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("boggy tender enlarged prostate .");
				guInputController.str = str1.toString();
				
			}if (postateWithoutMassesCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("without masses, ");
				guInputController.str = str1.toString();
				
			}if (postateMassesCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(guInputController.str);
				str1.append("mass palpable. ");
				guInputController.str = str1.toString();
				
			}			
			
			++guInputController.formCount;	
			guInputController.setGIUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				++guInputController.formCount;	
				guInputController.setGIUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

	
	
}
