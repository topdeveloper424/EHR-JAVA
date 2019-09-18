package com.ets.controller.gui.departmentUnit;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.controller.entity.address.AddressEntityController;
import com.ets.controller.entity.departmentUnit.DepartmentUnitEntityController;
import com.ets.controller.entity.division.DivisionEntityController;
import com.ets.controller.gui.division.DivisionViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Address;
import com.ets.model.DepartmentUnit;
import com.ets.model.Division;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 25-07-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DepartmentUnitInputController Class Description:
 * Enter.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class DepartmentUnitInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private TextField descriptionTextField;

	@FXML
	private TextField divisionTextField;

	@FXML
	private TextField supervisorTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField extensionTextField;

	@FXML
	private Spinner<?> oshaCategorySpinner;

	@FXML
	private Spinner<?> jobRiskCategorySpinner;

	@FXML
	private Button divisionBtn;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;

	@FXML
	private TableView<?> JobRiskAssignmentTable;

	@FXML
	private TableColumn<?, ?> jobClassCollumn;

	@FXML
	private TableColumn<?, ?> nameCollumn;

	@FXML
	private TableColumn<?, ?> tbCollumn;

	@FXML
	private TableColumn<?, ?> oshaCollumn;

	@FXML
	private TableColumn<?, ?> jobCollumn;

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button buttomButton;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;
	  @FXML
	    void enterKeyPressedForCancleButton(KeyEvent event) {
		  if(event.getCode() == KeyCode.ENTER){
		  try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    }}

	    @FXML
	    void enterKeyPressedForOkButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    	try {

				Address address = new Address();
				address.setEmail(emailTextField.getText());
				address.setFax(faxTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extensionTextField.getText());
				new AddressEntityController().add(address);

				DepartmentUnit departmentUnit = new DepartmentUnit();
				
				if(divisionTextField.getText().isEmpty()) {
					
					System.out.println("Division Is Empty");
					
				}else{
					
					Division division = new DivisionEntityController().viewByCode(divisionTextField.getText());
					departmentUnit.setDivision(division);
					
				}
				
				
				departmentUnit.setCode(codeTextField.getText());
				departmentUnit.setDescrip(descriptionTextField.getText());
				
				departmentUnit.setAddress(address);
				departmentUnit.setInactive(inactiveCheckBox.isSelected());

				new DepartmentUnitEntityController().saveDepartmentUnit(departmentUnit);
				
				departmentUnitViewController.viewDepartmentUnit();
				
				new FXFormCommonUtilities().closeForm(okButton);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
	    }}

	@FXML
	private CheckBox inactiveCheckBox;

	public void setdDeptUnitTextBox(String deptUnit) {

		this.divisionTextField.setText(deptUnit);
	}

	private DepartmentUnitViewController departmentUnitViewController;

	public void setDepartmentUnitViewController(DepartmentUnitViewController departmentUnitViewController) {
		this.departmentUnitViewController = departmentUnitViewController;
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {

		/*************************************
		 * Start of divisionBtn.setOnAction(..)
		 *****************************************************/

		divisionBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Division", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Division>> task =

					new Task<ObservableList<Division>>() {

						@Override
						protected ObservableList<Division> call() throws Exception {

							final ObservableList<Division> divisionList = new DivisionEntityController().viewDivision();

							if (isCancelled()) {
								return null;
							}
							return divisionList;
						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Division", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Division", null, Locale.US);
				formPath.closeApplicationContext();

				DivisionViewController viewAllDivisionGUIController = (DivisionViewController) new FXFormCommonUtilities()
						.divisionDisplayForm2(formName, formTitle, task.getValue());

				viewAllDivisionGUIController.setPredecessorFormController(this);
				viewAllDivisionGUIController.showSelectButton();

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of divisionBtn.setOnAction(..)
		 *************************************************************/

		okButton.setOnAction((event) -> {
			try {

				Address address = new Address();
				address.setEmail(emailTextField.getText());
				address.setFax(faxTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extensionTextField.getText());
				new AddressEntityController().add(address);

				DepartmentUnit departmentUnit = new DepartmentUnit();
				
				if(divisionTextField.getText().isEmpty()) {
					
					System.out.println("Division Is Empty");
					
				}else{
					
					Division division = new DivisionEntityController().viewByCode(divisionTextField.getText());
					departmentUnit.setDivision(division);
					
				}
				
				
				departmentUnit.setCode(codeTextField.getText());
				departmentUnit.setDescrip(descriptionTextField.getText());
				
				departmentUnit.setAddress(address);
				departmentUnit.setInactive(inactiveCheckBox.isSelected());

				new DepartmentUnitEntityController().saveDepartmentUnit(departmentUnit);
				
				departmentUnitViewController.viewDepartmentUnit();
				
				new FXFormCommonUtilities().closeForm(okButton);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
