package com.ets.controller.gui.emrCharting.pmh.familyHistory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHFamilyHistoryInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class FamilyHistorySurveyInputController implements Initializable {
	
	
	 @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox motherStroke;

	    @FXML
	    private CheckBox MotherBreastCancer;

	    @FXML
	    private CheckBox MotherHypertension;

	    @FXML
	    private CheckBox MotherDepression;

	    @FXML
	    private CheckBox motherCancer;

	    @FXML
	    private RadioButton MotherAliveRadio;

	    @FXML
	    private ToggleGroup tatus;

	    @FXML
	    private RadioButton MotherDecreasedRadio;

	    @FXML
	    private RadioButton MotherUnknownRadio;

	    @FXML
	    private TextField AgeMotherText;

	    @FXML
	    private CheckBox motherDiabetes;

	    @FXML
	    private CheckBox motherLung;

	    @FXML
	    private CheckBox motherSaubstances;

	    @FXML
	    private CheckBox motherColon;

	    @FXML
	    private CheckBox motherHeart;

	    @FXML
	    private CheckBox motherOverain;

	    @FXML
	    private CheckBox motherOther;

	    @FXML
	    private RadioButton fatherAliveRadio;

	    @FXML
	    private ToggleGroup fat;

	    @FXML
	    private RadioButton fatherDecreasedRadio;

	    @FXML
	    private RadioButton fatherUnknownRadio;

	    @FXML
	    private TextArea motherOtherTextArea;

	    @FXML
	    private TextField fatherAgeText;

	    @FXML
	    private CheckBox fatherStroke;

	    @FXML
	    private CheckBox fatherHypertension;

	    @FXML
	    private CheckBox Fatherdepression;

	    @FXML
	    private CheckBox fatherCancer;

	    @FXML
	    private CheckBox FatherDiabetes;

	    @FXML
	    private CheckBox FatherLung;

	    @FXML
	    private CheckBox FatherSubstances;

	    @FXML
	    private CheckBox fatherColon;

	    @FXML
	    private CheckBox FatherHeart;

	    @FXML
	    private CheckBox FatherPostrate;

	    @FXML
	    private CheckBox FatherOther;

	    @FXML
	    private TextArea fatherOtherTextArea;

	    @FXML
	    private TextArea otherFamiliyTextArea;
	    
	    private PMHFamilyHistoryInputController pMHFamilyHistoryInputController;

	    public void setpMHFamilyHistoryInputController(PMHFamilyHistoryInputController pMHFamilyHistoryInputController) {
			this.pMHFamilyHistoryInputController = pMHFamilyHistoryInputController;
		}
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {

			StringBuilder pmhSocialHitoryStr = new StringBuilder(pMHFamilyHistoryInputController.str);
			pmhSocialHitoryStr.append("\n\n ");
			pMHFamilyHistoryInputController.str = pmhSocialHitoryStr.toString();

			
			
			if(MotherAliveRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append(" Mother alive. ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}if(MotherDecreasedRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Mother deceased. ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
			}
			
			if(MotherUnknownRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Mother unknown. ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}
			
			
			
			
			if(AgeMotherText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Age " +AgeMotherText.getText() +". " );
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}
			
			
			if(MotherBreastCancer.isSelected() || MotherDepression.isSelected()
					|| MotherHypertension.isSelected() || motherCancer.isSelected()
					|| motherColon.isSelected() || motherDiabetes.isSelected()
					|| motherHeart.isSelected() || motherLung.isSelected()
					|| motherOther.isSelected() || motherOverain.isSelected()
					|| motherSaubstances.isSelected() || motherStroke.isSelected()){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Patient states mother's health problems include a history of ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
				if(MotherBreastCancer.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("breast cancer, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(MotherDepression.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("depression / anxiety, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(MotherHypertension.isSelected()){
					
					 				
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("hypertension, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherCancer.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("cancer (specify), ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherColon.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("colon cancer, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherDiabetes.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("diabetes, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherHeart.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("heart disease (CAD), ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherLung.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("lung cancer, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherOther.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("Other ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherOverain.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("ovarian cancer, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherSaubstances.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("substance abuse ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(motherStroke.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("stroke (CVA), ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}
				
				
				
				
			}
			
			
			
			if(motherOtherTextArea.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Other: " +motherOtherTextArea.getText() );
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}
			
			
			
			
			
			
			if(fatherAliveRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Father unknown. ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}if(fatherDecreasedRadio.isSelected()){
				
				StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str1.append("Father unknown. ");
				pMHFamilyHistoryInputController.str = str1.toString();
				
			}
			
			if(fatherUnknownRadio.isSelected()){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Father unknown. ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}
			
			
			
			
			if(fatherAgeText.getText().length() > 0){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Age " +fatherAgeText.getText() +". ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
			}
			
			
			
			
			
			
			
			if(fatherCancer.isSelected() || fatherColon.isSelected()
					|| fatherHypertension.isSelected() || fatherStroke.isSelected()
					|| Fatherdepression.isSelected() || FatherDiabetes.isSelected()
					|| FatherHeart.isSelected() || FatherLung.isSelected()
					|| FatherOther.isSelected() || FatherPostrate.isSelected()
					|| FatherSubstances.isSelected() ){
				
				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("Patient states father's health problems include a history of ");
				pMHFamilyHistoryInputController.str = str11.toString();
				
				if(fatherCancer.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("cancer (specify), ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(fatherColon.isSelected()){
					
					  			
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("colon cancer, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(fatherHypertension.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("hypertension, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(fatherStroke.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("stroke (CVA), ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(Fatherdepression.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("depression / anxiety, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(FatherDiabetes.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("diabetes, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(FatherHeart.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("heart disease (CAD), ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(FatherLung.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("lung cancer, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
							
				}if(FatherOther.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("Other (specify ) ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}if(FatherPostrate.isSelected()){
					
					
					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("prostate cancer, ");
					pMHFamilyHistoryInputController.str = str1.toString();
					
					
				}
				if (FatherSubstances.isSelected()) {

					StringBuilder str1 = new StringBuilder(pMHFamilyHistoryInputController.str);
					str1.append("substance abuse ");
					pMHFamilyHistoryInputController.str = str1.toString();

				}

			}
			
			if (fatherOtherTextArea.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("\n" + fatherOtherTextArea.getText() +". ");
				pMHFamilyHistoryInputController.str = str11.toString();

			}

			if (otherFamiliyTextArea.getText().length() > 0) {

				StringBuilder str11 = new StringBuilder(pMHFamilyHistoryInputController.str);
				str11.append("\n" + otherFamiliyTextArea.getText() +". ");
				pMHFamilyHistoryInputController.str = str11.toString();

			}

			
			

			++pMHFamilyHistoryInputController.formCount;
			pMHFamilyHistoryInputController.setFamilyHistoryUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		

		skipBtn.setOnAction((event) -> {
			try {
				++pMHFamilyHistoryInputController.formCount;
				pMHFamilyHistoryInputController.setFamilyHistoryUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
