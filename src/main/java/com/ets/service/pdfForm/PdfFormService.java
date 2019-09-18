package com.ets.service.pdfForm;

import java.util.List;

import com.ets.model.PdfForm;

public interface PdfFormService {
	
	public void add(PdfForm pdfForm);

	public List<PdfForm> list();

	public void update(PdfForm pdfForm);

	public PdfForm getByID(Integer id);

	public void delete(Integer id);


}
