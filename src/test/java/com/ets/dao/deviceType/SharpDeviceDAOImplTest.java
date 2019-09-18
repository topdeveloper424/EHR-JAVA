package com.ets.dao.deviceType;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.DeviceType;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.deviceType.SharpDeviceServiceImpl;

public class SharpDeviceDAOImplTest {
	
	@Mock
	private SharpDeviceDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetDeviceTypeById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   SharpDeviceServiceImpl deviceServiceImpl = (SharpDeviceServiceImpl) context.getBean("sharpDeviceService");

		  DeviceType type  = deviceServiceImpl.getBySharpDeviceID(1);
		  context.close();
	
	
	  assertNotNull( type );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListDeviceType() {
	  assertNotNull( daoImpl.sharpDeviceList() );
	
	  //fail("Not yet implemented");
	 }
	 


}
