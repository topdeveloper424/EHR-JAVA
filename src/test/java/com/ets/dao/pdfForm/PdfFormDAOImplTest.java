package com.ets.dao.pdfForm;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.PdfForm;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.pdfForm.PdfFormServiceImpl;

public class PdfFormDAOImplTest {
	
	@Mock
	private PdfFormDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetPdfFormById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  PdfFormServiceImpl serviceImpl  = (PdfFormServiceImpl) context.getBean("pdfFormService");

		   PdfForm pdfForm = serviceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( pdfForm );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListPdfForm() {
	  assertNotNull( daoImpl.list() );
	
	  //fail("Not yet implemented");
	 }
	 

}
