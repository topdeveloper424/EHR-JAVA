package com.ets.controller.gui.billingPanel;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentCatalog;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDField;

import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.patient.PatientEntityController;
import com.ets.controller.entity.patientBillingInvoice.PatientBillingInvoiceEntityController;
import com.ets.controller.entity.patientVisit.PatientVisitEntityController;
import com.ets.controller.entity.visitCategory.VisitCategoryEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.Icd10Codes;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.Patient;
import com.ets.model.PatientBillingInvoice;
import com.ets.model.PatientVisit;
import com.ets.model.VisitCategory;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.itextpdf.text.pdf.PdfDocument;

import javafx.application.Application;
import javafx.application.HostServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class ManageInvoiceController implements Initializable {
	
	@FXML
    private ChoiceBox<?> SelectChoiceBox;
	
	@FXML
    private TableView<PatientBillingInvoice> invoiceTable;

    @FXML
    private TableColumn<PatientBillingInvoice, String> BatchColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> InvoiceTypeColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> InvokesStartColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> InvokesEndColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, Date> DateColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> TotalColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> StatusColumn;

    @FXML
    private TableColumn<PatientBillingInvoice, String> ReferencesColumn;

    @FXML
    private Button UpdateButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button editListButton;

    @FXML
    private Button invoicesButton;

    @FXML
    private Button poutButton;

    @FXML
    private Button closeButton;
    
    private ObservableList<PatientBillingInvoice> patientBillingInvoiceMasterData = FXCollections.observableArrayList();
	
	public void viewPatientBillInvoice(){
		
		patientBillingInvoiceMasterData = new PatientBillingInvoiceEntityController().viewPatientBillingInvoiceByDateAndPatient();
		System.out.println("Size is : " +patientBillingInvoiceMasterData.size());
		
    	DateColumn.setCellValueFactory(cellData -> cellData.getValue().invoiceDateProperty());
		TotalColumn.setCellValueFactory(cellData -> cellData.getValue().totalProperty());
		StatusColumn.setCellValueFactory(cellData -> cellData.getValue().statusProperty());
		ReferencesColumn.setCellValueFactory(cellData -> cellData.getValue().referanceProperty());
		InvoiceTypeColumn.setCellValueFactory(cellData -> cellData.getValue().invoiceTypeProperty());
       	//serviceCollumn.setCellValueFactory(cellData -> cellData.getValue());
    	
		

		invoiceTable.setItems(patientBillingInvoiceMasterData);
		
       //visitCategoryTable.setItems(new VisitCategoryEntityController().view());
		
	}
	
	FXMLFormPath formPath = new FXMLFormPath();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		viewPatientBillInvoice();
		
		closeButton.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeButton);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		invoicesButton.setOnAction((event) -> {
			
			PatientBillingInvoice patientBillingInvoice = invoiceTable.getSelectionModel().getSelectedItem();
			
			if(patientBillingInvoice != null){
				
				if(patientBillingInvoice.getInvoiceType().equals("Carrier")){
					
					FileChooser fileChooser = new FileChooser();// different in jsp..after clickibg btn it will show pdf
		             
		             //Set extension filter
		             FileChooser.ExtensionFilter extFilter = 
		                     new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
		             fileChooser.getExtensionFilters().add(extFilter);
		               
		             //Show open file dialog
		             //File file = fileChooser.showOpenDialog(primaryStage);
		            // File file = new File("C:\\Users\\Ayan\\Desktop\\TEST\\CMS1500.pdf");
		               File file = new File("CMS1500.pdf");
		               InputStream is = this.getClass().getResourceAsStream("/pdf/CMS1500.pdf");
		               
		               OutputStream outputStream = null;
					try {
						outputStream = new FileOutputStream(file);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		               byte[] buffer = new byte[1024];
		               int length;
		               try {
						while ((length = is.read(buffer)) > 0) {
						       try {
								outputStream.write(buffer, 0, length);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						   }
					} catch (Exception e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
		               try {
						outputStream.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		               try {
						is.close();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
		              
		            
		             
		             PDDocument pdfTemplate = null;
						try {
							//pdfTemplate = PDDocument.load(is);
							pdfTemplate = PDDocument.load(file);
						} catch (IOException e) {
							e.printStackTrace();
						}

		             PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
		             PDAcroForm acroForm = docCatalog.getAcroForm();

		             // Get field names
		             List<PDField> fieldList = acroForm.getFields();

		             // String the object array
		             String[] fieldArray = new String[fieldList.size()];
		             int i = 0;
		             for (PDField sField : fieldList) {
		                 //fieldArray[i] = sField.getFullyQualifiedName();
		             	 fieldArray[i] = sField.getFieldType();
		                System.out.println("Field Name "+":"   +sField.getFullyQualifiedName());  //  for getting file input id
		                 System.out.println("Get Field Type "+sField.getPartialName());
		                
		                 i++;
		             }
		             
		           //  Patient patientList =null;
		             
		             //patientList = new PatientEntityController().viewByPatientId(Global.patient.getId());
		            
		             
		            // PatientVisit patientVisit = new PatientVisitEntityController().viewByPatientVisitId(Global.patientVisitObj.getId());
		           PatientVisit patientVisit = patientBillingInvoice.getPatientVisit();
		             // PatientVisit patientVisit = new PatientVisitEntityController().viewByPatientVisitId(49);
		 			//System.out.println("override fee" +patientBillingInvoice.getTotal());
		 			
		 			System.out.println("Patient Visit Size .........." +patientVisit.getIcd10Codes().size());
		 			//System.out.println("Patient Cpt Code Size .........." +patientVisit.getMedicalActivityCharge().size());
		 			
		 			/*String icd10Code1 = null;
		 			String icd10Code2 = null;
		 			String icd10Code2 = null;
		 			String icd10Code2 = null;
		 			for(Icd10Codes pvisit :patientVisit.getIcd10Codes()){
		 				
		 				System.out.println("ICD10 Code .........." +pvisit.getCode());
		 				
		 			}*/
		 			
		 			 try {
		 				 
		 			Integer lengthIcd = 0;
		 			lengthIcd = patientVisit.getIcd10Codes().size();
		 			
		 			String icdArr[] = new String[lengthIcd];
		 					 				 			
		 			for(int i1=0;i1<lengthIcd ; ++i1){
		 			   
		 		       icdArr[i1] = patientVisit.getIcd10Codes().get(i1).getCode();
		 		       System.out.println("Icd10 Code is :...." +icdArr[i1]);
		 		       
		 		       if(i1 == 0){
		 		    	  
		 		    	  acroForm.getField("diagnosis1").setValue(icdArr[0]);
		 		       }if(i1 == 1){
		 		    	  
		 		    	  acroForm.getField("diagnosis2").setValue(icdArr[1]);
		 		       }if(i1 == 2){
		 		    	   
		 		    	   
		 		    	  acroForm.getField("diagnosis3").setValue(icdArr[2]);
		 		       }if(i1 == 3){
		 		    	   
		 		    	  acroForm.getField("diagnosis4").setValue(icdArr[3]);
		 		       }if(i1 == 4){
		 		    	   
		 		    	  acroForm.getField("diagnosis5").setValue(icdArr[4]);
		 		       }if(i1 == 5){
		 		    	   
		 		    	  acroForm.getField("diagnosis6").setValue(icdArr[5]);
		 		       }if(i1 == 6){
		 		    	   
		 		    	  acroForm.getField("diagnosis7").setValue(icdArr[6]);
		 		       }if(i1 == 7){
		 		    	   
		 		    	  acroForm.getField("diagnosis8").setValue(icdArr[7]);
		 		       }if(i1 == 8){
		 		    	   
		 		    	  acroForm.getField("diagnosis9").setValue(icdArr[8]);
		 		       }if(i1 == 9){
		 		    	   
		 		    	  acroForm.getField("diagnosis10").setValue(icdArr[9]);
		 		       }if(i1 == 10){
		 		    	   
		 		    	  acroForm.getField("diagnosis11").setValue(icdArr[10]);
		 		       }if(i1 == 11){
		 		    	   
		 		    	  acroForm.getField("diagnosis12").setValue(icdArr[11]);
		 		       }
		 		     
						
		 		    
		 		      }
		 			
		 			if(patientVisit.getPatient().getPatientInsuranceCarrier()!=null){
		 				if(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getLocalAddress()!=null){
		 			    acroForm.getField("insurance_address").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getLocalAddress());
		 			    acroForm.getField("insurance_name").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getPlanName());
		 				}	
	            	 
							acroForm.getField("pt_name").setValue(patientVisit.getPatient().getPatientName().getFirstName()+""+patientVisit.getPatient().getPatientName().getAliasLastName());
							if(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier()!=null){
							if(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress()!=null){
							acroForm.getField("insurance_city_state_zip").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getCity()+""
									+patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getState()+""
								    +patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getZip());
							acroForm.getField("pt_street").setValue(patientVisit.getPatient().getAddress().getStreet());
							acroForm.getField("pt_city").setValue(patientVisit.getPatient().getAddress().getCity());
							acroForm.getField("pt_state").setValue(patientVisit.getPatient().getAddress().getState());
							acroForm.getField("pt_zip").setValue(patientVisit.getPatient().getAddress().getZip());
							acroForm.getField("pt_phone").setValue(patientVisit.getPatient().getAddress().getPhone());
							}
							acroForm.getField("ins_street").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getLocalAddress());
							acroForm.getField("ins_city").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getCity());
							acroForm.getField("ins_state").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getState());
							acroForm.getField("ins_zip").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getZip());
							acroForm.getField("ins_phone").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getCarrier().getAddress().getPhone());
							acroForm.getField("ins_policy").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getPolicyOrGroup());
							acroForm.getField("ins_plan_name").setValue(patientVisit.getPatient().getPatientInsuranceCarrier().getPlanName());
							}	}
		 			        if(patientVisit.getProvider()!=null){
							acroForm.getField("tax_id").setValue(patientVisit.getProvider().getFederalId().toString());
							
							acroForm.getField("physician_signature").setValue(patientVisit.getProvider().getFirstName()
									+ " " +patientVisit.getProvider().getMiddleName()
									+ " " +patientVisit.getProvider().getLastName());
							acroForm.getField("pin").setValue(patientVisit.getProvider().getNpi());
							acroForm.getField("grp").setValue(patientVisit.getProvider().getNpi());
		 			        
		 			        }
							acroForm.getField("physician_date").setValue(patientVisit.getVisitDate().toString());
							if(patientVisit.getPatient().getClinic()!=null){
								
							if(patientVisit.getPatient().getClinic()!=null){	
							acroForm.getField("fac_name").setValue(patientVisit.getPatient().getClinic().getName());
							if(patientVisit.getPatient().getClinic().getAddress()!=null){
							acroForm.getField("fac_street").setValue(patientVisit.getPatient().getClinic().getAddress().getLocalAddress());
							acroForm.getField("fac_location").setValue(patientVisit.getPatient().getClinic().getAddress().getCity()+
									" " +patientVisit.getPatient().getClinic().getAddress().getState() + 
									" " +patientVisit.getPatient().getClinic().getAddress().getZip());
                            acroForm.getField("pin1").setValue(patientVisit.getPatient().getClinic().getNpiNo());
							
							
							acroForm.getField("doc_name").setValue(patientVisit.getPatient().getClinic().getName());
							acroForm.getField("doc_street").setValue(patientVisit.getPatient().getClinic().getAddress().getLocalAddress());
							acroForm.getField("doc_location").setValue(patientVisit.getPatient().getClinic().getAddress().getCity()+
									" " +patientVisit.getPatient().getClinic().getAddress().getState() + 
									" " +patientVisit.getPatient().getClinic().getAddress().getZip());
							
							acroForm.getField("doc_phone").setValue(patientVisit.getPatient().getClinic().getAddress().getPhone());
							}}
							
							}
							
						 //acroForm.getField("Suppla").setValue(patientVisit.get);
		 			 
		            	 

							//acroForm.getField("insurance_name").setValue(patientList.getPatientInsuranceCarrier().getPlanName());
		            	
							//acroForm.getField("insurance_address").setValue(patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getLocalAddress());
		            	 
		            	/* acroForm.getField("insurance_address2").setValue("insurance_address2");

							
							acroForm.getField("NUCC USE").setValue("NUCC USE");
							acroForm.getField("40").setValue("40");
							acroForm.getField("57").setValue("57");
							acroForm.getField("58").setValue("58");
							acroForm.getField("41").setValue("41");
							acroForm.getField("50").setValue("50");
							acroForm.getField("73").setValue("73");
							acroForm.getField("74").setValue("74");
							acroForm.getField("85").setValue("85");
							acroForm.getField("96").setValue("96");
							acroForm.getField("99icd").setValue("99icd");
							acroForm.getField("135").setValue("135");
							acroForm.getField("157").setValue("157");
							acroForm.getField("179").setValue("179");
							acroForm.getField("201").setValue("201");
							acroForm.getField("223").setValue("223");
							acroForm.getField("245").setValue("245");*/
		            	 
		            	 
							//acroForm.getField("276").setValue("276");
							//acroForm.getField("Clear Form").setValue("Clear Form");
							
							/*acroForm.getField("insurance_city_state_zip").setValue(patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getCity()+""
							+patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getState()+""
						    +patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getZip());*/
							
							
							//acroForm.getField("pt_name").setValue(patientList.getPatientName().getFirstName()+""+patientList.getPatientName().getAliasLastName());
							
							//acroForm.getField("insurance_id").setValue(patient.getPatientInsuranceCarrier().getId().toString());
							
							//acroForm.getField("insurance_type").setValue("insurance_type");
							/*acroForm.getField("birth_mm").setValue("birth_mm");
							acroForm.getField("birth_dd").setValue("birth_dd");
							acroForm.getField("birth_yy").setValue("birth_yy");*/
							//acroForm.getField("sex").setValue("sex");
							
							/*acroForm.getField("ins_name").setValue("ins_name");
							 * acroForm.getField("pt_street").setValue(patientList.getAddress().getStreet());
							acroForm.getField("pt_city").setValue(patientList.getAddress().getCity());
							acroForm.getField("pt_state").setValue(patientList.getAddress().getState());
							acroForm.getField("pt_zip").setValue(patientList.getAddress().getZip());*/
							
		 			
		 			
							
							
							/*acroForm.getField("pt_phone").setValue(patientList.getAddress().getPhone());*/
							
//							acroForm.getField("rel_to_ins").setValue("rel_to_ins");
							
							/*acroForm.getField("ins_street").setValue(patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getLocalAddress());
							acroForm.getField("ins_city").setValue(patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getCity());
							acroForm.getField("ins_state").setValue(patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getState());
							acroForm.getField("ins_zip").setValue(patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getZip());*/
							
							
							
							
							/*acroForm.getField("ins_phone").setValue(patientList.getPatientInsuranceCarrier().getCarrier().getAddress().getPhone());
							acroForm.getField("ins_policy").setValue(patientList.getPatientInsuranceCarrier().getPolicyOrGroup());*/
							
							
							//acroForm.getField("ins_dob_mm").setValue(patient.getPatientStatistic().getDob().toString());
//							acroForm.getField("ins_sex").setValue("ins_sex");
							
							/*acroForm.getField("ins_dob_dd").setValue("ins_dob_dd");
							acroForm.getField("ins_dob_yy").setValue("ins_dob_yy");
							
							acroForm.getField("other_ins_name").setValue("");
							acroForm.getField("other_ins_policy").setValue("");
							acroForm.getField("ins_signature").setValue("ins_signature");*/
							
							//	acroForm.getField("ins_benefit_plan").setValue("ins_benefit_plan");
							/*acroForm.getField("ins_plan_name").setValue(patientList.getPatientInsuranceCarrier().getPlanName());*/
							
							
							
							/*acroForm.getField("pt_AreaCode").setValue("pt_AreaCode");
							  acroForm.getField("ins_phone area").setValue("ins_phone area");
							  acroForm.getField("pt_signature").setValue("pt_signature");
							acroForm.getField("pt_date").setValue("pt_date");
							acroForm.getField("cur_ill_mm").setValue("cur_ill_mm");
							acroForm.getField("cur_ill_dd").setValue("cur_ill_dd");
							acroForm.getField("cur_ill_yy").setValue("cur_ill_yy");
							acroForm.getField("ref_physician").setValue("ref_physician");
							acroForm.getField("id_physician").setValue("id_physician");
							acroForm.getField("physician number 17a1").setValue("physician number 17a1");
							acroForm.getField("physician number 17a").setValue("physician number 17a");
							acroForm.getField("sim_ill_mm").setValue("sim_ill_mm");
							acroForm.getField("sim_ill_dd").setValue("sim_ill_dd");
							acroForm.getField("sim_ill_yy").setValue("sim_ill_yy");
							acroForm.getField("work_mm_from").setValue("work_mm_from");
							acroForm.getField("work_dd_from").setValue("work_dd_from");
							acroForm.getField("work_yy_from").setValue("work_yy_from");
							acroForm.getField("work_mm_end").setValue("work_mm_end");
							acroForm.getField("work_dd_end").setValue("work_dd_end");
							acroForm.getField("work_yy_end").setValue("work_yy_end");
							acroForm.getField("hosp_mm_from").setValue("hosp_mm_from");
							acroForm.getField("hosp_dd_from").setValue("hosp_dd_from");
							acroForm.getField("hosp_yy_from").setValue("hosp_yy_from");
							acroForm.getField("hosp_mm_end").setValue("hosp_mm_end");
							acroForm.getField("hosp_dd_end").setValue("hosp_dd_end");
							acroForm.getField("hosp_yy_end").setValue("hosp_yy_end");*/
							//	acroForm.getField("lab").setValue("lab");
							
							/*acroForm.getField("charge").setValue("charge");
							acroForm.getField("medicaid_resub").setValue("medicaid_resub");
							acroForm.getField("original_ref").setValue("original_ref");
							acroForm.getField("prior_auth").setValue("prior_auth");
							acroForm.getField("emg1").setValue("emg1");
							acroForm.getField("local1a").setValue("local1a");
							acroForm.getField("sv1_mm_from").setValue("sv1_mm_from");
							acroForm.getField("sv1_dd_from").setValue("sv1_dd_from");
							acroForm.getField("sv1_yy_from").setValue("sv1_yy_from");
							acroForm.getField("sv1_mm_end").setValue("sv1_mm_end");
							acroForm.getField("sv1_dd_end").setValue("sv1_dd_end");
							acroForm.getField("sv1_yy_end").setValue("sv1_yy_end");
							acroForm.getField("diag1").setValue("diag1");
							acroForm.getField("ch1").setValue("ch1");
							acroForm.getField("day1").setValue("day1");
							acroForm.getField("sv2_mm_from").setValue("sv2_mm_from");
							acroForm.getField("sv3_mm_from").setValue("sv3_mm_from");
							acroForm.getField("sv4_mm_from").setValue("sv4_mm_from");
							acroForm.getField("sv5_mm_from").setValue("sv5_mm_from");
							acroForm.getField("sv6_mm_from").setValue("sv6_mm_from");
							acroForm.getField("sv2_dd_from").setValue("sv2_dd_from");
							acroForm.getField("sv3_dd_from").setValue("sv3_dd_from");
							acroForm.getField("sv4_dd_from").setValue("sv4_dd_from");
							
							acroForm.getField("sv5_dd_from").setValue("sv5_dd_from");
							acroForm.getField("sv6_dd_from").setValue("sv6_dd_from");
							acroForm.getField("sv2_yy_from").setValue("sv2_yy_from");
							acroForm.getField("sv3_yy_from").setValue("sv3_yy_from");
							acroForm.getField("sv4_yy_from").setValue("sv4_yy_from");
							acroForm.getField("sv5_yy_from").setValue("sv5_yy_from");
							acroForm.getField("sv6_yy_from").setValue("sv6_yy_from");
							acroForm.getField("sv2_mm_end").setValue("sv2_mm_end");
							acroForm.getField("sv3_mm_end").setValue("sv3_mm_end");
							acroForm.getField("sv4_mm_end").setValue("sv4_mm_end");
							acroForm.getField("sv5_mm_end").setValue("sv5_mm_end");
							acroForm.getField("sv6_mm_end").setValue("sv6_mm_end");
							acroForm.getField("sv2_dd_end").setValue("sv2_dd_end");
							acroForm.getField("sv3_dd_end").setValue("sv3_dd_end");
							acroForm.getField("sv4_dd_end").setValue("sv4_dd_end");
							acroForm.getField("sv5_dd_end").setValue("sv5_dd_end");
							acroForm.getField("sv6_dd_end").setValue("sv6_dd_end");
							acroForm.getField("sv2_yy_end").setValue("sv2_yy_end");
							acroForm.getField("sv3_yy_end").setValue("sv3_yy_end");
							acroForm.getField("sv4_yy_end").setValue("sv4_yy_end");
							acroForm.getField("sv5_yy_end").setValue("sv5_yy_end");
							acroForm.getField("sv6_yy_end").setValue("sv6_yy_end");
							acroForm.getField("place2").setValue("place2");
							
							acroForm.getField("place3").setValue("place3");
							acroForm.getField("place4").setValue("place4");
							acroForm.getField("place5").setValue("place5");
							acroForm.getField("place6").setValue("place6");
							acroForm.getField("diag2").setValue("diag2");
							acroForm.getField("diag3").setValue("diag3");
							acroForm.getField("diag4").setValue("diag4");
							acroForm.getField("ch2").setValue("ch2");
							acroForm.getField("ch3").setValue("ch3");
							acroForm.getField("ch4").setValue("ch4");
							acroForm.getField("ch5").setValue("ch5");
							acroForm.getField("ch6").setValue("ch6");
							
							acroForm.getField("Supplb").setValue("Supplb");
							acroForm.getField("Supplc").setValue("Supplc");
							acroForm.getField("Suppld").setValue("Suppld");
							acroForm.getField("Supple").setValue("Supple");
							acroForm.getField("day2").setValue("day2");
							acroForm.getField("day3").setValue("day3");
							acroForm.getField("day4").setValue("day4");
							
							acroForm.getField("day5").setValue("day5");
							acroForm.getField("day6").setValue("day6");
							acroForm.getField("emg2").setValue("emg2");
							acroForm.getField("emg3").setValue("emg3");
							acroForm.getField("emg4").setValue("emg4");
							acroForm.getField("emg5").setValue("emg5");
							acroForm.getField("emg6").setValue("emg6");
							acroForm.getField("local1").setValue("local1");
							acroForm.getField("local2a").setValue("local2a");
							acroForm.getField("local2").setValue("local2");
							acroForm.getField("local3a").setValue("local3a");
							acroForm.getField("local3").setValue("local3");
							acroForm.getField("local4a").setValue("local4a");
							acroForm.getField("local4").setValue("local4");
							acroForm.getField("local5a").setValue("local5a");
							acroForm.getField("local5").setValue("local5");
							acroForm.getField("local6a").setValue("local6a");
							acroForm.getField("local6").setValue("local6");
							
							acroForm.getField("pt_account").setValue("pt_account");*/
//							acroForm.getField("assignment").setValue("assignment");
							
							/*acroForm.getField("t_charge").setValue("t_charge");
							acroForm.getField("amt_paid").setValue("amt_paid");
							acroForm.getField("doc_phone area").setValue("doc_phone area");
							*/
							
							
							
							
							
						
							
							//acroForm.getField("employment").setValue("employment");
							//acroForm.getField("pt_auto_accident").setValue("pt_auto_accident");
							
							//acroForm.getField("other_accident").setValue("other_accident");
							
							//acroForm.getField("ssn").setValue("ssn");
							
							/*acroForm.getField("other_ins_plan_name").setValue("other_ins_plan_name");
							acroForm.getField("accident_place").setValue("accident_place");
							acroForm.getField("place1").setValue("place1");
							acroForm.getField("diag6").setValue("diag6");
							acroForm.getField("diag5").setValue("diag5");
							acroForm.getField("type6").setValue("type6");
							acroForm.getField("type5").setValue("type5");
							acroForm.getField("cpt6").setValue("cpt6");
							acroForm.getField("cpt5").setValue("cpt5");
							acroForm.getField("cpt4").setValue("cpt4");
							acroForm.getField("mod6").setValue("mod6");
							acroForm.getField("mod5").setValue("mod5");
							acroForm.getField("mod4").setValue("mod4");
							acroForm.getField("mod3").setValue("mod3");
							acroForm.getField("mod2").setValue("mod2");
							acroForm.getField("mod6a").setValue("mod6a");
							acroForm.getField("mod5a").setValue("mod5a");
							
							acroForm.getField("mod4a").setValue("mod4a");
							acroForm.getField("mod3a").setValue("mod3a");
							acroForm.getField("mod2a").setValue("mod2a");
							acroForm.getField("mod1a").setValue("mod1a");
							acroForm.getField("mod6b").setValue("mod6b");
							acroForm.getField("mod5b").setValue("mod5b");
							acroForm.getField("mod4b").setValue("mod4b");
							acroForm.getField("mod3b").setValue("mod3b");
							acroForm.getField("mod2b").setValue("mod2b");
							acroForm.getField("mod1b").setValue("mod1b");
							acroForm.getField("mod6c").setValue("mod6c");
							acroForm.getField("mod5c").setValue("mod5c");
							acroForm.getField("mod4c").setValue("mod4c");
							acroForm.getField("mod3c").setValue("mod3c");
							acroForm.getField("mod1c").setValue("mod1c");
							acroForm.getField("mod2c").setValue("mod2c");
							acroForm.getField("type1").setValue("type1");
							acroForm.getField("type2").setValue("type2");
							acroForm.getField("type3").setValue("type3");
							acroForm.getField("type4").setValue("type4");
							acroForm.getField("cpt1").setValue("cpt1");
							
							acroForm.getField("cpt2").setValue("cpt2");
							acroForm.getField("cpt3").setValue("cpt3");
							acroForm.getField("mod1").setValue("mod1");
							
							acroForm.getField("grp1").setValue("grp1");
							acroForm.getField("Suppl").setValue("Suppl");
							acroForm.getField("plan1").setValue("plan1");
							acroForm.getField("plan2").setValue("plan2");
							
							acroForm.getField("plan3").setValue("plan3");
							acroForm.getField("plan4").setValue("plan4");
							acroForm.getField("plan5").setValue("plan5");
							acroForm.getField("plan6").setValue("plan6");
							acroForm.getField("epsdt1").setValue("epsdt1");
							acroForm.getField("epsdt3").setValue("epsdt3");
							acroForm.getField("epsdt6").setValue("epsdt6");
							acroForm.getField("epsdt5").setValue("epsdt5");
							acroForm.getField("epsdt4").setValue("epsdt4");
							acroForm.getField("epsdt2").setValue("epsdt2");*/

							pdfTemplate.save(file);
							//pdfTemplate.close();
							ObservableList<MedicalActivityCharge> medicalActivityChargeList = null;
							MedicalActivityCharge medicalActivityCharge2 = new MedicalActivityCharge();
							medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByPatientVisit(patientBillingInvoice.getPatientVisit().getId());

							System.out.println("Medical Activity Charges Size is :  --  " +medicalActivityChargeList.size());
							//new MedicalActivityChargeViewController().viewChargeAfterBilling(medicalActivityChargeList.);
							for (int j=0; j<medicalActivityChargeList.size();j++) {
								medicalActivityChargeList.get(j).setCheckBillingStatus(true);
							   if(medicalActivityChargeList.get(j).getOverrideFee()==null||medicalActivityChargeList.get(j).getOverrideFee().equals("")){
									medicalActivityChargeList.get(j).setOverrideFee("0");
									
								} if(medicalActivityChargeList.get(j).getBillingQty()==null||medicalActivityChargeList.get(j).getBillingQty().equals("")){
									medicalActivityChargeList.get(j).setBillingQty("1");
									
								}
										
										
								new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge2);
							}
							
							patientBillingInvoice.setStatus("Printed");
							new PatientBillingInvoiceEntityController().saveOrUpdate(patientBillingInvoice);
							
						}  catch (IOException e) {
							
							e.printStackTrace();
						}
		             
		             
		            Application application = new Application() {
						
						@Override
						public void start(Stage primaryStage) throws Exception {
							
							
						}
					};
		            	
					//HostServices hostServices = application.getHostServices();//fx ,class for showing pdf, HostService class is different in jsp
		             //hostServices.showDocument();	//fx method for showing path

					Desktop desktop = Desktop.getDesktop();
			        try {
						desktop.open(file);
					} catch (Exception e) {
						
						e.printStackTrace();
					}
					
				}else if (patientBillingInvoice.getInvoiceType().equals("Employer")) {
					
					String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

					String formTitle1 = formPath.context.getMessage("Title.ProgressBar.CreateInvoice", null, Locale.US);
					formPath.closeApplicationContext();

					// Need the ProgressBar controller to access the progress bar in
					// this method
					ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
							.displayFormAndGetController(formName1, formTitle1);
					ProgressBar progressBar = progressBarGUIController.getProgressBar();

					/********************************
					 * Start of Task definition
					 *****************************************************************/
					Task<ObservableList<MedicalActivityCharge>> task =

							new Task<ObservableList<MedicalActivityCharge>>() {

								@Override
								protected ObservableList<MedicalActivityCharge> call() throws Exception {

									ObservableList<MedicalActivityCharge> medicalActivityChargeList = null;

									try {

										System.out.println("Generating PDF...");

										String printMedicalActivityCharge = formPath.context.getMessage("Print.CreateInvoice", null, Locale.US);

										formPath.closeApplicationContext();

										//InputStream is = new FileInputStream(new File(printClinician));
										InputStream is = this.getClass().getResourceAsStream(printMedicalActivityCharge);
										JasperReport jasperReport = JasperCompileManager.compileReport(is);
										/*Date date1= null;
										Date date2=null;
										LocalDate localDate1 = fromDate.getValue();
										LocalDate  localDate2= toDate.getValue();
										if(localDate1 != null&& localDate2!=null){
											 date1 = Date.from(localDate1.atStartOfDay(ZoneId.systemDefault()).toInstant());
											 date2= Date.from(localDate2.atStartOfDay(ZoneId.systemDefault()).toInstant());				
										}*/
										//medicalActivityChargeList = new  MedicalActivityChargeEntityController().viewMedicalActivityCharge(Global.patient.getId());
										/*if(employerPaidServicesCheck.isSelected()){
											overrideStr = "Employer";
											//medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(Global.patient.getId(), date1, date2, overrideStr);
											
										}
										else if(carrierPaidWorkersCompCheck.isSelected()){
											overrideStr = "carrier";
											//medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(Global.patient.getId(), date1, date2, overrideStr);
											
										}else{
											// Put Dialog Box Here
										}*/
										MedicalActivityCharge medicalActivityCharge2 = new MedicalActivityCharge();
										medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByPatientVisit(patientBillingInvoice.getPatientVisit().getId());

										System.out.println("Medical Activity Charges Size is :  --  " +medicalActivityChargeList.size());
										//new MedicalActivityChargeViewController().viewChargeAfterBilling(medicalActivityChargeList.);
										for (int i=0; i<medicalActivityChargeList.size();i++) {
											medicalActivityChargeList.get(i).setCheckBillingStatus(true);
											/*medicalActivityCharge2.setId(medicalActivityCharge.getId());
											medicalActivityCharge2.setCheckBillingStatus(true);
											medicalActivityCharge2.setActivityCost(medicalActivityCharge.getActivityCost());
											medicalActivityCharge2.setActivityDate(medicalActivityCharge.getActivityDate());
											medicalActivityCharge2.setBillingComment(medicalActivityCharge.getBillingComment());
											
											medicalActivityCharge2.setBillingModifier(medicalActivityCharge.getBillingModifier());
											medicalActivityCharge2.setBillingQty(medicalActivityCharge.getBillingQty());
											medicalActivityCharge2.setClinician(medicalActivityCharge.getClinician());
											medicalActivityCharge2.setLabOrderNo(medicalActivityCharge.getLabOrderNo());
											medicalActivityCharge2.setLabSampleId(medicalActivityCharge.getLabSampleId());
											medicalActivityCharge2.setNdcCode(medicalActivityCharge.getNdcCode());
											medicalActivityCharge2.setResultCode(medicalActivityCharge.getResultCode());
											medicalActivityCharge2.setPatient(medicalActivityCharge.getPatientVisit().getPatient());
											medicalActivityCharge2.setOverridePayer(medicalActivityCharge.getOverridePayer());
											medicalActivityCharge2.setPatientVisit(medicalActivityCharge.getPatientVisit());
											medicalActivityCharge2.setMedicalActivity(medicalActivityCharge.getMedicalActivity());
											medicalActivityCharge2.setNextDueDate(medicalActivityCharge.getNextDueDate());
											medicalActivityCharge2.setNoCost(medicalActivityCharge.getNoCost());
											medicalActivityCharge2.setOverrideFee(medicalActivityCharge.getOverrideFee());*/
											if(medicalActivityChargeList.get(i).getOverrideFee()==null||medicalActivityChargeList.get(i).getOverrideFee().equals("")){
												medicalActivityChargeList.get(i).setOverrideFee("0");
												
											} if(medicalActivityChargeList.get(i).getBillingQty()==null||medicalActivityChargeList.get(i).getBillingQty().equals("")){
												medicalActivityChargeList.get(i).setBillingQty("1");
												
											}
													
													
											new MedicalActivityChargeEntityController().saveOrUpdate(medicalActivityCharge2);
										}
										
										
										
										//medicalActivityChargeList = new  MedicalActivityChargeEntityController().viewMedicalActivityCharge();
										//medicalActivityChargeList = new  MedicalActivityChargeEntityController().viewMedicalActivityCharge(Global.patient.getId());
										JRDataSource JRdataSource = new JRBeanCollectionDataSource(medicalActivityChargeList);
										Map<String, Object> map = new HashMap<String, Object>();
										JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

										JasperViewer.viewReport(jasperPrint, false);
										patientBillingInvoice.setStatus("Printed");
										new PatientBillingInvoiceEntityController().saveOrUpdate(patientBillingInvoice);
										System.out.println("FirstReport.pdf has been generated!");
										
									} catch(NullPointerException nul){
										Alert alert = new Alert(AlertType.INFORMATION);
										alert.setTitle("");
										alert.setHeaderText(null);
										alert.setContentText("Some data is null!");

										alert.showAndWait();
									}
									catch (Exception ex) {
										ex.printStackTrace();
										
									}

									if (isCancelled()) {
										return null;
									}
									return medicalActivityChargeList;

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

					});

					progressBar.progressProperty().bind(task.progressProperty());

					try {
						// Start background thread for database record retrieval .
						new Thread(task).start();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
				
			}else{
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information Dialog");
				alert.setHeaderText(null);
				alert.setContentText("Please Select a Row");
				alert.showAndWait();
				
			}
			
			 
			viewPatientBillInvoice();
			
			
		});
		
		
/*		invoicesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();// different in jsp..after clickibg btn it will show pdf
                  
                //Set extension filter
                FileChooser.ExtensionFilter extFilter = 
                        new FileChooser.ExtensionFilter("PDF files (*.pdf)", "*.pdf");
                fileChooser.getExtensionFilters().add(extFilter);
                  
                //Show open file dialog
                //File file = fileChooser.showOpenDialog(primaryStage);
               // File file = new File("C:\\Users\\Ayan\\Desktop\\TEST\\CMS1500.pdf");
                File file = new File("file:../../src/main/resources/pdf/CMS1500.pdf");
 
                HostServices hostServices = getHostServices();
                hostServices.showDocument(file.getAbsolutePath());
                
                
                
                PDDocument pdfTemplate = null;
				try {
					pdfTemplate = PDDocument.load(file);
				} catch (IOException e) {
					e.printStackTrace();
				}

                PDDocumentCatalog docCatalog = pdfTemplate.getDocumentCatalog();
                PDAcroForm acroForm = docCatalog.getAcroForm();

                // Get field names
                List<PDField> fieldList = acroForm.getFields();

                // String the object array
                String[] fieldArray = new String[fieldList.size()];
                int i = 0;
                for (PDField sField : fieldList) {
                    //fieldArray[i] = sField.getFullyQualifiedName();
                	 fieldArray[i] = sField.getFieldType();
                   System.out.println("Field Name "+":"   +sField.getFullyQualifiedName());  //  for getting file input id
                    System.out.println("Get Field Type "+sField.getPartialName());
                   
                    i++;
                }
                
                try {
					acroForm.getField("insurance_name").setValue("insurance_name");
					acroForm.getField("insurance_address").setValue("insurance_address");
					acroForm.getField("insurance_address2").setValue("insurance_address2");
					
					acroForm.getField("NUCC USE").setValue("NUCC USE");
					acroForm.getField("40").setValue("40");
					acroForm.getField("57").setValue("57");
					acroForm.getField("58").setValue("58");
					acroForm.getField("41").setValue("41");
					acroForm.getField("50").setValue("50");
					acroForm.getField("73").setValue("73");
					acroForm.getField("74").setValue("74");
					acroForm.getField("85").setValue("85");
					acroForm.getField("96").setValue("96");
					acroForm.getField("99icd").setValue("99icd");
					acroForm.getField("135").setValue("135");
					acroForm.getField("157").setValue("157");
					acroForm.getField("179").setValue("179");
					acroForm.getField("201").setValue("201");
					acroForm.getField("223").setValue("223");
					acroForm.getField("245").setValue("245");
					acroForm.getField("276").setValue("276");
					acroForm.getField("Clear Form").setValue("Clear Form");
					acroForm.getField("insurance_city_state_zip").setValue("insurance_city_state_zip");
					acroForm.getField("pt_name").setValue("pt_name");
					acroForm.getField("insurance_id").setValue("insurance_id");
					acroForm.getField("ins_name").setValue("ins_name");
					acroForm.getField("insurance_type").setValue("insurance_type");
					acroForm.getField("birth_mm").setValue("birth_mm");
					acroForm.getField("birth_dd").setValue("birth_dd");
					acroForm.getField("birth_yy").setValue("birth_yy");
					acroForm.getField("sex").setValue("sex");
					acroForm.getField("pt_street").setValue("pt_street");
					acroForm.getField("pt_city").setValue("pt_city");
					acroForm.getField("pt_state").setValue("pt_state");
					acroForm.getField("pt_zip").setValue("pt_zip");
					acroForm.getField("pt_AreaCode").setValue("pt_AreaCode");
					acroForm.getField("pt_phone").setValue("pt_phone");
//					acroForm.getField("rel_to_ins").setValue("rel_to_ins");
					acroForm.getField("ins_street").setValue("ins_street");
					
					acroForm.getField("ins_city").setValue("ins_city");
					acroForm.getField("ins_state").setValue("ins_state");
					acroForm.getField("ins_zip").setValue("ins_zip");
					acroForm.getField("ins_phone area").setValue("ins_phone area");
					acroForm.getField("ins_phone").setValue("ins_phone");
					acroForm.getField("ins_policy").setValue("ins_policy");
					acroForm.getField("ins_dob_mm").setValue("ins_dob_mm");
					acroForm.getField("ins_dob_dd").setValue("ins_dob_dd");
					acroForm.getField("ins_dob_yy").setValue("ins_dob_yy");
//					acroForm.getField("ins_sex").setValue("ins_sex");
					acroForm.getField("other_ins_name").setValue("other_ins_name");
					acroForm.getField("other_ins_policy").setValue("other_ins_policy");
					acroForm.getField("ins_signature").setValue("ins_signature");
//					acroForm.getField("ins_benefit_plan").setValue("ins_benefit_plan");
					acroForm.getField("ins_plan_name").setValue("ins_plan_name");
					acroForm.getField("pt_signature").setValue("pt_signature");
					acroForm.getField("pt_date").setValue("pt_date");
					acroForm.getField("cur_ill_mm").setValue("cur_ill_mm");
					acroForm.getField("cur_ill_dd").setValue("cur_ill_dd");
					acroForm.getField("cur_ill_yy").setValue("cur_ill_yy");
					acroForm.getField("ref_physician").setValue("ref_physician");
					acroForm.getField("id_physician").setValue("id_physician");
					acroForm.getField("physician number 17a1").setValue("physician number 17a1");
					acroForm.getField("physician number 17a").setValue("physician number 17a");
					acroForm.getField("sim_ill_mm").setValue("sim_ill_mm");
					acroForm.getField("sim_ill_dd").setValue("sim_ill_dd");
					acroForm.getField("sim_ill_yy").setValue("sim_ill_yy");
					acroForm.getField("work_mm_from").setValue("work_mm_from");
					acroForm.getField("work_dd_from").setValue("work_dd_from");
					acroForm.getField("work_yy_from").setValue("work_yy_from");
					acroForm.getField("work_mm_end").setValue("work_mm_end");
					acroForm.getField("work_dd_end").setValue("work_dd_end");
					acroForm.getField("work_yy_end").setValue("work_yy_end");
					acroForm.getField("hosp_mm_from").setValue("hosp_mm_from");
					acroForm.getField("hosp_dd_from").setValue("hosp_dd_from");
					acroForm.getField("hosp_yy_from").setValue("hosp_yy_from");
					acroForm.getField("hosp_mm_end").setValue("hosp_mm_end");
					acroForm.getField("hosp_dd_end").setValue("hosp_dd_end");
					acroForm.getField("hosp_yy_end").setValue("hosp_yy_end");
//					acroForm.getField("lab").setValue("lab");
					
					acroForm.getField("charge").setValue("charge");
					acroForm.getField("medicaid_resub").setValue("medicaid_resub");
					acroForm.getField("original_ref").setValue("original_ref");
					acroForm.getField("prior_auth").setValue("prior_auth");
					acroForm.getField("emg1").setValue("emg1");
					acroForm.getField("local1a").setValue("local1a");
					acroForm.getField("sv1_mm_from").setValue("sv1_mm_from");
					acroForm.getField("sv1_dd_from").setValue("sv1_dd_from");
					acroForm.getField("sv1_yy_from").setValue("sv1_yy_from");
					acroForm.getField("sv1_mm_end").setValue("sv1_mm_end");
					acroForm.getField("sv1_dd_end").setValue("sv1_dd_end");
					acroForm.getField("sv1_yy_end").setValue("sv1_yy_end");
					acroForm.getField("diag1").setValue("diag1");
					acroForm.getField("ch1").setValue("ch1");
					acroForm.getField("day1").setValue("day1");
					acroForm.getField("sv2_mm_from").setValue("sv2_mm_from");
					acroForm.getField("sv3_mm_from").setValue("sv3_mm_from");
					acroForm.getField("sv4_mm_from").setValue("sv4_mm_from");
					acroForm.getField("sv5_mm_from").setValue("sv5_mm_from");
					acroForm.getField("sv6_mm_from").setValue("sv6_mm_from");
					acroForm.getField("sv2_dd_from").setValue("sv2_dd_from");
					acroForm.getField("sv3_dd_from").setValue("sv3_dd_from");
					acroForm.getField("sv4_dd_from").setValue("sv4_dd_from");
					
					acroForm.getField("sv5_dd_from").setValue("sv5_dd_from");
					acroForm.getField("sv6_dd_from").setValue("sv6_dd_from");
					acroForm.getField("sv2_yy_from").setValue("sv2_yy_from");
					acroForm.getField("sv3_yy_from").setValue("sv3_yy_from");
					acroForm.getField("sv4_yy_from").setValue("sv4_yy_from");
					acroForm.getField("sv5_yy_from").setValue("sv5_yy_from");
					acroForm.getField("sv6_yy_from").setValue("sv6_yy_from");
					acroForm.getField("sv2_mm_end").setValue("sv2_mm_end");
					acroForm.getField("sv3_mm_end").setValue("sv3_mm_end");
					acroForm.getField("sv4_mm_end").setValue("sv4_mm_end");
					acroForm.getField("sv5_mm_end").setValue("sv5_mm_end");
					acroForm.getField("sv6_mm_end").setValue("sv6_mm_end");
					acroForm.getField("sv2_dd_end").setValue("sv2_dd_end");
					acroForm.getField("sv3_dd_end").setValue("sv3_dd_end");
					acroForm.getField("sv4_dd_end").setValue("sv4_dd_end");
					acroForm.getField("sv5_dd_end").setValue("sv5_dd_end");
					acroForm.getField("sv6_dd_end").setValue("sv6_dd_end");
					acroForm.getField("sv2_yy_end").setValue("sv2_yy_end");
					acroForm.getField("sv3_yy_end").setValue("sv3_yy_end");
					acroForm.getField("sv4_yy_end").setValue("sv4_yy_end");
					acroForm.getField("sv5_yy_end").setValue("sv5_yy_end");
					acroForm.getField("sv6_yy_end").setValue("sv6_yy_end");
					acroForm.getField("place2").setValue("place2");
					
					acroForm.getField("place3").setValue("place3");
					acroForm.getField("place4").setValue("place4");
					acroForm.getField("place5").setValue("place5");
					acroForm.getField("place6").setValue("place6");
					acroForm.getField("diag2").setValue("diag2");
					acroForm.getField("diag3").setValue("diag3");
					acroForm.getField("diag4").setValue("diag4");
					acroForm.getField("ch2").setValue("ch2");
					acroForm.getField("ch3").setValue("ch3");
					acroForm.getField("ch4").setValue("ch4");
					acroForm.getField("ch5").setValue("ch5");
					acroForm.getField("ch6").setValue("ch6");
					acroForm.getField("Suppla").setValue("Suppla");
					acroForm.getField("Supplb").setValue("Supplb");
					acroForm.getField("Supplc").setValue("Supplc");
					acroForm.getField("Suppld").setValue("Suppld");
					acroForm.getField("Supple").setValue("Supple");
					acroForm.getField("day2").setValue("day2");
					acroForm.getField("day3").setValue("day3");
					acroForm.getField("day4").setValue("day4");
					
					acroForm.getField("day5").setValue("day5");
					acroForm.getField("day6").setValue("day6");
					acroForm.getField("emg2").setValue("emg2");
					acroForm.getField("emg3").setValue("emg3");
					acroForm.getField("emg4").setValue("emg4");
					acroForm.getField("emg5").setValue("emg5");
					acroForm.getField("emg6").setValue("emg6");
					acroForm.getField("local1").setValue("local1");
					acroForm.getField("local2a").setValue("local2a");
					acroForm.getField("local2").setValue("local2");
					acroForm.getField("local3a").setValue("local3a");
					acroForm.getField("local3").setValue("local3");
					acroForm.getField("local4a").setValue("local4a");
					acroForm.getField("local4").setValue("local4");
					acroForm.getField("local5a").setValue("local5a");
					acroForm.getField("local5").setValue("local5");
					acroForm.getField("local6a").setValue("local6a");
					acroForm.getField("local6").setValue("local6");
					acroForm.getField("tax_id").setValue("tax_id");
					acroForm.getField("pt_account").setValue("pt_account");
//					acroForm.getField("assignment").setValue("assignment");
					acroForm.getField("t_charge").setValue("t_charge");
					acroForm.getField("amt_paid").setValue("amt_paid");
					acroForm.getField("physician_signature").setValue("physician_signature");
					acroForm.getField("physician_date").setValue("physician_date");
					acroForm.getField("fac_name").setValue("fac_name");
					acroForm.getField("fac_street").setValue("fac_street");
					acroForm.getField("fac_location").setValue("fac_location");
					acroForm.getField("doc_name").setValue("doc_name");
					acroForm.getField("doc_street").setValue("doc_street");
					acroForm.getField("doc_location").setValue("doc_location");
					acroForm.getField("doc_phone area").setValue("doc_phone area");
					acroForm.getField("doc_phone").setValue("doc_phone");
					acroForm.getField("pin").setValue("pin");
					acroForm.getField("grp").setValue("grp");
					acroForm.getField("employment").setValue("employment");
					acroForm.getField("pt_auto_accident").setValue("pt_auto_accident");
					acroForm.getField("accident_place").setValue("accident_place");
					acroForm.getField("other_accident").setValue("other_accident");
					acroForm.getField("other_ins_plan_name").setValue("other_ins_plan_name");
					acroForm.getField("diagnosis1").setValue("diagnosis1");
					acroForm.getField("diagnosis4").setValue("diagnosis4");
					acroForm.getField("diagnosis3").setValue("diagnosis3");
					acroForm.getField("diagnosis2").setValue("diagnosis2");
					acroForm.getField("diagnosis5").setValue("diagnosis5");
					acroForm.getField("diagnosis6").setValue("diagnosis6");
					acroForm.getField("diagnosis7").setValue("diagnosis7");
					acroForm.getField("diagnosis8").setValue("diagnosis8");
					acroForm.getField("diagnosis9").setValue("diagnosis9");
					acroForm.getField("diagnosis10").setValue("diagnosis10");
					acroForm.getField("diagnosis11").setValue("diagnosis11");
					acroForm.getField("diagnosis12").setValue("diagnosis12");
					acroForm.getField("ssn").setValue("ssn");
					acroForm.getField("place1").setValue("place1");
					acroForm.getField("diag6").setValue("diag6");
					acroForm.getField("diag5").setValue("diag5");
					acroForm.getField("type6").setValue("type6");
					acroForm.getField("type5").setValue("type5");
					acroForm.getField("cpt6").setValue("cpt6");
					acroForm.getField("cpt5").setValue("cpt5");
					acroForm.getField("cpt4").setValue("cpt4");
					acroForm.getField("mod6").setValue("mod6");
					acroForm.getField("mod5").setValue("mod5");
					acroForm.getField("mod4").setValue("mod4");
					acroForm.getField("mod3").setValue("mod3");
					acroForm.getField("mod2").setValue("mod2");
					acroForm.getField("mod6a").setValue("mod6a");
					acroForm.getField("mod5a").setValue("mod5a");
					
					acroForm.getField("mod4a").setValue("mod4a");
					acroForm.getField("mod3a").setValue("mod3a");
					acroForm.getField("mod2a").setValue("mod2a");
					acroForm.getField("mod1a").setValue("mod1a");
					acroForm.getField("mod6b").setValue("mod6b");
					acroForm.getField("mod5b").setValue("mod5b");
					acroForm.getField("mod4b").setValue("mod4b");
					acroForm.getField("mod3b").setValue("mod3b");
					acroForm.getField("mod2b").setValue("mod2b");
					acroForm.getField("mod1b").setValue("mod1b");
					acroForm.getField("mod6c").setValue("mod6c");
					acroForm.getField("mod5c").setValue("mod5c");
					acroForm.getField("mod4c").setValue("mod4c");
					acroForm.getField("mod3c").setValue("mod3c");
					acroForm.getField("mod1c").setValue("mod1c");
					acroForm.getField("mod2c").setValue("mod2c");
					acroForm.getField("type1").setValue("type1");
					acroForm.getField("type2").setValue("type2");
					acroForm.getField("type3").setValue("type3");
					acroForm.getField("type4").setValue("type4");
					acroForm.getField("cpt1").setValue("cpt1");
					
					acroForm.getField("cpt2").setValue("cpt2");
					acroForm.getField("cpt3").setValue("cpt3");
					acroForm.getField("mod1").setValue("mod1");
					acroForm.getField("pin1").setValue("pin1");
					acroForm.getField("grp1").setValue("grp1");
					acroForm.getField("Suppl").setValue("Suppl");
					acroForm.getField("plan1").setValue("plan1");
					acroForm.getField("plan2").setValue("plan2");
					
					acroForm.getField("plan3").setValue("plan3");
					acroForm.getField("plan4").setValue("plan4");
					acroForm.getField("plan5").setValue("plan5");
					acroForm.getField("plan6").setValue("plan6");
					acroForm.getField("epsdt1").setValue("epsdt1");
					acroForm.getField("epsdt3").setValue("epsdt3");
					acroForm.getField("epsdt6").setValue("epsdt6");
					acroForm.getField("epsdt5").setValue("epsdt5");
					acroForm.getField("epsdt4").setValue("epsdt4");
					acroForm.getField("epsdt2").setValue("epsdt2");
										
					
					//pdfTemplate.save(file);
					pdfTemplate.close();
					
					
				} catch (IOException e) {
					
					e.printStackTrace();
				}
                
               
                HostServices hostServices = getHostServices();//fx ,class for showing pdf, HostService class is different in jsp
                hostServices.showDocument(file.getAbsolutePath());//fx method for showing path

                
            }
        });*/
		
		 			
	}

}
