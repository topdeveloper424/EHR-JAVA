package com.ets.dao.icd10Codes;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.Icd10Codes;
import com.ets.service.Icd10Codes.Icd10CodesServiceImpl;
import com.ets.service.complex.ComplexServiceImpl;

public class Icd10CodesDAOImplTest {
	
	@Mock
	private Icd10CodesDAOImpl daoImpl;

	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetIcd10CodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   Icd10CodesServiceImpl serviceImpl = (Icd10CodesServiceImpl) context.getBean("icd10CodesService");

		  Icd10Codes icd10Codes  = serviceImpl.getbyIcd10CodesID(1);
		  context.close();
	
	
	  assertNotNull( icd10Codes );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListIcd10Code() {
	  assertNotNull( daoImpl.icd10CodesList());
	
	  //fail("Not yet implemented");
	 }
	 
}
