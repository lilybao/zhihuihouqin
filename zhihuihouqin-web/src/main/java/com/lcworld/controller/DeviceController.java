package com.lcworld.controller;

import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcworld.entity.DeviceEntity;
import com.lcworld.service.DeviceService;
import com.lcworld.utils.PageUtils;
import com.lcworld.utils.Query;
import com.lcworld.utils.R;


/**
 * 
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-12 18:25:13
 */
@RestController
@RequestMapping("device")
public class DeviceController {
	@Autowired
	private DeviceService deviceService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("device:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<DeviceEntity> deviceList = deviceService.queryList(query);
		int total = deviceService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(deviceList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{deviceId}")
	@RequiresPermissions("device:info")
	public R info(@PathVariable("deviceId") Long deviceId){
		DeviceEntity device = deviceService.queryObject(deviceId);
		
		return R.ok().put("device", device);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("device:save")
	public R save(@RequestBody DeviceEntity device){
		deviceService.save(device);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("device:update")
	public R update(@RequestBody DeviceEntity device){
		deviceService.update(device);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("device:delete")
	public R delete(@RequestBody Long[] deviceIds){
		deviceService.deleteBatch(deviceIds);
		
		return R.ok();
	}
	
}
