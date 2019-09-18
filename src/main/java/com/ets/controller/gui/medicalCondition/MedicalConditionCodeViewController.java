package com.ets.controller.gui.medicalCondition;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.bodyzone.BodyZoneEntityController;
import com.ets.controller.entity.carrier.CarrierEntityController;
import com.ets.controller.entity.medicalCondition.MedicalConditionCodeEntityController;
import com.ets.controller.gui.billingServiceType.BillingServiceTypeEditController;
import com.ets.controller.gui.district.DistrictEditController;
import com.ets.controller.gui.icd10.ICD10CodeViewDetailsController;
import com.ets.controller.gui.icd10.ICD10InputController;
import com.ets.controller.gui.icd10.ICD10ViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BodyPart;
import com.ets.model.Carrier;
import com.ets.model.District;
import com.ets.model.Division;
import com.ets.model.BillingServiceType;
import com.ets.model.MedicalCondition;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
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
import javafx.scene.control.TextField;

/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalConditionCodeViewController Class
 *Description: View.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification: Update Operation
 *Owner: Sumanta Deyashi
 *Date:01-03-2016
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

public class MedicalConditionCodeViewController implements Initializable {

	@FXML
	private TableView<MedicalCondition> medicalConditionView;

	@FXML
	private TableColumn<MedicalCondition, String> descriptionColumn;

	@FXML
	private TableColumn<MedicalCondition, String> codeColumn;

	@FXML
	private TableColumn<MedicalCondition, String> typeColumn;

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
	private Button topButton; // Table Record Top Button

	@FXML
	private Button upButton; // Table Record Up Button

	@FXML
	private Button downButton; // Table Record Down Button

	@FXML
	private Button bottomButton; // Table Record Bottom Button
	
	 @FXML
	  private Button selectButton;

	@FXML
	private TextField searchTextField; // Table Record Bottom Button

	@FXML
	private CheckBox includeInactiveCheckBox;
	
	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {

				String formName = formPath.context.getMessage("EditMedicalCondition", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMedicalCondition", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				MedicalCondition medicalCondition = medicalConditionView.getSelectionModel().getSelectedItem();

				if (medicalCondition != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();

					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					MedicalConditionCodeEditController controller = fxmlLoader.getController();
					controller.setMedicalCondition(medicalCondition);
					controller.setMedicalConditionViewController(this);
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
	
	private ICD10InputController icd10InputController;
	
	public void setIcd10InputController(ICD10InputController icd10InputController) {
		this.icd10InputController = icd10InputController;
	}
	
	private ICD10CodeViewDetailsController icd10CodeEditController;
	
	public void setIcd10CodeEditController(ICD10CodeViewDetailsController icd10CodeEditController) {
		this.icd10CodeEditController = icd10CodeEditController;
	}

	public void refreshMedicalCondition() {

		codeColumn.setCellValueFactory(new PropertyValueFactory<MedicalCondition, String>("code"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<MedicalCondition, String>("descrip"));
		typeColumn.setCellValueFactory(new PropertyValueFactory<MedicalCondition, String>("type"));

	}

	public void populateMedicalConditionTable(ObservableList<MedicalCondition> medicalConditionList) {
		
FilteredList<MedicalCondition> filteredData = new FilteredList<MedicalCondition>(medicalConditionList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(medicalCondition -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (medicalCondition.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		includeInactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(medicalCondition -> {
				
				if (includeInactiveCheckBox.isSelected()) {
					
					return medicalCondition.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<MedicalCondition> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(medicalConditionView.comparatorProperty());
				
		medicalConditionView.setItems(sortedData);
		
		//medicalConditionView.setItems(medicalConditionList);
	}
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		

		refreshMedicalCondition();

		// cancel centralized form
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		addButton.setOnAction((event) -> {
			try {
				// Load and Display - Entermedicalconditioncode.fxml Form

				String formName = formPath.context.getMessage("AddMedicalCondition", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddMedicalCondition", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalConditionCodeInputController medicalConditionCodeInputController =  (MedicalConditionCodeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				medicalConditionCodeInputController.setMedicalConditionCodeViewController(this);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("EditMedicalCondition", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMedicalCondition", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				MedicalCondition medicalCondition = medicalConditionView.getSelectionModel().getSelectedItem();

				if (medicalCondition != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();

					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					MedicalConditionCodeEditController controller = fxmlLoader.getController();
					controller.setMedicalCondition(medicalCondition);
					controller.setMedicalConditionViewController(this);
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
		
		selectButton.setOnAction((event) -> {
			
			MedicalCondition selectedMedicalCondition = this.medicalConditionView.getSelectionModel().getSelectedItem();
			
			if(icd10InputController != null){
				
				this.icd10InputController.setMedicalCondition(selectedMedicalCondition.getCode());
				
			}else if (icd10CodeEditController != null) {
				
				icd10CodeEditController.setMedicalCondition(selectedMedicalCondition.getCode());
				
			}
				
				new FXFormCommonUtilities().closeForm(selectButton);
			

		});
		
		printButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.MedicalCondition", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<MedicalCondition>> task =

					new Task<ObservableList<MedicalCondition>>() {

						@Override
						protected ObservableList<MedicalCondition> call() throws Exception {

							ObservableList<MedicalCondition> medicalConditionList = null;

							try {

								System.out.println("Generating PDF...");

								String printCarrier= formPath.context.getMessage("Print.MedicalCondition", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printCarrier));
								InputStream is = this.getClass().getResourceAsStream(printCarrier);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								medicalConditionList =new MedicalConditionCodeEntityController().getMedicalList();
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(medicalConditionList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

							

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return medicalConditionList;

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

			// Delete Carrier Details

			try {

				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				Integer medicalConditionIndex = medicalConditionView.getSelectionModel().getSelectedIndex();

				if (medicalConditionIndex > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {
						
				   MedicalCondition medicalCondition = new MedicalConditionCodeEntityController().getMedicalList().get(medicalConditionIndex);
                   new MedicalConditionCodeEntityController().delete(medicalCondition.getId());
                    
                   populateMedicalConditionTable(new MedicalConditionCodeEntityController().getMedicalList());

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

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(medicalConditionView, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = medicalConditionView.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(medicalConditionView, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = medicalConditionView.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(medicalConditionView, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		bottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = medicalConditionView.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(medicalConditionView, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
	}
}
