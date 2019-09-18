package com.ets.service.role;

import java.util.List;

import com.ets.model.Role;

public interface RoleService {

	public void addOrUpdate(Role role);

	public List<Role> view();

	public Role getById(Integer id);

	public void delete(Integer id);
	
	public Role viewByName(String name);
	
	public List<String> roleName();

}
