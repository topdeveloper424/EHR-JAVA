package com.ets.dao.cptCode;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.CptCode4Hcpcs;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.cptCode.CptCodeServiceImpl;

public class CptCodeDAOImplTest {
	
	@Mock
	private CptCodeDAOImpl cptCodeDAOImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetCptCodeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		CptCodeServiceImpl cptCodeServiceImpl    = (CptCodeServiceImpl) context.getBean("cptCodeService");

		  CptCode4Hcpcs cptCode  = cptCodeServiceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( cptCode );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.CptCodeDAOImpl#list()}.
	  */
	 @Test
	 public void testListCptCode() {
	  assertNotNull( cptCodeDAOImpl.list() );
	
	  //fail("Not yet implemented");
	 }
	 

}
