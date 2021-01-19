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
import com.gzdata.core.dto.SouvenirMallDto;
import com.gzdata.core.model.SouvenirMall;
import com.gzdata.core.qo.SouvenirMallQo;
import com.gzdata.core.service.SouvenirMallService;

/**
 * 
 * SouvenirMall信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="纪念品商城-控制器")
@RestController
@RequestMapping("/api/")
public class SouvenirMallDataBackController {

	@Autowired
	private SouvenirMallService souvenirMallService;

	/**
	 * 
	 * 功能描述：积分商城 列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("普通分页")
	@GetMapping("data/souvenir/mall/pagelist")
	public Result pagelist(@RequestBody SouvenirMallQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				souvenirMallService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：积分商城 列表--通过条件查询
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
	@RequestMapping("data/souvenir/mall/list")
	public Result list(@RequestBody SouvenirMallQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				souvenirMallService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：积分商城 详情
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
	@ApiOperation("积分商城-详情")
	@GetMapping("data/souvenir/mall/detail")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				souvenirMallService.findById(id));
	}

	/**
	 * 
	 * 功能描述：积分商城 批量删除
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
	@GetMapping("data/souvenir/mall/batch_delete")
	public Result batchDelete(@RequestParam Serializable... ids) {

		souvenirMallService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：积分商城 删除
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
	@GetMapping("data/souvenir/mall/delete")
	public Result delete(@RequestParam String id) {

		souvenirMallService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：积分商城 添加
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
	@ApiOperation("新增数据")
	@PostMapping("data/souvenir/mall/add")
	public Result add(@RequestBody SouvenirMallDto dto) {

		SouvenirMall souvenirMall = new SouvenirMall();
		BeanUtils.copyProperties(dto, souvenirMall);
		souvenirMallService.insert(souvenirMall);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：积分商城 修改
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
	@PostMapping("data/souvenir/mall/update")
	public Result edit(@RequestBody SouvenirMallDto dto) {

		SouvenirMall souvenirMall = new SouvenirMall();
		BeanUtils.copyProperties(dto, souvenirMall);
		souvenirMallService.updateSelective(souvenirMall);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
