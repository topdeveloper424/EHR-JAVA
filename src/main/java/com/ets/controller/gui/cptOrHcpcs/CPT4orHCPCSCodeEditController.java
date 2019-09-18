package com.ets.controller.gui.cptOrHcpcs;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.cpt4.Cpt4EntityController;
import com.ets.model.CptCode4Hcpcs;
import com.ets.utils.DateConvert;
import com.ets.utils.FXFormCommonUtilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class CPT4orHCPCSCodeEditController implements Initializable {
	
	 	@FXML
	    private TextField codeTextField;

	    @FXML
	    private TextField descriptionTextField;

	    @FXML
	    private ChoiceBox<String> copyTypeChoiceBox;

	    @FXML
	    private CheckBox inactiveCheckBox;

	    @FXML
	    private TextField idTextField;

	    @FXML
	    private TextField workCompCurrentChargeTextField;

	    @FXML
	    private TextField workCompFutureChargeTextField;

	    @FXML
	    private DatePicker workCompCurrentDateField;

	    @FXML
	    private DatePicker workCompFutureDateField;

	    @FXML
	    private TextField usualCurrentChargeTextField;

	    @FXML
	    private TextField usualFutureChargeTextField;

	    @FXML
	    private DatePicker usualFutureDateField;

	    @FXML
	    private DatePicker usualCurrentDateField;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private Button updateButton;
	    
	    private CPTorHCPCSCodeViewController cPTorHCPCSCodeViewController;
	    

	    public void setcPTorHCPCSCodeViewController(CPTorHCPCSCodeViewController cPTorHCPCSCodeViewController) {
			this.cPTorHCPCSCodeViewController = cPTorHCPCSCodeViewController;
		}
	    
	    private CptCode4Hcpcs cptCode4Hcpcs;
	    

	    public void setCptCode4Hcpcs(CptCode4Hcpcs cptCode4Hcpcs) {
			this.cptCode4Hcpcs = cptCode4Hcpcs;
			
			idTextField.setText(Integer.toString(cptCode4Hcpcs.getId()));
			codeTextField.setText(cptCode4Hcpcs.getCode());
			copyTypeChoiceBox.setValue(cptCode4Hcpcs.getCodeType());
			descriptionTextField.setText(cptCode4Hcpcs.getDescrp());
			
			if(cptCode4Hcpcs.getInactive() == true){
				
				inactiveCheckBox.setSelected(true);
			}
			
			usualCurrentChargeTextField.setText(cptCode4Hcpcs.getPvtPracticeCrgCurrent());
			
			Date date1 = cptCode4Hcpcs.getPvtPracticeEffective();
			
			if(date1 != null){
				
				 LocalDate localDate1 = new DateConvert().dateToLocalDate(date1);
									
				usualCurrentDateField.setValue(localDate1);
				
			}
			
			usualFutureChargeTextField.setText(cptCode4Hcpcs.getPvtPracticeFutureCrg());
			
			Date date2 = cptCode4Hcpcs.getPvtPracticeFutureEfective();
			
			if(date2 != null){
				
				 LocalDate localDate2 = new DateConvert().dateToLocalDate(date2);
									
				usualFutureDateField.setValue(localDate2);
				
			}
			
			workCompCurrentChargeTextField.setText(cptCode4Hcpcs.getWrkCompCrgCurrent());
			
			Date date3 = cptCode4Hcpcs.getPvtPracticeFutureEfective();
					
					if(date3 != null){
						
						 LocalDate localDate3 = new DateConvert().dateToLocalDate(date3);
											
						 usualCurrentDateField.setValue(localDate3);
						
					}
			
			workCompFutureChargeTextField.setText(cptCode4Hcpcs.getWrkCompFutureCrg());
			
			Date date4 = cptCode4Hcpcs.getPvtPracticeFutureEfective();
					
					if(date4 != null){
						
						 LocalDate localDate4 = new DateConvert().dateToLocalDate(date4);
											
						 workCompFutureDateField.setValue(localDate4);
						
					}
					
			
		}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
List<String> list = new ArrayList<String>();
		
		list.add("CPT Code");
		list.add("HCPCS Code");
		list.add("Other");
		ObservableList obList = FXCollections.observableList(list);
		copyTypeChoiceBox.getItems().clear();
		copyTypeChoiceBox.setItems(obList);
		
		
		updateButton.setOnAction((event) -> {
			try {
				CptCode4Hcpcs cptCode = new CptCode4Hcpcs();
				
				cptCode.setId(Integer.parseInt(idTextField.getText()));
				cptCode.setCode(codeTextField.getText());
				cptCode.setCodeType( copyTypeChoiceBox.getSelectionModel().getSelectedItem());
				cptCode.setDescrp(descriptionTextField.getText());
				cptCode.setInactive(inactiveCheckBox.isSelected());
				cptCode.setPvtPracticeCrgCurrent(usualCurrentChargeTextField.getText());
				
				LocalDate localDate1 = usualCurrentDateField.getValue();
				if(localDate1 != null){
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				cptCode.setPvtPracticeEffective(date1);
				}
				cptCode.setPvtPracticeFutureCrg(usualFutureChargeTextField.getText());
				
				LocalDate localDate2 = usualFutureDateField.getValue();
				
				if(localDate2 != null){
					
				Date date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				cptCode.setPvtPracticeFutureEfective(date2);
				}
				
				cptCode.setWrkCompCrgCurrent(workCompCurrentChargeTextField.getText());
				
				LocalDate localDate3 = workCompCurrentDateField.getValue();
				
				if(localDate3 != null){
					
				Date date3 = Date.from(localDate3.atStartOfDay(ZoneId.systemDefault()).toInstant());
				cptCode.setWrkCompCrgEffective(date3);
				
				}
				cptCode.setWrkCompFutureCrg(workCompFutureChargeTextField.getText());
				
				LocalDate localDate4 = workCompFutureDateField.getValue();
				if(localDate4 != null){
					
				Date date4 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
				cptCode.setWrkCompFutureEffective(date4);
				
				}
				
				
				new Cpt4EntityController().update(cptCode);
				
				cPTorHCPCSCodeViewController.viewCptOrHcpcs();
					
					new FXFormCommonUtilities().closeForm(updateButton);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		cancelButton.setOnAction((event) -> {
			try {
				
				// cancel centralized form
				
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}