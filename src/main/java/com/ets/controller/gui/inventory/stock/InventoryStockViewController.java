package com.ets.controller.gui.inventory.stock;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.inventory.inventoryCurrentStock.InventoryCurrentStockEntityController;
import com.ets.controller.entity.inventory.inventoryPurchase.InventoryPurchaseEntityController;
import com.ets.model.InventoryCurrentStock;
import com.ets.model.InventoryPurchase;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;

public class InventoryStockViewController implements Initializable {
	
	 @FXML
	    private AnchorPane basePane;

	    @FXML
	    private TextField searchTextBox;

	    @FXML
	    private Button addButton;

	    @FXML
	    private Button closeButton;

	    @FXML
	    private TableView<InventoryCurrentStock> stockTable;

	    @FXML
	    private TableColumn<InventoryCurrentStock, String> inventoryNameCollumn;

	    @FXML
	    private TableColumn<InventoryCurrentStock, String> quantityInStockCollumn;
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	    
	    private ObservableList<InventoryCurrentStock> inventoryCurrentStockMasterData = FXCollections.observableArrayList();
	    
	    public void viewInventoryCurrentStock(){
		    	
	    	inventoryCurrentStockMasterData = new  InventoryCurrentStockEntityController().view();
		    	
	    	inventoryNameCollumn.setCellValueFactory(new PropertyValueFactory<InventoryCurrentStock, String>("inventory"));
	    	quantityInStockCollumn.setCellValueFactory(new PropertyValueFactory<InventoryCurrentStock, String>("quantityInStock"));
	    	//stockTable.setCellValueFactory(new PropertyValueFactory<InventoryCurrentStock, String>("lastPuschaseQuantity")); 
		     
	    	stockTable.setItems(inventoryCurrentStockMasterData);
		       
		        
	    }
		

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewInventoryCurrentStock();
		
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		addButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryStockInput", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryStockInput", null, Locale.US);
				formPath.closeApplicationContext();
				
				InventoryStockInputController inventoryStockInputController = 
				(InventoryStockInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				inventoryStockInputController.setInventoryStockViewController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
