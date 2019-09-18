package com.ets.service.pdfForm;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.pdfForm.PdfFormDAO;
import com.ets.model.PdfForm;
/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PdfFormServiceImpl Class
 *Description: PdfForm Entity Service class
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
public class PdfFormServiceImpl implements PdfFormService {
	
	private PdfFormDAO pdfFormDAO;

	public void setPdfFormDAO(PdfFormDAO pdfFormDAO) {
		this.pdfFormDAO = pdfFormDAO;
	}


	/** This method save the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pdfForm
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void add(PdfForm pdfForm) {
		
		pdfFormDAO.add(pdfForm);
		
	}

	/** This method gets all the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param Nothing
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of PdfForm objects
	 */
	@Override
	public List<PdfForm> list() {
		
		return pdfFormDAO.list();
	}
	/** This method update the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param pdfForm
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	
	@Override
	public void update(PdfForm pdfForm) {
		
		pdfFormDAO.update(pdfForm);
	}
	/** This method gets all the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return ObservableList of PdfForm objects
	 */
	@Override
	public PdfForm getByID(Integer id) {
		
		return pdfFormDAO.getByID(id);
	}
	/** This method delete the PdfForm objects currently present in the system .
	 * 
	 * @author Sumanta Deyashi
	 * @param id
	 * @since 22-02-2016
	 * @version 1.0
	 * 
	 * @return nothing
	 */
	@Override
	public void delete(Integer id) {
		
		pdfFormDAO.delete(id);
		
	}
	

}
