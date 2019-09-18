package com.ets.service.assesment;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.assessment.AssessmentDAO;
import com.ets.model.Assesment;

@Service
@Transactional
public class AssesmentServiceImpl  implements AssesmentService {
    
	private AssessmentDAO assessmentDAO;
  
    public void setAssessmentDAO(AssessmentDAO assessmentDAO) {
	    this.assessmentDAO = assessmentDAO;
   }

	@Override
	public void saveOrUpdate(Assesment assesment) {
		
		assessmentDAO.saveOrUpdate(assesment);
	}

	@Override
	public List<Assesment> search(Integer id) {
		
		return assessmentDAO.search(id);
	}

	@Override
	public List<Assesment> view() {
		
		return assessmentDAO.view();
	}

	@Override
	public void delete(Integer id) {
		
		assessmentDAO.delete(id);
		
	}

}
