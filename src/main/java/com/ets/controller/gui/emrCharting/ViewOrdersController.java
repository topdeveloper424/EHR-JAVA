package com.ets.controller.gui.emrCharting;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.pharmacy.PharmacyEntityController;
import com.ets.controller.gui.appointment.schedule.ScheduleController;
import com.ets.controller.mainWindowGUIController.HomePanelController;
import com.ets.model.Pharmacy;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.model.Patient;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.CheckBox;


public class ViewOrdersController implements Initializable {

	@FXML
    private TextField templateText;

    @FXML
    private Button templateBtn;

    @FXML
    private TextField arrivalTimeText;

    @FXML
    private Button arrivalTimeBtn;

    @FXML
    private ChoiceBox<?> meansOfArrivalBtn;

    @FXML
    private TextField clinicianInText;

    @FXML
    private Button clinicianInBtn;

    @FXML
    private TextField providerInText;

    @FXML
    private Button providerInBtn;

    @FXML
    private TextField dateOfJurnyText;

    @FXML
    private TextField clinicianOutText;

    @FXML
    private TextField providerOutText;

    @FXML
    private RadioButton tbdNAradioBtn1;

    @FXML
    private RadioButton newText;

    @FXML
    private RadioButton estabText;

    @FXML
    private RadioButton consultText;

    @FXML
    private RadioButton preventtext;

    @FXML
    private RadioButton telePhoneText;

    @FXML
    private RadioButton tbdNAradiobtn2;

    @FXML
    private RadioButton level1Text;

    @FXML
    private RadioButton level2Text;

    @FXML
    private RadioButton level3Text;

    @FXML
    private RadioButton level4Text;

    @FXML
    private RadioButton level5Text;

    @FXML
    private CheckBox twoPatientIdentificationVerifiedText;

    @FXML
    private Button recordVitalsText;

    @FXML
    private Button graphVitalsText;

    @FXML
    private Button expandedViewBtn;

    @FXML
    private Button allPatientHistoryBtn;

    @FXML
    private Button abcBtn;

    @FXML
    private Button demographicsBtn;

    @FXML
    private Button viewChartBtn;

    @FXML
    private Button pastNotesbtn;

    @FXML
    private Button appoinmentBtn;

    @FXML
    private Button ordersBtn;

    @FXML
    private Button prescriptionsBtn;

    @FXML
    private Button referralsBtn;

    @FXML
    private Button chargesBtn;

    @FXML
    private Button codeTBDbtn;

    @FXML
    private Button codeEMbtn;

    @FXML
    private Button buildNoteBtn;

    @FXML
    private Button auditBtn;

    @FXML
    private Button imagesBtn;

    @FXML
    private Button formsBtn;

    @FXML
    private Button reportBtn;

    @FXML
    private Button reviewBtn;

    @FXML
    private Button doneBtn;
    
    FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ordersBtn.setOnAction((event) -> {

			try {

				String formName = formPath.context.getMessage("OrdersView", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.OrdersView", null, Locale.US);
				formPath.closeApplicationContext();

				new FXFormCommonUtilities().displayForm(formName, formTitle);
			} catch (Exception ex) {
				ex.printStackTrace();
			}

		});
		
	}

}
