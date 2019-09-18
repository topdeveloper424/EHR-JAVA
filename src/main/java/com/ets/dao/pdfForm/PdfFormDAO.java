package com.ets.dao.pdfForm;

import java.util.List;

import com.ets.model.PdfForm;

/**
 *Original Author: Sumanta Deyahi on Behalf of ETS for Client Company
 *File Creation Date: 22-02-2016
 *Initial Version: 0.01
 *Module Name:
 *Parameter Definition: Type object of PdfFormDAO Interface
 *Description: PdfForm Entity DAO Interface
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

public interface PdfFormDAO {

	public void add(PdfForm pdfForm);

	public List<PdfForm> list();

	public void update(PdfForm pdfForm);

	public PdfForm getByID(Integer id);

	public void delete(Integer id);

}
