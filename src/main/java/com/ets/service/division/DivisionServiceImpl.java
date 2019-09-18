package com.ets.service.division;



import java.util.List;








import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.division.DivisionDAO;
import com.ets.model.Division;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of DivisionServiceImpl Class
 *Description: Division Entity Service class
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
public class DivisionServiceImpl implements DivisionService {
	
	private DivisionDAO divisionDAO;

	public void setDivisionDAO(DivisionDAO divisionDAO) {
		this.divisionDAO = divisionDAO;
	}

	/** This method save the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param division
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addDivision(Division division) {
		divisionDAO.addDivision(division);
		
	}

	/** This method gets all the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	@Override
	public List<Division> divisionList() {
		
		return divisionDAO.divisionList();
	}

	/** This method update the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param division
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateDivision(Division division) {
		
		divisionDAO.updateDivision(division);
		
	}

	/** This method get all the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	@Override
	public Division getByDivisionID(Integer id) {
		
		return divisionDAO.getByDivisionID(id);
	}

	/** This method delete the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteDivision(Integer id) {
		
		divisionDAO.deleteDivision(id);
		
	}
	/** This method get all the Division objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Division objects
	 */
	@Override
	public List<Division> viewDivisionById(Integer id) {
		// TODO Auto-generated method stub
		return divisionDAO.viewDivisionById(id);
	}

	@Override
	public Division viewByCode(String code) {
		
		return divisionDAO.viewByCode(code);
	}

		

}
