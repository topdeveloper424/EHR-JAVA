package com.ets.controller.gui.inventory.inventory;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.inventory.inventory.InventoryEntityController;
import com.ets.controller.gui.inventory.purchas.InventoryPurchasInputController;
import com.ets.controller.gui.inventory.stock.InventoryStockInputController;
import com.ets.model.BodyZone;
import com.ets.model.Clinician;
import com.ets.model.InventoryDescription;
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

public class InventoryViewController implements Initializable {
	
	  @FXML
	    private AnchorPane basePane;

	    @FXML
	    private TextField searchTextBox;

	    @FXML
	    private Button addButton;

	    @FXML
	    private Button closeButton;
	    
	    @FXML
	    private Button selectButton;

	    @FXML
	    private TableView<InventoryDescription> inventoryTable;

	    @FXML
	    private TableColumn<InventoryDescription, String> typeCollumn;

	    @FXML
	    private TableColumn<InventoryDescription, String> nameCollumn;

	    @FXML
	    private TableColumn<InventoryDescription, String> descriptionCollumn;

	    @FXML
	    private TableColumn<InventoryDescription, String> epcCodeCollumn;

	    @FXML
	    private TableColumn<InventoryDescription, String> unitDescriptionCollumn;
	    
	    private InventoryViewController inventoryViewController;
	      
	    private InventoryPurchasInputController purchasInputController;
	    	    
	    public void setPurchasInputController(InventoryPurchasInputController purchasInputController) {
			this.purchasInputController = purchasInputController;
		}
	    
	    private InventoryStockInputController inventoryStockInputController;
	    
		public void setInventoryStockInputController(InventoryStockInputController inventoryStockInputController) {
			this.inventoryStockInputController = inventoryStockInputController;
		}

		private ObservableList<InventoryDescription> inventoryDescriptionMasterData = FXCollections.observableArrayList();
	    
	    public void viewInventoryDescription(){
	    	
	    	inventoryDescriptionMasterData = new InventoryEntityController().view();
	    	
	    	/*codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
			descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().descripProperty());
			divisionCollumn.setCellValueFactory(cellData -> cellData.getValue().getDivision().codeProperty());
	    	*/
	    	 
	    	typeCollumn.setCellValueFactory(new PropertyValueFactory<InventoryDescription, String>("type"));
	    	nameCollumn.setCellValueFactory(new PropertyValueFactory<InventoryDescription, String>("name"));
	    	descriptionCollumn.setCellValueFactory(new PropertyValueFactory<InventoryDescription, String>("descrip"));
	    	epcCodeCollumn.setCellValueFactory(new PropertyValueFactory<InventoryDescription, String>("epcCode"));
	    	unitDescriptionCollumn.setCellValueFactory(new PropertyValueFactory<InventoryDescription, String>("unitDescrp"));
	    	
	    	inventoryTable.setItems(inventoryDescriptionMasterData);
	    	
	    }
	    
	    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewInventoryDescription();
		
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		selectButton.setOnAction((event) -> {
			
			InventoryDescription inventoryDescription = inventoryTable.getSelectionModel().getSelectedItem();
			
			if(purchasInputController != null){
				
				/*clinicianSelectController.setClinicianName(selectClinician.getSuffix() +" "+ selectClinician.getFirstName() +" "+ selectClinician.getMiddleName() +" "+ selectClinician.getLastName());
				clinicianSelectController.setClinicianType(selectClinician.getType());
				clinicianSelectController.setClinicianId(selectClinician.getId());*/
				
				purchasInputController.setInventory(inventoryDescription.getId());
				
			}else if(inventoryStockInputController != null){
				
				inventoryStockInputController.setInventory(inventoryDescription.getId());
				
			}
			
				new FXFormCommonUtilities().closeForm(selectButton);
			
		});
		
		addButton.setOnAction((event) -> {
			try {
				

				String formName = formPath.context.getMessage("InventoryInput", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.InventoryInput", null, Locale.US);
				formPath.closeApplicationContext();
				
				InventoryInputController inventoryInputController = 
				(InventoryInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				inventoryInputController.setInventoryViewController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
