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
import com.gzdata.core.dto.NamingRecordDto;
import com.gzdata.core.model.NamingRecord;
import com.gzdata.core.qo.NamingRecordQo;
import com.gzdata.core.service.NamingRecordService;

/**
 * 
 * NamingRecord信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class NamingRecordDataController {

	@Autowired
	private NamingRecordService namingRecordService;

	/**
	 * 
	 * 功能描述：冠名记录列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/naming/record/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody NamingRecordQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				namingRecordService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：冠名记录列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/naming/record/list")
	@ResponseBody
	public Result list(@RequestBody NamingRecordQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				namingRecordService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：冠名记录详情
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
	@RequestMapping("data/naming/record/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				namingRecordService.findById(id));
	}

	/**
	 * 
	 * 功能描述：冠名记录批量删除
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
	@RequestMapping("data/naming/record/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		namingRecordService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：冠名记录删除
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
	@RequestMapping("data/naming/record/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		namingRecordService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：冠名记录添加
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
	@RequestMapping("data/naming/record/add")
	@ResponseBody
	public Result add(@RequestBody NamingRecordDto dto) {

		NamingRecord namingRecord = new NamingRecord();
		BeanUtils.copyProperties(dto, namingRecord);
		namingRecordService.insert(namingRecord);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：冠名记录修改
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
	@RequestMapping("data/naming/record/update")
	@ResponseBody
	public Result edit(@RequestBody NamingRecordDto dto) {

		NamingRecord namingRecord = new NamingRecord();
		BeanUtils.copyProperties(dto, namingRecord);
		namingRecordService.updateSelective(namingRecord);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
