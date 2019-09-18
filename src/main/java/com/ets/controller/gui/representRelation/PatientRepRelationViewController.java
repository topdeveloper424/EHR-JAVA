package com.ets.controller.gui.representRelation;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import com.ets.model.RepresentRelation;
import com.ets.utils.FXFormCommonUtilities;
import com.ets.utils.FXMLFormPath;
import com.ets.controller.entity.icd10Codes.Icd10CodesEntityController;
import com.ets.controller.entity.patientAuthRep.PatientAuthRepEntityController;
import com.ets.model.RepresentRelation;
import com.ets.controller.entity.representativeRelation.RepRelationEntityController;
import com.ets.controller.gui.patient.PatientEditController;
import com.ets.controller.gui.patient.PatientInputController;
import com.ets.controller.gui.patientRepresentative.PatientRepresentativeInputController;
import com.ets.model.Icd10Codes;
import com.ets.model.Patient;
import com.ets.model.PatientAuthRep;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class PatientRepRelationViewController  implements Initializable{

   

	@FXML
    private CheckBox includeChk;

    @FXML
    private TableView<RepresentRelation> repTableView;

    @FXML
    private TableColumn<RepresentRelation, String> repName;

    @FXML
    private TableColumn<RepresentRelation, String> cityCol;

    @FXML
    private TableColumn<RepresentRelation, String> stateCol;

    @FXML
    private TableColumn<RepresentRelation, String> phoneCol;

    @FXML
    private TableColumn<RepresentRelation, String> relationCol;

    @FXML
    private Button addBtn;

    @FXML
    private Button changeBtn;

    @FXML
    private Button delBtn;

    @FXML
    private Button clsBtn;

    public PatientInputController patientInputController;
    public PatientEditController patientEditController;
   public static Patient patient;
    public int flag=0;
    
    
	public void setPatientEditController(PatientEditController patientEditController,Patient patient) {
		this.patientEditController = patientEditController;
		this.patient = patient;
		
		viewPatientRepresentativeRelation();
		/*if(patientEditController!=null)
		{
			
			flag++;
		}*/
	}

	/*PatientRepInputRelationController repInputRelationController = new PatientRepInputRelationController();
	private void repInputRelationController() {
		// TODO Auto-generated method stub
		repInputRelationController.passingTheController(flag);
	}*/
	

	public void setPatientInputController(PatientInputController patientInputController) {
		this.patientInputController = patientInputController;
		patRepRelationData=FXCollections.observableArrayList();
		patRepRelationData.addAll(relationList);
        viewPatientRepresentativeRelation();
		
	}

	FXMLFormPath formPath = new FXMLFormPath();
    public ObservableList<RepresentRelation> patRepRelationData;
    
    /*public ObservableList<RepresentRelation> patRepRelationEditData;*/
   /* public PatientRepRelationViewController1(){
    
    patRepRelationEditData = FXCollections.observableArrayList();
    }*/
    
    public  PatientRepRelationViewController() {
    	 patRepRelationData = FXCollections.observableArrayList();
		// TODO Auto-generated constructor stub
	}
    
    public static List<RepresentRelation> relationList = new ArrayList<RepresentRelation>();
	 //RepRelationEntityController relationObject = new RepRelationEntityController();
   
    public void relationList(RepresentRelation relation) {
    	
		relationList.add(relation);
		patRepRelationData.add(relation);
    	
		
		viewPatientRepresentativeRelation();
	}
    
    
    public void viewPatientRepresentativeRelation()
    {
     	if(patientEditController!=null){
     		System.out.println("PPPPPPPPPPPPRRRRRRRRRRRRRRRRRRRRRRPPPPPPPPPPPPPPPPPPP");
       		patRepRelationData = new RepRelationEntityController().viewRelation(patient.getId());
       		System.out.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD"+patient.getId());
       		//new RepRelationEntityController().viewRelation(patient.getId());
       		//System.out.println("  "+patRepRelationData.get(0).getRep().getFirstName());
       	}
     	
     	
    	//patRepRelationEditData = new RepRelationEntityController().viewRelation();
    	repName.setCellValueFactory(cellData ->cellData.getValue().getRep().firstNameProperty());
    	cityCol.setCellValueFactory(cellData -> cellData.getValue().getRep().getAddress()!=null?cellData.getValue().getRep().getAddress().cityProperty():null);
    	stateCol.setCellValueFactory(cellData ->cellData.getValue().getRep().getAddress()!=null? cellData.getValue().getRep().getAddress().stateProperty():null);
    	phoneCol.setCellValueFactory(cellData -> cellData.getValue().getRep().getAddress()!=null?cellData.getValue().getRep().getAddress().phoneProperty():null);
       	relationCol.setCellValueFactory(new PropertyValueFactory<RepresentRelation, String>("relation"));
    	
    	
    	/*relationCol.setCellValueFactory(cellData -> cellData.getValue().getRelation());*/
    	
    	//FilteredList<RepresentRelation> filteredData = new FilteredList<RepresentRelation>(patRepRelationData, p -> true);
       	/*if(patientInputController!=null){
    	repTableView.setItems(patRepRelationData);
       	}*/
       	repTableView.setItems(patRepRelationData);
      
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		viewPatientRepresentativeRelation();
		
		addBtn.setOnAction((event)->{
			try{
							
					String formName = formPath.context.getMessage("EnterAuthorisedPatientRepresentative", null, Locale.US);
					String formTitle = formPath.context.getMessage("Title.EnterAuthorisedPatientRepresentative", null, Locale.US);
					formPath.closeApplicationContext();
					PatientRepInputRelationController repRelationInput = (PatientRepInputRelationController) new FXFormCommonUtilities()
							.displayForm(formName,formTitle);
					repRelationInput.setPatientRepRelationViewController(this,patient);
					
						}catch (Exception ex) {
							ex.printStackTrace();
						}
		});
		
		/*repTableView;*/
		changeBtn.setOnAction((event)->{
			RepresentRelation changeQuery = repTableView.getSelectionModel().getSelectedItem();
			int index = repTableView.getSelectionModel().getSelectedIndex();
			try{
				
				String formName = formPath.context.getMessage("EnterAuthorisedPatientRepresentative", null, Locale.US);
				String formTitle = formPath.context.getMessage("Title.EnterAuthorisedPatientRepresentative", null, Locale.US);
				formPath.closeApplicationContext();

				PatientRepInputRelationController repRelationInput = (PatientRepInputRelationController) new FXFormCommonUtilities().displayForm(formName, formTitle);
				
				repRelationInput.setPatientRepRelationViewController1(this,changeQuery,index,patient);
				
			}
			catch (Exception ex) {
				ex.printStackTrace();
			}
			
		});
		
		//Deleteing a representative Relation
		delBtn.setOnAction((event)->{
			//From Input Controller and then deleting
			if(patientEditController==null){
			/*if(relationList==null){
				RepresentRelation deleteQuery = repTableView.getSelectionModel().getSelectedItem();
				RepRelationEntityController deleteRelation = new RepRelationEntityController();
				deleteRelation.delete(deleteQuery.getId());
				}else{*/
					//System.out.println(relationList.size());
					relationList.remove(repTableView.getSelectionModel().getSelectedItem().getId());
					
					patRepRelationData.remove(repTableView.getSelectionModel().getSelectedItem());
					//System.out.println(relationList.size());
				//}
				viewPatientRepresentativeRelation();
			}
			//From Edit Controller and then deleting
			if(patientEditController!=null){
				
				RepresentRelation deleteQuery = repTableView.getSelectionModel().getSelectedItem();
				new RepRelationEntityController().delete(deleteQuery.getId());;
				//-->deleteRelation.delete(deleteQuery.getId());
				//patRepRelationData.remove(repTableView.getSelectionModel().getSelectedItem());
				viewPatientRepresentativeRelation();
			}
		});
		//close the form
		clsBtn.setOnAction((event)->{
			try {
				new FXFormCommonUtilities().closeForm(clsBtn);
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
			
		});
	}
    
}
