package com.ets.service.illnessCode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.illnessCode.IllnessCodeDAO;
import com.ets.model.IllnessCode;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 23-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of IllnessCodeServiceImpl Class
 *Description: Illness Entity Service class
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
public class IllnessCodeServiceImpl implements IllnessCodeService {

	private IllnessCodeDAO illnessCodeDAO;

	public void setIllnessCodeDAO(IllnessCodeDAO illnessCodeDAO) {
		this.illnessCodeDAO = illnessCodeDAO;
	}

	/** This method save the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param illnessCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addIllnessCode(IllnessCode illnessCode) {
	
		illnessCodeDAO.addIllnessCode(illnessCode);

	}

	/** This method gets all the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IllnessCode objects
	 */
	@Override
	public List<IllnessCode> illnessCodeList() {
		
		return illnessCodeDAO.illnessCodeList();
	}

	/** This method update the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param illnessCode
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateIllnessCode(IllnessCode illnessCode) {
		
		illnessCodeDAO.updateIllnessCode(illnessCode);
		
	}

	/** This method gets all the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of IllnessCode objects
	 */
	@Override
	public IllnessCode getByIllnessCodeID(Integer id) {
		
		return illnessCodeDAO.getByIllnessCodeID(id);
	}

	/** This method delete the IllnessCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 23-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteIllnessCode(Integer id) {
		
		illnessCodeDAO.deleteIllnessCode(id);
		
	}

}
