package com.ets.service.complex;

import java.util.List;

import com.ets.model.Complex;
/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ComplexServiceImpl Interface
 *Description: Complex Entity Service Interface
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

public interface ComplexService {

	public void addComplex(Complex complex);

	public List<Complex> complexList();

	public void updateComplex(Complex complex);

	public Complex getByComplexID(Integer id);

	public void deleteComplex(Integer id);
	
	public Complex viewByCode(String code);

}
