package com.gzdata.core.controller.data;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.PurchaseHistoryDto;
import com.gzdata.core.model.PurchaseHistory;
import com.gzdata.core.qo.PurchaseHistoryQo;
import com.gzdata.core.service.PurchaseHistoryService;

/**
 * 
 * PurchaseHistory信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class PurchaseHistoryDataController {

	@Autowired
	private PurchaseHistoryService purchaseHistoryService;

	/**
	 * 
	 * 功能描述：已购代捐-购买历史列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/purchase/history/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody PurchaseHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				purchaseHistoryService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：已购代捐-购买历史列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/purchase/history/list")
	@ResponseBody
	public Result list(@RequestBody PurchaseHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				purchaseHistoryService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：已购代捐-购买历史详情
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
	@RequestMapping("data/purchase/history/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				purchaseHistoryService.findById(id));
	}

	/**
	 * 
	 * 功能描述：已购代捐-购买历史批量删除
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
	@RequestMapping("data/purchase/history/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		purchaseHistoryService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：已购代捐-购买历史删除
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
	@RequestMapping("data/purchase/history/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		purchaseHistoryService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：已购代捐-购买历史添加
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
	@PostMapping("data/purchase/history/add")
	@ResponseBody
	public Result add(@RequestBody PurchaseHistoryDto dto) {

		PurchaseHistory purchaseHistory = new PurchaseHistory();
		BeanUtils.copyProperties(dto, purchaseHistory);
		purchaseHistoryService.insert(purchaseHistory);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：已购代捐-购买历史修改
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
	@RequestMapping("data/purchase/history/update")
	@ResponseBody
	public Result edit(@RequestBody PurchaseHistoryDto dto) {

		PurchaseHistory purchaseHistory = new PurchaseHistory();
		BeanUtils.copyProperties(dto, purchaseHistory);
		purchaseHistoryService.updateSelective(purchaseHistory);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
