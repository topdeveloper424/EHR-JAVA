package com.ets.dao.medicalcondition;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.MedicalCondition;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.medicalcondition.MedicalConditionServiceImpl;

public class MedicalConditionDAOImplTest {
	
	@Mock
	private MedicalConditionDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	/*@Test
	 public void testGetComplexById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  MedicalConditionServiceImpl serviceImpl  = (MedicalConditionServiceImpl) context.getBean("medicalConditionService");

		  MedicalCondition medicalCondition  = serviceImpl.;
		  context.close();
	
	
	  assertNotNull( medicalCondition );
	  //fail("Not yet implemented");
	 }*/

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListMedicalCondition() {
	  assertNotNull( daoImpl.listMedicalConditions() );
	
	  //fail("Not yet implemented");
	 }
	 
	
	
	
}
