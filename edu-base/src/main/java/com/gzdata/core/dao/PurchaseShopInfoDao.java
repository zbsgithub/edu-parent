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
import com.gzdata.core.model.PurchaseShopInfo;

/**
 * 
 * 说明：已购代捐-商品信息对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface PurchaseShopInfoDao extends BaseDAOInterface<PurchaseShopInfo> {

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
	@Insert({ "insert into purchase_shop_info ( id,goods_name,img_path,act_price,donation_price,is_shelve,create_time,remark,is_delete,category)  values (#{id,jdbcType=BIGINT},#{goodsName,jdbcType=VARCHAR},#{imgPath,jdbcType=VARCHAR},#{actPrice,jdbcType=DECIMAL},#{donationPrice,jdbcType=DECIMAL},#{isShelve,jdbcType=TINYINT},#{createTime,jdbcType=TIMESTAMP},#{remark,jdbcType=VARCHAR},#{isDelete,jdbcType=TINYINT},#{category,jdbcType=LONGVARCHAR})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(PurchaseShopInfo entity);

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
			+ "insert into purchase_shop_info "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"goodsName != null\" > goods_name, </if> <if test=\"imgPath != null\" > img_path, </if> <if test=\"actPrice != null\" > act_price, </if> <if test=\"donationPrice != null\" > donation_price, </if> <if test=\"isShelve != null\" > is_shelve, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if> <if test=\"isDelete != null\" > is_delete, </if> <if test=\"category != null\" > category, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"goodsName != null\" > #{goodsName,jdbcType=VARCHAR}, </if> <if test=\"imgPath != null\" > #{imgPath,jdbcType=VARCHAR}, </if> <if test=\"actPrice != null\" > #{actPrice,jdbcType=DECIMAL}, </if> <if test=\"donationPrice != null\" > #{donationPrice,jdbcType=DECIMAL}, </if> <if test=\"isShelve != null\" > #{isShelve,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"isDelete != null\" > #{isDelete,jdbcType=TINYINT}, </if> <if test=\"category != null\" > #{category,jdbcType=LONGVARCHAR}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(PurchaseShopInfo entity);

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
	@Delete({ "delete from purchase_shop_info where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from purchase_shop_info where id in "
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
	@Update({ "update purchase_shop_info set id= #{id,jdbcType=BIGINT},goods_name= #{goodsName,jdbcType=VARCHAR},img_path= #{imgPath,jdbcType=VARCHAR},act_price= #{actPrice,jdbcType=DECIMAL},donation_price= #{donationPrice,jdbcType=DECIMAL},is_shelve= #{isShelve,jdbcType=TINYINT},create_time= #{createTime,jdbcType=TIMESTAMP},remark= #{remark,jdbcType=VARCHAR},is_delete= #{isDelete,jdbcType=TINYINT},category= #{category,jdbcType=LONGVARCHAR} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(PurchaseShopInfo entity);

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
			+ "update purchase_shop_info "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"goodsName != null\" > goods_name = #{goodsName,jdbcType=VARCHAR}, </if> <if test=\"imgPath != null\" > img_path = #{imgPath,jdbcType=VARCHAR}, </if> <if test=\"actPrice != null\" > act_price = #{actPrice,jdbcType=DECIMAL}, </if> <if test=\"donationPrice != null\" > donation_price = #{donationPrice,jdbcType=DECIMAL}, </if> <if test=\"isShelve != null\" > is_shelve = #{isShelve,jdbcType=TINYINT}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"isDelete != null\" > is_delete = #{isDelete,jdbcType=TINYINT}, </if> <if test=\"category != null\" > category = #{category,jdbcType=LONGVARCHAR}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(PurchaseShopInfo entity);

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
	@Select({ "select * from purchase_shop_info" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "img_path", property = "imgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "act_price", property = "actPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_price", property = "donationPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "is_shelve", property = "isShelve", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<PurchaseShopInfo> findAll();

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
	@Select({ "select count(id) from purchase_shop_info" })
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
	@Select({ "select * from purchase_shop_info where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "img_path", property = "imgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "act_price", property = "actPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_price", property = "donationPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "is_shelve", property = "isShelve", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR) })
	@Override
	public PurchaseShopInfo findById(Serializable id);

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
			+ "select * from purchase_shop_info "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"goodsName != null\" > and goods_name = #{goodsName,jdbcType=VARCHAR} </if><if test=\"imgPath != null\" > and img_path = #{imgPath,jdbcType=VARCHAR} </if><if test=\"actPrice != null\" > and act_price = #{actPrice,jdbcType=DECIMAL} </if><if test=\"donationPrice != null\" > and donation_price = #{donationPrice,jdbcType=DECIMAL} </if><if test=\"isShelve != null\" > and is_shelve = #{isShelve,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"category != null\" > and category = #{category,jdbcType=LONGVARCHAR} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "img_path", property = "imgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "act_price", property = "actPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_price", property = "donationPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "is_shelve", property = "isShelve", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<PurchaseShopInfo> findList(QueryInterface query);

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
			+ "select count(id) from purchase_shop_info "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"goodsName != null\" > and goods_name = #{goodsName,jdbcType=VARCHAR} </if><if test=\"imgPath != null\" > and img_path = #{imgPath,jdbcType=VARCHAR} </if><if test=\"actPrice != null\" > and act_price = #{actPrice,jdbcType=DECIMAL} </if><if test=\"donationPrice != null\" > and donation_price = #{donationPrice,jdbcType=DECIMAL} </if><if test=\"isShelve != null\" > and is_shelve = #{isShelve,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"category != null\" > and category = #{category,jdbcType=LONGVARCHAR} </if> "
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
			+ "select * from purchase_shop_info "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"goodsName != null\" > and goods_name = #{goodsName,jdbcType=VARCHAR} </if><if test=\"imgPath != null\" > and img_path = #{imgPath,jdbcType=VARCHAR} </if><if test=\"actPrice != null\" > and act_price = #{actPrice,jdbcType=DECIMAL} </if><if test=\"donationPrice != null\" > and donation_price = #{donationPrice,jdbcType=DECIMAL} </if><if test=\"isShelve != null\" > and is_shelve = #{isShelve,jdbcType=TINYINT} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"isDelete != null\" > and is_delete = #{isDelete,jdbcType=TINYINT} </if><if test=\"category != null\" > and category = #{category,jdbcType=LONGVARCHAR} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "goods_name", property = "goodsName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "img_path", property = "imgPath", jdbcType = JdbcType.VARCHAR),
			@Result(column = "act_price", property = "actPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "donation_price", property = "donationPrice", jdbcType = JdbcType.DECIMAL),
			@Result(column = "is_shelve", property = "isShelve", jdbcType = JdbcType.TINYINT),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "is_delete", property = "isDelete", jdbcType = JdbcType.TINYINT),
			@Result(column = "category", property = "category", jdbcType = JdbcType.VARCHAR) })
	@Override
	public List<PurchaseShopInfo> findPaginationDataByCondition(
			QueryInterface query);

}
