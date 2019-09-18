package com.ets.dao.naicsCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.NAICSCode;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.naicsCode.NaicsCodeServiceImpl;

public class NaicsCodeDAOImplTest {
	
	@Mock
	private NaicsCodeDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetNAICSCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   NaicsCodeServiceImpl serviceImpl = (NaicsCodeServiceImpl) context.getBean("naicsCodeService");

		   NAICSCode naicsCode = serviceImpl.getByNAICSCodeID(1);
		  context.close();
	
	
	  assertNotNull( naicsCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListNAICSCode() {
	  assertNotNull(daoImpl.naicsCodeLists() );
	
	  //fail("Not yet implemented");
	 }
	 

}
