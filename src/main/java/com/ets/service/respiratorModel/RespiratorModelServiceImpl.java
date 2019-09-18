package com.ets.service.respiratorModel;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.respiratorModel.RespiratorModelDAO;
import com.ets.model.RespiratorModel;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RespiratorModelServiceImpl Class
 *Description: RespiratorModel Entity Service class
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
public class RespiratorModelServiceImpl implements RespiratorModelService{
	
	private RespiratorModelDAO respiratorModelDAO;
	

	public void setRespiratorModelDAO(RespiratorModelDAO respiratorModelDAO) {
		this.respiratorModelDAO = respiratorModelDAO;
	}
	/** This method save the RespiratorModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param respiratorModel
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addRespiratorModel(RespiratorModel respiratorModel) {
		
		respiratorModelDAO.addRespiratorModel(respiratorModel);
		
	}
	/** This method gets all the RespiratorModel objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RespiratorModel objects
	 */
	@Override
	public List<RespiratorModel> viewAllRespiratorModel() {
		
		return respiratorModelDAO.viewAllRespiratorModel();
	}
	@Override
	public void delete(Integer id) {
	
		respiratorModelDAO.delete(id);
		
	}

}
