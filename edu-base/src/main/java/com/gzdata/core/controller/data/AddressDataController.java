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
import com.gzdata.core.dto.AddressDto;
import com.gzdata.core.model.Address;
import com.gzdata.core.qo.AddressQo;
import com.gzdata.core.service.AddressService;

/**
 * 
 * Address信息控制器（管理员）
 *
 * @author 张兵帅
 *
 * @version
 *
 * @since 2021年01月15日
 */
@Controller
public class AddressDataController {

	@Autowired
	private AddressService addressService;

	/**
	 * 
	 * 功能描述：地址信息列表--普通分页
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/address/pagelist")
	@ResponseBody
	public Result pagelist(@RequestBody AddressQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				addressService.findPaginationDataByCondition(qo));
	}

	/**
	 * 
	 * 功能描述：地址信息列表--通过条件查询
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@RequestMapping("data/address/list")
	@ResponseBody
	public Result list(@RequestBody AddressQo qo) {
		return Result.valueOf(Result.SUCCESS, "操作成功",
				addressService.findList(qo));
	}

	/**
	 * 
	 * 功能描述：地址信息详情
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
	@RequestMapping("data/address/detail")
	@ResponseBody
	public Result detail(@RequestParam String id) {

		return Result.valueOf(Result.SUCCESS, "操作成功",
				addressService.findById(id));
	}

	/**
	 * 
	 * 功能描述：地址信息批量删除
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
	@RequestMapping("data/address/batch_delete")
	@ResponseBody
	public Result batchDelete(@RequestParam Serializable... ids) {

		addressService.batchDelete(ids);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：地址信息删除
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
	@RequestMapping("data/address/delete")
	@ResponseBody
	public Result delete(@RequestParam String id) {

		addressService.deleteByID(id);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：地址信息添加
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
	@RequestMapping("data/address/add")
	@ResponseBody
	public Result add(@RequestBody AddressDto dto) {

		Address address = new Address();
		BeanUtils.copyProperties(dto, address);
		addressService.insert(address);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

	/**
	 * 
	 * 功能描述：地址信息修改
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
	@RequestMapping("data/address/update")
	@ResponseBody
	public Result edit(@RequestBody AddressDto dto) {

		Address address = new Address();
		BeanUtils.copyProperties(dto, address);
		addressService.updateSelective(address);

		return Result.valueOf(Result.SUCCESS, "操作成功");
	}

}
