package com.ets.service.cptCode;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.cptCode.CptCodeDAO;
import com.ets.model.CptCode4Hcpcs;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CptCodeServiceImpl Class
 *Description: CptCode Entity Service class
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
public class CptCodeServiceImpl implements CptCodeService {
	
	private CptCodeDAO cptCodeDAO;

	public void setCptCodeDAO(CptCodeDAO cptCodeDAO) {
		this.cptCodeDAO = cptCodeDAO;
	}


	/** This method save the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cptCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void add(CptCode4Hcpcs cptCode) {
		
		cptCodeDAO.add(cptCode);
	}

	/** This method gets all the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	@Override
	public List<CptCode4Hcpcs> list() {
		
		return cptCodeDAO.list();
	}

	/** This method update the cptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param cptCode
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void update(CptCode4Hcpcs cptCode) {
		
		cptCodeDAO.update(cptCode);
	}

	/** This method gets all the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	@Override
	public CptCode4Hcpcs getByID(Integer id) {
		
		return cptCodeDAO.getByID(id);
	}


	/** This method Remove the cptCode objects currently present in the system .
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
		
		cptCodeDAO.delete(id);
	}


	/** This method gets  the CptCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param code
	 * @since 31-08-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CptCode objects
	 */
	
	@Override
	public CptCode4Hcpcs viewByCode(String code) {
		
		return cptCodeDAO.viewByCode(code);
		
	}
	

}
