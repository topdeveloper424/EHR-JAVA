package com.ets.controller.gui.visionTesting;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.equipmentModel.EquipmentModelViewController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class VisionTestEquipmentInputController implements Initializable {
	

    @FXML
    private Button equipmentModelBtn;

	    
	    @FXML
	    private Button cancelBtn;

	    @FXML
	    private TextField locationDescText;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private TextField equipmentModelText;

	    @FXML
	    private CheckBox inactiveCheckBox;

	    @FXML
	    private TextField serialNumberText;

	    @FXML
	    private TextField equipmentText;
	    
	    FXMLFormPath formPath = new FXMLFormPath();

	    
	    public void setEquipmentModel(String modelNo){
			
			equipmentModelText.setText(modelNo);
	    }
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			
			
			
			equipmentModelBtn.setOnAction((event) -> {
				try {

					String formName = formPath.context.getMessage("ViewEquipmentModel", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ViewEquipmentModel", null, Locale.US);
					formPath.closeApplicationContext();
					EquipmentModelViewController equipmentViewController =
							(EquipmentModelViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
							equipmentViewController.setVisionTestEquipmentInputController(this);


				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
						
			cancelBtn.setOnAction((event) -> {
				try {
					//cancel centralized form
					new FXFormCommonUtilities().closeForm( cancelBtn);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
		}

}
