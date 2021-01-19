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
import com.gzdata.core.dto.StreetDto;
import com.gzdata.core.model.Street;
import com.gzdata.core.qo.StreetQo;
import com.gzdata.core.service.StreetService;

/**
 * 
 * Street信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class StreetDataController {

	@Autowired
	private StreetService streetService;

	/**
	 * 
	 * 功能描述：街道详细数据列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/street/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody StreetQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				streetService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：街道详细数据列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/street/list")
	@ResponseBody
	public Result list(@RequestBody StreetQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				streetService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：街道详细数据详情
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
	@RequestMapping("data/street/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				streetService.findById(id));
	}

	/**
	 * 
	 * 功能描述：街道详细数据批量删除
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
	@RequestMapping("data/street/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		streetService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：街道详细数据删除
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
	@RequestMapping("data/street/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		streetService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：街道详细数据添加
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
	@RequestMapping("data/street/add")
	@ResponseBody
	public Result add(@RequestBody StreetDto dto) {

		Street street = new Street();
		BeanUtils.copyProperties(dto, street);
		streetService.insert(street);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：街道详细数据修改
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
	@RequestMapping("data/street/update")
	@ResponseBody
	public Result edit(@RequestBody StreetDto dto) {

		Street street = new Street();
		BeanUtils.copyProperties(dto, street);
		streetService.updateSelective(street);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
