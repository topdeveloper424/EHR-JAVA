package com.ets.dao.objectOrSubstance;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.ObjectOrSubstance;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.objectOrSubstance.ObjectOrSubstanceServiceImpl;

public class ObjectOrSubstanceDAOImplTest {

	@Mock
	private ObjectOrSubstanceDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetObjectOrSubstanceById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 ObjectOrSubstanceServiceImpl serviceImpl   = (ObjectOrSubstanceServiceImpl) context.getBean("objectOrSubstanceService");

		  ObjectOrSubstance objectOrSubstance  = serviceImpl.getByObjectOrSubstanceID(7);
		  context.close();
	
	
	  assertNotNull( objectOrSubstance );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListObjectOrSubstance() {
	  assertNotNull(daoImpl.objectOrSubstanceLists() );
	
	  //fail("Not yet implemented");
	 }
	 
}
