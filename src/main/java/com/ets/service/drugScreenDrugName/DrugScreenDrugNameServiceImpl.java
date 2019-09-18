package com.ets.service.drugScreenDrugName;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ets.dao.drugScreenDrugName.DrugScreenDrugNameDAO;
import com.ets.model.DrugScreenDrugName;

@Transactional
@Service
public class DrugScreenDrugNameServiceImpl implements DrugScreenDrugNameService {
	
	private DrugScreenDrugNameDAO drugScreenDrugNameDAO;

	public void setDrugScreenDrugNameDAO(DrugScreenDrugNameDAO drugScreenDrugNameDAO) {
		this.drugScreenDrugNameDAO = drugScreenDrugNameDAO;
	}

	@Override
	public List<DrugScreenDrugName> view(String activityCodeName) {
		
		return drugScreenDrugNameDAO.view(activityCodeName);
	}
	

}
