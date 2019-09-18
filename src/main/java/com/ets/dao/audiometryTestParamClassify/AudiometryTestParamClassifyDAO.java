package com.ets.dao.audiometryTestParamClassify;

import java.util.List;

import com.ets.model.AudioMeterTestParamGen;
import com.ets.model.AudiometryTestParamClassify;

public interface AudiometryTestParamClassifyDAO {

	public void saveOrUpdate(AudiometryTestParamClassify audiometryTestParamClassify);
	public List<AudiometryTestParamClassify> viewAudiometryTestParamClassify();
	public void delete(Integer id);
	
}
