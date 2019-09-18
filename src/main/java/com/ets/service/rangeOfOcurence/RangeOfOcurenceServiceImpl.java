package com.ets.service.rangeOfOcurence;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.rangeOfOcurence.RangeOfOcurenceDAO;
import com.ets.model.RangeOfOcurence;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of RangeOfOcurenceServiceImpl Class
 *Description: RangeOfOcurence Entity Service class
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
public class RangeOfOcurenceServiceImpl implements RangeOfOcurenceService {
	
	private RangeOfOcurenceDAO rangeOfOcurenceDAO;

	public void setRangeOfOcurenceDAO(RangeOfOcurenceDAO rangeOfOcurenceDAO) {
		this.rangeOfOcurenceDAO = rangeOfOcurenceDAO;
	}
	/** This method save the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rangeOfOcurence
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(RangeOfOcurence rangeOfOcurence) {
		rangeOfOcurenceDAO.add(rangeOfOcurence);
		
	}
	/** This method gets all the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RangeOfOcurence objects
	 */
	@Override
	public List<RangeOfOcurence> list() {
		
		return rangeOfOcurenceDAO.list();
	}
	/** This method update the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param rangeOfOcurence
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(RangeOfOcurence rangeOfOcurence) {
		rangeOfOcurenceDAO.update(rangeOfOcurence);
		
	}
	/** This method gets all the RangeOfOcurence objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RangeOfOcurence objects
	 */
	@Override
	public RangeOfOcurence getByID(Integer id) {
		
		return rangeOfOcurenceDAO.getByID(id);
	}
	/** This method delete the RangeOfOcurence objects currently present in the system .
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
		rangeOfOcurenceDAO.delete(id);
		
	}
	

}
