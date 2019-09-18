package com.ets.service.userlogin;

import java.util.List;

import com.ets.model.UserLogin;

public interface UserLoginService {
	
	public List<UserLogin> login(String name , String password );
		

}
