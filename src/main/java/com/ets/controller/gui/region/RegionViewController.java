package com.ets.controller.gui.region;


import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.region.RegionEntityController;
import com.ets.controller.gui.Laboratories.LaboratoryInputController;
import com.ets.controller.gui.carriers.CarrierInputController;
import com.ets.controller.gui.mcoTpaBillPreview.McoTpaBillInputController;
import com.ets.model.Division;
import com.ets.model.Region;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RegionViewController Class
 *Description: View.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */


public class RegionViewController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;
	
	  @FXML
	    private TextField searchTextField;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;
	
	   @FXML
	    private Button selectButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button buttomButton;

	@FXML
	private TableView<Region> regionTable;

	@FXML
	private TableColumn<Region, String> codeCollumn;

	@FXML
	private TableColumn<Region, String> nameCollumn;
	   @FXML
	    void enterKeyPressedForAddButton(KeyEvent event) {
		   if(event.getCode() == KeyCode.ENTER){
			   try {
					// Load Region Details Entry form .

					String formName = formPath.context.getMessage("AddRegion", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddRegion", null, Locale.US);
					formPath.closeApplicationContext();
					RegionInputController regionInputController = (RegionInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					regionInputController.setRegionViewController(this);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
	    }
	   }
	    @FXML
	    void enterKeyPressedForChangeButton(KeyEvent event) {
           
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 try {
	 				// Load Region Details Edit form .

	 				Region region = regionTable.getSelectionModel().getSelectedItem();

	 				String formName = formPath.context.getMessage("EditRegion", null, Locale.US);
	 				String formTitle = formPath.context.getMessage("Title.EditRegion", null, Locale.US);

	 				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
	 				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
	 				formPath.closeApplicationContext();

	 				if (region != null) {

	 					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
	 					Parent root1 = (Parent) fxmlLoader.load();
	 					Stage stage = new Stage();
	 					stage.initModality(Modality.APPLICATION_MODAL);
	 					stage.setTitle(formTitle);
	 					stage.setScene(new Scene(root1));
	 					RegionEditController editController = fxmlLoader.getController();
	 					editController.setRegion(region);
	 					editController.setRegionViewController(this);
	 					stage.show();

	 				} else {
	 					Alert alert = new Alert(AlertType.INFORMATION);
	 					alert.setTitle(infoDialogBoxTitle);
	 					alert.setHeaderText(null);
	 					alert.setContentText(editInfo);
	 					alert.showAndWait();
	 				}

	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			}
	    	 }
	    }

	    @FXML
	    void enterKeyPressedForCloseButton(KeyEvent event) {
            
             if(event.getCode() == KeyCode.ENTER){
            	 try {
     				new FXFormCommonUtilities().closeForm(closeButton);
     			} catch (Exception ex) {
     				ex.printStackTrace();
     			} 
	    	 }
	    }

	    @FXML
	    void enterKeyPressedForDeleteButton(KeyEvent event) {
            if(event.getCode() == KeyCode.ENTER){
            	try {
    				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
    				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
    				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
    				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

    				formPath.closeApplicationContext();

    				Integer reg = regionTable.getSelectionModel().getSelectedIndex();
    				if (reg > -1) {
    					Alert alert = new Alert(AlertType.CONFIRMATION);
    					alert.setTitle(conformDialogBoxTitle);
    					alert.setHeaderText(conformDelete);
    					alert.setContentText(null);

    					Optional<ButtonType> result = alert.showAndWait();
    					if (result.get() == ButtonType.OK) {
    						Region region = new RegionEntityController().viewRegion().get(reg);
    						new RegionEntityController().removeRegion(region.getId());
    						populateRegionTable(new RegionEntityController().viewRegion());

    					} else {

    					}

    				} else {

    					Alert alert = new Alert(AlertType.INFORMATION);
    					alert.setTitle(infoDialogBoxTitle);
    					alert.setHeaderText(null);
    					alert.setContentText(deleteInfo);
    					alert.showAndWait();
    				}

    			} catch (Exception ex) {
    				ex.printStackTrace();
    			}
	    	 }
	    }

	    @FXML
	    void enterKeyPressedForSelectButton(KeyEvent event) {
             if(event.getCode() == KeyCode.ENTER){
            	 Region selectedRegion = this.regionTable.getSelectionModel().getSelectedItem();
     			
     			if( carrierInputController != null ){
     				carrierInputController.setRegion(selectedRegion.getCode());
     			}else if (mcoTpaBillInputController != null ) {
     				
     				mcoTpaBillInputController.setRegion(selectedRegion.getCode());
     				
     			}else if (laboratoryInputController != null) {
     				
     				laboratoryInputController.setRegion(selectedRegion.getCode());
     				
     			}
     			 
	    	 }
	    }
	
	private CarrierInputController carrierInputController;
	

	public void setCarrierInputController(CarrierInputController carrierInputController) {
		this.carrierInputController = carrierInputController;
	}
	
	private McoTpaBillInputController mcoTpaBillInputController;
	

	public void setMcoTpaBillInputController(McoTpaBillInputController mcoTpaBillInputController) {
		this.mcoTpaBillInputController = mcoTpaBillInputController;
	}
	
private LaboratoryInputController laboratoryInputController;
	

	public void setLaboratoryInputController(LaboratoryInputController laboratoryInputController) {
		this.laboratoryInputController = laboratoryInputController;
	}

	public void refreshRegion() {

		codeCollumn.setCellValueFactory(new PropertyValueFactory<Region, String>("code"));
		nameCollumn.setCellValueFactory(new PropertyValueFactory<Region, String>("name"));

	}

	public void populateRegionTable(ObservableList<Region> regionTableList) {
		
FilteredList<Region> filteredData = new FilteredList<Region>(regionTableList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(region -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (region.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(region -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return region.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<Region> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(regionTable.comparatorProperty());
				
		regionTable.setItems(sortedData);
		
		//regionTable.setItems(regionTableList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Division Details Edit form .
				Region region = regionTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditRegion", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditRegion", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				RegionEditController editController = fxmlLoader.getController();
				editController.setRegion(region);
				editController.setRegionViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshRegion();

		addButton.setOnAction((event) -> {
			try {
				// Load Region Details Entry form .

				String formName = formPath.context.getMessage("AddRegion", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddRegion", null, Locale.US);
				formPath.closeApplicationContext();
				RegionInputController regionInputController = (RegionInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				regionInputController.setRegionViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Region Details Edit form .

				Region region = regionTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditRegion", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditRegion", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (region != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					RegionEditController editController = fxmlLoader.getController();
					editController.setRegion(region);
					editController.setRegionViewController(this);
					stage.show();

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		deleteButton.setOnAction((event) -> {
			// Delete Region Details
			try {
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer reg = regionTable.getSelectionModel().getSelectedIndex();
				if (reg > -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						Region region = new RegionEntityController().viewRegion().get(reg);
						new RegionEntityController().removeRegion(region.getId());
						populateRegionTable(new RegionEntityController().viewRegion());

					} else {

					}

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(deleteInfo);
					alert.showAndWait();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		selectButton.setOnAction((event) -> {
			Region selectedRegion = this.regionTable.getSelectionModel().getSelectedItem();
			
			if( carrierInputController != null ){
				carrierInputController.setRegion(selectedRegion.getCode());
			}else if (mcoTpaBillInputController != null ) {
				
				mcoTpaBillInputController.setRegion(selectedRegion.getCode());
				
			}else if (laboratoryInputController != null) {
				
				laboratoryInputController.setRegion(selectedRegion.getCode());
				
			}
			
			
			
				new FXFormCommonUtilities().closeForm(selectButton);
			
		});

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(regionTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = regionTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(regionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = regionTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(regionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = regionTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(regionTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
*/
		// Centralised Form cancel
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
