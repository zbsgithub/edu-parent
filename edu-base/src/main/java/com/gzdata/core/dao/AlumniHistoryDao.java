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
import com.gzdata.core.model.AlumniHistory;

/**
 * 
 * 说明：校友历史对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface AlumniHistoryDao extends BaseDAOInterface<AlumniHistory> {

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
	@Insert({ "insert into alumni_history ( id,user_id,alumni_id,application_status,is_delete,apply_time,remark)  values (#{id,jdbcType=BIGINT},#{userId,jdbcType=INTEGER},#{alumniId,jdbcType=VARCHAR},#{applicationStatus,jdbcType=INTEGER},#{isDelete,jdbcType=INTEGER},#{applyTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(AlumniHistory entity);

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
			+ "insert into alumni_history "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"alumniId != null\" > alumni_id, </if> <if test=\"applicationStatus != null\" > application_status, </if> <if test=\"isDelete != null\" > is_delete, </if> <if test=\"applyTime != null\" > apply_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> <if test=\"alumniId != null\" > #{alumniId,jdbcType=VARCHAR}, </if> <if test=\"applicationStatus != null\" > #{applicationStatus,jdbcType=INTEGER}, </if> <if test=\"isDelete != null\" > #{isDelete,jdbcType=INTEGER}, </if> <if test=\"applyTime != null\" > #{applyTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(AlumniHistory entity);

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
	@Delete({ "delete from alumni_history where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from alumni_history where id in "
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
	@Update({ "update alumni_history set id= #{id,jdbcType=BIGINT},user_id= #{userId,jdbcType=INTEGER},alumni_id= #{alumniId,jdbcType=VARCHAR},application_status= #{applicationStatus,jdbcType=INTEGER},is_delete= #{isDelete,jdbcType=INTEGER},apply_time= #{applyTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(AlumniHistory entity);

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
			+ "update alumni_history "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if> <if test=\"alumniId != null\" > alumni_id = #{alumniId,jdbcType=VARCHAR}, </if> <if test=\"applicationStatus != null\" > application_status = #{applicationStatus,jdbcType=INTEGER}, </if> <if test=\"isDelete != null\" > is_delete = #{isDelete,jdbcType=INTEGER}, </if> <if test=\"applyTime != null\" > apply_time = #{applyTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(AlumniHistory entity);

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
	@Select({ "select * from alumni_history" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "alumni_id", property = "alumniId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.INTEGER),
			@Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<AlumniHistory> findAll();

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
	@Select({ "select count(id) from alumni_history" })
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
	@Select({ "select * from alumni_history where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "alumni_id", property = "alumniId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.INTEGER),
			@Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public AlumniHistory findById(Serializable id);

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
			+ "select * from alumni_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"alumniId != null\" > and alumni_id = #{alumniId,jdbcType=VARCHAR} </if><if test=\"applicationStatus != null\" > and application_status = #{applicationStatus,jdbcType=INTEGER} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=INTEGER} </if><if test=\"applyTime != null\" > and apply_time = #{applyTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "alumni_id", property = "alumniId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.INTEGER),
			@Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<AlumniHistory> findList(QueryInterface query);

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
			+ "select count(id) from alumni_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"alumniId != null\" > and alumni_id = #{alumniId,jdbcType=VARCHAR} </if><if test=\"applicationStatus != null\" > and application_status = #{applicationStatus,jdbcType=INTEGER} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=INTEGER} </if><if test=\"applyTime != null\" > and apply_time = #{applyTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
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
			+ "select * from alumni_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"alumniId != null\" > and alumni_id = #{alumniId,jdbcType=VARCHAR} </if><if test=\"applicationStatus != null\" > and application_status = #{applicationStatus,jdbcType=INTEGER} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=INTEGER} </if><if test=\"applyTime != null\" > and apply_time = #{applyTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "alumni_id", property = "alumniId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.INTEGER),
			@Result(column = "apply_time", property = "applyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<AlumniHistory> findPaginationDataByCondition(
			QueryInterface query);

}
