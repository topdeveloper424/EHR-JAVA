package com.ets.dao.billingservicetype;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.BillingServiceType;
import com.ets.service.billingservicetype.BillingTypeServiceImpl;

public class BillingServiceTypeDAOImplTest {
	
	@Mock
	private BillingServiceTypeDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetBillingServiceTypeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 BillingTypeServiceImpl serviceImpl   = (BillingTypeServiceImpl) context.getBean("billingTypeServiceIm");

		  BillingServiceType serviceType  = serviceImpl.getByBillingServiceTypeID(2) ;
		  context.close();
	
	
	  assertNotNull( serviceType );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListBillingServiceType() {
	  assertNotNull( daoImpl.billingServiceTypeLists() );
	
	  //fail("Not yet implemented");
	 }
	 

}
