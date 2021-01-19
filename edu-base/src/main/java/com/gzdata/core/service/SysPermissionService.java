package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.SysPermissionDao;
import com.gzdata.core.model.SysPermission;

/**
 * 
 * 说明：处理对权限信息表的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class SysPermissionService extends AbstractBaseService<SysPermission> {

	@Autowired
	private SysPermissionDao sysPermissionDao;

	@Override
	protected BaseDAOInterface<SysPermission> getDAO() {
		return sysPermissionDao;
	}

}