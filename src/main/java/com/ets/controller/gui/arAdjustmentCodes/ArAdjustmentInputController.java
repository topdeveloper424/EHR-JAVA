package com.ets.controller.gui.arAdjustmentCodes;
import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

public class ArAdjustmentInputController implements Initializable{

    @FXML
    private TextField codeTextField;
    
    @FXML
    private TextField descriptionTextField;
    
    @FXML
    private TextField chargeCodeTextField;
    
    @FXML
    private TextField electronicRemaintanceAdjustmentCodeTextField;
    
    @FXML
    private CheckBox inactiveCheckBox;
    
    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		cancelButton.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});	
	}

}


