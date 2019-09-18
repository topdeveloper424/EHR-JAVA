package com.ets.dao.company;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ets.model.Company;
import com.ets.service.company.CompanyServiceImpl;

import static org.junit.Assert.assertNotNull;
import static org.mockito.MockitoAnnotations.initMocks;

public class CompanyDAOImplTest {
	
	 @Mock
	 //@Autowired
	 CompanyDAOImpl companyDAO;
	 /**
	  * @throws java.lang.Exception
	  */
	 @Before
	 public void setUp() throws Exception {
	  initMocks(this);
	  //Company com1 = new Company("Delhi","AWS","Delhi","India","Gaziabad","inc@gmail.com","98356213","Amazon Web Services","NCR","98356213","110001");
	  //when( companyDAO.listCompany())
	 }

	 /**
	  * Test method for {@link com.ets.dao.CompanyDAOImpl#listCompany()}.
	  */
	 @Test
	 public void testListCompany() {
	  assertNotNull( companyDAO.listCompany() );
	  //fail("Not yet implemented");
	 }

	 /**
	  * Test method for {@link com.ets.dao.CompanyDAOImpl#getCompanyById(int)}.
	  */
	 @Test
	 public void testGetCompanyById() {
	  //Request spring app context for the companyService bean
	  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	  CompanyServiceImpl companyService = (CompanyServiceImpl)context.getBean("companyService");

	  Company company = companyService.getCompanyById(4);
	  context.close();
	  System.out.println(company);
	  assertNotNull( company );
	  //fail("Not yet implemented");
	 }

}
