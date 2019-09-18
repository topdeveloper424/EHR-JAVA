package com.ets.controller.gui.emrCharting.exam.mskel.leMotorStrength;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkelLeMotorStrengthInputController Class
 *Description: LEMotorStrengthExam GUI Controller class
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
public class SkelLeMotorStrengthInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox LEMuscleNormal;

    @FXML
    private CheckBox leftLowerActions;

    @FXML
    private CheckBox leftLowerActionsFlexion;

    @FXML
    private CheckBox leftLowerKneeChck;

    @FXML
    private CheckBox leftLowerExtremityChck;

    @FXML
    private CheckBox leftLowerFootChck;

    @FXML
    private CheckBox rightLeMuscleCheck;

    @FXML
    private CheckBox leftLowerActionsAdductions;

    @FXML
    private RadioButton RightLEMuscleNormalRadio;

    @FXML
    private ToggleGroup rightLe;

    @FXML
    private RadioButton LEMuscleNormalRadio;

    @FXML
    private ToggleGroup leftLe;

    @FXML
    private RadioButton LEMuscleModerateRadio;

    @FXML
    private RadioButton LEMuscleAbsentRadio;

    @FXML
    private RadioButton LEMuscleSlightlyRadio;

    @FXML
    private RadioButton LEMuscleMarkedlyRadio;

    @FXML
    private CheckBox leftLowerActionsSupination;

    @FXML
    private CheckBox leftLowerActionsExtension;

    @FXML
    private CheckBox leftLowerActionsPronation;

    @FXML
    private CheckBox leftLowerHipChck;

    @FXML
    private CheckBox leftLowerAnkleChck;

    @FXML
    private CheckBox leftLowerToesChck;

    @FXML
    private RadioButton RightLEMuscleModerateRadio;

    @FXML
    private RadioButton RightLEMuscleAbsentRadio;

    @FXML
    private RadioButton RightLEMuscleSlightlyRadio;

    @FXML
    private RadioButton RightLEMuscleMarkedlyRadio;

    @FXML
    private CheckBox rightLowerActions;

    @FXML
    private CheckBox rightLowerActionsFlexion;

    @FXML
    private CheckBox rightLowerActionsAdductions;

    @FXML
    private CheckBox rightLowerActionsSupination;

    @FXML
    private CheckBox rightLowerActionsExtension;

    @FXML
    private CheckBox rightLowerActionsPronation;

    @FXML
    private CheckBox rightLowerExtremity;

    @FXML
    private CheckBox rightLowerKneeChck;

    @FXML
    private CheckBox rightLowerFootChck;

    @FXML
    private CheckBox rightLowerHipChck;

    @FXML
    private CheckBox rightLowerAnkleChck;

    @FXML
    private CheckBox rightLowerToesChck;

	private MSkelInputController msSkelInputController;

	public void setMsSkelInputController(MSkelInputController msSkelInputController) {
		this.msSkelInputController = msSkelInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			StringBuilder skelComp = new StringBuilder(msSkelInputController.str);
			skelComp.append("\n\n ");
			msSkelInputController.str = skelComp.toString();
			
	      if (LEMuscleNormal.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(msSkelInputController.str);
				str11.append("Left lower extremity: normal. ");
				msSkelInputController.str = str11.toString();
				
				if (leftLowerActions.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("for all actions, ");
					msSkelInputController.str = str1.toString();
					
				} 
		      if (leftLowerActionsFlexion.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("flexion, ");
					msSkelInputController.str = str1.toString();
					
				}  
		      if (leftLowerActionsAdductions.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("abduction, ");
					msSkelInputController.str = str1.toString();
					
				} 
		      if (leftLowerActionsSupination.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("supination, ");
					msSkelInputController.str = str1.toString();
					
				} 
		      
		      if (leftLowerActionsExtension.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("extension, ");
					msSkelInputController.str = str1.toString();
					
				} 
		      if (leftLowerActionsPronation.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("pronation, ");
					msSkelInputController.str = str1.toString();
					
				}  
		      
		      if (leftLowerExtremityChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("of the extremity, ");
					msSkelInputController.str = str1.toString();
					
				}  
		      
		      if (leftLowerKneeChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("knee, ");
					msSkelInputController.str = str1.toString();
					
				} 
		      if (leftLowerFootChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("foot, ");
					msSkelInputController.str = str1.toString();
					
				}  
		      if (leftLowerHipChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("hip, ");
					msSkelInputController.str = str1.toString();
					
				}  
		      if (leftLowerAnkleChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("ankle, ");
					msSkelInputController.str = str1.toString();
					
				}  
		      if (leftLowerToesChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("toes, ");
					msSkelInputController.str = str1.toString();
					
				} 
		      
				
			}else{
				
				 if(LEMuscleNormalRadio.isSelected() || LEMuscleModerateRadio.isSelected()
			    		  || LEMuscleAbsentRadio.isSelected() || LEMuscleSlightlyRadio.isSelected() 
			    		  || LEMuscleMarkedlyRadio.isSelected() || leftLowerActions.isSelected()
			    		  || leftLowerActionsFlexion.isSelected() || leftLowerActionsAdductions.isSelected()
			    		  || leftLowerActionsSupination.isSelected() || leftLowerActionsExtension.isSelected()
			    		  || leftLowerActionsPronation.isSelected() ){
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("Motor strength testing of the left lower extremity: ");
						msSkelInputController.str = str1.toString();
						
					}
				 
				 if (LEMuscleNormalRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("normal");
						msSkelInputController.str = str1.toString();
						
					}   
			      if (LEMuscleModerateRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("moderately decreased ");
						msSkelInputController.str = str1.toString();
						
					} 
					
			      if (LEMuscleAbsentRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("absent");
						msSkelInputController.str = str1.toString();
						
					} 
			      if (LEMuscleSlightlyRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("slightly decreased");
						msSkelInputController.str = str1.toString();
						
					} 
					
			      if (LEMuscleMarkedlyRadio.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("markedly decreased");
						msSkelInputController.str = str1.toString();
						
					} 
			      
			      if (leftLowerActions.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("for all actions, ");
						msSkelInputController.str = str1.toString();
						
					} 
			      if (leftLowerActionsFlexion.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("flexion, ");
						msSkelInputController.str = str1.toString();
						
					}  
			      if (leftLowerActionsAdductions.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("abduction, ");
						msSkelInputController.str = str1.toString();
						
					} 
			      if (leftLowerActionsSupination.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("supination, ");
						msSkelInputController.str = str1.toString();
						
					} 
			      
			      if (leftLowerActionsExtension.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("extension, ");
						msSkelInputController.str = str1.toString();
						
					} 
			      if (leftLowerActionsPronation.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("pronation, ");
						msSkelInputController.str = str1.toString();
						
					}  
			      
			      if (leftLowerExtremityChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("of the extremity, ");
						msSkelInputController.str = str1.toString();
						
					}  
			      
			      if (leftLowerKneeChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("knee, ");
						msSkelInputController.str = str1.toString();
						
					} 
			      if (leftLowerFootChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("foot, ");
						msSkelInputController.str = str1.toString();
						
					}  
			      if (leftLowerHipChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("hip, ");
						msSkelInputController.str = str1.toString();
						
					}  
			      if (leftLowerAnkleChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("ankle, ");
						msSkelInputController.str = str1.toString();
						
					}  
			      if (leftLowerToesChck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("toes, ");
						msSkelInputController.str = str1.toString();
						
					} 
			      
			      
			      
				
			}
	     
	      
	      
	      
	       
	      if (rightLeMuscleCheck.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(msSkelInputController.str);
				str11.append(" Right lower extremity: normal. ");
				msSkelInputController.str = str11.toString();
				
				if (rightLowerActions.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("for all actions, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsFlexion.isSelected()) {
					 
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("flexion, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsAdductions.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("abduction, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsSupination.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("supination, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsExtension.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("extension, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsPronation.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("pronation, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerExtremity.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("of the extremity, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerKneeChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("knee, ");
					msSkelInputController.str = str1.toString();
					  
				} if (rightLowerFootChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("foot, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerHipChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("hip, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerAnkleChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("ankle, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerToesChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("toes, ");
					msSkelInputController.str = str1.toString();
					
				} 
				
			}else{
				
				if( RightLEMuscleNormalRadio.isSelected()
			    		  || RightLEMuscleModerateRadio.isSelected() || RightLEMuscleAbsentRadio.isSelected()
			    		  || RightLEMuscleSlightlyRadio.isSelected() || RightLEMuscleMarkedlyRadio.isSelected()
			    		  || rightLowerActions.isSelected() || rightLowerActionsFlexion.isSelected()
			    		  || rightLowerActionsAdductions.isSelected() || rightLowerActionsSupination.isSelected()
			    		  || rightLowerActionsExtension.isSelected() || rightLowerActionsPronation.isSelected()
			    		  || rightLowerExtremity.isSelected() || rightLowerKneeChck.isSelected()
			    		  || rightLowerFootChck.isSelected() || rightLowerHipChck.isSelected()
			    		  || rightLowerAnkleChck.isSelected() || rightLowerToesChck.isSelected()
			    		 
						){
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append(" Right lower extremity: ");
					msSkelInputController.str = str1.toString();
					
					}
				
				if (RightLEMuscleNormalRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("normal.");
					msSkelInputController.str = str1.toString();
					
				} if (RightLEMuscleModerateRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("moderately decreased.");
					msSkelInputController.str = str1.toString();
					
				} if (RightLEMuscleAbsentRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("absent");
					msSkelInputController.str = str1.toString();
					
				} if (RightLEMuscleSlightlyRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("slightly decreased");
					msSkelInputController.str = str1.toString();
					
				} if (RightLEMuscleMarkedlyRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("markedly decreased");
					msSkelInputController.str = str1.toString();
					
				}
				
				
				if (rightLowerActions.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("for all actions, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsFlexion.isSelected()) {
					 
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("flexion, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsAdductions.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("abduction, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsSupination.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("supination, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsExtension.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("extension, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerActionsPronation.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("pronation, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerExtremity.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("of the extremity, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerKneeChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("knee, ");
					msSkelInputController.str = str1.toString();
					  
				} if (rightLowerFootChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("foot, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerHipChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("hip, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerAnkleChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("ankle, ");
					msSkelInputController.str = str1.toString();
					
				} if (rightLowerToesChck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("toes, ");
					msSkelInputController.str = str1.toString();
					
				} 
				
			}
	      
	      
	      
	      
			 
	      
		++msSkelInputController.formCount;	
		msSkelInputController.setSkelUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	
		
	});

	
	skipBtn.setOnAction((event) -> {
		try {
			++msSkelInputController.formCount;	
			msSkelInputController.setSkelUI();
			new FXFormCommonUtilities().closeForm( skipBtn);
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
	}
	
}
