package com.ets.controller.gui.billingPanel;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.patientBillingInvoice.PatientBillingInvoiceEntityController;
import com.ets.model.PatientBillingInvoice;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;

public class SelectChargesByDateInputController implements Initializable {
	
	  @FXML
	    private DatePicker fromDate;

	    @FXML
	    private DatePicker thurDate;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button cancelBtn;
	    
	    FXMLFormPath formPath = new FXMLFormPath();
	    
	    public static List<PatientBillingInvoice> patientBillingInvoiceList = null;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		okBtn.setOnAction((event) -> {
			try {
				
				String formName = formPath.context.getMessage("ReviewChargesByDate", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.ReviewChargesByDate", null, Locale.US);
				formPath.closeApplicationContext();
				
				Date date1= null;
				LocalDate localDate1 = fromDate.getValue();
				if(localDate1 != null){
					 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
										
				}
				
				Date date2= null;
				LocalDate localDate2 = thurDate.getValue();
				if(localDate2 != null){
					date2 = Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());
										
				}
				
				patientBillingInvoiceList = new PatientBillingInvoiceEntityController().viewPatientBillingInvoiceByDate(date1, date2);
				System.out.println("Patient Billing Invoice Size is : " +patientBillingInvoiceList.size());
				
				ReviewChargesByDateViewController reviewChargesByDateViewController =
						(ReviewChargesByDateViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				reviewChargesByDateViewController.setSelectChargesByDateInputController(this);
				
				new FXFormCommonUtilities().closeForm(okBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		cancelBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
