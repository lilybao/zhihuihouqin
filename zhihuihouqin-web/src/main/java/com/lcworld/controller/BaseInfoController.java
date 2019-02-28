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

import com.lcworld.entity.BaseInfoEntity;
import com.lcworld.service.BaseInfoService;
import com.lcworld.utils.PageUtils;
import com.lcworld.utils.Query;
import com.lcworld.utils.R;


/**
 * 班级,科目,教材,知识点层级关系表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-10 16:04:29
 */
@RestController
@RequestMapping("baseinfo")
public class BaseInfoController {
	@Autowired
	private BaseInfoService baseInfoService;
	
	/**
	 * 列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("baseinfo:list")
	public R list(@RequestParam Map<String, Object> params){
		//查询列表数据
        Query query = new Query(params);

		List<BaseInfoEntity> baseInfoList = baseInfoService.queryList(query);
		int total = baseInfoService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(baseInfoList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	
	/**
	 * 信息
	 */
	@RequestMapping("/info/{id}")
	@RequiresPermissions("baseinfo:info")
	public R info(@PathVariable("id") Long id){
		BaseInfoEntity baseInfo = baseInfoService.queryObject(id);
		
		return R.ok().put("baseInfo", baseInfo);
	}
	
	/**
	 * 保存
	 */
	@RequestMapping("/save")
	@RequiresPermissions("baseinfo:save")
	public R save(@RequestBody BaseInfoEntity baseInfo){
		baseInfoService.save(baseInfo);
		
		return R.ok();
	}
	
	/**
	 * 修改
	 */
	@RequestMapping("/update")
	@RequiresPermissions("baseinfo:update")
	public R update(@RequestBody BaseInfoEntity baseInfo){
		baseInfoService.update(baseInfo);
		
		return R.ok();
	}
	
	/**
	 * 删除
	 */
	@RequestMapping("/delete")
	@RequiresPermissions("baseinfo:delete")
	public R delete(@RequestBody Long[] ids){
		baseInfoService.deleteBatch(ids);
		
		return R.ok();
	}
	
}
