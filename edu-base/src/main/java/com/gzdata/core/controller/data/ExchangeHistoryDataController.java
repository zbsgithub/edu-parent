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
import com.gzdata.core.dto.ExchangeHistoryDto;
import com.gzdata.core.model.ExchangeHistory;
import com.gzdata.core.qo.ExchangeHistoryQo;
import com.gzdata.core.service.ExchangeHistoryService;

/**
 * 
 * ExchangeHistory信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class ExchangeHistoryDataController {

	@Autowired
	private  ExchangeHistoryService exchangeHistoryService;
	
	/**
	 * 
	 * 功能描述：兑换历史列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/exchange/history/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody ExchangeHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", exchangeHistoryService.findPaginationDataByCondition(qo));
	}
	
	/**
	 * 
	 * 功能描述：兑换历史列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/exchange/history/list")
	@ResponseBody
	public Result list(@RequestBody ExchangeHistoryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", exchangeHistoryService.findList(qo));
	}

	

	/**
	 * 
	 * 功能描述：兑换历史详情
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
	@RequestMapping("data/exchange/history/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", exchangeHistoryService.findById(id));
	}
	
	/**
	 * 
	 * 功能描述：兑换历史批量删除
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
	@RequestMapping("data/exchange/history/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

	 	 exchangeHistoryService.batchDelete(ids);
			

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：兑换历史删除
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
	@RequestMapping("data/exchange/history/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		
			 			 exchangeHistoryService.deleteByID(id);
			
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：兑换历史添加
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
	@RequestMapping("data/exchange/history/add")
	@ResponseBody
	 	 public Result add(@RequestBody ExchangeHistoryDto dto) {
	
	
		 				ExchangeHistory exchangeHistory = new ExchangeHistory();
				BeanUtils.copyProperties(dto, exchangeHistory);
				exchangeHistoryService.insert(exchangeHistory);
		
				

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：兑换历史修改
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
	@RequestMapping("data/exchange/history/update")
	@ResponseBody
	 	 public Result edit(@RequestBody ExchangeHistoryDto dto) {
		
	 				ExchangeHistory exchangeHistory = new ExchangeHistory();
				BeanUtils.copyProperties(dto, exchangeHistory);
				exchangeHistoryService.updateSelective(exchangeHistory);
		
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
