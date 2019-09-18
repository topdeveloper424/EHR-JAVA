package com.ets.controller.gui.genericVisitProtocal;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PulseRatesInputController implements Initializable{

       private GraphVitalsInputController GraphVitalsInputController;
	   Integer pulse = 0;;
		public void setGraphVitalsInputController(GraphVitalsInputController graphVitalsInputController,String pulse) {
		GraphVitalsInputController = graphVitalsInputController;
		this.pulse = Integer.parseInt(pulse);
		}

		@FXML
	    void onMouseClick(MouseEvent event) {
			
			
			lineChartGraph.getData().clear();
			XYChart.Series<String, Number> series = new XYChart.Series<String,Number>();
			
			
			
			series.getData().add(new XYChart.Data<String, Number>("91", 91));
			
			series.getData().add(new XYChart.Data<String, Number>(pulse.toString(), pulse));
			
			 
			
			
			
			//lineChartGraph.seta
			
			lineChartGraph.getData().addAll(series);
	       
			visitDateLabel2.setText(Global.patientVisitObj.getVisitDate().toString());
			visitDateLabel.setText(Global.patientVisitObj.getVisitDate().toString());
			System.out.println("****************");
	    }
		@FXML
	    private AnchorPane lineChartAnchorPane;

	    @FXML
	    private LineChart<String, Number> lineChartGraph;

	    @FXML
	    private Label visitDateLabel2;

	    @FXML
	    private Label visitDateLabel;

	    @FXML
	    private Button closeBtn;

	    @FXML
	    private Button printBtn;
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
			
			closeBtn.setOnAction((event) -> {
				try {

					new FXFormCommonUtilities().closeForm(closeBtn);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			
			
			
			printBtn.setOnAction(e -> print(lineChartAnchorPane));

			
			
			
		
		}
		
		  
	}