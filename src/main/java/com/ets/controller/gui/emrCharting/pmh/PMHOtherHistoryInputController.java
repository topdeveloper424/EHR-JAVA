package com.ets.controller.gui.emrCharting.pmh;

import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.pmh.allergy.AspirinInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.BarbituratesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.CodeineInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.LatexAllergyInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.NarcoticAllergiesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.PenicillinesInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.QuinoloneAntibioticsInputController;
import com.ets.controller.gui.emrCharting.pmh.allergy.SulfaDrugsInputController;
import com.ets.controller.gui.emrCharting.pmh.otherHistory.OtherHistoryFreeTextController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class PMHOtherHistoryInputController implements Initializable {
	
	@FXML
    private CheckBox NoSurgeriesCheck;

    @FXML
    private CheckBox FactureHistoryCheck;

    @FXML
    private CheckBox CardiacSurgeryCheck;

    @FXML
    private CheckBox GITractCheck;

    @FXML
    private CheckBox generalCheck;

    @FXML
    private CheckBox femaleCheck;

    @FXML
    private CheckBox otherEventCheck;

    @FXML
    private Button SkipButton;
    
    @FXML
    private Button freeTextButton;

    @FXML
    private Button DoneButton;
    
    private Button button;
    
	
	public GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}
	
	 FXMLFormPath formPath = new FXMLFormPath();
	
	public static Integer formCount = 0;
	
	private Integer secondFormCount = 0;

	public static String str="\n\n";

	public static String strForFreeText = "";
	void formCountIncrement() {
		++secondFormCount;
	}
	
	public void setOtherHistoryUI(){
		
		if (NoSurgeriesCheck.isSelected()) {

			StringBuilder str1 = new StringBuilder(str);
			str1.append("");
			str = str1.toString();
			NoSurgeriesCheck.setSelected(false);
			setOtherHistoryUI();
		}

		else if (secondFormCount == formCount) {
			genericEMRChartingController.paint(button);
			
			formCount = 0;
			genericEMRChartingController.setPmhTextArea(str);
			genericEMRChartingController.saveAllTextArea();
			new FXFormCommonUtilities().closeForm(DoneButton);


		}
		
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		DoneButton.setOnAction((event)->
		{
			
			setOtherHistoryUI();
			
		
		});
		
		SkipButton.setOnAction((event)->
		{
			
			new FXFormCommonUtilities().closeForm(SkipButton);
		
		});
      
		
		freeTextButton.setOnAction((event) -> {
			
			

			if (NoSurgeriesCheck.isSelected()) {
                
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("No Surgeries,");
				strForFreeText = str1.toString();
				NoSurgeriesCheck.setSelected(false);

			}

			 if (FactureHistoryCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Facture History,");
				strForFreeText = str1.toString();
				FactureHistoryCheck.setSelected(false);
			}

			 if (CardiacSurgeryCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("Cardiac Surgery,");
				strForFreeText = str1.toString();
				CardiacSurgeryCheck.setSelected(false);
			}

			 if (GITractCheck.isSelected()) {
				 
				     StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("GITract,");
					strForFreeText = str1.toString();
					GITractCheck.setSelected(false);
			}

			 if (generalCheck.isSelected()) {
				 
				  StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("general,");
					strForFreeText = str1.toString();
					generalCheck.setSelected(false);
			}

			 if (femaleCheck.isSelected()) {
				 
				 StringBuilder str1 = new StringBuilder(strForFreeText);
					str1.append("female,");
					strForFreeText = str1.toString();
					femaleCheck.setSelected(false);
			}  
			 if (otherEventCheck.isSelected()) {
				StringBuilder str1 = new StringBuilder(strForFreeText);
				str1.append("other event,");
				strForFreeText = str1.toString();
				otherEventCheck.setSelected(false);

			}

			
			String formName = formPath.context.getMessage("PMHOtherHistoryFreeText", null, Locale.US);
			String formTitle = formPath.context.getMessage("Title.PMHOtherHistoryFreeText", null, Locale.US);
			
			
			OtherHistoryFreeTextController otherHistory = 
			(OtherHistoryFreeTextController) new FXFormCommonUtilities().displayForm(formName, formTitle);
			formPath.closeApplicationContext();
			otherHistory.setpMHOtherHistoryInputController(this);
						
			new FXFormCommonUtilities().closeForm(freeTextButton);
			
		});

		
	}

}
