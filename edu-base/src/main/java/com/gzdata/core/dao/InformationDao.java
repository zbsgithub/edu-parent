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
import com.gzdata.core.model.Information;

/**
 * 
 * 说明：资讯信息表对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface InformationDao extends BaseDAOInterface<Information> {

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
	@Insert({ "insert into information ( id,title,author,publish_time,click_count,content,is_have,cover_address,is_top,infor_type,is_delete,state,create_time,remark)  values (#{id,jdbcType=BIGINT},#{title,jdbcType=VARCHAR},#{author,jdbcType=VARCHAR},#{publishTime,jdbcType=TIMESTAMP},#{clickCount,jdbcType=INTEGER},#{content,jdbcType=BLOB},#{isHave,jdbcType=INTEGER},#{coverAddress,jdbcType=VARCHAR},#{isTop,jdbcType=VARCHAR},#{inforType,jdbcType=TINYINT},#{isDelete,jdbcType=TINYINT},#{state,jdbcType=TINYINT},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(Information entity);

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
			+ "insert into information "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"title != null\" > title, </if> <if test=\"author != null\" > author, </if> <if test=\"publishTime != null\" > publish_time, </if> <if test=\"clickCount != null\" > click_count, </if> <if test=\"content != null\" > content, </if> <if test=\"isHave != null\" > is_have, </if> <if test=\"coverAddress != null\" > cover_address, </if> <if test=\"isTop != null\" > is_top, </if> <if test=\"inforType != null\" > infor_type, </if> <if test=\"isDelete != null\" > is_delete, </if> <if test=\"state != null\" > state, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"title != null\" > #{title,jdbcType=VARCHAR}, </if> <if test=\"author != null\" > #{author,jdbcType=VARCHAR}, </if> <if test=\"publishTime != null\" > #{publishTime,jdbcType=TIMESTAMP}, </if> <if test=\"clickCount != null\" > #{clickCount,jdbcType=INTEGER}, </if> <if test=\"content != null\" > #{content,jdbcType=BLOB}, </if> <if test=\"isHave != null\" > #{isHave,jdbcType=INTEGER}, </if> <if test=\"coverAddress != null\" > #{coverAddress,jdbcType=VARCHAR}, </if> <if test=\"isTop != null\" > #{isTop,jdbcType=VARCHAR}, </if> <if test=\"inforType != null\" > #{inforType,jdbcType=TINYINT}, </if> <if test=\"isDelete != null\" > #{isDelete,jdbcType=TINYINT}, </if> <if test=\"state != null\" > #{state,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(Information entity);

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
	@Delete({ "delete from information where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from information where id in "
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
	@Update({ "update information set id= #{id,jdbcType=BIGINT},title= #{title,jdbcType=VARCHAR},author= #{author,jdbcType=VARCHAR},publish_time= #{publishTime,jdbcType=TIMESTAMP},click_count= #{clickCount,jdbcType=INTEGER},content= #{content,jdbcType=BLOB},is_have= #{isHave,jdbcType=INTEGER},cover_address= #{coverAddress,jdbcType=VARCHAR},is_top= #{isTop,jdbcType=VARCHAR},infor_type= #{inforType,jdbcType=TINYINT},is_delete= #{isDelete,jdbcType=TINYINT},state= #{state,jdbcType=TINYINT},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(Information entity);

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
			+ "update information "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"title != null\" > title = #{title,jdbcType=VARCHAR}, </if> <if test=\"author != null\" > author = #{author,jdbcType=VARCHAR}, </if> <if test=\"publishTime != null\" > publish_time = #{publishTime,jdbcType=TIMESTAMP}, </if> <if test=\"clickCount != null\" > click_count = #{clickCount,jdbcType=INTEGER}, </if> <if test=\"content != null\" > content = #{content,jdbcType=BLOB}, </if> <if test=\"isHave != null\" > is_have = #{isHave,jdbcType=INTEGER}, </if> <if test=\"coverAddress != null\" > cover_address = #{coverAddress,jdbcType=VARCHAR}, </if> <if test=\"isTop != null\" > is_top = #{isTop,jdbcType=VARCHAR}, </if> <if test=\"inforType != null\" > infor_type = #{inforType,jdbcType=TINYINT}, </if> <if test=\"isDelete != null\" > is_delete = #{isDelete,jdbcType=TINYINT}, </if> <if test=\"state != null\" > state = #{state,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(Information entity);

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
	@Select({ "select * from information" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "is_have", property = "isHave", jdbcType = JdbcType.INTEGER),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_top", property = "isTop", jdbcType = JdbcType.VARCHAR),
			@Result(column = "infor_type", property = "inforType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<Information> findAll();

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
	@Select({ "select count(id) from information" })
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
	@Select({ "select * from information where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "is_have", property = "isHave", jdbcType = JdbcType.INTEGER),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_top", property = "isTop", jdbcType = JdbcType.VARCHAR),
			@Result(column = "infor_type", property = "inforType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public Information findById(Serializable id);

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
			+ "select * from information "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"title != null\" > and title = #{title,jdbcType=VARCHAR} </if><if test=\"author != null\" > and author = #{author,jdbcType=VARCHAR} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"isHave != null\" > and is_have = #{isHave,jdbcType=INTEGER} </if><if test=\"coverAddress != null\" > and cover_address = #{coverAddress,jdbcType=VARCHAR} </if><if test=\"isTop != null\" > and is_top = #{isTop,jdbcType=VARCHAR} </if><if test=\"inforType != null\" > and infor_type = #{inforType,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "is_have", property = "isHave", jdbcType = JdbcType.INTEGER),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_top", property = "isTop", jdbcType = JdbcType.VARCHAR),
			@Result(column = "infor_type", property = "inforType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<Information> findList(QueryInterface query);

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
			+ "select count(id) from information "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"title != null\" > and title = #{title,jdbcType=VARCHAR} </if><if test=\"author != null\" > and author = #{author,jdbcType=VARCHAR} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"isHave != null\" > and is_have = #{isHave,jdbcType=INTEGER} </if><if test=\"coverAddress != null\" > and cover_address = #{coverAddress,jdbcType=VARCHAR} </if><if test=\"isTop != null\" > and is_top = #{isTop,jdbcType=VARCHAR} </if><if test=\"inforType != null\" > and infor_type = #{inforType,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
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
			+ "select * from information "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"title != null\" > and title = #{title,jdbcType=VARCHAR} </if><if test=\"author != null\" > and author = #{author,jdbcType=VARCHAR} </if><if test=\"publishTime != null\" > and publish_time = #{publishTime,jdbcType=TIMESTAMP} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"isHave != null\" > and is_have = #{isHave,jdbcType=INTEGER} </if><if test=\"coverAddress != null\" > and cover_address = #{coverAddress,jdbcType=VARCHAR} </if><if test=\"isTop != null\" > and is_top = #{isTop,jdbcType=VARCHAR} </if><if test=\"inforType != null\" > and infor_type = #{inforType,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "title", property = "title", jdbcType = JdbcType.VARCHAR),
			@Result(column = "author", property = "author", jdbcType = JdbcType.VARCHAR),
			@Result(column = "publish_time", property = "publishTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "is_have", property = "isHave", jdbcType = JdbcType.INTEGER),
			@Result(column = "cover_address", property = "coverAddress", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_top", property = "isTop", jdbcType = JdbcType.VARCHAR),
			@Result(column = "infor_type", property = "inforType", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<Information> findPaginationDataByCondition(QueryInterface query);

}
