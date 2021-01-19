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
import com.gzdata.core.model.CashDonation;

/**
 * 
 * 说明：现金捐赠对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface CashDonationDao extends BaseDAOInterface<CashDonation> {

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
	@Insert({ "insert into cash_donation ( id,full_name,phone,donation_method,donation_money,donation_time,message,is_anonymous,pay_status,serial_number)  values (#{id,jdbcType=BIGINT},#{fullName,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},#{donationMethod,jdbcType=INTEGER},#{donationMoney,jdbcType=DECIMAL},#{donationTime,jdbcType=TIMESTAMP},#{message,jdbcType=VARCHAR},#{isAnonymous,jdbcType=INTEGER},#{payStatus,jdbcType=INTEGER},#{serialNumber,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(CashDonation entity);

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
			+ "insert into cash_donation "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"fullName != null\" > full_name, </if> <if test=\"phone != null\" > phone, </if> <if test=\"donationMethod != null\" > donation_method, </if> <if test=\"donationMoney != null\" > donation_money, </if> <if test=\"donationTime != null\" > donation_time, </if> <if test=\"message != null\" > message, </if> <if test=\"isAnonymous != null\" > is_anonymous, </if> <if test=\"payStatus != null\" > pay_status, </if> <if test=\"serialNumber != null\" > serial_number, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"fullName != null\" > #{fullName,jdbcType=VARCHAR}, </if> <if test=\"phone != null\" > #{phone,jdbcType=VARCHAR}, </if> <if test=\"donationMethod != null\" > #{donationMethod,jdbcType=INTEGER}, </if> <if test=\"donationMoney != null\" > #{donationMoney,jdbcType=DECIMAL}, </if> <if test=\"donationTime != null\" > #{donationTime,jdbcType=TIMESTAMP}, </if> <if test=\"message != null\" > #{message,jdbcType=VARCHAR}, </if> <if test=\"isAnonymous != null\" > #{isAnonymous,jdbcType=INTEGER}, </if> <if test=\"payStatus != null\" > #{payStatus,jdbcType=INTEGER}, </if> <if test=\"serialNumber != null\" > #{serialNumber,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(CashDonation entity);

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
	@Delete({ "delete from cash_donation where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from cash_donation where id in "
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
	@Update({ "update cash_donation set id= #{id,jdbcType=BIGINT},full_name= #{fullName,jdbcType=VARCHAR},phone= #{phone,jdbcType=VARCHAR},donation_method= #{donationMethod,jdbcType=INTEGER},donation_money= #{donationMoney,jdbcType=DECIMAL},donation_time= #{donationTime,jdbcType=TIMESTAMP},message= #{message,jdbcType=VARCHAR},is_anonymous= #{isAnonymous,jdbcType=INTEGER},pay_status= #{payStatus,jdbcType=INTEGER},serial_number= #{serialNumber,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(CashDonation entity);

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
			+ "update cash_donation "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"fullName != null\" > full_name = #{fullName,jdbcType=VARCHAR}, </if> <if test=\"phone != null\" > phone = #{phone,jdbcType=VARCHAR}, </if> <if test=\"donationMethod != null\" > donation_method = #{donationMethod,jdbcType=INTEGER}, </if> <if test=\"donationMoney != null\" > donation_money = #{donationMoney,jdbcType=DECIMAL}, </if> <if test=\"donationTime != null\" > donation_time = #{donationTime,jdbcType=TIMESTAMP}, </if> <if test=\"message != null\" > message = #{message,jdbcType=VARCHAR}, </if> <if test=\"isAnonymous != null\" > is_anonymous = #{isAnonymous,jdbcType=INTEGER}, </if> <if test=\"payStatus != null\" > pay_status = #{payStatus,jdbcType=INTEGER}, </if> <if test=\"serialNumber != null\" > serial_number = #{serialNumber,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(CashDonation entity);

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
	@Select({ "select * from cash_donation" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_method", property = "donationMethod", jdbcType = JdbcType.INTEGER),
			@Result(column = "donation_money", property = "donationMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "message", property = "message", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_anonymous", property = "isAnonymous", jdbcType = JdbcType.INTEGER),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<CashDonation> findAll();

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
	@Select({ "select count(id) from cash_donation" })
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
	@Select({ "select * from cash_donation where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_method", property = "donationMethod", jdbcType = JdbcType.INTEGER),
			@Result(column = "donation_money", property = "donationMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "message", property = "message", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_anonymous", property = "isAnonymous", jdbcType = JdbcType.INTEGER),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR) })
	@Override
	public CashDonation findById(Serializable id);

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
			+ "select * from cash_donation "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"donationMethod != null\" > and donation_method = #{donationMethod,jdbcType=INTEGER} </if><if test=\"donationMoney != null\" > and donation_money = #{donationMoney,jdbcType=DECIMAL} </if><if test=\"donationTime != null\" > and donation_time = #{donationTime,jdbcType=TIMESTAMP} </if><if test=\"message != null\" > and message = #{message,jdbcType=VARCHAR} </if><if test=\"isAnonymous != null\" > and is_anonymous = #{isAnonymous,jdbcType=INTEGER} </if><if test=\"payStatus != null\" > and pay_status = #{payStatus,jdbcType=INTEGER} </if><if test=\"serialNumber != null\" > and serial_number = #{serialNumber,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_method", property = "donationMethod", jdbcType = JdbcType.INTEGER),
			@Result(column = "donation_money", property = "donationMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "message", property = "message", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_anonymous", property = "isAnonymous", jdbcType = JdbcType.INTEGER),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<CashDonation> findList(QueryInterface query);

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
			+ "select count(id) from cash_donation "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"donationMethod != null\" > and donation_method = #{donationMethod,jdbcType=INTEGER} </if><if test=\"donationMoney != null\" > and donation_money = #{donationMoney,jdbcType=DECIMAL} </if><if test=\"donationTime != null\" > and donation_time = #{donationTime,jdbcType=TIMESTAMP} </if><if test=\"message != null\" > and message = #{message,jdbcType=VARCHAR} </if><if test=\"isAnonymous != null\" > and is_anonymous = #{isAnonymous,jdbcType=INTEGER} </if><if test=\"payStatus != null\" > and pay_status = #{payStatus,jdbcType=INTEGER} </if><if test=\"serialNumber != null\" > and serial_number = #{serialNumber,jdbcType=VARCHAR} </if> "
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
			+ "select * from cash_donation "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"donationMethod != null\" > and donation_method = #{donationMethod,jdbcType=INTEGER} </if><if test=\"donationMoney != null\" > and donation_money = #{donationMoney,jdbcType=DECIMAL} </if><if test=\"donationTime != null\" > and donation_time = #{donationTime,jdbcType=TIMESTAMP} </if><if test=\"message != null\" > and message = #{message,jdbcType=VARCHAR} </if><if test=\"isAnonymous != null\" > and is_anonymous = #{isAnonymous,jdbcType=INTEGER} </if><if test=\"payStatus != null\" > and pay_status = #{payStatus,jdbcType=INTEGER} </if><if test=\"serialNumber != null\" > and serial_number = #{serialNumber,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "donation_method", property = "donationMethod", jdbcType = JdbcType.INTEGER),
			@Result(column = "donation_money", property = "donationMoney", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_time", property = "donationTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "message", property = "message", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_anonymous", property = "isAnonymous", jdbcType = JdbcType.INTEGER),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<CashDonation> findPaginationDataByCondition(QueryInterface query);

}
