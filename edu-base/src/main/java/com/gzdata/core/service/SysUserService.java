                                                                                                                                
package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.SysUserDao;
import com.gzdata.core.model.SysUser;

/**
 * 
 * 说明：处理对用户信息表的业务操作
 * 
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class SysUserService extends AbstractBaseService<SysUser> {

	@Autowired
	private SysUserDao sysUserDao;
	
	 
	@Override
	protected BaseDAOInterface<SysUser> getDAO() {
		return sysUserDao;
	}

}