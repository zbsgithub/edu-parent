package com.gzdata.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gzdata.common.db.mybatis.dao.BaseDAOInterface;
import com.gzdata.common.db.mybatis.service.AbstractBaseService;
import com.gzdata.core.dao.UserDetailDao;
import com.gzdata.core.model.UserDetail;

/**
 * 
 * 说明：处理对用户详情的业务操作
 *             
 * @author 张兵帅
 * 
 * @version 1.0
 * 
 * @since 2021年01月15日
 */
@Service
public class UserDetailService extends AbstractBaseService<UserDetail> {

	@Autowired
	private UserDetailDao userDetailDao;

	@Override
	protected BaseDAOInterface<UserDetail> getDAO() {
		return userDetailDao;
	}

}