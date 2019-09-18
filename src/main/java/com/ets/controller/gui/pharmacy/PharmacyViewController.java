package com.ets.controller.gui.pharmacy;

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Pharmacy;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-04-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PharmacyViewController Class
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

public class PharmacyViewController implements Initializable {

	@FXML
	private AnchorPane pane;

	@FXML
	private TextField pharmacyTextField;

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
	private TableView<Pharmacy> pharmacyTable;

	@FXML
	private TableColumn<Pharmacy, String> pharmacyNameCollumn;

	@FXML
	private TableColumn<Pharmacy, String> codeCollumn;

	@FXML
	private TableColumn<Pharmacy, String> cityCollumn;

	@FXML
	private TableColumn<Pharmacy, String> stateCollumn;

	@FXML
	private TableColumn<Pharmacy, String> telCollumn;

	@FXML
	private TableColumn<Pharmacy, String> faxCollumn;

	@FXML
	private Button printButton;

	@FXML
	private Button searchButton;

	public void refreshPharmacy() {
		codeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().codeProperty());
		pharmacyNameCollumn.setCellValueFactory(cellValue -> cellValue.getValue().nameProperty());
		cityCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getAddress().cityProperty());
		stateCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getAddress().stateProperty());
		telCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getAddress().phoneProperty());
		faxCollumn.setCellValueFactory(cellValue -> cellValue.getValue().getAddress().faxProperty());

	}

	public void populatePharmacyTable(ObservableList<Pharmacy> pharmacyTableList) {
		pharmacyTable.setItems(pharmacyTableList);
	}

	@FXML
	void doubleClick(MouseEvent event) {
		if (event.getClickCount() == 2) {
			try {
				// Load Pharmacy Details Edit form .

				Pharmacy pharmacy = pharmacyTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditPharmacy", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditPharmacy", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();

				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				PharmacyEditController editController = fxmlLoader.getController();
				editController.setPharmacy(pharmacy);
				editController.setPharmacyViewController(this);
				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	@FXML
	void tabKey(KeyEvent event) {

		if (event.getCode() == KeyCode.TAB) {

			try {

				populatePharmacyTable(
						new PharmacyEntityController().searchPharmacyUsingTabKey(pharmacyTextField.getText()));

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshPharmacy();

		searchButton.setOnAction((event) -> {

			try {

				if (pharmacyTextField.getText().length() == 0) {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please Enter Pharmacy Name");

					alert.showAndWait();

				} else {

					populatePharmacyTable(
							new PharmacyEntityController().searchPharmacyUsingTabKey(pharmacyTextField.getText()));

				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		addButton.setOnAction((event) -> {
			try {
				// Load Pharmacy Details Entry form .

				String formName = formPath.context.getMessage("AddPharmacy", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddPharmacy", null, Locale.US);
				formPath.closeApplicationContext();

				PharmacyInputController controller = (PharmacyInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				controller.setPharmacyViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Pharmacy Details Edit form .

				Pharmacy pharmacy = pharmacyTable.getSelectionModel().getSelectedItem();
				String formName = formPath.context.getMessage("EditPharmacy", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditPharmacy", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				if (pharmacy != null) {
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();

					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					PharmacyEditController editController = fxmlLoader.getController();
					editController.setPharmacy(pharmacy);
					editController.setPharmacyViewController(this);

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

			// Delete Pharmacy Details
			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer pharm = pharmacyTable.getSelectionModel().getSelectedIndex();

				if (pharm > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						Pharmacy pharmacy = new PharmacyEntityController().viewPharmacy().get(pharm);
						new PharmacyEntityController().removePharmacy(pharmacy.getId());
						populatePharmacyTable(new PharmacyEntityController().viewPharmacy());
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

		/*************************************
		 * Start of pharmacyBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Pharmacy", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Pharmacy>> task =

					new Task<ObservableList<Pharmacy>>() {

						@Override
						protected ObservableList<Pharmacy> call() throws Exception {

							ObservableList<Pharmacy> pharmacyList = null;

							try {

								System.out.println("Generating PDF...");

								String printPharmacy = formPath.context.getMessage("Print.Pharmacy", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printPharmacy));
								InputStream is = this.getClass().getResourceAsStream(printPharmacy);

								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								pharmacyList = new PharmacyEntityController().viewPharmacy();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(pharmacyList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return pharmacyList;

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
		/*************************************
		 * End of pharmacyBtn.setOnAction(..)
		 *************************************************************/
/*
		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(pharmacyTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = pharmacyTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(pharmacyTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = pharmacyTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(pharmacyTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = pharmacyTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(pharmacyTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
*/
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
