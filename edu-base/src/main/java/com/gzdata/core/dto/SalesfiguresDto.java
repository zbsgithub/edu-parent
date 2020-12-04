package com.gzdata.core.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

/**
 * 厂商销量实体
 */
@Document(collection="salesfigures")
public class SalesfiguresDto {
	
	@Field("_id")
	@ExcelIgnore
	private String id;//_id

	@Field("brand")
//	@ExcelProperty(value = {"品牌","品牌"},index = 1)
	@ExcelProperty(value = {"brand","brand"},index = 1)
    private String brand;
	
	@Field("type")
//	@ExcelProperty(value = {"品牌类型","品牌类型"},index = 2)
	@ExcelProperty(value = {"brandType","brandType"},index = 2)
	@ColumnWidth(15)
    private String type;
	
	@Field("province")
//	@ExcelProperty(value = {"省份","省份"},index = 3)
	@ExcelProperty(value = {"province","province"},index = 3)
    private String province;
	
	@Field("new_sales")
//	@ExcelProperty(value = {"新增销量","新增销量"},index = 4)
	@ExcelProperty(value = {"newSales","newSales"},index = 4)
	@ColumnWidth(15)
    private Integer newSales;//新增销量
	
	@Field("cumulative_sales")
//	@ExcelProperty(value = {"累计销量","累计销量"},index = 5)
	@ExcelProperty(value = {"cumulativeSales","cumulativeSales"},index = 5)
	@ColumnWidth(15)
    private Integer cumulativeSales;//累计销量
	
	@Field("month")
//	@ExcelProperty(value = {"月份","月份"},index = 0)
	@ExcelProperty(value = {"month","month"},index = 0)
	private String month;//月份

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

	public String getBrand() {
        return brand;
    }

    public String getType() {
        return type;
    }

    public String getProvince() {
        return province;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setProvince(String province) {
        this.province = province;
    }

	public Integer getNewSales() {
		return newSales;
	}

	public void setNewSales(Integer newSales) {
		this.newSales = newSales;
	}

	public Integer getCumulativeSales() {
		return cumulativeSales;
	}

	public void setCumulativeSales(Integer cumulativeSales) {
		this.cumulativeSales = cumulativeSales;
	}

	@Override
	public String toString() {
		return "SalesfiguresDto [id=" + id + ", brand=" + brand + ", type="
				+ type + ", province=" + province + ", newSales=" + newSales
				+ ", cumulativeSales=" + cumulativeSales + ", month=" + month
				+ "]";
	}

}
