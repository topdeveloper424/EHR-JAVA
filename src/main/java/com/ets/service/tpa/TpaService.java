package com.ets.service.tpa;

import java.util.List;

import com.ets.model.Tpa;

public interface TpaService {
	
	public void addOrUpdate(Tpa tpa);
	public List<Tpa> view();
	public Tpa viewByCode(String code);
	public void delete(Integer id);

}
