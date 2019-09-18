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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 25-07-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of DepartmentUnitEditController Class Description:
 * Edit.fxml Controller class Copyright 2016 @Eclipse Technoconsulting Global
 * Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class DepartmentUnitEditController implements Initializable {

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
	private Button divisionButton;

	@FXML
	private TextField idTextField;

	@FXML
	private CheckBox includeInactiveCheckBox;

	@FXML
	private Button addButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button deleteButton;
	

	@FXML
	private Button topButton;

	@FXML
	private Button upButton;

	@FXML
	private Button downButton;

	@FXML
	private Button buttomButton;

	@FXML
	private Button updateButton;

	@FXML
	private Button cancelButton;

	@FXML
	private CheckBox inactiveCheckBox;
	 @FXML
	    void enterKeyPressedForCancleButton(KeyEvent event) {
		 if(event.getCode() == KeyCode.ENTER){
			 try {
					new FXFormCommonUtilities().closeForm(cancelButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				} 
			 
		 }
	    }

	    @FXML
	    void enterKeyPressedForUpdateButton(KeyEvent event) {
	    	 if(event.getCode() == KeyCode.ENTER){
	    		 try {

	 				Address address = new Address();
	 				address.setId(departmentUnit.getAddress().getId());
	 				address.setEmail(emailTextField.getText());
	 				address.setFax(faxTextField.getText());
	 				address.setPhone(telephoneTextField.getText());
	 				address.setExt(extensionTextField.getText());
	 				new AddressEntityController().update(address);

	 				DepartmentUnit departmentUnit = new DepartmentUnit();

	 				if(divisionTextField.getText().isEmpty()) {
	 					
	 					System.out.println("Division Is Empty");
	 					
	 				}else{
	 					
	 					Division division = new DivisionEntityController().viewByCode(divisionTextField.getText());
	 					departmentUnit.setDivision(division);
	 					
	 				}

	 				departmentUnit.setId(Integer.parseInt(idTextField.getText()));
	 				departmentUnit.setCode(codeTextField.getText());
	 				departmentUnit.setDescrip(descriptionTextField.getText());
	 				
	 				departmentUnit.setAddress(address);
	 				departmentUnit.setInactive(inactiveCheckBox.isSelected());

	 				new DepartmentUnitEntityController().updateDepartmentUnit(departmentUnit);
	 				departmentUnitViewController.viewDepartmentUnit();
	 				try {
	 					new FXFormCommonUtilities().closeForm(updateButton);
	 				} catch (Exception ex) {
	 					ex.printStackTrace();
	 				}

	 			} catch (Exception ex) {
	 				ex.printStackTrace();
	 			} 
				 
			 }
	    }

	private DepartmentUnit departmentUnit;

	public void setDepartmentUnit(DepartmentUnit departmentUnit) {
		this.departmentUnit = departmentUnit;

		idTextField.setText(Integer.toString(departmentUnit.getId()));
		codeTextField.setText(departmentUnit.getCode());
		descriptionTextField.setText(departmentUnit.getDescrip());
		
		if(departmentUnit.getDivision() != null){
			
			divisionTextField.setText(departmentUnit.divisionProperty().getValue().getCode());
			
		}
		
		telephoneTextField.setText(departmentUnit.addressProperty().getValue().getPhone());
		extensionTextField.setText(departmentUnit.addressProperty().getValue().getExt());
		faxTextField.setText(departmentUnit.addressProperty().getValue().getFax());
		emailTextField.setText(departmentUnit.addressProperty().getValue().getEmail());
		supervisorTextField.setText(departmentUnit.getSupervisor());

		if (departmentUnit.getInactive() == true) {
			inactiveCheckBox.setSelected(true);
		} else {
			inactiveCheckBox.setSelected(false);
		}
	}
	
	public void setdDeptUnitTextBox(String deptUnit) {

		this.divisionTextField.setText(deptUnit);
	}

	private DepartmentUnitViewController departmentUnitViewController;

	public void setDepartmentUnitViewController(DepartmentUnitViewController departmentUnitViewController) {
		this.departmentUnitViewController = departmentUnitViewController;
	}
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		updateButton.setOnAction((event) -> {
			try {

				Address address = new Address();
				address.setId(departmentUnit.getAddress().getId());
				address.setEmail(emailTextField.getText());
				address.setFax(faxTextField.getText());
				address.setPhone(telephoneTextField.getText());
				address.setExt(extensionTextField.getText());
				new AddressEntityController().update(address);

				DepartmentUnit departmentUnit = new DepartmentUnit();

				if(divisionTextField.getText().isEmpty()) {
					
					System.out.println("Division Is Empty");
					
				}else{
					
					Division division = new DivisionEntityController().viewByCode(divisionTextField.getText());
					departmentUnit.setDivision(division);
					
				}

				departmentUnit.setId(Integer.parseInt(idTextField.getText()));
				departmentUnit.setCode(codeTextField.getText());
				departmentUnit.setDescrip(descriptionTextField.getText());
				
				departmentUnit.setAddress(address);
				departmentUnit.setInactive(inactiveCheckBox.isSelected());

				new DepartmentUnitEntityController().updateDepartmentUnit(departmentUnit);
				departmentUnitViewController.viewDepartmentUnit();
				try {
					new FXFormCommonUtilities().closeForm(updateButton);
				} catch (Exception ex) {
					ex.printStackTrace();
				}

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		divisionButton.setOnAction((event) -> {

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

				viewAllDivisionGUIController.setDepartmentUnitEditController(this);
				viewAllDivisionGUIController.showSelectButton();

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
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
