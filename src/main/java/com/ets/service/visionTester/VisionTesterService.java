package com.ets.service.visionTester;

import java.util.List;

import com.ets.model.VisionTester;

public interface VisionTesterService {
	public void saveOrUpdate(VisionTester visionTester);
	public List<VisionTester> viewVisionTester();
	public void delete(Integer id);
}
