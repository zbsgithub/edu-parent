package com.gzdata.core.dto;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "model_control")
public class ModelControllerDto {

	@Field("model_type")
	private Integer modelType;// 模块类型：0.销量数据 1.厂商活跃数据 2.ORS市场数据

	@Field("family_type")
	private Integer familyType;// 家庭类型：0.家庭 1.个人

	@Field("is_show")
	private Integer isShow;

	@Field("create_time")
	private String createTime;

	public Integer getModelType() {
		return modelType;
	}

	public void setModelType(Integer modelType) {
		this.modelType = modelType;
	}

	public Integer getFamilyType() {
		return familyType;
	}

	public void setFamilyType(Integer familyType) {
		this.familyType = familyType;
	}

	public Integer getIsShow() {
		return isShow;
	}

	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Override
	public String toString() {
		return "ModelCtrollerDto [modelType=" + modelType + ", isShow="
				+ isShow + ", createTime=" + createTime + "]";
	}

}
