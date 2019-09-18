package com.ets.service.provider;
/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 26-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ProviderServiceImpl Class
 *Description: Provider Entity Service class
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
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.provider.ProviderDAO;
import com.ets.model.Provider;

@Service
@Transactional
public class ProviderServiceImpl implements ProviderService {
	
	private ProviderDAO providerDAO;

	public void setProviderDAO(ProviderDAO providerDAO) {
		this.providerDAO = providerDAO;
	}

	@Override
	public void addOrUpdate(Provider provider) {
		
		providerDAO.addOrUpdate(provider);
		
	}

	@Override
	public List<Provider> view() {
		
		return providerDAO.view();
		
	}

	@Override
	public void delete(Integer id) {
		
		providerDAO.delete(id);
		
	}

	@Override
	public Provider viewByCode(String code){
		
		return providerDAO.viewByCode(code);
	}

	@Override
	public List<Provider> viewByClinicId(Integer clinicId) {
		
		return providerDAO.viewByClinicId(clinicId);
	}

	@Override
	public Provider viewById(Integer id) {
		// TODO Auto-generated method stub
		return providerDAO.viewById(id);
	}
	

}
