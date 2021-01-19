package com.gzdata.core.controller.data;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.SysUserPermissionDto;
import com.gzdata.core.model.SysUserPermission;
import com.gzdata.core.qo.SysUserPermissionQo;
import com.gzdata.core.service.SysUserPermissionService;

/**
 * 
 * SysUserPermission信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class SysUserPermissionDataController {

	@Autowired
	private SysUserPermissionService sysUserPermissionService;

	/**
	 * 
	 * 功能描述：用户-权限表列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/sys/user/permission/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody SysUserPermissionQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysUserPermissionService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：用户-权限表列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/sys/user/permission/list")
	@ResponseBody
	public Result list(@RequestBody SysUserPermissionQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysUserPermissionService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：用户-权限表详情
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
	@RequestMapping("data/sys/user/permission/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysUserPermissionService.findById(id));
	}

	/**
	 * 
	 * 功能描述：用户-权限表批量删除
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
	@RequestMapping("data/sys/user/permission/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		sysUserPermissionService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户-权限表删除
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
	@RequestMapping("data/sys/user/permission/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		sysUserPermissionService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户-权限表添加
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
	@RequestMapping("data/sys/user/permission/add")
	@ResponseBody
	public Result add(@RequestBody SysUserPermissionDto dto) {

		SysUserPermission sysUserPermission = new SysUserPermission();
		BeanUtils.copyProperties(dto, sysUserPermission);
		sysUserPermissionService.insert(sysUserPermission);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户-权限表修改
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
	@RequestMapping("data/sys/user/permission/update")
	@ResponseBody
	public Result edit(@RequestBody SysUserPermissionDto dto) {

		SysUserPermission sysUserPermission = new SysUserPermission();
		BeanUtils.copyProperties(dto, sysUserPermission);
		sysUserPermissionService.updateSelective(sysUserPermission);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
