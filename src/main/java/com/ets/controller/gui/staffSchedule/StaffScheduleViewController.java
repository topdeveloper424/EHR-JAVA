package com.ets.controller.gui.staffSchedule;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.providerSchedule.StaffScheduleEntityController;
import com.ets.controller.gui.provider.ProviderViewController;
import com.ets.model.DepartmentUnit;
import com.ets.model.Provider;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class StaffScheduleViewController implements Initializable {

	 @FXML
	    private Button scheduleButton;

	    @FXML
	    private Button closeButton;

	    @FXML
	    private Button providerButton;

	    @FXML
	    private TextField nameTextField;

	    @FXML
	    private TextField typeTextield;
	    
	    @FXML
	    private TextField idTextField;
	
	private ProviderViewController providerViewController;
	
	public void setProviderViewController(ProviderViewController providerViewController) {
		this.providerViewController = providerViewController;
	}
	public static Provider provider;
	 private ObservableList<Provider> providerMasterData = FXCollections.observableArrayList();

	public void setProviderName(String name){
		
		nameTextField.setText(name);
	}
	
	public void setType(String type){
		
		typeTextield.setText(type);
	}
	
	public void setProvider(Provider provider){
		
	  this.provider = provider;	
		
		
	}

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		providerButton.setOnAction((event) -> {
			try {
				// Load Provider Details Entry form .

				String formName = formPath.context.getMessage("ViewProvider", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ViewProvider", null, Locale.US);
				formPath.closeApplicationContext();
				ProviderViewController providerViewController =
				(ProviderViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				providerViewController.setStaffScheduleViewController(this);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*clinicianButton.setOnAction((event) -> {
			try {
				// Load Clinician Details Entry form .

				String formName = formPath.context.getMessage("Clinician", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinician", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		
		scheduleButton.setOnAction((event) -> {
			try {
				
				if(nameTextField.getText().equals("")){
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText("Please select provider!");

					alert.showAndWait();
					
				}else{
				
				String formName = formPath.context.getMessage("Scheduling", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Scheduling", null, Locale.US);
				formPath.closeApplicationContext();
				
				//new SchedulingViewController().getProviderSchedule(Integer.parseInt(idTextField.getText()));
				SchedulingViewController schedulingViewController = new SchedulingViewController();
				schedulingViewController.setProvider(provider);
				schedulingViewController = (SchedulingViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				}
			} catch (Exception ex) {
				ex.printStackTrace();
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
