package com.ets.controller.gui.pharmacy;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 19-04-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PharmacySearchController Class
 *Description: Search.fxml Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Pharmacy;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;


import com.itextpdf.text.pdf.PdfStructTreeController.returnType;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PharmacySearchController implements Initializable {

	@FXML
	private TextField pharmacyNameTextField;

	@FXML
	private TextField cityTextField;

	@FXML
	private TextField stateTextField;

	@FXML
	private Button searchBtn;

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		searchBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.Pharmacy", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Pharmacy>> task =

					new Task<ObservableList<Pharmacy>>() {

						@Override
						protected ObservableList<Pharmacy> call() throws Exception {

							final ObservableList<Pharmacy> pharmacyList = new PharmacyEntityController().searchPharmacy(
									pharmacyNameTextField.getText(), cityTextField.getText(), stateTextField.getText());

							if (isCancelled()) {
								return null;
							}
							return pharmacyList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Pharmacy", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Pharmacy", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.pharmacyDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				//
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}

}
