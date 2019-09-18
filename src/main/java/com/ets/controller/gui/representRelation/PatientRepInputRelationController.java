package com.ets.controller.gui.representRelation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import com.ets.controller.entity.representativeRelation.RepRelationEntityController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.controller.gui.patientRepresentative.PatientRepresentativeInputController;
import com.ets.controller.gui.patientRepresentative.PatientRepresentativeViewController;
import com.ets.model.PatientAuthRep;
import com.ets.model.Patient;
import com.ets.model.RepresentRelation;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class PatientRepInputRelationController implements Initializable{

    @FXML
    private Label repLabel;

    @FXML
    private Label reltnLabel;

    @FXML
    private Button okBtn;

    @FXML
    private Button closeBtn;

    @FXML
    private ChoiceBox<String> selectRelation;

    @FXML
    private Label noteLabel;

    @FXML
    private TextArea noteText;

    @FXML
    private Button selectBtn;

    @FXML
    private CheckBox chkActive;
    
    @FXML
    private Label representativeName;

    private PatientInputController patientInputController;
    private PatientRepresentativeViewController patientRep;
    private PatientRepRelationViewController patientRepRelationViewControllerEdit;
    private PatientRepRelationViewController patientRepRelationViewController;
    private PatientRepresentativeViewController patientRepresentativeViewController = new PatientRepresentativeViewController();
    private PatientEditController patientEditController;
    private Patient pat;
    //private int flag1;
   /* public PatientEditController getPatientEditController() {
		return patientEditController;
	}

*/


	public void setPatientEditController(PatientEditController patientEditController) {
		this.patientEditController = patientEditController;
		//pat = patient;
		//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$"+pat.getId());
	}
	
	/*public void se(PatientRepRelationViewController patient)
	{
		pat=patient;
	}*/

	private PatientAuthRep representative;
    private RepresentRelation representRelation;// = new RepresentRelation();
    
    //to dynamically set value to label
    
    public void selectedPatientRepresentative(PatientAuthRep representative)
	{
		this.representative = representative;
		representativeName.setText(representative.getFirstName()+" "+representative.getLastName());
		
	}
    
    
    
    
    /*public void public void setPatientRep(PatientRepresentativeViewController patientRep) {
		this.patientRep = patientRep;
	}*/

	/*public PatientRepresentativeViewController getPatientRepresentativeViewController() {
		return patientRepresentativeViewController;
	}
*/
	public void setPatientRepresentativeViewController(
			PatientRepresentativeViewController patientRepresentativeViewController) {
		
		this.patientRepresentativeViewController = patientRepresentativeViewController;
		
		
		
	}
	
	/*public void passingTheController(int flag){
		flag1 = flag;
	}*/

	/*public PatientRepRelationViewController getPatientRepRelationViewController() {
		return patientRepRelationViewController;
	}*/
	private RepresentRelation object;// = new RepresentRelation();
	int indx;
	
	
	 public void setPatientRepRelationViewController1(PatientRepRelationViewController patientRepRelationViewController, RepresentRelation representRelation,int index,Patient patient) {
		this.patientRepRelationViewControllerEdit = patientRepRelationViewController;
		object = representRelation;
		indx = index;
		pat = patient;
		
		if(PatientRepRelationViewController.relationList!=null){	
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$");
			representativeName.setText(object.getRep().getFirstName()+" "+object.getRep().getLastName());
			selectRelation.setValue(object.getRelation());
			noteText.setText(object.getRelation_notes());
	 }
		
	}
	 /*else{
		 representativeName.setText(PatientRepRelationViewController.relationList.);
	 }*/
	public void setPatientRepRelationViewController(PatientRepRelationViewController patientRepRelationViewController,Patient patient){
		this.patientRepRelationViewController = patientRepRelationViewController;
		this.pat = patient;
	}
	
	FXMLFormPath formPath = new FXMLFormPath();
	//String value = representative.getFirstName();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		
		// TODO Auto-generated method stub
		
		
		List<String> list1 = new ArrayList<String>();
		list1.add("Mother");
		list1.add("Father");
		list1.add("Brother");
		list1.add("Sister");
		list1.add("Son");
		list1.add("Daughter");
		ObservableList relationList =  FXCollections.observableList(list1);
		selectRelation.getItems().clear();
		selectRelation.setItems(relationList);
		
		
		selectBtn.setOnAction((event)->{
			
			//patientRep.viewPatientAuthRep();
			try {

				String formName = formPath.context.getMessage("PatientRepresentative", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.PatientRepresentative", null, Locale.US);
				formPath.closeApplicationContext();

				PatientRepresentativeViewController patientRepresentativeViewController = (PatientRepresentativeViewController) new FXFormCommonUtilities().displayForm(formName, formTitle);

				patientRepresentativeViewController.setPatientRepInputRelationController(this);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
						
		});
		
		okBtn.setOnAction((event)->{
			
			RepresentRelation relation= new RepresentRelation();
				
			
			if(object!=null && representative==null){
				relation=object;
				
			}else{
				relation.setRep(representative);
			}
			relation.setRelation(selectRelation.getValue());
			relation.setRelation_notes(noteText.getText());
			
			//From Input->Edit in static list 
			//System.out.println("##############"+pat.getId());
			if(patientRepRelationViewControllerEdit!=null ?patientRepRelationViewControllerEdit.patientInputController!=null : false)
			{
				System.out.println("#88VVVVVVVVVVVVVVVVVVVVVVVVVVVVVV888#  1");
				patientRepRelationViewControllerEdit.patRepRelationData.set(indx, relation);
				//patientRepRelationViewControllerEdit.relationList.set(indx, relation);
				patientRepRelationViewControllerEdit.viewPatientRepresentativeRelation();
			}
			
			if(patientRepRelationViewController!=null)
			{
				System.out.println("#88VVVVVVVVVVVVVVVVVVVVVVVVVVVVVV888# 2 ");
				//From Input->Add-in static list
				if(patientRepRelationViewController.patientInputController!=null)
				{
					System.out.println("#88VVVVVVVVVVVVVVVVVVVVVVVVVVVVVV888#");
					patientRepRelationViewController.relationList(relation);	
					patientRepRelationViewController.viewPatientRepresentativeRelation();
				}
				
				//From Edit->Add new representative in database
				if(patientRepRelationViewController.patientEditController!=null)
				{
					System.out.println("#88VVVVVVVVVVVVVVVVVVVVVVVVVVVVVV888# 3" + pat.getId());
					relation.setPat(pat);
					new RepRelationEntityController().addrelation(relation);
					patientRepRelationViewController.viewPatientRepresentativeRelation();
					
				}
			}
			
		
			/*}
			if(indx!= 0)
			{
				patientRepRelationViewController.relationList(indx, relation);
				PatientRepRelationViewController.patRepRelationData.set
			}*/
			//From Edit->Edit in database
			if(patientRepRelationViewControllerEdit!=null?patientRepRelationViewControllerEdit.patientEditController!=null:false)
			{
				System.out.println("QQQQQQQQQQQQQQQQQQQQQQQQQQQ"+pat.getId());
				if(object!=null)
				{
				 //patientInserted.getId()
					//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$"+pat.getId());
					relation.setPat(pat);
				 relation.setId(object.getId());
				 new RepRelationEntityController().saveUpdate(relation);
				 System.out.println("PPPPPPPPPPPPPPPPPPPPPPPPP");
				 patientRepRelationViewControllerEdit.viewPatientRepresentativeRelation();
				 //System.out.println(pat.getId());
				}
				/*
				
				if(object==null)
				{
					 System.out.println("PgfyufyfyifyifyifyfyifyfufyuPPPPP");
					 System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$"+pat.getId());
					 //System.out.println(pat.getId());
					relation.setPat(pat);
					new RepRelationEntityController().addrelation(relation);
					patientRepRelationViewController.viewPatientRepresentativeRelation();
				}*/
				//patientRepRelationViewController.viewPatientRepresentativeRelation();
			}
			System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
			
			new FXFormCommonUtilities().closeForm(okBtn);
		});
		
		closeBtn.setOnAction((event) -> {
			try {
				new FXFormCommonUtilities().closeForm(closeBtn);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		});
		
	}




}
