package com.ets.dao.supervisor;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.Supervisor;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.supervisor.SupervisorServiceImpl;

public class SupervisorDAOImplTest {
	
	@Mock
	private SupervisorDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetSupervisorById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 SupervisorServiceImpl serviceImpl   = (SupervisorServiceImpl) context.getBean("supervisorService");

		   Supervisor supervisor = serviceImpl.getBySupervisorID(1);
		  context.close();
	
	
	  assertNotNull( supervisor );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListSupervisor() {
	  assertNotNull( daoImpl.supervisorList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
