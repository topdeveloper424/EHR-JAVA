package com.ets.dao.stateWorkArea;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.StateWorkArea;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.stateWorkArea.StateWorkAreaServiceImpl;

public class StateWorkAreaDAOImplTest {
	
	@Mock
	private StateWorkAreaDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetStateWorkAreaById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   StateWorkAreaServiceImpl serviceImpl = (StateWorkAreaServiceImpl) context.getBean("stateWorkAreaService");

		 StateWorkArea stateWorkArea = serviceImpl.getByStateWorkArea(9);
		  context.close();
	
	
	  assertNotNull( stateWorkArea );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListStateWorkArea() {
	  assertNotNull( daoImpl.stateWorkAreaList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
