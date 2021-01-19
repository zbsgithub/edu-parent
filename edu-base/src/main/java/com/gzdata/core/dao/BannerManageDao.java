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
import com.gzdata.core.model.BannerManage;

/**
 * 
 * 说明：对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface BannerManageDao extends BaseDAOInterface<BannerManage> {

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
	@Insert({ "insert into banner_manage ( id,title,banner_type,publish_time,state,cover_address,content)  values (#{id,jdbcType=BIGINT},#{title,jdbcType=VARCHAR},#{bannerType,jdbcType=TINYINT},#{publishTime,jdbcType=TIMESTAMP},#{state,jdbcType=TINYINT},#{coverAddress,jdbcType=VARCHAR},#{content,jdbcType=BLOB})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(BannerManage entity);

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
			+ "insert into banner_manage "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"title != null\" > title, </if> <if test=\"bannerType != null\" > banner_type, </if> <if test=\"publishTime != null\" > publish_time, </if> <if test=\"state != null\" > state, </if> <if test=\"coverAddress != null\" > cover_address, </if> <if test=\"content != null\" > content, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"title != null\" > #{title,jdbcType=VARCHAR}, </if> <if test=\"bannerType != null\" > #{bannerType,jdbcType=TINYINT}, </if> <if test=\"publishTime != null\" > #{publishTime,jdbcType=TIMESTAMP}, </if> <if test=\"state != null\" > #{state,jdbcType=TINYINT}, </if> <if test=\"coverAddress != null\" > #{coverAddress,jdbcType=VARCHAR}, </if> <if test=\"content != null\" > #{content,jdbcType=BLOB}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(BannerManage entity);

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
	@Delete({ "delete from banner_manage where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from banner_manage where id in "
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
	@Update({ "update banner_manage set id= #{id,jdbcType=BIGINT},title= #{title,jdbcType=VARCHAR},banner_type= #{bannerType,jdbcType=TINYINT},publish_time= #{publishTime,jdbcType=TIMESTAMP},state= #{state,jdbcType=TINYINT},cover_address= #{coverAddress,jdbcType=VARCHAR},content= #{content,jdbcType=BLOB} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(BannerManage entity);

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
			+ "update banner_manage "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"title != null\" > title = #{title,jdbcType=VARCHAR}, </if> <if test=\"bannerType != null\" > banner_type = #{bannerType,jdbcType=TINYINT}, </if> <if test=\"publishTime != null\" > publish_time = #{publishTime,jdbcType=TIMESTAMP}, </if> <if test=\"state != null\" > state = #{state,jdbcType=TINYINT}, </if> <if test=\"coverAddress != null\" > cover_address = #{coverAddress,jdbcType=VARCHAR}, </if> <if test=\"content != null\" > content = #{content,jdbcType=BLOB}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(BannerManage entity);

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
	@Select({ "select * from banner_manage" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "banner_type", property = "bannerType", jdbcType = JdbcType.TINYINT),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public List<BannerManage> findAll();

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
	@Select({ "select count(id) from banner_manage" })
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
	@Select({ "select * from banner_manage where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "banner_type", property = "bannerType", jdbcType = JdbcType.TINYINT),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public BannerManage findById(Serializable id);

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
			+ "select * from banner_manage "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"title != null\" > and title = #{title,jdbcType=VARCHAR} </if><if test=\"bannerType != null\" > and banner_type = #{bannerType,jdbcType=TINYINT} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"coverAddress != null\" > and cover_address = #{coverAddress,jdbcType=VARCHAR} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "banner_type", property = "bannerType", jdbcType = JdbcType.TINYINT),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public List<BannerManage> findList(QueryInterface query);

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
			+ "select count(id) from banner_manage "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"title != null\" > and title = #{title,jdbcType=VARCHAR} </if><if test=\"bannerType != null\" > and banner_type = #{bannerType,jdbcType=TINYINT} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"coverAddress != null\" > and cover_address = #{coverAddress,jdbcType=VARCHAR} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if> "
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
			+ "select * from banner_manage "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"title != null\" > and title = #{title,jdbcType=VARCHAR} </if><if test=\"bannerType != null\" > and banner_type = #{bannerType,jdbcType=TINYINT} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"coverAddress != null\" > and cover_address = #{coverAddress,jdbcType=VARCHAR} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "banner_type", property = "bannerType", jdbcType = JdbcType.TINYINT),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB) })
	@Override
	public List<BannerManage> findPaginationDataByCondition(QueryInterface query);

}
