package com.ets.controller.gui.inventory.outGo;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.inventory.inventory.InventoryEntityController;
import com.ets.controller.entity.inventory.inventoryOutGo.InventoryOutGoEntityController;
import com.ets.model.InventoryDescription;
import com.ets.model.InventoryOutGo;
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

public class InventoryOutGoViewController implements Initializable {
	
	@FXML
    private AnchorPane basePane;

    @FXML
    private TextField searchTextBox;

    @FXML
    private Button addButton;

    @FXML
    private Button closeButton;

    @FXML
    private TableView<InventoryOutGo> outGoTable;

    @FXML
    private TableColumn<InventoryOutGo, String> inventoryCollumn;

    @FXML
    private TableColumn<InventoryOutGo, String> patientNameCollumn;

    @FXML
    private TableColumn<InventoryOutGo, String> clinicNameCollumn;

    @FXML
    private TableColumn<InventoryOutGo, String> quantityCollumn;

    @FXML
    private TableColumn<InventoryOutGo, String> dateCollumn;
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	    
	    private ObservableList<InventoryOutGo> inventoryOutGoMasterData = FXCollections.observableArrayList();
	    
       public void viewInventoryOutGo(){
	    	
	        inventoryOutGoMasterData = new  InventoryOutGoEntityController().view();
	    	
	    	 inventoryCollumn.setCellValueFactory(new PropertyValueFactory<InventoryOutGo, String>("inventory"));
	        patientNameCollumn.setCellValueFactory(new PropertyValueFactory<InventoryOutGo, String>("patient"));
	        clinicNameCollumn.setCellValueFactory(new PropertyValueFactory<InventoryOutGo, String>("clinic")); 
	     
	        quantityCollumn.setCellValueFactory(new PropertyValueFactory<InventoryOutGo, String>("quantityOut"));
	       dateCollumn.setCellValueFactory(new PropertyValueFactory<InventoryOutGo, String>("outGoDate"));
	       
	       outGoTable.setItems(inventoryOutGoMasterData);
	        
       }
	    
	   


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewInventoryOutGo();
		
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		addButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryOutGoInput", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryOutGoInput", null, Locale.US);
				formPath.closeApplicationContext();
				
				InventoryOutGoInputController inventoryOutGoInputController =
				(InventoryOutGoInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				inventoryOutGoInputController.setInventoryOutGoViewController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
