package com.ets.dao.denialOrShortPayReason;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Complex;
import com.ets.model.DenialOrShortPayReason;
import com.ets.service.complex.ComplexServiceImpl;
import com.ets.service.denialOrShortPayReason.DenialOrShortPayReasonServiceImpl;

public class DenialOrShortPayReasonDAOImplTest {
	
	@Mock
	private DenialOrShortPayReasonDAOImpl denialOrShortPayReasonDAOImpl;

	public void setDenialOrShortPayReasonDAOImpl(DenialOrShortPayReasonDAOImpl denialOrShortPayReasonDAOImpl) {
		this.denialOrShortPayReasonDAOImpl = denialOrShortPayReasonDAOImpl;
	}
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetDenialOrShortPayReasonById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		  DenialOrShortPayReasonServiceImpl denialOrShortPayReasonServiceImpl  = (DenialOrShortPayReasonServiceImpl) context.getBean("denialOrShortPayReasonService");

		   DenialOrShortPayReason denialOrShortPayReason = denialOrShortPayReasonServiceImpl.getByID(1);
		  context.close();
	
	
	  assertNotNull( denialOrShortPayReason );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.ComplexDAOImpl#complexList()}.
	  */
	 @Test
	 public void testListDenialOrShortPayReason() {
	  assertNotNull( denialOrShortPayReasonDAOImpl.list());
	
	  //fail("Not yet implemented");
	 }
	

}
