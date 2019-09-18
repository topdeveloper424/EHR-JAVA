package com.ets.service.audioMeter;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.audioMeter.AudioMeterDAO;
import com.ets.model.Audiometer;

@Service
@Transactional
public class AudioMeterServiceImpl implements AudioMeterService{
   private AudioMeterDAO audioMeterDAO;
	
	public void setAudioMeterDAO(AudioMeterDAO audioMeterDAO) {
	this.audioMeterDAO = audioMeterDAO;
}

	@Override
	public void saveOrUpdate(Audiometer audiometer) {
		audioMeterDAO.saveOrUpdate(audiometer);
		
	}

	@Override
	public List<Audiometer> viewAudioMeter() {
		
		return audioMeterDAO.viewAudioMeter();
	}

	@Override
	public void delete(Integer id) {
		audioMeterDAO.delete(id);
		
	}

}
