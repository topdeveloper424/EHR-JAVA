package com.ets.controller.gui.vitalReader;

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.spirometer.SpirometerEntityController;
import com.ets.controller.entity.vitalReader.VitalReaderEntityController;
import com.ets.controller.gui.pulmonaryFunction.SpiroMeterEditController;
import com.ets.model.Spirometer;
import com.ets.model.VitalReader;
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

public class VitalReaderViewContoller implements Initializable {

	@FXML
	private TableView<VitalReader> vitalReaderTable;

	@FXML
	private TableColumn<VitalReader, String> numColumn;

	@FXML
	private TableColumn<VitalReader, String> locationOrDescriptionColumn;

	@FXML
	private TableColumn<VitalReader, String> modelColumn;

	@FXML
	private TableColumn<VitalReader, String> serialNumberColumn;

	@FXML
	private Button add;

	@FXML
	private Button change;

	@FXML
	private Button delete;

	@FXML
	private CheckBox includeInactivesCheckBox;

	@FXML
	private Button clsbtn;
	FXMLFormPath formPath = new FXMLFormPath();

	private ObservableList<VitalReader> vitalReaderMasterData = FXCollections.observableArrayList();

	public void view() {

		vitalReaderMasterData = new VitalReaderEntityController().view();
		locationOrDescriptionColumn.setCellValueFactory(cellData -> cellData.getValue().locProperty());
		serialNumberColumn.setCellValueFactory(cellData -> cellData.getValue().serialNoProperty());
		vitalReaderTable.setItems(vitalReaderMasterData);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		view();
		add.setOnAction((event) -> {
			try {

				// Load and Display - Macro_text_defination.fxml Form

				String formName = formPath.context.getMessage("AddVitalsReaders", null, Locale.US);
				formPath.closeApplicationContext();
				String formTitle = "Enter Vitals Reader(new)";
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		delete.setOnAction((event) -> {
			try {
				// Load VitalReader Details Entry form .
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer vital = vitalReaderTable.getSelectionModel().getSelectedIndex();

				if (vital > -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						VitalReader vitalReader = new VitalReaderEntityController().view().get(vital);
						new VitalReaderEntityController().delete(vitalReader.getId());
						view();
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
		
		change.setOnAction((event) -> {
			try {
				// Load Cmplex Details Edit form .
				String formName = formPath.context.getMessage("EditVitalsReaders", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditVitalsReaders", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				VitalReader vitalReader = vitalReaderTable.getSelectionModel().getSelectedItem();

				if (vitalReader != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					VitalReaderEditController editController = fxmlLoader.getController();
					editController.setVitalReader(vitalReader);
					editController.setVitalReaderViewController(this);
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
		clsbtn.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(clsbtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}
