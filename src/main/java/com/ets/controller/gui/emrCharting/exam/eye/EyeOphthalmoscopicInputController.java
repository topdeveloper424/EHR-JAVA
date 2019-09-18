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
 *File Creation Date: 8-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EyeOphthalmoscopicInputController Class
 *Description: EyeOphthalmoscopic GUI Controller class
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
public class EyeOphthalmoscopicInputController implements Initializable{
	
		@FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox discsaNormalCkeckBox;

	    @FXML
	    private CheckBox discsaCkeckBox;

	    @FXML
	    private CheckBox discsLeftNormalCkeckBox;

	    @FXML
	    private CheckBox cateractsNoCkeckBox;

	    @FXML
	    private CheckBox cateractsLeftNormalCkeckBox;

	    @FXML
	    private CheckBox discsaRighttPallorCkeckBox;

	    @FXML
	    private CheckBox cateractsRightNormalCkeckBox;

	    @FXML
	    private CheckBox cateractsRightEyeCkeckBox;

	    @FXML
	    private CheckBox cateractsLeftEyeCkeckBox;

	    @FXML
	    private CheckBox vassclsShowAVCheck;

	    @FXML
	    private CheckBox vassclsAppearNormalCheck;

	    @FXML
	    private CheckBox vassclsShowSilverCheck;

	    @FXML
	    private CheckBox exudatesNohemorrhageOrNoExudateCheck;

	    @FXML
	    private CheckBox exudatesNohemorrhageCheck;

	    @FXML
	    private CheckBox exudatesLeftHemorrhageCheck;

	    @FXML
	    private CheckBox discsRightNormalCkeckBox;

	    @FXML
	    private CheckBox discsLeftPapilledemaCkeckBox;

	    @FXML
	    private CheckBox discsRightPapilledemaCkeckBox;

	    @FXML
	    private CheckBox discsaLeftPallorCkeckBox;

	    @FXML
	    private CheckBox exudatesHemorrhageCheck;

	    @FXML
	    private CheckBox exudatesNoExudateCheck;

	    @FXML
	    private CheckBox cateractsNormalCkeckBox;

	    @FXML
	    private CheckBox exudatesWithExudateCheck;

	    @FXML
	    private CheckBox exudatesRightExudateCheck;

	    @FXML
	    private CheckBox exudatesRightHemorrhageCheck;

	    @FXML
	    private CheckBox exudatesLeftExudateCheck;

	    @FXML
	    private CheckBox vassclsNormalCheck;

	    @FXML
	    private CheckBox exudatesNormalCheck;
	    
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
			
			
			
			if (discsaNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEyeInputController.str);
				str1.append("Funduscopic exam reveals normal discs and vessels,");
				examEyeInputController.str = str1.toString();
				
			}else{
				
				if (discsaCkeckBox.isSelected() || discsaLeftPallorCkeckBox.isSelected() || discsaRighttPallorCkeckBox.isSelected() 
						|| discsLeftNormalCkeckBox.isSelected() || discsLeftPapilledemaCkeckBox.isSelected() || discsRightNormalCkeckBox.isSelected()
						|| discsRightPapilledemaCkeckBox.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append("Funduscopic exam reveals ");
					examEyeInputController.str = str11.toString();
					
					 		
					if (discsaCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("normal discs, ");
						examEyeInputController.str = str1.toString();
						
					}if (discsaLeftPallorCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left pallor, ");
						examEyeInputController.str = str1.toString();
						
					}if (discsaRighttPallorCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right pallor, ");
						examEyeInputController.str = str1.toString();
						
					}if (discsLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left disc normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (discsLeftPapilledemaCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left papilledema, ");
						examEyeInputController.str = str1.toString();
						
					}if (discsRightNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right disc normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (discsRightPapilledemaCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right papilledema, ");
						examEyeInputController.str = str1.toString();
						
					}
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append(".");
					examEyeInputController.str = str12.toString();
					
				}
				
				
				
			}
			
			
			 			
			
			
			
			
			
			
			
			if(cateractsNormalCkeckBox.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("");
				examEyeInputController.str = str12.toString();
				
			}else{
				
				
				if (cateractsNoCkeckBox.isSelected() || cateractsLeftEyeCkeckBox.isSelected() || cateractsLeftNormalCkeckBox.isSelected()
						|| cateractsRightEyeCkeckBox.isSelected() || cateractsRightNormalCkeckBox.isSelected() ) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("with ");
					examEyeInputController.str = str12.toString();
					
					
					if (cateractsNoCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("no cataracts, ");
						examEyeInputController.str = str1.toString();
						
					}if (cateractsLeftEyeCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left eye cataract, ");
						examEyeInputController.str = str1.toString();
						
					}if (cateractsLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("left normal, ");
						examEyeInputController.str = str1.toString();
						
					}if (cateractsRightEyeCkeckBox.isSelected()) {
											
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right eye cataract, ");
						examEyeInputController.str = str1.toString();
						
					}if (cateractsRightNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("right normal, ");
						examEyeInputController.str = str1.toString();
						
					}
									
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append(".");
					examEyeInputController.str = str11.toString();
					
					
				}
				
			}
			
			
			
			
			
			
			
			if(vassclsNormalCheck.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examEyeInputController.str);
				str12.append("Vessels appear normal, ");
				examEyeInputController.str = str12.toString();
				
				  
			}else{
				
				if (vassclsAppearNormalCheck.isSelected() || vassclsShowAVCheck.isSelected() || vassclsShowSilverCheck.isSelected()	) {
					
					StringBuilder str12 = new StringBuilder(examEyeInputController.str);
					str12.append("Vessels ");
					examEyeInputController.str = str12.toString();
					
					
					if (vassclsAppearNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("appear normal, ");
						examEyeInputController.str = str1.toString();
												
					}if (vassclsShowAVCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("show AV nicking, ");
						examEyeInputController.str = str1.toString();
						
					}if (vassclsShowSilverCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("show silver-wire change ,");
						examEyeInputController.str = str1.toString();
					
					}
									
					StringBuilder str11 = new StringBuilder(examEyeInputController.str);
					str11.append(".");
					examEyeInputController.str = str11.toString();
				
			}
			
				
				
			}
			
			
				
				
				
				
				
				
				if(exudatesNormalCheck.isSelected()){
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append("no hemorrhages or exudates,");
					examEyeInputController.str = str1.toString();
					
					
				}else{
					
					if(exudatesHemorrhageCheck.isSelected() || exudatesLeftExudateCheck.isSelected() || exudatesLeftHemorrhageCheck.isSelected()
							|| exudatesNoExudateCheck.isSelected() || exudatesNohemorrhageCheck.isSelected() || exudatesNohemorrhageOrNoExudateCheck.isSelected()
							|| exudatesRightExudateCheck.isSelected() || exudatesRightHemorrhageCheck.isSelected() || exudatesWithExudateCheck.isSelected()){
					
					
						StringBuilder str11 = new StringBuilder(examEyeInputController.str);
						str11.append("and have ");
						examEyeInputController.str = str11.toString();
						
						
						if (exudatesHemorrhageCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("hemorrhages,");
						examEyeInputController.str = str1.toString();
											
					}if (exudatesLeftExudateCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("exudates left");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesLeftHemorrhageCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("hemorrhages left, ");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesNoExudateCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("no exudates, ");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesNohemorrhageCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("no hemorrhages, ");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesNohemorrhageOrNoExudateCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("have no hemorrhages or exudates,");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesRightExudateCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("exudates right, ");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesRightHemorrhageCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("hemorrhages right, ");
						examEyeInputController.str = str1.toString();
						
					}if (exudatesWithExudateCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEyeInputController.str);
						str1.append("with exudates, ");
						examEyeInputController.str = str1.toString();
						
					}
					
					StringBuilder str1 = new StringBuilder(examEyeInputController.str);
					str1.append(".");
					examEyeInputController.str = str1.toString();
					
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
