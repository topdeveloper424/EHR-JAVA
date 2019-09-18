package com.ets.controller.entity.clinicianDaysBlockException;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.ets.model.Clinician;
import com.ets.model.ClinicianBlockDayException;
import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;
import com.ets.service.clinicianDaysBlockException.ClinicianDaysBlockExceptionService;
import com.ets.service.clinicianDaysBlockException.ClinicianDaysBlockExceptionServiceImpl;
import com.ets.service.providerBlockDayExcepion.ProviderBlockDayExceptionServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
@Controller
public class ClinicianBlockDaysExceptionEntityController {
	private ClinicianDaysBlockExceptionServiceImpl clinicianDaysBlockExceptionServiceImpl;
	private ObservableList<ClinicianBlockDayException> observableList;
	public ClinicianBlockDaysExceptionEntityController(){
		clinicianDaysBlockExceptionServiceImpl =(ClinicianDaysBlockExceptionServiceImpl) Global.context.getBean("clinicianDaysBlockExceptionService");	
			 observableList = FXCollections.observableArrayList();
		}
	public void saveOrUpdate(List<String> dateList,Clinician clinician)
	{
		clinicianDaysBlockExceptionServiceImpl.saveOrUpdate(dateList,clinician);
	    // closeApplicationContext();
	}
	 public ObservableList<ClinicianBlockDayException> viewClinicianScheduleById(String excDateStartSt,String excDateendSt ,Clinician clinician){
		 
		   observableList = FXCollections.observableArrayList(clinicianDaysBlockExceptionServiceImpl.viewClinicianById(excDateStartSt, excDateendSt, clinician));
				   
		//	this.CloseApplicationContext();
			return observableList;
		}
	 
	 public void delete(String startDate,String endDate,Clinician clinician)
		{
		 clinicianDaysBlockExceptionServiceImpl.delete(startDate, endDate, clinician);
		    // closeApplicationContext();
		}
}