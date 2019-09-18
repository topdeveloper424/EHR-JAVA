package com.ets.controller.gui.clinicSchedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.entity.clinicSchedule.ClinicScheduleEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.providerSchedule.StaffScheduleEntityController;
import com.ets.controller.gui.complex.ComplexEditController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.Clinic;
import com.ets.model.ClinicSchedule;
import com.ets.model.Complex;
import com.ets.model.Provider;
import com.ets.model.ProviderSchedule;
import com.ets.test.controller.Book;
import com.ets.test.controller.Person;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ClinicScheduleViewController implements Initializable {

	@FXML
    private TableView<ClinicSchedule> clinicScheduleTable;
	
    @FXML
    private TableColumn<ClinicSchedule, String> dayCollumn;

    @FXML
    private TableColumn<ClinicSchedule, String> startTimeCollumn;

    @FXML
    private TableColumn<ClinicSchedule, String> finishTimeCollumn;
        

    @FXML
    private Button changeButton;

    @FXML
    private Button exceptionbutton;

    @FXML
    private RadioButton timeSlotRadioButton1;

    

    @FXML
    private RadioButton timeSlotRadioButton2;

    @FXML
    private RadioButton timeSlotRadioButton3;

    @FXML
    private RadioButton timeSlotRadioButton4;

    @FXML
    private RadioButton timeSlotRadioButton5;

    @FXML
    private Button okButton;
    @FXML
    private ToggleGroup timeSlot;

    @FXML
    private Button cancelButton;
    @FXML
    private RadioButton timeFiveRadio;

    @FXML
    private RadioButton timeTenRadio;

    @FXML
    private RadioButton timeFifteenRadio;

    @FXML
    private RadioButton timeTwentyRadio;

    @FXML
    private RadioButton TimeThirtyRadio;

    
  
	FXMLFormPath formPath = new FXMLFormPath();
	
	 public ObservableList<ClinicSchedule> getDefaultValue(){
		   
		   List list = new ArrayList();
		   
		   list.add(new ClinicSchedule("Sunday"));
		   list.add(new ClinicSchedule("Monday"));
		   list.add(new ClinicSchedule("TuesDay"));
		   list.add(new ClinicSchedule("Wednesday"));
		   list.add(new ClinicSchedule("Thursday"));
		   list.add(new ClinicSchedule("Friday"));
		   list.add(new ClinicSchedule("Saturday"));
		   
		   ObservableList<ClinicSchedule> weekdayData = FXCollections.observableList(list);
		  
		   
		   return weekdayData;
	   }	
	
	/*public void viewClinicSchedule(){
				
		//clinicScheduleTable.setEditable(true);
		 
		dayCollumn.setCellValueFactory(cellData -> cellData.getValue().weekdayProperty());
		
		startTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().openTimeProperty());
		finishTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().closeTimeProperty());
				
		clinicScheduleTable.setItems(new ClinicScheduleEntityController().view());
	}*/
	
	 private ObservableList<ClinicSchedule> data;
		
	public void viewDefaultClinicSchedule(){
		
		data = getDefaultValue();
		
	
		  for(int i=0;i<data.size();i++){
			  
             ClinicSchedule clinicSchedule = new ClinicSchedule();
		     clinicSchedule.setWeekday(data.get(i).getWeekday());
	         clinicSchedule.setClinic(Global.clinic);
	         clinicSchedule.setTimeslotSize("30");
	         new ClinicScheduleEntityController().saveOrUpdate(clinicSchedule);
		  }
		 
		 
		  
		    getClinicSchedileByClinicId(Global.clinic.getId());
		 
		    dayCollumn.setCellValueFactory(cellData -> cellData.getValue().weekdayProperty());
			
			startTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().openTimeProperty());
			finishTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().closeTimeProperty());
							
			clinicScheduleTable.setItems(clinicScheduleData);
		
		
	}
	
	
	
	private ObservableList clinicScheduleData;
	 List<ClinicSchedule>  clinicScheduleDataList;
	public ObservableList<ClinicSchedule> getClinicSchedileByClinicId(Integer cId){
		clinicScheduleDataList = new ClinicScheduleEntityController().viewClinicScheduleByClinicId(cId);
		clinicScheduleData = FXCollections.observableList(clinicScheduleDataList);
		
		return clinicScheduleData;
		
	}
	
	public void viewClinicSchedule(){
	
		
		dayCollumn.setCellValueFactory(cellData -> cellData.getValue().weekdayProperty());
		
		startTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().openTimeProperty());
		finishTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().closeTimeProperty());
						
		clinicScheduleTable.setItems(clinicScheduleData);
		
		
   if(clinicScheduleDataList.get(0).getTimeslotSize() != null){
	
	if(clinicScheduleDataList.get(0).getTimeslotSize().equals("5")){
		
		timeFiveRadio.setSelected(true);
		
	}else if (clinicScheduleDataList.get(0).getTimeslotSize().equals("10")) {
		
		timeTenRadio.setSelected(true);
		
	}else if (clinicScheduleDataList.get(0).getTimeslotSize().equals("15")) {
		
		timeFifteenRadio.setSelected(true);
		
	}else if (clinicScheduleDataList.get(0).getTimeslotSize().equals("20")) {
		
		timeTwentyRadio.setSelected(true);
		
	}else if (clinicScheduleDataList.get(0).getTimeslotSize().equals("30")) {
		
		TimeThirtyRadio.setSelected(true);
		
	}
	
}

		
	}
	
	
	@FXML
	void doubleClick(MouseEvent event) {
		if (event.getClickCount() == 2) {
			try {
				
				ClinicSchedule clinicSchedule = clinicScheduleTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditClinicSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditClinicSchedule", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ClinicScheduleSaveEditController editController = fxmlLoader.getController();
				editController.setClinicSchedule(clinicSchedule);
				editController.setClinicScheduleViewController(this);
				stage.show();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	public List<ClinicSchedule> clinicView(){
		
		
		getClinicSchedileByClinicId(Global.clinic.getId());
		
		
		if(clinicScheduleData.isEmpty()){
			
			viewDefaultClinicSchedule();
			System.out.println("if ___"+clinicScheduleDataList.size());	
		}else{
				
			
			viewClinicSchedule();
			System.out.println("else __"+clinicScheduleDataList.size());	
		}
		
		return clinicScheduleDataList;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		getClinicSchedileByClinicId(Global.clinic.getId());
	
		
		if(clinicScheduleData.isEmpty()){
			
			viewDefaultClinicSchedule();
			
		}else{
				
			
			viewClinicSchedule();
			
		}
		
		exceptionbutton.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("ClinicScheduleExceptionButton", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ClinicScheduleExceptionButton", null, Locale.US);
				
				formPath.closeApplicationContext();
				
				
			    ClinicScheduleSetUpController clinicScheduleSetUpController =  
						(ClinicScheduleSetUpController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			     clinicScheduleSetUpController.setClinicScheduleViewController(this, clinicScheduleDataList);
				
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				
				ClinicSchedule clinicSchedule = clinicScheduleTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditClinicSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditClinicSchedule", null, Locale.US);

				formPath.closeApplicationContext();

				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				ClinicScheduleSaveEditController editController = fxmlLoader.getController();
				editController.setClinicSchedule(clinicSchedule);
				editController.setClinicScheduleViewController(this);
				stage.show();
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		okButton.setOnAction((event) -> {
			System.out.println("Clinic Name is : " +Global.clinic.getName());
			try {
				
				//Clinic clinic = new ClinicEntityController().viewByName(Global.clinic.getName());
				
				
				for (ClinicSchedule item : clinicScheduleTable.getItems()) {
					ClinicSchedule clinicSchedule = new ClinicSchedule();
					
					String weekDay = (String) dayCollumn.getCellObservableValue(item).getValue();
					clinicSchedule.setWeekday(weekDay);
									   
					String openTime = (String) startTimeCollumn.getCellObservableValue(item).getValue();
					clinicSchedule.setOpenTime(openTime);
										
					String closeTime = (String) finishTimeCollumn.getCellObservableValue(item).getValue();
					clinicSchedule.setCloseTime(closeTime);
										
					Integer idCheck = item.getId();
					if(idCheck != 0){
												
						clinicSchedule.setId(idCheck);
						
					}
			
						
						String slotTime = null;
						if(timeFiveRadio.isSelected() == true){
							
							slotTime="5";
							
						}else if (timeTenRadio.isSelected() == true) {
							
							slotTime="10";
							
						}else if (timeFifteenRadio.isSelected() == true) {
							
							slotTime="15";
							
						}else if (timeTwentyRadio.isSelected() == true) {
							
							slotTime="20";
							
						}else if (TimeThirtyRadio.isSelected() == true) {
							
							slotTime="30";
							
						}
						
						clinicSchedule.setTimeslotSize(slotTime);
					
				    clinicSchedule.setClinic(Global.clinic);
				   
					new ClinicScheduleEntityController().saveOrUpdate(clinicSchedule);  
					
				}
				getClinicSchedileByClinicId(Global.clinic.getId());
			    Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText(" Calender Time Slot is Changed !");

				alert.showAndWait();
							
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		cancelButton.setOnAction((event) -> {
			try {
				// cancel centralized form
				new FXFormCommonUtilities().closeForm(cancelButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}
		
	
}
