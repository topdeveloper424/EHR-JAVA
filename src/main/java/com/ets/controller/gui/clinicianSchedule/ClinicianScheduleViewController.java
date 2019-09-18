package com.ets.controller.gui.clinicianSchedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinician.ClinicianEntityController;
import com.ets.controller.entity.clinicianSchedule.ClinicianScheduleEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.providerSchedule.StaffScheduleEntityController;
import com.ets.controller.gui.clinicianBlockSchedule.ClinicianBlockSchedule;
import com.ets.controller.gui.staffBlockSchedule.StaffBlockSchedule;
import com.ets.controller.gui.staffRecurrenceException.StaffRecurrenceExcpViewController;
import com.ets.controller.gui.staffSchedule.SchedulingEnterController;
import com.ets.controller.gui.staffSchedule.StaffScheduleSetUpController;
import com.ets.controller.gui.staffSchedule.StaffScheduleViewController;
import com.ets.model.Clinician;
import com.ets.model.ClinicianSchedule;
import com.ets.model.Provider;
import com.ets.model.ProviderSchedule;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClinicianScheduleViewController implements Initializable{
	
	@FXML
	private TableView<ClinicianSchedule> clinicianSchedulingTable;

	@FXML
	private TableColumn<ClinicianSchedule, String> weekDayCollumn;

	@FXML
	private TableColumn<ClinicianSchedule, String> startTimeCollumn;

	@FXML
	private TableColumn<ClinicianSchedule, String> finishTimeCollumn;
    @FXML
	private Button blockTimesButton;
	@FXML
	private Button changeButton;

    @FXML
    private Button recurrenceBtn;
	@FXML
	private Button clinicianSchedulingExceptionButton;

	@FXML
	private Button closeButton;

	@FXML
	private Button saveButton;

	@FXML
    void doubleClick(MouseEvent event) {
	   
	   if (event.getClickCount() == 2) {
			try {
				
				ClinicianSchedule clinicianSchedule = clinicianSchedulingTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EnterClinicianScheduling", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterClinicianScheduling", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ClinicianScheduleEnterController editController = fxmlLoader.getController();
				editController.setClinicianSchedule(clinicianSchedule);
				editController.setClinicianScheduleViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}

    }
   	  
   
   public ObservableList<ClinicianSchedule> getDefaultValue(){
	   
	   List list = new ArrayList();
	   
	   list.add(new ClinicianSchedule("Sunday"));
	   list.add(new ClinicianSchedule("Monday"));
	   list.add(new ClinicianSchedule("TuesDay"));
	   list.add(new ClinicianSchedule("Wednesday"));
	   list.add(new ClinicianSchedule("Thursday"));
	   list.add(new ClinicianSchedule("Friday"));
	   list.add(new ClinicianSchedule("Saturday"));
	   
	   ObservableList<ClinicianSchedule> weekdayData = FXCollections.observableList(list);
	  
	   
	   return weekdayData;
   }
   
  
   
   public static void setClinicianId(Clinician clinician){
	   
	   //idField = clinician.getId();
	   clinician  = clinician;
	  				   
   }
   public static Clinician clinician = null;
   private ObservableList<ClinicianSchedule> clinicianScheduleData;
   List<ClinicianSchedule> clinicianSchData;
   public ObservableList getClinicianSchedule(Integer clinicianId){
	   clinicianSchData = new ClinicianScheduleEntityController().viewClinicianScheduleById(ClinicianSelectController.clinician.getId());
	   clinicianScheduleData = FXCollections.observableList(clinicianSchData);
	  
	 // clinicianScheduleData = FXCollections.observableList(new ClinicianScheduleEntityController().viewClinicianScheduleByClinicianId(clinicianId));
	   
	   return clinicianScheduleData;
   }
   
   public void viewClinicianSchedule(){
	   
	   weekDayCollumn.setCellValueFactory(cellData -> cellData.getValue().weekdayProperty());
		
		startTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().openTimeProperty());
		finishTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().closeTimeProperty());
					
		clinicianSchedulingTable.setItems(clinicianScheduleData);
		//providerSchedulingTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
	   
   }
  	   
   
   private ObservableList<ClinicianSchedule> data;
   
   public void viewDefaultClinicianSchedule(){
	   
		data = getDefaultValue();
		
		for(int i=0;i<data.size();i++){
			ClinicianSchedule clinicianSchedule = new ClinicianSchedule();
			clinicianSchedule.setWeekday(data.get(i).getWeekday());
			clinicianSchedule.setClinician(ClinicianSelectController.clinician);
			new ClinicianScheduleEntityController().saveOrUpdate(clinicianSchedule);
		}
		getClinicianSchedule(ClinicianSelectController.clinician.getId());

		weekDayCollumn.setCellValueFactory(cellData -> cellData.getValue().weekdayProperty());
			
		startTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().openTimeProperty());
		finishTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().closeTimeProperty());
						
		clinicianSchedulingTable.setItems(clinicianScheduleData);
	 
		
	}
	    
	    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		getClinicianSchedule(ClinicianSelectController.clinician.getId());
		
		 blockTimesButton.setDisable(true);;
		
		

		clinicianSchedulingTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 1) {
		    		ClinicianSchedule clinicianSchedule = clinicianSchedulingTable.getSelectionModel().getSelectedItem();
		    		if((clinicianSchedule.getOpenTime()!="" && clinicianSchedule.getOpenTime()!="")||(clinicianSchedule.getOpenTime()!=null && clinicianSchedule.getOpenTime()!=null))
		    		{
		    		blockTimesButton.setDisable(false);
		    		}else{
		    			
		    			Alert alert = new Alert(AlertType.INFORMATION);
		    			alert.setTitle("Information Dialog");
		    			alert.setHeaderText(null);
		    			alert.setContentText("Start/End time required!");
		    			alert.showAndWait();
		    		}
		    		}}});
		
		if(clinicianScheduleData.isEmpty()){
				
			viewDefaultClinicianSchedule();
				
			}else{
								
				viewClinicianSchedule();
				
			}		
							
		
		
		/*if(clinicianScheduleData.isEmpty()){
			
			viewDefaultClinicianSchedule();
			
		}else{
							
			viewClinicianSchedule();
			
		}*/
		
		clinicianSchedulingExceptionButton.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("ClinicianSchedulingSetUp", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClinicianSchedulingSetUp", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicianScheduleSetUpController clinicianScheduleSetUpController = 
						(ClinicianScheduleSetUpController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				clinicianScheduleSetUpController.setClinicianScheduleViewController(this);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		saveButton.setOnAction((event) -> {
			try {
				clinician = new ClinicianEntityController().viewById(clinician.getId());
				
				
				for (ClinicianSchedule item : clinicianSchedulingTable.getItems()) {
					ClinicianSchedule clinicianSchedule = new ClinicianSchedule();
					
					String weekDay = (String) weekDayCollumn.getCellObservableValue(item).getValue();
					clinicianSchedule.setWeekday(weekDay);
									   
					String openTime = (String) startTimeCollumn.getCellObservableValue(item).getValue();
					clinicianSchedule.setOpenTime(openTime);
										
					String closeTime = (String) finishTimeCollumn.getCellObservableValue(item).getValue();
					clinicianSchedule.setCloseTime(closeTime);
										
					Integer idCheck = item.getId();
					if(idCheck != 0){
												
						clinicianSchedule.setId(idCheck);
						
					}
										
					clinicianSchedule.setClinician(clinician);
					
					new ClinicianScheduleEntityController().saveOrUpdate(clinicianSchedule);  
				}
				
				
				
				
			
							
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		blockTimesButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ClinicianBlockSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClinicianBlockSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				ClinicianSchedule clinicianSchedule = clinicianSchedulingTable.getSelectionModel().getSelectedItem();
		        ClinicianBlockSchedule clinicianBlockSchedule = 
				(ClinicianBlockSchedule) new FXFormCommonUtilities().displayForm(formName, formTitle);
		        clinicianBlockSchedule.setClinicianScheduleViewController(this,clinicianSchedule);	
				
				
			}catch(Exception e){
				
			}
		});
			
		changeButton.setOnAction((event) -> {
			try {
				
				ClinicianSchedule clinicianSchedule = clinicianSchedulingTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EnterClinicianScheduling", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterClinicianScheduling", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ClinicianScheduleEnterController editController = fxmlLoader.getController();
				editController.setClinicianSchedule(clinicianSchedule);
				editController.setClinicianScheduleViewController(this);
				stage.show();
								
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		recurrenceBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ViewProviderRecurrence", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProviderRecurrence", null, Locale.US);
				formPath.closeApplicationContext();
				StaffRecurrenceExcpViewController staffRecurrenceExcpViewController = 
				
			    (StaffRecurrenceExcpViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				staffRecurrenceExcpViewController.setClinicianScheduleViewController(this);	
				
				
			}catch(Exception e){
				
			}
		});
		closeButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
