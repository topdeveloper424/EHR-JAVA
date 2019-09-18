package com.ets.controller.gui.icd10ReportGroup;

/*
 *Original Author: Sumitava Roy and Subhomoy Khan on Behalf of ETS for Client Company
 *File Creation Date: 06-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SelectDiagonalisticRecordGroupController Class
 *Description: SelectDiagonalisticRecordGroup.fxml Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.model.MedicalActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.CheckBox;
import com.ets.model.Icd10Codes;

public class ICD10ReportGroupViewController implements Initializable {

	@FXML
	private TextField searchTextField;

	@FXML
	private CheckBox includeInactiveCheckBox;

	// @FXML
	// private TableView<Icd10Codes> icd10TeportGroupTable;

	@FXML
	private TableColumn<Icd10Codes, String> descriptionColumn;

	@FXML
	private TableColumn<MedicalActivity, String> codeColumn;

	@FXML
	private Button topButton; // Table Record Top Button

	@FXML
	private Button upButton; // Table Record Up Button

	@FXML
	private Button downButton; // Table Record Down Button

	@FXML
	private Button bottomButton; // Table Record Bottom Button

	@FXML
	private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private Button printButton;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		FXMLFormPath formPath = new FXMLFormPath();

		// cancel centralized form
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		addButton.setOnAction((event) -> {
			try {
				// Load and Display - Enter_Diagonosis_Report_Group(Record will

				String formName = formPath.context.getMessage("AddICD10Report", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddICD10Report", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
}