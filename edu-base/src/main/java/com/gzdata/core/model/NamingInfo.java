package com.gzdata.core.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.util.DateUtil;

/**
 * 
 * 说明： 冠名信息 值对象类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public class NamingInfo {

	private Integer id; // pk

	private String namingName; // 冠名名称

	private String namingImg; // 冠名图片地址

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
	private Date beginTime; // 活动-开始时间

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
	private Date overTime; // 活动-结束时间

	private Integer isShow; // 是否显示 0.显示 1.不显示

	private Integer isDelete; // 是否删除：0.已删除 1.未删除

	private String content; // 冠名内容

	private String publishPerson; // 发布人

	private Integer clickCount; // 点击数

	private Integer state; // 状态：0.编辑 1.提交 2.通过 3.拒绝 4.待发布 5.已发布 6.撤回 7.已过期

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createTime; // 创建时间

	private String remark; // 备注

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNamingName() {
		return this.namingName;
	}

	public void setNamingName(String namingName) {
		this.namingName = namingName;
	}

	public String getNamingImg() {
		return this.namingImg;
	}

	public void setNamingImg(String namingImg) {
		this.namingImg = namingImg;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getBeginTime() {
		return this.beginTime;
	}

	public void setBeginTime(Date beginTime) {
		this.beginTime = beginTime;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getOverTime() {
		return this.overTime;
	}

	public void setOverTime(Date overTime) {
		this.overTime = overTime;
	}

	public Integer getIsShow() {
		return this.isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPublishPerson() {
		return this.publishPerson;
	}

	public void setPublishPerson(String publishPerson) {
		this.publishPerson = publishPerson;
	}

	public Integer getClickCount() {
		return this.clickCount;
	}

	public void setClickCount(Integer clickCount) {
		this.clickCount = clickCount;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
