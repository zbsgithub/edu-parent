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
import com.gzdata.core.dto.InformationDto;
import com.gzdata.core.model.Information;
import com.gzdata.core.qo.InformationQo;
import com.gzdata.core.service.InformationService;

/**
 * 
 * Information信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="资讯-控制器")
@RequestMapping("/api/")
@Controller
public class InformationDataBackController {

	@Autowired
	private InformationService informationService;

	/**
	 * 
	 * 功能描述：资讯信息表列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/information/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody InformationQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				informationService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：资讯信息表列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/information/list")
	@ResponseBody
	public Result list(@RequestBody InformationQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				informationService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：资讯信息表详情
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
	@RequestMapping("data/information/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				informationService.findById(id));
	}

	/**
	 * 
	 * 功能描述：资讯信息表批量删除
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
	@RequestMapping("data/information/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		informationService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：资讯信息表删除
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
	@RequestMapping("data/information/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		informationService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：资讯信息表添加
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
	@RequestMapping("data/information/add")
	@ResponseBody
	public Result add(@RequestBody InformationDto dto) {

		Information information = new Information();
		BeanUtils.copyProperties(dto, information);
		informationService.insert(information);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：资讯信息表修改
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
	@RequestMapping("data/information/update")
	@ResponseBody
	public Result edit(@RequestBody InformationDto dto) {

		Information information = new Information();
		BeanUtils.copyProperties(dto, information);
		informationService.updateSelective(information);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
