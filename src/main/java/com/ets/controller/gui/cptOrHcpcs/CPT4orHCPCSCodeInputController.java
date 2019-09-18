package com.ets.controller.gui.cptOrHcpcs;


/**Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterSelectCPT4orHCPCSCodeNewController Class
 *Description: EnterSelectCPT4orHCPCSCodeNew.fxml Controller class
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
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;

import com.ets.controller.entity.cpt4.Cpt4EntityController;
import com.ets.model.CptCode4Hcpcs;
import com.ets.utils.FXFormCommonUtilities;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.CheckBox;

public class CPT4orHCPCSCodeInputController implements Initializable {

	   @FXML
	    private TextField codeTextField;

	    @FXML
	    private TextField descriptionTextField;

	    @FXML
	    private ChoiceBox<?> copyTypeChoiceBox;

	    @FXML
	    private CheckBox inactiveCheckBox;

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
	    private DatePicker usualCurrentDateField;

	    @FXML
	    private DatePicker usualFutureDateField;
	    
	    @FXML
	    private Button cancelButton;
	    
	    

		@FXML
	    private Button okButton;
		
		private CPTorHCPCSCodeViewController cPTorHCPCSCodeViewController;
	    

	    public void setcPTorHCPCSCodeViewController(CPTorHCPCSCodeViewController cPTorHCPCSCodeViewController) {
			this.cPTorHCPCSCodeViewController = cPTorHCPCSCodeViewController;
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
		
		
		okButton.setOnAction((event) -> {
			try {
				CptCode4Hcpcs cptCode = new CptCode4Hcpcs();
				
				cptCode.setCode(codeTextField.getText());
				cptCode.setCodeType((String) copyTypeChoiceBox.getSelectionModel().getSelectedItem());
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
					
				Date date4 = Date.from(localDate4.atStartOfDay(ZoneId.systemDefault()).toInstant());
				cptCode.setWrkCompFutureEffective(date4);
				
				}
				
				new Cpt4EntityController().save(cptCode);
				
				cPTorHCPCSCodeViewController.viewCptOrHcpcs();
				
				new FXFormCommonUtilities().closeForm(okButton);
								
				
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
