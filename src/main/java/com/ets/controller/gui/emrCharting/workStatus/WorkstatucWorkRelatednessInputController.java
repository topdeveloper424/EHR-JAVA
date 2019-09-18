package com.ets.controller.gui.emrCharting.workStatus;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class WorkstatucWorkRelatednessInputController implements Initializable {
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton notWorkRelatedRadio;

    @FXML
    private ToggleGroup select;

    @FXML
    private RadioButton undeterminedRadio;

    @FXML
    private RadioButton ashaRecordableRadio;

    @FXML
    private RadioButton firstAidRadio;

    @FXML
    private RadioButton workRelatedRadio;

    @FXML
    private ToggleGroup work;
    private EMRWorkStatusInputController emrWorkStatusInputController;

  	public void setEmrWorkStatusInputController(EMRWorkStatusInputController emrWorkStatusInputController) {
  		this.emrWorkStatusInputController = emrWorkStatusInputController;
  	}


  	@Override
  	public void initialize(URL location, ResourceBundle resources) {

  		doneBtn.setOnAction((event) -> {

  			StringBuilder Str1 = new StringBuilder(emrWorkStatusInputController.str);
  			Str1.append("\n\n ");
  			emrWorkStatusInputController.str = Str1.toString();

  			if(notWorkRelatedRadio.isSelected()){
  				
  				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
  				str1.append("Based on the information I have reviewed, I consider this problem to be Not Work-Related (Non-AOE/COE) ."
  						+ "\nDisclaimer:\n"
  						+ "I declare under penalty of perjury that the information contained in this report and its attachments, if any, is true and correct to the best of my knowledge and belief, except as to information that I have indicated I have received from others.  As to that information, I declare under penalty of perjury that the information accurately describes the information provided to me and, except as noted herein, that I believe it to be true."
  						+ "I have not violated Labor Code Section 139.3 and the contents of the report and bill are true and correct to the best of my knowledge.  This statement is made under penalty of perjury.");
  				emrWorkStatusInputController.str = str1.toString();
  				
  			}
  			
               if(undeterminedRadio.isSelected()){
  				
  				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
  				str1.append("Based on the information I have reviewed, I consider this problem to be Undetermined at this Time ."
  						+ "\nDisclaimer:\n"
  						+ "I declare under penalty of perjury that the information contained in this report and its attachments, if any, is true and correct to the best of my knowledge and belief, except as to information that I have indicated I have received from others.  As to that information, I declare under penalty of perjury that the information accurately describes the information provided to me and, except as noted herein, that I believe it to be true."
  						+ "I have not violated Labor Code Section 139.3 and the contents of the report and bill are true and correct to the best of my knowledge.  This statement is made under penalty of perjury.");
  				emrWorkStatusInputController.str = str1.toString();
  				
  			}
               if(ashaRecordableRadio.isSelected()){
   				
   				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
   				str1.append("Based on the information I have reviewed, I consider this problem to be OSHA Recordable/Work-Related ."
   						+ "\nDisclaimer:\n"
   						+ "I declare under penalty of perjury that the information contained in this report and its attachments, if any, is true and correct to the best of my knowledge and belief, except as to information that I have indicated I have received from others.  As to that information, I declare under penalty of perjury that the information accurately describes the information provided to me and, except as noted herein, that I believe it to be true."
   						+ "I have not violated Labor Code Section 139.3 and the contents of the report and bill are true and correct to the best of my knowledge.  This statement is made under penalty of perjury.");
   				emrWorkStatusInputController.str = str1.toString();
   				
   			}
               if(firstAidRadio.isSelected()){
    				
    				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
    				str1.append("Based on the information I have reviewed, I consider this problem to be First-Aid Only ."
    						+ "\nDisclaimer:\nI declare under penalty of perjury that the information contained in this report and its attachments, if any, is true and correct to the best of my knowledge and belief, except as to information that I have indicated I have received from others.  As to that information, I declare under penalty of perjury that the information accurately describes the information provided to me and, except as noted herein, that I believe it to be true."
    						+ "\nI have not violated Labor Code Section 139.3 and the contents of the report and bill are true and correct to the best of my knowledge.  This statement is made under penalty of perjury.");
    				emrWorkStatusInputController.str = str1.toString();
    				
    			}
               if(workRelatedRadio.isSelected()){
     				
     				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
     				str1.append("Based on the information I have reviewed, I consider this problem to be Work Related ."
     						+ "\nDisclaimer:\n"
     						+ "I declare under penalty of perjury that the information contained in this report and its attachments, if any, is true and correct to the best of my knowledge and belief, except as to information that I have indicated I have received from others.  As to that information, I declare under penalty of perjury that the information accurately describes the information provided to me and, except as noted herein, that I believe it to be true."
     						+ "I have not violated Labor Code Section 139.3 and the contents of the report and bill are true and correct to the best of my knowledge.  This statement is made under penalty of perjury.");
     				emrWorkStatusInputController.str = str1.toString();
     				
     			}
  			++emrWorkStatusInputController.formCount;
  			emrWorkStatusInputController.setWorkStatusUI();
  			new FXFormCommonUtilities().closeForm(doneBtn);
  			

  		});
  		
  		
  		skipBtn.setOnAction((event) -> {
  			try {
  				

  				++emrWorkStatusInputController.formCount;
  				emrWorkStatusInputController.setWorkStatusUI();
  				new FXFormCommonUtilities().closeForm(skipBtn);

  			} catch (Exception ex) {
  				ex.printStackTrace();
  			}
  		});
  		
  		
  	}

  }
