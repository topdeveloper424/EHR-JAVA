package com.ets.controller.navpanel;



import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.controller.entity.complex.ComplexEntityController;
import com.ets.controller.entity.district.DistrictEntityController;
import com.ets.controller.entity.division.DivisionEntityController;
import com.ets.controller.entity.region.RegionEntityController;
import com.ets.controller.entity.supervisor.SupervisorEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Complex;
import com.ets.model.District;
import com.ets.model.Division;
import com.ets.model.Region;
import com.ets.model.Supervisor;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
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

/**

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of OrganizationGUIController Class
 *Description: Organization.fxml Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner: Sumanta Deyashi
 *Date: 15-02-2016
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */

public class OrganisationGUIController implements Initializable {

	@FXML
	private AnchorPane basePane;

	@FXML
	private Button ediDestinationBtn;

	@FXML
	private Button planBtn;

	@FXML
	private Button divisionBtn;

	@FXML
	private Button deptUnitBtn;

	@FXML
	private Button jobClassBtn;

	@FXML
	private Button workLocationBtn;

	@FXML
	private Button supervisorBtn;

	@FXML
	private Button parentEmpBtn;

	@FXML
	private Button jobOrLocationRiskBtn;

	@FXML
	private Button regionBtn;

	@FXML
	private Button districtBtn;

	@FXML
	private Button complexBtn;

	@FXML
	private Button companyBtn;

	@FXML
	private Button closeBtn;
	
	@FXML
    void enterKeyPressedForCloseButton(KeyEvent event) {
		
		if(event.getCode() == KeyCode.ENTER){
			
			try {
				
				basePane.getChildren().clear();
			
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				basePane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}


		}

    }

    @FXML
    void enterKeyPressedForCompanyButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load Company Code Details Entry form .

			String formName = formPath.context.getMessage("Company", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);


    	}

    }

    @FXML
    void enterKeyPressedForComplexButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Complex", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Complex>> task =

					new Task<ObservableList<Complex>>() {

						@Override
						protected ObservableList<Complex> call() throws Exception {

							final ObservableList<Complex> complexList = new ComplexEntityController().viewComplex();

							if (isCancelled()) {
								return null;
							}
							return complexList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Complex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Complex", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.complexDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForDepartmentUnitButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName = formPath.context.getMessage("DepartmentUnitView", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.DepartmentUnitView", null, Locale.US);
			formPath.closeApplicationContext();

			new FXFormCommonUtilities().displayForm(formName, formTitle);


    	}

    }

    @FXML
    void enterKeyPressedForDistrictButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.District", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<District>> task =

					new Task<ObservableList<District>>() {

						@Override
						protected ObservableList<District> call() throws Exception {

							final ObservableList<District> districtList = new DistrictEntityController().viewDistrict();

							if (isCancelled()) {
								return null;
							}
							return districtList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("District", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.District", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.districtDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForDivisionButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Division", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Division>> task =

					new Task<ObservableList<Division>>() {

						@Override
						protected ObservableList<Division> call() throws Exception {
	//ObservableList<Division> foundDivisions =FXCollections.<Division>observableArrayList();
							final ObservableList<Division> divisionList = new DivisionEntityController().viewDivision();

							if (isCancelled()) {
								return null;
							}
							
							/* for (int i = 0; i < divisionList.size(); i++) {
				                    Thread.sleep(800);
				                    updateProgress(i + 1, divisionList.size());
				                    Division nextFriend = divisionList.get(i);
				                    foundDivisions.add(nextFriend);
				                    //updateMessage("Finding friends . . . found " + nextFriend);
				                }
				              Thread.sleep(800);*/
				              
							return divisionList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Division", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Division", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.divisionDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
			
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}



    	}

    }

    @FXML
    void enterKeyPressedForJobClassButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load Job Class Code Details Entry form .

			String formName = formPath.context.getMessage("JobClass", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.JobClass", null, Locale.US);
			formPath.closeApplicationContext();
			new FXFormCommonUtilities().displayForm(formName, formTitle);


    	}

    }

    @FXML
    void enterKeyPressedForRegionButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Region", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Region>> task =

					new Task<ObservableList<Region>>() {

						@Override
						protected ObservableList<Region> call() throws Exception {

							final ObservableList<Region> regionList = new RegionEntityController().viewRegion();

							if (isCancelled()) {
								return null;
							}
							return regionList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Region", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Region", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.regionDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
			
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}



    	}

    }

    @FXML
    void enterKeyPressedForSupervisorButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Supervisor", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Supervisor>> task =

					new Task<ObservableList<Supervisor>>() {

						@Override
						protected ObservableList<Supervisor> call() throws Exception {

							final ObservableList<Supervisor> supervisorList = new SupervisorEntityController()
									.viewSupervisor();

							if (isCancelled()) {
								return null;
							}
							return supervisorList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Supervisor", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Supervisor", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.supervisorDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
			
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}


    	}

    }

    @FXML
    void enterKeyPressedForWorkLocationButton(KeyEvent event) {
    	
    	if(event.getCode() == KeyCode.ENTER){
    		
    		// Load Work Location Code Details Entry form .

			String formName = formPath.context.getMessage("WorkLocation", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.WorkLocation", null, Locale.US);
			formPath.closeApplicationContext();
			
			new FXFormCommonUtilities().displayForm(formName, formTitle);


    	}

    }

	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		/*************************************
		 * Start of divisionBtn.setOnAction(..)
		 *****************************************************/

		divisionBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Division", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Division>> task =

					new Task<ObservableList<Division>>() {

						@Override
						protected ObservableList<Division> call() throws Exception {
	//ObservableList<Division> foundDivisions =FXCollections.<Division>observableArrayList();
							final ObservableList<Division> divisionList = new DivisionEntityController().viewDivision();

							if (isCancelled()) {
								return null;
							}
							
							/* for (int i = 0; i < divisionList.size(); i++) {
				                    Thread.sleep(800);
				                    updateProgress(i + 1, divisionList.size());
				                    Division nextFriend = divisionList.get(i);
				                    foundDivisions.add(nextFriend);
				                    //updateMessage("Finding friends . . . found " + nextFriend);
				                }
				              Thread.sleep(800);*/
				              
							return divisionList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Division", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Division", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.divisionDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
			
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of divisionBtn.setOnAction(..)
		 *************************************************************/

		deptUnitBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("DepartmentUnitView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.DepartmentUnitView", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		jobClassBtn.setOnAction((event) -> {
			try {
				// Load Job Class Code Details Entry form .

				String formName = formPath.context.getMessage("JobClass", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.JobClass", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		workLocationBtn.setOnAction((event) -> {
			try {
				// Load Work Location Code Details Entry form .

				String formName = formPath.context.getMessage("WorkLocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.WorkLocation", null, Locale.US);
				formPath.closeApplicationContext();
				
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		/*************************************
		 * Start of supervisorBtn.setOnAction(..)
		 *****************************************************/

		supervisorBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Supervisor", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Supervisor>> task =

					new Task<ObservableList<Supervisor>>() {

						@Override
						protected ObservableList<Supervisor> call() throws Exception {

							final ObservableList<Supervisor> supervisorList = new SupervisorEntityController()
									.viewSupervisor();

							if (isCancelled()) {
								return null;
							}
							return supervisorList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Supervisor", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Supervisor", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.supervisorDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
			
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of supervisorBtn.setOnAction(..)
		 *************************************************************/

		/*parentEmpBtn.setOnAction((event) -> {
			try {
				// Load Corporate Parent Employer Code Details Entry form .

				String formName = formPath.context.getMessage("ParentEmployerGroup", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ParentEmployerGroup", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*jobOrLocationRiskBtn.setOnAction((event) -> {
			try {

				String formName = formPath.context.getMessage("JobOrLocation", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.JobOrLocation", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});*/

		/*************************************
		 * Start of regionBtn.setOnAction(..)
		 *****************************************************/

		regionBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Region", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Region>> task =

					new Task<ObservableList<Region>>() {

						@Override
						protected ObservableList<Region> call() throws Exception {

							final ObservableList<Region> regionList = new RegionEntityController().viewRegion();

							if (isCancelled()) {
								return null;
							}
							return regionList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Region", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Region", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.regionDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
			
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of regionBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of districtBtn.setOnAction(..)
		 *****************************************************/

		districtBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.District", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<District>> task =

					new Task<ObservableList<District>>() {

						@Override
						protected ObservableList<District> call() throws Exception {

							final ObservableList<District> districtList = new DistrictEntityController().viewDistrict();

							if (isCancelled()) {
								return null;
							}
							return districtList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("District", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.District", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.districtDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of districtBtn.setOnAction(..)
		 *************************************************************/

		/*************************************
		 * Start of complexBtn.setOnAction(..)
		 *****************************************************/

		complexBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.Complex", null, Locale.US);
			formPath.closeApplicationContext();

			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			/********************************
			 * Start of Task definition
			 *****************************************************************/
			Task<ObservableList<Complex>> task =

					new Task<ObservableList<Complex>>() {

						@Override
						protected ObservableList<Complex> call() throws Exception {

							final ObservableList<Complex> complexList = new ComplexEntityController().viewComplex();

							if (isCancelled()) {
								return null;
							}
							return complexList;

						}
					};
			/*************************
			 * End of Task definition
			 *****************************************************************/

			task.setOnSucceeded(event1 -> {

				System.out.println("With in success.");
				
				Stage stage = (Stage) progressBarGUIController.getProgressBar().getScene().getWindow();
				stage.close();

				String formName = formPath.context.getMessage("Complex", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Complex", null, Locale.US);
				formPath.closeApplicationContext();

				FXFormCommonUtilities formDisplayer = new FXFormCommonUtilities();
				try {
					formDisplayer.complexDisplayForm(formName, formTitle, task.getValue());
				} catch (Exception e) {
					e.printStackTrace();
				}

			});

			progressBar.progressProperty().bind(task.progressProperty());

			try {
				
				new Thread(task).start();
			} catch (Exception e) {
				e.printStackTrace();
			}

		});
		/*************************************
		 * End of complexBtn.setOnAction(..)
		 *************************************************************/

		companyBtn.setOnAction((event) -> {
			try {
				// Load Company Code Details Entry form .

				String formName = formPath.context.getMessage("Company", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.Company", null, Locale.US);
				formPath.closeApplicationContext();
				new FXFormCommonUtilities().displayForm(formName, formTitle);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

		// Go back to previous nav panel ie Entity Table nav panel.
		closeBtn.setOnAction((event) -> {
			try {
			
				basePane.getChildren().clear();
			
				String formName = formPath.context.getMessage("SetupAdmin", null, Locale.US);
				formPath.closeApplicationContext();
				basePane.getChildren().add(FXMLLoader.load(getClass().getResource(formName)));

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
