package com.ets.controller.gui.emrCharting.exam.cv;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 16-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CvHeartExamCompMultiSysInputController Class
 *Description: HeartExamComprehensiveSingleSystem GUI Controller class
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
public class CvHeartExamCompMultiSysInputController  implements Initializable{
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox palpationNormal;

	    @FXML
	    private CheckBox AuscultationNormal;

	    @FXML
	    private CheckBox SRubNO;

	    @FXML
	    private CheckBox SRubS3;

	    @FXML
	    private CheckBox ApicalNormal;

	    @FXML
	    private CheckBox ApicalHypodynamic;

	    @FXML
	    private CheckBox ApicalHyperdynamic;

	    @FXML
	    private CheckBox ApicalDiffuse;

	    @FXML
	    private CheckBox heartNo;

	    @FXML
	    private CheckBox heartgrade26;

	    @FXML
	    private CheckBox heartgrade45;

	    @FXML
	    private CheckBox heartSoft;

	    @FXML
	    private CheckBox heartDiastolic;

	    @FXML
	    private CheckBox heartGrade16;

	    @FXML
	    private CheckBox heartGrade36;

	    @FXML
	    private CheckBox heartHarsh;

	    @FXML
	    private CheckBox heartBlowing;

	    @FXML
	    private CheckBox heartGrade56;

	    @FXML
	    private CheckBox heartSystolic;

	    @FXML
	    private RadioButton palpationNormalyLocated;

	    @FXML
	    private RadioButton palpationDeviatedLaterally;

	    @FXML
	    private RadioButton AuscultationRegularRadio;

	    @FXML
	    private RadioButton AuscultationIrregularRadio;

	    @FXML
	    private CheckBox heartFunctional;

	    @FXML
	    private CheckBox murmurAortic;

	    @FXML
	    private CheckBox murmurBase;

	    @FXML
	    private CheckBox murmurRadiating;

	    @FXML
	    private CheckBox murmurPulmonic;

	    @FXML
	    private CheckBox murmurApex;
	    
	    @FXML
	    private CheckBox murmurCarotids;

	    @FXML
	    private CheckBox SRubRub;

    
    private ExamCvInputController examCvInputController;

	public void setExamCvInputController(ExamCvInputController examCvInputController) {
		this.examCvInputController = examCvInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examCvInputController.str);
			examComp.append("\n\n:CV ");
			examCvInputController.str = examComp.toString();

			if (palpationNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("Apical impulse is normal. ");
				examCvInputController.str = str1.toString();

			} else {

			

					if (palpationNormalyLocated.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("Apical impulse is normally located. ");
						examCvInputController.str = str1.toString();

					}
					if (palpationDeviatedLaterally.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("Apical impulse is deviated laterally. ");
						examCvInputController.str = str1.toString();

					}
				

			}
			
			
			
			
			
			
			if (ApicalDiffuse.isSelected() || ApicalHyperdynamic.isSelected() 
					|| ApicalHypodynamic.isSelected() || ApicalNormal.isSelected() ) {

				StringBuilder str12 = new StringBuilder(examCvInputController.str);
				str12.append(" and is ");
				examCvInputController.str = str12.toString();

				if (ApicalDiffuse.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("normal, ");
					examCvInputController.str = str1.toString();

				}
				if (ApicalHyperdynamic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("hyperdynamic, ");
					examCvInputController.str = str1.toString();

				}
				if (ApicalHypodynamic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("hypodynamic, ");
					examCvInputController.str = str1.toString();

				}
				if (ApicalNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("diffuse, ");
					examCvInputController.str = str1.toString();

				}
				

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append(".");
				examCvInputController.str = str11.toString();

			}

		
			
			
			
			
			
			
			
			if (AuscultationNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("CV reveals rhythm is normal");
				examCvInputController.str = str1.toString();

			} else {

			

					if (AuscultationRegularRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("CV reveals rhythm is regular. ");
						examCvInputController.str = str1.toString();

					}
					if (AuscultationIrregularRadio.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("CV reveals rhythm is irregular. ");
						examCvInputController.str = str1.toString();

					}
				

			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (heartBlowing.isSelected() || heartDiastolic.isSelected() || heartFunctional.isSelected()
					|| heartGrade16.isSelected() || heartgrade26.isSelected() || heartGrade36.isSelected()
					|| heartgrade45.isSelected() || heartGrade56.isSelected() || heartHarsh.isSelected()
					|| heartNo.isSelected() || heartSoft.isSelected() || heartSystolic.isSelected()) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("CV reveals regular rhythm without murmur, and no S3 or rub. ");
				examCvInputController.str = str11.toString();
				
				  			
				
				
				if (heartBlowing.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("blowing, ");
					examCvInputController.str = str1.toString();

				}
				if (heartDiastolic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("diastolic, ");
					examCvInputController.str = str1.toString();

				}
				if (heartFunctional.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("functional murmur, ");
					examCvInputController.str = str1.toString();

				}
				if (heartGrade16.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("grade 1/6, ");
					examCvInputController.str = str1.toString();

				}if (heartgrade26.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("grade 2/6, ");
					examCvInputController.str = str1.toString();

				}
				if (heartGrade36.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("grade 3/6, ");
					examCvInputController.str = str1.toString();
					
				}
				if (heartgrade45.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("grade 4/5, ");
					examCvInputController.str = str1.toString();

				}
				if (heartGrade56.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("grade 5/6, ");
					examCvInputController.str = str1.toString();

				}if (heartHarsh.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("harsh, ");
					examCvInputController.str = str1.toString();

				}
				if (heartNo.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with no, ");
					examCvInputController.str = str1.toString();

				}
				if (heartSoft.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("soft, ");
					examCvInputController.str = str1.toString();

				}
				if (heartSystolic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("systolic, ");
					examCvInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(".");
				examCvInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
			
			if (murmurAortic.isSelected() || murmurApex.isSelected() || murmurBase.isSelected()
					|| murmurPulmonic.isSelected() || murmurRadiating.isSelected() || murmurCarotids.isSelected()) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("CV reveals regular rhythm without murmur, and no S3 or rub. ");
				examCvInputController.str = str11.toString();
				
				
				
				if (murmurAortic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("loudest in the aortic area, ");
					examCvInputController.str = str1.toString();

				}
				if (murmurApex.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("the apex, ");
					examCvInputController.str = str1.toString();

				}
				if (murmurBase.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("the base, ");
					examCvInputController.str = str1.toString();

				}
				if (murmurPulmonic.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("the pulmonic area, ");
					examCvInputController.str = str1.toString();

				}if (murmurRadiating.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("radiating to base , ");
					examCvInputController.str = str1.toString();

				}
				if (murmurCarotids.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("radiating to carotids, ");
					examCvInputController.str = str1.toString();

				}
				

			}
			
			
			
			
			
			
			if (SRubNO.isSelected() || SRubS3.isSelected() || SRubRub.isSelected()) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("CV reveals regular rhythm without murmur, and no S3 or rub. ");
				examCvInputController.str = str11.toString();
				
				
						
				
				if (SRubNO.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with no S3 or rub, ");
					examCvInputController.str = str1.toString();

				}
				if (SRubS3.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("S3, ");
					examCvInputController.str = str1.toString();

				}
				if (SRubRub.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("rub noted, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(".");
				examCvInputController.str = str1.toString();
				}
				

			
			
			

			++examCvInputController.formCount;
			examCvInputController.setCvUI();
			new FXFormCommonUtilities().closeForm(doneBtn);
			
			
		});

		skipBtn.setOnAction((event) -> {
			try {
				++examCvInputController.formCount;
				examCvInputController.setCvUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
