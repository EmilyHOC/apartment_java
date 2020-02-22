package com.njwb.service;

import com.njwb.entity.Device;


import java.util.List;

public interface DeviceService  {
    //获取所有租借信息
    List<Device> getAllDevice();
    //新增设备
	void addNewDevice(Device device);
	/*根据订单号搜索设施*/
	List<Device> searchOrderById(String device_Id);
	/*改变设施状态*/
	void changeDeviceStatus(String deviceId, String device_status, String device_return);
}
