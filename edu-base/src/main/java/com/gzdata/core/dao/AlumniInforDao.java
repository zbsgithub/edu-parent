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
import com.gzdata.core.model.AlumniInfor;

/**
 * 
 * 说明：校友信息对象的数据访问类
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
public interface AlumniInforDao extends BaseDAOInterface<AlumniInfor> {

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
	@Insert({ "insert into alumni_infor ( id,full_name,sex,enrolment_year,alumni_status,college,faculty,major,user_id,class_name,phone,remark,create_time)  values (#{id,jdbcType=BIGINT},#{fullName,jdbcType=VARCHAR},#{sex,jdbcType=INTEGER},#{enrolmentYear,jdbcType=VARCHAR},#{alumniStatus,jdbcType=INTEGER},#{college,jdbcType=VARCHAR},#{faculty,jdbcType=VARCHAR},#{major,jdbcType=VARCHAR},#{userId,jdbcType=VARCHAR},#{className,jdbcType=VARCHAR},#{phone,jdbcType=VARCHAR},#{remark,jdbcType=VARCHAR},#{createTime,jdbcType=TIMESTAMP})" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insert(AlumniInfor entity);

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
			+ "insert into alumni_infor "
			+ "<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\" > <if test=\"id != null\" > id, </if> <if test=\"fullName != null\" > full_name, </if> <if test=\"sex != null\" > sex, </if> <if test=\"enrolmentYear != null\" > enrolment_year, </if> <if test=\"alumniStatus != null\" > alumni_status, </if> <if test=\"college != null\" > college, </if> <if test=\"faculty != null\" > faculty, </if> <if test=\"major != null\" > major, </if> <if test=\"userId != null\" > user_id, </if> <if test=\"className != null\" > class_name, </if> <if test=\"phone != null\" > phone, </if> <if test=\"remark != null\" > remark, </if> <if test=\"createTime != null\" > create_time, </if>  </trim> "
			+ " <trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\" >  <if test=\"id != null\" > #{id,jdbcType=BIGINT}, </if> <if test=\"fullName != null\" > #{fullName,jdbcType=VARCHAR}, </if> <if test=\"sex != null\" > #{sex,jdbcType=INTEGER}, </if> <if test=\"enrolmentYear != null\" > #{enrolmentYear,jdbcType=VARCHAR}, </if> <if test=\"alumniStatus != null\" > #{alumniStatus,jdbcType=INTEGER}, </if> <if test=\"college != null\" > #{college,jdbcType=VARCHAR}, </if> <if test=\"faculty != null\" > #{faculty,jdbcType=VARCHAR}, </if> <if test=\"major != null\" > #{major,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > #{userId,jdbcType=VARCHAR}, </if> <if test=\"className != null\" > #{className,jdbcType=VARCHAR}, </if> <if test=\"phone != null\" > #{phone,jdbcType=VARCHAR}, </if> <if test=\"remark != null\" > #{remark,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > #{createTime,jdbcType=TIMESTAMP}, </if> </trim>"
			+ "</script>" })
	@Override
	@Options(useGeneratedKeys = true, keyProperty = "id")
	public void insertSelective(AlumniInfor entity);

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
	@Delete({ "delete from alumni_infor where id = #{id,jdbcType=BIGINT}" })
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
			+ "delete from alumni_infor where id in "
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
	@Update({ "update alumni_infor set id= #{id,jdbcType=BIGINT},full_name= #{fullName,jdbcType=VARCHAR},sex= #{sex,jdbcType=INTEGER},enrolment_year= #{enrolmentYear,jdbcType=VARCHAR},alumni_status= #{alumniStatus,jdbcType=INTEGER},college= #{college,jdbcType=VARCHAR},faculty= #{faculty,jdbcType=VARCHAR},major= #{major,jdbcType=VARCHAR},user_id= #{userId,jdbcType=VARCHAR},class_name= #{className,jdbcType=VARCHAR},phone= #{phone,jdbcType=VARCHAR},remark= #{remark,jdbcType=VARCHAR},create_time= #{createTime,jdbcType=TIMESTAMP} where id = #{id,jdbcType=BIGINT} " })
	@Override
	public void update(AlumniInfor entity);

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
			+ "update alumni_infor "
			+ "<set > <if test=\"id != null\" > id = #{id,jdbcType=BIGINT}, </if> <if test=\"fullName != null\" > full_name = #{fullName,jdbcType=VARCHAR}, </if> <if test=\"sex != null\" > sex = #{sex,jdbcType=INTEGER}, </if> <if test=\"enrolmentYear != null\" > enrolment_year = #{enrolmentYear,jdbcType=VARCHAR}, </if> <if test=\"alumniStatus != null\" > alumni_status = #{alumniStatus,jdbcType=INTEGER}, </if> <if test=\"college != null\" > college = #{college,jdbcType=VARCHAR}, </if> <if test=\"faculty != null\" > faculty = #{faculty,jdbcType=VARCHAR}, </if> <if test=\"major != null\" > major = #{major,jdbcType=VARCHAR}, </if> <if test=\"userId != null\" > user_id = #{userId,jdbcType=VARCHAR}, </if> <if test=\"className != null\" > class_name = #{className,jdbcType=VARCHAR}, </if> <if test=\"phone != null\" > phone = #{phone,jdbcType=VARCHAR}, </if> <if test=\"remark != null\" > remark = #{remark,jdbcType=VARCHAR}, </if> <if test=\"createTime != null\" > create_time = #{createTime,jdbcType=TIMESTAMP}, </if>  </set> "
			+ "where id = #{id,jdbcType=BIGINT}" + "</script>" })
	@Override
	public void updateSelective(AlumniInfor entity);

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
	@Select({ "select * from alumni_infor" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.INTEGER),
			@Result(column = "enrolment_year", property = "enrolmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_status", property = "alumniStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "faculty", property = "faculty", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<AlumniInfor> findAll();

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
	@Select({ "select count(id) from alumni_infor" })
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
	@Select({ "select * from alumni_infor where id = #{id,jdbcType=BIGINT}" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.INTEGER),
			@Result(column = "enrolment_year", property = "enrolmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_status", property = "alumniStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "faculty", property = "faculty", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public AlumniInfor findById(Serializable id);

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
			+ "select * from alumni_infor "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=INTEGER} </if><if test=\"enrolmentYear != null\" > and enrolment_year = #{enrolmentYear,jdbcType=VARCHAR} </if><if test=\"alumniStatus != null\" > and alumni_status = #{alumniStatus,jdbcType=INTEGER} </if><if test=\"college != null\" > and college = #{college,jdbcType=VARCHAR} </if><if test=\"faculty != null\" > and faculty = #{faculty,jdbcType=VARCHAR} </if><if test=\"major != null\" > and major = #{major,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=VARCHAR} </if><if test=\"className != null\" > and class_name = #{className,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id </script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.INTEGER),
			@Result(column = "enrolment_year", property = "enrolmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_status", property = "alumniStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "faculty", property = "faculty", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<AlumniInfor> findList(QueryInterface query);

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
			+ "select count(id) from alumni_infor "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=INTEGER} </if><if test=\"enrolmentYear != null\" > and enrolment_year = #{enrolmentYear,jdbcType=VARCHAR} </if><if test=\"alumniStatus != null\" > and alumni_status = #{alumniStatus,jdbcType=INTEGER} </if><if test=\"college != null\" > and college = #{college,jdbcType=VARCHAR} </if><if test=\"faculty != null\" > and faculty = #{faculty,jdbcType=VARCHAR} </if><if test=\"major != null\" > and major = #{major,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=VARCHAR} </if><if test=\"className != null\" > and class_name = #{className,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
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
			+ "select * from alumni_infor "
			+ "<where> 1 = 1 "
			+ "<if test=\"id != null\" > and id = #{id,jdbcType=BIGINT} </if><if test=\"fullName != null\" > and full_name = #{fullName,jdbcType=VARCHAR} </if><if test=\"sex != null\" > and sex = #{sex,jdbcType=INTEGER} </if><if test=\"enrolmentYear != null\" > and enrolment_year = #{enrolmentYear,jdbcType=VARCHAR} </if><if test=\"alumniStatus != null\" > and alumni_status = #{alumniStatus,jdbcType=INTEGER} </if><if test=\"college != null\" > and college = #{college,jdbcType=VARCHAR} </if><if test=\"faculty != null\" > and faculty = #{faculty,jdbcType=VARCHAR} </if><if test=\"major != null\" > and major = #{major,jdbcType=VARCHAR} </if><if test=\"userId != null\" > and user_id = #{userId,jdbcType=VARCHAR} </if><if test=\"className != null\" > and class_name = #{className,jdbcType=VARCHAR} </if><if test=\"phone != null\" > and phone = #{phone,jdbcType=VARCHAR} </if><if test=\"remark != null\" > and remark = #{remark,jdbcType=VARCHAR} </if><if test=\"createTime != null\" > and create_time = #{createTime,jdbcType=TIMESTAMP} </if> "
			+ "</where> order by id "
			+ "<if test=\"pagination==1\" > limit #{first,jdbcType=INTEGER},#{pageSize,jdbcType=INTEGER}</if>"
			+ "</script>" })
	@Results({
			@Result(column = "id", property = "id", jdbcType = JdbcType.BIGINT, id = true),
			@Result(column = "full_name", property = "fullName", jdbcType = JdbcType.VARCHAR),
			@Result(column = "sex", property = "sex", jdbcType = JdbcType.INTEGER),
			@Result(column = "enrolment_year", property = "enrolmentYear", jdbcType = JdbcType.VARCHAR),
			@Result(column = "alumni_status", property = "alumniStatus", jdbcType = JdbcType.INTEGER),
			@Result(column = "college", property = "college", jdbcType = JdbcType.VARCHAR),
			@Result(column = "faculty", property = "faculty", jdbcType = JdbcType.VARCHAR),
			@Result(column = "major", property = "major", jdbcType = JdbcType.VARCHAR),
			@Result(column = "user_id", property = "userId", jdbcType = JdbcType.VARCHAR),
			@Result(column = "class_name", property = "className", jdbcType = JdbcType.VARCHAR),
			@Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
			@Result(column = "remark", property = "remark", jdbcType = JdbcType.VARCHAR),
			@Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP) })
	@Override
	public List<AlumniInfor> findPaginationDataByCondition(QueryInterface query);

}
