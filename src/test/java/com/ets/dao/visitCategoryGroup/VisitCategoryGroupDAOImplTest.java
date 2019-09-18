package com.ets.dao.visitCategoryGroup;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.VisitCategoryGroup;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.visitCategoryGrup.VisitCategoryGroupServiceImpl;

public class VisitCategoryGroupDAOImplTest {
	
	@Mock
	private VisitCategoryGroupDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	/*@Test
	 public void testGetComplexById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		    VisitCategoryGroupServiceImpl serviceImpl = (VisitCategoryGroupServiceImpl) context.getBean("visitCategoryGroupService");

		  VisitCategoryGroup categoryGroup  = serviceImpl.
		  context.close();
	
	
	  assertNotNull( categoryGroup );
	  //fail("Not yet implemented");
	 }*/

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListVisitCategoryGroup() {
	  assertNotNull( daoImpl.viewVisitCategoryGroup() );
	
	  //fail("Not yet implemented");
	 }
	 

}
