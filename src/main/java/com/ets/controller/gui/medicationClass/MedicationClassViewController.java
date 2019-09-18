package com.ets.controller.gui.medicationClass;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.medicationClass.MedicationClassEntityController;
import com.ets.controller.gui.medicationCode.MedicationCodeEditController;
import com.ets.controller.gui.medicationCode.MedicationCodeInputController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.model.Medication;
import com.ets.model.MedicationClass;
import com.ets.model.Patient;
import com.ets.model.ReferalProvider;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MedicationClassViewController implements Initializable {

	@FXML
	private TableView<MedicationClass> medicationClassTable;

	@FXML
	private TableColumn<MedicationClass, String> classNameCollumn;

	@FXML
	private TextField medicationSearchText;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button selectButton;
	
	@FXML
	private Button printButton;

	@FXML
	private Button closeButton;

	FXMLFormPath formPath = new FXMLFormPath();
	
	private ObservableList<MedicationClass> medicationMasterData = FXCollections.observableArrayList();

	private MedicationCodeInputController medicationCodeInputController;

	public void setMedicationCodeInputController(MedicationCodeInputController medicationCodeInputController) {
		this.medicationCodeInputController = medicationCodeInputController;
		selectButton.setVisible(true);
	}

	private MedicationCodeEditController medicationCodeEditController;

	public void setMedicationCodeEditController(MedicationCodeEditController medicationCodeEditController) {
		this.medicationCodeEditController = medicationCodeEditController;
	}

	public void viewMedicationClass() {

		medicationMasterData = new MedicationClassEntityController().view();

		classNameCollumn.setCellValueFactory(cellData -> cellData.getValue().medicalClassProperty());

		FilteredList<MedicationClass> filteredData = new FilteredList<MedicationClass>(medicationMasterData, p -> true);

		medicationSearchText.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(medicationclass -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (medicationclass.getMedicalClass().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		SortedList<MedicationClass> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(medicationClassTable.comparatorProperty());

		medicationClassTable.setItems(sortedData);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		selectButton.setVisible(false);
		viewMedicationClass();

		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddMedicationClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddMedicationClass", null, Locale.US);
				formPath.closeApplicationContext();

				MedicationClassInputController medicationClassInputController = (MedicationClassInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationClassInputController.setMedicationClassViewController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				MedicationClass medicationClass = medicationClassTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditMedicationClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMedicationClass", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				// searchPatientController = null;

				if (medicationClass != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					MedicationClassEditController editController = fxmlLoader.getController();
					editController.setMedicationClass(medicationClass);
					editController.setMedicationClassViewController(this);
					stage.show();

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText("Please Select a Medication Class");
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

		selectButton.setOnAction((event) -> {
			try {
				MedicationClass selectmedication = this.medicationClassTable.getSelectionModel().getSelectedItem();

				if (medicationCodeInputController != null) {

					this.medicationCodeInputController.setMedicationClass(selectmedication.getMedicalClass());

				} else if (medicationCodeEditController != null) {

					this.medicationCodeEditController.setMedicationClass(selectmedication.getMedicalClass());
				}
				new FXFormCommonUtilities().closeForm(selectButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
