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
import com.gzdata.core.model.PurchaseHistory;

/**
 * 
 * 说明：已购代捐-购买历史对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface PurchaseHistoryDao extends BaseDAOInterface<PurchaseHistory> {

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
	@Insert({ "insert into purchase_history ( id,shop_id,user_id,address_id,serial_number,pay_status,buy_time,remark,delivery_status,create_time)  values (#{id,jdbcType=BIGINT},#{shopId,jdbcType=VARCHAR},#{userId,jdbcType=INTEGER},#{addressId,jdbcType=INTEGER},#{serialNumber,jdbcType=VARCHAR},#{payStatus,jdbcType=INTEGER},#{buyTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR},#{deliveryStatus,jdbcType=TINYINT},#{createTime,jdbcType=TIMESTAMP})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(PurchaseHistory entity);

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
			+ "insert into purchase_history "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"shopId != null\" > shop_id, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"addressId != null\" > address_id, </if> <if test=\"serialNumber != null\" > serial_number, </if> <if test=\"payStatus != null\" > pay_status, </if> <if test=\"buyTime != null\" > buy_time, </if> <if test=\"remark != null\" > remark, </if> <if test=\"deliveryStatus != null\" > delivery_status, </if> <if test=\"createTime != null\" > create_time, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"shopId != null\" > #{shopId,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> <if test=\"addressId != null\" > #{addressId,jdbcType=INTEGER}, </if> <if test=\"serialNumber != null\" > #{serialNumber,jdbcType=VARCHAR}, </if> <if test=\"payStatus != null\" > #{payStatus,jdbcType=INTEGER}, </if> <if test=\"buyTime != null\" > #{buyTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"deliveryStatus != null\" > #{deliveryStatus,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(PurchaseHistory entity);

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
	@Delete({ "delete from purchase_history where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from purchase_history where id in "
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
	@Update({ "update purchase_history set id= #{id,jdbcType=BIGINT},shop_id= #{shopId,jdbcType=VARCHAR},user_id= #{userId,jdbcType=INTEGER},address_id= #{addressId,jdbcType=INTEGER},serial_number= #{serialNumber,jdbcType=VARCHAR},pay_status= #{payStatus,jdbcType=INTEGER},buy_time= #{buyTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR},delivery_status= #{deliveryStatus,jdbcType=TINYINT},create_time= #{createTime,jdbcType=TIMESTAMP} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(PurchaseHistory entity);

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
			+ "update purchase_history "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"shopId != null\" > shop_id = #{shopId,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if> <if test=\"addressId != null\" > address_id = #{addressId,jdbcType=INTEGER}, </if> <if test=\"serialNumber != null\" > serial_number = #{serialNumber,jdbcType=VARCHAR}, </if> <if test=\"payStatus != null\" > pay_status = #{payStatus,jdbcType=INTEGER}, </if> <if test=\"buyTime != null\" > buy_time = #{buyTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"deliveryStatus != null\" > delivery_status = #{deliveryStatus,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(PurchaseHistory entity);

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
	@Select({ "select * from purchase_history" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "buy_time", property = "buyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "delivery_status", property = "deliveryStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<PurchaseHistory> findAll();

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
	@Select({ "select count(id) from purchase_history" })
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
	@Select({ "select * from purchase_history where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "buy_time", property = "buyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "delivery_status", property = "deliveryStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public PurchaseHistory findById(Serializable id);

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
			+ "select * from purchase_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"shopId != null\" > and shop_id = #{shopId,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=INTEGER} </if><if test=\"serialNumber != null\" > and serial_number = #{serialNumber,jdbcType=VARCHAR} </if><if test=\"payStatus != null\" > and pay_status = #{payStatus,jdbcType=INTEGER} </if><if test=\"buyTime != null\" > and buy_time = #{buyTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"deliveryStatus != null\" > and delivery_status = #{deliveryStatus,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "buy_time", property = "buyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "delivery_status", property = "deliveryStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<PurchaseHistory> findList(QueryInterface query);

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
			+ "select count(id) from purchase_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"shopId != null\" > and shop_id = #{shopId,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=INTEGER} </if><if test=\"serialNumber != null\" > and serial_number = #{serialNumber,jdbcType=VARCHAR} </if><if test=\"payStatus != null\" > and pay_status = #{payStatus,jdbcType=INTEGER} </if><if test=\"buyTime != null\" > and buy_time = #{buyTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"deliveryStatus != null\" > and delivery_status = #{deliveryStatus,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
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
			+ "select * from purchase_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"shopId != null\" > and shop_id = #{shopId,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=INTEGER} </if><if test=\"serialNumber != null\" > and serial_number = #{serialNumber,jdbcType=VARCHAR} </if><if test=\"payStatus != null\" > and pay_status = #{payStatus,jdbcType=INTEGER} </if><if test=\"buyTime != null\" > and buy_time = #{buyTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"deliveryStatus != null\" > and delivery_status = #{deliveryStatus,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "shop_id", property = "shopId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "serial_number", property = "serialNumber", jdbcType = JdbcType.VARCHAR),
			@Result(column = "pay_status", property = "payStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "buy_time", property = "buyTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "delivery_status", property = "deliveryStatus", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<PurchaseHistory> findPaginationDataByCondition(
			QueryInterface query);

}
