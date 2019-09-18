package com.ets.service.loginSchdule;

import java.util.List;

import com.ets.model.LoginSchedule;

public interface LoginSchduleService {
	
	public void addOrUpdate(LoginSchedule loginSchdule);
	
	public List<LoginSchedule> view();
	
	public LoginSchedule getById(Integer id);
	
	public void delete(Integer id);

}
