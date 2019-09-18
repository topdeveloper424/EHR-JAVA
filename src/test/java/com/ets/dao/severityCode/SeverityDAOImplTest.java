package com.ets.dao.severityCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.SeverityCode;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.severityCode.SeverityServiceImpl;

public class SeverityDAOImplTest {
	
	@Mock
	private SeverityDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetSeverityCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  SeverityServiceImpl serviceImpl  = (SeverityServiceImpl) context.getBean("severityService");

		SeverityCode severityCode    = serviceImpl.getBySeverityCodeID(4);
		  context.close();
	
	
	  assertNotNull( severityCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListSeverityCode() {
	  assertNotNull( daoImpl.severityCodeLists() );
	
	  //fail("Not yet implemented");
	 }
	 

}
