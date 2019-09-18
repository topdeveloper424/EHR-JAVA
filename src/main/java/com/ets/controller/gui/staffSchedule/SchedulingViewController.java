package com.ets.controller.gui.staffSchedule;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.clinicSchedule.ClinicScheduleEntityController;
import com.ets.controller.entity.provider.ProviderEntityController;
import com.ets.controller.entity.providerSchedule.StaffScheduleEntityController;
import com.ets.controller.gui.clinicSchedule.ClinicScheduleSaveEditController;
import com.ets.model.BillingServiceType;
import com.ets.model.ClinicSchedule;
import com.ets.model.Provider;
import com.ets.model.ProviderSchedule;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.controller.gui.staffBlockSchedule.StaffBlockSchedule;
import com.ets.controller.gui.staffRecurrenceException.StaffRecurrenceExcpViewController;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class SchedulingViewController implements Initializable {
	
	@FXML
    private TableView<ProviderSchedule> providerSchedulingTable;

    @FXML
    private TableColumn<ProviderSchedule, String> weekDayCollumn;

    @FXML
    private TableColumn<ProviderSchedule, String> startTimeCollumn;

	@FXML
	private TableColumn<ProviderSchedule, String> finishTimeCollumn;
	
   
	@FXML
	private Button StaffSchedulingExceptionButton;

	@FXML
	private Button changeButton;

	@FXML
	private Button saveButton;

	@FXML
	private Button closeButton;
	
	@FXML
	private Button blockTimesButton;
	@FXML
	private Button recurrenceBtn;
	   
	  @FXML
	    void doubleClick(MouseEvent event) {
		   
		   if (event.getClickCount() == 2) {
				try {
					
					ProviderSchedule providerSchedule = providerSchedulingTable.getSelectionModel().getSelectedItem();

					String formName = formPath.context.getMessage("EnterScheduling", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EnterScheduling", null, Locale.US);

					formPath.closeApplicationContext();

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					SchedulingEnterController editController = fxmlLoader.getController();
					editController.setProviderSchedule(providerSchedule);
					editController.setSchedulingViewController(this);
					stage.show();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}

	    }
	   	  
	   
	   public ObservableList<ProviderSchedule> getDefaultValue(){
		   
		   List list = new ArrayList();
		   
		   list.add(new ProviderSchedule("Sunday"));
		   list.add(new ProviderSchedule("Monday"));
		   list.add(new ProviderSchedule("TuesDay"));
		   list.add(new ProviderSchedule("Wednesday"));
		   list.add(new ProviderSchedule("Thursday"));
		   list.add(new ProviderSchedule("Friday"));
		   list.add(new ProviderSchedule("Saturday"));
		   
		   ObservableList<ProviderSchedule> weekdayData = FXCollections.observableList(list);
		  		   
		   return weekdayData;
	   }
	   
	   public static Provider provider = null;
	   
	
	   
	   public  void setProvider(Provider provider){
		  this.provider=provider;  
			
		  			   
	   }
	   	   
	   private ObservableList<ProviderSchedule> providerScheduleData;
	    List<ProviderSchedule> providerSchData;
	   
	   public ObservableList<ProviderSchedule> getProviderSchedule(Integer providerId){
		   providerSchData = new StaffScheduleEntityController().viewProviderScheduleById(providerId);
		   providerScheduleData = FXCollections.observableList(providerSchData);
		   
		   return providerScheduleData;
	   }
	   
	   public void viewProviderSchedule(){
		  
		   weekDayCollumn.setCellValueFactory(cellData -> cellData.getValue().weekdayProperty());
			
		   startTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().openTimeProperty());
		   finishTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().closeTimeProperty());
			
		 			
			providerSchedulingTable.setItems(providerScheduleData);
			//providerSchedulingTable.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> showPersonDetails(newValue));
		   
	   }
	  	   
	   
	   private ObservableList<ProviderSchedule> data;
	   
	   
  
	   
	   public void viewDefaultProviderSchedule(){
		   
			data = getDefaultValue();
			
			for(int i=0;i<data.size();i++){
				ProviderSchedule providerSchedule = new ProviderSchedule();
				providerSchedule.setWeekday(data.get(i).getWeekday());
				providerSchedule.setProvider(StaffScheduleViewController.provider);
				new StaffScheduleEntityController().saveOrUpdate(providerSchedule);
			}
			getProviderSchedule(StaffScheduleViewController.provider.getId());

			weekDayCollumn.setCellValueFactory(cellData -> cellData.getValue().weekdayProperty());
				
			startTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().openTimeProperty());
			finishTimeCollumn.setCellValueFactory(cellData -> cellData.getValue().closeTimeProperty());
							
			providerSchedulingTable.setItems(providerScheduleData);
		   
		}
	   	  
	  
	  	
	FXMLFormPath formPath = new FXMLFormPath();  

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		getProviderSchedule(StaffScheduleViewController.provider.getId());
		blockTimesButton.setDisable(true);
		
		providerSchedulingTable.setOnMouseClicked(new EventHandler<MouseEvent>() {
		    public void handle(MouseEvent me) {
		    	if (me.getClickCount() == 1) {
		    		ProviderSchedule providerSchedule = providerSchedulingTable.getSelectionModel().getSelectedItem();
		    		if((providerSchedule.getOpenTime()!="" && providerSchedule.getOpenTime()!="")||(providerSchedule.getOpenTime()!=null && providerSchedule.getOpenTime()!=null))
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
		
		if(providerScheduleData.isEmpty()){
				
				viewDefaultProviderSchedule();
				
			}else{
								
				viewProviderSchedule();
				
			}		
							
		
			
		StaffSchedulingExceptionButton.setOnAction((event) -> {
			try {
				String formName = formPath.context.getMessage("StaffScheduleSetUp", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.StaffScheduleSetUp", null, Locale.US);
				formPath.closeApplicationContext();
				StaffScheduleSetUpController staffScheduleSetUpController = 
				(StaffScheduleSetUpController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				staffScheduleSetUpController.setSchedulingViewController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		changeButton.setOnAction((event) -> {
			try {
				
				ProviderSchedule providerSchedule = providerSchedulingTable.getSelectionModel().getSelectedItem();
								
				String formName = formPath.context.getMessage("EnterScheduling", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterScheduling", null, Locale.US);
				formPath.closeApplicationContext();
				
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.initModality(Modality.APPLICATION_MODAL);
				stage.setTitle(formTitle);
				stage.setScene(new Scene(root1));
				SchedulingEnterController editController = fxmlLoader.getController();
				editController.setProviderSchedule(providerSchedule);
				editController.setSchedulingViewController(this);
				stage.show();
								
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		blockTimesButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ProviderBlockSchedule", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ProviderBlockSchedule", null, Locale.US);
				formPath.closeApplicationContext();
				ProviderSchedule providerSchedule = providerSchedulingTable.getSelectionModel().getSelectedItem();
				StaffBlockSchedule staffBlockSchedule = 
				(StaffBlockSchedule) new FXFormCommonUtilities().displayForm(formName, formTitle);
				staffBlockSchedule.setSchedulingViewController(this,providerSchedule);	
				
				
			}catch(Exception e){
				
			}
		});
			
		 
		saveButton.setOnAction((event) -> {
			try {
								
				provider = new ProviderEntityController().viewById(provider.getId());
								
				for (ProviderSchedule item : providerSchedulingTable.getItems()) {
					ProviderSchedule providerSchedule = new ProviderSchedule();
					
					String weekDay = (String) weekDayCollumn.getCellObservableValue(item).getValue();
					providerSchedule.setWeekday(weekDay);
									   
					String openTime = (String) startTimeCollumn.getCellObservableValue(item).getValue();
					providerSchedule.setOpenTime(openTime);
										
					String closeTime = (String) finishTimeCollumn.getCellObservableValue(item).getValue();
					providerSchedule.setCloseTime(closeTime);
										
					Integer idCheck = item.getId();
					if(idCheck != 0){
												
						providerSchedule.setId(idCheck);
						
					}
										
					providerSchedule.setProvider(provider);
					
					new StaffScheduleEntityController().saveOrUpdate(providerSchedule);  
				}
							
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
				staffRecurrenceExcpViewController.setSchedulingViewController(this);	
				
				
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
