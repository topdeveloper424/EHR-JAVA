package com.ets.service.vitalReader;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.vitalReader.VitalReaderDAO;
import com.ets.model.VitalReader;

@Service
@Transactional
public class VitalReaderServiceImpl implements VitalReaderService {
	private VitalReaderDAO vitalReaderDAO;

	public void setVitalReaderDAO(VitalReaderDAO vitalReaderDAO) {
		this.vitalReaderDAO = vitalReaderDAO;
	}

	@Override
	public void saveOrUpdate(VitalReader vitalReader) {
		vitalReaderDAO.saveOrUpdate(vitalReader);

	}

	@Override
	public List<VitalReader> viewVitalReader() {

		return vitalReaderDAO.viewVitalReader();
	}

	@Override
	public void delete(Integer id) {
		vitalReaderDAO.delete(id);

	}

	@Override
	public void updateVitalReader(VitalReader vitalReader) {
		vitalReaderDAO.updateVitalReader(vitalReader);
		
	}

}
