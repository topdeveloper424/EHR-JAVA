package com.ets.dao.reasonOrCause;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.ReasonOrCause;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.reasonOrCause.ReasonOrCauseServiceImpl;

public class ReasonOrCauseDAOImplTest {
	
	@Mock
	private ReasonOrCauseDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetReasonOrCauseById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   ReasonOrCauseServiceImpl serviceImpl = (ReasonOrCauseServiceImpl) context.getBean("reasonOrCauseService");

		   ReasonOrCause reasonOrCause = serviceImpl.getByReasonOrCauseID(1);
		  context.close();
	
	
	  assertNotNull( reasonOrCause );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListReasonOrCause() {
	  assertNotNull( daoImpl.reasonCauseLists() );
	
	  //fail("Not yet implemented");
	 }
	 

}
