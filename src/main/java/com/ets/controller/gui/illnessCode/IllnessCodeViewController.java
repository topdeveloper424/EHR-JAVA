package com.ets.controller.gui.illnessCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllIllnessCodeController Class
 *Description: ViewAllIllnessCode.fxml Controller class
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

import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.illnessCode.IllnessCodeEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.IllnessCode;
import com.ets.model.InjuryCode;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
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

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 08-02-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of IllnessCodeViewController Class Description:
 * View.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class IllnessCodeViewController implements Initializable {

	@FXML
	private TextField searchTextField;

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
	private TableView<IllnessCode> illnessTable;

	@FXML
	private TableColumn<IllnessCode, String> descriptionCollumn;

	@FXML
	private TableColumn<IllnessCode, String> codeCollumn;

	@FXML
	private TableColumn<IllnessCode, String> wc10Collumn;

	@FXML
	private Button printButton;

	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		try {
			// Load Illness Code Details Entry form .

			String formName = formPath.context.getMessage("AddIllnessCode", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddIllnessCode", null, Locale.US);
			formPath.closeApplicationContext();
			IllnessCodeInputController illnessCodeInputController = (IllnessCodeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			illnessCodeInputController.setIllnessCodeViewController(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		try {
			// Load Illness Code Details Update form .
			
			IllnessCode illnessCode = illnessTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditIllnessCode", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditIllnessCode", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			if (illnessCode != null) {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				IllnessCodeEditController controller = fxmlLoader.getController();
				controller.setIllnessCode(illnessCode);
				controller.setIllnessCodeViewController(this);
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
		// Delete IllnessCode Details

		try {
			String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
			String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

			formPath.closeApplicationContext();

			Integer illness = illnessTable.getSelectionModel().getSelectedIndex();

			if (illness > -1) {
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {

					IllnessCode ill = new IllnessCodeEntityController().viewIllnessCode().get(illness);
					new IllnessCodeEntityController().removeIllnessCode(ill.getId());
					populateIllnessTable(new IllnessCodeEntityController().viewIllnessCode());
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

	@FXML
	void enterKeyPressedForPrintButton(KeyEvent event) {
		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

		String formTitle1 = formPath.context.getMessage("Title.Division", null, Locale.US);
		formPath.closeApplicationContext();

		// Need the ProgressBar controller to access the progress bar in
		// this method
		ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities().displayFormAndGetController(formName1, formTitle1);
		ProgressBar progressBar = progressBarGUIController.getProgressBar();

		/********************************
		 * Start of Task definition
		 *****************************************************************/
		Task<ObservableList<IllnessCode>> task =

				new Task<ObservableList<IllnessCode>>() {

					@Override
					protected ObservableList<IllnessCode> call() throws Exception {

						ObservableList<IllnessCode> illnessCodeList = null;
						try {
							String printIllnessCode = formPath.context.getMessage("Print.IllnessCode", null, Locale.US);
							formPath.closeApplicationContext();
						//	InputStream is = new FileInputStream(new File(printIllnessCode));
							InputStream is = this.getClass().getResourceAsStream(printIllnessCode);
							JasperReport jasperReport = JasperCompileManager.compileReport(is);
							illnessCodeList = new IllnessCodeEntityController().viewIllnessCode();
							JRDataSource JRdataSource = new JRBeanCollectionDataSource(illnessCodeList);
							Map<String, Object> map = new HashMap<String, Object>();
							JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

							JasperViewer.viewReport(jasperPrint, false);
						} catch (Exception ex) {
							ex.printStackTrace();
						}

						if (isCancelled()) {
							return null;
						}
						
						return illnessCodeList;
					}
				};
		/*************************
		 * End of Task definition
		 *****************************************************************/

		task.setOnSucceeded(event1 -> {
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
	}

	public void refreshIllnessCode() {

		codeCollumn.setCellValueFactory(new PropertyValueFactory<IllnessCode, String>("code"));
		descriptionCollumn.setCellValueFactory(new PropertyValueFactory<IllnessCode, String>("descrp"));
		wc10Collumn.setCellValueFactory(new PropertyValueFactory<IllnessCode, String>("wc10Code"));
	}

	public void populateIllnessTable(ObservableList<IllnessCode> illnessCodeList) {

		FilteredList<IllnessCode> filteredData = new FilteredList<IllnessCode>(illnessCodeList, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(illnessCode -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (illnessCode.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(illnessCode -> {

				if (inactiveCheckBox.isSelected()) {

					return illnessCode.getInactive();

				}

				return true;
			});

		});

		SortedList<IllnessCode> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(illnessTable.comparatorProperty());

		illnessTable.setItems(sortedData);

		// illnessTable.setItems(illnessCodeList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				IllnessCode illnessCode = illnessTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditIllnessCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditIllnessCode", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				IllnessCodeEditController controller = fxmlLoader.getController();
				controller.setIllnessCode(illnessCode);
				controller.setIllnessCodeViewController(this);
				stage.show();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshIllnessCode();

		addButton.setOnAction((event) -> {
			try {
				// Load Illness Code Details Entry form .

				String formName = formPath.context.getMessage("AddIllnessCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddIllnessCode", null, Locale.US);
				formPath.closeApplicationContext();
				IllnessCodeInputController illnessCodeInputController = (IllnessCodeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				illnessCodeInputController.setIllnessCodeViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				// Load Illness Code Details Update form .

				IllnessCode illnessCode = illnessTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditIllnessCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditIllnessCode", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (illnessCode != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					IllnessCodeEditController controller = fxmlLoader.getController();
					controller.setIllnessCode(illnessCode);
					controller.setIllnessCodeViewController(this);
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

			// Delete IllnessCode Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer illness = illnessTable.getSelectionModel().getSelectedIndex();

				if (illness > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						IllnessCode ill = new IllnessCodeEntityController().viewIllnessCode().get(illness);
						new IllnessCodeEntityController().removeIllnessCode(ill.getId());
						populateIllnessTable(new IllnessCodeEntityController().viewIllnessCode());

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
				UIRecordNavigation.setPosition(illnessTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = illnessTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(illnessTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = illnessTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(illnessTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = illnessTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(illnessTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*************************************
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Division", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities().displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<IllnessCode>> task =

					new Task<ObservableList<IllnessCode>>() {

						@Override
						protected ObservableList<IllnessCode> call() throws Exception {

							ObservableList<IllnessCode> illnessCodeList = null;
							try {

								String printIllnessCode = formPath.context.getMessage("Print.IllnessCode", null, Locale.US);
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printIllnessCode));
								InputStream is = this.getClass().getResourceAsStream(printIllnessCode);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);
								illnessCodeList = new IllnessCodeEntityController().viewIllnessCode();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(illnessCodeList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return illnessCodeList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

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
		 * End of printBtn.setOnAction(..)
		 *************************************************************/

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
