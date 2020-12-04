package com.gzdata.core.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

/**
 * 新版-厂商活跃数据-实体
 */
@Document(collection = "manufacturers_active")
public class ManufacturersActiveDto {

	@Field("_id")
	@ExcelIgnore
	private String id;// _id

	@Field("month")
	@ExcelProperty(value = { "月份", "月份" }, index = 0)
	@ColumnWidth(15)
	private String month;// 月份

	@Field("type")
	@ExcelProperty(value = { "品牌类型", "品牌类型" }, index = 1)
	@ColumnWidth(15)
	private String type;

	@Field("province")
	@ExcelProperty(value = { "省份", "省份" }, index = 2)
	private String province;

	@Field("monthly_boot_scale")
	@ExcelProperty(value = { "月开机规模", "月开机规模" }, index = 3)
	@ColumnWidth(16)
	private Double monthlyBootScale;// 月开机规模（万）

	@Field("monthly_boot_rate")
	@ExcelProperty(value = { "月开机率", "月开机率" }, index = 4)
	@ColumnWidth(15)
	@NumberFormat("#.##%")
	private String monthlyBootRate;// 月开机率

	@Field("daily_boot_scale")
	@ExcelProperty(value = { "日均开机规模", "日均开机规模" }, index = 5)
	@ColumnWidth(16)
	private Double dailyBootScale;// 日均开机规模（万）

	@Field("daily_boot_rate")
	@ExcelProperty(value = { "日均开机率", "日均开机率" }, index = 6)
	@ColumnWidth(16)
	@NumberFormat("#.##%")
	private String dailyBootRate;// 日均开机率

	@Field("activation")
	@ExcelProperty(value = { "激活量", "激活量" }, index = 7)
	@ColumnWidth(16)
	private Double activation;// 激活量
	
	public Double getActivation() {
		return activation;
	}

	public void setActivation(Double activation) {
		this.activation = activation;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getProvince() {
		return province;
	}

	public Double getMonthlyBootScale() {
		return monthlyBootScale;
	}

	public void setMonthlyBootScale(Double monthlyBootScale) {
		this.monthlyBootScale = monthlyBootScale;
	}

	public String getMonthlyBootRate() {
		return monthlyBootRate;
	}

	public void setMonthlyBootRate(String monthlyBootRate) {
		this.monthlyBootRate = monthlyBootRate;
	}

	public String getDailyBootRate() {
		return dailyBootRate;
	}

	public void setDailyBootRate(String dailyBootRate) {
		this.dailyBootRate = dailyBootRate;
	}

	public Double getDailyBootScale() {
		return dailyBootScale;
	}

	public void setDailyBootScale(Double dailyBootScale) {
		this.dailyBootScale = dailyBootScale;
	}

	@Override
	public String toString() {
		return "ManufacturersActiveDto [id=" + id + ", month=" + month
				+ ", type=" + type + ", province=" + province
				+ ", monthlyBootScale=" + monthlyBootScale
				+ ", monthlyBootRate=" + monthlyBootRate + ", dailyBootScale="
				+ dailyBootScale + ", dailyBootRate=" + dailyBootRate
				+ ", activation=" + activation + "]";
	}
	
}
