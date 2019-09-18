package com.ets.controller.gui.whiteBoardController;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.entity.whiteBoardSave.WhiteBoardSaveEntityController;
import com.ets.controller.gui.companyProtocol.CompanyProtocolEditController;
import com.ets.controller.gui.emrCharting.exam.heLe.comprehensive.LymphComprehensiveInputController;
import com.ets.controller.gui.flowSheet.EncounterFormInputController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.controller.gui.whiteBoard.visitStatus.VisitStatusInputController;
import com.ets.model.Clinic;
import com.ets.model.PatientAppointment;
import com.ets.model.PatientVisit;
import com.ets.model.WhiteboardSave;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

import javafx.scene.control.MenuItem;
import javafx.scene.control.TextInputDialog;

import javafx.scene.effect.BlendMode;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class PatientWhiteBoardController implements Initializable {

	@FXML
	private ListView<String> waitingRoomList;

	@FXML
	private ListView<String> labListView;

	@FXML
	private ListView<String> xRayListView;

	@FXML
	private ListView<String> checkOutListView;

	@FXML
	private ListView<String> examRoom2ListView;

	@FXML
	private ListView<String> examRoom1ListView;

	@FXML
	private ListView<String> examRoom7ListView;

	@FXML
	private ListView<String> eyeRoomListView;

	@FXML
	private ListView<String> hcgListView;

	@FXML
	private ListView<String> physicalListView;

	@FXML
	private ListView<String> lacerationListView;

	@FXML
	private DatePicker inputDateField;

	@FXML
	private Button cancelButton;
	

	public static String listView=null;

	public static Integer FlagCheckFirst = 0;

	@FXML
	void DragEnter(DragEvent event) {
		System.out.println("Drag entered");
	}

	@FXML
	void DragExited(DragEvent event) {

		/*
		 * String formName =
		 * formPath.context.getMessage("ClinicWhiteboardDragForm", null,
		 * Locale.US);
		 * 
		 * String formTitle =
		 * formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null,
		 * Locale.US);
		 * 
		 * VisitStatusInputController visitStatusInputController =
		 * (VisitStatusInputController) new FXFormCommonUtilities()
		 * .displayForm(formName, formTitle);
		 * visitStatusInputController.setPatientWhiteBoardController(this,
		 * patienVisitList);
		 */
		System.out.println("Drag exited");

	}

	@FXML
	void waitingRoomListShowByMouseClick(MouseEvent event) {

		System.out.println("Run By Mouse Clicked List View1");
	}

	Date date = new Date();
	private ObservableList<String> patientAppointmentMasterData = FXCollections.observableArrayList();
	// private List<PatientAppointment> appointmentList = new
	// PatientAppointmentEntityController().viewByDate(date);

	public List<PatientVisit> patienVisitList = new PatientVisitEntityController().viewByDate(date);

	public PatientVisit selectedPatientList = null;
	private boolean patientVisitFlag = false;

	@FXML
	void showAppointmentBydate(ActionEvent event) {

		LocalDate localDate2 = inputDateField.getValue();

		if (localDate2 != null) {

			date = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());

		/*	patientAppointmentMasterData = FXCollections.observableArrayList();
			patientAppointmentMasterData.add(patientVisit.getPatient().getPatientName().getFirstName() + " "
					+ patientVisit.getPatient().getPatientName().getMiddleName() + " "
					+ patientVisit.getPatient().getPatientName().getLastName() + " "
					+ patientVisit.getArrivalTime() + " " + patientVisit.getVisitCategory().getCode());*/
			patienVisitList = new PatientVisitEntityController().viewByDate(date);
			ObservableList<String> whiteBoardsWaiting = null;

			ObservableList<String> checkOut = null;
			ObservableList<String> whiteBoardXray = null;
			ObservableList<String> whiteBoardRoom1 = null;
			ObservableList<String> whiteBoardRoom2 = null;
			ObservableList<String> whiteBoardRoom7 = null;
			ObservableList<String> whiteBoardEye = null;
			ObservableList<String> whiteBoardHcg = null;
			ObservableList<String> whiteBoardLab = null;
			ObservableList<String> whiteBoardLacerationRoom = null;
			ObservableList<String> whiteBoardPhysicalRoom = null;

		
			/*if (inputDateField.getValue() != null) {

				LocalDate localDate = inputDateField.getValue();
				Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

				patientVisits = new PatientVisitEntityController().viewByDate(date1);
			} else {

				patientVisits = new PatientVisitEntityController().viewByDate(new Date());

			}*/

			whiteBoardsWaiting = FXCollections.observableArrayList();
			checkOut = FXCollections.observableArrayList();
			whiteBoardXray = FXCollections.observableArrayList();

			whiteBoardRoom1 = FXCollections.observableArrayList();
			whiteBoardRoom2 = FXCollections.observableArrayList();
			whiteBoardRoom7 = FXCollections.observableArrayList();
			whiteBoardEye = FXCollections.observableArrayList();
			whiteBoardHcg = FXCollections.observableArrayList();
			whiteBoardLab = FXCollections.observableArrayList();
			whiteBoardLacerationRoom = FXCollections.observableArrayList();
			whiteBoardPhysicalRoom = FXCollections.observableArrayList();

			for (PatientVisit visitList : patienVisitList) {

				if (visitList.getWaitingRoom() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardsWaiting.add(time + " " + firstname + " " + lastname + " " + status);
					System.out.println("waiting " + whiteBoardsWaiting.size());

				}

				if (visitList.getCheckOut() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					checkOut.add(time + " " + firstname + " " + lastname + " " + status);
					System.out.println("checkout " + patientVisits);

				}
				if (visitList.getXRay() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardXray.add(time + " " + firstname + " " + lastname + " " + status);
					System.out.println("Xray " + whiteBoardXray);

				}
				/*
				 * if (visitList.getPhysicalRoom() == true) {
				 * 
				 * String firstname =
				 * visitList.getPatient().getPatientName().getFirstName(); String
				 * lastname = visitList.getPatient().getPatientName().getLastName();
				 * String status = visitList.getStatus(); String time =
				 * visitList.getArrivalTime(); Integer id = visitList.getId();
				 * whiteBoardPhysicalRoom.add(time + " " + firstname + " " +
				 * lastname + " " + status);
				 * physicalListView.setItems(whiteBoardPhysicalRoom);
				 * 
				 * }
				 */

				if (visitList.getExamRoom1() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardRoom1.add(time + " " + firstname + " " + lastname + " " + status);

				}

				if (visitList.getExamRoom2() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardRoom2.add(time + " " + firstname + " " + lastname + " " + status);

				}
				if (visitList.getExamRoom7() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardRoom7.add(time + " " + firstname + " " + lastname + " " + status);

				}
				if (visitList.getEyeRoom() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardEye.add(time + " " + firstname + " " + lastname + " " + status);

				}
				if (visitList.getHcg() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardHcg.add(time + " " + firstname + " " + lastname + " " + status);

				}
				if (visitList.getLab() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardLab.add(time + " " + firstname + " " + lastname + " " + status);

				}
				if (visitList.getlacerationRoom() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardLacerationRoom.add(time + " " + firstname + " " + lastname + " " + status);

				}
				if (visitList.getPhysicalRoom() == true) {

					String firstname = visitList.getPatient().getPatientName().getFirstName();
					String lastname = visitList.getPatient().getPatientName().getLastName();
					String status = visitList.getStatus();
					String time = visitList.getArrivalTime();
					Integer id = visitList.getId();
					whiteBoardPhysicalRoom.add(time + " " + firstname + " " + lastname + " " + status);

				}

			}
			physicalListView.setItems(whiteBoardPhysicalRoom);
			lacerationListView.setItems(whiteBoardLacerationRoom);
			labListView.setItems(whiteBoardLab);
			hcgListView.setItems(whiteBoardHcg);
			eyeRoomListView.setItems(whiteBoardEye);
			examRoom7ListView.setItems(whiteBoardRoom7);
			examRoom2ListView.setItems(whiteBoardRoom2);
			examRoom1ListView.setItems(whiteBoardRoom1);
			xRayListView.setItems(whiteBoardXray);
			checkOutListView.setItems(checkOut);
			waitingRoomList.setItems(whiteBoardsWaiting);


	}}

	

	public void viewPatientAppointmentByDate() {

		for (PatientVisit patientVisit : patienVisitList) {


			patientAppointmentMasterData.add(patientVisit.getPatient().getPatientName().getFirstName() + " "
					+ patientVisit.getPatient().getPatientName().getMiddleName() + " "
					+ patientVisit.getPatient().getPatientName().getLastName() + " " + patientVisit.getArrivalTime()
					+ " " + patientVisit.getVisitCategory().getCode());

		}

		waitingRoomList.setItems(patientAppointmentMasterData);

	}

	@FXML
	void enterKeyPressedFoCloseButton(KeyEvent event) {
		if (event.getCode() == KeyCode.ENTER) {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

	}

	@FXML
	void waitingRoomListMousePressed(MouseEvent event) {

		System.out.println("Waiting RoomList Mosuse Clicked Function Success #################");
		String patientDetail = waitingRoomList.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");
		System.out.println("Patient Name is :  " + patientDetailArr[2]+" "+patientDetailArr[1]);
		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		

		Global.patient = selectedPatientList.getPatient();

	}

	/*
	 * @FXML void waitingRoomListMouseClicked(MouseEvent event) {
	 * 
	 * System.out.println(
	 * "Waiting RoomList Mosuse Clicked Function Success #################");
	 * String patientDetail =
	 * waitingRoomList.getSelectionModel().getSelectedItem();
	 * 
	 * String patientDetailArr[] = patientDetail.split(" ");
	 * 
	 * selectedPatientList = new
	 * PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[0],
	 * patientDetailArr[2], patientDetailArr[3]); System.out.println(
	 * "Patient Name is :  " +patientDetailArr[2]);
	 * 
	 * Global.patient = selectedPatientList.getPatient();
	 * 
	 * 
	 * 
	 * 
	 * }
	 */

	@FXML
	void waitingRoomDargDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		System.out.println("White Board Drag Detacted");
		ClipboardContent content = new ClipboardContent();
		content.putString(waitingRoomList.getSelectionModel().getSelectedItem());

		String patientDetail = waitingRoomList.getSelectionModel().getSelectedItem();

		/*
		 * String patientDetailArr[] = patientDetail.split(" ");
		 * System.out.println("Length of Array is : " +
		 * patientDetailArr.length); System.out.println("First Array is " +
		 * patientDetailArr[0]); System.out.println("Second Array is " +
		 * patientDetailArr[1]); System.out.println("Third Array is " +
		 * patientDetailArr[2]); System.out.println("Fourth Array is " +
		 * patientDetailArr[3]); System.out.println("Fifth Array is " +
		 * patientDetailArr[4]);
		 */

		/*
		 * selectedPatientList = new
		 * PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[0],
		 * patientDetailArr[2], patientDetailArr[3]); System.out.println(
		 * "Patient Visit Id " + selectedPatientList.getId());
		 * System.out.println("Patient Visit Purpose " +
		 * selectedPatientList.getPurpose());
		 */
		dragBoard.setContent(content);

	}

	@FXML
	void labDragOver(DragEvent event) {
		System.out.println("Lab  Drag Over");
		/*
		 * if (event.getGestureSource() != labListView &&
		 * event.getDragboard().hasString()) {
		 * 
		 * event.acceptTransferModes(TransferMode.MOVE);
		 * 
		 * }
		 */
		event.acceptTransferModes(TransferMode.MOVE);

		event.consume();
	}

	@FXML
	void xRayDragOver(DragEvent event) {

		if (event.getGestureSource() != xRayListView && event.getDragboard().hasString()) {

			event.acceptTransferModes(TransferMode.MOVE);

		}
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void checkOutDragOver(DragEvent event) {
		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();
	}

	@FXML
	void examRoom1DragOver(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void examRoom2DragOver(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void examRoom7DragOver(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void eyeRoomDragOver(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void hcgRoomDragOver(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void lacerationRoomDragOver(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void physicalRoomDragOver(DragEvent event) {

		event.acceptTransferModes(TransferMode.MOVE);
		event.consume();

	}

	@FXML
	void labDragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		System.out.println("Lab  Drag Detacted");
		ClipboardContent content = new ClipboardContent();
		content.putString(labListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void labDragDroped(DragEvent event) {
		System.out.println("Lab  Drag Droped");

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);

		listView="labListView";
	

		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()

				.displayForm(formName, formTitle);
		 visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);
		
		
		
	}

	@FXML
	void labMousePressed(MouseEvent event) {

		String patientDetail = labListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void xRayDragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(xRayListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void xRayDragDroped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);

		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView = "xRayListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);
		for (PatientVisit patientVisit : patienVisitList) {
			System.out.println("" + selectedPatientList.getVisitStatusWhite());
			System.out.println("" + selectedPatientList.getStatus());
		}

	}

	@FXML
	void xRayMousePressed(MouseEvent event) {

		String patientDetail = xRayListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void checkOutDragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(checkOutListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void checkOutMousePressed(MouseEvent event) {

		String patientDetail = checkOutListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void checkOutDragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView = "checkOutListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);
		for (PatientVisit patientVisit : patienVisitList) {
			System.out.println("" + selectedPatientList.getVisitStatusWhite());
			System.out.println("" + selectedPatientList.getStatus());
		}

	}

	@FXML
	void examRoom2DragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(examRoom2ListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void examRoom2MousePressed(MouseEvent event) {

		String patientDetail = examRoom2ListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void examRoom2DragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView = "examRoom2ListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);
		for (PatientVisit patientVisit : patienVisitList) {
			System.out.println("" + selectedPatientList.getVisitStatusWhite());
			System.out.println("" + selectedPatientList.getStatus());
		}
	}

	@FXML
	void examRoom1DragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(examRoom1ListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void examRoom1MousePressed(MouseEvent event) {

		String patientDetail = examRoom1ListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void examRoom1DragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView = "examRoom1ListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);
		for (PatientVisit patientVisit : patienVisitList) {
			System.out.println("" + selectedPatientList.getVisitStatusWhite());
			System.out.println("" + selectedPatientList.getStatus());
		}
	}

	@FXML
	void examRoom7DragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(examRoom7ListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void examRoom7MousePressed(MouseEvent event) {

		String patientDetail = examRoom7ListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void examRoom7DragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView = "examRoom7ListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);
		for (PatientVisit patientVisit : patienVisitList) {
			System.out.println("" + selectedPatientList.getVisitStatusWhite());
			System.out.println("" + selectedPatientList.getStatus());
		}

	}

	@FXML
	void eyeRoomDragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(eyeRoomListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void eyeRoomMousePressed(MouseEvent event) {

		String patientDetail = eyeRoomListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void eyeRoomDragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView = "eyeRoomListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);
		for (PatientVisit patientVisit : patienVisitList) {
			System.out.println("" + selectedPatientList.getVisitStatusWhite());
			System.out.println("" + selectedPatientList.getStatus());
		}

	}

	@FXML
	void hcgDragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(hcgListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void hcgMousePressed(MouseEvent event) {

		String patientDetail = hcgListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void hcgDragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView="hcgListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);

	}

	@FXML
	void physicalRoomDragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(physicalListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void physicalRoomMousePressed(MouseEvent event) {

		String patientDetail = physicalListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void physicalRoomDragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView="physicalListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);

	}

	@FXML
	void lacerationRoomDragDetected(MouseEvent event) {

		Dragboard dragBoard = waitingRoomList.startDragAndDrop(TransferMode.MOVE);

		/* Put a string on a dragboard */
		ClipboardContent content = new ClipboardContent();
		content.putString(lacerationListView.getSelectionModel().getSelectedItem());
		dragBoard.setContent(content);

	}

	@FXML
	void lacerationRoomMousePressed(MouseEvent event) {

		String patientDetail = lacerationListView.getSelectionModel().getSelectedItem();

		String patientDetailArr[] = patientDetail.split(" ");

		selectedPatientList = new PatientVisitEntityController().ViewByNameAndDate(patientDetailArr[1],
				patientDetailArr[2], patientDetailArr[0]);
		System.out.println("Patient Name is :  " + patientDetailArr[2]);

		Global.patient = selectedPatientList.getPatient();

	}

	@FXML
	void lacerationRoomDragDropped(DragEvent event) {

		String formName = formPath.context.getMessage("ClinicWhiteboardDragForm", null, Locale.US);
		String formTitle = formPath.context.getMessage("Title.ClinicWhiteboardDragForm", null, Locale.US);
		listView = "lacerationListView";
		VisitStatusInputController visitStatusInputController = (VisitStatusInputController) new FXFormCommonUtilities()
				.displayForm(formName, formTitle);
		visitStatusInputController.setPatientWhiteBoardController(this, selectedPatientList);

	}

	FXMLFormPath formPath = new FXMLFormPath();
	private ObservableList<PatientVisit> patientVisits = FXCollections.observableArrayList();
	/*
	 * private ObservableList<String> whiteBoardsaveStr =
	 * FXCollections.observableArrayList();
	 */
	public boolean flag = false;

	public void viewwhiteBoard() {
		
		ObservableList<String> whiteBoardsWaiting = null;

		ObservableList<String> checkOut = null;
		ObservableList<String> whiteBoardXray = null;
		ObservableList<String> whiteBoardRoom1 = null;
		ObservableList<String> whiteBoardRoom2 = null;
		ObservableList<String> whiteBoardRoom7 = null;
		ObservableList<String> whiteBoardEye = null;
		ObservableList<String> whiteBoardHcg = null;
		ObservableList<String> whiteBoardLab = null;
		ObservableList<String> whiteBoardLacerationRoom = null;
		ObservableList<String> whiteBoardPhysicalRoom = null;

	
		if (inputDateField.getValue() != null) {

			LocalDate localDate = inputDateField.getValue();
			Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

			patientVisits = new PatientVisitEntityController().viewByDate(date1);
			
		} else {

			patientVisits = new PatientVisitEntityController().viewByDate(new Date());

		}

		whiteBoardsWaiting = FXCollections.observableArrayList();
		checkOut = FXCollections.observableArrayList();
		whiteBoardXray = FXCollections.observableArrayList();

		whiteBoardRoom1 = FXCollections.observableArrayList();
		whiteBoardRoom2 = FXCollections.observableArrayList();
		whiteBoardRoom7 = FXCollections.observableArrayList();
		whiteBoardEye = FXCollections.observableArrayList();
		whiteBoardHcg = FXCollections.observableArrayList();
		whiteBoardLab = FXCollections.observableArrayList();
		whiteBoardLacerationRoom = FXCollections.observableArrayList();
		whiteBoardPhysicalRoom = FXCollections.observableArrayList();

		for (PatientVisit visitList : patientVisits) {

			if (visitList.getWaitingRoom() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardsWaiting.add(time + " " + firstname + " " + lastname + " " + status);
				System.out.println("waiting " + whiteBoardsWaiting.size());

			}

			else if (visitList.getCheckOut() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				checkOut.add(time + " " + firstname + " " + lastname + " " + status);
				System.out.println("checkout " + patientVisits);

			}
			else if (visitList.getXRay() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardXray.add(time + " " + firstname + " " + lastname + " " + status);
				System.out.println("Xray " + whiteBoardXray);

			}
			/*
			 * if (visitList.getPhysicalRoom() == true) {
			 * 
			 * String firstname =
			 * visitList.getPatient().getPatientName().getFirstName(); String
			 * lastname = visitList.getPatient().getPatientName().getLastName();
			 * String status = visitList.getStatus(); String time =
			 * visitList.getArrivalTime(); Integer id = visitList.getId();
			 * whiteBoardPhysicalRoom.add(time + " " + firstname + " " +
			 * lastname + " " + status);
			 * physicalListView.setItems(whiteBoardPhysicalRoom);
			 * 
			 * }
			 */

			else if (visitList.getExamRoom1() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardRoom1.add(time + " " + firstname + " " + lastname + " " + status);

			}

			else if (visitList.getExamRoom2() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardRoom2.add(time + " " + firstname + " " + lastname + " " + status);

			}
			else if (visitList.getExamRoom7() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardRoom7.add(time + " " + firstname + " " + lastname + " " + status);

			}
			else if (visitList.getEyeRoom() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardEye.add(time + " " + firstname + " " + lastname + " " + status);

			}
			else if (visitList.getHcg() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardHcg.add(time + " " + firstname + " " + lastname + " " + status);

			}
			else if (visitList.getLab() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardLab.add(time + " " + firstname + " " + lastname + " " + status);

			}
			else if (visitList.getlacerationRoom() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardLacerationRoom.add(time + " " + firstname + " " + lastname + " " + status);

			}
			else if (visitList.getPhysicalRoom() == true) {

				String firstname = visitList.getPatient().getPatientName().getFirstName();
				String lastname = visitList.getPatient().getPatientName().getLastName();
				String status = visitList.getStatus();
				String time = visitList.getArrivalTime();
				Integer id = visitList.getId();
				whiteBoardPhysicalRoom.add(time + " " + firstname + " " + lastname + " " + status);

			}
			else
			{
				System.out.println("No Patient");
			}

		}
		physicalListView.setItems(whiteBoardPhysicalRoom);
		lacerationListView.setItems(whiteBoardLacerationRoom);
		labListView.setItems(whiteBoardLab);
		hcgListView.setItems(whiteBoardHcg);
		eyeRoomListView.setItems(whiteBoardEye);
		examRoom7ListView.setItems(whiteBoardRoom7);
		examRoom2ListView.setItems(whiteBoardRoom2);
		examRoom1ListView.setItems(whiteBoardRoom1);
		xRayListView.setItems(whiteBoardXray);
		checkOutListView.setItems(checkOut);
		waitingRoomList.setItems(whiteBoardsWaiting);

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ListView<String> lb=labListView;
     System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%"+lb.getId());
		viewwhiteBoard();

		/*
		 * for (WhiteboardSave whiteBoardSave : whiteBoardsavList) {
		 * 
		 * String rocedure=whiteBoardSave.getProcedure(); String status =
		 * whiteBoardSave.getStatus();
		 * 
		 * whiteBoardsaveStr.add(rocedure+" "+status); System.out.println(
		 * "********** "+whiteBoardsaveStr.size());
		 * 
		 * }
		 */

		/*
		 * MenuItem menuItem1 = new MenuItem("Change Patient Status");
		 * 
		 * menuItem1.setOnAction(new EventHandler<ActionEvent>() { public void
		 * handle(ActionEvent e) {
		 * 
		 * System.out.println("Change Patient Status"); } });
		 * 
		 * MenuItem menuItem2 = new MenuItem("View Protocol for this visit");
		 * 
		 * menuItem2.setOnAction(new EventHandler<ActionEvent>() { public void
		 * handle(ActionEvent e) {
		 * 
		 * System.out.println("View Protocol for this visit"); } });
		 * 
		 * MenuItem menuItem3 = new MenuItem("Record Vital Signs");
		 * 
		 * menuItem3.setOnAction(new EventHandler<ActionEvent>() { public void
		 * handle(ActionEvent e) {
		 * 
		 * System.out.println("Record Vital Signs"); } });
		 * 
		 * MenuItem menuItem4 = new MenuItem("Access/Update Clinic Visit");
		 * 
		 * menuItem4.setOnAction(new EventHandler<ActionEvent>() { public void
		 * handle(ActionEvent e) {
		 * 
		 * System.out.println("Access/Update Clinic Visit"); } });
		 * 
		 * MenuItem menuItem5 = new MenuItem("Visit Orders");
		 * 
		 * menuItem5.setOnAction(new EventHandler<ActionEvent>() { public void
		 * handle(ActionEvent e) {
		 * 
		 * System.out.println("Visit Orders"); } });
		 * 
		 * MenuItem menuItem6 = new MenuItem("Visit Results/Charges");
		 * 
		 * menuItem6.setOnAction(new EventHandler<ActionEvent>() { public void
		 * handle(ActionEvent e) {
		 * 
		 * System.out.println("Visit Results/Charges"); } });
		 */
		
		MenuItem menuItem4 = new MenuItem("View Protocol for this Visit");
		
		menuItem4.setOnAction((event) -> {
			try {
				
				Global.patientVisitObj = selectedPatientList;
				String formName = formPath.context.getMessage("EditProtocol", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EditProtocol", null, Locale.US);
				
				String formTitle2 = selectedPatientList.getPatient().getCompany().getName();
				String formTitle = formTitle1 + "(" + formTitle2 +")";
				formPath.closeApplicationContext();
				CompanyProtocolEditController companyProtocolEditController =
				(CompanyProtocolEditController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				companyProtocolEditController.setPatientWhiteBoardController(this);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		/*menuItem4.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				try {
					Global.patientVisitObj = selectedPatientList;
					String formName = formPath.context.getMessage("EditProtocol", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.EditProtocol", null, Locale.US);
					

					
					String formTitle2 = selectedPatientList.getPatient().getCompany().getName();
					String formTitle = formTitle1 + "(" + formTitle2 +")";
					formPath.closeApplicationContext();
					CompanyProtocolEditController companyProtocolEditController =
					(CompanyProtocolEditController) new FXFormCommonUtilities().displayForm(formName, formTitle);
					//companyProtocolEditController.setPatientWhiteBoardController(this);

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});*/
		
		MenuItem menuItem5 = new MenuItem("Record Vital Signs");
		
		/*menuItem5.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				try {

					String formName = formPath.context.getMessage("EnterVitalSignValue", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.EnterVitalSignValue", null, Locale.US);
					

					Global.patientVisitObj = selectedPatientList;
					String formTitle2 = selectedPatientList.getPatient().getPatientName().getFirstName() + " "
							+ selectedPatientList.getPatient().getPatientName().getLastName();
					String formTitle = formTitle1 + "/" + formTitle2;
					formPath.closeApplicationContext();
					new FXFormCommonUtilities().displayForm(formName, formTitle);
					

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});*/
		
		menuItem5.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("EnterVitalSignValue", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.EnterVitalSignValue", null, Locale.US);
				

				Global.patientVisitObj = selectedPatientList;
				String formTitle2 = selectedPatientList.getPatient().getPatientName().getFirstName() + " "
						+ selectedPatientList.getPatient().getPatientName().getLastName();
				String formTitle = formTitle1 + "/" + formTitle2;
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		MenuItem menuItem6 = new MenuItem("Visit Log");
		
		menuItem6.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				try {

					String formName = formPath.context.getMessage("AddVisitType", null, Locale.US);
					String formTitle1 = formPath.context.getMessage("Title.AddVisitType", null, Locale.US);
					

					Global.patientVisitObj = selectedPatientList;
					String formTitle2 = selectedPatientList.getPatient().getPatientName().getFirstName() + " "
							+ selectedPatientList.getPatient().getPatientName().getLastName();
					String formTitle = formTitle1 + "/" + formTitle2;
					formPath.closeApplicationContext();
					//new FXFormCommonUtilities().displayForm(formName, formTitle);
					
					VisitLogInputController visitLogInputController =
							(VisitLogInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
							
					visitLogInputController.setPatientWhiteBoardController();
							

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		
		MenuItem menuItem7 = new MenuItem("EMR Charting");

		menuItem7.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				try {

					if (selectedPatientList != null) {

						System.out.println(
								"VALUER :   " + selectedPatientList.getPatient().getPatientName().getFirstName());

						String formName = formPath.context.getMessage("GenericEMRCharting", null, Locale.US);
						String formTitle1 = formPath.context.getMessage("Title.GenericEMRCharting", null, Locale.US);

						Global.patientVisitObj = selectedPatientList;
						String formTitle2 = selectedPatientList.getPatient().getPatientName().getFirstName() + " "
								+ selectedPatientList.getPatient().getPatientName().getLastName();
						String formTitle = formTitle1 + "/" + formTitle2;
						formPath.closeApplicationContext();
						new FXFormCommonUtilities().displayForm(formName, formTitle);

					}

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

		});
		final ContextMenu contextMenu = new ContextMenu();
		/*
		 * contextMenu.getItems().addAll(menuItem1, menuItem2, menuItem3,
		 * menuItem4, menuItem5, menuItem6, menuItem7);
		 */
		contextMenu.getItems().addAll(menuItem4, menuItem5, menuItem6, menuItem7);
		waitingRoomList.setContextMenu(contextMenu);
		labListView.setContextMenu(contextMenu);
		xRayListView.setContextMenu(contextMenu);
		checkOutListView.setContextMenu(contextMenu);
		examRoom1ListView.setContextMenu(contextMenu);
		examRoom2ListView.setContextMenu(contextMenu);
		examRoom7ListView.setContextMenu(contextMenu);
		eyeRoomListView.setContextMenu(contextMenu);
		hcgListView.setContextMenu(contextMenu);
		physicalListView.setContextMenu(contextMenu);
		lacerationListView.setContextMenu(contextMenu);
		/* viewPatientAppointmentByDate(); */

		cancelButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}