package com.gzdata.core.controller.data;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.io.Serializable;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gzdata.common.db.mybatis.result.Result;
import com.gzdata.core.dto.ScoreDetailDto;
import com.gzdata.core.model.ScoreDetail;
import com.gzdata.core.qo.ScoreDetailQo;
import com.gzdata.core.service.ScoreDetailService;

/**
 * 
 * ScoreDetail信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@RestController
public class ScoreDetailDataController {

	@Autowired
	private  ScoreDetailService scoreDetailService;
	
	/**
	 * 
	 * 功能描述：积分明细列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("data/score/detail/pagelist")
	public Result pagelist(@RequestBody ScoreDetailQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", scoreDetailService.findPaginationDataByCondition(qo));
	}
	
	/**
	 * 
	 * 功能描述：积分明细列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@GetMapping("data/score/detail/list")
	public Result list(@RequestBody ScoreDetailQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功", scoreDetailService.findList(qo));
	}

	

	/**
	 * 
	 * 功能描述：积分明细详情
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
	@GetMapping("data/score/detail/detail")
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功", scoreDetailService.findById(id));
	}
	
	/**
	 * 
	 * 功能描述：积分明细批量删除
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
	@GetMapping("data/score/detail/batch_delete")
	public Result batchDelete(@RequestParam Serializable... ids) {

	 	 scoreDetailService.batchDelete(ids);
			

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：积分明细删除
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
	@GetMapping("data/score/detail/delete")
	public Result delete(@RequestParam String id) {

		
			 			 scoreDetailService.deleteByID(id);
			
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：积分明细添加
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
	@GetMapping("data/score/detail/add")
	public Result add(@RequestBody ScoreDetailDto dto) {
		ScoreDetail scoreDetail = new ScoreDetail();
		BeanUtils.copyProperties(dto, scoreDetail);
		scoreDetailService.insert(scoreDetail);
	return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：积分明细修改
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
	@GetMapping("data/score/detail/update")
 	 public Result edit(@RequestBody ScoreDetailDto dto) {
		
	 				ScoreDetail scoreDetail = new ScoreDetail();
				BeanUtils.copyProperties(dto, scoreDetail);
				scoreDetailService.updateSelective(scoreDetail);
		
		
		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
