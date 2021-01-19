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
import com.gzdata.core.model.SysUserPermission;

/**
 * 
 * 说明：用户-权限表对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface SysUserPermissionDao extends
		BaseDAOInterface<SysUserPermission> {

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
	@Insert({ "insert into sys_user_permission ( id,user_id,permission_id,create_time)  values (#{id,jdbcType=BIGINT},#{userId,jdbcType=INTEGER},#{permissionId,jdbcType=INTEGER},#{createTime,jdbcType=TIMESTAMP})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(SysUserPermission entity);

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
			+ "insert into sys_user_permission "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"permissionId != null\" > permission_id, </if> <if test=\"createTime != null\" > create_time, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> <if test=\"permissionId != null\" > #{permissionId,jdbcType=INTEGER}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(SysUserPermission entity);

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
	@Delete({ "delete from sys_user_permission where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from sys_user_permission where id in "
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
	@Update({ "update sys_user_permission set id= #{id,jdbcType=BIGINT},user_id= #{userId,jdbcType=INTEGER},permission_id= #{permissionId,jdbcType=INTEGER},create_time= #{createTime,jdbcType=TIMESTAMP} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(SysUserPermission entity);

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
			+ "update sys_user_permission "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if> <if test=\"permissionId != null\" > permission_id = #{permissionId,jdbcType=INTEGER}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(SysUserPermission entity);

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
	@Select({ "select * from sys_user_permission" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "permission_id", property = "permissionId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<SysUserPermission> findAll();

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
	@Select({ "select count(id) from sys_user_permission" })
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
	@Select({ "select * from sys_user_permission where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "permission_id", property = "permissionId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public SysUserPermission findById(Serializable id);

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
			+ "select * from sys_user_permission "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"permissionId != null\" > and permission_id = #{permissionId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "permission_id", property = "permissionId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<SysUserPermission> findList(QueryInterface query);

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
			+ "select count(id) from sys_user_permission "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"permissionId != null\" > and permission_id = #{permissionId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
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
			+ "select * from sys_user_permission "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"permissionId != null\" > and permission_id = #{permissionId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "permission_id", property = "permissionId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<SysUserPermission> findPaginationDataByCondition(
			QueryInterface query);

}
