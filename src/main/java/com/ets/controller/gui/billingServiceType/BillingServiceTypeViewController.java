package com.ets.controller.gui.billingServiceType;

/**
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BillingServiceTypeViewController Class
 *Description: View.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner: Sumanta Deyashi
 *Date: 23/02/2016
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 */

import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;
import com.ets.controller.entity.billingServiceType.BillingServiceTypeEntityController;
import com.ets.controller.gui.billingPanel.PatientAnalysisController;
import com.ets.controller.gui.medicalActivity.MedicalActivityCodeEditController;
import com.ets.controller.gui.medicalActivity.MedicalActivityCodeInputController;
import com.ets.controller.gui.visitCategory.VisitCategoryCodeEditController;
import com.ets.controller.gui.visitCategory.VisitCategoryCodeInputController;
import com.ets.model.BillingServiceType;
import com.ets.model.Division;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class BillingServiceTypeViewController implements Initializable {

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
    private Button selectButton;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button buttomButton;

	@FXML
	private TableView<BillingServiceType> billingServiceTable;

	@FXML
	private TableColumn<BillingServiceType, String> descriptionCollumn;

	@FXML
	private TableColumn<BillingServiceType, Integer> svcCollumn;

	@FXML
	private TableColumn<BillingServiceType, String> billTypeCollumn;
	
	private MedicalActivityCodeInputController medicalActivityCodeInputController;
	
	public void setMedicalActivityCodeInputController(MedicalActivityCodeInputController medicalActivityCodeInputController) {
		this.medicalActivityCodeInputController = medicalActivityCodeInputController;
	}
	
	private MedicalActivityCodeEditController medicalActivityCodeEditController;
		
	public void setMedicalActivityCodeEditController(MedicalActivityCodeEditController medicalActivityCodeEditController) {
		this.medicalActivityCodeEditController = medicalActivityCodeEditController;
	}

	private VisitCategoryCodeInputController visitCategoryCodeInputController;
	
	public void setVisitCategoryCodeInputController(VisitCategoryCodeInputController visitCategoryCodeInputController) {
		this.visitCategoryCodeInputController = visitCategoryCodeInputController;
	}
	
	private VisitCategoryCodeEditController visitCategoryCodeEditController;
	

	public void setVisitCategoryCodeEditController(VisitCategoryCodeEditController visitCategoryCodeEditController) {
		this.visitCategoryCodeEditController = visitCategoryCodeEditController;
	}

	
	
	
	private PatientAnalysisController patientAnalysisController;
	public void setPatientAnalysisController(PatientAnalysisController patientAnalysisController) {
		this.patientAnalysisController = patientAnalysisController;
		
	}
	/*
	private PatientAnalysisController patientAnalysisController1;
	public void setPatientAnalysisController1(PatientAnalysisController patientAnalysisController1) {
		this.patientAnalysisController1 = patientAnalysisController1;
		
	}*/
	
	
	public void refreshBillingServiceType() {

		descriptionCollumn.setCellValueFactory(new PropertyValueFactory<BillingServiceType, String>("descrip"));
		billTypeCollumn.setCellValueFactory(new PropertyValueFactory<BillingServiceType, String>("billing_type"));
		svcCollumn.setCellValueFactory(new PropertyValueFactory<BillingServiceType, Integer>("id"));
	}

	public void populateMedicalConditionTable(ObservableList<BillingServiceType> billingServiceTypeList) {
		
FilteredList<BillingServiceType> filteredData = new FilteredList<BillingServiceType>(billingServiceTypeList, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(billingServiceType -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (billingServiceType.getDescrip().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
		
		
		inactiveCheckBox.setOnAction((event) -> {

			filteredData.setPredicate(billingServiceType -> {
				
				if (inactiveCheckBox.isSelected()) {
					
					return billingServiceType.getInactive();
					
				}
				
				return true;
			});

		});
		
	
		SortedList<BillingServiceType> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(billingServiceTable.comparatorProperty());
				
		billingServiceTable.setItems(sortedData);
		
		//billingServiceTable.setItems(billingServiceTypeList);
	}

	@FXML
	void doubleClick(MouseEvent event) {

		if (event.getClickCount() == 2) {
			try {

				BillingServiceType billingServiceType = billingServiceTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditBillingService", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditBillingService", null, Locale.US);
				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));

				BillingServiceTypeEditController controller = fxmlLoader.getController();
				controller.setBillingServiceType(billingServiceType);
				controller.setBillingServiceTypeViewController(this);
				stage.show();

			} catch (Exception e) {

				e.printStackTrace();

			}
		}

	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		refreshBillingServiceType();

		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("AddBillingService", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddBillingService", null, Locale.US);
				formPath.closeApplicationContext();
				BillingServiceTypeInputController billingServiceTypeInputController = (BillingServiceTypeInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				billingServiceTypeInputController.setBillingServiceTypeViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		changeButton.setOnAction((event) -> {
			try {

				BillingServiceType billingServiceType = billingServiceTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditBillingService", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditBillingService", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (billingServiceType != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));

					BillingServiceTypeEditController controller = fxmlLoader.getController();
					controller.setBillingServiceType(billingServiceType);
					controller.setBillingServiceTypeViewController(this);
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

				Integer billing = billingServiceTable.getSelectionModel().getSelectedIndex();

				if (billing > -1) {

					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if (result.get() == ButtonType.OK) {

						BillingServiceType billingServiceType = new BillingServiceTypeEntityController()
								.viewBillingService().get(billing);
						new BillingServiceTypeEntityController().removeBillingServiceType(billingServiceType.getId());
						populateMedicalConditionTable(new BillingServiceTypeEntityController().viewBillingService());

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
			
			BillingServiceType selectedBillingServiceType = this.billingServiceTable.getSelectionModel().getSelectedItem();
					
			if(medicalActivityCodeInputController != null){
						
					this.medicalActivityCodeInputController.setBillingServiceType(selectedBillingServiceType.getId());
						
			}else if (medicalActivityCodeEditController != null) {
				
				medicalActivityCodeEditController.setBillingServiceType(selectedBillingServiceType.getId());
				
			}else if (visitCategoryCodeInputController != null) {
						
					visitCategoryCodeInputController.setBillingServiceType(selectedBillingServiceType.getId());
						
			}else if (visitCategoryCodeEditController != null) {
				
				visitCategoryCodeEditController.setBillingServiceType(selectedBillingServiceType.getId());
				
			}else{
				
				new FXFormCommonUtilities().closeForm(selectButton);
				
			}
					
					new FXFormCommonUtilities().closeForm(selectButton);
						
		});

		/*topButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(billingServiceTable, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		upButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = billingServiceTable.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(billingServiceTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		downButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = billingServiceTable.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(billingServiceTable, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		buttomButton.setOnAction((event) -> {
			try {
				int tempRowCount = billingServiceTable.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(billingServiceTable, tempRowCount);
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
