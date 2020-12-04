package com.gzdata.core.model;

import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;


public class ActiveVendorEntity {
	
	@ExcelIgnore
	private String id;//_id
	
	@ExcelProperty(value = {"品牌类型","品牌类型"},index = 1)
	@ColumnWidth(15)
    private String type;
	@Field("province")
	@ExcelProperty(value = {"省份","省份"},index = 2)
    private String province;
	
	@ExcelProperty(value = {"月开机规模","月开机规模"},index = 3)
	@ColumnWidth(16)
    private Integer monthlyBootScale;//月开机规模（万）
	
	@ExcelProperty(value = {"月开机率","月开机率"},index = 4)
	@ColumnWidth(15)
	@NumberFormat("#.##%")
    private String monthlyBootRate;//月开机率
	
	@ExcelProperty(value = {"日均开机规模","日均开机规模"},index = 5)
	@ColumnWidth(16)
    private Integer dailyBootScale;//日均开机规模（万）
	
	@ExcelProperty(value = {"日均开机率","日均开机率"},index = 6)
	@ColumnWidth(16)
	@NumberFormat("#.##%")
    private String dailyBootRate;//日均开机率
	
	@ExcelProperty(value = {"日均开机时长","日均开机时长"},index = 7)
	@ColumnWidth(16)
    private String dailyBootTime;//日均开机时长
	
	@ExcelProperty(value = {"日均开机频次","日均开机频次"},index = 8)
	@ColumnWidth(17)
    private String dailyBootFrequency;//日均开机频次

    @ExcelProperty(value = {"月份","月份"},index = 0)
	@ColumnWidth(15)
	private String month;//月份

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public Integer getMonthlyBootScale() {
		return monthlyBootScale;
	}

	public void setMonthlyBootScale(Integer monthlyBootScale) {
		this.monthlyBootScale = monthlyBootScale;
	}

	public String getMonthlyBootRate() {
		return monthlyBootRate;
	}

	public void setMonthlyBootRate(String monthlyBootRate) {
		this.monthlyBootRate = monthlyBootRate;
	}

	public Integer getDailyBootScale() {
		return dailyBootScale;
	}

	public void setDailyBootScale(Integer dailyBootScale) {
		this.dailyBootScale = dailyBootScale;
	}

	public String getDailyBootRate() {
		return dailyBootRate;
	}

	public void setDailyBootRate(String dailyBootRate) {
		this.dailyBootRate = dailyBootRate;
	}

	public String getDailyBootTime() {
		return dailyBootTime;
	}

	public void setDailyBootTime(String dailyBootTime) {
		this.dailyBootTime = dailyBootTime;
	}

	public String getDailyBootFrequency() {
		return dailyBootFrequency;
	}

	public void setDailyBootFrequency(String dailyBootFrequency) {
		this.dailyBootFrequency = dailyBootFrequency;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
}
