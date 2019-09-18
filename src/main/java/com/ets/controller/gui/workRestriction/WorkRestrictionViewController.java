package com.ets.controller.gui.workRestriction;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.departmentUnit.DepartmentUnitEntityController;
import com.ets.controller.entity.workRestriction.WorkRestrictionEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.workLocation.WorkLocationEditController;
import com.ets.model.DepartmentUnit;
import com.ets.model.JobClass;
import com.ets.model.WorkRestriction;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;

import javafx.collections.FXCollections;
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
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of WorkRestrictionViewController Class
 *Description: view.fxml Controller class
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

public class WorkRestrictionViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private TableView<WorkRestriction> workRestrictionTable;

	@FXML
	private TableColumn<WorkRestriction, String> descriptionCollumn;

	@FXML
	private TableColumn<WorkRestriction, String> codeCollumn;

	@FXML
	private Button topButton; // Table Record Top Button

	@FXML
	private Button upButton; // Table Record Up Button

	@FXML
	private Button downButton; // Table Record Down Button

	@FXML
	private Button bottomButton; // Table Record Bottom Button

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
	void doubleClicked(MouseEvent event) {

		if (event.getClickCount() == 2) {

			try {

				WorkRestriction workRestriction = workRestrictionTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditWorkRestriction", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditWorkRestriction", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				WorkRestrictionEditController editController = fxmlLoader.getController();
				editController.setWorkRestriction(workRestriction);
				editController.setWorkRestrictionViewController(this);

				stage.show();

			} catch (Exception e) {

				e.printStackTrace();
			}

		}

	}
	
	 private ObservableList<WorkRestriction> workRestrictionMasterData = FXCollections.observableArrayList();

	public void refreshWorkRestriction() {

		workRestrictionMasterData = new WorkRestrictionEntityController().view();
		
		codeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().codeProperty());
		descriptionCollumn.setCellValueFactory(cellValue -> cellValue.getValue().descrpProperty());
		
		
		FilteredList<WorkRestriction> filteredData = new FilteredList<WorkRestriction>(workRestrictionMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(workRestriction -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (workRestriction.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(workRestriction -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return workRestriction.getInactive();
					
				}

				return true;
			});

		});

		SortedList<WorkRestriction> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(workRestrictionTable.comparatorProperty());

		workRestrictionTable.setItems(sortedData);
		
		//workRestrictionTable.setItems(new WorkRestrictionEntityController().view());

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshWorkRestriction();

		addButton.setOnAction((event) -> {
			try {
				// Load and Display - EnterRestrictionType(New).fxml Form
				String formName = formPath.context.getMessage("AddWorkRestriction", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddWorkRestriction", null, Locale.US);
				formPath.closeApplicationContext();
				WorkRestrictionInputController workRestrictionInputController = (WorkRestrictionInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				workRestrictionInputController.setWorkRestrictionViewController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {

			try {

				WorkRestriction workRestriction = workRestrictionTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditWorkRestriction", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditWorkRestriction", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (workRestriction != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					WorkRestrictionEditController editController = fxmlLoader.getController();
					editController.setWorkRestriction(workRestriction);
					editController.setWorkRestrictionViewController(this);

					stage.show();

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();

				}

			} catch (Exception e) {

				e.printStackTrace();
			}

		});

		deleteButton.setOnAction((event) -> {

			try {
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer workRestrictionSelectedIndex = workRestrictionTable.getSelectionModel().getSelectedIndex();

				if (workRestrictionSelectedIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();

					if (result.get() == ButtonType.OK) {

						WorkRestriction workRestriction = new WorkRestrictionEntityController().view()
								.get(workRestrictionSelectedIndex);
						new WorkRestrictionEntityController().delete(workRestriction.getId());
						refreshWorkRestriction();

					} else {

					}

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(deleteInfo);

					alert.showAndWait();

				}

			} catch (Exception e) {

				e.printStackTrace();

			}
		});

		/*************************************
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.WorkRestriction", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<WorkRestriction>> task =

					new Task<ObservableList<WorkRestriction>>() {
						@Override
						protected ObservableList<WorkRestriction> call() throws Exception {

							ObservableList<WorkRestriction> departmentUnitList = null;

							try {

								String printDivision = formPath.context.getMessage("Print.WorkRestriction", null,
										Locale.US);
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printDivision));
								InputStream is = this.getClass().getResourceAsStream(printDivision);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								departmentUnitList = new WorkRestrictionEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(departmentUnitList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return departmentUnitList;
						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of printBtn.setOnAction(..)
		 *************************************************************/

		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(workRestrictionTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = workRestrictionTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(workRestrictionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = workRestrictionTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(workRestrictionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = workRestrictionTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(workRestrictionTable, tempRowCount);
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
	}
}