package com.ets.controller.gui.emrCharting.exam.musculoSkeleton.head;

import java.net.URL;
import java.util.ResourceBundle;

import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 4-03-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HeadComprehensiveInputController Class
 *Description: ExamMusculotoneHead GUI Controller class
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
public class HeadComprehensiveInputController implements Initializable {

	@FXML
	private AnchorPane stoolSampleFrankBloodCheckBox;



	@FXML
	private CheckBox abnormalities2SkullCheck;

	@FXML
	private CheckBox abnormalities2SclapCheck;

	@FXML
	private CheckBox abnormalities2ForeheadCheck;

	@FXML
	private CheckBox revealedNormalCkeckBox;

	@FXML
	private CheckBox abnormalities2Check;

	@FXML
	private CheckBox abnormalities2FrontalCheck;

	@FXML
	private CheckBox abnormalities2SIawCheck;

	@FXML
	private Button doneBtn;

	@FXML
	private Button skipBtn;

	@FXML
	private CheckBox abnormalities2MaxilaryCheck;

	@FXML
	private CheckBox tenderness2CheekCheck;

	@FXML
	private CheckBox tenderness2SkullCheck;

	@FXML
	private CheckBox tenderness2Frontalheck;

	@FXML
	private CheckBox tenderness2MaxilaryCheck;

	@FXML
	private CheckBox tenderness2IawCheck;

	@FXML
	private CheckBox tenderness2TemporomandibulaCheck;

	@FXML
	private CheckBox tenderness2ExudatesCheck;

	@FXML
	private CheckBox tenderness2ForeignCheck;

	@FXML
	private CheckBox swellingLeftCheckBox;

	@FXML
	private CheckBox swellingRightCheckBox;

	@FXML
	private CheckBox swellingBilaterallyCheckBox;

	@FXML
	private CheckBox InspectionNormocephalicCheck;

	@FXML
	private CheckBox InspectionAtraumaticCheck;

	@FXML
	private CheckBox swellingMassCheckBox;

	@FXML
	private CheckBox InspectionMicrocephalyCheck;

	@FXML
	private CheckBox InspectionEvidenceCheck;

	@FXML
	private CheckBox InspectionEnlargedCheck;

	@FXML
	private CheckBox InspectionNormalCheck;

	@FXML
	private CheckBox abnormalities1PartialCheck;

	@FXML
	private CheckBox abnormalities1LeftCheck;

	@FXML
	private CheckBox abnormalities1RightCheck;

	@FXML
	private CheckBox abnormalities1BilateralCheck;

	@FXML
	private CheckBox abnormalities1PosteriorCheck;

	@FXML
	private CheckBox abnormalities1AnteriorCheck;

	@FXML
	private RadioButton revealedNotendernessRadio;

	@FXML
	private RadioButton revealedTendernessRadio;
	
	  @FXML
	    private ToggleGroup face;

	@FXML
	private CheckBox tendernessPartialCheck;

	@FXML
	private CheckBox tendernessLeftCheck;

	@FXML
	private CheckBox tendernessRightCheck;

	@FXML
	private CheckBox tendernessPosteriorCheck;

	@FXML
	private CheckBox tendernessAnteriorCheck;

	@FXML
	private CheckBox salivaryTenderCheck;

	@FXML
	private CheckBox salivaryHardCheck;

	@FXML
	private CheckBox salivaryNormalCheck;

	@FXML
	private CheckBox hearOrFaceWithoutCheck;

	@FXML
	private CheckBox  salivaryPainfulCheck;
	@FXML
	private CheckBox salivaryparotidCheck;
	@FXML
	private CheckBox salivarySublingualCheck;
	
	@FXML
	private CheckBox salivarySubmaxillaryCheck;
	@FXML
	private CheckBox hearOrFaceWithCheck;

	@FXML
	private CheckBox location1LeftCheck;

	@FXML
	private CheckBox location1RightCheck;

	@FXML
	private CheckBox location1BilateralCheck;

	@FXML
	private CheckBox location1PosteriorCheck;

	@FXML
	private CheckBox location1AnteriorCheck;

	@FXML
	private CheckBox location1PartialCheck;

	@FXML
	private CheckBox location2SkullCheck;

	@FXML
	private CheckBox locationFrontalCheck;

	@FXML
	private CheckBox location2Maxilaryheck;

	@FXML
	private CheckBox location2IawCheck;

	@FXML
	private CheckBox otherMassesCheck;

	@FXML
	private CheckBox otherEcchymosisCheck;

	@FXML
	private CheckBox otherAbrasionsCheck;

	@FXML
	private CheckBox otherContusionsCheck;

	@FXML
	private CheckBox otherLacerationsCheck;

	@FXML
	private CheckBox HeadFaceNormalStrengthCheck1;

	@FXML
	private CheckBox HeadFaceWeeknessCheck1;

	@FXML
	private CheckBox HeadFaceSaggingCheck1;

	@FXML
	private CheckBox HeadFaceExtensivelCheck1;

	@FXML
	private CheckBox HeadFaceParalysisCheck1;

	@FXML
	private CheckBox HeadFaceSansationlCheck1;

	@FXML
	private CheckBox HeadFaceLossToneCheck1;

	@FXML
	private CheckBox HeadFaceNormalCheck1;

	private ExamMusculotoneHeadInputController examMusculotoneHeadInputController;

	public void setExamMusculotoneHeadInputController(
			ExamMusculotoneHeadInputController examMusculotoneHeadInputController) {
		this.examMusculotoneHeadInputController = examMusculotoneHeadInputController;
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		doneBtn.setOnAction((event) -> {

			StringBuilder examComp = new StringBuilder(examMusculotoneHeadInputController.str);
			examComp.append("\n\nMUSCULOSKELETAL ");
			examMusculotoneHeadInputController.str = examComp.toString();

			if (InspectionNormalCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append("Inspection of the head and face showed head to be normocephalic and atraumatic, "
						+ "without deformity. No masses, ecchymosis, abrasions, contusions or lacerations were noted. ");
				examMusculotoneHeadInputController.str = str11.toString();

			} else {

				if (InspectionAtraumaticCheck.isSelected() || InspectionEnlargedCheck.isSelected()
						|| InspectionEvidenceCheck.isSelected() || InspectionMicrocephalyCheck.isSelected()
						|| InspectionNormocephalicCheck.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
					str11.append(" Inspection of the head and face showed head ");
					examMusculotoneHeadInputController.str = str11.toString();

					if (InspectionAtraumaticCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("is atraumatic,  ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (InspectionEnlargedCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append(" is enlarged, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (InspectionEvidenceCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("has evidence of trauma , ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (InspectionMicrocephalyCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append(" has microcephaly , ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (InspectionNormocephalicCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("is normocephalic, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}

				}

			}

				if (hearOrFaceWithoutCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" without deformity, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (hearOrFaceWithCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" with deformity. ");
					examMusculotoneHeadInputController.str = str1.toString();

				}


			if (location1LeftCheck.isSelected() || location1AnteriorCheck.isSelected()
					|| location1BilateralCheck.isSelected() || location1PartialCheck.isSelected()
					|| location1PosteriorCheck.isSelected() || location1RightCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append("of the ");
				examMusculotoneHeadInputController.str = str11.toString();

				if (location1LeftCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append("left, ");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (location1AnteriorCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append(" anterior,");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (location1BilateralCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append("bilateral, ");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (location1PartialCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append("partial, ");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (location1PosteriorCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append(" posterior, ");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (location1RightCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append("right, ");
					examMusculotoneHeadInputController.str = str12.toString();

				}

				
			}

	
				if (location2IawCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append("jaw, ");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (location2Maxilaryheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append("maxillary area,");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (location2SkullCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append("skull, ");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				if (locationFrontalCheck.isSelected()) {

					StringBuilder str12 = new StringBuilder(examMusculotoneHeadInputController.str);
					str12.append(" frontal area,");
					examMusculotoneHeadInputController.str = str12.toString();

				}
				
			

			if (otherAbrasionsCheck.isSelected() || otherContusionsCheck.isSelected()
					|| otherEcchymosisCheck.isSelected() || otherLacerationsCheck.isSelected()
					|| otherMassesCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append(" Noted ");
				examMusculotoneHeadInputController.str = str11.toString();

				if (otherAbrasionsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("abrasions, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (otherContusionsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("contusions, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (otherEcchymosisCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("ecchymosis, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (otherLacerationsCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("lacerations, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (otherMassesCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" masses ");
					examMusculotoneHeadInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append(".");
				examMusculotoneHeadInputController.str = str1.toString();

			}

			if (abnormalities1AnteriorCheck.isSelected() || abnormalities1BilateralCheck.isSelected()
					|| abnormalities1LeftCheck.isSelected() || abnormalities1PartialCheck.isSelected()
					|| abnormalities1PosteriorCheck.isSelected() || abnormalities1RightCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append(" in the ");
				examMusculotoneHeadInputController.str = str11.toString();

				if (abnormalities1AnteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("anterior, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities1BilateralCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("bilateral,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities1LeftCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("left, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities1PartialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("partial,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities1PosteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("posterior, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities1RightCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("right");
					examMusculotoneHeadInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append(". ");
				examMusculotoneHeadInputController.str = str1.toString();

			}

			if (abnormalities2Check.isSelected() || abnormalities2ForeheadCheck.isSelected()
					|| abnormalities2FrontalCheck.isSelected() || abnormalities2MaxilaryCheck.isSelected()
					|| abnormalities2SclapCheck.isSelected() || abnormalities2SIawCheck.isSelected()
					|| abnormalities2SkullCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append(" Abnormal ");
				examMusculotoneHeadInputController.str = str11.toString();

				if (abnormalities2Check.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" cheek, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities2ForeheadCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" forehead, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities2FrontalCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("frontal area, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities2MaxilaryCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("maxillary area, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities2SclapCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("scalp, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities2SIawCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("jaw, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (abnormalities2SkullCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("skull");
					examMusculotoneHeadInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("was noted as specified below.");//
				examMusculotoneHeadInputController.str = str1.toString();

			}

			if (revealedNormalCkeckBox.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append(" There was no sinus tenderness in the face. ");
				examMusculotoneHeadInputController.str = str1.toString();

			} else {

				if (revealedNotendernessRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" Face examination revealed no tenderness. ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (revealedTendernessRadio.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("Face examination revealed tenderness.");
					examMusculotoneHeadInputController.str = str1.toString();

				}

			}

			if (tendernessLeftCheck.isSelected() || tendernessRightCheck.isSelected()
					|| tendernessAnteriorCheck.isSelected() || tendernessPosteriorCheck.isSelected()
					|| tendernessPartialCheck.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append("Tenderness was noted in the ");
				examMusculotoneHeadInputController.str = str11.toString();

				if (tendernessLeftCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("left,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessRightCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("right,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessAnteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("anterior,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessPosteriorCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("posterior, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tendernessPartialCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" parietal, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append(" region of the face/skull. ");
				examMusculotoneHeadInputController.str = str1.toString();

			}


				if (tenderness2CheekCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("cheek, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				
				if (tenderness2Frontalheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("frontal areas, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tenderness2IawCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("jaw,");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				
				if (tenderness2MaxilaryCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("Maxilary areas, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tenderness2SkullCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("skull, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (tenderness2TemporomandibulaCheck.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(" temporomandibular joint. ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				
			

			if (salivaryNormalCheck.isSelected()) {

				StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
				str1.append("Salivary glands are normal, ");
				examMusculotoneHeadInputController.str = str1.toString();

			} else {

				if (salivarySublingualCheck.isSelected() || salivaryHardCheck.isSelected() || salivarySubmaxillaryCheck.isSelected()
						|| salivaryparotidCheck.isSelected() || salivaryPainfulCheck.isSelected()
						|| salivaryTenderCheck.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
					str11.append("Salivary glands ");
					examMusculotoneHeadInputController.str = str11.toString();

					if (salivarySublingualCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("sublingual swollen, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryHardCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("hard, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivarySubmaxillaryCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("submaxillary swollen, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryparotidCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("parotid swollen, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryPainfulCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("painful, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (salivaryTenderCheck.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("tender");
						examMusculotoneHeadInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(". ");
					examMusculotoneHeadInputController.str = str1.toString();

				}

			

				if (swellingBilaterallyCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("bilaterally, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (swellingLeftCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("left, ");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				if (swellingRightCheckBox.isSelected()) {

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append("right");
					examMusculotoneHeadInputController.str = str1.toString();

				}
				
			}
			if (HeadFaceNormalCheck1.isSelected()) {

				StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
				str11.append(" Face has normal strength and tone. ");
				examMusculotoneHeadInputController.str = str11.toString();

			} else {

				if (HeadFaceExtensivelCheck1.isSelected() || HeadFaceLossToneCheck1.isSelected()
						|| HeadFaceNormalStrengthCheck1.isSelected() || HeadFaceParalysisCheck1.isSelected()
						|| HeadFaceSaggingCheck1.isSelected() || HeadFaceSansationlCheck1.isSelected()
						|| HeadFaceWeeknessCheck1.isSelected()) {

					StringBuilder str11 = new StringBuilder(examMusculotoneHeadInputController.str);
					str11.append(" Face has  ");
					examMusculotoneHeadInputController.str = str11.toString();

					if (HeadFaceExtensivelCheck1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("extensive wrinkling, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceLossToneCheck1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("loss of tone, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceNormalStrengthCheck1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("  tone., ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceParalysisCheck1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("paralysis , ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceSaggingCheck1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append(" sagging, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceSansationlCheck1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("sensation, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}
					if (HeadFaceWeeknessCheck1.isSelected()) {

						StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
						str1.append("weakness, ");
						examMusculotoneHeadInputController.str = str1.toString();

					}

					StringBuilder str1 = new StringBuilder(examMusculotoneHeadInputController.str);
					str1.append(".");
					examMusculotoneHeadInputController.str = str1.toString();

				}

			}

			++examMusculotoneHeadInputController.formCount;
			examMusculotoneHeadInputController.setHeadUI();
			new FXFormCommonUtilities().closeForm(doneBtn);

		});

		skipBtn.setOnAction((event) -> {
			try {
				++examMusculotoneHeadInputController.formCount;
				examMusculotoneHeadInputController.setHeadUI();
				new FXFormCommonUtilities().closeForm(skipBtn);

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});

	}

}
