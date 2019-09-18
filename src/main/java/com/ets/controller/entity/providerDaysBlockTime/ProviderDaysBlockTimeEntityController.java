package com.ets.controller.entity.providerDaysBlockTime;

import java.util.List;

import com.ets.model.Provider;
import com.ets.model.ProviderBlockTime;
import com.ets.model.ProviderDaysBlockTime;
import com.ets.service.providerBlockTime.StaffBlockTimeServiceImpl;
import com.ets.service.providerDaysBlock.ProviderDaysBlockService;
import com.ets.service.providerDaysBlock.ProviderDaysBlockServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProviderDaysBlockTimeEntityController {

	private ProviderDaysBlockServiceImpl providerDaysBlockServiceImpl;
	 private ObservableList<ProviderDaysBlockTime> observableList;
	public ProviderDaysBlockTimeEntityController(){
		providerDaysBlockServiceImpl =(ProviderDaysBlockServiceImpl) Global.context.getBean("providerDaysBlockService");	
		 observableList = FXCollections.observableArrayList();
	}
	
	public void saveOrUpdate(List<ProviderDaysBlockTime> providerDaysBlockTimes)
	{
		providerDaysBlockServiceImpl.saveOrUpdate(providerDaysBlockTimes);
	    // closeApplicationContext();
	}
	 public ObservableList<ProviderDaysBlockTime> viewProviderScheduleById(Provider providerId,String weekDay){
		 
		   observableList = FXCollections.observableArrayList(providerDaysBlockServiceImpl.getProviderDaysBlockTimes(providerId, weekDay));
		//	this.CloseApplicationContext();
			return observableList;
		}
	   
	 public void deleteBlock(List<ProviderDaysBlockTime> providerDaysBlockTimes){
		 providerDaysBlockServiceImpl.DeleteBlocks(providerDaysBlockTimes);
	 }
	 public List<ProviderDaysBlockTime> viewByProviderId(Provider provider){
		 return providerDaysBlockServiceImpl.viewProviderById(provider);
	 }
	 
}

	
	
