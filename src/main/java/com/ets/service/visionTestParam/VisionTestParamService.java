package com.ets.service.visionTestParam;

import java.util.List;

import com.ets.model.VisionTestParam;

public interface VisionTestParamService {
	public void saveOrUpdate(VisionTestParam visionTestParam);
	public List<VisionTestParam> viewVisionTestParam();
	public void delete(Integer id);
}
