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
import com.gzdata.core.dto.CashDonationDto;
import com.gzdata.core.model.CashDonation;
import com.gzdata.core.qo.CashDonationQo;
import com.gzdata.core.service.CashDonationService;

/**
 * 
 * CashDonation信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class CashDonationDataController {

	@Autowired
	private CashDonationService cashDonationService;

	/**
	 * 
	 * 功能描述：现金捐赠列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/cash/donation/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody CashDonationQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				cashDonationService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：现金捐赠列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/cash/donation/list")
	@ResponseBody
	public Result list(@RequestBody CashDonationQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				cashDonationService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：现金捐赠详情
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
	@RequestMapping("data/cash/donation/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				cashDonationService.findById(id));
	}

	/**
	 * 
	 * 功能描述：现金捐赠批量删除
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
	@RequestMapping("data/cash/donation/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		cashDonationService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：现金捐赠删除
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
	@RequestMapping("data/cash/donation/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		cashDonationService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：现金捐赠添加
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
	@RequestMapping("data/cash/donation/add")
	@ResponseBody
	public Result add(@RequestBody CashDonationDto dto) {

		CashDonation cashDonation = new CashDonation();
		BeanUtils.copyProperties(dto, cashDonation);
		cashDonationService.insert(cashDonation);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：现金捐赠修改
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
	@RequestMapping("data/cash/donation/update")
	@ResponseBody
	public Result edit(@RequestBody CashDonationDto dto) {

		CashDonation cashDonation = new CashDonation();
		BeanUtils.copyProperties(dto, cashDonation);
		cashDonationService.updateSelective(cashDonation);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
