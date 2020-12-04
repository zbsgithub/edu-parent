package com.gzdata.core.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;


/**
 * 个人分市场激活量
 */
@Document(collection="individual_market_activation")
public class IndividualMarketActivationDto {

	@Field("_id")
	@ExcelIgnore
	private String id;//_id
	
	@Field("province")
	@ExcelProperty(value = {"省份","省份"},index = 1)
    private String province;//省份
	
	@Field("region")
	@ExcelProperty(value = {"区域","区域"},index = 2)
    private String region;//区域：华东、华南
	
	@Field("city")
	@ExcelProperty(value = {"城市","城市"},index = 3)
    private String city;
	
	@Field("tier")
	@ExcelProperty(value = {"城市级别","城市级别"},index = 4)
	@ColumnWidth(14)
    private String tier;//城市级别
	
	@Field("gender")
	@ExcelProperty(value = {"性别","性别"},index = 5)
    private String gender;//性别
	
	@Field("age")
	@ExcelProperty(value = {"年龄","年龄"},index = 6)
    private String age;
	
	@Field("personInventory")
	@ExcelProperty(value = {"激活量","激活量"},index = 7)
    private Integer personInventory;//激活量
	
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

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
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

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAge(String age) {
        this.age = age;
    }

	public Integer getPersonInventory() {
		return personInventory;
	}

	public void setPersonInventory(Integer personInventory) {
		this.personInventory = personInventory;
	}

	@Override
	public String toString() {
		return "IndividualMarketActivationDto [id=" + id + ", province="
				+ province + ", region=" + region + ", city=" + city
				+ ", tier=" + tier + ", gender=" + gender + ", age=" + age
				+ ", personInventory=" + personInventory + ", month=" + month
				+ "]";
	}
	 
}

