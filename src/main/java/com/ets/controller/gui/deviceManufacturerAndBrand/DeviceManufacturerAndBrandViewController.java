package com.ets.controller.gui.deviceManufacturerAndBrand;



import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.deviceManufacturerAndBrand.DeviceManufacturerAndBrandEntityontroller;
import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.model.InjuryCode;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeviceManufacturerAndBrandViewController Class
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

public class DeviceManufacturerAndBrandViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

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
	private TableView<DeviceManufacturerAndBrand> manufacturerBrandTable;

	@FXML
	private TableColumn<DeviceManufacturerAndBrand, String> brandCollumn;

	@FXML
	private TableColumn<DeviceManufacturerAndBrand, String> manufacturerCollumn;	
	
	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		try {
			// Load Shrap Device Manufacturer And Brand Details Entry form .

			String formName = formPath.context.getMessage("AddManufacturerAndBrand", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddManufacturerAndBrand", null, Locale.US);
			formPath.closeApplicationContext();
			DeviceManufacturerAndBrandInputController deviceManufacturerAndBrandInputController = (DeviceManufacturerAndBrandInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			deviceManufacturerAndBrandInputController.setDeviceManufacturerAndBrandViewController(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		try {
			// Load rootCause Details Update form .

			DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = manufacturerBrandTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditManufacturerAndBrand", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditManufacturerAndBrand", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			if (sharpDeviceManufacAndBrand != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				DeviceManufacturerAndBrandEditController controller = fxmlLoader.getController();
				controller.setSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand);
				controller.setDeviceManufacturerAndBrandEditController(this);
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

	@FXML
	void enterKeyPressedForCloseButton(KeyEvent event) {
		try {
			new FXFormCommonUtilities().closeForm(closeButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForDeleteButton(KeyEvent event) {
		// Delete SharpDeviceManufacAndBrand Details
		try {
			String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
			String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			Integer sharpdevicemanufacture = manufacturerBrandTable.getSelectionModel().getSelectedIndex();

			if (sharpdevicemanufacture > -1) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = new DeviceManufacturerAndBrandEntityontroller().viewSharpDeviceManufacturerAndBrand().get(sharpdevicemanufacture);
					new DeviceManufacturerAndBrandEntityontroller().removeSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand.getId());
					populateDeviceManufacturerAndBrandTable(new DeviceManufacturerAndBrandEntityontroller().viewSharpDeviceManufacturerAndBrand());
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

	public void refreshManufacturerAndBrand() {

		manufacturerCollumn.setCellValueFactory(new PropertyValueFactory<DeviceManufacturerAndBrand, String>("mfd"));
		brandCollumn.setCellValueFactory(new PropertyValueFactory<DeviceManufacturerAndBrand, String>("brand"));

	}

	public void populateDeviceManufacturerAndBrandTable(
			ObservableList<DeviceManufacturerAndBrand> deviceManufacturerAndBrandList) {
		
		
FilteredList<DeviceManufacturerAndBrand> filteredData = new FilteredList<DeviceManufacturerAndBrand>(deviceManufacturerAndBrandList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(deviceManufacturerAndBrand -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (deviceManufacturerAndBrand.getBrand().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(deviceManufacturerAndBrand -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return deviceManufacturerAndBrand.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<DeviceManufacturerAndBrand> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(manufacturerBrandTable.comparatorProperty());
				
		manufacturerBrandTable.setItems(sortedData);
		
		//manufacturerBrandTable.setItems(deviceManufacturerAndBrandList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load DeviceManufacturerAndBrand Details Update form .

				DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = manufacturerBrandTable.getSelectionModel()
						.getSelectedItem();

				String formName = formPath.context.getMessage("EditManufacturerAndBrand", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditManufacturerAndBrand", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				DeviceManufacturerAndBrandEditController controller = fxmlLoader.getController();
				controller.setSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand);
				controller.setDeviceManufacturerAndBrandEditController(this);
				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshManufacturerAndBrand();

		addButton.setOnAction((event) -> {
			try {
				// Load Shrap Device Manufacturer And Brand Details Entry form .

				String formName = formPath.context.getMessage("AddManufacturerAndBrand", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddManufacturerAndBrand", null, Locale.US);
				formPath.closeApplicationContext();
				DeviceManufacturerAndBrandInputController deviceManufacturerAndBrandInputController = (DeviceManufacturerAndBrandInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				deviceManufacturerAndBrandInputController.setDeviceManufacturerAndBrandViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				// Load rootCause Details Update form .

				DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = manufacturerBrandTable.getSelectionModel()
						.getSelectedItem();

				String formName = formPath.context.getMessage("EditManufacturerAndBrand", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditManufacturerAndBrand", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (sharpDeviceManufacAndBrand != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					DeviceManufacturerAndBrandEditController controller = fxmlLoader.getController();
					controller.setSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand);
					controller.setDeviceManufacturerAndBrandEditController(this);
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

			// Delete SharpDeviceManufacAndBrand Details
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer sharpdevicemanufacture = manufacturerBrandTable.getSelectionModel().getSelectedIndex();

				if (sharpdevicemanufacture > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						DeviceManufacturerAndBrand sharpDeviceManufacAndBrand = new DeviceManufacturerAndBrandEntityontroller()
								.viewSharpDeviceManufacturerAndBrand().get(sharpdevicemanufacture);
						new DeviceManufacturerAndBrandEntityontroller()
								.removeSharpDeviceManufacAndBrand(sharpDeviceManufacAndBrand.getId());
						populateDeviceManufacturerAndBrandTable(
								new DeviceManufacturerAndBrandEntityontroller().viewSharpDeviceManufacturerAndBrand());

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

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(manufacturerBrandTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = manufacturerBrandTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(manufacturerBrandTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = manufacturerBrandTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(manufacturerBrandTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = manufacturerBrandTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(manufacturerBrandTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Centralised Form cancel
*/		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
