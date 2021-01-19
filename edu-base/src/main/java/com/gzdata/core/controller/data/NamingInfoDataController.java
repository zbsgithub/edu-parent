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
import com.gzdata.core.dto.NamingInfoDto;
import com.gzdata.core.model.NamingInfo;
import com.gzdata.core.qo.NamingInfoQo;
import com.gzdata.core.service.NamingInfoService;

/**
 * 
 * NamingInfo信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class NamingInfoDataController {

	@Autowired
	private NamingInfoService namingInfoService;

	/**
	 * 
	 * 功能描述：冠名信息列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/naming/info/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody NamingInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				namingInfoService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：冠名信息列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/naming/info/list")
	@ResponseBody
	public Result list(@RequestBody NamingInfoQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				namingInfoService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：冠名信息详情
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
	@RequestMapping("data/naming/info/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				namingInfoService.findById(id));
	}

	/**
	 * 
	 * 功能描述：冠名信息批量删除
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
	@RequestMapping("data/naming/info/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		namingInfoService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：冠名信息删除
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
	@RequestMapping("data/naming/info/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		namingInfoService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：冠名信息添加
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
	@RequestMapping("data/naming/info/add")
	@ResponseBody
	public Result add(@RequestBody NamingInfoDto dto) {

		NamingInfo namingInfo = new NamingInfo();
		BeanUtils.copyProperties(dto, namingInfo);
		namingInfoService.insert(namingInfo);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：冠名信息修改
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
	@RequestMapping("data/naming/info/update")
	@ResponseBody
	public Result edit(@RequestBody NamingInfoDto dto) {

		NamingInfo namingInfo = new NamingInfo();
		BeanUtils.copyProperties(dto, namingInfo);
		namingInfoService.updateSelective(namingInfo);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
