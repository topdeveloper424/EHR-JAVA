package com.ets.dao.incidentOrEvent;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.IncidentOrEvent;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.incidentOrEvent.IncidentOrEventServiceImpl;

public class IncidentOrEventDAOImplTest {
	
	@Mock
	private IncidentOrEventDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetIncidentOrEventById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  IncidentOrEventServiceImpl serviceImpl  = (IncidentOrEventServiceImpl) context.getBean("incidentOrEventService");

		IncidentOrEvent incidentOrEvent    = serviceImpl.getByIncidentOrEventID(1);
		  context.close();
	
	
	  assertNotNull( incidentOrEvent );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListIncidentOrEvent() {
	  assertNotNull( daoImpl.incidentOrEventLists() );
	
	  //fail("Not yet implemented");
	 }
	 

}
