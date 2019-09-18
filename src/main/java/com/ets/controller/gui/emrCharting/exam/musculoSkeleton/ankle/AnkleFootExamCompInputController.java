package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.ankle;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 14-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AnkleFootExamCompInputController Class
 *Description: ankleFootExamComp.fxml Controller class
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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class AnkleFootExamCompInputController implements Initializable{
	
	 @FXML
	    private CheckBox TendernessLetaralMalleousCheck;

	    @FXML
	    private CheckBox TendernessMedialCheck;

	    @FXML
	    private CheckBox TendernessAspectCheck;

	    @FXML
	    private CheckBox TendernessPlanterCheck;

	    @FXML
	    private CheckBox EcchymosisNormalCkeckBox;

	    @FXML
	    private Button doneBtn;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private CheckBox EdemaVentralCheck;

	    @FXML
	    private CheckBox Tenderness1MTPCheck;

	    @FXML
	    private CheckBox WarmthMTPCheck;

	    @FXML
	    private CheckBox WarmthAnkleCheck;

	    @FXML
	    private CheckBox TendernessAchillesCheck;

	    @FXML
	    private CheckBox TendernessPosteriorCalcaneousCheck;

	    @FXML
	    private CheckBox TendernessCalcaneousCheck;

	    @FXML
	    private CheckBox TendernessNacicularCheck;

	    @FXML
	    private CheckBox EdemaAnteriorCheck;

	    @FXML
	    private CheckBox WarmthNormalCheck;

	    @FXML
	    private CheckBox EdemaPosteriorCheck;

	    @FXML
	    private CheckBox EdemaLateralCheck;

	    @FXML
	    private CheckBox EdemaMedialCheck;

	    @FXML
	    private CheckBox EdemaDorsalCheck;

	    @FXML
	    private CheckBox EdemaEntireCheck;

	    @FXML
	    private CheckBox EdemaProximalCheck;

	    @FXML
	    private CheckBox TendernessNormalCheck;

	    @FXML
	    private CheckBox mildlineNormalCheck;

	    @FXML
	    private CheckBox EdemaDistalCheck;

	    @FXML
	    private RadioButton PreenceNoRadio;

	    @FXML
	    private ToggleGroup Preence;

	    @FXML
	    private RadioButton PreenceModerateRadio;

	    @FXML
	    private RadioButton PreenceMarkedRadio;

	    @FXML
	    private RadioButton MortiesIntactRadio;

	    @FXML
	    private ToggleGroup Morties;

	    @FXML
	    private RadioButton MortiesLaxRadio;

	    @FXML
	    private RadioButton whichLeftRadio;

	    @FXML
	    private ToggleGroup which;

	    @FXML
	    private RadioButton whichRightRadio;

	    @FXML
	    private CheckBox AnkleNormalCheck;

	    @FXML
	    private RadioButton pulseNormalRadio;

	    @FXML
	    private ToggleGroup Pulses;

	    @FXML
	    private RadioButton pulseDecreasedRadio;

	    @FXML
	    private RadioButton PreenceMildRadio;

	    @FXML
	    private TextArea EcchymosisText;

	    @FXML
	    private CheckBox TendernessTalofibular;

	    @FXML
	    private CheckBox Tenderness5MTPCheck;

	    @FXML
	    private CheckBox TendernessToeCheck;

	    @FXML
	    private CheckBox AnkleSlightlyCheck;

	    @FXML
	    private CheckBox AnkleModeratlyCheck;

	    @FXML
	    private CheckBox AnkleMarkedlyCheck;

	    @FXML
	    private CheckBox AnklePainCheck;

	    @FXML
	    private CheckBox AnkleNoPainCheck;

	    @FXML
	    private CheckBox TypeDorsiflexionCheck;

	    @FXML
	    private CheckBox TypePlanterCheck;

	    @FXML
	    private CheckBox TypeInversionCheck;

	    @FXML
	    private CheckBox TypeEversionCheck;

	    @FXML
	    private RadioButton gaitNormalRadio;

	    @FXML
	    private RadioButton gaitStiffRadio;

	    @FXML
	    private RadioButton gaitAnatagicRadio;
    
    private ExamMusculotoneAnkleInputController examMusculotoneAnkleInputController;

	public void setExamMusculotoneAnkleInputController(
			ExamMusculotoneAnkleInputController examMusculotoneAnkleInputController) {
		this.examMusculotoneAnkleInputController = examMusculotoneAnkleInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneAnkleInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL: ");
			examMusculotoneAnkleInputController.str = examComp.toString();
			
			
			
			if (whichLeftRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Examination of the left ankle ");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			if (whichRightRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Examination of the right ankle ");
				examMusculotoneAnkleInputController.str = str1.toString();

			}

		
			if (mildlineNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("and foot reveals normal pulses and capillary refills, no edema, ");
				examMusculotoneAnkleInputController.str = str1.toString();

			} else {

				if (pulseNormalRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("and foot reveals pulses and capillary refills normal. ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}
				if (pulseDecreasedRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("and foot reveals pulses and capillary refills decreased. ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}

			}

		
			
			
			
			
			if (EdemaAnteriorCheck.isSelected() || EdemaDistalCheck.isSelected() || EdemaDorsalCheck.isSelected()
					|| EdemaEntireCheck.isSelected() || EdemaLateralCheck.isSelected() || EdemaMedialCheck.isSelected()
					|| EdemaPosteriorCheck.isSelected() || EdemaProximalCheck.isSelected() || EdemaVentralCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str11.append("no edema at ");
				examMusculotoneAnkleInputController.str = str11.toString();

				if (EdemaAnteriorCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("anterior aspect of foot, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}
				if (EdemaDistalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("distal ankle/foot, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}
				if (EdemaDorsalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("dorsal aspect of foot, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}if (EdemaEntireCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("entire foot and ankle, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}
				if (EdemaLateralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("lateral aspect of ankle, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}
				if (EdemaMedialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("medial aspect of ankle, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}if (EdemaPosteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("posterior aspect of foot, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				} 
				if (EdemaProximalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("proximal ankle/foot, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}
				if (EdemaVentralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("ventral aspect of foot, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				}

			}

			
			
			
			
			
			if (EcchymosisNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("No ecchymosis.");
				examMusculotoneAnkleInputController.str = str1.toString();

			} else {

				

					if (EcchymosisText.getText().length() > 0) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("Ecchymosis at "+EcchymosisText.getText());
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					

			}

			
			
			
			
			
			
			
			if (WarmthNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append(" No warmth. ");
				examMusculotoneAnkleInputController.str = str1.toString();

			} else { 

				if (WarmthMTPCheck.isSelected() || WarmthAnkleCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str12.append(" warmth over ");
					examMusculotoneAnkleInputController.str = str12.toString();

					if (WarmthMTPCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append(" 1st MTP, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (WarmthAnkleCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append(" over ankle,");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					

					StringBuilder str11 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str11.append(".");
					examMusculotoneAnkleInputController.str = str11.toString();

				}

			}
			
			
			
			
			if (MortiesIntactRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Mortise joints intact. ");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			
			if (MortiesLaxRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Mortise joints jax. ");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
						
			

			
			
			
			
			
			

			if (TendernessNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("There was no point tenderness noted. ");
				examMusculotoneAnkleInputController.str = str1.toString();

			} else {

				if (Tenderness1MTPCheck.isSelected() || Tenderness5MTPCheck.isSelected() || TendernessAchillesCheck.isSelected()
						|| TendernessAspectCheck.isSelected() || TendernessCalcaneousCheck.isSelected() || TendernessLetaralMalleousCheck.isSelected()
						|| TendernessMedialCheck.isSelected() || TendernessNacicularCheck.isSelected() || TendernessPlanterCheck.isSelected()
						|| TendernessPosteriorCalcaneousCheck.isSelected() || TendernessTalofibular.isSelected() || TendernessToeCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str12.append("Tenderness over ");
					examMusculotoneAnkleInputController.str = str12.toString();

					if (Tenderness1MTPCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("1st MTP, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (Tenderness5MTPCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("5th MTP ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessAchillesCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("achilles insertion, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessAspectCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("posterior aspect, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}if (TendernessCalcaneousCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("posterior calcaneus, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessLetaralMalleousCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("lateral malleolus, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessMedialCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("medial malleolus, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessNacicularCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("navicular, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}if (TendernessPlanterCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("plantar fascia, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessPosteriorCalcaneousCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("lateral calcaneous, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessTalofibular.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("talofibular ligament, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (TendernessToeCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("toe(s), ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}

					StringBuilder str11 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str11.append(".");
					examMusculotoneAnkleInputController.str = str11.toString();

				}

			}

			
			
			
			
			if (AnkleNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Ankle motion and strength appear normal.");
				examMusculotoneAnkleInputController.str = str1.toString();
				
			}else{
				
				if(AnkleMarkedlyCheck.isSelected() || AnkleModeratlyCheck.isSelected() 
						|| AnkleNoPainCheck.isSelected() || AnklePainCheck.isSelected() || AnkleSlightlyCheck.isSelected()){
					
					StringBuilder str11 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str11.append("Ankle motion shows ");
					examMusculotoneAnkleInputController.str = str11.toString();
					
					
					if (AnkleMarkedlyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("markedly decreased strength, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					} 
					if (AnkleModeratlyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("moderately decreased strength, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}

					if (AnkleNoPainCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("no pain, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					if (AnklePainCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("pain, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}if (AnkleSlightlyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
						str1.append("slightly decreased strength, ");
						examMusculotoneAnkleInputController.str = str1.toString();

					}
					
					
					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append(".");
					examMusculotoneAnkleInputController.str = str1.toString();
					
					
				}
				
			}
			
			
			
			
		if(AnkleNormalCheck.isSelected()||AnkleMarkedlyCheck.isSelected() || AnkleModeratlyCheck.isSelected() 
				|| AnkleNoPainCheck.isSelected() || AnklePainCheck.isSelected() || AnkleSlightlyCheck.isSelected()
			){	
			
			if(TypeDorsiflexionCheck.isSelected() || TypePlanterCheck.isSelected() 
					|| TypeInversionCheck.isSelected() || TypeEversionCheck.isSelected()){
				
				StringBuilder str11 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str11.append("on ");
				examMusculotoneAnkleInputController.str = str11.toString();
				
				
				if (TypeDorsiflexionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("dorsiflexion, ");
					examMusculotoneAnkleInputController.str = str1.toString();

				} 
				if (TypePlanterCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("plantar flexion");
					examMusculotoneAnkleInputController.str = str1.toString();

				}

				if (TypeInversionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("inversion");
					examMusculotoneAnkleInputController.str = str1.toString();

				}if (TypeEversionCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
					str1.append("eversion");
					examMusculotoneAnkleInputController.str = str1.toString();

				}
				
				
				
				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append(".");
				examMusculotoneAnkleInputController.str = str1.toString();
				
				
			}
			
			
			
		}
			
			
			if (gaitNormalRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Gait is normal.");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			
			if (gaitStiffRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Gait is stiff.");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			

			if (gaitAnatagicRadio.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneAnkleInputController.str);
				str1.append("Gait is antalgic.");
				examMusculotoneAnkleInputController.str = str1.toString();

			}
			
			
			
			

			++examMusculotoneAnkleInputController.formCount;
			examMusculotoneAnkleInputController.setAnkleUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneAnkleInputController.formCount;
				examMusculotoneAnkleInputController.setAnkleUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
