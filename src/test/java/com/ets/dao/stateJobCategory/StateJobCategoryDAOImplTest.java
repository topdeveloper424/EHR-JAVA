package com.ets.dao.stateJobCategory;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.StateJobCategory;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.stateJobCategory.StateJobCategoryServiceImpl;

public class StateJobCategoryDAOImplTest {
	
	@Mock
	private StateJobCategoryDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetStateJobCategoryById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  StateJobCategoryServiceImpl serviceImpl  = (StateJobCategoryServiceImpl) context.getBean("stateJobCategoryService");

		   StateJobCategory stateJobCategory = serviceImpl.getByStateJobCategoryID(1);
		  context.close();
	
	
	  assertNotNull( stateJobCategory );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListStateJobCategory() {
	  assertNotNull( daoImpl.stateJobCategoryList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
