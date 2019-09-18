package com.ets.controller.gui.bodyzone;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.bodyzone.BodyZoneEntityController;
import com.ets.model.BodyZone;
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
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyZoneViewController Class
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

public class BodyZoneViewController implements Initializable {

	@FXML
	private TextField searchTextField;

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
    private CheckBox inactiveCheckBox;

	@FXML
	private TableView<BodyZone> bodyZoneTable;

	@FXML
	private TableColumn<BodyZone, String> descriptionCollumn;

	@FXML
	private TableColumn<BodyZone, String> bodyZoneCollumn;
	
	
	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		try {
			String formName = formPath.context.getMessage("AddBodyZone", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddBodyZone", null, Locale.US);
			formPath.closeApplicationContext();
			BodyZoneInputController bodyZoneInputController = (BodyZoneInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			bodyZoneInputController.setBodyZoneViewController(this);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		try {
			BodyZone bodyz = bodyZoneTable.getSelectionModel().getSelectedItem();
			String formName = formPath.context.getMessage("EditBodyZone", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditBodyZone", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			if (bodyz != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				BodyZoneEditController controller = fxmlLoader.getController();
				controller.setBodyZone(bodyz);
				controller.setBodyZoneViewController(this);
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
		// Delete Body Zone Details

		try {
			String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
			String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			Integer zone = bodyZoneTable.getSelectionModel().getSelectedIndex();

			if (zone > -1) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					BodyZone bodyZone = new BodyZoneEntityController().viewBodyZone().get(zone);
					new BodyZoneEntityController().removeBodyZone(bodyZone.getId());
					populateBodyZoneTable(new BodyZoneEntityController().viewBodyZone());
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

	public void refreshBodyZone() {

		bodyZoneCollumn.setCellValueFactory(new PropertyValueFactory<BodyZone, String>("zone"));
		descriptionCollumn.setCellValueFactory(new PropertyValueFactory<BodyZone, String>("descrp"));
		
	}

	public void populateBodyZoneTable(ObservableList<BodyZone> bodyZoneCodeList) {
		
		
FilteredList<BodyZone> filteredData = new FilteredList<BodyZone>(bodyZoneCodeList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(bodyZone -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (bodyZone.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(bodyZone -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return bodyZone.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<BodyZone> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(bodyZoneTable.comparatorProperty());
				
		bodyZoneTable.setItems(sortedData);
		
		//bodyZoneTable.setItems(bodyZoneCodeList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				BodyZone bodyz = bodyZoneTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditBodyZone", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditBodyZone", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				BodyZoneEditController controller = fxmlLoader.getController();
				controller.setBodyZone(bodyz);
				controller.setBodyZoneViewController(this);
				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshBodyZone();

		addButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("AddBodyZone", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddBodyZone", null, Locale.US);
				formPath.closeApplicationContext();
				BodyZoneInputController bodyZoneInputController = (BodyZoneInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				bodyZoneInputController.setBodyZoneViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {

			try {

				BodyZone bodyz = bodyZoneTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditBodyZone", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditBodyZone", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (bodyz != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					BodyZoneEditController controller = fxmlLoader.getController();
					controller.setBodyZone(bodyz);
					controller.setBodyZoneViewController(this);
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

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(bodyZoneTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = bodyZoneTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(bodyZoneTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = bodyZoneTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(bodyZoneTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = bodyZoneTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(bodyZoneTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
*/
		deleteButton.setOnAction((event) -> {

			// Delete Body Zone Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer zone = bodyZoneTable.getSelectionModel().getSelectedIndex();

				if (zone > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						BodyZone bodyZone = new BodyZoneEntityController().viewBodyZone().get(zone);

						new BodyZoneEntityController().removeBodyZone(bodyZone.getId());

						populateBodyZoneTable(new BodyZoneEntityController().viewBodyZone());

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
