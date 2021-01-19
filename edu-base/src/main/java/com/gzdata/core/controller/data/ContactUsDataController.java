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
import com.gzdata.core.dto.ContactUsDto;
import com.gzdata.core.model.ContactUs;
import com.gzdata.core.qo.ContactUsQo;
import com.gzdata.core.service.ContactUsService;

/**
 * 
 * ContactUs信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class ContactUsDataController {

	@Autowired
	private ContactUsService contactUsService;

	/**
	 * 
	 * 功能描述：联系我们列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/contact/us/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody ContactUsQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				contactUsService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：联系我们列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/contact/us/list")
	@ResponseBody
	public Result list(@RequestBody ContactUsQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				contactUsService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：联系我们详情
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
	@RequestMapping("data/contact/us/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				contactUsService.findById(id));
	}

	/**
	 * 
	 * 功能描述：联系我们批量删除
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
	@RequestMapping("data/contact/us/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		contactUsService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：联系我们删除
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
	@RequestMapping("data/contact/us/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		contactUsService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：联系我们添加
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
	@RequestMapping("data/contact/us/add")
	@ResponseBody
	public Result add(@RequestBody ContactUsDto dto) {

		ContactUs contactUs = new ContactUs();
		BeanUtils.copyProperties(dto, contactUs);
		contactUsService.insert(contactUs);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：联系我们修改
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
	@RequestMapping("data/contact/us/update")
	@ResponseBody
	public Result edit(@RequestBody ContactUsDto dto) {

		ContactUs contactUs = new ContactUs();
		BeanUtils.copyProperties(dto, contactUs);
		contactUsService.updateSelective(contactUs);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
