package com.ets.controller.entity.respiratorModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.ets.model.RespiratorModel;
import com.ets.service.respiratorModel.RespiratorModelServiceImpl;
import com.ets.utils.Global;

/**
 *Parameter Definition: Type object of RespiratorModelEntityController Class
 *Description: RespiratorModel Entity Non-GUI Controller class
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

 *Modification:
 *Owner:
 *Date:
 *@version 1.0
 *@since 18-02-2016
 *
 *Copyright 2016 @Eclipse Technoconsulting Global Pvt. Ltd.

*/

public class RespiratorModelEntityController {

	//private static ClassPathXmlApplicationContext context;
	private RespiratorModelServiceImpl respiratorModelServiceImpl;
	private ObservableList<RespiratorModel> respiratorModelList;

	public RespiratorModelEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");
		respiratorModelServiceImpl = (RespiratorModelServiceImpl) Global.context.getBean("respiratorModelService");
		respiratorModelList = FXCollections.observableArrayList();

	}

	

	/**
	 * This method save the RespiratorModel objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param respiratorModel
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RespiratorModel objects
	 */
	public void saveRespiratorModel(RespiratorModel respiratorModel) {

		respiratorModelServiceImpl.addRespiratorModel(respiratorModel);
		//this.closeApplicationContext();

	}

	/**
	 * This method gets all the RespiratorModel objects currently present in the
	 * system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 18-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of RespiratorModel objects
	 */

	public ObservableList<RespiratorModel> viewRespiratorModelList() {
		if (!respiratorModelList.isEmpty())
			respiratorModelList.clear();

		respiratorModelList = FXCollections.observableArrayList(respiratorModelServiceImpl.viewAllRespiratorModel());

		//this.closeApplicationContext();

		return respiratorModelList;

	}

	public void delete(Integer id) {

		respiratorModelServiceImpl.delete(id);
		//this.closeApplicationContext();

	}

}
