package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntOtoscopicInputController Class
 *Description: entNasalMucosa.fxml Controller class
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

public class EntOtoscopicInputController implements Initializable{
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox canalLeftAllNormalCkeckBox;

    @FXML
    private CheckBox canalLeftNormalCkeckBox;

    @FXML
    private CheckBox canalLeftCerumenouslCkeckBox;

    @FXML
    private CheckBox canalLeftErythematousCkeckBox;

    @FXML
    private CheckBox canalLeftExudatesCkeckBox;

    @FXML
    private CheckBox tympanicNormalCheck;

    @FXML
    private CheckBox tympanicErythematousCheck;

    @FXML
    private CheckBox tympanicBulgingCheck;

    @FXML
    private CheckBox tympanicRetractedCheck;

    @FXML
    private CheckBox tympanicFluidCheck;

    @FXML
    private CheckBox tympanicPerforationCheck;

    @FXML
    private CheckBox tympanicForeignBodyCheck;

    @FXML
    private CheckBox tympanicPETubeCheck;

    @FXML
    private CheckBox tympanicBloodCheck;

    @FXML
    private CheckBox tympanicMucusCheck;

    @FXML
    private CheckBox tympanicRightNormalCheck;

    @FXML
    private CheckBox tympanicRightErythematousCheck;

    @FXML
    private CheckBox tympanicRightFluidCheck;

    @FXML
    private CheckBox tympanicRightPerforationCheck;

    @FXML
    private CheckBox tympanicRightBloodCheck;

    @FXML
    private CheckBox tympanicRightMucusCheck;

    @FXML
    private CheckBox tympanicRightForeignBodyCheck;

    @FXML
    private CheckBox tympanicRightPETubeCheck;

    @FXML
    private CheckBox canalLeftPETubeCkeckBox;

    @FXML
    private CheckBox canalLeftForeignBodyCkeckBox;

    @FXML
    private CheckBox canalLeftTenderTractionCkeckBox;

    @FXML
    private CheckBox canalLeftBloodCkeckBox;

    @FXML
    private CheckBox canalRightNormalCkeckBox;

    @FXML
    private CheckBox canalRightTenderTractionCkeckBox;

    @FXML
    private CheckBox canalRightErythematousCkeckBox;

    @FXML
    private CheckBox canalRightBloodCkeckBox;

    @FXML
    private CheckBox canalRightExudatesCkeckBox;

    @FXML
    private CheckBox canalRightForeignBodyCkeckBox;

    @FXML
    private CheckBox tympanicRightBulgingCheck;

    @FXML
    private CheckBox tympanicRightRetractedCheck;

    @FXML
    private CheckBox canalRightPETubeCkeckBox;

    @FXML
    private CheckBox canalRightCerumenouslCkeckBox;
    
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
			
			if(canalLeftAllNormalCkeckBox.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if(canalLeftBloodCkeckBox.isSelected() || canalLeftNormalCkeckBox.isSelected() || canalLeftCerumenouslCkeckBox.isSelected() 
						|| canalLeftErythematousCkeckBox.isSelected() || canalLeftExudatesCkeckBox.isSelected() || canalLeftTenderTractionCkeckBox.isSelected() 
						|| canalLeftForeignBodyCkeckBox.isSelected() || canalLeftPETubeCkeckBox.isSelected()){
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("");
					examEntInputController.str = str11.toString();
					
					
					
					if (canalLeftBloodCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftCerumenouslCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftErythematousCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftExudatesCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftTenderTractionCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftForeignBodyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (canalLeftPETubeCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
					
				}
				
				
				
				
			}
			
			
			
			
			
			
			
			
			if (canalRightBloodCkeckBox.isSelected() || canalRightCerumenouslCkeckBox.isSelected() || canalRightErythematousCkeckBox.isSelected() 
					|| canalRightExudatesCkeckBox.isSelected() || canalRightForeignBodyCkeckBox.isSelected() || canalRightNormalCkeckBox.isSelected()
					|| canalRightPETubeCkeckBox.isSelected() || canalRightTenderTractionCkeckBox.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("");
				examEntInputController.str = str11.toString();
				
				if (canalRightBloodCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (canalRightCerumenouslCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (canalRightErythematousCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (canalRightExudatesCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (canalRightForeignBodyCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (canalRightNormalCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (canalRightPETubeCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (canalRightTenderTractionCkeckBox.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}
				
				StringBuilder str12 = new StringBuilder(examEntInputController.str);
				str12.append(".");
				examEntInputController.str = str12.toString();
				
				
			}
			
			
			
			
			
			
			
				
				
				if (tympanicBloodCheck.isSelected() || tympanicBulgingCheck.isSelected() || tympanicErythematousCheck.isSelected() || tympanicRetractedCheck.isSelected()
						|| tympanicFluidCheck.isSelected() || tympanicForeignBodyCheck.isSelected() || tympanicMucusCheck.isSelected()
						|| tympanicNormalCheck.isSelected() || tympanicPerforationCheck.isSelected() || tympanicPETubeCheck.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("");
					examEntInputController.str = str11.toString();
					
					
					
					if (tympanicBloodCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicBulgingCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicErythematousCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicRetractedCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicFluidCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicForeignBodyCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicMucusCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicPerforationCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}if (tympanicPETubeCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("");
						examEntInputController.str = str1.toString();
						
					}
					
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
				}
				
			
			
			
			
			
			
			
			
			
			if (tympanicRightBloodCheck.isSelected() || tympanicRightBulgingCheck.isSelected() || tympanicRightErythematousCheck.isSelected() || tympanicRightFluidCheck.isSelected()
					|| tympanicRightForeignBodyCheck.isSelected() || tympanicRightMucusCheck.isSelected() || tympanicRightNormalCheck.isSelected()
					|| tympanicRightPerforationCheck.isSelected() || tympanicRightPETubeCheck.isSelected() || tympanicRightRetractedCheck.isSelected()) {
				
				StringBuilder str11 = new StringBuilder(examEntInputController.str);
				str11.append("");
				examEntInputController.str = str11.toString();
				
				
				
				if (tympanicRightBloodCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightBulgingCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightErythematousCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightFluidCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightForeignBodyCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightMucusCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightPerforationCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightPETubeCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
					examEntInputController.str = str1.toString();
					
				}if (tympanicRightRetractedCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("");
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
