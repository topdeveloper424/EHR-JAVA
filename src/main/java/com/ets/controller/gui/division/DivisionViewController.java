package com.ets.controller.gui.division;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import com.ets.controller.entity.division.DivisionEntityController;
import com.ets.controller.gui.departmentUnit.DepartmentUnitEditController;
import com.ets.controller.gui.departmentUnit.DepartmentUnitInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.DepartmentUnit;
import com.ets.model.Division;
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
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 15-02-2016 
 * Initial Version: 0.01 
 * Module Name: Parameter
 * Definition: Type object of DivisionViewController Class 
 * Description: View.fxml Controller class 
 * Copyright 2016 @Eclipse Technoconsulting Global  Pvt. Ltd.
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

public class DivisionViewController implements Initializable {

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
	private Button pageDownBtn;

	@FXML
	private Button buttomButton;

	@FXML
	private TableView<Division> divisionTable;

	@FXML
	private TableColumn<Division, String> descriptionCollumn;

	@FXML
	private TableColumn<Division, String> codeCollumn;

	@FXML
	private Button printButton;

	@FXML
	private Button selectButton;

    @FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
    	 if(event.getCode() == KeyCode.ENTER){
    		 try {

 				String formName = formPath.context.getMessage("AddDivision", null, Locale.US);
 				String formTitle = formPath.context.getMessage("Title.AddDivision", null, Locale.US);
 				formPath.closeApplicationContext();
 				DivisionInputController divisionInputController = (DivisionInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				divisionInputController.setDivisionViewController(this);

 			} catch (Exception ex) {
 				ex.printStackTrace();
 			}
    	 }
    }

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
    	 if(event.getCode() == KeyCode.ENTER){
    		 try {

 				Division division = divisionTable.getSelectionModel().getSelectedItem();

 				String formName = formPath.context.getMessage("EditDivision", null, Locale.US);
 				String formTitle = formPath.context.getMessage("Title.EditDivision", null, Locale.US);

 				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
 				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
 				formPath.closeApplicationContext();

 				if (division != null) {

 					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
 					Parent root1 = (Parent) fxmlLoader.load();
 					Stage stage = new Stage();
 					stage.initModality(Modality.APPLICATION_MODAL);
 					stage.setTitle(formTitle);
 					stage.setScene(new Scene(root1));
 					DivisionEditController editController = fxmlLoader.getController();
 					editController.setDivision(division);
 					editController.setDivisionViewController(this);
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

				Integer div = divisionTable.getSelectionModel().getSelectedIndex();
				if (div > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						Division division = new DivisionEntityController().viewDivision().get(div);
						new DivisionEntityController().removeDivision(division.getId());
						populateDivisionTable(new DivisionEntityController().viewDivision());
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

  			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Division", null, Locale.US);
  			formPath.closeApplicationContext();

  			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
  					.displayFormAndGetController(formName1, formTitle1);
  			ProgressBar progressBar = progressBarGUIController.getProgressBar();

  			/********************************
  			 * Start of Task definition
  			 *****************************************************************/
  			Task<ObservableList<Division>> task =

  					new Task<ObservableList<Division>>() {
  						@Override
  						protected ObservableList<Division> call() throws Exception {

  							ObservableList<Division> divisionList = null;

  							try {

  								String printDivision = formPath.context.getMessage("Print.Division", null, Locale.US);
  								formPath.closeApplicationContext();
  								InputStream is = new FileInputStream(new File(printDivision));
  								JasperReport jasperReport = JasperCompileManager.compileReport(is);

  								divisionList = new DivisionEntityController().viewDivision();
  								JRDataSource JRdataSource = new JRBeanCollectionDataSource(divisionList);
  								Map<String, Object> map = new HashMap<String, Object>();
  								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

  								JasperViewer.viewReport(jasperPrint, false);

  							} catch (Exception ex) {
  								ex.printStackTrace();
  							}

  							if (isCancelled()) {
  								return null;
  							}
  							return divisionList;
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
    void enterKeyPressedForSelectButton(KeyEvent event) {
      if(event.getCode() == KeyCode.ENTER){
    	  Division selectedDivision = this.divisionTable.getSelectionModel().getSelectedItem();
			
			if(predecessorController != null){
				
				this.predecessorController.setdDeptUnitTextBox(selectedDivision.getCode());
				
			}else if (departmentUnitEditController != null) {
				
				departmentUnitEditController.setdDeptUnitTextBox(selectedDivision.getCode());
			}
					
				new FXFormCommonUtilities().closeForm(selectButton);
			  
    	 }
    }

	private DepartmentUnitInputController predecessorController;

	public void setPredecessorFormController(DepartmentUnitInputController predecessorController) {
		this.predecessorController = predecessorController;
	}
	
	private DepartmentUnitEditController departmentUnitEditController;
		
	public void setDepartmentUnitEditController(DepartmentUnitEditController departmentUnitEditController) {
		this.departmentUnitEditController = departmentUnitEditController;
	}

	public void showSelectButton(){
		selectButton.setVisible(true);
		
		
	}
	
	public void hideSelectButton(){
		selectButton.setVisible(false);
	}
	

	public void refreshDivision() {
		
		// codeCollumn.setCellValueFactory(new PropertyValueFactory<Division,
		// String>("code"));
		// descriptionCollumn.setCellValueFactory(new
		// PropertyValueFactory<Division, String>("descrip"));
		codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().descripProperty());

	}

	public void populateDivisionTable(ObservableList<Division> divisionTableList) {
		
FilteredList<Division> filteredData = new FilteredList<Division>(divisionTableList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(division -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (division.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(division -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return division.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<Division> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(divisionTable.comparatorProperty());
				
		divisionTable.setItems(sortedData);
		//divisionTable.setItems(divisionTableList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {

				Division division = divisionTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditDivision", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDivision", null, Locale.US);

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				DivisionEditController editController = fxmlLoader.getController();
				editController.setDivision(division);
				editController.setDivisionViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {
	
		hideSelectButton();
		refreshDivision();
		
		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddDivision", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddDivision", null, Locale.US);
				formPath.closeApplicationContext();
				DivisionInputController divisionInputController = (DivisionInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				divisionInputController.setDivisionViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				Division division = divisionTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditDivision", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDivision", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (division != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					DivisionEditController editController = fxmlLoader.getController();
					editController.setDivision(division);
					editController.setDivisionViewController(this);
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

			try {
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer div = divisionTable.getSelectionModel().getSelectedIndex();
				if (div > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						Division division = new DivisionEntityController().viewDivision().get(div);
						new DivisionEntityController().removeDivision(division.getId());
						populateDivisionTable(new DivisionEntityController().viewDivision());
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

		selectButton.setOnAction((event) -> {
			Division selectedDivision = this.divisionTable.getSelectionModel().getSelectedItem();
			
			if(predecessorController != null){
				
				this.predecessorController.setdDeptUnitTextBox(selectedDivision.getCode());
				
			}else if (departmentUnitEditController != null) {
				
				departmentUnitEditController.setdDeptUnitTextBox(selectedDivision.getCode());
			}
					
				new FXFormCommonUtilities().closeForm(selectButton);
			

		});

		/*************************************
		 * Start of PrintBtn.setOnAction(..)
		 *****************************************************/

		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Division", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Division>> task =

					new Task<ObservableList<Division>>() {
						@Override
						protected ObservableList<Division> call() throws Exception {

							ObservableList<Division> divisionList = null;

							try {

								String printDivision = formPath.context.getMessage("Print.Division", null, Locale.US);
								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printDivision));
								InputStream is = this.getClass().getResourceAsStream(printDivision);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								divisionList = new DivisionEntityController().viewDivision();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(divisionList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return divisionList;
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

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(divisionTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = divisionTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(divisionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = divisionTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(divisionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		pageDownBtn.setOnAction((event) -> {
			try {
				Integer selectedIndex = divisionTable.getSelectionModel().getSelectedIndex();
				selectedIndex = selectedIndex + 11;
				UIRecordNavigation.setPosition(divisionTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = divisionTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(divisionTable, tempRowCount);
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
