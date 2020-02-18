package com.njwb.service;

import com.njwb.entity.Device;


import java.util.List;

public interface DeviceService  {
    //获取所有租借信息
    List<Device> getAllDevice();
}
