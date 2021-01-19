package com.gzdata.core.qo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.model.AlumniOrganization;

public class AlumniOrganizationQo extends Pagination<AlumniOrganization> {

	private Integer id; // pk

	private String organizaName; // 组织名称

	private String area; // 区域

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createTime; // 创建时间

	private String remark; // 备注

	private Integer alumniType; // 学院类别 0.地方 1.学院 2.其它

	private Integer inforId; // 关联媒体ID

	private String content; // 组织内容信息

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrganizaName() {
		return this.organizaName;
	}

	public void setOrganizaName(String organizaName) {
		this.organizaName = organizaName;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
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

	public Integer getAlumniType() {
		return this.alumniType;
	}

	public void setAlumniType(Integer alumniType) {
		this.alumniType = alumniType;
	}

	public Integer getInforId() {
		return this.inforId;
	}

	public void setInforId(Integer inforId) {
		this.inforId = inforId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}