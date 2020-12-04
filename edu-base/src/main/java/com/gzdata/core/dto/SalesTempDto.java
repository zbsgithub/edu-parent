package com.gzdata.core.dto;

public class SalesTempDto {
	private String province;
	private String type;
	private String brand;
	private Double newSalesSum;
	private Double cumulativeSalesSum;
	
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public Double getNewSalesSum() {
		return newSalesSum;
	}
	public void setNewSalesSum(Double newSalesSum) {
		this.newSalesSum = newSalesSum;
	}
	public Double getCumulativeSalesSum() {
		return cumulativeSalesSum;
	}
	public void setCumulativeSalesSum(Double cumulativeSalesSum) {
		this.cumulativeSalesSum = cumulativeSalesSum;
	}
	@Override
	public String toString() {
		return "SalesTempDto [province=" + province + ", type=" + type
				+ ", brand=" + brand + ", newSalesSum=" + newSalesSum
				+ ", cumulativeSalesSum=" + cumulativeSalesSum + "]";
	}
}
