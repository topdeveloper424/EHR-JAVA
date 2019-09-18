package com.ets.controller.gui.emrCharting.exam.skin;

/*
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 27-01-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExamSkinInputController Class
 *Description: skin.fxml GUI Controller class
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
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.constitutional.appearance.ExamSmartConstInputController;
import com.ets.controller.gui.emrCharting.exam.skin.examComprehensive.ExamComprehensiveMultiInputController;
import com.ets.controller.gui.emrCharting.exam.skin.skinAlopecia.SkinAlopeciaInputController;
import com.ets.controller.gui.emrCharting.exam.skin.skinBurn.SkinBurnInputController;
import com.ets.controller.gui.emrCharting.exam.skin.skinDermGlobal.SkinDermGlobalInputController;
import com.ets.controller.gui.emrCharting.exam.skin.skinLacerationFollowUp.SkinLacerationFollowUpInputController;
import com.ets.controller.gui.emrCharting.exam.skin.skinLacerationNew.SkinLacerationNewInputController;
import com.ets.controller.gui.emrCharting.exam.skin.skinSclapHair.SkinSclapHairInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class ExamSkinInputController implements Initializable {
	 
	 @FXML
	    private CheckBox allNormalCheckBox;

	    @FXML
	    private CheckBox examCheckBox;

	    @FXML
	    private CheckBox sclapCheckBox;

	    @FXML
	    private CheckBox chikenPoxNewCheckBox;

	    @FXML
	    private CheckBox burnCheckBox;

	    @FXML
	    private CheckBox chikenPoxOldCheckBox;

	    @FXML
	    private CheckBox dermCheckBox;

	    @FXML
	    private CheckBox dermatitiesCheckBox;

	    @FXML
	    private CheckBox impetigoCheckBox;

	    @FXML
	    private CheckBox LacerationNewCheckBox;

	    @FXML
	    private CheckBox LacerationFollowCheckBox;

	    @FXML
	    private CheckBox ringwormCheckBox;

	    @FXML
	    private CheckBox urticareCheckBox;

	    @FXML
	    private CheckBox wartCheckBox;

	    @FXML
	    private CheckBox alopeciaCheckBox;

	    @FXML
	    private Button skipBtn;

	    @FXML
	    private Button doneBtn;

	private Button button;

	FXMLFormPath formPath = new FXMLFormPath();

	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
	}

	public static Integer formCount = 0;
	private Integer secondFormCount = 0;

	public String str="\n\n";

	void formCountIncrement() {
		++secondFormCount;
	}
	  private Integer flag=0;  
	    public void setSkinUI(){
	    	
	    	/*StringBuilder str11 = new StringBuilder(str);
			str11.append("SKIN: ");
			str = str11.toString();
			*/
		//setSkinUI 
    		
		if(allNormalCheckBox.isSelected()){
			
			   allNormalCheckBox.setSelected(false);
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("SKIN: Patient's skin was examined for signs of central cyanosis or peripheral cyanosis. Any skin abnormality such as diffuse ecchymosis, lesions, uticaria, erythema or induration were noted.  No abnormal findings.");
				str = str1.toString();
				
				
				setSkinUI();
				
				
	    		
	    	}

	    	else if(examCheckBox.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkinComprehensive", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamSkinComprehensive", null, Locale.US);
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				formPath.closeApplicationContext();
				
				ExamComprehensiveMultiInputController examSmartSkinInputController=
			   (ExamComprehensiveMultiInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				examSmartSkinInputController.setExamSkinInputController(this);
				examCheckBox.setSelected(false);
				
			   
	    	}else if(sclapCheckBox.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkinSclapHair", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamSkinSclapHair", null, Locale.US);
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				formPath.closeApplicationContext();
				
				SkinSclapHairInputController skinSclapHairInputController =
			   (SkinSclapHairInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skinSclapHairInputController.setExamSkinInputController(this);
				sclapCheckBox.setSelected(false);
			   
	    	}
	    	else if(alopeciaCheckBox.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkinAlopecia", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamSkinAlopecia", null, Locale.US);
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				formPath.closeApplicationContext();
				
				SkinAlopeciaInputController skinAlopeciaInputController =
			   (SkinAlopeciaInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skinAlopeciaInputController.setExamSkinInputController(this);
				alopeciaCheckBox.setSelected(false);
			   
	    	} 
	    	else if(burnCheckBox.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkinSkinBurn", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamSkinSkinBurn", null, Locale.US);
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				formPath.closeApplicationContext();
				
				SkinBurnInputController skinBurnInputController=
			   (SkinBurnInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skinBurnInputController.setExamSkinInputController(this);
				burnCheckBox.setSelected(false);
			   
	    	}
	    	else if(chikenPoxNewCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("SKIN:Skin exam reveals diffuse vesicular \"dew drop \"like lesions on erythematous base, some are excoriated.");
				str = str1.toString();
				chikenPoxNewCheckBox.setSelected(false);
				setSkinUI();
	    		
	    	}
	    	else if(chikenPoxOldCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("SKIN:Skin exam reveals no vesicular  lesions but there is dried  \"scabbing\" of old lesions diffusely.");
				str = str1.toString();
				chikenPoxOldCheckBox.setSelected(false);
				setSkinUI();
	    		
	    	}
	    	else if(dermCheckBox.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkinDermGlobal", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamSkinDermGlobal", null, Locale.US);
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				formPath.closeApplicationContext();
				
				SkinDermGlobalInputController skinDermGlobalInputController=
			   (SkinDermGlobalInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skinDermGlobalInputController.setExamSkinInputController(this);
				dermCheckBox.setSelected(false);
			   
	    	}
	    	else if(dermatitiesCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("SKIN:Skin exam reveals raised red maculopapular lesions on a erythematous base");
				str = str1.toString();
				dermatitiesCheckBox.setSelected(false);
				setSkinUI();
	    		
	    	}
	    	else if(impetigoCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("SKIN:Skin exam reveals lesion with raised red edges with scales and yellow crusting.");
				str = str1.toString();
				impetigoCheckBox.setSelected(false);
				setSkinUI();
	    		
	    	}else if(LacerationNewCheckBox.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkinLacerationNew", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamSkinLacerationNew", null, Locale.US);
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				formPath.closeApplicationContext();
				
				SkinLacerationNewInputController skinLacerationNewInputController=
			   (SkinLacerationNewInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skinLacerationNewInputController.setExamSkinInputController(this);
				LacerationNewCheckBox.setSelected(false);
			   
	    	}else if(LacerationFollowCheckBox.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamSkinLacerationFollowUp", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamSkinLacerationFollowUp", null, Locale.US);
				String formTitle2 = null;
				String formTitle3 = null;
				String formTitle4 = null;
				
				if(Global.patient != null){
					
					formTitle2 = Global.patient.getPatientName().getFirstName();
					formTitle3 = Global.patient.getPatientName().getMiddleName();
					formTitle4 = Global.patient.getPatientName().getLastName();
					
				}
				String formTitle = formTitle1+" "+"("+formTitle2+" "+formTitle3+" "+formTitle4+")";
				formPath.closeApplicationContext();
				
				SkinLacerationFollowUpInputController skinLacerationFollowUpInputController=
			   (SkinLacerationFollowUpInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				skinLacerationFollowUpInputController.setExamSkinInputController(this);
				LacerationFollowCheckBox.setSelected(false);
			   
	    	}
	    	else if(ringwormCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append(" SKIN:Skin exam reveals patchlike lesion with raised red scaly edges.");
				str = str1.toString();
				ringwormCheckBox.setSelected(false);
				setSkinUI();
	    		
	    	}
	    	else if(urticareCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("SKIN: Skin exam reveals diffuse urticarial wheals.");
				str = str1.toString();
				urticareCheckBox.setSelected(false);
				setSkinUI();
	    		
	    	}
	    	else if(wartCheckBox.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("SKIN:The affected area reveals a warty growth that is not pedunculated. The remainder of skin exam reveals no other lesions, rashes or abnormalities. Turgor is good.");
				str = str1.toString();
				wartCheckBox.setSelected(false);
				setSkinUI();
	    		
	    	}
	    	
	      if(secondFormCount==formCount){
	    		
	    	  
	    		 genericEMRChartingController.paint(button);
	    		new FXFormCommonUtilities().closeForm(doneBtn);
	    		formCount=0;
	    		genericEMRChartingController.setExamOrganTextArea(str);
	    		genericEMRChartingController.saveAllTextArea();
		    	
	    	}
	    	
	    	
	    }
	    
	
		
	    
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		

		doneBtn.setOnAction((event)->
		{
			
			setSkinUI();
			
		
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
