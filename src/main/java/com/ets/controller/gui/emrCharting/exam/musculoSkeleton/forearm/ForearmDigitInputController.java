package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.forearm;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ForearmDigitInputController Class
 *Description: ForearmDigits.fxml Controller class
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class ForearmDigitInputController implements Initializable {
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox abnormalitiesAbrasions;

    @FXML
    private CheckBox abnormalitiesContusions;

    @FXML
    private CheckBox abnormalitiesScarring;

    @FXML
    private CheckBox abnormalitiesDeformity;

    @FXML
    private CheckBox abnormalitiesEcchymosis;

    @FXML
    private CheckBox abnormalitiesLacerations;

    @FXML
    private CheckBox abnormalitiesSwelling;

    @FXML
    private RadioButton whichHandLeft;

    @FXML
    private RadioButton whichHandRight;
    
    @FXML
    private ToggleGroup hand;

    @FXML
    private CheckBox abnormalitiesNormal;

    @FXML
    private CheckBox fingerNormal;

    @FXML
    private CheckBox StrengthNormal;

    @FXML
    private CheckBox strengthNormal;

    @FXML
    private CheckBox strengthNormalExcept;

    @FXML
    private CheckBox strength4th;

    @FXML
    private CheckBox strength1st;
    
    @FXML
    private CheckBox strength2nd;

    @FXML
    private CheckBox strength3rd;

    @FXML
    private CheckBox strengthDecreasedExtension;

    @FXML
    private CheckBox provocativeNormal;

    @FXML
    private CheckBox sensationaDecreased;

    @FXML
    private CheckBox sensationaRadialSurface;

    @FXML
    private CheckBox sensationaFlexor;

    @FXML
    private CheckBox LocationNormal;

    @FXML
    private CheckBox Location1st;

    @FXML
    private CheckBox Location2nd;

    @FXML
    private CheckBox Location5th;

    @FXML
    private CheckBox Location4th;

    @FXML
    private CheckBox Location3rd;

    @FXML
    private CheckBox fingerNotNoted;

    @FXML
    private CheckBox finger2nd;

    @FXML
    private CheckBox finger5th;

    @FXML
    private CheckBox finger4th;

    @FXML
    private CheckBox finger3rd;

    @FXML
    private CheckBox finger1stDigit;

    @FXML
    private CheckBox fingerMcp;

    @FXML
    private CheckBox fingerPIP;

    @FXML
    private CheckBox fingerDip;

    @FXML
    private CheckBox strengthFingerFlexion;

    @FXML
    private CheckBox strength5th;

    @FXML
    private CheckBox sensationa2nd;

    @FXML
    private CheckBox sensationa5th;

    @FXML
    private CheckBox sensationaUlnar;

    @FXML
    private CheckBox sensationa3rd;

    @FXML
    private CheckBox sensationaExtensor;

    @FXML
    private CheckBox sensationa1st;

    @FXML
    private CheckBox sensationa4th;
    
    private ExamMusculotoneForearmInputController examMusculotoneForearmInputController;

   	public void setExamMusculotoneForearmInputController(
   			ExamMusculotoneForearmInputController examMusculotoneForearmInputController) {
   		this.examMusculotoneForearmInputController = examMusculotoneForearmInputController;
   	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneForearmInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneForearmInputController.str = examComp.toString();

			if (whichHandLeft.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Exam of the fingers of the left hand ");
				examMusculotoneForearmInputController.str = str1.toString();

			}

			if (whichHandRight.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
				str1.append("Exam of the fingers of the right hand ");
				examMusculotoneForearmInputController.str = str1.toString();

			}

			
			
			

		
			
			if (abnormalitiesNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("reveals abrasions, contusions, lacerations, ecchymosis, deformity, swelling and scarring. ");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {

				if (abnormalitiesAbrasions.isSelected() || abnormalitiesContusions.isSelected() || abnormalitiesDeformity.isSelected()
						|| abnormalitiesEcchymosis.isSelected() || abnormalitiesLacerations.isSelected() || abnormalitiesScarring.isSelected()
						|| abnormalitiesSwelling.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append("reveals ");
					examMusculotoneForearmInputController.str = str11.toString();

					
					if (abnormalitiesAbrasions.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("abrasions, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (abnormalitiesContusions.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("contusions, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (abnormalitiesDeformity.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("deformity, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (abnormalitiesEcchymosis.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("ecchymosis, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (abnormalitiesLacerations.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("lacerations, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (abnormalitiesScarring.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("scarring, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (abnormalitiesSwelling.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("swelling ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();

				}

			}
			
			
			
			
			
			
			
			if (LocationNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {
				
				if(Location1st.isSelected() || Location2nd.isSelected() || Location3rd.isSelected()
						|| Location4th.isSelected() || Location5th.isSelected()){
					
					
					
					if (Location1st.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("1st digit (thumb), ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (Location2nd.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("2nd digit (Index), ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (Location3rd.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("3rd digit (Middle), ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (Location4th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("4th digit (Ring) ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (Location5th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("5th digit (Little) ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();
					
				}

				

			}
			
			
			
			
			
			
			if (fingerNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append(" No finger tenderness noted. ");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {
				
				if(finger1stDigit.isSelected() || finger2nd.isSelected() || finger3rd.isSelected()
						|| finger4th.isSelected() || finger5th.isSelected() 
						|| fingerDip.isSelected() || fingerMcp.isSelected()
						|| fingerNotNoted.isSelected() || fingerPIP.isSelected()){
					
					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append("Finger tenderness ");
					examMusculotoneForearmInputController.str = str11.toString();
					
					
					if (finger1stDigit.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("1st digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (finger2nd.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("2nd digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (finger3rd.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("3rd digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (finger4th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("4th digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (finger5th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("5th digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (fingerDip.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("DIP, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (fingerMcp.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("MCP, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (fingerNotNoted.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("not noted, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (fingerPIP.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("PIP, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();
					
				}

				

			}
			
			
			
			
			if (StrengthNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("Finger strength is normal. ");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {
				
				if(strength1st.isSelected() || strength3rd.isSelected() || strength4th.isSelected()
						|| strength5th.isSelected() || strengthDecreasedExtension.isSelected() 
						|| strengthFingerFlexion.isSelected() || strengthNormalExcept.isSelected()
						|| strengthNormal.isSelected() || strength2nd.isSelected()){
					
					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append("Strength is ");
					examMusculotoneForearmInputController.str = str11.toString();
					
					  
					if (strength1st.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("1st digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
				if (strength2nd.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append("2nd digit, ");
					examMusculotoneForearmInputController.str = str1.toString();

				}if (strength3rd.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("3rd digit,");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (strength4th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("4th digit");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (strength5th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("5th digit ,");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (strengthDecreasedExtension.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased finger extension, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (strengthFingerFlexion.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased finger flexion, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (strengthNormalExcept.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("normal except, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (strengthNormal.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("normal, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					
					
					
				}

				

			}
			
			
			
			
			
			if (provocativeNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
				str11.append("sensation is intact. ");
				examMusculotoneForearmInputController.str = str11.toString();

			} else {
				
				if(sensationa1st.isSelected() || sensationa2nd.isSelected() || sensationa3rd.isSelected()
						|| sensationa4th.isSelected() || sensationa5th.isSelected() 
						|| sensationaDecreased.isSelected() || sensationaExtensor.isSelected() || sensationaFlexor.isSelected()
						|| sensationaRadialSurface.isSelected() || sensationaUlnar.isSelected()){
					
					StringBuilder str11 = new StringBuilder(examMusculotoneForearmInputController.str);
					str11.append("sensation ");
					examMusculotoneForearmInputController.str = str11.toString();
					
					
					if (sensationa1st.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("1st digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (sensationa2nd.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("2nd digit, ");
						examMusculotoneForearmInputController.str = str1.toString();
						
					}if (sensationa3rd.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("3rd digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (sensationa4th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("4th digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationa5th.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("5th digit, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationaDecreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("decreased, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationaExtensor.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("extensor surface, ");
						examMusculotoneForearmInputController.str = str1.toString();
						
					}if (sensationaFlexor.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("flexor surface, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					if (sensationaRadialSurface.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("radial surface, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}if (sensationaUlnar.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
						str1.append("ulnar surface, ");
						examMusculotoneForearmInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examMusculotoneForearmInputController.str);
					str1.append(".");
					examMusculotoneForearmInputController.str = str1.toString();
					
				}

				

			}
			

			

			++examMusculotoneForearmInputController.formCount;
			examMusculotoneForearmInputController.setForearmUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneForearmInputController.formCount;
				examMusculotoneForearmInputController.setForearmUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		
	}

}
