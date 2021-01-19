package com.gzdata.core.qo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gzdata.common.db.mybatis.page.Pagination;
import com.gzdata.common.util.DateUtil;
import com.gzdata.core.model.AlumniInfor;

public class AlumniInforQo extends Pagination<AlumniInfor> {

	private Integer id; // pk

	private String fullName; // 姓名

	private Integer sex; // 性别 性别：0.男 1.女 2.其它

	private String enrolmentYear; // 入学年份 例子：2019

	private Integer alumniStatus; // 校友身份 校友身份：0.普通本专科、1.研博生

	private String college; // 学院

	private String faculty; // 院系

	private String major; // 专业

	private String userId; // 用户ID 添加校友的学生用户ID

	private String className; // 班级名称

	private String phone; // 校友手机号

	private String remark; // 备注

	@DateTimeFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT)
	private Date createTime; // 创建时间

	/** 以下为get,set方法 */

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getSex() {
		return this.sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getEnrolmentYear() {
		return this.enrolmentYear;
	}

	public void setEnrolmentYear(String enrolmentYear) {
		this.enrolmentYear = enrolmentYear;
	}

	public Integer getAlumniStatus() {
		return this.alumniStatus;
	}

	public void setAlumniStatus(Integer alumniStatus) {
		this.alumniStatus = alumniStatus;
	}

	public String getCollege() {
		return this.college;
	}

	public void setCollege(String college) {
		this.college = college;
	}

	public String getFaculty() {
		return this.faculty;
	}

	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}

	public String getMajor() {
		return this.major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getClassName() {
		return this.className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemark() {
		return this.remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@JsonFormat(pattern = DateUtil.DEFAULT_DATETIME_FORMAT, timezone = DateUtil.DEFAULT_TIMEZONE)
	public Date getCreateTime() {
		return this.createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}