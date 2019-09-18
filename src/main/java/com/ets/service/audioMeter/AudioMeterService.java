package com.ets.service.audioMeter;

import java.util.List;

import com.ets.model.Audiometer;

public interface AudioMeterService {

	public void saveOrUpdate(Audiometer audiometer);
	public List<Audiometer> viewAudioMeter();
	public void delete(Integer id);
}
