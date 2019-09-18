package com.ets.dao.firstResponse;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.FirstResponse;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.firstResponse.FirstResponseServiceImpl;

public class FirstResponseDAOImplTest {
	
	@Mock
	private FirstResponseDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetFirstResponseById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   FirstResponseServiceImpl serviceImpl = (FirstResponseServiceImpl) context.getBean("firstResponseService");

		   FirstResponse firstResponse = serviceImpl.getbyFirstResponseID(4);
		  context.close();
	
	
	  assertNotNull( firstResponse );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListFirstResponse() {
	  assertNotNull( daoImpl.firstResponseList());
	
	  //fail("Not yet implemented");
	 }
	 


}
