package com.ets.service.exposureCode;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.exposureCode.ExposureCodeDAO;
import com.ets.model.ExposureCode;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ExposureCodeServiceImpl Class
 *Description: ExposureCode Entity Service class
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
public class ExposureCodeServiceImpl implements ExposureCodeService{
	
	private ExposureCodeDAO exposureCodeDAO;

	public void setExposureCodeDAO(ExposureCodeDAO exposureCodeDAO) {
		this.exposureCodeDAO = exposureCodeDAO;
	}

	/** This method save the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param exposureCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addExposureCode(ExposureCode exposureCode) {
		
		exposureCodeDAO.addExposureCode(exposureCode);
		
		
	}


	/** This method gets all the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ExposureCode objects
	 */
	@Override
	public List<ExposureCode> exposureCodeList() {
		
		return exposureCodeDAO.exposureCodeList();
	}

	/** This method update the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param exposureCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateExposureCode(ExposureCode exposureCode) {
		
		exposureCodeDAO.updateExposureCode(exposureCode);
		
	}

	/** This method gets all the ExposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ExposureCode objects
	 */
	@Override
	public ExposureCode getByExposureCodeID(Integer id) {
		
		return exposureCodeDAO.getByExposureCodeID(id);
	}

	/** This method delete the exposureCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteExposureCode(Integer id) {
		
		exposureCodeDAO.deleteExposureCode(id);
		
	}
	
	
	

}
