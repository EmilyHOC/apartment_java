package com.njwb.dao;

import com.njwb.entity.Device;

import java.util.List;

public interface DeviceDao {
    /*获取所有设备*/
    List<Device> getAllDevice();
}
