package com.ets.controller.entity.audioMeter;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Audiometer;
import com.ets.service.audioMeter.AudioMeterServiceImpl;
import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AudioMeterEntityController {
	
	//private static ClassPathXmlApplicationContext context;
	private AudioMeterServiceImpl audioMeterServiceImpl;
	private ObservableList<Audiometer> observableList;

	public AudioMeterEntityController() {

		// = new ClassPathXmlApplicationContext("spring.xml");
		audioMeterServiceImpl = (AudioMeterServiceImpl) Global.context.getBean("audioMeterService");
		observableList = FXCollections.observableArrayList();

	}

	
	public void saveOrUpdate(Audiometer audiometer) {
		audioMeterServiceImpl.saveOrUpdate(audiometer);
		//this.closeApplicationConrext();

	}

	public ObservableList<Audiometer> viewAudioMeter() {

		observableList = FXCollections.observableArrayList(audioMeterServiceImpl.viewAudioMeter());

		//this.closeApplicationConrext();
		return observableList;

	}

	public void delete(Integer id) {
		audioMeterServiceImpl.delete(id);
		//this.closeApplicationConrext();
	}

}
