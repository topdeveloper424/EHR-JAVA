package com.ets.dao.division;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.Division;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.division.DivisionServiceImpl;

public class DivisionDAOImplTest {
	
	@Mock
	private DivisionDAOImpl  daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetDivisionById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   DivisionServiceImpl serviceImpl = (DivisionServiceImpl) context.getBean("divisionService");

		  Division division  = serviceImpl.getByDivisionID(4);
		  context.close();
	
	
	  assertNotNull( division );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListDivision() {
	  assertNotNull( daoImpl.divisionList() );
	
	  //fail("Not yet implemented");
	 }
	 


}
