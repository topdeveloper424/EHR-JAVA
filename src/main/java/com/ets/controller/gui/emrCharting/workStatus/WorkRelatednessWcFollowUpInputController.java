package com.ets.controller.gui.emrCharting.workStatus;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class WorkRelatednessWcFollowUpInputController implements Initializable {


    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private RadioButton dcFromCareToday;

    @FXML
    private RadioButton NWRPttoSeePCP;
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

  			if(dcFromCareToday.isSelected()){
  				
  				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
  				str1.append("Discharge Status D/C from care today.");
  				emrWorkStatusInputController.str = str1.toString();
  				
  			}
  			
               if(NWRPttoSeePCP.isSelected()){
  				
  				StringBuilder str1 = new StringBuilder(emrWorkStatusInputController.str);
  				str1.append("Discharge Status NWR-Pt to see PCP.");
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
