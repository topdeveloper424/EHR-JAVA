package com.ets.controller.entity.audiometryTestParamGen;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.AudioMeterTestParamGen;
import com.ets.model.PatientAnalysis;
import com.ets.service.audioMeterTestParamGen.AudioMeterTestParamGenServiceImpl;

import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;






public class AudiometryTestParamGenEntityController {
	
	private AudioMeterTestParamGenServiceImpl audioMeterTestParamGenServiceImpl;
	
	public void add(AudioMeterTestParamGen audioMeterTestParamGen) {
		audioMeterTestParamGenServiceImpl.add(audioMeterTestParamGen);
	}
	
	
	
	
	
	
	/*public void add(AudioMeterTestParamGen audioMeterTestParamGen) {
		audioMeterTestParamGenServiceImpl.add(audioMeterTestParamGen);
	}*/

}
