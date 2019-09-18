package com.ets.service.deviceManufacturerAndBrand;

import java.util.List;

import com.ets.model.DeviceManufacturerAndBrand;

public interface SharpDeviceManufacturerAndBrandService {

	public void addSharpDeviceManufacturerAndBrand(DeviceManufacturerAndBrand manufacAndBrand);

	public List<DeviceManufacturerAndBrand> sharpDeviceManufacAndBrandLists();

	public void updateSharpDeviceManufacAndBrand(DeviceManufacturerAndBrand sharpDeviceManufacAndBrand);

	public DeviceManufacturerAndBrand getBySharpDeviceManufacAndBrandID(Integer id);

	public void deleteSharpDeviceManufacAndBrand(Integer id);

}
