package com.ets.service.equipmentModel;

import java.util.List;

import com.ets.model.EquipmentModel;

public interface EquipmentModelService {
	
	public void add(EquipmentModel equipmentModel);

	public List<EquipmentModel> list();

	public void update(EquipmentModel equipmentModel);

	public EquipmentModel getByID(Integer id);

	public void delete(Integer id);

}
