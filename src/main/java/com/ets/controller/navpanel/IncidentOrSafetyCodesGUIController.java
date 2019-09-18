package com.ets.controller.navpanel;


/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IncidentOrSafetyCodesGUIController Class
 *Description: IncidentOrSafetyCodes.fxml Controller class
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


import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.controller.entity.bodypart.BodyPartEntityController;
import com.ets.controller.entity.bodyzone.BodyZoneEntityController;
import com.ets.controller.entity.caseClosedReason.CaseClosedReasonStatusEntityController;
import com.ets.controller.entity.deviceManufacturerAndBrand.DeviceManufacturerAndBrandEntityontroller;
import com.ets.controller.entity.deviceModel.DeviceModelEntityController;
import com.ets.controller.entity.deviceType.DeviceTypeEntityController;
import com.ets.controller.entity.exposureCode.ExposureCodeEntityController;
import com.ets.controller.entity.firstResponse.FirstResponseEntityController;
import com.ets.controller.entity.illnessCode.IllnessCodeEntityController;
import com.ets.controller.entity.incidentOrEvent.IncidentOrEventEntityController;
import com.ets.controller.entity.injuryCode.InjuryCodeEntityController;
import com.ets.controller.entity.objectOrSubstance.ObjectOrSubstanceEntityController;
import com.ets.controller.entity.reasonOrCause.ReasonOrCauseEntityController;
import com.ets.controller.entity.rootCause.RootCauseEntityController;
import com.ets.controller.entity.severity.SeverityEntityController;
import com.ets.controller.entity.stateJobCategory.StateJobCategoryEntityController;
import com.ets.controller.entity.stateWorkArea.StateWorkAreaEntityController;
import com.ets.controller.entity.workActivity.WorkActivityEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BodyPart;
import com.ets.model.BodyZone;
import com.ets.model.CaseClosedReason;
import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.model.DeviceModel;
import com.ets.model.DeviceType;
import com.ets.model.FirstResponse;
import com.ets.model.IllnessCode;
import com.ets.model.IncidentOrEvent;
import com.ets.model.InjuryCode;
import com.ets.model.ExposureCode;
import com.ets.model.ObjectOrSubstance;
import com.ets.model.ReasonOrCause;
import com.ets.model.RootCause;
import com.ets.model.SeverityCode;
import com.ets.model.StateJobCategory;
import com.ets.model.StateWorkArea;
import com.ets.model.WorkActivity;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import javafx.concurrent.Task;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;

public class IncidentOrSafetyCodesGUIController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private Button injuryCodeBtn;

	@FXML
	private Button illnessCodeBtn;

	@FXML
	private Button exposureCodeBtn;

	@FXML
	private Button bodyPartBtn;

	@FXML
	private Button bodyZoneBtn;

	@FXML
	private Button serverityBtn;

	@FXML
	private Button incidentOrEventBtn;

	@FXML
	private Button reasonOrCauseBtn;

	@FXML
	private Button rootCauseBtn;

	@FXML
	private Button workActivityBtn;

	@FXML
	private Button objectOrsubstanceBtn;

	@FXML
	private Button deviceBtn;

	@FXML
	private Button manufacturerOrBrandBtn;

	@FXML
	private Button deviceModelBtn;

	@FXML
	private Button firstResponseBtn;

	@FXML
	private Button jobCategoryBtn;

	@FXML
	private Button workAreaBtn;

	@FXML
	private Button caseClosedBtn;

	@FXML
	private Button closeBtn;
	
	 @FXML
	    void enterKeyPressedForBodyPart(KeyEvent event) {
		 
		 if(event.getCode() == KeyCode.ENTER){
			 
			 String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.BodyPart", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<BodyPart>> task =

						new Task<ObservableList<BodyPart>>() {

							@Override
							protected ObservableList<BodyPart> call() throws Exception {

								final ObservableList<BodyPart> bodyPartCodeList = new BodyPartEntityController()
										.viewBodyParts();

								if (isCancelled()) {
									return null;
								}
								return bodyPartCodeList;

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

					String formName = formPath.context.getMessage("BodyPart", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.BodyPart", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.bodyPartCodeDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForBodyZone(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.BodyZone", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<BodyZone>> task =

						new Task<ObservableList<BodyZone>>() {

							@Override
							protected ObservableList<BodyZone> call() throws Exception {

								final ObservableList<BodyZone> bodyZoneCodeList = new BodyZoneEntityController()
										.viewBodyZone();

								if (isCancelled()) {
									return null;
								}
								return bodyZoneCodeList;

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

					String formName = formPath.context.getMessage("BodyZone", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.BodyZone", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.bodyZoneCodeDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForCaseCloseReason(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.CaseClosedReason", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<CaseClosedReason>> task =

						new Task<ObservableList<CaseClosedReason>>() {

							@Override
							protected ObservableList<CaseClosedReason> call() throws Exception {

								final ObservableList<CaseClosedReason> caseClosedReasonList = new CaseClosedReasonStatusEntityController()
										.viewCaseClosedReason();

								if (isCancelled()) {
									return null;
								}
								return caseClosedReasonList;

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

					String formName = formPath.context.getMessage("CaseClosed", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.CaseClosed", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.caseClosedDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForCloseButton(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		try {
					// Clear from view Current Navigation Panel
					basePane.getChildren().clear();
					// Display SetupAdmin Navigation Panel
					String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
					formPath.closeApplicationContext();
					basePane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

				} catch (Exception ex) {
					ex.printStackTrace();
				}


	    	}

	    }

	    @FXML
	    void enterKeyPressedForDeviceModel(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.DeviceModel", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<DeviceModel>> task =

						new Task<ObservableList<DeviceModel>>() {

							@Override
							protected ObservableList<DeviceModel> call() throws Exception {

								final ObservableList<DeviceModel> deviceModelList = new DeviceModelEntityController()
										.viewSharpDeviceModel();

								if (isCancelled()) {
									return null;
								}
								return deviceModelList;

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

					String formName = formPath.context.getMessage("DeviceModel", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.DeviceModel", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.deviceModelDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForExposureCode(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ExposureCode", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<ExposureCode>> task =

						new Task<ObservableList<ExposureCode>>() {

							@Override
							protected ObservableList<ExposureCode> call() throws Exception {

								final ObservableList<ExposureCode> exposureCodeList = new ExposureCodeEntityController()
										.viewExposureCode();
								if (isCancelled()) {
									return null;
								}
								return exposureCodeList;

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

					String formName = formPath.context.getMessage("ExposureCode", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ExposureCode", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.ExposureCodeDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForFirstResponse(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.FirstResponse", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<FirstResponse>> task =

						new Task<ObservableList<FirstResponse>>() {

							@Override
							protected ObservableList<FirstResponse> call() throws Exception {

								final ObservableList<FirstResponse> firstResponseList = new FirstResponseEntityController()
										.viewFirstResponse();

								if (isCancelled()) {
									return null;
								}
								return firstResponseList;

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

					String formName = formPath.context.getMessage("FirstResponse", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.FirstResponse", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.firstResponseDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForIllnessCode(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.IllnessCode", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<IllnessCode>> task =

						new Task<ObservableList<IllnessCode>>() {

							@Override
							protected ObservableList<IllnessCode> call() throws Exception {

								final ObservableList<IllnessCode> illnessCodeList = new IllnessCodeEntityController()
										.viewIllnessCode();

								if (isCancelled()) {
									return null;
								}
								return illnessCodeList;

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

					String formName = formPath.context.getMessage("IllnessCode", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.IllnessCode", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.displayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForIncidentOrEventType(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.IncidentOrEventType", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<IncidentOrEvent>> task =

						new Task<ObservableList<IncidentOrEvent>>() {

							@Override
							protected ObservableList<IncidentOrEvent> call() throws Exception {

								final ObservableList<IncidentOrEvent> incidentOrEventList = new IncidentOrEventEntityController()
										.viewIncidentOrEvent();

								if (isCancelled()) {
									return null;
								}
								return incidentOrEventList;

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

					String formName = formPath.context.getMessage("IncidentOrEvent", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.IncidentOrEvent", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.incidentOrEventDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForInjuryCode(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.InjuryCode", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<InjuryCode>> task =

						new Task<ObservableList<InjuryCode>>() {

							@Override
							protected ObservableList<InjuryCode> call() throws Exception {

								final ObservableList<InjuryCode> illnessCodeList = new InjuryCodeEntityController()
										.viewInjuryCode();

								if (isCancelled()) {
									return null;
								}
								return illnessCodeList;

							}
						};
				/*************************
				 * End of Task definition
				 *****************************************************************/

				task.setOnSucceeded(event1 -> {

					System.out.println("With in success.");
					Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
					stage.close();
					String formName = formPath.context.getMessage("InjuryCode", null, Locale.US);

					String formTitle = formPath.context.getMessage("Title.InjuryCode", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.InjuryCodeDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForManufacturerBrand(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ManufacturerAndBrand", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<DeviceManufacturerAndBrand>> task =

						new Task<ObservableList<DeviceManufacturerAndBrand>>() {

							@Override
							protected ObservableList<DeviceManufacturerAndBrand> call() throws Exception {

								final ObservableList<DeviceManufacturerAndBrand> deviceManufacturerAndBrandList = new DeviceManufacturerAndBrandEntityontroller()
										.viewSharpDeviceManufacturerAndBrand();

								if (isCancelled()) {
									return null;
								}
								return deviceManufacturerAndBrandList;

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

					String formName = formPath.context.getMessage("ManufacturerAndBrand", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ManufacturerAndBrand", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.manufacturerAndBrandDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForObjectOrSubstance(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ObjectOrSubstance", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<ObjectOrSubstance>> task =

						new Task<ObservableList<ObjectOrSubstance>>() {

							@Override
							protected ObservableList<ObjectOrSubstance> call() throws Exception {

								final ObservableList<ObjectOrSubstance> objectOrSubstanceList = new ObjectOrSubstanceEntityController()
										.viewObjectOrSubstance();

								if (isCancelled()) {
									return null;
								}
								return objectOrSubstanceList;

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

					String formName = formPath.context.getMessage("ObjectOrSubstance", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ObjectOrSubstance", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.objectOrSubstanceDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForReasonOrCause(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ReasonOrCause", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<ReasonOrCause>> task =

						new Task<ObservableList<ReasonOrCause>>() {

							@Override
							protected ObservableList<ReasonOrCause> call() throws Exception {

								final ObservableList<ReasonOrCause> reasonOrCauseList = new ReasonOrCauseEntityController()
										.viewReasonOrCause();

								if (isCancelled()) {
									return null;
								}
								return reasonOrCauseList;

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

					String formName = formPath.context.getMessage("ReasonOrCause", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ReasonOrCause", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.reasonOrCauseDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForSevirity(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.SeverityCode", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<SeverityCode>> task =

						new Task<ObservableList<SeverityCode>>() {

							@Override
							protected ObservableList<SeverityCode> call() throws Exception {

								final ObservableList<SeverityCode> severityCodeList = new SeverityEntityController()
										.viewSeverity();

								if (isCancelled()) {
									return null;
								}
								return severityCodeList;

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

					String formName = formPath.context.getMessage("SeverityCode", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.SeverityCode", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.severityCodeDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForSharpDevice(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.DeviceType", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<DeviceType>> task =

						new Task<ObservableList<DeviceType>>() {

							@Override
							protected ObservableList<DeviceType> call() throws Exception {

								final ObservableList<DeviceType> deviceTypeList = new DeviceTypeEntityController()
										.viewSharpDdevice();

								if (isCancelled()) {
									return null;
								}
								return deviceTypeList;

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

					String formName = formPath.context.getMessage("SharpDevice", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.SharpDevice", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.deviceTypeDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForStateJobCategory(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.StateJobCategory", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<StateJobCategory>> task =

						new Task<ObservableList<StateJobCategory>>() {

							@Override
							protected ObservableList<StateJobCategory> call() throws Exception {

								final ObservableList<StateJobCategory> stateJobCategoryList = new StateJobCategoryEntityController()
										.viewStateJobCategory();

								if (isCancelled()) {
									return null;
								}
								return stateJobCategoryList;

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

					String formName = formPath.context.getMessage("JobCategory", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.JobCategory", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.stateJobCategoryDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForStateWorkArea(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.StateWorkArea", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<StateWorkArea>> task =

						new Task<ObservableList<StateWorkArea>>() {

							@Override
							protected ObservableList<StateWorkArea> call() throws Exception {

								final ObservableList<StateWorkArea> objectOrSubstanceList = new StateWorkAreaEntityController()
										.viewStateWorkArea();

								if (isCancelled()) {
									return null;
								}
								return objectOrSubstanceList;

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

					String formName = formPath.context.getMessage("WorkArea", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.WorkArea", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.workAreaDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForWorkActivity(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.WorkActivity", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<WorkActivity>> task =

						new Task<ObservableList<WorkActivity>>() {

							@Override
							protected ObservableList<WorkActivity> call() throws Exception {

								final ObservableList<WorkActivity> workActivityList = new WorkActivityEntityController()
										.viewWorkActivity();

								if (isCancelled()) {
									return null;
								}
								return workActivityList;

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

					String formName = formPath.context.getMessage("WorkActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.WorkActivity", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.workActivityDisplayForm(formName, formTitle, task.getValue());
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
	    void enterKeyPressedForRootCause(KeyEvent event) {
	    	
	    	if(event.getCode() == KeyCode.ENTER){
	    		
	    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

				String formTitle1 = formPath.context.getMessage("Title.ProgressBar.RootCause", null, Locale.US);
				formPath.closeApplicationContext();

				// Need the ProgressBar controller to access the progress bar in
				// this method
				ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
						.displayFormAndGetController(formName1, formTitle1);
				ProgressBar progressBar = progressBarGUIController.getProgressBar();

				/********************************
				 * Start of Task definition
				 *****************************************************************/
				Task<ObservableList<RootCause>> task =

						new Task<ObservableList<RootCause>>() {

							@Override
							protected ObservableList<RootCause> call() throws Exception {

								final ObservableList<RootCause> reasonOrCauseList = new RootCauseEntityController()
										.viewRootCause();

								if (isCancelled()) {
									return null;
								}
								return reasonOrCauseList;

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

					String formName = formPath.context.getMessage("RootCause", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.RootCause", null, Locale.US);
					formPath.closeApplicationContext();

					FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
					try {
						formDisplayer.rootCauseDisplayForm(formName, formTitle, task.getValue());
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

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*************************************
		 * Start of injuryCodeBtn.setOnAction(..)
		 *****************************************************/

		injuryCodeBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.InjuryCode", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<InjuryCode>> task =

					new Task<ObservableList<InjuryCode>>() {

						@Override
						protected ObservableList<InjuryCode> call() throws Exception {

							final ObservableList<InjuryCode> illnessCodeList = new InjuryCodeEntityController()
									.viewInjuryCode();

							if (isCancelled()) {
								return null;
							}
							return illnessCodeList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();
				String formName = formPath.context.getMessage("InjuryCode", null, Locale.US);

				String formTitle = formPath.context.getMessage("Title.InjuryCode", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.InjuryCodeDisplayForm(formName, formTitle, task.getValue());
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
		 * End of injuryCodeBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of illnessCodeBtn.setOnAction(..)
		 *****************************************************/

		illnessCodeBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);
			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.IllnessCode", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<IllnessCode>> task =

					new Task<ObservableList<IllnessCode>>() {

						@Override
						protected ObservableList<IllnessCode> call() throws Exception {

							final ObservableList<IllnessCode> illnessCodeList = new IllnessCodeEntityController()
									.viewIllnessCode();

							if (isCancelled()) {
								return null;
							}
							return illnessCodeList;

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

				String formName = formPath.context.getMessage("IllnessCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.IllnessCode", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.displayForm(formName, formTitle, task.getValue());
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
		 * End of illnessCodeBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of exposureCodeBtn.setOnAction(..)
		 *****************************************************/

		exposureCodeBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ExposureCode", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<ExposureCode>> task =

					new Task<ObservableList<ExposureCode>>() {

						@Override
						protected ObservableList<ExposureCode> call() throws Exception {

							final ObservableList<ExposureCode> exposureCodeList = new ExposureCodeEntityController()
									.viewExposureCode();
							if (isCancelled()) {
								return null;
							}
							return exposureCodeList;

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

				String formName = formPath.context.getMessage("ExposureCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ExposureCode", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.ExposureCodeDisplayForm(formName, formTitle, task.getValue());
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
		 * End of exposureCodeBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of bodyPartBtn.setOnAction(..)
		 *****************************************************/

		bodyPartBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.BodyPart", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<BodyPart>> task =

					new Task<ObservableList<BodyPart>>() {

						@Override
						protected ObservableList<BodyPart> call() throws Exception {

							final ObservableList<BodyPart> bodyPartCodeList = new BodyPartEntityController()
									.viewBodyParts();

							if (isCancelled()) {
								return null;
							}
							return bodyPartCodeList;

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

				String formName = formPath.context.getMessage("BodyPart", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BodyPart", null, Locale.US);
				
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.bodyPartCodeDisplayForm(formName, formTitle, task.getValue());
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
		 * End of bodyPartBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of bodyZoneBtn.setOnAction(..)
		 *****************************************************/

		bodyZoneBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.BodyZone", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<BodyZone>> task =

					new Task<ObservableList<BodyZone>>() {

						@Override
						protected ObservableList<BodyZone> call() throws Exception {

							final ObservableList<BodyZone> bodyZoneCodeList = new BodyZoneEntityController()
									.viewBodyZone();

							if (isCancelled()) {
								return null;
							}
							return bodyZoneCodeList;

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

				String formName = formPath.context.getMessage("BodyZone", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.BodyZone", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.bodyZoneCodeDisplayForm(formName, formTitle, task.getValue());
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
		 * End of bodyZoneBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of serverityBtn.setOnAction(..)
		 *****************************************************/

		serverityBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.SeverityCode", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<SeverityCode>> task =

					new Task<ObservableList<SeverityCode>>() {

						@Override
						protected ObservableList<SeverityCode> call() throws Exception {

							final ObservableList<SeverityCode> severityCodeList = new SeverityEntityController()
									.viewSeverity();

							if (isCancelled()) {
								return null;
							}
							return severityCodeList;

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

				String formName = formPath.context.getMessage("SeverityCode", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SeverityCode", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.severityCodeDisplayForm(formName, formTitle, task.getValue());
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
		 * End of serverityBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of incidentOrEventBtn.setOnAction(..)
		 *****************************************************/

		incidentOrEventBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.IncidentOrEventType", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<IncidentOrEvent>> task =

					new Task<ObservableList<IncidentOrEvent>>() {

						@Override
						protected ObservableList<IncidentOrEvent> call() throws Exception {

							final ObservableList<IncidentOrEvent> incidentOrEventList = new IncidentOrEventEntityController()
									.viewIncidentOrEvent();

							if (isCancelled()) {
								return null;
							}
							return incidentOrEventList;

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

				String formName = formPath.context.getMessage("IncidentOrEvent", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.IncidentOrEvent", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.incidentOrEventDisplayForm(formName, formTitle, task.getValue());
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
		 * End of incidentOrEventBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of reasonOrCauseBtn.setOnAction(..)
		 *****************************************************/

		reasonOrCauseBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ReasonOrCause", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<ReasonOrCause>> task =

					new Task<ObservableList<ReasonOrCause>>() {

						@Override
						protected ObservableList<ReasonOrCause> call() throws Exception {

							final ObservableList<ReasonOrCause> reasonOrCauseList = new ReasonOrCauseEntityController()
									.viewReasonOrCause();

							if (isCancelled()) {
								return null;
							}
							return reasonOrCauseList;

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

				String formName = formPath.context.getMessage("ReasonOrCause", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ReasonOrCause", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.reasonOrCauseDisplayForm(formName, formTitle, task.getValue());
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
		 * End of reasonOrCauseBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of rootCauseBtn.setOnAction(..)
		 *****************************************************/

		rootCauseBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.RootCause", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<RootCause>> task =

					new Task<ObservableList<RootCause>>() {

						@Override
						protected ObservableList<RootCause> call() throws Exception {

							final ObservableList<RootCause> reasonOrCauseList = new RootCauseEntityController()
									.viewRootCause();

							if (isCancelled()) {
								return null;
							}
							return reasonOrCauseList;

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

				String formName = formPath.context.getMessage("RootCause", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.RootCause", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.rootCauseDisplayForm(formName, formTitle, task.getValue());
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
		 * End of rootCauseBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of workActivityBtn.setOnAction(..)
		 *****************************************************/

		workActivityBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.WorkActivity", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<WorkActivity>> task =

					new Task<ObservableList<WorkActivity>>() {

						@Override
						protected ObservableList<WorkActivity> call() throws Exception {

							final ObservableList<WorkActivity> workActivityList = new WorkActivityEntityController()
									.viewWorkActivity();

							if (isCancelled()) {
								return null;
							}
							return workActivityList;

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

				String formName = formPath.context.getMessage("WorkActivity", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.WorkActivity", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.workActivityDisplayForm(formName, formTitle, task.getValue());
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
		 * End of workActivityBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of objectOrsubstanceBtn.setOnAction(..)
		 *****************************************************/

		objectOrsubstanceBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ObjectOrSubstance", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<ObjectOrSubstance>> task =

					new Task<ObservableList<ObjectOrSubstance>>() {

						@Override
						protected ObservableList<ObjectOrSubstance> call() throws Exception {

							final ObservableList<ObjectOrSubstance> objectOrSubstanceList = new ObjectOrSubstanceEntityController()
									.viewObjectOrSubstance();

							if (isCancelled()) {
								return null;
							}
							return objectOrSubstanceList;

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

				String formName = formPath.context.getMessage("ObjectOrSubstance", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ObjectOrSubstance", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.objectOrSubstanceDisplayForm(formName, formTitle, task.getValue());
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
		 * End of objectOrsubstanceBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of deviceBtn.setOnAction(..)
		 *****************************************************/

		deviceBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.DeviceType", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<DeviceType>> task =

					new Task<ObservableList<DeviceType>>() {

						@Override
						protected ObservableList<DeviceType> call() throws Exception {

							final ObservableList<DeviceType> deviceTypeList = new DeviceTypeEntityController()
									.viewSharpDdevice();

							if (isCancelled()) {
								return null;
							}
							return deviceTypeList;

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

				String formName = formPath.context.getMessage("SharpDevice", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.SharpDevice", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.deviceTypeDisplayForm(formName, formTitle, task.getValue());
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
		 * End of deviceBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of manufacturerOrBrandBtn.setOnAction(..)
		 *****************************************************/

		manufacturerOrBrandBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.ManufacturerAndBrand", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<DeviceManufacturerAndBrand>> task =

					new Task<ObservableList<DeviceManufacturerAndBrand>>() {

						@Override
						protected ObservableList<DeviceManufacturerAndBrand> call() throws Exception {

							final ObservableList<DeviceManufacturerAndBrand> deviceManufacturerAndBrandList = new DeviceManufacturerAndBrandEntityontroller()
									.viewSharpDeviceManufacturerAndBrand();

							if (isCancelled()) {
								return null;
							}
							return deviceManufacturerAndBrandList;

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

				String formName = formPath.context.getMessage("ManufacturerAndBrand", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ManufacturerAndBrand", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.manufacturerAndBrandDisplayForm(formName, formTitle, task.getValue());
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
		 * End of manufacturerOrBrandBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of deviceModelBtn.setOnAction(..)
		 *****************************************************/

		deviceModelBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.DeviceModel", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<DeviceModel>> task =

					new Task<ObservableList<DeviceModel>>() {

						@Override
						protected ObservableList<DeviceModel> call() throws Exception {

							final ObservableList<DeviceModel> deviceModelList = new DeviceModelEntityController()
									.viewSharpDeviceModel();

							if (isCancelled()) {
								return null;
							}
							return deviceModelList;

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

				String formName = formPath.context.getMessage("DeviceModel", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.DeviceModel", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.deviceModelDisplayForm(formName, formTitle, task.getValue());
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
		 * End of deviceModelBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of firstResponseBtn.setOnAction(..)
		 *****************************************************/

		firstResponseBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.FirstResponse", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<FirstResponse>> task =

					new Task<ObservableList<FirstResponse>>() {

						@Override
						protected ObservableList<FirstResponse> call() throws Exception {

							final ObservableList<FirstResponse> firstResponseList = new FirstResponseEntityController()
									.viewFirstResponse();

							if (isCancelled()) {
								return null;
							}
							return firstResponseList;

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

				String formName = formPath.context.getMessage("FirstResponse", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.FirstResponse", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.firstResponseDisplayForm(formName, formTitle, task.getValue());
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
		 * End of firstResponseBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of jobCategoryBtn.setOnAction(..)
		 *****************************************************/

		jobCategoryBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.StateJobCategory", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<StateJobCategory>> task =

					new Task<ObservableList<StateJobCategory>>() {

						@Override
						protected ObservableList<StateJobCategory> call() throws Exception {

							final ObservableList<StateJobCategory> stateJobCategoryList = new StateJobCategoryEntityController()
									.viewStateJobCategory();

							if (isCancelled()) {
								return null;
							}
							return stateJobCategoryList;

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

				String formName = formPath.context.getMessage("JobCategory", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.JobCategory", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.stateJobCategoryDisplayForm(formName, formTitle, task.getValue());
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
		 * End of jobCategoryBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of workAreaBtn.setOnAction(..)
		 *****************************************************/

		workAreaBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.StateWorkArea", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<StateWorkArea>> task =

					new Task<ObservableList<StateWorkArea>>() {

						@Override
						protected ObservableList<StateWorkArea> call() throws Exception {

							final ObservableList<StateWorkArea> objectOrSubstanceList = new StateWorkAreaEntityController()
									.viewStateWorkArea();

							if (isCancelled()) {
								return null;
							}
							return objectOrSubstanceList;

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

				String formName = formPath.context.getMessage("WorkArea", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.WorkArea", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.workAreaDisplayForm(formName, formTitle, task.getValue());
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
		 * End of workAreaBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of caseClosedBtn.setOnAction(..)
		 *****************************************************/

		caseClosedBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.CaseClosedReason", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<CaseClosedReason>> task =

					new Task<ObservableList<CaseClosedReason>>() {

						@Override
						protected ObservableList<CaseClosedReason> call() throws Exception {

							final ObservableList<CaseClosedReason> caseClosedReasonList = new CaseClosedReasonStatusEntityController()
									.viewCaseClosedReason();

							if (isCancelled()) {
								return null;
							}
							return caseClosedReasonList;

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

				String formName = formPath.context.getMessage("CaseClosed", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.CaseClosed", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.caseClosedDisplayForm(formName, formTitle, task.getValue());
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
		 * End of caseClosedBtn.setOnAction(..)
		 *************************************************************/

		// Go back to previous nav panel ie SetupAndAdmin nav panel
		closeBtn.setOnAction((event) -> {
			try {
				// Clear from view Current Navigation Panel
				basePane.getChildren().clear();
				// Display SetupAdmin Navigation Panel
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				basePane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
	}

}
