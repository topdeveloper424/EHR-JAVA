package com.ets.controller.gui.departmentUnit;

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
import com.ets.controller.entity.division.DivisionEntityController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.DepartmentUnit;
import com.ets.model.Division;
import com.ets.model.Provider;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
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
 * Creation Date: 25-07-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DepartmentUnitViewController Class Description:
 * view.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class DepartmentUnitViewController implements Initializable {

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
	private TableView<DepartmentUnit> departmentUnitTable;

	@FXML
	private TableColumn<DepartmentUnit, String> descriptionCollumn;

	@FXML
	private TableColumn<DepartmentUnit, String> codeCollumn;

	@FXML
	private TableColumn<DepartmentUnit, String> divisionCollumn;

	@FXML
	private Button printButton;
	
	@FXML
    private Button selectButton;

	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				// Load Department Unit Details Entry form .
				String formName = formPath.context.getMessage("AddDepartmentUnitView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddDepartmentUnitView", null, Locale.US);
				formPath.closeApplicationContext();
				DepartmentUnitInputController departmentUnitInputController = (DepartmentUnitInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				departmentUnitInputController.setDepartmentUnitViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}
	}

	@FXML
	void enterKeyPressedForChangeButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				// Load Cmplex Details Edit form .

				String formName = formPath.context.getMessage("EditDepartmentUnit", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDepartmentUnit", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				DepartmentUnit departmentUnit = departmentUnitTable.getSelectionModel().getSelectedItem();

				if (departmentUnit != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					DepartmentUnitEditController editController = fxmlLoader.getController();
					editController.setDepartmentUnit(departmentUnit);
					editController.setDepartmentUnitViewController(this);
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
	}

	@FXML
	void enterKeyPressedForCloseButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@FXML
	void enterKeyPressedForDeleteButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				// Load Department Unit Details Entry form .
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer deptUnit = departmentUnitTable.getSelectionModel().getSelectedIndex();

				if (deptUnit > -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						DepartmentUnit departmentUnit = new DepartmentUnitEntityController().viewDepartmentUnit()
								.get(deptUnit);
						new DepartmentUnitEntityController().deleteDepartmentUnit(departmentUnit.getId());
						viewDepartmentUnit();
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
	}

	@FXML
	void enterKeyPressedForPrintButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.DepartmentUnit", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<DepartmentUnit>> task =

					new Task<ObservableList<DepartmentUnit>>() {
						@Override
						protected ObservableList<DepartmentUnit> call() throws Exception {

							ObservableList<DepartmentUnit> departmentUnitList = null;

							try {

								String printDivision = formPath.context.getMessage("Print.DepartmentUnit", null,
										Locale.US);
								formPath.closeApplicationContext();
								InputStream is = new FileInputStream(new File(printDivision));
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								departmentUnitList = new DepartmentUnitEntityController().viewDepartmentUnit();
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
		}
	}

	@FXML
	void doubleClicked(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Cmplex Details Edit form .

				String formName = formPath.context.getMessage("EditDepartmentUnit", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDepartmentUnit", null, Locale.US);

				formPath.closeApplicationContext();

				DepartmentUnit departmentUnit = departmentUnitTable.getSelectionModel().getSelectedItem();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				DepartmentUnitEditController editController = fxmlLoader.getController();
				editController.setDepartmentUnit(departmentUnit);
				editController.setDepartmentUnitViewController(this);
				stage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	private ObservableList<DepartmentUnit> departmentUnitMasterData = FXCollections.observableArrayList();

	public void viewDepartmentUnit() {

		departmentUnitMasterData = new DepartmentUnitEntityController().viewDepartmentUnit();

		codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().descripProperty());
		divisionCollumn.setCellValueFactory(cellData -> cellData.getValue().getDivision().codeProperty());

		FilteredList<DepartmentUnit> filteredData = new FilteredList<DepartmentUnit>(departmentUnitMasterData,
				p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(departmentUnit -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (departmentUnit.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(departmentUnit -> {

				if (inactiveCheckBox.isSelected()) {

					return departmentUnit.getInactive();

				}

				return true;
			});

		});

		SortedList<DepartmentUnit> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(departmentUnitTable.comparatorProperty());

		departmentUnitTable.setItems(sortedData);

		// departmentUnitTable.setItems(new
		// DepartmentUnitEntityController().viewDepartmentUnit());

	}

	FXMLFormPath formPath = new FXMLFormPath();
	
	private CompanyProtocolInputController companyProtocolInputController;

	public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController) {
		this.companyProtocolInputController = companyProtocolInputController;
	}
	
	private CompanyProtocolEditController companyProtocolEditController;
	
	public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController) {
		this.companyProtocolEditController = companyProtocolEditController;
	}
	

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		viewDepartmentUnit();
		
		selectButton.setOnAction((event) -> {
			
			DepartmentUnit departmentUnitSelected = departmentUnitTable.getSelectionModel().getSelectedItem();
			
			if(companyProtocolInputController != null){
				
				companyProtocolInputController.setDepartmentUnitCode(departmentUnitSelected.getCode());
				
			}else if(companyProtocolEditController != null){
				
				companyProtocolEditController.setDepartmentUnitCode(departmentUnitSelected);
				
			}
			
			new FXFormCommonUtilities().closeForm(selectButton);
			
		});

		addButton.setOnAction((event) -> {
			try {
				// Load Department Unit Details Entry form .
				String formName = formPath.context.getMessage("AddDepartmentUnitView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddDepartmentUnitView", null, Locale.US);
				formPath.closeApplicationContext();
				DepartmentUnitInputController departmentUnitInputController = (DepartmentUnitInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				departmentUnitInputController.setDepartmentUnitViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		deleteButton.setOnAction((event) -> {
			try {
				// Load Department Unit Details Entry form .
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer deptUnit = departmentUnitTable.getSelectionModel().getSelectedIndex();

				if (deptUnit > -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						DepartmentUnit departmentUnit = new DepartmentUnitEntityController().viewDepartmentUnit()
								.get(deptUnit);
						new DepartmentUnitEntityController().deleteDepartmentUnit(departmentUnit.getId());
						viewDepartmentUnit();
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
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.DepartmentUnit", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<DepartmentUnit>> task =

					new Task<ObservableList<DepartmentUnit>>() {
						@Override
						protected ObservableList<DepartmentUnit> call() throws Exception {

							ObservableList<DepartmentUnit> departmentUnitList = null;

							try {

								String printDivision = formPath.context.getMessage("Print.DepartmentUnit", null,
										Locale.US);
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printDivision));
								InputStream is = this.getClass().getResourceAsStream(printDivision);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								departmentUnitList = new DepartmentUnitEntityController().viewDepartmentUnit();
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

	/*	topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(departmentUnitTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = departmentUnitTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(departmentUnitTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = departmentUnitTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(departmentUnitTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = departmentUnitTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(departmentUnitTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		changeButton.setOnAction((event) -> {
			try {
				// Load Cmplex Details Edit form .

				String formName = formPath.context.getMessage("EditDepartmentUnit", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDepartmentUnit", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				DepartmentUnit departmentUnit = departmentUnitTable.getSelectionModel().getSelectedItem();

				if (departmentUnit != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					DepartmentUnitEditController editController = fxmlLoader.getController();
					editController.setDepartmentUnit(departmentUnit);
					editController.setDepartmentUnitViewController(this);
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
