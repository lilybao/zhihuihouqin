package com.lcworld.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcworld.annotation.IgnoreToken;
import com.lcworld.entity.DeviceEntity;
import com.lcworld.service.DeviceService;
import com.lcworld.utils.FastJSONUtils;
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
	 * 保存
	 */
	@RequestMapping("/save")
	@IgnoreToken
	public R save(HttpServletRequest req) {
		String biz = req.getParameter("biz");
		DeviceEntity deviceEntity = FastJSONUtils.getObject(biz, DeviceEntity.class);

		deviceEntity.setAddTime(new Date());

		deviceService.save(deviceEntity);

		return R.ok();
	}

}
