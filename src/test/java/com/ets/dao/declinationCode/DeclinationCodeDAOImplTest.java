package com.ets.dao.declinationCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.DeclinationCode;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.declinationCode.DeclinationCodeServiceImpl;

public class DeclinationCodeDAOImplTest {
	
	@Mock
	private DeclinationCodeDAOImpl declinationCodeDAOImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetDeclinationCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  DeclinationCodeServiceImpl declinationCodeServiceImpl  = (DeclinationCodeServiceImpl) context.getBean("declinationCodeService");

		   DeclinationCode declinationCode = declinationCodeServiceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( declinationCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListDeclinationCode() {
	  assertNotNull( declinationCodeDAOImpl.list());
	
	  //fail("Not yet implemented");
	 }


}
