package com.lcworld.entity;

import java.io.Serializable;
import java.util.Date;



/**
 * 用户
 * 
 * @author xlf
 * @email xlfbe696@gmail.com
 * @date 2017-07-10 15:41:01
 */
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Long userId;
	//用户名
	private String username;
	//手机号
	private String mobile;
	//密码
	private String password;
	//创建时间
	private Date createTime;
	//年级
	private Long grade;
	//年级名:冗余
	private String gradeName;
	//性别:0 男;1 女
	private Integer sex;
	//头像
	private String avatar;
	//0 文科;1理科
	private String subjecttype;
	//face的uuid
	private String faceId;
	//教材版本:冗余
	private String textbookversion;
	//教材id
	private Long textbookId;

	/**
	 * 设置：
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**
	 * 获取：
	 */
	public Long getUserId() {
		return userId;
	}
	/**
	 * 设置：用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * 获取：用户名
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * 设置：手机号
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * 获取：手机号
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * 设置：密码
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * 获取：密码
	 */
	public String getPassword() {
		return password;
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
	/**
	 * 设置：年级
	 */
	public void setGrade(Long grade) {
		this.grade = grade;
	}
	/**
	 * 获取：年级
	 */
	public Long getGrade() {
		return grade;
	}
	/**
	 * 设置：年级名:冗余
	 */
	public void setGradeName(String gradeName) {
		this.gradeName = gradeName;
	}
	/**
	 * 获取：年级名:冗余
	 */
	public String getGradeName() {
		return gradeName;
	}
	/**
	 * 设置：性别:0 男;1 女
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别:0 男;1 女
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：头像
	 */
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	/**
	 * 获取：头像
	 */
	public String getAvatar() {
		return avatar;
	}
	/**
	 * 设置：0 文科;1理科
	 */
	public void setSubjecttype(String subjecttype) {
		this.subjecttype = subjecttype;
	}
	/**
	 * 获取：0 文科;1理科
	 */
	public String getSubjecttype() {
		return subjecttype;
	}
	/**
	 * 设置：face的uuid
	 */
	public void setFaceId(String faceId) {
		this.faceId = faceId;
	}
	/**
	 * 获取：face的uuid
	 */
	public String getFaceId() {
		return faceId;
	}
	/**
	 * 设置：教材版本:冗余
	 */
	public void setTextbookversion(String textbookversion) {
		this.textbookversion = textbookversion;
	}
	/**
	 * 获取：教材版本:冗余
	 */
	public String getTextbookversion() {
		return textbookversion;
	}
	/**
	 * 设置：教材id
	 */
	public void setTextbookId(Long textbookId) {
		this.textbookId = textbookId;
	}
	/**
	 * 获取：教材id
	 */
	public Long getTextbookId() {
		return textbookId;
	}
}
