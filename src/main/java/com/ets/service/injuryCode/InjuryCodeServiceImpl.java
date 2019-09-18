package com.ets.service.injuryCode;




import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.injuryCode.InjuryCodeDAO;
import com.ets.model.InjuryCode;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of InjuryCodeServiceImpl Class
 *Description: InjuryCode Entity Service class
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
public class InjuryCodeServiceImpl implements InjuryCodeService {
	
	private InjuryCodeDAO injuryCodeDAO;

	
	public void setInjuryCodeDAO(InjuryCodeDAO injuryCodeDAO) {
		this.injuryCodeDAO = injuryCodeDAO;
	}


	/** This method Save the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param injuryCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addInjuryCode(InjuryCode injuryCode) {
	
		injuryCodeDAO.addInjuryCode(injuryCode);
		
	}


	/** This method gets all the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of InjuryCode objects
	 */
	@Override
	public List<InjuryCode> injuryCodeList() {
		
		return injuryCodeDAO.injuryCodeList();
	}

	/** This method Update the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param injuryCode
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateInjuryCode(InjuryCode injuryCode) {
		// Update InjuryCode Record
		injuryCodeDAO.updateInjuryCode(injuryCode);
		
	}


	/** This method gets all the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of InjuryCode objects
	 */
	@Override
	public InjuryCode getbyInjuryID(Integer id) {
		
		return injuryCodeDAO.getbyInjuryID(id);
	}


	/** This method Delete the InjuryCode objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */ 
	@Override
	public void deleteInjuryCode(Integer id) {
		
		injuryCodeDAO.deleteInjuryCode(id);
		
	}
	
	

}
