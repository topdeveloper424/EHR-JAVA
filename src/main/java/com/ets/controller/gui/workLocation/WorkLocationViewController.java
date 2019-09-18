package com.ets.controller.gui.workLocation;

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
import com.ets.controller.entity.workLocation.WorkLocationEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.DepartmentUnit;
import com.ets.model.JobClass;
import com.ets.model.WorkLocation;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
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
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company 
 * File Creation Date: 26-07-2016 
 * Initial Version: 0.01 
 * Module Name: Parameter
 * Definition: Type object of WorkLocationViewController Class 
 * Description: view.fxml Controller class 
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: 
 * Owner: 
 * Date: 
 * Version: 
 * Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class WorkLocationViewController implements Initializable {

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
	private TableView<WorkLocation> workLocationTable;

	@FXML
	private TableColumn<WorkLocation, String> descriptionCollumn;

	@FXML
	private TableColumn<WorkLocation, String> codeCollumn;

	@FXML
	private Button printButton;
	  @FXML
	    void enterKeyPressedForAddButton(KeyEvent event) {
		  if(event.getCode() == KeyCode.ENTER){
			  try {
					// Load Work Location Details Entry form .

					String formName = formPath.context.getMessage("AddWorkLocation", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddWorkLocation", null, Locale.US);
					formPath.closeApplicationContext();
					WorkLocationInputController workLocationInputController = (WorkLocationInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					workLocationInputController.setWorkLocationViewController(this);

				} catch (Exception ex) {
					ex.printStackTrace();
				} 
		  }
	    }

	    @FXML
	    void enterKeyPressedForChangeButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    			try {

	    				WorkLocation workLocation = workLocationTable.getSelectionModel().getSelectedItem();

	    				String formName = formPath.context.getMessage("EditWorkLocation", null, Locale.US);
	    				String formTitle = formPath.context.getMessage("Title.EditWorkLocation", null, Locale.US);

	    				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
	    				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

	    				formPath.closeApplicationContext();

	    				if (workLocation != null) {

	    					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
	    					Parent root1 = (Parent) fxmlLoader.load();
	    					Stage stage = new Stage();
	    					stage.initModality(Modality.APPLICATION_MODAL);
	    					stage.setTitle(formTitle);
	    					stage.setScene(new Scene(root1));
	    					WorkLocationEditController editController = fxmlLoader.getController();
	    					editController.setWorkLocation(workLocation);
	    					editController.setWorkLocationViewController(this);

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
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 try {
	 				new FXFormCommonUtilities().closeForm(closeButton);
	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			} 
	    	 }
	    }

	    @FXML
	    void enterKeyPressedForDeleteButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 try {

	 				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
	 				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
	 				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
	 				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

	 				formPath.closeApplicationContext();

	 				Integer workLocationIndex = workLocationTable.getSelectionModel().getSelectedIndex();

	 				if (workLocationIndex > -1) {
	 					Alert alert = new Alert(AlertType.CONFIRMATION);
	 					alert.setTitle(conformDialogBoxTitle);
	 					alert.setHeaderText(conformDelete);
	 					alert.setContentText(null);

	 					Optional<ButtonType> result = alert.showAndWait();
	 					if (result.get() == ButtonType.OK) {
	 						WorkLocation workLocation = new WorkLocationEntityController().view().get(workLocationIndex);
	 						new WorkLocationEntityController().delete(workLocation.getId());
	 						viewWorkLocation();

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
	    	 if(event.getCode() == KeyCode.ENTER){

	 			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

	 			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.WorkLocation", null, Locale.US);
	 			formPath.closeApplicationContext();

	 			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
	 					.displayFormAndGetController(formName1, formTitle1);
	 			ProgressBar progressBar = progressBarGUIController.getProgressBar();

	 			/********************************
	 			 * Start of Task definition
	 			 *****************************************************************/
	 			Task<ObservableList<WorkLocation>> task =

	 					new Task<ObservableList<WorkLocation>>() {
	 						@Override
	 						protected ObservableList<WorkLocation> call() throws Exception {

	 							ObservableList<WorkLocation> workLocationList = null;

	 							try {

	 								String printDivision = formPath.context.getMessage("Print.WorkLocation", null, Locale.US);
	 								formPath.closeApplicationContext();
	 								InputStream is = new FileInputStream(new File(printDivision));
	 								JasperReport jasperReport = JasperCompileManager.compileReport(is);

	 								workLocationList = new WorkLocationEntityController().view();
	 								JRDataSource JRdataSource = new JRBeanCollectionDataSource(workLocationList);
	 								Map<String, Object> map = new HashMap<String, Object>();
	 								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

	 								JasperViewer.viewReport(jasperPrint, false);

	 							} catch (Exception ex) {
	 								ex.printStackTrace();
	 							}

	 							if (isCancelled()) {
	 								return null;
	 							}
	 							return workLocationList;
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

				WorkLocation workLocation = workLocationTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditWorkLocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditWorkLocation", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				WorkLocationEditController editController = fxmlLoader.getController();
				editController.setWorkLocation(workLocation);
				editController.setWorkLocationViewController(this);

				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		}

	}

	FXMLFormPath formPath = new FXMLFormPath();
	
	 private ObservableList<WorkLocation> workLocationMasterData = FXCollections.observableArrayList();

	public void viewWorkLocation() {

		workLocationMasterData = new WorkLocationEntityController().view();
		
		codeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().codeProperty());
		descriptionCollumn.setCellValueFactory(cellValue -> cellValue.getValue().descrpProperty());
		
		FilteredList<WorkLocation> filteredData = new FilteredList<WorkLocation>(workLocationMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(workLocation -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (workLocation.getDescrp().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(workLocation -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return workLocation.getInactive();
					
				}

				return true;
			});

		});

		SortedList<WorkLocation> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(workLocationTable.comparatorProperty());

		workLocationTable.setItems(sortedData);

		//workLocationTable.setItems(new WorkLocationEntityController().view());
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		viewWorkLocation();

		addButton.setOnAction((event) -> {
			try {
				// Load Work Location Details Entry form .

				String formName = formPath.context.getMessage("AddWorkLocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddWorkLocation", null, Locale.US);
				formPath.closeApplicationContext();
				WorkLocationInputController workLocationInputController = (WorkLocationInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				workLocationInputController.setWorkLocationViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {

			try {

				WorkLocation workLocation = workLocationTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditWorkLocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditWorkLocation", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (workLocation != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					WorkLocationEditController editController = fxmlLoader.getController();
					editController.setWorkLocation(workLocation);
					editController.setWorkLocationViewController(this);

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
		deleteButton.setOnAction((event) -> {

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer workLocationIndex = workLocationTable.getSelectionModel().getSelectedIndex();

				if (workLocationIndex > -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						WorkLocation workLocation = new WorkLocationEntityController().view().get(workLocationIndex);
						new WorkLocationEntityController().delete(workLocation.getId());
						viewWorkLocation();

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

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.WorkLocation", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<WorkLocation>> task =

					new Task<ObservableList<WorkLocation>>() {
						@Override
						protected ObservableList<WorkLocation> call() throws Exception {

							ObservableList<WorkLocation> workLocationList = null;

							try {

								String printDivision = formPath.context.getMessage("Print.WorkLocation", null, Locale.US);
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printDivision));
								InputStream is = this.getClass().getResourceAsStream(printDivision);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								workLocationList = new WorkLocationEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(workLocationList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return workLocationList;
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
/*
		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(workLocationTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = workLocationTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(workLocationTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = workLocationTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(workLocationTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = workLocationTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(workLocationTable, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
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
