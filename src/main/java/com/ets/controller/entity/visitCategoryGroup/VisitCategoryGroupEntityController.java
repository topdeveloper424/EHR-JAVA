package com.ets.controller.entity.visitCategoryGroup;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.VisitCategoryGroup;
import com.ets.service.visitCategoryGrup.VisitCategoryGroupServiceImpl;
import com.ets.utils.Global;

/**
 *Parameter Definition: Type object of VisitCategoryGroupEntityController Class
 *Description: VisitCategoryGroup Entity Non-GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *@version 1.0
 *@since 18-02-2016
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

public class VisitCategoryGroupEntityController {

	//private static ClassPathXmlApplicationContext context;
	private VisitCategoryGroupServiceImpl visitCategoryGroupServiceImpl;
	private ObservableList<VisitCategoryGroup> visitCategoryGroupsList;
	
	public VisitCategoryGroupEntityController() {
		
		//context = new ClassPathXmlApplicationContext("spring.xml");
		visitCategoryGroupServiceImpl=(VisitCategoryGroupServiceImpl) Global.context.getBean("visitCategoryGroupService");
		visitCategoryGroupsList=FXCollections.observableArrayList();
		
	}
	

	/** This method save the VisitCategoryGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	public void saveVisitCategoryGroup(VisitCategoryGroup visitCategoryGroup){
		
		visitCategoryGroupServiceImpl.addVisitCategoryGroup(visitCategoryGroup);
		////this.closeApplicationContext();
		
	}
	
	/** This method gets all the VisitCategoryGroup objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of VisitCategoryGroup objects
	 */
	public ObservableList<VisitCategoryGroup> viewVisitCategoryGroup() {
		if (!visitCategoryGroupsList.isEmpty())
			visitCategoryGroupsList.clear();

		visitCategoryGroupsList=FXCollections.observableArrayList(visitCategoryGroupServiceImpl.viewVisitCategoryGroup());

		//this.closeApplicationContext();

		return visitCategoryGroupsList;
		
	}
	
	

}
