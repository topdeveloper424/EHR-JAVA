package com.ets.controller.gui.emrCharting;

import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.buildNote.BuildNoteEntityController;
import com.ets.controller.entity.medicationClass.MedicationClassEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.gui.emrCharting.hpi.mechanism.HPIMechanismInputController;
import com.ets.model.BuildNote;
import com.ets.model.MedicationClass;
import com.ets.model.Patient;
import com.ets.model.PatientVisit;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PastBuildNoteViewController  implements Initializable{
	@FXML
    private Button viewBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private TableView<PatientVisit> tableView;

    @FXML
    private TableColumn<PatientVisit, Date> dateColumn;

    @FXML
    private TableColumn<PatientVisit, String> visitChartingSummaryCol;

    @FXML
    private TableColumn<PatientVisit, String> providerCol;

    @FXML
    private TableColumn<PatientVisit, String> statusCol;
    private GenericEMRChartingController genericEMRChartingController;
	  
    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController) {
		this.genericEMRChartingController = genericEMRChartingController;
				
	}
  
    FXMLFormPath  formPath = new FXMLFormPath();
   private ObservableList<PatientVisit> patientVisitList = FXCollections.observableArrayList();
   
   
    public void viewPastNotes() {

    	patientVisitList = new PatientVisitEntityController().viewByPat(Global.patient.getId());

    	visitChartingSummaryCol.setCellValueFactory(cellData -> cellData.getValue().purposeProperty());
    	providerCol.setCellValueFactory(cellData -> cellData.getValue().getProvider().firstNameProperty());
    	dateColumn.setCellValueFactory(cellData -> cellData.getValue().visitDateProperty());
    	

    	tableView.setItems(patientVisitList);
    
    	
    	

	}

    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewPastNotes();
		
		viewBtn.setOnAction((event) -> {
			try {
				
				PatientVisit patVisit = tableView.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("BuildNote", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BuildNote", null, Locale.US);
				formPath.closeApplicationContext();
				

				BuildNoteViewController buildNoteViewController = (BuildNoteViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				buildNoteViewController.setPastBuildNoteViewController(this,patVisit);
				
			  
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		cancelBtn.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
