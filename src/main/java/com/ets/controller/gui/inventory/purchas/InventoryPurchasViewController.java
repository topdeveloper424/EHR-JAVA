package com.ets.controller.gui.inventory.purchas;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.inventory.inventoryOutGo.InventoryOutGoEntityController;
import com.ets.controller.entity.inventory.inventoryPurchase.InventoryPurchaseEntityController;
import com.ets.controller.gui.inventory.inventory.InventoryViewController;
import com.ets.model.InventoryDescription;
import com.ets.model.InventoryOutGo;
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

public class InventoryPurchasViewController implements Initializable {
	
    @FXML
    private AnchorPane basePane;

    @FXML
    private TextField searchTextBox;

    @FXML
    private Button addButton;

    @FXML
    private Button closeButton;

   

    @FXML
    private TableView<InventoryPurchase> purchasTable;

    @FXML
    private TableColumn<InventoryPurchase, String> name;

    @FXML
    private TableColumn<InventoryPurchase, String> price;

    @FXML
    private TableColumn<InventoryPurchase, String> dateCollumn;

    @FXML
    private TableColumn<InventoryPurchase, String> quantityCollumn;

    
	private ObservableList<InventoryPurchase> inventoryPurchaseMasterData = FXCollections.observableArrayList();
    
    public void viewInventoryPurchase(){
	    	
    	inventoryPurchaseMasterData = new  InventoryPurchaseEntityController().view();
	    	
    	price.setCellValueFactory(new PropertyValueFactory<InventoryPurchase, String>("pricePerUnit"));
    	name.setCellValueFactory(new PropertyValueFactory<InventoryPurchase, String>("inventory"));
    	//quantityCollumn.setCellValueFactory(new PropertyValueFactory<InventoryPurchase, String>("lastPuschaseQuantity")); 
	     
    	//dateCollumn.setCellValueFactory(new PropertyValueFactory<InventoryPurchase, String>("lastPurchaseDate"));
    	//name.setCellValueFactory(new PropertyValueFactory<InventoryDescription, String>("type"));
    	quantityCollumn.setCellValueFactory(new PropertyValueFactory<InventoryPurchase, String>("lastPuschaseQuantity"));
    	purchasTable.setItems(inventoryPurchaseMasterData);
	       
	        
    }
    FXMLFormPath formPath = new FXMLFormPath();  

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewInventoryPurchase();
		
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		addButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryPurchaseInput", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryPurchaseInput", null, Locale.US);
				formPath.closeApplicationContext();
				InventoryPurchasInputController inventoryPurchasInputController =
				(InventoryPurchasInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				inventoryPurchasInputController.setInventoryPurchasViewController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
