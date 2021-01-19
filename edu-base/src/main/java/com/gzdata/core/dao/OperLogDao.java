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
import com.gzdata.core.model.OperLog;

/**
 * 
 * 说明：操作日志表对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface OperLogDao extends BaseDAOInterface<OperLog> {

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
	@Insert({ "insert into oper_log ( id,content,oper_name,oper_time,remark)  values (#{id,jdbcType=BIGINT},#{content,jdbcType=VARCHAR},#{operName,jdbcType=VARCHAR},#{operTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(OperLog entity);

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
			+ "insert into oper_log "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"content != null\" > content, </if> <if test=\"operName != null\" > oper_name, </if> <if test=\"operTime != null\" > oper_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"content != null\" > #{content,jdbcType=VARCHAR}, </if> <if test=\"operName != null\" > #{operName,jdbcType=VARCHAR}, </if> <if test=\"operTime != null\" > #{operTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(OperLog entity);

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
	@Delete({ "delete from oper_log where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from oper_log where id in "
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
	@Update({ "update oper_log set id= #{id,jdbcType=BIGINT},content= #{content,jdbcType=VARCHAR},oper_name= #{operName,jdbcType=VARCHAR},oper_time= #{operTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(OperLog entity);

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
			+ "update oper_log "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"content != null\" > content = #{content,jdbcType=VARCHAR}, </if> <if test=\"operName != null\" > oper_name = #{operName,jdbcType=VARCHAR}, </if> <if test=\"operTime != null\" > oper_time = #{operTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(OperLog entity);

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
	@Select({ "select * from oper_log" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_name", property = "operName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_time", property = "operTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<OperLog> findAll();

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
	@Select({ "select count(id) from oper_log" })
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
	@Select({ "select * from oper_log where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_name", property = "operName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_time", property = "operTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public OperLog findById(Serializable id);

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
			+ "select * from oper_log "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=VARCHAR} </if><if test=\"operName != null\" > and oper_name = #{operName,jdbcType=VARCHAR} </if><if test=\"operTime != null\" > and oper_time = #{operTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_name", property = "operName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_time", property = "operTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<OperLog> findList(QueryInterface query);

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
			+ "select count(id) from oper_log "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=VARCHAR} </if><if test=\"operName != null\" > and oper_name = #{operName,jdbcType=VARCHAR} </if><if test=\"operTime != null\" > and oper_time = #{operTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
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
			+ "select * from oper_log "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=VARCHAR} </if><if test=\"operName != null\" > and oper_name = #{operName,jdbcType=VARCHAR} </if><if test=\"operTime != null\" > and oper_time = #{operTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_name", property = "operName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "oper_time", property = "operTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<OperLog> findPaginationDataByCondition(QueryInterface query);

}
