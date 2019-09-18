package com.ets.controller.gui.medicalActivityCharge;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25/11/2016
 * *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalActivityChargeInputController Class
 *Description: Left_Panel.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */


import java.net.URL;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import org.fxmisc.easybind.EasyBind;

import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.drugScreenDrugName.DrugScreenDrugNameEntityController;
import com.ets.controller.entity.drugScreenResult.DrugScreenResultEntityController;
import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.controller.navpanel.BillingAndInvoicingGUIController;
import com.ets.model.Clinic;
import com.ets.model.ClinicSchedule;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.model.MedicalActivity;
import com.ets.model.MedicalActivityCharge;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.lowagie.text.Cell;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MedicalActivityChargeViewController implements Initializable {
	
	 	@FXML
	    private TableView<MedicalActivity> MedicalActivityTableByName;

	    @FXML
	    private TableColumn<MedicalActivity, String> activityCollumnByName;

	    @FXML
	    private TableColumn<MedicalActivity, String> codeCollumnByName;

	    @FXML
	    private TableView<MedicalActivity> MedicalActivityTableByCPTCode;

	    @FXML
	    private TableColumn<MedicalActivity, String> codeCollumnByCPTCode;

	    @FXML
	    private TableColumn<MedicalActivity, String> nameCollumnByCPTCode;
	    
	    @FXML
	    private TableView<MedicalActivityCharge> medicalActivityChargeTable;

	    @FXML
	    private TableColumn<MedicalActivityCharge, String> activityCodeCollumn;

	    @FXML
	    private TableColumn<MedicalActivityCharge, String> descriptionCollumn;

	    @FXML
	    private TableColumn<MedicalActivityCharge, String> cpt4Collumn;

	    @FXML
	    private TableColumn<MedicalActivityCharge, String> modifyCollumn;

	    @FXML
	    private TableColumn<MedicalActivityCharge, String> qtyCollumn;

	    @FXML
	    private TableColumn<MedicalActivityCharge, String> icd10Collumn;

	    @FXML
	    private TableColumn<MedicalActivityCharge, String> statusCollumn;
	    
	    @FXML
	    private Button changeBtn;
	    
	    @FXML
	    private Button addBtn;
	    
	    @FXML
	    private Button deleteButton;

	    @FXML
	    private Button closeBtn;
	    
	    @FXML
	    private TextField searchMedicalChargeText;
	    
	    @FXML
	    private TextField searchMedicalActivityText;
	    	    
	    private DrugScreenResult drugScreenResult;
	    private DrugScreenTestResult drugScreenTestResult ;
	    
	    
	    private ObservableList<MedicalActivity> medicalActivityMasterData = FXCollections.observableArrayList();
	    
	    public void viewMedicalActivityDetails(){
	    	
	    	medicalActivityMasterData = new MedicalActivityEntityController().viewMedicalActivity();
	    }
	    
	    public void viewMedicalActivityByName() {

	    	//medicalActivityMasterData = new DepartmentUnitEntityController().viewDepartmentUnit();
	    	
	    	codeCollumnByName.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
	    	activityCollumnByName.setCellValueFactory(cellData -> cellData.getValue().descripProperty());
			//divisionCollumn.setCellValueFactory(cellData -> cellData.getValue().getDivision().codeProperty());
	    	
	    	FilteredList<MedicalActivity> filteredData = new FilteredList<MedicalActivity>(medicalActivityMasterData,
					p -> true);
	    	
	    	searchMedicalActivityText.textProperty().addListener((observable, oldValue, newValue) -> {

				filteredData.setPredicate(medicalActivity -> {

					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();

					if (medicalActivity.getCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					}
					return false; // Does not match.
				});
			});
	    	
	    	SortedList<MedicalActivity> sortedData = new SortedList<>(filteredData);

			sortedData.comparatorProperty().bind(MedicalActivityTableByName.comparatorProperty());
	    	
	    	//medicalActivityChargeTable.setItems(medicalActivityChargeMasterData);
			//medicalActivityChargeTable.setItems(sortedData);
			
			MedicalActivityTableByName.setItems(sortedData);


				    }
	    
	    
	    public void viewChargeAfterBilling(Integer id){
	    	
	    	
	    }
	    
	    public void viewMedicalActivityByCPTCode(){
	    		    	
	    	//codeCollumnByCPTCode.setCellValueFactory(cellData -> cellData.getValue().getCptCode4Hcpcs().codeProperty());
	    	codeCollumnByCPTCode.setCellValueFactory( data -> 
		    EasyBind.select(data.getValue().cptCode4HcpcsProperty())
		        .selectObject(CptCode4Hcpcs::codeProperty));
	    	//nameCollumnByCPTCode.setCellValueFactory(cellData -> cellData.getValue().getCptCode4Hcpcs().descrpProperty());
	    	
	    	nameCollumnByCPTCode.setCellValueFactory( data -> 
		    EasyBind.select(data.getValue().cptCode4HcpcsProperty())
		        .selectObject(CptCode4Hcpcs::descrpProperty));
	    		    	
	    	FilteredList<MedicalActivity> filteredData = new FilteredList<MedicalActivity>(medicalActivityMasterData,
					p -> true);
	    	
	    	searchMedicalActivityText.textProperty().addListener((observable, oldValue, newValue) -> {

				filteredData.setPredicate(medicalActivityCPTCode -> {

					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();

					if (medicalActivityCPTCode.getCptCode4Hcpcs().getCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					}
					return false; // Does not match.
				});
			});
	    	
	    	SortedList<MedicalActivity> sortedData = new SortedList<>(filteredData);

			sortedData.comparatorProperty().bind(MedicalActivityTableByCPTCode.comparatorProperty());
	    	
	    	//medicalActivityChargeTable.setItems(medicalActivityChargeMasterData);
			//medicalActivityChargeTable.setItems(sortedData);
			
			MedicalActivityTableByCPTCode.setItems(sortedData);

	    	//MedicalActivityTableByCPTCode.setItems(medicalActivityMasterData);
	    	
	    }
	    
	    private ObservableList<MedicalActivityCharge> medicalActivityChargeMasterData = FXCollections.observableArrayList();
	    
	    public void viewMedicalActivityCharge(){
	    	
	    	//medicalActivityChargeMasterData= new MedicalActivityChargeEntityController().viewMedicalActivityCharge(Global.patient.getId(),false); changes
	    	
	    	medicalActivityChargeMasterData= new MedicalActivityChargeEntityController().searchByPatientVisit(Global.patientVisitObj.getId());
	    	
	    	
	    	System.out.println("$$$$$$$$$$$$$$$$$ "+Global.patientVisitObj.getId());
	    	System.out.println("Patient Visit Id is ;----" +Global.patientVisitObj.getId());
	    	
	    	activityCodeCollumn.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity()!= null?cellData.getValue().getMedicalActivity().codeProperty():null);
	    	descriptionCollumn.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity()!= null?cellData.getValue().getMedicalActivity().descripProperty():null);
	    	//cpt4Collumn.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity().getCptCode4Hcpcs().codeProperty());
	    	cpt4Collumn.setCellValueFactory( data -> data.getValue().getMedicalActivity()!= null?
		    EasyBind.select(data.getValue().getMedicalActivity().cptCode4HcpcsProperty()).selectObject(CptCode4Hcpcs::codeProperty):null);
	    	
	    	//modifyCollumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
	    	qtyCollumn.setCellValueFactory(cellData -> cellData.getValue().billingQtyProperty());
	    	//icd10Collumn.setCellValueFactory(cellData -> cellData.getValue().getMedicalActivity().geti);
	    	System.out.println("size before removing charges "+medicalActivityChargeMasterData.size());
	    	statusCollumn.setCellValueFactory(cellData -> cellData.getValue().billingStatusProperty());
	    	/*if(medicalActivityChargeMasterData.size()>0){
	    		Iterator<MedicalActivityCharge> medActivity = medicalActivityChargeMasterData.iterator();
	    		while(medActivity.hasNext()){
	    			if(medActivity.next().getCheckBillingStatus()==true){
	    				
	    				statusCollumn.setCellValueFactory(cellData -> cellData.getValue().billingStatusProperty());
						medicalActivityChargeMasterData.remove(medActivity);
	    			}else{
	    				statusCollumn.setCellValueFactory(cellData -> cellData.getValue().billingStatusProperty());
	    				
	    			}
	    			
	    		}System.out.println("size afte removing charges "+medicalActivityChargeMasterData.size());
	    		
	    	for (MedicalActivityCharge medicalActivityCharge : medicalActivityChargeMasterData) {
				if(medicalActivityCharge.getCheckBillingStatus()==true){
					
					//statusCollumn.setText("Billed");
					
					statusCollumn.setCellValueFactory(cellData -> cellData.getValue().billingStatusProperty());
					medicalActivityChargeMasterData.remove(medicalActivityCharge);
				
				}else{
					
					statusCollumn.setCellValueFactory(cellData -> cellData.getValue().billingStatusProperty());
				}
	    	}
	    	}*/
	    	FilteredList<MedicalActivityCharge> filteredData = new FilteredList<MedicalActivityCharge>(medicalActivityChargeMasterData,
					p -> true);
	    	
	    	searchMedicalChargeText.textProperty().addListener((observable, oldValue, newValue) -> {

				filteredData.setPredicate(medicalCharge -> {

					if (newValue == null || newValue.isEmpty()) {
						return true;
					}

					String lowerCaseFilter = newValue.toLowerCase();

					if (medicalCharge.getMedicalActivity().getCode().toLowerCase().indexOf(lowerCaseFilter) != -1) {
						return true; // Filter matches first name.
					}
					return false; // Does not match.
				});
			});
	    	
	    	SortedList<MedicalActivityCharge> sortedData = new SortedList<>(filteredData);

			sortedData.comparatorProperty().bind(medicalActivityChargeTable.comparatorProperty());
	    	
	    	
	    	//medicalActivityChargeTable.setItems(medicalActivityChargeMasterData);
			medicalActivityChargeTable.setItems(sortedData);
	    		    	
	    }
	    
	    @FXML
	    void doubleClickOnMedicalActivityTable(MouseEvent event) {
	    	
	    	if (event.getClickCount() == 2) {
	    		try {
	    			
	    			MedicalActivity medicalActivity = MedicalActivityTableByName.getSelectionModel().getSelectedItem();
	    			
	    			MedicalActivityCharge medicalActivityCharge = new MedicalActivityCharge();
	    			medicalActivityCharge.setMedicalActivity(medicalActivity);
	    			
	    			if(Global.patientVisitObj.getVisitType().equals("Worker's Comp")){
	    				System.out.println("VisitType is :- ------- " +Global.patientVisitObj.getVisitType());
	    				medicalActivityCharge.setOverrideFee(medicalActivity.getCptCode4Hcpcs().getWrkCompCrgCurrent());
	    			}else if(Global.patientVisitObj.getVisitType().equals("Private Practice")){
	    				System.out.println("VisitType is :- ------- " +Global.patientVisitObj.getVisitType());
	    				medicalActivityCharge.setOverrideFee(medicalActivity.getCptCode4Hcpcs().getPvtPracticeCrgCurrent());
	    			}else if(visitLogInputController.visitType.equals("Worker's Comp")){
	    				System.out.println("VisitType is :- ------- " +visitLogInputController.visitType);
	    				medicalActivityCharge.setOverrideFee(medicalActivity.getCptCode4Hcpcs().getWrkCompCrgCurrent());
	    			}else if(visitLogInputController.visitType.equals("Private Practice")){
	    				System.out.println("VisitType is :- ------- " +visitLogInputController.visitType);
	    				medicalActivityCharge.setOverrideFee(medicalActivity.getCptCode4Hcpcs().getPvtPracticeCrgCurrent());
	    			}
	    			medicalActivityCharge.setActivityDate(new Date());
	    			medicalActivityCharge.setPatientVisit(Global.patientVisitObj);
	    			medicalActivityCharge.setPatient(Global.patient);
	    			new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge);
	    			viewMedicalActivityCharge();
	    			
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    	}

	    }
	    
	    
	
	    
	    
	    @FXML
	    void doubleClickOnCptCodeTable(MouseEvent event) {
	    	
	    	if (event.getClickCount() == 2) {
	    		try {
	    			
	    			MedicalActivity medicalActivity = MedicalActivityTableByCPTCode.getSelectionModel().getSelectedItem();
	    			
	    			MedicalActivityCharge medicalActivityCharge = new MedicalActivityCharge();
	    			medicalActivityCharge.setMedicalActivity(medicalActivity);
	    			
	    			if(visitLogInputController.visitType.equals("Worker's Comp")){
	    				System.out.println("VisitType is :- ------- " +visitLogInputController.visitType);
	    				medicalActivityCharge.setOverrideFee(medicalActivity.getCptCode4Hcpcs().getWrkCompCrgCurrent());
	    			}else if(visitLogInputController.visitType.equals("Private Practice")){
	    				System.out.println("VisitType is :- ------- " +visitLogInputController.visitType);
	    				medicalActivityCharge.setOverrideFee(medicalActivity.getCptCode4Hcpcs().getPvtPracticeCrgCurrent());
	    			}
	    			medicalActivityCharge.setActivityDate(new Date());
	    			medicalActivityCharge.setPatientVisit(Global.patientVisitObj);
	    			medicalActivityCharge.setPatient(Global.patient);
	    			new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge);
	    			viewMedicalActivityCharge();
	    			
	    			
	    			
	    			
	    			
	    			
	    			/*MedicalActivityCharge medicalActivityCharge = new MedicalActivityCharge();
	    			medicalActivityCharge.setMedicalActivity(medicalActivity);
	    			
	    			medicalActivityCharge.setActivityDate(new Date());
	    			
	    			new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge);*/
	    			//viewMedicalActivityCharge();
	    			
	    		}catch(Exception e){
	    			e.printStackTrace();
	    		}
	    	}


	    }
	    
		public static String drugTestProfile = null;
		
		
        public VisitLogInputController visitLogInputController;
	    
	    public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
	   this.visitLogInputController = visitLogInputController;
}

	    public BillingAndInvoicingGUIController billingAndInvoicingGUIController;
	    
			public void setBillingAndInvoicingGUIController(BillingAndInvoicingGUIController billingAndInvoicingGUIController) {
			this.billingAndInvoicingGUIController = billingAndInvoicingGUIController;
		}

		FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewMedicalActivityDetails();
		viewMedicalActivityByName();
		viewMedicalActivityByCPTCode();
		viewMedicalActivityCharge();
		
		addBtn.setOnAction((event) -> {
			//System.out.println("HIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
			try {

				String formName = formPath.context.getMessage("EnterMedicalActivityCharge", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EnterMedicalActivityCharge", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle3= Global.patient.getCompany().getName();
				String formTitle = formTitle1+"/"+formTitle2+"/"+formTitle3;
				MedicalActivityChargeInputController medicalActivityChargeInputController = new MedicalActivityChargeInputController();
				medicalActivityChargeInputController.setMedicalActivityChargeViewController(this);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*changeBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("EnterMedicalActivityCharge", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EnterMedicalActivityCharge", null, Locale.US);
				String formTitle2 = Global.patient.getPatientName().getFirstName();
				String formTitle3= Global.patient.getCompany().getName();
				String formTitle = formTitle1+"/"+formTitle2+"/"+formTitle3;
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
	
		
		changeBtn.setOnAction((event) -> {
			try {
				
				// Load Clinician Details Edit form .

				MedicalActivityCharge medicalActivityCharge = medicalActivityChargeTable.getSelectionModel().getSelectedItem();
				
				drugTestProfile = medicalActivityCharge.getMedicalActivity().getDescrip();
				String formName = formPath.context.getMessage("EditMedicalActivityCharge", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditMedicalActivityCharge", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				formPath.closeApplicationContext();

				if (medicalActivityCharge != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					MedicalActivityChargeEditController editController = fxmlLoader.getController();
					editController.setMedicalActivityCharge(medicalActivityCharge);
					editController.setMedicalActivityChargeViewController(this);
					editController.setActivityCode(medicalActivityCharge.getMedicalActivity());
					stage.show();

				} else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();
				}

			
				
			}catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		deleteButton.setOnAction((event)->{
			MedicalActivityCharge medicalActivityCharge = medicalActivityChargeTable.getSelectionModel().getSelectedItem();
			System.out.println("sdfsasf"+medicalActivityCharge.getId());
			if(medicalActivityCharge.getMedicalActivity().getCode().equals("RPD DS10") || medicalActivityCharge.getMedicalActivity().getCode().equals("RPD DS") && ( drugScreenResult!= null && drugScreenResult.getMedActCharge().getId() == medicalActivityCharge.getId())){
			new DrugScreenResultEntityController().deleteMedActCharge(medicalActivityCharge.getId());
			new MedicalActivityChargeEntityController().delete(medicalActivityCharge.getId());
			viewMedicalActivityCharge();
				
		} 
			
			else {
			    new MedicalActivityChargeEntityController().delete(medicalActivityCharge.getId());
			    viewMedicalActivityCharge();
			}
		});
		
		
		
		closeBtn.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
						
	}

}
