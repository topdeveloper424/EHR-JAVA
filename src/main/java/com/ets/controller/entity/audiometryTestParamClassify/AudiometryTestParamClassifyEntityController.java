package com.ets.controller.entity.audiometryTestParamClassify;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.AudioMeterTestParamGen;
import com.ets.model.Audiometer;
import com.ets.model.AudiometryTestParamClassify;
import com.ets.model.PatientAnalysis;
import com.ets.service.audioMeterTestParamGen.AudioMeterTestParamGenServiceImpl;
import com.ets.service.audiometryTestParamClassify.AudiometryTestParamClassifyServiceImpl;

import com.ets.utils.Global;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AudiometryTestParamClassifyEntityController {

	//private static ClassPathXmlApplicationContext context;
	private AudiometryTestParamClassifyServiceImpl audiometryTestParamClassifyServiceImpl;
	//private AudioMeterTestParamGenServiceImpl audioMeterTestParamGenServiceImpl;
	private ObservableList<AudiometryTestParamClassify> observableList;

	public AudiometryTestParamClassifyEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		audiometryTestParamClassifyServiceImpl = (AudiometryTestParamClassifyServiceImpl) Global.context
				.getBean("audiometryTestParamClassifyService");
		observableList = FXCollections.observableArrayList();

	}
	
	/*public void add(AudioMeterTestParamGen audioMeterTestParamGen) {
		audioMeterTestParamGenServiceImpl.add(audioMeterTestParamGen);
	}
	*/
	
	
	public void saveOrUpdate(AudiometryTestParamClassify audiometryTestParamClassify) {
		audiometryTestParamClassifyServiceImpl.saveOrUpdate(audiometryTestParamClassify);
		//this.closeApplicationContext();

	}

	public ObservableList<AudiometryTestParamClassify> view() {

		observableList = FXCollections
				.observableArrayList(audiometryTestParamClassifyServiceImpl.viewAudiometryTestParamClassify());

		//this.closeApplicationContext();
		return observableList;

	}

	public void delete(Integer id) {
		audiometryTestParamClassifyServiceImpl.delete(id);
		//this.closeApplicationContext();
	}
}
