package com.ets.service.deviceType;

import java.util.List;

import com.ets.model.DeviceType;

public interface SharpDeviceService {

	public void addSharpDevice(DeviceType sharpDevice);

	public List<DeviceType> sharpDeviceList();

	public void updateSharpDevice(DeviceType sharpDevice);

	public DeviceType getBySharpDeviceID(Integer id);

	public void deleteSharpDevice(Integer id);

}
