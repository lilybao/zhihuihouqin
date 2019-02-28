package com.lcworld.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 收藏
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-08-11 10:53:19
 */
public class TFavorEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//id
	private Integer id;
	//实体id
	private Integer entityid;
	//用户id
	private Integer uid;
	//收藏时间
	private Date createtime;
	//收藏状态 1: 已收藏 0：未收藏
	private Integer status;
	//收藏类型 1: 公告，2：办公，3：作品，4：图书，5：医生，6：活动，7：发型师 8:健康资讯 9： 专家
	private Integer favortype;

	/**
	 * 设置：id
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：id
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：实体id
	 */
	public void setEntityid(Integer entityid) {
		this.entityid = entityid;
	}
	/**
	 * 获取：实体id
	 */
	public Integer getEntityid() {
		return entityid;
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
	 * 设置：收藏时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：收藏时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：收藏状态 1: 已收藏 0：未收藏
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * 获取：收藏状态 1: 已收藏 0：未收藏
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * 设置：收藏类型 1: 公告，2：办公，3：作品，4：图书，5：医生，6：活动，7：发型师 8:健康资讯 9： 专家
	 */
	public void setFavortype(Integer favortype) {
		this.favortype = favortype;
	}
	/**
	 * 获取：收藏类型 1: 公告，2：办公，3：作品，4：图书，5：医生，6：活动，7：发型师 8:健康资讯 9： 专家
	 */
	public Integer getFavortype() {
		return favortype;
	}
}
