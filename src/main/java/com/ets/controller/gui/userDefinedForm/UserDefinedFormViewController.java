package com.ets.controller.gui.userDefinedForm;

import java.io.File;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SelectUserdefinedpdfFormController Class
 *Description: SelectUserdefinedpdfForm.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.userDefinedForm.UserDefinedFormEntityController;
import com.ets.controller.gui.companyProtocol.CompanyStandardProtocolActivityInputController;
import com.ets.controller.gui.flowSheet.EncounterFormInputController;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.UserDefinedForm;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class UserDefinedFormViewController implements Initializable{
	
	 	@FXML
	    private Button addBtn;

	    @FXML
	    private Button changebtn;

	    @FXML
	    private Button closeBtn;

	    @FXML
	    private Button deleteBtn;
	    @FXML
	    private TableView<UserDefinedForm> userDefinedFormTable;

	    @FXML
	    private TableColumn<UserDefinedForm, String> formNameCollumn;

	    @FXML
	    private TableColumn<UserDefinedForm, String> formTypeCollumn;

	    @FXML
	    private Button selectBtn;
	    
	    private EncounterFormInputController encounterFormInputController;
	    
	    public void setEncounterFormInputController(EncounterFormInputController encounterFormInputController) {
			this.encounterFormInputController = encounterFormInputController;
		}
        private Integer selectedRelatedFormInd;
	    public void setEncounterFormInputController(EncounterFormInputController encounterFormInputController,int selectedRelatedFormInd) {
			this.encounterFormInputController = encounterFormInputController;
			this.selectedRelatedFormInd=selectedRelatedFormInd;
		}
		private ObservableList<UserDefinedForm> userDefinedFormMasterData = FXCollections.observableArrayList();
	    
	    public void viewUserDefinedForm(){
	    	
	    	userDefinedFormMasterData = new UserDefinedFormEntityController().viewUserDefinedForm();
	    	
	    	formNameCollumn.setCellValueFactory(cellValue -> cellValue.getValue().formNameProperty());
	    	formTypeCollumn.setCellValueFactory(cellValue -> cellValue.getValue().formTypeProperty());
	    	
	    	userDefinedFormTable.setItems(userDefinedFormMasterData);
	    		
	    }
	    
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewUserDefinedForm();
			
		closeBtn.setOnAction((event) -> {
			try {
				
				new FXFormCommonUtilities().closeForm( closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
			
		deleteBtn.setOnAction(event->{
			UserDefinedForm userDefinedForm = userDefinedFormTable.getSelectionModel().getSelectedItem();
			if(userDefinedForm!=null){
				if(userDefinedForm.getFormName()!=null&&userDefinedForm.getFormPath()!=null){
				File file = new File(userDefinedForm.getFormPath()+"/"+userDefinedForm.getFormName());
				file.delete();
				}
				new UserDefinedFormEntityController().delete(userDefinedForm);
				viewUserDefinedForm();
				
				
			}else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Please select a record!");

				alert.showAndWait();
			}
		});
		addBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("AddUserDefinedPDFForms", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddUserDefinedPDFForms", null, Locale.US);
				formPath.closeApplicationContext();
				
				UserDefineFormInputController defineFormInputController =
				(UserDefineFormInputController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				defineFormInputController.setUserDefinedFormViewController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changebtn.setOnAction(event->{
			try{
				UserDefinedForm userDefinedForm = userDefinedFormTable.getSelectionModel().getSelectedItem();
				if(userDefinedForm!=null){
				String formName = formPath.context.getMessage("AddUserDefinedPDFForms", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddUserDefinedPDFForms", null, Locale.US);
				formPath.closeApplicationContext();
				
				UserDefineFormInputController defineFormInputController =
				(UserDefineFormInputController) new FXFormCommonUtilities().displayForm( formName , formTitle);
				defineFormInputController.setUserDefinedFormViewController(this,userDefinedForm);
				
				}else{
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select a record!");

					alert.showAndWait();
				}
				
			}catch(Exception ex){
				
			}
			
		});
		selectBtn.setOnAction(event->{
			UserDefinedForm userDefinedForm = userDefinedFormTable.getSelectionModel().getSelectedItem();
			if(userDefinedForm!=null?encounterFormInputController!=null:false){
				
				
				if(selectedRelatedFormInd!=null&&selectedRelatedFormInd!=-1){
					EncounterFormInputController.userDefinedFormList.set(selectedRelatedFormInd, userDefinedForm);
					encounterFormInputController.viewRelatedForms();
				}else{
					encounterFormInputController.setRelatedForm(userDefinedForm);
				}
				
			}else{
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Please select a record!");

				alert.showAndWait();	
			}
			
			new FXFormCommonUtilities().closeForm( closeBtn);
		});
		
	}
}