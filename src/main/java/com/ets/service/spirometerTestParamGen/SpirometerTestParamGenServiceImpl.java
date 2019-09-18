package com.ets.service.spirometerTestParamGen;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.spirometerTestParamGen.SpirometerTestParamGenDAO;
import com.ets.model.SpirometerTestParamGen;
/**
 *Original Author: Ayan Kumar Misra on Behalf of ETS for Client Company
 *File Creation Date: 22-11-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of spirometerTestParamGenServiceImpl Class
 *Description:spirometerTestParamGenServiceImpl
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
public class SpirometerTestParamGenServiceImpl implements SpirometerTestParamGenService {

	private SpirometerTestParamGenDAO spirometerTestParamGenDAO;

	public void setSpirometerTestParamGenDAO(SpirometerTestParamGenDAO spirometerTestParamGenDAO) {
		this.spirometerTestParamGenDAO = spirometerTestParamGenDAO;
	}

	@Override
	public void saveSpirometerTestParamGen(SpirometerTestParamGen spirometerTestParamGen) {
		spirometerTestParamGenDAO.saveSpirometerTestParamGen(spirometerTestParamGen);
	}

}
