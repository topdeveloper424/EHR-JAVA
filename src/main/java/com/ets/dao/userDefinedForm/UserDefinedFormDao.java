package com.ets.dao.userDefinedForm;

import java.util.List;

import com.ets.model.UserDefinedForm;

public interface UserDefinedFormDao {
	
	public void saveForm(UserDefinedForm userDefinedForm);
	public List<UserDefinedForm> viewAllForm();
    public void delete(UserDefinedForm userDefinedForm);
}
