package com.ets.dao.rangeOfOcurence;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.Pharmacy;
import com.ets.model.RangeOfOcurence;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.rangeOfOcurence.RangeOfOcurenceServiceImpl;

public class RangeOfOcurenceDAOImplTest {
	
	@Mock
	private RangeOfOcurenceDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetRangeOfOcurenceId() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   RangeOfOcurenceServiceImpl serviceImpl = (RangeOfOcurenceServiceImpl) context.getBean("rangeOfOcurenceService");

		  RangeOfOcurence rangeOfOcurence  = serviceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( rangeOfOcurence );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListRangeOfOcurence() {
	  assertNotNull( daoImpl.list());
	
	  //fail("Not yet implemented");
	 }
	 

}
