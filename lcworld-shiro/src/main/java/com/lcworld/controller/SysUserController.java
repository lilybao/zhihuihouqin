package com.lcworld.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcworld.annotation.SysLog;
import com.lcworld.entity.SysUserEntity;
import com.lcworld.service.SysUserRoleService;
import com.lcworld.service.SysUserService;
import com.lcworld.utils.Constant;
import com.lcworld.utils.PageUtils;
import com.lcworld.utils.Query;
import com.lcworld.utils.R;
import com.lcworld.utils.ShiroUtils;
import com.lcworld.validator.Assert;
import com.lcworld.validator.ValidatorUtils;
import com.lcworld.validator.group.AddGroup;
import com.lcworld.validator.group.UpdateGroup;

/**
 * 系统用户
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年10月31日 上午10:40:10
 */
@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
	@Autowired
	private SysUserService sysUserService;
	@Autowired
	private SysUserRoleService sysUserRoleService;
	
	/**
	 * 所有用户列表
	 */
	@RequestMapping("/list")
	@RequiresPermissions("sys:user:list")
	public R list(@RequestParam Map<String, Object> params){
		//只有超级管理员，才能查看所有管理员列表
		if(getUserId() != Constant.SUPER_ADMIN){
			params.put("createUserId", getUserId());
		}
		
		//查询列表数据
		Query query = new Query(params);
		//取出角色
		Integer roleId = MapUtils.getInteger(params, "roleId");
		List<Integer> userIds = sysUserRoleService.queryUserIds(roleId);
		if (userIds.size()<=0) {
			userIds.add(-1);
		}
		query.put("userIds", userIds.toArray());
		List<SysUserEntity> userList = sysUserService.queryList(query);
		int total = sysUserService.queryTotal(query);
		
		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
		
		return R.ok().put("page", pageUtil);
	}
	
	/**
	 * 获取登录的用户信息
	 */
	@RequestMapping("/info")
	public R info(){
		return R.ok().put("user", getUser());
	}
	/**
	 * 获取管理端职位列表
	 * @return
	 */
	@RequestMapping("/getPositionList")
	public R getPositionList(){
		HashMap<String, Object> position1 = new HashMap<>();
		HashMap<String, Object> position2 = new HashMap<>();
		HashMap<String, Object> position3 = new HashMap<>();
		HashMap<String, Object> position4 = new HashMap<>();
		position1.put("id","1");
		position1.put("name","消毒专员 ");
		position2.put("id","2");
		position2.put("name","补货专员 ");
		position3.put("id","3");
		position3.put("name","换货专员 ");
		position4.put("id","4");
		position4.put("name","维修专员 ");
		ArrayList<Object> arrayList = new ArrayList<>();
		arrayList.add(position1);
		arrayList.add(position2);
		arrayList.add(position3);
		arrayList.add(position4);
		return R.ok().put("positionList", arrayList);
	}
	
	/**
	 * 修改登录用户密码
	 */
	@SysLog("修改密码")
	@RequestMapping("/password")
	public R password(String password, String newPassword){
		Assert.isBlank(newPassword, "新密码不为能空");
		
		//sha256加密
		password = new Sha256Hash(password).toHex();
		//sha256加密
		newPassword = new Sha256Hash(newPassword).toHex();
				
		//更新密码
		int count = sysUserService.updatePassword(getUserId(), password, newPassword);
		if(count == 0){
			return R.error("原密码不正确");
		}
		
		//退出
		ShiroUtils.logout();
		
		return R.ok();
	}
	
	/**
	 * 用户信息
	 */
	@RequestMapping("/info/{userId}")
	@RequiresPermissions("sys:user:info")
	public R info(@PathVariable("userId") Long userId){
		SysUserEntity user = sysUserService.queryObject(userId);
		String position = user.getPosition();
		if (!StringUtils.isBlank(position)) {
			String[] positionArr = position.split(",");
			user.getPositionNameList().addAll(Arrays.asList(positionArr));
		}
		//获取用户所属的角色列表
		List<Long> roleIdList = sysUserRoleService.queryRoleIdList(userId);
		user.setRoleIdList(roleIdList);
		
		return R.ok().put("user", user);
	}
	
	/**
	 * 保存用户
	 */
	@SysLog("保存用户")
	@RequestMapping("/save")
	@RequiresPermissions("sys:user:save")
	public R save(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, AddGroup.class);
		
		user.setCreateUserId(getUserId());
		ArrayList<String> positionNameList = user.getPositionNameList();
		String position = "";
		for (String pos : positionNameList) {
			position += pos + ",";
		}
		String positionStr = position.substring(0, position.length()-1);
		user.setPosition(positionStr);
		sysUserService.save(user);
		
		return R.ok();
	}
	
	/**
	 * 修改用户
	 */
	@SysLog("修改用户")
	@RequestMapping("/update")
	@RequiresPermissions("sys:user:update")
	public R update(@RequestBody SysUserEntity user){
		ValidatorUtils.validateEntity(user, UpdateGroup.class);
		
		user.setCreateUserId(getUserId());
		ArrayList<String> positionNameList = user.getPositionNameList();
		String position = "";
		for (String pos : positionNameList) {
			position += pos + ",";
		}
		String positionStr = position.substring(0, position.length()-1);
		user.setPosition(positionStr);
		sysUserService.update(user);
		
		return R.ok();
	}
	
	/**
	 * 删除用户
	 */
	@SysLog("删除用户")
	@RequestMapping("/delete")
	@RequiresPermissions("sys:user:delete")
	public R delete(@RequestBody Long[] userIds){
		if(ArrayUtils.contains(userIds, 1L)){
			return R.error("系统管理员不能删除");
		}
		
		if(ArrayUtils.contains(userIds, getUserId())){
			return R.error("当前用户不能删除");
		}
		
		sysUserService.deleteBatch(userIds);
		
		return R.ok();
	}
}
