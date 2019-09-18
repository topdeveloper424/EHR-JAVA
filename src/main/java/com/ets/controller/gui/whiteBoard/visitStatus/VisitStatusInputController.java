package com.ets.controller.gui.whiteBoard.visitStatus;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.hibernate.event.spi.SaveOrUpdateEvent;

import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.entity.whiteBoardSave.WhiteBoardSaveEntityController;
import com.ets.controller.gui.whiteBoardController.PatientWhiteBoardController;
import com.ets.model.PatientVisit;
import com.ets.model.WhiteboardSave;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class VisitStatusInputController implements Initializable {

	@FXML
	private Button addButton;

	@FXML
	private Button closeButton;

	@FXML
	private ChoiceBox<String> locationChoice;

	@FXML
	private ChoiceBox<String> visitChoice;

	@FXML
	private TextField statusTimeText;
	@FXML
	private Label patientNameLabel;
	@FXML
	private TextField procedureText;
	
	
	private boolean flagTest = false;

	private PatientVisit patVisit;

	private PatientWhiteBoardController patientWhiteBoardController;

	public void setPatientWhiteBoardController(PatientWhiteBoardController patientWhiteBoardController,
			PatientVisit patVisit) {
		this.patientWhiteBoardController = patientWhiteBoardController;
		this.patVisit = patVisit;
		
	}

	public void setChoiceBox() {

		if (patientWhiteBoardController.listView.equals("waitingRoomList")) {

			locationChoice.setValue("Waiting Room");
			
		}

		if (patientWhiteBoardController.listView.equals("labListView")){

			locationChoice.setValue("Lab");
			
		}

		if (patientWhiteBoardController.listView.equals("xRayListView")) {

			locationChoice.setValue("X-Ray");
			
		}

		if (patientWhiteBoardController.listView.equals("checkOutListView")) {

			locationChoice.setValue("Check out");
			
		}

		if (patientWhiteBoardController.listView.equals("examRoom1ListView")) {

			locationChoice.setValue("Exam Room 1");
			
		}

		if (patientWhiteBoardController.listView.equals("examRoom2ListView")) {

			locationChoice.setValue("Exam Room 2");
			
		}

		if (patientWhiteBoardController.listView.equals("examRoom7ListView")){

			locationChoice.setValue("Exam Room 7");
			
		}

		if (patientWhiteBoardController.listView.equals("eyeRoomListView")){

			locationChoice.setValue("Eye Room");
			
		}

		if (patientWhiteBoardController.listView.equals("hcgListView")){

			locationChoice.setValue("HCG");

		}

		if (patientWhiteBoardController.listView.equals("physicalListView")){

			locationChoice.setValue("Physical Room");

		}

		if (patientWhiteBoardController.listView.equals("lacerationListView")){

			locationChoice.setValue("Laceration Room");

		}

	}
	
	

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		
		setChoiceBox();
		
		
		List<String> list = new ArrayList<String>();

		list.add("Waiting Room");
		list.add("X-Ray");
		list.add("Exam Room 1");
		list.add("Exam Room 2");
		list.add("Exam Room 7");
		list.add("HCG");
		list.add("Check out");
		list.add("Lab");
		list.add("Laceration Room");
		list.add("Eye Room");
		list.add("Physical Room");
		list.add("Discharge");
		ObservableList obList = FXCollections.observableList(list);
		locationChoice.getItems().clear();
		locationChoice.setItems(obList);

		List<String> visitStatusList = new ArrayList<String>();

		visitStatusList.add("waiting");
		visitStatusList.add("with clinician");
		visitStatusList.add("with provider");
		visitStatusList.add("ready for discharge");
		visitStatusList.add("at checkout");

		ObservableList visitList = FXCollections.observableList(visitStatusList);
		visitChoice.getItems().clear();
		visitChoice.setItems(visitList);
		
		
		
		addButton.setOnAction((event) -> {

			try {

				patVisit.setStatus(statusTimeText.getText());

				patVisit.setProcedure(procedureText.getText());
				// patientVisit.setPatientVisit(patVisit);
				if (locationChoice.getSelectionModel().getSelectedItem() == "Waiting Room") {
					patVisit.setWaitingRoom(true);
				}
				if (locationChoice.getSelectionModel().getSelectedItem() == "X-Ray") {
					patVisit.setXRay(true);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);

					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);

				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "Check out") {
					patVisit.setCheckOut(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);

					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);

					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);

				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "Exam Room 1") {
					patVisit.setExamRoom1(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);
					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);
				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "Exam Room 2") {
					patVisit.setExamRoom2(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);

					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);
					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);
				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "Exam Room 7") {
					patVisit.setExamRoom7(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);

					patVisit.setHcg(false);
					patVisit.setLab(false);

					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);
				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "HCG") {
					patVisit.setHcg(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setLab(false);

					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);
				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "Lab") {
					patVisit.setLab(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);

					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);
				}
				if (locationChoice.getSelectionModel().getSelectedItem() == "Physical Room") {
					patVisit.setPhysicalRoom(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);
					patVisit.setLacerationRoom(false);
					patVisit.setEyeRoom(false);
				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "Laceration Room") {
					patVisit.setLacerationRoom(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);
					patVisit.setPhysicalRoom(false);

					patVisit.setEyeRoom(false);
				}
				if (locationChoice.getSelectionModel().getSelectedItem() == "Eye Room") {
					patVisit.setEyeRoom(true);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);

					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);

				}

				if (locationChoice.getSelectionModel().getSelectedItem() == "Discharge") {
					patVisit.setEyeRoom(false);
					patVisit.setXRay(false);
					patVisit.setWaitingRoom(false);
					patVisit.setCheckOut(false);
					patVisit.setExamRoom1(false);
					patVisit.setExamRoom2(false);
					patVisit.setExamRoom7(false);
					patVisit.setHcg(false);
					patVisit.setLab(false);

					patVisit.setPhysicalRoom(false);
					patVisit.setLacerationRoom(false);

				}

				if (visitChoice.getSelectionModel().getSelectedItem() == "waiting") {
					patVisit.setVisitStatusWhite("waiting");
				}

				if (visitChoice.getSelectionModel().getSelectedItem() == "with clinician") {
					patVisit.setVisitStatusWhite("with clinician");
				}

				if (visitChoice.getSelectionModel().getSelectedItem() == "with provider") {
					patVisit.setVisitStatusWhite("with provider");
				}
				if (visitChoice.getSelectionModel().getSelectedItem() == "ready for discharge") {
					patVisit.setVisitStatusWhite("ready for discharge");
				}
				if (visitChoice.getSelectionModel().getSelectedItem() == "at checkout") {
					patVisit.setVisitStatusWhite("at checkout");
				}

				new PatientVisitEntityController().saveOrUpdate(patVisit);

				patientWhiteBoardController.viewwhiteBoard();

				new FXFormCommonUtilities().closeForm(addButton);

			} catch (Exception e) {

				e.printStackTrace();

			}

		});
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
