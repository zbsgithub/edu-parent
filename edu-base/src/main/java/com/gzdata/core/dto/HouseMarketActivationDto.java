package com.gzdata.core.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;

/**
 * 家庭分市场激活量
 */
@Document(collection="house_market_activation")
public class HouseMarketActivationDto {

	@Field("_id")
	@ExcelIgnore
	private String id;//_id
	
	@Field("province")
	@ExcelProperty(value = {"省份","省份"},index = 1)
    private String province;
	
	@Field("region")
	@ExcelProperty(value = {"区域","区域"},index = 2)
    private String region;//区域:华东、华南等
	
	@Field("city")
	@ExcelProperty(value = {"城市","城市"},index = 3)
    private String city;
	
	@Field("tier")
	@ExcelProperty(value = {"城市级别","城市级别"},index = 4)
	@ColumnWidth(15)
    private String tier;//城市级别：二线城市、三线等
	
	@Field("family_life_stage")
	@ExcelProperty(value = {"家庭生命周期","家庭生命周期"},index = 5)
	@ColumnWidth(16)
    private String familyLifeStage;//家庭生命周期
	
	@Field("family_inventory")
	@ExcelProperty(value = {"激活量","激活量"},index = 6)
    private Integer familyInventory;//激活量

	@Field("month")
	@ExcelProperty(value = {"月份","月份"},index = 0)
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

	public String getProvince() {
        return province;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getTier() {
        return tier;
    }

    public String getFamilyLifeStage() {
        return familyLifeStage;
    }

   

    public void setProvince(String province) {
        this.province = province;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public void setFamilyLifeStage(String familyLifeStage) {
        this.familyLifeStage = familyLifeStage;
    }

	public Integer getFamilyInventory() {
		return familyInventory;
	}

	public void setFamilyInventory(Integer familyInventory) {
		this.familyInventory = familyInventory;
	}

	@Override
	public String toString() {
		return "HouseMarketActivationDto [id=" + id + ", province=" + province
				+ ", region=" + region + ", city=" + city + ", tier=" + tier
				+ ", familyLifeStage=" + familyLifeStage + ", familyInventory="
				+ familyInventory + ", month=" + month + "]";
	}
	
}

