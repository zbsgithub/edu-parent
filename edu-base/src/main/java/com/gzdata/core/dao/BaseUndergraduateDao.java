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
import com.gzdata.core.model.BaseUndergraduate;

/**
 * 
 * 说明：基础-普通专本科对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface BaseUndergraduateDao extends
		BaseDAOInterface<BaseUndergraduate> {

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
	@Insert({ "insert into base_undergraduate ( id,stu_number,stu_name,sex,college,major,class_name,enrollment_year,university,stu_type,create_time,remark)  values (#{id,jdbcType=BIGINT},#{stuNumber,jdbcType=VARCHAR},#{stuName,jdbcType=VARCHAR},#{sex,jdbcType=CHAR},#{college,jdbcType=VARCHAR},#{major,jdbcType=VARCHAR},#{className,jdbcType=VARCHAR},#{enrollmentYear,jdbcType=VARCHAR},#{university,jdbcType=VARCHAR},#{stuType,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(BaseUndergraduate entity);

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
			+ "insert into base_undergraduate "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"stuNumber != null\" > stu_number, </if> <if test=\"stuName != null\" > stu_name, </if> <if test=\"sex != null\" > sex, </if> <if test=\"college != null\" > college, </if> <if test=\"major != null\" > major, </if> <if test=\"className != null\" > class_name, </if> <if test=\"enrollmentYear != null\" > enrollment_year, </if> <if test=\"university != null\" > university, </if> <if test=\"stuType != null\" > stu_type, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"stuNumber != null\" > #{stuNumber,jdbcType=VARCHAR}, </if> <if test=\"stuName != null\" > #{stuName,jdbcType=VARCHAR}, </if> <if test=\"sex != null\" > #{sex,jdbcType=CHAR}, </if> <if test=\"college != null\" > #{college,jdbcType=VARCHAR}, </if> <if test=\"major != null\" > #{major,jdbcType=VARCHAR}, </if> <if test=\"className != null\" > #{className,jdbcType=VARCHAR}, </if> <if test=\"enrollmentYear != null\" > #{enrollmentYear,jdbcType=VARCHAR}, </if> <if test=\"university != null\" > #{university,jdbcType=VARCHAR}, </if> <if test=\"stuType != null\" > #{stuType,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(BaseUndergraduate entity);

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
	@Delete({ "delete from base_undergraduate where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from base_undergraduate where id in "
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
	@Update({ "update base_undergraduate set id= #{id,jdbcType=BIGINT},stu_number= #{stuNumber,jdbcType=VARCHAR},stu_name= #{stuName,jdbcType=VARCHAR},sex= #{sex,jdbcType=CHAR},college= #{college,jdbcType=VARCHAR},major= #{major,jdbcType=VARCHAR},class_name= #{className,jdbcType=VARCHAR},enrollment_year= #{enrollmentYear,jdbcType=VARCHAR},university= #{university,jdbcType=VARCHAR},stu_type= #{stuType,jdbcType=VARCHAR},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(BaseUndergraduate entity);

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
			+ "update base_undergraduate "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"stuNumber != null\" > stu_number = #{stuNumber,jdbcType=VARCHAR}, </if> <if test=\"stuName != null\" > stu_name = #{stuName,jdbcType=VARCHAR}, </if> <if test=\"sex != null\" > sex = #{sex,jdbcType=CHAR}, </if> <if test=\"college != null\" > college = #{college,jdbcType=VARCHAR}, </if> <if test=\"major != null\" > major = #{major,jdbcType=VARCHAR}, </if> <if test=\"className != null\" > class_name = #{className,jdbcType=VARCHAR}, </if> <if test=\"enrollmentYear != null\" > enrollment_year = #{enrollmentYear,jdbcType=VARCHAR}, </if> <if test=\"university != null\" > university = #{university,jdbcType=VARCHAR}, </if> <if test=\"stuType != null\" > stu_type = #{stuType,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(BaseUndergraduate entity);

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
	@Select({ "select * from base_undergraduate" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "stu_number", property = "stuNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_name", property = "stuName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enrollment_year", property = "enrollmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "university", property = "university", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_type", property = "stuType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<BaseUndergraduate> findAll();

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
	@Select({ "select count(id) from base_undergraduate" })
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
	@Select({ "select * from base_undergraduate where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "stu_number", property = "stuNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_name", property = "stuName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enrollment_year", property = "enrollmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "university", property = "university", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_type", property = "stuType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public BaseUndergraduate findById(Serializable id);

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
			+ "select * from base_undergraduate "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"stuNumber != null\" > and stu_number = #{stuNumber,jdbcType=VARCHAR} </if><if test=\"stuName != null\" > and stu_name = #{stuName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=CHAR} </if><if test=\"college != null\" > and college = #{college,jdbcType=VARCHAR} </if><if test=\"major != null\" > and major = #{major,jdbcType=VARCHAR} </if><if test=\"className != null\" > and class_name = #{className,jdbcType=VARCHAR} </if><if test=\"enrollmentYear != null\" > and enrollment_year = #{enrollmentYear,jdbcType=VARCHAR} </if><if test=\"university != null\" > and university = #{university,jdbcType=VARCHAR} </if><if test=\"stuType != null\" > and stu_type = #{stuType,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "stu_number", property = "stuNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_name", property = "stuName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enrollment_year", property = "enrollmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "university", property = "university", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_type", property = "stuType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<BaseUndergraduate> findList(QueryInterface query);

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
			+ "select count(id) from base_undergraduate "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"stuNumber != null\" > and stu_number = #{stuNumber,jdbcType=VARCHAR} </if><if test=\"stuName != null\" > and stu_name = #{stuName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=CHAR} </if><if test=\"college != null\" > and college = #{college,jdbcType=VARCHAR} </if><if test=\"major != null\" > and major = #{major,jdbcType=VARCHAR} </if><if test=\"className != null\" > and class_name = #{className,jdbcType=VARCHAR} </if><if test=\"enrollmentYear != null\" > and enrollment_year = #{enrollmentYear,jdbcType=VARCHAR} </if><if test=\"university != null\" > and university = #{university,jdbcType=VARCHAR} </if><if test=\"stuType != null\" > and stu_type = #{stuType,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
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
			+ "select * from base_undergraduate "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"stuNumber != null\" > and stu_number = #{stuNumber,jdbcType=VARCHAR} </if><if test=\"stuName != null\" > and stu_name = #{stuName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=CHAR} </if><if test=\"college != null\" > and college = #{college,jdbcType=VARCHAR} </if><if test=\"major != null\" > and major = #{major,jdbcType=VARCHAR} </if><if test=\"className != null\" > and class_name = #{className,jdbcType=VARCHAR} </if><if test=\"enrollmentYear != null\" > and enrollment_year = #{enrollmentYear,jdbcType=VARCHAR} </if><if test=\"university != null\" > and university = #{university,jdbcType=VARCHAR} </if><if test=\"stuType != null\" > and stu_type = #{stuType,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "stu_number", property = "stuNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_name", property = "stuName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "enrollment_year", property = "enrollmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "university", property = "university", jdbcType = JdbcType.VARCHAR),
			@Result(column = "stu_type", property = "stuType", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<BaseUndergraduate> findPaginationDataByCondition(
			QueryInterface query);

}
