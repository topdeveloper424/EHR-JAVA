package com.ets.controller.gui.sicCode;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SicCodeGUIController Class
 *Description: EnterNaicsCode.fxml Controller class
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

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.entity.sicCode.SicCodeEntityController;
import com.ets.model.SICCode;
import com.ets.utils.FXFormCommonUtilities;





import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;import javafx.scene.control.CheckBox;import javafx.scene.control.TextField;

public class SicCodeInputController implements Initializable {
	
	    @FXML
	    private TextField sicCode;

	    @FXML
	    private TextField descrp;

	    @FXML
	    private TextField workinjrate;

	    @FXML
	    private TextField ltimeinjrate;

	    @FXML
	    private TextField lworkday;

	    @FXML
	    private TextField avgwagecost;

	    @FXML
	    private TextField avgcomppremium;

	    @FXML
	    private TextField variablepremium;

	    
	    @FXML
	    private CheckBox inactive;
	    
	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button cancelBtn;
	  

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		okBtn.setOnAction((event) -> {

			SICCode sicCode = new SICCode();
			sicCode.setCode(this.sicCode.getText());
			sicCode.setDescrp(this.descrp.getText());
			sicCode.setAvgCompPremiumPerEmp(this.avgcomppremium.getText());
			sicCode.setAvgWageReplCost(this.avgwagecost.getText());
			sicCode.setLostTimeInjuryRate(this.ltimeinjrate.getText());
			sicCode.setLostWorkDays(this.lworkday.getText());
			sicCode.setVariablePremium(this.variablepremium.getText());
			sicCode.setWorkInjuryRate(this.workinjrate.getText());
			sicCode.setInactive(this.inactive.isSelected());

			new SicCodeEntityController().saveSICCode(sicCode);
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
