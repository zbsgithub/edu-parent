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
import com.gzdata.core.dto.FileEnquiryDto;
import com.gzdata.core.model.FileEnquiry;
import com.gzdata.core.qo.FileEnquiryQo;
import com.gzdata.core.service.FileEnquiryService;

/**
 * 
 * FileEnquiry信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
@RequestMapping("/api/")
@Api(tags="档案查询")
public class FileEnquiryDataBackController {

	@Autowired
	private FileEnquiryService fileEnquiryService;

	/**
	 * 
	 * 功能描述：档案查询列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/file/enquiry/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody FileEnquiryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				fileEnquiryService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：档案查询列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/file/enquiry/list")
	@ResponseBody
	public Result list(@RequestBody FileEnquiryQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				fileEnquiryService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：档案查询详情
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
	@RequestMapping("data/file/enquiry/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				fileEnquiryService.findById(id));
	}

	/**
	 * 
	 * 功能描述：档案查询批量删除
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
	@RequestMapping("data/file/enquiry/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		fileEnquiryService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：档案查询删除
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
	@RequestMapping("data/file/enquiry/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		fileEnquiryService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：档案查询添加
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
	@RequestMapping("data/file/enquiry/add")
	@ResponseBody
	public Result add(@RequestBody FileEnquiryDto dto) {

		FileEnquiry fileEnquiry = new FileEnquiry();
		BeanUtils.copyProperties(dto, fileEnquiry);
		fileEnquiryService.insert(fileEnquiry);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：档案查询修改
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
	@RequestMapping("data/file/enquiry/update")
	@ResponseBody
	public Result edit(@RequestBody FileEnquiryDto dto) {

		FileEnquiry fileEnquiry = new FileEnquiry();
		BeanUtils.copyProperties(dto, fileEnquiry);
		fileEnquiryService.updateSelective(fileEnquiry);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
