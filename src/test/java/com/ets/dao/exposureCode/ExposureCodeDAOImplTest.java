package com.ets.dao.exposureCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.ExposureCode;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.exposureCode.ExposureCodeServiceImpl;

public class ExposureCodeDAOImplTest {
	
	@Mock
	private ExposureCodeDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetExposureCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   ExposureCodeServiceImpl serviceImpl = (ExposureCodeServiceImpl) context.getBean("exposureCodeService");

		  ExposureCode exposureCode = serviceImpl.getByExposureCodeID(1);
		  context.close();
	
	
	  assertNotNull( exposureCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListExposureCode() {
	  assertNotNull( daoImpl.exposureCodeList() );
	
	  //fail("Not yet implemented");
	 }
	 


}
