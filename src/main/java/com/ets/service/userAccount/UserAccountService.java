package com.ets.service.userAccount;

import java.util.List;

import com.ets.model.UserAccount;

public interface UserAccountService {

	public void addOrUpdate(UserAccount userAccount);

	public List<UserAccount> userAccounts();

	public UserAccount getById(Integer id);

	public void delete(Integer id);
	
	public List<UserAccount> login(String userName, String password);
	
	public List<UserAccount> login2(String userName, String password , Boolean loginStatus);
	
	public UserAccount viewByName(String userName);
	
	

}
