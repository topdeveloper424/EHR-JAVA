package com.ets.controller.gui.emrCharting.result.otherTest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.result.ResultInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class PTParametersExercisesInputController implements Initializable {
	
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private CheckBox generalPRECkeckBox;

    @FXML
    private CheckBox generalARomCheck;

    @FXML
    private CheckBox generalStretchCheck;

    @FXML
    private CheckBox generalAARomsCheck;

    @FXML
    private CheckBox generalPRomCheck;

    @FXML
    private CheckBox spineSwissballCheck;

    @FXML
    private CheckBox spinePelvicCheck;

    @FXML
    private CheckBox spineSingleCheck;

    @FXML
    private CheckBox general2FoarRollerCheck;

    @FXML
    private CheckBox spineHamstringCheck;

    @FXML
    private CheckBox spineLateralCheck;

    @FXML
    private CheckBox spineAngryCheck;

    @FXML
    private CheckBox spineCobraCheck;

    @FXML
    private CheckBox spineSupermanCheck;

    @FXML
    private CheckBox spineFoamRollerCheck;

    @FXML
    private CheckBox shoulderExternalCheck;

    @FXML
    private CheckBox shoulderWallCheck;

    @FXML
    private CheckBox shoulderWandCheck;

    @FXML
    private CheckBox shoulderCodmanCheck;

    @FXML
    private CheckBox shoulderSwissballCheck;

    @FXML
    private CheckBox shoulderClimbingCheck;

    @FXML
    private CheckBox shoulderRowingCheck;

    @FXML
    private CheckBox shoulderLateralCheck;

    @FXML
    private CheckBox shoulderPNFCheck;

    @FXML
    private CheckBox elbowHandBallCheck;

    @FXML
    private CheckBox elbowDigiFlexCheckBox;

    @FXML
    private CheckBox elbowMarbleCheck;

    @FXML
    private CheckBox elbowDesensitizationCheck;

    @FXML
    private CheckBox elbowNutralCheck;

    @FXML
    private CheckBox elbowPowerCheck;

    @FXML
    private CheckBox elbowFineMotorCheck;

    @FXML
    private CheckBox elbowExeboardCheck;

    @FXML
    private CheckBox elbowFlexBarCheck;

    @FXML
    private CheckBox generalIsometricsCheck;

    @FXML
    private CheckBox generalTBandCheck;

    @FXML
    private CheckBox generalStabilizationCheck;

    @FXML
    private CheckBox general2SwissballCheck;

    @FXML
    private CheckBox generalTreadmillCheck;

    @FXML
    private CheckBox general2PNFCheck;

    @FXML
    private CheckBox generalRelaxationCheck;

    @FXML
    private CheckBox general2PilatesCheck;

    @FXML
    private CheckBox shoulderSideCheck;

    @FXML
    private CheckBox shoulderPullyCheck;

    @FXML
    private CheckBox elbowTheraputtyCheck;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox shoulderTowelCheck;

    @FXML
    private CheckBox generalUBECheck;

    @FXML
    private CheckBox generalBicycleCheck;

    @FXML
    private CheckBox spineDoubleCheck;

    @FXML
    private CheckBox spineMidBackCheck;

    @FXML
    private CheckBox spineBidgesCheck;

    @FXML
    private CheckBox kneeQuadricepsCheck;

    @FXML
    private CheckBox kneeGlutealCheck;

    @FXML
    private CheckBox kneeLAQCheck;

    @FXML
    private CheckBox kneeLegPressCheck;

    @FXML
    private CheckBox kneeExtensionCheck;

    @FXML
    private CheckBox kneeLegCurlCheck;

    @FXML
    private CheckBox kneeRestoratorCheck;

    @FXML
    private CheckBox kneeStepperCheck;

    @FXML
    private CheckBox kneeDynaCheck;

    @FXML
    private CheckBox kneeHamstringCheck;

    @FXML
    private CheckBox kneeSLRCheck;

    @FXML
    private CheckBox kneeSAQCheck;

    @FXML
    private CheckBox footAnklePumpsCheck;

    @FXML
    private CheckBox footInversionCheckBox;

    @FXML
    private CheckBox footCalfCheck;

    @FXML
    private CheckBox footAnkleLungeCheck;

    @FXML
    private CheckBox footBapBoardCheck;

    @FXML
    private CheckBox footKneelingCheck;

    @FXML
    private CheckBox footAnkleCircleCheck;

    @FXML
    private CheckBox footTowelCheck;

    @FXML
    private CheckBox footABCCheck;

    @FXML
    private CheckBox Proprioception2FeetCheck;

    @FXML
    private CheckBox ProprioceptionDiscCheck;

    @FXML
    private CheckBox ProprioceptionTherabandCheck;

    @FXML
    private CheckBox ProprioceptionSingleLegCheck;

    @FXML
    private CheckBox ProprioceptionSingleLegStandCheck;

    @FXML
    private CheckBox ProprioceptionWobbleCheck;
	
	private ResultInputController resultInputController;

	public void setResultInputController(ResultInputController resultInputController) {
		this.resultInputController = resultInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
				
		doneBtn.setOnAction((event) -> {

			StringBuilder procedureStr = new StringBuilder(resultInputController.str);
			procedureStr.append("\n\n ");
			resultInputController.str = procedureStr.toString();

			
			
			
			if (generalAARomsCheck.isSelected() || generalARomCheck.isSelected()
					|| generalBicycleCheck.isSelected() || generalIsometricsCheck.isSelected()
					|| generalPRECkeckBox.isSelected() || generalPRomCheck.isSelected()
					|| generalRelaxationCheck.isSelected() || generalStabilizationCheck.isSelected()
					|| generalStretchCheck.isSelected() || generalTBandCheck.isSelected()
					|| generalTreadmillCheck.isSelected() || generalUBECheck.isSelected()) {

				
				
				if (generalAARomsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("aaROM, ");
					resultInputController.str = str1.toString();
					
				}if (generalARomCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("AROM, ");
					resultInputController.str = str1.toString();

				}if (generalBicycleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("bicycle, ");
					resultInputController.str = str1.toString();

				}if (generalIsometricsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("isometrics, ");
					resultInputController.str = str1.toString();

		
				}if (generalPRECkeckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("PRE's, ");
					resultInputController.str = str1.toString();

				}if (generalPRomCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("pROM, ");
					resultInputController.str = str1.toString();

				}if (generalRelaxationCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("relaxation techniques, ");
					resultInputController.str = str1.toString();
					
				}if (generalStabilizationCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("stabilization, ");
					resultInputController.str = str1.toString();

				}if (generalStretchCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("stretches, ");
					resultInputController.str = str1.toString();

				}if (generalTBandCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("T-Band exercises, ");
					resultInputController.str = str1.toString();
					
				}if (generalTreadmillCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("treadmill, ");
					resultInputController.str = str1.toString();

				}if (generalUBECheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("UBE, ");
					resultInputController.str = str1.toString();

				} 
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			if (general2FoarRollerCheck.isSelected() || general2PilatesCheck.isSelected()
							|| general2PNFCheck.isSelected() || general2SwissballCheck.isSelected()) {

				
				
				if (general2FoarRollerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" foam roller,");
					resultInputController.str = str1.toString();
								
				}if (general2PilatesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" pilates,");
					resultInputController.str = str1.toString();

				}if (general2PNFCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" PNF,");
					resultInputController.str = str1.toString();

				}if (general2SwissballCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append(" swissball,");
					resultInputController.str = str1.toString();
					
				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			
			
			
			if (spineAngryCheck.isSelected() || spineBidgesCheck.isSelected()
					|| spineCobraCheck.isSelected() || spineDoubleCheck.isSelected()
					|| spineFoamRollerCheck.isSelected() || spineHamstringCheck.isSelected()
					|| spineLateralCheck.isSelected() || spineMidBackCheck.isSelected()
					|| spinePelvicCheck.isSelected() || spineSingleCheck.isSelected()
					|| spineSupermanCheck.isSelected() || spineSwissballCheck.isSelected()) {

				
				
				if (spineAngryCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("angry cat stretch, ");
					resultInputController.str = str1.toString();
					
				}if (spineBidgesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("bridges, ");
					resultInputController.str = str1.toString();

				}if (spineCobraCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("cobra stretch, ");
					resultInputController.str = str1.toString();
					
				}if (spineDoubleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("double-knee-chest, ");
					resultInputController.str = str1.toString();
					
				}if (spineFoamRollerCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("foam roller exercises, ");
					resultInputController.str = str1.toString();

				}if (spineHamstringCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("hamstring stretch, ");
					resultInputController.str = str1.toString();

				}if (spineLateralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Lateral trunk rotation, ");
					resultInputController.str = str1.toString();
					
				}if (spineMidBackCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("mid-back stretch, ");
					resultInputController.str = str1.toString();

				}if (spinePelvicCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("pelvic tilt, ");
					resultInputController.str = str1.toString();

				}if (spineSingleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Single-knee-chest, ");
					resultInputController.str = str1.toString();
							
				}if (spineSupermanCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("superman, ");
					resultInputController.str = str1.toString();

				}if (spineSwissballCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Swissball, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
			
			
			
			
			
			
			
			
			
			 if (shoulderClimbingCheck.isSelected() || shoulderCodmanCheck.isSelected()
				     || shoulderExternalCheck.isSelected() || shoulderLateralCheck.isSelected()
				     || shoulderPNFCheck.isSelected() || shoulderPullyCheck.isSelected()
				     || shoulderRowingCheck.isSelected() || shoulderSideCheck.isSelected()
				     || shoulderSwissballCheck.isSelected() || shoulderTowelCheck.isSelected()
				     || shoulderWallCheck.isSelected() || shoulderWandCheck.isSelected()) {

				    
				    if (shoulderClimbingCheck.isSelected()) {

				     StringBuilder str1 = new StringBuilder(resultInputController.str);
				     str1.append("climbing wall, ");
				     resultInputController.str = str1.toString();
				     
				    }if (shoulderCodmanCheck.isSelected()) {

				     StringBuilder str1 = new StringBuilder(resultInputController.str);
				     str1.append("Codman, ");
				     resultInputController.str = str1.toString();

				    }if (shoulderExternalCheck.isSelected()) {

				     StringBuilder str1 = new StringBuilder(resultInputController.str);
				     str1.append("External/internal rotation, ");
				     resultInputController.str = str1.toString();

				    }if (shoulderLateralCheck.isSelected()) {

				     StringBuilder str1 = new StringBuilder(resultInputController.str);
				     str1.append("lateral pull down, ");
				     resultInputController.str= str1.toString();
				    }
				    			    
				    if (shoulderPNFCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("PNF, ");
					     resultInputController.str= str1.toString();
					    }
				    
				    if (shoulderPullyCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("shoulder pulley, ");
					     resultInputController.str= str1.toString();
					    }
				    if (shoulderRowingCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("rowing, ");
					     resultInputController.str= str1.toString();
					    }
				    if (shoulderSideCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("side raise, ");
					     resultInputController.str= str1.toString();
					    }
				      
				    
				    if (shoulderSwissballCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("swissball, ");
					     resultInputController.str= str1.toString();
					    }
				    if (shoulderTowelCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("towel exercises, ");
					     resultInputController.str= str1.toString();
					    }
				    if (shoulderWallCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("wall push-up, ");
					     resultInputController.str= str1.toString();
					    }
				    if (shoulderWandCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("wand, ");
					     resultInputController.str= str1.toString();
					    }
					    	
				   }
				    
				    
				    
					   
					   if (kneeDynaCheck.isSelected() || kneeExtensionCheck.isSelected()
					     || kneeGlutealCheck.isSelected() || kneeHamstringCheck.isSelected()
					     || kneeLAQCheck.isSelected() || kneeLegCurlCheck.isSelected()
					     || kneeLegCurlCheck.isSelected() || kneeLegPressCheck.isSelected()
					     || kneeQuadricepsCheck.isSelected() || kneeQuadricepsCheck.isSelected()
					     || kneeRestoratorCheck.isSelected() || kneeSAQCheck.isSelected()
					     || kneeSLRCheck.isSelected()|| kneeStepperCheck.isSelected()) {

					   
					   	    
					    if (kneeDynaCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("dyna-disc ball, ");
					     resultInputController.str = str1.toString();
					     
					    }if (kneeExtensionCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("Knee extension/flexion, ");
					     resultInputController.str = str1.toString();

					    }if (kneeGlutealCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("gluteal sets, ");
					     resultInputController.str = str1.toString();

					    }if (kneeHamstringCheck.isSelected()) {

					     StringBuilder str1 = new StringBuilder(resultInputController.str);
					     str1.append("hamstring sets, ");
					     resultInputController.str= str1.toString();
					    }
					    if (kneeLAQCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("LAQ's, ");
						     resultInputController.str= str1.toString();
						    }
					    if (kneeLegCurlCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("Leg curl, ");
						     resultInputController.str= str1.toString();
						    }
					    if (kneeLegPressCheck.isSelected()) {
					    	
						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("Leg Press, ");
						     resultInputController.str= str1.toString();
						    }
					    if (kneeQuadricepsCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("Quadriceps sets, ");
						     resultInputController.str= str1.toString();
						    }
					    if (kneeRestoratorCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("restorator, ");
						     resultInputController.str= str1.toString();
						    }
					    if (kneeSAQCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("SAQ's, ");
						     resultInputController.str= str1.toString();
						    }
					    if (kneeSLRCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("SLR's, ");
						     resultInputController.str= str1.toString();
						    }
					    if (kneeStepperCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("stepper, ");
						     resultInputController.str= str1.toString();
						    }
					    
					   }
					    
					    
					    
						   if (elbowDesensitizationCheck.isSelected() || elbowDigiFlexCheckBox.isSelected()
						     || elbowExeboardCheck.isSelected() || elbowFineMotorCheck.isSelected()
						     || elbowFlexBarCheck.isSelected() || elbowHandBallCheck.isSelected()
						     || elbowMarbleCheck.isSelected() || elbowMarbleCheck.isSelected()
						     || elbowNutralCheck.isSelected() || elbowPowerCheck.isSelected()
						     || elbowTheraputtyCheck.isSelected()
						    ) {

						    
						    if (elbowDesensitizationCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("desensitization, ");
						     resultInputController.str = str1.toString();
						     
						    }if (elbowDigiFlexCheckBox.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("Digiflex, ");
						     resultInputController.str = str1.toString();

						    }if (elbowExeboardCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("exerboard, ");
						     resultInputController.str = str1.toString();
						    
						    }if (elbowFineMotorCheck.isSelected()) {

						     StringBuilder str1 = new StringBuilder(resultInputController.str);
						     str1.append("fine motor drills, ");
						     resultInputController.str= str1.toString();
						    }
						    if (elbowFlexBarCheck.isSelected()) {

							     StringBuilder str1 = new StringBuilder(resultInputController.str);
							     str1.append("Flex bar, ");
							     resultInputController.str= str1.toString();
							    }
						    if (elbowHandBallCheck.isSelected()) {

							     StringBuilder str1 = new StringBuilder(resultInputController.str);
							     str1.append("hand ball, ");
							     resultInputController.str= str1.toString();
							    }
						    if (elbowMarbleCheck.isSelected()) {

							     StringBuilder str1 = new StringBuilder(resultInputController.str);
							     str1.append("marble exercises, ");
							     resultInputController.str= str1.toString();
							    }
						    if (elbowNutralCheck.isSelected()) {

							     StringBuilder str1 = new StringBuilder(resultInputController.str);
							     str1.append("neural tendon glides, ");
							     resultInputController.str= str1.toString();
							    }
						    if (elbowNutralCheck.isSelected()) {

							     StringBuilder str1 = new StringBuilder(resultInputController.str);
							     str1.append("");
							     resultInputController.str= str1.toString();
							    } 
						    if (elbowPowerCheck.isSelected()) {

							     StringBuilder str1 = new StringBuilder(resultInputController.str);
							     str1.append("power web,  ");
							     resultInputController.str= str1.toString();
							    }
						    if (elbowTheraputtyCheck.isSelected()) {

							     StringBuilder str1 = new StringBuilder(resultInputController.str);
							     str1.append("theraputty, ");
							     resultInputController.str= str1.toString();
							    }
						   }
						   
						   
						   
						   if (footABCCheck.isSelected() || footAnkleCircleCheck.isSelected()
								     || footAnkleLungeCheck.isSelected() || footAnklePumpsCheck.isSelected()
								     || footBapBoardCheck.isSelected() || footCalfCheck.isSelected()
								     || footInversionCheckBox.isSelected() || footKneelingCheck.isSelected()
								     || footTowelCheck.isSelected() 
								    ) {

								    
								    if (footABCCheck.isSelected()) {

								     StringBuilder str1 = new StringBuilder(resultInputController.str);
								     str1.append("ABC's, ");
								     resultInputController.str = str1.toString();
								     
								    }if (footAnkleCircleCheck.isSelected()) {

								     StringBuilder str1 = new StringBuilder(resultInputController.str);
								     str1.append("foot/ankle circles, ");
								     resultInputController.str = str1.toString();

								    }if (footAnkleLungeCheck.isSelected()) {

								     StringBuilder str1 = new StringBuilder(resultInputController.str);
								     str1.append("nkle lunge stretch, ");
								     resultInputController.str = str1.toString();
								     
								    }if (footAnklePumpsCheck.isSelected()) {
								    	
								    	 StringBuilder str1 = new StringBuilder(resultInputController.str);
									     str1.append("foot/ankle pumps,");
									     resultInputController.str = str1.toString();
								    }if (footBapBoardCheck.isSelected()) {

										StringBuilder str1 = new StringBuilder(resultInputController.str);
										str1.append("bap's board, ");
										resultInputController.str = str1.toString();
										
									}if (footCalfCheck.isSelected()) {

										StringBuilder str1 = new StringBuilder(resultInputController.str);
										str1.append("calf-stretch, ");
										resultInputController.str = str1.toString();

									}if (footInversionCheckBox.isSelected()) {

										StringBuilder str1 = new StringBuilder(resultInputController.str);
										str1.append("inversion stretch, ");
										resultInputController.str = str1.toString();

									}if (footKneelingCheck.isSelected()) {

										StringBuilder str1 = new StringBuilder(resultInputController.str);
										str1.append("akneeling stretch, ");
										resultInputController.str = str1.toString();
										
									}if (footTowelCheck.isSelected()) {

										StringBuilder str1 = new StringBuilder(resultInputController.str);
										str1.append("towel exercises, ");
										resultInputController.str = str1.toString();
										
									}
									
									StringBuilder str1 = new StringBuilder(resultInputController.str);
									str1.append(".");
									resultInputController.str = str1.toString();
								    
						   }
			
			
			
			
			
			
			
			
			if (Proprioception2FeetCheck.isSelected() || ProprioceptionDiscCheck.isSelected()
					|| ProprioceptionSingleLegCheck.isSelected() || ProprioceptionSingleLegStandCheck.isSelected()
					|| ProprioceptionTherabandCheck.isSelected() || ProprioceptionWobbleCheck.isSelected()) {

				
				if (Proprioception2FeetCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("2 feet, ");
					resultInputController.str = str1.toString();
					
				}if (ProprioceptionDiscCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("disc, ");
					resultInputController.str = str1.toString();
					
				}if (ProprioceptionSingleLegCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("single leg, ");
					resultInputController.str = str1.toString();

				}if (ProprioceptionSingleLegStandCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Single leg stand, ");
					resultInputController.str = str1.toString();
					
				}if (ProprioceptionTherabandCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("theraband, ");
					resultInputController.str = str1.toString();

				}if (ProprioceptionWobbleCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(resultInputController.str);
					str1.append("Wobble board, ");
					resultInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(resultInputController.str);
				str1.append(".");
				resultInputController.str = str1.toString();
				

			}
						

			++resultInputController.formCount;
			resultInputController.setResUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});

		skipBtn.setOnAction((event) -> {
			try {
				++resultInputController.formCount;
				resultInputController.setResUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
