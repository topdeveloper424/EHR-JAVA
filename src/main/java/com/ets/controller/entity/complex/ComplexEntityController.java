package com.ets.controller.entity.complex;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.utils.Global;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ComplexEntityController Class
 *Description: Complex Entity Non-GUI Controller class
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


public class ComplexEntityController {

	//private static ClassPathXmlApplicationContext context;

	private ComplexServiceImpl complexServiceImpl;

	private ObservableList<Complex> observableList;

	public ComplexEntityController() {

		//context = new ClassPathXmlApplicationContext("spring.xml");

		complexServiceImpl = (ComplexServiceImpl) Global.context
				.getBean("complexService");
		observableList = FXCollections.observableArrayList();

	}

	
	/** This method save the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param complex
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void saveComplex(Complex complex) {

		complexServiceImpl.addComplex(complex);
		//this.closeApplicationConrext();
	}

	
	/** This method gets all the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of complex objects
	 */
	
	public ObservableList<Complex> viewComplex() {

		observableList = FXCollections.observableArrayList(complexServiceImpl.complexList());

		//this.closeApplicationConrext();
		return observableList;

	}
	
	/** This method update the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param complex
	 * @since 22-02-2016
	 * @version 1.0
	 * @return nothing
	 * 
	 */
	
	public void updateComplex(Complex complex){
		
		complexServiceImpl.updateComplex(complex);
		//this.closeApplicationConrext();
		
	}
	
	/** This method Remove the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	public void removeComplex(Integer id){
		
		complexServiceImpl.deleteComplex(id);
		//this.closeApplicationConrext();
	}
	
	public Complex viewByCode(String code){
		
		observableList = FXCollections.observableArrayList(complexServiceImpl.viewByCode(code));

		//this.closeApplicationConrext();
		return observableList.get(0);
		
	}
	

}
