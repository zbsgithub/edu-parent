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
import com.gzdata.core.dto.BaseUndergraduateDto;
import com.gzdata.core.model.BaseUndergraduate;
import com.gzdata.core.qo.BaseUndergraduateQo;
import com.gzdata.core.service.BaseUndergraduateService;

/**
 * 
 * BaseUndergraduate信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class BaseUndergraduateDataController {

	@Autowired
	private BaseUndergraduateService baseUndergraduateService;

	/**
	 * 
	 * 功能描述：基础-普通专本科列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/base/undergraduate/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody BaseUndergraduateQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				baseUndergraduateService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：基础-普通专本科列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/base/undergraduate/list")
	@ResponseBody
	public Result list(@RequestBody BaseUndergraduateQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				baseUndergraduateService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：基础-普通专本科详情
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
	@RequestMapping("data/base/undergraduate/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				baseUndergraduateService.findById(id));
	}

	/**
	 * 
	 * 功能描述：基础-普通专本科批量删除
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
	@RequestMapping("data/base/undergraduate/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		baseUndergraduateService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：基础-普通专本科删除
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
	@RequestMapping("data/base/undergraduate/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		baseUndergraduateService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：基础-普通专本科添加
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
	@RequestMapping("data/base/undergraduate/add")
	@ResponseBody
	public Result add(@RequestBody BaseUndergraduateDto dto) {

		BaseUndergraduate baseUndergraduate = new BaseUndergraduate();
		BeanUtils.copyProperties(dto, baseUndergraduate);
		baseUndergraduateService.insert(baseUndergraduate);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：基础-普通专本科修改
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
	@RequestMapping("data/base/undergraduate/update")
	@ResponseBody
	public Result edit(@RequestBody BaseUndergraduateDto dto) {

		BaseUndergraduate baseUndergraduate = new BaseUndergraduate();
		BeanUtils.copyProperties(dto, baseUndergraduate);
		baseUndergraduateService.updateSelective(baseUndergraduate);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
