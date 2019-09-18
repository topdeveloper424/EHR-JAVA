package com.ets.controller.gui.pulmonaryFunction;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.model.SpirometerTestParamGen;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TextField;
public class EnterNewPulomanoryfunctionParametersController implements Initializable{
	

	 @FXML
	    private ComboBox<String> methodForCalculatingPredictedValuesChoicebox;

	    @FXML
	    private TextField asiantext;

	    @FXML
	    private TextField blackText;

	    @FXML
	    private TextField hispanicText;

	    @FXML
	    private TextField FVCnoObstrictiveDiseaseFirstText;

	    @FXML
	    private TextField FVCthruFirstText;

	    @FXML
	    private TextField FVCfromFirstText;

	    @FXML
	    private TextField FVCnoObstrictiveDiseaseSecondText;

	    @FXML
	    private TextField FVCthruSecondText;

	    @FXML
	    private TextField FVCfromSecondText;

	    @FXML
	    private TextField FVCnoObstrictiveDiseaseThirdText;

	    @FXML
	    private TextField FVCthruThirdText;

	    @FXML
	    private TextField FVCfromThirdText;

	    @FXML
	    private TextField FEVInoObstrictiveDiseaseFirstText;

	    @FXML
	    private TextField FEVIthruFirstText;

	    @FXML
	    private TextField FEVIfromFirstText;

	    @FXML
	    private TextField FEVInoObstrictiveDiseaseSecondText;

	    @FXML
	    private TextField FEVIthruSecondText;

	    @FXML
	    private TextField FEVIfromSecondText;

	    @FXML
	    private TextField FEVInoObstrictiveDiseaseThirdText;

	    @FXML
	    private TextField FEVIthruThirdText;

	    @FXML
	    private TextField FEVIfromThirdText;

	    @FXML
	    private TextField resultCodeForNormalText;

	    @FXML
	    private TextField midText;

	    @FXML
	    private TextField modText;

	    @FXML
	    private TextField worstText;

	    @FXML
	    private TextField firstLevelText;

	    @FXML
	    private TextField FEVIpercentageFirstText;

	    @FXML
	    private TextField FVCpercentageFirstText;

	    @FXML
	    private TextField secondLevelText;

	    @FXML
	    private TextField FEVIpercentageSecondText;

	    @FXML
	    private TextField FVCpercentageSecondText;

	    @FXML
	    private TextField thirdLevelText;

	    @FXML
	    private TextField FEVIpercentageThirdText;

	    @FXML
	    private TextField FVCpercentageThirdText;

	    @FXML
	    private TextField fourthLevelText;

	    @FXML
	    private TextField FEVIpercentageFourthText;

	    @FXML
	    private TextField FVCpercentageFourthText;

	    @FXML
	    private Button medicalActivityBtn;

	    @FXML
	    private Button visitCategoryBtn;

	    @FXML
	    private Button spirometerEquipmentBtn;

	    @FXML
	    private Button okBtn;

	    @FXML
	    private Button close;
	    
	    public void setPulmonaryFunction(){
	    	
	    	ObservableList<String> items = FXCollections.observableArrayList("Knudson(1987)/IMTS", "J Morris", "EDCS",
	    			"Knudson(1976)","Knudson(1986)","NHANES III(1999)");
	    	methodForCalculatingPredictedValuesChoicebox.setItems(items);
	    	methodForCalculatingPredictedValuesChoicebox.setValue("Knudson(1987)/IMTS");
			
	    	asiantext.setText("15");
	    	blackText.setText("15");
	    	hispanicText.setText("0");
	    	
	    	FVCnoObstrictiveDiseaseFirstText.setText("Mild Restrictive Disease");
	    	FVCnoObstrictiveDiseaseSecondText.setText("Moderate Restrictive Disease");
	    	FVCnoObstrictiveDiseaseThirdText.setText("Severe Restrictive Disease");
	    	FVCthruFirstText.setText("66");
	    	FVCthruSecondText.setText("51");
	    	FVCthruThirdText.setText("0");
	    	FVCfromFirstText.setText("79");
	    	FVCfromSecondText.setText("65");
	    	FVCfromThirdText.setText("50");
	    	
	    	FEVInoObstrictiveDiseaseFirstText.setText("Mild Objective Disease");
	    	FEVInoObstrictiveDiseaseSecondText.setText("Moderate Objective Disease");
	    	FEVInoObstrictiveDiseaseThirdText.setText("Severe Objective Disease");
	    	
	    	FEVIthruFirstText.setText("66");
	    	FEVIthruSecondText.setText("51");
	    	FEVIthruThirdText.setText("0");
	    	
	    	FEVIfromFirstText.setText("79");
	    	FEVIfromSecondText.setText("65");
	    	FEVIfromThirdText.setText("50");
	    	
	    	resultCodeForNormalText.setText("N");
	    	midText.setText("A");
	    	modText.setText("A");
	    	worstText.setText("A");
	    	
	    	
	    	
	    }
	    
	    FXMLFormPath formPath = new FXMLFormPath();

		@Override
		public void initialize(URL location, ResourceBundle resources) {
			setPulmonaryFunction();
			spirometerEquipmentBtn.setOnAction((event) -> {
				try {
				
					String formName = formPath.context.getMessage("ViewSpiroMeter", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.ViewSpiroMeter", null, Locale.US);
					formPath.closeApplicationContext();
				
					new FXFormCommonUtilities().displayForm( formName , formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
		
			
			medicalActivityBtn.setOnAction((event) -> {
				try {
				
					String formName = formPath.context.getMessage("MedicalActivity", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.MedicalActivity", null, Locale.US);
					formPath.closeApplicationContext();
				
					new FXFormCommonUtilities().displayForm( formName , formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			visitCategoryBtn.setOnAction((event) -> {
				try {
				//  Load and Display - Select_Visit_Category_Code.fxml Form
					String formName = formPath.context.getMessage("VisitCategory", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.VisitCategory", null, Locale.US);
					formPath.closeApplicationContext();
				
					new FXFormCommonUtilities().displayForm( formName , formTitle);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
			
			okBtn.setOnAction((event) -> {
				
				/*SpirometerTestParamGen spirometerTestParamGen = new SpirometerTestParamGen();
				
				spirometerTestParamGen.setMethCalcPredictVal(methCalcPredictVal);
				spirometerTestParamGen.setRaceCorrectAsian(raceCorrectAsian);
				spirometerTestParamGen.setRaceCorrectBlack(raceCorrectBlack);
				spirometerTestParamGen.setRaceCorrectHispanic(raceCorrectHispanic);*/
				
				new FXFormCommonUtilities().closeForm( okBtn);
				
			});
			
			close.setOnAction((event) -> {
				try {
					//cancel centralized form
					new FXFormCommonUtilities().closeForm( close);
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			});
				
		}

	}


