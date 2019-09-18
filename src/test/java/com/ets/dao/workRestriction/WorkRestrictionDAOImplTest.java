package com.ets.dao.workRestriction;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.controller.gui.workRestriction.WorkRestrictionViewController;
import com.ets.model.Complex;
import com.ets.model.WorkRestriction;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.workRestriction.WorkRestrictionServiceImpl;

public class WorkRestrictionDAOImplTest {
	
	@Mock
	private WorkRestrictionDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetWorkRestrictionById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  WorkRestrictionServiceImpl serviceImpl   = (WorkRestrictionServiceImpl) context.getBean("workRestrictionService");

		   WorkRestriction workRestriction = serviceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( workRestriction );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListWorkRestriction() {
	  assertNotNull( daoImpl.list());
	
	  //fail("Not yet implemented");
	 }
	 

}
