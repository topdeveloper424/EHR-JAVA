package com.ets.controller.gui.stateWorkArea;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.stateWorkArea.StateWorkAreaEntityController;
import com.ets.model.InjuryCode;
import com.ets.model.StateWorkArea;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;

import javafx.collections.FXCollections;
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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of StateWorkAreaViewController Class
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

public class StateWorkAreaViewController implements Initializable {

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
	private TableView<StateWorkArea> stateWorkAreaTable;

	@FXML
	private TableColumn<StateWorkArea, String> codeCollumn;

	@FXML
	private TableColumn<StateWorkArea, String> descriptionCollumn;

	@FXML
	private ComboBox<String> stateCombobox;

	public void refreshWorkArea() {

		codeCollumn.setCellValueFactory(new PropertyValueFactory<StateWorkArea, String>("code"));
		//descriptionCollumn.setCellValueFactory(new PropertyValueFactory<StateWorkArea, String>("descrp"));

	}

	public void populateStateWorkAreaTable(ObservableList<StateWorkArea> stateWorkAreaList) {
		
FilteredList<StateWorkArea> filteredData = new FilteredList<StateWorkArea>(stateWorkAreaList, p -> true);
					
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(stateWorkArea -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return stateWorkArea.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<StateWorkArea> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(stateWorkAreaTable.comparatorProperty());
				
		stateWorkAreaTable.setItems(sortedData);
		
		//stateWorkAreaTable.setItems(stateWorkAreaList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Work Area Details Update form .

				StateWorkArea stateWorkArea = stateWorkAreaTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditWorkArea", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditWorkArea", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				StateWorkAreaEditController controller = fxmlLoader.getController();
				controller.setStateWorkArea(stateWorkArea);
				controller.setStateWorkAreaViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshWorkArea();

		List<String> list = new ArrayList<String>();
		list.add("Alabama");
		list.add("Alaska");
		list.add("Arizona");
		list.add("Arkansas");
		list.add("California");
		list.add("Colorado");
		list.add("Connecticut");
		list.add("Delaware");
		list.add("Florida");
		list.add("Georgia");
		list.add("Hawaii");
		list.add("Idaho");
		list.add("Illinois");
		list.add("Indiana");
		list.add("Iowa");
		list.add("Kansas");
		list.add("Kentucky");
		list.add("Louisiana");
		list.add("Maine");
		list.add("Maryland");
		list.add("Massachusetts");
		list.add("Michigan");
		list.add("Minnesota");
		list.add("Mississippi");
		list.add("Missouri");
		list.add("Montana");
		list.add("Nebraska");
		list.add("Nevada");
		list.add("New Hampshire");
		list.add("New Jersey");
		list.add("New Mexico");
		list.add("New York");
		list.add("North Carolina");
		list.add("North Dakota");
		list.add("Ohio");
		list.add("Oklahoma");
		list.add("Oregon");
		list.add("Pennsylvania");
		list.add("Rhode Island");
		list.add("South Carolina");
		list.add("South Dakota");
		list.add("Tennessee");
		list.add("Texas");
		list.add("Utah");
		list.add("Vermont");
		list.add("Virginia");
		list.add("Washington");
		list.add("West Virginia");
		list.add("Wisconsin");
		list.add("Wyoming");

		ObservableList obList = FXCollections.observableList(list);
		stateCombobox.getItems().clear();
		stateCombobox.setItems(obList);
		stateCombobox.setVisibleRowCount(10);

		addButton.setOnAction((event) -> {
			try {
				// Load Injury Code Details Entry form .
				String state = (String) stateCombobox.getValue();

				if (state == null) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Required Entry!");
					alert.setHeaderText(null);
					alert.setContentText("You must select a State before adding Codes");

					alert.showAndWait();
				} else {

					String formName = formPath.context.getMessage("AddWorkArea", null, Locale.US);
					// String formTitle =
					// formPath.context.getMessage("Title.AddWorkArea" +state,
					// null, Locale.US);
					String formTitle = "Enter State Job Category " + state;
					formPath.closeApplicationContext();

					StateWorkAreaInputController stateWorkAreaInputController = (StateWorkAreaInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					stateWorkAreaInputController.setStateWorkAreaViewController(this);

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				// Load Work Area Details Update form .
				StateWorkArea stateWorkArea = stateWorkAreaTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditWorkArea", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditWorkArea", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (stateWorkArea != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					StateWorkAreaEditController controller = fxmlLoader.getController();
					controller.setStateWorkArea(stateWorkArea);
					controller.setStateWorkAreaViewController(this);
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

			// Delete State Work Area Details
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer area = stateWorkAreaTable.getSelectionModel().getSelectedIndex();

				if (area > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						StateWorkArea stateWorkArea = new StateWorkAreaEntityController().viewStateWorkArea().get(area);
						new StateWorkAreaEntityController().removeStateWorkArea(stateWorkArea.getId());

						populateStateWorkAreaTable(new StateWorkAreaEntityController().viewStateWorkArea());

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
				UIRecordNavigation.setPosition(stateWorkAreaTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = stateWorkAreaTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(stateWorkAreaTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = stateWorkAreaTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(stateWorkAreaTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = stateWorkAreaTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(stateWorkAreaTable, tempRowCount);
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
