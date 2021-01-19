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
import com.gzdata.core.model.SysUser;

/**
 * 
 * 说明：用户信息表对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface SysUserDao extends BaseDAOInterface<SysUser> {

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
	@Insert({ "insert into sys_user ( id,user_name,pwd,nick,email,create_time,phone,begin_time,over_time,role_type,is_delete,platform_type,openid,head_img)  values (#{id,jdbcType=BIGINT},#{userName,jdbcType=VARCHAR},#{pwd,jdbcType=VARCHAR},#{nick,jdbcType=VARCHAR},#{email,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP},#{phone,jdbcType=VARCHAR},#{beginTime,jdbcType=DATE},#{overTime,jdbcType=DATE},#{roleType,jdbcType=TINYINT},#{isDelete,jdbcType=TINYINT},#{platformType,jdbcType=TINYINT},#{openid,jdbcType=VARCHAR},#{headImg,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(SysUser entity);

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
			+ "insert into sys_user "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"userName != null\" > user_name, </if> <if test=\"pwd != null\" > pwd, </if> <if test=\"nick != null\" > nick, </if> <if test=\"email != null\" > email, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"phone != null\" > phone, </if> <if test=\"beginTime != null\" > begin_time, </if> <if test=\"overTime != null\" > over_time, </if> <if test=\"roleType != null\" > role_type, </if> <if test=\"isDelete != null\" > is_delete, </if> <if test=\"platformType != null\" > platform_type, </if> <if test=\"openid != null\" > openid, </if> <if test=\"headImg != null\" > head_img, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"userName != null\" > #{userName,jdbcType=VARCHAR}, </if> <if test=\"pwd != null\" > #{pwd,jdbcType=VARCHAR}, </if> <if test=\"nick != null\" > #{nick,jdbcType=VARCHAR}, </if> <if test=\"email != null\" > #{email,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"phone != null\" > #{phone,jdbcType=VARCHAR}, </if> <if test=\"beginTime != null\" > #{beginTime,jdbcType=DATE}, </if> <if test=\"overTime != null\" > #{overTime,jdbcType=DATE}, </if> <if test=\"roleType != null\" > #{roleType,jdbcType=TINYINT}, </if> <if test=\"isDelete != null\" > #{isDelete,jdbcType=TINYINT}, </if> <if test=\"platformType != null\" > #{platformType,jdbcType=TINYINT}, </if> <if test=\"openid != null\" > #{openid,jdbcType=VARCHAR}, </if> <if test=\"headImg != null\" > #{headImg,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(SysUser entity);

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
	@Delete({ "delete from sys_user where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from sys_user where id in "
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
	@Update({ "update sys_user set id= #{id,jdbcType=BIGINT},user_name= #{userName,jdbcType=VARCHAR},pwd= #{pwd,jdbcType=VARCHAR},nick= #{nick,jdbcType=VARCHAR},email= #{email,jdbcType=VARCHAR},create_time= #{createTime,jdbcType=TIMESTAMP},phone= #{phone,jdbcType=VARCHAR},begin_time= #{beginTime,jdbcType=DATE},over_time= #{overTime,jdbcType=DATE},role_type= #{roleType,jdbcType=TINYINT},is_delete= #{isDelete,jdbcType=TINYINT},platform_type= #{platformType,jdbcType=TINYINT},openid= #{openid,jdbcType=VARCHAR},head_img= #{headImg,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(SysUser entity);

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
			+ "update sys_user "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"userName != null\" > user_name = #{userName,jdbcType=VARCHAR}, </if> <if test=\"pwd != null\" > pwd = #{pwd,jdbcType=VARCHAR}, </if> <if test=\"nick != null\" > nick = #{nick,jdbcType=VARCHAR}, </if> <if test=\"email != null\" > email = #{email,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"phone != null\" > phone = #{phone,jdbcType=VARCHAR}, </if> <if test=\"beginTime != null\" > begin_time = #{beginTime,jdbcType=DATE}, </if> <if test=\"overTime != null\" > over_time = #{overTime,jdbcType=DATE}, </if> <if test=\"roleType != null\" > role_type = #{roleType,jdbcType=TINYINT}, </if> <if test=\"isDelete != null\" > is_delete = #{isDelete,jdbcType=TINYINT}, </if> <if test=\"platformType != null\" > platform_type = #{platformType,jdbcType=TINYINT}, </if> <if test=\"openid != null\" > openid = #{openid,jdbcType=VARCHAR}, </if> <if test=\"headImg != null\" > head_img = #{headImg,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(SysUser entity);

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
	@Select({ "select * from sys_user" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nick", property = "nick", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "role_type", property = "roleType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "platform_type", property = "platformType", jdbcType = JdbcType.TINYINT),
			@Result(column = "openid", property = "openid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "head_img", property = "headImg", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<SysUser> findAll();

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
	@Select({ "select count(id) from sys_user" })
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
	@Select({ "select * from sys_user where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nick", property = "nick", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "role_type", property = "roleType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "platform_type", property = "platformType", jdbcType = JdbcType.TINYINT),
			@Result(column = "openid", property = "openid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "head_img", property = "headImg", jdbcType = JdbcType.VARCHAR) })
	@Override
	public SysUser findById(Serializable id);

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
			+ "select * from sys_user "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userName != null\" > and user_name = #{userName,jdbcType=VARCHAR} </if><if test=\"pwd != null\" > and pwd = #{pwd,jdbcType=VARCHAR} </if><if test=\"nick != null\" > and nick = #{nick,jdbcType=VARCHAR} </if><if test=\"email != null\" > and email = #{email,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"beginTime != null\" > and begin_time = #{beginTime,jdbcType=DATE} </if><if test=\"overTime != null\" > and over_time = #{overTime,jdbcType=DATE} </if><if test=\"roleType != null\" > and role_type = #{roleType,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"platformType != null\" > and platform_type = #{platformType,jdbcType=TINYINT} </if><if test=\"openid != null\" > and openid = #{openid,jdbcType=VARCHAR} </if><if test=\"headImg != null\" > and head_img = #{headImg,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nick", property = "nick", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "role_type", property = "roleType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "platform_type", property = "platformType", jdbcType = JdbcType.TINYINT),
			@Result(column = "openid", property = "openid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "head_img", property = "headImg", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<SysUser> findList(QueryInterface query);

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
			+ "select count(id) from sys_user "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userName != null\" > and user_name = #{userName,jdbcType=VARCHAR} </if><if test=\"pwd != null\" > and pwd = #{pwd,jdbcType=VARCHAR} </if><if test=\"nick != null\" > and nick = #{nick,jdbcType=VARCHAR} </if><if test=\"email != null\" > and email = #{email,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"beginTime != null\" > and begin_time = #{beginTime,jdbcType=DATE} </if><if test=\"overTime != null\" > and over_time = #{overTime,jdbcType=DATE} </if><if test=\"roleType != null\" > and role_type = #{roleType,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"platformType != null\" > and platform_type = #{platformType,jdbcType=TINYINT} </if><if test=\"openid != null\" > and openid = #{openid,jdbcType=VARCHAR} </if><if test=\"headImg != null\" > and head_img = #{headImg,jdbcType=VARCHAR} </if> "
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
			+ "select * from sys_user "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"userName != null\" > and user_name = #{userName,jdbcType=VARCHAR} </if><if test=\"pwd != null\" > and pwd = #{pwd,jdbcType=VARCHAR} </if><if test=\"nick != null\" > and nick = #{nick,jdbcType=VARCHAR} </if><if test=\"email != null\" > and email = #{email,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"beginTime != null\" > and begin_time = #{beginTime,jdbcType=DATE} </if><if test=\"overTime != null\" > and over_time = #{overTime,jdbcType=DATE} </if><if test=\"roleType != null\" > and role_type = #{roleType,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"platformType != null\" > and platform_type = #{platformType,jdbcType=TINYINT} </if><if test=\"openid != null\" > and openid = #{openid,jdbcType=VARCHAR} </if><if test=\"headImg != null\" > and head_img = #{headImg,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "user_name", property = "userName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pwd", property = "pwd", jdbcType = JdbcType.VARCHAR),
			@Result(column = "nick", property = "nick", jdbcType = JdbcType.VARCHAR),
			@Result(column = "email", property = "email", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "role_type", property = "roleType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "platform_type", property = "platformType", jdbcType = JdbcType.TINYINT),
			@Result(column = "openid", property = "openid", jdbcType = JdbcType.VARCHAR),
			@Result(column = "head_img", property = "headImg", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<SysUser> findPaginationDataByCondition(QueryInterface query);

}
