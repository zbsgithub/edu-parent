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
import com.gzdata.core.dto.OperLogDto;
import com.gzdata.core.model.OperLog;
import com.gzdata.core.qo.OperLogQo;
import com.gzdata.core.service.OperLogService;

/**
 * 
 * OperLog信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api("操作日志-控制器")
@RequestMapping("/api/")
@Controller
public class OperLogDataBackController {

	@Autowired
	private OperLogService operLogService;

	/**
	 * 
	 * 功能描述：操作日志表列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/oper/log/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody OperLogQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				operLogService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：操作日志表列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/oper/log/list")
	@ResponseBody
	public Result list(@RequestBody OperLogQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				operLogService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：操作日志表详情
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
	@RequestMapping("data/oper/log/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				operLogService.findById(id));
	}

	/**
	 * 
	 * 功能描述：操作日志表批量删除
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
	@RequestMapping("data/oper/log/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		operLogService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：操作日志表删除
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
	@RequestMapping("data/oper/log/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		operLogService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：操作日志表添加
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
	@RequestMapping("data/oper/log/add")
	@ResponseBody
	public Result add(@RequestBody OperLogDto dto) {

		OperLog operLog = new OperLog();
		BeanUtils.copyProperties(dto, operLog);
		operLogService.insert(operLog);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：操作日志表修改
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
	@RequestMapping("data/oper/log/update")
	@ResponseBody
	public Result edit(@RequestBody OperLogDto dto) {

		OperLog operLog = new OperLog();
		BeanUtils.copyProperties(dto, operLog);
		operLogService.updateSelective(operLog);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
