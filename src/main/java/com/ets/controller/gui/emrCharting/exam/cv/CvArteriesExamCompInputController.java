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
 *Parameter Definition: Type object of CvArteriesExamCompInputController Class
 *Description: cvArteriesExamComp GUI Controller class
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
public class CvArteriesExamCompInputController implements Initializable{
	
	
	  @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox EdemaNormal;

	    @FXML
	    private CheckBox EdemaLeft3;

	    @FXML
	    private CheckBox EdemaLeft4;

	    @FXML
	    private CheckBox EdemaLeftNonPitting;

	    @FXML
	    private CheckBox EdemaLeft2;

	    @FXML
	    private CheckBox EdemaLeft1;

	    @FXML
	    private CheckBox EdemaLeftPitting;

	    @FXML
	    private CheckBox EdemaLeftNone;

	    @FXML
	    private CheckBox VaricositiesLeftNoneCheck;

	    @FXML
	    private CheckBox VaricositiesLeftMildCheck;

	    @FXML
	    private CheckBox VaricositiesLeftModerateCheck;

	    @FXML
	    private CheckBox VaricositiesLeftServeCheck;

	    @FXML
	    private CheckBox VaricositiesLeftWithStasisCheck;

	    @FXML
	    private CheckBox edemaRight3Check;

	    @FXML
	    private CheckBox edemaRight4Check;

	    @FXML
	    private CheckBox edemaRightNonPittinglCheck;

	    @FXML
	    private CheckBox edemaRight2Check;

	    @FXML
	    private CheckBox edemaRight1Check;

	    @FXML
	    private CheckBox edemaRightPittinglCheck;

	    @FXML
	    private CheckBox edemaRightNoneNotedlCheck;

	    @FXML
	    private CheckBox VaricositiesRightNoneCheck;

	    @FXML
	    private CheckBox VaricositiesRightMildCheck;

	    @FXML
	    private CheckBox VaricositiesRightModerateCheck;

	    @FXML
	    private CheckBox VaricositiesRightServeCheck;

	    @FXML
	    private CheckBox VaricositiesRightWithStasisCheck;

	    @FXML
	    private CheckBox carotidsNormal;

	    @FXML
	    private CheckBox carotidsRightDecreased;

	    @FXML
	    private CheckBox carotidsRightNormal;

	    @FXML
	    private CheckBox carotidsLeftDecrease;

	    @FXML
	    private CheckBox carotidsLeftNormal;

	    @FXML
	    private CheckBox carotidsNormalBilaterally;

	    @FXML
	    private RadioButton noBruitsRadio;

	    @FXML
	    private RadioButton bilateralBruitsRadio;

	    @FXML
	    private RadioButton bilateralRightRadio;

	    @FXML
	    private RadioButton bilateralLeftRadio;

	    @FXML
	    private RadioButton abdominalPulsatileRadio;

	    @FXML
	    private RadioButton abdominalEnlargedRadio;

	    @FXML
	    private RadioButton abdominalBilateralLeftRadio;

	    @FXML
	    private CheckBox abdominalNormal;

	    @FXML
	    private RadioButton abdominalEnlarged5Radio;

	    @FXML
	    private RadioButton abdominalenlarged6Radio;

	    @FXML
	    private RadioButton abdominalEnlarged3Radio;

	    @FXML
	    private RadioButton abdominalEnlarged7Radio;

	    @FXML
	    private CheckBox FemoralLeft3;

	    @FXML
	    private CheckBox FemoralLeft4;

	    @FXML
	    private CheckBox FemoralLeftWithBruit;

	    @FXML
	    private CheckBox FemoralLeft2;

	    @FXML
	    private CheckBox FemoralLeft1;

	    @FXML
	    private CheckBox FemoralLeftWithoutBruit;

	    @FXML
	    private CheckBox FemoralLeftAbsent;

	    @FXML
	    private CheckBox FemoralLeftNormal;

	    @FXML
	    private CheckBox FemoralRight3;

	    @FXML
	    private CheckBox FemoralRight4;

	    @FXML
	    private CheckBox FemoralRightWithBruit;

	    @FXML
	    private CheckBox FemoralRight2;

	    @FXML
	    private CheckBox FemoralRight1;

	    @FXML
	    private CheckBox FemoralRightWithoutBruit;

	    @FXML
	    private CheckBox FemoralRightAbsent;
	    
	    @FXML
	    private CheckBox PedalLeftNormal;

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
			examComp.append("\n\n:CV:  ");
			examCvInputController.str = examComp.toString();

			
			
			if(carotidsNormal.isSelected()){
				
				StringBuilder str12 = new StringBuilder(examCvInputController.str);
				str12.append("Carotids are normal bilaterally. ");
				examCvInputController.str = str12.toString();
				
			}else{
				
				
				if (carotidsLeftDecrease.isSelected() || carotidsLeftNormal.isSelected() || carotidsNormalBilaterally.isSelected()
						|| carotidsRightDecreased.isSelected() || carotidsRightNormal.isSelected() ) {

					StringBuilder str12 = new StringBuilder(examCvInputController.str);
					str12.append("Carotids are ");
					examCvInputController.str = str12.toString();

					if (carotidsLeftDecrease.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("left decreased, ");
						examCvInputController.str = str1.toString();

					}
					if (carotidsLeftNormal.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("left normal, ");
						examCvInputController.str = str1.toString();

					}
					if (carotidsNormalBilaterally.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("normal bilaterally, ");
						examCvInputController.str = str1.toString();

					}
					if (carotidsRightDecreased.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("right decreased, ");
						examCvInputController.str = str1.toString();

					}if (carotidsRightNormal.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("right normal, ");
						examCvInputController.str = str1.toString();

					}
					

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append(".");
					examCvInputController.str = str11.toString();

				}
				
				
			}
			
			
			
			
			
			
			
			
			
			
			if (noBruitsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with no bruits noted. ");
				examCvInputController.str = str1.toString();

			}
			if (bilateralBruitsRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with bilateral bruits noted.");
				examCvInputController.str = str1.toString();

			}
			if (bilateralRightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with bilateral right bruits noted.");
				examCvInputController.str = str1.toString();

			}
			if (bilateralLeftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("with bilateral left bruits noted.");
				examCvInputController.str = str1.toString();

			}
			
			
			
		
			
			
			if(abdominalNormal.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("Abdominal aorta is normal. ");
				examCvInputController.str = str1.toString();
				
				
			}else{
				
				if (abdominalPulsatileRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is pulsatile. ");
					examCvInputController.str = str1.toString();

				}if (abdominalBilateralLeftRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is bilateral left. ");
					examCvInputController.str = str1.toString();

				}
				if (abdominalEnlarged3Radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 3 cm.");
					examCvInputController.str = str1.toString();

				}
				if (abdominalEnlarged5Radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 5 cm.");
					examCvInputController.str = str1.toString();

				}
				if (abdominalenlarged6Radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 6 cm.");
					examCvInputController.str = str1.toString();

				}if (abdominalEnlarged7Radio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged to 7 cm.");
					examCvInputController.str = str1.toString();

				}
				if (abdominalEnlargedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("Abdominal aorta is enlarged.");
					examCvInputController.str = str1.toString();

				}
				
			}
			
			

			
			
			
				
			
			
			
			
			if(FemoralLeftNormal.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("Femoral pulses are normal. ");
				examCvInputController.str = str1.toString();
				
				
			}else{
				
				
				if (FemoralLeft1.isSelected() || FemoralLeft2.isSelected() || FemoralLeft3.isSelected()
						|| FemoralLeft4.isSelected() || FemoralLeftAbsent.isSelected()
						|| FemoralLeftWithBruit.isSelected() || FemoralLeftWithoutBruit.isSelected()) {

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append("Femoral pulses show: left ");
					examCvInputController.str = str11.toString();
				
				if (FemoralLeft1.isSelected()) {
					 
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+1, ");
					examCvInputController.str = str1.toString();

				}if (FemoralLeft2.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+2, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeft3.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+3, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeft4.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+4, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeftAbsent.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("absent, ");
					examCvInputController.str = str1.toString();

				}if (FemoralLeftWithBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with bruit, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralLeftWithoutBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("without bruit, ");
					examCvInputController.str = str1.toString();

				}
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();
				 
			}
				
			}
				
				
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			if (FemoralRight1.isSelected() || FemoralRight2.isSelected() || FemoralRight3.isSelected()
					|| FemoralRight4.isSelected() || FemoralRightAbsent.isSelected() || FemoralRightWithBruit.isSelected()
					|| FemoralRightWithoutBruit.isSelected()) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Femoral pulses show: right ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (FemoralRight1.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+1, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRight2.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+2, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRight3.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+3, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRight4.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("+4, ");
					examCvInputController.str = str1.toString();

				}if (FemoralRightAbsent.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("absent, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRightWithBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with bruit, ");
					examCvInputController.str = str1.toString();

				}
				if (FemoralRightWithoutBruit.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("without bruit, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();

			}
			
			
			
			
			
			
			
			
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
			
			
			
			
			
			
			if (EdemaNormal.isSelected()) {

				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append("No edema or varicosities are noted.");
				examCvInputController.str = str1.toString();
				
			}else{
				
				if (EdemaLeft1.isSelected() || EdemaLeft2.isSelected() || EdemaLeft3.isSelected()
						|| EdemaLeft4.isSelected() || EdemaLeftNone.isSelected() || EdemaLeftNonPitting.isSelected()
						|| EdemaLeftPitting.isSelected()) {

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append("Edema:  left ");
					examCvInputController.str = str11.toString();
					
					
					
					
					if (EdemaLeft1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+1, ");
						examCvInputController.str = str1.toString();

					}
					if (EdemaLeft2.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+2, ");
						examCvInputController.str = str1.toString();

					}
					if (EdemaLeft3.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+3, ");
						examCvInputController.str = str1.toString();

					}
					if (EdemaLeft4.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+4, ");
						examCvInputController.str = str1.toString();

					}if (EdemaLeftNone.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("none noted, ");
						examCvInputController.str = str1.toString();

					}
					if (EdemaLeftNonPitting.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("non pitting, ");
						examCvInputController.str = str1.toString();

					}
					if (EdemaLeftPitting.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("pierced lobes, ");
						examCvInputController.str = str1.toString();

					}
					
					
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append(";");
					examCvInputController.str = str1.toString();

				}
				
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		
				
				
				
				if (edemaRight1Check.isSelected() || edemaRight2Check.isSelected() || edemaRight3Check.isSelected()
						|| edemaRight4Check.isSelected() || edemaRightNoneNotedlCheck.isSelected() || edemaRightNonPittinglCheck.isSelected()
						|| edemaRightPittinglCheck.isSelected() ) {

					StringBuilder str11 = new StringBuilder(examCvInputController.str);
					str11.append("Edema:  right ");
					examCvInputController.str = str11.toString();
					
					
					 
					
					if (edemaRight1Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+1, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRight2Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+2, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRight3Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+3, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRight4Check.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("+4, ");
						examCvInputController.str = str1.toString();

					}if (edemaRightNoneNotedlCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("none noted, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRightNonPittinglCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("non pitting, ");
						examCvInputController.str = str1.toString();

					}
					if (edemaRightPittinglCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examCvInputController.str);
						str1.append("pitting, ");
						examCvInputController.str = str1.toString();

					}
					
					
					
					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append(";");
					examCvInputController.str = str1.toString();

				}
				
			
			
			
			
			
			
			
			
				
				if (VaricositiesLeftMildCheck.isSelected() || VaricositiesLeftModerateCheck.isSelected() || VaricositiesLeftNoneCheck.isSelected()
					|| VaricositiesLeftServeCheck.isSelected() || VaricositiesLeftWithStasisCheck.isSelected() ) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Varicosities: left ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (VaricositiesLeftMildCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("mild, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesLeftModerateCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("moderate, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesLeftNoneCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("none noted, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesLeftServeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("severe, ");
					examCvInputController.str = str1.toString();

				}if (VaricositiesLeftWithStasisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with stasis changes, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
				examCvInputController.str = str1.toString();

			}
			
			
			
			
			
			
			if (VaricositiesRightMildCheck.isSelected() || VaricositiesRightModerateCheck.isSelected() || VaricositiesRightNoneCheck.isSelected()
					|| VaricositiesRightServeCheck.isSelected() || VaricositiesRightWithStasisCheck.isSelected() ) {

				StringBuilder str11 = new StringBuilder(examCvInputController.str);
				str11.append("Varicosities: right ");
				examCvInputController.str = str11.toString();
				
				
				
				
				if (VaricositiesRightMildCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("mild, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesRightModerateCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("moderate, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesRightNoneCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("none noted, ");
					examCvInputController.str = str1.toString();

				}
				if (VaricositiesRightServeCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("severe, ");
					examCvInputController.str = str1.toString();

				}if (VaricositiesRightWithStasisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examCvInputController.str);
					str1.append("with stasis changes, ");
					examCvInputController.str = str1.toString();

				}
				
				
				StringBuilder str1 = new StringBuilder(examCvInputController.str);
				str1.append(";");
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
