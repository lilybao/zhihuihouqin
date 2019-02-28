package com.lcworld.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-12 18:25:13
 */
public class DeviceEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long deviceId;
	//设备名字
	private String deviceName;
	//imei
	private String imei;
	//
	private Date addTime;

	/**
	 * 设置：
	 */
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	/**
	 * 获取：
	 */
	public Long getDeviceId() {
		return deviceId;
	}
	/**
	 * 设置：设备名字
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	/**
	 * 获取：设备名字
	 */
	public String getDeviceName() {
		return deviceName;
	}
	/**
	 * 设置：imei
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}
	/**
	 * 获取：imei
	 */
	public String getImei() {
		return imei;
	}
	/**
	 * 设置：
	 */
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	/**
	 * 获取：
	 */
	public Date getAddTime() {
		return addTime;
	}
}
