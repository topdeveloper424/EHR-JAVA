package com.ets.dao.visionTestParam;

import java.util.List;

import com.ets.model.VisionTestParam;

public interface VisionTestParamDAO {

	public void saveOrUpdate(VisionTestParam visionTestParam);
	public List<VisionTestParam> viewVisionTestParam();
	public void delete(Integer id);
}
