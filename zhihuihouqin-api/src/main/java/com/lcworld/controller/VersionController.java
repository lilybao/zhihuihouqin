package com.lcworld.controller;


import javax.servlet.http.HttpServletRequest;

import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lcworld.annotation.IgnoreToken;
import com.lcworld.entity.VersionEntity;
import com.lcworld.service.VersionService;
import com.lcworld.utils.R;
import com.lcworld.validator.Assert;

/**
 * 版本查询接口类型
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017年4月27日 下午7:14:46
 */
@RestController
@RequestMapping("/version")
public class VersionController {
	private Logger log = LoggerFactory.getLogger(VersionController.class);
  @Autowired
  private VersionService versionService;

  @PostMapping("/get")
  @IgnoreToken
  public R get(HttpServletRequest req) {
    String biz = req.getParameter("biz");
	log.debug("biz:"+biz);
    JSONObject parse = (JSONObject) JSON.parse(biz);

    // 默认安卓
    Integer type = MapUtils.getInteger(parse, "type");
    
    Assert.isNull(type, "type为空");

    VersionEntity version = versionService.selectLatest(type);

    return R.ok().put("version", version);
  }
}
