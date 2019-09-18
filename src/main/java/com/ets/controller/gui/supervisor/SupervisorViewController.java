package com.ets.controller.gui.supervisor;


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
import com.ets.controller.entity.supervisor.SupervisorEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Division;
import com.ets.model.Supervisor;
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

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SupervisorViewController Class
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

public class SupervisorViewController implements Initializable {
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
	private TableView<Supervisor> supervisorTable;

	@FXML
	private TableColumn<Supervisor, String> nameCollumn;

	@FXML
	private TableColumn<Supervisor, String> identifierCollumn;

	@FXML
	private TableColumn<Supervisor, String> typeCollumn;

	@FXML
	private TableColumn<Supervisor, String> inactiveCollumn;

	@FXML
	private Button printButton;
	  @FXML
	    void enterKeyPressedForAddButton(KeyEvent event) {
         
		  if(event.getCode() == KeyCode.ENTER){
			  try {
					// Load Supervisor Details Entry form .

					String formName = formPath.context.getMessage("AddSupervisor", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.AddSupervisor", null, Locale.US);
					formPath.closeApplicationContext();
					SupervisorInputController supervisorInputController = (SupervisorInputController) new FXFormCommonUtilities()
							.displayForm(formName, formTitle);
					supervisorInputController.setSupervisorViewController(this);

				} catch (Exception ex) {
					ex.printStackTrace();
				} 
			 }
	    }

	    @FXML
	    void enterKeyPressedForChangeButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 try {
	 				// Load Supervisor Details Edit form .

	 				Supervisor supervisor = supervisorTable.getSelectionModel().getSelectedItem();

	 				String formName = formPath.context.getMessage("EditSupervisor", null, Locale.US);
	 				String formTitle = formPath.context.getMessage("Title.EditSupervisor", null, Locale.US);

	 				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
	 				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

	 				formPath.closeApplicationContext();

	 				if (supervisor != null) {

	 					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
	 					Parent root1 = (Parent) fxmlLoader.load();
	 					Stage stage = new Stage();
	 					stage.initModality(Modality.APPLICATION_MODAL);
	 					stage.setTitle(formTitle);
	 					stage.setScene(new Scene(root1));
	 					SupervisorEditController editController = fxmlLoader.getController();
	 					editController.setSupervisor(supervisor);
	 					editController.setSupervisorViewController(this);
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

	 				Integer supervi = supervisorTable.getSelectionModel().getSelectedIndex();

	 				if (supervi > -1) {
	 					Alert alert = new Alert(AlertType.CONFIRMATION);
	 					alert.setTitle(conformDialogBoxTitle);
	 					alert.setHeaderText(conformDelete);
	 					alert.setContentText(null);

	 					Optional<ButtonType> result = alert.showAndWait();
	 					if (result.get() == ButtonType.OK) {

	 						Supervisor supervisor = new SupervisorEntityController().viewSupervisor().get(supervi);
	 						new SupervisorEntityController().removeSupervisor(supervisor.getId());
	 						populateSupervisorTable(new SupervisorEntityController().viewSupervisor());

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

	    			String formTitle1 = formPath.context.getMessage("Title.Supervisor", null, Locale.US);
	    			formPath.closeApplicationContext();

	    			// Need the ProgressBar controller to access the progress bar in
	    			// this method
	    			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
	    					.displayFormAndGetController(formName1, formTitle1);
	    			ProgressBar progressBar = progressBarGUIController.getProgressBar();

	    			/********************************
	    			 * Start of Task definition
	    			 *****************************************************************/
	    			Task<ObservableList<Supervisor>> task =

	    					new Task<ObservableList<Supervisor>>() {

	    						@Override
	    						protected ObservableList<Supervisor> call() throws Exception {

	    							ObservableList<Supervisor> supervisorList = null;

	    							try {

	    								String printSupervisor = formPath.context.getMessage("Print.Supervisor", null,
	    										Locale.US);

	    								formPath.closeApplicationContext();
	    								InputStream is = new FileInputStream(new File(printSupervisor));
	    								JasperReport jasperReport = JasperCompileManager.compileReport(is);

	    								supervisorList = new SupervisorEntityController().viewSupervisor();
	    								JRDataSource JRdataSource = new JRBeanCollectionDataSource(supervisorList);
	    								Map<String, Object> map = new HashMap<String, Object>();
	    								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

	    								JasperViewer.viewReport(jasperPrint, false);

	    							} catch (Exception ex) {
	    								ex.printStackTrace();
	    							}

	    							if (isCancelled()) {
	    								return null;
	    							}
	    							return supervisorList;
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
			 }
	    }

	

	public void refreshSupervisor() {

		nameCollumn.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("fisrtName"));
		typeCollumn.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("type"));
		inactiveCollumn.setCellValueFactory(new PropertyValueFactory<Supervisor, String>("inactive"));

	}

	public void populateSupervisorTable(ObservableList<Supervisor> supervisorTableList) {
		
FilteredList<Supervisor> filteredData = new FilteredList<Supervisor>(supervisorTableList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(supervisor -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (supervisor.getFisrtName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(supervisor -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return supervisor.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<Supervisor> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(supervisorTable.comparatorProperty());
				
		supervisorTable.setItems(sortedData);
		
		//supervisorTable.setItems(supervisorTableList);
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {
				// Load Supervisor Details Edit form .

				Supervisor supervisor = supervisorTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditSupervisor", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditSupervisor", null, Locale.US);
				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				SupervisorEditController editController = fxmlLoader.getController();
				editController.setSupervisor(supervisor);
				editController.setSupervisorViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		refreshSupervisor();

		addButton.setOnAction((event) -> {
			try {
				// Load Supervisor Details Entry form .

				String formName = formPath.context.getMessage("AddSupervisor", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddSupervisor", null, Locale.US);
				formPath.closeApplicationContext();
				SupervisorInputController supervisorInputController = (SupervisorInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				supervisorInputController.setSupervisorViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {
				// Load Supervisor Details Edit form .

				Supervisor supervisor = supervisorTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditSupervisor", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditSupervisor", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (supervisor != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					SupervisorEditController editController = fxmlLoader.getController();
					editController.setSupervisor(supervisor);
					editController.setSupervisorViewController(this);
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

			// Delete Supervisor Details
			try {
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer supervi = supervisorTable.getSelectionModel().getSelectedIndex();

				if (supervi > -1) {
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						Supervisor supervisor = new SupervisorEntityController().viewSupervisor().get(supervi);
						new SupervisorEntityController().removeSupervisor(supervisor.getId());
						populateSupervisorTable(new SupervisorEntityController().viewSupervisor());

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

			String formTitle1 = formPath.context.getMessage("Title.Supervisor", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Supervisor>> task =

					new Task<ObservableList<Supervisor>>() {

						@Override
						protected ObservableList<Supervisor> call() throws Exception {

							ObservableList<Supervisor> supervisorList = null;

							try {

								String printSupervisor = formPath.context.getMessage("Print.Supervisor", null,
										Locale.US);

								formPath.closeApplicationContext();
								//InputStream is = new FileInputStream(new File(printSupervisor));
								InputStream is = this.getClass().getResourceAsStream(printSupervisor);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								supervisorList = new SupervisorEntityController().viewSupervisor();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(supervisorList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return supervisorList;
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
		
		

		topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(supervisorTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = supervisorTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(supervisorTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = supervisorTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(supervisorTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = supervisorTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(supervisorTable, tempRowCount);
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
