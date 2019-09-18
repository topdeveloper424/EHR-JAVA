package com.ets.controller.gui.inventory.inventory;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.inventory.inventory.InventoryEntityController;
import com.ets.model.InventoryDescription;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InventoryInputController implements Initializable {
	
	@FXML
    private TextField typeText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField descripTionText;

    @FXML
    private TextField epcCodeText;

    @FXML
    private TextField unitDescriptionText;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;
    
    private InventoryViewController inventoryViewController;
        
	public void setInventoryViewController(InventoryViewController inventoryViewController) {
		this.inventoryViewController = inventoryViewController;
	}


	public void setNameText(TextField nameText) {
		this.nameText = nameText;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		okButton.setOnAction((event) -> {
			
			InventoryDescription inventoryDescription = new InventoryDescription();
			
			inventoryDescription.setDescrip(descripTionText.getText());
			inventoryDescription.setEpcCode(epcCodeText.getText());
			inventoryDescription.setName(nameText.getText());
			inventoryDescription.setType(typeText.getText());
			inventoryDescription.setUnitDescrp(unitDescriptionText.getText());
			
			new InventoryEntityController().saveOrUpdate(inventoryDescription);
			inventoryViewController.viewInventoryDescription();
			new FXFormCommonUtilities().closeForm(okButton);
			
		});
		
		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
