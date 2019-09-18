package com.ets.controller.gui.mcoTpaBillPreview;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ViewAllCompMcoTpaBillController Class
 *Description: SelectCompMCOTPAOrBillReviewOrganization.fxml Controller class
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
import com.ets.controller.entity.tpa.TpaEntityController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.provider.ProviderEditController;
import com.ets.model.Carrier;
import com.ets.model.Clinic;
import com.ets.model.Contact;
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

public class McoTpaBillViewController implements Initializable {

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
    private TableColumn<Tpa, String> managedCareCollumn;

    @FXML
    private TableColumn<Tpa, String> codeCollumn;

    @FXML
    private TableColumn<Tpa, String> cityCollumn;

    @FXML
    private TableColumn<Tpa, String> stateCollumn;

    @FXML
    private TableColumn<Tpa, String> emailCollumn;

    @FXML
    private TableColumn<Tpa, String> addressCollumn;

    @FXML
    private TableColumn<Tpa, String> telephoneCollumn;

    @FXML
    private TableColumn<Tpa, String> faxCollumn;
    
    @FXML
    private TableView<Tpa> tpaTable;

    @FXML
    private Button printButton;
    
    @FXML
    private Button selectButton;
    @FXML
    void enterKeyPressedForAddButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {

			String formName = formPath.context.getMessage("AddMCOOrTPA", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddMCOOrTPA", null, Locale.US);
			formPath.closeApplicationContext();
			
			McoTpaBillInputController mcoTpaBillInputController =
			(McoTpaBillInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			mcoTpaBillInputController.setMcoTpaBillViewController(this);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
    	}

    }

    @FXML
    void enterKeyPressedForChangeButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	try {
			
			Tpa tpa = tpaTable.getSelectionModel().getSelectedItem();

			String formName = formPath.context.getMessage("EditMCOOrTPA", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.EditMCOOrTPA", null, Locale.US);

			String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
			String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
			formPath.closeApplicationContext();

			if (tpa != null) {

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				McoTpaBillEditController editController = fxmlLoader.getController();
				editController.setTpa(tpa);
				editController.setMcoTpaBillViewController(this);
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

			Integer tpaIndex = tpaTable.getSelectionModel().getSelectedIndex();

			if (tpaIndex > -1) {

				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle(conformDialogBoxTitle);
				alert.setHeaderText(conformDelete);
				alert.setContentText(null);

				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					
					Tpa tpa = new TpaEntityController().view().get(tpaIndex);
					
					new TpaEntityController().delete(tpa.getId());
											

					viewTPA();

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

    }}

    @FXML
    void enterKeyPressedForPrintButton(KeyEvent event) {

    }

    @FXML
    void enterKeyPressedForSelectButton(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER){
    	Tpa tpa = this.tpaTable.getSelectionModel().getSelectedItem();

		if (companyInputController != null) {
			
			this.companyInputController.setTpa(tpa.getCode());
			
		}else if (companyEditController != null) {
			
			companyEditController.setTpa(tpa.getCode());
			
		}
				

			new FXFormCommonUtilities().closeForm(selectButton);
		

    	}
    }
    
    @FXML
    void doubleClick(MouseEvent event) {
    	
    	if (event.getClickCount() == 2) {
			try {
				Tpa tpa = tpaTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditMCOOrTPA", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMCOOrTPA", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				McoTpaBillEditController editController = fxmlLoader.getController();
				editController.setTpa(tpa);
				editController.setMcoTpaBillViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

    }
    private Button button;
    
    private CompanyInputController companyInputController;
        
    public void setCompanyInputController(CompanyInputController companyInputController) {
		this.companyInputController = companyInputController;
	}
    
    public void setCompanyInputController(CompanyInputController companyInputController ,Button button) {
		this.companyInputController = companyInputController;
		this.button = button;
	}
    
    private CompanyEditController companyEditController;
	
	public void setCompanyEditController(CompanyEditController companyEditController ,Button button) {
		this.companyEditController = companyEditController;
		this.button = button;
	}

	private ObservableList<Tpa> tpaMasterData = FXCollections.observableArrayList();
	
	public void viewTPA(){
		
		tpaMasterData = new TpaEntityController().view();
		
		managedCareCollumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		
    	
		codeCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		emailCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().emailProperty());
		cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
		addressCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().localAddressProperty());
		stateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
		telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());
		faxCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().faxProperty());

		FilteredList<Tpa> filteredData = new FilteredList<Tpa>(tpaMasterData, p -> true);

		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(tpa -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (tpa.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(tpa -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return tpa.getInactive();
					
				}
				
				return true;
			});

		});

		SortedList<Tpa> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(tpaTable.comparatorProperty());

		tpaTable.setItems(sortedData);

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resource) {

		viewTPA();
		
		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddMCOOrTPA", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddMCOOrTPA", null, Locale.US);
				formPath.closeApplicationContext();
				
				McoTpaBillInputController mcoTpaBillInputController =
				(McoTpaBillInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				mcoTpaBillInputController.setMcoTpaBillViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		selectButton.setOnAction((event) -> {
			   
			Tpa tpa = this.tpaTable.getSelectionModel().getSelectedItem();

			if (companyInputController != null) {
				
				if(button.getId().equals("clinicalTpaBtn") ){
				
				this.companyInputController.setClinicalTpa(tpa.getCode());
				
				}else if(button.getId().equals("tpaButton")){
					this.companyInputController.setTpa(tpa.getCode());
				}
				
			}else if (companyEditController != null) {
				
				companyEditController.setTpa(tpa.getCode());
				
			}
					

				new FXFormCommonUtilities().closeForm(selectButton);
			

		});
		
		changeButton.setOnAction((event) -> {
			try {
				
				Tpa tpa = tpaTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditMCOOrTPA", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMCOOrTPA", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (tpa != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					McoTpaBillEditController editController = fxmlLoader.getController();
					editController.setTpa(tpa);
					editController.setMcoTpaBillViewController(this);
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

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Tpa1", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Tpa>> task =

					new Task<ObservableList<Tpa>>() {

						@Override
						protected ObservableList<Tpa> call() throws Exception {

							ObservableList<Tpa> tpaList = null;

							try {

								System.out.println("Generating PDF...");

								String printTpa= formPath.context.getMessage("Print.Tpa", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printTpa));
								InputStream is = this.getClass().getResourceAsStream(printTpa);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								tpaList =new TpaEntityController().view();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(tpaList);
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
							return tpaList;

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
		deleteButton.setOnAction((event) -> {

			// Delete TPA Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer tpaIndex = tpaTable.getSelectionModel().getSelectedIndex();

				if (tpaIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
						Tpa tpa = new TpaEntityController().view().get(tpaIndex);
						
						new TpaEntityController().delete(tpa.getId());
												

						viewTPA();

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
