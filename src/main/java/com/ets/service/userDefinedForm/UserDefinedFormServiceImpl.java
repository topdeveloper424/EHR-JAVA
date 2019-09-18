package com.ets.service.userDefinedForm;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.userDefinedForm.UserDefinedFormDao;
import com.ets.model.UserDefinedForm;

@Transactional
@Service
public class UserDefinedFormServiceImpl implements UserDefinedFormService{
	
	private UserDefinedFormDao userDefinedFormDao;

	public void setUserDefinedFormDao(UserDefinedFormDao userDefinedFormDao) {
		this.userDefinedFormDao = userDefinedFormDao;
	}

	@Override
	public void saveForm(UserDefinedForm userDefinedForm) {
		
		userDefinedFormDao.saveForm(userDefinedForm);
		
	}

	@Override
	public List<UserDefinedForm> viewAllForm() {
		
		return userDefinedFormDao.viewAllForm();
	}

	@Override
	public void delete(UserDefinedForm userDefinedForm) {
		userDefinedFormDao.delete(userDefinedForm);
		
	}

}
