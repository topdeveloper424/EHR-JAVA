package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class EyeConjunctiveLidsInputController implements Initializable {
	
	 	@FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox conjunctiveNormalCkeckBox;

	    @FXML
	    private CheckBox conjunctiveBilaterallyCheck;

	    @FXML
	    private CheckBox conjunctiveRightInjectedCheck;

	    @FXML
	    private CheckBox conjunctiveBilaterallyInjectedCheck;

	    @FXML
	    private CheckBox conjunctiveRightNormalCheck;

	    @FXML
	    private CheckBox lidsNormallyBilaterallyCheckBox;

	    @FXML
	    private CheckBox lidsLeftNormalCheckBox;

	    @FXML
	    private CheckBox lidsRightNormalCheckBox;

	    @FXML
	    private CheckBox lidsChalazioCheckBox;

	    @FXML
	    private CheckBox lidsEctropionCheckBox;

	    @FXML
	    private CheckBox lidsShowingCheckBox;

	    @FXML
	    private CheckBox conjunctiveLeftNormalCheck;

	    @FXML
	    private CheckBox conjunctiveLeftInjectedCheck;

	    @FXML
	    private CheckBox ScleraeNormallyBilaterallyCheck;

	    @FXML
	    private CheckBox ScleraeRightNormalCheck;

	    @FXML
	    private CheckBox ScleraeAnictericCheck;

	    @FXML
	    private CheckBox ScleraeRightNormalHemorrCheck;

	    @FXML
	    private CheckBox ScleraeLeftNormalCheck;

	    @FXML
	    private CheckBox ScleraeleftNormalHemorrCheck;

	    @FXML
	    private CheckBox scleraeNormalCheck;

	    @FXML
	    private CheckBox lidsNormalCheck;
	    
	    private ExamEyeInputController examEyeInputController;

	    public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
			this.examEyeInputController = examEyeInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEyeInputController.str);
			examComp.append("\n\nEYE: ");
			examEyeInputController.str = examComp.toString();
			
						
			
			if (conjunctiveNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Conjunctivae are normal bilaterally ");
				examEyeInputController.str = str1.toString();

			} else {

				if (conjunctiveBilaterallyCheck.isSelected() || conjunctiveBilaterallyInjectedCheck.isSelected()
						|| conjunctiveLeftInjectedCheck.isSelected() || conjunctiveLeftNormalCheck.isSelected()
						|| conjunctiveNormalCkeckBox.isSelected() || conjunctiveRightInjectedCheck.isSelected()
						|| conjunctiveRightNormalCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Conjunctivae are ");
					examEyeInputController.str = str11.toString();

					if (conjunctiveBilaterallyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal bilaterally, ");
						examEyeInputController.str = str1.toString();

					} 
					if (conjunctiveBilaterallyInjectedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally injected, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveLeftInjectedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left injected, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveLeftNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveNormalCkeckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveRightInjectedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right injected, ");
						examEyeInputController.str = str1.toString();

					}
					if (conjunctiveRightNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();

					}

					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}

			}
			
			
			
			
			
			
			
			if(scleraeNormalCheck.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Sclerae normal bilaterally");
				examEyeInputController.str = str12.toString();
				
			}else{
				
				if (ScleraeAnictericCheck.isSelected() || ScleraeLeftNormalCheck.isSelected()
						|| ScleraeleftNormalHemorrCheck.isSelected() || ScleraeNormallyBilaterallyCheck.isSelected()
						|| ScleraeRightNormalCheck.isSelected() || ScleraeRightNormalHemorrCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Sclerae: ");
					examEyeInputController.str = str11.toString();

					if (ScleraeAnictericCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("anicteric, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeLeftNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeleftNormalHemorrCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left scleral hemorrhage, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeNormallyBilaterallyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal bilaterally, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeRightNormalCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (ScleraeRightNormalHemorrCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right scleral hemorrhage, ");
						examEyeInputController.str = str1.toString();

					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}
				
			}
			
			
			
			
			
			
			
			
			
			
			
			if(lidsNormalCheck.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Lids are normal. ");
				examEyeInputController.str = str12.toString();
				
			}else{
				
				
				if (lidsChalazioCheckBox.isSelected() || lidsEctropionCheckBox.isSelected()
						|| lidsLeftNormalCheckBox.isSelected() || lidsNormallyBilaterallyCheckBox.isSelected()
						|| lidsRightNormalCheckBox.isSelected() || lidsShowingCheckBox.isSelected()) {

					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Lids are ");
					examEyeInputController.str = str11.toString();

					if (lidsChalazioCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("chalazion, ");
						examEyeInputController.str = str1.toString();

					}   
					if (lidsEctropionCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("ectropion, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsLeftNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsNormallyBilaterallyCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsRightNormalCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();

					}
					if (lidsShowingCheckBox.isSelected()) {

						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("showing seborrheic changes, ");
						examEyeInputController.str = str1.toString();

					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();

				}
				
				
			}
			
			
			
			
			
			
			++examEyeInputController.formCount;	
			examEyeInputController.setEyeUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examEyeInputController.formCount;	
				examEyeInputController.setEyeUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
