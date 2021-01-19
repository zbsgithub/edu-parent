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
public class ExchangeHistoryDto {

	private Integer id; // pk

	private Integer score; // 积分

	private Integer userId; // 用户ID

	private String goodsImgPath; // 商品图片地址

	private String goodsName; // 商品名称

	private String goodsModel; // 商品型号

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT)
	private Date exchangeTime; // 兑换时间

	private String remark; // 备注

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getScore() {
		return this.score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getUserId() {
		return this.userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getGoodsImgPath() {
		return this.goodsImgPath;
	}

	public void setGoodsImgPath(String goodsImgPath) {
		this.goodsImgPath = goodsImgPath;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsModel() {
		return this.goodsModel;
	}

	public void setGoodsModel(String goodsModel) {
		this.goodsModel = goodsModel;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATE_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getExchangeTime() {
		return this.exchangeTime;
	}

	public void setExchangeTime(Date exchangeTime) {
		this.exchangeTime = exchangeTime;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
