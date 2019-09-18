package com.ets.controller.gui.patientRepresentative;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.patientAuthRep.PatientAuthRepEntityController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.controller.gui.representRelation.PatientRepInputRelationController;
import com.ets.model.PatientAuthRep;
import com.ets.model.Provider;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientRepresentativeViewController Class
 *Description: PatientRepresentative.fxml Controller class
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

public class PatientRepresentativeViewController implements Initializable {

	@FXML
	private TableView<PatientAuthRep> patientAuthRepTable;

	@FXML
	private TableColumn<PatientAuthRep, String> nameCollumn;

	@FXML
	private TableColumn<PatientAuthRep, String> cityCollumn;

	@FXML
	private TableColumn<PatientAuthRep, String> stateCollumn;

	@FXML
	private TableColumn<PatientAuthRep, String> telephoneCollumn;

	@FXML
	private TextField searchText;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button bottomButton;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;


    @FXML
    private Button selectButton;

	@FXML
	void enterKeyPressedForAddButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				String formName = formPath.context.getMessage("EnterPatientRepresentative", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterPatientRepresentative", null, Locale.US);
				formPath.closeApplicationContext();

				PatientRepresentativeInputController patientRepresentativeInputController = (PatientRepresentativeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				patientRepresentativeInputController.setPatientRepresentativeViewController(this);
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
	void enterKeyPressedForSelectButton(KeyEvent event) {
		
		 if(event.getCode() == KeyCode.ENTER){
			 PatientAuthRep selectPatientAuthRep = patientAuthRepTable.getSelectionModel().getSelectedItem();
			 try {

				 if (patientInputController != null) {

						patientInputController.setPatientAuthRep(selectPatientAuthRep);
						

					}

					new FXFormCommonUtilities().closeForm(selectButton);
			 
			 
			 } catch (Exception ex) {
					ex.printStackTrace();
				}
		 }


	}

	@FXML
	private Button closeButton;

	private ObservableList<PatientAuthRep> patientAuthRepMasterData = FXCollections.observableArrayList();

	public void viewPatientAuthRep() {

		patientAuthRepMasterData = new PatientAuthRepEntityController().view();

		nameCollumn.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
		cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress()!=null?cellData.getValue().getAddress().cityProperty():null);
		stateCollumn.setCellValueFactory(cellData ->cellData.getValue().getAddress()!=null? cellData.getValue().getAddress().stateProperty():null);
		telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress()!=null?cellData.getValue().getAddress().phoneProperty():null);
		/*cityCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().cityProperty());
		stateCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().stateProperty());
		telephoneCollumn.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());*/

		FilteredList<PatientAuthRep> filteredData = new FilteredList<PatientAuthRep>(patientAuthRepMasterData, p -> true);

		searchText.textProperty().addListener((observable, oldValue, newValue) -> {

			filteredData.setPredicate(patientAuthRep -> {

				if (newValue == null || newValue.isEmpty()) {
					return true;
				}

				String lowerCaseFilter = newValue.toLowerCase();

				if (patientAuthRep.getFirstName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				}
				return false; // Does not match.
			});
		});

		SortedList<PatientAuthRep> sortedData = new SortedList<>(filteredData);

		sortedData.comparatorProperty().bind(patientAuthRepTable.comparatorProperty());

		patientAuthRepTable.setItems(sortedData);

	}
	
	

	private PatientInputController patientInputController;

	public void setPatientInputController(PatientInputController patientInputController) {
		this.patientInputController = patientInputController;
	}
	
	private PatientRepInputRelationController patientRepInputRelationController;
	

	public void setPatientRepInputRelationController(PatientRepInputRelationController patientRepInputRelationController) {
		this.patientRepInputRelationController = patientRepInputRelationController;
		System.out.println("@@@@@@@@@@@");
	
	}

	FXMLFormPath formPath = new FXMLFormPath();
	
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		viewPatientAuthRep();

		addButton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("EnterPatientRepresentative", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterPatientRepresentative", null, Locale.US);
				formPath.closeApplicationContext();

				PatientRepresentativeInputController patientRepresentativeInputController = (PatientRepresentativeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				patientRepresentativeInputController.setPatientRepresentativeViewController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		
		selectButton.setOnAction((event) -> {
			
			
			PatientAuthRep selectPatientAuthRep = patientAuthRepTable.getSelectionModel().getSelectedItem();
			try {
				if (patientInputController != null) {

					patientInputController.setPatientAuthRep(selectPatientAuthRep);
					

				}
				if(patientRepInputRelationController != null)
				{
					
					
					patientRepInputRelationController.selectedPatientRepresentative(selectPatientAuthRep);
				}

				new FXFormCommonUtilities().closeForm(selectButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
			});
			
		
		//Change Patient Representative
		changeButton.setOnAction((event)-> {
			PatientAuthRep selectPatientRep = patientAuthRepTable.getSelectionModel().getSelectedItem();
			
			try {
			
					String formName = formPath.context.getMessage("EnterPatientRepresentative", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EnterPatientRepresentative", null, Locale.US);
					
					formPath.closeApplicationContext();
					
					

					PatientRepresentativeInputController patientRepresentativeInputController = (PatientRepresentativeInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					patientRepresentativeInputController.setPatientRepresentativeViewController(this,selectPatientRep);
				
				
			} catch (Exception ex) {
				// TODO: handle exception
				ex.printStackTrace();
			}
		});
		
		//Delete Patient Representative
		deleteButton.setOnAction((event)->{
			try{
			PatientAuthRep selectPatientRep = patientAuthRepTable.getSelectionModel().getSelectedItem();
			PatientAuthRepEntityController obj = new PatientAuthRepEntityController();
			obj.delete(selectPatientRep.getId());
			viewPatientAuthRep();

		
			}catch (Exception ex){
				ex.printStackTrace();
			}
			
		});
		
		//Select button
		/*selectButton.setOnAction((event)->{
			
			
			PatientRepInputRelationController representRelation = new PatientRepInputRelationController();
			representRelation.setPatientRep(this);
			
		});*/

		// Centralized Form cancel
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
