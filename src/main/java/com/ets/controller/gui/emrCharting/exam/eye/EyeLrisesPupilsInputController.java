package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class EyeLrisesPupilsInputController implements Initializable{
	
	 	@FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox PupilsMidpointCheck;

	    @FXML
	    private CheckBox PupilsBilaterallyDilatedCheck;

	    @FXML
	    private CheckBox PupilsBilaterallyContrictedCheck;

	    @FXML
	    private CheckBox PupilsLeftMidpointCheck;

	    @FXML
	    private CheckBox PupilsLeftContrictedCheck;

	    @FXML
	    private CheckBox PupilsLeftDilatedCheck;

	    @FXML
	    private CheckBox ReactivityBilateralNormalCheck;

	    @FXML
	    private CheckBox ReactivityLeftNormalCheck;

	    @FXML
	    private CheckBox ReactivityleftSluggishCheck;

	    @FXML
	    private CheckBox ReactivityLeftUnreactiveNormalCheck;

	    @FXML
	    private CheckBox ReactivityRightlNormalCheck;

	    @FXML
	    private CheckBox ReactivityRightSluggishResCheck;

	    @FXML
	    private CheckBox ReactivityRightUnreactiveNormalCheck;

	    @FXML
	    private CheckBox AccomodationBilateralNormalCheck;

	    @FXML
	    private CheckBox AccomodationLeftNormalCheck;

	    @FXML
	    private CheckBox AccomodationLeftSlowCheck;

	    @FXML
	    private CheckBox AccomodationRightUnResponsiveCheck;

	    @FXML
	    private CheckBox AccomodationRightlNormalCheck;

	    @FXML
	    private CheckBox pupilsNormalCheck;

	    @FXML
	    private CheckBox PupilsRightMidPointCheck;

	    @FXML
	    private CheckBox PupilsRightConstrictedCheck;

	    @FXML
	    private CheckBox AccomodationRightSlowCheck;

	    @FXML
	    private CheckBox AccomodationleftUnResponsiveCheck;

	    @FXML
	    private CheckBox PupilsRightDilatedCheck;

	    @FXML
	    private CheckBox ReactivityNormalCheck;

	    @FXML
	    private CheckBox AccomodationNormalCheck;
	    
	    private ExamEyeInputController examEyeInputController;

	    public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
			this.examEyeInputController = examEyeInputController;
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEyeInputController.str);
			examComp.append("\n\n: ");
			examEyeInputController.str = examComp.toString();
			
		
			
			
			
			
			
			
			
			
if(pupilsNormalCheck.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Pupils are midpoint bilaterally, and normally reactive to light and accommodation.	");
				examEyeInputController.str = str12.toString();
				
			}else{
				
				
				if (PupilsMidpointCheck.isSelected() || PupilsBilaterallyContrictedCheck.isSelected() || PupilsBilaterallyDilatedCheck.isSelected()
						|| PupilsLeftContrictedCheck.isSelected() || PupilsLeftMidpointCheck.isSelected() || PupilsRightConstrictedCheck.isSelected()
						|| PupilsRightMidPointCheck.isSelected() || PupilsLeftDilatedCheck.isSelected() || PupilsRightDilatedCheck.isSelected()) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("Pupils are ");
					examEyeInputController.str = str12.toString();
					
					
					if (PupilsMidpointCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("midpoint bilaterally, ");
						examEyeInputController.str = str1.toString();
							
					}if (PupilsRightDilatedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right dilated , ");
						examEyeInputController.str = str1.toString();
							
					}if (PupilsBilaterallyContrictedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally constricted, ");
						examEyeInputController.str = str1.toString();
						
					}if (PupilsBilaterallyDilatedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally dilated, ");
						examEyeInputController.str = str1.toString();
						
					}if (PupilsLeftContrictedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left constricted, ");
						examEyeInputController.str = str1.toString();
						
					}if (PupilsLeftMidpointCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left midpoint, ");
						examEyeInputController.str = str1.toString();
						
					}if (PupilsRightConstrictedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right constricted, ");
						examEyeInputController.str = str1.toString();
						
					}if (PupilsRightMidPointCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right midpoint, ");
						examEyeInputController.str = str1.toString();
						
					}if (PupilsLeftDilatedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left dilated, ");
						examEyeInputController.str = str1.toString();
						
					}
					
									
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append(".");
					examEyeInputController.str = str11.toString();
					
					
				}
				
			}
			
			
			
			
			
			

			if(ReactivityNormalCheck.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("normally neactive to light. ");
				examEyeInputController.str = str12.toString();
				
			}else{
				
				
				if (ReactivityBilateralNormalCheck.isSelected() || ReactivityLeftNormalCheck.isSelected() || ReactivityleftSluggishCheck.isSelected()
						|| ReactivityLeftUnreactiveNormalCheck.isSelected() || ReactivityRightlNormalCheck.isSelected() || ReactivityRightSluggishResCheck.isSelected()
						|| ReactivityRightUnreactiveNormalCheck.isSelected()) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("reactivity to light: ");
					examEyeInputController.str = str12.toString();
					
					
					if (ReactivityBilateralNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally normal, ");
						examEyeInputController.str = str1.toString();
						 		
					}if (ReactivityLeftNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (ReactivityleftSluggishCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left sluggish response, ");
						examEyeInputController.str = str1.toString();
						
					}if (ReactivityLeftUnreactiveNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left unreactive, ");
						examEyeInputController.str = str1.toString();
						
					}if (ReactivityRightlNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (ReactivityRightSluggishResCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right sluggish response, ");
						examEyeInputController.str = str1.toString();
						
					}if (ReactivityRightUnreactiveNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right unreactive, ");
						examEyeInputController.str = str1.toString();
						
					}
									
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append(".");
					examEyeInputController.str = str11.toString();
					
					
				}
				
				
			}
			
			
			
			
			
			
			
			
			
			
			if(AccomodationNormalCheck.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Accommodation normal bilaterally.");
				examEyeInputController.str = str12.toString();
				
				
			}else{
				
				
				if (AccomodationBilateralNormalCheck.isSelected() || AccomodationLeftNormalCheck.isSelected() || AccomodationLeftSlowCheck.isSelected()
						|| AccomodationleftUnResponsiveCheck.isSelected() || AccomodationRightlNormalCheck.isSelected() || AccomodationRightSlowCheck.isSelected()
						|| AccomodationRightUnResponsiveCheck.isSelected()) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("Accommodation: ");
					examEyeInputController.str = str12.toString();
					
					
					if (AccomodationBilateralNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("bilaterally normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (AccomodationLeftNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (AccomodationLeftSlowCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left slow, ");
						examEyeInputController.str = str1.toString();
						
					}if (AccomodationleftUnResponsiveCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left unresponsive, ");
						examEyeInputController.str = str1.toString();
						
					}if (AccomodationRightlNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (AccomodationRightSlowCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right slow, ");
						examEyeInputController.str = str1.toString();
						
					}if (AccomodationRightUnResponsiveCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right unresponsive, ");
						examEyeInputController.str = str1.toString();
						
					}
					
									
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append(".");
					examEyeInputController.str = str11.toString();
					
					
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
