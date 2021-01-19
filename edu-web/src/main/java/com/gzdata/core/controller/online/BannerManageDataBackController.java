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
import com.gzdata.core.dto.BannerManageDto;
import com.gzdata.core.model.BannerManage;
import com.gzdata.core.qo.BannerManageQo;
import com.gzdata.core.service.BannerManageService;

/**
 * 
 * BannerManage信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
@Api(tags="banner管理-控制器")
@RequestMapping("/api/")
public class BannerManageDataBackController {

	@Autowired
	private BannerManageService bannerManageService;

	/**
	 * 
	 * 功能描述：列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/banner/manage/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody BannerManageQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				bannerManageService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/banner/manage/list")
	@ResponseBody
	public Result list(@RequestBody BannerManageQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				bannerManageService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：详情
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
	@RequestMapping("data/banner/manage/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				bannerManageService.findById(id));
	}

	/**
	 * 
	 * 功能描述：批量删除
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
	@RequestMapping("data/banner/manage/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		bannerManageService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：删除
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
	@RequestMapping("data/banner/manage/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		bannerManageService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：添加
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
	@RequestMapping("data/banner/manage/add")
	@ResponseBody
	public Result add(@RequestBody BannerManageDto dto) {

		BannerManage bannerManage = new BannerManage();
		BeanUtils.copyProperties(dto, bannerManage);
		bannerManageService.insert(bannerManage);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：修改
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
	@RequestMapping("data/banner/manage/update")
	@ResponseBody
	public Result edit(@RequestBody BannerManageDto dto) {

		BannerManage bannerManage = new BannerManage();
		BeanUtils.copyProperties(dto, bannerManage);
		bannerManageService.updateSelective(bannerManage);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
