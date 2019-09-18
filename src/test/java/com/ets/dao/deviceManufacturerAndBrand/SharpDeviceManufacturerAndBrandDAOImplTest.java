package com.ets.dao.deviceManufacturerAndBrand;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.DeviceManufacturerAndBrand;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.deviceManufacturerAndBrand.SharpDeviceManufacturerAndBrandServiceImpl;

public class SharpDeviceManufacturerAndBrandDAOImplTest {
	
	@Mock
	private SharpDeviceManufacturerAndBrandDAOImpl sharpDeviceManufacturerAndBrandDAOImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetDeviceManufacturerAndBrandById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  SharpDeviceManufacturerAndBrandServiceImpl brandServiceImpl  = (SharpDeviceManufacturerAndBrandServiceImpl) context.getBean("manufacturerAndBrandService");

		  DeviceManufacturerAndBrand brand  = brandServiceImpl.getBySharpDeviceManufacAndBrandID(4);
		  context.close();
	
	
	  assertNotNull( brand );
	  //fail("Not yet implemented");
	 }


	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListDeviceManufacturerAndBrand() {
	  assertNotNull( sharpDeviceManufacturerAndBrandDAOImpl.sharpDeviceManufacAndBrandLists());
	
	  //fail("Not yet implemented");
	 }

}
