package com.ets.dao.workActivity;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.WorkActivity;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.workActivity.WorkActivityServiceImpl;

public class WorkActivityDAOImplTest {
	
	@Mock
	private WorkActivityDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetWorkActivityById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   WorkActivityServiceImpl serviceImpl = (WorkActivityServiceImpl) context.getBean("workActivityService");

		   WorkActivity workActivity = serviceImpl.getByWorkActivityID(2);
		  context.close();
	
	
	  assertNotNull( workActivity );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListWorkActivity() {
	  assertNotNull( daoImpl.workActivityList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
