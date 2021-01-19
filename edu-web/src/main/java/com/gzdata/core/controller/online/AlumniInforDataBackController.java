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
import com.gzdata.core.dto.AlumniInforDto;
import com.gzdata.core.model.AlumniInfor;
import com.gzdata.core.qo.AlumniInforQo;
import com.gzdata.core.service.AlumniInforService;

/**
 * 
 * AlumniInfor信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Api("校友信息控制器")
@RequestMapping("/api/")
@Controller
public class AlumniInforDataBackController {

	@Autowired
	private AlumniInforService alumniInforService;

	/**
	 * 
	 * 功能描述：校友信息列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/infor/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody AlumniInforQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniInforService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：校友信息列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/alumni/infor/list")
	@ResponseBody
	public Result list(@RequestBody AlumniInforQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniInforService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：校友信息详情
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
	@RequestMapping("data/alumni/infor/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				alumniInforService.findById(id));
	}

	/**
	 * 
	 * 功能描述：校友信息批量删除
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
	@RequestMapping("data/alumni/infor/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		alumniInforService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友信息删除
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
	@RequestMapping("data/alumni/infor/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		alumniInforService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友信息添加
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
	@RequestMapping("data/alumni/infor/add")
	@ResponseBody
	public Result add(@RequestBody AlumniInforDto dto) {

		AlumniInfor alumniInfor = new AlumniInfor();
		BeanUtils.copyProperties(dto, alumniInfor);
		alumniInforService.insert(alumniInfor);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：校友信息修改
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
	@RequestMapping("data/alumni/infor/update")
	@ResponseBody
	public Result edit(@RequestBody AlumniInforDto dto) {

		AlumniInfor alumniInfor = new AlumniInfor();
		BeanUtils.copyProperties(dto, alumniInfor);
		alumniInforService.updateSelective(alumniInfor);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
