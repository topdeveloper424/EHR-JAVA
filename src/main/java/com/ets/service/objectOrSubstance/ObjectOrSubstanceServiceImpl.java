package com.ets.service.objectOrSubstance;



import java.util.List;







import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.objectOrSubstance.ObjectOrSubstanceDAO;
import com.ets.model.ObjectOrSubstance;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 19-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ObjectOrSubstanceServiceImpl Class
 *Description: ObjectOrSubstance Entity Service class
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
public class ObjectOrSubstanceServiceImpl implements ObjectOrSubstanceService {
	
	private ObjectOrSubstanceDAO objectOrSubstanceDAO;

	
	public void setObjectOrSubstanceDAO(ObjectOrSubstanceDAO objectOrSubstanceDAO) {
		this.objectOrSubstanceDAO = objectOrSubstanceDAO;
	}


	/** This method save the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param objectOrSubstance
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addObjectorSubstance(ObjectOrSubstance objectOrSubstance) {
		
		objectOrSubstanceDAO.addObjectorSubstance(objectOrSubstance);
		
	}


	/** This method gets all the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ObjectOrSubstance objects
	 */
	@Override
	public List<ObjectOrSubstance> objectOrSubstanceLists() {
		
		return objectOrSubstanceDAO.objectOrSubstanceLists();
	}


	/** This method update the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param objectOrSubstance
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void updateObjectOrSubstance(ObjectOrSubstance objectOrSubstance) {
		
		objectOrSubstanceDAO.updateObjectOrSubstance(objectOrSubstance);
		
	}


	/** This method gets all the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of ObjectOrSubstance objects
	 */
	@Override
	public ObjectOrSubstance getByObjectOrSubstanceID(Integer id) {
		
		return objectOrSubstanceDAO.getByObjectOrSubstanceID(id);
	}


	/** This method delete the ObjectOrSubstance objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void deleteObjectOrSubstance(Integer id) {
		
		objectOrSubstanceDAO.deleteObjectOrSubstance(id);
		
	}
	
	

}
