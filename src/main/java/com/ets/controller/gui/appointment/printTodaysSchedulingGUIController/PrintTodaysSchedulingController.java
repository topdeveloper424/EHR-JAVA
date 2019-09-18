package com.ets.controller.gui.appointment.printTodaysSchedulingGUIController;

import java.io.InputStream;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.entity.referalProvider.ReferalProviderEntityController;
import com.ets.controller.gui.appointment.AppointmentController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.MedicalActivity;
import com.ets.model.PatientAppointment;
import com.ets.model.ReferalProvider;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.tabulator.SplitCell;
import net.sf.jasperreports.view.JasperViewer;

/**
 * 
 * Original Author: Neha Sahadev on Behalf of ETS for Client Company File
 * Creation Date: 28-03-2017 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of AppointmentGUIController Class Description:
 * Appointment.fxml Controller class Copyright 2016 @Eclipse Technoconsulting
 * Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */
public class PrintTodaysSchedulingController implements Initializable {

	@FXML
	private Button printForProvider1Button;

	@FXML
	private Button summaryButton;

	@FXML
	private Label provider1;

	@FXML
	private Button printForProvider2Button;

	@FXML
	private Label provider2;
	private AppointmentController appointmentController;
	private String providerName = null;
	private String providerName2 = null;
	private Date date11 = null;

	public void setAppointmentController(AppointmentController appointmentController, String providerName,
			String providerName2, Date date11) {
		this.appointmentController = appointmentController;
		this.providerName = providerName;
		this.providerName2 = providerName2;
		this.date11 = date11;

		setProviderAccoringColumn1And2();

	}

	public void setProviderAccoringColumn1And2() {
		provider1.setText(this.providerName);
		provider2.setText(this.providerName2);

	}

	FXMLFormPath formPath = new FXMLFormPath();

	private ObservableList<PatientAppointment> patientAppointment1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		summaryButton.setOnAction((event) -> {

			String providerNameArr[] = providerName.split(" ");
			String providerNameArr2[] = providerName2.split(" ");

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context
					.getMessage("Title.ProgressBar.PrintTodaysSchedulingAppointmentForSummary", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<PatientAppointment>> task =

					new Task<ObservableList<PatientAppointment>>() {

						@Override
						protected ObservableList<PatientAppointment> call() throws Exception {

							ObservableList<PatientAppointment> patientAppointmentList = null;
							// ObservableList<PatientAppointment>
							// patientAppointmentList2 = null;

							try {

								System.out.println("Generating PDF...");

								String printPatientAppointment = formPath.context.getMessage(
										"Print.PrintTodaysSchedulingAppointmentForSummary", null, Locale.US);

								formPath.closeApplicationContext();

								// InputStream is = new FileInputStream(new
								// File(printMedicalActivity));
								InputStream is = this.getClass().getResourceAsStream(printPatientAppointment);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								patientAppointmentList = new PatientAppointmentEntityController().viewByBothProvider(
										providerNameArr[0], providerNameArr[2], providerNameArr2[0],
										providerNameArr2[2], date11);

								Map map = new HashMap();

								// Map<String, Object> map = new HashMap<String,
								// Object>();
								map.put("provider1", providerName);
								map.put("provider2", providerName2);

								JRDataSource JRdataSource = new JRBeanCollectionDataSource(patientAppointmentList);
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return patientAppointmentList;

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

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		printForProvider1Button.setOnAction((event) -> {

			String providerNameArr[] = providerName.split(" ");

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context
					.getMessage("Title.ProgressBar.PrintTodaysSchedulingAppointmentForProvider1", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<PatientAppointment>> task =

					new Task<ObservableList<PatientAppointment>>() {

						@Override
						protected ObservableList<PatientAppointment> call() throws Exception {

							ObservableList<PatientAppointment> patientAppointmentList = null;

							try {

								System.out.println("Generating PDF...");

								String printPatientAppointment = formPath.context.getMessage(
										"Print.PrintTodaysSchedulingAppointmentForProvider1", null, Locale.US);

								formPath.closeApplicationContext();

								// InputStream is = new FileInputStream(new
								// File(printMedicalActivity));
								InputStream is = this.getClass().getResourceAsStream(printPatientAppointment);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								patientAppointmentList = new PatientAppointmentEntityController()
										.viewByNameAndDate(providerNameArr[0], providerNameArr[2], date11);
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(patientAppointmentList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return patientAppointmentList;

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

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

		printForProvider2Button.setOnAction((event) -> {

			String providerNameArr[] = providerName2.split(" ");

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context
					.getMessage("Title.ProgressBar.PrintTodaysSchedulingAppointmentForProvider2", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<PatientAppointment>> task =

					new Task<ObservableList<PatientAppointment>>() {

						@Override
						protected ObservableList<PatientAppointment> call() throws Exception {

							ObservableList<PatientAppointment> patientAppointmentList = null;

							try {

								System.out.println("Generating PDF...");

								String printPatientAppointment = formPath.context.getMessage(
										"Print.PrintTodaysSchedulingAppointmentForProvider2", null, Locale.US);

								formPath.closeApplicationContext();

								// InputStream is = new FileInputStream(new
								// File(printMedicalActivity));
								InputStream is = this.getClass().getResourceAsStream(printPatientAppointment);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								patientAppointmentList = new PatientAppointmentEntityController()
										.viewByNameAndDate(providerNameArr[0], providerNameArr[2], date11);
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(patientAppointmentList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return patientAppointmentList;

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

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});

	}

}
