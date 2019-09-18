package com.ets.controller.gui.drugScreen;

import java.net.URL;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.aop.framework.adapter.GlobalAdvisorAdapterRegistry;

import com.ets.controller.entity.drugScreenTestResult.DrugScreenTestResultEntityController;
import com.ets.controller.gui.medicalActivityCharge.MedicalActivityChargeEditController;
import com.ets.model.DrugScreenResult;
import com.ets.model.DrugScreenTestResult;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;
import com.itextpdf.text.log.SysoCounter;
import com.mchange.v2.c3p0.impl.NewProxyDatabaseMetaData;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class DrugScreenResultEditController implements Initializable{
	
	   @FXML
	    private ChoiceBox<String> labResultChoiceBox;

	    @FXML
	    private TextField textResultText;

	    @FXML
	    private TextField testNameText;

	    @FXML
	    private TextField numaricResultText;

	    @FXML
	    private TextField unitsText;

	    @FXML
	    private TextField rangeText;

	    @FXML
	    private ChoiceBox<String> finalResultChoiceBox;

	    @FXML
	    private ChoiceBox<String> preliminaryResultChoiceBox;

	    @FXML
	    private ChoiceBox<String> splitSpecimenResultChoiceBox;

	    @FXML
	    private TextField resultSummaryText;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button cancelBtn;

	    @FXML
	    private TextArea describeReasonTextarea;

	    @FXML
	    private Label substanceLabel;
	
	    
	    private String defaultVal = "Negative";
	    private Integer revision;
	private DrugScreenTestResult drugScreenTestResult;
	 
	private DrugScreenResult drugScreenId;
	private Integer drugScreenindx;
	//List<DrugScreenTestResult> staticListDrugScreenTest = FXCollections.observableList(list);
	private DrugScreenResultInputController drugScreenResultInputController;
	//private DrugScreenResultInputController drugScreenResultInputController2;

	public void setDrugScreenResultInputController(DrugScreenResultInputController drugScreenResultInputController ,DrugScreenTestResult drugScreenTestResult ,DrugScreenResult drugScreenId) {
		this.drugScreenResultInputController = drugScreenResultInputController;
		this.drugScreenTestResult = drugScreenTestResult;
		this.drugScreenId = drugScreenId;
		revision = drugScreenTestResult.getRevision();
		if(drugScreenTestResult!=null){
			System.out.println("MISSISIPPI"+this.drugScreenTestResult.getDrugTestName());
		}
		setDrugScreenTestResultInfo();
	}
	
	public void setDrugScreenResultInputController1(DrugScreenResultInputController drugScreenResultInputController ,DrugScreenTestResult drugScreenTestResult ,DrugScreenResult drugScreenId,Integer drugScreenindx) {
	
		this.drugScreenResultInputController = drugScreenResultInputController;
		this.drugScreenTestResult = drugScreenTestResult;
		this.drugScreenId = drugScreenId;
		revision = drugScreenTestResult.getRevision();
		/*if(drugScreenTestResult!=null){
			System.out.println("MISSISIPPI"+this.drugScreenTestResult.getDrugTestName());
		}*/
		this.drugScreenindx = drugScreenindx;
		setDrugScreenTestResultInfo();
	}
	
	
	
	/*public void setDrugScreenResult(DrugScreenResult drugScreenId) {
		//this.drugScreenResultInputController2 = drugScreenResultInputController2;
		this.drugScreenId =drugScreenId;
		if(drugScreenId!=null){
			System.out.println("MISSISIPPI"+this.drugScreenId.getId());
		}
	}*/

	public void setDrugScreenTestResultInfo(){
				
		substanceLabel.setText(drugScreenTestResult.getDrugTestName());
		preliminaryResultChoiceBox.setValue(drugScreenTestResult.getPrelimResult());
		finalResultChoiceBox.setValue(drugScreenTestResult.getFinalResult());
		splitSpecimenResultChoiceBox.setValue(drugScreenTestResult.getSplitSpecimenResult());
		resultSummaryText.setText(drugScreenTestResult.getResultSummary());
		testNameText.setText(drugScreenTestResult.getTestName());
		textResultText.setText(drugScreenTestResult.getTextResult());
		labResultChoiceBox.setValue(drugScreenTestResult.getLabResult());
		numaricResultText.setText(drugScreenTestResult.getNumaricResult());
		unitsText.setText(drugScreenTestResult.getUnits());
		rangeText.setText(drugScreenTestResult.getRefRange());
		describeReasonTextarea.setText(drugScreenTestResult.getDescribeReason());
		System.out.println(drugScreenResultInputController.drugScreenTestResult.getDrugScreenId()+"%%%%%%%%%%%%%%%%%%DDDDDDDDDDD");
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		List<String> list1 = new ArrayList<String>();
		list1.add("No Result");
		list1.add("Negative");
		list1.add("Possitive");
		list1.add("Complete");
		
		
		ObservableList preliminaryResult = FXCollections.observableList(list1);
		preliminaryResultChoiceBox.setItems(preliminaryResult);
		
		
		List<String> list2 = new ArrayList<String>();
		list2.add("Negative");
		list2.add("Possitive");
		list2.add("Complete");
		
		
		ObservableList finalResult = FXCollections.observableList(list2);
		finalResultChoiceBox.setItems(finalResult);
		
		
		List<String> list3 = new ArrayList<String>();
		list3.add("Negative");
		list3.add("Possitive");
		list3.add("Complete");
		list3.add("Requested");
		
		
		ObservableList splitSpecimenResult = FXCollections.observableList(list3);
		splitSpecimenResultChoiceBox.setItems(splitSpecimenResult);
		
		
		List<String> list4 = new ArrayList<String>();
		list4.add("Final");
		list4.add("Preliminary");
		list4.add("InComplete");
		list4.add("Correction");
		list4.add("No Result");
		
		
		ObservableList labResult = FXCollections.observableList(list4);
		labResultChoiceBox.setItems(labResult);
		
		okBtn.setOnAction((event) -> {
			try {
				DrugScreenTestResult drugScreenTestResult1 = new DrugScreenTestResult();
				
				drugScreenTestResult1.setPrelimResult(preliminaryResultChoiceBox.getSelectionModel().getSelectedItem());
				drugScreenTestResult1.setFinalResult(finalResultChoiceBox.getSelectionModel().getSelectedItem());
				drugScreenTestResult1.setSplitSpecimenResult(splitSpecimenResultChoiceBox.getSelectionModel().getSelectedItem());
				drugScreenTestResult1.setResultSummary(resultSummaryText.getText());
				drugScreenTestResult1.setTestName(testNameText.getText());
				drugScreenTestResult1.setTextResult(textResultText.getText());
				drugScreenTestResult1.setLabResult(labResultChoiceBox.getSelectionModel().getSelectedItem());
				drugScreenTestResult1.setNumaricResult(numaricResultText.getText());
				drugScreenTestResult1.setUnits(unitsText.getText());
				drugScreenTestResult1.setRefRange(rangeText.getText());
				drugScreenTestResult1.setDescribeReason(describeReasonTextarea.getText());
				drugScreenTestResult1.setDrugScreenId(drugScreenId);
				drugScreenTestResult1.setDrugTestName(drugScreenTestResult.getDrugTestName());
				drugScreenTestResult1.setPatient(Global.patient);
				drugScreenTestResult1.setPatientVisit(Global.patientVisitObj);
				drugScreenTestResult1.setMedicalActivityCode(drugScreenResultInputController.medicalActivityCharge.getMedicalActivity().getCode());
				drugScreenTestResult1.setModifiedDate(new Date());
				

				if(preliminaryResultChoiceBox.getSelectionModel().getSelectedItem()!= defaultVal && describeReasonTextarea.getText().length()!=0){
					if(revision!=null && revision!=0){
											
					++revision;
					}
					else{
						revision=1;
					}
					drugScreenTestResult1.setRevision(revision);
					System.out.println("tyutytytytyutyutytyu");
					if(drugScreenindx == null){
						System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+drugScreenId);
						new DrugScreenTestResultEntityController().saveOrUpdate(drugScreenTestResult1);
						new DrugScreenTestResultEntityController().viewDrugScreenByPatientVisitId(Global.patientVisitObj.getId() , MedicalActivityChargeEditController.activityCodeName, drugScreenId.getId());
						drugScreenResultInputController.viewDrugScreenDrugName();	
					
						}
						else{
							
							
							/***********************/
							//List<Drug>
							drugScreenResultInputController.drugTestNameList.add(drugScreenTestResult1);
							ObservableList<DrugScreenTestResult> allMaxRevisions= new DrugScreenTestResultEntityController().sortingMaxRevision(drugScreenResultInputController.drugTestNameList);
							drugScreenResultInputController.setTempDrugScreen(allMaxRevisions);
							
							for(DrugScreenTestResult sortRevision : allMaxRevisions){
							System.out.println("%%%%%%%%%%%%%"+sortRevision.getDrugTestName()+" "+allMaxRevisions.size());
							}
						}
						
					
				}
				else{
					System.out.println("@@@@@@@@@@@@@@@#################$$$$$$$$$$");
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Warning Dialog");
					//alert.setHeaderText("Look, a Warning Dialog");
					alert.setContentText("Give a description for modification");
					alert.showAndWait();
				}
					
					/*Calendar calendar = Calendar.getInstance();

					
					java.util.Date currentDate = calendar.getTime();

					
					java.sql.Date date = new java.sql.Date(currentDate.getTime());*/
					//drugScreenTestResult.setModifiedDate(new Date());	
					
			
				
				//new DrugScreenTestResultEntityController().saveOrUpdate(drugScreenTestResult1);
	
					
				new FXFormCommonUtilities().closeForm( okBtn);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
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
