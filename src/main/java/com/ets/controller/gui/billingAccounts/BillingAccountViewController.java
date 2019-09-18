package com.ets.controller.gui.billingAccounts;
import java.net.URL;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import com.ets.controller.entity.billingAccount.BillingAccountEntityController;
import com.ets.controller.entity.clinic.ClinicEntityController;
import com.ets.controller.gui.Laboratories.LaboratoryEditController;
import com.ets.controller.gui.Laboratories.LaboratoryInputController;
import com.ets.controller.gui.carriers.CarrierEditController;
import com.ets.controller.gui.carriers.CarrierInputController;
import com.ets.controller.gui.clinic.ClinicEditController;
import com.ets.controller.gui.company.CompanyEditController;
import com.ets.controller.gui.company.CompanyInputController;
import com.ets.controller.gui.mcoTpaBillPreview.McoTpaBillEditController;
import com.ets.controller.gui.mcoTpaBillPreview.McoTpaBillInputController;
import com.ets.controller.gui.visitLog.VisitLogInputController;
import com.ets.model.BillingAccount;
import com.ets.model.Clinic;
import com.ets.model.Contact;
import com.ets.model.DepartmentUnit;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class BillingAccountViewController implements Initializable{

	@FXML
    private TextField searchTextField;

    @FXML
    private CheckBox includeInactiveCheckBox;

    @FXML
    private Button addButton;

    @FXML
    private Button changeButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button closeButton;
    
    @FXML
    private Button selectButton;

    @FXML
    private Button topButton;

    @FXML
    private Button upButton;

    @FXML
    private Button downButton;

    @FXML
    private Button bottomButton;

    @FXML
    private TableView<BillingAccount> billingAccountTable;

    @FXML
    private TableColumn<BillingAccount, String> accountNameCol;

    @FXML
    private TableColumn<BillingAccount, String> codeCol;

    @FXML
    private TableColumn<BillingAccount, String> phoneCol;

    @FXML
    private Button printButton;
    
    
    private VisitLogInputController visitLogInputController;
    
    
    public void setVisitLogInputController(VisitLogInputController visitLogInputController) {
		this.visitLogInputController = visitLogInputController;
		addButton.setVisible(false);
		changeButton.setVisible(false);
		deleteButton.setVisible(false);
		printButton.setVisible(false);
    
    
    
    }

	@FXML
    void doubleClick(MouseEvent event) {
    	
    	if(event.getClickCount() == 2){
			 
			 try {

					BillingAccount  billingAccount = billingAccountTable.getSelectionModel().getSelectedItem();

					String formName = formPath.context.getMessage("EditBillingAccounts", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EditBillingAccounts", null, Locale.US);

					formPath.closeApplicationContext();

					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					BillingAccountEditController editController = fxmlLoader.getController();
					editController.setBillingAccountViewController(this);
					editController.setBillingAccount(billingAccount);

					stage.show();

				} catch (Exception ex) {
					ex.printStackTrace();
				}
			 
		 }


    }
	
	private CompanyInputController companyInputController;
	
	
	public void setCompanyInputController(CompanyInputController companyInputController) {
		this.companyInputController = companyInputController;
	}
	
	private CompanyEditController companyEditController;
		
	public void setCompanyEditController(CompanyEditController companyEditController) {
		this.companyEditController = companyEditController;
	}

	private CarrierInputController carrierInputController;
	

	public void setCarrierInputController(CarrierInputController carrierInputController) {
		this.carrierInputController = carrierInputController;
	}
	
	private CarrierEditController carrierEditController;
	
	public void setCarrierEditController(CarrierEditController carrierEditController) {
		this.carrierEditController = carrierEditController;
	}
	
	private McoTpaBillInputController mcoTpaBillInputController;
	
	public void setMcoTpaBillInputController(McoTpaBillInputController mcoTpaBillInputController) {
		this.mcoTpaBillInputController = mcoTpaBillInputController;
	}
	
	private McoTpaBillEditController mcoTpaBillEditController;
	
	public void setMcoTpaBillEditController(McoTpaBillEditController mcoTpaBillEditController) {
		this.mcoTpaBillEditController = mcoTpaBillEditController;
	}
	
	private LaboratoryInputController laboratoryInputController;
	
	public void setLaboratoryInputController(LaboratoryInputController laboratoryInputController) {
		this.laboratoryInputController = laboratoryInputController;
	}
	
	private LaboratoryEditController laboratoryEditController;
	
	public void setLaboratoryEditController(LaboratoryEditController laboratoryEditController) {
		this.laboratoryEditController = laboratoryEditController;
	}
	
	public BillingAccountInputController billingAccountInputController;

	public void setBillingAccountInputController(BillingAccountInputController billingAccountInputController) {
		this.billingAccountInputController = billingAccountInputController;
	}

	private ObservableList<BillingAccount> billingAccountUnitMasterData = FXCollections.observableArrayList();
	
	public void viewBillingAccount(){
		
		billingAccountUnitMasterData = new BillingAccountEntityController().view();
		
		accountNameCol.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
		codeCol.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
		//phoneCol.setCellValueFactory(cellData -> cellData.getValue().getAddress().phoneProperty());
		//billingAccountTable.setItems(new BillingAccountEntityController().view());
		
FilteredList<BillingAccount> filteredData = new FilteredList<BillingAccount>(billingAccountUnitMasterData, p -> true);
		
		searchTextField.textProperty().addListener((observable, oldValue, newValue) -> {
			
			filteredData.setPredicate(billingAccount -> {
				
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (billingAccount.getName().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches first name.
				} 
				return false; // Does not match.
			});
		});
			
	
		SortedList<BillingAccount> sortedData = new SortedList<>(filteredData);
		
		sortedData.comparatorProperty().bind(billingAccountTable.comparatorProperty());
				
		billingAccountTable.setItems(sortedData);
		
		
	}

	FXMLFormPath formPath = new FXMLFormPath();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		addButton.setVisible(true);
		changeButton.setVisible(true);
		deleteButton.setVisible(true);
		printButton.setVisible(true);
     
		viewBillingAccount();

		closeButton.setOnAction((event) -> {
			try {
				
				new FXFormCommonUtilities().closeForm( closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
			
		addButton.setOnAction((event) -> {
		try {
			
			String formName = formPath.context.getMessage("AddBillingAccounts", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.AddBillingAccounts", null, Locale.US);
			formPath.closeApplicationContext();
			
			BillingAccountInputController billingAccountInputController=
			(BillingAccountInputController) new FXFormCommonUtilities().displayForm( formName , formTitle);
			billingAccountInputController.setBillingAccountViewController(this);
			
		} 						
		 catch (Exception ex) {
					ex.printStackTrace();
				}
		});
		
		
		changeButton.setOnAction((event) -> {
			try {

				BillingAccount  billingAccount = billingAccountTable.getSelectionModel().getSelectedItem();

				String formName = formPath.context.getMessage("EditBillingAccounts", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EditBillingAccounts", null, Locale.US);
				
				String editInfo = formPath.context.getMessage("EditInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				
				if(billingAccount != null){
					
					FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
					Parent root1 = (Parent) fxmlLoader.load();
					Stage stage = new Stage();
					stage.initModality(Modality.APPLICATION_MODAL);
					stage.setTitle(formTitle);
					stage.setScene(new Scene(root1));
					BillingAccountEditController editController = fxmlLoader.getController();
					editController.setBillingAccountViewController(this);
					editController.setBillingAccount(billingAccount);

					stage.show();
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(editInfo);
					alert.showAndWait();
					
				}
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		
		
	
		
		
		deleteButton.setOnAction((event) -> {
			
			
			try {
				
				String deleteInfo = formPath.context.getMessage("DeleteInfo", null, Locale.US);
				String conformDelete = formPath.context.getMessage("ConformDeleteInfo", null, Locale.US);
				String infoDialogBoxTitle = formPath.context.getMessage("Title.InfoDialogBox", null, Locale.US);
				String conformDialogBoxTitle = formPath.context.getMessage("Title.ConformDialogBox", null, Locale.US);

				formPath.closeApplicationContext();
				
				Integer billingAccountIndex = billingAccountTable.getSelectionModel().getSelectedIndex();
				if(billingAccountIndex > -1){
					Alert alert = new Alert(AlertType.CONFIRMATION);
					alert.setTitle(conformDialogBoxTitle);
					alert.setHeaderText(conformDelete);
					alert.setContentText(null);

					Optional<ButtonType> result = alert.showAndWait();
					if(result.get() == ButtonType.OK){
						
						BillingAccount billingAccount = new BillingAccountEntityController().view().get(billingAccountIndex);
						new BillingAccountEntityController().delete(billingAccount.getId());
						
						viewBillingAccount();
						
					}else{
						
					}
					
				}else{
					
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle(infoDialogBoxTitle);
					alert.setHeaderText(null);
					alert.setContentText(deleteInfo);

					alert.showAndWait();
					
				}
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		closeButton.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(closeButton);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		selectButton.setOnAction((event) -> {
			   
			BillingAccount billingAccount = this.billingAccountTable.getSelectionModel().getSelectedItem();

			if (billingAccountInputController.companyInputController != null) {
				
				billingAccountInputController.companyInputController.setbillingAccount(billingAccount.getCode());
				billingAccountInputController.billingAccount2 = billingAccount;
				System.out.println("Code is : ----" +billingAccountInputController.billingAccount2.getCode());
				
			}else if (companyEditController != null) {
				
				companyEditController.setbillingAccount(billingAccount.getCode());
				
			}else if (carrierInputController != null) {
				
				carrierInputController.setCarrierBillingAccount(billingAccount.getCode());
				
			}else if (carrierEditController != null) {
				
				carrierEditController.setCarrierBillingAccount(billingAccount.getCode());
				
			}else if (mcoTpaBillInputController != null) {
				
				mcoTpaBillInputController.setCarrierBillingAccount(billingAccount.getCode());
				
			}else if (mcoTpaBillEditController != null) {
				
				mcoTpaBillEditController.setCarrierBillingAccount(billingAccount.getCode());
				
			}else if (laboratoryInputController != null) {
				
				laboratoryInputController.setCarrierBillingAccount(billingAccount.getCode());
				
			}else if (laboratoryEditController != null) {
				
				laboratoryEditController.setCarrierBillingAccount(billingAccount.getCode());
				
			}else if(visitLogInputController!=null){
			this.visitLogInputController.setBillingAccount(billingAccount.getCode());
			}

				new FXFormCommonUtilities().closeForm(selectButton);
			

		});
	}
}