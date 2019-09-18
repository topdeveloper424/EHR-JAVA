package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntEarNoseExternalInputController Class
 *Description: entEar&NoseExternal.fxml Controller class
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


import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.AnchorPane;

public class EntEarNoseExternalInputController implements Initializable{
	
	 @FXML
	    private AnchorPane stoolSampleFrankBloodCheckBox;

	    @FXML
	    private CheckBox externalLeftNormalCkeckBox;

	    @FXML
	    private CheckBox externalLeftTenderTractionCkeckBox;

	    @FXML
	    private CheckBox externalLeftCerumenousCkeckBox;

	    @FXML
	    private CheckBox externalLeftErythematouCkeckBox;

	    @FXML
	    private CheckBox externalRightNormalCkeckBox;

	    @FXML
	    private CheckBox externalLeftAtrophicCkeckBox;

	    @FXML
	    private CheckBox externalRightErythematouCkeckBox;

	    @FXML
	    private CheckBox externalRightCerumenousCkeckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox externalLeftAllNormalCkeckBox;

	    @FXML
	    private CheckBox externalLeftPiercedCkeckBox;

	    @FXML
	    private CheckBox externalRightPiercedCkeckBox;

	    @FXML
	    private CheckBox noseNormalCkeckBox;

	    @FXML
	    private CheckBox noseMarkedCkeckBox;

	    @FXML
	    private CheckBox externalRightAtrophicCkeckBox;

	    @FXML
	    private CheckBox externalRightTenderTractionCkeckBox;

	    @FXML
	    private CheckBox noseRhonphymaCkeckBox;

	    @FXML
	    private CheckBox noseErythematouslCkeckBox;

	    @FXML
	    private CheckBox noseDepressedCkeckBox;
	    
	    private ExamEntInputController examEntInputController;
		
		public void setExamEntInputController(ExamEntInputController examEntInputController) {
			this.examEntInputController = examEntInputController;
		}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examComp = new StringBuilder(examEntInputController.str);
			examComp.append("\n\n: ");
			examEntInputController.str = examComp.toString();
			
			
				
if (externalLeftAllNormalCkeckBox.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("External ears appear normal. ");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (externalLeftAtrophicCkeckBox.isSelected() || externalLeftCerumenousCkeckBox.isSelected() || externalLeftErythematouCkeckBox.isSelected() 
						|| externalLeftNormalCkeckBox.isSelected() || externalLeftPiercedCkeckBox.isSelected() || externalLeftTenderTractionCkeckBox.isSelected()) {
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append("External ears: ");
					examEntInputController.str = str12.toString();
					
					if (externalLeftAtrophicCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("atrophic cartilage, ");
						examEntInputController.str = str1.toString();
								
					}if (externalLeftCerumenousCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("cerumenous, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftErythematouCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("erythematous, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("left ear normal, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftPiercedCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("pierced lobes, ");
						examEntInputController.str = str1.toString();
						
					}if (externalLeftTenderTractionCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("tender on traction on tragus, ");
						examEntInputController.str = str1.toString();
						
					}
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append(".");
					examEntInputController.str = str11.toString();
					
				}
				
				
			}
			
			


if (externalRightAtrophicCkeckBox.isSelected() || externalRightCerumenousCkeckBox.isSelected() || externalRightErythematouCkeckBox.isSelected()
		|| externalRightNormalCkeckBox.isSelected() || externalRightPiercedCkeckBox.isSelected() || externalRightTenderTractionCkeckBox.isSelected()) {
	
	StringBuilder str12 = new StringBuilder(examEntInputController.str);
	str12.append("External ears: ");
	examEntInputController.str = str12.toString();
	
	
	if (externalRightAtrophicCkeckBox.isSelected()) {
		
		StringBuilder str1 = new StringBuilder(examEntInputController.str);
		str1.append("atrophic cartilage, ");
		examEntInputController.str = str1.toString();
		
	}if (externalRightCerumenousCkeckBox.isSelected()) {
		
		StringBuilder str1 = new StringBuilder(examEntInputController.str);
		str1.append("cerumenous, ");
		examEntInputController.str = str1.toString();
		
	}if (externalRightErythematouCkeckBox.isSelected()) {
		
		StringBuilder str1 = new StringBuilder(examEntInputController.str);
		str1.append("erythematous, ");
		examEntInputController.str = str1.toString();
		
	}if (externalRightNormalCkeckBox.isSelected()) {
		
		StringBuilder str1 = new StringBuilder(examEntInputController.str);
		str1.append("right ear normal, ");
		examEntInputController.str = str1.toString();
		
	}if (externalRightPiercedCkeckBox.isSelected()) {
		
		StringBuilder str1 = new StringBuilder(examEntInputController.str);
		str1.append("pierced lobes, ");
		examEntInputController.str = str1.toString();
		
	}if (externalRightTenderTractionCkeckBox.isSelected()) {
		
		StringBuilder str1 = new StringBuilder(examEntInputController.str);
		str1.append("tender on traction on tragus, ");
		examEntInputController.str = str1.toString();
		
	}
	
					
	StringBuilder str11 = new StringBuilder(examEntInputController.str);
	str11.append(".");
	examEntInputController.str = str11.toString();
	
	
}





	
	if (noseErythematouslCkeckBox.isSelected() || noseMarkedCkeckBox.isSelected() || noseNormalCkeckBox.isSelected()
			|| noseRhonphymaCkeckBox.isSelected() || noseDepressedCkeckBox.isSelected()) {
		
		StringBuilder str11 = new StringBuilder(examEntInputController.str);
		str11.append("Nose: ");
		examEntInputController.str = str11.toString();
		 
		
		if (noseErythematouslCkeckBox.isSelected()) {
			
			StringBuilder str1 = new StringBuilder(examEntInputController.str);
			str1.append("erythematous, ");
			examEntInputController.str = str1.toString();
			
		}if (noseMarkedCkeckBox.isSelected()) {
			
			StringBuilder str1 = new StringBuilder(examEntInputController.str);
			str1.append("marked septal deviation, ");
			examEntInputController.str = str1.toString();
			
		}if (noseNormalCkeckBox.isSelected()) {
			
			StringBuilder str1 = new StringBuilder(examEntInputController.str);
			str1.append("normal, ");
			examEntInputController.str = str1.toString();
			
		}if (noseRhonphymaCkeckBox.isSelected()) {
			
			StringBuilder str1 = new StringBuilder(examEntInputController.str);
			str1.append("rhonphyma noted, ");
			examEntInputController.str = str1.toString();
			
		}if (noseDepressedCkeckBox.isSelected()) {
			
			StringBuilder str1 = new StringBuilder(examEntInputController.str);
			str1.append("depressed bridge of nose, ");
			examEntInputController.str = str1.toString();
			
		}
		
		
		StringBuilder str12 = new StringBuilder(examEntInputController.str);
		str12.append(".");
		examEntInputController.str = str12.toString();
		
		
		
	}
	
		
		
			
			
			
			++examEntInputController.formCount;	
			examEntInputController.setEntUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examEntInputController.formCount;	
				examEntInputController.setEntUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
