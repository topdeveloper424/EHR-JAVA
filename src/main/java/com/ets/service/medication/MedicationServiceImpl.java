package com.ets.service.medication;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.medication.MedicationDao;
import com.ets.model.Medication;


@Service
@Transactional
public class MedicationServiceImpl implements MedicationService {

	
	private MedicationDao medicationDao;
	
	
	public void setMedicationDao(MedicationDao medicationDao) {
		this.medicationDao = medicationDao;
	}

	@Override
	public void saveOrUpdate(Medication medication) {
		medicationDao.saveOrUpdate(medication);
		
	}

	@Override
	public List<Medication> view() {
		// TODO Auto-generated method stub
		return medicationDao.view();
	}

	@Override
	public Medication searchByName(String medName) {
		// TODO Auto-generated method stub
		return medicationDao.searchByDescrip(medName);
	}

}
