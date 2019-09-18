package com.ets.service.spirometer;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.spirometer.SpirometerDAO;
import com.ets.model.Spirometer;
/**
 *Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company
 *File Creation Date: 22-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SpirometerServiceImpl Class
 *Description:SpirometerServiceImpl
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
@Service
@Transactional
public class SpirometerServiceImpl implements SpirometerService {

	private SpirometerDAO spirometerDAO;

	public void setSpirometerDAO(SpirometerDAO spirometerDAO) {
		this.spirometerDAO = spirometerDAO;

	}

	@Override
	public void saveSpirometer(Spirometer spirometer) {
        spirometerDAO.saveSpirometer(spirometer);
	}

	@Override
	public List<Spirometer> view() {
		return spirometerDAO.view();
		
	}

	/*@Override
	public Spirometer getById(Integer id) {
		// TODO Auto-generated method stub
		return spirometerDAO.getById(id);	}
*/
	/*
	@Override
	public void update(Spirometer spirometer) {
		// TODO Auto-generated method stub
		spirometerDAO.update(spirometer);
	}*/

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		spirometerDAO.delete(id);
	}
	
}
