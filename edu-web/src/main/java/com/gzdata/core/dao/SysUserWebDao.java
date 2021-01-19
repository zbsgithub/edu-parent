package com.gzdata.core.dao;

import org.apache.ibatis.annotations.Select;

public interface SysUserWebDao extends SysUserDao {

	/**
	 * 
	 * 功能描述：保存
	 * 
	 * @return
	 * 
	 * @author 张兵帅
	 * 
	 * @since 2021年01月15日
	 * 
	 * @update:[变更日期YYYY-MM-DD][更改人姓名][变更描述]
	 */
	@Select({ "SELECT COUNT(*) FROM sys_user su ; " })
	public int findUserCount();

}
