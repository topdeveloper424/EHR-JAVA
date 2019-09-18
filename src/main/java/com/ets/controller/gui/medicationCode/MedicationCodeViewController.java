package com.ets.controller.gui.medicationCode;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import org.fxmisc.easybind.EasyBind;

import com.ets.controller.entity.medication.MedicationEntityController;
import com.ets.controller.gui.emrCharting.order.MedicationInputController;
import com.ets.controller.gui.emrCharting.order.medication.AcetaminophenInputController;
import com.ets.controller.gui.emrCharting.order.medication.AllergyInputController;
import com.ets.controller.gui.emrCharting.order.medication.AnalgesicsMuscleRelaxantsInputController;
import com.ets.controller.gui.emrCharting.order.medication.AnalgesicsNSAIDSInputController;
import com.ets.controller.gui.emrCharting.order.medication.AnalgesicsOpioidsInputController;
import com.ets.controller.gui.emrCharting.order.medication.AntibioticAdultRXInputController;
import com.ets.controller.gui.emrCharting.order.medication.AspirinAdultOTCInputController;
import com.ets.controller.gui.emrCharting.order.medication.AsthmaInputController;
import com.ets.controller.gui.emrCharting.order.medication.DiabetesInputController;
import com.ets.controller.gui.emrCharting.order.medication.DrJonesFavoritesInputController;
import com.ets.controller.gui.emrCharting.order.medication.DrSmithFavoritesInputController;
import com.ets.controller.gui.emrCharting.order.medication.ENDOInputController;
import com.ets.controller.gui.emrCharting.order.medication.GIAntidiarrheaInputController;
import com.ets.controller.gui.emrCharting.order.medication.GIAntinausesInputController;
import com.ets.controller.gui.emrCharting.order.medication.HTNInputController;
import com.ets.controller.gui.emrCharting.order.medication.IbuprofenInputController;
import com.ets.controller.gui.emrCharting.order.medication.IbuprofenOTCInputController;
import com.ets.controller.gui.emrCharting.order.medication.InHouseDispenseInputController;
import com.ets.controller.gui.emrCharting.order.medication.InOfficeAdministeredInputController;
import com.ets.controller.gui.emrCharting.order.medication.LipidsInputControlle;
import com.ets.controller.gui.emrCharting.order.medication.MagicMouthwashInputController;
import com.ets.controller.gui.emrCharting.order.medication.MedicationForPatientInputController;
import com.ets.controller.gui.emrCharting.order.medication.OralInputController;
import com.ets.controller.gui.emrCharting.order.medication.PainNeuropathicInputController;
import com.ets.controller.gui.emrCharting.order.medication.PainWithInSpasmInputController;
import com.ets.controller.gui.emrCharting.order.medication.PainWithInflamationInputController;
import com.ets.controller.gui.emrCharting.order.medication.PreloneInputController;
import com.ets.controller.gui.emrCharting.order.medication.SleepInputController;
import com.ets.controller.gui.emrCharting.order.medication.UrgentCareInjectablesInputcontroller;
import com.ets.controller.gui.emrCharting.pmh.allergy.AspirinInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.CodeineInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.MedicationCategoryInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.SelectMedicationInputController;
import com.ets.controller.gui.medicationClass.MedicationClassEditController;
import com.ets.controller.gui.medicationClass.MedicationClassInputController;
import com.ets.model.Medication;
import com.ets.model.MedicationClass;
import com.ets.model.Patient;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

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

public class MedicationCodeViewController implements Initializable {

	@FXML
	private TableView<Medication> medicationCodeTable;

	@FXML
	private TableColumn<Medication, String> medicationNameCollumn;

	@FXML
	private TableColumn<Medication, String> strengthCollumn;

	@FXML
	private TableColumn<Medication, String> formCollumn;

	@FXML
	private TableColumn<Medication, String> genericMecationCollumn;

	@FXML
	private TableColumn<Medication, String> medicationClassCollumn;

	@FXML
	private TextField searchByMedicationClassTextField;

	@FXML
	private TextField searchByMedicationNameText;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;
	@FXML
	private Button selectButton;

	@FXML
	private Button selectButtonForPatient;
	@FXML
	private Button closeButton;

	@FXML
	private Button printButton;

	private CodeineInputController codeineInputController;

	public void setCodeineInputController(CodeineInputController codeineInputController) {
		this.codeineInputController = codeineInputController;
		selectButton.setVisible(true);
	}

	private AspirinInputController aspirinInputController;

	public void setAspirinInputController(AspirinInputController aspirinInputController) {
		this.aspirinInputController = aspirinInputController;

		selectButton.setVisible(true);
	}

	public MedicationInputController medicationInputController;
	private String str;

	public void setMedicationInputController(MedicationInputController medicationInputController, String str) {
		this.medicationInputController = medicationInputController;
		this.str = str;
		// selectButton.setVisible(true);
		selectButtonForPatient.setVisible(true);
	}

	private SelectMedicationInputController selectMedicationInputController;

	public void setSelectMedicationInputController(SelectMedicationInputController selectMedicationInputController) {
		this.selectMedicationInputController = selectMedicationInputController;
		selectButton.setVisible(true);

	}

	private MedicationCategoryInputController medicationCategoryInputController;

	public void setMedicationCategoryInputController(
			MedicationCategoryInputController medicationCategoryInputController) {
		this.medicationCategoryInputController = medicationCategoryInputController;
		selectButton.setVisible(true);
	}

	FXMLFormPath formPath = new FXMLFormPath();
	private ObservableList<Medication> medicationsList;

	public void viewMedication() {
		medicationsList = new MedicationEntityController().view();

		medicationNameCollumn.setCellValueFactory(cellData -> cellData.getValue().medicationNameProperty());
		strengthCollumn.setCellValueFactory(cellData -> cellData.getValue().medStrengthProperty());

		formCollumn.setCellValueFactory(cellData -> cellData.getValue().formProperty());

		medicationClassCollumn.setCellValueFactory(data -> EasyBind.select(data.getValue().medicationClassProperty())
				.selectObject(MedicationClass::medicalClassProperty));

		FilteredList<Medication> filteredData = new FilteredList<Medication>(medicationsList, p -> true);

		searchByMedicationNameText.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(medicationName -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (medicationName.getMedicationName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}

				return false; // Does not match.
			});
		});

		searchByMedicationClassTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(medicationName -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (medicationName.getMedicationClass().getMedicalClass().toLowerCase()
						.indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}

				return false; // Does not match.
			});
		});

		SortedList<Medication> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(medicationCodeTable.comparatorProperty());

		// patientTable.setItems(patientMasterData);
		medicationCodeTable.setItems(sortedData);

		// patientTable.setItems(patientMasterData);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewMedication();
		selectButton.setVisible(false);
		selectButtonForPatient.setVisible(false);

		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddMedicationCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddMedicationCode", null, Locale.US);
				MedicationCodeInputController medicationCodeInputController = (MedicationCodeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				medicationCodeInputController.setMedicationCodeViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				Medication medication = medicationCodeTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditMedicationCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMedicationCode", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (medication != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					MedicationCodeEditController editController = fxmlLoader.getController();
					editController.setMedication(medication);
					editController.setMedicationCodeViewController(this);
					stage.show();

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText("Please Select a Medication Code");
					alert.showAndWait();

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		selectButtonForPatient.setOnAction((event) -> {
			try {

				if (str == "UrgentCareOralCheck") {
					MedicationForPatientInputController medicationForPatientInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("MedicationForPatient", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					medicationForPatientInputController = (MedicationForPatientInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					medicationForPatientInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "UrgentCareInjectablesCheckBox") {

					UrgentCareInjectablesInputcontroller urgentCareInjectablesInputcontroller = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("UrgentCareInjectables", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					urgentCareInjectablesInputcontroller = (UrgentCareInjectablesInputcontroller) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					urgentCareInjectablesInputcontroller.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "InHouseDispenseCheckBox") {

					InHouseDispenseInputController inHouseDispenseInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("InHouseDispense", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					inHouseDispenseInputController = (InHouseDispenseInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					inHouseDispenseInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "InOfficeAdministeredCheckBox") {

					InOfficeAdministeredInputController inOfficeAdministeredInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("InOfficeAdministered", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					inOfficeAdministeredInputController = (InOfficeAdministeredInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					inOfficeAdministeredInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "AntibioticsAdultRxCheckBox") {

					AntibioticAdultRXInputController antibioticAdultRXInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("AntibioticsAdultRx", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					antibioticAdultRXInputController = (AntibioticAdultRXInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					antibioticAdultRXInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "OralTopicalRxCheckBox") {

					OralInputController oralInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("OralRxFrequentList", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					oralInputController = (OralInputController) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					oralInputController.setMedicationCodeViewController(this, selectedmedication);

				}

				if (str == "PainWithInflamationCheckBox") {

					PainWithInflamationInputController painWithInflamationInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("PainWithInflamation", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					painWithInflamationInputController = (PainWithInflamationInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					painWithInflamationInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "PainWithSpasmCheckBox") {

					PainWithInSpasmInputController painWithInSpasmInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("PainWithSpasm", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					painWithInSpasmInputController = (PainWithInSpasmInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					painWithInSpasmInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "PainNeuropathicCheckBox") {

					PainNeuropathicInputController painNeuropathicInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("PainNeuropathicW", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					painNeuropathicInputController = (PainNeuropathicInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					painNeuropathicInputController.setMedicationCodeViewController(this, selectedmedication);
				}

				if (str == "DrJonesCheckBox") {

					DrJonesFavoritesInputController drJonesFavoritesInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("DrJonesFavorites", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					drJonesFavoritesInputController = (DrJonesFavoritesInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					drJonesFavoritesInputController.setMedicationCodeViewController(this, selectedmedication);
				}

				if (str == "DrSmithCheckBox") {

					DrSmithFavoritesInputController drSmithFavoritesInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("DrSmithFavorites", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					drSmithFavoritesInputController = (DrSmithFavoritesInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					drSmithFavoritesInputController.setMedicationCodeViewController(this, selectedmedication);

				}

				if (str == "Acetaminophen500CheckBox") {

					AcetaminophenInputController acetaminophenInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("Acetaminophen", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					acetaminophenInputController = (AcetaminophenInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					acetaminophenInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "AspirinOTCCheckBox") {

					// AspirinInputController aspirinInputController = null;
					com.ets.controller.gui.emrCharting.order.medication.AspirinInputController aspirinInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("AspirinOTC", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					aspirinInputController = (com.ets.controller.gui.emrCharting.order.medication.AspirinInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					aspirinInputController.setMedicationCodeViewController(this, selectedmedication);
				}

				if (str == "IbuprofenCheckBox") {

					IbuprofenInputController ibuprofenInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("Ibuprofen", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					ibuprofenInputController = (IbuprofenInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					ibuprofenInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "IbuprofenOTCCheck") {

					IbuprofenOTCInputController ibuprofenOTCInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("IbuprofenOTC", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					ibuprofenOTCInputController = (IbuprofenOTCInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					ibuprofenOTCInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "MagicMouthwashCheckBox") {

					MagicMouthwashInputController magicMouthwashInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("MagicMouthwash", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					magicMouthwashInputController = (MagicMouthwashInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					magicMouthwashInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "Prelone15CheckBox") {

					PreloneInputController preloneInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("Prelone", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					preloneInputController = (PreloneInputController) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					preloneInputController.setMedicationCodeViewController(this, selectedmedication);

				}

				if (str == "AsthmaCheck") {

					AsthmaInputController asthmaInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("Asthma", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					asthmaInputController = (AsthmaInputController) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					asthmaInputController.setMedicationCodeViewController(this, selectedmedication);

				}

				if (str == "AllergyURICoughCheckBox") {

					AllergyInputController allergyInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("AllergyURICoug", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					allergyInputController = (AllergyInputController) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					allergyInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "AnalgesicsMuscleCheckBox") {

					AnalgesicsMuscleRelaxantsInputController analgesicsMuscleRelaxantsInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("AnalgesicsMuscle", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					analgesicsMuscleRelaxantsInputController = (AnalgesicsMuscleRelaxantsInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					analgesicsMuscleRelaxantsInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "AnalgesicsNSAIDSCheckBox") {

					AnalgesicsNSAIDSInputController analgesicsNSAIDSInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("AnalgesicsNSAIDS", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					analgesicsNSAIDSInputController = (AnalgesicsNSAIDSInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					analgesicsNSAIDSInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "AnalgesicsOpioidsCheck") {

					AnalgesicsOpioidsInputController analgesicsOpioidsInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("AnalgesicsOpioids", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					analgesicsOpioidsInputController = (AnalgesicsOpioidsInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					analgesicsOpioidsInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "DiabetesCheckBox") {

					DiabetesInputController diabetesInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("Diabetes", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					diabetesInputController = (DiabetesInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					diabetesInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "ENDOOCPCheckBox") {

					ENDOInputController endoInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("ENDO_OCP", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					endoInputController = (ENDOInputController) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					endoInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "GIAntidiarrheCheckBox") {

					GIAntidiarrheaInputController giAntidiarrheaInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("GIAntidiarrhea", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					giAntidiarrheaInputController = (GIAntidiarrheaInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					giAntidiarrheaInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "GIAntinausesCheckBox") {

					GIAntinausesInputController antinausesInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("GIAntinauses", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					antinausesInputController = (GIAntinausesInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					antinausesInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "htnAceArbCheckBox") {

					HTNInputController htnInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("HTN_ACE", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					htnInputController = (HTNInputController) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					htnInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "lipidsCheckBox") {

					LipidsInputControlle lipidsInputControlle = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("Lipids", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					lipidsInputControlle = (LipidsInputControlle) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					lipidsInputControlle.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "SleepAnxietyCheckBox") {

					SleepInputController sleepInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("SleepAnxiety", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					sleepInputController = (SleepInputController) new FXFormCommonUtilities().displayForm(formName,
							formTitle);
					sleepInputController.setMedicationCodeViewController(this, selectedmedication);

				}
				if (str == "AspirinAdultOTCCheckBox") {

					AspirinAdultOTCInputController aspirinAdultOTCInputController = null;
					Medication selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem();
					// medicationForPatientInputController.selectedmedication.getMedicationName());
					String formName = formPath.context.getMessage("AspirinAdultOTC", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicationForPatient", null, Locale.US);

					aspirinAdultOTCInputController = (AspirinAdultOTCInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					aspirinAdultOTCInputController.setMedicationCodeViewController(this, selectedmedication);

				}

				new FXFormCommonUtilities().closeForm(selectButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		selectButton.setOnAction((event) -> {
			try {

				String selectedmedication = this.medicationCodeTable.getSelectionModel().getSelectedItem()
						.getMedicationName();
				if (aspirinInputController != null) {

					aspirinInputController.setMedication(selectedmedication);

				}

				if (codeineInputController != null) {

					codeineInputController.setMedication(selectedmedication);

				}

				if (selectMedicationInputController != null) {
					selectMedicationInputController.setMedication(selectedmedication);

				}

				if (medicationCategoryInputController != null) {
					medicationCategoryInputController.setMedication(selectedmedication);

				}
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Centralised Form cancel
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
				++medicationInputController.formCount;
				medicationInputController.setMedicationForPatientUI();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
