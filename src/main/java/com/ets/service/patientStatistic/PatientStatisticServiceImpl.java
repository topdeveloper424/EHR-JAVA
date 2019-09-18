package com.ets.service.patientStatistic;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 25-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PatientStatisticServiceImpl Class
 *Description: PatientStatistic Entity Service class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description:
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.
 */
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.patientStatistic.PatientStatisticDAO;
import com.ets.model.PatientStatistic;

import org.springframework.stereotype.Service;

@Service
@Transactional
public class PatientStatisticServiceImpl implements PatientStatisticService {
	private PatientStatisticDAO patientStatisticDAO;

	public void setPatientStatisticDAO(PatientStatisticDAO patientStatisticDAO) {
		this.patientStatisticDAO = patientStatisticDAO;
	}

	@Override
	public void saveOrUpdate(PatientStatistic patientStatistic) {
		patientStatisticDAO.saveOrUpdate(patientStatistic);

	}

}
