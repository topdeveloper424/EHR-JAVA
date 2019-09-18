package com.ets.service.assesmentQuestion;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.assesmentQuestion.AssesmentQuestionDAO;
import com.ets.model.AssesmentQuestion;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AssesmentQuestionServiceImpl Class
 *Description: AssesmentQuestion Entity Service class
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
public class AssesmentQuestionServiceImpl implements AssesmentQuestionService {

	private AssesmentQuestionDAO assesmentQuestionDAO;
	
	public void setAssesmentQuestionDAO(AssesmentQuestionDAO assesmentQuestionDAO) {
		this.assesmentQuestionDAO = assesmentQuestionDAO;
	}

	/** This method save the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param assesmentQuestion
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void add(AssesmentQuestion assesmentQuestion) {
		
		assesmentQuestionDAO.add(assesmentQuestion);
		
	}

	/** This method gets all the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of AssesmentQuestion objects
	 */
	@Override
	public List<AssesmentQuestion> list() {
		
		return assesmentQuestionDAO.list();
	}

	/** This method update the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param assesmentQuestion
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void update(AssesmentQuestion assesmentQuestion) {
		
		assesmentQuestionDAO.update(assesmentQuestion);
		
	}

	/** This method gets all the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of AssesmentQuestion objects
	 */
	@Override
	public AssesmentQuestion getByID(Integer id) {
		
		return assesmentQuestionDAO.getByID(id);
	}

	/** This method delete the AssesmentQuestion objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 19-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {
		
		assesmentQuestionDAO.delete(id);
		
	}

}
