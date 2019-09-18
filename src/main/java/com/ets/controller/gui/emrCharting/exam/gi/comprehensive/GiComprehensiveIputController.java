package com.ets.controller.gui.emrCharting.exam.gi.comprehensive;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of GiComprehensiveIputController Class
 *Description: gi.fxml Controller class
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

import com.ets.controller.gui.emrCharting.exam.gi.ExamGIinputController;
import com.ets.controller.gui.emrCharting.pmh.PMHSocialHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;

public class GiComprehensiveIputController implements Initializable {
	
	    @FXML
	    private CheckBox abdomenNormalCkeckBox;

	    @FXML
	    private CheckBox flankCkeckBox;

	    @FXML
	    private CheckBox surgicalCkeckBox;

	    @FXML
	    private CheckBox lesionsCkeckBox;

	    @FXML
	    private CheckBox ecchymosisCkeckBox;

	    @FXML
	    private TextArea inspectionTextArea;

	    @FXML
	    private RadioButton hyperactiveRadio;

	    @FXML
	    private ToggleGroup auscullation;

	    @FXML
	    private RadioButton diminishedRadio;

	    @FXML
	    private RadioButton absendRadio;

	    @FXML
	    private CheckBox auscullationNormalCkeckBox;

	    @FXML
	    private CheckBox nttpRUSCheckBox;

	    @FXML
	    private CheckBox ttpRUQCheckBox;

	    @FXML
	    private CheckBox nttpLUQCheckBox;

	    @FXML
	    private CheckBox ttpLUQCheckBox;

	    @FXML
	    private CheckBox tendernessNormalCkeckBox;

	    @FXML
	    private CheckBox nttpRLQCheckBox;

	    @FXML
	    private CheckBox ttpRLQCheckBox;

	    @FXML
	    private CheckBox nttpLLQCheckBox;

	    @FXML
	    private CheckBox ttpLLQCheckBox;

	    @FXML
	    private CheckBox nttpEpigastricCheckBox;

	    @FXML
	    private CheckBox ttpEpigastricCheckBox;

	    @FXML
	    private CheckBox nttpUmbilicalCheckBox;

	    @FXML
	    private CheckBox ttpUmbilicalCheckBox;

	    @FXML
	    private CheckBox nttpSuperpublicCheckBox;

	    @FXML
	    private CheckBox ttpSuperpublicCheckBox;

	    @FXML
	    private CheckBox guardingNormalCkeckBox;

	    @FXML
	    private CheckBox guardingCheckBox;

	    @FXML
	    private CheckBox regidityCheckBox;

	    @FXML
	    private CheckBox reboundCheckBox;

	    @FXML
	    private CheckBox inRUQCkeckBox;

	    @FXML
	    private CheckBox inRLQCkeckBox;

	    @FXML
	    private CheckBox inLUQCkeckBox;

	    @FXML
	    private CheckBox inLLQCkeckBox;

	    @FXML
	    private CheckBox ruqCkeckBox;

	    @FXML
	    private CheckBox massesNormalCkeckBox;

	    @FXML
	    private CheckBox rlqCkeckBox;

	    @FXML
	    private CheckBox luqCkeckBox;

	    @FXML
	    private CheckBox llqCkeckBox;

	    @FXML
	    private CheckBox centralRegionCkeckBox;

	    @FXML
	    private CheckBox noOrganomegalyCheckBox;

	    @FXML
	    private CheckBox hepatomegalyCheckBox;

	    @FXML
	    private CheckBox splenomegalyCheckBox;

	    @FXML
	    private CheckBox hepaticTendernessCheckBox;

	    @FXML
	    private CheckBox liverNodularCheckBox;

	    @FXML
	    private CheckBox noneNotedCheckBox;

	    @FXML
	    private CheckBox leftInguinalCheckBox;

	    @FXML
	    private CheckBox rightInguinalCheckBox;

	    @FXML
	    private CheckBox umbilicalCheckBox;

	    @FXML
	    private CheckBox ventralCheckBox;

	    @FXML
	    private CheckBox includeCkeckBox;

	    @FXML
	    private CheckBox normalToneCheckBox;

	    @FXML
	    private CheckBox noHemorroidsCheckBox;

	    @FXML
	    private CheckBox hemeNegativeCheckBox;

	    @FXML
	    private CheckBox decreasedToneCheckBox;

	    @FXML
	    private CheckBox hemorroidsPresentCheckBox;

	    @FXML
	    private CheckBox hemePossitiveCheckBox;

	    @FXML
	    private CheckBox noMassesCheckBox;

	    @FXML
	    private CheckBox nonTenderCheckBox;

	    @FXML
	    private CheckBox exhibitedFrankBloodCheckBox;

	    @FXML
	    private CheckBox rectalNormalCkeckBox;

	    @FXML
	    private CheckBox massPalpableCheckBox;

	    @FXML
	    private CheckBox tendernessCheckBox;

	    @FXML
	    private CheckBox impactedStoolCheckBox;

	    @FXML
	    private CheckBox negativeForOccultCheckBox;

	    @FXML
	    private CheckBox possitiveForOccultCheckBox;

	    @FXML
	    private CheckBox groosBloodPresentCheckBox;

	    @FXML
	    private CheckBox frankBloodPresentCheckBox;

	    @FXML
	    private CheckBox melanoticStoolCheckBox;
	    
	    @FXML
	    private CheckBox stoolSampleAllNormalCkeckBox;

	    @FXML
	    private CheckBox wasNegativeCheckBox;

	    @FXML
	    private CheckBox wasPossitiveCheckBox;

	    @FXML
	    private CheckBox wasNotTestedCheckBox;

	    @FXML
	    private CheckBox stoolSampleGrossBloodCheckBox;

	    @FXML
	    private CheckBox wasMelanoticCheckBox;

	    @FXML
	    private CheckBox liverNormalCkeckBox;

	    @FXML
	    private CheckBox herniasNormalCkeckBox;
	    
	    @FXML
	    private CheckBox stoolSampleexibitedFrankBlood;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;


	private ExamGIinputController examGIinputController;
	
	public void setExamGIinputController(ExamGIinputController examGIinputController) {
		this.examGIinputController = examGIinputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examGIinputController.str);
			examComp.append("\n\nGI & ABDOMEN: ");
			examGIinputController.str = examComp.toString();
			
			if(abdomenNormalCkeckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Inspection of abdomen reveals normal appearance. ");
				examGIinputController.str = str1.toString();
				
			}if(flankCkeckBox.isSelected() || lesionsCkeckBox.isSelected() || ecchymosisCkeckBox.isSelected() || surgicalCkeckBox.isSelected() ){
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Inspection of abdomen reveals");
				examGIinputController.str = str1.toString();
			}
			if (flankCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("flank bulging, ");
				examGIinputController.str = str1.toString();
				
			}if (lesionsCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("lesions, ");
				examGIinputController.str = str1.toString();
				
			}if (ecchymosisCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("ecchymosis, ");
				examGIinputController.str = str1.toString();
				
			}if (surgicalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("surgical scars, ");
				examGIinputController.str = str1.toString();
				
			}if (inspectionTextArea.getText() != null) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append(inspectionTextArea.getText());
				examGIinputController.str = str1.toString();
				
			}if (auscullationNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Auscultation NABS x 4. ");
				examGIinputController.str = str1.toString();
				
			} if (hyperactiveRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Auscultation hyperactive bowel sounds. ");
				examGIinputController.str = str1.toString();
				
			} if (diminishedRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append(" Auscultation diminished bowel sounds. ");
				examGIinputController.str = str1.toString();
				
			} if (absendRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append(" Auscultation absend bowel sounds. ");
				examGIinputController.str = str1.toString();
				
			} if (tendernessNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("No tenderness noted in any area. ");
				examGIinputController.str = str1.toString();
				
			} if (nttpRUSCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("NTTP RUQ, ");
				examGIinputController.str = str1.toString();
				
			} if (nttpRLQCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("NTTP RLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (ttpRUQCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("+TTP RUQ, ");
				examGIinputController.str = str1.toString();
				 
			} if (ttpRLQCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("+TTP RLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (nttpLUQCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("NTTP LUQ, ");
				examGIinputController.str = str1.toString();
				
			} if (nttpLLQCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("NTTP LLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (ttpLUQCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("+TTP LUQ, ");
				examGIinputController.str = str1.toString();
				
			} if (ttpLLQCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("+TTP LLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (nttpEpigastricCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("NTTP epigastric, ");
				examGIinputController.str = str1.toString();
				
			} if (nttpSuperpublicCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("NTTP superpubic region, ");
				examGIinputController.str = str1.toString();
				
			} if (ttpEpigastricCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("+TTP epigastric, ");
				examGIinputController.str = str1.toString();
				
			} if (ttpSuperpublicCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("+TTP superpubic region, ");
				examGIinputController.str = str1.toString();
				
			} if (nttpUmbilicalCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("NTTP umbilical region, ");
				examGIinputController.str = str1.toString();
				
			} if (ttpUmbilicalCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("+TTP umbilical region, ");
				examGIinputController.str = str1.toString();
				
			} if (guardingNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Guarding, rigidity and rebound pain were not noted, ");
				examGIinputController.str = str1.toString();
				
			} if (guardingCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Noted guarding, ");
				examGIinputController.str = str1.toString();
				
			} if (inRLQCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("in RLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (regidityCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("rigidity, ");
				examGIinputController.str = str1.toString();
				
			} if (inLUQCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("in LUQ, ");
				examGIinputController.str = str1.toString();
				
			} if (reboundCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("rebound pain, ");
				examGIinputController.str = str1.toString();
				
			} if (inLLQCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("in LLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (inRUQCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("in RUQ, ");
				examGIinputController.str = str1.toString();
				
			} if (massesNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Masses not noted in any region. ");
				examGIinputController.str = str1.toString();
				
			}if(ruqCkeckBox.isSelected() || rlqCkeckBox.isSelected() || luqCkeckBox.isSelected() || llqCkeckBox.isSelected()){
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Masses noted in: ");
				examGIinputController.str = str1.toString();
				
			}
			 if (ruqCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("RUQ, ");
				examGIinputController.str = str1.toString();
				
			} if (centralRegionCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("central region, ");
				examGIinputController.str = str1.toString();
				
			} if (rlqCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("RLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (luqCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("LUQ, ");
				examGIinputController.str = str1.toString();
				
			} if (llqCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("LLQ, ");
				examGIinputController.str = str1.toString();
				
			} if (liverNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Exam of liver and spleen reveals no organomegaly present. ");
				examGIinputController.str = str1.toString();
				
			}if(noOrganomegalyCheckBox.isSelected() || liverNodularCheckBox.isSelected() || hepatomegalyCheckBox.isSelected() || hepaticTendernessCheckBox.isSelected() || splenomegalyCheckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Exam of liver and spleen reveals, ");
				examGIinputController.str = str1.toString();
				
			}
			 if (noOrganomegalyCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("no organomegaly present, ");
				examGIinputController.str = str1.toString();
				
			} if (liverNodularCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("liver nodular. ");
				examGIinputController.str = str1.toString();
				
			} if (hepatomegalyCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("hepatomegaly, ");
				examGIinputController.str = str1.toString();
				
			} if (hepaticTendernessCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("hepatic tenderness, ");
				examGIinputController.str = str1.toString();
				
			} if (splenomegalyCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("splenomegaly, ");
				examGIinputController.str = str1.toString();
				
			} if (herniasNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("No hernias noted. ");
				examGIinputController.str = str1.toString();
				
			}if(noneNotedCheckBox.isSelected() || ventralCheckBox.isSelected() || leftInguinalCheckBox.isSelected() || rightInguinalCheckBox.isSelected() || umbilicalCheckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Hernias: ");
				examGIinputController.str = str1.toString();
				
			}if (noneNotedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("none noted. ");
				examGIinputController.str = str1.toString();
				
			} if (ventralCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("ventral, ");
				examGIinputController.str = str1.toString();
				
			} if (leftInguinalCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("left inguinal, ");
				examGIinputController.str = str1.toString();
				
			} if (rightInguinalCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append(" right inguinal, ");
				examGIinputController.str = str1.toString();
				
			} if (umbilicalCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("umbilical, ");
				examGIinputController.str = str1.toString();
				
			} if (includeCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Patient declined rectal examination. ");
				examGIinputController.str = str1.toString();
				
			} if (rectalNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Examination of anus and rectum reveals normal tone with no masses present. ");
				examGIinputController.str = str1.toString();
				
			}if(normalToneCheckBox.isSelected() || noHemorroidsCheckBox.isSelected() || hemeNegativeCheckBox.isSelected() || noMassesCheckBox.isSelected() || 
					hemorroidsPresentCheckBox.isSelected() || hemePossitiveCheckBox.isSelected() || decreasedToneCheckBox.isSelected() || nonTenderCheckBox.isSelected() ||
					exhibitedFrankBloodCheckBox.isSelected() || massPalpableCheckBox.isSelected() || tendernessCheckBox.isSelected() || impactedStoolCheckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Rectal exam reveals ");
				examGIinputController.str = str1.toString();
				
			} if (normalToneCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("normal tone, ");
				examGIinputController.str = str1.toString();
				
			} if (noHemorroidsCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("no hemorrhoids noted, ");
				examGIinputController.str = str1.toString();
				
			} if (hemeNegativeCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("heme negative stool, ");
				examGIinputController.str = str1.toString();
				
			} if (noMassesCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("no masses,");
				examGIinputController.str = str1.toString();
				
			} if (hemorroidsPresentCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("hemorrhoids present, ");
				examGIinputController.str = str1.toString();
				
			} if (hemePossitiveCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("heme positive stool, ");
				examGIinputController.str = str1.toString();
				
			} if (decreasedToneCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("decreased tone, ");
				examGIinputController.str = str1.toString();
				
			} if (nonTenderCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("non tender near appendix, ");
				examGIinputController.str = str1.toString();
				
			} if (exhibitedFrankBloodCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("exhibited frank blood, ");
				examGIinputController.str = str1.toString();
				
			} if (massPalpableCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("mass palpable, ");
				examGIinputController.str = str1.toString();
				
			} if (tendernessCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("tenderness near appendix, ");
				examGIinputController.str = str1.toString();
				
			} if (impactedStoolCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("impacted stool. ");
				examGIinputController.str = str1.toString();
				
			} if (negativeForOccultCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Negative for occult blood. ");
				examGIinputController.str = str1.toString();
				
			} if (melanoticStoolCheckBox.isSelected()) {
			
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Melanotic stool. ");
				examGIinputController.str = str1.toString();
				
			} if (possitiveForOccultCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Positive for occult blood. ");
				examGIinputController.str = str1.toString();
				
			} if (frankBloodPresentCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Frank blood present.");
				examGIinputController.str = str1.toString();
				
			} if (groosBloodPresentCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Gross blood present. ");
				examGIinputController.str = str1.toString();
				
			}if (stoolSampleAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Stool sample was negative for occult blood. ");
				examGIinputController.str = str1.toString();
				
			} if(wasNegativeCheckBox.isSelected() || stoolSampleGrossBloodCheckBox.isSelected() || wasNotTestedCheckBox.isSelected() || 
					wasPossitiveCheckBox.isSelected() || wasMelanoticCheckBox.isSelected() || stoolSampleexibitedFrankBlood.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("Stool sample ");
				examGIinputController.str = str1.toString();
				
			}if (wasNegativeCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("was negative for occult blood.");
				examGIinputController.str = str1.toString();
				
			} if (stoolSampleGrossBloodCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("exhibited gross blood. ");
				examGIinputController.str = str1.toString();
				
			} if (wasNotTestedCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("was not tested.");
				examGIinputController.str = str1.toString();
				
			} if (wasPossitiveCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("was positive for occult blood, ");
				examGIinputController.str = str1.toString();
				
			} if (wasMelanoticCheckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("was melanotic ");
				examGIinputController.str = str1.toString();
				
			} if (stoolSampleexibitedFrankBlood.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examGIinputController.str);
				str1.append("exhibited frank blood, ");
				examGIinputController.str = str1.toString();
				
			} 
			
			++examGIinputController.formCount;	
			examGIinputController.setGIUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examGIinputController.formCount;	
				examGIinputController.setGIUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}
}
