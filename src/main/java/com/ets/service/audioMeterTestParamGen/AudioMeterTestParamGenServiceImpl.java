package com.ets.service.audioMeterTestParamGen;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

//import com.ets.dao.audioMeter.AudioMeterDAO;
import com.ets.dao.audiometerTestParamGen.AudioMeterTestParamGenDAO;
import com.ets.model.AudioMeterTestParamGen;

@Service
@Transactional
public class AudioMeterTestParamGenServiceImpl {
	private AudioMeterTestParamGenDAO audioMeterTestParamGenDAO;
	
	
	//@Override
	public void add(AudioMeterTestParamGen audioMeterTestParamGen) {
		audioMeterTestParamGenDAO.add(audioMeterTestParamGen);
	}
	
	
	
	
}
