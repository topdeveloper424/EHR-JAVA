package com.ets.dao.visionTester;

import java.util.List;

import com.ets.model.VisionTester;

public interface VisionTesterDAO {

	public void saveOrUpdate(VisionTester visionTester);
	public List<VisionTester> viewVisionTester();
	public void delete(Integer id);
}
