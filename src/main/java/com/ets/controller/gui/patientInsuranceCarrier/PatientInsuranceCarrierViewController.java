package com.ets.controller.gui.patientInsuranceCarrier;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.patientAuthRep.PatientAuthRepEntityController;
import com.ets.controller.entity.patientInsuranceCarrier.PatientInsuranceCarrierEntityController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.controller.gui.patientRepresentative.PatientRepresentativeInputController;
import com.ets.model.Carrier;
import com.ets.model.PatientAuthRep;
import com.ets.model.PatientInsuranceCarrier;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PatientInsuranceCarrierViewController implements Initializable {
	
	@FXML
    private TableView<PatientInsuranceCarrier> patientInsuranceCareerTable;
	
	
	    @FXML
	    private TableColumn<PatientInsuranceCarrier, String> TypeColumn;

	    @FXML
	    private TableColumn<PatientInsuranceCarrier, String> CoPayColumn;

	    @FXML
	    private TableColumn<PatientInsuranceCarrier, String> DeductibleColumn;

	    @FXML
	    private TableColumn<PatientInsuranceCarrier, String> PercentColumn;
	    
	    @FXML
	    private TextField searchText;

	    @FXML
	    private Button AddButton;

	    @FXML
	    private Button ChangeButton;

	    @FXML
	    private Button DeleteButton;

	    @FXML
	    private Button SelectButton;

	    @FXML
	    private Button CloseButton;
	    
	    private ObservableList<PatientInsuranceCarrier> patientInsuranceCarrierMasterData = FXCollections.observableArrayList();
	    
	    public void viewPatientInsuranceCarrier(){
	    	
	    	patientInsuranceCarrierMasterData = new PatientInsuranceCarrierEntityController().view();
			
	    	//LevelColumn.setCellValueFactory(cellData -> cellData.getValue().);
	    	//LevelColumn.setCellValueFactory(cellData -> cellData.getValue().);
	    	//PayorColumn.setCellValueFactory(cellData -> cellData.getValue().);
	    	TypeColumn.setCellValueFactory(cellData -> cellData.getValue().planTypeProperty());
	    	CoPayColumn.setCellValueFactory(cellData -> cellData.getValue().copayAmtProperty());
	    	DeductibleColumn.setCellValueFactory(cellData -> cellData.getValue().deductAmtProperty());
	    	PercentColumn.setCellValueFactory(cellData -> cellData.getValue().coverPercentProperty());
	    	
	    	FilteredList<PatientInsuranceCarrier> filteredData = new FilteredList<PatientInsuranceCarrier>(patientInsuranceCarrierMasterData, p -> true);
			
			searchText.textProperty().addListener((observable, oldValue, newValue) -> {
				
				filteredData.setPredicate(patientInsuranceCarrier -> {
					
					if (newValue == null || newValue.isEmpty()) {
						return true;
					}
					
					
					String lowerCaseFilter = newValue.toLowerCase();
					
					if (patientInsuranceCarrier.getPlanType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					} 
					return false; // Does not match.
				});
			});
			
			SortedList<PatientInsuranceCarrier> sortedData = new SortedList<>(filteredData);
			
			sortedData.comparatorProperty().bind(patientInsuranceCareerTable.comparatorProperty());
					
			patientInsuranceCareerTable.setItems(sortedData);
			
	    }
	    
	    private PatientInputController patientInputController;
	    	    
	    public void setPatientInputController(PatientInputController patientInputController) {
			this.patientInputController = patientInputController;
		}
	    
	    private PatientEditController patientEditController;
		
		public void setPatientEditController(PatientEditController patientEditController) {
			this.patientEditController = patientEditController;
		}

		FXMLFormPath formPath = new FXMLFormPath();
	    

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewPatientInsuranceCarrier();
		
		AddButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("AddPatientInsuranceCareer", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddPatientInsuranceCareer", null, Locale.US);
				formPath.closeApplicationContext();
				
				 new FXFormCommonUtilities().displayForm(formName, formTitle);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		SelectButton.setOnAction((event) -> {
			try {
				PatientInsuranceCarrier selectPatientInsuranceCarrier = patientInsuranceCareerTable.getSelectionModel().getSelectedItem();
				
				if(patientInputController != null){
					
					patientInputController.setPatientInsurance(selectPatientInsuranceCarrier);
				
					
				}else if(patientEditController != null){
					patientEditController.setPatientInsurance(selectPatientInsuranceCarrier);
					
				}
				
				new FXFormCommonUtilities().closeForm(SelectButton);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		CloseButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(CloseButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
				
	}

}
