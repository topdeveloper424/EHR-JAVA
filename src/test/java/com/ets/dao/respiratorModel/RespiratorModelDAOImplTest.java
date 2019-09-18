package com.ets.dao.respiratorModel;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.RespiratorModel;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.respiratorModel.RespiratorModelServiceImpl;

public class RespiratorModelDAOImplTest {
	
	@Mock
	private RespiratorModelDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	/*@Test
	 public void testGetComplexById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  RespiratorModelServiceImpl serviceImpl  = (RespiratorModelServiceImpl) context.getBean("respiratorModelService");

		  RespiratorModel respiratorModel  = serviceImpl.;
		  context.close();
	
	
	  assertNotNull( respiratorModel );
	  //fail("Not yet implemented");
	 }*/

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListRespiratorModel() {
	  assertNotNull( daoImpl.viewAllRespiratorModel() );
	
	  //fail("Not yet implemented");
	 }
	 

}
