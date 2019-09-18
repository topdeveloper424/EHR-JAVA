package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntComprehensiveMultiSystemInputController Class
 *Description: entEarComprehensiveMultiSystem.fxml Controller class
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

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class EntComprehensiveMultiSystemInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;

	@FXML
	private CheckBox canalLeftAllNormalCkeckBox;

	@FXML
	private CheckBox canalLeftNormalCkeckBox;

	@FXML
	private CheckBox canalLeftCerumenouslCkeckBox;

	@FXML
	private CheckBox canalLeftErythematousCkeckBox;

	@FXML
	private CheckBox canalLeftExudatesCkeckBox;

	@FXML
	private CheckBox tympanicNormalCheck;

	@FXML
	private CheckBox tympanicErythematousCheck;

	@FXML
	private CheckBox tympanicBulgingCheck;

	@FXML
	private CheckBox tympanicRetractedCheck;

	@FXML
	private CheckBox tympanicFluidCheck;

	@FXML
	private CheckBox tympanicPerforationCheck;

	@FXML
	private CheckBox tympanicForeignBodyCheck;

	@FXML
	private CheckBox tympanicPETubeCheck;

	@FXML
	private CheckBox tympanicBloodCheck;

	@FXML
	private CheckBox tympanicMucusCheck;

	@FXML
	private CheckBox tympanicRightNormalCheck;

	@FXML
	private CheckBox tympanicRightErythematousCheck;

	@FXML
	private CheckBox tympanicRightFluidCheck;

	@FXML
	private CheckBox tympanicRightPerforationCheck;

	@FXML
	private CheckBox tympanicRightBloodCheck;

	@FXML
	private CheckBox tympanicRightMucusCheck;

	@FXML
	private CheckBox tympanicRightForeignBodyCheck;

	@FXML
	private CheckBox tympanicRightPETubeCheck;

	@FXML
	private CheckBox hearLeftNormalCkeckBox;

	@FXML
	private CheckBox hearLeftWhisperedCkeckBox;

	@FXML
	private CheckBox hearLeftMldlyCkeckBox;

	@FXML
	private CheckBox hearLeftModeratelyCkeckBox;

	@FXML
	private CheckBox hearLeftSeverallyCkeckBox;

	@FXML
	private CheckBox hearRightNormalCkeckBox;

	@FXML
	private CheckBox hearRighttWhisperedCkeckBox;

	@FXML
	private CheckBox hearRightMldlyCkeckBox;

	@FXML
	private CheckBox hearRighttAbsentCkeckBox;

	@FXML
	private CheckBox hearRightSeverallyCkeckBox;

	@FXML
	private CheckBox externalLeftNormalCkeckBox;

	@FXML
	private CheckBox externalLeftTenderTractionCkeckBox;

	@FXML
	private CheckBox externalLeftCerumenousCkeckBox;

	@FXML
	private CheckBox externalLeftErythematouCkeckBox;

	@FXML
	private CheckBox externalRightNormalCkeckBox;

	@FXML
	private CheckBox canalLeftPETubeCkeckBox;

	@FXML
	private CheckBox canalLeftForeignBodyCkeckBox;

	@FXML
	private CheckBox hearRightAllNormalCkeckBox;

	@FXML
	private CheckBox canalLeftTenderTractionCkeckBox;

	@FXML
	private CheckBox canalLeftBloodCkeckBox;

	@FXML
	private CheckBox canalRightNormalCkeckBox;

	@FXML
	private CheckBox canalRightTenderTractionCkeckBox;

	@FXML
	private CheckBox canalRightErythematousCkeckBox;

	@FXML
	private CheckBox canalRightBloodCkeckBox;

	@FXML
	private CheckBox canalRightExudatesCkeckBox;

	@FXML
	private CheckBox canalRightForeignBodyCkeckBox;

	@FXML
	private CheckBox tympanicAllNormalCheck;

	@FXML
	private CheckBox tympanicRightBulgingCheck;

	@FXML
	private CheckBox tympanicRightRetractedCheck;

	@FXML
	private CheckBox hearLeftAbsentCkeckBox;

	@FXML
	private CheckBox hearLeftNotTestedCkeckBox;

	@FXML
	private CheckBox hearRightNotTestedCkeckBox;

	@FXML
	private CheckBox hearRightModeratelyCkeckBox;

	@FXML
	private CheckBox externalLeftAtrophicCkeckBox;

	@FXML
	private CheckBox externalRightErythematouCkeckBox;

	@FXML
	private CheckBox externalRightCerumenousCkeckBox;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox canalRightPETubeCkeckBox;

	@FXML
	private CheckBox canalRightCerumenouslCkeckBox;

	@FXML
	private CheckBox hearLeftAllNormalCkeckBox;

	@FXML
	private CheckBox externalLeftAllNormalCkeckBox;

	@FXML
	private CheckBox externalLeftPiercedCkeckBox;

	@FXML
	private CheckBox externalRightPiercedCkeckBox;

	@FXML
	private CheckBox noseNormalCkeckBox;

	@FXML
	private CheckBox noseMarkedCkeckBox;

	@FXML
	private CheckBox externalRightAtrophicCkeckBox;

	@FXML
	private CheckBox externalRightTenderTractionCkeckBox;

	@FXML
	private CheckBox noseRhonphymaCkeckBox;

	@FXML
	private CheckBox noseErythematouslCkeckBox;

	@FXML
	private CheckBox noseTenderTractionCkeckBox;

	@FXML
	private CheckBox noseAllNormalCkeckBox;

	private ExamEntInputController examEntInputController;

	public void setExamEntInputController(ExamEntInputController examEntInputController) {
		this.examEntInputController = examEntInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEntInputController.str);
			examComp.append("\n\nENT: ");
			examEntInputController.str = examComp.toString();
			
			if(canalLeftAllNormalCkeckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Ear canals normal.");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if(canalLeftBloodCkeckBox.isSelected() || canalLeftNormalCkeckBox.isSelected() || canalLeftCerumenouslCkeckBox.isSelected() 
						|| canalLeftErythematousCkeckBox.isSelected() || canalLeftExudatesCkeckBox.isSelected() || canalLeftTenderTractionCkeckBox.isSelected() 
						|| canalLeftForeignBodyCkeckBox.isSelected() || canalLeftPETubeCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Examination of external ear canals: ");
					examEntInputController.str = str11.toString();
					
					    
					
					if (canalLeftBloodCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("blood noted, ");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("left normal, ");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftCerumenouslCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("cerumenous, ");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftErythematousCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("erythematous, ");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftExudatesCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("with exudates, ");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftTenderTractionCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("tender on traction on tragus, ");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftForeignBodyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("foreign body noted, ");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftPETubeCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("PE tube noted, ");
						examEntInputController.str = str1.toString();
						
					}
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
					
				}
				
				
				
				
			}
			
			
			
			
			
			
			
			
			if (canalRightBloodCkeckBox.isSelected() || canalRightCerumenouslCkeckBox.isSelected() || canalRightErythematousCkeckBox.isSelected() 
					|| canalRightExudatesCkeckBox.isSelected() || canalRightForeignBodyCkeckBox.isSelected() || canalRightNormalCkeckBox.isSelected()
					|| canalRightPETubeCkeckBox.isSelected() || canalRightTenderTractionCkeckBox.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("Examination of external ear canals: ");
				examEntInputController.str = str11.toString();
				
				if (canalRightBloodCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("blood noted, ");
					examEntInputController.str = str1.toString();
					
				}if (canalRightCerumenouslCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("cerumenous, ");
					examEntInputController.str = str1.toString();
					
				}if (canalRightErythematousCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("erythematous, ");
					examEntInputController.str = str1.toString();
					
				}if (canalRightExudatesCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("with exudates, ");
					examEntInputController.str = str1.toString();
					
				}if (canalRightForeignBodyCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("foreign body noted, ");
					examEntInputController.str = str1.toString();
					
				}if (canalRightNormalCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("right normal, ");
					examEntInputController.str = str1.toString();
					
				}if (canalRightPETubeCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("PE tube noted. ");
					examEntInputController.str = str1.toString();
					
				}if (canalRightTenderTractionCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("tender on traction on tragus, ");
					examEntInputController.str = str1.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(examEntInputController.str);
				str12.append(".");
				examEntInputController.str = str12.toString();
				
				
			}
			
			
			
			
			
			
			if(tympanicAllNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Tympanic membranes normal. ");
				examEntInputController.str = str1.toString();
				
			}else{
				
				
				if (tympanicBloodCheck.isSelected() || tympanicBulgingCheck.isSelected() || tympanicErythematousCheck.isSelected() || tympanicRetractedCheck.isSelected()
						|| tympanicFluidCheck.isSelected() || tympanicForeignBodyCheck.isSelected() || tympanicMucusCheck.isSelected()
						|| tympanicNormalCheck.isSelected() || tympanicPerforationCheck.isSelected() || tympanicPETubeCheck.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Tympanic membranes: ");
					examEntInputController.str = str11.toString();
					
					
					
					if (tympanicBloodCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("obscured by blood, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicBulgingCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("bulging, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicErythematousCheck.isSelected()) {
								
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("erythematous, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicRetractedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("retracted, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicFluidCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("fluid noted, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicForeignBodyCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("obscured by foreign body, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicMucusCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("obscured by mucus, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("left normal, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicPerforationCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("perforation noted, ");
						examEntInputController.str = str1.toString();
						
					}if (tympanicPETubeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("PE tube noted, ");
						examEntInputController.str = str1.toString();
						
					}
					
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
				}
				
			}
			
			
			
			
			
			
			
			if (tympanicRightBloodCheck.isSelected() || tympanicRightBulgingCheck.isSelected() || tympanicRightErythematousCheck.isSelected() || tympanicRightFluidCheck.isSelected()
					|| tympanicRightForeignBodyCheck.isSelected() || tympanicRightMucusCheck.isSelected() || tympanicRightNormalCheck.isSelected()
					|| tympanicRightPerforationCheck.isSelected() || tympanicRightPETubeCheck.isSelected() || tympanicRightRetractedCheck.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("Tympanic membranes ");
				examEntInputController.str = str11.toString();
				
				
				
				if (tympanicRightBloodCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("obscured by blood, ");
					examEntInputController.str = str1.toString();
									
				}if (tympanicRightBulgingCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("bulging, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightErythematousCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("erythematous, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightFluidCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("fluid noted, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightForeignBodyCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("obscured by foreign body, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightMucusCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("obscured by mucus, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("right normal, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightPerforationCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("perforation noted, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightPETubeCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("PE tube noted, ");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightRetractedCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("retracted, ");
					examEntInputController.str = str1.toString();
					
				}
				
				
				
				StringBuilder str12 = new StringBuilder(examEntInputController.str);
				str12.append(".");
				examEntInputController.str = str12.toString();
				
			}
			
			
			
			
			
			
			if (hearLeftAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Hearing in the left ear is normal; ");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (hearLeftAbsentCkeckBox.isSelected() || hearLeftMldlyCkeckBox.isSelected() || hearLeftModeratelyCkeckBox.isSelected() || hearLeftNormalCkeckBox.isSelected() 
						|| hearLeftNotTestedCkeckBox.isSelected() || hearLeftSeverallyCkeckBox.isSelected() || hearLeftWhisperedCkeckBox.isSelected() ) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("");
					examEntInputController.str = str11.toString();
					
					
					if (hearLeftAbsentCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftMldlyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftModeratelyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftNotTestedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftSeverallyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearLeftWhisperedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the left ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}
					
					
				}
				
				
				
			}
			
			
			
			
			
			
			
			
			if (hearRightAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("Hearing in the right ear is normal; ");
				examEntInputController.str = str11.toString();
				
			}else{
				
				if (hearRightMldlyCkeckBox.isSelected() || hearRightModeratelyCkeckBox.isSelected() || hearRightNormalCkeckBox.isSelected() || hearRightNotTestedCkeckBox.isSelected() 
						|| hearRightSeverallyCkeckBox.isSelected() || hearRighttAbsentCkeckBox.isSelected() || hearRighttWhisperedCkeckBox.isSelected() ) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("");
					examEntInputController.str = str11.toString();
					
					
					if (hearRightMldlyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightModeratelyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightNotTestedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRightSeverallyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRighttAbsentCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}if (hearRighttWhisperedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("Hearing in the right ear is moderately decreased ; ");
						examEntInputController.str = str1.toString();
						
					}
					
					
				}
				
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			if (externalLeftAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("External ears appear normal. ");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (externalLeftAtrophicCkeckBox.isSelected() || externalLeftCerumenousCkeckBox.isSelected() || externalLeftErythematouCkeckBox.isSelected() 
						|| externalLeftNormalCkeckBox.isSelected() || externalLeftPiercedCkeckBox.isSelected() || externalLeftTenderTractionCkeckBox.isSelected()) {
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append("External ears: ");
					examEntInputController.str = str12.toString();
					
					if (externalLeftAtrophicCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("atrophic cartilage, ");
						examEntInputController.str = str1.toString();
								
					}if (externalLeftCerumenousCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("cerumenous, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftErythematouCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("erythematous, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("left ear normal, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftPiercedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("pierced lobes, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftTenderTractionCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("tender on traction on tragus, ");
						examEntInputController.str = str1.toString();
						
					}
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append(".");
					examEntInputController.str = str11.toString();
					
				}
				
				
			}
			
			
			
			
			
			if (externalRightAtrophicCkeckBox.isSelected() || externalRightCerumenousCkeckBox.isSelected() || externalRightErythematouCkeckBox.isSelected()
					|| externalRightNormalCkeckBox.isSelected() || externalRightPiercedCkeckBox.isSelected() || externalRightTenderTractionCkeckBox.isSelected()) {
				
				StringBuilder str12 = new StringBuilder(examEntInputController.str);
				str12.append("External ears: ");
				examEntInputController.str = str12.toString();
				
				
				if (externalRightAtrophicCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("atrophic cartilage, ");
					examEntInputController.str = str1.toString();
					
				}if (externalRightCerumenousCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("cerumenous, ");
					examEntInputController.str = str1.toString();
					
				}if (externalRightErythematouCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("erythematous, ");
					examEntInputController.str = str1.toString();
					
				}if (externalRightNormalCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("right ear normal, ");
					examEntInputController.str = str1.toString();
					
				}if (externalRightPiercedCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("pierced lobes, ");
					examEntInputController.str = str1.toString();
					
				}if (externalRightTenderTractionCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("tender on traction on tragus, ");
					examEntInputController.str = str1.toString();
					
				}
				
								
				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append(".");
				examEntInputController.str = str11.toString();
				
				
			}
			
			
			
			
			if (noseAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append(" Nose normal.");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (noseErythematouslCkeckBox.isSelected() || noseMarkedCkeckBox.isSelected() || noseNormalCkeckBox.isSelected()
						|| noseRhonphymaCkeckBox.isSelected() || noseTenderTractionCkeckBox.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Nose: ");
					examEntInputController.str = str11.toString();
					 
					
					if (noseErythematouslCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("erythematous, ");
						examEntInputController.str = str1.toString();
						
					}if (noseMarkedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("marked septal deviation, ");
						examEntInputController.str = str1.toString();
						
					}if (noseNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("normal, ");
						examEntInputController.str = str1.toString();
						
					}if (noseRhonphymaCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("rhonphyma noted, ");
						examEntInputController.str = str1.toString();
						
					}if (noseTenderTractionCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("depressed bridge of nose, ");
						examEntInputController.str = str1.toString();
						
					}
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
					
					
				}
				
			}
			
			
			
			
			++examEntInputController.formCount;	
			examEntInputController.setEntUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examEntInputController.formCount;	
				examEntInputController.setEntUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
