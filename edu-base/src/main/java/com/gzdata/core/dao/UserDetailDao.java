package com.gzdata.core.dao;

import java.io.Serializable;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.type.JdbcType;
import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.query.QueryInterface;
import com.gzdata.core.model.UserDetail;

/**
 * 
 * 说明：用户详情对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface UserDetailDao extends BaseDAOInterface<UserDetail> {

	/**
	 * 
	 * 功能描述：保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({ "insert into user_detail ( id,full_name,sex,work_unit,department,job,work_address,unit_nature,industry_type,identity_type,auditing_status,student_ids,create_time,remark)  values (#{id,jdbcType=BIGINT},#{fullName,jdbcType=VARCHAR},#{sex,jdbcType=TINYINT},#{workUnit,jdbcType=VARCHAR},#{department,jdbcType=VARCHAR},#{job,jdbcType=VARCHAR},#{workAddress,jdbcType=VARCHAR},#{unitNature,jdbcType=VARCHAR},#{industryType,jdbcType=VARCHAR},#{identityType,jdbcType=TINYINT},#{auditingStatus,jdbcType=TINYINT},#{studentIds,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(UserDetail entity);

	/**
	 * 
	 * 功能描述：选择字段保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Insert({ "<script>"
			+ "insert into user_detail "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"fullName != null\" > full_name, </if> <if test=\"sex != null\" > sex, </if> <if test=\"workUnit != null\" > work_unit, </if> <if test=\"department != null\" > department, </if> <if test=\"job != null\" > job, </if> <if test=\"workAddress != null\" > work_address, </if> <if test=\"unitNature != null\" > unit_nature, </if> <if test=\"industryType != null\" > industry_type, </if> <if test=\"identityType != null\" > identity_type, </if> <if test=\"auditingStatus != null\" > auditing_status, </if> <if test=\"studentIds != null\" > student_ids, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"fullName != null\" > #{fullName,jdbcType=VARCHAR}, </if> <if test=\"sex != null\" > #{sex,jdbcType=TINYINT}, </if> <if test=\"workUnit != null\" > #{workUnit,jdbcType=VARCHAR}, </if> <if test=\"department != null\" > #{department,jdbcType=VARCHAR}, </if> <if test=\"job != null\" > #{job,jdbcType=VARCHAR}, </if> <if test=\"workAddress != null\" > #{workAddress,jdbcType=VARCHAR}, </if> <if test=\"unitNature != null\" > #{unitNature,jdbcType=VARCHAR}, </if> <if test=\"industryType != null\" > #{industryType,jdbcType=VARCHAR}, </if> <if test=\"identityType != null\" > #{identityType,jdbcType=TINYINT}, </if> <if test=\"auditingStatus != null\" > #{auditingStatus,jdbcType=TINYINT}, </if> <if test=\"studentIds != null\" > #{studentIds,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(UserDetail entity);

	/**
	 * 
	 * 功能描述：根据ID删除
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({ "delete from user_detail where id = #{id,jdbcType=BIGINT}" })
	@Override
	public void deleteByID(Serializable id);

	/**
	 * 
	 * 功能描述：根据ID数组批量删除
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Delete({ "<script>"
			+ "delete from user_detail where id in "
			+ "<foreach  item=\"id\"  collection=\"array\" open=\"(\" separator=\",\" close=\")\" > #{id} </foreach>"
			+ "</script>" })
	@Override
	public void batchDelete(Serializable... ids);

	/**
	 * 
	 * 功能描述：更新
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "update user_detail set id= #{id,jdbcType=BIGINT},full_name= #{fullName,jdbcType=VARCHAR},sex= #{sex,jdbcType=TINYINT},work_unit= #{workUnit,jdbcType=VARCHAR},department= #{department,jdbcType=VARCHAR},job= #{job,jdbcType=VARCHAR},work_address= #{workAddress,jdbcType=VARCHAR},unit_nature= #{unitNature,jdbcType=VARCHAR},industry_type= #{industryType,jdbcType=VARCHAR},identity_type= #{identityType,jdbcType=TINYINT},auditing_status= #{auditingStatus,jdbcType=TINYINT},student_ids= #{studentIds,jdbcType=VARCHAR},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(UserDetail entity);

	/**
	 * 
	 * 功能描述：选择字段更新
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Update({ "<script>"
			+ "update user_detail "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"fullName != null\" > full_name = #{fullName,jdbcType=VARCHAR}, </if> <if test=\"sex != null\" > sex = #{sex,jdbcType=TINYINT}, </if> <if test=\"workUnit != null\" > work_unit = #{workUnit,jdbcType=VARCHAR}, </if> <if test=\"department != null\" > department = #{department,jdbcType=VARCHAR}, </if> <if test=\"job != null\" > job = #{job,jdbcType=VARCHAR}, </if> <if test=\"workAddress != null\" > work_address = #{workAddress,jdbcType=VARCHAR}, </if> <if test=\"unitNature != null\" > unit_nature = #{unitNature,jdbcType=VARCHAR}, </if> <if test=\"industryType != null\" > industry_type = #{industryType,jdbcType=VARCHAR}, </if> <if test=\"identityType != null\" > identity_type = #{identityType,jdbcType=TINYINT}, </if> <if test=\"auditingStatus != null\" > auditing_status = #{auditingStatus,jdbcType=TINYINT}, </if> <if test=\"studentIds != null\" > student_ids = #{studentIds,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(UserDetail entity);

	/**
	 * 
	 * 功能描述：查询所有
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from user_detail" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.TINYINT),
			@Result(column = "work_unit", property = "workUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "department", property = "department", jdbcType = JdbcType.VARCHAR),
			@Result(column = "job", property = "job", jdbcType = JdbcType.VARCHAR),
			@Result(column = "work_address", property = "workAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "unit_nature", property = "unitNature", jdbcType = JdbcType.VARCHAR),
			@Result(column = "industry_type", property = "industryType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "identity_type", property = "identityType", jdbcType = JdbcType.TINYINT),
			@Result(column = "auditing_status", property = "auditingStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "student_ids", property = "studentIds", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<UserDetail> findAll();

	/**
	 * 
	 * 功能描述：查询总数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select count(id) from user_detail" })
	@Override
	public int findTotalCount();

	/**
	 * 
	 * 功能描述：根据ID查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "select * from user_detail where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.TINYINT),
			@Result(column = "work_unit", property = "workUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "department", property = "department", jdbcType = JdbcType.VARCHAR),
			@Result(column = "job", property = "job", jdbcType = JdbcType.VARCHAR),
			@Result(column = "work_address", property = "workAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "unit_nature", property = "unitNature", jdbcType = JdbcType.VARCHAR),
			@Result(column = "industry_type", property = "industryType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "identity_type", property = "identityType", jdbcType = JdbcType.TINYINT),
			@Result(column = "auditing_status", property = "auditingStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "student_ids", property = "studentIds", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public UserDetail findById(Serializable id);

	/**
	 * 
	 * 功能描述：根据查询对象查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "<script>"
			+ "select * from user_detail "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=TINYINT} </if><if test=\"workUnit != null\" > and work_unit = #{workUnit,jdbcType=VARCHAR} </if><if test=\"department != null\" > and department = #{department,jdbcType=VARCHAR} </if><if test=\"job != null\" > and job = #{job,jdbcType=VARCHAR} </if><if test=\"workAddress != null\" > and work_address = #{workAddress,jdbcType=VARCHAR} </if><if test=\"unitNature != null\" > and unit_nature = #{unitNature,jdbcType=VARCHAR} </if><if test=\"industryType != null\" > and industry_type = #{industryType,jdbcType=VARCHAR} </if><if test=\"identityType != null\" > and identity_type = #{identityType,jdbcType=TINYINT} </if><if test=\"auditingStatus != null\" > and auditing_status = #{auditingStatus,jdbcType=TINYINT} </if><if test=\"studentIds != null\" > and student_ids = #{studentIds,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.TINYINT),
			@Result(column = "work_unit", property = "workUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "department", property = "department", jdbcType = JdbcType.VARCHAR),
			@Result(column = "job", property = "job", jdbcType = JdbcType.VARCHAR),
			@Result(column = "work_address", property = "workAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "unit_nature", property = "unitNature", jdbcType = JdbcType.VARCHAR),
			@Result(column = "industry_type", property = "industryType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "identity_type", property = "identityType", jdbcType = JdbcType.TINYINT),
			@Result(column = "auditing_status", property = "auditingStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "student_ids", property = "studentIds", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<UserDetail> findList(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据查询对象查询记录数
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "<script>"
			+ "select count(id) from user_detail "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=TINYINT} </if><if test=\"workUnit != null\" > and work_unit = #{workUnit,jdbcType=VARCHAR} </if><if test=\"department != null\" > and department = #{department,jdbcType=VARCHAR} </if><if test=\"job != null\" > and job = #{job,jdbcType=VARCHAR} </if><if test=\"workAddress != null\" > and work_address = #{workAddress,jdbcType=VARCHAR} </if><if test=\"unitNature != null\" > and unit_nature = #{unitNature,jdbcType=VARCHAR} </if><if test=\"industryType != null\" > and industry_type = #{industryType,jdbcType=VARCHAR} </if><if test=\"identityType != null\" > and identity_type = #{identityType,jdbcType=TINYINT} </if><if test=\"auditingStatus != null\" > and auditing_status = #{auditingStatus,jdbcType=TINYINT} </if><if test=\"studentIds != null\" > and student_ids = #{studentIds,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where></script>" })
	@Override
	public int findTotalCountByCondition(QueryInterface query);

	/**
	 * 
	 * 功能描述：根据查询对象查询分页记录
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "<script>"
			+ "select * from user_detail "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=TINYINT} </if><if test=\"workUnit != null\" > and work_unit = #{workUnit,jdbcType=VARCHAR} </if><if test=\"department != null\" > and department = #{department,jdbcType=VARCHAR} </if><if test=\"job != null\" > and job = #{job,jdbcType=VARCHAR} </if><if test=\"workAddress != null\" > and work_address = #{workAddress,jdbcType=VARCHAR} </if><if test=\"unitNature != null\" > and unit_nature = #{unitNature,jdbcType=VARCHAR} </if><if test=\"industryType != null\" > and industry_type = #{industryType,jdbcType=VARCHAR} </if><if test=\"identityType != null\" > and identity_type = #{identityType,jdbcType=TINYINT} </if><if test=\"auditingStatus != null\" > and auditing_status = #{auditingStatus,jdbcType=TINYINT} </if><if test=\"studentIds != null\" > and student_ids = #{studentIds,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.TINYINT),
			@Result(column = "work_unit", property = "workUnit", jdbcType = JdbcType.VARCHAR),
			@Result(column = "department", property = "department", jdbcType = JdbcType.VARCHAR),
			@Result(column = "job", property = "job", jdbcType = JdbcType.VARCHAR),
			@Result(column = "work_address", property = "workAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "unit_nature", property = "unitNature", jdbcType = JdbcType.VARCHAR),
			@Result(column = "industry_type", property = "industryType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "identity_type", property = "identityType", jdbcType = JdbcType.TINYINT),
			@Result(column = "auditing_status", property = "auditingStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "student_ids", property = "studentIds", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<UserDetail> findPaginationDataByCondition(QueryInterface query);

}
