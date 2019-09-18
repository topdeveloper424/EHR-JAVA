package com.ets.dao.medicalactivity;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.MedicalActivity;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.medicalactivity.MedicalActivityServiceImpl;

public class MedicalActivityDAOImplTest {
	
	@Mock
	private MedicalActivityDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetMedicalActivityById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 MedicalActivityServiceImpl  serviceImpl   = (MedicalActivityServiceImpl) context.getBean("medicalActivityService");

		MedicalActivity activity    = serviceImpl.getByMedicalActivityID(1);
		  context.close();
	
	
	  assertNotNull( activity );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListMedicalActivity() {
	  assertNotNull(daoImpl.medicalActivityList());
	
	  //fail("Not yet implemented");
	 }
	 

}
