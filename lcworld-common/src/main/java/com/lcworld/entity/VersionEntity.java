package com.lcworld.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 版本表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-04-27 16:00:35
 */
public class VersionEntity implements Serializable {
  private static final long serialVersionUID = 1L;

  //
  private Integer versionId;
  // 版本号(整形,每次递增)
  private Integer versionCode;
  //
  private String versionName;
  // 0:安卓 1:IOS
  private Integer type;
  // 包地址(对于ios来说,可以在新版本审核通过,添加ios的版本信息,然后app通过版本更新接口提示用户升级)
  private String url;
  // 是否强制更新:0 否;1是
  private Integer isForceUpdate;
  // 创建时间
  private Date createTime;

  private String content;


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  /**
   * 设置：
   */
  public void setVersionId(Integer versionId) {
    this.versionId = versionId;
  }

  /**
   * 获取：
   */
  public Integer getVersionId() {
    return versionId;
  }

  /**
   * 设置：版本号(整形,每次递增)
   */
  public void setVersionCode(Integer versionCode) {
    this.versionCode = versionCode;
  }

  /**
   * 获取：版本号(整形,每次递增)
   */
  public Integer getVersionCode() {
    return versionCode;
  }

  /**
   * 设置：
   */
  public void setVersionName(String versionName) {
    this.versionName = versionName;
  }

  /**
   * 获取：
   */
  public String getVersionName() {
    return versionName;
  }

  /**
   * 设置：0:安卓 1:IOS
   */
  public void setType(Integer type) {
    this.type = type;
  }

  /**
   * 获取：0:安卓 1:IOS
   */
  public Integer getType() {
    return type;
  }

  /**
   * 设置：包地址(对于ios来说,可以在新版本审核通过,添加ios的版本信息,然后app通过版本更新接口提示用户升级)
   */
  public void setUrl(String url) {
    this.url = url;
  }

  /**
   * 获取：包地址(对于ios来说,可以在新版本审核通过,添加ios的版本信息,然后app通过版本更新接口提示用户升级)
   */
  public String getUrl() {
    return url;
  }

  /**
   * 设置：是否强制更新:0 否;1是
   */
  public void setIsForceUpdate(Integer isForceUpdate) {
    this.isForceUpdate = isForceUpdate;
  }

  /**
   * 获取：是否强制更新:0 否;1是
   */
  public Integer getIsForceUpdate() {
    return isForceUpdate;
  }

  /**
   * 设置：创建时间
   */
  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  /**
   * 获取：创建时间
   */
  public Date getCreateTime() {
    return createTime;
  }
}
