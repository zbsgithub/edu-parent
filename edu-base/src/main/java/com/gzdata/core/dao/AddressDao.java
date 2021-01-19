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
import com.gzdata.core.model.Address;

/**
 * 
 *  说明：地址信息对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface AddressDao extends BaseDAOInterface<Address> {

	 	
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
	@Insert({ "insert into address ( id,province,city,area,street,is_default,consignee,phone,user_id,create_time)  values (#{id,jdbcType=BIGINT},#{province,jdbcType=VARCHAR},#{city,jdbcType=VARCHAR},#{area,jdbcType=VARCHAR},#{street,jdbcType=VARCHAR},#{isDefault,jdbcType=INTEGER},#{consignee,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},#{userId,jdbcType=INTEGER},#{createTime,jdbcType=TIMESTAMP})" })
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insert(Address entity);

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
	@Insert({
			"<script>"
			+"insert into address "
		    +"<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"province != null\" > province, </if> <if test=\"city != null\" > city, </if> <if test=\"area != null\" > area, </if> <if test=\"street != null\" > street, </if> <if test=\"isDefault != null\" > is_default, </if> <if test=\"consignee != null\" > consignee, </if> <if test=\"phone != null\" > phone, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"createTime != null\" > create_time, </if>  </trim> "
		    +" <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"province != null\" > #{province,jdbcType=VARCHAR}, </if> <if test=\"city != null\" > #{city,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > #{area,jdbcType=VARCHAR}, </if> <if test=\"street != null\" > #{street,jdbcType=VARCHAR}, </if> <if test=\"isDefault != null\" > #{isDefault,jdbcType=INTEGER}, </if> <if test=\"consignee != null\" > #{consignee,jdbcType=VARCHAR}, </if> <if test=\"phone != null\" > #{phone,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> </trim>"
		    +"</script>" 
			})
	@Override
	 	@Options(useGeneratedKeys = true, keyProperty = "id")
		public void insertSelective(Address entity);
	
	

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
	@Delete({ "delete from address where id = #{id,jdbcType=BIGINT}" })
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
	@Delete({
			"<script>"
			+"delete from address where id in "
			+"<foreach  item=\"id\"  collection=\"array\" open=\"(\" separator=\",\" close=\")\" > #{id} </foreach>"
			+"</script>" 
			})
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
	@Update({ "update address set id= #{id,jdbcType=BIGINT},province= #{province,jdbcType=VARCHAR},city= #{city,jdbcType=VARCHAR},area= #{area,jdbcType=VARCHAR},street= #{street,jdbcType=VARCHAR},is_default= #{isDefault,jdbcType=INTEGER},consignee= #{consignee,jdbcType=VARCHAR},phone= #{phone,jdbcType=VARCHAR},user_id= #{userId,jdbcType=INTEGER},create_time= #{createTime,jdbcType=TIMESTAMP} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(Address entity);
	
	

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
	@Update({
			"<script>"
			+"update address "
			+"<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"province != null\" > province = #{province,jdbcType=VARCHAR}, </if> <if test=\"city != null\" > city = #{city,jdbcType=VARCHAR}, </if> <if test=\"area != null\" > area = #{area,jdbcType=VARCHAR}, </if> <if test=\"street != null\" > street = #{street,jdbcType=VARCHAR}, </if> <if test=\"isDefault != null\" > is_default = #{isDefault,jdbcType=INTEGER}, </if> <if test=\"consignee != null\" > consignee = #{consignee,jdbcType=VARCHAR}, </if> <if test=\"phone != null\" > phone = #{phone,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if>  </set> "
			+"where id = #{id,jdbcType=BIGINT}"
			+"</script>" 
			})
	@Override
	public void updateSelective(Address entity);

	
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
	@Select({ "select * from address" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.BIGINT ,id = true  ),@Result(column = "province", property = "province" , jdbcType = JdbcType.VARCHAR ),@Result(column = "city", property = "city" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "street", property = "street" , jdbcType = JdbcType.VARCHAR ),@Result(column = "is_default", property = "isDefault" , jdbcType = JdbcType.INTEGER ),@Result(column = "consignee", property = "consignee" , jdbcType = JdbcType.VARCHAR ),@Result(column = "phone", property = "phone" , jdbcType = JdbcType.VARCHAR ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<Address> findAll();

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
	@Select({ "select count(id) from address" })
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
	@Select({ "select * from address where id = #{id,jdbcType=BIGINT}" })
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.BIGINT ,id = true  ),@Result(column = "province", property = "province" , jdbcType = JdbcType.VARCHAR ),@Result(column = "city", property = "city" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "street", property = "street" , jdbcType = JdbcType.VARCHAR ),@Result(column = "is_default", property = "isDefault" , jdbcType = JdbcType.INTEGER ),@Result(column = "consignee", property = "consignee" , jdbcType = JdbcType.VARCHAR ),@Result(column = "phone", property = "phone" , jdbcType = JdbcType.VARCHAR ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public Address findById(Serializable id);

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
	@Select({
			"<script>"
			+"select * from address "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"province != null\" > and province = #{province,jdbcType=VARCHAR} </if><if test=\"city != null\" > and city = #{city,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"street != null\" > and street = #{street,jdbcType=VARCHAR} </if><if test=\"isDefault != null\" > and is_default = #{isDefault,jdbcType=INTEGER} </if><if test=\"consignee != null\" > and consignee = #{consignee,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+"</where> order by id </script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.BIGINT ,id = true  ),@Result(column = "province", property = "province" , jdbcType = JdbcType.VARCHAR ),@Result(column = "city", property = "city" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "street", property = "street" , jdbcType = JdbcType.VARCHAR ),@Result(column = "is_default", property = "isDefault" , jdbcType = JdbcType.INTEGER ),@Result(column = "consignee", property = "consignee" , jdbcType = JdbcType.VARCHAR ),@Result(column = "phone", property = "phone" , jdbcType = JdbcType.VARCHAR ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<Address> findList(QueryInterface query);

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
	@Select({
			"<script>"
			+"select count(id) from address "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"province != null\" > and province = #{province,jdbcType=VARCHAR} </if><if test=\"city != null\" > and city = #{city,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"street != null\" > and street = #{street,jdbcType=VARCHAR} </if><if test=\"isDefault != null\" > and is_default = #{isDefault,jdbcType=INTEGER} </if><if test=\"consignee != null\" > and consignee = #{consignee,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+"</where></script>" 
			})
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
	@Select({
			"<script>"
			+"select * from address "
			+"<where> 1 = 1 "
			+"<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"province != null\" > and province = #{province,jdbcType=VARCHAR} </if><if test=\"city != null\" > and city = #{city,jdbcType=VARCHAR} </if><if test=\"area != null\" > and area = #{area,jdbcType=VARCHAR} </if><if test=\"street != null\" > and street = #{street,jdbcType=VARCHAR} </if><if test=\"isDefault != null\" > and is_default = #{isDefault,jdbcType=INTEGER} </if><if test=\"consignee != null\" > and consignee = #{consignee,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+"</where> order by id "
			+"<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+"</script>" 
			})
	@Results({@Result(column = "id", property = "id" , jdbcType = JdbcType.BIGINT ,id = true  ),@Result(column = "province", property = "province" , jdbcType = JdbcType.VARCHAR ),@Result(column = "city", property = "city" , jdbcType = JdbcType.VARCHAR ),@Result(column = "area", property = "area" , jdbcType = JdbcType.VARCHAR ),@Result(column = "street", property = "street" , jdbcType = JdbcType.VARCHAR ),@Result(column = "is_default", property = "isDefault" , jdbcType = JdbcType.INTEGER ),@Result(column = "consignee", property = "consignee" , jdbcType = JdbcType.VARCHAR ),@Result(column = "phone", property = "phone" , jdbcType = JdbcType.VARCHAR ),@Result(column = "user_id", property = "userId" , jdbcType = JdbcType.INTEGER ),@Result(column = "create_time", property = "createTime" , jdbcType = JdbcType.TIMESTAMP ) })
	@Override
	public List<Address> findPaginationDataByCondition(QueryInterface query);

}

