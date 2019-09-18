package com.ets.dao.caseClosedReason;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.CaseClosedReason;
import com.ets.model.Complex;
import com.ets.service.caseClosedReason.CaseClosedReasonStatusServiceImpl;
import com.ets.service.complex.ComplexServiceImpl;

public class CaseClosedReasonStatusDAOImplTest {
	
	@Mock
	private CaseClosedReasonStatusDAOImpl caseClosedReasonStatusDAOImpl;
	
	@Before
	 public void setUp() throws Exception {
	  initMocks(this);
			  
	 }
	
	
	@Test
	 public void testGetCaseClosedReasonById() {
	
		 ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		 CaseClosedReasonStatusServiceImpl caseClosedReasonStatusServiceImpl  = (CaseClosedReasonStatusServiceImpl) context.getBean("caseClosedReasonStatusService");

		 CaseClosedReason caseClosedReason = caseClosedReasonStatusServiceImpl.getByCaseClosedReasonID(1);
		  context.close();
	
	
	  assertNotNull( caseClosedReason );
	  //fail("Not yet implemented");
	 }

	
	/**
	  * Test method for {@link com.ets.dao.CaseClosedReasonStatusDAOImpl#caseClosedReasonList()}.
	  */
	 @Test
	 public void testListCaseClosedReason() {
	  assertNotNull( caseClosedReasonStatusDAOImpl.caseClosedReasonList() );
	
	  //fail("Not yet implemented");
	 }
	 

}
