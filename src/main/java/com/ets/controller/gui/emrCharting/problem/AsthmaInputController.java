package com.ets.controller.gui.emrCharting.problem;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 11-04-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AsthmaInputController Class
 *Description: asthma.fxml GUI Controller class
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.pmh.PMHAllergyInputController;
import com.ets.controller.gui.emrCharting.pmh.PMHProblemInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AsthmaInputController implements Initializable {
	
	 @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneButton;

	    @FXML
	    private TextField icd1Text;

	    @FXML
	    private TextField icd2Text;

	    @FXML
	    private TextField icd3Text;

	    @FXML
	    private TextField icd4Text;

	    @FXML
	    private Button icd1Btn;

	    @FXML
	    private Button icd2Btn;

	    @FXML
	    private Button icd3Btn;

	    @FXML
	    private Button icd4Btn;

	    @FXML
	    private Button asignDiagonosisBtn;

	    @FXML
	    private Button snomedCtBtn;

	    @FXML
	    private TextField snomedCtText;

	    @FXML
	    private TextField conditionText;

	    @FXML
	    private DatePicker onsetDate;

	    @FXML
	    private DatePicker endDate;

	    @FXML
	    private TextField onsetAgeText;

	    @FXML
	    private TextField startYearText;

	    @FXML
	    private RadioButton chronicityNaRadio;

	    @FXML
	    private ToggleGroup chronicity;

	    @FXML
	    private RadioButton chronicityChronicRadio;

	    @FXML
	    private RadioButton chronicityAcuteRadio;

	    @FXML
	    private RadioButton chronicitySelfRadio;

	    @FXML
	    private RadioButton degreeNaRadio;

	    @FXML
	    private ToggleGroup degree;

	    @FXML
	    private RadioButton degreeControlledRadio;

	    @FXML
	    private RadioButton degreeUncontrolledRadio;

	    @FXML
	    private RadioButton degreeQuestionableRadio;

	    @FXML
	    private TextArea additionalTextarea;

	    @FXML
	    private RadioButton securityNaRadio;

	    @FXML
	    private ToggleGroup security;

	    @FXML
	    private RadioButton securityControlledRadio;

	    @FXML
	    private RadioButton securityUncontrolledRadio;

	    @FXML
	    private RadioButton securityQuestionableRadio;

	    private PMHProblemInputController pMHProblemInputController;
		
		
		public void setpMHProblemInputController(PMHProblemInputController pMHProblemInputController) {
		this.pMHProblemInputController = pMHProblemInputController;
	}


@Override
public void initialize(URL location, ResourceBundle resources) {
	
	doneButton.setOnAction((event) -> {

		StringBuilder pmhProblemStr = new StringBuilder(pMHProblemInputController.str);
		pmhProblemStr.append("\n\n ");
		pMHProblemInputController.str = pmhProblemStr.toString();

		
		
		

		

		++pMHProblemInputController.formCount;
		pMHProblemInputController.setProblemUI();
		new FXFormCommonUtilities().closeForm(doneButton);
		

	});

	skipBtn.setOnAction((event) -> {
		try {
			++pMHProblemInputController.formCount;
			pMHProblemInputController.setProblemUI();
			new FXFormCommonUtilities().closeForm(skipBtn);

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	});
		
		
	}

}
