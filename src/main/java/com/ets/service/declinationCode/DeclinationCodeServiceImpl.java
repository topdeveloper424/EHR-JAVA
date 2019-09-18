package com.ets.service.declinationCode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.declinationCode.DeclinationCodeDAO;
import com.ets.model.DeclinationCode;

/**
 *Original Author: Neha Sahadev on Behalf of ETS for Client Company
 *File Creation Date: 02-10-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DeclinationCodeServiceImpl Class
 *Description: DeclinationCode Entity Service Class
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
public class DeclinationCodeServiceImpl implements DeclinationCodeService {
	
	private DeclinationCodeDAO declinationCodeDAO;

	public void setDeclinationCodeDAO(DeclinationCodeDAO declinationCodeDAO) {
		this.declinationCodeDAO = declinationCodeDAO;
	}

	/** This method save the declinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param declinationCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void add(DeclinationCode declinationCode) {
		
		declinationCodeDAO.add(declinationCode);
		
	}

	/** This method gets all the DeclinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeclinationCode objects
	 */
	
	@Override
	public List<DeclinationCode> list() {
		
		return declinationCodeDAO.list();
	}

	/** This method update the declinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param declinationCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void update(DeclinationCode declinationCode) {
		
		declinationCodeDAO.update(declinationCode);
		
	}

	/** This method gets all the DeclinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of DeclinationCode objects
	 */
	@Override
	public DeclinationCode getByID(Integer id) {
		
		return declinationCodeDAO.getByID(id);
	}

	/** This method Remove the DeclinationCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void delete(Integer id) {
		
		declinationCodeDAO.delete(id);
		
	}
	

}
