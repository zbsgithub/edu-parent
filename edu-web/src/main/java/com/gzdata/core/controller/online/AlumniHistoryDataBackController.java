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
import com.gzdata.core.dto.AlumniHistoryDto;
import com.gzdata.core.model.AlumniHistory;
import com.gzdata.core.qo.AlumniHistoryQo;
import com.gzdata.core.service.AlumniHistoryService;

/**
 * 
 * AlumniHistory信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="校友历史控制器")
@RequestMapping("/api/")
@Controller
public class AlumniHistoryDataBackController {

	@Autowired
	private AlumniHistoryService alumniHistoryService;

	/**
	 * 
	 * 功能描述：校友历史列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/history/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody AlumniHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniHistoryService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：校友历史列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/history/list")
	@ResponseBody
	public Result list(@RequestBody AlumniHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniHistoryService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：校友历史详情
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
	@RequestMapping("data/alumni/history/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniHistoryService.findById(id));
	}

	/**
	 * 
	 * 功能描述：校友历史批量删除
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
	@RequestMapping("data/alumni/history/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		alumniHistoryService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友历史删除
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
	@RequestMapping("data/alumni/history/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		alumniHistoryService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友历史添加
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
	@RequestMapping("data/alumni/history/add")
	@ResponseBody
	public Result add(@RequestBody AlumniHistoryDto dto) {

		AlumniHistory alumniHistory = new AlumniHistory();
		BeanUtils.copyProperties(dto, alumniHistory);
		alumniHistoryService.insert(alumniHistory);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友历史修改
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
	@RequestMapping("data/alumni/history/update")
	@ResponseBody
	public Result edit(@RequestBody AlumniHistoryDto dto) {

		AlumniHistory alumniHistory = new AlumniHistory();
		BeanUtils.copyProperties(dto, alumniHistory);
		alumniHistoryService.updateSelective(alumniHistory);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
