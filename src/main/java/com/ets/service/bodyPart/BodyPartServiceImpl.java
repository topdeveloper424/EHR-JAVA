package com.ets.service.bodyPart;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.bodyPart.BodyPartDAO;
import com.ets.model.BodyPart;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of BodyPartServiceImpl Class
 *Description: BodyPart Entity Service class
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
public class BodyPartServiceImpl implements BodyPartService {

	private BodyPartDAO bodyPartDAO;

	public void setBodyPartDAO(BodyPartDAO bodyPartDAO) {
		this.bodyPartDAO = bodyPartDAO;
	}
	
	/** This method save the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyPart
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addBodyPart(BodyPart bodyPart) {
		
		bodyPartDAO.addBodyPart(bodyPart);

	}

	/** This method gets all the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyPart objects
	 */
	@Override
	public List<BodyPart> listBodyPart() {
		
		return bodyPartDAO.listBodyPart();
	}

	/** This method Update all the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param bodyPart
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void updateBodyPart(BodyPart bodyPart) {
		
		bodyPartDAO.updateBodyPart(bodyPart);

	}

	 /** This method gets all the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of BodyPart objects
	 */
	@Override
	public BodyPart getByBodyPartID(Integer id) {
		
		return bodyPartDAO.getByBodyPartID(id);
	}

	 /** This method Delete the body part objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Id
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void deleteBodyPartCode(Integer id) {
		
		bodyPartDAO.deleteBodyPartCode(id);
		
	}

}
