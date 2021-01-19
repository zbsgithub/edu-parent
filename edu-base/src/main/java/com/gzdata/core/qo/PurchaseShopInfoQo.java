package com.gzdata.core.qo;

import java.math.BigDecimal;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.model.PurchaseShopInfo;

public class PurchaseShopInfoQo extends Pagination<PurchaseShopInfo> {

	private Integer id; // pk

	private String goodsName; // 商品名称

	private String imgPath; // 图片地址

	private BigDecimal actPrice; // 实际价格

	private BigDecimal donationPrice; // 捐赠价格

	private Integer isShelve; // 是否下架 0.已下架 1.未下架

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createTime; // 创建时间

	private String remark; // 备注

	private Integer isDelete; // 是否删除：0.已删除 1.未删除

	private String category; // 品类：颜色、尺码、规格eg

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getGoodsName() {
		return this.goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public BigDecimal getActPrice() {
		return this.actPrice;
	}

	public void setActPrice(BigDecimal actPrice) {
		this.actPrice = actPrice;
	}

	public BigDecimal getDonationPrice() {
		return this.donationPrice;
	}

	public void setDonationPrice(BigDecimal donationPrice) {
		this.donationPrice = donationPrice;
	}

	public Integer getIsShelve() {
		return this.isShelve;
	}

	public void setIsShelve(Integer isShelve) {
		this.isShelve = isShelve;
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

	public Integer getIsDelete() {
		return this.isDelete;
	}

	public void setIsDelete(Integer isDelete) {
		this.isDelete = isDelete;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

}