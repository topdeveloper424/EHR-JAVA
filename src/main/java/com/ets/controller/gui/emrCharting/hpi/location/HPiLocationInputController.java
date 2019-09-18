package com.ets.controller.gui.emrCharting.hpi.location;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 11-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of HPiLocationInputController Class
 *Description: Location.fxml GUI Controller class
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

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.utils.FXFormCommonUtilities;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;

public class HPiLocationInputController implements Initializable {
	

    @FXML
    private RadioButton abdomenRadioBtnL;

    @FXML
    private ToggleGroup Abdomen;

    @FXML
    private RadioButton AnkleRadioBtnL;

    @FXML
    private ToggleGroup Ankle;

    @FXML
    private RadioButton ArmRadioBtnL;

    @FXML
    private ToggleGroup Arm;

    @FXML
    private RadioButton BackRadioBtnL;

    @FXML
    private ToggleGroup Back;

    @FXML
    private RadioButton BladderRadioBtnL;

    @FXML
    private ToggleGroup Bladder;

    @FXML
    private RadioButton BreastRadioBtnL;

    @FXML
    private ToggleGroup Breast;

    @FXML
    private RadioButton ChestradioBtnL;

    @FXML
    private ToggleGroup Chest;

    @FXML
    private RadioButton CoccyxRadioBtnL;

    @FXML
    private ToggleGroup Coccyx;

    @FXML
    private RadioButton EarRadioBtnL;

    @FXML
    private ToggleGroup Ear;

    @FXML
    private RadioButton ElbowRadioBtnL;

    @FXML
    private ToggleGroup Elbow;

    @FXML
    private RadioButton EyeRadioBtnL;

    @FXML
    private ToggleGroup Eye;

    @FXML
    private RadioButton FaceRadioBtnL;

    @FXML
    private ToggleGroup Face;

    @FXML
    private RadioButton FingerRadioBtnL;

    @FXML
    private ToggleGroup Finger;

    @FXML
    private RadioButton FootRadioBtnL;

    @FXML
    private ToggleGroup Foot;

    @FXML
    private RadioButton ForearmRadioBtnL;

    @FXML
    private ToggleGroup Forearm;

    @FXML
    private RadioButton ForeheadRadioBtnL;

    @FXML
    private ToggleGroup Forehead;

    @FXML
    private RadioButton GenitalsRadioBtnL;

    @FXML
    private ToggleGroup Genitals;

    @FXML
    private RadioButton GroinRadioBtnL;

    @FXML
    private ToggleGroup Groin;

    @FXML
    private RadioButton HandRadioBtnL;

    @FXML
    private ToggleGroup Hand;

    @FXML
    private RadioButton ButtocksRadioBtnL;

    @FXML
    private ToggleGroup Buttocks;

    @FXML
    private RadioButton abdomenRadioBtnR;

    @FXML
    private RadioButton AnkleRadioBtnR;

    @FXML
    private RadioButton ArmRadioBtnR;

    @FXML
    private RadioButton BackRadioBtnR;

    @FXML
    private RadioButton BladderRadioBtnR;

    @FXML
    private RadioButton BreastRadioBtnR;

    @FXML
    private RadioButton ButtocksRadioBtnR;

    @FXML
    private RadioButton ChestradioBtnR;

    @FXML
    private RadioButton CoccyxRadioBtnR;

    @FXML
    private RadioButton EarRadioBtnR;

    @FXML
    private RadioButton ElbowRadioBtnR;

    @FXML
    private RadioButton EyeRadioBtnR;

    @FXML
    private RadioButton FaceRadioBtnR;

    @FXML
    private RadioButton FingerRadioBtnR;

    @FXML
    private RadioButton FootRadioBtnR;

    @FXML
    private RadioButton ForearmRadioBtnR;

    @FXML
    private RadioButton ForeheadRadioBtnR;

    @FXML
    private RadioButton GenitalsRadioBtnR;

    @FXML
    private RadioButton GroinRadioBtnR;

    @FXML
    private RadioButton HeadRadioBtnR;

    @FXML
    private ToggleGroup Head;

    @FXML
    private RadioButton HeelradioBtnR;

    @FXML
    private ToggleGroup Heel;

    @FXML
    private RadioButton HipRadioBtnR;

    @FXML
    private ToggleGroup Hip;

    @FXML
    private RadioButton KneeRadioBtnR;

    @FXML
    private ToggleGroup Knee;

    @FXML
    private RadioButton LowerLegRadioBtnR;

    @FXML
    private ToggleGroup LowerLeg;

    @FXML
    private RadioButton LungsRadioBtnR;

    @FXML
    private ToggleGroup Lungs;

    @FXML
    private RadioButton LowerBackRadioBtnR;

    @FXML
    private ToggleGroup LowerBack;

    @FXML
    private RadioButton MouthRadioBtnR;

    @FXML
    private ToggleGroup Mouth;

    @FXML
    private RadioButton NeckRadioBtnR;

    @FXML
    private ToggleGroup Neck;

    @FXML
    private RadioButton NoseRadioBtnR;

    @FXML
    private ToggleGroup Nose;

    @FXML
    private RadioButton ShoulderRadioBtnR;

    @FXML
    private ToggleGroup Shoulder;

    @FXML
    private RadioButton SideRadioBtnR;

    @FXML
    private ToggleGroup Side;

    @FXML
    private RadioButton SkinRadioBtnR;

    @FXML
    private ToggleGroup Skin;

    @FXML
    private RadioButton tightRadioBtnR;

    @FXML
    private ToggleGroup Tight;

    @FXML
    private RadioButton throatRadioBtnR;

    @FXML
    private ToggleGroup Throat;

    @FXML
    private RadioButton thumbRadioBtnR;

    @FXML
    private ToggleGroup Thumb;

    @FXML
    private RadioButton ToeRadioBtnR;

    @FXML
    private ToggleGroup Toe;

    @FXML
    private RadioButton VaginaRadioBtnR;

    @FXML
    private ToggleGroup Vagina;

    @FXML
    private RadioButton WristRadioBtnR;

    @FXML
    private ToggleGroup Wrist;

    @FXML
    private RadioButton otherLocationRadioBtnR;

    @FXML
    private ToggleGroup OtherLocation;

    @FXML
    private RadioButton HeadRadioBtnL;

    @FXML
    private RadioButton HeelradioBtnL;

    @FXML
    private RadioButton HipRadioBtnL;

    @FXML
    private RadioButton KneeRadioBtnL;

    @FXML
    private RadioButton LowerBackRadioBtnL;

    @FXML
    private RadioButton LowerLegRadioBtnL;

    @FXML
    private RadioButton LungsRadioBtnL;

    @FXML
    private RadioButton MouthRadioBtnL;

    @FXML
    private RadioButton NeckRadioBtnL;

    @FXML
    private RadioButton NoseRadioBtnL;

    @FXML
    private RadioButton ShoulderRadioBtnL;

    @FXML
    private RadioButton SideRadioBtnL;

    @FXML
    private RadioButton SkinRadioBtnL;

    @FXML
    private RadioButton tightRadioBtnL;

    @FXML
    private RadioButton throatRadioBtnL;

    @FXML
    private RadioButton thumbRadioBtnL;

    @FXML
    private RadioButton abdomenRadioBtn;

    @FXML
    private RadioButton AnkleRadioBtn;

    @FXML
    private RadioButton ArmRadioBtn;

    @FXML
    private RadioButton BackRadioBtn;

    @FXML
    private RadioButton BladderRadioBtn;

    @FXML
    private RadioButton BreastRadioBtn;

    @FXML
    private RadioButton ButtocksRadioBtn;

    @FXML
    private RadioButton ChestradioBtn;

    @FXML
    private RadioButton CoccyxRadioBtn;

    @FXML
    private RadioButton EarRadioBtn;

    @FXML
    private RadioButton ElbowRadioBtn;

    @FXML
    private RadioButton EyeRadioBtn;

    @FXML
    private RadioButton FaceRadioBtn;

    @FXML
    private RadioButton FingerRadioBtn;

    @FXML
    private RadioButton FootRadioBtn;

    @FXML
    private RadioButton ForearmRadioBtn;

    @FXML
    private RadioButton ForeheadRadioBtn;

    @FXML
    private RadioButton GenitalsRadioBtn;

    @FXML
    private RadioButton GroinRadioBtn;

    @FXML
    private RadioButton HandRadioBtn;

    @FXML
    private RadioButton HeadRadioBtn;

    @FXML
    private RadioButton HeelradioBtn;

    @FXML
    private RadioButton HipRadioBtn;

    @FXML
    private RadioButton KneeRadioBtn;

    @FXML
    private RadioButton LowerBackRadioBtn;

    @FXML
    private RadioButton LowerLegRadioBtn;

    @FXML
    private RadioButton LungsRadioBtn;

    @FXML
    private RadioButton MouthRadioBtn;

    @FXML
    private RadioButton NeckRadioBtn;

    @FXML
    private RadioButton NoseRadioBtn;

    @FXML
    private RadioButton ShoulderRadioBtn;

    @FXML
    private RadioButton SideRadioBtn;

    @FXML
    private RadioButton SkinRadioBtn;

    @FXML
    private RadioButton tightRadioBtn;

    @FXML
    private RadioButton throatRadioBtn;

    @FXML
    private RadioButton thumbRadioBtn;

    @FXML
    private RadioButton ToeRadioBtn;

    @FXML
    private RadioButton VaginaRadioBtn;

    @FXML
    private RadioButton WristRadioBtn;

    @FXML
    private RadioButton otherLocationRadioBtn;

    @FXML
    private RadioButton ToeRadioBtnL;

    @FXML
    private RadioButton VaginaRadioBtnL;

    @FXML
    private RadioButton WristRadioBtnL;

    @FXML
    private RadioButton otherLocationRadioBtnL;

    @FXML
    private RadioButton HandRadioBtnR;

    @FXML
    private Button skipBtn;

    @FXML
    private Button doneBtn;
    
    private Button button;
    
    private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController, Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		doneBtn.setOnAction((event) -> {
			try {
				genericEMRChartingController.setHpiTextArea("\n\nLOCATION : ");
				if(abdomenRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("abdomen");
				}
				if(abdomenRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left abdomen");
				}
				if(abdomenRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right abdomen");
				}
				if(AnkleRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Ankle");
				}
				if(AnkleRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Ankle");
				}
				if(AnkleRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Ankle");
				}
				if(ArmRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Arm");
				}
				if(ArmRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Arm");
				}
				if(ArmRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Arm");
				}
				if(BackRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Back");
				}
				if(BackRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Back");
				}
				if(BackRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Back");
				}
				if(BladderRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Bladder");
				}
				if(BladderRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Bladder");
				}
				if(BladderRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Bladder");
				}
				if(BreastRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Breast");
				}
				if(BreastRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Breast");
				}
				if(BreastRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Breast");
				}
				if(ButtocksRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Buttocks");
				}
				if(ButtocksRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Buttocks");
				}
				if(ButtocksRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Buttocks");
				}
				if(ChestradioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Chest");
				}
				if(ChestradioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Chest");
				}
				if(ChestradioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Chest");
				}
				if(CoccyxRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Coccyx");
				}
				if(CoccyxRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Coccyx");
				}
				if(CoccyxRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Coccyx");
				}
				if(EarRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Ear");
				}
				if(EarRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Ear");
				}
				if(EarRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Ear");
				}
				if(ElbowRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Elbow");
				}
				if(ElbowRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Elbow");
				}
				if(ElbowRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Elbow");
				}
				if(EyeRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Eye");
				}
				if(EyeRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Eye");
				}
				if(EyeRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Eye");
				}
				if(FaceRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Face");
				}
				if(FaceRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Face");
				}
				if(FaceRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Face");
				}
				if(FingerRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Finger");
				}
				if(FingerRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Finger");
				}
				if(FingerRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Finger");
				}
				if(FootRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Foot");
				}
				if(FootRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Foot");
				}
				if(FootRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Foot");
				}
				if(ForearmRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Forearm");
				}
				if(ForearmRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Forearm");
				}
				if(ForearmRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Forearm");
				}
				if(ForeheadRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Forehead");
				}
				if(ForeheadRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Forehead");
				}
				if(ForeheadRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Forehead");
				}
				if(GenitalsRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Genitals");
				}
				if(GenitalsRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Genitals");
				}
				if(GenitalsRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Genitals");
				}
				if(GroinRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Groin");
				}
				if(GroinRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Groin");
				}
				if(GroinRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Groin");
				}
				if(HandRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Hand");
				}
				if(HandRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Hand");
				}
				if(HandRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Hand");
				}
				if(HeadRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Head");
				}
				if(HeadRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Head");
				}
				if(HeadRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Head");
				}
				if(HeelradioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Heel");
				}
				if(HeelradioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Heel");
				}
				if(HeelradioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Heel");
				}
				if(HipRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Hip");
				}
				if(HipRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Hip");
				}
				if(HipRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Hip");
				}
				if(KneeRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Knee");
				}
				if(KneeRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Knee");
				}
				if(KneeRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Knee");
				}
				if(LowerBackRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("LowerBack");
				}
				if(LowerBackRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left LowerBack");
				}
				if(LowerBackRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right LowerBack");
				}
				if(LowerLegRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("LowerLeg");
				}
				if(LowerLegRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left LowerLeg");
				}
				if(LowerLegRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right LowerLeg");
				}
				if(LungsRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Lungs");
				}
				if(LungsRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Lungs");
				}
				if(LungsRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Lungs");
				}
				if(MouthRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Mouth");
				}
				if(MouthRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Mouth");
				}
				if(MouthRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Mouth");
				}
				if(NeckRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Neck");
				}
				if(NeckRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Neck ");
				}
				if(NeckRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Neck");
				}
				if(NoseRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Nose");
				}
				if(NoseRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Nose");
				}
				if(NoseRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Nose");
				}
				if(ShoulderRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Shoulder");
				}
				if(ShoulderRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Shoulder");
				}
				if(ShoulderRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Shoulder");
				}
				if(SideRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Side");
				}
				if(SideRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Side");
				}
				if(SideRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Side");
				}
				if(SkinRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Skin");
				}
				if(SkinRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Skin");
				}
				if(SkinRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Skin");
				}
				if(tightRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("tight");
				}
				if(tightRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left tight");
				}
				if(tightRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right tight");
				}
				if(throatRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("throat");
				}
				if(throatRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left throat");
				}
				if(throatRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right throat");
				}
				if(thumbRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("thumb");
				}
				if(thumbRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left thumb");
				}
				if(thumbRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right thumb");
				}
				if(ToeRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Toe");
				}
				if(ToeRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Toe");
				}
				if(ToeRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Toe");
				}
				if(VaginaRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Vagina");
				}
				if(VaginaRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Vagina");
				}
				if(VaginaRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Vagina");
				}
				if(WristRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Wrist");
				}
				if(WristRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("left Wrist");
				}
				if(WristRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("right Wrist");
				}
				/*if(otherLocationRadioBtn.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient claims onset pain of 2/10. Current pain is 2/10 ");
				}
				if(otherLocationRadioBtnL.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient claims onset pain of 2/10. Current pain is 2/10 ");
				}
				if(otherLocationRadioBtnR.isSelected()){
					genericEMRChartingController.setHpiTextArea("Patient claims onset pain of 2/10. Current pain is 2/10 ");
				}*/
												
				genericEMRChartingController.saveAllTextArea(); 
				button.setTextFill(Color.GREEN);
				new FXFormCommonUtilities().closeForm( doneBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		skipBtn.setOnAction((event) -> {
			try {
				
				new FXFormCommonUtilities().closeForm( skipBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
		
	}

}
