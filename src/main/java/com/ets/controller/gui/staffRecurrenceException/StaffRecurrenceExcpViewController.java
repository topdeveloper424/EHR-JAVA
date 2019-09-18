package com.ets.controller.gui.staffRecurrenceException;

import java.net.URL;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import org.fxmisc.easybind.EasyBind;

import com.ets.controller.entity.providerSchRecurException.StaffSchRecurExceptionEntityController;
import com.ets.controller.gui.clinicianSchedule.ClinicianScheduleViewController;
import com.ets.controller.gui.clinicianSchedule.ClinicianSelectController;
import com.ets.controller.gui.staffSchedule.SchedulingViewController;
import com.ets.model.Clinician;
import com.ets.model.CptCode4Hcpcs;
import com.ets.model.OccurRange;
import com.ets.model.ProviderSchRecurException;
import com.ets.model.RecurPattern;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class StaffRecurrenceExcpViewController implements Initializable{
	  @FXML
	    private Button addBtn;

	    @FXML
	    private Button cancelButton;

	    @FXML
	    private ComboBox<String> recurrenceScheduleDropDown;
	    @FXML
	    private TableView<ProviderSchRecurException> staffRecurTable;
	    @FXML
	    private TableColumn<ProviderSchRecurException, String> descriptionColumn;

	    @FXML
	    private TableColumn<ProviderSchRecurException, Date> DateRangeStartColumn;

	    @FXML
	    private TableColumn<ProviderSchRecurException, Date> DateRangeEndCol;

	    @FXML
	    private TableColumn<ProviderSchRecurException, String> timeSlotStartCol;

	    @FXML
	    private TableColumn<ProviderSchRecurException, String> timeSlotEndCol;

	    @FXML
	    private TableColumn<ProviderSchRecurException, String> hashCol;

	    @FXML
	    private TableColumn<ProviderSchRecurException, Integer> RecurrenceSeriesCol;

	    @FXML
	    private Button changeBtn;

	    @FXML
	    private Button deleteBtn;

	    @FXML
	    void clickOkButton(ActionEvent event) {

	    }
    public ClinicianScheduleViewController clinicianScheduleViewController;
    
	public ClinicianScheduleViewController getClinicianScheduleViewController() {
		return clinicianScheduleViewController;
	}
	public void setClinicianScheduleViewController(ClinicianScheduleViewController clinicianScheduleViewController) {
		this.clinicianScheduleViewController = clinicianScheduleViewController;
		
		view();
		
	}
	public SchedulingViewController schedulingViewController;

	public void setSchedulingViewController(SchedulingViewController schedulingViewController) {
		this.schedulingViewController = schedulingViewController;
		 view();
	}
	FXMLFormPath formPath = new FXMLFormPath();
	 private ObservableList<ProviderSchRecurException> providerSchRecurExcpList = FXCollections.observableArrayList();
	
	 public void view(){
	 
		 if(clinicianScheduleViewController!=null){
			 providerSchRecurExcpList=new StaffSchRecurExceptionEntityController().viewStaffSchRecurExcByClinicianId(ClinicianSelectController.clinician.getId());
			  
		 }
		 if(schedulingViewController!=null){
			 providerSchRecurExcpList = new StaffSchRecurExceptionEntityController().viewStaffSchRecurExcByProviderId(SchedulingViewController.provider.getId());	
					 
			 
		 }
		 
		 
		 
	    descriptionColumn.setCellValueFactory(cellValue -> cellValue.getValue().getOccurRange().descrpProperty());
		DateRangeStartColumn.setCellValueFactory(cellValue -> cellValue.getValue().getOccurRange().startDateProperty());
		DateRangeEndCol.setCellValueFactory(cellValue->cellValue.getValue().getOccurRange().endByDateProperty());
		timeSlotStartCol.setCellValueFactory(cellValue->cellValue.getValue().getOccurRange().blockedStartTimeProperty());
		timeSlotEndCol.setCellValueFactory(cellValue->cellValue.getValue().getOccurRange().blockedEndTimeProperty());
		hashCol.setCellValueFactory(cellData-> cellData.getValue().getOccurRange().endAfterProperty());
		
		//RecurrenceSeriesCol.setCellValueFactory(cellValue->cellValue.getValue().getOccurRange().re);
		staffRecurTable.setItems(providerSchRecurExcpList);
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		changeBtn.setOnAction((event) -> {
		try{
			ProviderSchRecurException providerSchRecurException = staffRecurTable.getSelectionModel().getSelectedItem();
			String formName = formPath.context.getMessage("AddProviderRecurrence", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddProviderRecurrence", null, Locale.US);
			formPath.closeApplicationContext();
			StaffRecurrenceExcpController staffRecurrenceExcpController = 
			
		    (StaffRecurrenceExcpController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			staffRecurrenceExcpController.setStaffRecurrenceExcpViewController(this,providerSchRecurException);
			
		    }catch(Exception e){
			 e.printStackTrace();
		}
		
		});
		
		addBtn.setOnAction((event) -> {
		try{
			String formName = formPath.context.getMessage("AddProviderRecurrence", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddProviderRecurrence", null, Locale.US);
			formPath.closeApplicationContext();
			StaffRecurrenceExcpController staffRecurrenceExcpController = 
			
		    (StaffRecurrenceExcpController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			staffRecurrenceExcpController.setStaffRecurrenceExcpViewController(this);
			
		    }catch(Exception e){
			 e.printStackTrace();
		}
		
	});
		deleteBtn.setOnAction((event) -> {
			try{
				ProviderSchRecurException providerSchRecurException = staffRecurTable.getSelectionModel().getSelectedItem();
				new StaffSchRecurExceptionEntityController().delete(providerSchRecurException.getId());
				view();
		    }catch(Exception e){
			 e.printStackTrace();
		}
		
	});
		cancelButton.setOnAction((event) -> {
			new FXFormCommonUtilities().closeForm(cancelButton);
		
	});
}
}
