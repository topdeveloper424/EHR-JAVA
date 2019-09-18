package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.hip;


/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 06-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HipComprehensiveInputController Class
 *Description: HipExamComprehensive.fxml Controller class
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

public class HipComprehensiveInputController implements Initializable{
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox hipInspectionEffusion;

    @FXML
    private CheckBox hippInspectionSwelling;

    @FXML
    private CheckBox hippInspectionEcchymosis;

    @FXML
    private CheckBox hippInspectionErythema;

    @FXML
    private CheckBox hipInspectionNoAbnormalities;

    @FXML
    private CheckBox hipInspectionNormal;

    @FXML
    private CheckBox palpationNormal;

    @FXML
    private CheckBox strengthFlexion;

    @FXML
    private RadioButton Left;

    @FXML
    private ToggleGroup hipLeft;

    @FXML
    private RadioButton right;

    @FXML
    private CheckBox hippInspectionSurgical;

    @FXML
    private RadioButton palpationNoTenderness;

    @FXML
    private ToggleGroup pal;

    @FXML
    private RadioButton legSymmetric;

    @FXML
    private ToggleGroup leg;

    @FXML
    private RadioButton palpationTenderness;

    @FXML
    private RadioButton legShorter;

    @FXML
    private CheckBox legNormal;

    @FXML
    private RadioButton legLonger;

    @FXML
    private CheckBox restingNormal;

    @FXML
    private RadioButton restingNeutral;

    @FXML
    private ToggleGroup rest;

    @FXML
    private RadioButton restingExternally;

    @FXML
    private RadioButton restingInternally;

    @FXML
    private CheckBox StrengthNormal;

    @FXML
    private CheckBox strengthAbduction;

    @FXML
    private CheckBox strengthExtension;

    @FXML
    private CheckBox strengthAdduction;

    @FXML
    private CheckBox atrophyNormal;

    @FXML
    private CheckBox atrophyNoAtrophy;

    @FXML
    private CheckBox atrophyofTheThigh;

    @FXML
    private CheckBox atrophyofButtocks;
    
    private ExamMusculotoneHipInputController examMusculotoneHipInputController;


	public void setExamMusculotoneHipInputController(ExamMusculotoneHipInputController examMusculotoneHipInputController) {
		this.examMusculotoneHipInputController = examMusculotoneHipInputController;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneHipInputController.str);
			examComp.append("\n\n MUSCULOSKELETAL:");
			examMusculotoneHipInputController.str = examComp.toString();

			if (Left.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append("Inspection of the left hip ");
				examMusculotoneHipInputController.str = str1.toString();

			}

			if (right.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
				str1.append("Inspection of the right hip");
				examMusculotoneHipInputController.str = str1.toString();

			}

			

			if (hipInspectionNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
				str11.append(" no abnormalities.");
				examMusculotoneHipInputController.str = str11.toString();

			} else {

				if (hipInspectionEffusion.isSelected() || hipInspectionNoAbnormalities.isSelected()
						|| hippInspectionEcchymosis.isSelected() || hippInspectionErythema.isSelected()
						|| hippInspectionSurgical.isSelected() || hippInspectionSwelling.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
					str11.append(" reveals");
					examMusculotoneHipInputController.str = str11.toString();

					if (hipInspectionEffusion.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("effusion,");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (hipInspectionNoAbnormalities.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("no abnormalities, ");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (hippInspectionEcchymosis.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("ecchymosis,");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (hippInspectionErythema.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("erythema,");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (hippInspectionSurgical.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("surgical scarring,");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (hippInspectionSwelling.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("swelling ");
						examMusculotoneHipInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
					str1.append(".");
					examMusculotoneHipInputController.str = str1.toString();

				}

			}

			
			
			
			
			
			
			if (palpationNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
				str11.append(" No tenderness to palpation about the hip joint");
				examMusculotoneHipInputController.str = str11.toString();

			} else {

				

					if (palpationNoTenderness.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("There is no tenderness to palpation about the hip joint");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (palpationTenderness.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("There is tenderness to palpation about the hip joint");
						examMusculotoneHipInputController.str = str1.toString();

					}
					
					
				}
			

			

			if (legNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
				str11.append("Leg length is symmetric.");
				examMusculotoneHipInputController.str = str11.toString();

			} else {

				

					if (legLonger.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("Leg length is longer than contralateral leg.");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (legShorter.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("Leg length is shorter than contralateral leg.");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (legSymmetric.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("Leg length is symmetric.");
						examMusculotoneHipInputController.str = str1.toString();

					}
					

			}

			
			
			
			
			if (restingNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
				str11.append("Resting position is neutral.");
				examMusculotoneHipInputController.str = str11.toString();

			} else {

				if (restingExternally.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
					str1.append("Resting position is externally rotated.");
					examMusculotoneHipInputController.str = str1.toString();

				}
				if (restingInternally.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
					str1.append("Resting position is internally rotated.");
					examMusculotoneHipInputController.str = str1.toString();

				}
				if (restingNeutral.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
					str1.append("Resting position is neutral.");
					examMusculotoneHipInputController.str = str1.toString();

				}

			}
			
			
			
			
			
			
			

			

			if (StrengthNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
				str11.append("Strength is normal.");
				examMusculotoneHipInputController.str = str11.toString();

			} else {

				if (strengthAbduction.isSelected() || strengthAdduction.isSelected()
						|| strengthExtension.isSelected() || strengthFlexion.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
					str11.append("Strength is decreased in");
					examMusculotoneHipInputController.str = str11.toString();

					if (strengthAbduction.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("abduction,");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (strengthAdduction.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("adduction");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (strengthExtension.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("extension,");
						examMusculotoneHipInputController.str = str1.toString();

					}if (strengthFlexion.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("flexion,");
						examMusculotoneHipInputController.str = str1.toString();

					}
					

					StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
					str1.append(".");
					examMusculotoneHipInputController.str = str1.toString();

				}

			}

			
			
			
			
			
			if (atrophyNormal.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
				str11.append("There is no atrophy of the buttocks or thighs.");
				examMusculotoneHipInputController.str = str11.toString();

			} else {

				if (atrophyNoAtrophy.isSelected() || atrophyofButtocks.isSelected()
						|| atrophyofTheThigh.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneHipInputController.str);
					str11.append("There is");
					examMusculotoneHipInputController.str = str11.toString();

					if (atrophyNoAtrophy.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append(" no atrophy present,");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (atrophyofButtocks.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("atrophy of the buttocks ");
						examMusculotoneHipInputController.str = str1.toString();

					}
					if (atrophyofTheThigh.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
						str1.append("atrophy of the thigh ");
						examMusculotoneHipInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneHipInputController.str);
					str1.append(".");
					examMusculotoneHipInputController.str = str1.toString();

				}

			}

			
			

			++examMusculotoneHipInputController.formCount;
			examMusculotoneHipInputController.setHipUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneHipInputController.formCount;
				examMusculotoneHipInputController.setHipUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
