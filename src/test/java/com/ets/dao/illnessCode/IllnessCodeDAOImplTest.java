package com.ets.dao.illnessCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.IllnessCode;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.illnessCode.IllnessCodeServiceImpl;

public class IllnessCodeDAOImplTest {
	
	@Mock
	private IllnessCodeDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetIllnessCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   IllnessCodeServiceImpl serviceImpl = (IllnessCodeServiceImpl) context.getBean("illnessCodeService");

		   IllnessCode illnessCode = serviceImpl.getByIllnessCodeID(2);
		  context.close();
	
	
	  assertNotNull( illnessCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListIllnessCode() {
	  assertNotNull( daoImpl.illnessCodeList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
