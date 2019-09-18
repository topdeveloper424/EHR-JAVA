package com.ets.service.firstResponse;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.firstResponse.FirstResponseDAO;
import com.ets.model.FirstResponse;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of FirstResponseServiceImpl Class
 *Description: FirstResponse Entity Service class
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
public class FirstResponseServiceImpl implements FirstResponseService {
	
	private FirstResponseDAO firstresponseDAO;
	
	
	public void setFirstresponseDAO(FirstResponseDAO firstresponseDAO) {
		this.firstresponseDAO = firstresponseDAO;
	}

	/** This method save the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param firstResponse
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void addFirstResponse(FirstResponse firstResponse) {
		
		firstresponseDAO.addFirstResponse(firstResponse);
		
	}

	/** This method gets all the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of FirstResponse objects
	 */
	@Override
	public List<FirstResponse> firstResponseList() {
		
		return firstresponseDAO.firstResponseList();
	}

	/** This method update the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param firstResponse
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateFirstResponse(FirstResponse firstResponse) {
		
		firstresponseDAO.updateFirstResponse(firstResponse);
	}

	/** This method gets all the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of FirstResponse objects
	 */
	@Override
	public FirstResponse getbyFirstResponseID(Integer id) {
		
		return firstresponseDAO.getbyFirstResponseID(id);
	}

	/** This method delete the FirstResponse objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void dleteFirstResponse(Integer id) {
		
		firstresponseDAO.dleteFirstResponse(id);
		
	}

}
