package com.ets.controller.gui.appointment;



import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.swing.UIManager;

import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.gui.appointment.printTodaysSchedulingGUIController.PrintTodaysSchedulingController;
import com.ets.controller.gui.appointment.schedule.ScheduleController;
import com.ets.controller.gui.emrCharting.exam.mskel.DigitalAndNail.SkelDigitalNailInputController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.SearchPatientController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.controller.gui.visitLog.VisitLogSelectController;
import com.ets.controller.gui.whiteBoard.visitStatus.VisitStatusInputController;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.Provider;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.ets.controller.gui.clinic.ClinicViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.DialogPane;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.WindowEvent;

/**
 * 
 * Original Author: Neha Sahadev on Behalf of ETS for Client Company File
 * Creation Date: 14-12-2016 Initial Version: 0.01 Module Name: Parameter
 * Definition: Type object of AppointmentGUIController Class Description:
 * viewPatientAppointmentController.fxml Controller class Copyright 2016 @Eclipse Technoconsulting
 * Global Pvt. Ltd.
 * 
 * Modification: Owner: Date: Version: Description: Backup Location for Previous
 * Version:
 *
 * Copyright 2017 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class AppointmentController implements Initializable {
 @FXML
 private Button printTodaySchedulingButton;

	@FXML
	private TextArea appointmentTextArea;

	@FXML
	private Button appointmentScheduleBtn;

	@FXML
	private Button saveButton;
	@FXML
	private Button  ChangeToOtherClinicButton;
	@FXML
	private Button closeButton;
	@FXML
	private Button  todaysSchedulingButton;

	@FXML
	private DatePicker inputDateField;

	@FXML
	private ComboBox<String> Column2Choicebox;
	@FXML
	private ComboBox<String> Column1Choicebox;
	@FXML
	private GridPane gridTest;

	@FXML
	private TextField Column1text7;

	@FXML
	private TextField Column1text730;

	@FXML
	private TextField Column1text8;

	@FXML
	private TextField Column1text830;

	@FXML
	private TextField Column1text9;

	@FXML
	private TextField Column1text930;

	@FXML
	private TextField Column1text10;

	@FXML
	private TextField Column1text1030;

	@FXML
	private TextField Column1text11;

	@FXML
	private TextField Column1text1130;

	@FXML
	private TextField Column1text12;

	@FXML
	private TextField Column1text1230;

	@FXML
	private TextField Column1text1;

	@FXML
	private TextField Column1text130;

	@FXML
	private TextField Column1text2;

	@FXML
	private TextField Column1text230;

	@FXML
	private TextField Column1text3;

	@FXML
	private TextField Column1text330;

	@FXML
	private TextField Column1text4;

	@FXML
	private TextField Column1text430;

	@FXML
	private TextField Column1text530;

	@FXML
	private TextField Column2text430;

	@FXML
	private TextField Column2text4;

	@FXML
	private TextField Column2text330;

	@FXML
	private TextField Column2text3;

	@FXML
	private TextField Column2text230;

	@FXML
	private TextField Column2text2;

	@FXML
	private TextField Column2text130;

	@FXML
	private TextField Column2text1;

	@FXML
	private TextField Column2text1230;

	@FXML
	private TextField Column2text12;

	@FXML
	private TextField Column2text1130;

	@FXML
	private TextField Column2text11;

	@FXML
	private TextField Column2text1030;

	@FXML
	private TextField Column2text10;

	@FXML
	private TextField Column2text930;

	@FXML
	private TextField Column2text9;

	@FXML
	private TextField Column2text830;

	@FXML
	private TextField Column2text8;

	@FXML
	private TextField Column2text730;

	@FXML
	private TextField Column2text7;

	@FXML
	private TextField Column1text5;

	@FXML
	private TextField Column2text5;

	@FXML
	private TextField Column2text530;

	public Integer providerId = 0;
	
	@FXML
	private Button checkInPatientButton;
	
	public static Integer patientViewFlag = 0;


	
	
	
	
	/*
	
	   @FXML
	    void onDragDetectedForColumn1text1(MouseEvent event) {
		   Dragboard dragBoard = Column1text1.startDragAndDrop(TransferMode.MOVE);
	    	System.out.println("drag detected for text4");
			 Put a string on a dragboard 
			
			ClipboardContent content = new ClipboardContent();
			content.putString(Column1text1.getText());
			dragBoard.setContent(content);
	    }

*/
	public static Integer flag = 0;

	// on drag detected for column1 and column2 [start]

	@FXML
	void onDragDetectedForColumn1text1(MouseEvent event) {
		Dragboard dragBoard = Column1text1.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");
		/* Put a string on a dragboard */

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text1.getText());
		dragBoard.setContent(content);
	}
 
	@FXML
	void onDragDetectedForColumn1text10(MouseEvent event) {

		Dragboard dragBoard = Column1text10.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text10.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text1030(MouseEvent event) {
		Dragboard dragBoard = Column1text1030.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text1030.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text11(MouseEvent event) {
		Dragboard dragBoard = Column1text11.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text11.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text1130(MouseEvent event) {
		Dragboard dragBoard = Column1text1130.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text1130.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text12(MouseEvent event) {
		Dragboard dragBoard = Column1text12.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text12.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text1230(MouseEvent event) {
		Dragboard dragBoard = Column1text1230.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text1230.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text130(MouseEvent event) {
		Dragboard dragBoard = Column1text130.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text130.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text2(MouseEvent event) {
		Dragboard dragBoard = Column1text2.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text2.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text230(MouseEvent event) {
		Dragboard dragBoard = Column1text230.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text230.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text3(MouseEvent event) {

		Dragboard dragBoard = Column1text3.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text3.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text330(MouseEvent event) {
		Dragboard dragBoard = Column1text330.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text330.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text5(MouseEvent event) {
		Dragboard dragBoard = Column1text5.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text5.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text730(MouseEvent event) {
		Dragboard dragBoard = Column1text730.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text730.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text8(MouseEvent event) {

		Dragboard dragBoard = Column1text8.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text8.getText());
		dragBoard.setContent(content);

	}

	@FXML
	void onDragDetectedForColumn1text830(MouseEvent event) {
		Dragboard dragBoard = Column1text830.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text830.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text9(MouseEvent event) {
		Dragboard dragBoard = Column1text9.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text9.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text930(MouseEvent event) {
		Dragboard dragBoard = Column1text930.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text930.getText());
		dragBoard.setContent(content);

	}

	@FXML
	void onDragDetectedForColumn2text1(MouseEvent event) {
		Dragboard dragBoard = Column2text1.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text1.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text10(MouseEvent event) {
		Dragboard dragBoard = Column2text10.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text10.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text1030(MouseEvent event) {
		Dragboard dragBoard = Column2text1030.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text1030.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text11(MouseEvent event) {
		Dragboard dragBoard = Column2text11.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text11.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text1130(MouseEvent event) {
		Dragboard dragBoard = Column2text1130.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text1130.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text12(MouseEvent event) {
		Dragboard dragBoard = Column2text12.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text12.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text1230(MouseEvent event) {
		Dragboard dragBoard = Column2text1230.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text1230.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text130(MouseEvent event) {
		Dragboard dragBoard = Column2text130.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text130.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text2(MouseEvent event) {
		Dragboard dragBoard = Column2text2.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text2.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text230(MouseEvent event) {
		Dragboard dragBoard = Column2text230.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text230.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text3(MouseEvent event) {
		Dragboard dragBoard = Column2text3.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text3.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text330(MouseEvent event) {
		Dragboard dragBoard = Column2text330.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text330.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text4(MouseEvent event) {
		Dragboard dragBoard = Column2text4.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text4.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text430(MouseEvent event) {
		Dragboard dragBoard = Column2text430.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text430.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text5(MouseEvent event) {
		Dragboard dragBoard = Column2text5.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text5.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text7(MouseEvent event) {
		Dragboard dragBoard = Column2text7.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text7.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text730(MouseEvent event) {
		Dragboard dragBoard = Column2text730.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text730.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text8(MouseEvent event) {
		Dragboard dragBoard = Column2text8.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text8.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text830(MouseEvent event) {
		Dragboard dragBoard = Column2text830.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text830.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn1text4(MouseEvent event) {

		Dragboard dragBoard = Column1text4.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");
		/* Put a string on a dragboard */

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text4.getText());
		dragBoard.setContent(content);

	}

	@FXML
	void onDragDetectedForColumn2text9(MouseEvent event) {
		Dragboard dragBoard = Column2text9.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text9.getText());
		dragBoard.setContent(content);
	}

	@FXML
	void onDragDetectedForColumn2text930(MouseEvent event) {
		Dragboard dragBoard = Column2text930.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column2text930.getText());
		dragBoard.setContent(content);
	}

	// on drag detected for column1 and column 2

	// on drag drop for column1 and column2 [start]
	@FXML
	void onDragDropedForColumn1text1(DragEvent event) {

		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text10(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text1030(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text11(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text1130(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text12(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text1230(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text130(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text2(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);
		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text230(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text3(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text330(DragEvent event) {

		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text430(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text5(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text730(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text8(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text830(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text9(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text930(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2tex930(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text1(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text10(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text1030(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text11(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text1130(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text12(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text1230(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text130(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text2(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text230(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text3(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text330(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text4(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text430(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text5(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text7(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text730(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text8(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text830(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDroppedForColumn1text4(DragEvent event) {

		System.out.println("drag dropped for text4");
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn1text7(DragEvent event) {

		System.out.println("drag dropped for text7");

		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	@FXML
	void onDragDropedForColumn2text9(DragEvent event) {
		String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

		PatientAppointmentEditController patientAppointmentEditController = (PatientAppointmentEditController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		patientAppointmentEditController.setAppointmentController(this, appointmentList);
		// patientAppointmentEditController.setPatientAppointment(appointmentList.get(0));

	}

	// on drag drop for column1 and column2 [end]

	// on drag over for column1 and column2 [start]
	@FXML
	void onDragOverForColumn1text1(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void onDragOverForColumn1text10(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void onDragOverForColumn1text1030(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void onDragOverForColumn1text11(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void onDragOverForColumn1text1130(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text12(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text1230(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text130(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text2(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text230(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text3(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text330(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text430(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text5(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text730(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text8(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text830(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text9(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text930(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text1(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text10(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text1030(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text11(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text1130(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text12(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text1230(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text130(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text2(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text230(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text3(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text330(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text4(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text430(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text5(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text7(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void onDragOverForColumn2text730(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void onDragOverForColumn2text8(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text830(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn1text4(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
		System.out.println("drag over for text4");

	}

	@FXML
	void onDragOverForColumn1text7(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
		System.out.println("drag over for text7");

	}

	@FXML
	void onDragOverForColumn2text9(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void onDragOverForColumn2text930(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	// on drag over for column1 and column2 [end]

	private FXMLFormPath formPath;
	public ObservableList<PatientAppointment> appointmentList = null;
	public ObservableList<PatientAppointment> appointmentListViewByDate = null;

	@FXML
	void onActionSelectingDate(ActionEvent event) {
		reFresh();
		refreshCol2();

	}

	@FXML
	void onDragDetectedForColumn1text7(MouseEvent event) {

		Dragboard dragBoard = Column1text7.startDragAndDrop(TransferMode.MOVE);
		System.out.println("drag detected for text4");

		ClipboardContent content = new ClipboardContent();
		content.putString(Column1text7.getText());
		dragBoard.setContent(content);

	}

	// on drag dropped for column1 [end]

	// Display appointment details in textArea by single click on textBox
	// [start]

	@FXML
	void onMouseClickCol1Text1(MouseEvent event) {
      System.out.println();
		String patName = Column1text1.getText();

		if (Column1text1.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
				

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text10(MouseEvent event) {

		String patName = Column1text10.getText();

		if (Column1text10.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text1030(MouseEvent event) {
		String patName = Column1text1030.getText();
		if (Column1text1030.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text11(MouseEvent event) {
		String patName = Column1text11.getText();
		if (Column1text11.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text1130(MouseEvent event) {
		String patName = Column1text1130.getText();
		if (Column1text1130.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text12(MouseEvent event) {
		String patName = Column1text12.getText();
		if (Column1text12.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text1230(MouseEvent event) {
		String patName = Column1text1230.getText();
		if (Column1text1230.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text130(MouseEvent event) {
		String patName = Column1text130.getText();
		if (Column1text130.getText().isEmpty()) {

		}else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text2(MouseEvent event) {
		String patName = Column1text2.getText();
		if (Column1text2.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text230(MouseEvent event) {
		String patName = Column1text230.getText();
		if (Column1text230.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text3(MouseEvent event) {
		String patName = Column1text3.getText();
		if (Column1text3.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text330(MouseEvent event) {
		String patName = Column1text330.getText();
		if (Column1text330.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text4(MouseEvent event) {
		String patName = Column1text4.getText();
		if (Column1text4.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text430(MouseEvent event) {
		String patName = Column1text430.getText();

		if (Column1text430.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text5(MouseEvent event) {

		String patName = Column1text5.getText();

		if (Column1text5.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text7(MouseEvent event) {

		String patName = Column1text7.getText();
		if (Column1text7.getText().isEmpty()) {

		}else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text730(MouseEvent event) {
		String patName = Column1text730.getText();

		if (Column1text730.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text8(MouseEvent event) {
		String patName = Column1text8.getText();

		if (Column1text8.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text830(MouseEvent event) {
		String patName = Column1text830.getText();

		if (Column1text830.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text9(MouseEvent event) {
		String patName = Column1text9.getText();

		if (Column1text9.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol1Text930(MouseEvent event) {
		String patName = Column1text930.getText();

		if (Column1text930.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text1(MouseEvent event) {
		String patName = Column2text1.getText();

		if (Column2text1.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text10(MouseEvent event) {
		String patName = Column2text10.getText();

		if (Column2text10.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text1030(MouseEvent event) {
		String patName = Column2text1030.getText();

		if (Column2text1030.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text11(MouseEvent event) {
		String patName = Column2text11.getText();

		if (Column2text11.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text1130(MouseEvent event) {
		String patName = Column2text1130.getText();

		if (Column2text1130.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text12(MouseEvent event) {
		String patName = Column2text12.getText();

		if (Column2text12.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text1230(MouseEvent event) {
		String patName = Column2text1230.getText();

		if (Column2text1230.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text130(MouseEvent event) {
		String patName = Column2text130.getText();
		if (Column2text130.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text2(MouseEvent event) {
		String patName = Column2text2.getText();

		if (Column2text2.getText().isEmpty()) {

		}else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text230(MouseEvent event) {
		String patName = Column2text230.getText();

		if (Column2text230.getText().isEmpty()) {

		}else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text3(MouseEvent event) {
		String patName = Column2text3.getText();

		if (Column2text3.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text330(MouseEvent event) {
		String patName = Column2text330.getText();

		if (Column2text330.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text4(MouseEvent event) {
		String patName = Column2text4.getText();

		if (Column2text4.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text430(MouseEvent event) {
		String patName = Column2text430.getText();

		if (Column2text430.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text5(MouseEvent event) {
		String patName = Column2text5.getText();

		if (Column2text5.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text7(MouseEvent event) {
		String patName = Column2text7.getText();
		if (Column2text7.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text730(MouseEvent event) {
		String patName = Column2text730.getText();

		if (Column2text730.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text8(MouseEvent event) {
		String patName = Column2text8.getText();

		if (Column2text8.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text830(MouseEvent event) {
		String patName = Column2text830.getText();

		if (Column2text830.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text9(MouseEvent event) {
		String patName = Column2text9.getText();

		if (Column2text9.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	@FXML
	void onMouseClickCol2Text930(MouseEvent event) {
		String patName = Column2text930.getText();

		if (Column2text930.getText().isEmpty()) {

		} else {
			String patNameArr[] = patName.split(" ");
			String purpose[] = patName.split("/");
			String providerName = Column2Choicebox.getSelectionModel().getSelectedItem();
			String providerNameArr[] = providerName.split(" ");

			if (inputDateField.getValue() != null) {

				LocalDate localDate1 = inputDateField.getValue();
				Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());

				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], date1, purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {
					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}

			} else {
				appointmentList = new PatientAppointmentEntityController().viewByNameDateProviderPurpose(patNameArr[0],
						patNameArr[1], new Date(), purpose[2], providerNameArr[0], providerNameArr[2], purpose[1]);

				for (PatientAppointment apt : appointmentList) {

					appointmentTextArea.setText(
							patNameArr[0] + " " + patNameArr[1] + "\n" + apt.getPatient().getCompany().getName() + "\n"
									+ apt.getPurpose() + "\n" + apt.getStatus());

				}
			}
		}
	}

	// Display appointment details in textArea by single click on textBox [end]

	private ObservableList<String> patientAppointmentMasterData = FXCollections.observableArrayList();
    
	
	
    private List<Provider> providertList = new  ProviderEntityController().viewByClinicId(Global.clinic!=null?Global.clinic.getId():null);
			
	private ObservableList<Patient> patientList = null;

	// display appointment on selecting provider from comboBox1 [start]
	

	@FXML
	void viewAppointmentByProvider(ActionEvent event) {
		reFresh();

	}

	public void reFresh() {

		String name = Column1Choicebox.getSelectionModel().getSelectedItem();
		

		String nameArr[] = name.split(" ");

		if (inputDateField.getValue() != null) {

			Column1text7.setText("");
			Column1text7.setStyle(null);
			Column1text730.setText("");
			Column1text730.setStyle(null);
			Column1text8.setText("");
			Column1text8.setStyle(null);
			Column1text830.setText("");
			Column1text830.setStyle(null);
			Column1text9.setText("");
			Column1text9.setStyle(null);
			Column1text930.setText("");
			Column1text930.setStyle(null);
			Column1text10.setText("");
			Column1text10.setStyle(null);
			Column1text1030.setText("");
			Column1text1030.setStyle(null);
			Column1text11.setText("");
			Column1text11.setStyle(null);
			Column1text1130.setText("");
			Column1text1130.setStyle(null);
			Column1text12.setText("");
			Column1text12.setStyle(null);
			Column1text1230.setText("");
			Column1text1230.setStyle(null);
			Column1text1.setText("");
			Column1text1.setStyle(null);
			Column1text130.setText("");
			Column1text130.setStyle(null);
			Column1text2.setText("");
			Column1text2.setStyle(null);
			Column1text230.setText("");
			Column1text230.setStyle(null);
			Column1text3.setText("");
			Column1text3.setStyle(null);
			Column1text330.setText("");
			Column1text330.setStyle(null);
			Column1text4.setText("");
			Column1text4.setStyle(null);
			Column1text430.setText("");
			Column1text430.setStyle(null);
			Column1text5.setText("");
			Column1text5.setStyle(null);
			LocalDate localDate1 = inputDateField.getValue();

			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			appointmentList = new PatientAppointmentEntityController().viewByNameAndDate(nameArr[0], nameArr[2], date1);

			for (PatientAppointment apt : appointmentList) {

				if (apt.getApptTime().equals("7:00 AM")) {

					Column1text7.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text7.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("7:30 AM")) {

					Column1text730.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text730.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("8:00 AM")) {

					Column1text8.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text8.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("8:30 AM")) {

					Column1text830.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text830.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:00 AM")) {

					Column1text9.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text9.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:30 AM")) {

					Column1text930.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());

					Column1text930.setStyle(" -fx-background-color: cccccc;");
				} else if (apt.getApptTime().equals("10:00 AM")) {

					Column1text10.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text10.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("10:30 AM")) {

					Column1text1030.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1030.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:00 AM")) {

					Column1text11.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text11.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:30 AM")) {

					Column1text1130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("12:00 PM")) {

					Column1text12.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text12.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("12:30 PM")) {

					Column1text1230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:00 PM")) {

					Column1text1.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:30 PM")) {

					Column1text130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:00 PM")) {

					Column1text2.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text2.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:30 PM")) {

					Column1text230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:00 PM")) {

					Column1text3.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text3.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:30 PM")) {

					Column1text330.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text330.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:00 PM")) {

					Column1text4.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text4.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:30 PM")) {

					Column1text430.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text430.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("5:00 PM")) {

					Column1text5.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
				
					Column1text5.setStyle(" -fx-background-color: cccccc;");
					// Column1text5.setFont(Font.font ("Verdana", 20));

				}

			}

		} else {

			Column1text7.setText("");
			Column1text7.setStyle(null);
			Column1text730.setText("");
			Column1text730.setStyle(null);
			Column1text8.setText("");
			Column1text8.setStyle(null);
			Column1text830.setText("");
			Column1text830.setStyle(null);
			Column1text9.setText("");
			Column1text9.setStyle(null);
			Column1text930.setText("");
			Column1text930.setStyle(null);
			Column1text10.setText("");
			Column1text10.setStyle(null);
			Column1text1030.setText("");
			Column1text1030.setStyle(null);
			Column1text11.setText("");
			Column1text11.setStyle(null);
			Column1text1130.setText("");
			Column1text1130.setStyle(null);
			Column1text12.setText("");
			Column1text12.setStyle(null);
			Column1text1230.setText("");
			Column1text1230.setStyle(null);
			Column1text1.setText("");
			Column1text1.setStyle(null);
			Column1text130.setText("");
			Column1text130.setStyle(null);
			Column1text2.setText("");
			Column1text2.setStyle(null);
			Column1text230.setText("");
			Column1text230.setStyle(null);
			Column1text3.setText("");
			Column1text3.setStyle(null);
			Column1text330.setText("");
			Column1text330.setStyle(null);
			Column1text4.setText("");
			Column1text4.setStyle(null);
			Column1text430.setText("");
			Column1text430.setStyle(null);
			Column1text5.setText("");
			Column1text5.setStyle(null);

			appointmentList = new PatientAppointmentEntityController().viewByNameAndDate(nameArr[0], nameArr[2],
					new Date());
			System.out.println("size  " + appointmentList.size());

			for (PatientAppointment apt : appointmentList) {

				if (apt.getApptTime().equals("7:00 AM")) {

					Column1text7.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text7.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("7:30 AM")) {

					Column1text730.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text730.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("8:00 AM")) {

					Column1text8.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text8.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("8:30 AM")) {

					Column1text830.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text830.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:00 AM")) {

					Column1text9.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text9.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:30 AM")) {

					Column1text930.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());

					Column1text930.setStyle(" -fx-background-color: cccccc;");
				} else if (apt.getApptTime().equals("10:00 AM")) {

					Column1text10.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text10.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("10:30 AM")) {

					Column1text1030.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1030.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:00 AM")) {

					Column1text11.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text11.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:30 AM")) {

					Column1text1130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("12:00 PM")) {

					Column1text12.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text12.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("12:30 PM")) {

					Column1text1230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:00 PM")) {

					Column1text1.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text1.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:30 PM")) {

					Column1text130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:00 PM")) {

					Column1text2.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text2.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:30 PM")) {

					Column1text230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:00 PM")) {

					Column1text3.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text3.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:30 PM")) {

					Column1text330.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text330.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:00 PM")) {

					Column1text4.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text4.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:30 PM")) {

					Column1text430.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text430.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("5:00 PM")) {

					Column1text5.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column1text5.setStyle("-fx-text-inner-color: fff ;");
					Column1text5.setStyle(" -fx-background-color: cccccc;");
					// Column1text5.setFont(Font.font ("Verdana", 20));

				}

			}
		}

	}

	// display appointment on selecting provider from comboBox1 [end]

	// display appointment on selecting provider from comboBox2 [start]

	@FXML
	void viewAppointmentByProviderCol2(ActionEvent event) {
		refreshCol2();
	}
	
	public void refreshCol2() {
		// name = Column2Choicebox.getSelectionModel().

		String name = Column2Choicebox.getSelectionModel().getSelectedItem();
		
		String nameArr[] = name.split(" ");

		if (inputDateField.getValue() != null) {

			Column2text7.setText("");
			Column2text7.setStyle(null);
			Column2text730.setText("");
			Column2text730.setStyle(null);
			Column2text8.setText("");
			Column2text8.setStyle(null);
			Column2text830.setText("");
			Column2text830.setStyle(null);
			Column2text9.setText("");
			Column2text9.setStyle(null);
			Column2text930.setText("");
			Column2text930.setStyle(null);
			Column2text10.setText("");
			Column2text10.setStyle(null);
			Column2text1030.setText("");
			Column2text1030.setStyle(null);
			Column2text11.setText("");
			Column2text11.setStyle(null);
			Column2text1130.setText("");
			Column2text1130.setStyle(null);
			Column2text12.setText("");
			Column2text12.setStyle(null);
			Column2text1230.setText("");
			Column2text1230.setStyle(null);
			Column2text1.setText("");
			Column2text1.setStyle(null);
			Column2text130.setText("");
			Column2text130.setStyle(null);
			Column2text2.setText("");
			Column2text2.setStyle(null);
			Column2text230.setText("");
			Column2text230.setStyle(null);
			Column2text3.setText("");
			Column2text3.setStyle(null);
			Column2text330.setText("");
			Column2text330.setStyle(null);
			Column2text4.setText("");
			Column2text4.setStyle(null);
			Column2text430.setText("");
			Column2text430.setStyle(null);
			Column2text5.setText("");
			Column2text5.setStyle(null);
			LocalDate localDate1 = inputDateField.getValue();

			Date date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
			appointmentList = new PatientAppointmentEntityController().viewByNameAndDate(nameArr[0], nameArr[2], date1);
			
			
			for (PatientAppointment apt : appointmentList) {

				if (apt.getApptTime().equals("7:00 AM")) {

					Column2text7.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text7.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("7:30 AM")) {

					Column2text730.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text730.setStyle(" -fx-background-color: cccccc;");
				} else if (apt.getApptTime().equals("8:00 AM")) {

					Column2text8.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text8.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("8:30 AM")) {

					Column2text830.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text830.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:00 AM")) {

					Column2text9.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text9.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:30 AM")) {

					Column2text930.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());

					Column2text930.setStyle(" -fx-background-color: cccccc;");
				} else if (apt.getApptTime().equals("10:00 AM")) {

					Column2text10.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text10.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("10:30 AM")) {

					Column2text1030.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1030.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:00 AM")) {

					Column2text11.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text11.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:30 AM")) {

					Column2text1130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("12:00 PM")) {

					Column2text12.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());

				} else if (apt.getApptTime().equals("12:30 PM")) {

					Column2text1230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:00 PM")) {

					Column2text1.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:30 PM")) {

					Column2text130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:00 PM")) {

					Column2text2.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text2.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:30 PM")) {

					Column2text230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:00 PM")) {

					Column2text3.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text3.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:30 PM")) {

					Column2text330.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text330.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:00 PM")) {

					Column2text4.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text4.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:30 PM")) {

					Column2text430.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text430.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("5:00 PM")) {

					Column2text5.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text5.setStyle(" -fx-background-color: cccccc;");

				}

			}

		} else {

			Column2text7.setText("");
			Column2text7.setStyle(null);
			Column2text730.setText("");
			Column2text730.setStyle(null);
			Column2text8.setText("");
			Column2text8.setStyle(null);
			Column2text830.setText("");
			Column2text830.setStyle(null);
			Column2text9.setText("");
			Column2text9.setStyle(null);
			Column2text930.setText("");
			Column2text930.setStyle(null);
			Column2text10.setText("");
			Column2text10.setStyle(null);
			Column2text1030.setText("");
			Column2text1030.setStyle(null);
			Column2text11.setText("");
			Column2text11.setStyle(null);
			Column2text1130.setText("");
			Column2text1130.setStyle(null);
			Column2text12.setText("");
			Column2text12.setStyle(null);
			Column2text1230.setText("");
			Column2text1230.setStyle(null);
			Column2text1.setText("");
			Column2text1.setStyle(null);
			Column2text130.setText("");
			Column2text130.setStyle(null);
			Column2text2.setText("");
			Column2text2.setStyle(null);
			Column2text230.setText("");
			Column2text230.setStyle(null);
			Column2text3.setText("");
			Column2text3.setStyle(null);
			Column2text330.setText("");
			Column2text330.setStyle(null);
			Column2text4.setText("");
			Column2text4.setStyle(null);
			Column2text430.setText("");
			Column2text430.setStyle(null);
			Column2text5.setText("");
			Column2text5.setStyle(null);

			Column1text5.setStyle(" -fx-background-color: e0e0e2 ;");

			appointmentList = new PatientAppointmentEntityController().viewByNameAndDate(nameArr[0], nameArr[2],
					new Date());
			System.out.println("size  " + appointmentList.size());
			for (PatientAppointment apt : appointmentList) {

				if (apt.getApptTime().equals("7:00 AM")) {

					Column2text7.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text7.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("7:30 AM")) {

					Column2text730.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text730.setStyle(" -fx-background-color: cccccc;");
				} else if (apt.getApptTime().equals("8:00 AM")) {

					Column2text8.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text8.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("8:30 AM")) {

					Column2text830.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text830.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:00 AM")) {

					Column2text9.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text9.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("9:30 AM")) {

					Column2text930.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());

					Column2text930.setStyle(" -fx-background-color: cccccc;");
				} else if (apt.getApptTime().equals("10:00 AM")) {

					Column2text10.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text10.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("10:30 AM")) {

					Column2text1030.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1030.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:00 AM")) {

					Column2text11.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text11.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("11:30 AM")) {

					Column2text1130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("12:00 PM")) {

					Column2text12.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());

				} else if (apt.getApptTime().equals("12:30 PM")) {

					Column2text1230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:00 PM")) {

					Column2text1.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text1.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("1:30 PM")) {

					Column2text130.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text130.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:00 PM")) {

					Column2text2.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text2.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("2:30 PM")) {

					Column2text230.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text230.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:00 PM")) {

					Column2text3.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text3.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("3:30 PM")) {

					Column2text330.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text330.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:00 PM")) {

					Column2text4.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text4.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("4:30 PM")) {

					Column2text430.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text430.setStyle(" -fx-background-color: cccccc;");

				} else if (apt.getApptTime().equals("5:00 PM")) {

					Column2text5.setText(apt.getPatient().getPatientName().getFirstName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " "
							+ apt.getPatient().getPatientName().getLastName() + " " + "/" + apt.getStatus() + "/"
							+ apt.getPurpose());
					Column2text5.setStyle(" -fx-background-color: cccccc;");

				}

			}

		}

	}
	
	// display appointment on selecting provider from comboBox2 [end]

	// view provider or doctors in choicebox
	public void viewProvider() {
       if(providertList.size()>0){
		for (Provider provider : providertList) {

			String name1 = provider.getFirstName();
			String name2 = provider.getMiddleName();
			String name3 = provider.getLastName();

			patientAppointmentMasterData.addAll(name1 + " " + name2 + " " + name3);

		}

		Column1Choicebox.getItems().clear();
		Column1Choicebox.setItems(patientAppointmentMasterData);
		Column1Choicebox.setValue(patientAppointmentMasterData.get(0));
       if(patientAppointmentMasterData.size()>1){
		Column2Choicebox.getItems().clear();
		Column2Choicebox.setItems(patientAppointmentMasterData);
		Column2Choicebox.setValue(patientAppointmentMasterData.get(1));
       
       }
       refreshCol2();
       reFresh();
       }
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewProvider();
        
		ChangeToOtherClinicButton.setOnAction((event) -> {
			String formName = formPath.context.getMessage("Clinic", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
			ClinicViewController clinicViewController = (ClinicViewController) new FXFormCommonUtilities()
					.displayForm(formName, formTitle);

			clinicViewController.setAppointmentController(this);
			new FXFormCommonUtilities().closeForm(ChangeToOtherClinicButton);
			
		
		});
		
		// show Menu item by clicking right by mouse [start]

		MenuItem menuItem1 = new MenuItem("Change Appointment");

		menuItem1.setOnAction((event) -> {
			// public void handle(ActionEvent e) {

			try {
               
				String formName = formPath.context.getMessage("SearchPatient", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SearchPatient", null, Locale.US);
                String menuStr = "Change Appointment";
				SearchPatientController searchPatientController = (SearchPatientController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				searchPatientController.setAppointmentController(this,appointmentList.get(0),menuStr);

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});

		/*if(appointmentList.get(0).get){
			
		}*/
		MenuItem menuItem2 = new MenuItem("Log Visit");

		menuItem2.setOnAction((event) -> {
			// public void handle(ActionEvent e) {

			try {

				flag = 1;
				String formName = formPath.context.getMessage("AddVisitType", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AddVisitType", null, Locale.US);

				if(appointmentList.get(0).isVisitingStatus()==false){
				VisitLogInputController visitLogInputController = (VisitLogInputController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);

				visitLogInputController.setAppointmentController(this, appointmentList);
				}else{
					Alert alert = new Alert(AlertType.INFORMATION);
				    alert.setTitle("Information");
				alert.setHeaderText("");
				alert.setContentText("patient already visited");
					alert.showAndWait();
					

					
				}
				/*
				 * VisitLogInputController visitLogInputController
				 * =(VisitLogInputController) new
				 * FXFormCommonUtilities().displayForm(formName, formTitle);
				 * 
				 * visitLogInputController.setAppointmentController(this,
				 * appointmentList);
				 */
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		
		MenuItem menuItem3 = new MenuItem("Delete");

		menuItem3.setOnAction((event) -> {
			// public void handle(ActionEvent e) {

			try {
           
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				 DialogPane dialogPane = alert.getDialogPane();

        	     dialogPane.setStyle("-fx-font-size: 12px;-fx-font-style: italic;");
				alert.setHeaderText(null);
				alert.setContentText("Are you sure you want to delete appointment for "+appointmentList.get(0).getPatient().getPatientName().getFirstName()+" "+"?");
				
				Optional<ButtonType> result = alert.showAndWait();
				if (result.get() == ButtonType.OK) {
					
					PatientAppointmentEntityController patientAppointmentEntityController= new PatientAppointmentEntityController();
					patientAppointmentEntityController.delete(appointmentList.get(0).getId());
					appointmentTextArea.setText("");
					
				}else{
					
				}
			
			
				reFresh();
				refreshCol2();
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		
		
		
		final ContextMenu contextMenu = new ContextMenu();
		/*
		 * contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3,
		 * menuItem4, menuItem5, menuItem6, menuItem7);
		 */
		contextMenu.getItems().addAll(menuItem1, menuItem2,menuItem3);
		// contextMenu.getItems().addAll(menuItem1);
		Column2text7.setContextMenu(contextMenu);

		Column2text730.setContextMenu(contextMenu);

		Column2text8.setContextMenu(contextMenu);

		Column2text830.setContextMenu(contextMenu);

		Column2text9.setContextMenu(contextMenu);

		Column2text930.setContextMenu(contextMenu);

		Column2text10.setContextMenu(contextMenu);

		Column2text1030.setContextMenu(contextMenu);

		Column2text11.setContextMenu(contextMenu);

		Column2text1130.setContextMenu(contextMenu);

		Column2text12.setContextMenu(contextMenu);

		Column2text1230.setContextMenu(contextMenu);

		Column2text1.setContextMenu(contextMenu);

		Column2text130.setContextMenu(contextMenu);

		Column2text2.setContextMenu(contextMenu);

		Column2text230.setContextMenu(contextMenu);

		Column2text3.setContextMenu(contextMenu);

		Column2text330.setContextMenu(contextMenu);

		Column2text4.setContextMenu(contextMenu);

		Column2text430.setContextMenu(contextMenu);

		Column2text5.setContextMenu(contextMenu);

		Column1text7.setContextMenu(contextMenu);

		Column1text730.setContextMenu(contextMenu);

		Column1text8.setContextMenu(contextMenu);

		Column1text830.setContextMenu(contextMenu);

		Column1text9.setContextMenu(contextMenu);

		Column1text930.setContextMenu(contextMenu);

		Column1text10.setContextMenu(contextMenu);

		Column1text1030.setContextMenu(contextMenu);

		Column1text11.setContextMenu(contextMenu);

		Column1text1130.setContextMenu(contextMenu);

		Column1text12.setContextMenu(contextMenu);

		Column1text1230.setContextMenu(contextMenu);

		Column1text1.setContextMenu(contextMenu);

		Column1text130.setContextMenu(contextMenu);

		Column1text2.setContextMenu(contextMenu);

		Column1text230.setContextMenu(contextMenu);

		Column1text3.setContextMenu(contextMenu);

		Column1text330.setContextMenu(contextMenu);

		Column1text4.setContextMenu(contextMenu);

		Column1text430.setContextMenu(contextMenu);

		Column1text5.setContextMenu(contextMenu);

		// show Menu item by clicking right by mouse [end]
		appointmentScheduleBtn.setOnAction((event) -> {
			try {

				String formName = "/view/code/appointmentSetup/appointment/AppointmentScheduling.fxml";
				String formTitle = "Appointment  Schedule";

				ScheduleController scheduleController = (ScheduleController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				scheduleController.setAppointmentController(this);

			} catch (Exception ex) {

				ex.printStackTrace();
			}
		});

		printTodaySchedulingButton.setOnAction((event) -> {
			try {
				Date date11 = null;
				String providerName = Column1Choicebox.getSelectionModel().getSelectedItem();
				String providerName2 = Column2Choicebox.getSelectionModel().getSelectedItem();
				if(inputDateField.getValue()!=null){
				LocalDate localDate1 = inputDateField.getValue();

				 date11 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
				
				}else{
					 date11 = new Date();	
					
				}
				String formName = formPath.context.getMessage("PrintTodaysScheduling", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PrintTodaysScheduling", null, Locale.US);
				
				PrintTodaysSchedulingController printTodaysSchedulingController = (PrintTodaysSchedulingController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				printTodaysSchedulingController.setAppointmentController(this,providerName,providerName2,date11);

			} catch (Exception ex) {

				ex.printStackTrace();
			}
		});
		todaysSchedulingButton.setOnAction((event) -> {

			try {
				patientViewFlag =1;
				 
				appointmentListViewByDate =	new PatientAppointmentEntityController().viewByDate(new Date());
				String formName = "/view/code/appointmentSetup/appointment/ViewPatientAppointment.fxml";
				String formTitle = "Todays  Schedule";

				PatientAppointmentViewController patientAppointmentViewController = (PatientAppointmentViewController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				patientAppointmentViewController.setAppointmentController(this,appointmentListViewByDate);
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
		checkInPatientButton.setOnAction((event) -> {

			try {
				
				String formName = "/view/code/appointmentSetup/patient/Search.fxml";
				String formTitle1 = "Search  Patient";
				//String formTitle2 = Global.company.getName();
				String formTitle2 = null;
				if(Global.company == null){
					 formTitle2 = "";
				}else{
					 formTitle2= Global.company.getName();
				}
				String formTitle=formTitle1+"/"+formTitle2;
				SearchPatientController searchPatientController =
				(SearchPatientController) new FXFormCommonUtilities().displayForm(formName , formTitle);
				searchPatientController.setAppointmentController(this,appointmentList.get(0),null);
                
				

				
				/*String formName = "/view/code/visitLog/VisitType.fxml";
				String formTitle = "Log a visit";

				VisitLogSelectController visitLogSelectController= visitLogSelectController = (VisitLogSelectController) new FXFormCommonUtilities()
						.displayForm(formName, formTitle);
				visitLogSelectController.setAppointmentController(this,appointmentList);
              */				
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		closeButton.setOnAction((event) -> {

			try {
                ScheduleController.appointmentController = null;
				new FXFormCommonUtilities().closeForm(closeButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
