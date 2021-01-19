package com.gzdata.core.qo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.model.SouvenirBuyHistory;

public class SouvenirBuyHistoryQo extends Pagination<SouvenirBuyHistory> {

	private Integer id; // pk

	private Integer mallId; // 纪念品ID

	private String convertor; // 兑换人名称

	private String concatPhone; // 联系电话

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date convertorTime; // 兑换时间

	private Integer addressId; // 邮寄地址

	private Integer state; // 发货状态：0.已发货 1.未发货 2.缺货

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createTime; // 创建时间

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getMallId() {
		return this.mallId;
	}

	public void setMallId(Integer mallId) {
		this.mallId = mallId;
	}

	public String getConvertor() {
		return this.convertor;
	}

	public void setConvertor(String convertor) {
		this.convertor = convertor;
	}

	public String getConcatPhone() {
		return this.concatPhone;
	}

	public void setConcatPhone(String concatPhone) {
		this.concatPhone = concatPhone;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getConvertorTime() {
		return this.convertorTime;
	}

	public void setConvertorTime(Date convertorTime) {
		this.convertorTime = convertorTime;
	}

	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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

}