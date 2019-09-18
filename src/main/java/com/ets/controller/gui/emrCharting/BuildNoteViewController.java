package com.ets.controller.gui.emrCharting;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.buildNote.BuildNoteEntityController;
import com.ets.controller.entity.medicalActivityCharge.MedicalActivityChargeEntityController;
import com.ets.controller.entity.patientBillingInvoice.PatientBillingInvoiceEntityController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.BuildNote;
import com.ets.model.EmrChartingTextAreaSave;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientBillingInvoice;
import com.ets.model.PatientVisit;
import com.ets.model.VitalSign;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class BuildNoteViewController implements Initializable {


    @FXML
    private TextArea subjectiveTextArea;

    @FXML
    private TextArea objectiveTextArea;

    @FXML
    private TextArea asesmentTextArea;

    @FXML
    private TextArea planTextArea;

    @FXML
    private Label providerLabel;

    @FXML
    private Label dateLabel;

    @FXML
    private Label clinicianlabel;

    @FXML
    private Label ummarylabel;

    @FXML
    private Button saveBtn;

    @FXML
    private Button cancelBtn;

    @FXML
    private Button printBtn;


       private TextArea patientChief;
       
       private String str = "";
       
     
        
      /* public BuildNoteViewController(){
    	   System.out.println("First");
    	   
    	   if(genericEMRChartingController!=null){
   			
   			setBuildNote();
   			
   		  }
   		  if(pastBuildNoteViewController!=null){
   			
   			viewPastBuildNote();
   			
   			
   		}
    	   
    	   
       }*/
       
   private PastBuildNoteViewController pastBuildNoteViewController;
   private  PatientVisit patientVisit;

   public void setPatientVisit(PatientVisit patientVisit) {
	this.patientVisit = patientVisit;
}




    public void setPastBuildNoteViewController(PastBuildNoteViewController pastBuildNoteViewController,PatientVisit patVisit) {
	     this.pastBuildNoteViewController = pastBuildNoteViewController;
	     this.patientVisit = patVisit;
	
	viewPastBuildNote();
    }
   
   


	public void setBuildNote(){
		
		
		if(Global.patientVisitObj.getProvider() != null){
			
			providerLabel.setText(Global.patientVisitObj.getProvider().getFirstName()+" "+Global.patientVisitObj.getProvider().getMiddleName()+" "
					+Global.patientVisitObj.getProvider().getLastName());	
			
		}
		
		if(Global.patientVisitObj.getClinician() != null){
			clinicianlabel.setText(Global.patientVisitObj.getClinician().getFirstName()+" "
					+Global.patientVisitObj.getClinician().getMiddleName()+" "
					+Global.patientVisitObj.getClinician().getLastName());
			
			
		}
		if(Global.patientVisitObj.getVisitDate()!=null){
			
			dateLabel.setText(Global.patientVisitObj.getVisitDate().toString());
			
			
		}
		if(Global.patientVisitObj.getPurpose() != null){
			
			ummarylabel.setText(Global.patientVisitObj.getPurpose());
			
		}
		
		if(genericEMRChartingController.patientVisitComplaintStr != null){
			
			
			StringBuilder str1 = new StringBuilder(str);
			str1.append("Initial Chief Complaint\n\n"+genericEMRChartingController.patientVisitComplaintStr);
			str = str1.toString();
		
		}
		if(genericEMRChartingController.hpiStaticStringTextareaBuild != null){
			
			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nPatient Complaint\n "+genericEMRChartingController.hpiStaticStringTextareaBuild);
			str = str1.toString();
		    
		}
		
           if(genericEMRChartingController.pmhStaticStringTextareaBuild != null){
			
			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\n Patient Histories\n"+genericEMRChartingController.pmhStaticStringTextareaBuild);
			str = str1.toString();
		    
		}
		

           if(genericEMRChartingController.rosStaticStringTextareaBuild != null){
			
			StringBuilder str1 = new StringBuilder(str);
			str1.append("\n\nReview of System"+genericEMRChartingController.rosStaticStringTextareaBuild);
			str = str1.toString();
		    
		}
		
           subjectiveTextArea.setText(str);
           str = "";
           
           if(genericEMRChartingController.assessmentStaticStringTextareaBuild != null){
        	   
        	  StringBuilder str1 = new StringBuilder(str);
   			str1.append("\nAssessment"+genericEMRChartingController.assessmentStaticStringTextareaBuild);
   			str = str1.toString();
   		      
        	   
           }
           if(genericEMRChartingController.workStatusStaticStringTextAreaBuild != null){
        	   
         	  StringBuilder str1 = new StringBuilder(str);
    		  str1.append("\n\nWork status/Assesment\n"+genericEMRChartingController.workStatusStaticStringTextAreaBuild);
    		  str = str1.toString();
    		      
         	   
            }
      
 		
           asesmentTextArea.setText(str);
           str  = "";
		
           if(genericEMRChartingController.orderTextAreaStaticStringTextareaBuild != null){
        	   
          	  StringBuilder str1 = new StringBuilder(str);
     		  str1.append("\nTreatments/Orders/Work Restrictions\n"+genericEMRChartingController.orderTextAreaStaticStringTextareaBuild);
     		  str = str1.toString();
     		      
          	   
             } if(genericEMRChartingController.procedureStaticStringTextareaBuild != null){
          	   
             	  StringBuilder str1 = new StringBuilder(str);
        		  str1.append("\n\nMedical Procedures\n"+genericEMRChartingController.procedureStaticStringTextareaBuild);
        		  str = str1.toString();
        		      
             	   
                }
             if(genericEMRChartingController.instructionStaticStringTextAreaBuild != null){
            	   
            	  StringBuilder str1 = new StringBuilder(str);
       		      str1.append("\n\nPatient Instructions\n"+genericEMRChartingController.instructionStaticStringTextAreaBuild);
       		      str = str1.toString();
       		      
            	   
               }
          
             planTextArea.setText(str);
             
             str ="";
		
		
		if(genericEMRChartingController.vitalSign.size() > 0){
		
		objectiveTextArea.setText("Examination\n\nHeight: "+genericEMRChartingController.vitalSign.get(0).getHeightInInches()
				+" inches. Weight: "+genericEMRChartingController.vitalSign.get(0).getWeightLb()
				+"pounds,"+genericEMRChartingController.vitalSign.get(0).getWeightOz()+" ounces."
						+ " BMI :"+genericEMRChartingController.vitalSign.get(0).getBmi()
						+" Body Fat:"+genericEMRChartingController.vitalSign.get(0).getBodyFat()
						+" Abdominal Circumference "+genericEMRChartingController.vitalSign.get(0).getAbdominalInches()
						+" Temperature "+genericEMRChartingController.vitalSign.get(0).getFarenhiet()+"F.Blood Pressure: "
						+genericEMRChartingController.vitalSign.get(0).getSystolic()+"/"+genericEMRChartingController.vitalSign.get(0).getDystolic()
						+". Pulse "+genericEMRChartingController.vitalSign.get(0).getPulsePerRate()
						+" "+genericEMRChartingController.vitalSign.get(0).getPatientPositionAtTimeReading()+" Respiration "
						+genericEMRChartingController.vitalSign.get(0).getBreathPerMinute()+". Pulse Oxy "+genericEMRChartingController.vitalSign.get(0).getPulseoximetry()
						+"% RA. "+Global.patientVisitObj.getProvider().getFirstName()+" "+Global.patientVisitObj.getProvider().getMiddleName()+" "
						+Global.patientVisitObj.getProvider().getLastName()
						+"\n\n EXAM"+genericEMRChartingController.examStaticStringTextareaBuild+"\n\n"+"Diagnostic Test Results\n"
						+genericEMRChartingController.resultStaticStringTextareaBuild);
		}else{
			
			objectiveTextArea.setText("\n\n EXAM"+genericEMRChartingController.examStaticStringTextareaBuild+"\n\n"+"Diagnostic Test Results\n"
						+genericEMRChartingController.resultStaticStringTextareaBuild);
			
		}
	
    }
	    private GenericEMRChartingController genericEMRChartingController;
	  
	    public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController) {
			this.genericEMRChartingController = genericEMRChartingController;
		    
			
						
		}
	  
	    FXMLFormPath  formPath = new FXMLFormPath();
	    
	    List<BuildNote> buildNoteList = null;
	    public void  viewBuildNote(){
	    	
	    	buildNoteList  = new BuildNoteEntityController().viewByPatientVisit(Global.patientVisitObj.getId());
	    	
	    }
	    
	    
	    public void viewPastBuildNote(){
	    	
	    	if(patientVisit != null){
	    	buildNoteList	= new BuildNoteEntityController().viewByPatientVisit(patientVisit.getId()); 
	    	
	    	
	    	if(buildNoteList.size() > 0){
	    		
	    	subjectiveTextArea.setText(buildNoteList.get(0).getBuildNoteSubjective());
	    	objectiveTextArea.setText(buildNoteList.get(0).getBuildNoteObjective());
	    	asesmentTextArea.setText(buildNoteList.get(0).getAssessment());
	    	planTextArea.setText(buildNoteList.get(0).getPlan());
	    	
	    	if(buildNoteList.get(0).getPatientVisit().getProvider() != null){
	    		
	    	providerLabel.setText(buildNoteList.get(0).getPatientVisit().getProvider().getFirstName()+"  "+buildNoteList.get(0).getPatientVisit().getProvider().getMiddleName()+" "+buildNoteList.get(0).getPatientVisit().getProvider().getLastName());
	    	
	    	if(buildNoteList.get(0).getPatientVisit().getPurpose() != null){
	    	ummarylabel.setText(buildNoteList.get(0).getPatientVisit().getPurpose());
	    	}
	    	}
	    	
           if(buildNoteList.get(0).getPatientVisit().getVisitDate()!=null){
	    	dateLabel.setText(buildNoteList.get(0).getPatientVisit().getVisitDate().toString());
           }
	    	
	    	if(buildNoteList.get(0).getPatientVisit().getClinician() != null){
	    		
	    		clinicianlabel.setText(buildNoteList.get(0).getPatientVisit().getClinician().getFirstName()+"  "+buildNoteList.get(0).getPatientVisit().getClinician().getMiddleName()+
		    			" "+buildNoteList.get(0).getPatientVisit().getClinician().getLastName()
		    			);
		    		
	    	}
	    
	    	}
	    	}
	    	
	    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		
		if(genericEMRChartingController != null){
			
			setBuildNote();
		}
		
		
		
		saveBtn.setOnAction((event) -> {
			
			BuildNote buildNote = new BuildNote();
			buildNote.setAssessment(asesmentTextArea.getText());
			buildNote.setBuildNoteObjective(objectiveTextArea.getText());
			buildNote.setBuildNoteSubjective(subjectiveTextArea.getText());
			buildNote.setPlan(planTextArea.getText());
			buildNote.setPatientVisit(Global.patientVisitObj);
			
			viewBuildNote();
			
            if(buildNoteList.size() > 0){
            	
            	
            	buildNote.setId(buildNoteList.get(0).getId());
	    		new BuildNoteEntityController().saveOrUpdate(buildNote);
	    		
	    	}else{
	    		
	    		new BuildNoteEntityController().saveOrUpdate(buildNote);
	    		
	    	}
			
		
			new FXFormCommonUtilities().closeForm(saveBtn);
		});
		
		cancelBtn.setOnAction((event) -> {
			try {

				new FXFormCommonUtilities().closeForm(cancelBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	/*	
		printBtn.setOnAction((event) -> {

			String formName1 = formPath.context.getMessage("ProgressBar", null, Locale.US);

			String formTitle1 = formPath.context.getMessage("Title.ProgressBar.", null, Locale.US);
			formPath.closeApplicationContext();

			// Need the ProgressBar controller to access the progress bar in
			// this method
			ProgressBarGUIController progressBarGUIController = (ProgressBarGUIController) new FXFormCommonUtilities()
					.displayFormAndGetController(formName1, formTitle1);
			ProgressBar progressBar = progressBarGUIController.getProgressBar();

			*//********************************
			 * Start of Task definition
			 *****************************************************************//*
			Task<ObservableList<MedicalActivityCharge>> task =

					new Task<ObservableList<MedicalActivityCharge>>() {

						@Override
						protected ObservableList<MedicalActivityCharge> call() throws Exception {
						
							ObservableList<MedicalActivityCharge> medicalActivityChargeList = null;
						//MedicalActivityCharge medicalActivityChargeList = null;
							try {

								System.out.println("Generating PDF...");

								String printMedicalActivityCharge= formPath.context.getMessage("Print.ProcessCharges", null, Locale.US);

								formPath.closeApplicationContext();

								//InputStream is = new FileInputStream(new File(printClinician));
								InputStream is = this.getClass().getResourceAsStream(printMedicalActivityCharge);
								JasperReport jasperReport = JasperCompileManager.compileReport(is);

								
								
								
								MedicalActivityCharge medicalActivityCharge2 = new MedicalActivityCharge();
								medicalActivityChargeList = new  MedicalActivityChargeEntityController().searchByDateAndOverride(Global.patientVisitObj.getId(), date1, date2, overrideStr);
								
								//new MedicalActivityChargeViewController().viewChargeAfterBilling(medicalActivityChargeList.);
							
								JRDataSource JRdataSource = new JRBeanCollectionDataSource(medicalActivityChargeList);
								Map<String, Object> map = new HashMap<String, Object>();
								JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, map, JRdataSource);

								JasperViewer.viewReport(jasperPrint, false);

								System.out.println("FirstReport.pdf has been generated!");

							} catch (Exception ex) {
								ex.printStackTrace();
							}

							if (isCancelled()) {
								return null;
							}
							return medicalActivityChargeList;

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

			});

		
		
	});*/

}
}
