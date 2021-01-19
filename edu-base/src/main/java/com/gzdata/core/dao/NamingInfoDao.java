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
import com.gzdata.core.model.NamingInfo;

/**
 * 
 * 说明：冠名信息对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface NamingInfoDao extends BaseDAOInterface<NamingInfo> {

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
	@Insert({ "insert into naming_info ( id,naming_name,naming_img,begin_time,over_time,is_show,is_delete,content,publish_person,click_count,state,create_time,remark)  values (#{id,jdbcType=BIGINT},#{namingName,jdbcType=VARCHAR},#{namingImg,jdbcType=VARCHAR},#{beginTime,jdbcType=DATE},#{overTime,jdbcType=DATE},#{isShow,jdbcType=TINYINT},#{isDelete,jdbcType=TINYINT},#{content,jdbcType=BLOB},#{publishPerson,jdbcType=VARCHAR},#{clickCount,jdbcType=INTEGER},#{state,jdbcType=TINYINT},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(NamingInfo entity);

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
			+ "insert into naming_info "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"namingName != null\" > naming_name, </if> <if test=\"namingImg != null\" > naming_img, </if> <if test=\"beginTime != null\" > begin_time, </if> <if test=\"overTime != null\" > over_time, </if> <if test=\"isShow != null\" > is_show, </if> <if test=\"isDelete != null\" > is_delete, </if> <if test=\"content != null\" > content, </if> <if test=\"publishPerson != null\" > publish_person, </if> <if test=\"clickCount != null\" > click_count, </if> <if test=\"state != null\" > state, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"namingName != null\" > #{namingName,jdbcType=VARCHAR}, </if> <if test=\"namingImg != null\" > #{namingImg,jdbcType=VARCHAR}, </if> <if test=\"beginTime != null\" > #{beginTime,jdbcType=DATE}, </if> <if test=\"overTime != null\" > #{overTime,jdbcType=DATE}, </if> <if test=\"isShow != null\" > #{isShow,jdbcType=TINYINT}, </if> <if test=\"isDelete != null\" > #{isDelete,jdbcType=TINYINT}, </if> <if test=\"content != null\" > #{content,jdbcType=BLOB}, </if> <if test=\"publishPerson != null\" > #{publishPerson,jdbcType=VARCHAR}, </if> <if test=\"clickCount != null\" > #{clickCount,jdbcType=INTEGER}, </if> <if test=\"state != null\" > #{state,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(NamingInfo entity);

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
	@Delete({ "delete from naming_info where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from naming_info where id in "
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
	@Update({ "update naming_info set id= #{id,jdbcType=BIGINT},naming_name= #{namingName,jdbcType=VARCHAR},naming_img= #{namingImg,jdbcType=VARCHAR},begin_time= #{beginTime,jdbcType=DATE},over_time= #{overTime,jdbcType=DATE},is_show= #{isShow,jdbcType=TINYINT},is_delete= #{isDelete,jdbcType=TINYINT},content= #{content,jdbcType=BLOB},publish_person= #{publishPerson,jdbcType=VARCHAR},click_count= #{clickCount,jdbcType=INTEGER},state= #{state,jdbcType=TINYINT},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(NamingInfo entity);

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
			+ "update naming_info "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"namingName != null\" > naming_name = #{namingName,jdbcType=VARCHAR}, </if> <if test=\"namingImg != null\" > naming_img = #{namingImg,jdbcType=VARCHAR}, </if> <if test=\"beginTime != null\" > begin_time = #{beginTime,jdbcType=DATE}, </if> <if test=\"overTime != null\" > over_time = #{overTime,jdbcType=DATE}, </if> <if test=\"isShow != null\" > is_show = #{isShow,jdbcType=TINYINT}, </if> <if test=\"isDelete != null\" > is_delete = #{isDelete,jdbcType=TINYINT}, </if> <if test=\"content != null\" > content = #{content,jdbcType=BLOB}, </if> <if test=\"publishPerson != null\" > publish_person = #{publishPerson,jdbcType=VARCHAR}, </if> <if test=\"clickCount != null\" > click_count = #{clickCount,jdbcType=INTEGER}, </if> <if test=\"state != null\" > state = #{state,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(NamingInfo entity);

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
	@Select({ "select * from naming_info" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "naming_name", property = "namingName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "naming_img", property = "namingImg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "is_show", property = "isShow", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<NamingInfo> findAll();

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
	@Select({ "select count(id) from naming_info" })
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
	@Select({ "select * from naming_info where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "naming_name", property = "namingName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "naming_img", property = "namingImg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "is_show", property = "isShow", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public NamingInfo findById(Serializable id);

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
			+ "select * from naming_info "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"namingName != null\" > and naming_name = #{namingName,jdbcType=VARCHAR} </if><if test=\"namingImg != null\" > and naming_img = #{namingImg,jdbcType=VARCHAR} </if><if test=\"beginTime != null\" > and begin_time = #{beginTime,jdbcType=DATE} </if><if test=\"overTime != null\" > and over_time = #{overTime,jdbcType=DATE} </if><if test=\"isShow != null\" > and is_show = #{isShow,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"publishPerson != null\" > and publish_person = #{publishPerson,jdbcType=VARCHAR} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "naming_name", property = "namingName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "naming_img", property = "namingImg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "is_show", property = "isShow", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<NamingInfo> findList(QueryInterface query);

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
			+ "select count(id) from naming_info "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"namingName != null\" > and naming_name = #{namingName,jdbcType=VARCHAR} </if><if test=\"namingImg != null\" > and naming_img = #{namingImg,jdbcType=VARCHAR} </if><if test=\"beginTime != null\" > and begin_time = #{beginTime,jdbcType=DATE} </if><if test=\"overTime != null\" > and over_time = #{overTime,jdbcType=DATE} </if><if test=\"isShow != null\" > and is_show = #{isShow,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"publishPerson != null\" > and publish_person = #{publishPerson,jdbcType=VARCHAR} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
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
			+ "select * from naming_info "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"namingName != null\" > and naming_name = #{namingName,jdbcType=VARCHAR} </if><if test=\"namingImg != null\" > and naming_img = #{namingImg,jdbcType=VARCHAR} </if><if test=\"beginTime != null\" > and begin_time = #{beginTime,jdbcType=DATE} </if><if test=\"overTime != null\" > and over_time = #{overTime,jdbcType=DATE} </if><if test=\"isShow != null\" > and is_show = #{isShow,jdbcType=TINYINT} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"content != null\" > and content = #{content,jdbcType=BLOB} </if><if test=\"publishPerson != null\" > and publish_person = #{publishPerson,jdbcType=VARCHAR} </if><if test=\"clickCount != null\" > and click_count = #{clickCount,jdbcType=INTEGER} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "naming_name", property = "namingName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "naming_img", property = "namingImg", jdbcType = JdbcType.VARCHAR),
			@Result(column = "begin_time", property = "beginTime", jdbcType = JdbcType.DATE),
			@Result(column = "over_time", property = "overTime", jdbcType = JdbcType.DATE),
			@Result(column = "is_show", property = "isShow", jdbcType = JdbcType.TINYINT),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "content", property = "content", jdbcType = JdbcType.BLOB),
			@Result(column = "publish_person", property = "publishPerson", jdbcType = JdbcType.VARCHAR),
			@Result(column = "click_count", property = "clickCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<NamingInfo> findPaginationDataByCondition(QueryInterface query);

}
