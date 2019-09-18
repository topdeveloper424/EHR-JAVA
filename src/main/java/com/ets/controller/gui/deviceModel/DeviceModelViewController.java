package com.ets.controller.gui.deviceModel;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.deviceModel.DeviceModelEntityController;
import com.ets.model.DeviceModel;
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
 *Parameter Definition: Type object of DeviceModelViewController Class
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

public class DeviceModelViewController implements Initializable {

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;
	
    @FXML
    private TextField searchTextField;

	@FXML
	private Button deleteButton;

	@FXML
	private Button closeButton;

	@FXML
	private TableView<DeviceModel> deviceModelTable;

	@FXML
	private TableColumn<DeviceModel, String> deviceModelCollumn;	
	
	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		
		try {
			// Load Sharp Device Model Details Entry form .

			String formName = formPath.context.getMessage("AddDeviceModel", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddDeviceModel", null, Locale.US);
			formPath.closeApplicationContext();
			DeviceModelInputController deviceModelInputController = (DeviceModelInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			deviceModelInputController.setDeviceModelViewController(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		try {
			// Load Sharp Device Model Details Edit form .

			DeviceModel sharpDeviceModel = deviceModelTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditDeviceModel", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditDeviceModel", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			if (sharpDeviceModel != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				DeviceModelEditController editController = fxmlLoader.getController();
				editController.setSharpDeviceModel(sharpDeviceModel);
				editController.setDeviceModelEditController(this);
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
		// Delete Sharp Device Model Details
		try {
			String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
			String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			Integer devicemodel = deviceModelTable.getSelectionModel().getSelectedIndex();

			if (devicemodel > -1) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

					DeviceModel sharpDeviceModel = new DeviceModelEntityController().viewSharpDeviceModel().get(devicemodel);
					new DeviceModelEntityController().removeSharpDeviceModel(sharpDeviceModel.getId());

					populateDeviceModelTable(new DeviceModelEntityController().viewSharpDeviceModel());
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

	public void refreshDeviceModel() {

		deviceModelCollumn.setCellValueFactory(new PropertyValueFactory<DeviceModel, String>("descrp"));

	}

	public void populateDeviceModelTable(ObservableList<DeviceModel> deviceModelList) {
		
		
FilteredList<DeviceModel> filteredData = new FilteredList<DeviceModel>(deviceModelList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(deviceModel -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (deviceModel.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(deviceModel -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return deviceModel.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<DeviceModel> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(deviceModelTable.comparatorProperty());
				
		deviceModelTable.setItems(sortedData);
		
		//deviceModelTable.setItems(deviceModelList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Sharp Device Model Details Edit form .

				DeviceModel sharpDeviceModel = deviceModelTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditDeviceModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDeviceModel", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();

				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				DeviceModelEditController editController = fxmlLoader.getController();
				editController.setSharpDeviceModel(sharpDeviceModel);
				editController.setDeviceModelEditController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshDeviceModel();

		addButton.setOnAction((event) -> {
			try {
				// Load Sharp Device Model Details Entry form .

				String formName = formPath.context.getMessage("AddDeviceModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddDeviceModel", null, Locale.US);
				formPath.closeApplicationContext();
				DeviceModelInputController deviceModelInputController = (DeviceModelInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				deviceModelInputController.setDeviceModelViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Sharp Device Model Details Edit form .

				DeviceModel sharpDeviceModel = deviceModelTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditDeviceModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDeviceModel", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (sharpDeviceModel != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					DeviceModelEditController editController = fxmlLoader.getController();
					editController.setSharpDeviceModel(sharpDeviceModel);
					editController.setDeviceModelEditController(this);
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

			// Delete Sharp Device Model Details
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer devicemodel = deviceModelTable.getSelectionModel().getSelectedIndex();

				if (devicemodel > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						DeviceModel sharpDeviceModel = new DeviceModelEntityController().viewSharpDeviceModel()
								.get(devicemodel);
						new DeviceModelEntityController().removeSharpDeviceModel(sharpDeviceModel.getId());

						populateDeviceModelTable(new DeviceModelEntityController().viewSharpDeviceModel());

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
