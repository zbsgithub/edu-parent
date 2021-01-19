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
import com.gzdata.core.model.ExchangeHistory;

/**
 * 
 * 说明：兑换历史对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface ExchangeHistoryDao extends BaseDAOInterface<ExchangeHistory> {

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
	@Insert({ "insert into exchange_history ( id,score,user_id,goods_img_path,goods_name,goods_model,exchange_time,remark)  values (#{id,jdbcType=BIGINT},#{score,jdbcType=INTEGER},#{userId,jdbcType=INTEGER},#{goodsImgPath,jdbcType=VARCHAR},#{goodsName,jdbcType=VARCHAR},#{goodsModel,jdbcType=VARCHAR},#{exchangeTime,jdbcType=DATE},#{remark,jdbcType=VARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(ExchangeHistory entity);

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
			+ "insert into exchange_history "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"score != null\" > score, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"goodsImgPath != null\" > goods_img_path, </if> <if test=\"goodsName != null\" > goods_name, </if> <if test=\"goodsModel != null\" > goods_model, </if> <if test=\"exchangeTime != null\" > exchange_time, </if> <if test=\"remark != null\" > remark, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"score != null\" > #{score,jdbcType=INTEGER}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> <if test=\"goodsImgPath != null\" > #{goodsImgPath,jdbcType=VARCHAR}, </if> <if test=\"goodsName != null\" > #{goodsName,jdbcType=VARCHAR}, </if> <if test=\"goodsModel != null\" > #{goodsModel,jdbcType=VARCHAR}, </if> <if test=\"exchangeTime != null\" > #{exchangeTime,jdbcType=DATE}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(ExchangeHistory entity);

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
	@Delete({ "delete from exchange_history where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from exchange_history where id in "
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
	@Update({ "update exchange_history set id= #{id,jdbcType=BIGINT},score= #{score,jdbcType=INTEGER},user_id= #{userId,jdbcType=INTEGER},goods_img_path= #{goodsImgPath,jdbcType=VARCHAR},goods_name= #{goodsName,jdbcType=VARCHAR},goods_model= #{goodsModel,jdbcType=VARCHAR},exchange_time= #{exchangeTime,jdbcType=DATE},remark= #{remark,jdbcType=VARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(ExchangeHistory entity);

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
			+ "update exchange_history "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"score != null\" > score = #{score,jdbcType=INTEGER}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if> <if test=\"goodsImgPath != null\" > goods_img_path = #{goodsImgPath,jdbcType=VARCHAR}, </if> <if test=\"goodsName != null\" > goods_name = #{goodsName,jdbcType=VARCHAR}, </if> <if test=\"goodsModel != null\" > goods_model = #{goodsModel,jdbcType=VARCHAR}, </if> <if test=\"exchangeTime != null\" > exchange_time = #{exchangeTime,jdbcType=DATE}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(ExchangeHistory entity);

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
	@Select({ "select * from exchange_history" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "goods_img_path", property = "goodsImgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_model", property = "goodsModel", jdbcType = JdbcType.VARCHAR),
			@Result(column = "exchange_time", property = "exchangeTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<ExchangeHistory> findAll();

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
	@Select({ "select count(id) from exchange_history" })
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
	@Select({ "select * from exchange_history where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "goods_img_path", property = "goodsImgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_model", property = "goodsModel", jdbcType = JdbcType.VARCHAR),
			@Result(column = "exchange_time", property = "exchangeTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public ExchangeHistory findById(Serializable id);

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
			+ "select * from exchange_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"score != null\" > and score = #{score,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"goodsImgPath != null\" > and goods_img_path = #{goodsImgPath,jdbcType=VARCHAR} </if><if test=\"goodsName != null\" > and goods_name = #{goodsName,jdbcType=VARCHAR} </if><if test=\"goodsModel != null\" > and goods_model = #{goodsModel,jdbcType=VARCHAR} </if><if test=\"exchangeTime != null\" > and exchange_time = #{exchangeTime,jdbcType=DATE} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "goods_img_path", property = "goodsImgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_model", property = "goodsModel", jdbcType = JdbcType.VARCHAR),
			@Result(column = "exchange_time", property = "exchangeTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<ExchangeHistory> findList(QueryInterface query);

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
			+ "select count(id) from exchange_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"score != null\" > and score = #{score,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"goodsImgPath != null\" > and goods_img_path = #{goodsImgPath,jdbcType=VARCHAR} </if><if test=\"goodsName != null\" > and goods_name = #{goodsName,jdbcType=VARCHAR} </if><if test=\"goodsModel != null\" > and goods_model = #{goodsModel,jdbcType=VARCHAR} </if><if test=\"exchangeTime != null\" > and exchange_time = #{exchangeTime,jdbcType=DATE} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
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
			+ "select * from exchange_history "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"score != null\" > and score = #{score,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"goodsImgPath != null\" > and goods_img_path = #{goodsImgPath,jdbcType=VARCHAR} </if><if test=\"goodsName != null\" > and goods_name = #{goodsName,jdbcType=VARCHAR} </if><if test=\"goodsModel != null\" > and goods_model = #{goodsModel,jdbcType=VARCHAR} </if><if test=\"exchangeTime != null\" > and exchange_time = #{exchangeTime,jdbcType=DATE} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "score", property = "score", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "goods_img_path", property = "goodsImgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "goods_model", property = "goodsModel", jdbcType = JdbcType.VARCHAR),
			@Result(column = "exchange_time", property = "exchangeTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<ExchangeHistory> findPaginationDataByCondition(
			QueryInterface query);

}
