package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.chest;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ChestExamComprehensiveInputController Class
 *Description: chestExamComprehensive.fxml GUI Controller class
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
public class ChestExamComprehensiveInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox ribSplintingRight;

    @FXML
    private CheckBox ribParadoxicalRight;

    @FXML
    private CheckBox ribSplintingLeft;

    @FXML
    private CheckBox ribParadoxicalLeft;

    @FXML
    private CheckBox ribSymmetrical;

    @FXML
    private CheckBox OtherEcchymosis;

    @FXML
    private CheckBox OtherAbrasions;

    @FXML
    private CheckBox OtherLacerations;

    @FXML
    private CheckBox otherNo;

    @FXML
    private CheckBox LocationAnterior;

    @FXML
    private CheckBox LocationPosterior;

    @FXML
    private CheckBox locationLeft;

    @FXML
    private CheckBox LocationRight;

    @FXML
    private CheckBox ribNormal;

    @FXML
    private CheckBox otherNormal;

    @FXML
    private CheckBox LocationParaspinous;

    @FXML
    private CheckBox LocationAxillary;

    @FXML
    private CheckBox LocationCostochondral;
    
    private ExamMusculotoneChestInputController examMusculotoneChestInputController;
	
   	public void setExamMusculotoneChestInputController(
   			ExamMusculotoneChestInputController examMusculotoneChestInputController) {
   		this.examMusculotoneChestInputController = examMusculotoneChestInputController;
   	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneChestInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneChestInputController.str = examComp.toString();

			if (ribNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneChestInputController.str);
				str11.append("Exam of the ribs shows symmetrical movement. ");
				examMusculotoneChestInputController.str = str11.toString();

			} else {

				if (ribParadoxicalLeft.isSelected() || ribParadoxicalRight.isSelected()
						|| ribSplintingLeft.isSelected() || ribSplintingRight.isSelected()
						|| ribSymmetrical.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneChestInputController.str);
					str11.append("Exam of the ribs shows ");
					examMusculotoneChestInputController.str = str11.toString();
					  
					if (ribParadoxicalLeft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("paradoxical movement left, ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (ribParadoxicalRight.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("paradoxical movement right , ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (ribSplintingLeft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("splinting left, ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (ribSplintingRight.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("splinting right, ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (ribSymmetrical.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("symmetrical movement, ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
					str1.append(".");
					examMusculotoneChestInputController.str = str1.toString();

				}

			}

			
			if (otherNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneChestInputController.str);
				str11.append("No abrasions, ecchymosis or lacerations noted. ");
				examMusculotoneChestInputController.str = str11.toString();

			} else {

				if (otherNo.isSelected() || OtherAbrasions.isSelected()
						|| OtherEcchymosis.isSelected() || OtherLacerations.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneChestInputController.str);
					str11.append("Noted ");
					examMusculotoneChestInputController.str = str11.toString();

					if (otherNo.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append(" no other abnormalities, ");
						examMusculotoneChestInputController.str = str1.toString();

					} 
					if (OtherAbrasions.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("abrasions, ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (OtherEcchymosis.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("ecchymosis, ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (OtherLacerations.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("lacerations ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					
					

				}

			}

			

				if (locationLeft.isSelected() || LocationRight.isSelected()
						|| LocationAnterior.isSelected() || LocationPosterior.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneChestInputController.str);
					str11.append("in the ");
					examMusculotoneChestInputController.str = str11.toString();

					if (locationLeft.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("left ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (LocationRight.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("right ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (LocationAnterior.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("anterior ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (LocationPosterior.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("posterior ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					


				}
				
				
				
				
				
				if (LocationAxillary.isSelected() || LocationParaspinous.isSelected()
						|| LocationCostochondral.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneChestInputController.str);
					str11.append("in the ");
					examMusculotoneChestInputController.str = str11.toString();

					if (LocationAxillary.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("axillary line, ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (LocationParaspinous.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("paraspinous area ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					if (LocationCostochondral.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
						str1.append("costochondral junction ");
						examMusculotoneChestInputController.str = str1.toString();

					}
					
					

					StringBuilder str1 = new StringBuilder(examMusculotoneChestInputController.str);
					str1.append(".");
					examMusculotoneChestInputController.str = str1.toString();

				}

		
			

			++examMusculotoneChestInputController.formCount;
			examMusculotoneChestInputController.setChestUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneChestInputController.formCount;
				examMusculotoneChestInputController.setChestUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
		
	}

}
