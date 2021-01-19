package com.gzdata.core.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.util.DateUtil;

/**
 * 
 * 说明： 返校服务 值对象类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public class BackSchoolService {

	private Integer id; // pk

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
	private Date backTime; // 返校时间

	private Integer backPeopleCount; // 返校人数

	private Integer diningSituation; // 用餐情况 0.预定用餐 1.预定校内用餐

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date diningTime; // 用餐时间

	private Integer reservation; // 预定服务 0.活动摄影 1.校友之家场地服务 2.校友纪念章领取 3.参观校史馆
									// 4.参观图书馆

	private String otherService; // 其它服务

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createTime; // 创建时间

	private String remark; // 备注

	private Integer userId; // 用户ID

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getBackTime() {
		return this.backTime;
	}

	public void setBackTime(Date backTime) {
		this.backTime = backTime;
	}

	public Integer getBackPeopleCount() {
		return this.backPeopleCount;
	}

	public void setBackPeopleCount(Integer backPeopleCount) {
		this.backPeopleCount = backPeopleCount;
	}

	public Integer getDiningSituation() {
		return this.diningSituation;
	}

	public void setDiningSituation(Integer diningSituation) {
		this.diningSituation = diningSituation;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getDiningTime() {
		return this.diningTime;
	}

	public void setDiningTime(Date diningTime) {
		this.diningTime = diningTime;
	}

	public Integer getReservation() {
		return this.reservation;
	}

	public void setReservation(Integer reservation) {
		this.reservation = reservation;
	}

	public String getOtherService() {
		return this.otherService;
	}

	public void setOtherService(String otherService) {
		this.otherService = otherService;
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

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

}
