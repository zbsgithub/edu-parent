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
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.SouvenirBuyHistoryDto;
import com.gzdata.core.model.SouvenirBuyHistory;
import com.gzdata.core.qo.SouvenirBuyHistoryQo;
import com.gzdata.core.service.SouvenirBuyHistoryService;

/**
 * 
 * SouvenirBuyHistory信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="纪念品-购买历史-控制器")
@RequestMapping("/api/")
@RestController
public class SouvenirBuyHistoryDataBackController {

	@Autowired
	private SouvenirBuyHistoryService souvenirBuyHistoryService;

	/**
	 * 
	 * 功能描述：纪念品-购买历史列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("纪念品-购买历史列表--普通分页")
	@GetMapping("data/souvenir/buy/history/pagelist")
	public Result pagelist(@RequestBody SouvenirBuyHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				souvenirBuyHistoryService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：纪念品-购买历史列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("通过条件查询")
	@GetMapping("data/souvenir/buy/history/list")
	public Result list(@RequestBody SouvenirBuyHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				souvenirBuyHistoryService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：纪念品-购买历史详情
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
	@ApiOperation("纪念品购买-历史详情")
	@GetMapping("data/souvenir/buy/history/detail")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				souvenirBuyHistoryService.findById(id));
	}

	/**
	 * 
	 * 功能描述：纪念品-购买历史批量删除
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
	@GetMapping("data/souvenir/buy/history/batch_delete")
	public Result batchDelete(@RequestParam Serializable... ids) {

		souvenirBuyHistoryService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：纪念品-购买历史删除
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
	@RequestMapping("data/souvenir/buy/history/delete")
	public Result delete(@RequestParam String id) {

		souvenirBuyHistoryService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：纪念品-购买历史添加
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
	@ApiOperation("纪念品-购买历史添加")
	@PostMapping("data/souvenir/buy/history/add")
	public Result add(@RequestBody SouvenirBuyHistoryDto dto) {

		SouvenirBuyHistory souvenirBuyHistory = new SouvenirBuyHistory();
		BeanUtils.copyProperties(dto, souvenirBuyHistory);
		souvenirBuyHistoryService.insert(souvenirBuyHistory);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：纪念品-购买历史修改
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
	@ApiOperation("纪念品-购买历史修改")
	@PostMapping("data/souvenir/buy/history/update")
	public Result edit(@RequestBody SouvenirBuyHistoryDto dto) {

		SouvenirBuyHistory souvenirBuyHistory = new SouvenirBuyHistory();
		BeanUtils.copyProperties(dto, souvenirBuyHistory);
		souvenirBuyHistoryService.updateSelective(souvenirBuyHistory);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
