package com.gzdata.core.controller.online;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.SysPermissionDto;
import com.gzdata.core.model.SysPermission;
import com.gzdata.core.qo.SysPermissionQo;
import com.gzdata.core.service.SysPermissionService;

/**
 * 
 * SysPermission信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="权限-控制器")
@RequestMapping("/api/")
@RestController
public class SysPermissionDataBackController {

	@Autowired
	private SysPermissionService sysPermissionService;

	/**
	 * 
	 * 功能描述：权限信息表列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("分页数据")
	@GetMapping("data/sys/permission/pagelist")
	public Result pagelist(@RequestBody SysPermissionQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysPermissionService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：权限信息表列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("条件查询")
	@GetMapping("data/sys/permission/list")
	public Result list(@RequestBody SysPermissionQo qo) {
		
		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysPermissionService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：权限信息表详情
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
	@ApiOperation("获取详情")
	@RequestMapping("data/sys/permission/detail")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysPermissionService.findById(id));
	}

	/**
	 * 
	 * 功能描述：权限信息表批量删除
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
	@ApiOperation("批量删除")
	@GetMapping("data/sys/permission/batch_delete")
	public Result batchDelete(@RequestParam Serializable... ids) {

		sysPermissionService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：权限信息表删除
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
	@ApiOperation("单个删除")
	@GetMapping("data/sys/permission/delete")
	public Result delete(@RequestParam String id) {

		sysPermissionService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：权限信息表添加
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
	@ApiOperation("添加数据")
	@PostMapping("data/sys/permission/add")
	public Result add(@RequestBody SysPermissionDto dto) {

		SysPermission sysPermission = new SysPermission();
		BeanUtils.copyProperties(dto, sysPermission);
		sysPermissionService.insert(sysPermission);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：权限信息表修改
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
	@ApiOperation("修改数据")
	@PostMapping("data/sys/permission/update")
	public Result edit(@RequestBody SysPermissionDto dto) {

		SysPermission sysPermission = new SysPermission();
		BeanUtils.copyProperties(dto, sysPermission);
		sysPermissionService.updateSelective(sysPermission);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
