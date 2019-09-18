package com.ets.dao.audioMeter;

import java.util.List;

import com.ets.model.Audiometer;

public interface AudioMeterDAO {

	public void saveOrUpdate(Audiometer audiometer);
	public List<Audiometer> viewAudioMeter();
	public void delete(Integer id);
}
