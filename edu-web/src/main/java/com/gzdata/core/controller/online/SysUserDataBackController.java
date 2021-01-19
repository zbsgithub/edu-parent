package com.gzdata.core.controller.online;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.SysUserDto;
import com.gzdata.core.model.SysUser;
import com.gzdata.core.qo.SysUserQo;
import com.gzdata.core.service.SysUserService;

/**
 * 
 * SysUser信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="用户信息-控制器")
@RequestMapping("/api/")
@RestController
public class SysUserDataBackController {

	@Autowired
	private SysUserService sysUserService;

	/**
	 * 
	 * 功能描述：用户信息表列表--普通分页
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
	@GetMapping("data/sys/user/pagelist")
	public Result pagelist(@RequestBody SysUserQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysUserService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：用户信息表列表--通过条件查询
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
	@GetMapping("data/sys/user/list")
	public Result list(@RequestBody SysUserQo qo) {
		
		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysUserService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：用户信息表详情
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
	@GetMapping("data/sys/user/detail")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				sysUserService.findById(id));
	}

	/**
	 * 
	 * 功能描述：用户信息表批量删除
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
	@GetMapping("data/sys/user/batch_delete")
	public Result batchDelete(@RequestParam Serializable... ids) {

		sysUserService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户信息表删除
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
	@RequestMapping("data/sys/user/delete")
	public Result delete(@RequestParam String id) {

		sysUserService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户信息表添加
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
	@PostMapping("data/sys/user/add")
	public Result add(@RequestBody SysUserDto dto) {

		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(dto, sysUser);
		sysUserService.insert(sysUser);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户信息表修改
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
	@PostMapping("data/sys/user/update")
	public Result edit(@RequestBody SysUserDto dto) {

		SysUser sysUser = new SysUser();
		BeanUtils.copyProperties(dto, sysUser);
		sysUserService.updateSelective(sysUser);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
