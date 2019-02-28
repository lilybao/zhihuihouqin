package com.lcworld.service;

import com.lcworld.entity.DeviceEntity;

import java.util.List;
import java.util.Map;

/**
 * 
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-12 18:25:13
 */
public interface DeviceService {
	
	DeviceEntity queryObject(Long deviceId);
	
	List<DeviceEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(DeviceEntity device);
	
	void update(DeviceEntity device);
	
	void delete(Long deviceId);
	
	void deleteBatch(Long[] deviceIds);
}
