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
import com.gzdata.core.model.NamingRecord;

/**
 * 
 * 说明：冠名记录对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface NamingRecordDao extends BaseDAOInterface<NamingRecord> {

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
	@Insert({ "insert into naming_record ( id,donors,donation_time,money,naming_id,naming_userid,remark,pay_state)  values (#{id,jdbcType=BIGINT},#{donors,jdbcType=VARCHAR},#{donationTime,jdbcType=TIMESTAMP},#{money,jdbcType=DECIMAL},#{namingId,jdbcType=INTEGER},#{namingUserid,jdbcType=INTEGER},#{remark,jdbcType=VARCHAR},#{payState,jdbcType=TINYINT})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(NamingRecord entity);

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
			+ "insert into naming_record "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"donors != null\" > donors, </if> <if test=\"donationTime != null\" > donation_time, </if> <if test=\"money != null\" > money, </if> <if test=\"namingId != null\" > naming_id, </if> <if test=\"namingUserid != null\" > naming_userid, </if> <if test=\"remark != null\" > remark, </if> <if test=\"payState != null\" > pay_state, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"donors != null\" > #{donors,jdbcType=VARCHAR}, </if> <if test=\"donationTime != null\" > #{donationTime,jdbcType=TIMESTAMP}, </if> <if test=\"money != null\" > #{money,jdbcType=DECIMAL}, </if> <if test=\"namingId != null\" > #{namingId,jdbcType=INTEGER}, </if> <if test=\"namingUserid != null\" > #{namingUserid,jdbcType=INTEGER}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"payState != null\" > #{payState,jdbcType=TINYINT}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(NamingRecord entity);

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
	@Delete({ "delete from naming_record where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from naming_record where id in "
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
	@Update({ "update naming_record set id= #{id,jdbcType=BIGINT},donors= #{donors,jdbcType=VARCHAR},donation_time= #{donationTime,jdbcType=TIMESTAMP},money= #{money,jdbcType=DECIMAL},naming_id= #{namingId,jdbcType=INTEGER},naming_userid= #{namingUserid,jdbcType=INTEGER},remark= #{remark,jdbcType=VARCHAR},pay_state= #{payState,jdbcType=TINYINT} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(NamingRecord entity);

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
			+ "update naming_record "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"donors != null\" > donors = #{donors,jdbcType=VARCHAR}, </if> <if test=\"donationTime != null\" > donation_time = #{donationTime,jdbcType=TIMESTAMP}, </if> <if test=\"money != null\" > money = #{money,jdbcType=DECIMAL}, </if> <if test=\"namingId != null\" > naming_id = #{namingId,jdbcType=INTEGER}, </if> <if test=\"namingUserid != null\" > naming_userid = #{namingUserid,jdbcType=INTEGER}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"payState != null\" > pay_state = #{payState,jdbcType=TINYINT}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(NamingRecord entity);

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
	@Select({ "select * from naming_record" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "donors", property = "donors", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "money", property = "money", jdbcType = JdbcType.DECIMAL),
			@Result(column = "naming_id", property = "namingId", jdbcType = JdbcType.INTEGER),
			@Result(column = "naming_userid", property = "namingUserid", jdbcType = JdbcType.INTEGER),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_state", property = "payState", jdbcType = JdbcType.TINYINT) })
	@Override
	public List<NamingRecord> findAll();

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
	@Select({ "select count(id) from naming_record" })
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
	@Select({ "select * from naming_record where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "donors", property = "donors", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "money", property = "money", jdbcType = JdbcType.DECIMAL),
			@Result(column = "naming_id", property = "namingId", jdbcType = JdbcType.INTEGER),
			@Result(column = "naming_userid", property = "namingUserid", jdbcType = JdbcType.INTEGER),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_state", property = "payState", jdbcType = JdbcType.TINYINT) })
	@Override
	public NamingRecord findById(Serializable id);

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
			+ "select * from naming_record "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"donors != null\" > and donors = #{donors,jdbcType=VARCHAR} </if><if test=\"donationTime != null\" > and donation_time = #{donationTime,jdbcType=TIMESTAMP} </if><if test=\"money != null\" > and money = #{money,jdbcType=DECIMAL} </if><if test=\"namingId != null\" > and naming_id = #{namingId,jdbcType=INTEGER} </if><if test=\"namingUserid != null\" > and naming_userid = #{namingUserid,jdbcType=INTEGER} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"payState != null\" > and pay_state = #{payState,jdbcType=TINYINT} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "donors", property = "donors", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "money", property = "money", jdbcType = JdbcType.DECIMAL),
			@Result(column = "naming_id", property = "namingId", jdbcType = JdbcType.INTEGER),
			@Result(column = "naming_userid", property = "namingUserid", jdbcType = JdbcType.INTEGER),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_state", property = "payState", jdbcType = JdbcType.TINYINT) })
	@Override
	public List<NamingRecord> findList(QueryInterface query);

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
			+ "select count(id) from naming_record "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"donors != null\" > and donors = #{donors,jdbcType=VARCHAR} </if><if test=\"donationTime != null\" > and donation_time = #{donationTime,jdbcType=TIMESTAMP} </if><if test=\"money != null\" > and money = #{money,jdbcType=DECIMAL} </if><if test=\"namingId != null\" > and naming_id = #{namingId,jdbcType=INTEGER} </if><if test=\"namingUserid != null\" > and naming_userid = #{namingUserid,jdbcType=INTEGER} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"payState != null\" > and pay_state = #{payState,jdbcType=TINYINT} </if> "
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
			+ "select * from naming_record "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"donors != null\" > and donors = #{donors,jdbcType=VARCHAR} </if><if test=\"donationTime != null\" > and donation_time = #{donationTime,jdbcType=TIMESTAMP} </if><if test=\"money != null\" > and money = #{money,jdbcType=DECIMAL} </if><if test=\"namingId != null\" > and naming_id = #{namingId,jdbcType=INTEGER} </if><if test=\"namingUserid != null\" > and naming_userid = #{namingUserid,jdbcType=INTEGER} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"payState != null\" > and pay_state = #{payState,jdbcType=TINYINT} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "donors", property = "donors", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "money", property = "money", jdbcType = JdbcType.DECIMAL),
			@Result(column = "naming_id", property = "namingId", jdbcType = JdbcType.INTEGER),
			@Result(column = "naming_userid", property = "namingUserid", jdbcType = JdbcType.INTEGER),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_state", property = "payState", jdbcType = JdbcType.TINYINT) })
	@Override
	public List<NamingRecord> findPaginationDataByCondition(QueryInterface query);

}
