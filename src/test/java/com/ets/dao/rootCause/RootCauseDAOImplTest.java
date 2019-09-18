package com.ets.dao.rootCause;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.RootCause;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.rootCause.RootCauseServiceImpl;

public class RootCauseDAOImplTest {
	
	@Mock
	private RootCauseDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetRootCauseById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 RootCauseServiceImpl serviceImpl   = (RootCauseServiceImpl) context.getBean("rootCauseService");

		 RootCause rootCause   = serviceImpl.getByRootCauseID(1);
		  context.close();
	
	
	  assertNotNull( rootCause );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListRootCause() {
	  assertNotNull( daoImpl.rootCauseLists() );
	
	  //fail("Not yet implemented");
	 }
	 

}
