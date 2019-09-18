package com.ets.dao.pharmacy;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.Pharmacy;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.pharmacy.PharmacyServiceImpl;

public class PharmacyDAOImplTest {
	
	@Mock
	private PharmacyDAOImpl daoImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetPharmacyById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 PharmacyServiceImpl serviceImpl   = (PharmacyServiceImpl) context.getBean("pharmacyService");

		  Pharmacy pharmacy  = serviceImpl.getByPharmacyID(4);
		  context.close();
	
	
	  assertNotNull( pharmacy );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListPharmacy() {
	  assertNotNull( daoImpl.pharmacyList());
	
	  //fail("Not yet implemented");
	 }
	 

}
