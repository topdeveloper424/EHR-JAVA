package com.ets.controller.gui.drugScreen;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;


import com.ets.controller.entity.drugScreenDrugName.DrugScreenDrugNameEntityController;
import com.ets.controller.entity.drugScreenResult.DrugScreenResultEntityController;
import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
import com.ets.controller.entity.laboratory.LaboratoryEntityController;
import com.ets.controller.gui.Laboratories.LaboratoryViewController;
import com.ets.controller.gui.division.DivisionEditController;
import com.ets.controller.gui.drugScreenTestResultReport.EmployerReportGUIController;
import com.ets.controller.gui.drugScreenTestResultReport.MroRequestFormGUIController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeInputController;
import com.ets.model.DrugScreenDrugName;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.RepresentRelation;
import com.ets.model.Laboratory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;



import com.ets.utils.DateConvert;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class DrugScreenResultInputController implements Initializable {
	
	  @FXML
	    private DatePicker collectionDate;

	    @FXML
	    private TextField ccfNumberText;

	    @FXML
	    private TextField laboratoryText;

	    @FXML
	    private ChoiceBox<String> orderResultStatusChoiceBox;

	    @FXML
	    private Button setAllNegativeBtn;

	    @FXML
	    private DatePicker receiveDate;

	    @FXML
	    private ChoiceBox<String> collectionProtocolChoiceBox;

	    @FXML
	    private ChoiceBox<String> testReasonChoiceBox;

	    @FXML
	    private Button laboratoryBtn;

	    @FXML
	    private DatePicker sentDateToLabDateField;

	    @FXML
	    private Button mroRequestBtn;

	    @FXML
	    private Button employerReportBtn;

	    @FXML
	    private DatePicker mroReviewDate;

	    @FXML
	    private TextField reportedToText;

	    @FXML
	    private TextField commentsText;

	    @FXML
	    private ChoiceBox<String> finalDetarminationChoiceBox;

	    @FXML
	    private DatePicker mroReqDate;

	    @FXML
	    private DatePicker employeeNotifiedDate;

	    @FXML
	    private DatePicker splitSpecimenReq;

	    @FXML
	    private DatePicker splitResultDate;

	    @FXML
	    private DatePicker finalDetarminationDate;
	    
	    @FXML
	    private Button changeOneResultBtn;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button cancelBtn;
	  	 

	  @FXML
	    private TableView<DrugScreenTestResult> drugScreenDrugNameTable;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> drugTestNameCollumn;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> labPrelimCollumn;
         
	    @FXML
	    private TableColumn<DrugScreenTestResult, String> finalCollumn;
	    
	    @FXML
	    private TableColumn<DrugScreenTestResult, String> drugSplit;

	    @FXML
	    private TableColumn<DrugScreenTestResult, Integer> drugRevision;
	    
	    @FXML
	    private TableView<DrugScreenTestResult> drugRevisionTable;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> revisedDrugName;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> revisedLabPrelim;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> revisedFinal;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> revisedSplit;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> revisionModDate;

	    @FXML
	    private TableColumn<DrugScreenTestResult, String> revisionCounts;

	    @FXML
	    private Label drugNameforRevision;
	    
	    @FXML
	    private Label drugScreenDescription;

	    @FXML
	    private Label medTestCode;
	    
	    @FXML
	    void drugScreenRevision(MouseEvent event) {
	    	System.out.println("CLICK Event is Fired");
	    	if(drugScreenResult2!=null){
	    	viewDrugScreenRevisions();
	    	}
	    	else{
	    		System.out.println("No Foreign key saved");
	    		DrugScreenTestResult staticRevisionDrug = drugScreenDrugNameTable.getSelectionModel().getSelectedItem();
	    		String Drug = staticRevisionDrug.getDrugTestName();
	    		viewStaticDrugLowerTable(Drug);
	    		
	    	}

	    }

	    private ObservableList<DrugScreenTestResult> revisionList = FXCollections.observableArrayList();
	    
	    public  ObservableList<DrugScreenTestResult> drugTestNameList = FXCollections.observableArrayList();
	    
	    DrugScreenDrugName drugtable = new DrugScreenDrugName();
	    
	    private DrugScreenTestResult tempDrugScreen;
	    
		public void setTempDrugScreen(ObservableList<DrugScreenTestResult> tempDrugScreen) {
			drugTestNameCollumn.setCellValueFactory(cellData -> cellData.getValue().drugTestNameProperty());
			labPrelimCollumn.setCellValueFactory(cellData -> cellData.getValue().prelimResultProperty());
			finalCollumn.setCellValueFactory(cellData -> cellData.getValue().finalResultProperty());
			drugRevision.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, Integer>("revision"));
			
			//List<DrugScreenTestResult> list = drugTestNameList.Stream().collect(Collectors.toList());
			//new DrugScreenTestResultEntityController().sortingMaxRevision(drugTestNameList);
			drugScreenDrugNameTable.setItems(tempDrugScreen);
			
			
		}
		public ObservableList<DrugScreenTestResult> revisionShowInputList = FXCollections.observableArrayList();
		
		public static List<DrugScreenTestResult> revisionInputList = new ArrayList<DrugScreenTestResult>();
		
		

	    
	    private final ObservableList<DrugScreenTestResult> preliminaryCollumn5PanelTest =
	            FXCollections.observableArrayList(
	            		new DrugScreenTestResult("Amphetamines" , "No Result"),
	            		new DrugScreenTestResult("Cocaine" , "No Result"),
	            		new DrugScreenTestResult("Marijuana-Cannabinoids" , "No Result"),
	            		new DrugScreenTestResult("Opiates" , "No Result"),
	            		new DrugScreenTestResult("Methamphetamines" , "No Result")
	            		
	            
	            );
	    
	    private final ObservableList<DrugScreenTestResult> dataForFinalColllumn5PanelTest =
	            FXCollections.observableArrayList(
	            		new DrugScreenTestResult("Amphetamines" , "Negative", null),
	            		new DrugScreenTestResult("Cocaine" , "Negative", null),
	            		new DrugScreenTestResult("Marijuana-Cannabinoids" , "Negative", null),
	            		new DrugScreenTestResult("Opiates" , "Negative", null),
	            		new DrugScreenTestResult("Methamphetamines" , "Negative", null)
	            		
	            
	            );
	    
	    
	    private final ObservableList<DrugScreenTestResult> preliminaryCollumn10PanelTest =
	            FXCollections.observableArrayList(
	            		new DrugScreenTestResult("Amphetamines" , "No Result"),
	            		new DrugScreenTestResult("Barbiturates" , "No Result"),
	            		new DrugScreenTestResult("Benzodiazapines" , "No Result"),
	            		new DrugScreenTestResult("Cocaine" , "No Result"),
	            		new DrugScreenTestResult("Marijuana-Cannabinoids" , "No Result"),
	            		new DrugScreenTestResult("Methadone" , "No Result"),
	            		new DrugScreenTestResult("Oxycodone-Percodan" , "No Result"),
	            		new DrugScreenTestResult("Methamphetamines" , "No Result"),
	            		new DrugScreenTestResult("Buprenorphine" , "No Result"),
	            		new DrugScreenTestResult("Morphine" , "No Result")  		            		
	            
	            );
	    
	    
	    private final ObservableList<DrugScreenTestResult> dataForFinalColllumn10PanelTest =
	            FXCollections.observableArrayList(
	            		new DrugScreenTestResult("Amphetamines" , "Nagative", null),
	            		new DrugScreenTestResult("Barbiturates" , "Nagative", null),
	            		new DrugScreenTestResult("Benzodiazapines" , "Nagative", null),
	            		new DrugScreenTestResult("Cocaine" , "Nagative", null),
	            		new DrugScreenTestResult("Marijuana-Cannabinoids" , "Nagative", null),
	            		new DrugScreenTestResult("Methadone" , "Nagative", null),
	            		new DrugScreenTestResult("Oxycodone-Percodan" , "Nagative", null),
	            		new DrugScreenTestResult("Methamphetamines" , "Nagative", null),
	            		new DrugScreenTestResult("Buprenorphine" , "Nagative", null),
	            		new DrugScreenTestResult("Morphine" , "Nagative", null)
	            		
	            
	            );
	    
	  /*  if(medicalActivityCharge.getId()!=null){
	    ccfNumberText.setText(medicalActivityCharge.get);}
	    */
	    private ObservableList<DrugScreenDrugName> DrugScreenDrugNameMasterData = FXCollections.observableArrayList();
	    private ObservableList<DrugScreenTestResult> drugScreenDrugNameMasterDataFromDatabase = FXCollections.observableArrayList();
	    private ObservableList<DrugScreenTestResult> drugScreenRevision = FXCollections.observableArrayList();
	    public void viewDrugScreenDrugName(){
	    /*	viewDrugScreenresult();*/
	    	//MedicalActivityCharge medicalActivityCharge = new MedicalActivityChargeEntityController().searchForDrugScreen(Global.patientVisitObj.getVisitDate(), "RPD DS10", Global.patientVisitObj);
	    	//System.out.println("Drug Screen Chag Size is : " +medicalActivityCharge.getId() );
	    /*	
	    	if(MedicalActivityChargeInputController.activityCodeName != null){
	    		
	    		DrugScreenDrugNameMasterData = new DrugScreenDrugNameEntityController().viewDrugScreenResult(MedicalActivityChargeInputController.activityCodeName);
	    		System.out.println("MedicalActivityChargeINPUT Controller RUN !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
	    	}
	    	if(MedicalActivityChargeEditController.activityCodeName != null){
	    		
	    		DrugScreenDrugNameMasterData = new DrugScreenDrugNameEntityController().viewDrugScreenResult(MedicalActivityChargeEditController.activityCodeName);	
	    			    		
	    	}*/
	    	
	   // DrugScreenTestResult revisionDrug = drugScreenDrugNameTable.getSelectionModel().getSelectedItem();
	    	/********Upper Table***/
	    	
	    	if(drugScreenResult2!=null){	
	    	drugScreenDrugNameMasterDataFromDatabase = new DrugScreenTestResultEntityController().viewDrugScreenByPatientVisitId(Global.patientVisitObj.getId() , MedicalActivityChargeEditController.activityCodeName,drugScreenResult2.getId());
	    	System.out.println(Global.patientVisitObj.getId() +"8*8*8*8*8*8*8*8*8*8"+ MedicalActivityChargeEditController.activityCodeName+"*8*8*8*8*8*8*8*8*8*8");
	    	}
	    		
	    		System.out.println("Patient Visit Id is : " +Global.patientVisitObj.getId());
	    		System.out.println("List Size is : " +drugScreenDrugNameMasterDataFromDatabase.size());
	    		if(drugScreenDrugNameMasterDataFromDatabase.size() > 0){
	    			System.out.println("RUN IF BLOCK ################################");
	    				    			
	    			drugTestNameCollumn.setCellValueFactory(cellData -> cellData.getValue().drugTestNameProperty());
	    				    			
	    			labPrelimCollumn.setCellValueFactory(cellData -> cellData.getValue().prelimResultProperty());
	    						    	
			    	finalCollumn.setCellValueFactory(cellData -> cellData.getValue().finalResultProperty());
			    	drugSplit.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("splitSpecimenResult"));
			    	drugRevision.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, Integer>("revision"));
			    	drugScreenDrugNameTable.setItems(drugScreenDrugNameMasterDataFromDatabase);
			    	
			    	/*if(MedicalActivityChargeEditController.activityCodeName.equals("RPD DS")){
			    		drugScreenDrugNameTable.setItems(drugScreenDrugNameMasterDataFromDatabase);
			    	}else{
			    		drugScreenDrugNameTable.setItems(preliminaryCollumn);
			    	}*/
			    	
			    	
			    	
	    			//setCellValueFactory(new PropertyValueFactory<RepresentRelation, String>("relation"));
			    	
	    		}else{
	    			
	    			System.out.println("RUN ELSE BLOCK !!!!!!!!!!!!!!!!!!!!!!!!!");
	    			DrugScreenDrugNameMasterData = new DrugScreenDrugNameEntityController().viewDrugScreenResult(MedicalActivityChargeEditController.activityCodeName);	
	    			for(int i=0;i<DrugScreenDrugNameMasterData.size(); i++)
	    			{
	    				DrugScreenTestResult drugtestname = new DrugScreenTestResult();
	    				drugtestname.setRevision(0);
	    				drugtestname.setDrugTestName(DrugScreenDrugNameMasterData.get(i).getDrugName());
	    				drugtestname.setPrelimResult(DrugScreenDrugNameMasterData.get(i).getPrelimResult());
	    				drugTestNameList.add(drugtestname);
	    				
	    				
	    			}
	    			drugTestNameCollumn.setCellValueFactory(cellData -> cellData.getValue().drugTestNameProperty());
	    			labPrelimCollumn.setCellValueFactory(cellData -> cellData.getValue().prelimResultProperty());
	    			finalCollumn.setCellValueFactory(cellData -> cellData.getValue().finalResultProperty());
	    			drugRevision.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, Integer>("revision"));
	    			
	    			//List<DrugScreenTestResult> list = drugTestNameList.Stream().collect(Collectors.toList());
	    			//new DrugScreenTestResultEntityController().sortingMaxRevision(drugTestNameList);
	    			drugScreenDrugNameTable.setItems(drugTestNameList);
	    			
	    		/*	if(MedicalActivityChargeEditController.activityCodeName.equals("RPD DS")){
	    				
	    				drugScreenDrugNameTable.setItems(preliminaryCollumn5PanelTest);
	    				
	    			}else if(MedicalActivityChargeEditController.activityCodeName.equals("RPD DS10")){
	    				
	    				drugScreenDrugNameTable.setItems(preliminaryCollumn10PanelTest);
	    				
	    			}*/
			    		    			
	    		}
	    		
	    	}
	    
	   
	    //********************************************************************************//
	    
	    
	    public void viewDrugScreenresult(){
	    	
	    	/*if(medicalActivityCharge.getId()!=null){
	    	    ccfNumberText.setText(drugScreenResult.getCcfNo());
	    	    }
	    	*/
	    	drugScreenResult = new DrugScreenResultEntityController().viewDrugScreenResult(Global.patientVisitObj.getId());
	    	System.out.println("###########" +drugScreenResult.getCcfNo());
	    	    	
	    }
	    
	    private DrugScreenResultEditController drugScreenResultEditController2;
	    private DrugScreenResult drugScreenResult2;
	    public void viewByMedicalChargeId(){
	    	System.out.println("%%%%% "+Global.patientVisitObj.getId()+" "+medicalActivityCharge.getId());
	    	
	    	drugScreenResult2=	new DrugScreenResultEntityController().viewByMedicalChargeId(Global.patientVisitObj.getId(), medicalActivityCharge.getId());
	    	//System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGG"+drugScreenResult2.getId());
	    	/*if(medicalActivityCharge.getId()!= null )
	    	{
	    		if(drugScreenResult!=null)
	    		{
	    			ccfNumberText.setText(drugScreenResult.getCcfNo());
	    		}
	    	}*/
	    	
	    	if(medicalActivityChargeEditController.medicalActivityChargeOb != null){
	    		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	    		if(drugScreenResult2!=null)
	    		{
	    			System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
	    			drugScreenDescription.setText(drugScreenResult2.getMedActCharge().getMedicalActivity().getDescrip());
	    			medTestCode.setText(drugScreenResult2.getMedActCharge().getMedicalActivity().getCode());
	    			ccfNumberText.setText(drugScreenResult2.getCcfNo()!=null?drugScreenResult2.getCcfNo():null);
	    			laboratoryText.setText(drugScreenResult2.getLaboratory()!= null? drugScreenResult2.getLaboratory().getName():null);
	    			LocalDate dateObject = (drugScreenResult2.getCollectionDate()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getCollectionDate()):null);
	    			collectionDate.setValue(dateObject);
	    			orderResultStatusChoiceBox.setValue(drugScreenResult2.getOrderResultStatus());
	    			receiveDate.setValue(drugScreenResult2.getDateReceived()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getDateReceived()):null);
	    			collectionProtocolChoiceBox.setValue(drugScreenResult2.getCollectionProtocol());
	    			testReasonChoiceBox.setValue(drugScreenResult2.getTestReason());
	    			sentDateToLabDateField.setValue(drugScreenResult2.getDateSent()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getDateSent()):null);
	    			reportedToText.setText(drugScreenResult2.getReportedTo());
	    			commentsText.setText(drugScreenResult2.getComments());
	    			finalDetarminationChoiceBox.setValue(drugScreenResult2.getFinalDetarmination());
	    			mroReqDate.setValue((drugScreenResult2.getMroReqDate()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getMroReqDate()):null));
	    			//mroReqDate.setValue(DateConvert.dateToLocalDate(drugScreenResult2.getMroReqDate()));
	    			/*}
	    			else{
	    				mroReqDate.setValue(new Date());
	    			}*/
	    			employeeNotifiedDate.setValue(drugScreenResult2.getEmployeeNotifiedDate()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getEmployeeNotifiedDate()):null);
	    			splitSpecimenReq.setValue(drugScreenResult2.getSplitSpecimenDate()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getSplitSpecimenDate()):null);
	    			splitResultDate.setValue(drugScreenResult2.getSplitResultDate()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getSplitResultDate()):null);
	    			finalDetarminationDate.setValue(drugScreenResult2.getFinalDeterminationDate()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getFinalDeterminationDate()):null);
	    			mroReviewDate.setValue(drugScreenResult2.getMroReviewDate()!=null?DateConvert.dateToLocalDate(drugScreenResult2.getMroReviewDate()):null);
	    			
	    			//drugScreenResultEditController2.setDrugScreenResult(drugScreenResult);
	    			System.out.println("HAVANA"+drugScreenResult2.getId());
	    			
	    		}
	    		
	    	}
	    }
	    /*******************/
	    public void viewDrugScreenRevisions(){
	    	revisionList = FXCollections.observableArrayList();
	    	DrugScreenTestResult revisionDrug = drugScreenDrugNameTable.getSelectionModel().getSelectedItem();
	    	drugScreenRevision = new DrugScreenTestResultEntityController().viewByDrugScreenDrugName(Global.patientVisitObj.getId(), MedicalActivityChargeEditController.activityCodeName, drugScreenResult2.getId(), revisionDrug.getDrugTestName());
	    	drugNameforRevision.setText(revisionDrug.getDrugTestName());
	    	//revisionList.add(revisionDrug);
	    	/**********LOWER TABLE**/
	    	revisedDrugName.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("drugTestName"));
	    	revisedLabPrelim.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("prelimResult"));
	    	revisedFinal.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("finalResult"));
	    	revisedSplit.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("splitSpecimenResult"));
	    	revisionModDate.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("modifiedDate"));
	    	revisionCounts.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("revision"));
			drugRevisionTable.setItems(drugScreenRevision);
	    }
	  
	    public void viewStaticDrugLowerTable(String drug){
	    	
	    	ObservableList<DrugScreenTestResult> staticLowerTable = FXCollections.observableArrayList();
	    	for(int i=0;i<drugTestNameList.size();i++)
	    	{
	    	if(drugTestNameList.get(i).getDrugTestName().equals(drug))
	    		staticLowerTable.add(drugTestNameList.get(i));
	    	
	    	}
	    	
	    	
	    	revisedDrugName.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("drugTestName"));
	    	revisedLabPrelim.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("prelimResult"));
	    	revisedFinal.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("finalResult"));
	    	revisedSplit.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("splitSpecimenResult"));
	    	revisionModDate.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("modifiedDate"));
	    	revisionCounts.setCellValueFactory(new PropertyValueFactory<DrugScreenTestResult, String>("revision"));
	    	drugRevisionTable.setItems(staticLowerTable);
	    }
	  public void setlaboratory(String code){
		  
		  laboratoryText.setText(code);
		  
	  }
	  
	  DrugScreenResult drugScreenResult = new DrugScreenResult();
	  DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResult();
	  
	  public void setDrugScreenResultObject(){
		  
		  LocalDate localDate2 = collectionDate.getValue();
			if(localDate2 != null){
				
				Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				drugScreenResult.setCollectionDate(date2);
									
			}
			
			drugScreenResult.setCcfNo(ccfNumberText.getText());
			
			if(laboratoryText.getText()!=null){
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Warning Dialog");
				//alert.setHeaderText("Look, a Warning Dialog");
				alert.setContentText("Select Laboratory");
				alert.showAndWait();
			}else{
				
				Laboratory laboratory = new LaboratoryEntityController().viewByCode(laboratoryText.getText());
				
				drugScreenResult.setLaboratory(laboratory);
				
			}
			
			LocalDate localDate3 = sentDateToLabDateField.getValue();
			if(localDate3 != null){
				
				Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setDateSent(date3);
				
			}
			
			
			drugScreenResult.setCollectionProtocol(collectionProtocolChoiceBox.getSelectionModel().getSelectedItem());
			
			drugScreenResult.setTestReason(testReasonChoiceBox.getSelectionModel().getSelectedItem());
			
			LocalDate localDate1 = receiveDate.getValue();
			if(localDate1 != null){
				
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setDateReceived(date1);	
				
			}
			
			drugScreenResult.setOrderResultStatus(orderResultStatusChoiceBox.getSelectionModel().getSelectedItem());
			
			LocalDate localDate5 = mroReqDate.getValue();
			if(localDate5 != null){
				
				Date date5 = Date.from(localDate5.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setMroReqDate(date5);	
				
			}
			
			LocalDate localDate6 = employeeNotifiedDate.getValue();
			if(localDate6 != null){
				
				Date date6 = Date.from(localDate6.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setEmployeeNotifiedDate(date6);
				
			}
			
			LocalDate localDate7 = splitSpecimenReq.getValue();
			if(localDate7 != null){
				
				Date date7 = Date.from(localDate7.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setSplitSpecimenDate(date7);
				
			}
			
			LocalDate localDate8 = splitResultDate.getValue();
			if(localDate8 != null){
				
				Date date8 = Date.from(localDate8.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setSplitResultDate(date8);	
				
			}
			
			LocalDate localDate9 = mroReviewDate.getValue();
			if(localDate9 != null){
				
				Date date9 = Date.from(localDate9.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setMroReviewDate(date9);	
				
			}
			
			drugScreenResult.setReportedTo(reportedToText.getText());
			
			drugScreenResult.setFinalDetarmination(finalDetarminationChoiceBox.getSelectionModel().getSelectedItem());
			
			LocalDate localDate10 = finalDetarminationDate.getValue();
			if(localDate10 != null){
				
				Date date10 = Date.from(localDate10.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenResult.setFinalDeterminationDate(date10);	
				
			}
			
			drugScreenResult.setComments(commentsText.getText());
			
			drugScreenResult.setPatientVisit(Global.patientVisitObj);
							
			/*drugScreenResult.setDrugTestCode(drugTestCode);
			drugScreenResult.setDrugTestDescrp(drugTestDescrp);
			
			drugScreenResult.setModificationReason(drugTestDescrp);*/
			//LocalDate localDate11 = receiveDate.getValue();
			/*//if(localDate11 != null){
				
				Date date1 = Date.from(localDate11.atStartOfDay(ZoneId.systemDefault()).toInstant());
				drugScreenTestResult.setModifiedDate(modifiedDate);;	
				
			}
				*/			
			new DrugScreenResultEntityController().saveOrUpdate(drugScreenResult);
			
	  }
	  
	  FXMLFormPath formPath = new FXMLFormPath();
	  
	 private  MedicalActivityChargeEditController medicalActivityChargeEditController;
	 public static MedicalActivityCharge medicalActivityCharge;

	 public void setMedicalchargeObject(MedicalActivityChargeEditController medicalActivityChargeEditController, MedicalActivityCharge medicalActivityCharge) {
		this.medicalActivityChargeEditController = medicalActivityChargeEditController;
		this.medicalActivityCharge=medicalActivityCharge;

		viewByMedicalChargeId();
		viewDrugScreenDrugName();
		
	}
	 /*private DrugScreenResult drugScreenResult1 = new DrugScreenResultEntityController().viewByMedicalChargeId(Global.patientVisitObj.getId(), medicalActivityCharge.getId());
	 private void show(){
		 System.out.println(drugScreenResult1.getId()+"MISSISIPPII");
	 }*/
	 
	 
	 
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Pre Placement");
		list1.add("Random");
		list1.add("Post Accident");
		list1.add("Annual");
		list1.add("Periodic");
		list1.add("Recertification");
		list1.add("Treatement Follow-Up");
		list1.add("Reasonable Suspicion");
		list1.add("Return to Duty");
		list1.add("Follow-Up");
		list1.add("Other");
		
		ObservableList obList1 = FXCollections.observableList(list1);
		testReasonChoiceBox.setItems(obList1);
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Federal");
		list2.add("Non-Federal");
		list2.add("Federal Look Al");
		
		ObservableList obList2 = FXCollections.observableList(list2);
		collectionProtocolChoiceBox.setItems(obList2);
		
		List<String> list3 = new ArrayList<String>();
		list3.add("Final");
		list3.add("Preliminary");
		list3.add("Incomplete");
		list3.add("Correction");
		list3.add("No Result");
		
		ObservableList obList3 = FXCollections.observableList(list3);
		orderResultStatusChoiceBox.setItems(obList3);
		
		List<String> list4 = new ArrayList<String>();
		list4.add("Pending");
		list4.add("Negative");
		list4.add("Negative-Dilute");
		list4.add("Rejected for Testing");
		list4.add("Positive");
		list4.add("Positive-Dilute");
		list4.add("Adulterated");
		list4.add("Substituted");
		list4.add("Shy Bladder");
		list4.add("Invalid Result");
		list4.add("Invalid Specimen");
		list4.add("Test Canceled");
		list4.add("Refusal to Test");
		list4.add("No Test");
		list4.add("Collection Only");
		
		
		ObservableList obList4 = FXCollections.observableList(list4);
		orderResultStatusChoiceBox.setItems(obList4);
				
		//DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResult();
		//private DrugScreenTestResult drugScreenTestResultOb;
		
		setAllNegativeBtn.setOnAction((event) -> {
			
			drugTestNameCollumn.setCellValueFactory(cellData -> cellData.getValue().drugTestNameProperty());
			finalCollumn.setCellValueFactory(cellData -> cellData.getValue().finalResultProperty());
			labPrelimCollumn.setCellValueFactory(null);
			
			if(MedicalActivityChargeEditController.activityCodeName.equals("RPD DS")){
				
				drugScreenDrugNameTable.setItems(dataForFinalColllumn5PanelTest);
				
			}else if(MedicalActivityChargeEditController.activityCodeName.equals("RPD DS10")){
				
				drugScreenDrugNameTable.setItems(dataForFinalColllumn10PanelTest);
			}
			
	    	//drugScreenDrugNameTable.setItems(dataForFinalColllumn5PanelTest);
    		
    		for(DrugScreenTestResult drugScreenTestresultName : drugScreenDrugNameTable.getItems()){
				
				DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResult();
				
				//String drugTestName = drugTestNameCollumn.getCellObservableValue(drugName).getValue();
				drugScreenTestresultName.setDrugTestName(drugTestNameCollumn.getCellObservableValue(drugScreenTestresultName).getValue());
             
				String finalResult = finalCollumn.getCellObservableValue(drugScreenTestresultName).getValue();
				drugScreenTestresultName.setFinalResult(finalResult);
				
				drugScreenTestresultName.setMedicalActivityCode(MedicalActivityChargeEditController.activityCodeName);
				drugScreenTestresultName.setPatient(Global.patient);
				drugScreenTestresultName.setPatientVisit(Global.patientVisitObj);
				drugScreenTestresultName.setDrugScreenId(drugScreenResult);
				
				new DrugScreenTestResultEntityController().saveOrUpdate(drugScreenTestresultName);
				
			}
    		
    		setDrugScreenResultObject();    						
				
		});
				/*Write save Save Function here */
				
				/*for(DrugScreenDrugName drugName : drugScreenDrugNameTable.getItems()){
					
					DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResult();
					String finalResult = finalCollumn.getCellObservableValue(drugName).getValue();
					System.out.println("Size : " +finalResult);
					new DrugScreenTestResultEntityController().saveOrUpdate(drugScreenTestResult);
					
				}*/
		
		changeOneResultBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("EditDrugScreen", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditDrugScreen", null, Locale.US);
				
				
				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				
				formPath.closeApplicationContext();
				
				
				
				if(drugScreenResult2!= null){
					DrugScreenTestResult drugScreenTestResult = drugScreenDrugNameTable.getSelectionModel().getSelectedItem();
					if (drugScreenTestResult != null) {

						DrugScreenResultEditController drugScreenResultEditController =
								(DrugScreenResultEditController) new FXFormCommonUtilities().displayForm(formName, formTitle);
								
								drugScreenResultEditController.setDrugScreenResultInputController(this, drugScreenTestResult,drugScreenResult2);
								System.out.println("CROATIA"+drugScreenTestResult.getId());
								//System.out.println("KOLKATA"+drugScreenTestResult.getDrugScreenId());
								//drugScreenResultEditController2.setDrugScreenResult(drugScreenResult2);
								//drugScreenTestResult.setDrugScreenId(drugScreenResult2);

					} else {

						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText(editInfo);
						alert.showAndWait();
						
						/*Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning Dialog");
						alert.setHeaderText("Look, a Warning Dialog");
						alert.setContentText("No item is selected");

						alert.showAndWait();*/
					}
				
				}
				else
				{
					DrugScreenTestResult drugScreenTestResult = drugScreenDrugNameTable.getSelectionModel().getSelectedItem();
					
					if (drugScreenTestResult != null) {
						Integer drugScreenindx = drugScreenDrugNameTable.getSelectionModel().getSelectedItem().getId();
					DrugScreenResultEditController drugScreenResultEditController =
							(DrugScreenResultEditController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					drugScreenResultEditController.setDrugScreenResultInputController1(this, drugScreenTestResult,drugScreenResult2,drugScreenindx);
					//ObservableList<DrugScreenTestResult> allMaxRevisions= 
							//new DrugScreenTestResultEntityController().sortingMaxRevision(drugTestNameList);
						/* drugScreenDrugNameTable.setItems(allMaxRevisions); */
					} else {
						
						/*Alert alert = new Alert(AlertType.WARNING);
						alert.setTitle("Warning Dialog");
						alert.setHeaderText("Look, a Warning Dialog");
						alert.setContentText("No item is selected");

						alert.showAndWait();*/
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle(infoDialogBoxTitle);
						alert.setHeaderText(null);
						alert.setContentText(editInfo);
						alert.showAndWait();
					}
					
				}
				
				
				
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});	
		
		laboratoryBtn.setOnAction((event) -> {
			try {
				// Load Laboratory Details Entry form .

				String formName = formPath.context.getMessage("Laboratory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Laboratory", null, Locale.US);
				formPath.closeApplicationContext();
				
				LaboratoryViewController laboratoryViewController =
				(LaboratoryViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				laboratoryViewController.setDrugScreenResultInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		okBtn.setOnAction((event) -> {
			try {
				
				/*DrugScreenResult drugScreenResult = new DrugScreenResult();*/
				
				LocalDate localDate2 = collectionDate.getValue();
				if(localDate2 != null){
					
					Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
					
					drugScreenResult.setCollectionDate(date2);
										
				}
				
				drugScreenResult.setCcfNo(ccfNumberText.getText());
				
				if(laboratoryText.getText()!=null){
					
				}else{
					
					Laboratory laboratory = new LaboratoryEntityController().viewByCode(laboratoryText.getText());
					
					drugScreenResult.setLaboratory(laboratory);
					
				}
				
				LocalDate localDate3 = sentDateToLabDateField.getValue();
				if(localDate3 != null){
					
					Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setDateSent(date3);
					
				}
				
				
				drugScreenResult.setCollectionProtocol(collectionProtocolChoiceBox.getSelectionModel().getSelectedItem());
				
				drugScreenResult.setTestReason(testReasonChoiceBox.getSelectionModel().getSelectedItem());
				
				LocalDate localDate1 = receiveDate.getValue();
				if(localDate1 != null){
					
					Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setDateReceived(date1);	
					
				}
				
				drugScreenResult.setOrderResultStatus(orderResultStatusChoiceBox.getSelectionModel().getSelectedItem());
				
				LocalDate localDate5 = mroReqDate.getValue();
				if(localDate5 != null){
					
					Date date5 = Date.from(localDate5.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setMroReqDate(date5);	
					
				}
				
				LocalDate localDate6 = employeeNotifiedDate.getValue();
				if(localDate6 != null){
					
					Date date6 = Date.from(localDate6.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setEmployeeNotifiedDate(date6);
					
				}
				
				LocalDate localDate7 = splitSpecimenReq.getValue();
				if(localDate7 != null){
					
					Date date7 = Date.from(localDate7.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setSplitSpecimenDate(date7);
					
				}
				
				LocalDate localDate8 = splitResultDate.getValue();
				if(localDate8 != null){
					
					Date date8 = Date.from(localDate8.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setSplitResultDate(date8);	
					
				}
				
				LocalDate localDate9 = mroReviewDate.getValue();
				if(localDate9 != null){
					
					Date date9 = Date.from(localDate9.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setMroReviewDate(date9);	
					
				}
				
				drugScreenResult.setReportedTo(reportedToText.getText());
				
				drugScreenResult.setFinalDetarmination(finalDetarminationChoiceBox.getSelectionModel().getSelectedItem());
				
				LocalDate localDate10 = finalDetarminationDate.getValue();
				if(localDate10 != null){
					
					Date date10 = Date.from(localDate10.atStartOfDay(ZoneId.systemDefault()).toInstant());
					drugScreenResult.setFinalDeterminationDate(date10);	
					
				}
				
				drugScreenResult.setComments(commentsText.getText());
				
				drugScreenResult.setPatientVisit(Global.patientVisitObj);
				drugScreenResult.setMedActCharge(medicalActivityCharge);
								
				/*drugScreenResult.setDrugTestCode(drugTestCode);
				drugScreenResult.setDrugTestDescrp(drugTestDescrp);
				
				drugScreenResult.setModificationReason(drugTestDescrp);*/
								
				new DrugScreenResultEntityController().saveOrUpdate(drugScreenResult);
				DrugScreenResult drugScreenResultTemp = drugScreenResult;
				DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResult();
				
				//drugScreenTestResult.setDrugScreenId(drugScreenResult);
				//new DrugScreenTestResultEntityController().saveOrUpdate(drugScreenTestResult);
				if(drugTestNameList!=null)
				{
					for(int i=0;i<drugTestNameList.size();i++){
						if(drugTestNameList.get(i).getDrugScreenId()==null){
							drugScreenTestResult = drugTestNameList.get(i);
							drugScreenTestResult.setDrugScreenId(drugScreenResultTemp);
							drugScreenTestResult.setMedicalActivityCode(drugScreenResultTemp.getMedActCharge().getMedicalActivity().getCode());
							drugScreenTestResult.setPatientVisit(Global.patientVisitObj);
							drugScreenTestResult.setPatient(Global.patient);
						}
						
					new DrugScreenTestResultEntityController().saveOrUpdate(drugScreenTestResult);
					}
				}
				
				new FXFormCommonUtilities().closeForm( okBtn);
			
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		employerReportBtn.setOnAction((event) -> {
			
			try {
				
				setDrugScreenResultObject();
				//DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResultEntityController().viewByPatientId(Global.patient.getId());
				
				String formName = formPath.context.getMessage("EmployerReport", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EmployerReport", null, Locale.US);
				formPath.closeApplicationContext();
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				EmployerReportGUIController employerReportGUIController = fxmlLoader.getController();
				employerReportGUIController.setDrugScreenTestResult(drugScreenDrugNameMasterDataFromDatabase);
				//employerReportGUIController.setCarrierViewController(this);
				stage.show();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
mroRequestBtn.setOnAction((event) -> {
			
			try {
				
				setDrugScreenResultObject();
				DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResultEntityController().viewByPatientId(Global.patient.getId());
				
				String formName = formPath.context.getMessage("MRORequest", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MRORequest", null, Locale.US);
				formPath.closeApplicationContext();
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				MroRequestFormGUIController mroRequestFormGUIController = fxmlLoader.getController();
				mroRequestFormGUIController.setDrugScreenTestResult(drugScreenDrugNameMasterDataFromDatabase);
				stage.show();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*mroRequestBtn.setOnAction((event) -> {
			try {
				
				setDrugScreenResultObject();
				DrugScreenTestResult drugScreenTestResult = new DrugScreenTestResultEntityController().viewByPatientId(Global.patient.getId());
				
				String formName = formPath.context.getMessage("MRORequest", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MRORequest", null, Locale.US);
				formPath.closeApplicationContext();
				
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				MroRequestFormGUIController mroRequestFormGUIController = fxmlLoader.getController();
				mroRequestFormGUIController.setDrugScreenTestResult(drugScreenTestResult);
				stage.show();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		
		
		cancelBtn.setOnAction((event) -> {
			try {
				//cancel centralized form
				new FXFormCommonUtilities().closeForm( cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
