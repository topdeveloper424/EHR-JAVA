package com.ets.controller.gui.emrCharting.exam.eye;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 8-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EyeSlitLampTestingInputController Class
 *Description: EyeSlitLampTesting GUI Controller class
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
public class EyeSlitLampTestingInputController implements Initializable{
	
	  @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox corneaNormalCkeckBox;

	    @FXML
	    private CheckBox corneaCkeckBox;

	    @FXML
	    private CheckBox corneaProteinCkeckBox;

	    @FXML
	    private CheckBox corneaWhiteBloodCkeckBox;

	    @FXML
	    private CheckBox lensPoseriorCheck;

	    @FXML
	    private CheckBox lensCortexCheck;

	    @FXML
	    private CheckBox lensNucleusCheck;

	    @FXML
	    private CheckBox lensNormalCheck;

	    @FXML
	    private CheckBox lensLeftEyeCheck;

	    @FXML
	    private CheckBox lensRightEyeCheck;

	    @FXML
	    private CheckBox fluorescenceOSPossitiveCheck;

	    @FXML
	    private CheckBox fluorescenceOSNegativeCheck;

	    @FXML
	    private CheckBox fluorescenceODPossitiveCheck;

	    @FXML
	    private CheckBox fluorescenceODNegativeCheck;

	    @FXML
	    private CheckBox locationConjunctiveOutsideCheck;

	    @FXML
	    private CheckBox locationConjunctiveInsideCheck;

	    @FXML
	    private CheckBox locationCorneaInsideCheck;

	    @FXML
	    private CheckBox locationCorneaOutsideCheck;

	    @FXML
	    private CheckBox locationUpperCheck;

	    @FXML
	    private CheckBox locationLowerCheck;

	    @FXML
	    private CheckBox foreignBodyVisibleCheck;

	    @FXML
	    private CheckBox corneaHyphemaCkeckBox;

	    @FXML
	    private CheckBox corneaHypopyonCkeckBox;

	    @FXML
	    private CheckBox anteriorNormalCheck;

	    @FXML
	    private CheckBox anteriorShallowCheck;

	    @FXML
	    private CheckBox lensDecreasedCheck;

	    @FXML
	    private CheckBox noForeignBodyVisibleCheck;

	    @FXML
	    private CheckBox lensAnteriorCheck;

	    @FXML
	    private CheckBox locationAnteriorCheck;

	    @FXML
	    private TextField foreignBodyOSText;

	    @FXML
	    private TextField foreignBodyODText;

	    @FXML
	    private RadioButton negativeRadio;

	    @FXML
	    private ToggleGroup fb;

	    @FXML
	    private RadioButton possitiveRadio;
    
    
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
			
						
			
			if (corneaNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Slit lamp examination revealed normal corneas, anterior chamber depth normal, and lenses normal bilaterally.");
				examEyeInputController.str = str1.toString();
				
			}else{
				
				if (corneaCkeckBox.isSelected() || corneaHyphemaCkeckBox.isSelected() 
						|| corneaWhiteBloodCkeckBox.isSelected() || corneaProteinCkeckBox.isSelected() 
						 || corneaHypopyonCkeckBox.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Slit lamp examination revealed corneas:  ");
					examEyeInputController.str = str11.toString();
					
						
					if (corneaCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("");
						examEyeInputController.str = str1.toString();
						
					}if (corneaHyphemaCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append(" possible hyphema, ");
						examEyeInputController.str = str1.toString();
						
					}if (corneaHypopyonCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("possible hypopyon , ");
						examEyeInputController.str = str1.toString();
						
					}if (corneaWhiteBloodCkeckBox.isSelected()) {
										
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("white blood cells, ");
						examEyeInputController.str = str1.toString();
						
					}if (corneaProteinCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("presence of protein, ");
						examEyeInputController.str = str1.toString();
						
					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();
					
				}
				
				
				
			}
			
			
			
			
			if (anteriorNormalCheck.isSelected() || anteriorShallowCheck.isSelected()) {
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("anterior chamber depth: ");
				examEyeInputController.str = str12.toString();
				
				
				if (anteriorNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(" normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (anteriorShallowCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("shallow, ");
					examEyeInputController.str = str1.toString();
					
				}
								
				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append(".");
				examEyeInputController.str = str11.toString();
				
				
			}
			
			
			
			
			if (lensAnteriorCheck.isSelected() || lensCortexCheck.isSelected() || lensDecreasedCheck.isSelected()
					|| lensLeftEyeCheck.isSelected() || lensNormalCheck.isSelected() || lensNucleusCheck.isSelected()
					|| lensPoseriorCheck.isSelected() || lensRightEyeCheck.isSelected() ) {
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append(" And ");
				examEyeInputController.str = str12.toString();
				
				
				if (lensAnteriorCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("anterior capsule: irregular, ");
					examEyeInputController.str = str1.toString();
					   				
				}if (lensCortexCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("cortex: abnormal, ");
					examEyeInputController.str = str1.toString();
					  	
				}if (lensDecreasedCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("clarity: decreased, ");
					examEyeInputController.str = str1.toString();
					
				}if (lensLeftEyeCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("left eye, ");
					examEyeInputController.str = str1.toString();
					
				}if (lensNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("lenses clarity: normal, ");
					examEyeInputController.str = str1.toString();
					
				}if (lensNucleusCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("nucleus: abnormal, ");
					examEyeInputController.str = str1.toString();
					
				}if (lensPoseriorCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("posterior capsule: irregular, ");
					examEyeInputController.str = str1.toString();
					
				}if (lensRightEyeCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("right eye, ");
					examEyeInputController.str = str1.toString();
					
				}
				
								
				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append(".");
				examEyeInputController.str = str11.toString();
				
				
			}
			
			
			
			
			
			
				
				
				if (fluorescenceODNegativeCheck.isSelected() || fluorescenceODPossitiveCheck.isSelected() 
						|| fluorescenceOSNegativeCheck.isSelected() || fluorescenceOSPossitiveCheck.isSelected() ) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("Fluorescence stain reveals ");
					examEyeInputController.str = str12.toString();
					
					 				
					if (fluorescenceODNegativeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OD negative uptake, ");
						examEyeInputController.str = str1.toString();
							
					}if (fluorescenceODPossitiveCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OD positive uptake, ");
						examEyeInputController.str = str1.toString();
							
					}if (fluorescenceOSNegativeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OS negative uptake, ");
						examEyeInputController.str = str1.toString();
						
					}if (fluorescenceOSPossitiveCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("OS positive uptake, ");
						examEyeInputController.str = str1.toString();
						
					}
					
									
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append(".");
					examEyeInputController.str = str11.toString();
					
					
				}
				
			
			
			
			
			
			
			
					
			
			
			if (locationAnteriorCheck.isSelected() || locationConjunctiveInsideCheck.isSelected() || locationCorneaOutsideCheck.isSelected()
					|| locationConjunctiveOutsideCheck.isSelected() || locationCorneaInsideCheck.isSelected() 
					|| locationLowerCheck.isSelected() || locationUpperCheck.isSelected()) {
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Fluorescence uptake located in");
				examEyeInputController.str = str12.toString();
				
				
				if (locationAnteriorCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("anterior chamber, ");
					examEyeInputController.str = str1.toString();
					 		
				}if (locationConjunctiveInsideCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("conjunctivae, inside VF, ");
					examEyeInputController.str = str1.toString();
					 		
				}if (locationConjunctiveOutsideCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("conjunctivae, outside VF.");
					examEyeInputController.str = str1.toString();
					
				}if (locationCorneaOutsideCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("cornea, outside VF, ");
					examEyeInputController.str = str1.toString();
					
				}if (locationCorneaInsideCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("cornea, inside VF, ");
					examEyeInputController.str = str1.toString();
					
				}if (locationLowerCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("lower palpebral conj. (lid), ");
					examEyeInputController.str = str1.toString();
					
				}if (locationUpperCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("upper palpebral conj. (lid), ");
					examEyeInputController.str = str1.toString();
					
				}
								
				StringBuilder str11 = new StringBuilder(examEyeInputController.str);
				str11.append(".");
				examEyeInputController.str = str11.toString();
				
				
			}
			
			
			
			  
				
				
				if (foreignBodyVisibleCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("foreign body visible. ");
					examEyeInputController.str = str1.toString();
					
				}if (noForeignBodyVisibleCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("no foreign body visible.");
					examEyeInputController.str = str1.toString();
					
				}
				
				
			
			
			
			
				
			
			if (foreignBodyOSText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("OS at "+foreignBodyOSText.getText()+" o'clock position.");
				examEyeInputController.str = str1.toString();
				
			}
			
			
			if (foreignBodyODText.getText().length() > 0) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("OD at "+foreignBodyODText.getText()+" o'clock position.");
				examEyeInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if (negativeRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("FB is in field of vision: negative");
				examEyeInputController.str = str1.toString();
				
			}if (possitiveRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("FB is in field of vision: positive.");
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
