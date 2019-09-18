package com.ets.dao.region;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Region;
import com.ets.service.region.RegionServiceImpl;

import static org.mockito.MockitoAnnotations.initMocks;
import static org.mockito.Mockito.when;

public class RegionDAOImplTest {
	
		
	@Mock
	RegionDAOImpl regionDAOImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	@Test
	 public void testGetRegionById() {
		
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  RegionServiceImpl regionService = (RegionServiceImpl) context.getBean("regionService");

		  Region region = regionService.getByRegionID(1);
		  context.close();
	
	
	  assertNotNull( region );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.RegionDAOImpl#regionList()}.
	  */
	 @Test
	 public void testListRegion() {
	  assertNotNull( regionDAOImpl.regionList() );
	
	  //fail("Not yet implemented");
	 }
	 
	 
}
