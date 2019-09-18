package com.ets.dao.sicCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.SICCode;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.sicCode.SicCodeServiceImpl;

public class SicCodeDAOImplTest {
	
	@Mock
	private SicCodeDAOImpl  daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetSICCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   SicCodeServiceImpl serviceImpl = (SicCodeServiceImpl) context.getBean("sicCodeService");

		  SICCode sicCode  = serviceImpl.getBySICCodeID(1);
		  context.close();
	
	
	  assertNotNull( sicCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListSICCode() {
	  assertNotNull(daoImpl.sicCodeList());
	
	  //fail("Not yet implemented");
	 }
	 

}
