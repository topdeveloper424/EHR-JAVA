package com.ets.service.sicCode;



import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.sicCode.SicCodeDAO;
import com.ets.model.SICCode;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 24-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of SicCodeServiceImpl Class
 *Description: SICCode Entity Service class
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
public class SicCodeServiceImpl implements SicCodeService {
	
	private SicCodeDAO sicCodeDAO;

	public void setSicCodeDAO(SicCodeDAO sicCodeDAO) {
		this.sicCodeDAO = sicCodeDAO;
	}

	/** This method save the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sicCode
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addSICCode(SICCode sicCode) {
		
		sicCodeDAO.addSICCode(sicCode);
		
	}

	/** This method gets all the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SICCode objects
	 */
	@Override
	public List<SICCode> sICCodeList() {
		
		return sicCodeDAO.sicCodeList();
	}

	/** This method update the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param sicCode
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateSICCode(SICCode sicCode) {
		
		sicCodeDAO.updateSICCode(sicCode);
		
	}

	/** This method gets all the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of SICCode objects
	 */
	@Override
	public SICCode getBySICCodeID(Integer id) {
		
		return sicCodeDAO.getBySICCodeID(id);
	}

	/** This method delete the SICCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 24-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteSICCode(Integer id) {
		
		sicCodeDAO.deleteSICCode(id);
		
	}

	@Override
	public SICCode viewByCode(String code) {
		// TODO Auto-generated method stub
		return sicCodeDAO.viewByCode(code);
	}
	
	
	
	
}
