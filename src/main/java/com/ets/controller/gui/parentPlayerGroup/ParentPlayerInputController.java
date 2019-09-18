package com.ets.controller.gui.parentPlayerGroup;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.controller.entity.district.DistrictEntityController;
import com.ets.controller.entity.region.RegionEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Complex;
import com.ets.model.District;
import com.ets.model.Region;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceBox;

/**
 * 
 * Original Author: Sumanta Deyashi on Behalf of ETS for Client Company File
 * Creation Date: 09-05-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of ParentPlayerGUIController Class Description:
 * EnterCorporateParentPlayerOrganization.fxml Controller class Copyright
 * 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */
public class ParentPlayerInputController implements Initializable {

	@FXML
	private TextField codeTextField;

	@FXML
	private ChoiceBox playerTypeChoiceBox;

	@FXML
	private TextField nameTextField;

	@FXML
	private TextField addressTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private TextField zipTextField;

	@FXML
	private TextField telephoneTextField;

	@FXML
	private TextField extTextField;

	@FXML
	private TextField faxTextField;

	@FXML
	private TextField emailTextField;

	@FXML
	private TextField sourceFaxTextField;

	@FXML
	private TextField contactTextField;

	@FXML
	private CheckBox nationalPlayerOrganizationCheckBox;

	@FXML
	private CheckBox inactiveCheckBox;

	@FXML
	private TextField regionTextField;

	@FXML
	private TextField districtTextField;

	@FXML
	private TextField complexTextField;

	@FXML
	private Button regionButton;

	@FXML
	private Button districtButton;

	@FXML
	private Button complexButton;

	@FXML
	private Button okButton;

	@FXML
	private Button cancelButton;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle reources) {
		
		List<String> list = new ArrayList<String>();
		
		list.add("Carrier");
		list.add("Lab");
		list.add("MCO/TPA");
		list.add("Contract TPA");
		
		ObservableList obList = FXCollections.observableList(list);
		playerTypeChoiceBox.getItems().clear();
		playerTypeChoiceBox.setItems(obList);
		
		/*************************************
		 * Start of regionBtn.setOnAction(..)
		 *****************************************************/

		regionButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Region", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Region>> task =

					new Task<ObservableList<Region>>() {

						@Override
						protected ObservableList<Region> call() throws Exception {

							final ObservableList<Region> regionList = new RegionEntityController().viewRegion();

							if (isCancelled()) {
								return null;
							}
							return regionList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Region", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Region", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.regionDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of regionBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of districtBtn.setOnAction(..)
		 *****************************************************/

		districtButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.District", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<District>> task =

					new Task<ObservableList<District>>() {

						@Override
						protected ObservableList<District> call() throws Exception {

							final ObservableList<District> districtList = new DistrictEntityController().viewDistrict();

							if (isCancelled()) {
								return null;
							}
							return districtList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("District", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.District", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.districtDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());
			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of districtBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of complexBtn.setOnAction(..)
		 *****************************************************/

		complexButton.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Complex", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Complex>> task =

					new Task<ObservableList<Complex>>() {

						@Override
						protected ObservableList<Complex> call() throws Exception {

							final ObservableList<Complex> complexList = new ComplexEntityController().viewComplex();

							if (isCancelled()) {
								return null;
							}
							return complexList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");

				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Complex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Complex", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.complexDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {

				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of complexBtn.setOnAction(..)
		 *************************************************************/

		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
