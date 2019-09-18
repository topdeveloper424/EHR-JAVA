package com.ets.controller.gui.respiratorModel;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.respiratorModel.RespiratorModelEntityController;
import com.ets.model.Division;
import com.ets.model.RespiratorModel;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-07-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespiratorModelViewController Class
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

public class RespiratorModelViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private TableView<RespiratorModel> respiratorModelTable;

	@FXML
	private TableColumn<RespiratorModel, String> descriptionColumn;

	@FXML
	private TableColumn<RespiratorModel, String> codeColumn;

	@FXML
	private Button topButton; // Table Record Top Button

	@FXML
	private Button upButton; // Table Record Up Button

	@FXML
	private Button downButton; // Table Record Down Button

	@FXML
	private Button bottomButton; // Table Record Bottom Button

	@FXML
	void doubleClicked(MouseEvent event) {

		try {
			// Load Respirator Model Details Entry form .

			String formName = formPath.context.getMessage("EditRespiratorModel", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditRespiratorModel", null, Locale.US);
			formPath.closeApplicationContext();

			RespiratorModel respiratorModel = respiratorModelTable.getSelectionModel().getSelectedItem();

			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.setTitle(formTitle);
			stage.setScene(new Scene(root1));
			RespiratorModelEditController editController = fxmlLoader.getController();
			editController.setRespiratorModel(respiratorModel);
			editController.setRespiratorModelViewController(this);
			stage.show();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

	}

	public void refreshRespiratorModel() {

		codeColumn.setCellValueFactory(new PropertyValueFactory<RespiratorModel, String>("code"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<RespiratorModel, String>("descrp"));

	}

	public void populateRespiratorModelTable(ObservableList<RespiratorModel> respiratorModelList) {
		
FilteredList<RespiratorModel> filteredData = new FilteredList<RespiratorModel>(respiratorModelList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(respiratorModel -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
								
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (respiratorModel.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(respiratorModel -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return respiratorModel.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<RespiratorModel> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(respiratorModelTable.comparatorProperty());
				
		respiratorModelTable.setItems(sortedData);
		
		
		//respiratorModelTable.setItems(respiratorModelList);
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshRespiratorModel();

		addButton.setOnAction((event) -> {
			try {
				// Load Respirator Model Details Entry form .

				String formName = formPath.context.getMessage("AddRespiratorModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddRespiratorModel", null, Locale.US);
				formPath.closeApplicationContext();
				
				RespiratorModelInputController respiratorModelInputController =
				(RespiratorModelInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				respiratorModelInputController.setRespiratorModelViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Fiest Response Details Entry form .

				String formName = formPath.context.getMessage("EditRespiratorModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditRespiratorModel", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				RespiratorModel respiratorModel = respiratorModelTable.getSelectionModel().getSelectedItem();

				if (respiratorModel != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					RespiratorModelEditController editController = fxmlLoader.getController();
					editController.setRespiratorModel(respiratorModel);
					editController.setRespiratorModelViewController(this);
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
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer respiratorModelSelectedIndex = respiratorModelTable.getSelectionModel().getSelectedIndex();

				if (respiratorModelSelectedIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						RespiratorModel respiratorModel = new RespiratorModelEntityController()
								.viewRespiratorModelList().get(respiratorModelSelectedIndex);
						new RespiratorModelEntityController().delete(respiratorModel.getId());
						populateRespiratorModelTable(new RespiratorModelEntityController().viewRespiratorModelList());

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

		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(respiratorModelTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = respiratorModelTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(respiratorModelTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = respiratorModelTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(respiratorModelTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = respiratorModelTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(respiratorModelTable, tempRowCount);
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
