package com.ets.service.vitalSignRange;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.vitalSignRange.VitalSignRangeDAO;
import com.ets.model.VitalSignRange;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of VitalSignRangeServiceImpl Class
 *Description: VitalSignRange Entity Service class
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
public class VitalSignRangeServiceImpl implements VitalSignRangeService {
	
	private VitalSignRangeDAO  vitalSignRangeDAO;

	public void setVitalSignRangeDAO(VitalSignRangeDAO vitalSignRangeDAO) {
		this.vitalSignRangeDAO = vitalSignRangeDAO;
	}
	/** This method save the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param vitalSignRange
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(VitalSignRange vitalSignRange) {
		vitalSignRangeDAO.add(vitalSignRange);
		
	}
	/** This method gets all the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of VitalSignRange objects
	 */
	@Override
	public List<VitalSignRange> list() {
		
		return vitalSignRangeDAO.list();
	}
	/** This method update the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param vitalSignRange
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(VitalSignRange vitalSignRange) {
		vitalSignRangeDAO.update(vitalSignRange);
		
	}
	/** This method gets  the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of VitalSignRange objects
	 */
	@Override
	public VitalSignRange getByID(Integer id) {
		
		return vitalSignRangeDAO.getByID(id);
	}
	/** This method delete the VitalSignRange objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {
		vitalSignRangeDAO.delete(id);
		
	}
	

}
