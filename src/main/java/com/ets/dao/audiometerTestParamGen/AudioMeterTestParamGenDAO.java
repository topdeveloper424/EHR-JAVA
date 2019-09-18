package com.ets.dao.audiometerTestParamGen;

import com.ets.model.AudioMeterTestParamGen;

public interface AudioMeterTestParamGenDAO {

	public void saveOrUpdate(AudioMeterTestParamGen audioMeterTestParamGen);
	public AudioMeterTestParamGen view();
	public void add(AudioMeterTestParamGen audioMeterTestParamGen);
}
