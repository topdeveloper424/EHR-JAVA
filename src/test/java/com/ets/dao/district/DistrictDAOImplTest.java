package com.ets.dao.district;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.District;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.district.DistrictServiceImpl;

public class DistrictDAOImplTest {
	
	@Mock
	private DistrictDAOImpl impl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetDistrictById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 DistrictServiceImpl serviceImpl = (DistrictServiceImpl) context.getBean("districtService");

		    District district = serviceImpl.getByDistrictID(1);
		  context.close();
	
	
	  assertNotNull( district );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListDistrict() {
	  assertNotNull(impl.districtList());
	
	  //fail("Not yet implemented");
	 }
	 


}
