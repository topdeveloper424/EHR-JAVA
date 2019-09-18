package com.ets.service.userDefinedForm;

import java.util.List;

import com.ets.model.UserDefinedForm;

public interface UserDefinedFormService {
	
	public void saveForm(UserDefinedForm userDefinedForm);
	public List<UserDefinedForm> viewAllForm();
	 public void delete(UserDefinedForm userDefinedForm);
}
