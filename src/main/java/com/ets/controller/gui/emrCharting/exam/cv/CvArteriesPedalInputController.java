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
 *Parameter Definition: Type object of CvArteriesPedalInputController Class
 *Description: cvArteriesPedal GUI Controller class
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
public class CvArteriesPedalInputController implements Initializable {

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox pedalLeft3;

	@FXML
	private CheckBox pedalLeft4;

	@FXML
	private CheckBox pedalLeftDorsalisPedis;

	@FXML
	private CheckBox pedalLeft2;

	@FXML
	private CheckBox pedalLeft1;

	@FXML
	private CheckBox pedalLeft0;
	
	@FXML
	private CheckBox PedalLeftNormal;

	@FXML
	private CheckBox pedalLeftNormal;

	@FXML
	private CheckBox pedalLeftPosterior;

	@FXML
	private CheckBox pedalRight3;

	@FXML
	private CheckBox pedalRight4;

	@FXML
	private CheckBox pedalRightDorsalis;

	@FXML
	private CheckBox pedalRight2;

	@FXML
	private CheckBox pedalRight1;

	@FXML
	private CheckBox pedalRight0;

	@FXML
	private CheckBox pedalRightNormal;

	@FXML
	private CheckBox pedalRightPosterior;

	@FXML
	private CheckBox capillaryNormalRight;

	@FXML
	private CheckBox capillaryDecreasedLeft;

	@FXML
	private CheckBox capillaryNormalLeft;

	@FXML
	private CheckBox capillaryDecreasedBilaterally;

	@FXML
	private CheckBox capillaryNormalBilaterally;

	@FXML
	private CheckBox capillaryDecreasedRight;

	private ExamCvInputController examCvInputController;

	public void setExamCvInputController(ExamCvInputController examCvInputController) {
		this.examCvInputController = examCvInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examCvInputController.str);
			examComp.append("\n\n: ");
			examCvInputController.str = examComp.toString();

			if(PedalLeftNormal.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("Pedal pulses and capillary refill are normal bilaterally. ");
				examCvInputController.str = str1.toString();
				
			}else{
				
				
				
				if (pedalLeft0.isSelected() || pedalLeft1.isSelected() || pedalLeft2.isSelected()
						|| pedalLeft3.isSelected() || pedalLeft4.isSelected() || pedalLeftDorsalisPedis.isSelected()
						|| pedalLeftNormal.isSelected() || pedalLeftPosterior.isSelected()) {

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append("Pedal pulses are: left ");
					examCvInputController.str = str11.toString();
					
					
					
					
					if (pedalLeft0.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("0, ");
						examCvInputController.str = str1.toString();

					}
					if (pedalLeft1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+1, ");
						examCvInputController.str = str1.toString();

					}
					if (pedalLeft2.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+2, ");
						examCvInputController.str = str1.toString();

					}
					if (pedalLeft3.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+3, ");
						examCvInputController.str = str1.toString();

					}
					if (pedalLeft4.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+4, ");
						examCvInputController.str = str1.toString();

					}if (pedalLeftDorsalisPedis.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("dorsalis pedis, ");
						examCvInputController.str = str1.toString();

					}
					if (pedalLeftNormal.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("normal, ");
						examCvInputController.str = str1.toString();

					}if (pedalLeftPosterior.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("posterior tibial, ");
						examCvInputController.str = str1.toString();

					}
					
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append(";");
					examCvInputController.str = str1.toString();
					

				}
				
				
				
			}
			
			
			
			
			
			
			if (pedalRight0.isSelected() || pedalRight1.isSelected() || pedalRight2.isSelected()
					|| pedalRight3.isSelected() || pedalRight4.isSelected() || pedalRightDorsalis.isSelected()
					|| pedalRightNormal.isSelected() || pedalRightPosterior.isSelected()) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Pedal pulses are: right ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (pedalRight0.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("0, ");
					examCvInputController.str = str1.toString();

				}if (pedalRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+1, ");
					examCvInputController.str = str1.toString();
					
				}
				if (pedalRight2.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+2, ");
					examCvInputController.str = str1.toString();

				}
				if (pedalRight3.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+3, ");
					examCvInputController.str = str1.toString();

				}
				if (pedalRight4.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+4, ");
					examCvInputController.str = str1.toString();

				}if (pedalRightDorsalis.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("dorsalis pedis, ");
					examCvInputController.str = str1.toString();

				}
				if (pedalRightNormal.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("right ear normal, ");
					examCvInputController.str = str1.toString();

				}
				if (pedalRightPosterior.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("posterior tibial, ");
					examCvInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();

			}
			
			
			
		
			
			
			if (capillaryDecreasedBilaterally.isSelected() || capillaryDecreasedLeft.isSelected() || capillaryDecreasedRight.isSelected()
					|| capillaryNormalBilaterally.isSelected() || capillaryNormalLeft.isSelected() || capillaryNormalRight.isSelected()
					) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Capillary refill is ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (capillaryDecreasedBilaterally.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("decreased bilaterally, ");
					examCvInputController.str = str1.toString();

				}
				if (capillaryDecreasedLeft.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("decreased left, ");
					examCvInputController.str = str1.toString();

				}
				if (capillaryDecreasedRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("decreased right, ");
					examCvInputController.str = str1.toString();

				}
				if (capillaryNormalBilaterally.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("normal bilaterally, ");
					examCvInputController.str = str1.toString();

				}if (capillaryNormalLeft.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("normal left, ");
					examCvInputController.str = str1.toString();

				}
				if (capillaryNormalRight.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("normal right, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("");
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
