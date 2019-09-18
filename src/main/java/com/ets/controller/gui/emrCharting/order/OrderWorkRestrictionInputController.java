package com.ets.controller.gui.emrCharting.order;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.order.consult.ConsultErTransferInputController;
import com.ets.controller.gui.emrCharting.order.consult.ConsultPcpUcInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.BendingTwistingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.ClimbingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.DrivingAndRidingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.ElbowFlexionInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.ElevationOfArmInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.ElevationOfRestrictionInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.FlyingRestrictionInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.FootControlsInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.FootUsageInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.HandGraspInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.HandUsageInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.KneelingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.LiftingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.LiftingPoundsInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.OtherLimitationsInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.PullingNoneInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.PullingPoundsInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.PushingPoundsInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.ReachingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.SchoolExcuseUConlyInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.ShoulderUsageInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.SittingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.SquattingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.StreachBreakInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.WalkingStandingInputController;
import com.ets.controller.gui.emrCharting.order.workRestriction.WorkExcuseUConlyInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class OrderWorkRestrictionInputController implements Initializable {
	
	  @FXML
	    private CheckBox WorkBendingCheck;

	    @FXML
	    private CheckBox WorkClimbingCheck;

	    @FXML
	    private CheckBox WorkElbow;

	    @FXML
	    private CheckBox WorkFootControls;

	    @FXML
	    private CheckBox WorkFootUsage;

	    @FXML
	    private CheckBox WorkHandGrasp;

	    @FXML
	    private CheckBox WorkHandUsage;

	    @FXML
	    private CheckBox WorkKneeling;

	    @FXML
	    private CheckBox WorkliftingNone;

	    @FXML
	    private CheckBox WorkPullingNone;

	    @FXML
	    private CheckBox WorkReaching;

	    @FXML
	    private CheckBox WorkShoulderUsage;

	    @FXML
	    private CheckBox WorkSitting;

	    @FXML
	    private CheckBox WorkSquatting;

	    @FXML
	    private CheckBox WorkWalking;

	    @FXML
	    private CheckBox WorkFlyingRestriction;

	    @FXML
	    private CheckBox WorkElevationofArm;

	    @FXML
	    private CheckBox WorkOfLeg;

	    @FXML
	    private CheckBox WorkSedentary;

	    @FXML
	    private CheckBox WorkStrech;

	    @FXML
	    private CheckBox WorkOtherLimitation;

	    @FXML
	    private CheckBox WorkWorkExecuse;

	    @FXML
	    private CheckBox WorkSchoolExcuse;

	    @FXML
	    private CheckBox WorkDriving;

	    @FXML
	    private CheckBox WorkAnalgesics;

	    @FXML
	    private CheckBox WorkLiftingPound;

	    @FXML
	    private CheckBox WorkPullingSpecific;

	    @FXML
	    private CheckBox WorkPushingNone;

	    @FXML
	    private CheckBox WorkPushingPounds;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;
	    
	    private Button button;
	    
 		public GenericEMRChartingController genericEMRChartingController;
 	    
 	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
 			this.genericEMRChartingController = genericEMRChartingController;
 			this.button = button;
 		}
 	    
 	    
 	   FXMLFormPath formPath = new FXMLFormPath();

 		public static Integer formCount = 0;

 		private Integer secondFormCount = 0;

 		public static String str = "\n\n";


 		void formCountIncrement() {
 			++secondFormCount;
 		}
 		
 		public void setWorkRestrictionUI(){
 			
 			if(WorkBendingCheck.isSelected()){
 				
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionBendingTwisting", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				BendingTwistingInputController bendingTwistingInputController = (BendingTwistingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				bendingTwistingInputController.setOrderWorkRestrictionInputController(this);

 				WorkBendingCheck.setSelected(false);
 				
 			}else if (WorkClimbingCheck.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionClimbing", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				ClimbingInputController climbingInputController = (ClimbingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				climbingInputController.setOrderWorkRestrictionInputController(this);

 				WorkClimbingCheck.setSelected(false);

 			}else if (WorkElbow.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionElbowFlexion", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				ElbowFlexionInputController elbowFlexionInputController = (ElbowFlexionInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				elbowFlexionInputController.setOrderWorkRestrictionInputController(this);

 				WorkElbow.setSelected(false);

 			}else if (WorkFootControls.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionFootControls", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				FootControlsInputController footControlsInputController = (FootControlsInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				footControlsInputController.setOrderWorkRestrictionInputController(this);

 				WorkFootControls.setSelected(false);

 			}else if (WorkFootUsage.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionFootUsage", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				FootUsageInputController footUsageInputController = (FootUsageInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				footUsageInputController.setOrderWorkRestrictionInputController(this);

 				WorkFootUsage.setSelected(false);

 			}else if (WorkHandGrasp.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionHandGrasp", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				HandGraspInputController handGraspInputController = (HandGraspInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				handGraspInputController.setOrderWorkRestrictionInputController(this);

 				WorkHandGrasp.setSelected(false);

 			}else if (WorkHandUsage.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionHandUsage", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				HandUsageInputController handUsageInputController = (HandUsageInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				handUsageInputController.setOrderWorkRestrictionInputController(this);

 				WorkHandUsage.setSelected(false);

 			}else if (WorkKneeling.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionKneeling", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				KneelingInputController kneelingInputController = (KneelingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				kneelingInputController.setOrderWorkRestrictionInputController(this);

 				WorkKneeling.setSelected(false);

 			}else if (WorkliftingNone.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionLifting", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				LiftingInputController liftingInputController = (LiftingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				liftingInputController.setOrderWorkRestrictionInputController(this);

 				WorkliftingNone.setSelected(false);

 			}else if (WorkLiftingPound.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionLiftingPounds", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				LiftingPoundsInputController liftingPoundsInputController = (LiftingPoundsInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				liftingPoundsInputController.setOrderWorkRestrictionInputController(this);

 				WorkLiftingPound.setSelected(false);

 			}else if (WorkPullingNone.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionPullingNone", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				PullingNoneInputController pullingNoneInputController = (PullingNoneInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				pullingNoneInputController.setOrderWorkRestrictionInputController(this);

 				WorkPullingNone.setSelected(false);

 			}else if (WorkPullingSpecific.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionPullingPounds", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				PullingPoundsInputController pullingPoundsInputController = (PullingPoundsInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				pullingPoundsInputController.setOrderWorkRestrictionInputController(this);

 				WorkPullingSpecific.setSelected(false);

 			}else if (WorkPushingNone.isSelected()) {
 				StringBuilder str1 = new StringBuilder(str);
 				str1.append("No pushing with either arm.");
 				str = str1.toString();
 				WorkPushingNone.setSelected(false);

 				setWorkRestrictionUI();

 			}else if (WorkPushingPounds.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionPushingPounds", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				PushingPoundsInputController pushingPoundsInputController = (PushingPoundsInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				pushingPoundsInputController.setOrderWorkRestrictionInputController(this);

 				WorkPushingPounds.setSelected(false);

 			}else if (WorkReaching.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionReaching", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				ReachingInputController reachingInputController = (ReachingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				reachingInputController.setOrderWorkRestrictionInputController(this);

 				WorkReaching.setSelected(false);

 			}else if (WorkShoulderUsage.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionShoulderUsage", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				ShoulderUsageInputController shoulderUsageInputController = (ShoulderUsageInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				shoulderUsageInputController.setOrderWorkRestrictionInputController(this);

 				WorkShoulderUsage.setSelected(false);

 			}else if (WorkSitting.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionSitting", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				SittingInputController sittingInputController = (SittingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				sittingInputController.setOrderWorkRestrictionInputController(this);

 				WorkSitting.setSelected(false);

 			}else if (WorkSquatting.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionSquatting", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				SquattingInputController squattingInputController = (SquattingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				squattingInputController.setOrderWorkRestrictionInputController(this);

 				WorkSquatting.setSelected(false);

 			}else if (WorkWalking.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionWalkingStanding", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				WalkingStandingInputController walkingStandingInputController = (WalkingStandingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				walkingStandingInputController.setOrderWorkRestrictionInputController(this);

 				WorkWalking.setSelected(false);

 			}else if (WorkDriving.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionDrivingAndRiding", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				DrivingAndRidingInputController drivingAndRidingInputController = (DrivingAndRidingInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				drivingAndRidingInputController.setOrderWorkRestrictionInputController(this);

 				WorkDriving.setSelected(false);

 			}else if (WorkFlyingRestriction.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionFlyingRestriction", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				FlyingRestrictionInputController flyingRestrictionInputController = (FlyingRestrictionInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				flyingRestrictionInputController.setOrderWorkRestrictionInputController(this);

 				WorkFlyingRestriction.setSelected(false);

 			}else if (WorkElevationofArm.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionElevationOfArm", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				ElevationOfArmInputController elevationOfArmInputController = (ElevationOfArmInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				elevationOfArmInputController.setOrderWorkRestrictionInputController(this);

 				WorkElevationofArm.setSelected(false);

 			}else if (WorkOfLeg.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionElevationOfLeg", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				ElevationOfRestrictionInputController elevationOfRestrictionInputController = (ElevationOfRestrictionInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				elevationOfRestrictionInputController.setOrderWorkRestrictionInputController(this);

 				WorkOfLeg.setSelected(false);

 			}else if (WorkSedentary.isSelected()) {
 				StringBuilder str1 = new StringBuilder(str);
 				str1.append("Restricted to sedentary work.");
 				str = str1.toString();
 				WorkSedentary.setSelected(false);

 				setWorkRestrictionUI();

 			}else if (WorkStrech.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionStreachBreak", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				StreachBreakInputController streachBreakInputController = (StreachBreakInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				streachBreakInputController.setOrderWorkRestrictionInputController(this);

 				WorkStrech.setSelected(false);

 			}else if (WorkOtherLimitation.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionOtherLimitations", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				OtherLimitationsInputController limitationsInputController  = (OtherLimitationsInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				limitationsInputController.setOrderWorkRestrictionInputController(this);

 				WorkOtherLimitation.setSelected(false);

 			}else if (WorkWorkExecuse.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionWorkExcuseUConly", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				WorkExcuseUConlyInputController workExcuseUConlyInputController = (WorkExcuseUConlyInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				workExcuseUConlyInputController.setOrderWorkRestrictionInputController(this);

 				WorkWorkExecuse.setSelected(false);

 			}else if (WorkSchoolExcuse.isSelected()) {
 				formCountIncrement();
 				String formName = formPath.context.getMessage("OrderWorkRestrictionSchoolExcuseUConly", null, Locale.US);

 				String formTitle1 = formPath.context.getMessage("Title.CommonFormTitle", null, Locale.US);

 				String formTitle2 = null;
 				String formTitle3 = null;
 				String formTitle4 = null;

 				if (Global.patient != null) {

 					formTitle2 = Global.patient.getPatientName().getFirstName();
 					formTitle3 = Global.patient.getPatientName().getMiddleName();
 					formTitle4 = Global.patient.getPatientName().getLastName();

 				}
 				String formTitle = formTitle1 + " " + "(" + formTitle2 + " " + formTitle3 + " " + formTitle4 + ")";
 				formPath.closeApplicationContext();

 				SchoolExcuseUConlyInputController schoolExcuseUConlyInputController = (SchoolExcuseUConlyInputController) new FXFormCommonUtilities()
 						.displayForm(formName, formTitle);
 				schoolExcuseUConlyInputController.setOrderWorkRestrictionInputController(this);

 				WorkSchoolExcuse.setSelected(false);

 			}
 			
 			
 			
 			else if (secondFormCount == formCount) {

 				genericEMRChartingController.paint(button);

 				formCount = 0;
 				genericEMRChartingController.setOrderTextArea(str);
 				genericEMRChartingController.saveAllTextArea();
 				new FXFormCommonUtilities().closeForm(doneBtn);

 			}
 			
 			
 		}
 	    

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			setWorkRestrictionUI();
			

		});
		skipBtn.setOnAction((event) -> {

			new FXFormCommonUtilities().closeForm(skipBtn);

		});
		
	}

}
