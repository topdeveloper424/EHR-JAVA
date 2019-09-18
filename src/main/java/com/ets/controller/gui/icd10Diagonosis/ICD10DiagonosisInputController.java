package com.ets.controller.gui.icd10Diagonosis;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 29-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VisitLogInputController Class
 *Description: Left_Panel.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
*/
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.medicationClass.MedicationClassEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.gui.icd10.ICD10ViewController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Icd10Codes;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientVisit;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ICD10DiagonosisInputController implements Initializable {

	@FXML
	private TextField descriptionContainsTextField;

	@FXML
	private TextField codesContainsTextField;

	@FXML
	private TextField searchTextField;

	@FXML
	private Button okButton;

	@FXML
	private Button closeButton;

	@FXML
	private TableView<Icd10Codes> viewIcd10Codes;

	@FXML
	private TableColumn<Icd10Codes, String> codeColumn;

	@FXML
	private TableColumn<Icd10Codes, String> descriptionColumn;

	/*
	 * @FXML private TableColumn<Icd10Codes, String> obsoleteColumn;
	 */

	@FXML
	private TextField icd1Text;

	@FXML
	private TextField icd2Text;

	@FXML
	private TextField icd3Text;

	@FXML
	private TextField icd4Text;

	@FXML
	private TextField icd5Text;

	@FXML
	private TextField icd6Text;

	@FXML
	private TextField icd7Text;

	@FXML
	private TextField icd8Text;

	@FXML
	private TextField icd9Text;

	@FXML
	private TextField icd10Text;

	@FXML
	private TextField icd11Text;

	@FXML
	private Button icd1SearchButton;

	@FXML
	private Button icd2SearchButton;

	@FXML
	private Button icd3SearchButton;

	@FXML
	private Button icd4SearchButton;

	@FXML
	private Button icd5SearchButton;

	@FXML
	private Button icd6SearchButton;

	@FXML
	private Button icd7SearchButton;

	@FXML
	private Button icd8SearchButton;

	@FXML
	private Button icd9SearchButton;

	@FXML
	private Button icd10SearchButton;

	@FXML
	private Button icd11SearchButton;

	@FXML
	private TextField icd12Text;

	@FXML
	private Button icd12SearchButton;

	@FXML
	private TextField icd1DecripText;

	@FXML
	private TextField icd2DecripText;

	@FXML
	private TextField icd5DecripText;

	@FXML
	private TextField icd3DecripText;

	@FXML
	private TextField icd4DecripText;

	@FXML
	private TextField icd6DecripText;

	@FXML
	private TextField icd7DecripText;

	@FXML
	private TextField icd8DecripText;

	@FXML
	private TextField icd9DecripText;

	@FXML
	private TextField icd10DecripText;

	@FXML
	private TextField icd11DecripText;

	@FXML
	private TextField icd12DecripText;

	@FXML
	private Button clearAllBtn;

	@FXML
	private Button addButton;

	@FXML
	void doubleClick(MouseEvent event) {
		if (event.getClickCount() == 2) {

			populateIntoTextFieldOnDoubleClick();

		}

	}

	private Icd10Codes icd10Codes;
   
	public void populateIntoTextFieldOnDoubleClick() {
		if (icd1Text.getText().length() == 0) {

			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();

			icd1Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd1DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (flag == 0) {
                 System.out.println("############## "+icd10Codes);
				icd10CodesList.add(0, icd10Codes);
				flag = 1;

			} else {
				icd10CodesList.set(0, icd10Codes);
			}

		}

		else if (icd2Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd2Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd2DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());
			if (icd10CodesList.size() == 1) {

				icd10CodesList.add(1, icd10Codes);

			} else {
				icd10CodesList.set(1, icd10Codes);

			}

		} else if (icd3Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd3Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd3DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());
			if (icd10CodesList.size() == 2) {

				icd10CodesList.add(2, icd10Codes);

			} else {
				icd10CodesList.set(2, icd10Codes);

			}

		} else if (icd4Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd4Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd4DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 3) {

				icd10CodesList.add(3, icd10Codes);

			} else {
				icd10CodesList.set(3, icd10Codes);

			}

		} else if (icd5Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd5Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd5DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 4) {

				icd10CodesList.add(4, icd10Codes);

			} else {
				icd10CodesList.set(4, icd10Codes);

			}

		} else if (icd6Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd6Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd6DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 5) {

				icd10CodesList.add(5, icd10Codes);

			} else {
				icd10CodesList.set(5, icd10Codes);

			}

		} else if (icd7Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd7Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd7DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 6) {

				icd10CodesList.add(6, icd10Codes);

			} else {
				icd10CodesList.set(6, icd10Codes);

			}

		} else if (icd8Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd8Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd8DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 7) {

				icd10CodesList.add(7, icd10Codes);

			} else {
				icd10CodesList.set(7, icd10Codes);

			}

		} else if (icd9Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd9Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd9DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 8) {

				icd10CodesList.add(8, icd10Codes);

			} else {
				icd10CodesList.set(8, icd10Codes);

			}

		} else if (icd10Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd10Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd10DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());
			if (icd10CodesList.size() == 9) {

				icd10CodesList.add(9, icd10Codes);

			} else {
				icd10CodesList.set(9, icd10Codes);

			}

		} else if (icd11Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd11Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd11DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 10) {

				icd10CodesList.add(10, icd10Codes);

			} else {
				icd10CodesList.set(10, icd10Codes);

			}

		} else if (icd12Text.getText().length() == 0) {
			icd10Codes = viewIcd10Codes.getSelectionModel().getSelectedItem();
			icd12Text.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getCode());
			icd12DecripText.setText(viewIcd10Codes.getSelectionModel().getSelectedItem().getDescrip());

			if (icd10CodesList.size() == 11) {

				icd10CodesList.add(11, icd10Codes);

			} else {
				icd10CodesList.set(11, icd10Codes);

			}
			for (Icd10Codes icd10Codes : icd10CodesList) {
				System.out.println("icd10CodesList "+icd10Codes.getCode());
			}
			
			
		}

	}

	private VisitLogInputController visitLogInputController;

	public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
		this.visitLogInputController = visitLogInputController;
	}

	private ObservableList<Icd10Codes> icd10list = FXCollections.observableArrayList();

	public void viewICD10Table() {

		icd10list = new Icd10CodesEntityController().viewIcd10Codes();

		codeColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		descriptionColumn.setCellValueFactory(cellData -> cellData.getValue().descripProperty());

		// obsoleteColumn.setCellValueFactory(cellData -> cellData.getValue().);
		viewIcd10Codes.setItems(icd10list);

	}

	Button button;
	private Integer flag = 0;

	public static List<Icd10Codes> icd10CodesList = new ArrayList<Icd10Codes>();

	public void seticdFromSearchBtn(Icd10Codes icd10Codes) {

		if (button.equals(icd1SearchButton)) {

			icd1Text.setText(icd10Codes.getCode());

			icd1DecripText.setText(icd10Codes.getDescrip());

			if (flag == 0) {

				icd10CodesList.add(0, icd10Codes);
				flag = 1;

			} else {
				icd10CodesList.set(0, icd10Codes);
			}

			
			System.out.println("***  " + icd10CodesList.get(0));
		}

		else if (button.equals(icd2SearchButton)) {

			icd2Text.setText(icd10Codes.getCode());

			icd2DecripText.setText(icd10Codes.getDescrip());

			if (icd10CodesList.size() == 1) {

				icd10CodesList.add(1, icd10Codes);

			} else {
				icd10CodesList.set(1, icd10Codes);

			}

		} else if (button.equals(icd3SearchButton)) {

			icd3Text.setText(icd10Codes.getCode());

			icd3DecripText.setText(icd10Codes.getDescrip());
			

			if (icd10CodesList.size() == 2) {
				icd10CodesList.add(2, icd10Codes);
			} else {
				icd10CodesList.set(2, icd10Codes);

			}

		} else if (button.equals(icd4SearchButton)) {

			icd4Text.setText(icd10Codes.getCode());

			icd4DecripText.setText(icd10Codes.getDescrip());

			if (icd10CodesList.size() == 3) {
				icd10CodesList.add(3, icd10Codes);
			} else {

				icd10CodesList.set(3, icd10Codes);
			}

		} else if (button.equals(icd5SearchButton)) {

			icd5Text.setText(icd10Codes.getCode());

			icd5DecripText.setText(icd10Codes.getDescrip());

			if (icd10CodesList.size() == 4) {
				icd10CodesList.add(4, icd10Codes);
			} else {

				icd10CodesList.set(4, icd10Codes);
			}

		} else if (button.equals(icd6SearchButton)) {

			icd6Text.setText(icd10Codes.getCode());

			icd6DecripText.setText(icd10Codes.getDescrip());

			if (icd10CodesList.size() == 5) {

				icd10CodesList.add(5, icd10Codes);
			} else {
				icd10CodesList.set(5, icd10Codes);
			}

		} else if (button.equals(icd7SearchButton)) {

			icd7Text.setText(icd10Codes.getCode());

			icd7DecripText.setText(icd10Codes.getDescrip());

			if (icd10CodesList.size() == 6) {
				icd10CodesList.add(6, icd10Codes);
			} else {
				icd10CodesList.set(6, icd10Codes);
			}

		} else if (button.equals(icd8SearchButton)) {

			icd8Text.setText(icd10Codes.getCode());

			icd8DecripText.setText(icd10Codes.getDescrip());

			if (icd10CodesList.size() == 7) {
				icd10CodesList.add(7, icd10Codes);
			} else {
				icd10CodesList.set(7, icd10Codes);

			}

		} else if (button.equals(icd9SearchButton)) {

			icd9Text.setText(icd10Codes.getCode());

			icd9DecripText.setText(icd10Codes.getDescrip());
			if (icd10CodesList.size() == 8) {
				icd10CodesList.add(8, icd10Codes);
			} else {
				icd10CodesList.set(8, icd10Codes);

			}

		} else if (button.equals(icd10SearchButton)) {

			icd10Text.setText(icd10Codes.getCode());

			icd10DecripText.setText(icd10Codes.getDescrip());

			if (icd10CodesList.size() == 9) {
				icd10CodesList.add(9, icd10Codes);

			} else {

				icd10CodesList.set(9, icd10Codes);
				
			}

		} else if (button.equals(icd11SearchButton)) {

			icd11Text.setText(icd10Codes.getCode());

			icd11DecripText.setText(icd10Codes.getDescrip());
			if (icd10CodesList.size() == 10) {
				icd10CodesList.add(10, icd10Codes);
			} else {
				icd10CodesList.set(10, icd10Codes);
			}

		} else if (button.equals(icd12SearchButton)) {

			icd12Text.setText(icd10Codes.getCode());

			icd12DecripText.setText(icd10Codes.getDescrip());
			if (icd10CodesList.size() == 11) {
				icd10CodesList.add(11, icd10Codes);
			} else {
				icd10CodesList.set(11, icd10Codes);
			}
			
			
			

		}

	}
   List<TextField> codesText = new ArrayList<TextField>();
   List<TextField> codesDescripText = new ArrayList<TextField>();
   /*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

	public void getSelectedCodes(){
		icd10CodesList = new ArrayList<Icd10Codes>();
		if(Global.patientVisitObj.getIcd10Codes()!=null){
		icd10CodesList.addAll(Global.patientVisitObj.getIcd10Codes());
		codesText.add(icd1Text);
		codesText.add(icd2Text);
		codesText.add(icd3Text);
		codesText.add(icd4Text);
		codesText.add(icd5Text);
		codesText.add(icd6Text);
		codesText.add(icd7Text);
		codesText.add(icd8Text);
		codesText.add(icd9Text);
		codesText.add(icd10Text);
		codesText.add(icd11Text);
		codesText.add(icd12Text);
		codesDescripText.add(icd1DecripText);
		codesDescripText.add(icd2DecripText);
		codesDescripText.add(icd3DecripText);
		codesDescripText.add(icd4DecripText);
		codesDescripText.add(icd5DecripText);
		codesDescripText.add(icd6DecripText);
		codesDescripText.add(icd7DecripText);
		
		codesDescripText.add(icd8DecripText);
		codesDescripText.add(icd9DecripText);
		codesDescripText.add(icd10DecripText);
		codesDescripText.add(icd11DecripText);
		codesDescripText.add(icd12DecripText);
		System.out.println("@@@@@@@@@@@@@@ size "+icd10CodesList.size());
		if(icd10CodesList.size()>0){
			for (int i=0;i<icd10CodesList.size();i++) {
				System.out.println("@@@@@@@@@@@@@@ size "+icd10CodesList.get(i).getCode());
				codesText.get(i).setText(icd10CodesList.get(i).getCode());
				codesDescripText.get(i).setText(icd10CodesList.get(i).getDescrip());
			}
			
			
		}
		}
	}
	FXMLFormPath formpath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		viewICD10Table();
		getSelectedCodes();
		okButton.setOnAction((event) -> {
			try {

			/*	PatientVisit patientVisit = new PatientVisit();

				patientVisit.setIcd10Codes(icd10CodesList);

			     new PatientVisitEntityController().saveOrUpdate(patientVisit);
				
*/             
				
				visitLogInputController.populateTableICD10Table();
				
				new FXFormCommonUtilities().closeForm(okButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd1SearchButton.setOnAction((event) -> {
			try {
				button = icd1SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd2SearchButton.setOnAction((event) -> {
			try {
				button = icd2SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		icd3SearchButton.setOnAction((event) -> {
			try {
				button = icd3SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		icd4SearchButton.setOnAction((event) -> {
			try {
				button = icd4SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd5SearchButton.setOnAction((event) -> {
			try {
				button = icd5SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd6SearchButton.setOnAction((event) -> {
			try {
				button = icd6SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd7SearchButton.setOnAction((event) -> {
			try {
				button = icd7SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd8SearchButton.setOnAction((event) -> {
			try {
				button = icd8SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd9SearchButton.setOnAction((event) -> {
			try {
				button = icd9SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd10SearchButton.setOnAction((event) -> {
			try {
				button = icd10SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd11SearchButton.setOnAction((event) -> {
			try {
				button = icd11SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		icd12SearchButton.setOnAction((event) -> {
			try {
				button = icd12SearchButton;
				String formName = formpath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formpath.context.getMessage("Title.ICD10", null, Locale.US);
				formpath.closeApplicationContext();
				ICD10ViewController icd10view = (ICD10ViewController) new FXFormCommonUtilities().displayForm(formName,
						formTitle);
				icd10view.setiCD10DiagonosisInputController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		clearAllBtn.setOnAction((event) -> {
			try {

				icd1Text.setText("");
				icd1DecripText.setText("");
				icd2DecripText.setText("");
				icd2Text.setText("");
				icd3DecripText.setText("");
				icd3Text.setText("");
				icd4DecripText.setText("");
				icd4Text.setText("");
				icd5DecripText.setText("");
				icd5Text.setText("");
				icd6DecripText.setText("");
				icd6Text.setText("");
				icd7DecripText.setText("");
				icd7Text.setText("");
				icd8DecripText.setText("");
				icd8Text.setText("");
				icd9DecripText.setText("");
				icd9Text.setText("");
				icd10DecripText.setText("");
				icd10Text.setText("");
				icd11DecripText.setText("");
				icd11Text.setText("");
				icd12DecripText.setText("");
				icd12Text.setText("");

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		closeButton.setOnAction((event) -> {
			try {
				
				icd10CodesList= null;
				new FXFormCommonUtilities().closeForm(closeButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
