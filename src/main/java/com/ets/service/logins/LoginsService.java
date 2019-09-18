package com.ets.service.logins;

import java.util.List;

import com.ets.model.LoginHistory;

public interface LoginsService {

	public void addOrUpdate(LoginHistory logins);

	public List<LoginHistory> view();

	public LoginHistory getById(Integer id);

	public void delete(Integer id);

}
