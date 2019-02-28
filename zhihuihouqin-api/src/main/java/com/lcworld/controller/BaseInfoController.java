package com.lcworld.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lcworld.annotation.IgnoreToken;
import com.lcworld.entity.BaseInfoEntity;
import com.lcworld.service.BaseInfoService;
import com.lcworld.utils.R;
import com.lcworld.validator.Assert;

/**
 * 班级,科目,教材,知识点层级关系表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-10 16:04:29
 */
@RestController
@RequestMapping("baseInfo")
public class BaseInfoController {
	@Autowired
	private BaseInfoService baseInfoService;

	/**
	 * 查询班级列表
	 */
	@RequestMapping("/baseInfo")
	@IgnoreToken
	public R baseInfo(HttpServletRequest req) {
		String biz = req.getParameter("biz");
		JSONObject parse = (JSONObject) JSON.parse(biz);

		String type = parse.getString("type");

		Integer parentid = parse.getInteger("parentid");

		Assert.isBlank(type, "type is null");


		Map<String, Object> map = new HashMap<>();

		map.put("type", type);

		map.put("parentid", parentid);

		// 查询列表数据

		List<BaseInfoEntity> baseInfoList = baseInfoService.queryBaseInfoList(map);

		return R.ok().put("baseInfo", baseInfoList);
	}

	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	public R info(@PathVariable("id") Long id) {
		BaseInfoEntity baseInfo = baseInfoService.queryObject(id);

		return R.ok().put("baseInfo", baseInfo);
	}

}
