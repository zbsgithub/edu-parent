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
import com.gzdata.core.dto.BackSchoolServiceDto;
import com.gzdata.core.model.BackSchoolService;
import com.gzdata.core.qo.BackSchoolServiceQo;
import com.gzdata.core.service.BackSchoolServiceService;

/**
 * 
 * BackSchoolService信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class BackSchoolServiceDataController {

	@Autowired
	private BackSchoolServiceService backSchoolServiceService;

	/**
	 * 
	 * 功能描述：返校服务列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/back/school/service/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody BackSchoolServiceQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				backSchoolServiceService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：返校服务列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/back/school/service/list")
	@ResponseBody
	public Result list(@RequestBody BackSchoolServiceQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				backSchoolServiceService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：返校服务详情
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
	@RequestMapping("data/back/school/service/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				backSchoolServiceService.findById(id));
	}

	/**
	 * 
	 * 功能描述：返校服务批量删除
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
	@RequestMapping("data/back/school/service/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		backSchoolServiceService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：返校服务删除
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
	@RequestMapping("data/back/school/service/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		backSchoolServiceService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：返校服务添加
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
	@RequestMapping("data/back/school/service/add")
	@ResponseBody
	public Result add(@RequestBody BackSchoolServiceDto dto) {

		BackSchoolService backSchoolService = new BackSchoolService();
		BeanUtils.copyProperties(dto, backSchoolService);
		backSchoolServiceService.insert(backSchoolService);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：返校服务修改
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
	@RequestMapping("data/back/school/service/update")
	@ResponseBody
	public Result edit(@RequestBody BackSchoolServiceDto dto) {

		BackSchoolService backSchoolService = new BackSchoolService();
		BeanUtils.copyProperties(dto, backSchoolService);
		backSchoolServiceService.updateSelective(backSchoolService);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
