package com.ets.dao.boyZone;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.BodyZone;
import com.ets.model.Complex;
import com.ets.service.bodyZone.BodyZoneServiceImpl;
import com.ets.service.complex.ComplexServiceImpl;

public class BodyZoneDAOImplTest {
	
	@Mock
	private BodyZoneDAOImpl bodyZoneDAOImpl;
	
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetBodyZoneById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  BodyZoneServiceImpl bodyZoneService  = (BodyZoneServiceImpl) context.getBean("bodyZoneService");

		  BodyZone bodyZone = bodyZoneService.getbyBodyZoneID(1);
		  context.close();
	
	
	  assertNotNull( bodyZone );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.BodyZoneDAOImpl#bodyZoneList()}.
	  */
	 @Test
	 public void testListBodyZone() {
	  assertNotNull( bodyZoneDAOImpl.bodyZoneList() );
	
	  //fail("Not yet implemented");
	 }

}
