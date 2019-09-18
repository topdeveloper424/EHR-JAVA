package com.ets.controller.gui.genericVisitProtocal;

import java.io.InputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import com.ets.controller.entity.medicalactivity.MedicalActivityEntityController;
import com.ets.controller.entity.patientBillingInvoice.PatientBillingInvoiceEntityController;
import com.ets.controller.entity.vitalSign.VitalSignEntityController;
import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.procedure.MedicalProcedureInputController;
import com.ets.controller.gui.progressBar.ProgressBarGUIController;
import com.ets.model.MedicalActivity;
import com.ets.model.MedicalActivityCharge;
import com.ets.model.PatientBillingInvoice;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;
import com.ets.model.VitalSign;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RespirationGraphController  implements Initializable{

	private GraphVitalsInputController GraphVitalsInputController;
	  
	   
	   Integer resp = 0;;
		public void setGraphVitalsInputController(GraphVitalsInputController graphVitalsInputController,String resp) {
		GraphVitalsInputController = graphVitalsInputController;
		this.resp = Integer.parseInt(resp);
		}

		@FXML
	    void onMouseClick(MouseEvent event) {
			
			
			lineChartGraph.getData().clear();
			XYChart.Series<String, Number> series = new XYChart.Series<String,Number>();
			
			
			
			series.getData().add(new XYChart.Data<String, Number>("30", 30));
			
			series.getData().add(new XYChart.Data<String, Number>(resp.toString(), resp));
			
			 
			
			
			
			//lineChartGraph.seta
			
			lineChartGraph.getData().addAll(series);
	       
			visitDateLabel2.setText(Global.patientVisitObj.getVisitDate().toString());
			visitDateLabel.setText(Global.patientVisitObj.getVisitDate().toString());
			System.out.println("****************");
	    }
		
		
		FXMLFormPath formPath = new FXMLFormPath();


	    @FXML
	    private AnchorPane lincChartAnchorPane;

	    @FXML
	    private LineChart<String, Number> lineChartGraph;

	    @FXML
	    private Label visitDateLabel2;

	    @FXML
	    private Label visitDateLabel;

	    @FXML
	    private Button printBtn;

	    @FXML
	    private Button cancelBtn;

	    private void print(Node node) {
	        System.out.println("Creating a printer job...");

	        PrinterJob job = PrinterJob.createPrinterJob();
	        if (job != null) {
	          System.out.println(job.jobStatusProperty().asString());

	          boolean printed = job.printPage(node);
	          if (printed) {
	            job.endJob();
	          } else {
	            System.out.println("Printing failed.");
	          }
	        } else {
	          System.out.println("Could not create a printer job.");
	        }
	      }
		@Override
		public void initialize(URL location, ResourceBundle resources) {
			
			cancelBtn.setOnAction((event) -> {
				try {

					new FXFormCommonUtilities().closeForm(cancelBtn);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			
			
			
			printBtn.setOnAction(e -> print(lincChartAnchorPane));

			
			
			
		
		}
		
		  
	}
