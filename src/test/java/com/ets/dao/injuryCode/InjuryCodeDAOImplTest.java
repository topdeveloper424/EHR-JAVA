package com.ets.dao.injuryCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.InjuryCode;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.injuryCode.InjuryCodeServiceImpl;

public class InjuryCodeDAOImplTest {
	
	@Mock
	private InjuryCodeDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetInjuryCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 InjuryCodeServiceImpl serviceImpl   = (InjuryCodeServiceImpl) context.getBean("injuryCodeService");

		  InjuryCode injuryCode  = serviceImpl.getbyInjuryID(1);
		  context.close();
	
	
	  assertNotNull( injuryCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListInjuryCode() {
	  assertNotNull( daoImpl.injuryCodeList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
