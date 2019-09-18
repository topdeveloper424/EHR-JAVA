package com.ets.controller.entity.clinicianDaysBlockTime;

import java.util.List;

import org.springframework.stereotype.Controller;


import com.ets.model.Clinician;
import com.ets.model.ClinicianDaysBlockTime;
import com.ets.model.Provider;
import com.ets.model.ProviderDaysBlockTime;
import com.ets.service.clinicianDaysBlockTime.ClinicianDaysBlockTimeServiceImpl;

import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Controller
public class ClinicianDaysBlockTimeEntityController {

	private ClinicianDaysBlockTimeServiceImpl clinicianDaysBlockTimeServiceImpl;

	 private ObservableList<ClinicianDaysBlockTime> observableList;
	public void setClinicianDaysBlockTimeServiceImpl(ClinicianDaysBlockTimeServiceImpl clinicianDaysBlockTimeServiceImpl) {
		this.clinicianDaysBlockTimeServiceImpl = clinicianDaysBlockTimeServiceImpl;
	}

	public ClinicianDaysBlockTimeEntityController(){
		clinicianDaysBlockTimeServiceImpl =(ClinicianDaysBlockTimeServiceImpl) Global.context.getBean("clinicianDaysBlockTimeService");	
		 observableList = FXCollections.observableArrayList();
	}
	
	public void saveOrUpdate(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes)
	{
		clinicianDaysBlockTimeServiceImpl.saveOrUpdate(clinicianDaysBlockTimes);
	    // closeApplicationContext();
	}
	 public ObservableList<ClinicianDaysBlockTime> viewClinicianDaysBlockTime(Clinician clinician,String weekDay){
		 
		   observableList = FXCollections.observableArrayList(clinicianDaysBlockTimeServiceImpl.getClinicianDaysBlockTime(clinician, weekDay));
		//	this.CloseApplicationContext();
			return observableList;
		}
	   
	 public void deleteBlock(List<ClinicianDaysBlockTime> clinicianDaysBlockTimes){
		 clinicianDaysBlockTimeServiceImpl.DeleteBlocks(clinicianDaysBlockTimes);
	 }
	 public List<ClinicianDaysBlockTime> viewByClinicianId(Clinician clinician){
		 return clinicianDaysBlockTimeServiceImpl.viewClinicianById(clinician);
	 }
	 
	 
	 public ObservableList<ClinicianDaysBlockTime> viewClinicianScheduleById(Clinician clinicianId,String weekDay){
		 
		   observableList = FXCollections.observableArrayList(clinicianDaysBlockTimeServiceImpl.getClinicianDaysBlockTime(clinicianId, weekDay));
		//	this.CloseApplicationContext();
			return observableList;
		}
	
	
}
