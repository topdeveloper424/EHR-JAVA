package com.ets.utils;



/*
 *Original Author: Indronil Chaudhuri on Behalf of ETS for Client Company
 *File Creation Date: 01-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of FXFormCommonUtilities Class
 *Description: Common Utilities for JavaFX Forms class
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

import java.util.ArrayList;

import com.ets.controller.gui.illnessCode.IllnessCodeViewController;
import com.ets.model.IllnessCode;
import com.ets.controller.gui.billingServiceType.BillingServiceTypeViewController;
import com.ets.controller.gui.bodypart.BodyPartViewController;
import com.ets.controller.gui.bodyzone.BodyZoneViewController;
import com.ets.controller.gui.caseClosedReason.CaseClosedReasonOrStatusViewController;
import com.ets.controller.gui.company.CompanyViewController;
import com.ets.controller.gui.complex.ComplexViewController;
import com.ets.controller.gui.deviceManufacturerAndBrand.DeviceManufacturerAndBrandViewController;
import com.ets.controller.gui.deviceModel.DeviceModelViewController;
import com.ets.controller.gui.deviceType.DeviceTypeViewController;
import com.ets.controller.gui.district.DistrictViewController;
import com.ets.controller.gui.division.DivisionViewController;
import com.ets.controller.gui.exposurecode.ExposureCodeViewController;
import com.ets.controller.gui.firstResponse.FirstResponseViewController;
import com.ets.controller.gui.illnessCode.IllnessCodeViewController;
import com.ets.controller.gui.incidentOrEvent.IncidentOrEventTypeViewController;
import com.ets.controller.gui.injuryCode.InjuryCodeViewController;
import com.ets.controller.gui.medicalCondition.MedicalConditionCodeViewController;
import com.ets.controller.gui.objectOrSubstance.ObjectOrSubstanceViewController;
import com.ets.controller.gui.pharmacy.PharmacyViewController;
import com.ets.controller.gui.reasonOrCause.ReasonOrCauseViewController;
import com.ets.controller.gui.region.RegionViewController;
import com.ets.controller.gui.respiratorModel.RespiratorModelViewController;
import com.ets.controller.gui.rootCause.RootCauseViewController;
import com.ets.controller.gui.severity.ServerityCodeViewController;
import com.ets.controller.gui.stateJobCategory.StateJobCategoryViewController;
import com.ets.controller.gui.stateWorkArea.StateWorkAreaViewController;
import com.ets.controller.gui.supervisor.SupervisorViewController;
import com.ets.controller.gui.visitCategoryGroup.VisitCategoryGroupViewController;
import com.ets.controller.gui.workActivity.WorkActivityViewController;
import com.ets.model.BillingServiceType;
import com.ets.model.BodyPart;
import com.ets.model.BodyZone;
import com.ets.model.CaseClosedReason;
import com.ets.model.Company;
import com.ets.model.Complex;
import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.model.DeviceModel;
import com.ets.model.DeviceType;
import com.ets.model.District;
import com.ets.model.Division;
import com.ets.model.ExposureCode;
import com.ets.model.FirstResponse;
import com.ets.model.IllnessCode;
import com.ets.model.IncidentOrEvent;
import com.ets.model.InjuryCode;
import com.ets.model.MedicalCondition;
import com.ets.model.ObjectOrSubstance;
import com.ets.model.Pharmacy;
import com.ets.model.ReasonOrCause;
import com.ets.model.Region;
import com.ets.model.RespiratorModel;
import com.ets.model.RootCause;
import com.ets.model.SeverityCode;
import com.ets.model.StateJobCategory;
import com.ets.model.StateWorkArea;
import com.ets.model.Supervisor;
import com.ets.model.VisitCategoryGroup;
import com.ets.model.WorkActivity;

import javafx.animation.FadeTransition;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import javafx.collections.ObservableList;
import javafx.scene.control.ProgressBar;

public class FXFormCommonUtilities {

	/*
	 * Display form provided as formName formName : contains relative apth of
	 * the fxml file to load This method has been made non-static since making
	 * it static gives rise to compilation errors with getClass() method call
	 * within the FXMLLoader() constructor
	 *
	 */

	/*public AnchorPane fadeIN(AnchorPane pane){

			FadeTransition ft=new FadeTransition(Duration.seconds(2));
			ft.setNode(pane);
			ft.setFromValue(0.1);
			ft.setToValue(1);
			ft.setCycleCount(1);
			ft.setAutoReverse(false);
			ft.play();
			return pane;

		}
	*/
	
	public void displayHome(String formTitle ) {
		//Object fooController = null;
		
		try {
			// Load Company Details Entry form .
			AnchorPane pane = new AnchorPane();
			FXMLLoader fxmlLoader ;
			fxmlLoader= new FXMLLoader(getClass().getResource("/view/MainWindow.fxml"));
			Parent root1 = (Parent) fxmlLoader.load();
			//fooController = fxmlLoader.getController();
			//root1.getStylesheets().add("/css/style.css");
			//AnchorPane root1 = fxmlLoader.load();
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			//stage.initModality(Modality.WINDOW_MODAL);
			//stage.initOwner(stage.getScene().getWindow());
			 stage.setResizable(false);
			// stage.initStyle(StageStyle.UNDECORATED);
			//stage.initStyle(StageStyle.DECORATED);
			stage.initStyle(StageStyle.UTILITY);
			// May be redundant
			stage.setTitle("Electronic Health Record   "   +Global.clinic.getName());
			stage.setScene(new Scene(root1));
			stage.centerOnScreen();
			//fadeIN(root1);
			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		//return fooController;
	}

	
	
	public Object displayForm( String formName , String formTitle ) {
		Object fooController = null;
		
		try {
			// Load Company Details Entry form .
			AnchorPane pane = new AnchorPane();
			FXMLLoader fxmlLoader ;
			fxmlLoader= new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			fooController = fxmlLoader.getController();
			//root1.getStylesheets().add("/css/style.css");
			//AnchorPane root1 = fxmlLoader.load();
			Stage stage = new Stage();
			 stage.initModality(Modality.APPLICATION_MODAL);
			//stage.initModality(Modality.WINDOW_MODAL);
			//stage.initOwner(stage.getScene().getWindow());
			 stage.setResizable(false);
			// stage.initStyle(StageStyle.UNDECORATED);
			//stage.initStyle(StageStyle.DECORATED);
			stage.initStyle(StageStyle.UTILITY);
			// May be redundant
			stage.setTitle(formTitle);
			stage.setScene(new Scene(root1));
			stage.centerOnScreen();
			//fadeIN(root1);
			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}
	
	public void InjuryCodeDisplayForm( String formName , String formTitle , ObservableList<InjuryCode> injuryCodeList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			InjuryCodeViewController injuryCodeViewController = (InjuryCodeViewController)fxmlLoader.getController();
			injuryCodeViewController.populateInjuryTable(injuryCodeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	
	
	public void ExposureCodeDisplayForm( String formName , String formTitle , ObservableList<ExposureCode> exposureCodeList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			ExposureCodeViewController exposureCodeViewController = (ExposureCodeViewController)fxmlLoader.getController();
			exposureCodeViewController.populateExposureTable(exposureCodeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void bodyPartCodeDisplayForm( String formName , String formTitle , ObservableList<BodyPart> bodyPartCodeList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			BodyPartViewController bodyPartViewController = (BodyPartViewController)fxmlLoader.getController();
			bodyPartViewController.populateBodyPartTable(bodyPartCodeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void bodyZoneCodeDisplayForm( String formName , String formTitle , ObservableList<BodyZone> bodyZoneCodeList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			BodyZoneViewController bodyZoneViewController = (BodyZoneViewController)fxmlLoader.getController();
			bodyZoneViewController.populateBodyZoneTable(bodyZoneCodeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void severityCodeDisplayForm( String formName , String formTitle , ObservableList<SeverityCode> severityCodeList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			ServerityCodeViewController serverityCodeViewController = (ServerityCodeViewController)fxmlLoader.getController();
			serverityCodeViewController.populateSeverityTable(severityCodeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void incidentOrEventDisplayForm( String formName , String formTitle , ObservableList<IncidentOrEvent> incidentOrEventList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 IncidentOrEventTypeViewController incidentOrEventTypeViewController = (IncidentOrEventTypeViewController)fxmlLoader.getController();
			 incidentOrEventTypeViewController.populateIncidentOrEventTable(incidentOrEventList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void reasonOrCauseDisplayForm( String formName , String formTitle , ObservableList<ReasonOrCause> reasonOrCauseList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			ReasonOrCauseViewController reaonOrCausesViewController = (ReasonOrCauseViewController) fxmlLoader.getController();
			reaonOrCausesViewController.populateReasonOrCauseTable(reasonOrCauseList);
			
			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void rootCauseDisplayForm( String formName , String formTitle , ObservableList<RootCause> rootCauseList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 RootCauseViewController rootCauseViewController = (RootCauseViewController)fxmlLoader.getController();
			 rootCauseViewController.populateRootCauseTable(rootCauseList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void workActivityDisplayForm( String formName , String formTitle , ObservableList<WorkActivity> workActivityList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			WorkActivityViewController workActivityViewController  = (WorkActivityViewController)fxmlLoader.getController();
			workActivityViewController.populateWorkActivityTable(workActivityList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void objectOrSubstanceDisplayForm( String formName , String formTitle , ObservableList<ObjectOrSubstance> objectOrSubstanceList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 ObjectOrSubstanceViewController objectOrSubstanceViewController = (ObjectOrSubstanceViewController)fxmlLoader.getController();
			 objectOrSubstanceViewController.populateObjectOrSubstanceTable(objectOrSubstanceList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deviceTypeDisplayForm( String formName , String formTitle , ObservableList<DeviceType> deviceTypeList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 DeviceTypeViewController deviceTypeViewController = (DeviceTypeViewController)fxmlLoader.getController();
			 deviceTypeViewController.populateDeviceTypeTable(deviceTypeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void manufacturerAndBrandDisplayForm( String formName , String formTitle , ObservableList<DeviceManufacturerAndBrand> deviceManufacturerAndBrandList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 DeviceManufacturerAndBrandViewController deviceManufacturerAndBrandViewController = (DeviceManufacturerAndBrandViewController)fxmlLoader.getController();
			 deviceManufacturerAndBrandViewController.populateDeviceManufacturerAndBrandTable(deviceManufacturerAndBrandList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void deviceModelDisplayForm( String formName , String formTitle , ObservableList<DeviceModel> deviceModelList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 DeviceModelViewController deviceModelViewController = (DeviceModelViewController)fxmlLoader.getController();
			 deviceModelViewController.populateDeviceModelTable(deviceModelList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void firstResponseDisplayForm( String formName , String formTitle , ObservableList<FirstResponse> firstResponseList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 FirstResponseViewController firstResponseViewController = (FirstResponseViewController)fxmlLoader.getController();
			 firstResponseViewController.populateFirstResponseTable(firstResponseList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void stateJobCategoryDisplayForm( String formName , String formTitle , ObservableList<StateJobCategory> stateJobCategoryList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 StateJobCategoryViewController stateJobCategoryViewController = (StateJobCategoryViewController)fxmlLoader.getController();
			 stateJobCategoryViewController.populateStateJobCategoryTable(stateJobCategoryList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void workAreaDisplayForm( String formName , String formTitle , ObservableList<StateWorkArea> stateWorkAreaList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 StateWorkAreaViewController stateWorkAreaViewController = (StateWorkAreaViewController)fxmlLoader.getController();
			 stateWorkAreaViewController.populateStateWorkAreaTable(stateWorkAreaList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public void caseClosedDisplayForm( String formName , String formTitle , ObservableList<CaseClosedReason> caseClosedReasonList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			CaseClosedReasonOrStatusViewController closedReasonOrStatusViewController = (CaseClosedReasonOrStatusViewController)fxmlLoader.getController();
			closedReasonOrStatusViewController.populateCaseClosedReasonTable(caseClosedReasonList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
	public void divisionDisplayForm( String formName , String formTitle , ObservableList<Division> divisionList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			 DivisionViewController viewAllDivisionGUIController = (DivisionViewController)fxmlLoader.getController();
			 viewAllDivisionGUIController.populateDivisionTable(divisionList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void supervisorDisplayForm( String formName , String formTitle , ObservableList<Supervisor> supervisorList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			  SupervisorViewController viewAllSupervisorGUIController = (SupervisorViewController)fxmlLoader.getController();
			  viewAllSupervisorGUIController.populateSupervisorTable(supervisorList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	
	public Object regionDisplayForm( String formName , String formTitle , ObservableList<Region> regionList ) {
		Object fooController = null;
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			
			fooController = (Object) fxmlLoader.getController();
			  RegionViewController viewAllRegionGUIController = (RegionViewController)fxmlLoader.getController();
			  viewAllRegionGUIController.populateRegionTable(regionList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}

	
	public Object districtDisplayForm( String formName , String formTitle , ObservableList<District> districtList ) {
		
		Object fooController = null;
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			fooController = (Object) fxmlLoader.getController();
			  DistrictViewController viewAllDistrictGUIController = (DistrictViewController)fxmlLoader.getController();
			  viewAllDistrictGUIController.populateDistrictTable(districtList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}

	
	public Object complexDisplayForm( String formName , String formTitle , ObservableList<Complex> complexList ) {
		
		Object fooController = null;
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			fooController = (Object) fxmlLoader.getController();
			  ComplexViewController complexViewController = (ComplexViewController)fxmlLoader.getController();
			  complexViewController.populateComplexTable(complexList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}

	
	public void pharmacyDisplayForm( String formName , String formTitle , ObservableList<Pharmacy> pharmacyList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			   PharmacyViewController viewAllPharmacyGUIController = (PharmacyViewController)fxmlLoader.getController();
			   viewAllPharmacyGUIController.populatePharmacyTable(pharmacyList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	/*public void companyDisplayForm( String formName , String formTitle , ObservableList<Company> companyList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			
			    CompanyViewController viewAllCompanyController = (CompanyViewController)fxmlLoader.getController();
			    viewAllCompanyController.populateCompanyTable(companyList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}*/
	
public Object companyDisplayForm( String formName , String formTitle , ObservableList<Company> companyList ) {
		
		Object fooController = null;
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			fooController = (Object) fxmlLoader.getController();
			    CompanyViewController viewAllCompanyController = (CompanyViewController)fxmlLoader.getController();
			    viewAllCompanyController.populateCompanyTable(companyList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}
	
	public void medicalConditionDisplayForm( String formName , String formTitle , ObservableList<MedicalCondition> medicalConditionList ) {
		
		
		
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			     MedicalConditionCodeViewController selectMedicalConditionCodeController = (MedicalConditionCodeViewController)fxmlLoader.getController();
			     selectMedicalConditionCodeController.populateMedicalConditionTable(medicalConditionList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
	}
	
public Object medicalConditionDisplayForm2( String formName , String formTitle , ObservableList<MedicalCondition> medicalConditionList ) {
		
		Object fooController = null;
		
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
				fooController = (Object) fxmlLoader.getController();
			     MedicalConditionCodeViewController selectMedicalConditionCodeController = (MedicalConditionCodeViewController)fxmlLoader.getController();
			     selectMedicalConditionCodeController.populateMedicalConditionTable(medicalConditionList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}
	
	public void respiratorModelDisplayForm( String formName , String formTitle , ObservableList<RespiratorModel> respiratorModelList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			     RespiratorModelViewController respiratorModelViewController = (RespiratorModelViewController)fxmlLoader.getController();
			     respiratorModelViewController.populateRespiratorModelTable(respiratorModelList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void visitCategoryGroupDisplayForm( String formName , String formTitle , ObservableList<VisitCategoryGroup> visitCategoryGroupList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			     VisitCategoryGroupViewController visitCategoryGroupViewController = (VisitCategoryGroupViewController)fxmlLoader.getController();
			     visitCategoryGroupViewController.populateVisitCategoryGroupTable(visitCategoryGroupList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	
public Object billingServiceTypeDisplayForm( String formName , String formTitle , ObservableList<BillingServiceType> billingServiceTypeList ) {
		
		Object fooController = null;
		
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
				fooController = (Object) fxmlLoader.getController();		
			
			     BillingServiceTypeViewController billingServiceTypeController  = (BillingServiceTypeViewController)fxmlLoader.getController();
			     billingServiceTypeController.populateMedicalConditionTable(billingServiceTypeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		
		return fooController;
	}
	

	

	public void displayForm( String formName , String formTitle , ObservableList<IllnessCode> illnessCodeList ) {
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			IllnessCodeViewController illnessCodeViewController = (IllnessCodeViewController)fxmlLoader.getController();
			illnessCodeViewController.populateIllnessTable(illnessCodeList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	

	public Object displayFormAndReturnCtrl( String formName , String formTitle ) {
		
		Object fooController = null;
		
		try {
			// Load Company Details Entry form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			
			fooController = (Object) fxmlLoader.getController();
			//root1.getStylesheets().add("/css/style.css");
			//AnchorPane root1 = fxmlLoader.load();
			Stage stage = new Stage();
			// stage.initModality(Modality.APPLICATION_MODAL);
			stage.initModality(Modality.APPLICATION_MODAL);
			// stage.initStyle(StageStyle.UNDECORATED);
			//stage.initStyle(StageStyle.DECORATED);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			// May be redundant
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));
			//fadeIN(root1);
			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}
	

	public Object divisionDisplayForm2( String formName , String formTitle , ObservableList<Division> divisionList ) {
		
		Object fooController = null;
		
		try {
			// Load  form .
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();
			/*
			 * Please Note : You first have to run loader.load() then you can get the Controller.
			 * in our case the loader is named fxmlLoader . Otherwise it does not work . The
			 * sequence is very important .
			*/
			fooController = (Object) fxmlLoader.getController();
			 DivisionViewController viewAllDivisionGUIController = (DivisionViewController)fxmlLoader.getController();
			 viewAllDivisionGUIController.populateDivisionTable(divisionList);

			//root1.getStylesheets().add("/css/style.css");
			Stage stage = new Stage();
			stage.initModality(Modality.APPLICATION_MODAL);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));

			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		
		return fooController;
	}

	

	public Object displayFormAndGetController( String formName , String formTitle ) {
		FXMLLoader fxmlLoader = null;
		try {
			fxmlLoader = new FXMLLoader(getClass().getResource(formName));
			Parent root1 = (Parent) fxmlLoader.load();

			//root1.getStylesheets().add("/css/style.css");
			//AnchorPane root1 = fxmlLoader.load();
			Stage stage = new Stage();
			// stage.initModality(Modality.APPLICATION_MODAL);
			stage.initModality(Modality.APPLICATION_MODAL);
			// stage.initStyle(StageStyle.UNDECORATED);
			//stage.initStyle(StageStyle.DECORATED);
			stage.initStyle(StageStyle.UTILITY);
			stage.setResizable(false);
			// May be redundant
			stage.setTitle(formTitle);
			stage.centerOnScreen();
			stage.setScene(new Scene(root1));
			//fadeIN(root1);
			stage.show();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return fxmlLoader.getController();
	}

	/*
	 * Get the controller of the fxml form pointed to by the  "formName" argument .
	 * The argument contains the relative path of the fxml file which has been already
	 * included in this project
	 */

	public  Object getController( String formName  )	{
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(formName));
		return fxmlLoader.getController();
	}
	/*
	 * Substitute current left Navigation Panel with new Navigation Panel
	 * dated 01-02-2016 @ Author Indronil Chaudhuri
	 */

	public void changeLeftNavPanel()	{

	}

	/*
	 * Close current window , centralised code
	 * triggeringButton is the name or id of the cancel button
	 * or what ever name the cancel button is named .
	 *
	 */
	
	public void closeForm( Button triggeringButton  ) {
		// Get a handle to the stage
		Stage stage = ( Stage ) triggeringButton.getScene().getWindow();

		// Close
		stage.close();
	}

	// Over Loaded method
	public void closeForm( ProgressBar progressBar  ) {
		// Get a handle to the stage
		Stage stage = ( Stage ) progressBar.getScene().getWindow();
		// Close form
		stage.close();
	}
}
