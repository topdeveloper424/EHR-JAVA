package com.ets.service.reasonOrCause;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.reasonOrCause.ReasonOrCauseDAO;
import com.ets.model.ReasonOrCause;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ReasonOrCauseServiceImpl Class
 *Description: ReasonOrCause Entity Service class
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
public class ReasonOrCauseServiceImpl implements ReasonOrCauseService {
	
	private ReasonOrCauseDAO reasonOrCauseDAO;

	
	public void setReasonOrCauseDAO(ReasonOrCauseDAO reasonOrCauseDAO) {
		this.reasonOrCauseDAO = reasonOrCauseDAO;
	}


	/** This method save the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param reasonOrCause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addReasonOrCause(ReasonOrCause reasonOrCause) {
		
		reasonOrCauseDAO.addReasonOrCause(reasonOrCause);
		
	}



	/** This method gets all the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ReasonOrCause objects
	 */
	@Override
	public List<ReasonOrCause> reasonCauseLists() {
		
		return reasonOrCauseDAO.reasonCauseLists();
	}



	/** This method update the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param reasonOrCause
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateReasonOrCause(ReasonOrCause reasonOrCause) {
		
		reasonOrCauseDAO.updateReasonOrCause(reasonOrCause);
		
	}


	/** This method gets all the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ReasonOrCause objects
	 */
	@Override
	public ReasonOrCause getByReasonOrCauseID(Integer id) {
		
		return reasonOrCauseDAO.getByReasonOrCauseID(id);
	}


	/** This method delete the ReasonOrCause objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteReasonOrCause(Integer id) {
		
		reasonOrCauseDAO.deleteReasonOrCause(id);
		
	}
	
	

}
