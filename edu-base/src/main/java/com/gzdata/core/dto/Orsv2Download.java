package com.gzdata.core.dto;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
/**
 * 下载记录表
 * 
 *
 * @author 张兵帅
 *
 * @version 
 *
 * @since 2020年9月26日
 */
@Document(collection="ors_v2_download")
public class Orsv2Download {
	
	@Field("_id")
	private String _id;//_id
	
	@Field("task_name")
	private String taskName;
	
	@Field("start_time")
	private String startTime;
	
	@Field("user_name")
	private String userName;
	
	@Field("module1")
	private String module1;
	
	@Field("module2")
	private String module2;
	
	@Field("start_date")
	private String startDate;
	
	@Field("end_date")
	private String endDate;
	
	@Field("personal_attribute")
	private String personalAttribute;
	
	@Field("media_name")
	private String mediaName;
	
	@Field("regional")
	private String regional;
	
	@Field("report_type")
	private String reportType;
	
	@Field("time_period")
	private String timePeriod;
	
	@Field("status")
	private String status;
	
	@Field("ip")
	private String ip;//0.third download 1.其它下载

	@Field("download_type")
	private Integer downloadType;//0.后台下载 1.其它下载

	@Field("brand_type_list")
	private String brandTypeList;//0.后台下载 1.其它下载
	
	
	public String getBrandTypeList() {
		return brandTypeList;
	}

	public void setBrandTypeList(String brandTypeList) {
		this.brandTypeList = brandTypeList;
	}

	public Integer getDownloadType() {
		return downloadType;
	}

	public void setDownloadType(Integer downloadType) {
		this.downloadType = downloadType;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getModule1() {
		return module1;
	}

	public void setModule1(String module1) {
		this.module1 = module1;
	}

	public String getModule2() {
		return module2;
	}

	public void setModule2(String module2) {
		this.module2 = module2;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPersonalAttribute() {
		return personalAttribute;
	}

	public void setPersonalAttribute(String personalAttribute) {
		this.personalAttribute = personalAttribute;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getRegional() {
		return regional;
	}

	public void setRegional(String regional) {
		this.regional = regional;
	}

	public String getReportType() {
		return reportType;
	}

	public void setReportType(String reportType) {
		this.reportType = reportType;
	}

	public String getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(String timePeriod) {
		this.timePeriod = timePeriod;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Orsv2Download [_id=" + _id + ", taskName=" + taskName
				+ ", startTime=" + startTime + ", userName=" + userName
				+ ", module1=" + module1 + ", module2=" + module2
				+ ", startDate=" + startDate + ", endDate=" + endDate
				+ ", personalAttribute=" + personalAttribute + ", mediaName="
				+ mediaName + ", regional=" + regional + ", reportType="
				+ reportType + ", timePeriod=" + timePeriod + ", status="
				+ status + "]";
	}
	
}
