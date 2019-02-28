package com.lcworld.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 班级,科目,教材,知识点层级关系表
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-10 16:04:29
 */
public class BaseInfoEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long id;
	//名称
	private String name;
	//链接地址
	private String url;
	//父亲节点id
	private String parentid;
	//类型
	private String type;
	//节点层级
	private Integer level;
	//是否最后一层节点 1: true  0 : false
	private Integer lastlevel;
	//状态 -1删除 0 正常
	private Integer status;
	//
	private Date createTime;

	/**
	 * 设置：
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：链接地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：链接地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：父亲节点id
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * 获取：父亲节点id
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * 设置：类型
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * 获取：类型
	 */
	public String getType() {
		return type;
	}
	/**
	 * 设置：节点层级
	 */
	public void setLevel(Integer level) {
		this.level = level;
	}
	/**
	 * 获取：节点层级
	 */
	public Integer getLevel() {
		return level;
	}
	/**
	 * 设置：是否最后一层节点 1: true  0 : false
	 */
	public void setLastlevel(Integer lastlevel) {
		this.lastlevel = lastlevel;
	}
	/**
	 * 获取：是否最后一层节点 1: true  0 : false
	 */
	public Integer getLastlevel() {
		return lastlevel;
	}
	/**
	 * 设置：状态 -1删除 0 正常
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：状态 -1删除 0 正常
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * 获取：
	 */
	public Date getCreateTime() {
		return createTime;
	}
}
