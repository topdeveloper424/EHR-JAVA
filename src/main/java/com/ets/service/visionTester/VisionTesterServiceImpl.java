package com.ets.service.visionTester;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.visionTester.VisionTesterDAO;
import com.ets.model.VisionTester;

@Service
@Transactional
public class VisionTesterServiceImpl implements VisionTesterService {
	private VisionTesterDAO visionTesterDAO;

	public void setVisionTesterDAO(VisionTesterDAO visionTesterDAO) {
		this.visionTesterDAO = visionTesterDAO;
	}

	@Override
	public void saveOrUpdate(VisionTester visionTester) {
		visionTesterDAO.saveOrUpdate(visionTester);

	}

	@Override
	public List<VisionTester> viewVisionTester() {

		return visionTesterDAO.viewVisionTester();
	}

	@Override
	public void delete(Integer id) {
		visionTesterDAO.delete(id);

	}

}
