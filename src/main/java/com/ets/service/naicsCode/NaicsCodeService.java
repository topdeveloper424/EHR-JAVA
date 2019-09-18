package com.ets.service.naicsCode;

import java.util.List;

import com.ets.model.NAICSCode;



public interface NaicsCodeService {

	public void addNaicsCode(NAICSCode naicsCode);

	public List<NAICSCode> naicsCodeLists();

	public void updateNAICSCode(NAICSCode naicsCode);

	public NAICSCode getByNAICSCodeID(Integer id);

	public void deleteNAICSCode(Integer id);
	
	public NAICSCode viewByCode(String code);

}
