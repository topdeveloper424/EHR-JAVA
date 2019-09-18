package com.ets.service.visionTestParam;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.visionTestParam.VisionTestParamDAO;
import com.ets.model.VisionTestParam;

@Service
@Transactional
public class VisionTestParamServiceImpl  implements VisionTestParamService {
	private VisionTestParamDAO visionTestParamDAO;

	public void setVisionTestParamDAO(VisionTestParamDAO visionTestParamDAO) {
		this.visionTestParamDAO = visionTestParamDAO;
	}

	@Override
	public void saveOrUpdate(VisionTestParam visionTestParam) {
		visionTestParamDAO.saveOrUpdate(visionTestParam);
		
	}

	@Override
	public List<VisionTestParam> viewVisionTestParam() {
		
		return visionTestParamDAO.viewVisionTestParam();
	}

	@Override
	public void delete(Integer id) {
		visionTestParamDAO.delete(id);
		
	}

}
