package com.ets.controller.gui.appointment;

import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.fxmisc.easybind.EasyBind;

import com.ets.controller.entity.patientAppointment.PatientAppointmentEntityController;
import com.ets.controller.gui.district.DistrictEditController;
import com.ets.controller.gui.patient.PatientViewController;
import com.ets.controller.gui.patient.SearchPatientController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.District;
import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.model.VisitCategory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class PatientAppointmentViewController implements Initializable {
	
	@FXML
    private TableView<PatientAppointment> patientAppointmentTable;

    @FXML
    private TableColumn<PatientAppointment, Date> dateCollumn;

    @FXML
    private TableColumn<PatientAppointment, String> categoryCollumn;

    @FXML
    private TableColumn<PatientAppointment, String> purposeCollumn;

    @FXML
    private TableColumn<PatientAppointment, String> protocolCollumn;

    @FXML
    private TableColumn<PatientAppointment, String> statusCollumn;

    @FXML
    private Button selectButton;

    @FXML
    private Button cancelButton;
    
    public PatientViewController patientViewController;
    private Button button;
	public void setPatientViewController(PatientViewController patientViewController,Button button) {
		this.patientViewController = patientViewController;
		this.button=button;
		
	}

	private AppointmentController appointmentController;
    private ObservableList<PatientAppointment> appointmentListViewByDate;
  
  
	public void setAppointmentController(AppointmentController appointmentController,ObservableList<PatientAppointment>appointmentListViewByDate) {
		this.appointmentController = appointmentController;
		this.appointmentListViewByDate = appointmentListViewByDate;
		if(appointmentListViewByDate.size()!=0){
		dateCollumn.setCellValueFactory(cellData -> cellData.getValue().apptDateProperty());
    	
		
		//categoryCollumn.setCellValueFactory(cellData -> cellData.getValue().getVisitCatId().codeProperty());
		categoryCollumn.setCellValueFactory( cellData -> 
		    EasyBind.select(cellData.getValue().visitCatIdProperty())
		        .selectObject(VisitCategory::codeProperty));
		    
    	purposeCollumn.setCellValueFactory(cellData -> cellData.getValue().purposeProperty());
    	//protocolCollumn.setCellValueFactory(cellData -> cellData.getValue().apptDateProperty());
    	statusCollumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
    	
    	patientAppointmentTable.setItems(appointmentListViewByDate);
		
		}else{
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			 DialogPane dialogPane = alert.getDialogPane();

    	     dialogPane.setStyle("-fx-font-size: 12px;-fx-font-style: italic;");
			alert.setHeaderText(null);
			alert.setContentText("No Appointments for today!");
			
			alert.showAndWait();	
			
			
		}
		
	}

	private ObservableList<PatientAppointment> patientAppointmentMasterData = FXCollections.observableArrayList();
    
    public void viewPatientAppointment(){
    	
    	patientAppointmentMasterData = new PatientAppointmentEntityController().viewById(Global.patient.getId());
    	 
    	dateCollumn.setCellValueFactory(cellData -> cellData.getValue().apptDateProperty());
    	categoryCollumn.setCellValueFactory(cellData -> cellData.getValue().getVisitCatId()!=null?cellData.getValue().getVisitCatId().codeProperty():null);
    	purposeCollumn.setCellValueFactory(cellData -> cellData.getValue().purposeProperty());
    	//protocolCollumn.setCellValueFactory(cellData -> cellData.getValue().apptDateProperty());
    	statusCollumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
    	
    	patientAppointmentTable.setItems(patientAppointmentMasterData);
    	
    }
    
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		if(AppointmentController.patientViewFlag==0){
		viewPatientAppointment();
		}	
		
		AppointmentController.patientViewFlag=0;
	
		cancelButton.setOnAction((event) -> {
			// Cancel centralized Form
			try {
				AppointmentController.patientViewFlag=0;
				new FXFormCommonUtilities().closeForm(cancelButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		selectButton.setOnAction((event) -> {
			
			try {
			
				PatientAppointment patientAppointment = patientAppointmentTable.getSelectionModel().getSelectedItem();
				
				formPath.closeApplicationContext();

				if (patientAppointment != null) {
					   
					if(button!=null?button.getId().equals("changeAppointment"):false){
						
						String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

						PatientAppointmentEditController patientAppointmentEditController=(PatientAppointmentEditController) new FXFormCommonUtilities().displayForm(formName, formTitle);
						patientAppointmentEditController.setPatientAppointmentViewController(this);
						patientAppointmentEditController.setPatientAppointment(patientAppointment);
					}else{
						
						String formName = formPath.context.getMessage("AddVisitType", null, Locale.US);
						String formTitle = formPath.context.getMessage("Title.AddVisitType", null, Locale.US);

						String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
						String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					VisitLogInputController editController = fxmlLoader.getController();
					editController.setPatientAppointmentViewController(this);
					editController.setPatientAppointment(patientAppointment);
					//editController.setPatientAppointmentViewController(this);
					
					stage.show();
					}
				} else {
					System.out.println("%%%%%%%%%%%%%%");
/*
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("");
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();
*/
				new FXFormCommonUtilities().closeForm(selectButton);

				} 

				

				/*String formName = formPath.context.getMessage("EditPatientAppointment", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditPatientAppointment", null, Locale.US);

				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();

				if (patientAppointment != null) {

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					PatientAppointmentEditController editController = fxmlLoader.getController();
					editController.setPatientAppointment(patientAppointment);
					editController.setPatientAppointmentViewController(this);
					
					stage.show();

				} else {

					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();

				new FXFormCommonUtilities().closeForm(selectButton);

				} 
*/			
				}catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
