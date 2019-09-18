package com.ets.service.Icd10Codes;

import java.util.List;

import com.ets.model.Icd10Codes;

public interface Icd10CodesService {
	
	public void addIcd10Codes(Icd10Codes icd10Codes);
	
	public List<Icd10Codes> icd10CodesList();	
	
	public Icd10Codes getbyIcd10CodesID(Integer id);
	
	public Icd10Codes getByICD10Code(String code);

}
