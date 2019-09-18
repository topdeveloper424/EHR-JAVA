package com.ets.controller.gui.emrCharting.exam.ent;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 08-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of EntMouthSinusesInputController Class
 *Description: entLipGumTeeth.fxml Controller class
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class EntMouthSinusesInputController implements Initializable{
	
	
	@FXML
    private AnchorPane stoolSampleFrankBloodCheckBox;

    @FXML
    private CheckBox pharynxMoistlCheck;

    @FXML
    private CheckBox pharynxDryCheck;

    @FXML
    private CheckBox pharynxShowAreaCheck;

    @FXML
    private CheckBox pharynxShowLesionCheck;

    @FXML
    private CheckBox palateNormalCkeckBox;

    @FXML
    private CheckBox palateSwollenLeftCkeckBox;

    @FXML
    private CheckBox palateSwollenRightCkeckBox;

    @FXML
    private CheckBox uvulaErythematousCkeckBox;

    @FXML
    private CheckBox tongueGeographicCkeckBox;

    @FXML
    private CheckBox uvulaRightCkeckBox;

    @FXML
    private CheckBox uvulaLeftCkeckBox;

    @FXML
    private CheckBox tongueLeukoplakiaCkeckBox;

    @FXML
    private CheckBox tongueNormalCkeckBox;

    @FXML
    private CheckBox pharynxNormalCheck;

    @FXML
    private CheckBox palateSwollenBilaterallyCkeckBox;

    @FXML
    private CheckBox uvulaSwollenCkeckBox;

    @FXML
    private CheckBox tongueSmoothCkeckBox;

    @FXML
    private CheckBox tongueGlossitiesCkeckBox;

    @FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox uvulaNormalCkeckBox;

    @FXML
    private CheckBox tonsilsErythematousCkeckBox;

    @FXML
    private CheckBox tonsilsForeignBodyRightCkeckBox;

    @FXML
    private CheckBox tonsilsNormalCkeckBox;

    @FXML
    private CheckBox tongueAphthousCkeckBox;

    @FXML
    private CheckBox tongueGlossitiesLesionCkeckBox;

    @FXML
    private CheckBox tonsilsEnlargedBilaterallyCkeckBox;

    @FXML
    private CheckBox tonsilsEnlargedLeftCkeckBox;

    @FXML
    private CheckBox tonsilsEnlargedRightCkeckBox;

    @FXML
    private CheckBox tonsilsWithExudatesCkeckBox;

    @FXML
    private CheckBox tonsilsWithoutExudatesCkeckBox;

    @FXML
    private CheckBox tonsilsForeignBodyLeftCkeckBox;

    @FXML
    private CheckBox posteriorNormalCheckBox;

    @FXML
    private CheckBox posteriorPebblingCheckBox;

    @FXML
    private CheckBox posteriorNasalDripCheckBox;

    @FXML
    private CheckBox posteriorForeignBodyCheckBox;

    @FXML
    private CheckBox salivaryNormalCheck;

    @FXML
    private CheckBox salivaryLeftParotidCheck;

    @FXML
    private CheckBox posteriorMassCheckBox;

    @FXML
    private CheckBox salivaryRightParotidCheck;

    @FXML
    private CheckBox salivaryRightSubmandibulaCheck;

    @FXML
    private CheckBox salivaryPainfulCheck;

    @FXML
    private CheckBox salivaryPainlessCheck;
    
    @FXML
    private CheckBox salivaryHardCheck;

    @FXML
    private CheckBox salivaryLeftSubmandibulaCheck;

    @FXML
    private CheckBox salivaryTenderCheck;

    @FXML
    private CheckBox lipNormalCheck;

    @FXML
    private CheckBox dentitionNormalCheck;

    @FXML
    private RadioButton lipNormalRadio;

    @FXML
    private ToggleGroup lip;

    @FXML
    private RadioButton gumAppearRadio;

    @FXML
    private ToggleGroup gum;

    @FXML
    private RadioButton detitionGoodRadio;

    @FXML
    private ToggleGroup dentition;

    @FXML
    private RadioButton detitionFairRadio;

    @FXML
    private RadioButton gumMildRadio;

    @FXML
    private RadioButton lipChelitisRadio;

    @FXML
    private RadioButton lipHerpiticRadio;

    @FXML
    private RadioButton gumSevereRadio;

    @FXML
    private RadioButton detitionPoorRadio;

    @FXML
    private RadioButton detitionEvalRadio;

    @FXML
    private RadioButton gumMassrRadio;

    @FXML
    private Label Frontal;

    @FXML
    private RadioButton SinusesNonTenderRadio;

    @FXML
    private ToggleGroup Sinuses;

    @FXML
    private RadioButton SinusesLeftTenderRadio;

    @FXML
    private RadioButton SinusesRightTenderRadio;

    @FXML
    private RadioButton SinusesBilaterallyTenderRadio;

    @FXML
    private ToggleGroup Ethmoid;

    @FXML
    private RadioButton TenderRadio;

    @FXML
    private CheckBox sinusesNormalCheck;

    @FXML
    private RadioButton FrontalNonTenderRadio;

    @FXML
    private ToggleGroup aa;

    @FXML
    private RadioButton FrontalLeftTenderRadio;

    @FXML
    private RadioButton FrontalRightTenderRadio;

    @FXML
    private RadioButton FrontalBilaterallyTenderRadio;
    
    @FXML
    private RadioButton ethmoidNonTenderRadio;
    
    @FXML
    private RadioButton ethmoidTenderRadio;
    
    
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
			
			
			
			
			
			if (lipNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Lips and gums are normal. ");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (lipNormalRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Lips show normal.");
					examEntInputController.str = str1.toString();
					
				}if (lipChelitisRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Lips show cheilitis.");
					examEntInputController.str = str1.toString();
					
				}if (lipHerpiticRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Lips show Herpetic stomatitis. ");
					examEntInputController.str = str1.toString();
					
				}
				
				
				
			}
			
			
			
			
			
			
			
			if (gumAppearRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Gums appear normal");
				examEntInputController.str = str1.toString();
				
			}if (gumMassrRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Gums mass noted");
				examEntInputController.str = str1.toString();
				
			}if (gumMildRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Gums show mild gingivitis. ");
				examEntInputController.str = str1.toString();
				
			}if (gumSevereRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Gums show severe gingivitis. ");
				examEntInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			
			
			
				
				if (detitionGoodRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition is in good repair.");
					examEntInputController.str = str1.toString();
					
				}if (detitionEvalRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition eval. shows carie  abscess. ");
					examEntInputController.str = str1.toString();
					
				}if (detitionFairRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition is in fair repair.");
					examEntInputController.str = str1.toString();
					
				}if (detitionPoorRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Dentition is in poor repair.");
					examEntInputController.str = str1.toString();
					
				}
		
			
			
			
			
			
			
			
			
			
			
			
				if (pharynxNormalCheck.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append(" Oropharynx shows mucous membranes moist; palate, uvula, tongue, "
							+ "tonsils, salivary glands and posterior pharynx are normal. No sinus "
							+ "tenderness present.");
					examEntInputController.str = str1.toString();
					
				}else{
					
					if (pharynxDryCheck.isSelected() || pharynxMoistlCheck.isSelected() 
							|| pharynxShowAreaCheck.isSelected() || pharynxShowLesionCheck.isSelected()) {
						
						StringBuilder str12 = new StringBuilder(examEntInputController.str);
						str12.append("Oropharynx:  ");
						examEntInputController.str = str12.toString();
						
						if (pharynxDryCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEntInputController.str);
							str1.append("dry, ");
							examEntInputController.str = str1.toString();
							
						}if (pharynxMoistlCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEntInputController.str);
							str1.append("mucous membranes moist, ");
							examEntInputController.str = str1.toString();
							
						}if (pharynxShowAreaCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEntInputController.str);
							str1.append("show areas of aphthous stomatitis, ");
							examEntInputController.str = str1.toString();
							
						}if (pharynxShowLesionCheck.isSelected()) {
							
							StringBuilder str1 = new StringBuilder(examEntInputController.str);
							str1.append("show lesion, ");
							examEntInputController.str = str1.toString();
							
						}
						
						StringBuilder str11 = new StringBuilder(examEntInputController.str);
						str11.append(".");
						examEntInputController.str = str11.toString();
						
					}
					
					
				}
				
				
				if (palateNormalCkeckBox.isSelected() || palateSwollenBilaterallyCkeckBox.isSelected()
						|| palateSwollenLeftCkeckBox.isSelected() || palateSwollenRightCkeckBox.isSelected()) {
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append("Palate : ");
					examEntInputController.str = str12.toString();
					
					
					if (palateNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("normal, ");
						examEntInputController.str = str1.toString();
						
					}if (palateSwollenBilaterallyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("swollen bilaterally, ");
						examEntInputController.str = str1.toString();
						  	
					}if (palateSwollenLeftCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("swollen left, ");
						examEntInputController.str = str1.toString();
						
					}if (palateSwollenRightCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("swollen right, ");
						examEntInputController.str = str1.toString();
						
					}
									
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append(".");
					examEntInputController.str = str11.toString();
					
					
				}
				
				
				
				
				
				
				
				if (uvulaErythematousCkeckBox.isSelected() || uvulaLeftCkeckBox.isSelected() || uvulaNormalCkeckBox.isSelected()
						|| uvulaRightCkeckBox.isSelected() || uvulaSwollenCkeckBox.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Uvula: ");
					examEntInputController.str = str11.toString();
					
					
					if (uvulaErythematousCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("erythematous, ");
						examEntInputController.str = str1.toString();
						
					}if (uvulaLeftCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("deviated to left, ");
						examEntInputController.str = str1.toString();
						
					}if (uvulaNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append(" normal, ");
						examEntInputController.str = str1.toString();
						
					}if (uvulaRightCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("deviated to right, ");
						examEntInputController.str = str1.toString();
						
					}if (uvulaSwollenCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("swollen, ");
						examEntInputController.str = str1.toString();
						
					}
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
					
					
				}
				
				
				
				
				
				
				if (tongueNormalCkeckBox.isSelected() || tongueAphthousCkeckBox.isSelected() || tongueGeographicCkeckBox.isSelected() || tongueGlossitiesCkeckBox.isSelected()
						|| tongueGlossitiesLesionCkeckBox.isSelected() || tongueLeukoplakiaCkeckBox.isSelected() || tongueSmoothCkeckBox.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Tongue: ");
					examEntInputController.str = str11.toString();
					
					
					if (tongueNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("normal, ");
						examEntInputController.str = str1.toString();
						
					}if (tongueAphthousCkeckBox.isSelected()) {
						 
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("shows aphthous ulcers, ");
						examEntInputController.str = str1.toString();
						
					}if (tongueGeographicCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("shows geographic tongue, ");
						examEntInputController.str = str1.toString();
						
					}if (tongueGlossitiesCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("shows glossitis, ");
						examEntInputController.str = str1.toString();
						
					}if (tongueGlossitiesLesionCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("shows lesion, ");
						examEntInputController.str = str1.toString();
						
					}if (tongueLeukoplakiaCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("shows leukoplakia, ");
						examEntInputController.str = str1.toString();
						
					}if (tongueSmoothCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("smooth, ");
						examEntInputController.str = str1.toString();
						
					}
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
					
					
				}
				
				
				
				
				
				
				
				if (tonsilsEnlargedBilaterallyCkeckBox.isSelected() || tonsilsEnlargedLeftCkeckBox.isSelected() || tonsilsEnlargedRightCkeckBox.isSelected() 
						|| tonsilsErythematousCkeckBox.isSelected() || tonsilsForeignBodyLeftCkeckBox.isSelected() || tonsilsForeignBodyRightCkeckBox.isSelected() 
						|| tonsilsNormalCkeckBox.isSelected() || tonsilsWithExudatesCkeckBox.isSelected() || tonsilsWithoutExudatesCkeckBox.isSelected() ) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Tonsils are ");
					examEntInputController.str = str11.toString();
					
					
					if (tonsilsEnlargedBilaterallyCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("bilaterally enlarged, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsEnlargedLeftCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("enlarged left, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsEnlargedRightCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("enlarged right, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsErythematousCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("erythematous, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsForeignBodyLeftCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("with foreign body on the left, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsForeignBodyRightCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("with foreign body on the right, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsNormalCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("normal, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsWithExudatesCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("with exudates, ");
						examEntInputController.str = str1.toString();
						
					}if (tonsilsWithoutExudatesCkeckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("without exudates, ");
						examEntInputController.str = str1.toString();
						
					}
					
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
				}
				
				
				
				
				
				
				
				
				
				
				
				
				if (posteriorForeignBodyCheckBox.isSelected() || posteriorMassCheckBox.isSelected() || posteriorNasalDripCheckBox.isSelected()
						|| posteriorNormalCheckBox.isSelected() || posteriorPebblingCheckBox.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Posterior pharynx reveals ");
					examEntInputController.str = str11.toString();
					
					
					if (posteriorForeignBodyCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("foreign body, ");
						examEntInputController.str = str1.toString();
						
					}if (posteriorMassCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append(" mass, ");
						examEntInputController.str = str1.toString();
						
					}if (posteriorNasalDripCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("post nasal drip, ");
						examEntInputController.str = str1.toString();
						
					}if (posteriorNormalCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("normal, ");
						examEntInputController.str = str1.toString();
						
					}if (posteriorPebblingCheckBox.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("pebbling, ");
						examEntInputController.str = str1.toString();
						
					}
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
				}
				
				
				
				
				
				
				
				
				
				if (salivaryLeftParotidCheck.isSelected() || salivaryLeftSubmandibulaCheck.isSelected() || salivaryNormalCheck.isSelected()
						|| salivaryPainfulCheck.isSelected() || salivaryPainlessCheck.isSelected() || salivaryRightParotidCheck.isSelected()
						|| salivaryRightSubmandibulaCheck.isSelected() || salivaryTenderCheck.isSelected() || salivaryHardCheck.isSelected()) {
					
					StringBuilder str11 = new StringBuilder(examEntInputController.str);
					str11.append("Salivary glands ");
					examEntInputController.str = str11.toString();
					
					
					if (salivaryLeftParotidCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("left parotid swollen, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryLeftSubmandibulaCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("left submandibular swollen, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryNormalCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("normal, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryPainfulCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("painful, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryPainlessCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("painless, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryRightParotidCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("right parotid swollen, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryRightSubmandibulaCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("right submandibular swollen, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryTenderCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("tender, ");
						examEntInputController.str = str1.toString();
						
					}if (salivaryHardCheck.isSelected()) {
						
						StringBuilder str1 = new StringBuilder(examEntInputController.str);
						str1.append("hard, ");
						examEntInputController.str = str1.toString();
						
					}
					
					
					
					StringBuilder str12 = new StringBuilder(examEntInputController.str);
					str12.append(".");
					examEntInputController.str = str12.toString();
					
				}
				

			
			
			
			if (sinusesNormalCheck.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("No sinus tenderness present.");
				examEntInputController.str = str1.toString();
				
			}else{
				
				if (SinusesBilaterallyTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Sinuses:  maxillary tender bilaterally ;");
					examEntInputController.str = str1.toString();
					
				}if (SinusesLeftTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Sinuses:  maxillary tender left ;");
					examEntInputController.str = str1.toString();
					
				}if (SinusesNonTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Sinuses:  maxillary non tender ;");
					examEntInputController.str = str1.toString();
					
				}if (SinusesRightTenderRadio.isSelected()) {
					
					StringBuilder str1 = new StringBuilder(examEntInputController.str);
					str1.append("Sinuses:  maxillary tender right ;");
					examEntInputController.str = str1.toString();
					
				}
				
				
				
			}
			
			
			
		
			
			
			if (FrontalBilaterallyTenderRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("frontal tender bilaterally. ");
				examEntInputController.str = str1.toString();
				
			}if (FrontalLeftTenderRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("frontal tender left. ");
				examEntInputController.str = str1.toString();
				
			}if (FrontalNonTenderRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("frontal right tender. ");
				examEntInputController.str = str1.toString();
				
			}if (FrontalRightTenderRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("frontal tender right. ");
				examEntInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			
			if (ethmoidNonTenderRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Ethmoid non tender.");
				examEntInputController.str = str1.toString();
				
			}if (ethmoidTenderRadio.isSelected()) {
				
				StringBuilder str1 = new StringBuilder(examEntInputController.str);
				str1.append("Ethmoid tender.");
				examEntInputController.str = str1.toString();
				
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
