package com.ets.service.audiometryTestParamClassify;

import java.util.List;

import com.ets.model.AudiometryTestParamClassify;

import com.ets.model.PatientAnalysis;

public interface AudiometryTestParamClassifyService {
	public void saveOrUpdate(AudiometryTestParamClassify audiometryTestParamClassify);
	public List<AudiometryTestParamClassify> viewAudiometryTestParamClassify();
	public void delete(Integer id);
	
}
