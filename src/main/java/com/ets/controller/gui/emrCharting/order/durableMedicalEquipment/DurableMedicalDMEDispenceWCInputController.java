package com.ets.controller.gui.emrCharting.order.durableMedicalEquipment;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class DurableMedicalDMEDispenceWCInputController implements Initializable{
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox ankleAirgelCkeckBox;

    @FXML
    private CheckBox ankleElasticCkeckBox;

    @FXML
    private CheckBox ankleSprintCkeckBox;

    @FXML
    private CheckBox ankleAlluminiumCkeckBox;

    @FXML
    private CheckBox anklefigureCkeckBox;

    @FXML
    private CheckBox ankleTuliCkeckBox;

    @FXML
    private CheckBox ankleArchCkeckBox;

    @FXML
    private CheckBox anklePneumaticCkeckBox;

    @FXML
    private CheckBox ankleLegStripBraceCkeckBox;

    @FXML
    private CheckBox ankleLegTibCkeckBox;

    @FXML
    private CheckBox ankleLegPanel3CkeckBox;

    @FXML
    private CheckBox ankleLegSpacerCkeckBox;

    @FXML
    private CheckBox ankleLegACECkeckBox;

    @FXML
    private CheckBox ankleLegSportKneeCkeckBox;

    @FXML
    private CheckBox ankleLegSplintCkeckBox;

    @FXML
    private CheckBox ankleLegElasticCkeckBox;

    @FXML
    private CheckBox shoulderCSpineCheckBox;

    @FXML
    private CheckBox miscTheraPutty;

    @FXML
    private CheckBox miscSwissBall;

    @FXML
    private CheckBox miscTheraBand;

    @FXML
    private CheckBox miscFlexBar;

    @FXML
    private CheckBox miscTheraCane;

    @FXML
    private CheckBox miscDuraband;

    @FXML
    private CheckBox ankleCaneCheck;

    @FXML
    private CheckBox ankleAceCheck;

    @FXML
    private CheckBox ankleMedShoeCheck;

    @FXML
    private CheckBox backTorsoDoublePull;

    @FXML
    private CheckBox backTorsoDeluxRib;

    @FXML
    private CheckBox backTorsoHalfMoon;

    @FXML
    private CheckBox backTorsoBackTrack;

    @FXML
    private CheckBox backTorsoRingCushion;

    @FXML
    private CheckBox neckCervicalCollarFoam;

    @FXML
    private CheckBox neckCervicalCollar;

    @FXML
    private CheckBox neckCSpine;

    @FXML
    private CheckBox forearmAducted;

    @FXML
    private CheckBox forearmAlluminium;

    @FXML
    private CheckBox forearmGutterSplint;

    @FXML
    private CheckBox forearmIMaxPil;

    @FXML
    private CheckBox forearmImaxSmart;

    @FXML
    private CheckBox forearmProflex;

    @FXML
    private CheckBox forearmPowerWeb;

    @FXML
    private CheckBox forearmSoftWrist;

    @FXML
    private CheckBox forearmThumbOPrene;

    @FXML
    private CheckBox forearmACEBandage;

    @FXML
    private CheckBox forearmWristOprene;

    @FXML
    private CheckBox forearmUpperExt;

    @FXML
    private CheckBox shoulderElastic;

    @FXML
    private CheckBox shoulderIMAX;

    @FXML
    private CheckBox shoulderImmobilizer;

    @FXML
    private CheckBox shoulderTenisElbow;

    @FXML
    private CheckBox shoulderSling;

    @FXML
    private CheckBox shoulderPully;

    @FXML
    private CheckBox miscFoamRoller;

    @FXML
    private CheckBox miscHot;

    @FXML
    private CheckBox miscPowerWeb;

    @FXML
    private CheckBox miscDigiflex;

    @FXML
    private CheckBox miscThgeraBall;

    @FXML
    private CheckBox miscStretchRope;

	
	private OrderDurableMedicalEquipmentInputController orderDurableMedicalEquipmentInputController;

	public void setOrderDurableMedicalEquipmentInputController(
			OrderDurableMedicalEquipmentInputController orderDurableMedicalEquipmentInputController) {
		this.orderDurableMedicalEquipmentInputController = orderDurableMedicalEquipmentInputController;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
	

		doneBtn.setOnAction((event) -> {

			StringBuilder durableReferalStr = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			durableReferalStr.append("\n\n ");
			orderDurableMedicalEquipmentInputController.str = durableReferalStr.toString();

			
			if(ankleAceCheck.isSelected() || ankleAirgelCkeckBox.isSelected()
					|| ankleAlluminiumCkeckBox.isSelected() || ankleArchCkeckBox.isSelected()
					|| ankleCaneCheck.isSelected() || ankleElasticCkeckBox.isSelected()
					|| anklefigureCkeckBox.isSelected() || ankleMedShoeCheck.isSelected()
					|| anklePneumaticCkeckBox.isSelected() || ankleSprintCkeckBox.isSelected()
					|| ankleTuliCkeckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was given the following DME and instructed on use: ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(ankleAceCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" ACE bandage,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleAirgelCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" Airgel,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(ankleAlluminiumCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" aluminum crutches (pair),");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleArchCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" arch support,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleCaneCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" cane,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleElasticCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" elastic ankle support,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(anklefigureCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" figure 8 stabilizing ankle support,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(ankleMedShoeCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" med/surg shoe,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(anklePneumaticCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" pneumatic walking boot,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleSprintCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(ankleTuliCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" Tuli's heel cup,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(".");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			
			}
			
			
			
			
			
			
			if(ankleLegACECkeckBox.isSelected() || ankleLegElasticCkeckBox.isSelected()
					|| ankleLegPanel3CkeckBox.isSelected() || ankleLegSpacerCkeckBox.isSelected()
					|| ankleLegSplintCkeckBox.isSelected() || ankleLegSportKneeCkeckBox.isSelected()
					|| ankleLegStripBraceCkeckBox.isSelected() || ankleLegTibCkeckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was given the following DME and instructed on use: ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(ankleLegACECkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" ACE bandage,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleLegElasticCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("elastic knee sleeve (closed),");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(ankleLegPanel3CkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("3 panel knee immobilizer, ");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleLegSpacerCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("spacer,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleLegSplintCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("splint, ");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(ankleLegSportKneeCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("sport knee sleeve (open),");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(ankleLegStripBraceCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("ankle stirrup brace,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(ankleLegTibCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" tib/fib padded splint,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				
				
				
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(".");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			
			}
			
			
			
			
			
			if(backTorsoBackTrack.isSelected() || backTorsoDeluxRib.isSelected()
					|| backTorsoDoublePull.isSelected() 
					|| backTorsoHalfMoon.isSelected() || backTorsoRingCushion.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append("Patient was given the following DME and instructed on use: ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(backTorsoBackTrack.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("back track LSO post rigid panel pre,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(backTorsoDeluxRib.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("deluxe rib belt (female),");
					
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(backTorsoDoublePull.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("double pull sacrolumbar support,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(backTorsoHalfMoon.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append(" half moon lumbar pillow, ");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(backTorsoRingCushion.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("ring cushion (doughnut),");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			
			}
			
			
			if(neckCervicalCollar.isSelected() || neckCervicalCollarFoam.isSelected()
					|| neckCSpine.isSelected()){
				
				StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str1.append(" Patient was given the following DME and instructed on use: ");
				orderDurableMedicalEquipmentInputController.str = str1.toString();
				
				if(neckCervicalCollar.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("clavicle collar , ");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
				
				if(neckCervicalCollarFoam.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("cervical collar foam (2 piece) ,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}if(neckCSpine.isSelected()){
					
					StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
					str11.append("C-spine / T-spine pillow,");
					orderDurableMedicalEquipmentInputController.str = str11.toString();
					
				}
		
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(".");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			
			}
	
		
		if(forearmACEBandage.isSelected() || forearmAducted.isSelected()
				|| forearmAlluminium.isSelected() || forearmGutterSplint.isSelected()
				|| forearmIMaxPil.isSelected() || forearmImaxSmart.isSelected()
				|| forearmPowerWeb.isSelected() || forearmProflex.isSelected()
				|| forearmSoftWrist.isSelected() || forearmThumbOPrene.isSelected()
				|| forearmUpperExt.isSelected() || forearmWristOprene.isSelected()){
			
			StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			str1.append("Patient was given the following DME and instructed on use: ");
			orderDurableMedicalEquipmentInputController.str = str1.toString();
			
			if(forearmACEBandage.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("ACE bandage,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(forearmAducted.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("abducted thumb,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(forearmAlluminium.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" aluminum splint,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(forearmGutterSplint.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" gutter splint,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(forearmIMaxPil.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" IMAK Pil-O splint,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(forearmImaxSmart.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("  IMAK Smart Glove w/thumb,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(forearmPowerWeb.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" Power-Web Hand Exerciser,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(forearmProflex.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" Proflex 4020 Wrist Brace,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(forearmSoftWrist.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" soft wrist sleeve,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(forearmThumbOPrene.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("  Thumb-o-Prene,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(forearmUpperExt.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" upper ext fx orthosis wrist Collies ,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(forearmWristOprene.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("Wrist-o-Prene,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			str11.append(".");
			orderDurableMedicalEquipmentInputController.str = str11.toString();
			
		
		}
	
		if(shoulderCSpineCheckBox.isSelected() || shoulderElastic.isSelected()
				|| shoulderIMAX.isSelected() || shoulderImmobilizer.isSelected()
				|| shoulderPully.isSelected() 
				|| shoulderSling.isSelected() || shoulderTenisElbow.isSelected()){
			
			StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			str1.append(" Patient was given the following DME and instructed on use: ");
			orderDurableMedicalEquipmentInputController.str = str1.toString();
			
			if(shoulderCSpineCheckBox.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" C-spine / T-spine pillow,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(shoulderElastic.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" elastic elbow sleeve,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(shoulderIMAX.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("MAK adjustable elbow brace,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(shoulderImmobilizer.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("shoulder immobilizer (universal),");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(shoulderPully.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("shoulder pulley - ESP,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(shoulderSling.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" shoulder sling (universal),");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(shoulderTenisElbow.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" tennis elbow brace,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			
			
			StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			str11.append("");
			orderDurableMedicalEquipmentInputController.str = str11.toString();
			
		
		}

		if(miscDigiflex.isSelected() || miscDuraband.isSelected()
				|| miscFlexBar.isSelected() || miscFoamRoller.isSelected()
				|| miscHot.isSelected() || miscPowerWeb.isSelected()
				|| miscStretchRope.isSelected() || miscSwissBall.isSelected()
				|| miscTheraBand.isSelected() || miscTheraCane.isSelected()
				|| miscTheraPutty.isSelected() || miscThgeraBall.isSelected()){
			
			StringBuilder str1 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			str1.append("Patient provided the following: ");
			orderDurableMedicalEquipmentInputController.str = str1.toString();
			
			if(miscDigiflex.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" digiflex,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(miscDuraband.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("Duraband,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(miscFlexBar.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" Flex-bar,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(miscFoamRoller.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" foam roller,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(miscHot.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" hot/cold pack,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(miscPowerWeb.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("Power-web,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(miscStretchRope.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("stretch rope,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(miscSwissBall.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" Swissball,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(miscTheraBand.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append("Thera-Band,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			if(miscTheraCane.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" Thera-Cane,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(miscTheraPutty.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" Thera-Putty,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}if(miscThgeraBall.isSelected()){
				
				StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
				str11.append(" Thera-Ball,");
				orderDurableMedicalEquipmentInputController.str = str11.toString();
				
			}
			
			
			
			StringBuilder str11 = new StringBuilder(orderDurableMedicalEquipmentInputController.str);
			str11.append(" and instructed in their use.");
			orderDurableMedicalEquipmentInputController.str = str11.toString();
			
		
		}
		++orderDurableMedicalEquipmentInputController.formCount;
			orderDurableMedicalEquipmentInputController.setDurableMedicalEquipmentModelUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			

		});
		
		
		skipBtn.setOnAction((event) -> {
			try {
				

				++orderDurableMedicalEquipmentInputController.formCount;
				orderDurableMedicalEquipmentInputController.setDurableMedicalEquipmentModelUI();
				new FXFormCommonUtilities().closeForm(skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
