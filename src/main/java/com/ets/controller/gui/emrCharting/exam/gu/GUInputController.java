package com.ets.controller.gui.emrCharting.exam.gu;

/*

 *Original Author: Sumanta Deyashi on Behalf of ETS for Client Company
 *File Creation Date: 03-02-2017
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of GUInputController Class
 *Description: gu.fxml Controller class
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

import java.io.Serializable;
import java.net.URL;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.gui.emrCharting.GenericEMRChartingController;
import com.ets.controller.gui.emrCharting.exam.gi.comprehensive.GiComprehensiveIputController;
import com.ets.controller.gui.emrCharting.exam.gu.comprehensiveMultiSystem.GUComprehensiveInputController;
import com.ets.controller.gui.emrCharting.exam.gu.malePenis.ExamMalePensInputController;
import com.ets.controller.gui.emrCharting.exam.gu.prostate.ExamProstateInputController;
import com.ets.controller.gui.emrCharting.exam.gu.testes.ExamGUTestesInputController;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.utils.Global;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class GUInputController implements Initializable {

	@FXML
	private CheckBox AllNormalCompCheck;

	@FXML
	private CheckBox ComprehensiveCheck;

	@FXML
	private CheckBox MalePenisCheck;

	@FXML
	private CheckBox HerniaReduceCheck;

	@FXML
	private CheckBox MaleHyderoceleCheck;

	@FXML
	private CheckBox HerniaIncarcCheck;

	@FXML
	private CheckBox StdCheck;

	@FXML
	private CheckBox TorsionCheck;

	@FXML
	private CheckBox MaleProstateCheck;

	@FXML
	private CheckBox MaleTestesCheck;

	@FXML
	private CheckBox EpididymitisCheck;

	@FXML
	private Button skipBtn;

	@FXML
	private Button doneBtn;

	
	private Button button;
	
	private CheckBox checkBox;
	
	public static Integer formCount = 0;
	private Integer secondFormCount = 0;
	private Integer flag = 0;
	private Integer flag1 = 0;

	FXMLFormPath formPath = new FXMLFormPath();
	
	private GenericEMRChartingController genericEMRChartingController;

	public void setGenericEMRChartingController(GenericEMRChartingController genericEMRChartingController,
			Button button , CheckBox checkBox) {
		this.genericEMRChartingController = genericEMRChartingController;
		this.button = button;
		this.checkBox = checkBox;
	}

	public String str = "\n\n: ";

	void formCountIncrement() {
		++secondFormCount;
	}
	    
	    public void setGIUI(){
	    	
	    	if(AllNormalCompCheck.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GU Male: Exam shows normal testes, normal penis, prostate not enlarged and without masses. ");
				str = str1.toString();
				AllNormalCompCheck.setSelected(false);
				setGIUI();
	    		
	    	}
	    	else if(ComprehensiveCheck.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamGUcomprehensive", null, Locale.US);
	    		
				String formTitle1 = formPath.context.getMessage("Title.ExamGUcomprehensive", null, Locale.US);
				
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
				
				GUComprehensiveInputController guComprehensiveInputController=
			   (GUComprehensiveInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				guComprehensiveInputController.setGuInputController(this);
				
				ComprehensiveCheck.setSelected(false);
			   
	    	}
	    	 else if(MalePenisCheck.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamGUpens", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamGUpens", null, Locale.US);
				
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
				
				ExamMalePensInputController examMalePensInputController=
			   (ExamMalePensInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				examMalePensInputController.setGuInputController(this);
				
				MalePenisCheck.setSelected(false);
			   
	    	}else if(MaleProstateCheck.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamGUprostate", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamGUprostate", null, Locale.US);
				
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
				
				ExamProstateInputController examProstateInputController=
			   (ExamProstateInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				examProstateInputController.setGuInputController(this);
				
				MaleProstateCheck.setSelected(false);
			   
	    	}else if(MaleTestesCheck.isSelected()){
	    		formCountIncrement();
	    		String formName = formPath.context.getMessage("ExamGUTests", null, Locale.US);
				String formTitle1 = formPath.context.getMessage("Title.ExamGUTests", null, Locale.US);
				
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
				
				ExamGUTestesInputController guTestesInputController=
			   (ExamGUTestesInputController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				guTestesInputController.setGuInputController(this);
				
				MaleTestesCheck.setSelected(false);
			   
	    	}else if(EpididymitisCheck.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GU Male: Exam shows tender testes on the affected side, but one can get above it to feel the epididymis which is more tender and has a ' bag of worms ' consistency . Normal penis without rash  There are no inguinal nodes or hernias.");
				str = str1.toString();
				EpididymitisCheck.setSelected(false);
				setGIUI();
	    		
	    	}else if(HerniaIncarcCheck.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GU Male: Exam shows normal testes, normal penis. A hernia check reveals a tender bulging mass on the affected side which is not reducible and appears to be incarcerated.");
				str = str1.toString();
				HerniaIncarcCheck.setSelected(false);
				setGIUI();
	    		
	    	}else if(HerniaReduceCheck.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GU Male: Exam shows normal testes, normal penis. A hernia check reveals a bulging mass on the affected side which is reducible.");
				str = str1.toString();
				HerniaReduceCheck.setSelected(false);
				setGIUI();
	    		
	    	}else if(MaleHyderoceleCheck.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GU Male: Exam shows normal testes on the unaffected side, normal penis. The affected side presents with mildly tender swelling that transilluminates.");
				str = str1.toString();
				MaleHyderoceleCheck.setSelected(false);
				setGIUI();
	    		
	    	}else if(StdCheck.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GU Male: Exam shows normal testes, normal penis, without rash but there is a mucoid discharge. There are some inguinal nodes but no hernias.");
				str = str1.toString();
				StdCheck.setSelected(false);
				setGIUI();
	    		
	    	}else if(TorsionCheck.isSelected()){
	    		
	    		StringBuilder str1 = new StringBuilder(str);
				str1.append("GU Male: Exam shows tender testes on the affected side, and one cannot get above it to feel the epididymis . Normal penis without rash  There are no inguinal nodes or hernias.");
				str = str1.toString();
				TorsionCheck.setSelected(false);
				setGIUI();
	    		
	    	}
	    	
	    	
	    	else if(secondFormCount==formCount){
	    		
	    		 genericEMRChartingController.paint(button);
	    		 genericEMRChartingController.hideCheckBox(checkBox);
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
				
				setGIUI();
			
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
