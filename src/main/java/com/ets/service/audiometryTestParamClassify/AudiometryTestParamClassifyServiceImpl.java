package com.ets.service.audiometryTestParamClassify;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.audiometryTestParamClassify.AudiometryTestParamClassifyDAO;
import com.ets.model.AudiometryTestParamClassify;

@Service
@Transactional
public class AudiometryTestParamClassifyServiceImpl implements AudiometryTestParamClassifyService {
	private AudiometryTestParamClassifyDAO audiometryTestParamClassifyDAO;
	 

	public void setAudiometryTestParamClassifyDAO(AudiometryTestParamClassifyDAO audiometryTestParamClassifyDAO) {
		this.audiometryTestParamClassifyDAO = audiometryTestParamClassifyDAO;
	}

	@Override
	public void saveOrUpdate(AudiometryTestParamClassify audiometryTestParamClassify) {

		audiometryTestParamClassifyDAO.saveOrUpdate(audiometryTestParamClassify);

	}

		
	@Override
	public List<AudiometryTestParamClassify> viewAudiometryTestParamClassify() {

		return audiometryTestParamClassifyDAO.viewAudiometryTestParamClassify();
	}

	@Override
	public void delete(Integer id) {

		audiometryTestParamClassifyDAO.delete(id);

	}

}
