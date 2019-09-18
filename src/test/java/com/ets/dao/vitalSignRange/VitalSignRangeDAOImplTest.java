package com.ets.dao.vitalSignRange;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.VitalSignRange;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.vitalSignRange.VitalSignRangeServiceImpl;

public class VitalSignRangeDAOImplTest {
	
	@Mock
	private VitalSignRangeDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetVitalSignRangeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  VitalSignRangeServiceImpl serviceImpl  = (VitalSignRangeServiceImpl) context.getBean("vitalSignRangeService");

		  VitalSignRange vitalSignRange  = serviceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( vitalSignRange );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListVitalSignRange() {
	  assertNotNull( daoImpl.list() );
	
	  //fail("Not yet implemented");
	 }
	 

}
