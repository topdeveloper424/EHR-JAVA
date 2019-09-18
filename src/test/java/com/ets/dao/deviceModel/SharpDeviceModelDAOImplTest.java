package com.ets.dao.deviceModel;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.DeviceModel;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.deviceModel.SharpDeviceModelServiceImpl;

public class SharpDeviceModelDAOImplTest {

	@Mock
	private SharpDeviceModelDAOImpl sharpDeviceModelDAOImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetDeviceModelById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  SharpDeviceModelServiceImpl serviceImpl  = (SharpDeviceModelServiceImpl) context.getBean("sharpDeviceModelService");

		   DeviceModel deviceModel = serviceImpl.getBySharpDeviceModelID(1);
		  context.close();
	
	
	  assertNotNull( deviceModel );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListDeviceModel() {
	  assertNotNull( sharpDeviceModelDAOImpl.sharpDeviceModelList() );
	
	  //fail("Not yet implemented");
	 }
	 

	 
}
