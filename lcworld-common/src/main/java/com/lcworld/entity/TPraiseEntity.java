package com.lcworld.entity;

import java.io.Serializable;
import java.util.Date;

import org.joda.time.DateTime;



/**
 * 
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-08-11 10:53:19
 */
public class TPraiseEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer upId;
	//用户id
	private Integer uid;
	//点赞状态(0未赞1已赞)
	private Integer upStatus;
	//点赞类型
	private Integer upTargetType;
	//点赞目标id
	private Integer entityid;

	/**
	 * 设置：
	 */
	public void setUpId(Integer upId) {
		this.upId = upId;
	}
	/**
	 * 获取：
	 */
	public Integer getUpId() {
		return upId;
	}
	/**
	 * 设置：用户id
	 */
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	/**
	 * 获取：用户id
	 */
	public Integer getUid() {
		return uid;
	}
	/**
	 * 设置：点赞状态(0未赞1已赞)
	 */
	public void setUpStatus(Integer upStatus) {
		this.upStatus = upStatus;
	}
	/**
	 * 获取：点赞状态(0未赞1已赞)
	 */
	public Integer getUpStatus() {
		return upStatus;
	}
	/**
	 * 设置：点赞类型
	 */
	public void setUpTargetType(Integer upTargetType) {
		this.upTargetType = upTargetType;
	}
	/**
	 * 获取：点赞类型
	 */
	public Integer getUpTargetType() {
		return upTargetType;
	}
	public Integer getEntityid() {
		return entityid;
	}
	public void setEntityid(Integer entityid) {
		this.entityid = entityid;
	}
	
}
