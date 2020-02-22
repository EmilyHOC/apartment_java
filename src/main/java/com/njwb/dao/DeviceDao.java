package com.njwb.dao;

import com.njwb.entity.Device;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
@Mapper
public interface DeviceDao {
    /*获取所有设备*/
    List<Device> getAllDevice();
    /*新增设备*/
	void addNewDevice(Device device);
	/*搜索设施订单*/
	List<Device> searchOrderById(String device_Id);
	/*改变设备状态*/
	void changeDeviceStatus(String deviceId, String device_status, String device_return);
}
