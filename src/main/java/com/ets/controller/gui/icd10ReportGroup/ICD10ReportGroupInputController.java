package com.ets.controller.gui.icd10ReportGroup;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EnterDiagonasisReportGroupController Class
 *Description: EnterDiagonasisReportGroup.fxml Controller class
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
import java.util.ResourceBundle;
import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.model.Icd10Codes;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.UIRecordNavigation;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;

public class ICD10ReportGroupInputController implements Initializable {

	@FXML
	private TextField dxGroupCodeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField descriptionContainsTextField;

	@FXML
	private TextField codeContainsTextField;

	@FXML
	private CheckBox includeInactivesCheckBox;

	@FXML
	private Button closeButton;

	@FXML
	private Button okButton;

	@FXML
	private TableView<Icd10Codes> viewIcd10Codes; // Icd10 Table View

	@FXML
	private TableColumn<Icd10Codes, String> descriptionColumn; // Icd10 Table
																// Column

	@FXML
	private TableColumn<Icd10Codes, String> codeColumn; // Icd10 Table Column

	@FXML
	private Button icd10TopButton; // Table Record Top Button

	@FXML
	private Button icd10UpButton; // Table Record Up Button

	@FXML
	private Button icd10DownButton; // Table Record Down Button

	@FXML
	private Button icd10BottomButton; // Table Record Bottom Button

	@FXML
	private Button diagonosisTopButton; // Table Record Top Button

	@FXML
	private Button diagonosisUpButton; // Table Record Up Button

	@FXML
	private Button diagonosisDownButton; // Table Record Down Button

	@FXML
	private Button diagonosisBottomButton; // Table Record Bottom Button

	@FXML
	private Button rightButton;

	@FXML
	private Button leftButton;

	@FXML
	private CheckBox inactiveCheckBox;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		codeColumn.setCellValueFactory(new PropertyValueFactory<Icd10Codes, String>("code"));
		descriptionColumn.setCellValueFactory(new PropertyValueFactory<Icd10Codes, String>("descrip"));
		viewIcd10Codes.setItems(new Icd10CodesEntityController().viewIcd10Codes());

		icd10TopButton.setOnAction((event) -> {
			try {
				UIRecordNavigation.setPosition(viewIcd10Codes, 0);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd10UpButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = viewIcd10Codes.getSelectionModel().getSelectedIndex();
				selectedIndex--;
				UIRecordNavigation.setPosition(viewIcd10Codes, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd10DownButton.setOnAction((event) -> {
			try {
				Integer selectedIndex = viewIcd10Codes.getSelectionModel().getSelectedIndex();
				selectedIndex++;
				UIRecordNavigation.setPosition(viewIcd10Codes, selectedIndex);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		icd10BottomButton.setOnAction((event) -> {
			try {
				int tempRowCount = viewIcd10Codes.getSelectionModel().getTableView().getItems().size();
				--tempRowCount;
				UIRecordNavigation.setPosition(viewIcd10Codes, tempRowCount);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// cancel centralized form
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
