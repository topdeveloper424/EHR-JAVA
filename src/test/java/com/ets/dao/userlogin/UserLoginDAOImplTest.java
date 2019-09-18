/*package com.ets.dao.userlogin;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.UserLogin;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.userlogin.UserLoginServiceImpl;

public class UserLoginDAOImplTest {
	
	@Mock
	private UserLoginDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetComplexById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 UserLoginServiceImpl serviceImpl   = (UserLoginServiceImpl) context.getBean("complexService");

		  UserLogin userLogin  = serviceImpl.;
		  context.close();
	
	
	  assertNotNull( complex );
	  //fail("Not yet implemented");
	 }

	
	*//**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  *//*
	 @Test
	 public void testListComplex() {
	  assertNotNull( complexDAOImpl.complexList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
*/