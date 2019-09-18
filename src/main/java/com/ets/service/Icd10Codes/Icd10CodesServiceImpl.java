package com.ets.service.Icd10Codes;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.ets.dao.icd10Codes.Icd10CodesDAO;
import com.ets.model.Icd10Codes;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Icd10CodesServiceImpl Class
 *Description: Icd10Codes Entity Service class
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
public class Icd10CodesServiceImpl implements Icd10CodesService{
	
	private Icd10CodesDAO icd10CodesDAO;
	
	public void setIcd10CodesDAO(Icd10CodesDAO icd10CodesDAO) {
		this.icd10CodesDAO = icd10CodesDAO;
	}
	
	/** This method save the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param icd10Codes
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void addIcd10Codes(Icd10Codes icd10Codes) {
		
		icd10CodesDAO.addIcd10Codes(icd10Codes);		
	}
	
	/** This method gets all the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Icd10Codes objects
	 */
	@Override
	public List<Icd10Codes> icd10CodesList() {
		
		return icd10CodesDAO.icd10CodesList();
	}
	
	/** This method gets all the Icd10Codes objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of Icd10Codes objects
	 */
	@Override
	public Icd10Codes getbyIcd10CodesID(Integer id) {
		
		return icd10CodesDAO.getbyIcd10CodesID(id);
	}

	@Override
	public Icd10Codes getByICD10Code(String code) {
		
		return icd10CodesDAO.getByICD10Code(code);
	}

}
