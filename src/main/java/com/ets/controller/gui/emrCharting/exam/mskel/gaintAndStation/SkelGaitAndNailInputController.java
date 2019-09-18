package com.ets.controller.gui.emrCharting.exam.mskel.gaintAndStation;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.exam.mskel.MSkelInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 10-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkelGaitAndNailInputController Class
 *Description: gaitAndStation GUI Controller class
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
public class SkelGaitAndNailInputController implements Initializable {


    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox gaitNormal;

    @FXML
    private CheckBox gaitLimping;

    @FXML
    private CheckBox gaitSpastic;

    @FXML
    private CheckBox gaitStaggering;

    @FXML
    private CheckBox gaitsteppage;

    @FXML
    private CheckBox gaitWithPoorHeel;

    @FXML
    private CheckBox gaitUnableWalk;

    @FXML
    private CheckBox gaitWithPoorWeight;

    @FXML
    private CheckBox gaitTender;

    @FXML
    private CheckBox stationNormal;

    @FXML
    private CheckBox stationboardBased;

    @FXML
    private CheckBox coordinationNormal;

    @FXML
    private CheckBox stationUndetermined;

    @FXML
    private CheckBox coordinationDecreasedOnFinger;

    @FXML
    private CheckBox coordinationDecreasedHeel;

    @FXML
    private CheckBox rombergNormal;

    @FXML
    private RadioButton rombergNotTestedRadio;

    @FXML
    private RadioButton rombergNegativeRadio;

    @FXML
    private RadioButton RombergPositiveRadio;
    
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
			
	      if (gaitNormal.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Patient was noted to be walking in a normal gait.  ");
				msSkelInputController.str = str1.toString();
				
			}else{
				
				if(gaitLimping.isSelected() || gaitStaggering.isSelected()
			    		  || gaitWithPoorHeel.isSelected() || gaitUnableWalk.isSelected() 
			    		  || gaitSpastic.isSelected()|| gaitsteppage.isSelected()
			    		  || gaitWithPoorWeight.isSelected()
			    		  ){
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("Patient's gait was noted to be ");
						msSkelInputController.str = str1.toString();
						
					}
				
				if (gaitLimping.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("limping, ");
					msSkelInputController.str = str1.toString();
					
				}   
		      if (gaitStaggering.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("staggering and lurching, ");
					msSkelInputController.str = str1.toString();
					
				} 
				
		      if (gaitUnableWalk.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("unable to walk w/o assistance. ");
					msSkelInputController.str = str1.toString();
					
				} 
		      if (gaitSpastic.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("spastic, ");
					msSkelInputController.str = str1.toString();
					
				} 
				
		      if (gaitsteppage.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("steppage, ");
					msSkelInputController.str = str1.toString();
					
				} 
		      if (gaitWithPoorWeight.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("with poor weight bearing, ");
					msSkelInputController.str = str1.toString();
					
				} 
		     
		      if (gaitWithPoorHeel.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("with poor heel strike, ");
					msSkelInputController.str = str1.toString();
					
				}
				
		      StringBuilder str11 = new StringBuilder(msSkelInputController.str);
				str11.append(".");
				msSkelInputController.str = str11.toString();
				
			}
	      
	       
	    
			
	      if (stationNormal.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Station is normal. ");
				msSkelInputController.str = str1.toString();
				
			} else{
				
				if( stationboardBased.isSelected()
			    		  || stationUndetermined.isSelected() 
			    		 ){
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("Station is ");
						msSkelInputController.str = str1.toString();
						
					}
			      if (stationboardBased.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("broad based  ");
						msSkelInputController.str = str1.toString();
						
					} 
			      if (stationUndetermined.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("undetermined. ");
						msSkelInputController.str = str1.toString();
						
					}  
				
			}
	      
	      if (coordinationNormal.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append("Coordination normal. ");
				msSkelInputController.str = str1.toString();
				
			}  else{
				
				 if( coordinationDecreasedOnFinger.isSelected()
			    		  || coordinationDecreasedHeel.isSelected() 
			    		 ){
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("Coordination is ");
						msSkelInputController.str = str1.toString();
						
					}
			      if (coordinationDecreasedOnFinger.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("decreased on finger to nose ");
						msSkelInputController.str = str1.toString();
						
					} 
			      if (coordinationDecreasedHeel.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(msSkelInputController.str);
						str1.append("decreased heel, knee, shin, ");
						msSkelInputController.str = str1.toString();
						
					} 
				
			}
	      
	      if (rombergNormal.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(msSkelInputController.str);
				str1.append(" Romberg negative. ");
				msSkelInputController.str = str1.toString();
				
			} else{
				
				if (rombergNotTestedRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("Romberg not tested. ");
					msSkelInputController.str = str1.toString();
					
				}  
		      if (RombergPositiveRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("Romberg positive. ");
					msSkelInputController.str = str1.toString();
					
				}  
		      if (rombergNegativeRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(msSkelInputController.str);
					str1.append("Romberg negative. ");
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

