package com.gzdata.core.dto;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.util.DateUtil;

/**
 * 
 * 
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public class CashDonationDto {

	private Integer id; // pk

	private String fullName; // 姓名

	private String phone; // 电话

	private Integer donationMethod; // 捐赠方式 捐赠方式：0.个人捐赠 1.班级捐赠 2.分会捐赠 3.企事业捐赠

	private BigDecimal donationMoney; // 捐赠金额

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date donationTime; // 捐赠时间

	private String message; // 寄语

	private Integer isAnonymous; // 是否匿名 0.匿名 1.非匿名

	private Integer payStatus; // 支付状态 支付状态：0.成功 1.失败

	private String serialNumber; // 流水号

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getDonationMethod() {
		return this.donationMethod;
	}

	public void setDonationMethod(Integer donationMethod) {
		this.donationMethod = donationMethod;
	}

	public BigDecimal getDonationMoney() {
		return this.donationMoney;
	}

	public void setDonationMoney(BigDecimal donationMoney) {
		this.donationMoney = donationMoney;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getDonationTime() {
		return this.donationTime;
	}

	public void setDonationTime(Date donationTime) {
		this.donationTime = donationTime;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getIsAnonymous() {
		return this.isAnonymous;
	}

	public void setIsAnonymous(Integer isAnonymous) {
		this.isAnonymous = isAnonymous;
	}

	public Integer getPayStatus() {
		return this.payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getSerialNumber() {
		return this.serialNumber;
	}

	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}

}
