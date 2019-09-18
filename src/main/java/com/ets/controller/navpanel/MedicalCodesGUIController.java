package com.ets.controller.navpanel;

/*
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of MedicalCodesGUIController Class
 *Description: MedicalCodes.fxml Controller class
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse TechnoConsulting Global Pvt. Ltd.

*/

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.controller.entity.billingServiceType.BillingServiceTypeEntityController;
import com.ets.controller.entity.medicalCondition.MedicalConditionCodeEntityController;
import com.ets.controller.entity.respiratorModel.RespiratorModelEntityController;
import com.ets.controller.entity.visitCategoryGroup.VisitCategoryGroupEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BillingServiceType;
import com.ets.model.MedicalCondition;
import com.ets.model.RespiratorModel;
import com.ets.model.VisitCategoryGroup;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MedicalCodesGUIController implements Initializable {

	@FXML
	private AnchorPane medicalCodeNavPanel;

	@FXML
	private Button closeBtn;

	@FXML
	private Button adBtn;

	@FXML
	private Button medAct;

	@FXML
	private Button medatm;

	@FXML
	private Button medco;

	@FXML
	private Button vstcgry;

	@FXML
	private Button vstgrp;

	@FXML
	private Button icd;

	@FXML
	private Button icd10CodesBtn;

	@FXML
	private Button wrst;

	
	@FXML
	private Button cpt4hcp;

	@FXML
	private Button decl;

	@FXML
	private Button assmnt;

	@FXML
	private Button bill;

	@FXML
	private Button respiratorModelBtn;
	
	 @FXML
	    void enterKeyPressedForAssesmentQuesButton(KeyEvent event) {
		 
		 if(event.getCode() == KeyCode.ENTER){
			 
			// Load and Display - selectassessmentquestion_code.fxml Form
				String formName = formPath.context.getMessage("AssesmentQuestion", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AssesmentQuestion", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);


		 }

	    }

	    @FXML
	    void enterKeyPressedForBillingServiceTypeButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.BillingService", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<BillingServiceType>> task =

						new Task<ObservableList<BillingServiceType>>() {

							@Override
							protected ObservableList<BillingServiceType> call() throws Exception {

								final ObservableList<BillingServiceType> billingServiceTypeList = new BillingServiceTypeEntityController()
										.viewBillingService();

								if (isCancelled()) {
									return null;
								}
								return billingServiceTypeList;

							}
						};
				/*************************
				 * End of Task definition
				 *****************************************************************/

				task.setOnSucceeded(event1 -> {

					System.out.println("With in success.");
					// Close Progress Bar Form
					Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
					stage.close();

					String formName = formPath.context.getMessage("BillingService", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.BillingService", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.billingServiceTypeDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForCPT4CodeButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		// Load and Display - Select_CPT-4_or_HCPCS_Code.fxml Form
				String formName = formPath.context.getMessage("CPT4", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CPT4", null, Locale.US);
				formPath.closeApplicationContext();
				// String formTitle = "Select CPT-4 or HCPCS Code" ;
				new FXFormCommonUtilities().displayForm(formName, formTitle);


	    	}

	    }

	    @FXML
	    void enterKeyPressedForCloseButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		try {
					// Clear from view Current Navigation Panel
					medicalCodeNavPanel.getChildren().clear();
					// Display SetupAdmin Navigational Panel
					String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
					formPath.closeApplicationContext();
					medicalCodeNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

				} catch (Exception ex) {
					ex.printStackTrace();
				}


	    	}

	    }

	    @FXML
	    void enterKeyPressedForDeclinationCodeButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		// Load and Display - Select_Activity_Declanation_Code.fxml Form
				String formName = formPath.context.getMessage("Declination", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Declination", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);


	    	}

	    }

	    @FXML
	    void enterKeyPressedForICD10CodeButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		// Load and Display - ICD-10_Diagnoisis Codes(ReadOnly).fxml
				// Form
				String formName = formPath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD10", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);


	    	}

	    }

	    @FXML
	    void enterKeyPressedForMedicalActivity(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		// Load and Display - Select_medical_activity.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				// String formTitle = "Select Medical Activity" ;
				new FXFormCommonUtilities().displayForm(formName, formTitle);


	    	}

	    }

	    @FXML
	    void enterKeyPressedForMedicalConditionButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.MedicalCondition", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<MedicalCondition>> task =

						new Task<ObservableList<MedicalCondition>>() {

							@Override
							protected ObservableList<MedicalCondition> call() throws Exception {

								final ObservableList<MedicalCondition> medicalConditionList = new MedicalConditionCodeEntityController()
										.getMedicalList();

								if (isCancelled()) {
									return null;
								}
								return medicalConditionList;

							}
						};
				/*************************
				 * End of Task definition
				 *****************************************************************/

				task.setOnSucceeded(event1 -> {

					System.out.println("With in success.");
					// Close Progress Bar Form
					Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
					stage.close();

					String formName = formPath.context.getMessage("MedicalCondition", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicalCondition", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.medicalConditionDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForRespiratorModelButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.RespiratorModel", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<RespiratorModel>> task =

						new Task<ObservableList<RespiratorModel>>() {

							@Override
							protected ObservableList<RespiratorModel> call() throws Exception {

								final ObservableList<RespiratorModel> respiratorModelList = new RespiratorModelEntityController()
										.viewRespiratorModelList();

								if (isCancelled()) {
									return null;
								}
								return respiratorModelList;

							}
						};
				/*************************
				 * End of Task definition
				 *****************************************************************/

				task.setOnSucceeded(event1 -> {

					System.out.println("With in success.");
					// Close Progress Bar Form
					Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
					stage.close();

					String formName = formPath.context.getMessage("RespiratorModel", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.RespiratorModel", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.respiratorModelDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForVisitCategoryButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

	    	}

	    }

	    @FXML
	    void enterKeyPressedForWorkRestrictionButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		// Load and Display - Work_Retrictions_Type.fxml Form
				String formName = formPath.context.getMessage("WorkRestriction", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.WorkRestriction", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);


	    	}

	    }

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		// Cancel Medical Codes Nav Panel and show the previous nav apnel namely
		// SetupAdmin nav panel
		closeBtn.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				medicalCodeNavPanel.getChildren().clear();
				// Display SetupAdmin Navigational Panel
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				medicalCodeNavPanel.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*************************************
		 * Start of complexBtn.setOnAction(..)
		 *****************************************************/

		medco.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.MedicalCondition", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<MedicalCondition>> task =

					new Task<ObservableList<MedicalCondition>>() {

						@Override
						protected ObservableList<MedicalCondition> call() throws Exception {

							final ObservableList<MedicalCondition> medicalConditionList = new MedicalConditionCodeEntityController()
									.getMedicalList();

							if (isCancelled()) {
								return null;
							}
							return medicalConditionList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("MedicalCondition", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalCondition", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.medicalConditionDisplayForm(formName, formTitle, task.getValue());
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

		});
		/*************************************
		 * End of complexBtn.setOnAction(..)
		 *************************************************************/

		wrst.setOnAction((event) -> {
			try {
				 // Load and Display - Work_Retrictions_Type.fxml Form
				String formName = formPath.context.getMessage("WorkRestriction", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.WorkRestriction", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		cpt4hcp.setOnAction((event) -> {
			try {
				// Load and Display - Select_CPT-4_or_HCPCS_Code.fxml Form
				String formName = formPath.context.getMessage("CPT4", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CPT4", null, Locale.US);
				formPath.closeApplicationContext();
				// String formTitle = "Select CPT-4 or HCPCS Code" ;
				new FXFormCommonUtilities().displayForm(formName, formTitle);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		decl.setOnAction((event) -> {
			try {
				// Load and Display - Select_Activity_Declanation_Code.fxml Form
				String formName = formPath.context.getMessage("Declination", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Declination", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		assmnt.setOnAction((event) -> {
			try {
				// Load and Display - selectassessmentquestion_code.fxml Form
				String formName = formPath.context.getMessage("AssesmentQuestion", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.AssesmentQuestion", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*************************************
		 * Start of respiratorModelBtn.setOnAction(..)
		 *****************************************************/

		respiratorModelBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.RespiratorModel", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<RespiratorModel>> task =

					new Task<ObservableList<RespiratorModel>>() {

						@Override
						protected ObservableList<RespiratorModel> call() throws Exception {

							final ObservableList<RespiratorModel> respiratorModelList = new RespiratorModelEntityController()
									.viewRespiratorModelList();

							if (isCancelled()) {
								return null;
							}
							return respiratorModelList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("RespiratorModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.RespiratorModel", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.respiratorModelDisplayForm(formName, formTitle, task.getValue());
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

		});
		/*************************************
		 * End of respiratorModelBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of billingServiceType.setOnAction(..)
		 *****************************************************/

		bill.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.BillingService", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<BillingServiceType>> task =

					new Task<ObservableList<BillingServiceType>>() {

						@Override
						protected ObservableList<BillingServiceType> call() throws Exception {

							final ObservableList<BillingServiceType> billingServiceTypeList = new BillingServiceTypeEntityController()
									.viewBillingService();

							if (isCancelled()) {
								return null;
							}
							return billingServiceTypeList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("BillingService", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BillingService", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.billingServiceTypeDisplayForm(formName, formTitle, task.getValue());
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

		});
		/*************************************
		 * End of respiratorModelBtn.setOnAction(..)
		 *************************************************************/

		medAct.setOnAction((event) -> {
			try {
				// Load and Display - Select_medical_activity.fxml Form
				String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
				formPath.closeApplicationContext();
				// String formTitle = "Select Medical Activity" ;
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	/*	medatm.setOnAction((event) -> {
			try {
				// Load and Display - Medicalactivitytemplates.fxml Form
				String formName = formPath.context.getMessage("MedicalTemplate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.MedicalTemplate", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/
		vstcgry.setOnAction((event) -> {
			try {
				// Load and Display - Select_Visit_Category_Code.fxml Form
				String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*************************************
		 * Start of complexBtn.setOnAction(..)
		 *****************************************************/

		/*vstgrp.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.VisitCategoryGroup", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************
			 * Start of Task definition
			 *****************************************************************//*
			Task<ObservableList<VisitCategoryGroup>> task =

					new Task<ObservableList<VisitCategoryGroup>>() {

						@Override
						protected ObservableList<VisitCategoryGroup> call() throws Exception {

							final ObservableList<VisitCategoryGroup> visitCategoryGroupList = new VisitCategoryGroupEntityController()
									.viewVisitCategoryGroup();

							if (isCancelled()) {
								return null;
							}
							return visitCategoryGroupList;

						}
					};
			*//*************************
			 * End of Task definition
			 *****************************************************************//*

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				// Close Progress Bar Form
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("VisitCategoryGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.VisitCategoryGroup", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.visitCategoryGroupDisplayForm(formName, formTitle, task.getValue());
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
		/*************************************
		 * End of complexBtn.setOnAction(..)
		 *************************************************************/

		icd10CodesBtn.setOnAction((event) -> {
			try {
				// Load and Display - ICD-10_Diagnoisis Codes(ReadOnly).fxml
				// Form
				String formName = formPath.context.getMessage("ICD10", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ICD10", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
