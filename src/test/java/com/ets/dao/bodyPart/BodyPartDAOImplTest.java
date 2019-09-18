package com.ets.dao.bodyPart;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.BodyPart;
import com.ets.model.Complex;
import com.ets.service.bodyPart.BodyPartServiceImpl;
import com.ets.service.complex.ComplexServiceImpl;

public class BodyPartDAOImplTest {
	
	@Mock
	private BodyPartDAOImpl bodyPartDAOImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetBodyPartById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  BodyPartServiceImpl bodyPartServic = (BodyPartServiceImpl) context.getBean("bodyPartService");

		  BodyPart bodyPart = bodyPartServic.getByBodyPartID(2);
		  context.close();
	
	
	  assertNotNull( bodyPart );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#regionList()}.
	  */
	 @Test
	 public void testListBodyPart() {
	  assertNotNull( bodyPartDAOImpl.listBodyPart());
	
	  //fail("Not yet implemented");
	 }
	 

}
