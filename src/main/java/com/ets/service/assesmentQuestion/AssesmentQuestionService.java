package com.ets.service.assesmentQuestion;

import java.util.List;

import com.ets.model.AssesmentQuestion;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 18-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of AssesmentQuestionService Interface
 *Description: AssesmentQuestion Entity Service Interface
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


public interface AssesmentQuestionService {

	public void add(AssesmentQuestion assesmentQuestion);

	public List<AssesmentQuestion> list();

	public void update(AssesmentQuestion assesmentQuestion);

	public AssesmentQuestion getByID(Integer id);

	public void delete(Integer id);

}
