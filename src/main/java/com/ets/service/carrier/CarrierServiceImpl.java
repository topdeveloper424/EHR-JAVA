package com.ets.service.carrier;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.carrier.CarrierDAO;
import com.ets.dao.carrier.CarrierDAOImpl;
import com.ets.model.Carrier;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CarrierServiceImpl Class
 *Description: Carrier Entity Service Class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *Version:
 *Description
 *Backup Location for Previous Version:
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 */

@Transactional
@Service
public class CarrierServiceImpl implements CarrierService {

	private CarrierDAO carrierDAO;

	public void setCarrierDAO(CarrierDAO carrierDAO) {
		this.carrierDAO = carrierDAO;
	}

	@Override
	public void addOrUpdate(Carrier carrier) {
		carrierDAO.add(carrier);

	}

	@Override
	public List<Carrier> view() {

		return carrierDAO.view();
	}

	@Override
	public Carrier viewByCode(String code) {
		// TODO Auto-generated method stub
		return carrierDAO.viewByCode(code);
	}

	@Override
	public void delete(Integer id) {
		carrierDAO.delete(id);
	}

}
