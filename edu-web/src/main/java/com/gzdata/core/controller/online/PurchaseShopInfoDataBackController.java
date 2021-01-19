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
import com.gzdata.core.dto.PurchaseShopInfoDto;
import com.gzdata.core.model.PurchaseShopInfo;
import com.gzdata.core.qo.PurchaseShopInfoQo;
import com.gzdata.core.service.PurchaseShopInfoService;

/**
 * 
 * PurchaseShopInfo信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="已购代捐-商品信息")
@RestController
@RequestMapping("/api/")
public class PurchaseShopInfoDataBackController {

	@Autowired
	private PurchaseShopInfoService purchaseShopInfoService;

	/**
	 * 
	 * 功能描述：已购代捐-商品信息列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("已购代捐-商品信息列表--普通分页")
	@GetMapping("data/purchase/shop/info/pagelist")
	public Result pagelist(@RequestBody PurchaseShopInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				purchaseShopInfoService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：已购代捐-商品信息列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@ApiOperation("已购代捐-商品信息列表--通过条件查询")
	@GetMapping("data/purchase/shop/info/list")
	public Result list(@RequestBody PurchaseShopInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				purchaseShopInfoService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：已购代捐-商品信息详情
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
	@ApiOperation("已购代捐-商品信息详情")
	@GetMapping("data/purchase/shop/info/detail")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				purchaseShopInfoService.findById(id));
	}

	/**
	 * 
	 * 功能描述：已购代捐-商品信息批量删除
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
	@ApiOperation("已购代捐-商品信息批量删除")
	@GetMapping("data/purchase/shop/info/batch_delete")
	public Result batchDelete(@RequestParam Serializable... ids) {

		purchaseShopInfoService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：已购代捐-商品信息删除
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
	@ApiOperation("已购代捐-商品信息删除")
	@GetMapping("data/purchase/shop/info/delete")
	public Result delete(@RequestParam String id) {

		purchaseShopInfoService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：已购代捐-商品信息添加
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
	@ApiOperation("已购代捐-商品信息添加")
	@PostMapping("data/purchase/shop/info/add")
	public Result add(@RequestBody PurchaseShopInfoDto dto) {

		PurchaseShopInfo purchaseShopInfo = new PurchaseShopInfo();
		BeanUtils.copyProperties(dto, purchaseShopInfo);
		purchaseShopInfoService.insert(purchaseShopInfo);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：已购代捐-商品信息修改
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
	@ApiOperation("已购代捐-商品信息修改")
	@PostMapping("data/purchase/shop/info/update")
	public Result edit(@RequestBody PurchaseShopInfoDto dto) {

		PurchaseShopInfo purchaseShopInfo = new PurchaseShopInfo();
		BeanUtils.copyProperties(dto, purchaseShopInfo);
		purchaseShopInfoService.updateSelective(purchaseShopInfo);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
