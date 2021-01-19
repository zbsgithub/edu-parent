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
import com.gzdata.core.model.AlumniOrganization;

/**
 * 
 * 说明：校友组织信息对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface AlumniOrganizationDao extends
		BaseDAOInterface<AlumniOrganization> {

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
	@Insert({ "insert into alumni_organization ( id,organiza_name,area,create_time,remark,alumni_type,infor_id,content)  values (#{id,jdbcType=BIGINT},#{organizaName,jdbcType=VARCHAR},#{area,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR},#{alumniType,jdbcType=INTEGER},#{inforId,jdbcType=INTEGER},#{content,jdbcType=BLOB})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(AlumniOrganization entity);

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
			+ "insert into alumni_organization "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"organizaName != null\" > organiza_name, </if> <if test=\"area != null\" > area, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if> <if test=\"alumniType != null\" > alumni_type, </if> <if test=\"inforId != null\" > infor_id, </if> <if test=\"content != null\" > content, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"organizaName != null\" > #{organizaName,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > #{area,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"alumniType != null\" > #{alumniType,jdbcType=INTEGER}, </if> <if test=\"inforId != null\" > #{inforId,jdbcType=INTEGER}, </if> <if test=\"content != null\" > #{content,jdbcType=BLOB}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(AlumniOrganization entity);

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
	@Delete({ "delete from alumni_organization where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from alumni_organization where id in "
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
	@Update({ "update alumni_organization set id= #{id,jdbcType=BIGINT},organiza_name= #{organizaName,jdbcType=VARCHAR},area= #{area,jdbcType=VARCHAR},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR},alumni_type= #{alumniType,jdbcType=INTEGER},infor_id= #{inforId,jdbcType=INTEGER},content= #{content,jdbcType=BLOB} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(AlumniOrganization entity);

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
			+ "update alumni_organization "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"organizaName != null\" > organiza_name = #{organizaName,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > area = #{area,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"alumniType != null\" > alumni_type = #{alumniType,jdbcType=INTEGER}, </if> <if test=\"inforId != null\" > infor_id = #{inforId,jdbcType=INTEGER}, </if> <if test=\"content != null\" > content = #{content,jdbcType=BLOB}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(AlumniOrganization entity);

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
	@Select({ "select * from alumni_organization" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "organiza_name", property = "organizaName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_type", property = "alumniType", jdbcType = JdbcType.INTEGER),
			@Result(column = "infor_id", property = "inforId", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public List<AlumniOrganization> findAll();

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
	@Select({ "select count(id) from alumni_organization" })
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
	@Select({ "select * from alumni_organization where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "organiza_name", property = "organizaName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_type", property = "alumniType", jdbcType = JdbcType.INTEGER),
			@Result(column = "infor_id", property = "inforId", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public AlumniOrganization findById(Serializable id);

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
			+ "select * from alumni_organization "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"organizaName != null\" > and organiza_name = #{organizaName,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"alumniType != null\" > and alumni_type = #{alumniType,jdbcType=INTEGER} </if><if test=\"inforId != null\" > and infor_id = #{inforId,jdbcType=INTEGER} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "organiza_name", property = "organizaName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_type", property = "alumniType", jdbcType = JdbcType.INTEGER),
			@Result(column = "infor_id", property = "inforId", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public List<AlumniOrganization> findList(QueryInterface query);

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
			+ "select count(id) from alumni_organization "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"organizaName != null\" > and organiza_name = #{organizaName,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"alumniType != null\" > and alumni_type = #{alumniType,jdbcType=INTEGER} </if><if test=\"inforId != null\" > and infor_id = #{inforId,jdbcType=INTEGER} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if> "
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
			+ "select * from alumni_organization "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"organizaName != null\" > and organiza_name = #{organizaName,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"alumniType != null\" > and alumni_type = #{alumniType,jdbcType=INTEGER} </if><if test=\"inforId != null\" > and infor_id = #{inforId,jdbcType=INTEGER} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "organiza_name", property = "organizaName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "area", property = "area", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_type", property = "alumniType", jdbcType = JdbcType.INTEGER),
			@Result(column = "infor_id", property = "inforId", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public List<AlumniOrganization> findPaginationDataByCondition(
			QueryInterface query);

}
