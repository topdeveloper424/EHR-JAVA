package com.ets.controller.entity.emrHpi;

import java.util.List;

import org.springframework.stereotype.Controller;

import com.ets.model.EmrHpi;
import com.ets.service.access.AccessServiceImpl;
import com.ets.service.emrHpi.EmrHpiServiceImpl;
import com.ets.utils.Global;


public class EmrHpiEntityController {

	private EmrHpiServiceImpl emrHpiServiceImpl;

	public void setEmrHpiServiceImpl(EmrHpiServiceImpl emrHpiServiceImpl) {
		this.emrHpiServiceImpl = emrHpiServiceImpl;
	}
	
	
	public EmrHpiEntityController() {
		emrHpiServiceImpl = (EmrHpiServiceImpl) Global.context.getBean("emrHpiService");
	}


	/*public void saveOrUpdate(EmrHpi emrHpi){
		
		emrHpiServiceImpl.saveOrUpdate(emrHpi);
		
		
	}*/
	
	public void saveOrUpdate(List<EmrHpi> emrHpi){
		
		emrHpiServiceImpl.saveOrUpdate(emrHpi);
		
		
	}
	public int delete(String emrHpi){
	
		
		return emrHpiServiceImpl.delete(emrHpi);
		
		
	}
	
	/*
	public List<EmrHpi> view(){
		
		return emrHpiServiceImpl.view();
		
	}*/
}
