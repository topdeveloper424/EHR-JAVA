package com.ets.dao.equipmentModel;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.EquipmentModel;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.equipmentModel.EquipmentModelServiceImpl;

public class EquipmentModelDAOImplTest {
	
	@Mock
	private EquipmentModelDAOImpl daoImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetEquipmentModelById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		   EquipmentModelServiceImpl serviceImpl = (EquipmentModelServiceImpl) context.getBean("equipmentModelService");

		   EquipmentModel equipmentModel = serviceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( equipmentModel );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListEquipmentModel() {
	  assertNotNull( daoImpl.list());
	
	  //fail("Not yet implemented");
	 }
	 


}
