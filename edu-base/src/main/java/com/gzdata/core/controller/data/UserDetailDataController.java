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
import com.gzdata.core.dto.UserDetailDto;
import com.gzdata.core.model.UserDetail;
import com.gzdata.core.qo.UserDetailQo;
import com.gzdata.core.service.UserDetailService;

/**
 * 
 * UserDetail信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class UserDetailDataController {

	@Autowired
	private UserDetailService userDetailService;

	/**
	 * 
	 * 功能描述：用户详情列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/detail/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody UserDetailQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				userDetailService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：用户详情列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/user/detail/list")
	@ResponseBody
	public Result list(@RequestBody UserDetailQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				userDetailService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：用户详情详情
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
	@RequestMapping("data/user/detail/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				userDetailService.findById(id));
	}

	/**
	 * 
	 * 功能描述：用户详情批量删除
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
	@RequestMapping("data/user/detail/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		userDetailService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户详情删除
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
	@RequestMapping("data/user/detail/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		userDetailService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户详情添加
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
	@RequestMapping("data/user/detail/add")
	@ResponseBody
	public Result add(@RequestBody UserDetailDto dto) {

		UserDetail userDetail = new UserDetail();
		BeanUtils.copyProperties(dto, userDetail);
		userDetailService.insert(userDetail);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：用户详情修改
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
	@RequestMapping("data/user/detail/update")
	@ResponseBody
	public Result edit(@RequestBody UserDetailDto dto) {

		UserDetail userDetail = new UserDetail();
		BeanUtils.copyProperties(dto, userDetail);
		userDetailService.updateSelective(userDetail);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
