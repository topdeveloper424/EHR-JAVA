package com.ets.controller.gui.emrCharting.exam.skin.skinDermGlobal;

/*
 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SkinDermGlobalInputController Class
 *Description: SkinDermGlobal.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.exam.skin.ExamSkinInputController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class SkinDermGlobalInputController implements Initializable {
	
	
	@FXML
    private Button doneBtn;

    @FXML
    private Button skipBtn;

    @FXML
    private CheckBox normalCheck;

    @FXML
    private CheckBox hypopigmentedCheck;

    @FXML
    private CheckBox yellowCheck;

    @FXML
    private CheckBox whiteCheck;

    @FXML
    private CheckBox brownCheck;

    @FXML
    private CheckBox violaceousCheck;

    @FXML
    private CheckBox hyperpigmentedCheck;

    @FXML
    private CheckBox skinCheck;

    @FXML
    private CheckBox bluishCheck;

    @FXML
    private CheckBox regularBordersCheck;

    @FXML
    private CheckBox cafeCheck;

    @FXML
    private CheckBox irreguralCheck;

    @FXML
    private CheckBox plaqueCheck;

    @FXML
    private CheckBox insectBiteCheck;

    @FXML
    private CheckBox scalyCheck;

    @FXML
    private CheckBox wartyCheck;

    @FXML
    private CheckBox papuleCheck;

    @FXML
    private CheckBox redCheck;

    @FXML
    private CheckBox blackCheck;

    @FXML
    private CheckBox irregularBorderCheck;

    @FXML
    private CheckBox seborrheicCheck;

    @FXML
    private CheckBox blueCheck;

    @FXML
    private CheckBox PapularhemangiomaCheck;

    @FXML
    private CheckBox scabiformCheck;

    @FXML
    private CheckBox confluenceCheck;

    @FXML
    private CheckBox psoriaticCheck;

    @FXML
    private CheckBox eczemoidCheck;

    @FXML
    private CheckBox TineaCheck;

    @FXML
    private CheckBox lichenifiedCheck;

    @FXML
    private CheckBox tumorousCheck;

    @FXML
    private CheckBox LeftForearmPartExtremity;

    @FXML
    private CheckBox vegetatedCheck;

    @FXML
    private CheckBox melanomatousCheck;

    @FXML
    private CheckBox carcinomatousCheck;

    @FXML
    private CheckBox XanthomatousCheck;

    @FXML
    private CheckBox hemangiomaCheck;

    @FXML
    private CheckBox actiniformCheck;

    @FXML
    private CheckBox dyshidroticCheck;

    @FXML
    private CheckBox folliculitisCheck;

    @FXML
    private CheckBox keratoticCheck;

    @FXML
    private CheckBox impetiginousCheck;

    @FXML
    private CheckBox infectedCheck;

    @FXML
    private CheckBox eczemaCheck;

    @FXML
    private CheckBox vesicularCheck;

    @FXML
    private CheckBox herpeticCheck;

    @FXML
    private CheckBox maculeCheck;

    @FXML
    private CheckBox pustuleCheck;

    @FXML
    private CheckBox scaleCheck;

    @FXML
    private CheckBox vesicleCheck;

    @FXML
    private CheckBox erosionCheck;

    @FXML
    private CheckBox bullaCheck;

    @FXML
    private CheckBox atrophyCheck;

    @FXML
    private CheckBox noduleCheck;

    @FXML
    private CheckBox whealCheck;

    @FXML
    private CheckBox scarCheck;

    @FXML
    private CheckBox greenCheck;

    @FXML
    private CheckBox brownHyperpigmentedCheck;

    @FXML
    private CheckBox blanchesCheck;

    @FXML
    private CheckBox redExanthemCheck;

    @FXML
    private CheckBox pityriricCheck;

    @FXML
    private CheckBox neurofibromatosisCheck;

    @FXML
    private CheckBox furuncularCheck;

    @FXML
    private CheckBox erythematousCheck;

    @FXML
    private CheckBox angioedemaCheck;

    @FXML
    private CheckBox urticariaCheck;

    @FXML
    private CheckBox dematorgraphismCheck;

    @FXML
    private CheckBox ichthyosisCheck;

    @FXML
    private CheckBox desquamationCheck;

    @FXML
    private CheckBox pityriasisCheck;

    @FXML
    private CheckBox erythemaCheck;

    @FXML
    private CheckBox atopicCheck;

    @FXML
    private CheckBox honeyCheck;

    @FXML
    private CheckBox pemphigusCheck;

    @FXML
    private CheckBox tineaCheck;

    @FXML
    private CheckBox ulcerationCheck;

    @FXML
    private CheckBox LossOfSkinatrophyCheck;

    @FXML
    private CheckBox straeCheck;

    @FXML
    private CheckBox excoriationCheck;

    @FXML
    private CheckBox fissureCheck;

    @FXML
    private CheckBox ischemicCheck;

    @FXML
    private CheckBox sclerosisCheck;

    @FXML
    private CheckBox chappingCheck;

    @FXML
    private CheckBox thickCheck;

    @FXML
    private CheckBox purpuricCheck;

    @FXML
    private CheckBox miliaCheck;

    @FXML
    private CheckBox lichenificationCheck;

    @FXML
    private CheckBox comedoneCheck;

    @FXML
    private CheckBox burrowCheck;

    @FXML
    private CheckBox telangiectasicCheck;

    @FXML
    private CheckBox petechiaeCheck;

    @FXML
    private CheckBox cystCheck;

    @FXML
    private CheckBox faceCheck;
    
    @FXML
    private CheckBox plaqueTypeCheck;
	
	@FXML
    private CheckBox flatHyperpigmentedCheck;

    @FXML
    private CheckBox extremitiescheck;

    @FXML
    private CheckBox mouthCheck;

    @FXML
    private CheckBox flexorCheck;

    @FXML
    private CheckBox mucousCheck;

    @FXML
    private CheckBox extensorCheck;

    @FXML
    private CheckBox trunkCheck;

    @FXML
    private CheckBox palmsCheck;

    @FXML
    private CheckBox diffuselyCheck;

    @FXML
    private CheckBox sunCheck;

    @FXML
    private CheckBox feetCheck;

    @FXML
    private CheckBox lesion1cmCheck;

    @FXML
    private CheckBox lesion2cmCheck;

	@FXML
	private CheckBox lesion5cmCheck;

	private ExamSkinInputController examSkinInputController;

	public void setExamSkinInputController(ExamSkinInputController examSkinInputController) {
		this.examSkinInputController = examSkinInputController;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event)->
		{
			
			StringBuilder examBasic = new StringBuilder(examSkinInputController.str);
			examBasic.append("\n\nSKIN: ");
			examSkinInputController.str = examBasic.toString();
			
			if(maculeCheck.isSelected() || scaleCheck.isSelected() || plaqueTypeCheck.isSelected() || noduleCheck.isSelected()
					|| scarCheck.isSelected() || vesicleCheck.isSelected() || pustuleCheck.isSelected() || erosionCheck.isSelected()
					|| bullaCheck.isSelected() || whealCheck.isSelected() || atrophyCheck.isSelected() || papuleCheck.isSelected()
					|| hypopigmentedCheck.isSelected() || redCheck.isSelected() || blackCheck.isSelected() || greenCheck.isSelected()
					|| violaceousCheck.isSelected() || brownCheck.isSelected() || yellowCheck.isSelected() || whiteCheck.isSelected() || blueCheck.isSelected() 
					|| flatHyperpigmentedCheck.isSelected() || plaqueCheck.isSelected() || insectBiteCheck.isSelected() || scalyCheck.isSelected()
					|| scabiformCheck.isSelected() || wartyCheck.isSelected() || irregularBorderCheck.isSelected() || seborrheicCheck.isSelected()
					|| PapularhemangiomaCheck.isSelected() || confluenceCheck.isSelected() || eczemoidCheck.isSelected() || seborrheicCheck.isSelected() || pityriricCheck.isSelected()
					|| psoriaticCheck.isSelected() || TineaCheck.isSelected() || tumorousCheck.isSelected()
					|| tumorousCheck.isSelected() || vegetatedCheck.isSelected() || melanomatousCheck.isSelected() || XanthomatousCheck.isSelected()
					|| neurofibromatosisCheck.isSelected() || LeftForearmPartExtremity.isSelected() || wartyCheck.isSelected() || carcinomatousCheck.isSelected()
					|| hemangiomaCheck.isSelected() || furuncularCheck.isSelected()
					|| actiniformCheck.isSelected() || folliculitisCheck.isSelected() || impetiginousCheck.isSelected() || infectedCheck.isSelected()
					|| dyshidroticCheck.isSelected() || keratoticCheck.isSelected() || infectedCheck.isSelected() || herpeticCheck.isSelected()
					|| faceCheck.isSelected() || mouthCheck.isSelected() || mucousCheck.isSelected()
					|| trunkCheck.isSelected() || diffuselyCheck.isSelected() || extremitiescheck.isSelected()
					|| flexorCheck.isSelected() || extensorCheck.isSelected() || palmsCheck.isSelected()
					|| lesion1cmCheck.isSelected() || lesion2cmCheck.isSelected() || lesion5cmCheck.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("The skin abnormality appears to be ");
				examSkinInputController.str = str1.toString();
				
			}
			
			if(maculeCheck.isSelected() || scaleCheck.isSelected() || plaqueTypeCheck.isSelected() || noduleCheck.isSelected()
					|| scarCheck.isSelected() || vesicleCheck.isSelected() || pustuleCheck.isSelected() || erosionCheck.isSelected()
					|| bullaCheck.isSelected() || whealCheck.isSelected() || atrophyCheck.isSelected() || papuleCheck.isSelected() ){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" a ");
				examSkinInputController.str = str1.toString();
				
			}
			
			if(maculeCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("macule, ");
				examSkinInputController.str = str1.toString();
				
			}if(scaleCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("scale or crust, ");
				examSkinInputController.str = str1.toString();
				
			}if(plaqueTypeCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("plaque, ");
				examSkinInputController.str = str1.toString();
				
			}if(noduleCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("nodule, ");
				examSkinInputController.str = str1.toString();
				
			}if(scarCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("scar, ");
				examSkinInputController.str = str1.toString();
				
			}if(vesicleCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("vesicle, ");
				examSkinInputController.str = str1.toString();
				
			}if(pustuleCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("pustule, ");
				examSkinInputController.str = str1.toString();
				
			}if(erosionCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("erosion, ulcer or fissure. ");
				examSkinInputController.str = str1.toString();
				
			}if(bullaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("bulla, ");
				examSkinInputController.str = str1.toString();
				
			}if(whealCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("wheal (hive), ");
				examSkinInputController.str = str1.toString();
				
			}if(atrophyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("atrophy, ");
				examSkinInputController.str = str1.toString();
				
			}if(papuleCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("papule, ");
				examSkinInputController.str = str1.toString();
				
			}
			
		if(hypopigmentedCheck.isSelected() || redCheck.isSelected() || blackCheck.isSelected() || greenCheck.isSelected()
				|| violaceousCheck.isSelected() || brownCheck.isSelected() || yellowCheck.isSelected() || whiteCheck.isSelected() || blueCheck.isSelected() ){
			
			StringBuilder str1 = new StringBuilder(examSkinInputController.str);
			str1.append("whose coloration is; ");
			examSkinInputController.str = str1.toString();
		}
			
			
			if(hypopigmentedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hypopigmented, ");
				examSkinInputController.str = str1.toString();
				
			}if(redCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("red, ");
				examSkinInputController.str = str1.toString();
				
			}if(blackCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("black, ");
				examSkinInputController.str = str1.toString();
				
			}if(greenCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("green, ");
				examSkinInputController.str = str1.toString();
				
			}if(violaceousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("violaceous, ");
				examSkinInputController.str = str1.toString();
				
			}if(brownCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("brown, ");
				examSkinInputController.str = str1.toString();
				
			}if(yellowCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("yellow, ");
				examSkinInputController.str = str1.toString();
				
			}if(whiteCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("white, ");
				examSkinInputController.str = str1.toString();
				
			}if(blueCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("blue");
				examSkinInputController.str = str1.toString();
				
			}
				
			
			
			
			
			
			
			if(brownHyperpigmentedCheck.isSelected() || flatHyperpigmentedCheck.isSelected() || bluishCheck.isSelected() || cafeCheck.isSelected()
					|| scalyCheck.isSelected() || blanchesCheck.isSelected() ||  irreguralCheck.isSelected() || regularBordersCheck.isSelected()
					|| skinCheck.isSelected() || redExanthemCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("The lesion is circumscribed, flat, discolored (macular); ");
				examSkinInputController.str = str1.toString();
				
			}			
			
			if(brownHyperpigmentedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("brown hyperpigmented, ");
				examSkinInputController.str = str1.toString();
				
			}if(flatHyperpigmentedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hypopigmented, ");
				examSkinInputController.str = str1.toString();
				
			}
			if(bluishCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("bluish (Mongolian spot), ");
				examSkinInputController.str = str1.toString();
				
			}if(cafeCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("cafe au lait spot, ");
				examSkinInputController.str = str1.toString();
				
			} 
			if(scalyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("scaly, ");
				examSkinInputController.str = str1.toString();
				
			}if(blanchesCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("blanches with pressure, ");
				examSkinInputController.str = str1.toString();
				
			}if(irreguralCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("irregular borders, ");
				examSkinInputController.str = str1.toString();
				
			}if(regularBordersCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("regular borders, ");
				examSkinInputController.str = str1.toString();
				
			}if(skinCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("skin folds, ");
				examSkinInputController.str = str1.toString();
				
			}if(redExanthemCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("red exanthem, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			if(hypopigmentedCheck.isSelected() || plaqueCheck.isSelected() || insectBiteCheck.isSelected() || scalyCheck.isSelected()
					|| scabiformCheck.isSelected() || wartyCheck.isSelected() || irregularBorderCheck.isSelected() || seborrheicCheck.isSelected()
					|| PapularhemangiomaCheck.isSelected() ){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Elevated solid papular lesion less than 0.5 cm in diameter, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(hypopigmentedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hypopigmented, ");
				examSkinInputController.str = str1.toString();
				
			}if(plaqueCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("plaque, ");
				examSkinInputController.str = str1.toString();
				   
			}if(insectBiteCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("insect bite, ");
				examSkinInputController.str = str1.toString();
				
			}if(scalyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("scaly eczematous,  ");
				examSkinInputController.str = str1.toString();
				
			}if(scabiformCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("scabiform, ");
				examSkinInputController.str = str1.toString();
				
			}if(wartyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("warty, ");
				examSkinInputController.str = str1.toString();
				
			}if(irregularBorderCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("irregular border, ");
				examSkinInputController.str = str1.toString();
				
			}if(seborrheicCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("seborrheic keratosis, ");
				examSkinInputController.str = str1.toString();
				
			}if(PapularhemangiomaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hemangioma, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			if(confluenceCheck.isSelected() || eczemoidCheck.isSelected() || seborrheicCheck.isSelected() || pityriricCheck.isSelected()
					|| psoriaticCheck.isSelected() || TineaCheck.isSelected() || tumorousCheck.isSelected() ){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Circumscribed, elevated, superficial, solid lesion less than 0.5 cm in diameter plaque-like lesion ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(confluenceCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("confluence of papules, ");
				examSkinInputController.str = str1.toString();
				
			}if(eczemoidCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("eczemoid, ");
				examSkinInputController.str = str1.toString();
				 
			}if(seborrheicCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("seborrheic dermatitis, ");
				examSkinInputController.str = str1.toString();
				
			}if(pityriricCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("pityriric (pityriasis), ");
				examSkinInputController.str = str1.toString();
				
			}if(psoriaticCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("psoriatic, ");
				examSkinInputController.str = str1.toString();
				
			}if(TineaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Tinea-like (versicolor/corpor) ");
				examSkinInputController.str = str1.toString();
				
			}if(lichenifiedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Lichenified, " );
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if(tumorousCheck.isSelected() || vegetatedCheck.isSelected() || melanomatousCheck.isSelected() || XanthomatousCheck.isSelected()
					|| neurofibromatosisCheck.isSelected() || LeftForearmPartExtremity.isSelected() || wartyCheck.isSelected() || carcinomatousCheck.isSelected()
					|| hemangiomaCheck.isSelected() || furuncularCheck.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Circumscribed elevated, solid lesion more than 0.5 cm in diameter ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(tumorousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("tumorous (large nodule), ");
				examSkinInputController.str = str1.toString();
				
			}if(vegetatedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("vegetated borders, ");
				examSkinInputController.str = str1.toString();
				
			}if(melanomatousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("melanomatous, ");
				examSkinInputController.str = str1.toString();
				
			}if(XanthomatousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Xanthomatous, ");
				examSkinInputController.str = str1.toString();
				
			}if(neurofibromatosisCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("neurofibromatosis, ");
				examSkinInputController.str = str1.toString();
				
			}if(LeftForearmPartExtremity.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("lipomatous, ");
				examSkinInputController.str = str1.toString();
				
			}if(wartyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("warty, ");
				examSkinInputController.str = str1.toString();
				
			}if(carcinomatousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("carcinomatous, ");
				examSkinInputController.str = str1.toString();
				
			}if(hemangiomaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("hemangioma, ");
				examSkinInputController.str = str1.toString();
				
			}if(furuncularCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("furuncular, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(actiniformCheck.isSelected() || folliculitisCheck.isSelected() || impetiginousCheck.isSelected() || infectedCheck.isSelected()
					|| dyshidroticCheck.isSelected() || keratoticCheck.isSelected() || infectedCheck.isSelected() || herpeticCheck.isSelected() ){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("A circumscribed collection of leukocytes and free fluids ( pustule )");
				examSkinInputController.str = str1.toString();
				
				
			}
			
			
			
			if(actiniformCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("actiniform (acne), ");
				examSkinInputController.str = str1.toString();
				
			}if(folliculitisCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("folliculitis, ");
				examSkinInputController.str = str1.toString();
				
			}if(impetiginousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Impetiginous (impetigo), ");
				examSkinInputController.str = str1.toString();
				
			}if(infectedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("infected vesicular, ");
				examSkinInputController.str = str1.toString();
				
			}if(dyshidroticCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("dyshidrotic,scaly, ");
				examSkinInputController.str = str1.toString();
				
			}if(keratoticCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("keratotic, ");
				examSkinInputController.str = str1.toString();
				
			}if(infectedCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("infected scabiform, ");
				examSkinInputController.str = str1.toString();
				
			}if(herpeticCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("herpetic, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if(eczemaCheck.isSelected() || vesicularCheck.isSelected() || herpeticCheck.isSelected()
					|| erythematousCheck.isSelected() ){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Circumscribed collection of free fluid up to 0.5 cm in diameter (vesicle) or if larger a bulla; ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(eczemaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("eczema, ");
				examSkinInputController.str = str1.toString();
				
			}if(vesicularCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("vesicular, ");
				examSkinInputController.str = str1.toString();
				
			}if(herpeticCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("herpetic and erythematous, ");
				examSkinInputController.str = str1.toString();
				
			}if(erythematousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("erythematous, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			
			if(angioedemaCheck.isSelected() || urticariaCheck.isSelected() || dematorgraphismCheck.isSelected()
					){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("A firm edematous plaque or wheal resulting from infiltration of the dermis with fluid (hives) ");
				examSkinInputController.str = str1.toString();
				
				
			}
			
			
			if(angioedemaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("angioedema, ");
				examSkinInputController.str = str1.toString();
				
			}if(urticariaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("Urticaria, ");
				examSkinInputController.str = str1.toString();
				
			}if(dematorgraphismCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("dermatographism, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			if(psoriaticCheck.isSelected() || desquamationCheck.isSelected() || erythemaCheck.isSelected()
					|| ichthyosisCheck.isSelected() || pityriasisCheck.isSelected()){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" excess dead epidermal tissue resulting from increased keratinization and shedding (scales) ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(psoriaticCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("psoriatic, ");
				examSkinInputController.str = str1.toString();
				
			}if(desquamationCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("desquamation, ");
				examSkinInputController.str = str1.toString();
				 
			}if(erythemaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("erythema craquele -thick scale, ");
				examSkinInputController.str = str1.toString();
				
			}if(ichthyosisCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("ichthyosis, ");
				examSkinInputController.str = str1.toString();
				
			}if(pityriasisCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("pityriasis rosea, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if(atopicCheck.isSelected() || honeyCheck.isSelected() || pemphigusCheck.isSelected() || tineaCheck.isSelected()
					){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("collection of dried serum and cellular debris forming a crust or scab ");
				examSkinInputController.str = str1.toString();
				
				
			}
			
			if(atopicCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("atopic, ");
				examSkinInputController.str = str1.toString();
				
			}if(honeyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("honey colored impetiginous, ");
				examSkinInputController.str = str1.toString();
				
			}if(pemphigusCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("pemphigus, ");
				examSkinInputController.str = str1.toString();
				
			}if(tineaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("tinea capitus, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			
			
			if(ulcerationCheck.isSelected() || erosionCheck.isSelected() || fissureCheck.isSelected()|| sclerosisCheck.isSelected()
					|| straeCheck.isSelected() || LossOfSkinatrophyCheck.isSelected() || excoriationCheck.isSelected() || ischemicCheck.isSelected()
					|| chappingCheck.isSelected() ){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("loss of skin tissue due to; ");
				examSkinInputController.str = str1.toString();
				
			}
			
			if(ulcerationCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("ulceration, ");
				examSkinInputController.str = str1.toString();
				
			}if(erosionCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("erosion, ");
				examSkinInputController.str = str1.toString();
				
			}if(fissureCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("fissure, ");
				examSkinInputController.str = str1.toString();
				
			}if(sclerosisCheck.isSelected()){
				 
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("sclerosis, ");
				examSkinInputController.str = str1.toString();
				
			}if(straeCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("strae, ");
				examSkinInputController.str = str1.toString();
				
			}if(LossOfSkinatrophyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("atrophy, ");
				examSkinInputController.str = str1.toString();
				
			}if(excoriationCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("excoriation, ");
				examSkinInputController.str = str1.toString();
				
			}if(ischemicCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("ischemic, ");
				examSkinInputController.str = str1.toString();
				
			}if(chappingCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("chapping, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(ulcerationCheck.isSelected() || erosionCheck.isSelected() || fissureCheck.isSelected()|| sclerosisCheck.isSelected()
					|| straeCheck.isSelected() || LossOfSkinatrophyCheck.isSelected() || excoriationCheck.isSelected() || ischemicCheck.isSelected()
					|| chappingCheck.isSelected() ){
				
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("changes in the skin.");
				examSkinInputController.str = str1.toString();
				
			}
			
		
			
		
			
			if(thickCheck.isSelected() || whiteCheck.isSelected() || comedoneCheck.isSelected() 
					|| telangiectasicCheck.isSelected() || petechiaeCheck.isSelected() || lichenificationCheck.isSelected() || miliaCheck.isSelected() 
					|| burrowCheck.isSelected() || cystCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("somewhat unusual lesion; ");
				examSkinInputController.str = str1.toString();
				
			}
			
			if(thickCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("thick and pink scarring, ");
				examSkinInputController.str = str1.toString();
				
			}if(whiteCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("white atrophic scarring, ");
				examSkinInputController.str = str1.toString();
				
			}if(comedoneCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("comedone, ");
				examSkinInputController.str = str1.toString();
				
			}if(telangiectasicCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("telangiectasic blood vessel, ");
				examSkinInputController.str = str1.toString();
				
			}if(petechiaeCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("petechiae, ");
				examSkinInputController.str = str1.toString();
				
			}if(purpuricCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("purpuric, ");
				examSkinInputController.str = str1.toString();
				
			}if(lichenificationCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("lichenification, ");
				examSkinInputController.str = str1.toString();
				
			}if(miliaCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("milia, ");
				examSkinInputController.str = str1.toString();
				
			}if(burrowCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("burrow, ");
				examSkinInputController.str = str1.toString();
				
			}if(cystCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("cyst, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			if(faceCheck.isSelected() || mouthCheck.isSelected() || mucousCheck.isSelected()
					|| trunkCheck.isSelected() || diffuselyCheck.isSelected() || extremitiescheck.isSelected()
					|| flexorCheck.isSelected() || extensorCheck.isSelected() || palmsCheck.isSelected()
					|| feetCheck.isSelected() || sunCheck.isSelected() ){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("located primarily; ");
				examSkinInputController.str = str1.toString();
				
				
			}  
			
			if(faceCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("face,");
				examSkinInputController.str = str1.toString();
				
			}if(mouthCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append(" mouth,");
				examSkinInputController.str = str1.toString();
				
			}if(mucousCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("mucous membranes, ");
				examSkinInputController.str = str1.toString();
				
			}if(trunkCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("trunk, ");
				examSkinInputController.str = str1.toString();
				
			}if(diffuselyCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("diffusely, ");
				examSkinInputController.str = str1.toString();
				
			}if(extremitiescheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("extremities, ");
				examSkinInputController.str = str1.toString();
				
			}if(flexorCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("flexor surfaces, ");
				examSkinInputController.str = str1.toString();
				
			}if(extensorCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("extensor surfaces, ");
				examSkinInputController.str = str1.toString();
				
			}if(palmsCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("palms, ");
				examSkinInputController.str = str1.toString();
				
			}if(sunCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("sun exposed, ");
				examSkinInputController.str = str1.toString();
				
			}if(feetCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("feet, ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			
			
			if(lesion1cmCheck.isSelected() || lesion2cmCheck.isSelected() || lesion5cmCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("size wise ");
				examSkinInputController.str = str1.toString();
				
			}
			
			
			if(lesion1cmCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("1 cm is largest lesion, ");
				examSkinInputController.str = str1.toString();
				
			}if(lesion2cmCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("2.5 cm is largest lesion, ");
				examSkinInputController.str = str1.toString();
				
			}if(lesion5cmCheck.isSelected()){
				
				StringBuilder str1 = new StringBuilder(examSkinInputController.str);
				str1.append("5 cm largest lesion, ");
				examSkinInputController.str = str1.toString();
				
			}
		
		++examSkinInputController.formCount;	
		examSkinInputController.setSkinUI();
		new FXFormCommonUtilities().closeForm(doneBtn);
	});
		
		skipBtn.setOnAction((event) -> {
			try {
				++examSkinInputController.formCount;	
				examSkinInputController.setSkinUI();
				new FXFormCommonUtilities().closeForm( skipBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}

}
