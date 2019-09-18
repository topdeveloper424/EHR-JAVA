package com.ets.service.complex;



import java.util.List;







import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.complex.ComplexDAO;
import com.ets.model.Complex;

/**
 *Original Author: Sumanta Deyashii on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of ComplexServiceImpl Class
 *Description: Complex Entity Service class
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
public class ComplexServiceImpl implements ComplexService{
	
	private ComplexDAO complexDAO;

	public void setComplexDAO(ComplexDAO complexDAO) {
		this.complexDAO = complexDAO;
	}

	/** This method save the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param complex
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	
	@Override
	public void addComplex(Complex complex) {
		
		complexDAO.addComplex(complex);
		
	}
	
	/** This method gets all the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of complex objects
	 */
	@Override
	public List<Complex> complexList() {
		
		return complexDAO.complexList();
	}

	/** This method update the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param complex
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void updateComplex(Complex complex) {
		
		complexDAO.updateComplex(complex);
		
	}

	/** This method gets all the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of complex objects
	 */
	@Override
	public Complex getByComplexID(Integer id) {
		
		return complexDAO.getByComplexID(id);
	}

	/** This method Remove the complex objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return Nothing
	 */
	@Override
	public void deleteComplex(Integer id) {
		
		complexDAO.deleteComplex(id);
		
	}

	@Override
	public Complex viewByCode(String code) {
		
		return complexDAO.viewByCode(code);
		
	}
	
	

}
