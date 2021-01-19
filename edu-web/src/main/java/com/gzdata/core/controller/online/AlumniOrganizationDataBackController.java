package com.gzdata.core.controller.online;

import io.swagger.annotations.Api;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.AlumniOrganizationDto;
import com.gzdata.core.model.AlumniOrganization;
import com.gzdata.core.qo.AlumniOrganizationQo;
import com.gzdata.core.service.AlumniOrganizationService;

/**
 * 
 * AlumniOrganization信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
@Api(tags="校友历史控制器")
@RequestMapping("/api/")
public class AlumniOrganizationDataBackController {

	@Autowired
	private AlumniOrganizationService alumniOrganizationService;

	/**
	 * 
	 * 功能描述：校友组织信息列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/organization/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody AlumniOrganizationQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniOrganizationService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：校友组织信息列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/organization/list")
	@ResponseBody
	public Result list(@RequestBody AlumniOrganizationQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniOrganizationService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：校友组织信息详情
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/organization/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniOrganizationService.findById(id));
	}

	/**
	 * 
	 * 功能描述：校友组织信息批量删除
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/organization/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		alumniOrganizationService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友组织信息删除
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/organization/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		alumniOrganizationService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友组织信息添加
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/organization/add")
	@ResponseBody
	public Result add(@RequestBody AlumniOrganizationDto dto) {

		AlumniOrganization alumniOrganization = new AlumniOrganization();
		BeanUtils.copyProperties(dto, alumniOrganization);
		alumniOrganizationService.insert(alumniOrganization);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友组织信息修改
	 *
	 * @param id
	 * @return
	 * 
	 * @author 张兵帅
	 *
	 * @since 2015年10月30日
	 *
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/organization/update")
	@ResponseBody
	public Result edit(@RequestBody AlumniOrganizationDto dto) {

		AlumniOrganization alumniOrganization = new AlumniOrganization();
		BeanUtils.copyProperties(dto, alumniOrganization);
		alumniOrganizationService.updateSelective(alumniOrganization);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
