package com.ets.service.caseClosedReason;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.caseClosedReason.CaseClosedReasonStatusDAO;
import com.ets.model.CaseClosedReason;

/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of CaseClosedReasonStatusServiceImpl Class
 *Description: CaseClosedReason Entity Service class
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
public class CaseClosedReasonStatusServiceImpl implements CaseClosedReasonStatusService {
	
	private CaseClosedReasonStatusDAO reasonStatusDAO;

	public void setReasonStatusDAO(CaseClosedReasonStatusDAO reasonStatusDAO) {
		this.reasonStatusDAO = reasonStatusDAO;
	}

	/** This method Save the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param caseClosedReason
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void addCaseClosedReason(CaseClosedReason caseClosedReason) {
		
		reasonStatusDAO.addCaseClosedReason(caseClosedReason);
		
	}

	/** This method gets all the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CaseClosedReason objects
	 */
	@Override
	public List<CaseClosedReason> caseClosedReasonList() {
		
		return reasonStatusDAO.caseClosedReasonList();
	}

	/** This method Update the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param caseClosedReason
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void updateCaseClosedReason(CaseClosedReason caseClosedReason) {
		
		reasonStatusDAO.updateCaseClosedReason(caseClosedReason);
		
	}

	/** This method gets all the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of CaseClosedReason objects
	 */
	@Override
	public CaseClosedReason getByCaseClosedReasonID(Integer id) {
		
		return reasonStatusDAO.getByCaseClosedReasonID(id);
	}

	/** This method Delete the CaseClosedReason objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 20-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void deleteCaseClosedReason(Integer id) {
		
		reasonStatusDAO.deleteCaseClosedReason(id);
		
	}
	
	

}
