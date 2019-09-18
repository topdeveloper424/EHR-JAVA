package com.ets.controller.gui.companyProtocol;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.companyOptionalProtocolActivity.CompanyOptionalProtocolActivityEntityController;
import com.ets.controller.entity.companyStandardProtocolActivity.CompanyStandardProtocolActivityEntityController;
import com.ets.controller.gui.medicalActivity.MedicalActivityViewController;
import com.ets.model.CompanyOptionalProtocolActivity;
import com.ets.model.CompanyStandardProtocolActivity;
import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CompanyOptionalProtocolActivityEditController implements Initializable{
	@FXML
    private Button cancelBtn;

    @FXML
    private Button okBtn;
    
    @FXML
    private Button activitySearchBtn;

    @FXML
    private Label activityLabel;

    @FXML
    private ChoiceBox<String> overridePayerTypeChoiceBox;

    @FXML
    private TextField overrideChargeText;

    @FXML
    private CheckBox noChargeCheckBox;

    @FXML
    private TextField onlyUponAgeText;

    @FXML
    private ChoiceBox<String> onlyForSexChoiceBox;

    @FXML
    private TextField stopAtAgeText;

    @FXML
    private ChoiceBox<String> onlyForEthnicChoiceBox;
    
    public MedicalActivityViewController medicalActivityViewController;

	public void setMedicalActivityViewController(MedicalActivityViewController medicalActivityViewController) {
		this.medicalActivityViewController = medicalActivityViewController;
	}
   
	private MedicalActivity medicalActivity;
	
	public void setMedicalActivity(MedicalActivity medicalActivity) {
		this.medicalActivity = medicalActivity;
	}
	
	

	public void setMedicalActivityObject(MedicalActivity medicalActivity2){
		
		activityLabel.setText(medicalActivity2.getDescrip());
		medicalActivity  = medicalActivity2;
	}
	
   	
   	private CompanyProtocolInputController companyProtocolInputController;
   
	public void setCompanyProtocolInputController(CompanyProtocolInputController companyProtocolInputController) {
		this.companyProtocolInputController = companyProtocolInputController;
	}
	
	
	private CompanyProtocolEditController companyProtocolEditController;
	   
	public void setCompanyProtocolEditController(CompanyProtocolEditController companyProtocolEditController) {
		this.companyProtocolEditController = companyProtocolEditController;
	}
 
	private CompanyOptionalProtocolActivity  companyOptionalProtocolActivity;
	private Integer optionalProtocolTableIndex;
	public void setCompanyOptionalProtocolActivity(CompanyOptionalProtocolActivity companyOptionalProtocolActivity,Integer optionalProtocolTableIndex){
		this.companyOptionalProtocolActivity=companyOptionalProtocolActivity;
		    this.optionalProtocolTableIndex = optionalProtocolTableIndex;
	
			medicalActivity = companyOptionalProtocolActivity.getMedicalActivity();
			if(companyOptionalProtocolActivity.getMedicalActivity()!=null){
			activityLabel.setText(companyOptionalProtocolActivity.getMedicalActivity().getCode());
			} 
			overridePayerTypeChoiceBox.setValue(companyOptionalProtocolActivity.getOverridePayerType());
			overrideChargeText.setText(companyOptionalProtocolActivity.getOverrideCharge());
			
			if(companyOptionalProtocolActivity.getNoCharge() == true){
				noChargeCheckBox.setSelected(true);
			}
			onlyUponAgeText.setText(companyOptionalProtocolActivity.getUponAge());
			stopAtAgeText.setText(companyOptionalProtocolActivity.getStopAge());
			onlyForSexChoiceBox.setValue(companyOptionalProtocolActivity.getForSex());
			onlyForEthnicChoiceBox.setValue(companyOptionalProtocolActivity.getEthnic());
		
	}
	

	FXMLFormPath formPath = new FXMLFormPath();
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		List<String> list1 = new ArrayList<String>();

		list1.add("Default");
		list1.add("Employer");
		list1.add("Patient");
		
		ObservableList payerTypeList = FXCollections.observableList(list1);
		overridePayerTypeChoiceBox.getItems().clear();
		overridePayerTypeChoiceBox.setItems(payerTypeList);
		
		List<String> list2 = new ArrayList<String>();

		list2.add("Male");
		list2.add("Female");
				
		ObservableList forSexList = FXCollections.observableList(list2);
		onlyForSexChoiceBox.getItems().clear();
		onlyForSexChoiceBox.setItems(forSexList);
		
		
		List<String> list3 = new ArrayList<String>();

		list3.add("Asian");
		list3.add("Black");
		list3.add("Caucasian");
		list3.add("Hispanic");
				
		ObservableList ethnicList = FXCollections.observableList(list3);
		onlyForEthnicChoiceBox.getItems().clear();
		onlyForEthnicChoiceBox.setItems(ethnicList);
		okBtn.setOnAction((event) -> {
        	try {
        		CompanyOptionalProtocolActivity optionalProtocolActivity = new  CompanyOptionalProtocolActivity();
				/*if(companyStandardProtocolActivityEdit!=null){
					standardProtocolActivity=companyStandardProtocolActivityEdit;
					
				}
        		*/
        		
        		if(medicalActivityViewController != null){
					
        			optionalProtocolActivity.setMedicalActivity(medicalActivity);
					
				}
				
        		optionalProtocolActivity.setEthnic(onlyForEthnicChoiceBox.getSelectionModel().getSelectedItem());
        		optionalProtocolActivity.setForSex(onlyForSexChoiceBox.getSelectionModel().getSelectedItem());
        		optionalProtocolActivity.setNoCharge(noChargeCheckBox.isSelected());
        		optionalProtocolActivity.setOverrideCharge(overrideChargeText.getText());
        		optionalProtocolActivity.setOverridePayerType(overridePayerTypeChoiceBox.getSelectionModel().getSelectedItem());
        		optionalProtocolActivity.setStopAge(stopAtAgeText.getText());
        		optionalProtocolActivity.setUponAge(onlyUponAgeText.getText());
        		//optionalProtocolActivity.setInactive(false);
                 if(medicalActivity!=null){
                	 optionalProtocolActivity.setMedicalActivity(medicalActivity);
        			
        		 }
				
               /*  if(companyProtocolInputController!=null){
                	
                	 CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList.set(standardProtocolTableIndex, standardProtocolActivity); 
                	 companyProtocolInputController.viewCompanyStandardProtocolActivity();
                 
                 }*/
                 
                 if((companyProtocolInputController!=null)||(companyProtocolEditController!=null?
                		companyProtocolEditController.companyProtocol!=null?
                        (companyProtocolEditController.companyProtocol.getId()==null||
                        companyProtocolEditController.companyProtocol.getId()==0):false:false)){
                   
                	
                	 CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList.set(optionalProtocolTableIndex, optionalProtocolActivity); 
                    
                	 if(companyProtocolInputController!=null){
                		  
                    	  companyProtocolInputController.viewCompanyOptionalProtocolActivity();
                    	
                      }
                      if(companyProtocolEditController!=null){
                    	  companyProtocolEditController.observableListOpt=FXCollections.observableArrayList();
                    	  companyProtocolEditController.observableListOpt.addAll(CompanyOptionalProtocolActivityInputController.companyOptionalProtocolActivityList);
                    	  companyProtocolEditController.viewCompanyOptionalProtocolActivity(); 
                    	 
                      }
                     
                 }
                 
                 
                  else{
                	 
                	  optionalProtocolActivity.setCompanyProtocol(CompanyProtocolEditController.companyProtocol);
                	  optionalProtocolActivity.setId(companyOptionalProtocolActivity.getId());
                 	  
                 	  new CompanyOptionalProtocolActivityEntityController().saveCompanyOptionalProtocolActivity(optionalProtocolActivity);
                 	  companyProtocolEditController.observableListOpt=
                  			  new CompanyOptionalProtocolActivityEntityController().viewCompanyOptionalProtocolActivityByProtocolId(CompanyProtocolEditController.companyProtocol.getId());
                  
                 	 companyProtocolEditController.viewCompanyOptionalProtocolActivity();
                 }
                 
                 
                 
                 
                 
                 
                 
                /*  if(companyProtocolEditController!=null){
        			
        			 if(CompanyProtocolViewController.company==null){
      				   CompanyStandardProtocolActivityInputController.companyStandardProtocolActivityList.set(standardProtocolTableIndex,standardProtocolActivity);
                         companyProtocolInputController.viewCompanyStandardProtocolActivity();
                        }else{
                        	
                      	  standardProtocolActivity.setCompanyProtocol(CompanyProtocolEditController.companyProtocol);
                      	  standardProtocolActivity.setId(companyStandardProtocolActivity.getId());
                      	  
                      	  new CompanyStandardProtocolActivityEntityController().saveCompanyStandardProtocolActivity(standardProtocolActivity);
                      	  
                      	  medicalActivityViewController.companyProtocolEditController.observableListStd=
                      			  new CompanyStandardProtocolActivityEntityController().viewCompanyStandardProtocolActivityByProtocolId(CompanyProtocolEditController.companyProtocol.getId());
                      
                      	  medicalActivityViewController.companyProtocolEditController.viewCompanyStandardProtocolActivity();
                        
                        
                        }
        			*/
        			
                 new FXFormCommonUtilities().closeForm(okBtn);
        	
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		activitySearchBtn.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				MedicalActivityViewController activityViewController =
				(MedicalActivityViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				activityViewController.setCompanyOptionalProtocolActivityEditController(this);

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
