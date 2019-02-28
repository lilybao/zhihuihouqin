package com.lcworld.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lcworld.entity.VersionEntity;
import com.lcworld.service.VersionService;
import com.lcworld.utils.PageUtils;
import com.lcworld.utils.Query;
import com.lcworld.utils.R;


/**
 * 版本表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-04-27 16:00:35
 */
@RestController
@RequestMapping("version")
public class SysVersionController {
  
  @Autowired
  private VersionService versionService;

  /**
   * 列表
   */
  @RequestMapping("/list")
  @RequiresPermissions("version:list")
  public R list(@RequestParam Map<String, Object> params) {
    // 查询列表数据
    Query query = new Query(params);

    List<VersionEntity> versionList = versionService.queryList(query);
    int total = versionService.queryTotal(query);

    PageUtils pageUtil = new PageUtils(versionList, total, query.getLimit(), query.getPage());

    return R.ok().put("page", pageUtil);
  }


  /**
   * 信息
   */
  @RequestMapping("/info/{versionId}")
  @RequiresPermissions("version:info")
  public R info(@PathVariable("versionId") Integer versionId) {
    VersionEntity version = versionService.queryObject(versionId);

    return R.ok().put("version", version);
  }

  /**
   * 保存
   */
  @RequestMapping("/save")
  @RequiresPermissions("version:save")
  public R save(@RequestBody VersionEntity version) {
    
    version.setCreateTime(new Date());
    versionService.save(version);

    return R.ok();
  }

  /**
   * 修改
   */
  @RequestMapping("/update")
  @RequiresPermissions("version:update")
  public R update(@RequestBody VersionEntity version) {
    versionService.update(version);
    

    return R.ok();
  }

  /**
   * 删除
   */
  @RequestMapping("/delete")
  @RequiresPermissions("version:delete")
  public R delete(@RequestBody Integer[] versionIds) {
    versionService.deleteBatch(versionIds);

    return R.ok();
  }

}
