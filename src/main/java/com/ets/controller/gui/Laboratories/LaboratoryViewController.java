package com.ets.controller.gui.Laboratories;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllLaboratoryController Class
 *Description: SelectLaboratory.fxml Controller class
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

import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.laboratory.LaboratoryEntityController;
import com.ets.controller.entity.tpa.TpaEntityController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.drugScreen.DrugScreenResultInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.provider.ProviderEditController;
import com.ets.model.Carrier;
import com.ets.model.Laboratory;
import com.ets.model.Provider;
import com.ets.model.Tpa;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

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

public class LaboratoryViewController implements Initializable {

	@FXML
    private TextField searchTextField;

    @FXML
    private CheckBox includeInactiveCheckBox;

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
    private Button bottomButton;

    @FXML
    private TableView<Laboratory> laboratoryTable;

    @FXML
    private TableColumn<Laboratory, String> labNameCollumn;

    @FXML
    private TableColumn<Laboratory, String> codeCollumn;

    @FXML
    private TableColumn<Laboratory, String> cityCollumn;

    @FXML
    private TableColumn<Laboratory, String> stateCollumn;

    @FXML
    private TableColumn<Laboratory, String> telephoneCollumn;

    @FXML
    private TableColumn<Laboratory, String> faxCollumn;

    @FXML
    private Button printButton;
    
    @FXML
    private Button selectBtn;

    
    private DrugScreenResultInputController drugScreenResultInputController;
    
    public void setDrugScreenResultInputController(DrugScreenResultInputController drugScreenResultInputController) {
		this.drugScreenResultInputController = drugScreenResultInputController;
	}
    
    private CompanyInputController companyInputController;

	public void setCompanyInputController(CompanyInputController companyInputController) {
		this.companyInputController = companyInputController;
	}
	
	private CompanyEditController companyEditController;
	
	public void setCompanyEditController(CompanyEditController companyEditController) {
		this.companyEditController = companyEditController;
	}

	@FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			// Load Laboratory Details Entry form .

			String formName = formPath.context.getMessage("AddLaboratory", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddLaboratory", null, Locale.US);
			formPath.closeApplicationContext();
			
			LaboratoryInputController laboratoryInputController = 
			(LaboratoryInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			laboratoryInputController.setLaboratoryViewController(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}
    }

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			// Load Region Details Edit form .

			Laboratory laboratory = laboratoryTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditLaboratory", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditLaboratory", null, Locale.US);


			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			formPath.closeApplicationContext();

			if (laboratory != null) {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				LaboratoryEditController editController = fxmlLoader.getController();
				editController.setLaboratory(laboratory);
				editController.setLaboratoryViewController(this);
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

    }}

    @FXML
    void enterKeyPressedForCloseButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			new FXFormCommonUtilities().closeForm(closeButton);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
    }}

    @FXML
    void enterKeyPressedForDeleteButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer laboratoryIndex = laboratoryTable.getSelectionModel().getSelectedIndex();

				if (laboratoryIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						Laboratory laboratory = new LaboratoryEntityController().view().get(laboratoryIndex);
						
						new LaboratoryEntityController().delete(laboratory.getId());
						
						viewLaboratory();

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
    		
    	}
    }

    
    @FXML
    void doubleClick(MouseEvent event) {
    	
    	if (event.getClickCount() == 2) {
			try {
				Laboratory laboratory = laboratoryTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditLaboratory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditLaboratory", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				LaboratoryEditController editController = fxmlLoader.getController();
				editController.setLaboratory(laboratory);
				editController.setLaboratoryViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}


    }
    
    private ObservableList<Laboratory> laboratoryMasterData = FXCollections.observableArrayList();
	
	public void viewLaboratory(){
		
		laboratoryMasterData = new LaboratoryEntityController().view();
		
		labNameCollumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		    	
    	codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
    	cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
    	
    	stateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
    	telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());
    	faxCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().faxProperty());
    	
    	
    	FilteredList<Laboratory> filteredData = new FilteredList<Laboratory>(laboratoryMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(laboratory -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (laboratory.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(laboratory -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return laboratory.getInactive();
					
				}

				return true;
			});

		});

		SortedList<Laboratory> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(laboratoryTable.comparatorProperty());

		laboratoryTable.setItems(sortedData);
    	    		
				
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resource) {

		viewLaboratory();
		
		addButton.setOnAction((event) -> {
			try {
				// Load Laboratory Details Entry form .

				String formName = formPath.context.getMessage("AddLaboratory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddLaboratory", null, Locale.US);
				formPath.closeApplicationContext();
				
				LaboratoryInputController laboratoryInputController = 
				(LaboratoryInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				laboratoryInputController.setLaboratoryViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				// Load Region Details Edit form .

				Laboratory laboratory = laboratoryTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditLaboratory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditLaboratory", null, Locale.US);


				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (laboratory != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					LaboratoryEditController editController = fxmlLoader.getController();
					editController.setLaboratory(laboratory);
					editController.setLaboratoryViewController(this);
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
		
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Laboratory", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Laboratory>> task =

					new Task<ObservableList<Laboratory>>() {

						@Override
						protected ObservableList<Laboratory> call() throws Exception {

							ObservableList<Laboratory> laboratoryList = null;

							try {

								System.out.println("Generating PDF...");

								String printLaboratory= formPath.context.getMessage("Print.Laboratory", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printLaboratory));
								InputStream is = this.getClass().getResourceAsStream(printLaboratory);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								laboratoryList =new LaboratoryEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(laboratoryList);
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
							return laboratoryList;

						}
					};
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
		
		deleteButton.setOnAction((event) -> {

			// Delete TPA Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer laboratoryIndex = laboratoryTable.getSelectionModel().getSelectedIndex();

				if (laboratoryIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						Laboratory laboratory = new LaboratoryEntityController().view().get(laboratoryIndex);
						
						new LaboratoryEntityController().delete(laboratory.getId());
						
						viewLaboratory();

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
		
		selectBtn.setOnAction((event) -> {
			
			Laboratory laboratory = laboratoryTable.getSelectionModel().getSelectedItem();
			if(drugScreenResultInputController != null){
				
				drugScreenResultInputController.setlaboratory(laboratory.getCode());
			}else if(companyInputController != null){
				
				companyInputController.setLaboratory(laboratory.getCode());
				
			}
			new FXFormCommonUtilities().closeForm(selectBtn);
			
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
