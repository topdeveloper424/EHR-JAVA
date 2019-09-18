package com.ets.controller.entity.patientAppointment;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Patient;
import com.ets.model.PatientAppointment;
import com.ets.service.patientAppointment.PatientAppointmentServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PatientAppointmentEntityController {

   // private static ClassPathXmlApplicationContext context;
    private PatientAppointmentServiceImpl patientAppointmentServiceImpl;
    private ObservableList< PatientAppointment> observableList;
   
    public PatientAppointmentEntityController(){
    	
    	//context=new ClassPathXmlApplicationContext("spring.xml");
    	patientAppointmentServiceImpl = (PatientAppointmentServiceImpl) Global.context.getBean("patientAppointmentService");
    	observableList =FXCollections.observableArrayList();
	
    }
    public void saveOrUpdate(PatientAppointment patientAppointment)
    {
    	patientAppointmentServiceImpl.saveOrUpdate(patientAppointment);  
    //	context.close();
    	
    }
    public void delete(Integer id)
    {
    	patientAppointmentServiceImpl.delete(id);  
    //	context.close();
    	
    }
    
    public ObservableList<PatientAppointment> viewByDate(Date date){
    	
    	observableList = FXCollections
				.observableArrayList(patientAppointmentServiceImpl.viewByDate(date));
    	//context.close();
		return observableList;
		
    }
    

public ObservableList<PatientAppointment> viewById(Integer patentId){
    	
    	observableList = FXCollections
				.observableArrayList(patientAppointmentServiceImpl.viewById(patentId));
    	//context.close();
		return observableList;
		
    }


    public ObservableList<PatientAppointment> viewByProiderAndDate(Date date,Integer id)
    {
    	observableList = FXCollections
				.observableArrayList(patientAppointmentServiceImpl.viewByProiderAndDate(date, id));
				//context.close();
				
				return observableList;
    }

    public ObservableList<PatientAppointment> viewByNameAndDate(String firstName,String lastName,Date date){
    	observableList = FXCollections.observableArrayList(patientAppointmentServiceImpl.viewByNameAndDate(firstName, lastName, date));
    	//context.close();
		
		return observableList;

}
    public ObservableList<PatientAppointment> viewByNameDateProviderId(String firstName,String lastName,Date date,String purpose){
	observableList = FXCollections.observableArrayList(patientAppointmentServiceImpl.viewByNameDateProviderId(firstName, lastName, date,purpose));
	//context.close();
	
	return observableList;

}
    
    
    public ObservableList<PatientAppointment> viewByNameDateProviderAndTime(Date date,String time,String providerCode){
    	observableList = FXCollections.observableArrayList(patientAppointmentServiceImpl.viewByNameDateProviderAndTime(date, time, providerCode));
    	//context.close();
    	
    	return observableList;

    }
    
    
    public ObservableList<PatientAppointment> viewByNameDateProviderPurpose(String firstName, String lastName, Date date,
			String purpose, String providerFirst,String providerLast, String status){
    	observableList = FXCollections.observableArrayList(patientAppointmentServiceImpl.viewByNameDateProviderPurpose(firstName, lastName, date, purpose, providerFirst, providerLast, status));
    	//context.close();
    	
    	return observableList;

    }
    public ObservableList<PatientAppointment> viewByBothProvider(String firstName,String lastName,String firstName1,String lastName1,Date date){
    	observableList = FXCollections.observableArrayList(patientAppointmentServiceImpl.viewByBothProvider(firstName, lastName, firstName1, lastName1, date));
    	//context.close();
    	
    	return observableList;

    } 
    
    public ObservableList<PatientAppointment> viewByProvider(String firstName,String lastName){
    	observableList = FXCollections.observableArrayList(patientAppointmentServiceImpl.viewByProvider(firstName, lastName));
    	//context.close();
    	
    	return observableList;

    } 
    
    }
    
    

