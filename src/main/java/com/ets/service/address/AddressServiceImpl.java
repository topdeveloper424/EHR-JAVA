package com.ets.service.address;

import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.address.AddressDAO;
import com.ets.model.Address;

import org.springframework.stereotype.Service;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 19-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AddressServiceImpl Interface
 *Description: Address Entity Service Interface
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

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	private AddressDAO addressDAO;

	public void setAddressDAO(AddressDAO addressDAO) {
		this.addressDAO = addressDAO;
	}

	@Override
	public void add(Address address) {
		
		addressDAO.add(address);
		
	}

	@Override
	public void update(Address address) {
		
		addressDAO.update(address);
		
	}
		

}
