package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 7-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EyeComprehensiveMultiSystemInputController Class
 *Description: eyeComphrensiveMultiSystem GUI Controller class
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
public class EyeComprehensiveMultiSystemInputController implements Initializable{
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox conjunctiveNormalCkeckBox;

	    @FXML
	    private CheckBox ODNegativeCheck;

	    @FXML
	    private CheckBox OSPOsitiveCheck;

	    @FXML
	    private CheckBox ODPositiveCheck;

	    @FXML
	    private CheckBox OSNegativeCheck;

	    @FXML
	    private CheckBox lidsNormalBilaterallyCheck;

	    @FXML
	    private CheckBox lidsLeftNormalCheck;

	    @FXML
	    private CheckBox lidsRightNormalCheck;

	    @FXML
	    private CheckBox lidsChalazionCheck;

	    @FXML
	    private CheckBox lidsEctropionCheck;

	    @FXML
	    private CheckBox lidsShowingCheck;

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
	    private CheckBox PupilsRightDilatedCheck;

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
	    private CheckBox FunduscopicLeftDiseCheckBox;

	    @FXML
	    private CheckBox FunduscopicRightDiseCheckBox;

	    @FXML
	    private CheckBox FunduscopicRightPapilledemaCheckBox;

	    @FXML
	    private CheckBox FunduscopicLeftPapilledemaCheckBox;

	    @FXML
	    private CheckBox FunduscopicNormalDiseCheckBox;

	    @FXML
	    private CheckBox cataractsCheckBox;

	    @FXML
	    private CheckBox cataractsLeftNormalCheckBox;

	    @FXML
	    private CheckBox cataractsRightNormalCheckBox;

	    @FXML
	    private CheckBox cataractsLeftEyeCheckBox;

	    @FXML
	    private CheckBox vesselAppearCkeckBox;

	    @FXML
	    private CheckBox nohemorrhagesCheck;

	    @FXML
	    private CheckBox HemorrhagesRightCheckBox;

	    @FXML
	    private CheckBox HemorrhagesLeftCheck;

	    @FXML
	    private CheckBox HemorrhagesCheck;

	    @FXML
	    private CheckBox noExudatesCheck;

	    @FXML
	    private CheckBox withExudatesCheck;

	    @FXML
	    private CheckBox exudatesLeft;

	    @FXML
	    private CheckBox exudatesRightCheck;

	    @FXML
	    private CheckBox noHemorrhagesExudatesCheck;

	    @FXML
	    private CheckBox FunduscopicNormalCkeckBox;

	    @FXML
	    private CheckBox OUNegativeCheck;

	    @FXML
	    private CheckBox OUPositiveCheck;

	    @FXML
	    private CheckBox ScleraeNormallyBilaterallyCheck;

	    @FXML
	    private CheckBox ScleraeRightNormalCheck;

	    @FXML
	    private CheckBox ScleraeAnictericCheck;

	    @FXML
	    private CheckBox ScleraeRightHemorrCheck;

	    @FXML
	    private CheckBox ScleraeLeftNormalCheck;

	    @FXML
	    private CheckBox ScleraeleftNormalHemorrCheck;

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
	    private CheckBox includeCkeckBox;

	    @FXML
	    private CheckBox FunduscopicRightPallorCheckBox;

	    @FXML
	    private CheckBox FunduscopicLeftPallorCheckBox;

	    @FXML
	    private CheckBox cataractsRightEyeCheckBox;

	    @FXML
	    private CheckBox showAVCheck;

	    @FXML
	    private CheckBox showSilverWireCheck;
	    
	    private ExamEyeInputController examEyeInputController;

	    public void setExamEyeInputController(ExamEyeInputController examEyeInputController) {
			this.examEyeInputController = examEyeInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEyeInputController.str);
			examComp.append("\n\nEYES: ");
			examEyeInputController.str = examComp.toString();
			
						
			
			if (conjunctiveNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Conjunctivae are normal bilaterally. Sclerae are normal and lids are normal. ");
				examEyeInputController.str = str1.toString();
				
			}else{
				
				if (ODNegativeCheck.isSelected() || OUNegativeCheck.isSelected() || ODPositiveCheck.isSelected() || OUPositiveCheck.isSelected() 
						|| OSNegativeCheck.isSelected() || OSPOsitiveCheck.isSelected() ) {
					
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Inspection of conjunctivae revealed");
					examEyeInputController.str = str11.toString();
					
					
					if (ODNegativeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OD-negative for injection, ");
						examEyeInputController.str = str1.toString();
						
					}if (OUNegativeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OU- negative for injection, ");
						examEyeInputController.str = str1.toString();
						
					}if (ODPositiveCheck.isSelected()) {
										
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OD- positive for injection, ");
						examEyeInputController.str = str1.toString();
						
					}if (OUPositiveCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OU- positive for injection, ");
						examEyeInputController.str = str1.toString();
						
					}if (OSNegativeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OS- negative for injection, ");
						examEyeInputController.str = str1.toString();
						
					}if (OSPOsitiveCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OS- positive for injection, ");
						examEyeInputController.str = str1.toString();
						
					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();
					
				}
				
				
				
			}
			
			
			
			
			if (ScleraeNormallyBilaterallyCheck.isSelected() || ScleraeAnictericCheck.isSelected() || ScleraeLeftNormalCheck.isSelected()
					|| ScleraeleftNormalHemorrCheck.isSelected() || ScleraeRightHemorrCheck.isSelected() || ScleraeRightNormalCheck.isSelected()) {
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Sclerae: ");
				examEyeInputController.str = str12.toString();
				
				
				if (ScleraeNormallyBilaterallyCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("normal bilaterally, ");
					examEyeInputController.str = str1.toString();
					
				}if (ScleraeAnictericCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("anicteric, ");
					examEyeInputController.str = str1.toString();
					
				}if (ScleraeLeftNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (ScleraeleftNormalHemorrCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left scleral hemorrhage, ");
					examEyeInputController.str = str1.toString();
					
				}if (ScleraeRightHemorrCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right scleral hemorrhage, ");
					examEyeInputController.str = str1.toString();
					
				}if (ScleraeRightNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right normal, ");
					examEyeInputController.str = str1.toString();
					
				}
				
								
				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append(".");
				examEyeInputController.str = str11.toString();
				
				
			}
			
			
			
			
			if (lidsNormalBilaterallyCheck.isSelected() || lidsChalazionCheck.isSelected() || lidsEctropionCheck.isSelected()
					|| lidsLeftNormalCheck.isSelected() || lidsRightNormalCheck.isSelected() || lidsShowingCheck.isSelected()) {
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Lids are ");
				examEyeInputController.str = str12.toString();
				
				
				if (lidsNormalBilaterallyCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("bilaterally normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (lidsChalazionCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("chalazion, ");
					examEyeInputController.str = str1.toString();
					  	
				}if (lidsEctropionCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(" ectropion, ");
					examEyeInputController.str = str1.toString();
					
				}if (lidsLeftNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (lidsRightNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (lidsShowingCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("showing seborrheic changes, ");
					examEyeInputController.str = str1.toString();
					
				}
				
								
				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append(".");
				examEyeInputController.str = str11.toString();
				
				
			}
			
			
			
			
			
			
			
			
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
			
			
			
			
			
			
			if (includeCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Dilated pupils for ophthalmoscopic examination. ");
				examEyeInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			
			if(FunduscopicNormalCkeckBox.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Funduscopic exam reveals normal discs and vessels, no cataracts and no hemorrhages or exudates.");
				examEyeInputController.str = str12.toString();
				
				
			}else{
				
				if (FunduscopicLeftDiseCheckBox.isSelected() || FunduscopicLeftPallorCheckBox.isSelected() || FunduscopicLeftPapilledemaCheckBox.isSelected()
						|| FunduscopicNormalDiseCheckBox.isSelected() || FunduscopicRightDiseCheckBox.isSelected() || FunduscopicRightPallorCheckBox.isSelected()
						|| FunduscopicRightPapilledemaCheckBox.isSelected()) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("Funduscopic exam reveals ");
					examEyeInputController.str = str12.toString();
					
					 
					if (FunduscopicLeftDiseCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left disc normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (FunduscopicLeftPallorCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left pallor, ");
						examEyeInputController.str = str1.toString();
						
					}if (FunduscopicLeftPapilledemaCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left papilledema, ");
						examEyeInputController.str = str1.toString();
						
					}if (FunduscopicNormalDiseCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal discs, ");
						examEyeInputController.str = str1.toString();
						
					}if (FunduscopicRightDiseCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right disc normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (FunduscopicRightPallorCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right pallor, ");
						examEyeInputController.str = str1.toString();
						
					}if (FunduscopicRightPapilledemaCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right papilledema, ");
						examEyeInputController.str = str1.toString();
						
					}
					
									
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append(".");
					examEyeInputController.str = str11.toString();
				
			}
			
				
				
			}
			
			
			
			
			
			if (cataractsCheckBox.isSelected() || cataractsLeftEyeCheckBox.isSelected() || cataractsLeftNormalCheckBox.isSelected()
					|| cataractsRightEyeCheckBox.isSelected() || cataractsRightNormalCheckBox.isSelected() ) {
				
				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append("with ");
				examEyeInputController.str = str11.toString();
				
				
				
				if (cataractsCheckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("no cataracts, ");
					examEyeInputController.str = str1.toString();
					
				}if (cataractsLeftEyeCheckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left eye cataract ");
					examEyeInputController.str = str1.toString();
					
				}if (cataractsLeftNormalCheckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (cataractsRightEyeCheckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right eye cataract, ");
					examEyeInputController.str = str1.toString();
					
				}if (cataractsRightNormalCheckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right normal, ");
					examEyeInputController.str = str1.toString();
					
				}
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append(".");
				examEyeInputController.str = str1.toString();
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			 if (vesselAppearCkeckBox.isSelected() || showAVCheck.isSelected() || showSilverWireCheck.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Vessels ");
					examEyeInputController.str = str11.toString();
					
					if (vesselAppearCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("appear normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (showAVCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("show AV nicking, ");
						examEyeInputController.str = str1.toString();
						
					}if (showSilverWireCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("show silver-wire change, ");
						examEyeInputController.str = str1.toString();
						
					}
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(".");
					examEyeInputController.str = str1.toString();
					
					
				}
			 
			
			
			
			
			
			
			
			
			
			
			
			
			
			 if (noHemorrhagesExudatesCheck.isSelected() || nohemorrhagesCheck.isSelected() || noExudatesCheck.isSelected()
					 || HemorrhagesCheck.isSelected() || HemorrhagesLeftCheck.isSelected() || HemorrhagesRightCheckBox.isSelected()
					 || withExudatesCheck.isSelected() || exudatesRightCheck.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("and have ");
					examEyeInputController.str = str11.toString();
					
					
					if (noHemorrhagesExudatesCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("no hemorrhages or exudates, ");
						examEyeInputController.str = str1.toString();
						
					}if (nohemorrhagesCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("no hemorrhages, ");
						examEyeInputController.str = str1.toString();
						
					}if (noExudatesCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("no exudates, ");
						examEyeInputController.str = str1.toString();
						
					}if (HemorrhagesCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("hemorrhages, ");
						examEyeInputController.str = str1.toString();
						
					}if (HemorrhagesLeftCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append(" hemorrhages left, ");
						examEyeInputController.str = str1.toString();
						
					}if (HemorrhagesRightCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("hemorrhages right, ");
						examEyeInputController.str = str1.toString();
						
					}if (withExudatesCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("with exudates, ");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesLeft.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("exudates left, ");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesRightCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("exudates right, ");
						examEyeInputController.str = str1.toString();
						
					}
					
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(".");
					examEyeInputController.str = str1.toString();
					
					
					
					
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
