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
import com.gzdata.core.model.FileEnquiry;

/**
 * 
 * 说明：档案查询对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface FileEnquiryDao extends BaseDAOInterface<FileEnquiry> {

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
	@Insert({ "insert into file_enquiry ( id,phone,id_card,application_type,card_front,card_back,application_status,user_id,download_link,address_id,create_time,remark,deadline,is_mail)  values (#{id,jdbcType=BIGINT},#{phone,jdbcType=VARCHAR},#{idCard,jdbcType=VARCHAR},#{applicationType,jdbcType=TINYINT},#{cardFront,jdbcType=VARCHAR},#{cardBack,jdbcType=VARCHAR},#{applicationStatus,jdbcType=INTEGER},#{userId,jdbcType=INTEGER},#{downloadLink,jdbcType=VARCHAR},#{addressId,jdbcType=INTEGER},#{createTime,jdbcType=DATE},#{remark,jdbcType=VARCHAR},#{deadline,jdbcType=DATE},#{isMail,jdbcType=TINYINT})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(FileEnquiry entity);

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
			+ "insert into file_enquiry "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"phone != null\" > phone, </if> <if test=\"idCard != null\" > id_card, </if> <if test=\"applicationType != null\" > application_type, </if> <if test=\"cardFront != null\" > card_front, </if> <if test=\"cardBack != null\" > card_back, </if> <if test=\"applicationStatus != null\" > application_status, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"downloadLink != null\" > download_link, </if> <if test=\"addressId != null\" > address_id, </if> <if test=\"createTime != null\" > create_time, </if> <if test=\"remark != null\" > remark, </if> <if test=\"deadline != null\" > deadline, </if> <if test=\"isMail != null\" > is_mail, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"phone != null\" > #{phone,jdbcType=VARCHAR}, </if> <if test=\"idCard != null\" > #{idCard,jdbcType=VARCHAR}, </if> <if test=\"applicationType != null\" > #{applicationType,jdbcType=TINYINT}, </if> <if test=\"cardFront != null\" > #{cardFront,jdbcType=VARCHAR}, </if> <if test=\"cardBack != null\" > #{cardBack,jdbcType=VARCHAR}, </if> <if test=\"applicationStatus != null\" > #{applicationStatus,jdbcType=INTEGER}, </if> <if test=\"userId != null\" > #{userId,jdbcType=INTEGER}, </if> <if test=\"downloadLink != null\" > #{downloadLink,jdbcType=VARCHAR}, </if> <if test=\"addressId != null\" > #{addressId,jdbcType=INTEGER}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=DATE}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"deadline != null\" > #{deadline,jdbcType=DATE}, </if> <if test=\"isMail != null\" > #{isMail,jdbcType=TINYINT}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(FileEnquiry entity);

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
	@Delete({ "delete from file_enquiry where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from file_enquiry where id in "
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
	@Update({ "update file_enquiry set id= #{id,jdbcType=BIGINT},phone= #{phone,jdbcType=VARCHAR},id_card= #{idCard,jdbcType=VARCHAR},application_type= #{applicationType,jdbcType=TINYINT},card_front= #{cardFront,jdbcType=VARCHAR},card_back= #{cardBack,jdbcType=VARCHAR},application_status= #{applicationStatus,jdbcType=INTEGER},user_id= #{userId,jdbcType=INTEGER},download_link= #{downloadLink,jdbcType=VARCHAR},address_id= #{addressId,jdbcType=INTEGER},create_time= #{createTime,jdbcType=DATE},remark= #{remark,jdbcType=VARCHAR},deadline= #{deadline,jdbcType=DATE},is_mail= #{isMail,jdbcType=TINYINT} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(FileEnquiry entity);

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
			+ "update file_enquiry "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"phone != null\" > phone = #{phone,jdbcType=VARCHAR}, </if> <if test=\"idCard != null\" > id_card = #{idCard,jdbcType=VARCHAR}, </if> <if test=\"applicationType != null\" > application_type = #{applicationType,jdbcType=TINYINT}, </if> <if test=\"cardFront != null\" > card_front = #{cardFront,jdbcType=VARCHAR}, </if> <if test=\"cardBack != null\" > card_back = #{cardBack,jdbcType=VARCHAR}, </if> <if test=\"applicationStatus != null\" > application_status = #{applicationStatus,jdbcType=INTEGER}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=INTEGER}, </if> <if test=\"downloadLink != null\" > download_link = #{downloadLink,jdbcType=VARCHAR}, </if> <if test=\"addressId != null\" > address_id = #{addressId,jdbcType=INTEGER}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=DATE}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"deadline != null\" > deadline = #{deadline,jdbcType=DATE}, </if> <if test=\"isMail != null\" > is_mail = #{isMail,jdbcType=TINYINT}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(FileEnquiry entity);

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
	@Select({ "select * from file_enquiry" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_card", property = "idCard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_type", property = "applicationType", jdbcType = JdbcType.TINYINT),
			@Result(column = "card_front", property = "cardFront", jdbcType = JdbcType.VARCHAR),
			@Result(column = "card_back", property = "cardBack", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "download_link", property = "downloadLink", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "deadline", property = "deadline", jdbcType = JdbcType.DATE),
			@Result(column = "is_mail", property = "isMail", jdbcType = JdbcType.TINYINT) })
	@Override
	public List<FileEnquiry> findAll();

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
	@Select({ "select count(id) from file_enquiry" })
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
	@Select({ "select * from file_enquiry where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_card", property = "idCard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_type", property = "applicationType", jdbcType = JdbcType.TINYINT),
			@Result(column = "card_front", property = "cardFront", jdbcType = JdbcType.VARCHAR),
			@Result(column = "card_back", property = "cardBack", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "download_link", property = "downloadLink", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "deadline", property = "deadline", jdbcType = JdbcType.DATE),
			@Result(column = "is_mail", property = "isMail", jdbcType = JdbcType.TINYINT) })
	@Override
	public FileEnquiry findById(Serializable id);

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
			+ "select * from file_enquiry "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"idCard != null\" > and id_card = #{idCard,jdbcType=VARCHAR} </if><if test=\"applicationType != null\" > and application_type = #{applicationType,jdbcType=TINYINT} </if><if test=\"cardFront != null\" > and card_front = #{cardFront,jdbcType=VARCHAR} </if><if test=\"cardBack != null\" > and card_back = #{cardBack,jdbcType=VARCHAR} </if><if test=\"applicationStatus != null\" > and application_status = #{applicationStatus,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"downloadLink != null\" > and download_link = #{downloadLink,jdbcType=VARCHAR} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=DATE} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"deadline != null\" > and deadline = #{deadline,jdbcType=DATE} </if><if test=\"isMail != null\" > and is_mail = #{isMail,jdbcType=TINYINT} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_card", property = "idCard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_type", property = "applicationType", jdbcType = JdbcType.TINYINT),
			@Result(column = "card_front", property = "cardFront", jdbcType = JdbcType.VARCHAR),
			@Result(column = "card_back", property = "cardBack", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "download_link", property = "downloadLink", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "deadline", property = "deadline", jdbcType = JdbcType.DATE),
			@Result(column = "is_mail", property = "isMail", jdbcType = JdbcType.TINYINT) })
	@Override
	public List<FileEnquiry> findList(QueryInterface query);

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
			+ "select count(id) from file_enquiry "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"idCard != null\" > and id_card = #{idCard,jdbcType=VARCHAR} </if><if test=\"applicationType != null\" > and application_type = #{applicationType,jdbcType=TINYINT} </if><if test=\"cardFront != null\" > and card_front = #{cardFront,jdbcType=VARCHAR} </if><if test=\"cardBack != null\" > and card_back = #{cardBack,jdbcType=VARCHAR} </if><if test=\"applicationStatus != null\" > and application_status = #{applicationStatus,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"downloadLink != null\" > and download_link = #{downloadLink,jdbcType=VARCHAR} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=DATE} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"deadline != null\" > and deadline = #{deadline,jdbcType=DATE} </if><if test=\"isMail != null\" > and is_mail = #{isMail,jdbcType=TINYINT} </if> "
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
			+ "select * from file_enquiry "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"idCard != null\" > and id_card = #{idCard,jdbcType=VARCHAR} </if><if test=\"applicationType != null\" > and application_type = #{applicationType,jdbcType=TINYINT} </if><if test=\"cardFront != null\" > and card_front = #{cardFront,jdbcType=VARCHAR} </if><if test=\"cardBack != null\" > and card_back = #{cardBack,jdbcType=VARCHAR} </if><if test=\"applicationStatus != null\" > and application_status = #{applicationStatus,jdbcType=INTEGER} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=INTEGER} </if><if test=\"downloadLink != null\" > and download_link = #{downloadLink,jdbcType=VARCHAR} </if><if test=\"addressId != null\" > and address_id = #{addressId,jdbcType=INTEGER} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=DATE} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"deadline != null\" > and deadline = #{deadline,jdbcType=DATE} </if><if test=\"isMail != null\" > and is_mail = #{isMail,jdbcType=TINYINT} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "id_card", property = "idCard", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_type", property = "applicationType", jdbcType = JdbcType.TINYINT),
			@Result(column = "card_front", property = "cardFront", jdbcType = JdbcType.VARCHAR),
			@Result(column = "card_back", property = "cardBack", jdbcType = JdbcType.VARCHAR),
			@Result(column = "application_status", property = "applicationStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.INTEGER),
			@Result(column = "download_link", property = "downloadLink", jdbcType = JdbcType.VARCHAR),
			@Result(column = "address_id", property = "addressId", jdbcType = JdbcType.INTEGER),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.DATE),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "deadline", property = "deadline", jdbcType = JdbcType.DATE),
			@Result(column = "is_mail", property = "isMail", jdbcType = JdbcType.TINYINT) })
	@Override
	public List<FileEnquiry> findPaginationDataByCondition(QueryInterface query);

}
