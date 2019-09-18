package com.ets.controller.navpanel;



import java.net.URL;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;








import com.ets.controller.entity.company.CompanyEntityController;
import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.company.CompanyViewController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.controller.gui.userLogin.UserLoginGUIController;
import com.ets.model.Company;
import com.ets.model.Complex;
import com.ets.model.Pharmacy;
import com.ets.model.UserAccount;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;








import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 02-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SetupAdminController Class
 *Description: SetupAdmin.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

public class SetupAdminController implements Initializable {

	@FXML
	private AnchorPane setupAdminNavPanel;
	
    @FXML
    private Button clinicButton;

    @FXML
    private Button companyButton;

    @FXML
    private Button medicalCodesButton;

    @FXML
    private Button incidentCodesButton;

    /*@FXML
    private Button protocolOrProfileButton;*/

    @FXML
    private Button organizationButton;

    @FXML
    private Button thirdPartyPlayerButton;

    @FXML
    private Button providerButton;

    @FXML
    private Button pharmacyButton;

    @FXML
    private Button clinicalSetupButton;

    /*@FXML
    private Button emrSetupButton;

    @FXML
    private Button billingSetupButton;*/

    @FXML
    private Button adminSecurityButton;

    @FXML
    private Button homeButton;
    /*@FXML
    private Button billingPannel;*/
    
    @FXML
    void enterKeyPressedForAdminSecurityButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName = formPath.context.getMessage("ViewUserDetail", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.ViewUserDetail", null, Locale.US);
			formPath.closeApplicationContext();

			new FXFormCommonUtilities().displayForm(formName, formTitle);


    	}

    }

    @FXML
    void enterKeyPressedForBillingSetUpButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
		
				String formName = formPath.context.getMessage("BillingSetup", null, Locale.US);
				formPath.closeApplicationContext();
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForClinicButton(KeyEvent event) {
    	
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName = formPath.context.getMessage("Clinic", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
			formPath.closeApplicationContext();
			
			new FXFormCommonUtilities().displayForm( formName , formTitle);


    	}

    }

    @FXML
    void enterKeyPressedForClinicalSetUpButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){

    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("ClinicalSetup", null, Locale.US);
				formPath.closeApplicationContext();
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}

    	}

    }

    @FXML
    void enterKeyPressedForCompanyButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load Progress Bar
			
    					String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
    					
    					String formTitle1 = formPath.context.getMessage("Title.Company", null, Locale.US);
    					formPath.closeApplicationContext();
    					
    					// Need the ProgressBar controller to access the progress bar in this method
    					ProgressBarGUIController progressBarGUIController = ( ProgressBarGUIController )new FXFormCommonUtilities()
    																			.displayFormAndGetController(formName1, formTitle1);
    					ProgressBar progressBar = progressBarGUIController.getProgressBar();

    					/********************************   Start of Task definition    *****************************************************************/
    					Task<ObservableList<Company>> task =

    							new Task<ObservableList<Company>>() {

    									@Override
    									protected ObservableList<Company> call() throws Exception {

    											final ObservableList<Company> companyList = new CompanyEntityController().getCompanyList();
    											
    											if (isCancelled()) {
    											    return null;
    											}
    											return companyList;

    									}
    		    				};
    		    				
    					/*************************   End of Task definition    *****************************************************************/

    					task.setOnSucceeded(event1 -> {

    						 System.out.println("With in success.");
    						 // Close Progress Bar Form
    						 Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
    						 stage.close();
    						 
    						 String formName = formPath.context.getMessage("Company", null, Locale.US);
    							String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
    							formPath.closeApplicationContext();

    						 FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
    						 try {
    							formDisplayer.companyDisplayForm( formName , formTitle , task.getValue() );
    						 } catch (Exception e) {
    							e.printStackTrace();
    						 }

    					});

    					progressBar.progressProperty().bind(task.progressProperty());
    					
    					try {
    						// Start background thread for database record retrieval .
    						new Thread(task).start();
    					} catch (Exception e) {
    						e.printStackTrace();
    					}


    	}

    }

    @FXML
    void enterKeyPressedForEMRButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				
				String formName = formPath.context.getMessage("EMRSetup", null, Locale.US);
				formPath.closeApplicationContext();
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForHomeButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("Home", null, Locale.US);
				formPath.closeApplicationContext();
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForIncidentCodeButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("IncidentCode", null, Locale.US);
				formPath.closeApplicationContext();
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForMedicalCodeButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try{
    			
    			setupAdminNavPanel.getChildren().clear();
    			// Display SetupAdmin Navigational Panel
    			String formName = formPath.context.getMessage("MedicalCode", null, Locale.US);
    			formPath.closeApplicationContext();
    			setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));
    			
    			
    		}catch(Exception e){
    			
    			e.printStackTrace();
    		}
    		
    	}

    }

    @FXML
    void enterKeyPressedForOrganizationButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				String formName = formPath.context.getMessage("Organization", null, Locale.US);
				formPath.closeApplicationContext();
				// Display Organization Navigational Panel
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
    		
    		


    	}

    }

    @FXML
    void enterKeyPressedForPharmacyButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
			
			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Pharmacy", null, Locale.US);
			formPath.closeApplicationContext();
			
			// Need the ProgressBar controller to access the progress bar in this method
			ProgressBarGUIController progressBarGUIController = ( ProgressBarGUIController )new FXFormCommonUtilities()
																	.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************   Start of Task definition    *****************************************************************/
			Task<ObservableList<Pharmacy>> task =

					new Task<ObservableList<Pharmacy>>() {

							@Override
							protected ObservableList<Pharmacy> call() throws Exception {

									//updateMessage("Loading Illness Codes...");

									final ObservableList<Pharmacy> pharmacyList = new PharmacyEntityController().viewPharmacy();
									
									if (isCancelled()) {
									    return null;
									}
									return pharmacyList;

							}
    				};
			/*************************   End of Task definition    *****************************************************************/

			task.setOnSucceeded(event1 -> {

				 System.out.println("With in success.");
				 // Close Progress Bar Form
				 Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				 stage.close();
				 
				 String formName = formPath.context.getMessage("Pharmacy", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.Pharmacy", null, Locale.US);
					formPath.closeApplicationContext();

				 FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				 try {
					formDisplayer.pharmacyDisplayForm( formName , formTitle , task.getValue() );
				 } catch (Exception e) {
					e.printStackTrace();	 }

			});

			progressBar.progressProperty().bind(task.progressProperty());
			
			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForProtocolProfile(KeyEvent event) {

    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("ProtocolOrProfile", null, Locale.US);
				formPath.closeApplicationContext();
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}
    }

    @FXML
    void enterKeyPressedForProviderbutton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				String formName = formPath.context.getMessage("Provider", null, Locale.US);
				formPath.closeApplicationContext();
				// Display SetupAdmin Navigational Panel
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForThirdPartyButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				String formName = formPath.context.getMessage("ThirdParty", null, Locale.US);
				formPath.closeApplicationContext();

				// Display SetupAdmin Navigational Panel
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


    	}

    }
    
	private Stage primaryStage;
		
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	private BorderPane rootLayout;
		
	public BorderPane getRootLayout() {
		return rootLayout;
	}

	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}
	
	List<UserAccount> userList = UserLoginGUIController.getUserlist();
	
	public void accessControl(){
		
		if(userList.get(0).getRoleName().equals("Nurse")){
			
			//billingSetupButton.setVisible(false);
			adminSecurityButton.setVisible(false);
			
		}else if (userList.get(0).getRoleName().equals("Lab")) {
			
			clinicButton.setVisible(false);
			companyButton.setVisible(false);
			medicalCodesButton.setVisible(false);
			incidentCodesButton.setVisible(false);
			//protocolOrProfileButton.setVisible(false);
			organizationButton.setVisible(false);
			thirdPartyPlayerButton.setVisible(false);
			providerButton.setVisible(false);
			pharmacyButton.setVisible(false);
			//emrSetupButton.setVisible(false);
			//billingSetupButton.setVisible(false);
			adminSecurityButton.setVisible(false);
			
		}
		else if (userList.get(0).getRoleName().equals("Billing")) {
			
			clinicButton.setVisible(false);
			companyButton.setVisible(false);
			medicalCodesButton.setVisible(false);
			incidentCodesButton.setVisible(false);
			//protocolOrProfileButton.setVisible(false);
			organizationButton.setVisible(false);
			thirdPartyPlayerButton.setVisible(false);
			providerButton.setVisible(false);
			pharmacyButton.setVisible(false);
			//emrSetupButton.setVisible(false);
			clinicalSetupButton.setVisible(false);
			adminSecurityButton.setVisible(false);
			
		}
	}
	
	
	FXMLFormPath formPath = new FXMLFormPath();
		

	@Override
	public void initialize(URL location, ResourceBundle resources) {
			
		accessControl();
		
		clinicButton.setOnAction((event) -> {
			try {
				// Load Clinic Details  .
								
				String formName = formPath.context.getMessage("Clinic", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Clinic", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm( formName , formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	
		companyButton.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*************************************    Start of  companyBtn.setOnAction(..)     *****************************************************/

		/*companyButton.setOnAction((event) -> {
			
			// Load Progress Bar
			
			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
			
			String formTitle1 = formPath.context.getMessage("Title.Company", null, Locale.US);
			formPath.closeApplicationContext();
			
			// Need the ProgressBar controller to access the progress bar in this method
			ProgressBarGUIController progressBarGUIController = ( ProgressBarGUIController )new FXFormCommonUtilities()
																	.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************   Start of Task definition    *****************************************************************//*
			Task<ObservableList<Company>> task =

					new Task<ObservableList<Company>>() {

							@Override
							protected ObservableList<Company> call() throws Exception {

									final ObservableList<Company> companyList = new CompanyEntityController().getCompanyList();
									
									if (isCancelled()) {
									    return null;
									}
									return companyList;

							}
    				};
    				
			*//*************************   End of Task definition    *****************************************************************//*

			task.setOnSucceeded(event1 -> {

				 System.out.println("With in success.");
				 // Close Progress Bar Form
				 Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				 stage.close();
				 
				 String formName = formPath.context.getMessage("Company", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
					formPath.closeApplicationContext();

				 FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				 try {
					formDisplayer.companyDisplayForm( formName , formTitle , task.getValue() );
				 } catch (Exception e) {
					e.printStackTrace();
				 }

			});

			progressBar.progressProperty().bind(task.progressProperty());
			
			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});*/
		/*************************************    End of  companyBtn.setOnAction(..)     *************************************************************/




		// Load Navigation Panel for Medical Codes .
		medicalCodesButton.setOnAction((event) -> {
					try {
					
						setupAdminNavPanel.getChildren().clear();
						// Display SetupAdmin Navigational Panel
						String formName = formPath.context.getMessage("MedicalCode", null, Locale.US);
						formPath.closeApplicationContext();
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});

		// Load Navigation Panel for SetupAdmin .
		homeButton.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				setupAdminNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("Home", null, Locale.US);
				formPath.closeApplicationContext();
				setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Load Navigation Panel for IncidentOrSafetyCodes .
		incidentCodesButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
						// Display SetupAdmin Navigational Panel
						String formName = formPath.context.getMessage("IncidentCode", null, Locale.US);
						formPath.closeApplicationContext();
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		// Load Navigation Panel for IncidentOrSafetyCodes .
		/*billingPannel.setOnAction((event) -> {
							try {
								// Clear from view Current Navigation Panel
								setupAdminNavPanel.getChildren().clear();
								// Display SetupAdmin Navigational Panel
								String formName = formPath.context.getMessage("BillingPanel", null, Locale.US);
								formPath.closeApplicationContext();
								setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

							} catch (Exception ex) {
								ex.printStackTrace();
							}
						});*/

		// Load Navigation Panel for Medical Codes .
		/*protocolOrProfileButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
						// Display SetupAdmin Navigational Panel
						String formName = formPath.context.getMessage("ProtocolOrProfile", null, Locale.US);
						formPath.closeApplicationContext();
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});*/
		
		
		
		// Load Navigation Panel for Organizarions .
		organizationButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
						String formName = formPath.context.getMessage("Organization", null, Locale.US);
						formPath.closeApplicationContext();
						// Display Organization Navigational Panel
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
		// Load Navigation Panel for ThirdPartyPlayer .
		thirdPartyPlayerButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
						String formName = formPath.context.getMessage("ThirdParty", null, Locale.US);
						formPath.closeApplicationContext();

						// Display SetupAdmin Navigational Panel
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});

		// Load Navigation Panel for Provider .
		providerButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
						String formName = formPath.context.getMessage("Provider", null, Locale.US);
						formPath.closeApplicationContext();
						// Display SetupAdmin Navigational Panel
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
						
			
		
		/*************************************    Start of  pharmacyBtn.setOnAction(..)     *****************************************************/

		pharmacyButton.setOnAction((event) -> {
			

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
			
			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Pharmacy", null, Locale.US);
			formPath.closeApplicationContext();
			
			// Need the ProgressBar controller to access the progress bar in this method
			ProgressBarGUIController progressBarGUIController = ( ProgressBarGUIController )new FXFormCommonUtilities()
																	.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************   Start of Task definition    *****************************************************************/
			Task<ObservableList<Pharmacy>> task =

					new Task<ObservableList<Pharmacy>>() {

							@Override
							protected ObservableList<Pharmacy> call() throws Exception {

									//updateMessage("Loading Illness Codes...");

									final ObservableList<Pharmacy> pharmacyList = new PharmacyEntityController().viewPharmacy();
									
									if (isCancelled()) {
									    return null;
									}
									return pharmacyList;

							}
    				};
			/*************************   End of Task definition    *****************************************************************/

			task.setOnSucceeded(event1 -> {

				 System.out.println("With in success.");
				 // Close Progress Bar Form
				 Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				 stage.close();
				 
				 String formName = formPath.context.getMessage("Pharmacy", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.Pharmacy", null, Locale.US);
					formPath.closeApplicationContext();

				 FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				 try {
					formDisplayer.pharmacyDisplayForm( formName , formTitle , task.getValue() );
				 } catch (Exception e) {
					e.printStackTrace();	 }

			});

			progressBar.progressProperty().bind(task.progressProperty());
			
			try {
				// Start background thread for database record retrieval .
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************    End of  pharmacyBtn.setOnAction(..)     *************************************************************/

		
		// Load Navigation Panel for EMR And Administration Setup .
		/*emrSetupButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
						// Display SetupAdmin Navigational Panel
						
						String formName = formPath.context.getMessage("EMRSetup", null, Locale.US);
						formPath.closeApplicationContext();
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});*/

		// Load Navigation Panel for Billing Setup .
		/*billingSetupButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
				
						String formName = formPath.context.getMessage("BillingSetup", null, Locale.US);
						formPath.closeApplicationContext();
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});*/
		
		

		// Load Navigation Panel for Clinical Setup .
		clinicalSetupButton.setOnAction((event) -> {
					try {
						// Clear from view Current Navigation Panel
						setupAdminNavPanel.getChildren().clear();
						// Display SetupAdmin Navigational Panel
						String formName = formPath.context.getMessage("ClinicalSetup", null, Locale.US);
						formPath.closeApplicationContext();
						setupAdminNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

					} catch (Exception ex) {
						ex.printStackTrace();
					}
				});
		
				// Load User Details .
				adminSecurityButton.setOnAction((event) -> {
							try {
							
								String formName = formPath.context.getMessage("ViewUserDetail", null, Locale.US);
								String formTitle = formPath.context.getMessage("Title.ViewUserDetail", null, Locale.US);
								formPath.closeApplicationContext();

								new FXFormCommonUtilities().displayForm(formName, formTitle);

							} catch (Exception ex) {
								ex.printStackTrace();
							}
						});

	}

}