package com.ets.dao.icd10Codes;

import java.util.List;

import com.ets.model.Icd10Codes;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 20-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of Icd10CodesDAO Interface
 *Description: Icd10Codes Entity DAO Interface
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

public interface Icd10CodesDAO {

	public void addIcd10Codes(Icd10Codes icd10Codes);
	
	public List<Icd10Codes> icd10CodesList();	
	
	public Icd10Codes getbyIcd10CodesID(Integer id);
	
	public Icd10Codes getByICD10Code(String code);
	public void delete(Integer id);
		
}
