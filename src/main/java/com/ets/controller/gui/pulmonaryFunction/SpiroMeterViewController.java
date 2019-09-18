package com.ets.controller.gui.pulmonaryFunction;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.spirometer.SpirometerEntityController;
import com.ets.model.Spirometer;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SpiroMeterViewController implements Initializable {

	@FXML
	private TableView<Spirometer> spirometerTable;

	@FXML
	private TableColumn<Spirometer, Integer> numColumn;

	@FXML
	private TableColumn<Spirometer, String> locationOrDescriptionColumn;

	@FXML
	private TableColumn<Spirometer, String> modelColumn;

	@FXML
	private TableColumn<Spirometer, String> serialNumberColumn;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button selectButton;

	@FXML
	private CheckBox includeInacticeCheckBox;

	/*
	 * private SpiroMeterInputController spirometerInputController;
	 * 
	 * public void setSpiroMeterInputController(SpiroMeterInputController
	 * spiroMeterInputController){
	 * this.spirometerInputController=spiroMeterInputController; }
	 */
	private ObservableList<Spirometer> spirometerMasterData = FXCollections.observableArrayList();

	public void viewSpirometer() {

		spirometerMasterData = new SpirometerEntityController().viewSpirometer();

		// numColumn.setCellValueFactory(cellData ->
		// cellData.getValue().idProperty());
		locationOrDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().locProperty());
		// modelColumn.setCellValueFactory(cellData ->
		// cellData.getValue().getEquipmentModel().modelNoProperty());
		serialNumberColumn.setCellValueFactory(cellData -> cellData.getValue().serialNoProperty());
		spirometerTable.setItems(spirometerMasterData);

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewSpirometer();

		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("EnterSpiroMeter", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterSpiroMeter", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		deleteButton.setOnAction((event) -> {
			try {
				// Load Spirometer Details Entry form .
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer spiro = spirometerTable.getSelectionModel().getSelectedIndex();

				if (spiro > -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						Spirometer spirometer = new SpirometerEntityController().viewSpirometer().get(spiro);
						new SpirometerEntityController().deleteSpirometer(spirometer.getId());
						viewSpirometer();
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

		changeButton.setOnAction((event) -> {
			try {
				// Load Cmplex Details Edit form .

				String formName = formPath.context.getMessage("EditSpirometer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditSpirometer", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Spirometer spirometer = spirometerTable.getSelectionModel().getSelectedItem();

				if (spirometer != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					SpiroMeterEditController editController = fxmlLoader.getController();
					editController.setSpirometer(spirometer);
					editController.setSpiroMeterViewController(this);
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

	}

}
