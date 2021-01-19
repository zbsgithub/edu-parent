package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.SysUserPermissionDao;
import com.gzdata.core.model.SysUserPermission;

/**
 * 
 * 说明：处理对用户-权限表的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class SysUserPermissionService extends
		AbstractBaseService<SysUserPermission> {

	@Autowired
	private SysUserPermissionDao sysUserPermissionDao;

	@Override
	protected BaseDAOInterface<SysUserPermission> getDAO() {
		return sysUserPermissionDao;
	}

}