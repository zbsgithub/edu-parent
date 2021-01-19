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
import com.gzdata.core.dto.BindAccountDto;
import com.gzdata.core.model.BindAccount;
import com.gzdata.core.qo.BindAccountQo;
import com.gzdata.core.service.BindAccountService;

/**
 * 
 * BindAccount信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api(tags="绑定账号-控制器")
@RequestMapping("/api/")
@Controller
public class BindAccountDataBackController {

	@Autowired
	private BindAccountService bindAccountService;

	/**
	 * 
	 * 功能描述：绑定账号列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/bind/account/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody BindAccountQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				bindAccountService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：绑定账号列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/bind/account/list")
	@ResponseBody
	public Result list(@RequestBody BindAccountQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				bindAccountService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：绑定账号详情
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
	@RequestMapping("data/bind/account/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				bindAccountService.findById(id));
	}

	/**
	 * 
	 * 功能描述：绑定账号批量删除
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
	@RequestMapping("data/bind/account/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		bindAccountService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：绑定账号删除
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
	@RequestMapping("data/bind/account/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		bindAccountService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：绑定账号添加
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
	@RequestMapping("data/bind/account/add")
	@ResponseBody
	public Result add(@RequestBody BindAccountDto dto) {

		BindAccount bindAccount = new BindAccount();
		BeanUtils.copyProperties(dto, bindAccount);
		bindAccountService.insert(bindAccount);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：绑定账号修改
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
	@RequestMapping("data/bind/account/update")
	@ResponseBody
	public Result edit(@RequestBody BindAccountDto dto) {

		BindAccount bindAccount = new BindAccount();
		BeanUtils.copyProperties(dto, bindAccount);
		bindAccountService.updateSelective(bindAccount);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
