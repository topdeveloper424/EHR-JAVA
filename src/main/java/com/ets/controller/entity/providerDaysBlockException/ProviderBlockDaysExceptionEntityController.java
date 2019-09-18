package com.ets.controller.entity.providerDaysBlockException;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;

import com.ets.model.Provider;
import com.ets.model.ProviderBlockDayException;
import com.ets.model.ProviderDaysBlockTime;
import com.ets.service.providerBlockDayExcepion.ProviderBlockDayExceptionServiceImpl;
import com.ets.service.providerDaysBlock.ProviderDaysBlockServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@Controller
public class ProviderBlockDaysExceptionEntityController {

	private ProviderBlockDayExceptionServiceImpl providerBlockDayExceptionServiceImpl;
	private ObservableList<ProviderBlockDayException> observableList;
	public ProviderBlockDaysExceptionEntityController(){
		providerBlockDayExceptionServiceImpl =(ProviderBlockDayExceptionServiceImpl) Global.context.getBean("providerBlockDayExceptionService");	
			 observableList = FXCollections.observableArrayList();
		}
	public void saveOrUpdate(List<String> dateList,Provider provider)
	{
		providerBlockDayExceptionServiceImpl.saveOrUpdate(dateList,provider);
	    // closeApplicationContext();
	}
	 public ObservableList<ProviderBlockDayException> viewProviderScheduleById(String excDateStartSt,String excDateendSt ,Provider provider){
		 
		   observableList = FXCollections.observableArrayList(providerBlockDayExceptionServiceImpl.viewProviderById(excDateStartSt, excDateendSt, provider));
				   
		//	this.CloseApplicationContext();
			return observableList;
		}
	 
	 public void delete(String startDate,String endDate,Provider provider)
		{
			providerBlockDayExceptionServiceImpl.delete(startDate, endDate, provider);
		    // closeApplicationContext();
		}
}
