package com.ets.service.objectOrSubstance;

import java.util.List;

import com.ets.model.ObjectOrSubstance;

public interface ObjectOrSubstanceService {

	public void addObjectorSubstance(ObjectOrSubstance objectOrSubstance);

	public List<ObjectOrSubstance> objectOrSubstanceLists();

	public void updateObjectOrSubstance(ObjectOrSubstance objectOrSubstance);

	public ObjectOrSubstance getByObjectOrSubstanceID(Integer id);

	public void deleteObjectOrSubstance(Integer id);

}
