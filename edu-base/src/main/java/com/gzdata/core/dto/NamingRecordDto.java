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
public class NamingRecordDto {

	private Integer id; // pk

	private String donors; // 捐赠方

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date donationTime; // 捐赠时间

	private BigDecimal money; // 捐赠金额

	private Integer namingId; // 冠名id (冠名哪个东西)

	private Integer namingUserid; // 冠名人、组织

	private String remark; // 备注

	private Integer payState; // 支付状态：0.success 1.failed

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDonors() {
		return this.donors;
	}

	public void setDonors(String donors) {
		this.donors = donors;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getDonationTime() {
		return this.donationTime;
	}

	public void setDonationTime(Date donationTime) {
		this.donationTime = donationTime;
	}

	public BigDecimal getMoney() {
		return this.money;
	}

	public void setMoney(BigDecimal money) {
		this.money = money;
	}

	public Integer getNamingId() {
		return this.namingId;
	}

	public void setNamingId(Integer namingId) {
		this.namingId = namingId;
	}

	public Integer getNamingUserid() {
		return this.namingUserid;
	}

	public void setNamingUserid(Integer namingUserid) {
		this.namingUserid = namingUserid;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getPayState() {
		return this.payState;
	}

	public void setPayState(Integer payState) {
		this.payState = payState;
	}

}
