package com.njwb.service.impl;
import com.njwb.dao.DeviceDao;
import com.njwb.entity.Device;
import com.njwb.entity.Room;
import com.njwb.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DeviceServiceImpl implements DeviceService {
    @Autowired
    private DeviceDao dao;
    @Override
    public List<Device> getAllDevice() {
        List<Device> deviceList = new ArrayList<Device>();
        deviceList = dao.getAllDevice();
        return deviceList;
    }
    /*
     * 新增设备
     * */
	@Override
	public void addNewDevice(Device device) {
		dao.addNewDevice(device);
	}
	/*根据订单号搜索设施订单*/
	@Override
	public List<Device> searchOrderById(String device_Id) {
		List<Device> deviceList = new ArrayList<Device>();
		deviceList = dao.searchOrderById(device_Id);
		return deviceList;
	}
	/*改变设施状态*/
	@Override
	public void changeDeviceStatus(String deviceId, String device_status,String device_return) {
		dao.changeDeviceStatus(deviceId,device_status,device_return);
	}


}
