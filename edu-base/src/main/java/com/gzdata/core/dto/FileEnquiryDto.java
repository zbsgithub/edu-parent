package com.gzdata.core.dto;

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
public class FileEnquiryDto {

	private Integer id; // pk

	private String phone; // 手机号

	private String idCard; // 身份证号

	private Integer applicationType; // 类型 0.成绩单 1.毕业证明 2.学位证明

	private String cardFront; // 身份证-正面

	private String cardBack; // 身份证-反面

	private Integer applicationStatus; // 申请状态 0.待审核 1.已通过 2.已拒绝

	private Integer userId; // 用户ID

	private String downloadLink; // 下载链接

	private Integer addressId; // 地址ID

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
	private Date createTime; // 创建时间

	private String remark; // 备注

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
	private Date deadline; // 截止时间

	private Integer isMail; // 是否邮寄：0.已邮寄 1.未邮寄

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getIdCard() {
		return this.idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Integer getApplicationType() {
		return this.applicationType;
	}

	public void setApplicationType(Integer applicationType) {
		this.applicationType = applicationType;
	}

	public String getCardFront() {
		return this.cardFront;
	}

	public void setCardFront(String cardFront) {
		this.cardFront = cardFront;
	}

	public String getCardBack() {
		return this.cardBack;
	}

	public void setCardBack(String cardBack) {
		this.cardBack = cardBack;
	}

	public Integer getApplicationStatus() {
		return this.applicationStatus;
	}

	public void setApplicationStatus(Integer applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getDownloadLink() {
		return this.downloadLink;
	}

	public void setDownloadLink(String downloadLink) {
		this.downloadLink = downloadLink;
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
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

	@JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getDeadline() {
		return this.deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	public Integer getIsMail() {
		return this.isMail;
	}

	public void setIsMail(Integer isMail) {
		this.isMail = isMail;
	}

}
