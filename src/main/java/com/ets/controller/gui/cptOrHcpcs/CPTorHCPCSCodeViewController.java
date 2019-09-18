package com.ets.controller.gui.cptOrHcpcs;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SelectCPTorHCPCSCodeController Class
 *Description: SelectCPTorHCPCSCode.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.
 */

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.cpt4.Cpt4EntityController;
import com.ets.controller.entity.workLocation.WorkLocationEntityController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.medicalActivity.MedicalActivityCodeEditController;
import com.ets.controller.gui.medicalActivity.MedicalActivityCodeInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BillingServiceType;
import com.ets.model.Carrier;
import com.ets.model.Complex;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.JobClass;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.Initializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**

 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 20-12-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CPT HCPC code Class
 *Description: View.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:Neha Sahadev
 *Owner:
 *Date:21/11/2017
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class CPTorHCPCSCodeViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private TextField descriptionContainsTextField;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private TableView<CptCode4Hcpcs> cptTable;

	@FXML
	private TableColumn<CptCode4Hcpcs, String> codeCollumn;

	@FXML
	private TableColumn<CptCode4Hcpcs, String> descriptionCollumn;

	@FXML
	private TableColumn<CptCode4Hcpcs, String> typeCollumn;

	@FXML
	private TableColumn<CptCode4Hcpcs, Boolean> inactiveCollumn;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button bottomButton;

	@FXML
	private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button printButton;

	@FXML
	private Button selectButton;

	private MedicalActivityCodeInputController medicalActivityCodeInputController;

	public void setMedicalActivityCodeInputController(
			MedicalActivityCodeInputController medicalActivityCodeInputController) {
		this.medicalActivityCodeInputController = medicalActivityCodeInputController;
	}

	private MedicalActivityCodeEditController medicalActivityCodeEditController;

	public void setMedicalActivityCodeEditController(
			MedicalActivityCodeEditController medicalActivityCodeEditController) {
		this.medicalActivityCodeEditController = medicalActivityCodeEditController;
	}

	private ObservableList<CptCode4Hcpcs> cptCode4HcpcsMasterData = FXCollections.observableArrayList();

	public void viewCptOrHcpcs() {

		cptCode4HcpcsMasterData = new Cpt4EntityController().view();

		codeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().codeProperty());
		descriptionCollumn.setCellValueFactory(cellValue -> cellValue.getValue().descrpProperty());
		typeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().codeTypeProperty());
		inactiveCollumn.setCellValueFactory(cellValue -> cellValue.getValue().inactiveProperty());

		FilteredList<CptCode4Hcpcs> filteredData = new FilteredList<CptCode4Hcpcs>(cptCode4HcpcsMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(cptCode -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (cptCode.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(cptCode -> {

				if (includeInactiveCheckBox.isSelected()) {

					return cptCode.getInactive();

				}

				return true;
			});

		});

		SortedList<CptCode4Hcpcs> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(cptTable.comparatorProperty());

		cptTable.setItems(sortedData);

		// cptTable.setItems(new Cpt4EntityController().view());
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {

				CptCode4Hcpcs code4Hcpcs = cptTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditCPT4", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCPT4", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				CPT4orHCPCSCodeEditController editController = fxmlLoader.getController();
				editController.setCptCode4Hcpcs(code4Hcpcs);
				editController.setcPTorHCPCSCodeViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewCptOrHcpcs();

		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		addButton.setOnAction((event) -> {

			try {
				// Load and Display - Enter_Select_CPT-4_or_HCPCS_Code(New).fxml
				// Form
				String formName = formPath.context.getMessage("AddCPT4", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddCPT4", null, Locale.US);
				formPath.closeApplicationContext();
				CPT4orHCPCSCodeInputController cpt4orHCPCSCodeInputController = (CPT4orHCPCSCodeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				cpt4orHCPCSCodeInputController.setcPTorHCPCSCodeViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Cmplex Details Edit form .

				CptCode4Hcpcs code4Hcpcs = cptTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditCPT4", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditCPT4", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (code4Hcpcs != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					CPT4orHCPCSCodeEditController editController = fxmlLoader.getController();
					editController.setCptCode4Hcpcs(code4Hcpcs);
					editController.setcPTorHCPCSCodeViewController(this);
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

			// Delete Carrier Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer cptIndex = cptTable.getSelectionModel().getSelectedIndex();

				if (cptIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						CptCode4Hcpcs cdptCode4Hcpcs = new Cpt4EntityController().view().get(cptIndex);

						new Cpt4EntityController().delete(cdptCode4Hcpcs.getId());

						viewCptOrHcpcs();

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
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.CptCode4Hcpcs", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<CptCode4Hcpcs>> task =

					new Task<ObservableList<CptCode4Hcpcs>>() {

						@Override
						protected ObservableList<CptCode4Hcpcs> call() throws Exception {

							ObservableList<CptCode4Hcpcs> cptCode4HcpcsList = null;

							try {

								System.out.println("Generating PDF...");

								String printCptCode4Hcpcs = formPath.context.getMessage("Print.CptCode4Hcpcs", null,
										Locale.US);

								formPath.closeApplicationContext();

								// InputStream is = new FileInputStream(new
								// File(printCptCode4Hcpcs));
								InputStream is = this.getClass().getResourceAsStream(printCptCode4Hcpcs);

								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								cptCode4HcpcsList = new Cpt4EntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(cptCode4HcpcsList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return cptCode4HcpcsList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		selectButton.setOnAction((event) -> {

			CptCode4Hcpcs selectedCptCode4Hcpcs = this.cptTable.getSelectionModel().getSelectedItem();

			if (medicalActivityCodeInputController != null) {

				this.medicalActivityCodeInputController.setCptCodeOrHecpcs(selectedCptCode4Hcpcs.getCode());

			} else if (medicalActivityCodeEditController != null) {

				medicalActivityCodeEditController.setCptCodeOrHecpcs(selectedCptCode4Hcpcs.getCode());

			} else {

				new FXFormCommonUtilities().closeForm(selectButton);
			}

			new FXFormCommonUtilities().closeForm(selectButton);

		});
	}
}