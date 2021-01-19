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
import com.gzdata.core.model.SouvenirBuyHistory;

/**
 * 
 * 说明：纪念品-购买历史对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface SouvenirBuyHistoryDao extends
		BaseDAOInterface<SouvenirBuyHistory> {

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
	@Insert({ "insert into souvenir_buy_history ( id,mall_id,convertor,concat_phone,convertor_time,address_id,state,create_time)  values (#{id,jdbcType=BIGINT},#{mallId,jdbcType=BIGINT},#{convertor,jdbcType=VARCHAR},#{concatPhone,jdbcType=VARCHAR},#{convertorTime,jdbcType=TIMESTAMP},#{addressId,jdbcType=BIGINT},#{state,jdbcType=TINYINT},#{createTime,jdbcType=TIMESTAMP})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(SouvenirBuyHistory entity);

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
			+ "insert into souvenir_buy_history "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"mallId != null\" > mall_id, </if> <if test=\"convertor != null\" > convertor, </if> <if test=\"concatPhone != null\" > concat_phone, </if> <if test=\"convertorTime != null\" > convertor_time, </if> <if test=\"addressId != null\" > address_id, </if> <if test=\"state != null\" > state, </if> <if test=\"createTime != null\" > create_time, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"mallId != null\" > #{mallId,jdbcType=BIGINT}, </if> <if test=\"convertor != null\" > #{convertor,jdbcType=VARCHAR}, </if> <if test=\"concatPhone != null\" > #{concatPhone,jdbcType=VARCHAR}, </if> <if test=\"convertorTime != null\" > #{convertorTime,jdbcType=TIMESTAMP}, </if> <if test=\"addressId != null\" > #{addressId,jdbcType=BIGINT}, </if> <if test=\"state != null\" > #{state,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(SouvenirBuyHistory entity);

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
	@Delete({ "delete from souvenir_buy_history where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from souvenir_buy_history where id in "
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
	@Update({ "update souvenir_buy_history set id= #{id,jdbcType=BIGINT},mall_id= #{mallId,jdbcType=BIGINT},convertor= #{convertor,jdbcType=VARCHAR},concat_phone= #{concatPhone,jdbcType=VARCHAR},convertor_time= #{convertorTime,jdbcType=TIMESTAMP},address_id= #{addressId,jdbcType=BIGINT},state= #{state,jdbcType=TINYINT},create_time= #{createTime,jdbcType=TIMESTAMP} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(SouvenirBuyHistory entity);

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
			+ "update souvenir_buy_history "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"mallId != null\" > mall_id = #{mallId,jdbcType=BIGINT}, </if> <if test=\"convertor != null\" > convertor = #{convertor,jdbcType=VARCHAR}, </if> <if test=\"concatPhone != null\" > concat_phone = #{concatPhone,jdbcType=VARCHAR}, </if> <if test=\"convertorTime != null\" > convertor_time = #{convertorTime,jdbcType=TIMESTAMP}, </if> <if test=\"addressId != null\" > address_id = #{addressId,jdbcType=BIGINT}, </if> <if test=\"state != null\" > state = #{state,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(SouvenirBuyHistory entity);

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
	@Select({ "select * from souvenir_buy_history" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "mall_id", property = "mallId", jdbcType = JdbcType.BIGINT),
			@Result(column = "convertor", property = "convertor", jdbcType = JdbcType.VARCHAR),
			@Result(column = "concat_phone", property = "concatPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "convertor_time", property = "convertorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.BIGINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<SouvenirBuyHistory> findAll();

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
	@Select({ "select count(id) from souvenir_buy_history" })
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
	@Select({ "select * from souvenir_buy_history where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "mall_id", property = "mallId", jdbcType = JdbcType.BIGINT),
			@Result(column = "convertor", property = "convertor", jdbcType = JdbcType.VARCHAR),
			@Result(column = "concat_phone", property = "concatPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "convertor_time", property = "convertorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.BIGINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public SouvenirBuyHistory findById(Serializable id);

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
			+ "select * from souvenir_buy_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"mallId != null\" > and mall_id = #{mallId,jdbcType=BIGINT} </if><if test=\"convertor != null\" > and convertor = #{convertor,jdbcType=VARCHAR} </if><if test=\"concatPhone != null\" > and concat_phone = #{concatPhone,jdbcType=VARCHAR} </if><if test=\"convertorTime != null\" > and convertor_time = #{convertorTime,jdbcType=TIMESTAMP} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=BIGINT} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "mall_id", property = "mallId", jdbcType = JdbcType.BIGINT),
			@Result(column = "convertor", property = "convertor", jdbcType = JdbcType.VARCHAR),
			@Result(column = "concat_phone", property = "concatPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "convertor_time", property = "convertorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.BIGINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<SouvenirBuyHistory> findList(QueryInterface query);

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
			+ "select count(id) from souvenir_buy_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"mallId != null\" > and mall_id = #{mallId,jdbcType=BIGINT} </if><if test=\"convertor != null\" > and convertor = #{convertor,jdbcType=VARCHAR} </if><if test=\"concatPhone != null\" > and concat_phone = #{concatPhone,jdbcType=VARCHAR} </if><if test=\"convertorTime != null\" > and convertor_time = #{convertorTime,jdbcType=TIMESTAMP} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=BIGINT} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
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
			+ "select * from souvenir_buy_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"mallId != null\" > and mall_id = #{mallId,jdbcType=BIGINT} </if><if test=\"convertor != null\" > and convertor = #{convertor,jdbcType=VARCHAR} </if><if test=\"concatPhone != null\" > and concat_phone = #{concatPhone,jdbcType=VARCHAR} </if><if test=\"convertorTime != null\" > and convertor_time = #{convertorTime,jdbcType=TIMESTAMP} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=BIGINT} </if><if test=\"state != null\" > and state = #{state,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "mall_id", property = "mallId", jdbcType = JdbcType.BIGINT),
			@Result(column = "convertor", property = "convertor", jdbcType = JdbcType.VARCHAR),
			@Result(column = "concat_phone", property = "concatPhone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "convertor_time", property = "convertorTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.BIGINT),
			@Result(column = "state", property = "state", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<SouvenirBuyHistory> findPaginationDataByCondition(
			QueryInterface query);

}
