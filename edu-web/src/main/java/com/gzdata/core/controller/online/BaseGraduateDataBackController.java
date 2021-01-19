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
import com.gzdata.core.dto.BaseGraduateDto;
import com.gzdata.core.model.BaseGraduate;
import com.gzdata.core.qo.BaseGraduateQo;
import com.gzdata.core.service.BaseGraduateService;

/**
 * 
 * BaseGraduate信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
@Api(tags="研究生-控制器")
@RequestMapping("/api/")
public class BaseGraduateDataBackController {

	@Autowired
	private BaseGraduateService baseGraduateService;

	/**
	 * 
	 * 功能描述：基础-研究生列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/base/graduate/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody BaseGraduateQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				baseGraduateService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：基础-研究生列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/base/graduate/list")
	@ResponseBody
	public Result list(@RequestBody BaseGraduateQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				baseGraduateService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：基础-研究生详情
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
	@RequestMapping("data/base/graduate/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				baseGraduateService.findById(id));
	}

	/**
	 * 
	 * 功能描述：基础-研究生批量删除
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
	@RequestMapping("data/base/graduate/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		baseGraduateService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：基础-研究生删除
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
	@RequestMapping("data/base/graduate/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		baseGraduateService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：基础-研究生添加
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
	@RequestMapping("data/base/graduate/add")
	@ResponseBody
	public Result add(@RequestBody BaseGraduateDto dto) {

		BaseGraduate baseGraduate = new BaseGraduate();
		BeanUtils.copyProperties(dto, baseGraduate);
		baseGraduateService.insert(baseGraduate);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：基础-研究生修改
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
	@RequestMapping("data/base/graduate/update")
	@ResponseBody
	public Result edit(@RequestBody BaseGraduateDto dto) {

		BaseGraduate baseGraduate = new BaseGraduate();
		BeanUtils.copyProperties(dto, baseGraduate);
		baseGraduateService.updateSelective(baseGraduate);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
