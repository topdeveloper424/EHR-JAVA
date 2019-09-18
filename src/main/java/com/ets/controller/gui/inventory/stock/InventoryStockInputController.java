package com.ets.controller.gui.inventory.stock;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.inventory.inventory.InventoryEntityController;
import com.ets.controller.entity.inventory.inventoryCurrentStock.InventoryCurrentStockEntityController;
import com.ets.controller.entity.inventory.inventoryOutGo.InventoryOutGoEntityController;
import com.ets.controller.gui.inventory.inventory.InventoryViewController;
import com.ets.model.InventoryCurrentStock;
import com.ets.model.InventoryDescription;
import com.ets.model.InventoryOutGo;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class InventoryStockInputController implements Initializable {
	
    @FXML
    private TextField inventoryNameText;

    @FXML
    private TextField quantityText;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button inventoryBtn;
    
    public void setInventory(Integer id){
    	
    	inventoryNameText.setText(Integer.toString(id));
    	
    }
    
    private InventoryStockViewController inventoryStockViewController;
        
    public void setInventoryStockViewController(InventoryStockViewController inventoryStockViewController) {
		this.inventoryStockViewController = inventoryStockViewController;
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
				inventoryViewController.setInventoryStockInputController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		 okButton.setOnAction((event) -> {
				
				InventoryCurrentStock inventoryCurrentStock=new InventoryCurrentStock();
				
				if(inventoryNameText.getText().isEmpty()){
					
				}else{
					
					InventoryDescription inventoryDescription = new InventoryEntityController().getById(Integer.parseInt(inventoryNameText.getText()));
					inventoryCurrentStock.setInventory(inventoryDescription);
					
				}

			
				inventoryCurrentStock.setQuantityInStock(quantityText.getText());
				
				new InventoryCurrentStockEntityController().saveOrUpdate(inventoryCurrentStock);
				inventoryStockViewController.viewInventoryCurrentStock();
			
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
