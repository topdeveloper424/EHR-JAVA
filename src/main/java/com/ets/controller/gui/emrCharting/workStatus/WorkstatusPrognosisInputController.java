package com.ets.controller.gui.emrCharting.workStatus;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class WorkstatusPrognosisInputController implements Initializable {
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private TextField resumeWorkText;

    @FXML
    private TextField releaseFromCareText;
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

  			if(resumeWorkText.getLength() >= 1){
  				
  				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
  				str1.append(" I anticipate resumption of regular work in" +resumeWorkText.getText()+"  days");
  				emrWorkStatusInputController.str = str1.toString();
  				
  			}
  			
               if(releaseFromCareText.getLength() >= 1){
  				
  				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
  				str1.append(" and release from care in "+releaseFromCareText.getText()+" days ");
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
