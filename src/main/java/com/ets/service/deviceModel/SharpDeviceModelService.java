package com.ets.service.deviceModel;

import java.util.List;

import com.ets.model.DeviceModel;

public interface SharpDeviceModelService {

	public void addSharpDeviceModel(DeviceModel sharpDeviceModel);

	public List<DeviceModel> sharpDeviceModelList();

	public void updateSharpDeviceModel(DeviceModel sharpDeviceModel);

	public DeviceModel getBySharpDeviceModelID(Integer id);

	public void deleteSharpDeviceModel(Integer id);

}
