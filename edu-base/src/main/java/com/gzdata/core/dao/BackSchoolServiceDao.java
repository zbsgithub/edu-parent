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
import com.gzdata.core.model.BackSchoolService;

/**
 * 
 * 说明：返校服务对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface BackSchoolServiceDao extends
		BaseDAOInterface<BackSchoolService> {

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
	@Insert({ "insert into back_school_service ( id,back_time,back_people_count,dining_situation,dining_time,reservation,other_service,create_time,remark,user_id)  values (#{id,jdbcType=BIGINT},#{backTime,jdbcType=DATE},#{backPeopleCount,jdbcType=INTEGER},#{diningSituation,jdbcType=INTEGER},#{diningTime,jdbcType=TIMESTAMP},#{reservation,jdbcType=INTEGER},#{otherService,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR},#{userId,jdbcType=INTEGER})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(BackSchoolService entity);

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
			+ "insert into back_school_service "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"backTime != null\" > back_time, </if> <if test=\"backPeopleCount != null\" > back_people_count, </if> <if test=\"diningSituation != null\" > dining_situation, </if> <if test=\"diningTime != null\" > dining_time, </if> <if test=\"reservation != null\" > reservation, </if> <if test=\"otherService != null\" > other_service, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if> <if test=\"userId != null\" > user_id, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"backTime != null\" > #{backTime,jdbcType=DATE}, </if> <if test=\"backPeopleCount != null\" > #{backPeopleCount,jdbcType=INTEGER}, </if> <if test=\"diningSituation != null\" > #{diningSituation,jdbcType=INTEGER}, </if> <if test=\"diningTime != null\" > #{diningTime,jdbcType=TIMESTAMP}, </if> <if test=\"reservation != null\" > #{reservation,jdbcType=INTEGER}, </if> <if test=\"otherService != null\" > #{otherService,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(BackSchoolService entity);

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
	@Delete({ "delete from back_school_service where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from back_school_service where id in "
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
	@Update({ "update back_school_service set id= #{id,jdbcType=BIGINT},back_time= #{backTime,jdbcType=DATE},back_people_count= #{backPeopleCount,jdbcType=INTEGER},dining_situation= #{diningSituation,jdbcType=INTEGER},dining_time= #{diningTime,jdbcType=TIMESTAMP},reservation= #{reservation,jdbcType=INTEGER},other_service= #{otherService,jdbcType=VARCHAR},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR},user_id= #{userId,jdbcType=INTEGER} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(BackSchoolService entity);

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
			+ "update back_school_service "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"backTime != null\" > back_time = #{backTime,jdbcType=DATE}, </if> <if test=\"backPeopleCount != null\" > back_people_count = #{backPeopleCount,jdbcType=INTEGER}, </if> <if test=\"diningSituation != null\" > dining_situation = #{diningSituation,jdbcType=INTEGER}, </if> <if test=\"diningTime != null\" > dining_time = #{diningTime,jdbcType=TIMESTAMP}, </if> <if test=\"reservation != null\" > reservation = #{reservation,jdbcType=INTEGER}, </if> <if test=\"otherService != null\" > other_service = #{otherService,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(BackSchoolService entity);

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
	@Select({ "select * from back_school_service" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "back_time", property = "backTime", jdbcType = JdbcType.DATE),
			@Result(column = "back_people_count", property = "backPeopleCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_situation", property = "diningSituation", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_time", property = "diningTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "reservation", property = "reservation", jdbcType = JdbcType.INTEGER),
			@Result(column = "other_service", property = "otherService", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER) })
	@Override
	public List<BackSchoolService> findAll();

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
	@Select({ "select count(id) from back_school_service" })
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
	@Select({ "select * from back_school_service where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "back_time", property = "backTime", jdbcType = JdbcType.DATE),
			@Result(column = "back_people_count", property = "backPeopleCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_situation", property = "diningSituation", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_time", property = "diningTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "reservation", property = "reservation", jdbcType = JdbcType.INTEGER),
			@Result(column = "other_service", property = "otherService", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER) })
	@Override
	public BackSchoolService findById(Serializable id);

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
			+ "select * from back_school_service "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"backTime != null\" > and back_time = #{backTime,jdbcType=DATE} </if><if test=\"backPeopleCount != null\" > and back_people_count = #{backPeopleCount,jdbcType=INTEGER} </if><if test=\"diningSituation != null\" > and dining_situation = #{diningSituation,jdbcType=INTEGER} </if><if test=\"diningTime != null\" > and dining_time = #{diningTime,jdbcType=TIMESTAMP} </if><if test=\"reservation != null\" > and reservation = #{reservation,jdbcType=INTEGER} </if><if test=\"otherService != null\" > and other_service = #{otherService,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "back_time", property = "backTime", jdbcType = JdbcType.DATE),
			@Result(column = "back_people_count", property = "backPeopleCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_situation", property = "diningSituation", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_time", property = "diningTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "reservation", property = "reservation", jdbcType = JdbcType.INTEGER),
			@Result(column = "other_service", property = "otherService", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER) })
	@Override
	public List<BackSchoolService> findList(QueryInterface query);

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
			+ "select count(id) from back_school_service "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"backTime != null\" > and back_time = #{backTime,jdbcType=DATE} </if><if test=\"backPeopleCount != null\" > and back_people_count = #{backPeopleCount,jdbcType=INTEGER} </if><if test=\"diningSituation != null\" > and dining_situation = #{diningSituation,jdbcType=INTEGER} </if><if test=\"diningTime != null\" > and dining_time = #{diningTime,jdbcType=TIMESTAMP} </if><if test=\"reservation != null\" > and reservation = #{reservation,jdbcType=INTEGER} </if><if test=\"otherService != null\" > and other_service = #{otherService,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if> "
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
			+ "select * from back_school_service "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"backTime != null\" > and back_time = #{backTime,jdbcType=DATE} </if><if test=\"backPeopleCount != null\" > and back_people_count = #{backPeopleCount,jdbcType=INTEGER} </if><if test=\"diningSituation != null\" > and dining_situation = #{diningSituation,jdbcType=INTEGER} </if><if test=\"diningTime != null\" > and dining_time = #{diningTime,jdbcType=TIMESTAMP} </if><if test=\"reservation != null\" > and reservation = #{reservation,jdbcType=INTEGER} </if><if test=\"otherService != null\" > and other_service = #{otherService,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "back_time", property = "backTime", jdbcType = JdbcType.DATE),
			@Result(column = "back_people_count", property = "backPeopleCount", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_situation", property = "diningSituation", jdbcType = JdbcType.INTEGER),
			@Result(column = "dining_time", property = "diningTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "reservation", property = "reservation", jdbcType = JdbcType.INTEGER),
			@Result(column = "other_service", property = "otherService", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER) })
	@Override
	public List<BackSchoolService> findPaginationDataByCondition(
			QueryInterface query);

}
