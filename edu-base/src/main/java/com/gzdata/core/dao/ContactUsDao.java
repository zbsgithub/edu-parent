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
import com.gzdata.core.model.ContactUs;

/**
 * 
 * 说明：联系我们对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * 
 * @since 2021年01月15日
 */
public interface ContactUsDao extends BaseDAOInterface<ContactUs> {

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
	@Insert({ "insert into contact_us ( id,content,publish_time,publish_person,click_count)  values (#{id,jdbcType=BIGINT},#{content,jdbcType=BLOB},#{publishTime,jdbcType=TIMESTAMP},#{publishPerson,jdbcType=VARCHAR},#{clickCount,jdbcType=INTEGER})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(ContactUs entity);

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
			+ "insert into contact_us "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"content != null\" > content, </if> <if test=\"publishTime != null\" > publish_time, </if> <if test=\"publishPerson != null\" > publish_person, </if> <if test=\"clickCount != null\" > click_count, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"content != null\" > #{content,jdbcType=BLOB}, </if> <if test=\"publishTime != null\" > #{publishTime,jdbcType=TIMESTAMP}, </if> <if test=\"publishPerson != null\" > #{publishPerson,jdbcType=VARCHAR}, </if> <if test=\"clickCount != null\" > #{clickCount,jdbcType=INTEGER}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(ContactUs entity);

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
	@Delete({ "delete from contact_us where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from contact_us where id in "
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
	@Update({ "update contact_us set id= #{id,jdbcType=BIGINT},content= #{content,jdbcType=BLOB},publish_time= #{publishTime,jdbcType=TIMESTAMP},publish_person= #{publishPerson,jdbcType=VARCHAR},click_count= #{clickCount,jdbcType=INTEGER} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(ContactUs entity);

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
			+ "update contact_us "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"content != null\" > content = #{content,jdbcType=BLOB}, </if> <if test=\"publishTime != null\" > publish_time = #{publishTime,jdbcType=TIMESTAMP}, </if> <if test=\"publishPerson != null\" > publish_person = #{publishPerson,jdbcType=VARCHAR}, </if> <if test=\"clickCount != null\" > click_count = #{clickCount,jdbcType=INTEGER}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(ContactUs entity);

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
	@Select({ "select * from contact_us" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER) })
	@Override
	public List<ContactUs> findAll();

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
	@Select({ "select count(id) from contact_us" })
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
	@Select({ "select * from contact_us where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER) })
	@Override
	public ContactUs findById(Serializable id);

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
			+ "select * from contact_us "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"publishPerson != null\" > and publish_person = #{publishPerson,jdbcType=VARCHAR} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER) })
	@Override
	public List<ContactUs> findList(QueryInterface query);

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
			+ "select count(id) from contact_us "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"publishPerson != null\" > and publish_person = #{publishPerson,jdbcType=VARCHAR} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if> "
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
			+ "select * from contact_us "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"publishPerson != null\" > and publish_person = #{publishPerson,jdbcType=VARCHAR} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER) })
	@Override
	public List<ContactUs> findPaginationDataByCondition(QueryInterface query);

}
