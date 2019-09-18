package com.ets.controller.gui.inventory.purchas;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.inventory.inventory.InventoryEntityController;
import com.ets.controller.entity.inventory.inventoryOutGo.InventoryOutGoEntityController;
import com.ets.controller.entity.inventory.inventoryPurchase.InventoryPurchaseEntityController;
import com.ets.controller.gui.inventory.inventory.InventoryViewController;
import com.ets.model.Clinician;
import com.ets.model.InventoryDescription;
import com.ets.model.InventoryOutGo;
import com.ets.model.InventoryPurchase;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InventoryPurchasInputController implements Initializable {
	

    @FXML
    private TextField inventoryNameText;

    @FXML
    private TextField priceText;

    @FXML
    private TextField quantityText;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private DatePicker dateField;

    @FXML
    private Button inventoryBtn;
    
    public void setInventory(Integer id){
    	
    	inventoryNameText.setText(Integer.toString(id));
    	
    }
    
    private InventoryPurchasViewController inventoryPurchasViewController;
    
    public void setInventoryPurchasViewController(InventoryPurchasViewController inventoryPurchasViewController) {
		this.inventoryPurchasViewController = inventoryPurchasViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();
    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		inventoryBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("InventoryView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryView", null, Locale.US);
				formPath.closeApplicationContext();
				InventoryViewController inventoryViewController =
				(InventoryViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				inventoryViewController.setPurchasInputController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		 okButton.setOnAction((event) -> {
				
				InventoryPurchase inventoryPurchase=new InventoryPurchase();
				
				if(inventoryNameText.getText().isEmpty()){
					
				}else{
					
					InventoryDescription inventoryDescription = new InventoryEntityController().getById(Integer.parseInt(inventoryNameText.getText()));
					inventoryPurchase.setInventory(inventoryDescription);
					
				}
				
				LocalDate localDate = dateField.getValue();
				if(localDate != null){
					
					Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
										
					inventoryPurchase.setLastPurchaseDate(date);
					
				}
				
				inventoryPurchase.setLastPuschaseQuantity(quantityText.getText());
				inventoryPurchase.setPricePerUnit(priceText.getText());
				
				
				new InventoryPurchaseEntityController().saveOrUpdate(inventoryPurchase);
				inventoryPurchasViewController.viewInventoryPurchase();
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
