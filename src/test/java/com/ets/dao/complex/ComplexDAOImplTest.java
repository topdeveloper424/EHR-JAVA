package com.ets.dao.complex;


import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.service.complex.ComplexServiceImpl;
import static org.mockito.MockitoAnnotations.initMocks;


public class ComplexDAOImplTest {
	
	@Mock
	private ComplexDAOImpl complexDAOImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetComplexById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  ComplexServiceImpl complexService = (ComplexServiceImpl) context.getBean("complexService");

		  Complex complex = complexService.getByComplexID(6);
		  context.close();
	
	
	  assertNotNull( complex );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListComplex() {
	  assertNotNull( complexDAOImpl.complexList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
