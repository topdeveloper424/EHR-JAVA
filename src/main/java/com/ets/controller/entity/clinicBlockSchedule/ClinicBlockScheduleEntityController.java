package com.ets.controller.entity.clinicBlockSchedule;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ets.model.ClinicBlockSchedule;
import com.ets.service.clinicBlockSchedule.ClinicBlockScheduleService;
import com.ets.service.clinicBlockSchedule.ClinicBlockScheduleServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Controller
public class ClinicBlockScheduleEntityController {

	
	 private ClinicBlockScheduleServiceImpl clinicBlockScheduleServiceImpl;
	
	 public void setClinicBlockScheduleService(ClinicBlockScheduleServiceImpl clinicBlockScheduleService) {
		this.clinicBlockScheduleServiceImpl = clinicBlockScheduleServiceImpl;
	}

	public  ClinicBlockScheduleEntityController(){
		clinicBlockScheduleServiceImpl = (ClinicBlockScheduleServiceImpl) Global.context.getBean("clinicBlockScheduleService"); 
		 
	 }
	 
	ObservableList<ClinicBlockSchedule> observableList = FXCollections.observableArrayList();
 
	 
	 public void save(List<ClinicBlockSchedule> clinicBlockSchedules){
		 System.out.println("****controller****"+clinicBlockSchedules.size());
		 clinicBlockScheduleServiceImpl.saveOrUpdate(clinicBlockSchedules);
	  
  }

	 public List<ClinicBlockSchedule> viewByDate(List<Date> date){
		
	
		return  clinicBlockScheduleServiceImpl.viewByDate(date); 
		 
	 }

	 public void delete(List<ClinicBlockSchedule> clinicBlockSchedules){
			
			
		  clinicBlockScheduleServiceImpl.delete(clinicBlockSchedules);
			 
		 }
	 
}
